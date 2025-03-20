package ttcs_project.FitnessWebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ttcs_project.FitnessWebsite.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
