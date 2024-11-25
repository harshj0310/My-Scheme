package com.start.controller;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.start.dao.UserRepository;
import com.start.dao.UserRepository2;
import com.start.dao.UserRepositoryfeed;
import com.start.dao.Userrepository1;
import com.start.entities.Admin;
import com.start.entities.Feedback;
import com.start.entities.Scheme;
import com.start.entities.User;
import com.start.helper.Message;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	User u =new User();
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserRepositoryfeed userRepositoryfeed;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRepository2 userRepository2;
	
	

	
	@RequestMapping("/home")
	public String home() {
		
		return "home.html";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		
		return "contact";
	}
	
	@RequestMapping("/adminLogin")
	public String adminLogin() {
		
		return "adminLogin";
	}
	@RequestMapping("/feedback")
	public String feedback() {
		
		return "feedback";
	}
	@RequestMapping("/feed")
	public String feed(@ModelAttribute("feedback")Feedback feedback, Model model)  {
		Feedback result=this.userRepositoryfeed.save(feedback);
		model.addAttribute("feedback",new Feedback());
		model.addAttribute("sucess","Successfully register");
		System.out.println("sucess message call");

		return "feedback";
	}
	
	
	@RequestMapping("/signup")
	public String signup(Model model) {
		
		model.addAttribute("user",new User());
		return "signup";
	}
	
	@RequestMapping("/login")
	public String login(Model model , HttpSession session, HttpServletRequest req) {
		//String username="";
		
		model.addAttribute("user",new User());
		return "login";
	}
	
	
	@RequestMapping("/department")
	public String department(Model model , HttpSession session, HttpServletRequest req) {
		u =(User) session.getAttribute("User");
		if(u==null) {
			return "login";
		}
			
		model.addAttribute("user",new User());
		return "userui";
	}
	
	@RequestMapping("/review")
	public String review(Model model , HttpSession session, HttpServletRequest req) {
		
		String query="SELECT * FROM FEEDBACK";
		List<Feedback> dml = jdbbcT.query(query, new RowMapper<Feedback>() {

			@Override
			public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
				Feedback f= new Feedback();
				
				f.setEmail(rs.getString("EMAIL"));
				f.setFeed(rs.getString("FEED"));
				f.setName(rs.getString("NAME"));
				
				

				return f;
			}

		});
        System.out.println("size :"+dml.size());
        if(dml.size() > 0) {
        model.addAttribute("f", dml);
        }else {
            model.addAttribute("message","Error ! No row is present with this inputs");

        }
        return "Review";
		
	}

	
	
	
	
//-----------------forget password------------------------------------------	
	
	
	@RequestMapping("/for")
	public String forget() {
		
		return "forget";
	}
    @PostMapping("/forget")
    public ModelAndView update(String email,Model model,HttpSession session , HttpServletRequest req) throws NotFoundException {
      try {
//    	Optional<User> optional = userRepository.findByEmail(email);
//        User user = optional.orElseThrow(() -> new NotFoundException());
    	  
    	User user = userRepository.findByEmail(email);
    	if(user==null) {
    		System.out.println("This is note a valid user*******");
    		return new ModelAndView ("forget");
    	}
                
        String s=req.getParameter("password1");
		BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder();
		String encryptedPass =bcrypt.encode(s);
		user.setPassword(encryptedPass);

        userRepository.save(user);
      }catch(Exception e) {
    	  return new ModelAndView ("error");
      }
        
        return new ModelAndView ("login");
    }
		
	
