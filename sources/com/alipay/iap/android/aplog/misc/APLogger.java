package com.alipay.iap.android.aplog.misc;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogHelper;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.log.behavior.AliveReportLog;
import com.alipay.iap.android.aplog.log.behavior.BehaviourLog;
import com.alipay.iap.android.common.log.IMonitor;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes6.dex */
public class APLogger implements IMonitor {
    @Override // com.alipay.iap.android.common.log.IMonitor
    public void performance(String str, String str2, String str3, Map<String, String> map) {
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void aliveReport() {
        LoggerFactory.getLogContext().appendLog(new AliveReportLog());
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void behaviour(String str, Map<String, String> map) {
        behaviour(str, null, map);
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void behaviour(String str, String str2, Map<String, String> map) {
        BehaviourLog behaviourLog = new BehaviourLog();
        behaviourLog.setSeedID(str);
        if (!TextUtils.isEmpty(str2)) {
            behaviourLog.setBizType(str2);
        }
        if (map != null) {
            for (String str3 : map.keySet()) {
                behaviourLog.putExtParam(str3, map.get(str3));
            }
        }
        LoggerFactory.getLogContext().appendLog(behaviourLog);
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void flush() {
        LoggerFactory.getLogContext().flush();
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void pageOnStart(Object obj, String str) {
        LoggerFactory.getLogContext().getSpmMonitor().pageOnStart(obj, str);
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void pageOnEnd(Object obj, String str, String str2, Map<String, String> map) {
        LoggerFactory.getLogContext().getSpmMonitor().pageOnEnd(obj, str, str2, map);
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void pageOnDestroy(Object obj) {
        LoggerFactory.getLogContext().getSpmMonitor().pageOnDestroy(obj);
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void spmClick(Object obj, String str, String str2, Map<String, String> map) {
        LoggerFactory.getLogContext().getSpmMonitor().spmClick(obj, str, str2, map);
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void spmExpose(Object obj, String str, String str2, Map<String, String> map) {
        LoggerFactory.getLogContext().getSpmMonitor().spmExpose(obj, str, str2, map);
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void exception(String str, String str2, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("exceptionType", str);
        LogHelper.exception(str2, map);
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void exception(String str, Map<String, String> map) {
        LogHelper.exception(str, map);
    }

    @Override // com.alipay.iap.android.common.log.IMonitor
    public void performance(String str, String str2, Map<String, String> map) {
        LogHelper.performance(str, str2, map);
    }
}
