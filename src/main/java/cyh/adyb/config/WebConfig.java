package cyh.adyb.config;

import cyh.adyb.web.interceptor.ModifyInterceptor;
import cyh.adyb.web.interceptor.SessionCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ModifyInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error","/login");


        registry.addInterceptor(new SessionCheckInterceptor())
                .order(2)
                .addPathPatterns("/modify", "/board_write")
                .excludePathPatterns("/css/**", "/*.ico", "/error","/login");

    }

};