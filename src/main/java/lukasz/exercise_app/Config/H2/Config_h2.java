package lukasz.exercise_app.Config.H2;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


//@Configuration
//@PropertySource("classpath:Registration.sql")
public class Config_h2 {


   /* public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:database_Exercise;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSourceBuilder.username("lukasz");
        dataSourceBuilder.password("lukasz1986!@#");
        return dataSourceBuilder.build();
    }*/


}
