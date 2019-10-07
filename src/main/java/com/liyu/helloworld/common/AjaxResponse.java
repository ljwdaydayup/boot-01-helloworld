package com.liyu.helloworld.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Levi
 * @date 2019/9/18 9:39
 */
@Data
@ApiModel
public class AjaxResponse {
    @ApiModelProperty("请求是否处理成功")
    private boolean isok;   //请求是否处理成功
    @ApiModelProperty("请求响应状态码（200、400、500）")
    private int code;          //请求响应状态码（200、400、500）
    private String message;  //请求结果描述信息
    private Object data;  //请求结果数据

    private AjaxResponse() {

    }

    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }

}
