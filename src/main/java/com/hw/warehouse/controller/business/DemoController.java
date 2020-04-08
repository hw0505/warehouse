package com.hw.warehouse.controller.business;

import com.hw.warehouse.entity.InProductEntity;
import com.hw.warehouse.entity.OutProductEntity;
import com.hw.warehouse.service.IDemoService;
import com.hw.warehouse.utils.GsonUtils;
import com.hw.warehouse.vo.InProductVo;
import com.hw.warehouse.vo.OutProductVo;
import com.hw.warehouse.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping(value = "/search")
    public String getTableInfo(@RequestParam("searchTable") String searchTable,@RequestParam("searchType") String searchType,@RequestParam("searchText") String searchText) {
        boolean SearchTable = Boolean.parseBoolean(searchTable);
        String res = "";
        System.out.print(searchTable + " " + searchType);
        if(SearchTable){
            res = getInTable(searchType,searchText);
        }else{
            res = getOutTable(searchType,searchText);
        }
        return res;
    }

    public String getInTable(String searchType,String searchText){
        List<InProductVo> inProductList= demoService.getInProductList();
        String resp = "";
        for(int i = 0;i < inProductList.size();i ++){
            resp += "        {\n" +
                    "            \"id\": \"" + inProductList.get(i).getInId() +"\",\n" +
                    "            \"name\": \"" + inProductList.get(i).getInName() +"\",\n" +
                    "            \"amount\": \"" + inProductList.get(i).getInNumber() +"\",\n" +
                    "            \"date\": \"" +inProductList.get(i).getInDate() + "\"\n" +
                    "        }\n";
            if(i < (inProductList.size() - 1)) {
                resp += ",";
            }
        }
        String tableItem = "{\n" +
                "    \"code\": 0,\n" +
                "    \"msg\": \"\",\n" +
                "    \"count\": " + inProductList.size() + ",\n" +
                "    \"data\": [\n" +
                resp +
                "    ]\n" +
                "}";
        return tableItem;
    }

    public String getOutTable(String searchType,String searchText){
        List<OutProductVo> outProductList= demoService.getOutProductList();
        String resp = "";
        for(int i = 0;i < outProductList.size();i ++){
            resp += "        {\n" +
                    "            \"id\": \"" + outProductList.get(i).getOutId() +"\",\n" +
                    "            \"name\": \"" + outProductList.get(i).getOutName() +"\",\n" +
                    "            \"amount\": \"" + outProductList.get(i).getOutNumber() +"\",\n" +
                    "            \"date\": \"" +outProductList.get(i).getOutDate() + "\"\n" +
                    "        }\n";
            if(i < (outProductList.size() - 1)) {
                resp += ",";
            }
        }
        String tableItem = "{\n" +
                "    \"code\": 0,\n" +
                "    \"msg\": \"\",\n" +
                "    \"count\": " + outProductList.size() + ",\n" +
                "    \"data\": [\n" +
                resp +
                "    ]\n" +
                "}";
        return tableItem;
    }

//    @PostMapping(value = "/search")
//    public void getSearch(@RequestParam Map<String, Object> map) {
//        String searchType1 = (String) map.get("searchType1");
//        String searchType2 = (String) map.get("searchType1");
//        System.out.print(searchType2);
//    }

    @PostMapping(value = "/add_inProduct")
    public void addInProduct(@RequestParam Map<String, Object> map) {
        String inName = (String) map.get("inName");
        String inNumber = (String) map.get("inNumber");
        String inDate = (String) map.get("inDate");
        InProductEntity inProductEntity = new InProductEntity();
        inProductEntity.setInName(inName);
        inProductEntity.setInNumber(inNumber);
        inProductEntity.setInDate(inDate);
        demoService.addInProduct(inProductEntity);
        //System.out.print(inName + inNumber + inDate);
    }

    @PostMapping(value = "/add_outProduct")
    public void addOutProduct(@RequestParam Map<String, Object> map) {
        String outName = (String) map.get("outName");
        String outNumber = (String) map.get("outNumber");
        String outDate = (String) map.get("outDate");
        OutProductEntity outProductEntity = new OutProductEntity();
        outProductEntity.setOutName(outName);
        outProductEntity.setOutNumber(outNumber);
        outProductEntity.setOutDate(outDate);
        demoService.addOutProduct(outProductEntity);
        //System.out.print(outName + outNumber + outDate);
    }


}
