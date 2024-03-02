package com.controller;


import com.common.PoetryResult;
import com.common.Result;
import com.req.BaseRequestVO;
import com.req.CommentReq;
import com.service.ICommentService;
import com.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



/**
 * <p>
 * 文章评论表 前端控制器
 * </p>
 *
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommonQuery commonQuery;

    @Resource
    private ICommentService commentService;
    /**
     * 保存评论
     */
    @PostMapping("/saveComment")
    public Result saveComment(@Validated @RequestBody CommentReq commentReq) {
        String content = StringUtil.removeHtml(commentReq.getCommentContent());
        if (!StringUtils.hasText(content)) {
            return Result.failed("评论内容不合法！");
        }
        commentReq.setCommentContent(content);
        CacheUtil.remove(CommonConst.COMMENT_COUNT_CACHE + commentReq.getSource().toString() + "_" + commentReq.getType());
        return   commentService.saveComment(commentReq);
    }

    /**
     * 删除评论
     */
    @GetMapping("/deleteComment")
    public Result deleteComment(@RequestParam("id") Integer id) {
        commentService.deleteComment(id);
        return Result.ok();
    }


    /**
     * 查询评论数量
     */
    @GetMapping("/getCommentCount")
    public Result<Integer> getCommentCount(@RequestParam("source") Integer source, @RequestParam("type") String type) {
        return Result.ok(commonQuery.getCommentCount(source, type));
    }

    /**
     * 查询评论
     */
    @PostMapping("/listComment")
    public PoetryResult<BaseRequestVO> listComment(@RequestBody BaseRequestVO baseRequestVO) {
        return commentService.listComment(baseRequestVO);
    }
}

