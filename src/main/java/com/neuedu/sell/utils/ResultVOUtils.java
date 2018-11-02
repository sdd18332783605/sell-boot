package com.neuedu.sell.utils;

import com.neuedu.sell.VO.ResultVO;

public class ResultVOUtils {

    /**
     * 发送成功
     * @param data
     * @return
     */
    public static ResultVO success(Object data){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(data);
        return resultVO;
    }

    /**
     * 发送数据为空
     * @return
     */
    public static ResultVO success(){
        return  success(null);
    }

    /**
     * 数据发送失败
     * @param code
     * @param message
     * @return
     */
    public static ResultVO error(Integer code,String message){

        ResultVO resultVO =new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return  resultVO;
    }


}
