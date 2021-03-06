package commons;

/**
 * Created by liuhao on 17/7/26.
 * <p>
 * 系统异常错误码定义：采用9为数字格式，前三位为系统编码，中间三位为模块编码，后三位为错误编码。
 * 1)	前三位：中旅总社后台系统编码为：100，手机银行后台系统编码为200。
 * 2)	中间三位：各系统自行定义，从001开始。如：用户模块001，订单模块002。
 * 3)  后三位：各系统自行定义，从001开始。如：用户密码不正确001。
 * 例子：如果中间三位001代表用户模块，后三位001代表用户密码不正确，那么异常编码为100001001
 */
public enum CodeMessage {
    // 例子
    SUCCESS("100000000", "成功"),
    FAILED("100000001", "失败"),
    /*******************************************************************/
    /***********************  总社-系统异常100000XXX  ********************/
    /*******************************************************************/
    SYSTEM_BUSY("100000001", "系统繁忙,请稍后重试"),
    PARAMS_ERR("100000002", "请求参数异常"),
    SYSTEM_NOT_FOUND("100000003", "没有找到资源,请稍后重试"),
    SYSTEM_SYNTAX_ERROR("100000004", "参数语法错误,请稍后重试"),
    SYSTEM_ERR("100000005", "后台服务器错误,请稍后重试"),//主要针对数据库连接超时的时候定义的异常,为了出现错误的时候看错误码就能够知道数据库挂掉了
    SMS_SEND_ERR("100000006", "验证码一天只能发送三条"),
    SMS_SEND_INTERSACE_ERR("100000007", "验证码接口调用错误"),
    STUDENT_TEST_ERR("100000008","没有学生信息");

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

//    public String getMsg(String code) {
//
//    }

    CodeMessage(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "CodeMessage{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static CodeMessage getCodeMessage(String code) {
        for (CodeMessage codeMessage : CodeMessage.values()) {
            if (codeMessage.getCode().equals(code)) {
                return codeMessage;
            }
        }
        return null;
    }


}
