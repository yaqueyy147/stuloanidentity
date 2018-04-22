package com.stuidentity.web.controller.api;

import com.stuidentity.web.mybatis.domain.Studentroll;
import com.stuidentity.web.mybatis.domain.inte.StudentrollMapper;
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

    @RequestMapping(value = "stuidentity")
    @ResponseBody
    public Object stuidentity(HttpServletRequest request, @RequestParam Map<String,Object> params){
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("message","认证失败");

        List<Studentroll> list = studentrollMapper.selectByParams(params);
        if(list != null && list.size() > 0){
            result.put("stuinfo",list.get(0));
            result.put("code",1);
            result.put("message","认证成功");
        }
        return result;
    }

}
