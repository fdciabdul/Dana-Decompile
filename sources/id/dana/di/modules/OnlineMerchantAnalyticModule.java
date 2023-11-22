package id.dana.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker;
import id.dana.onlinemerchant.tracker.OnlineMerchantMixpanelTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/di/modules/OnlineMerchantAnalyticModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "MyBillsEntityDataFactory", "(Landroid/content/Context;)Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class OnlineMerchantAnalyticModule {
    @Provides
    public final OnlineMerchantAnalyticTracker MyBillsEntityDataFactory(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new OnlineMerchantMixpanelTracker(p0);
    }
}
