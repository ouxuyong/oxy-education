package com.oxygen.education.filter;

import com.oxygen.education.context.OxyContext;
import com.oxygen.education.context.OxygenContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * 自定义request filter
 *
 * @author oxygen
 * @Description 每次请求会将header中的值放到本地线程中
 */
@Slf4j
public class CustomizeHeaderFilter extends OncePerRequestFilter {
    private static final String OXY_USER_ID = "oxy-user-id";
    private static final String OXY_COMPANY_ID = "oxy-company-id";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            OxygenContextHolder.clearOxyContext();

            String userId =  httpServletRequest.getHeader(OXY_USER_ID);
            String companyId = httpServletRequest.getHeader(OXY_COMPANY_ID);

            OxyContext context = OxygenContextHolder.getContext();
            context.setUserId(Optional.ofNullable(userId).map(e->Long.valueOf(userId)).orElse(null) );
            context.setCompanyId(Optional.ofNullable(userId).map(e->Long.valueOf(companyId)).orElse(null));

        } catch (Exception e) {
            log.error("填充上下文异常：",e);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
