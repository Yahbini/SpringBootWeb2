package com.phoebedev.SpringBootWeb_2.controller;

import com.phoebedev.SpringBootWeb_2.dto.request.UserRequestDto;
import com.phoebedev.SpringBootWeb_2.dto.response.ResponseData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @PostMapping(value = "/addUser", headers = "apiKey=v1.0")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDto userDto) {
        return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);
    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@Min(1) @PathVariable int userId, @RequestBody UserRequestDto userDto) {
        System.out.println("Request update userID= " + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }


    @PatchMapping("/{userId}")
    //required = false ko cần thiết nhập
    public ResponseData<?> changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        System.out.println("Request change status userID= " + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User status changed successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@Min(1) @PathVariable int userId) {
        System.out.println("Request delete userID= " + userId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted successfully");
    }

    @GetMapping("/{userId}")
    public ResponseData<UserRequestDto> getUser(@PathVariable int userId) {
        System.out.println("Request retrieve userID= " + userId);
        return new ResponseData<>(HttpStatus.OK.value(), "Get user", new UserRequestDto("acc1", "acc", "a@gmail.com",
                "1234567890"));
    }

    @GetMapping("/listUser")
    public ResponseData<List<UserRequestDto>> getAllUser(@Valid
            @RequestParam(required = false) String email, @RequestParam(defaultValue = "0") int pageNo,
            @Max(10) @RequestParam(defaultValue = "10") int pageSize) {
        System.out.println("Request retrieve all users");
        return new ResponseData<>(HttpStatus.OK.value(), "Get user", List.of(
                new UserRequestDto("acc1", "acc", "a@gmail.com", "1234568901"),
                new UserRequestDto("acc2", "acc", "b@gmail.com", "1234567890"),
                new UserRequestDto("acc3", "acc", "c@gmail.com", "1234567890")
        ));
    }
}
