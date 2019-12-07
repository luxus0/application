package lukasz.exercise_app.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "registration_table")
public class Registration {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "age")
    private int age;

    @Column(name = "pesel")
    private BigInteger pesel;

    @NotNull
    @Column(name = "birth")
    private LocalDateTime birth;

    @NotNull
    @Column(name = "adress")
    private String adress;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "mobile")
    private int mobile;


    public Registration() {
    }

    public Registration(String name, String surname, int age, BigInteger pesel, LocalDateTime birth, String adress, String email, int mobile) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.pesel = pesel;
        this.birth = birth;
        this.adress = adress;
        this.email = email;
        this.mobile = mobile;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public @NotNull BigInteger getPesel() {
        return pesel;
    }

    public void setPesel(BigInteger pesel) {
        this.pesel = pesel;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", pesel=" + pesel +
                ", birth=" + birth +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                '}';
    }


}
