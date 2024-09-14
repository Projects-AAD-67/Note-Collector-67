package lk.ijse.gdse.aad67.notecollecter67.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse.aad67.notecollecter67")
@EnableWebMvc
@MultipartConfig
public class WebAppConfig {
}
