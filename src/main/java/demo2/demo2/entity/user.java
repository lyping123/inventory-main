package demo2.demo2.entity;

import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;



@Entity
@Table(name="users")
public class user {
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
    private Set<role> roles=new HashSet<>();


    public user() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }


    public user orElse(Object object) {
		return null;
	}

    public Set<role> getRoles(){
        return roles;
    }
    
    public void addRoles(role role){
        this.roles.add(role);
        
    }

}
