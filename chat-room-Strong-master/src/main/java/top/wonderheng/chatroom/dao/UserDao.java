package top.wonderheng.chatroom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.wonderheng.chatroom.vo.User;

import java.util.List;


@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);

    List<User> findByUsername(String username);
}
