package id.dana.contract.deeplink.path;

import android.app.Activity;
import com.google.firebase.perf.metrics.Trace;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.deeplink.tracker.DeeplinkRedirectionValue;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.PerActivity;
import id.dana.oauth.OauthLoginManager;
import id.dana.oauth.activity.InputNameActivity;
import id.dana.oauth.activity.OauthGrantActivity;
import id.dana.oauth.mapper.OauthModelMapperKt;
import id.dana.oauth.model.OauthParamsModel;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J5\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\n\u001a\u00020\u00072\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\n\u0010\fJ#\u0010\r\u001a\u00020\u00072\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\r\u0010\fR\u0014\u0010\n\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureOauth;", "", "Landroid/app/Activity;", "p0", "", "", "p1", "", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;Ljava/util/Map;Z)V", "(Ljava/util/Map;)Z", "getAuthRequestContext", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "<init>", "(Lid/dana/contract/deeplink/tracker/DeeplinkTracker;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class FeatureOauth {
    private final DeeplinkTracker BuiltInFictitiousFunctionClassFactory;

    @Inject
    public FeatureOauth(DeeplinkTracker deeplinkTracker) {
        Intrinsics.checkNotNullParameter(deeplinkTracker, "");
        this.BuiltInFictitiousFunctionClassFactory = deeplinkTracker;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(Activity p0, Map<String, String> p1, boolean p2) {
        if (p0 != null) {
            OauthParamsModel BuiltInFictitiousFunctionClassFactory = OauthModelMapperKt.BuiltInFictitiousFunctionClassFactory(p1);
            OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
            OauthLoginManager.isLayoutRequested();
            FirebasePerformanceMonitor MyBillsEntityDataFactory = FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
            Intrinsics.checkNotNullParameter("binding_gn", "");
            Trace trace = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.get("binding_gn");
            if (trace != null) {
                trace.stop();
            }
            if (!BuiltInFictitiousFunctionClassFactory(p1)) {
                if (getAuthRequestContext(p1)) {
                    DeeplinkTracker deeplinkTracker = this.BuiltInFictitiousFunctionClassFactory;
                    String str = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext;
                    deeplinkTracker.KClassImpl$Data$declaredNonStaticMembers$2(str != null ? str : "", DeeplinkRedirectionValue.AGREEMENT, "None");
                    OauthGrantActivity.Companion companion = OauthGrantActivity.INSTANCE;
                    OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
                    OauthLoginManager.PrepareContext();
                    p0.startActivity(OauthGrantActivity.Companion.MyBillsEntityDataFactory(p0, BuiltInFictitiousFunctionClassFactory, p2));
                    return;
                }
                return;
            }
            DeeplinkTracker deeplinkTracker2 = this.BuiltInFictitiousFunctionClassFactory;
            String str2 = DeeplinkSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext;
            deeplinkTracker2.KClassImpl$Data$declaredNonStaticMembers$2(str2 != null ? str2 : "", DeeplinkRedirectionValue.INPUT_NICKNAME, "None");
            InputNameActivity.Companion companion2 = InputNameActivity.INSTANCE;
            p0.startActivity(InputNameActivity.Companion.BuiltInFictitiousFunctionClassFactory(p0, BuiltInFictitiousFunctionClassFactory, p2));
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Map<String, String> p0) {
        return (Intrinsics.areEqual(String.valueOf(Boolean.TRUE), p0.get(BranchLinkConstant.Params.PREMIUM_USER)) || Intrinsics.areEqual(String.valueOf(Boolean.TRUE), p0.get(BranchLinkConstant.Params.HAS_NICKNAME)) || Intrinsics.areEqual(String.valueOf(Boolean.TRUE), p0.get(BranchLinkConstant.Params.IGNORE_NICKNAME))) ? false : true;
    }

    private static boolean getAuthRequestContext(Map<String, String> p0) {
        boolean areEqual = Intrinsics.areEqual(String.valueOf(Boolean.TRUE), p0.get(BranchLinkConstant.Params.HAS_NICKNAME));
        boolean areEqual2 = Intrinsics.areEqual(String.valueOf(Boolean.TRUE), p0.get(BranchLinkConstant.Params.PREMIUM_USER));
        return Intrinsics.areEqual(String.valueOf(Boolean.TRUE), p0.get(BranchLinkConstant.Params.IGNORE_NICKNAME)) || areEqual2 || (!areEqual2 && areEqual);
    }
}
