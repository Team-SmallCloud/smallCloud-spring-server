package cap.stone.team.smallCloud.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDataInvalidException extends RuntimeException {
    public UserDataInvalidException(String message) {
        super(message);
    }
}