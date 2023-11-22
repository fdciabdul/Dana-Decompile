package com.alibaba.griver.h5.extension;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.h5.appinfo.GriverH5AppInfo;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.H5FileUtil;
import com.alibaba.griver.base.common.utils.KitUtils;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import com.alibaba.griver.base.resource.point.BeforeGetMainPackageResourcePoint;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class UrlMapExtension implements NodeAware<App>, BeforeGetMainPackageResourcePoint {
    WeakReference<App> appWeakReference;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.appWeakReference = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.griver.base.resource.point.BeforeGetMainPackageResourcePoint
    public ResourceQuery beforeQuery(ResourceQuery resourceQuery) {
        WeakReference<App> weakReference = this.appWeakReference;
        if (weakReference != null && weakReference.get() != null) {
            App app = this.appWeakReference.get();
            resourceQuery.pureUrl = mapUrl(resourceQuery.pureUrl, app.getAppId(), app.getAppVersion());
        }
        return resourceQuery;
    }

    public String mapUrl(String str, String str2, String str3) {
        AppModel queryAppInfo;
        GriverH5AppInfo h5AppFromAppInfo;
        StringBuilder sb = new StringBuilder();
        sb.append("load response mapUrl url = ");
        sb.append(str);
        GriverLogger.d("UrlMapExtension", sb.toString());
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String extension = H5FileUtil.getExtension(KitUtils.getFileName(str));
        if (TextUtils.isEmpty(extension) || "html".equalsIgnoreCase(extension)) {
            if (TextUtils.isEmpty(str3)) {
                queryAppInfo = GriverAppCenter.queryHighestAppInfo(str2);
            } else {
                queryAppInfo = GriverAppCenter.queryAppInfo(str2, str3);
            }
            if (queryAppInfo == null || (h5AppFromAppInfo = AppInfoUtils.getH5AppFromAppInfo(queryAppInfo)) == null) {
                return str;
            }
            String str4 = h5AppFromAppInfo.remoteURLPrefix;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load response remoteURLPrefix = ");
            sb2.append(str4);
            GriverLogger.d("UrlMapExtension", sb2.toString());
            if (!TextUtils.isEmpty(str4) && str.startsWith(str4)) {
                String str5 = h5AppFromAppInfo.type;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("load response type = ");
                sb3.append(str5);
                GriverLogger.d("UrlMapExtension", sb3.toString());
                if (GriverH5AppInfo.AppType.SPA.equalsIgnoreCase(str5)) {
                    String str6 = h5AppFromAppInfo.index;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("load response index = ");
                    sb4.append(str6);
                    GriverLogger.d("UrlMapExtension", sb4.toString());
                    if (TextUtils.isEmpty(str6)) {
                        return str;
                    }
                    if (str6.startsWith("/")) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(queryAppInfo.getAppInfoModel().getVhost());
                        sb5.append(str6);
                        return sb5.toString();
                    } else if (str6.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                        return str6;
                    } else {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(queryAppInfo.getAppInfoModel().getVhost());
                        sb6.append(File.separator);
                        sb6.append(str6);
                        return sb6.toString();
                    }
                }
                return str;
            }
            return str;
        }
        return str;
    }
}
