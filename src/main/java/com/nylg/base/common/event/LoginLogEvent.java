package com.nylg.base.common.event;

import com.nylg.base.modules.sys.entity.SysLoginLog;
import org.springframework.context.ApplicationEvent;

/**
 * @Description //TODO $
 * @Date 11:29
 * @Author yzcheng90@qq.com
 **/
public class LoginLogEvent extends ApplicationEvent {

    public LoginLogEvent(SysLoginLog source) {
        super(source);
    }
}
