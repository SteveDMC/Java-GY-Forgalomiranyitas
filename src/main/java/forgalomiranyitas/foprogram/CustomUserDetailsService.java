package forgalomiranyitas.foprogram;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
    //@Autowired
    private final UserRepository userRepo;

    public CustomUserDetailsService(final UserRepository userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findByBejelentkezes(userName).orElseThrow(()-> new UsernameNotFoundException("Bejelentkezes" + userName + "not found"));
        return new org.springframework.security.core.userdetails.User(user.getBejelentkezes(),user.getJelszo(),getAuthorities(user));
    }
    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        Collection<GrantedAuthority> authorities;
        authorities = AuthorityUtils.createAuthorityList(user.getJogosultsag());
        return authorities;
    }
}
