package com.req;


import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;

@Data
public class BaseRequestVO extends Page {

    /**
     * 评论来源标识
     */
    private Integer source;

    private String type;

    private String commentType;


    // 是否推荐[0:否，1:是]
    private Boolean recommendStatus;


}
