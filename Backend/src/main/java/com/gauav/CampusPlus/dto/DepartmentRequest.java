package com.gauav.CampusPlus.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

// it creates the getters and setters
@Data
public class DepartmentRequest {
    @NotBlank(message = "Department name is required")
    @Size(min = 3, max = 100,
            message="Department name must be between 3 and 100 characters")
    private String name;

    @Size(max = 255,
         message="Description cannot exceed 255 characters")
    private String description;

    public DepartmentRequest(){

    }


}
