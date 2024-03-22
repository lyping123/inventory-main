package demo2.demo2.servise;

import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.ArrayList;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import demo2.demo2.entity.roles;
import demo2.demo2.entity.users;


public class MyUserDetails implements UserDetails{
    private users user;

    public MyUserDetails(users user){
        super();
        this.user=user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
         Set<roles> roles = user.getRoles();
         List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         for(roles role :roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
         }
        
         return authorities;
         
    }
    

    @Override
    public String getPassword() {
        return user.getPassword();
    }

 
    @Override
    public String getUsername() {
		return user.getName();
	}

	
	public String getEmail() {
		return user.getEmail();
	}

 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
}
