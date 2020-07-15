package com.jie.mango.response;

import com.jie.mango.model.SysMenuModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SysMenuResponse {

    /**
     *返回码
     */
    @ApiModelProperty(value = "返回码")
    private String rejCode;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息")
    private String rejMsg;

    /**
     * 返回所有菜单列表
     */
    @ApiModelProperty(value = "返回所有菜单列表")
    List<SysMenuModel> menuList;

}
