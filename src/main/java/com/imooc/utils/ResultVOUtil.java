package com.imooc.utils;

import com.imooc.VO.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object){

        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(1);
        resultVO.setMsg("ok");

        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);

        return resultVO;
    }
}
