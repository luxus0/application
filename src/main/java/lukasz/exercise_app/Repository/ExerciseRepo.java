package lukasz.exercise_app.Repository;

import lukasz.exercise_app.Entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepo extends JpaRepository<Exercise,Integer> {
}
