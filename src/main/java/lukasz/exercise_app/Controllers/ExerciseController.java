package lukasz.exercise_app.Controllers;

import lukasz.exercise_app.Entities.Exercise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ExerciseController {

    private List<Exercise> exerciseList;

    public ExerciseController() {
        exerciseList = new ArrayList<>();
        exerciseList.add(new Exercise("aa",12,23,"One","Fit","shoulders","A","reduce","Meri Dacia"));
        exerciseList.add(new Exercise("bb",45,65,"Two","Get-Fit","biceps","B","reduce lower","Micro Kovac"));
    }
    @GetMapping("/exercise")
    public List<Exercise> getAll()
    {
        return exerciseList;
    }

    @GetMapping("/exercise/{id}")
    public Exercise getById(@PathVariable("id") Integer id)
    {
        return exerciseList.get(id);
    }

    @PostMapping("/exercise")
    public boolean add(@RequestBody Exercise exercise)
    {
        return exerciseList.add(exercise);
    }

    @DeleteMapping("/exercise")
    public boolean delete(@RequestParam("id") Integer id)
    {
        Optional<Exercise> find = exerciseList.stream().filter(p -> p.getId() == id).findFirst();
        return find.map(exercise -> exerciseList.remove(exercise)).orElse(false);
    }

    @GetMapping("/login?error")
    public ResponseEntity LoginError()
    {
        return  ResponseEntity.notFound().build();
    }

}
