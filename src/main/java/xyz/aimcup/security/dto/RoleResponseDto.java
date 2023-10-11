package xyz.aimcup.security.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RoleResponseDto {
    private UUID id;

    private String name;

}
