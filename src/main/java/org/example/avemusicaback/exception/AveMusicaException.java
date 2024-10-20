package org.example.avemusicaback.exception;

public class AveMusicaException extends RuntimeException{

    public AveMusicaException(String message){
        super(message);
    }
    public static AveMusicaException userAlreadyExists(){
        return new AveMusicaException("用户已经存在!");
    }

    public static AveMusicaException notLogin(){
        return new AveMusicaException("未登录!");
    }
    public static AveMusicaException UserNotExist(){
        return new AveMusicaException("用户不存在！");
    }

    public static AveMusicaException usernameOrPasswordError(){
        return new AveMusicaException("用户名或密码错误!");
    }


}
