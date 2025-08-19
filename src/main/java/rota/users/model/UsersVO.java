package rota.users.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
public class UsersVO implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "user_acc", nullable = false, unique = true)
    private String account;

    @Column(name = "user_pwd", nullable = false)
    private String password;

    @Column(name = "user_sta", insertable = false, columnDefinition = "integer default 0")
    private Integer status;

    @Column(name = "register_by", nullable = false)
    private String registerBy;

    public UsersVO(){}

    public UsersVO(String username, String account, String password) {
        this.username = username;
        this.account = account;
        this.password = password;
    }

    public UsersVO(String username, String account, String password, String registerBy) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.registerBy = registerBy;
    }

    // --- UserDetails interface methods ---


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.status == 0;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    // --- getter and setter ---

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRegisterBy() { return registerBy; }

    public void setRegisterBy(String registerBy) { this.registerBy = registerBy; }
}
