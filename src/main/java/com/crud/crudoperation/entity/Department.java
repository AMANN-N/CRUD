
package com.crud.crudoperation.entity;


        import jakarta.persistence.Entity;
        import jakarta.persistence.GeneratedValue;
        import jakarta.persistence.GenerationType;
        import jakarta.persistence.Id;
        import lombok.AllArgsConstructor;
        import lombok.Builder;
        import lombok.Data;
        import lombok.NoArgsConstructor;

        import jakarta.persistence.Entity;
        import jakarta.persistence.GeneratedValue;
        import jakarta.persistence.GenerationType;
        import jakarta.persistence.Id;
        import org.hibernate.annotations.Where;


@Entity    //help in mapping objects to DB
@Data       //to use get,set,construct,to_string
@NoArgsConstructor      //to generate constructor with no param
@AllArgsConstructor     // generate constructor with all param
@Builder                //The @Builder annotation in Spring Boot simplifies object creation and improves code readability

// Class

@Where(clause = "is_deleted=false")

public class Department {

    @Id         //primary key
    @GeneratedValue(strategy = GenerationType.AUTO)         //generate value automatically
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
    private Boolean isDeleted = false;


    private String timeStamp = "Not deleted yet";

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }


}
