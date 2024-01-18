package com.crud.crudoperation.service;

        import com.crud.crudoperation.entity.Department;
        import com.crud.crudoperation.repository.DepartmentRepository;
        import java.time.Instant;
        import java.util.List;
        import java.util.Objects;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;


@Service        //@Service is for business layer , where you define business functionalities


public class DepartmentServiceImpl
        implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override                                                                                                                   //@Override annotation informs the compiler that the element is meant to override an element declared in a superclass.
    public Department saveDepartment(Department department)
    {
        return departmentRepository.save(department);
    }


    @Override public List<Department> fetchDepartmentList(Boolean checker)
    {
        if (checker != null && checker)
        {
            return departmentRepository.findDepartmentsByChecker(checker);
        }
        else
        {
            return departmentRepository.findAll();
        }

        //         return (List<Department>)
        //        departmentRepository.findAll();
    }



//    @Override
//    public List<Department> fetchDepartmentList(Boolean checker) {
//        if (checker != null && checker) {
//            return departmentRepository.findDepartmentsByChecker(checker);
//        } else {
//            return departmentRepository.findAll();
//        }
//    }


    @Override
    public Department
    updateDepartment(Department department,
                     Long departmentId)
    {
        Department depDB
                = departmentRepository.findById(departmentId)
                .get();

        if (Objects.nonNull(department.getDepartmentName())
                && !"".equalsIgnoreCase(
                department.getDepartmentName())) {
            depDB.setDepartmentName(
                    department.getDepartmentName());
        }

        if (Objects.nonNull(
                department.getDepartmentAddress())
                && !"".equalsIgnoreCase(
                department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(
                    department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(
                department.getDepartmentCode())) {
            depDB.setDepartmentCode(
                    department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }


    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        Department depDB
                = departmentRepository.findById(departmentId).get();

        depDB.setDeleted(true);

        Instant instant = Instant.now();
        //use current time in milis

        depDB.setTimeStamp(instant.toString());
        departmentRepository.save(depDB);


        //departmentRepository.deleteById(departmentId);

    }
}
