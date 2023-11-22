package id.dana.contract.deeplink.path;

import android.app.Activity;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.lazada.LazadaGuideActivity;
import id.dana.lazada.model.MiniAppParamsModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureMiniApp;", "", "Landroid/app/Activity;", "p0", "", "", "p1", "", "getAuthRequestContext", "(Landroid/app/Activity;Ljava/util/Map;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureMiniApp {
    public static final FeatureMiniApp INSTANCE = new FeatureMiniApp();

    private FeatureMiniApp() {
    }

    @JvmStatic
    public static final void getAuthRequestContext(Activity p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p1.get(BranchLinkConstant.MiniAppParams.NEED_OAUTH);
        boolean parseBoolean = str != null ? Boolean.parseBoolean(str) : false;
        String str2 = p1.get("clientId");
        String str3 = str2 == null ? "" : str2;
        String str4 = p1.get("redirectUrl");
        String str5 = str4 == null ? "" : str4;
        String str6 = p1.get("scopes");
        String str7 = str6 == null ? "" : str6;
        String str8 = p1.get("bizType");
        p0.startActivity(LazadaGuideActivity.createIntent(p0, new MiniAppParamsModel(parseBoolean, str3, str5, str7, str8 == null ? "" : str8)));
    }
}
