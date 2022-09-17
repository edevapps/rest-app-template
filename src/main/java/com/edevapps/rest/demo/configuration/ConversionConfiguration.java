package com.edevapps.rest.demo.configuration;

import com.edevapps.rest.demo.rest.converter.DtoToMessage;
import com.edevapps.rest.demo.rest.converter.MessageToDto;
import com.edevapps.rest.demo.data.persistence.converter.EntityToMessage;
import com.edevapps.rest.demo.data.persistence.converter.MessageToEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfiguration {

    @Bean(name = {"conversionService", "conversion", "beanConversion"})
    public ConversionServiceFactoryBean conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter<?, ?>> converters = new HashSet<>();
        converters.add(new EntityToMessage());
        converters.add(new MessageToEntity());
        converters.add(new DtoToMessage());
        converters.add(new MessageToDto());
        bean.setConverters(converters);
        return bean;
    }
}
