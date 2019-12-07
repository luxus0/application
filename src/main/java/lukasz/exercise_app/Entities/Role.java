package lukasz.exercise_app.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "role_table")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id_role")
    private Integer id;

    @NotNull
    @Column(name = "name_role")
    private String name;

    @NotNull
    @ManyToMany
    @JoinTable(name = "user_table",joinColumns = @JoinColumn(name= "username"),inverseJoinColumns = @JoinColumn(name = "password"))
    private Collection<User> users;

    @NotNull
    @ManyToMany
    @JoinTable(name = "privilege_table", joinColumns = @JoinColumn(name = "id_privilege"), inverseJoinColumns = @JoinColumn(name = "name_privilege"))
    private Collection<Privilege> privileges;

    public Role()
    { }

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

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }
}
