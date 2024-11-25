//package com.start.controller;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.start.entities.Scheme;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@Controller
//public class SearchController {
//	 //******************************User-Search-Module--End**************************
//    @Autowired
//    JdbcTemplate jdbbcT;
//    
//    
//    
////	@GetMapping("/logout")
////	public ModelAndView logout(Model model) {
////		
////		return new ModelAndView ("login");
////	}
//    
//    
//    
//    
//    
//    @PostMapping("/result")
//    public String userSearch(HttpServletRequest req, @ModelAttribute Scheme scheme, Model model) {
//    	
//    	
//    	
//        int s_age = 0;
//        int s_income = 0;
//        String s_department = null;
//        
//        if (req.getParameter("s_age") != null && !req.getParameter("s_age").isEmpty()) {
//        	s_age = Integer.parseInt(req.getParameter("s_age"));
//        }
//
//        if (req.getParameter("s_income") != null && !req.getParameter("s_income").isEmpty()) {
//            s_income = Integer.parseInt(req.getParameter("s_income"));
//        }
//
//        if (req.getParameter("s_department") != null && !req.getParameter("s_department").isEmpty()) {
//            s_department = req.getParameter("s_department");
//        }
//        
//        String query = "SELECT * FROM SS WHERE S_DEPARTMENT='"+s_department+"' OR  S_INCOME="+s_income+" OR  S_AGE="+s_age;
//        
//        System.out.println("query : " +query);
//      
//        List<Scheme> dml = jdbbcT.query(query, new RowMapper<Scheme>() {
//
//			@Override
//			public Scheme mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Scheme aScheme = new Scheme();
//
//				aScheme.setS_department(rs.getString("S_DEPARTMENT"));
//				//aScheme.setS_income(rs.getString("S_INCOME"));
//				aScheme.setS_income(rs.getInt("S_INCOME"));
//				aScheme.setS_link(rs.getString("S_LINK"));
//				//aScheme.setS_name(rs.getString("S_NAME"));
//			    aScheme.setS_name(rs.getString("SNAME"));
//				
//
//				return aScheme;
//			}
//
//		});
//        System.out.println("size :"+dml.size());
//        if(dml.size() > 0) {
//        model.addAttribute("schemes", dml);
//        }else {
//            model.addAttribute("message","Error ! No row is present with this inputs");
//
//        }
//        return "result";
//    }
//}
