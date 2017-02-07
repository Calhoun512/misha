/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import CRM.objects.Users;
import CRM.repository.UsersDAO;
import CRM.objects.Message;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author calho
 */
@Controller
public class UsersController {
    @Autowired
    UsersDAO dao;
    
    private static final Logger logger = Logger.getLogger(UsersController.class.getName());
    
    @RequestMapping("/users/userform")
    public ModelAndView showform(){
        return new ModelAndView("userform", "command", new Users());
    }
    
    @RequestMapping(value = "/users/newUser", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("User") Users user, HttpServletRequest request){
        int r = dao.save(user);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.SUCCESS, "User creation successful");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New User creation unsuccessful");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/home");
    }
    
    @RequestMapping("/Users/viewUsers/{pageid}")
    public ModelAndView viewUsers(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;
        }
        
        List<Users> list = dao.getUsersByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("list", list);
        
        int count = dao.getUserCount();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");
        
        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
        }
        
        return new ModelAndView("viewUsers", context);
    }
    
    @RequestMapping(value = "/Users/editUser/{user_id}")
    public ModelAndView edit(@PathVariable int user_id){
        Users user = dao.getUsersById(user_id);
        return new ModelAndView("usereditform", "command", user);
    }
    
    @RequestMapping(value = "/users/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("users") Users users, HttpServletRequest request){
        int r = dao.update(users);
        
        Message msg = null;
        if(r == 1) {
            msg = new Message(Message.Level.SUCCESS, "User successfully edited");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Fail to edit user");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/home");
    }
    
    @RequestMapping(value = "/users/deleteuser/{user_id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int user_id, HttpServletRequest request){
        int r = dao.delete(user_id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.SUCCESS, "User has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "User deletion failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/home");
    }
}
