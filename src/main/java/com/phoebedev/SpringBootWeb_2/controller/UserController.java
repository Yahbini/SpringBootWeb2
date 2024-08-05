package com.phoebedev.SpringBootWeb_2.controller;

import com.phoebedev.SpringBootWeb_2.dto.request.UserRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping(value = "/addUser", headers = "apiKey=v1.0")
    public String addUser(@Valid @RequestBody UserRequestDto userDto) {
        return "User added successfully";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDto userDto) {
        System.out.println("Request update userID= " + userId);
        return "User updated successfully";
    }


    @PatchMapping("/{userId}")
    //required = false ko cần thiết nhập
    public String changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        System.out.println("Request change status userID= " + userId);
        return "User status changed successfully";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@Min(1) @PathVariable int userId) {
        System.out.println("Request delete userID= " + userId);
        return "User deleted successfully";
    }

    @GetMapping("/{userId}")
    public UserRequestDto getUser(@PathVariable int userId) {
        System.out.println("Request retrieve userID= " + userId);
        return new UserRequestDto("acc1", "acc", "a@gmail.com", "1234567890");
    }

    @GetMapping("listUser")
    public List<UserRequestDto> getAllUser(
            @RequestParam(required = false) String email, @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        System.out.println("Request retrieve all users");
        return List.of(
                new UserRequestDto("acc1", "acc", "a@gmail.com", "1234568901"),
                new UserRequestDto("acc2", "acc", "b@gmail.com", "1234567890"),
                new UserRequestDto("acc3", "acc", "c@gmail.com", "1234567890")
        );
    }
}
