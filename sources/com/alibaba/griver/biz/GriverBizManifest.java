package com.alibaba.griver.biz;

import com.alibaba.ariver.integration.RVManifest;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.kernel.api.extension.registry.EmbedViewMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.remote.RemoteController;
import com.alibaba.ariver.kernel.api.security.AccessController;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.biz.jsapi.open.GetUserInfoBridgeExtension;
import com.alibaba.griver.biz.jsapi.open.OpenAPIBridgeExtension;
import com.alibaba.griver.biz.jsapi.scan.ScanBridgeExtension;
import com.iap.ac.android.acs.plugin.utils.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverBizManifest implements RVManifest {

    /* renamed from: a  reason: collision with root package name */
    private static final GriverBizManifest f6389a = new GriverBizManifest();

    @Override // com.alibaba.ariver.integration.RVManifest
    public AccessController getAccessController() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<AppUpdaterFactory.Rule> getAppUpdaterRules() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<BridgeDSL> getBridgeDSLs() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public Map<String, EmbedViewMetaInfo> getEmbedViews() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<ExtensionMetaInfo> getExtensions() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.IProxyManifest> getProxies() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public RemoteController getRemoteController() {
        return null;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.ServiceBeanManifest> getServiceBeans(ExtensionManager extensionManager) {
        return null;
    }

    public static RVManifest getInstance() {
        return f6389a;
    }

    @Override // com.alibaba.ariver.integration.RVManifest
    public List<RVManifest.BridgeExtensionManifest> getBridgeExtensions() {
        ArrayList arrayList = new ArrayList();
        if (ReflectUtils.classExist("com.alipay.iap.android.wallet.acl.WalletServiceManager")) {
            arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("GriverBizManifest", OpenAPIBridgeExtension.class.getName(), (List<String>) Arrays.asList(Constants.JS_API_GET_AUTH_CODE, Constants.JS_API_TRADE_PAY, Constants.JS_API_GET_COMPONENT_AUTH, "appxrpc", "crossPay")));
            arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("GriverBizManifest", GetUserInfoBridgeExtension.class.getName(), (List<String>) Arrays.asList("getUserInfo")));
            arrayList.add(RVManifest.BridgeExtensionManifest.makeRaw("GriverBizManifest", ScanBridgeExtension.class.getName(), (List<String>) Collections.singletonList("scan")));
        }
        return arrayList;
    }
}
