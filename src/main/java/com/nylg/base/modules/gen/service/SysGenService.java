package com.nylg.base.modules.gen.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nylg.base.modules.gen.entity.InfoRmationSchema;
import com.nylg.base.modules.gen.entity.MakerConfigEntity;

public interface SysGenService extends IService<InfoRmationSchema> {

    IPage<InfoRmationSchema> queryTableList(IPage page, QueryWrapper<InfoRmationSchema> entityWrapper);

    void generatorCode(MakerConfigEntity config);
}
