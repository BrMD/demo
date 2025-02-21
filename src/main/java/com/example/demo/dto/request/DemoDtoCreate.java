package com.example.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DemoDtoCreate {
    @NotNull(message = "Login Cannot be null")
    @Size(min = 1,max = 200, message = "Login must be between 1 and 200 characteres")
    String login;

    @NotNull(message = "Password Cannot be null")
    @Size(min = 1,max = 200, message = "Password must be between 1 and 200 characteres")
    String password;
}
