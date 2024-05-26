package com.nylg.base.modules.sys.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description //TODO $
 * @Date 12:47
 * @Author yzcheng90@qq.com
 **/
@Data
public class RouterInfo {

    public UserInfoVO userInfo;

    public List<SysMenuNewVO> menus;

}
