package xyz.aimcup.security.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import xyz.aimcup.security.dto.UserResponseDto;

@FeignClient(name = "user-microservice", path = "/user")
@Headers("Authorization: Bearer {token}")
public interface AuthServiceClient {

    @GetMapping("/me")
    ResponseEntity<UserResponseDto> me(@RequestHeader("Authorization") String token);
}
