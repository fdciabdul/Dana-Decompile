package com.iap.ac.android.biz.common.internal.config.mpm;

import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.remoteconfig.mpm.HookUrlConfig;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class HookUrlConfigModel {
    public List<HookUrlConfig> mHookUrlConfigList = new ArrayList();

    public List<HookUrlConfig> getHookUrlConfigList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mHookUrlConfigList);
        return arrayList;
    }

    public boolean isValid() {
        boolean z;
        synchronized (this) {
            z = this.mHookUrlConfigList.size() > 0;
        }
        return z;
    }

    public boolean parseFromJson(String str) {
        synchronized (this) {
            List<HookUrlConfig> parseHookeUrlConfigList = ConfigUtils.parseHookeUrlConfigList(str);
            if (parseHookeUrlConfigList != null && parseHookeUrlConfigList.size() > 0) {
                this.mHookUrlConfigList = parseHookeUrlConfigList;
                StringBuilder a2 = a.a("HookUrlConfigModel, finish, size: ");
                a2.append(this.mHookUrlConfigList.size());
                ACLog.i(Constants.TAG, a2.toString());
                return this.mHookUrlConfigList.size() > 0;
            }
            ACLog.e(Constants.TAG, "HookDecodeUrlConfigModel error, invalid input");
            return false;
        }
    }
}
