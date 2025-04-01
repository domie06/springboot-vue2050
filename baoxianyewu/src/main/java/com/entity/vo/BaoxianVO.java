package com.entity.vo;

import com.entity.BaoxianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 保险
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("baoxian")
public class BaoxianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 保险名称
     */

    @TableField(value = "bxname")
    private String bxname;


    /**
     * 保险费用
     */

    @TableField(value = "bxmoney")
    private Double bxmoney;


    /**
     * 赔偿金额
     */

    @TableField(value = "bxamountpaid")
    private Double bxamountpaid;


    /**
     * 保险类型
     */

    @TableField(value = "leixing_types")
    private Integer leixingTypes;


    /**
     * 保险详情
     */

    @TableField(value = "neirong_content")
    private String neirongContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：保险名称
	 */
    public String getBxname() {
        return bxname;
    }


    /**
	 * 获取：保险名称
	 */

    public void setBxname(String bxname) {
        this.bxname = bxname;
    }
    /**
	 * 设置：保险费用
	 */
    public Double getBxmoney() {
        return bxmoney;
    }


    /**
	 * 获取：保险费用
	 */

    public void setBxmoney(Double bxmoney) {
        this.bxmoney = bxmoney;
    }
    /**
	 * 设置：赔偿金额
	 */
    public Double getBxamountpaid() {
        return bxamountpaid;
    }


    /**
	 * 获取：赔偿金额
	 */

    public void setBxamountpaid(Double bxamountpaid) {
        this.bxamountpaid = bxamountpaid;
    }
    /**
	 * 设置：保险类型
	 */
    public Integer getLeixingTypes() {
        return leixingTypes;
    }


    /**
	 * 获取：保险类型
	 */

    public void setLeixingTypes(Integer leixingTypes) {
        this.leixingTypes = leixingTypes;
    }
    /**
	 * 设置：保险详情
	 */
    public String getNeirongContent() {
        return neirongContent;
    }


    /**
	 * 获取：保险详情
	 */

    public void setNeirongContent(String neirongContent) {
        this.neirongContent = neirongContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
