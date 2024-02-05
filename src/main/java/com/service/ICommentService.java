package com.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.common.PoetryResult;
import com.common.Result;
import com.entity.Comment;
import com.req.BaseRequestVO;
import com.req.CommentReq;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 评论表 服务类
 * </p>
 */
@Service
public interface ICommentService  extends IService<Comment> {

    Result saveComment(CommentReq commentReq);

    Result deleteComment(Integer id);

    PoetryResult<BaseRequestVO> listComment(BaseRequestVO baseRequestVO);



}
