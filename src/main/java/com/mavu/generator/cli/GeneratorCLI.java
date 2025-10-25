package com.mavu.generator.cli;

import com.mavu.generator.model.Project;
import com.mavu.generator.service.OpenApiParserService;
import com.mavu.generator.service.TemplateService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;

@Command(
        name = "mavucli",
        mixinStandardHelpOptions = true,
        description = "Generates DTOs, Services, Controllers and Listeners from an OpenAPI YAML file."
)
public class GeneratorCLI implements Runnable {

    @Option(names = {"-f", "--file"}, description = "Path to OpenAPI YAML file", required = true)
    private File openApiFile;

    @Override
    public void run() {
        try {
            OpenApiParserService parser = new OpenApiParserService();
            Project project = parser.parse(openApiFile.getAbsolutePath());

            TemplateService generator = new TemplateService();
            generator.generateProject(project);

            System.out.println("✅ Successfully generated project: " + project.getName());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}