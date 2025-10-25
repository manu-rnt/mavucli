package com.mavu.generator.service;

import com.mavu.generator.model.*;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.parser.OpenAPIV3Parser;

import java.util.*;

public class OpenApiParserService {

    public Project parse(String filePath) {
        OpenAPI openAPI = new OpenAPIV3Parser().read(filePath);
        if (openAPI == null) {
            throw new RuntimeException("Invalid OpenAPI YAML file");
        }

        Project project = new Project();
        project.setName(sanitizeName(openAPI.getInfo().getTitle()));
        project.setDescription(openAPI.getInfo().getDescription());
        project.setEntities(new ArrayList<>());
        project.setEndpoints(new ArrayList<>());

        // Schemas -> Entities
        if (openAPI.getComponents() != null && openAPI.getComponents().getSchemas() != null) {
            openAPI.getComponents().getSchemas().forEach((entityName, schema) -> {
                Entity entity = new Entity();
                entity.setName(entityName);
                entity.setFields(new ArrayList<>());

                Map<String, Schema<?>> properties = schema.getProperties();
                if (properties != null) {
                    properties.forEach((propName, propSchema) -> {
                        Schema<?> fieldSchema = (Schema<?>) propSchema;
                        Field field = new Field();
                        field.setName(propName);
                        field.setType(fieldSchema.getType());
                        entity.getFields().add(field);
                    });
                }

                project.getEntities().add(entity);
            });
        }

        // Paths -> Endpoints
        if (openAPI.getPaths() != null) {
            openAPI.getPaths().forEach((path, pathItem) ->
                    pathItem.readOperationsMap().forEach((method, op) -> {
                        Endpoint endpoint = new Endpoint();
                        endpoint.setMethod(method.toString().toUpperCase());
                        endpoint.setPath(path);
                        endpoint.setAction(
                                op.getOperationId() != null
                                        ? op.getOperationId()
                                        : method + " " + path);
                        project.getEndpoints().add(endpoint);
                    })
            );
        }

        return project;
    }

    private String sanitizeName(String title) {
        if (title == null) return "untitled";
        return title.toLowerCase().replaceAll("\\s+", "-");
    }
}
