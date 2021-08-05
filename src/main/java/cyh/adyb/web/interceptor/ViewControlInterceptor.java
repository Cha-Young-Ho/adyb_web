package cyh.adyb.web.interceptor;

import cyh.adyb.domain.User;
import cyh.adyb.web.session.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class ViewControlInterceptor implements HandlerInterceptor {


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        User loginUser = (User) request.getSession().getAttribute(SessionConst.LOGIN_USER);

        log.info("login User = {}", (User)request.getSession().getAttribute(SessionConst.LOGIN_USER));
        if(loginUser == null){
            log.info("여기 통과");
            loginUser = new User();
        }
        modelAndView.addObject("user",loginUser);
    }
}