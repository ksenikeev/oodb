package ru.icmit.oodb.lab19.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.icmit.oodb.lab19.filter.SecurityFilter;

@EnableWebMvc
@Configuration
@ComponentScan({"ru.icmit.oodb.lab19"})
public class SpringWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
               .addResourceLocations("classpath:/resources/");
    }

    @Bean
    public FilterRegistrationBean<SecurityFilter> securityFilter(){
        FilterRegistrationBean<SecurityFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new SecurityFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }

}