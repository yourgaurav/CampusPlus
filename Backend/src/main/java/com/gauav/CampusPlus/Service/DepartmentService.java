
package com.gauav.CampusPlus.Service;

import com.gauav.CampusPlus.dto.DepartmentRequest;
import com.gauav.CampusPlus.dto.DepartmentResponse;
import com.gauav.CampusPlus.entity.Department;
import com.gauav.CampusPlus.exception.DepartmentNotFoundException;
import com.gauav.CampusPlus.exception.DuplicateDepartmentException;
import com.gauav.CampusPlus.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    // Constructor injection
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // to creating the table
    @Transactional
    public DepartmentResponse createDepartment(DepartmentRequest request) {

        if(departmentRepository.existsByName(request.getName())){
            throw new DuplicateDepartmentException("Department already exists with name:"
                    + request.getName());
        }


        Department department = new Department();
        department.setName(request.getName());
        department.setDescription(request.getDescription());

        Department savedDepartment = departmentRepository.save(department);
        return new DepartmentResponse(
                savedDepartment.getId(),
                savedDepartment.getName(),
                savedDepartment.getDescription()
        );

    }

    // to fetch the all the departments

    public List<DepartmentResponse> getAllDepartments() {

        List<Department> departments = departmentRepository.findAll();
         return departments.stream()
                 .map(department -> new DepartmentResponse(
                      department.getId(),
                      department.getName(),
                      department.getDescription()
                 )).toList();
    }

    //  to fetch by id
    public DepartmentResponse getDepartmentById(Long id){

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                                   new DepartmentNotFoundException("Department with id: " + id + " not found"));
        return new DepartmentResponse(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }

    // to update the department
    @Transactional
    public DepartmentResponse updateDepartment(Long id,DepartmentRequest request){

        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(()->new DepartmentNotFoundException("Department not found" + id));

        if(departmentRepository.existsByNameAndIdNot(request.getName(),id)){
            throw new DuplicateDepartmentException(
                    "Department already exists with name:" + request.getName()
            );
        }


        existingDepartment.setName(request.getName());
        existingDepartment.setDescription(request.getDescription());


        return new DepartmentResponse(
                existingDepartment.getId(),
                existingDepartment.getName(),
                existingDepartment.getDescription()
        );


    }

    // to delete the department by id
    @Transactional
    public void deleteDepartment(Long id){
        if(!departmentRepository.existsById(id)){
            throw new DepartmentNotFoundException("Department not found" + id);
        }
        departmentRepository.deleteById(id);

    }





}
