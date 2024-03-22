package demo2.demo2.entity;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;


@Entity
@Table(name = "users")
public class users {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name="users_roles",
        joinColumns =@JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<roles> roles=new HashSet<>();

    public users() {
		super();
	}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole(roles role){
        return role.getName();
    }

    public Set<roles> getRoles(){
        return roles;
    }
    
    public void addRoles(roles role){
        this.roles.add(role);        
    }

}
