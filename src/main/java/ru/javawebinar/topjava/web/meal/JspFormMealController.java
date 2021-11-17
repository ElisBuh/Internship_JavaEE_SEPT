package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javawebinar.topjava.service.MealService;

@Controller
@RequestMapping(value = "/mealForm")
public class JspFormMealController extends AbstractMealRestController {
    public JspFormMealController(MealService service) {
        super(service);
    }

    @GetMapping("")
    public String form(Model model) {
        return "/mealForm";
    }

}
