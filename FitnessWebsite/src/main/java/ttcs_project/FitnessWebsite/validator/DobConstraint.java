package ttcs_project.FitnessWebsite.validator;

import java.lang.annotation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD}) // hướng sử dụng
@Retention(RetentionPolicy.RUNTIME) // khi nào sử dụng
@Constraint(validatedBy = {DobValidator.class})
public @interface DobConstraint {
    String message() default "{Invalid date of birth}";

    int min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {}; // 3 thuộc tính cơ bản của validation
}