//-------------------------------------------------------------	
	
	

	
	//handler for new register user
	@RequestMapping(value="/do_register",method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("user")User user,  
		Model model,HttpSession session , HttpServletRequest req) {
		
		
		
		try {			
//			<dependency>
//				<groupId>org.springframework.security</groupId>
//				<artifactId>spring-security-crypto</artifactId>
//			</dependency> 
			String s=req.getParameter("password");
			BCryptPasswordEncoder bcrypt= new BCryptPasswordEncoder();
			if(s!=null) {
				String encryptedPass =bcrypt.encode(s);
				user.setPassword(encryptedPass);
			}
			
			
			
			
//****************************************************************************************************			
			
			user.setRole("ROLE_USER");
			
			//System.out.println("Agreement " +agreement);
			System.out.println("User" +user);
			User result=this.userRepository.save(user);
			model.addAttribute("user",new User());
			
			session.setAttribute("message", new Message("Successfully register","alert-success"));
			model.addAttribute("sucess","Successfully register");
			System.out.println("sucess message call");
			
			return new ModelAndView ("signup");
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user",user);
			//session.setAttribute("message", new Message("Something went wrong"+e.getMessage(),"alert-danger"));
			model.addAttribute("sucess","check box not clicked");
			return new ModelAndView ("signup");
		}
		
		
	}
	
	@RequestMapping(value="/check_user",method=RequestMethod.POST)
	public String checkUser(@ModelAttribute("user")User user, @RequestParam(value="agreement",defaultValue="false")boolean agreement, 
		Model model,HttpSession session , HttpServletRequest req,HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
		
		// For Java Servlet (using HttpServletResponse)
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setHeader("Expires", "0"); // Proxies
		// response.sendRedirect(request.getRequestURI()); // Redirect to the same page

		if (session == null || session.isNew()) {
	        // If session is null or invalid, redirect to the home page
	        return "redirect:/home";
	    }
		
				
		
		String email ="";
		String password1 ="";
		BCryptPasswordEncoder bcrypt1= new BCryptPasswordEncoder();
		
		System.out.println("do register method call.................................................");
				
		if(req.getParameter("name")!= null && !req.getParameter("name").equals("")) {
		 email = req.getParameter("name");
		 System.out.println(email);
		 
		}
		if(req.getParameter("password")!= null && !req.getParameter("password").equals("")) {
		// password = req.getParameter("password");
		
		 password1 = req.getParameter("password");
		 	 
		 //System.out.println(password);
		}
		
		
		
	ArrayList<User>allUserList =(ArrayList<User>) userRepository.findAll();
	System.out.println("LIST_SIZE ................................................. : "+allUserList.size());
	boolean flag =false; // flag for user
	boolean flag2=false; // flag2 for admin
	for(int i =  0 ; i<allUserList.size();i++) {
		// if user try to login
		if(allUserList.get(i).getEmail().equals(email)&&  allUserList.get(i).getRole().equals("ROLE_USER")){
			if(bcrypt1.matches(password1,allUserList.get(i).getPassword())) {// this method is match the user input password to the encrypted database password
				flag=true;
				System.out.println("...........................INSIDE IF BLOCK................................................. : ");
				User u = new User();
				u.setEmail(email);
				u.setPassword(password1);
				u.setRole("ROLE_USER");
			
				if(u!=null) {
					model.addAttribute("user",new User());
					
					String query = "SELECT * FROM UU WHERE EMAIL='" + email + "'";
					List<User> dml = jdbbcT.query(query, new RowMapper<User>() {

						@Override
						public User mapRow(ResultSet rs, int rowNum) throws SQLException {
							User us= new User();
							
							us.setEmail(rs.getString("EMAIL"));
							//us.setFeed(rs.getString("FEED"));
							us.setName(rs.getString("NAME"));
							
							

							return us;
						}

					});
					
					 System.out.println(" user email size :"+dml.size());
				        if(dml.size() > 0) {
				        model.addAttribute("us", dml);
				        }else {
				            model.addAttribute("message","Error ! No row is present with this inputs");

				        }
				        
					session.setAttribute("User",u);
					return "user_search";	
				}							
			}
		}
		

		
	}//End for loop
	
	if(flag ) {
		return "user_search";	
	}
	
	else {
		return "error";
		//return "login";
	}

}
	
	
	
	
//if admin try to login
	@RequestMapping(value="/check_admin",method=RequestMethod.POST)
	public String checkAdmin(@ModelAttribute("admin")Admin admin, @RequestParam(value="agreement",defaultValue="false")boolean agreement, 
		Model model,HttpSession session , HttpServletRequest req) {
		String email ="";
		String password1 ="";
		BCryptPasswordEncoder bcrypt1= new BCryptPasswordEncoder();
		
		System.out.println("do register method call.................................................");
		
//		if(req.getParameter("name")!= null && !req.getParameter("name").equals("")) {
//		 username = req.getParameter("name");
//		}
		if(req.getParameter("name")!= null && !req.getParameter("name").equals("")) {
		 email = req.getParameter("name");
		 System.out.println(email);
		 
		}
		if(req.getParameter("password")!= null && !req.getParameter("password").equals("")) {
		// password = req.getParameter("password");
		
		 password1 = req.getParameter("password");
		 	 
		 //System.out.println(password);
		}
		
		
		
	ArrayList<Admin>allUserList =(ArrayList<Admin>) userRepository2.findAll();
	System.out.println("LIST_SIZE ................................................. : "+allUserList.size());

	boolean flag2=false; // flag2 for admin
	for(int i =  0 ; i<allUserList.size();i++) {
//----------------+++---------------------------------
		//if admin try to login
		 if(allUserList.get(i).getEmail().equals(email)&&  allUserList.get(i).getRole().equals("admin")) {
			
			if(bcrypt1.matches(password1,allUserList.get(i).getPassword())) {// this method is match the user input password to the encrypted database password
				flag2=true;
				System.out.println("...........................INSIDE IF BLOCK................................................. : ");
				Admin u = new Admin();
				u.setRole("admin");
			
				if(u!=null) {
					session.setAttribute("Admin",u);
					//return "adminui";
					return "insert";
					
				}
				
			}
		}//else-if end
			
			
		//----------------+++---------------------------------
		
	}//End for loop
	
	
    if(flag2) {
		//return "adminui";
		return "insert";
	}
	else {
		return "error";
		//return "login";
	}

}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
	    if (session != null) {
	        session.invalidate(); // Invalidate the session completely
	    }
	    System.out.println("Logout successfully");
	    
	    // Set cache control headers to prevent caching
	    CacheControl cacheControl = CacheControl.noStore().mustRevalidate();
	    
	    // Construct the redirect URL to the home page
	    String redirectUrl = request.getContextPath() + "/home";
	    
	    // Add headers to prevent caching
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	    response.setHeader("Expires", "0"); // Proxies
	    
	    // Redirect to the home page using a POST request
	    StringBuilder html = new StringBuilder();
	    html.append("<html><head><script>");
	    html.append("function submitForm() {");
	    html.append("var form = document.createElement('form');");
	    html.append("form.method = 'post';");
	    html.append("form.action = '" + redirectUrl + "';");
	    html.append("document.body.appendChild(form);");
	    html.append("form.submit();");
	    html.append("}");
	    html.append("</script></head><body onload='submitForm();'></body></html>");
	    
	    // Return the response with cache control headers and redirection headers
	    return ResponseEntity.status(HttpStatus.OK)
	            .cacheControl(cacheControl)
	            .body(html.toString());
	}

	
	
