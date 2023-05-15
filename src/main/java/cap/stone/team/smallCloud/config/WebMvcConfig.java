package cap.stone.team.smallCloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${file.path}")
    private String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry handlerRegistry) {
        WebMvcConfigurer.super.addResourceHandlers(handlerRegistry);

        handlerRegistry.addResourceHandler("/images/**")
                .addResourceLocations("file:///" + uploadPath)
                .setCachePeriod(60 * 10 * 6)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }
}
