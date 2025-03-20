package ttcs_project.FitnessWebsite.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ttcs_project.FitnessWebsite.dto.request.RoleRequest;
import ttcs_project.FitnessWebsite.dto.response.RoleResponse;
import ttcs_project.FitnessWebsite.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request); // do Set ở RoleRequest là String

    RoleResponse toRoleResponse(Role role);
}