//******************************Admin-Module--start**************************	
	@Autowired
	private Userrepository1 userrepository1;
	
	@GetMapping("/adminui")
	public ModelAndView adminUi(Model model) {
		
		return new ModelAndView ("insert");
	}
	

	@PostMapping("/add")
	public ModelAndView add(HttpServletRequest req, @ModelAttribute("scheme") Scheme scheme, Model model) {
	    // Ensure that sname is set before saving
	    // For demonstration purposes, let's assume sname can be obtained from the request parameter "sname"
		
	    String sname = req.getParameter("sname");
	    scheme.setSname(sname);

	    // Now you can save the Scheme object
	    Scheme result = this.userrepository1.save(scheme);

	    // Clear the model attribute to prepare for the next entry
	    model.addAttribute("scheme", new Scheme());

	    // Add a success message to the model
	    model.addAttribute("success", "Successfully registered");

	    // Return the ModelAndView with appropriate view name and model attributes
	    return new ModelAndView("insert", "Scheme", scheme);
	}

	
	
	
	
	
	@GetMapping("/delete")
	public ModelAndView delete(Model model) {
		
		return new ModelAndView ("delete");
	}


    

    @GetMapping("/del")
  //  public String deleteSchemeByName(@PathVariable("sname") String sname) {
    public ModelAndView deleteSchemeByName(@RequestParam String sname) {
        try {
           
        	Scheme sc=userrepository1.findById(sname).get();
            userrepository1.delete(sc);
        	
        	
            return new ModelAndView ("delete");
           // return "redirect:/?deleted=true";
        } catch (Exception e) {
        	
        	return new ModelAndView ("error1");
        }
    }
	
	
    @GetMapping("/updat")
	public ModelAndView update(Model model) {
		
		return new ModelAndView ("update");
	}
    
    
    @GetMapping("/up")
    public ModelAndView update(String sname,int s_age_max,int s_age_min ,String s_department,String s_gov,String s_link,int s_income,String s_caste) throws NotFoundException {
      try {
    	Optional<Scheme> optional = userrepository1.findBysname(sname);
        Scheme user = optional.orElseThrow(() -> new NotFoundException());

        // Update user details
        user.setS_age_max(s_age_max);
        user.setS_age_min(s_age_min);
        user.setS_department(s_department);   
        user.setS_income(s_income);
        user.setS_link(s_link);
        user.setS_caste(s_caste);
       

        userrepository1.save(user);
      }catch(Exception e) {
    	  return new ModelAndView ("error1");
      }
        
        return new ModelAndView ("update");
    }
  //******************************Admin-Module--End**************************
    
    
  //******************************User-Search-Module--End**************************
    @Autowired
    JdbcTemplate jdbbcT;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @PostMapping("/result")
    public String userSearch(HttpServletRequest req, @ModelAttribute Scheme scheme, Model model) {
    	
    	 
    	
    	
        int s_age = 0;
        int s_income = 0;
        String s_department = null;
        String s_gender=null;
        String s_caste=null;

        
        if (req.getParameter("s_age") != null && !req.getParameter("s_age").isEmpty()) {
        	s_age = Integer.parseInt(req.getParameter("s_age"));
        }

        if (req.getParameter("s_income") != null && !req.getParameter("s_income").isEmpty()) {
            s_income = Integer.parseInt(req.getParameter("s_income"));
        }

        if (req.getParameter("s_department") != null && !req.getParameter("s_department").isEmpty()) {
            s_department = req.getParameter("s_department");
        }
        if (req.getParameter("s_gender") != null && !req.getParameter("s_gender").isEmpty()) {
            s_gender = req.getParameter("s_gender");
        }
        if (req.getParameter("s_caste") != null && !req.getParameter("s_caste").isEmpty()) {
            s_caste = req.getParameter("s_caste");
        }
        
        
        String query = "SELECT * FROM SS WHERE S_DEPARTMENT = :s_department "
                + "AND S_INCOME >= :s_income "
                + "AND (S_GENDER = :s_gender OR S_GENDER = 'both') "
                + "AND (S_CASTE = :s_caste OR S_CASTE = 'OPEN') "
                + "AND :s_age BETWEEN S_AGE_MIN AND S_AGE_MAX";
               ;

               // Use this in place of JdbcTemplate
               Map<String, Object> params = new HashMap<>();
               params.put("s_department", s_department);
               params.put("s_income", s_income);
               params.put("s_gender", s_gender);
               params.put("s_caste", s_caste);
               params.put("s_age", s_age);

        System.out.println("query : " +query);
        
      
//        List<Scheme> dml = jdbbcT.query(query, new RowMapper<Scheme>() {
        
        List<Scheme> dml = namedParameterJdbcTemplate.query(query, params, new RowMapper<Scheme>() {
			@Override
			public Scheme mapRow(ResultSet rs, int rowNum) throws SQLException {
				Scheme aScheme = new Scheme();

				aScheme.setS_department(rs.getString("S_DEPARTMENT"));
				aScheme.setS_income(rs.getInt("S_INCOME"));
				aScheme.setS_link(rs.getString("S_LINK"));
				aScheme.setS_gender(rs.getString("S_GENDER"));
				//aScheme.setS_name(rs.getString("S_NAME"));
			   // aScheme.setS_name(rs.getString("SNAME"));
				aScheme.setSname(rs.getString("SNAME"));
				

				return aScheme;
			}

		});
        System.out.println("size :"+dml.size());
        if(dml.size() > 0) {
        model.addAttribute("schemes", dml);
        }else {
            model.addAttribute("message","Error ! No row is present with this inputs");

        }
        return "result";
    }
    
    
	
}//Homecontroller class end




