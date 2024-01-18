

// Java Program to Illustrate DepartmentRepository File

// Importing package module to this code
package com.crud.crudoperation.repository;
// Importing required classes
        import com.crud.crudoperation.entity.Department;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

        import java.util.List;


@Repository


public interface DepartmentRepository
        extends JpaRepository<Department, Long>
{
        @Query(value = "SELECT * FROM department WHERE is_deleted = true", nativeQuery = true)
        List<Department> findDepartmentsByChecker(@Param("checkerValue") Boolean checker);

}


