package com.req;


import com.baomidou.mybatisplus.plugins.Page;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BaseRequestVO extends Page {

    private Long id;
    private Integer source;
    private String type;
    private Long parentCommentId;
    private Long userId;
    private Long floorCommentId;
    private Long parentUserId;
    private Integer likeCount;
    private String commentContent;
    private LocalDateTime createTime;
    private String zhangHao;
    private String xingMing;
    private String touXiang;
    /**分页可能会用到
     *
     */
    private Integer pageNum;
    private Integer pageSize;
}
