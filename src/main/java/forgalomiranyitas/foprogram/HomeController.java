package forgalomiranyitas.foprogram;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/home")
    public String user() {
        return "user";
    }
    @GetMapping("/admin/home")
    public String admin() {
        return "admin";
    }
    @GetMapping("/jelszoteszt")
    @ResponseBody
    public String[] jelszoteszt() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String[] pass = {"jelszo1","jelszo2","jelszo3","jelszo4","jelszo5","jelszo6","jelszo7","jelszo8","jelszo9","jelszo10"};
        for (int i=0;i<10;i++) {
            pass[i] = "jelszó" + (i + 1) + ": " + bCryptPasswordEncoder.encode(pass[i]);
        }
        return pass;
    }
}
