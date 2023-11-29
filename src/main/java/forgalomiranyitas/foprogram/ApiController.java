package forgalomiranyitas.foprogram;

import forgalomiranyitas.foprogram.model.Korlatozas;
import forgalomiranyitas.foprogram.model.KorlatozasRepo;
import forgalomiranyitas.foprogram.model.Megnevezes;
import forgalomiranyitas.foprogram.model.MegnevezesRepo;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class ApiController {
    private final MegnevezesRepo repo;

    public ApiController(MegnevezesRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/api/megnevezes")
    Iterable<Megnevezes> olvasMind() {
        return repo.findAll();
    }

    @GetMapping("/api/megnevezes/{id}")
    Megnevezes olvasEgy(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("Megnevezés nem található: " + id));
    }

    @PostMapping("/api/megnevezes")
    Megnevezes feltolt(@RequestBody Megnevezes ujKorlatozas) {
        return repo.save(ujKorlatozas);
    }

    @PutMapping("/api/megnevezes/{id}")
    Megnevezes modosit(@RequestBody Megnevezes adatKorlatozas, @PathVariable Integer id) {
        return repo.findById(id)
                .map(a -> {
                    a.setNev(adatKorlatozas.getNev());
                    return repo.save(a);
                })
                .orElseGet(() -> {
                    adatKorlatozas.setId(id);
                    return repo.save(adatKorlatozas);
                });
    }

    @DeleteMapping("/api/megnevezes/{id}")
    void torol(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
