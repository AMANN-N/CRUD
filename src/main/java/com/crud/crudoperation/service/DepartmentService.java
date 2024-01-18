


package com.crud.crudoperation.service;
        import com.crud.crudoperation.entity.Department;
        import java.util.List;


public interface DepartmentService {


    Department saveDepartment(Department department);


    List<Department> fetchDepartmentList(Boolean checker);
    //List<Department> fetchDepartmentList();

    Department updateDepartment(Department department,
                                Long departmentId);


    void deleteDepartmentById(Long departmentId);
}

