package com.etoak.execption;

import com.etoak.commons.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ParamException.class)
    public ModelAndView handleParamException(ParamException e){
       log.error(e.getMessage(),e);
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("error",e.getMessage());
       modelAndView.setViewName("error");
       return modelAndView;
   }
   @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public CommonResult handleUserLoginException(UserLoginException e){
        log.error(e.getMessage());
        return new CommonResult(CommonResult.FAILED_CODE,e.getMessage());
   }
}
