package controller;


import entity.user.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.TeacherService;

import java.util.Optional;

@Controller
public class TeacherController {

    private TeacherService service;

    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @RequestMapping("/teacher/{id}")
    public String teacher(@PathVariable int id, Model model){
        Optional<Teacher> teacher = service.get(id);
        if (!teacher.isPresent()) {
            return "error";
        }
        model.addAttribute("teacher", teacher.get());
        return "teacher/info";
    }

}
