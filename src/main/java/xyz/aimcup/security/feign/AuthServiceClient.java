package xyz.aimcup.security.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import xyz.aimcup.generated.model.UserResponseDto;
import xyz.aimcup.security.domain.UserBase;

@FeignClient(name = "user-microservice", path = "/user/auth-service")
@Headers("Authorization: Bearer {token}")
public interface AuthServiceClient {

    @GetMapping("/me")
    ResponseEntity<UserResponseDto> user(@RequestHeader("Authorization") String token);
}
