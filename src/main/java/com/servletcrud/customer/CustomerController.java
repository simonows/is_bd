package com.servletcrud.customer;

import java.util.*;
import org.springframework.web.*;
import org.springframework.web.servlet.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/cabinet")
    public ModelAndView home() {
        List<User> listCustomer = customerService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }
    @RequestMapping("/settings")
    public String newCustomerForm(Map<String, Object> model) {
        Settings customer = new Settings();
        model.put("ab", customer);
        return "settings_table";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logCustomer(@ModelAttribute("login") Customer customer) {
        customerService.log(customer);
        return "redirect:/";
    }
    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        customerService.delete(id);
        return "redirect:/";
    }
    @Query(value = "SELECT c FROM Users c WHERE c.name LIKE '%' || :keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'"
            + " OR c.address LIKE '%' || :keyword || '%'")
    public List<Customer> search(@Param("keyword") String keyword);
}
