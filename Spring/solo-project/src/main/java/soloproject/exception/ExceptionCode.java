package soloproject.exception;

import lombok.Getter;

public enum ExceptionCode {
    TODOS_NOT_FOUND(404, "Todos not found"),
    TODOS_EXISTS(409,"Todos exists"),
    CANNOT_CHANGE(403, "Can not change"),
    NOT_IMPLEMENTATION(501, "Not Implementation"),;

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message){
        this.status = code;
        this.message = message;
    }
}
