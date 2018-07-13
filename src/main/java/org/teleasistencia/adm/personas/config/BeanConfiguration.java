package org.teleasistencia.adm.personas.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.teleasistencia.adm.personas.modelo.Persona;
import org.teleasistencia.adm.personas.vo.consultas.PersonaVO;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper = new ModelMapper();

        mapper.addMappings(new PropertyMap<Persona, PersonaVO>() {

            @Override
            protected void configure() {
                map().setIdGenero(source.getIdGenero());
            }
        });

        return mapper;
    }

    @Bean
    public ValidatorFactory validatorFactory() {
        return Validation.buildDefaultValidatorFactory();
    }
}
