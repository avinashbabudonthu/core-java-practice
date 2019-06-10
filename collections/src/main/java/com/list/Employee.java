package com.list;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {

    private String name;
    private LocalDate joiningDate;
    private String gender;
}
