package demo2.demo2.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import demo2.demo2.entity.users;

import java.util.Collection;
import java.util.List;



public interface UserRepository extends JpaRepository<users,Integer>{
    

    @Query("Select case when count(u.email)> 0 then true else false end from users u where lower(u.email) like lower(:email)")
    public boolean existsByEmail(String email);

    @Query("SELECT u FROM users u WHERE u.email=:email")
    public users getUserbyemail(String email);

    @Query("SELECT u FROM users u WHERE u.email=:searchvalue OR u.name=:searchvalue")
    public List<users> getUserbyemailorname(String searchvalue);

    @Query("SELECT u from users u INNER JOIN u.roles r WHERE r.name=:role_name")
    List<users> getRoleUsers(String role_name);

        
}
