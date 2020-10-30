package com.cloud.dandan.dandanproduct.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
@TableName("good_info")
public class GoodsInfoDO implements Serializable {
    @TableField("id")
    private Long id;
    @TableField("good_name")
    private String goodName;
    @TableField("price")
    private String price;
    @TableField("image_url")
    private String imageUrl;
    @TableField("is_del")
    private Integer isDel;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodName=").append(goodName);
        sb.append(", price=").append(price);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", isDel=").append(isDel);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}