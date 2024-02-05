package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.common.Result;
import com.entity.Comment;
import com.req.BaseRequestVO;
import com.req.CommentReq;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 评论表 服务类
 * </p>
 */
@Service
public interface ICommentService  extends IService<Comment> {

    Result saveComment(CommentReq commentReq);

    Result deleteComment(Integer id);

    Result<BaseRequestVO> listComment(Integer pageSize, Integer pageNum,BaseRequestVO baseRequestVO);
}
