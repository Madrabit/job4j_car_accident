package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {


    @GetMapping("/")
    public String index(Model model) {
        AccidentMem repository = new AccidentMem();
        //Test @Repository
        repository.store(new Accident(1, "Petr", "lalala", "Spb"));
        repository.store(new Accident(2, "Andrew", "hohoho", "Msk"));
        model.addAttribute("accidents", repository.getAccidents());
        return "index";
    }
}
