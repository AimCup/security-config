package xyz.aimcup.security.dto;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserResponseDto {
    private UUID id;

    private String username;

    private Integer osuId;

    private Boolean isRestricted;

    @Valid
    private List<Object> roles;
}
