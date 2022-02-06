package com.xgk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xgk
 * @date 2022/2/1
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
