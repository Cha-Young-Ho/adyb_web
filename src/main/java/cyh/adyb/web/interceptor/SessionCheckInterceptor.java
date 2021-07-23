package cyh.adyb.web.interceptor;

import cyh.adyb.web.session.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class SessionCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {

        if(request.getSession().getAttribute(SessionConst.LOGIN_USER) == null){
            response.sendRedirect("/login");
            return false;
        }

        return true;

    };
}
