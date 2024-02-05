package com.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.Result;
import com.dao.CommentMapper;
import com.entity.Comment;
import com.req.BaseRequestVO;
import com.req.CommentReq;

import com.service.ICommentService;
import com.utils.CommentTypeEnum;
import com.utils.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.List;


/**
 * <p>
 * 文章评论表 服务实现类
 * </p>
 *
 * @author sara
 * @since 2021-08-13
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public Result saveComment(CommentReq commentReq) {
        if (CommentTypeEnum.getEnumByCode(commentReq.getType()) == null) {
            return Result.failed("评论来源类型不存在！");
        }
        Comment comment = Comment.builder()
                .source(commentReq.getSource())
                .type(commentReq.getType())
                .commentContent(commentReq.getCommentContent())
                .parentCommentId(commentReq.getParentCommentId())
                .floorCommentId(commentReq.getFloorCommentId())
                .parentUserId(commentReq.getParentUserId())
                .userId(commentReq.getUserId())
                .build();
        if (StringUtils.hasText(commentReq.getCommentInfo())) {
            comment.setCommentInfo(commentReq.getCommentInfo());
        }
        commentMapper.insert(comment);
        return Result.ok();
    }

    @Override
    public Result deleteComment(Integer id) {
        commentMapper.deleteById(id);
        return Result.ok();
    }


    @Override
    public Result listComment(@RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                              @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                              BaseRequestVO baseRequestVO) {
        if (null != baseRequestVO.getSource()){
            List<Comment> commentList=commentMapper.selectCommentList(baseRequestVO.getSource());
        }
        //TODO查询出评论的集合，使用工具类分页，mp版本太低用不惯
        PageUtil<BaseRequestVO> pageUtil = new PageUtil<>(pageNum, pageSize, commentList);
        return Result(pageUtil.getPageList());
    }


}
