package rota.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rota.configulation.jwt.JwtUtil;
import rota.users.model.CustomUserDetailsService;
import rota.users.model.UsersService;
import rota.users.model.UsersVO;

@Controller
@RequestMapping("/users/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getAccount(), loginRequest.getPassword())
            );

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getAccount());
            String token = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.status(400).body("Error logging in: 帳號或密碼錯誤");
        }

    }
}
