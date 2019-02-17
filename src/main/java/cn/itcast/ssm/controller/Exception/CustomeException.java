package cn.itcast.ssm.controller.Exception;

public  class CustomeException extends Exception{
    //异常信息
    public String message;

    public CustomeException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
