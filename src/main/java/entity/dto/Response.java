package entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private ResponseStatus status;

    private T data;

    private String msg;

    public static <T> Response<T> success(T data){
        return new Response<>(ResponseStatus.SUCCESS, data, "");
    }

    public static <T> Response<T> error(T data){
        return new Response<>(ResponseStatus.ERROR, data, "");
    }

    public static <T> Response<T> refuse(T data){
        return new Response<>(ResponseStatus.REFUSE, data, "");
    }

    public static <T> Response<T> success(T data, String msg){
        return new Response<>(ResponseStatus.SUCCESS, data, msg);
    }

    public static <T> Response<T> error(T data, String msg){
        return new Response<>(ResponseStatus.ERROR, data, msg);
    }

    public static <T> Response<T> refuse(T data, String msg){
        return new Response<>(ResponseStatus.REFUSE, data, msg);
    }

}
