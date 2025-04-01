package com.entity.model;

import com.entity.ShenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 赔偿申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-24
 */
public class ShenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请人
     */
    private Integer yonghuId;


    /**
     * 购买保险
     */
    private Integer baoxianId;


    /**
     * 赔偿金额
     */
    private Double amountpaid;


    /**
     * 申请结果
     */
    private Integer jieguoTypes;


    /**
     * 申请原因
     */
    private String shenqingContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：申请人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：申请人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：购买保险
	 */
    public Integer getBaoxianId() {
        return baoxianId;
    }


    /**
	 * 设置：购买保险
	 */
    public void setBaoxianId(Integer baoxianId) {
        this.baoxianId = baoxianId;
    }
    /**
	 * 获取：赔偿金额
	 */
    public Double getAmountpaid() {
        return amountpaid;
    }


    /**
	 * 设置：赔偿金额
	 */
    public void setAmountpaid(Double amountpaid) {
        this.amountpaid = amountpaid;
    }
    /**
	 * 获取：申请结果
	 */
    public Integer getJieguoTypes() {
        return jieguoTypes;
    }


    /**
	 * 设置：申请结果
	 */
    public void setJieguoTypes(Integer jieguoTypes) {
        this.jieguoTypes = jieguoTypes;
    }
    /**
	 * 获取：申请原因
	 */
    public String getShenqingContent() {
        return shenqingContent;
    }


    /**
	 * 设置：申请原因
	 */
    public void setShenqingContent(String shenqingContent) {
        this.shenqingContent = shenqingContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
