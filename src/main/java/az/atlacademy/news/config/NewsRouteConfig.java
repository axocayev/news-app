package az.atlacademy.news.config;

import az.atlacademy.news.service.impl.NewsServiceImpl;
import org.hibernate.service.spi.ServiceException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class NewsRouteConfig {

    @Bean
    public RouterFunction<ServerResponse> newsRoute(NewsServiceImpl newsService) {
        return route(GET("/news"),
                req -> {
                    try {
                        return ServerResponse.ok().body(newsService.getAll());
                    } catch (ServiceException e) {
                        return exceptionHandle(e);
                    }

                });
    }

    private ServerResponse exceptionHandle(ServiceException e) {
        return ServerResponse.status(500).body(e.getMessage());
    }
}
