package id.dana.paymentsetting.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.paymentsetting.tracker.PaymentSettingAnalyticalTracker;
import id.dana.paymentsetting.tracker.PaymentSettingMixpanelTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/paymentsetting/di/PaymentSettingAnalyticModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/paymentsetting/tracker/PaymentSettingAnalyticalTracker;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Lid/dana/paymentsetting/tracker/PaymentSettingAnalyticalTracker;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class PaymentSettingAnalyticModule {
    @Provides
    public final PaymentSettingAnalyticalTracker KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new PaymentSettingMixpanelTracker(p0);
    }
}
