package lukasz.exercise_app.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "db/changelog/create_exercise_table.xml")
public class Exercise {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "time")
    private int time;

    @NotNull
    @Column(name = "wage")
    private int wage;

    @NotNull
    @Column(name = "level")
    private String level;

    @NotNull
    @Column(name = "destination")
    private String destination;

    @NotNull
    @Column(name = "body_part")
    private String bodyPart;

    @NotNull
    @Column(name = "category")
    private String category;

    @NotNull
    @Column(name = "types")
    private String types;

    @NotNull
    @Column(name = "instructor")
    private String instructor;


    public Exercise(){}
    public Exercise(String name, int time, int wage, String level, String destination, String bodyPart, String category, String types, String instructor) {
        this.name = name;
        this.time = time;
        this.wage = wage;
        this.level = level;
        this.destination = destination;
        this.bodyPart = bodyPart;
        this.category = category;
        this.types = types;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTypes() {
        return types;
    }

    public void setType(String types) {
        this.types = types;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }



}
