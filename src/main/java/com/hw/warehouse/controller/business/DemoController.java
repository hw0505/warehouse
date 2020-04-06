package com.hw.warehouse.controller.business;

import com.hw.warehouse.service.IDemoService;
import com.hw.warehouse.utils.GsonUtils;
import com.hw.warehouse.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 业务controller
 * @author liurl
 */
@RestController
@RequestMapping(value = "/business")
@Slf4j
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping(value = "/userList")
    public String getUserList() {
        List<UserVo> userList = demoService.getUserList();
        String res = GsonUtils.toJson(userList);
        log.info("响应报文{}", res);
        return res;
    }

    @GetMapping(value = "/table")
    public String getTableInfo() {
        String res = "{\n" +
                "    \"code\": 0,\n" +
                "    \"msg\": \"\",\n" +
                "    \"count\": 1000,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 10000,\n" +
                "            \"name\": \"user-0\",\n" +
                "            \"number\": \"女\",\n" +
                "            \"date\": \"城市-0\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        return res;
    }
}
