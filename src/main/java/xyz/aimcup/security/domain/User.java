package xyz.aimcup.security.domain;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Setter(AccessLevel.NONE)
    private Long id;
    private String username;
    private Long osuId;
    private Boolean isRestricted;
    private Set<Role> roles = new HashSet<>();
}
