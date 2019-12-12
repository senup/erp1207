package com.layuicms.erp.vo;

import com.layuicms.erp.domain.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)//防止误认为相等而导致出错
public class DeptVo extends Dept {
    public static final Long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;


}
