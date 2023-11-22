package com.alipay.iap.android.aplog.log.behavior;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.abtest.AbtestInfoGetter;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.log.BaseLogInfo;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class AbTestLog extends BaseLogInfo {
    public static final String KEY_ABTESTINFO = "abTestInfo";
    private String abTestInfo;

    public abstract String getSeedID();

    public String getAbTestInfo() {
        return this.abTestInfo;
    }

    public void setAbTestInfo(String str) {
        this.abTestInfo = str;
    }

    public void dealAbTestInfo(AbTestLog abTestLog) {
        if (abTestLog == null || !TextUtils.isEmpty(abTestLog.getAbTestInfo()) || LoggerFactory.getLogContext() == null) {
            return;
        }
        String str = abTestLog.getExtParam() != null ? abTestLog.getExtParam().get(KEY_ABTESTINFO) : null;
        AbtestInfoGetter abtestInfoGetter = LoggerFactory.getLogContext().getAbtestInfoGetter();
        if (abtestInfoGetter == null) {
            abTestLog.setAbTestInfo(str);
            return;
        }
        String seedID = abTestLog.getSeedID();
        if (TextUtils.isEmpty(seedID)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = abtestInfoGetter.getLogForSpmID(seedID);
        }
        abTestLog.setAbTestInfo(str);
        Map<String, String> extInfoForSpmID = abtestInfoGetter.getExtInfoForSpmID(seedID);
        if (extInfoForSpmID == null) {
            return;
        }
        putAllExtParam(extInfoForSpmID);
    }
}
