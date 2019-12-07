package lukasz.exercise_app.Config.Postgresql;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:postgresql.properties")
public class Config_postgresql {

}
