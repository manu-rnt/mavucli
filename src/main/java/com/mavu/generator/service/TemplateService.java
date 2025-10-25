package com.mavu.generator.service;

import com.mavu.generator.model.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TemplateService {

    private static final String TEMPLATE_PATH = "src/main/resources/templates/";

    public void generateProject(Project project) throws IOException {
        String baseDir = "output/" + project.getName() + "/src/main/java/com/mavu/" + project.getName();
        Files.createDirectories(Paths.get(baseDir + "/controller"));
        Files.createDirectories(Paths.get(baseDir + "/service"));
        Files.createDirectories(Paths.get(baseDir + "/dto"));
        Files.createDirectories(Paths.get(baseDir + "/listener"));

        for (Entity entity : project.getEntities()) {
            generate("DTO.java.tpl.java.tpl", baseDir + "/dto/" + entity.getName() + "DTO.java.tpl.java", project, entity, null);
            generate("Service.java.tpl.java.tpl", baseDir + "/service/" + entity.getName() + "Service.java.tpl.java", project, entity, null);
            generate("Listener.java.tpl.java.tpl", baseDir + "/listener/" + entity.getName() + "Listener.java.tpl.java", project, entity, null);
        }

        generate("Controller.java.tpl.java.tpl", baseDir + "/controller/ApiController.java", project, null, project.getEndpoints());
    }

    private void generate(String template, String target, Project project, Entity entity, List<Endpoint> endpoints) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(TEMPLATE_PATH + template)));

        content = content
                .replace("{{projectName}}", project.getName())
                .replace("{{entityName}}", entity != null ? entity.getName() : "")
                .replace("{{entityLower}}", entity != null ? entity.getName().toLowerCase() : "");

        if (entity != null && entity.getFields() != null) {
            StringBuilder fields = new StringBuilder();
            for (Field f : entity.getFields()) {
                fields.append("    private ").append(f.getType()).append(" ").append(f.getName()).append(";\n");
            }
            content = content.replace("{{fields}}", fields.toString());
        }

        if (endpoints != null) {
            StringBuilder methods = new StringBuilder();
            for (Endpoint e : endpoints) {
                methods.append("    @")
                        .append(e.getMethod().substring(0, 1).toUpperCase())
                        .append(e.getMethod().substring(1).toLowerCase())
                        .append("Mapping(\"").append(e.getPath()).append("\")\n")
                        .append("    public void ").append(e.getAction()).append("() {\n")
                        .append("        // TODO implement ").append(e.getAction()).append("\n")
                        .append("    }\n\n");
            }
            content = content.replace("{{methods}}", methods.toString());
        } else {
            content = content.replace("{{methods}}", "");
        }

        Files.writeString(Paths.get(target), content);
    }
}
