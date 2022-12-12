package soloproject.exception;

import lombok.Getter;

public class BusinessLogicException {
    @Getter
    private ExceptionCode exceptionCode;

    public BusinessLogicException(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
