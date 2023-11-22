package id.dana.data.foundation.amcs;

import android.content.Context;
import com.alipay.iap.android.common.securityprofiles.extractor.SecurityProfileExtractor;
import com.alipay.iap.android.common.securityprofiles.profile.SyncProfile;
import com.alipay.iap.android.common.syncintegration.SyncIntegration;
import com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher;
import com.iap.ac.config.lite.utils.ConfigUtils;
import id.dana.utils.exception.CallableReturnNullError;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR\u0012\u0010\r\u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/foundation/amcs/SyncUtils;", "", "Landroid/content/Context;", "p0", "", "p1", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/alipay/iap/android/common/syncintegration/lifecycle/LifecycleWatcher;", "MyBillsEntityDataFactory", "Lcom/alipay/iap/android/common/syncintegration/lifecycle/LifecycleWatcher;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SyncUtils {
    public static final SyncUtils INSTANCE = new SyncUtils();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public static LifecycleWatcher PlaceComponentResult;

    private SyncUtils() {
    }

    static {
        LifecycleWatcher newValidWatcher = LifecycleWatcher.newValidWatcher();
        Intrinsics.checkNotNullExpressionValue(newValidWatcher, "");
        PlaceComponentResult = newValidWatcher;
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(final Context p0, final String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        final SecurityProfileExtractor securityProfileExtractor = new SecurityProfileExtractor(p0, p2);
        Single PlaceComponentResult2 = Single.PlaceComponentResult(new Callable() { // from class: id.dana.data.foundation.amcs.SyncUtils$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SyncUtils.MyBillsEntityDataFactory(SecurityProfileExtractor.this, p1);
            }
        });
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(PlaceComponentResult2, MyBillsEntityDataFactory));
        Scheduler PlaceComponentResult3 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult3, "scheduler is null");
        RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory, PlaceComponentResult3)).MyBillsEntityDataFactory(new Consumer() { // from class: id.dana.data.foundation.amcs.SyncUtils$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SyncUtils.MyBillsEntityDataFactory(p0, (SyncProfile) obj);
            }
        }, new Consumer() { // from class: id.dana.data.foundation.amcs.SyncUtils$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                DanaLog.BuiltInFictitiousFunctionClassFactory("SyncUtils", "SyncProfile is null, will not start sync trigger!!");
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Context context, SyncProfile syncProfile) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(syncProfile, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(syncProfile, "");
        StringBuilder sb = new StringBuilder();
        sb.append("syncProfile: ");
        sb.append(ConfigUtils.toJSONString(syncProfile));
        DanaLog.MyBillsEntityDataFactory("SyncUtils", sb.toString());
        SyncIntegration.instance().initialize(context, syncProfile);
        PlaceComponentResult.addCallback(new LifecycleWatcher.Callback() { // from class: id.dana.data.foundation.amcs.SyncUtils$startForegroundSwitchCallback$1
            @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher.Callback
            public final void onAppToForeground() {
                SyncIntegration.instance().appToForeground();
            }

            @Override // com.alipay.iap.android.common.syncintegration.lifecycle.LifecycleWatcher.Callback
            public final void onAppToBackground() {
                SyncIntegration.instance().appToBackground();
            }
        });
        PlaceComponentResult.startWatcher(context);
        if (PlaceComponentResult.isAppForeground()) {
            SyncIntegration.instance().appToForeground();
        }
    }

    public static /* synthetic */ SyncProfile MyBillsEntityDataFactory(SecurityProfileExtractor securityProfileExtractor, String str) {
        Intrinsics.checkNotNullParameter(securityProfileExtractor, "");
        Intrinsics.checkNotNullParameter(str, "");
        SyncProfile createSyncProfile = securityProfileExtractor.createSyncProfile(str);
        if (createSyncProfile != null) {
            return createSyncProfile;
        }
        throw new CallableReturnNullError("SyncUtils#initializeSync");
    }
}
