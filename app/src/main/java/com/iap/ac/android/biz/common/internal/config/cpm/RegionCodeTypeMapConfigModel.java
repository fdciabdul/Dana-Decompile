package com.iap.ac.android.biz.common.internal.config.cpm;

import android.text.TextUtils;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.config.utils.ConfigUtils;
import com.iap.ac.android.biz.common.model.remoteconfig.cpm.RegionCodeTypeMapConfig;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RegionCodeTypeMapConfigModel {
    public List<RegionCodeTypeMapConfig> mRegionCodeTypeList = new ArrayList();

    public String getFirstCodeType(String str) {
        synchronized (this) {
            String str2 = null;
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("getFirstCodeType error, invalid input, regionCode: ");
                sb.append(str);
                ACLog.e(Constants.TAG, sb.toString());
                return null;
            }
            for (RegionCodeTypeMapConfig regionCodeTypeMapConfig : this.mRegionCodeTypeList) {
                if (regionCodeTypeMapConfig != null && TextUtils.equals(str, regionCodeTypeMapConfig.region)) {
                    List<String> list = regionCodeTypeMapConfig.codeTypes;
                    if (list != null && list.size() > 0) {
                        str2 = regionCodeTypeMapConfig.codeTypes.get(0);
                    }
                    return str2;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getFirstCodeType error with regionCode: ");
            sb2.append(str);
            ACLog.e(Constants.TAG, sb2.toString());
            return null;
        }
    }

    public boolean isValid() {
        boolean z;
        synchronized (this) {
            z = this.mRegionCodeTypeList.size() > 0;
        }
        return z;
    }

    public boolean parseFromJson(String str) {
        synchronized (this) {
            List<RegionCodeTypeMapConfig> parseRegionCodeTypeMapList = ConfigUtils.parseRegionCodeTypeMapList(str);
            if (parseRegionCodeTypeMapList != null && parseRegionCodeTypeMapList.size() > 0) {
                this.mRegionCodeTypeList = parseRegionCodeTypeMapList;
                StringBuilder a2 = a.a("RegionCodeTypeMapConfigModel parse finish, size: ");
                a2.append(this.mRegionCodeTypeList.size());
                ACLog.i(Constants.TAG, a2.toString());
                return this.mRegionCodeTypeList.size() > 0;
            }
            ACLog.e(Constants.TAG, "RegionCodeTypeMapConfigModel parse error, invalid input");
            return false;
        }
    }
}
