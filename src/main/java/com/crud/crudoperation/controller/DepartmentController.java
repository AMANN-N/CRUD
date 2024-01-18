



package com.crud.crudoperation.controller;

        import com.crud.crudoperation.entity.Department;
        import com.crud.crudoperation.service.DepartmentService;
        import java.util.List;
        import jakarta.validation.Valid;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;


@RestController                                                                         //Controller is used to declare common web controllers which can return HTTP response but @RestController is used to create controllers for REST APIs which can return JSON


public class DepartmentController {


    @Autowired private DepartmentService departmentService;                            //Spring @Autowired annotation is used for automatic dependency injection.


    @PostMapping("/insertNewDepartment")
    public Department saveDepartment(
            @Valid @RequestBody Department department)                                              //@Valid = tells that the parameters must be validated
    {                                                                                                   //RequestBody = extract http body data
        return departmentService.saveDepartment(department);
    }


//    @GetMapping("/displayAllDepartments/{check}")
//    public List<Department> fetchDepartmentList(@PathVariable("check") Boolean checker)
//    {
//        return departmentService.fetchDepartmentList(checker);
//    }



    @GetMapping("/displayAllDepartments")
    public List<Department> fetchDepartmentList(@RequestParam(name = "check", defaultValue = "false") Boolean checker) {
        if (checker == null) {
            checker = false; // Default value if not provided in the URL
        }
        return departmentService.fetchDepartmentList(checker);
    }






    @PutMapping("/updateDepartment/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(
                department, departmentId);
    }


    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartmentById(@PathVariable("id")              //@PathVariable = to get path variable mentioned
                                       Long departmentId)
    {
        departmentService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }
}
