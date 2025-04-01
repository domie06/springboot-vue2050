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
 * 赔偿申请
 *
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("shenqing")
public class ShenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShenqingEntity() {

	}

	public ShenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Shenqing{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", baoxianId=" + baoxianId +
            ", amountpaid=" + amountpaid +
            ", jieguoTypes=" + jieguoTypes +
            ", shenqingContent=" + shenqingContent +
            ", createTime=" + createTime +
        "}";
    }
}
