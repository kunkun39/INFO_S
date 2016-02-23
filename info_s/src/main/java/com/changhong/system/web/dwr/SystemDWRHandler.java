package com.changhong.system.web.dwr;

import com.changhong.system.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("systemDWRHandler")
public class SystemDWRHandler {

    @Autowired
    private ConfigService configService;

    public void updateSystemConfig(String confKey, String confValue) {
        configService.updateConfiguration(confKey, confValue);
    }

}
