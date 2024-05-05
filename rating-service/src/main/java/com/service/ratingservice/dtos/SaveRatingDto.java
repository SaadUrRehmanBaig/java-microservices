package com.service.ratingservice.dtos;

import org.hibernate.validator.constraints.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class SaveRatingDto {
    @NotBlank
    @UUID
    private String hotelId;

    @NotBlank
    @UUID
    private String userId;

    @Max(5)
    @Min(0)
    private int stars;

    private String feedback;
}
