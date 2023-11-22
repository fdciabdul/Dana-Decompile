package com.alipay.mobile.verifyidentity.adapter;

import com.alipay.mobile.verifyidentity.adapterapi.IConfig;
import com.alipay.mobile.verifyidentity.adapterapi.log.ILog;
import com.alipay.mobile.verifyidentity.adapterapi.log.NormalLog;

/* loaded from: classes3.dex */
public class Config implements IConfig {
    @Override // com.alipay.mobile.verifyidentity.adapterapi.IConfig
    public ILog getLog() {
        return new NormalLog();
    }
}
