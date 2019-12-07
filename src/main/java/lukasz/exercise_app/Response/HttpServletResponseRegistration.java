package lukasz.exercise_app.Response;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HttpServletResponseRegistration {

    private HttpServletResponse response;

    public HttpServletResponse reponseRegistration() {
        Map<String, HttpStatus> map = new HashMap<>();
        map.put(Arrays.toString(HttpStatus.values()), HttpStatus.OK);

        map.forEach((a,b)-> System.out.println(a + b));

        return  response;
    }
}
