package com.example.Supabase2.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI CustomOpenAPI(){

        return new OpenAPI()
                .info(new Info()
                        .title("Supabase2")
                        .version("1.0")
                        .description("ejercicio papeleria")
                        .contact(new Contact()
                                .name("Soorte API")
                                .email("javier.bravo50@gamail.com")));
    }

}
