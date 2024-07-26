package com.books.bookApp.controller.dto;


import java.time.LocalDate;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String title;
    private String author;
    private String Gender;
    private LocalDate yearPublication;

}
