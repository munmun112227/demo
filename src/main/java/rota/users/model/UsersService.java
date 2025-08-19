package rota.users.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rota.configulation.jwt.JwtUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public UsersVO getUserById(Integer userId) {
        return usersRepository.findById(userId).orElse(null);
    }

    public UsersVO addUser(UsersVO usersVO) throws IllegalArgumentException {
        if (usersRepository.findByAccount(usersVO.getAccount()).isPresent()) {
            throw new IllegalArgumentException("User with account " + usersVO.getAccount() + " already exists!");
        } else {
            return usersRepository.save(usersVO);
        }

    }

    public UsersVO saveUser(UsersVO usersVO) {
        // 在儲存前，對密碼進行加密
        usersVO.setPassword(passwordEncoder.encode(usersVO.getPassword()));
        return usersRepository.save(usersVO);
    }

    public void deleteUserById(Integer userId) {
        usersRepository.deleteById(userId);
    }

    public Iterable<UsersVO> getAllUsers() {
        return usersRepository.findAll();
    }
}
