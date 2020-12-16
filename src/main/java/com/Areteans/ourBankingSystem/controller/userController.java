package com.Areteans.ourBankingSystem.controller;
import com.Areteans.ourBankingSystem.models.User;
import com.Areteans.ourBankingSystem.services.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user")
public class userController {
 private final userService userService;
    @CrossOrigin
    @PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> createDetails(@RequestBody Map<String, Object> user) {
        return userService.save(user);
    }
    @PutMapping(path = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> updateDetails(@RequestBody Map<String, Object> users){
        return userService.updateUser(users);
    }
//    @DeleteMapping(value = "delete/{user_id}")
//    public void deleteUserData(@PathVariable("user_id") Long user_id) {
//        userService.deleteUserByID(user_id);
//    }
    @DeleteMapping(value = "delete/{user_id}")
           public void CancellationOfUser(@PathVariable("user_id") Long user_id) {
               userService.CancelUser(user_id);
    }
    @CrossOrigin
    @GetMapping(path = "details")
    public Map<String, Object> GetUserDetails(@RequestParam(value = "user_id") Long user_id) {
        return this.userService.UserDetails(user_id);
    }
}
