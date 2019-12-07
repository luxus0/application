package lukasz.exercise_app.Error_Handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CorsRegistrationException {

    @ExceptionHandler
    public void ExceptionHandler(String message, Throwable t)
    {



        System.out.println(message + t.getMessage());
        if(message.isEmpty())
        {
            Logger log = LoggerFactory.getLogger(this.getClass());
            log.error("MESSAGE IS EMPTY");
        }
    }
}
