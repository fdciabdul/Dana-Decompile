package com.iap.ac.android.biz.common.configcenter;

import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.internal.foundation.facade.LogFacade;
import com.iap.ac.android.biz.common.rpc.ssl.IAPSslPinner;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.account.ACUserInfo;
import com.iap.ac.android.common.account.ACUserInfoManager;
import com.iap.ac.android.common.config.ACConfig;
import com.iap.ac.android.common.config.IConfigChangeListener;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public enum ConfigCenter implements IConfigChangeListener {
    INSTANCE;

    public JSONObject mConfigs;
    public boolean mFirstTriggerAMCS = true;

    ConfigCenter() {
    }

    private JSONObject getACBizRequestConfig() {
        return (JSONObject) getKeyOrDefault(Constant.KEY_ACBIZ_REQUEST_CONFIG, new JSONObject());
    }

    private void setLogGateWayUrl() {
        LogFacade.setLogGateWayUrl();
    }

    private void setLogStrategy() {
        LogFacade.setLogStrategy((String) getKeyOrDefault("log", ""));
    }

    private void setUserInfo() {
        ACUserInfo aCUserInfo = new ACUserInfo();
        aCUserInfo.openId = ACManager.getInstance().fetch(ACManager.getInstance().getOpenIdStorageKey("ac_biz"));
        ACUserInfoManager.getInstance("ac_biz").setUserInfo(aCUserInfo);
    }

    public final List<String> getAcCertificates() {
        try {
            JSONArray jSONArray = (JSONArray) getKeyOrDefault(Constant.KEY_AC_CER_LIST, new JSONArray());
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            ACLog.e(Constants.TAG, "getAcCertificates error", th);
            return null;
        }
    }

    public final JSONObject getAcsAcquirerIdMap() {
        return (JSONObject) getKeyOrDefault(Constant.KEY_AC_ACQUIRERID_MAP, new JSONObject());
    }

    public final List<String> getAcsAppIdList() {
        JSONArray jSONArray = (JSONArray) getKeyOrDefault(Constant.KEY_AC_APPID_LIST, new JSONArray());
        int length = jSONArray.length();
        if (length > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                try {
                    arrayList.add(jSONArray.getString(i));
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getAcsAppIdList error:");
                    sb.append(th);
                    ACLog.e(Constants.TAG, sb.toString());
                    return null;
                }
            }
            return arrayList;
        }
        return null;
    }

    public final List<String> getAuthList() {
        try {
            JSONArray jSONArray = (JSONArray) getKeyOrDefault(Constant.KEY_AC_AUTH_LIST, new JSONArray());
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            ACLog.e(Constants.TAG, "ConfigCenter#getAuthList error", th);
            return null;
        }
    }

    public final List<String> getDomains(String str) {
        try {
            Map map = (Map) JsonUtils.fromJson((JSONObject) getKeyOrDefault(Constant.KEY_JS_PERMISSION, new JSONObject()), Map.class);
            if (map != null) {
                return (List) map.get(str);
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("getDomains error:");
            sb.append(th);
            ACLog.e(Constants.TAG, sb.toString());
            return null;
        }
    }

    public final boolean getGolSignContractToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_GOL_SIGN_CONTRACT, Boolean.TRUE)).booleanValue();
    }

    public final <T> T getKeyOrDefault(String str, T t) {
        synchronized (this) {
            JSONObject jSONObject = this.mConfigs;
            if (jSONObject == null) {
                return t;
            }
            try {
                T t2 = (T) jSONObject.get(str);
                if (t2 != null && t2.getClass() == t.getClass()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ConfigCenter, get value from config center success, key: ");
                    sb.append(str);
                    sb.append(", value: ");
                    sb.append(t2);
                    ACLog.i(Constants.TAG, sb.toString());
                    return t2;
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getKeyOrDefault exception: ");
                sb2.append(th);
                ACLog.e(Constants.TAG, sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ConfigCenter, get value from config center fail, key: ");
            sb3.append(str);
            sb3.append(", use default value.");
            ACLog.e(Constants.TAG, sb3.toString());
            return t;
        }
    }

    public final Map getMap(String str, Map map) {
        synchronized (this) {
            try {
                Map map2 = (Map) JsonUtils.fromJson((JSONObject) getKeyOrDefault(str, new JSONObject(map)), Map.class);
                if (map2 != null) {
                    return map2;
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("getMap exception:");
                sb.append(th);
                ACLog.e(Constants.TAG, sb.toString());
            }
            return map;
        }
    }

    public final boolean getMpmGofCollectionOrderToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_MPM_GOF_COLLECTION_ORDER, Boolean.TRUE)).booleanValue();
    }

    public final boolean getMpmGofOrderToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_MPM_GOF_ORDER, Boolean.TRUE)).booleanValue();
    }

    public final boolean getMpmGolOrderToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_MPM_GOL_ORDER, Boolean.TRUE)).booleanValue();
    }

    public final boolean getMpmMiniAppToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_MPM_MINI_APP, Boolean.TRUE)).booleanValue();
    }

    public final long getMultiLanguageCacheExpirationTime() {
        return ((Long) getKeyOrDefault(Constant.KEY_AC_MULTILANGUAGE_CACHE_EXPIRATION_TIME, 86400000L)).longValue();
    }

    public final String getNewGateWayUrl() {
        JSONObject aCBizRequestConfig = getACBizRequestConfig();
        try {
            return (aCBizRequestConfig.has(Constant.KEY_NEW_GATEWAYURL) && (aCBizRequestConfig.get(Constant.KEY_NEW_GATEWAYURL) instanceof String)) ? (String) aCBizRequestConfig.get(Constant.KEY_NEW_GATEWAYURL) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public final String getOldGateWayUrl() {
        JSONObject aCBizRequestConfig = getACBizRequestConfig();
        try {
            return (aCBizRequestConfig.has(Constant.KEY_OLD_GATEWAYURL) && (aCBizRequestConfig.get(Constant.KEY_OLD_GATEWAYURL) instanceof String)) ? (String) aCBizRequestConfig.get(Constant.KEY_OLD_GATEWAYURL) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public final List getRegionMiniAppList() {
        JSONArray optJSONArray = ((JSONObject) INSTANCE.getKeyOrDefault("region_config", new JSONObject())).optJSONArray("APRegionRPCMiniProgramWhiteList");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.opt(i));
            }
            return arrayList;
        }
        return null;
    }

    public final long getRemoteConfigRefreshInterval() {
        return Utils.stringToLong((String) getKeyOrDefault(Constant.KEY_REMOTE_CONFIG_REFRESH_INTERVAL, ""), 60L) * 60000;
    }

    public final List<String> getURLInterceptRules() {
        JSONObject aCBizRequestConfig = getACBizRequestConfig();
        try {
            if (aCBizRequestConfig.has("operationTypeContainRules")) {
                Object obj = aCBizRequestConfig.get("operationTypeContainRules");
                if (obj instanceof JSONArray) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = (JSONArray) obj;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.optString(i));
                    }
                    return arrayList;
                }
            }
        } catch (Exception unused) {
        }
        return new ArrayList();
    }

    public final void init() {
        this.mConfigs = ACConfig.getInstance("ac_biz").getSectionConfig("ACConfig");
        setLogStrategy();
        setLogGateWayUrl();
        setUserInfo();
        ACConfig.getInstance("ac_biz").addSectionConfigChangeListener("ACConfig", this);
        ACConfig.getInstance("ac_biz").addSectionConfigChangeListener(Constant.SECTION_LOG_CONFIG, this);
    }

    public final boolean isACPrepareOptimizedEnable() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_ACPREPARE_OPTIMIZED_ENABLE, Boolean.FALSE)).booleanValue();
    }

    public final boolean isOAuthOptimizedEnable() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_OAUTH_OPTIMIZED_ENABLE, Boolean.FALSE)).booleanValue();
    }

    public final boolean isRewardsInterceptorDisable() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_APLUSREWARDS_INTERCEPTOR_DISABLE, Boolean.FALSE)).booleanValue();
    }

    public final boolean isToggleNewSourceSite() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_NEW_SOURCE_SITE, Boolean.TRUE)).booleanValue();
    }

    public final boolean isUrlInterceptEnalbe() {
        return getACBizRequestConfig().optBoolean("enabled", false);
    }

    @Override // com.iap.ac.android.common.config.IConfigChangeListener
    public final void onConfigChanged(String str, Object obj) {
        StringBuilder a2 = a.a("value:");
        a2.append(obj == null ? "null" : obj.toString());
        ACLog.e(com.alipay.zoloz.config.ConfigCenter.TAG, a2.toString());
    }

    @Override // com.iap.ac.android.common.config.IConfigChangeListener
    public final void onSectionConfigChanged(String str, JSONObject jSONObject) {
        str.hashCode();
        if (str.equals(Constant.SECTION_LOG_CONFIG)) {
            setLogGateWayUrl();
        } else if (str.equals("ACConfig")) {
            this.mConfigs = jSONObject;
            setLogStrategy();
            if (getSslPinningToggle()) {
                IAPSslPinner.INSTANCE.enableSslPinning();
            } else {
                IAPSslPinner.INSTANCE.disableSslPinning();
            }
            List<String> acCertificates = getAcCertificates();
            if (acCertificates == null || acCertificates.size() <= 0) {
                return;
            }
            IAPSslPinner.INSTANCE.addCertificates(acCertificates);
        }
    }

    public final void refreshConfigs() {
        if (!ACManager.getInstance().getAMCSToggle()) {
            ACLog.e(Constants.TAG, "refreshConfigs, skip refresh because close AMCS toggle is false");
        } else if (this.mFirstTriggerAMCS) {
            ACConfig.getInstance("ac_biz").refreshConfig(null, false);
            this.mFirstTriggerAMCS = false;
        } else {
            ACConfig.getInstance("ac_biz").refreshConfig(null, true);
        }
    }

    public final boolean getACContainerToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_ACCONTAINER, Boolean.TRUE)).booleanValue();
    }

    public final boolean getGoogleInvokeImgsApi() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_GOOGLE_INVOKE_IMGSAPI, Boolean.FALSE)).booleanValue();
    }

    public final boolean getIsvToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_ISV_AD_PAGE, Boolean.FALSE)).booleanValue();
    }

    public final boolean getLoadingGolGoogleAuthToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_LOADING_GOL_GOOGLE_AUTH, Boolean.TRUE)).booleanValue();
    }

    public final boolean getLoadingSpiToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_LOADING_SPI, Boolean.TRUE)).booleanValue();
    }

    public final boolean getOfflineCodeToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_CPM_OFFLINE, Boolean.TRUE)).booleanValue();
    }

    public final boolean getOnlineCodeToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_CPM_ONLINE, Boolean.TRUE)).booleanValue();
    }

    public final boolean getRegionCodeToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_REGION_CODE_TOGGLE, Boolean.FALSE)).booleanValue();
    }

    public final boolean getSslPinningToggle() {
        return ((Boolean) getKeyOrDefault(Constant.KEY_TOGGLE_SSL_PINNING, Boolean.FALSE)).booleanValue();
    }
}
