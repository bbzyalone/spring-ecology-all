package com.ecology.bbzy.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  实体类。
 *
 * @author bbzyk
 * @since 2023-11-30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "tb_info")
public class TbInfo implements Serializable {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String appid;

    private String appkey;

}
