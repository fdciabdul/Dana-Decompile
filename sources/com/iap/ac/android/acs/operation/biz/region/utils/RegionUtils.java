package com.iap.ac.android.acs.operation.biz.region.utils;

import com.iap.ac.android.acs.operation.biz.region.config.RegionRPCConfigCenter;
import java.util.List;

/* loaded from: classes3.dex */
public class RegionUtils {
    public static boolean isRegionMiniProgram(String str, String str2) {
        List regionMiniAppList = RegionRPCConfigCenter.INSTANCE.getRegionMiniAppList();
        return regionMiniAppList != null && regionMiniAppList.contains(str);
    }
}
