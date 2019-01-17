package com.song.order.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPagesConfig {

    @Bean    //此注解一定记住要加上，别忘记
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> containerCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {

            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                ErrorPage errorPage400 = new ErrorPage(HttpStatus.BAD_REQUEST, "/error.html");
                ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error.html");
                ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error.html");
                factory.addErrorPages(errorPage400,errorPage404,errorPage500);
            }
        };
    }
}
