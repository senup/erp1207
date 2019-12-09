package com.layuicms.erp.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
json数据实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataGridView {
    private Integer code;
    private String msg;
    private Long count = 0L;
    private Object data;

    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }
    public DataGridView(Object data) {
        super();
        this.data = data;
    }
}
