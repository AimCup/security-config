package xyz.aimcup.security.mapper;

import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import xyz.aimcup.security.domain.Role;
import xyz.aimcup.security.domain.User;
import xyz.aimcup.security.dto.RoleResponseDto;
import xyz.aimcup.security.dto.UserResponseDto;

@Mapper(componentModel = "spring")
public interface ResponseUserMapper {
    User mapUserResponseDtoToUser(UserResponseDto userResponseDto);

    Role mapRoleResponseToRole(RoleResponseDto userBase);
    Role mapRoleResponseToRole(Object userBase);
    Set<Role> mapRoles(List<Object> objectList);

}
