package ttcs_project.FitnessWebsite.service;

import java.util.HashSet;
import java.util.List;

import ttcs_project.FitnessWebsite.entity.Role;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ttcs_project.FitnessWebsite.constant.PredefinedRole;
import ttcs_project.FitnessWebsite.dto.request.UserCreationRequest;
import ttcs_project.FitnessWebsite.dto.request.UserUpdateRequest;
import ttcs_project.FitnessWebsite.dto.response.UserResponse;
import ttcs_project.FitnessWebsite.entity.User;
import ttcs_project.FitnessWebsite.exception.AppException;
import ttcs_project.FitnessWebsite.exception.ErrorCode;
import ttcs_project.FitnessWebsite.mapper.UserMapper;
import ttcs_project.FitnessWebsite.repository.RoleRepository;
import ttcs_project.FitnessWebsite.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService { // Có constructor và các biến là private final
    UserRepository userRepository;
    RoleRepository roleRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest request) {
        User user = userMapper.toUser(request); // yêu cầu tạo tài khoản
        // Xử lý ngoại lệ
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Mã hóa Password

        HashSet<Role> roles = new HashSet<>();
        roleRepository.findById(PredefinedRole.USER_ROLE).ifPresent(roles::add);

        user.setRoles(roles);

        try{
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new AppException(ErrorCode.USER_EXITSTED);
        }

        return userMapper.toUserResponse(user);
    }

    public UserResponse updateUser(String userID, UserUpdateRequest request) {
        User user = userRepository.findById(userID).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);
        user.setPassword(passwordEncoder.encode(request.getPassword())); // mã hóa

        var roles = roleRepository.findAllById(request.getRoles());
        user.setRoles(new HashSet<>(roles));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        return userMapper.toUserResponse(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    // @PreAuthorize("hasAuthority('DO_EVERYTHING')")
    public List<UserResponse> getAllUsers() {
        log.info("In method get Users");
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(
                userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
    }
}

