package demo2.demo2.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import demo2.demo2.config.WebConfig;
import demo2.demo2.entity.product;

import demo2.demo2.entity.users;
import demo2.demo2.servise.MyUserDetails;
import demo2.demo2.servise.UserServise;
import demo2.demo2.servise.productServise;




@Controller
public class commonController {
	// private UserServise userServise;
    

    private final productServise productServise;

    @Autowired
    private UserServise userServise;


    
    public commonController(productServise productServise) {
        this.productServise = productServise;
    }

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }
    

    @GetMapping("/products")
    public String getHomePage(@RequestParam(name="itemname",required = false) String query,Model model,@AuthenticationPrincipal MyUserDetails loginUserDetails) {
            List<product> products;
            if (query != null && !query.isEmpty()) {
                products = productServise.findProductsByItem(query);
            } else {
                products = productServise.getProducts();
            }
            model.addAttribute("name", loginUserDetails.getUsername());
            model.addAttribute("products", products);
            return "products";
        
    }

    @GetMapping("/logout")
    public String getMethodName(HttpSession session) {
        session.setAttribute("successMessage", "Logout success");
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String getUserform(@RequestParam(name="searchvalue",required=false) String query ,Model model) {
        List<users> Users;
        if(query != null && !query.isEmpty()){
            Users=userServise.getUserbyemailorname(query);
        }else{
            Users=userServise.getUsers();
        }
        
        model.addAttribute("users",Users);
        return "users";
    }

    
    

    @GetMapping("/register")
    public String getRegisterform(){
        return "register";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "login";
    }
    
    
    @GetMapping("/product")
    public String getProductPage(HttpSession session) {
            return "productform";
    }
    
    // @PostMapping("/addproduct")
    // public List<product> AddNewProduct(@RequestBody List<product> Products) {
    // 	//userServise.registerNewproduct(i_name, qty, price)
    //     System.out.println(Products);
    // 	return userServise.saveproducts(Products);
    // }
    

    @GetMapping("/editproduct/{id}")
    public String getAddproductsPage(@PathVariable Long id,Model model) {
        product oneproduct=productServise.getProductById(id);
        model.addAttribute("product", oneproduct);
        return "editproduct";
    }


    @GetMapping("/products/{id}")
    public product findProductById(@PathVariable Long id) {
    	return productServise.getProductById(id);
    }

    @PutMapping("/updateproduct")
    public product updateProduct(@RequestBody product Product) {
    	return productServise.updateProduct(Product); 
    }
       
}

