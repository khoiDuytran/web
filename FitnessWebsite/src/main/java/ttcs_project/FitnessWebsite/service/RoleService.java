package ttcs_project.FitnessWebsite.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import ttcs_project.FitnessWebsite.dto.request.RoleRequest;
import ttcs_project.FitnessWebsite.dto.response.RoleResponse;
import ttcs_project.FitnessWebsite.mapper.RoleMapper;
import ttcs_project.FitnessWebsite.repository.PermissionRepository;
import ttcs_project.FitnessWebsite.repository.RoleRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> findAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}

