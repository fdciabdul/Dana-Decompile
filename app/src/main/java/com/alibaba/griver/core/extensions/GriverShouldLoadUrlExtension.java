package com.alibaba.griver.core.extensions;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.api.security.ApiPermissionCheckResult;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.ariver.permission.api.proxy.AuthenticationProxy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.page.GriverInterceptUrlEvent;
import com.alibaba.griver.api.common.page.GriverUrlNavigationEvent;
import com.alibaba.griver.api.h5.permission.GriverH5UrlInterceptedProxy;
import com.alibaba.griver.base.api.ShouldLoadUrlPoint;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.H5UrlHelper;
import com.alibaba.griver.base.common.utils.KitUtils;
import com.alibaba.griver.base.resource.utils.ErrorPageUtils;
import com.alibaba.griver.core.GriverParam;
import com.alipay.mobile.security.bio.api.BioDetector;
import id.dana.data.socialshare.ShareAppKey;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes6.dex */
public class GriverShouldLoadUrlExtension implements NodeAware<Page>, ShouldLoadUrlPoint {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f6408a;
    WeakReference<Page> pageWeakReference;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    static {
        ArrayList arrayList = new ArrayList();
        f6408a = arrayList;
        arrayList.add("tel");
        arrayList.add("mailto");
        arrayList.add(ShareAppKey.SMS);
        arrayList.add(BioDetector.EXT_KEY_GEO);
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<Page> weakReference) {
        this.pageWeakReference = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<Page> getNodeType() {
        return Page.class;
    }

    @Override // com.alibaba.griver.base.api.ShouldLoadUrlPoint
    public boolean shouldLoad(JSONObject jSONObject, String str) {
        ApiPermissionCheckResult interceptUrlForTiny;
        JSONObject configJSONObject;
        Uri parse;
        Page page = this.pageWeakReference.get();
        ExtensionPoint node = ExtensionPoint.as(GriverUrlNavigationEvent.class).node(this.pageWeakReference.get());
        Boolean bool = Boolean.FALSE;
        if (((GriverUrlNavigationEvent) node.defaultValue(bool).resolve(new ResultResolver<Boolean>() { // from class: com.alibaba.griver.core.extensions.GriverShouldLoadUrlExtension.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
            public Boolean resolve(List<Boolean> list) {
                if (list != null && list.size() != 0) {
                    for (Boolean bool2 : list) {
                        if (bool2 != null && bool2.booleanValue()) {
                            return Boolean.TRUE;
                        }
                    }
                }
                return Boolean.FALSE;
            }
        }).create()).allowLoadUrl(page, str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("url is allowLoadUrl: ");
            sb.append(str);
            GriverLogger.d("GriverShouldLoadUrlExtension", sb.toString());
            return true;
        } else if (((GriverInterceptUrlEvent) ExtensionPoint.as(GriverInterceptUrlEvent.class).node(this.pageWeakReference.get()).defaultValue(bool).resolve(new ResultResolver<Boolean>() { // from class: com.alibaba.griver.core.extensions.GriverShouldLoadUrlExtension.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
            public Boolean resolve(List<Boolean> list) {
                if (list != null && list.size() != 0) {
                    for (Boolean bool2 : list) {
                        if (bool2 != null && bool2.booleanValue()) {
                            return Boolean.TRUE;
                        }
                    }
                }
                return Boolean.FALSE;
            }
        }).create()).interceptUrl(page, str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("url is intercepted by outer: ");
            sb2.append(str);
            GriverLogger.d("GriverShouldLoadUrlExtension", sb2.toString());
            a(str);
            return false;
        } else if (((GriverUrlNavigationEvent) ExtensionPoint.as(GriverUrlNavigationEvent.class).node(this.pageWeakReference.get()).defaultValue(bool).resolve(new ResultResolver<Boolean>() { // from class: com.alibaba.griver.core.extensions.GriverShouldLoadUrlExtension.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
            public Boolean resolve(List<Boolean> list) {
                if (list != null && list.size() != 0) {
                    for (Boolean bool2 : list) {
                        if (bool2 != null && bool2.booleanValue()) {
                            return Boolean.TRUE;
                        }
                    }
                }
                return Boolean.FALSE;
            }
        }).create()).onStartUrlNavigation(page, str)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("url is intercepted by outer: ");
            sb3.append(str);
            GriverLogger.d("GriverShouldLoadUrlExtension", sb3.toString());
            a(str);
            return false;
        } else {
            WeakReference<Page> weakReference = this.pageWeakReference;
            if (weakReference == null || weakReference.get() == null) {
                GriverLogger.d("GriverShouldLoadUrlExtension", "page is null, intercepted");
                a(str);
                return false;
            } else if (TextUtils.isEmpty(str)) {
                GriverLogger.d("GriverShouldLoadUrlExtension", "url is empty, intercepted");
                a(str);
                return false;
            } else {
                boolean z = BundleUtils.getBoolean(page.getStartParams(), RVParams.isH5App, false);
                if (a(page, str, z)) {
                    GriverLogger.d("GriverShouldLoadUrlExtension", "url is intercepted by scheme");
                    a(str);
                    return false;
                } else if (z) {
                    if (str.startsWith("file:///android_asset")) {
                        return true;
                    }
                    try {
                        if (TextUtils.isEmpty(Uri.parse(str).getScheme())) {
                            a(str);
                            return false;
                        }
                    } catch (Exception e) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("intercept url ");
                        sb4.append(e.getMessage());
                        GriverLogger.e("GriverShouldLoadUrlExtension", sb4.toString());
                    }
                    if (b(str)) {
                        a(str);
                        GriverLogger.d("GriverShouldLoadUrlExtension", "intercept url isNotInWhiteList");
                        return false;
                    } else if (c(str)) {
                        a(str);
                        GriverLogger.d("GriverShouldLoadUrlExtension", "intercept url isInBlackList");
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    Uri uri = null;
                    try {
                        uri = Uri.parse(str);
                    } catch (Exception e2) {
                        GriverLogger.e("GriverShouldLoadUrlExtension", "parse url to uri failed", e2);
                    }
                    if (uri == null) {
                        GriverLogger.w("GriverShouldLoadUrlExtension", "load url intercepted for failed to parse url.");
                        return false;
                    }
                    String scheme = uri.getScheme();
                    String host = uri.getHost();
                    String path = uri.getPath();
                    if (scheme != null && f6408a.contains(scheme)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("scheme in whitelist, should load, scheme: ");
                        sb5.append(scheme);
                        GriverLogger.d("GriverShouldLoadUrlExtension", sb5.toString());
                        return true;
                    } else if (AppInfoUtils.isEmbeddedApp(page) && (parse = Uri.parse(ErrorPageUtils.getErrorStatusPageUrl())) != null && TextUtils.equals(scheme, parse.getScheme()) && TextUtils.equals(path, parse.getPath())) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("error status page, should load, scheme: ");
                        sb6.append(scheme);
                        GriverLogger.d("GriverShouldLoadUrlExtension", sb6.toString());
                        return true;
                    } else {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("url ");
                        sb7.append(str);
                        sb7.append(" scheme ");
                        sb7.append(scheme);
                        sb7.append(" host ");
                        sb7.append(host);
                        RVLogger.d("GriverShouldLoadUrlExtension", sb7.toString());
                        AuthenticationProxy authenticationProxy = (AuthenticationProxy) RVProxy.get(AuthenticationProxy.class);
                        String string = BundleUtils.getString(page.getStartParams(), "appId");
                        boolean isEmbeddedApp = AppInfoUtils.isEmbeddedApp(page);
                        if (isEmbeddedApp) {
                            interceptUrlForTiny = authenticationProxy.hasPermission(string, host, "Webview_Config_allowedDomain", page.getApp(), page);
                        } else {
                            interceptUrlForTiny = authenticationProxy.interceptUrlForTiny(str, string, page, false);
                        }
                        boolean z2 = (interceptUrlForTiny == ApiPermissionCheckResult.IGNORE || interceptUrlForTiny == ApiPermissionCheckResult.ALLOW) ? false : true;
                        if (!z2 && isEmbeddedApp && (configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.KEY_PWA_BLACK_DOMAIN_LIST)) != null && configJSONObject.size() > 0) {
                            String appId = page.getApp().getAppId();
                            if (!TextUtils.isEmpty(appId) && configJSONObject.containsKey(appId)) {
                                Iterator<Object> it = configJSONObject.getJSONArray(appId).iterator();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    if ((next instanceof String) && ((String) next).trim().equals(host)) {
                                        z2 = true;
                                    }
                                }
                            }
                        }
                        if (z2) {
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(String.format(ErrorPageUtils.getErrorStatusPageUrl(), string, Integer.valueOf((int) ErrorPageUtils.WEB_VIEW_INTERCEPTED), "MINI_PROGRAM"));
                            sb8.append("&url=");
                            sb8.append(H5UrlHelper.encode(str));
                            a(page, sb8.toString());
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append("interceptUrlForTiny\t");
                            sb9.append(str);
                            GriverLogger.e("GriverShouldLoadUrlExtension", sb9.toString());
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
    }

    private void a(final Page page, final String str) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.extensions.GriverShouldLoadUrlExtension.4
            @Override // java.lang.Runnable
            public void run() {
                if (page.isExited() || page.getRender() == null) {
                    return;
                }
                LoadParams loadParams = new LoadParams();
                loadParams.forceLoad = true;
                loadParams.url = str;
                page.getRender().load(loadParams);
            }
        });
    }

    private boolean a(Page page, String str, boolean z) {
        try {
            Uri parseUrl = UrlUtils.parseUrl(str);
            if (parseUrl == null) {
                GriverLogger.w("GriverShouldLoadUrlExtension", "load url intercepted for failed to parse url.");
                return true;
            }
            String scheme = parseUrl.getScheme();
            if (!GriverParam.ABOUT_BLANK.equals(str) && !"about".equalsIgnoreCase(scheme) && !"data".equalsIgnoreCase(scheme) && !SemanticAttributes.FaasTriggerValues.HTTP.equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme) && !"ftp".equalsIgnoreCase(scheme)) {
                if ("file".equalsIgnoreCase(scheme)) {
                    String path = parseUrl.getPath();
                    if (path != null && path.startsWith("/android_asset/")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("load asset ");
                        sb.append(path);
                        GriverLogger.d("GriverShouldLoadUrlExtension", sb.toString());
                    }
                    return false;
                } else if (c()) {
                    if (z) {
                        return a(str, scheme);
                    }
                    boolean z2 = !f6408a.contains(scheme);
                    if (z2) {
                        App app = page.getApp();
                        String appId = app != null ? app.getAppId() : "";
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.format(ErrorPageUtils.getErrorStatusPageUrl(), appId, Integer.valueOf((int) ErrorPageUtils.WEB_VIEW_SCHEME_ERROR), "MINI_PROGRAM"));
                        sb2.append("&url=");
                        sb2.append(H5UrlHelper.encode(str));
                        a(page, sb2.toString());
                    }
                    return z2;
                } else {
                    return a(str, scheme);
                }
            }
            return false;
        } catch (Exception e) {
            GriverLogger.e("GriverShouldLoadUrlExtension", "intercept url with scheme exception", e);
            return true;
        }
    }

