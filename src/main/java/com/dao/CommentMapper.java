package com.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 */
public interface CommentMapper extends BaseMapper<Comment> {


    Integer selectCount(@Param("source") Integer source,@Param("type") String type);


    List<Comment> selectCommentList(@Param("source") Integer source,@Param("type") String type, @Param("firstComment")int firstComment);



}
