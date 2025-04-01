package com.testapi.testapi.specifications;
import org.springframework.data.jpa.domain.Specification;
import com.testapi.testapi.models.User;
import org.springframework.util.StringUtils;
import jakarta.persistence.criteria.*;


public class UserSpecifications {

    public static Specification<User> hasEmailLike(String email) {
        return (root, query, criteriaBuilder) -> {
            if(StringUtils.hasText(email)) {
              //  return criteriaBuilder.like(root.get("email"), "ivan");
                return criteriaBuilder.like(root.get("email"), "%" + email + "%");
            }
            return  criteriaBuilder.conjunction();
        };

    }
    public static Specification<User> hasId(Long id) {
        return (root, query, criteriaBuilder) -> {
            if (id == null) {
                return criteriaBuilder.conjunction(); // Si el ID es null, no filtrar
            }
            return criteriaBuilder.equal(root.get("id"), id); // WHERE id = :id
        };
    }
    public static Specification<User> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (!StringUtils.hasText(name)) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("name"), name);
        };
    }
}
