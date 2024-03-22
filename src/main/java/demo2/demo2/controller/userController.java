package demo2.demo2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import demo2.demo2.entity.users;
import demo2.demo2.servise.UserServise;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;





@Controller
public class userController {
    @Autowired
    private  UserServise UserServise;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute(name = "user") users user,@RequestParam("confirmPassword") String confirmpassword,Model model,HttpSession session){
        try{
            if(UserServise.verifyEmail(user.getEmail())){
                model.addAttribute("error", "Email already been register, please try a new email");
                return "register";
            }else{
                if(user.getPassword().matches(confirmpassword)){
                    UserServise.registerUser(user);
                    
                    session.setAttribute("successMessage", "register Success, now you can start sign in");
                }else{
                    model.addAttribute("error", "password and confirm is not matching");
                    return "register";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "redirect:/login";
    }

    @GetMapping("/deleteaccount/{id}")
    public String deleteUser(@PathVariable Integer id){
        UserServise.deleteUsers(id);
        return "redirect:/users";
    }



    // @PostMapping("/login")
    // public String login(@RequestParam String email,@RequestParam String password,Model model,HttpSession session) {
    //     try{
    //         if(UserServise.verifyEmail(email)){
    //             model.addAttribute("error", "email is not register yet");
    //             return "login";
    //         }else{
    //             if(UserServise.authenticateUser(email, password)){
    //                 // user Userinformation =UserServise.findByEmail(email);
    //                 // session.setAttribute("loggedInUser",Userinformation);
    //                 // session.setAttribute("successMessage", "Login success, welcome  "+Userinformation.getName());
    //                 //session.addAttribute("successMessage","Login success, welcome");
    //                 return "redirect:/";
                    
    //             }else{
    //                 model.addAttribute("error", "invalid email or password");
    //                 return "login";
    //             }
    //         }
    //     }catch (Exception e){
    //         e.printStackTrace();
    //         return "error";
    //     }   
    // }
    
}
