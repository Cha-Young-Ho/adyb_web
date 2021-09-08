package cyh.adyb.config;

import cyh.adyb.web.interceptor.ViewControlInterceptor;
import cyh.adyb.web.interceptor.SessionCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ViewControlInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error", "/contact/email");


        registry.addInterceptor(new SessionCheckInterceptor())
                .order(2)
                .addPathPatterns("/modify", "/board_write", "/mypage", "/reply_write", "/reply_delete")
                .excludePathPatterns("/css/**", "/*.ico", "/error","/login");

    }

};