package cap.stone.team.smallCloud.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyUserDataException extends RuntimeException {
    public EmptyUserDataException(String message) {
        super(message);
    }
}
