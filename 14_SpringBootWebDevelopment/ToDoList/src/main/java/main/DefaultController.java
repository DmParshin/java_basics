package main;

import main.model.Deal;
import main.model.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class DefaultController {

    @Autowired
    DealRepository dealRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Deal>dealIterable = dealRepository.findAll();
        ArrayList<Deal>dealArrayList = new ArrayList<>();
        dealIterable.forEach(deal -> dealArrayList.add(deal));
        model.addAttribute("deals", dealArrayList);

        return "index";
    }
}
