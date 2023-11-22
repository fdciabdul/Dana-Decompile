package id.dana.globalnetwork;

import com.alibaba.griver.api.common.webview.GriverUserAgentExtension;
import com.alibaba.griver.api.ui.share.GriverShareMenu4PageExtension;
import com.alibaba.griver.api.ui.share.GriverShareURLCreatorExtension;
import com.alibaba.griver.base.common.bridge.GriverAppLanguageExtension;
import com.alibaba.griver.base.common.bridge.GriverHttpRequestAPIExtension;
import dagger.Lazy;
import id.dana.DanaApplication;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.extension.DanaGriverAppLanguageExtension;
import id.dana.danah5.extension.DanaGriverShareMenuExtension;
import id.dana.danah5.extension.DanaGriverShareURLCreatorExtension;
import id.dana.danah5.extension.DanaGriverUserAgentExtension;
import id.dana.danah5.httprequest.HttpRequestExtension;
import id.dana.domain.danah5.interactor.OpenH5;
import id.dana.domain.featureconfig.interactor.GetMarmotConfig;
import id.dana.domain.geocode.interactor.GetLatestSubdivision;
import id.dana.globalnetworkproxy.GlobalNetworkProxyContract;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0087\"¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0087\"¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\tX\u0087\"¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\tX\u0087\"¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\tX\u0087\"¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\tX\u0087\"¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\tX\u0087\"¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\tX\u0087\"¢\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\tX\u0087\"¢\u0006\u0006\n\u0004\b\u001c\u0010\f"}, d2 = {"Lid/dana/globalnetwork/AlipayConnectInitializer;", "", "", "getAuthRequestContext", "()V", "Lid/dana/DanaApplication;", "MyBillsEntityDataFactory", "Lid/dana/DanaApplication;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ldagger/Lazy;", "Lid/dana/danah5/extension/DanaGriverAppLanguageExtension;", "danaGriverAppLanguageExtension", "Ldagger/Lazy;", "Lid/dana/danah5/extension/DanaGriverShareURLCreatorExtension;", "danaGriverShareURLCreatorExtension", "Lid/dana/danah5/extension/DanaGriverUserAgentExtension;", "danaGriverUserAgentExtension", "Lid/dana/danah5/extension/DanaGriverShareMenuExtension;", "danaShareMenuExtension", "Lid/dana/domain/geocode/interactor/GetLatestSubdivision;", "getLatestSubdivision", "Lid/dana/domain/featureconfig/interactor/GetMarmotConfig;", "getMarmotConfig", "Lid/dana/globalnetworkproxy/GlobalNetworkProxyContract$Presenter;", "globalNetworkProxyPresenter", "Lid/dana/danah5/httprequest/HttpRequestExtension;", BridgeName.HTTP_REQUEST_EXTENSION, "Lid/dana/domain/danah5/interactor/OpenH5;", "openH5Lazy", "p0", "<init>", "(Lid/dana/DanaApplication;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AlipayConnectInitializer {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final DanaApplication KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public Lazy<DanaGriverAppLanguageExtension> danaGriverAppLanguageExtension;
    @Inject
    public Lazy<DanaGriverShareURLCreatorExtension> danaGriverShareURLCreatorExtension;
    @Inject
    public Lazy<DanaGriverUserAgentExtension> danaGriverUserAgentExtension;
    @Inject
    public Lazy<DanaGriverShareMenuExtension> danaShareMenuExtension;
    @Inject
    public Lazy<GetLatestSubdivision> getLatestSubdivision;
    @Inject
    public Lazy<GetMarmotConfig> getMarmotConfig;
    @Inject
    public Lazy<GlobalNetworkProxyContract.Presenter> globalNetworkProxyPresenter;
    @Inject
    public Lazy<HttpRequestExtension> httpRequestExtension;
    @Inject
    public Lazy<OpenH5> openH5Lazy;

    public AlipayConnectInitializer(DanaApplication danaApplication) {
        Intrinsics.checkNotNullParameter(danaApplication, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaApplication;
    }

    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getApplicationComponent().getAuthRequestContext(this);
        Lazy<GlobalNetworkProxyContract.Presenter> lazy = this.globalNetworkProxyPresenter;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        lazy.get().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ Map PlaceComponentResult(AlipayConnectInitializer alipayConnectInitializer) {
        HashMap hashMap = new HashMap();
        Lazy<HttpRequestExtension> lazy = alipayConnectInitializer.httpRequestExtension;
        Lazy<DanaGriverShareMenuExtension> lazy2 = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        hashMap.put(GriverHttpRequestAPIExtension.class, lazy);
        Lazy<DanaGriverAppLanguageExtension> lazy3 = alipayConnectInitializer.danaGriverAppLanguageExtension;
        if (lazy3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy3 = null;
        }
        hashMap.put(GriverAppLanguageExtension.class, lazy3);
        Lazy<DanaGriverUserAgentExtension> lazy4 = alipayConnectInitializer.danaGriverUserAgentExtension;
        if (lazy4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy4 = null;
        }
        hashMap.put(GriverUserAgentExtension.class, lazy4);
        Lazy<DanaGriverShareURLCreatorExtension> lazy5 = alipayConnectInitializer.danaGriverShareURLCreatorExtension;
        if (lazy5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy5 = null;
        }
        hashMap.put(GriverShareURLCreatorExtension.class, lazy5);
        Lazy<DanaGriverShareMenuExtension> lazy6 = alipayConnectInitializer.danaShareMenuExtension;
        if (lazy6 != null) {
            lazy2 = lazy6;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        hashMap.put(GriverShareMenu4PageExtension.class, lazy2);
        return hashMap;
    }
}
