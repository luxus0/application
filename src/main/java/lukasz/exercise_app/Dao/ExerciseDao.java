package lukasz.exercise_app.Dao;

import lukasz.exercise_app.Repository.ExerciseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ExerciseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ExerciseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Map<String, Object>> showById(int id) {
        String sql = "SELECT * FROM Exercise WHERE id LIKE ?";
        return  jdbcTemplate.queryForList(sql,new Object[]{id});
    }

    public List<Map<String, Object>> showByName(String name)
    {
        String sql = "SELECT * FROM Exercise WHERE name LIKE ?";
        return jdbcTemplate.queryForList(sql,new Object[]{name});
    }

    public List<Map<String, Object>> showByTime(int time)
    {
        String sql = "SELECT * FROM Exercise WHERE time LIKE ?";
        return jdbcTemplate.queryForList(sql,new Object[]{time});
    }

    public List<Map<String, Object>> showByWage(int wage)
    {
        String sql = "SELECT * FROM Exercise WHERE wage LIKE ?";
        return jdbcTemplate.queryForList(sql,new Object[]{wage});
    }

    public List<Map<String, Object>> showByLevel(String level)
    {
        String sql = "SELECT * FROM Exercise WHERE level LIKE ?";
        return jdbcTemplate.queryForList(sql,new Object[]{level});
    }

    public List<Map<String, Object>> showByDestination(String destination)
    {
        String sql = "SELECT * FROM Exercise WHERE destination LIKE ?";
        return jdbcTemplate.queryForList(sql,new Object[]{destination});
    }

    public List<Map<String, Object>> showByBodyPart(String bodyPart)
    {
        String sql = "SELECT * FROM Exercise WHERE bodyPart LIKE ?";
        return jdbcTemplate.queryForList(sql,new Object[]{bodyPart});
    }

    public List<Map<String, Object>> showByCategories(String categories)
    {
        String sql = "SELECT * FROM Exercise WHERE categories LIKE ?";
        return jdbcTemplate.queryForList(sql,new Object[]{categories});
    }

    public List<Map<String, Object>> showByTypes(String types)
    {
        String sql = "SELECT * FROM Exercise WHERE types LIKE ?";
        return jdbcTemplate.queryForList(sql,new Object[]{types});
    }

    public List<Map<String, Object>> showByInstructors(String instructors)
    {
        String sql = "SELECT * FROM Exercise WHERE time LIKE ?";
        return jdbcTemplate.queryForList(sql,new Object[]{instructors});
    }





}
