//package com.start.controller;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.start.dao.Userrepository1;
//import com.start.entities.Scheme;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@Controller
//public class AdminController {
//
//	//******************************Admin-Module--start**************************	
//		@Autowired
//		private Userrepository1 userrepository1;
//		
//		@GetMapping("/adminui")
//		public ModelAndView adminUi(Model model) {
//			
//			return new ModelAndView ("insert");
//		}
//		
//		
////		@GetMapping("/insert")
////		public ModelAndView insert(Model model) {
////			
////			return new ModelAndView ("insert");
////		}
//		
//		//@RequestMapping(value="/add",method=RequestMethod.POST)
//		@PostMapping("/add")
//		public ModelAndView add(HttpServletRequest req, @ModelAttribute("scheme")Scheme scheme, Model model) {
//			
//		        Scheme result=this.userrepository1.save(scheme);
//				model.addAttribute("scheme",new Scheme());
//				
//				//session.setAttribute("message", new Message("Successfully register","alert-success"));
//				model.addAttribute("sucess","Successfully register");
//				System.out.println("sucess message call");
//		        //System.out.println(s_name);
//		      //  model.addAttribute("Scheme",scheme1);
//			// return new ModelAndView("sucess", "Scheme", scheme);
//				return new ModelAndView("insert", "Scheme", scheme);
//		}
//		
//		
//		
//		
//		
//		@GetMapping("/delete")
//		public ModelAndView delete(Model model) {
//			
//			return new ModelAndView ("delete");
//		}
//		@GetMapping("/logout")
//		public ModelAndView logout(Model model) {
//			
//			return new ModelAndView ("login");
//		}
//
//	    
//
//	    @GetMapping("/del")
//	  //  public String deleteSchemeByName(@PathVariable("sname") String sname) {
//	    public ModelAndView deleteSchemeByName(@RequestParam String sname) {
//	        try {
//	           
//	        	Scheme sc=userrepository1.findById(sname).get();
//	            userrepository1.delete(sc);
//	        	
//	        	
//	            return new ModelAndView ("delete");
//	           // return "redirect:/?deleted=true";
//	        } catch (Exception e) {
//	        	
//	        	return new ModelAndView ("error1");
//	        }
//	    }
//		
//		
//	    @GetMapping("/updat")
//		public ModelAndView update(Model model) {
//			
//			return new ModelAndView ("update");
//		}
//	    
//	    
//	    @GetMapping("/up")
//	    public ModelAndView update(String sname,int s_age, String s_department,String s_gov,String s_link,int s_income) throws NotFoundException {
//	      try {
//	    	Optional<Scheme> optional = userrepository1.findBysname(sname);
//	        Scheme user = optional.orElseThrow(() -> new NotFoundException());
//
//	        // Update user details
//	        user.setS_age(s_age);
//	        user.setS_department(s_department);
//	        user.setS_gov(s_gov);
//	        user.setS_income(s_income);
//	        user.setS_link(s_link);
//	       
//
//	        userrepository1.save(user);
//	      }catch(Exception e) {
//	    	  return new ModelAndView ("error1");
//	      }
//	        
//	        return new ModelAndView ("sucess");
//	    }
//	  //******************************Admin-Module--End**************************
//}
