package com.iap.ac.android.biz.common.internal.config.cpm;

import android.text.TextUtils;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.remoteconfig.cpm.CPMConfig;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CPMConfigModel {
    public List<CPMConfig> mCPMConfigList = new ArrayList();

    public CPMConfig getCPMConfig(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (CPMConfig cPMConfig : this.mCPMConfigList) {
                if (cPMConfig != null && TextUtils.equals(str, cPMConfig.codeType)) {
                    return cPMConfig;
                }
            }
            return null;
        }
    }

    public boolean isValid() {
        boolean z;
        synchronized (this) {
            z = this.mCPMConfigList.size() > 0;
        }
        return z;
    }

    public boolean parseFromJson(String str) {
        synchronized (this) {
            List<CPMConfig> parseCpmConfigList = ConfigUtils.parseCpmConfigList(str);
            if (parseCpmConfigList != null && parseCpmConfigList.size() > 0) {
                this.mCPMConfigList = parseCpmConfigList;
                StringBuilder a2 = a.a("CPMConfigModel parse finish, size: ");
                a2.append(this.mCPMConfigList.size());
                ACLog.i(Constants.TAG, a2.toString());
                return this.mCPMConfigList.size() > 0;
            }
            ACLog.e(Constants.TAG, "CPMConfigModel parse error, invalid input");
            return false;
        }
    }
}
