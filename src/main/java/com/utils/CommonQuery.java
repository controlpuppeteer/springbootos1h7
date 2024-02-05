package com.utils;

import com.dao.CommentMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CommonQuery {
    @Resource
    CommentMapper commentMapper;
    public Integer getCommentCount(Integer source, String type) {
        Integer count = (Integer) CacheUtil.get(CommonConst.COMMENT_COUNT_CACHE + source.toString() + "_" + type);
        if (count != null) {
            return count;
        }
        Integer c = commentMapper.selectCount(source,type);
        CacheUtil.put(CommonConst.COMMENT_COUNT_CACHE + source.toString() + "_" + type, c, CommonConst.EXPIRE);
        return c;
    }
}
