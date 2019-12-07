package lukasz.exercise_app.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "privilege_table")
public class Privilege {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToMany
    @JoinTable(name = "role_table", joinColumns = @JoinColumn(name = "name_role"))
    @Column(name = "roles")
    private Collection<Role> roles;

    @NotNull
    @ManyToMany
    @JoinTable(name = "user_table", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "password"))
    @Column(name = "users")
    private Collection<User> users;



}
