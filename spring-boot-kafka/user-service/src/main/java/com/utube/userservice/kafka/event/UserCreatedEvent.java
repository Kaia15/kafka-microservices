package com.utube.userservice.kafka.event;

// import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.Getter;
// import lombok.Setter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserCreatedEvent {
    private String message;
    private String status;
    private Long userId;
    private String userEmail;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }
}
