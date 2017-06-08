package com.boot.controller;

import com.boot.model.DemoObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Admin on 2017/6/8.
 * 自定义 {@link com.boot.convert.MyMesageConvert} 控制器.
 */
@Controller
public class ConverterController {

    private static Logger logger = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping(value = "/convert", produces = {"application/x-wisely"})
    @ResponseBody
    public DemoObj convert(@RequestBody DemoObj demoObj) {
        Long id = demoObj.getId() + 1;
        demoObj.setId(id);
        logger.info("收到的DemoObj对象信息：" + id + "------------" + demoObj.getName());
        return demoObj;
    }
}
