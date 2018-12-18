package controller;

import entity.user.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.StudentService;

import java.util.Optional;

@Controller
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/student/{id}")
    public String student(@PathVariable int id, Model model){
        Optional<Student> student = service.get(id);
        if (!student.isPresent()) {
            return "error";
        }
        model.addAttribute("student", student.get());
        return "student/info";
    }

}
