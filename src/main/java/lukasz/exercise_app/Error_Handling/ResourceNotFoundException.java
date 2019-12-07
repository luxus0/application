package lukasz.exercise_app.Error_Handling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ResourceNotFoundException extends Throwable {

    Logger log = LoggerFactory.getLogger(this.getClass());


    public ResourceNotFoundException(String message,Integer id)
    {
        log.error(message,id);

    }
}
