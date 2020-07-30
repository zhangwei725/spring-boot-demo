package com.smart.example.exception;

import com.smart.example.domain.resp.ErrorStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndPasswordException extends RuntimeException {
    private String msg;
    private int status;
    public UserAndPasswordException(ErrorStatus errorStatus) {
        this.status = errorStatus.getStatus();
        this.msg = errorStatus.getMsg();
    }

}
