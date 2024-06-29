package com.example.demo.controller;

import com.example.demo.Bean.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @RequestMapping("/student")
    public String index(Model model,
    @RequestParam("index") Optional<Integer> index) throws Exception {
        ObjectMapper mapper=new ObjectMapper();
//        File path= ResourceUtils.getFile("classpath:com/example/demo/Bean/student.json");
        String path="D:\\SU24\\block2\\java6\\Bai_online\\Bai2_demo\\scopes_parameter\\src\\main\\java\\com\\example\\demo\\Bean\\student.json";
        TypeReference<List<Student>> typeReference=new TypeReference<>() {};
        List<Student> students=mapper.readValue(path,typeReference);

        int i=index.orElse(0);
        model.addAttribute("n",i);
        model.addAttribute("sv",students.get(i));
        return "scope/student";
    }
}
