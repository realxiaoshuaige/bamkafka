package com.eshore.bamkafkaserv.entity;

import lombok.Data;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * created by czx on 2019/8/6 0006.
 */
@Data
public class BamData {


    private String InvokeDate;

    private String FuncCode;

    private String TargetCode;

    private String SourceCode;

    private String SysCode;

    private String proxy;

    private String CallMethod;

    private String domainname;

    private String ReqCode;

    private String RecvDate;

    private String IPAddress;

    private String ResDate;

    private String ResBodyLen;

    private String ResReason;

    private String ResResult;

    private String Response;


    public static BamData parseXml(Document document){
        BamData bamData =new BamData();
        Element rootElement = document.getRootElement();
        Element body = rootElement.element("Body");
        Element bamdata = body.element("bamdata");
        if (bamdata.element("InvokeDate") != null){
            bamData.setInvokeDate(bamdata.element("InvokeDate").getText());
        }
        if (bamdata.element("FuncCode") != null){
            bamData.setFuncCode(bamdata.element("FuncCode").getText());
        }
        if (bamdata.element("TargetCode") != null){
            bamData.setTargetCode(bamdata.element("TargetCode").getText());
        }
        if (bamdata.element("SourceCode") != null){
            bamData.setSourceCode(bamdata.element("SourceCode").getText());
        }
        if (bamdata.element("SysCode") != null){
            bamData.setSysCode(bamdata.element("SysCode").getText());
        }
        if (bamdata.element("proxy") != null){
            bamData.setProxy(bamdata.element("proxy").getText());
        }
        if (bamdata.element("CallMethod") != null){
            bamData.setCallMethod(bamdata.element("CallMethod").getText());
        }
        if (bamdata.element("domainname") != null){
            bamData.setDomainname(bamdata.element("domainname").getText());
        }
        if (bamdata.element("ReqCode") != null){
            bamData.setReqCode(bamdata.element("ReqCode").getText());
        }
        if (bamdata.element("RecvDate") != null){
            bamData.setRecvDate(bamdata.element("RecvDate").getText());
        }
        if (bamdata.element("IPAddress") != null){
            bamData.setIPAddress(bamdata.element("IPAddress").getText());
        }
        if (bamdata.element("ResDate") != null){
            bamData.setResDate(bamdata.element("ResDate").getText());
        }
        if (bamdata.element("ResBodyLen") != null){
            bamData.setResBodyLen(bamdata.element("ResBodyLen").getText());
        }
        if (bamdata.element("ResReason") != null){
            bamData.setResReason(bamdata.element("ResReason").getText());
        }
        if (bamdata.element("ResResult") != null){
            bamData.setResResult(bamdata.element("ResResult").getText());
        }
        if (bamdata.element("Response") != null){
            bamData.setResponse(bamdata.element("Response").getText());
        }
        return bamData;
    }
}
