package mvc.backend_server.jwtService;

import mvc.backend_server.entity.Account;
import mvc.backend_server.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JwtUserDetailsService implements IJwtUserDetailsService {

    @Autowired
    private final AccountRepo accountRepo;

    public JwtUserDetailsService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("List user to find");
        List<Account> accountList = accountRepo.findAll();
        String encodedPass = null;
        boolean check = false;
        for (Account a : accountList) {
            if (username.equals(a.getUsername())) {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                encodedPass = bCryptPasswordEncoder.encode(a.getPassword());
                check = true;
            }
        }
        Account findUser = accountRepo.findAccountByUsername(username);
        if (findUser.isAccountNonLocked() && check == true) {
            System.out.println("role user in loadusername"+ findUser.getAuthorities());
            return new User(username, encodedPass, true,
                    true, true, true, findUser.getAuthorities());
        }
        else if(!findUser.isAccountNonLocked() && check == true){
            return new User("lockedAccount", encodedPass, true,
                    true, true, true, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
        }
        else return null;
    }
}
