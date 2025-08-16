package rota.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import rota.users.model.UsersService;
import rota.users.model.UsersVO;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 用於使用者註冊的 API 端點。
     * 這個端點將會是公開的。
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UsersVO usersVO) {
        try {
            usersService.saveUser(usersVO);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) { // Catch any exception
            return ResponseEntity.status(500).body("Error registering user: " + e.getMessage());
        }
    }

}