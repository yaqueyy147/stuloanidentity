package com.stuidentity.web.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.stuidentity.web.mybatis.domain.Creditscore;
import com.stuidentity.web.mybatis.domain.Studentroll;
import com.stuidentity.web.mybatis.domain.inte.CreditscoreMapper;
import com.stuidentity.web.mybatis.domain.inte.StudentrollMapper;
import com.stuidentity.web.vo.ResultBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by suyx on 2018-04-21.
 * 学生信息认证
 */
@Controller
@RequestMapping(value = "/student/api/identity")
public class StudentIdentityController {

    @Autowired
    private StudentrollMapper studentrollMapper;
    @Autowired
    private CreditscoreMapper creditscoreMapper;

    @RequestMapping(value = "/stuidentity")
    @ResponseBody
    public ResultBase stuidentity(HttpServletRequest request, @RequestParam Map<String,Object> params){
        ResultBase resultBase = new ResultBase();
        resultBase.setSuccess(false);
        resultBase.setMessage("认证失败");

        Map<String,String> result = new HashMap<>();

        try {
            List<Studentroll> list = studentrollMapper.selectByParams(params);
            if(list != null && list.size() > 0){
                result.put("studentinfo", JSONObject.toJSONString(list.get(0)));
                resultBase.setResultmaps(result);
                resultBase.setSuccess(true);
                resultBase.setMessage("认证成功");
            }

        }catch (Exception e){
            e.printStackTrace();
            resultBase.setSuccess(false);
            resultBase.setMessage("认证失败");
        }

        return resultBase;
    }

    @RequestMapping(value = "/creditidentity")
    @ResponseBody
    public ResultBase creditidentity(HttpServletRequest request, @RequestParam Map<String,Object> params){
        ResultBase resultBase = new ResultBase();
        resultBase.setSuccess(false);
        resultBase.setMessage("认证失败");

        Map<String,String> result = new HashMap<>();

        try {

            List<Creditscore> list1 = creditscoreMapper.selectByParams(params);
            if(list1 != null && list1.size() > 0){
                result.put("creditscore",JSONObject.toJSONString(list1.get(0)));
            }
            resultBase.setResultmaps(result);
            resultBase.setSuccess(true);
            resultBase.setMessage("认证成功");
        }catch (Exception e){
            e.printStackTrace();
            resultBase.setSuccess(false);
            resultBase.setMessage("认证失败");
        }

        return resultBase;
    }

}
