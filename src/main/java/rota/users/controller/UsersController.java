package rota.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import rota.users.model.UsersService;
import rota.users.model.UsersVO;

import java.util.List;

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
    public ResponseEntity<String> registerUser(@RequestBody UsersVO usersVO, @AuthenticationPrincipal UserDetails currentUser) {
        try {
            String registerBy = currentUser.getUsername();
            usersVO.setRegisterBy(registerBy);
            usersService.addUser(usersVO);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) { // Catch any exception
            return ResponseEntity.status(403).body("Error registering user: " + e.getMessage());
        }
    }

    /**
     * 用於使用者修改的 API 端點。
     * 這個端點將會是公開的。
     */
    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UsersVO usersVO){
        try {
            usersService.saveUser(usersVO);
            return ResponseEntity.ok("User updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(403).body("Error updating user: " + e.getMessage());
        }
    }

    /**
     * 用於取得所有使用者資訊。
     * 這個端點將會是公開的。
     */
    @GetMapping("/getUsers")
    public List<UsersVO> getUsers(){
        return usersService.getAllUsers();
    }

    /**
     * 用於取得指定使用者資訊。
     * @param userId
     * @return 使用者資訊
     */
    @GetMapping("/getUserById/{userId}")
    public UsersVO getUserById(@PathVariable Integer userId){
        return usersService.getUserById(userId);
    }

}