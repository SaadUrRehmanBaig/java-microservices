package com.service.hotelservice.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelSaveDto {
    @NotBlank(message = "name can be blank")
    @Size(min = 3, message = "name must have atleast 3 characters")
    private String name;

    @NotBlank(message = "location can be blank")
    private String location;

    @NotBlank(message = "about can be blank")
    @Size(min = 10, message = "about must have atleast 10 characters")
    private String about;
}
