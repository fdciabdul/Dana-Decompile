package id.dana.nearbyme.merchantreview.tracker;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MerchantReviewFormMixpanelTracker_Factory implements Factory<MerchantReviewFormMixpanelTracker> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    private MerchantReviewFormMixpanelTracker_Factory(Provider<Context> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static MerchantReviewFormMixpanelTracker_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider) {
        return new MerchantReviewFormMixpanelTracker_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MerchantReviewFormMixpanelTracker(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
