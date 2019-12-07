package lukasz.exercise_app.CORS;

import lukasz.exercise_app.Error_Handling.CorsRegistrationException;
import lukasz.exercise_app.Entities.Registration;
import lukasz.exercise_app.Request.HttpServletRequestRegistration;
import lukasz.exercise_app.Response.HttpServletResponseRegistration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsProcessor;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;
import java.nio.charset.Charset;

@CrossOrigin
public class CorsRegistry {

    private Registration reg;
    private HttpServletRequestRegistration servlet;
    private HttpServletResponseRegistration response;
    private CorsProcessor process;

    public void addCorsMapping(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        registry.addMapping("/registration/{id}")
                .allowedOrigins("http://localhost:8080")
                .allowCredentials(true)
                .allowedHeaders(HttpHeaders.ACCEPT_LANGUAGE, HttpHeaders.ACCEPT, "utf-8", Charset.defaultCharset().toString())
                .maxAge(70);
    }

    public void registrationFilterCors(CorsFilter filter,Environment env,CorsRegistrationException ex) throws IOException {
        Environment cors = (Environment) env.getProperty("BATEK ENVIRONMENT",Registration.class);
        if (cors != null) {
            filter.setEnvironment(cors);
        }
        else
        {
            ex.ExceptionHandler("ERROR ENVIRONMENT SERVER",new HttpServerErrorException(HttpStatus.OK));
        }



        filter.setCorsProcessor(CorsProcessorRegistration(CorsProcessorRegistration(this.process)));

    }

    private CorsProcessor CorsProcessorRegistration(CorsProcessor process) throws IOException {
        process.processRequest(CorsConfigurationRegister(),servlet.request(),response.reponseRegistration());
    return process;
    }

    public CorsConfiguration CorsConfigurationRegister()
    {
        CorsConfiguration config = new CorsConfiguration();
        config.setMaxAge(70L);
        config.addAllowedHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS);
        config.addAllowedHeader(HttpHeaders.ACCEPT_CHARSET);
        config.addAllowedHeader(HttpHeaders.CONTENT_LOCATION);
        config.setAllowCredentials(true);


        return config;
    }
}
