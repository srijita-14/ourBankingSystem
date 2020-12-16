package com.Areteans.ourBankingSystem.services;
import com.Areteans.ourBankingSystem.Repository.UserRepo;
import com.Areteans.ourBankingSystem.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class userService {
    private final UserRepo userRepository;
    private final JdbcTemplate jdbcTemplateofUser;
    private final JdbcTemplate getJdbcTemplateofUser;
    public Map<String, Object> save(Map<String, Object> Users) {
        Map<String, Object> uMap = jdbcTemplateofUser.queryForMap("insert into Accounts(balance,account_no,name,address,contact) values(?,?,?,?,?) RETURNING user_id",
                //Long.parseLong((String) Users.get("user_id"),
                Long.parseLong((String) Users.get("balance")),
                Long.parseLong((String) Users.get("account_no")),
                Users.get("name"),
                Users.get("address"),
                Long.parseLong((String) Users.get("contact")));

        Users.put("user_id", uMap.get("user_id"));
        return Users;
    }
    public Map<String,Object> updateUser (Map<String,Object> Users){
        getJdbcTemplateofUser.update("update Accounts set balance=?,name=?,address=?,contact=? where user_id = ?",

                Long.parseLong((String) Users.get("balance")),
                Users.get("name"),
                Users.get("address"),
                Long.parseLong((String) Users.get("contact")),
                Long.parseLong((String) Users.get("user_id")));

        return Users;
    }

//    public void deleteUserByID(Long id) {
//        userRepository.deleteById(id);
//    }
         public void CancelUser(Long user_id) {
           getJdbcTemplateofUser.update("Delete from Accounts where user_id=?;", user_id);
           }

           public Map<String, Object> UserDetails(Long user_id) {
        return getJdbcTemplateofUser.queryForMap("select * from Accounts where user_id=?", user_id);

           }
//    public User getUserByID(Long id) {
//        Optional<User> user =userRepository.findById(id);
//        if (user.isPresent()) {
//            return user.get();
//        }
//        return null;
//    }
}
