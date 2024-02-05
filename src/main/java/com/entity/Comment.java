package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 文章评论表
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("comment")
@Builder
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 评论来源的房间ID
     */
    @TableField("source")
    private Integer source;

    /**
     * 父评论ID
     */
    @TableField("parent_comment_id")
    private Integer parentCommentId;

    /**
     * 评论来源类型
     */
    @TableField("type")
    private String type;

    /**
     * 发表用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 父发表会员ID
     */
    @TableField("parent_user_id")
    private Integer parentUserId;

    /**
     * 点赞数
     */
    @TableField("like_count")
    private Integer likeCount;

    /**
     * 评论内容
     */
    @TableField("comment_content")
    private String commentContent;

    /**
     * 评论额外信息
     */
    @TableField("comment_info")
    private String commentInfo;

    /**
     * 楼层评论ID
     */
    @TableField("floor_comment_id")
    private Integer floorCommentId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}
