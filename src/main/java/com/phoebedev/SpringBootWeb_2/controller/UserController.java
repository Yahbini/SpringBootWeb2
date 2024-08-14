package com.phoebedev.SpringBootWeb_2.controller;

import com.phoebedev.SpringBootWeb_2.configuration.Translator;
import com.phoebedev.SpringBootWeb_2.dto.request.UserRequestDto;
import com.phoebedev.SpringBootWeb_2.dto.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User Controller")
public class UserController {

    @Operation(summary = "Add user", description = "Api Create new user")
    @PostMapping(value = "/addUser", headers = "apiKey=v1.0")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDto userDto) {
        return new ResponseData<>(HttpStatus.CREATED.value(), Translator.toLocale("user.add.success"), 1);
    }

    @Operation(summary = "Update user", description = "Api Update new user")
    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@Min(1) @PathVariable int userId, @RequestBody UserRequestDto userDto) {
        System.out.println("Request update userID= " + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), Translator.toLocale("user.upd.success"),"User updated successfully");
    }

    @Operation(summary = "Patch status", description = "Api Patch status")
    @PatchMapping("/{userId}")
    //required = false ko cần thiết nhập
    public ResponseData<?> changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        System.out.println("Request change status userID= " + userId);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), Translator.toLocale("user.add.success"),1);
    }

    @Operation(summary = "Delete user", description = "Api Delete new user")
    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@Min(1) @PathVariable int userId) {
        System.out.println("Request delete userID= " + userId);
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted successfully");
    }

    @Operation(summary = "Get a user", description = "Api Get a user")
    @GetMapping("/{userId}")
    public ResponseData<UserRequestDto> getUser(@PathVariable int userId) {
        System.out.println("Request retrieve userID= " + userId);
        return new ResponseData<>(HttpStatus.OK.value(), "Get user", new UserRequestDto("acc1", "acc", "a@gmail.com",
                "1234567890"));
    }

    @Operation(summary = "List user", description = "Api List all user")
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
