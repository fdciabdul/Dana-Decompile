package com.alipay.iap.android.aplog.log.behavior;

import com.alipay.iap.android.aplog.api.LogCategory;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.util.IntUtil;
import com.alipay.iap.android.aplog.util.TraceIdUtil;

/* loaded from: classes3.dex */
public class SPMLog extends AbTestLog {
    private BehaviourPageInfo behaviourPageInfo;
    private String bizType;
    private String logcategory = LogCategory.LOG_SPM;
    private String refer;
    private String seedID;

    public SPMLog(String str) {
        initLog();
        this.seedID = str;
        String c10to64 = IntUtil.c10to64(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(TraceIdUtil.UNDERLINE);
        sb.append(LoggerFactory.getLogContext().getDeviceID());
        sb.append(TraceIdUtil.UNDERLINE);
        sb.append(c10to64);
        String obj = sb.toString();
        this.behaviourPageInfo.setPageID(obj);
        LoggerFactory.getLogContext().addSPMPage(obj);
    }

    private void initLog() {
        this.behaviourPageInfo = new BehaviourPageInfo();
        generateSequenceID();
        BehaviourPageInfo behaviourPageInfo = this.behaviourPageInfo;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        behaviourPageInfo.setStartTime(sb.toString());
        this.behaviourPageInfo.setLastPage(LoggerFactory.getLogContext().getLastSPMPage());
    }

    @Override // com.alipay.iap.android.aplog.log.BaseLogInfo
    public String getLogCategory() {
        return this.logcategory;
    }

    public BehaviourPageInfo getBehaviourPageInfo() {
        return this.behaviourPageInfo;
    }

    public void setBehaviourPageInfo(BehaviourPageInfo behaviourPageInfo) {
        this.behaviourPageInfo = behaviourPageInfo;
    }

    public void setEndTime(String str) {
        BehaviourPageInfo behaviourPageInfo = this.behaviourPageInfo;
        if (behaviourPageInfo != null) {
            behaviourPageInfo.setEndTime(str);
        }
    }

    public void setStartTime(String str) {
        BehaviourPageInfo behaviourPageInfo = this.behaviourPageInfo;
        if (behaviourPageInfo != null) {
            behaviourPageInfo.setStartTime(str);
        }
    }

    @Override // com.alipay.iap.android.aplog.log.behavior.AbTestLog
    public String getSeedID() {
        return this.seedID;
    }

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public String getRefer() {
        return this.refer;
    }

    public void setRefer(String str) {
        this.refer = str;
    }

    public void setPageID(String str) {
        this.behaviourPageInfo.setPageID(str);
    }
}
