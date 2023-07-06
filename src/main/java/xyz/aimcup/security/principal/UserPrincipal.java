package xyz.aimcup.security.principal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.aimcup.security.domain.User;

import java.util.Collection;
import java.util.Map;

@Builder
@Getter
@Setter
public class UserPrincipal implements UserDetails {

    private String username;
    private Long osuId;

    private Boolean active;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public static UserPrincipal create(User user) {
        return UserPrincipal.builder()
                .username(user.getUsername())
                .osuId(user.getOsuId())
                .active(!user.getIsRestricted())
                .authorities(user.getRoles())
                .build();
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
}