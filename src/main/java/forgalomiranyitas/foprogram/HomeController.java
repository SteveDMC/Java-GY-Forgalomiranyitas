package forgalomiranyitas.foprogram;

import forgalomiranyitas.foprogram.model.KorlatozasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("/regisztral")
    public String greetingForm(Model model){
        model.addAttribute("reg", new User());
        return "regisztral";
    }
    //@Autowired
    private final UserRepository userRepo;

    public HomeController(final UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    @PostMapping("/regisztral_feldolgoz")
    public String Regisztracio(@ModelAttribute User user, Model model) {
        for(User felhasznalo2:userRepo.findAll())
            if(felhasznalo2.getBejelentkezes().equals(user.getBejelentkezes())){
                model.addAttribute("uzenet","A regisztrációs név már foglalt ("+user.getBejelentkezes()+")!");
                return "reghiba";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setJelszo(passwordEncoder.encode(user.getJelszo()));
        user.setJogosultsag("ROLE_Vendeg");
        userRepo.save(user);
        model.addAttribute("id",user.getId());
        model.addAttribute("bejelentkezes",user.getBejelentkezes());
        return "regjo";
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

    @Autowired private KorlatozasRepo korlatozasRepo;
    @GetMapping("/korlatozasok")
    public String korlatozasok(Model model){
        model.addAttribute("korlatozasok", korlatozasRepo.findAll());
        return "korlatozasok";
    }
}
