package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalDate;
import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalTime;

@Controller
@RequestMapping(value = "/meals")
public class JspMealController extends AbstractMealRestController {


    public JspMealController(MealService service) {
        super(service);
    }

    @GetMapping("")
    public String getMeals(Model model,
                           @RequestParam(name = "action", defaultValue = "all") String action,
                           HttpServletRequest request) {
        List<MealTo> list;
        if (action.equals("filter")) {
            LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
            LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
            LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
            LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
            list = getBetween(startDate, startTime, endDate, endTime);
        } else {
            list = getAll();
        }
        model.addAttribute("meals", list);
        return "meals";
    }

    @GetMapping("/delete")
    public String deleteMeal(@RequestParam(name = "id") Integer id) {
        delete(id);
        return "redirect:/meals";
    }

    @GetMapping("/update")
    public String updateMeal(@RequestParam(name = "id") Integer id,
                             HttpServletRequest request) {
        request.setAttribute("meal", get(id));
        return "forward:/mealForm";
    }

    @GetMapping("/create")
    public String createMeal(HttpServletRequest request) {
        Meal meal = new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000);
        request.setAttribute("meal", meal);
        return "forward:/mealForm";
    }

    @PostMapping("")
    public String save(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        Meal meal = new Meal(
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));

        if (StringUtils.hasLength(request.getParameter("id"))) {
            update(meal, Integer.parseInt(request.getParameter("id")));
        } else {
            create(meal);
        }
        return "redirect:/meals";
    }

}
