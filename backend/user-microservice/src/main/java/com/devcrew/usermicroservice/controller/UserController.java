package com.devcrew.usermicroservice.controller;

import com.devcrew.usermicroservice.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.devcrew.usermicroservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Only admin can get all users
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/get-all")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    //Only admin can get the info of any user, and user can get his own info
    @PreAuthorize("hasRole('ROLE_ADMIN') or #username == authentication.principal.username")
    @GetMapping(path = "info/{username}")
    public UserDTO getUser(@PathVariable("username") String username) {
        return userService.getUserInfo(username);
    }

    //Only admin can delete any user, and user can delete his own account
    @PreAuthorize("hasRole('ROLE_ADMIN') or #username == authentication.principal.username")
    @DeleteMapping(path = "delete/{username}")
    public void deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
    }

    //Only admin can change the email of any user, and user can change his own email
    @PreAuthorize("hasRole('ROLE_ADMIN') or #username == authentication.principal.username")
    @PutMapping(path = "updateEmail/{username}")
    public void updateUserEmail(@PathVariable("username") String username,
                                @RequestParam() String email) {
        userService.updateUserEmail(username, email);
    }

    //Only admin can change the username of any user, and user can change his own username
    @PreAuthorize("hasRole('ROLE_ADMIN') or #username == authentication.principal.username")
    @PutMapping(path = "updateUsername/{username}")
    public void updateUserUsername(@PathVariable("username") String username,
                                   @RequestParam() String newUsername) {
        userService.updateUserUsername(username, newUsername);
    }

    //Only admin can change the password of any user, and user can change his own password
    @PreAuthorize("hasRole('ROLE_ADMIN') or #username == authentication.principal.username")
    @PutMapping(path = "changePassword/{username}")
    public void changePassword(@PathVariable("username") String username,
                               @RequestParam() String password) {
        userService.changeUserPassword(username, password);
    }

    //Only admin can change the role of any user
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "changeRole/{username}")
    public void changeRole(@PathVariable("username") String username,
                           @RequestParam() String role) {
        userService.changeUserRole(username, role);
    }
}