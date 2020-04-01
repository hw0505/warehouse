package com.hw.warehouse.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 视图 控制器
 * @author liurl
 */
@Controller
@RequestMapping(value = "/view")
public class DemoViewController {

    @GetMapping(value = {"/", "/demo"})
    public ModelAndView demo(ModelAndView modelAndView) {
        modelAndView.setViewName("demo");
        return modelAndView;
    }
}