    private boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !"javascript".equals(str2)) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                if (Build.VERSION.SDK_INT >= 15) {
                    parseUri.setSelector(null);
                }
                try {
                    Application applicationContext = GriverEnv.getApplicationContext();
                    parseUri.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    applicationContext.startActivity(parseUri);
                    StringBuilder sb = new StringBuilder();
                    sb.append("start ext app: ");
                    sb.append(str2);
                    GriverLogger.d("GriverShouldLoadUrlExtension", sb.toString());
                    return true;
                } catch (Exception e) {
                    GriverLogger.e("GriverShouldLoadUrlExtension", "exception detail", e);
                    return false;
                }
            } catch (URISyntaxException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("bad uri ");
                sb2.append(str);
                sb2.append(": ");
                sb2.append(e2.getMessage());
                GriverLogger.w("GriverShouldLoadUrlExtension", sb2.toString());
            }
        }
        return false;
    }

    private void a(String str) {
        ((GriverH5UrlInterceptedProxy) RVProxy.get(GriverH5UrlInterceptedProxy.class)).intercepted(str);
    }

    private boolean b(String str) {
        List<String> a2 = a();
        if (a2 == null || a2.size() == 0) {
            return false;
        }
        for (int i = 0; i < a2.size(); i++) {
            if (KitUtils.isDomainMatch(a2.get(i), str)) {
                return false;
            }
        }
        return true;
    }

    private boolean c(String str) {
        List<String> b = b();
        if (b != null && b.size() != 0) {
            for (int i = 0; i < b.size(); i++) {
                if (KitUtils.isDomainMatch(b.get(i), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<String> a() {
        return d("whitelist");
    }

    private List<String> b() {
        return d("blacklist");
    }

    private List<String> d(String str) {
        String config = GriverConfig.getConfig(str, "");
        ArrayList arrayList = new ArrayList();
        try {
            List parseArray = JSON.parseArray(config, String.class);
            if (parseArray != null && parseArray.size() > 0) {
                arrayList.addAll(parseArray);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse config failed: ");
            sb.append(str);
            GriverLogger.e("GriverShouldLoadUrlExtension", sb.toString(), e);
        }
        return arrayList;
    }

    private static boolean c() {
        return GriverInnerConfig.getConfigBoolean("intercept_scheme_android", false);
    }
}
