package com.nylg.base.modules.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nylg.base.common.annotation.SysLog;
import com.nylg.base.common.base.AbstractController;
import com.nylg.base.modules.sys.entity.SysMenuNew;
import com.nylg.base.modules.sys.service.SysMenuNewService;
import com.nylg.base.modules.sys.vo.SysMenuNewVO;
import com.suke.zhjg.common.autofull.util.R;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 系统菜单
 *
 * @author czx
 * @email object_czx@163.com
 */
@Slf4j
@RestController
@RequestMapping("/sys/menu")
@AllArgsConstructor
@Api(value = "SysMenuController", tags = "系统菜单")
public class SysMenuController extends AbstractController {

    private final SysMenuNewService sysMenuNewService;

    /**
     * 所有菜单列表
     */
    @GetMapping(value = "/list")
    public R list(@RequestParam Map<String, Object> params) {
        final List<SysMenuNewVO> userMenu = sysMenuNewService.getUserMenu();
        return R.ok().setData(userMenu);
    }

    /**
     * 保存
     */
    @SysLog("保存菜单")
    @PostMapping(value = "/save")
    public R save(@RequestBody SysMenuNewVO menu) {
        SysMenuNew menuNew = this.getParam(menu);
        if(menuNew.getParentId() == null){
            menuNew.setParentId(0L);
        }
        sysMenuNewService.save(menuNew);
        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改菜单")
    @PostMapping(value = "/update")
    public R update(@RequestBody SysMenuNewVO menu) {
        if (menu.getMenuId() == null) {
            return R.error("菜单ID为空");
        }
        SysMenuNew menuNew = this.getParam(menu);
        menuNew.setMenuId(menu.getMenuId());
        sysMenuNewService.updateById(menuNew);
        return R.ok();
    }

    public SysMenuNew getParam(SysMenuNewVO menu) {
        SysMenuNew menuNew = new SysMenuNew();
        menuNew.setParentId(menu.getParentId());
        menuNew.setPath(menu.getPath());
        menuNew.setName(menu.getName());
        menuNew.setComponent(menu.getComponent());
        menuNew.setRedirect(menu.getRedirect());
        menuNew.setTitle(menu.getTitle());
        menuNew.setOrderSort(menu.getOrderSort());
        if (menu.getMeta() != null) {
            menuNew.setTitle(menu.getMeta().getTitle());
            menuNew.setIsLink(menu.getMeta().getIsLink());
            menuNew.setHide(menu.getMeta().isHide());
            menuNew.setKeepAlive(menu.getMeta().isKeepAlive());
            menuNew.setAffix(menu.getMeta().isAffix());
            menuNew.setIframe(menu.getMeta().isIframe());
            menuNew.setIcon(menu.getMeta().getIcon());
            menuNew.setRoles(menu.getMeta().getRoles());
            menuNew.setDisabled(!menu.getMeta().isHide());
        }
        return menuNew;
    }

    /**
     * 删除
     */
    @SysLog("删除菜单")
    @PostMapping(value = "/delete")
    public R delete(@RequestBody SysMenuNew menu) {
        if (menu == null) {
            return R.error("参数错误");
        }
        Long menuId = menu.getMenuId();
        if (menuId == null) {
            return R.error("ID为空");
        }
        //判断是否有子菜单或按钮
        QueryWrapper<SysMenuNew> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysMenuNew::getParentId, menuId);
        List<SysMenuNew> menuList = sysMenuNewService.list(queryWrapper);
        if (menuList.size() > 0) {
            return R.error("请先删除子菜单");
        }
        sysMenuNewService.removeById(menuId);
        return R.ok();
    }
}
