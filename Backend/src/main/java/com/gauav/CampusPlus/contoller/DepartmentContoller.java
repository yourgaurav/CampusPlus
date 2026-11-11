
package com.gauav.CampusPlus.contoller;

import com.gauav.CampusPlus.Service.DepartmentService;
import com.gauav.CampusPlus.dto.DepartmentRequest;
import com.gauav.CampusPlus.dto.DepartmentResponse;
import com.gauav.CampusPlus.entity.Department;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentContoller {

    private final DepartmentService departmentService;

    // Constructor injection
    public DepartmentContoller(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Get all departments
    @GetMapping
    public List<DepartmentResponse> getDepartments() {
        return departmentService.getAllDepartments();
    }

    // Create department
    @PostMapping
    public DepartmentResponse addDepartment( @Valid @RequestBody DepartmentRequest request) {
        return departmentService.createDepartment(request);
    }

    // Get department by ID
    @GetMapping("/{id}")
    public DepartmentResponse getDepartment(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);

    }

    // Update department
    @PutMapping("/{id}")
    public DepartmentResponse updateDepartment(
            @PathVariable Long id,
            @RequestBody DepartmentRequest request) {
        return departmentService.updateDepartment(id, request);
    }

    // Delete department
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
