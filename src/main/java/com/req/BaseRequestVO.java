package com.req;


import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;

@Data
public class BaseRequestVO extends Page {

    private String order;

    private boolean desc = true;
    /**
     * 评论来源标识
     */
    private Integer source;

    private String type;

    private String commentType;

    private Integer floorCommentId;

    private String searchKey;

    private String articleSearch;

    // 是否推荐[0:否，1:是]
    private Boolean recommendStatus;

    private Integer sortId;

    private Integer labelId;

    private Boolean userStatus;

    private Integer userType;

    private Integer userId;

    private String resourceType;

    private Boolean status;

    private String classify;

    /**分页可能会用到
     *
     */
    private Integer pageNum;
    private Integer pageSize;
}
