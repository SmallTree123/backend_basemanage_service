package com.nylg.base.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nylg.base.modules.sys.entity.SysLog;
import com.nylg.base.modules.sys.mapper.SysLogMapper;
import com.nylg.base.modules.sys.service.SysLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

}
