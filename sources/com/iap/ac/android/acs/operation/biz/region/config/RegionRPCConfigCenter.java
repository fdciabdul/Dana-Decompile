package com.iap.ac.android.acs.operation.biz.region.config;

import android.text.TextUtils;
import com.iap.ac.android.acs.operation.biz.region.RegionConstants;
import com.iap.ac.android.biz.common.configcenter.ConfigCenter;
import com.iap.ac.android.common.rpc.http.HttpTransportFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public enum RegionRPCConfigCenter {
    INSTANCE;

    private boolean getBooleanValue(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        Object obj = getRegionConfig().get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    private boolean getRegionConfigToggle(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Object obj = getRegionConfig().get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    private String getStringValue(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        Object obj = getRegionConfig().get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    private boolean isRealizeNetworkProxy() {
        if (getRegionBizHotBootToggle()) {
            return HttpTransportFactory.getCreater("region_biz") != null && isAllowRegisterCommonNetwork();
        }
        return true;
    }

    public final boolean fetchStageInfoEnabled() {
        return getBooleanValue(RegionConstants.KEY_FETCH_STAGEINFO_ENABLED, true) && isRealizeNetworkProxy() && getRegionBizToggle();
    }

    public final boolean getCommonNetworkProxyRegisterToggle() {
        return getBooleanValue(RegionConstants.TOGGLE_COMMON_NETWORK_PROXY_REGISTER, true);
    }

    public final boolean getMiniProgramOpenRetryToggle() {
        return getBooleanValue(RegionConstants.KEY_TOGGLE_MINI_PROGRAM_START_REPORT_RETRY, true);
    }

    public final boolean getMiniProgramRegionRPCToggle() {
        return getBooleanValue(RegionConstants.TOGGLE_MINI_PROGRAM_REGION_RPC, true);
    }

    public final boolean getMiniProgramStartReportToggle() {
        return getBooleanValue(RegionConstants.KEY_TOGGLE_MINI_PROGRAM_START_REPORT, true);
    }

    public final boolean getNotificationBoxRedDotEnabled() {
        return getRegionConfigToggle(RegionConstants.TOGGLE_NOTIFICATION_BOX_REDDOT_ENABLED) && getRegionBizToggle() && isRealizeNetworkProxy();
    }

    public final boolean getRegionBizHotBootToggle() {
        return ((Boolean) ConfigCenter.INSTANCE.getKeyOrDefault(RegionConstants.KEY_REGION_BIZ_HOT_BOOT_ENABLE, Boolean.TRUE)).booleanValue();
    }

    public final boolean getRegionBizToggle() {
        return getBooleanValue(RegionConstants.KEY_TOGGLE_REGION_BIZ, true);
    }

    public final Map getRegionConfig() {
        return ConfigCenter.INSTANCE.getMap("region_config", new HashMap());
    }

    public final List getRegionMiniAppList() {
        Object obj = getRegionConfig().get("APRegionRPCMiniProgramWhiteList");
        if (obj instanceof List) {
            return (List) obj;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("2102020070539967");
        arrayList.add("2171010082627392");
        return arrayList;
    }

    public final boolean getShowFavoriteItem() {
        return getRegionConfigToggle(RegionConstants.TOGGLE_SHOW_FAVORITE_ITEM);
    }

    public final boolean getShowFeedBackItem() {
        return getRegionConfigToggle(RegionConstants.TOGGLE_SHOW_FEEDBACK_ITEM);
    }

    public final boolean getShowNotificationBoxItem() {
        return getRegionConfigToggle(RegionConstants.TOGGLE_SHOW_NOTIFICATION_BOX_ITEM);
    }

    public final int getStageCacheVersion() {
        Object obj = getRegionConfig().get(RegionConstants.KEY_STAGE_CACHE_VERSION);
        try {
            if (obj instanceof Double) {
                return ((Double) obj).intValue();
            }
            return Integer.valueOf(obj.toString()).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public final boolean heartBeatEnabled() {
        return getBooleanValue(RegionConstants.HEART_BEAT_ENABLED, true) && isRealizeNetworkProxy() && getRegionBizToggle();
    }

    public final boolean isAllowRegisterCommonNetwork() {
        return getRegionBizToggle() && getCommonNetworkProxyRegisterToggle();
    }

    public final boolean isDirect() {
        return "DIRECT".equals(getStringValue("regionRpcType", "SERVICE_PROXY"));
    }

    public final boolean isEnableReport() {
        return getRegionBizToggle() && getMiniProgramStartReportToggle() && isRealizeNetworkProxy();
    }

    public final boolean isEnableRetryReport() {
        return getRegionBizToggle() && getMiniProgramOpenRetryToggle() && isRealizeNetworkProxy();
    }

    public final boolean isRegionNetworkProxyEnable() {
        return getRegionBizToggle() && getCommonNetworkProxyRegisterToggle();
    }

    public final boolean regionRPCEnable() {
        return getRegionBizToggle() && getMiniProgramRegionRPCToggle() && isRealizeNetworkProxy();
    }
}
