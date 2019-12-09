package com.layuicms.erp.common;

import com.layuicms.erp.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiveUser {
    private User user;
    private List<String> roles;
    private List<String> permissions;
}
