package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 客房信息
 * 数据库通用操作实体类（普通增删改查）
 * @author
 * @email
 * @date 2023-02-23 11:38:12
 */
@TableName("kefangxinxi")
public class KefangxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KefangxinxiEntity() {

	}

	public KefangxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 客房号
	 */

	private String kefanghao;

	/**
	 * 客房类型
	 */

	private String kefangleixing;

	/**
	 * 封面
	 */

	private String fengmian;

	/**
	 * 房间面积
	 */

	private String fangjianmianji;

	/**
	 * 客房位置
	 */

	private String kefangweizhi;

	/**
	 * 价格
	 */

	private Float jiage;

	/**
	 * 可约时间
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date keyueshijian;

	/**
	 * 房间设施
	 */

	private String fangjiansheshi;

	/**
	 * 客房介绍
	 */

	private String kefangjieshao;

	/**
	 * 员工工号
	 */

	private String yuangonggonghao;

	/**
	 * 员工姓名
	 */

	private String yuangongxingming;

	/**
	 * 最近点击时间
	 */

	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date clicktime;

	/**
	 * 点击次数
	 */

	private Integer clicknum;


	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	/**
	 * 是否启用评论[0:否，1:是]
	 */
	@TableField("comment_status")
	private Boolean commentStatus;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：客房号
	 */
	public void setKefanghao(String kefanghao) {
		this.kefanghao = kefanghao;
	}
	/**
	 * 获取：客房号
	 */
	public String getKefanghao() {
		return kefanghao;
	}
	/**
	 * 设置：客房类型
	 */
	public void setKefangleixing(String kefangleixing) {
		this.kefangleixing = kefangleixing;
	}
	/**
	 * 获取：客房类型
	 */
	public String getKefangleixing() {
		return kefangleixing;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：房间面积
	 */
	public void setFangjianmianji(String fangjianmianji) {
		this.fangjianmianji = fangjianmianji;
	}
	/**
	 * 获取：房间面积
	 */
	public String getFangjianmianji() {
		return fangjianmianji;
	}
	/**
	 * 设置：客房位置
	 */
	public void setKefangweizhi(String kefangweizhi) {
		this.kefangweizhi = kefangweizhi;
	}
	/**
	 * 获取：客房位置
	 */
	public String getKefangweizhi() {
		return kefangweizhi;
	}
	/**
	 * 设置：价格
	 */
	public void setJiage(Float jiage) {
		this.jiage = jiage;
	}
	/**
	 * 获取：价格
	 */
	public Float getJiage() {
		return jiage;
	}
	/**
	 * 设置：可约时间
	 */
	public void setKeyueshijian(Date keyueshijian) {
		this.keyueshijian = keyueshijian;
	}
	/**
	 * 获取：可约时间
	 */
	public Date getKeyueshijian() {
		return keyueshijian;
	}
	/**
	 * 设置：房间设施
	 */
	public void setFangjiansheshi(String fangjiansheshi) {
		this.fangjiansheshi = fangjiansheshi;
	}
	/**
	 * 获取：房间设施
	 */
	public String getFangjiansheshi() {
		return fangjiansheshi;
	}
	/**
	 * 设置：客房介绍
	 */
	public void setKefangjieshao(String kefangjieshao) {
		this.kefangjieshao = kefangjieshao;
	}
	/**
	 * 获取：客房介绍
	 */
	public String getKefangjieshao() {
		return kefangjieshao;
	}
	/**
	 * 设置：员工工号
	 */
	public void setYuangonggonghao(String yuangonggonghao) {
		this.yuangonggonghao = yuangonggonghao;
	}
	/**
	 * 获取：员工工号
	 */
	public String getYuangonggonghao() {
		return yuangonggonghao;
	}
	/**
	 * 设置：员工姓名
	 */
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

	public Boolean getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(Boolean commentStatus) {
		this.commentStatus = commentStatus;
	}
}
