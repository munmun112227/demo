package rota.users.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersVO, Integer> {
    /**
     * Finds a user by their account name.
     * @param account the account name to search for
     * @return an Optional containing the user if found, or empty if not
     */
    Optional<UsersVO> findByAccount(String account);
}
