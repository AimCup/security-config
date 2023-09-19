package xyz.aimcup.security.mapper;

import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import xyz.aimcup.generated.model.RoleResponseDto;
import xyz.aimcup.generated.model.UserResponseDto;
import xyz.aimcup.security.domain.Role;
import xyz.aimcup.security.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapUserResponseDtoToUser(UserResponseDto userResponseDto);

    Role mapRoleResponseToRole(RoleResponseDto userBase);
    Role mapRoleResponseToRole(Object userBase);
    Set<Role> mapRoles(List<Object> objectList);

}
