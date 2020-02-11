package com.eshore.bamkafkaserv.controller;

import com.alibaba.fastjson.JSONObject;
import com.eshore.bamkafkaserv.entity.BamData;
import com.eshore.bamkafkaserv.util.readStreamUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created by czx on 2019/8/6 0006.
 */

@RestController
@RequestMapping("/bam")
public class receiveXmlController {

    private Logger logger = LoggerFactory.getLogger(receiveXmlController.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping("/kafka")
    public BamData Xml2Json(HttpServletRequest request, HttpServletResponse response){
        ServletInputStream inputStream = null;
        BamData bamData =null;
        try {
            inputStream = request.getInputStream();
            byte[] rebyte=readStreamUtil.readStream(inputStream);
            String remess = new String(rebyte);
            logger.info(remess);
            Document bamXml = DocumentHelper.parseText(remess);
            bamData =BamData.parseXml(bamXml);
           /* kafkaTemplate.send(kafkaTemplate.getDefaultTopic(), JSONObject.toJSONString(bamData));*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bamData;
    }

}
