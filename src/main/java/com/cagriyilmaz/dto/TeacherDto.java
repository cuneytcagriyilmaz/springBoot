package com.cagriyilmaz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;

    @NotEmpty(message = "Ad soyad alanı boş geçilemez")
    @Size(min = 1, max = 255)
    private String teacherNameSurname;

    @NotEmpty(message = "Email alanı boş geçilemez")
    @Email(message = "Uygun Formatta Mail Giriniz")
    private String teacherEmail;

    @NotEmpty(message = "Şifreyi alanı boş geçilemez")
    @Min(value=18, message="Minimum 18 yaş")
    @Max(value=50, message="Maksimum 50 yaş")
    private String teacherPassword;
}
