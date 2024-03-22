package demo2.demo2.servise;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import demo2.demo2.entity.user;
import demo2.demo2.entity.users;
import demo2.demo2.repository.*;

@Service
public class UserServise {
	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private RoleRespository roleRespository;

	public users findByEmail(String email){
		return UserRepository.getUserbyemail(email);
	}

	public users registerUser(users user){
		users User =new users();

		BCryptPasswordEncoder password=new BCryptPasswordEncoder();
		String saltpassword=password.encode(user.getPassword());
		User.setName(user.getName());
		User.setEmail(user.getEmail());
		User.setPassword(saltpassword);
		User.addRoles(roleRespository.findById(2).get());

		return UserRepository.save(User);
	}

	public List<users> getUsers(){
		return UserRepository.getRoleUsers("user");
	}

	public List<users> getUserbyemailorname(String searchvalue){
		return UserRepository.getUserbyemailorname(searchvalue);
	}

	public boolean verifyEmail(String email){
		return UserRepository.existsByEmail(email);
	}

	public void deleteUsers(Integer id){
		Optional<users> optionalUser=UserRepository.findById(id);
		if(optionalUser.isPresent()){
			users User=optionalUser.get();
			User.getRoles().clear();
			UserRepository.delete(User);
		}
	}



	
}
