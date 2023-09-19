package xyz.aimcup.security.domain;

import java.util.UUID;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserBase {
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String username;
    private Long osuId;
    private Boolean isRestricted;
    private Set<RoleBase> roles = new HashSet<>();
}
