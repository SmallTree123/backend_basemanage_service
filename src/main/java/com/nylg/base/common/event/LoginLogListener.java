package com.nylg.base.common.event;

import com.nylg.base.modules.sys.entity.SysLoginLog;
import com.nylg.base.modules.sys.service.SysLoginLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @Description //TODO $
 * @Date 11:28
 * @Author yzcheng90@qq.com
 **/
@Configuration
@RequiredArgsConstructor
public class LoginLogListener {

    private final SysLoginLogService sysLoginLogService;

    @Async
    @EventListener(LoginLogEvent.class)
    public void saveSysLog(LoginLogEvent event) {
        SysLoginLog sysLoginLog = (SysLoginLog) event.getSource();
        sysLoginLogService.save(sysLoginLog);
    }

}
