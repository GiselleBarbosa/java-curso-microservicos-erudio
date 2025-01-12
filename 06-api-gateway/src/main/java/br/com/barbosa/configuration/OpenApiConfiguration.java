package br.com.barbosa.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionRouteLocator;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class OpenApiConfiguration {

    public List<GroupedOpenApi> apis(
            SwaggerUiConfigParameters config,
            RouteDefinitionRouteLocator locator) {

        var definitions = locator.getRoutes().collectList().block();

        definitions.stream().filter(routeDefinition ->
                routeDefinition.getId()
                        .matches(".*-service")).forEach(routeDefinition -> {
            String name = routeDefinition.getId();

            config.addGroup(name);

            GroupedOpenApi.builder()
                    .pathsToMatch("/" + name + "/**")
                    .group(name)
                    .build();
        });

        return new ArrayList<>();
    }
}
