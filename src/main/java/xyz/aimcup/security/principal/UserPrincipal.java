package xyz.aimcup.security.principal;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import xyz.aimcup.security.domain.User;

import java.util.Collection;
import java.util.Map;

@Builder
@Getter
@Setter
public class UserPrincipal implements UserDetails, OAuth2User {

    private UUID id;
    private String username;
    private Long osuId;

    private Boolean active;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public static UserPrincipal create(User userBase) {
        return UserPrincipal.builder()
            .id(userBase.getId())
            .username(userBase.getUsername())
            .osuId(userBase.getOsuId())
            .active(!userBase.getIsRestricted())
            .authorities(userBase.getRoles())
            .build();
    }

    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return this.username;
    }
}
