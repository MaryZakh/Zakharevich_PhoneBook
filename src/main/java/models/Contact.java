package models;

import lombok.*;


@Getter
@Setter
@ToString
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Contact {

    private String name;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private String description;
}
