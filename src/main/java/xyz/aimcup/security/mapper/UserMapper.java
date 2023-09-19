package xyz.aimcup.security.mapper;

import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import xyz.aimcup.generated.model.RoleResponseDto;
import xyz.aimcup.generated.model.UserResponseDto;
import xyz.aimcup.security.domain.RoleBase;
import xyz.aimcup.security.domain.UserBase;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserBase mapUserResponseDtoToUser(UserResponseDto userResponseDto);

    RoleBase mapRoleResponseToRole(RoleResponseDto userBase);
    RoleBase mapRoleResponseToRole(Object userBase);
    Set<RoleBase> mapRoles(List<Object> objectList);

}
