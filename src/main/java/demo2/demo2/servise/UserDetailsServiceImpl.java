package demo2.demo2.servise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

import demo2.demo2.entity.users;
import demo2.demo2.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    

    @Override
    public UserDetails loadUserByUsername(String email)
                throws UsernameNotFoundException{
            users user=userRepository.getUserbyemail(email);
            
            if (user==null) {
                throw new UsernameNotFoundException("Could not found user");
            }
            return new MyUserDetails(user);
        }
       
    }

