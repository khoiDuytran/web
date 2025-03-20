package ttcs_project.FitnessWebsite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ttcs_project.FitnessWebsite.dto.request.PermissionRequest;
import ttcs_project.FitnessWebsite.dto.response.PermissionResponse;
import ttcs_project.FitnessWebsite.entity.Permission;
import ttcs_project.FitnessWebsite.mapper.PermissionMapper;
import ttcs_project.FitnessWebsite.repository.PermissionRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> findAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}

