package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;

    @NotBlank
    @Size(min = 5, max = 45,message = "Tên Phải Có Kí Tự Từ 5-45 Kí Tự")
    private String firstName;

    @NotBlank
    @Size(min = 5, max = 45,message = "Tên Phải Có Kí Tự Từ 5-45 Kí Tự")
    private String lastName;

    @NotBlank
    @Pattern(regexp = "[0][9][0-9]{8}",message = "Number phải 09********  * là số từ 0-9")
    private String phoneNumber ;

    @NotBlank
    @Min(value = 18,message = "Tuổi Phải Lớn Hơn 18")
    private String age;

//    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]{2,}(\\.[A-Za-z0-9]{2,}){1,2}$",
//            message = "Email phải đúng định dạng")
    @Email()
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
      UserDto userDto = (UserDto) target;
      if("admin@gmail.com".equals(userDto.getEmail())){
          errors.rejectValue("email","","Không Được Dùng Admin");
      }
    }
}
