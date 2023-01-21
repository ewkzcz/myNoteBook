package ewk.code19.controller;

import ewk.code19.data.Code;
import ewk.code19.data.Result;
import ewk.code19.exception.BusinessException;
import ewk.code19.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice  // Rest风格异常处理器
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)  // 拦截类型
    public Result doSystemException(SystemException ex) {
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    // 用户不正确使用导致的异常,提醒用户即可
    @ExceptionHandler(BusinessException.class)  // 拦截类型
    public Result doBusinessException(BusinessException ex) {
        return new Result(ex.getCode(), null, ex.getMessage());
    }

    // 未知异常
    @ExceptionHandler(Exception.class)  // 拦截类型
    public Result doException(Exception ex) {
        System.out.println(ex);
        return new Result(Code.SYSTEM_UNKNOWN_ERR, null, "系统繁忙,请稍后再试");
    }
}
