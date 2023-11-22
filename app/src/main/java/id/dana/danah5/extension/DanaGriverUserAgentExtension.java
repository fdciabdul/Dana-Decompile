package id.dana.danah5.extension;

import com.alibaba.griver.api.common.webview.GriverUserAgentExtension;
import id.dana.globalnetwork.AlipayConnectHelper;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;

@Singleton
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danah5/extension/DanaGriverUserAgentExtension;", "Lcom/alibaba/griver/api/common/webview/GriverUserAgentExtension;", "", "getUserAgent", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanaGriverUserAgentExtension implements GriverUserAgentExtension {
    @Inject
    public DanaGriverUserAgentExtension() {
    }

    @Override // com.alibaba.griver.api.common.webview.GriverUserAgentExtension
    public final String getUserAgent() {
        StringBuilder sb = new StringBuilder();
        AlipayConnectHelper alipayConnectHelper = AlipayConnectHelper.INSTANCE;
        sb.append(AlipayConnectHelper.BuiltInFictitiousFunctionClassFactory());
        sb.append(" AlipayConnect iapconnectsdk/2.37.0");
        return sb.toString();
    }
}
