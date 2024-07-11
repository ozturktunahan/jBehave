package org.example;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.StepMonitor;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.core.ConfigurableEmbedder;
import org.junit.Test;

import java.util.Collections;

public class StoryRunner extends ConfigurableEmbedder {
    public Embedder embedder;

    @Override
    @Test
    public void run() {
        embedder = configuredEmbedder();
        embedder.useConfiguration(configuration());
        embedder.useStepsFactory(stepsFactory());
        System.out.println("Run Method");

        String storyPath = "myFirstStory.story";
        embedder.runStoriesAsPaths(Collections.singletonList(storyPath));
    }

    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withDefaultFormats()
                        .withFormats(Format.CONSOLE, Format.TXT))
                .useStepMonitor(stepMonitor());
    }

    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new BookMyFlight());
    }

    public StepMonitor stepMonitor() {
        return new SilentStepMonitor();
    }
}
