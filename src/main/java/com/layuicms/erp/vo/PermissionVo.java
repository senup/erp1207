package com.layuicms.erp.vo;

import com.layuicms.erp.domain.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)//防止误认为相等而导致出错
public class PermissionVo extends Permission {
    public static final Long serialVersionUID = 1L;
}
