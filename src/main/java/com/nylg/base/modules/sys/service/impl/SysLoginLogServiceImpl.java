package com.nylg.base.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nylg.base.modules.sys.entity.SysLoginLog;
import com.nylg.base.modules.sys.mapper.SysLoginLogMapper;
import com.nylg.base.modules.sys.service.SysLoginLogService;
import org.springframework.stereotype.Service;


@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService {

}
