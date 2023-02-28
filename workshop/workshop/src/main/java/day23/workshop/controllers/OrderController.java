package day23.workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import day23.workshop.models.ID;
import day23.workshop.models.Order;
import day23.workshop.repo.OrderRepo;

@Controller
@RequestMapping
public class OrderController {

    @Autowired
    OrderRepo oRepo;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("order", new ID());
        return "index";

    }

    @PostMapping("/")
    public String searchById(Model model, ID id) {
        return "redirect:/order/total/" + id.getId();
    }

    @GetMapping("/order/total/{id}")
    public String getOrderById(Model model, @PathVariable(name = "id") int id) {

        List<Order> result = oRepo.getOrderById(id);
        model.addAttribute("orderid", id);
        model.addAttribute("result", result);
        return "order";
    }
    
}
