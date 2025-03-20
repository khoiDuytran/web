package ttcs_project.FitnessWebsite.mapper;

import org.mapstruct.Mapper;

import ttcs_project.FitnessWebsite.dto.request.PermissionRequest;
import ttcs_project.FitnessWebsite.dto.response.PermissionResponse;
import ttcs_project.FitnessWebsite.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}