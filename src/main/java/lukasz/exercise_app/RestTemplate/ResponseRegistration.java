package lukasz.exercise_app.RestTemplate;


import lukasz.exercise_app.Entities.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ResponseRegistration {


    private Logger log = LoggerFactory.getLogger(this.getClass());

    public void getAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.exchange("/registration", HttpMethod.GET,requestEntity,this.getClass());
        if(responseEntity.getStatusCode().value() != 200)
        {
            try
            {
                log = LoggerFactory.getLogger(this.getClass());
                log.error("STATUS CODE" +responseEntity.getStatusCodeValue());
            }
            catch(HttpStatusCodeException e)
            {
                e.getLocalizedMessage();
            }
        }
    }


    public void getById()
    {
        HttpHeaders headers = new HttpHeaders();
        List<Locale.LanguageRange> languageList = new ArrayList<>();
        languageList.add(new Locale.LanguageRange(Locale.CANADA.getCountry()));
        languageList.add(new Locale.LanguageRange(Arrays.toString(Locale.getISOCountries())));
        languageList.add(new Locale.LanguageRange(Locale.ITALY.getDisplayLanguage()));
        languageList.add(new Locale.LanguageRange(Locale.getDefault().getCountry()));
        languageList.add(new Locale.LanguageRange(Locale.KOREA.getDisplayName()));

        headers.setAcceptLanguage(languageList);
        headers.set(HttpHeaders.ACCESS_CONTROL_MAX_AGE,"45");
        headers.setContentLength(100);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.exchange("/registration/{id}",HttpMethod.GET,entity,this.getClass());

       if(response.getStatusCodeValue() == 200)
       {
           log.info("STATUS CODE: "+response.getBody());
       }
    }

    public void addRegistration()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        RestTemplate template = new RestTemplate();
       ResponseEntity<Registration> response = template.exchange("/registration",HttpMethod.POST,entity,Registration.class);

       if(response.getStatusCodeValue() != 200)
       {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
       else
       {
           Logger log = LoggerFactory.getLogger(this.getClass());
           log.info(HttpStatus.OK.toString());
       }

    }

    public void deleteRegistration()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        RestTemplate template = new RestTemplate();
        template.exchange("/registration/{id}",HttpMethod.DELETE,entity,this.getClass());
    }

    public static void main(String args[])
    {

    }
}
