package com.ecology.bbzy.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(value = "tb_account")
public class TbAccount implements Serializable {

    /**
     * id
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 名称
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private LocalDateTime birthday;

}
