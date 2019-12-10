package com.layuicms.erp.vo;

import com.layuicms.erp.domain.LogLogin;
import com.layuicms.erp.domain.Permission;
import com.sun.xml.internal.ws.spi.db.DatabindingException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)//防止误认为相等而导致出错
public class LogLoginVo extends LogLogin {
    public static final Long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;

    private Integer[] ids;//接受多个id

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
