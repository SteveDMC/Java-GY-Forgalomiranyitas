package forgalomiranyitas.foprogram;

import forgalomiranyitas.foprogram.model.KorlatozasRepo;
import forgalomiranyitas.foprogram.model.Uzenet;
import forgalomiranyitas.foprogram.model.UzenetRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.time.LocalDateTime;

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
    public String admin(Model model) {
        model.addAttribute("uzenetek", uzenetRepo.findAllWithCustomOrderBy(Sort.by(Sort.Direction.DESC, "datum")));
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

    @GetMapping("/uzenetkuldes")
    public String uzenetkuldes(Model model){
        model.addAttribute("uzenet", new Uzenet());
        return "uzenetkuldes";
    }

    @Autowired private UzenetRepo uzenetRepo;
    @PostMapping("/uzenetkuldes")
    public String uzenetkuldes(@Valid @ModelAttribute Uzenet uzenet, BindingResult bindingResult, Model model, Principal principal) {
        if (bindingResult.hasErrors())
            return "uzenetkuldes";
        String nev = principal != null ? principal.getName() : "Vendég";
        uzenet.setNev(nev);
        uzenet.setDatum(LocalDateTime.now());
        uzenetRepo.save(uzenet);
        return "uzenet-bekuldve";
    }
}
