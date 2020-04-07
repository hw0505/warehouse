package com.hw.warehouse.controller.business;

import com.hw.warehouse.service.IDemoService;
import com.hw.warehouse.utils.GsonUtils;
import com.hw.warehouse.vo.InProductVo;
import com.hw.warehouse.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        //log.info("响应报文{}", res);
        return res;
    }

    @GetMapping(value = "/table")
    public String getTableInfo() {
        List<InProductVo> inProductList = demoService.getInProductList();
        System.out.print(inProductList.get(0).getInName());
        List<String> tableItems = null;
        //for(InProductVo inProductVo : inProductList){
            String tableItem = "{\n" +
                    "    \"code\": 0,\n" +
                    "    \"msg\": \"\",\n" +
                    "    \"count\": 100,\n" +
                    "    \"data\": [\n" +
                    "        {\n" +
                    "            \"id\": \"" + inProductList.get(0).getInId() +"\",\n" +
                    "            \"name\": \"" + inProductList.get(0).getInName() +"\",\n" +
                    "            \"amount\": \"" + inProductList.get(0).getInNumber() +"\",\n" +
                    "            \"date\": \"" +inProductList.get(0).getInDate() + "\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
//            tableItems.add(tableItem);
//        }

        return tableItem;
    }

    @PostMapping(value = "/search")
    public void getSearch(@RequestBody Map<String, Object> map) {
        String searchType = (String) map.get("searchType1");
        System.out.print(searchType);
    }



}
