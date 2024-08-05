package com.phoebedev.SpringBootWeb_2.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.phoebedev.SpringBootWeb_2.util.PhoneNumber;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


// dùng Serializable để khi nó có 1 qtr sẽ chuyển đổi từ JSON sang nhị phân và ngược lại
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto implements Serializable {
    @NotBlank(message = "firstname must be not blank")
    private String firstName;
    @NotNull(message = "lastname must be not blank")
    private String lastName;
    @Email(message = "email invalid format")
    private String email;
//    @Pattern(regexp = "^\\d{10}$", message= "phone invalid format")
    @PhoneNumber
    private String phone;
    @NotNull(message = "DOB must be not null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dob;
    @NotEmpty
    List<String> permission;

    public UserRequestDto(String acc1, String acc, String mail, String number) {
    }
}
