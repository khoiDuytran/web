package ttcs_project.FitnessWebsite.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import ttcs_project.FitnessWebsite.dto.request.UserCreationRequest;
import ttcs_project.FitnessWebsite.dto.request.UserUpdateRequest;
import ttcs_project.FitnessWebsite.dto.response.UserResponse;
import ttcs_project.FitnessWebsite.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    // @Mapping(source = "firstName", target = "lastName"): firstName == lastName
    // @Mapping(target = "lastName", ignore = true): lastName = null

    UserResponse toUserResponse(User user); // nối user với UserResponse

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
