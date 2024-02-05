package com.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.PoetryResult;
import com.common.Result;
import com.dao.CommentMapper;
import com.dao.HuiyuanDao;
import com.dao.KefangxinxiDao;
import com.entity.Comment;
import com.entity.HuiyuanEntity;
import com.entity.KefangxinxiEntity;
import com.entity.vo.CommentVO;
import com.req.BaseRequestVO;
import com.req.CommentReq;

import com.service.ICommentService;
import com.utils.CommentTypeEnum;
import com.utils.CommonConst;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * <p>
 * 文章评论表 服务实现类
 * </p>
 *
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Resource
    private CommentMapper commentMapper;
    @Resource
    KefangxinxiDao kefangxinxiDao;
    @Resource
    HuiyuanDao huiyuanDao;

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
    public PoetryResult<BaseRequestVO> listComment(BaseRequestVO baseRequestVO) {
        if (CommentTypeEnum.COMMENT_TYPE_HOTEL.getCode().equals(baseRequestVO.getCommentType())) {
            KefangxinxiEntity kefangxinxiEntity = kefangxinxiDao.selectById(baseRequestVO.getSource());
            if (kefangxinxiEntity.getCommentStatus() != null && !kefangxinxiEntity.getCommentStatus()) {
                return PoetryResult.fail("评论功能已关闭！");
            }
        }

        if (baseRequestVO.getFloorCommentId() == null) {
            List<Comment> comments = commentMapper.selectCommentList(baseRequestVO.getSource(), baseRequestVO.getType(), CommonConst.FIRST_COMMENT);
            if (CollectionUtils.isEmpty(comments)) {
                PoetryResult.success(baseRequestVO);
            }
            List<CommentVO> commentVOs = comments.stream().map(c -> {
                CommentVO commentVO = buildCommentVO(c);
                Page page = new Page(1, 5);
                EntityWrapper<Comment> entityWrapper = new EntityWrapper<>();
                entityWrapper.eq("source", baseRequestVO.getSource())
                        .eq("type", baseRequestVO.getCommentType())
                        .eq("floor_comment_id", c.getId())
                        .orderBy("create_time", true); // true 表示升序
                List<Comment> childComments = page.getRecords();
                if (childComments != null) {
                    List<CommentVO> ccVO = childComments.stream().map(cc -> buildCommentVO(cc)).collect(Collectors.toList());
                    page.setRecords(ccVO);
                }
                commentVO.setChildComments(page);
                return commentVO;
            }).collect(Collectors.toList());
            baseRequestVO.setRecords(commentVOs);
        } else {
            EntityWrapper<Comment> entityWrapper = new EntityWrapper<>();
            entityWrapper.eq("source", baseRequestVO.getSource())
                    .eq("type", baseRequestVO.getCommentType())
                    .eq("floor_comment_id", baseRequestVO.getFloorCommentId())
                    .orderBy("create_time", true); // true 表示升序
            List<Comment> childComments = baseRequestVO.getRecords();
            if (CollectionUtils.isEmpty(childComments)) {
                PoetryResult.success(baseRequestVO);
            }
            List<CommentVO> ccVO = childComments.stream().map(cc -> buildCommentVO(cc)).collect(Collectors.toList());
            baseRequestVO.setRecords(ccVO);
        }

        return PoetryResult.success(baseRequestVO);
    }



    private CommentVO buildCommentVO(Comment c) {
        CommentVO commentVO = new CommentVO();
        BeanUtils.copyProperties(c, commentVO);
        HuiyuanEntity huiyuanEntity = huiyuanDao.selectById(c.getSource());
        if (huiyuanEntity != null) {
            commentVO.setAvatar(huiyuanEntity.getTouxiang());
            commentVO.setUsername(huiyuanEntity.getXingming());
        }
        if (commentVO.getParentUserId() != null) {

            if (huiyuanEntity != null) {
                commentVO.setParentUsername(huiyuanEntity.getXingming());
            }
        }
        return commentVO;
    }
}
