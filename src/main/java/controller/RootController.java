package controller;

import entity.user.Student;
import entity.user.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.StudentService;
import service.TeacherService;

import javax.validation.constraints.NotNull;

@Controller
public class RootController {

    private StudentService studentService;
    private TeacherService teacherService;

    private final String STUDENT_TYPE = "student";
    private final String TEACHER_TYPE = "teacher";

    @Autowired
    public RootController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login/login";
    }

    @RequestMapping(value = "/loginTo", method = RequestMethod.POST)
    public String loginTo(@NotNull int id,
                          @NotNull String password,
                          @NotNull String type,
                          Errors errors,
                          Model model) {
        if (errors.hasErrors()) {
            return "login/login";
        }
        if (STUDENT_TYPE.equals(type)) {
            Student student = studentService.login(id, password);
            model.addAttribute("user", student);
        } else if (TEACHER_TYPE.equals(type)) {
            Teacher teacher = teacherService.login(id, password);
            model.addAttribute("user", teacher);
        }else {
            return "login/login";
        }
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "login/register";
    }

    @RequestMapping(value = "/registerTo", method = RequestMethod.POST)
    public String registerTo(@NotNull String name,
                             @NotNull String password,
                             @NotNull String password2,
                             String email,
                             @NotNull String type,
                             Errors errors) {
        if (errors.hasErrors()) {
            return "login/register";
        }
        if (!password.equals(password2)){
            return "login/register";
        }
        if (STUDENT_TYPE.equals(type)) {
            studentService.register((Student) new Student()
                    .setName(name)
                    .setPassword(password)
                    .setEmail(email)
            );
        } else if (TEACHER_TYPE.equals(type)) {
            teacherService.register((Teacher) new Teacher()
                    .setName(name)
                    .setPassword(password)
                    .setEmail(email)
            );
        }else {
            return "login/register";
        }
        return "login/registerSuccess";
    }

}
