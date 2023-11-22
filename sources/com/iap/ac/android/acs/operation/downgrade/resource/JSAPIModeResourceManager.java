package com.iap.ac.android.acs.operation.downgrade.resource;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class JSAPIModeResourceManager extends BaseConfigModel<MobilePaymentJSAPIMode> {
    public JSAPIModeResourceManager() {
    }

    public List<String> getJSAPIBlackList() {
        if (isValid()) {
            MobilePaymentJSAPIMode mobilePaymentJSAPIMode = (MobilePaymentJSAPIMode) this.mode;
            if (mobilePaymentJSAPIMode.blackList != null) {
                return mobilePaymentJSAPIMode.blackList;
            }
        }
        return new ArrayList();
    }

    public List<String> getJSAPIWhiteList() {
        if (isValid()) {
            MobilePaymentJSAPIMode mobilePaymentJSAPIMode = (MobilePaymentJSAPIMode) this.mode;
            if (mobilePaymentJSAPIMode.whiteList != null) {
                return mobilePaymentJSAPIMode.whiteList;
            }
        }
        return new ArrayList();
    }

    @Override // com.iap.ac.android.acs.operation.downgrade.resource.BaseConfigModel
    public String getSectionName() {
        return "jsapiMode";
    }

    public JSAPIModeResourceManager(Context context, String str) {
        super(context, str);
    }
}
