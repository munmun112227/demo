package rota.users.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        UsersVO userVO = usersRepository.findByAccount(account)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with account: " + account));

        return User.withUsername(userVO.getAccount())
                .password(userVO.getPassword())
                .roles("")
                .build();
    }
}
