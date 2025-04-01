package com.entity.vo;

import com.entity.ShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赔偿申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("shenqing")
public class ShenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 申请人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 购买保险
     */

    @TableField(value = "baoxian_id")
    private Integer baoxianId;


    /**
     * 赔偿金额
     */

    @TableField(value = "amountpaid")
    private Double amountpaid;


    /**
     * 申请结果
     */

    @TableField(value = "jieguo_types")
    private Integer jieguoTypes;


    /**
     * 申请原因
     */

    @TableField(value = "shenqing_content")
    private String shenqingContent;


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
	 * 设置：申请人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：申请人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买保险
	 */
    public Integer getBaoxianId() {
        return baoxianId;
    }


    /**
	 * 获取：购买保险
	 */

    public void setBaoxianId(Integer baoxianId) {
        this.baoxianId = baoxianId;
    }
    /**
	 * 设置：赔偿金额
	 */
    public Double getAmountpaid() {
        return amountpaid;
    }


    /**
	 * 获取：赔偿金额
	 */

    public void setAmountpaid(Double amountpaid) {
        this.amountpaid = amountpaid;
    }
    /**
	 * 设置：申请结果
	 */
    public Integer getJieguoTypes() {
        return jieguoTypes;
    }


    /**
	 * 获取：申请结果
	 */

    public void setJieguoTypes(Integer jieguoTypes) {
        this.jieguoTypes = jieguoTypes;
    }
    /**
	 * 设置：申请原因
	 */
    public String getShenqingContent() {
        return shenqingContent;
    }


    /**
	 * 获取：申请原因
	 */

    public void setShenqingContent(String shenqingContent) {
        this.shenqingContent = shenqingContent;
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
