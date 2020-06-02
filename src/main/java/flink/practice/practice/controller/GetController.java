package flink.practice.practice.controller;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import flink.practice.practice.entity.MemberTest;
import flink.practice.practice.memberService;
import flink.practice.practice.repository.memberRepository;
import flink.practice.practice.testuser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;

import javax.servlet.Servlet;
import javax.servlet.http.HttpSession;
import java.security.Security;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;


@Controller
@RequestMapping("/")
public class GetController {
    @Autowired
    memberRepository repository;

    @RequestMapping(method = RequestMethod.POST, value = "/getMethod")
    public @ResponseBody
    String test(@RequestParam("id") String id, @RequestParam("password") String password) {
       MemberTest memberTest =  repository.findByUserEmail(id);
        System.out.println("///"+memberTest.getUserName());
        return "id : " + id + "  password : " + password;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/test")
    public @ResponseBody
    ArrayList<testuser> test1(@RequestParam("param1") String name) {
        ArrayList<testuser> list = new ArrayList<>();
        testuser user = new testuser();
        user.name = name;
        user.age = "ddd";
        list.add(user);
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/good")
    public @ResponseBody
    ArrayList<String> test3() {
        ArrayList<String> list = new ArrayList<>();
        list.add("hihi");
        list.add("my");
        list.add("name");
        return list;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/signUp")
    public @ResponseBody
    String practice(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name
            , @RequestParam("nickname") String nickname, @RequestParam("year") String year,
                    @RequestParam("month") String month, @RequestParam("date") String date, @RequestParam("phoneNumber") String Phone)  {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    MemberTest member = new MemberTest();
    member.setUserEmail(email);
    member.setUserName(name);
    member.setUserPassword(passwordEncoder.encode(password));
    member.setUserNickname(nickname);
    member.setUserYear(year);
    member.setUserMonth(month);
    member.setUserDate(date);
    member.setUserPhoneNumber(Phone);
    System.out.println("암호화된 비밀번호" + member.getUserPassword());
    MemberTest memberTest2 = repository.save(member);

        return "성공";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public @ResponseBody
    void login(@RequestParam("username") String username, @RequestParam("password") String password) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        MemberTest memberTest = repository.findByUserEmail(email);
//        Boolean check = passwordEncoder.matches(password, memberTest.getUserPassword());
//        if (check) {
//            return success();
//
//        } else {
//
//            return "실패";
//        }
    }
@RequestMapping(method = RequestMethod.GET , value = "/login/success")
    public @ResponseBody
    String success(){
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "성공";
}

    @RequestMapping(method = RequestMethod.GET, value = "/user/logout/result")
    public @ResponseBody
    String logout(){
        return "성공";
    };
}

