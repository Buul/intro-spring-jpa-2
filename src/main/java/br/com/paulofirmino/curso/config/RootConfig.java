package br.com.paulofirmino.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("br.com.paulofirmino.curso")
@EnableWebMvc
public class RootConfig {

}
