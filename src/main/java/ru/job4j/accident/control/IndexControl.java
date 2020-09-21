package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentHibernate;
import ru.job4j.accident.repository.DAO;

@Controller
public class IndexControl {
    final DAO repo;

    public IndexControl(AccidentHibernate repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", repo.findAll());
        return "index";
    }
}
