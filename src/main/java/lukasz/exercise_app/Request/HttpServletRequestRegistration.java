package lukasz.exercise_app.Request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.web.bind.MissingRequestCookieException;

import javax.annotation.Resource;
import javax.naming.AuthenticationException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Parameter;
import java.security.Principal;
import java.time.Duration;
import java.util.*;

public class HttpServletRequestRegistration {

private @ NotNull HttpServletRequest request;
private Registration registration;
private HttpOutputMessage output;
private HttpMessageConverter<Registration> converter;
private Parameter parameter;


        public String authRegistration(Resource.AuthenticationType type,Throwable e) throws Exception {
            if (type.name().isEmpty()) {
                throw new AuthenticationException("AUTh exc" + e.getMessage());

            }

            else if(converter.canRead(this.getClass(), MediaType.APPLICATION_JSON))
            {
                converter.write(registration, MediaType.APPLICATION_JSON, output);
            }


            String auth = HttpServletRequest.BASIC_AUTH;
            Logger log = LoggerFactory.getLogger(this.getClass());
            log.info(auth);

            return "AUTHENTICATION FAILED";
        }



    public Cookie getCookies() throws MissingRequestCookieException {
        Session.Cookie cookie = new Session.Cookie();
        cookie.setSecure(true);
        cookie.setComment("COOKIE FOR DOMAIN REGISTRATION");
        cookie.setDomain("Registry");
        cookie.setMaxAge(Duration.ofSeconds(50));
        cookie.setPath("/registration");

        if(cookie.getPath() == null)
        {

            throw new MissingRequestCookieException("MISSING PARAMETER COOKIE", MethodParameter.forParameter(parameter));
        }

        return new Cookie("COOKIE1","REGISTRY");
    }

public HttpServletRequest request()
{
    request.getRequestURL().append("/registration");

    if(HttpServletResponse.SC_OK == 200)
    {
        Assert.isTrue(request.isSecure());
    }

    return request;

}



}
