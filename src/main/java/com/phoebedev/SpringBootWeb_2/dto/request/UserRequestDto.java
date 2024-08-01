package com.phoebedev.SpringBootWeb_2.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// dùng Serializable để khi nó có 1 qtr sẽ chuyển đổi từ JSON sang nhị phân và ngược lại
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

}
