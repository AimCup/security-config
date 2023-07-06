package xyz.aimcup.security.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Getter
@Setter
public class Role implements GrantedAuthority {
    private Long id;
    private RoleName name;

    public Role() {

    }

    public Role(Long id, RoleName name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return this.name.toString();
    }
}
