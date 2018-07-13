package org.teleasistencia.adm.personas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("POST", "GET", "PUT", "DELETE");
//                .allowedHeaders("Content-Type")
//                .exposedHeaders("header-1", "header-2")
//                .allowCredentials(false)
//                .maxAge(6000);
    }


}
