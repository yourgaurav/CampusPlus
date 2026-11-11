package com.gauav.CampusPlus.dto;

import com.gauav.CampusPlus.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class DepartmentResponse {
    private Long id;
    private String name;
    private String description;

    public DepartmentResponse(){

    }

    public DepartmentResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
