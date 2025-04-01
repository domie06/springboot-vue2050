package com.entity.model;

import com.entity.BaoxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 保险
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-24
 */
public class BaoxianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 保险名称
     */
    private String bxname;


    /**
     * 保险费用
     */
    private Double bxmoney;


    /**
     * 赔偿金额
     */
    private Double bxamountpaid;


    /**
     * 保险类型
     */
    private Integer leixingTypes;


    /**
     * 保险详情
     */
    private String neirongContent;


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
	 * 获取：保险名称
	 */
    public String getBxname() {
        return bxname;
    }


    /**
	 * 设置：保险名称
	 */
    public void setBxname(String bxname) {
        this.bxname = bxname;
    }
    /**
	 * 获取：保险费用
	 */
    public Double getBxmoney() {
        return bxmoney;
    }


    /**
	 * 设置：保险费用
	 */
    public void setBxmoney(Double bxmoney) {
        this.bxmoney = bxmoney;
    }
    /**
	 * 获取：赔偿金额
	 */
    public Double getBxamountpaid() {
        return bxamountpaid;
    }


    /**
	 * 设置：赔偿金额
	 */
    public void setBxamountpaid(Double bxamountpaid) {
        this.bxamountpaid = bxamountpaid;
    }
    /**
	 * 获取：保险类型
	 */
    public Integer getLeixingTypes() {
        return leixingTypes;
    }


    /**
	 * 设置：保险类型
	 */
    public void setLeixingTypes(Integer leixingTypes) {
        this.leixingTypes = leixingTypes;
    }
    /**
	 * 获取：保险详情
	 */
    public String getNeirongContent() {
        return neirongContent;
    }


    /**
	 * 设置：保险详情
	 */
    public void setNeirongContent(String neirongContent) {
        this.neirongContent = neirongContent;
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
