package xyz.aimcup.security.domain;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Getter
@Setter
public class RoleBase implements GrantedAuthority {
    private UUID id;
    private RoleName name;

    public RoleBase() {

    }

    public RoleBase(UUID id, RoleName name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name.toString();
    }
}
