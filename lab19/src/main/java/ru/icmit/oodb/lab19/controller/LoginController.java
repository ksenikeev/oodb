package ru.icmit.oodb.lab19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.icmit.oodb.lab19.domain.Users;
import ru.icmit.oodb.lab19.repository.UsersJPARepository;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UsersJPARepository service;

    @GetMapping(value="/loginpage")
    @ResponseBody
    public String loginPage() {
        return "<html><body>" +
                "<h1>Login page</h1>" +
                "<form method='post' action='/login'>" +
                "login:<input name='login' type='text'/><br/>" +
                "password:<input name='password' type='password'/><br/>" +
                "<input type='submit'/>" +
                "<form>" +
                "</body></html>";
    }

    @PostMapping(value="/login")
    @ResponseBody
    public String loginPost(HttpServletRequest request,
                @RequestParam(name = "login") String login,  @RequestParam(name = "password") String password) {

        Users user = service.getUser(login, password);

        if (user != null) {
            request.getSession(true).setAttribute("user", user);

            return "<html><body>" +
                    "<h1>Add pay</h1>" +
                    "<form  method='post' action='/addpay'>" +
                    "Organization source (id):<input name='org1' type='text'/><br/>" +
                    "Organization destantion (id):<input name='org2' type='text'/><br/>" +
                    "Summ:<input name='summ' type='text'/><br/>" +
                    "<input type='submit'/>" +
                    "<form>" +
                    "</body></html>";
        } else {
            return "<html><body>" +
                    "<h1>Login page (!)</h1>" +
                    "<form method='post' action='/login'>" +
                    "login:<input name='login' type='text'/><br/>" +
                    "password:<input name='password' type='password'/><br/>" +
                    "<input type='submit'/>" +
                    "<form>" +
                    "</body></html>";

        }
    }

}
