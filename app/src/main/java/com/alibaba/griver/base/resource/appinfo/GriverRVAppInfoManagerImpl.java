package com.alibaba.griver.base.resource.appinfo;

import android.text.TextUtils;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVAppInfoManager;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.resource.appcenter.storage.GriverAppInfoStorage;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverRVAppInfoManagerImpl implements RVAppInfoManager {
    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public String findUrlMappedAppId(String str) {
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public void saveAppModelList(List<AppModel> list) {
        GriverAppInfoStorage.saveAppInfos(list);
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public AppModel getAppModel(AppInfoQuery appInfoQuery) {
        String appId = appInfoQuery.getAppId();
        String version = appInfoQuery.getVersion();
        if (TextUtils.isEmpty(version) || TextUtils.equals(version, "*")) {
            AppModel queryHighestAppInfo = GriverAppCenter.queryHighestAppInfo(appId);
            if (queryHighestAppInfo != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("getAppModel appid = ");
                sb.append(queryHighestAppInfo.getAppId());
                sb.append(" appversion = ");
                sb.append(queryHighestAppInfo.getAppVersion());
                GriverLogger.d("UsePackage", sb.toString());
            } else {
                GriverLogger.d("UsePackage", "getAppModel appinfo is null");
            }
            return queryHighestAppInfo;
        }
        AppModel queryAppInfo = GriverAppCenter.queryAppInfo(appId, version);
        if (queryAppInfo != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getAppModel has version appid = ");
            sb2.append(queryAppInfo.getAppId());
            sb2.append(" appversion = ");
            sb2.append(queryAppInfo.getAppVersion());
            GriverLogger.d("UsePackage", sb2.toString());
        } else {
            GriverLogger.d("UsePackage", "getAppModel has version appinfo is null");
        }
        return queryAppInfo;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public AppInfoModel getAppInfoModel(AppInfoQuery appInfoQuery) {
        AppModel appModel = getAppModel(appInfoQuery);
        if (appModel != null) {
            return appModel.getAppInfoModel();
        }
        return null;
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public long getLastUpdateTime(String str) {
        return GriverAppCenter.queryLastRefreshTimestamp(str);
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public void refreshUpdateTime(String str, long j) {
        GriverAppCenter.refreshUpdateTime(str, j);
    }

    @Override // com.alibaba.ariver.resource.api.proxy.RVAppInfoManager
    public String getAppType(AppModel appModel) {
        return AppInfoUtils.getAppTypeByModel(appModel).toString();
    }
}
