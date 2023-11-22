package id.dana.data.csatsurvey.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CsatSurveyCreatedDatePreference_Factory implements Factory<CsatSurveyCreatedDatePreference> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    private CsatSurveyCreatedDatePreference_Factory(Provider<Context> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static CsatSurveyCreatedDatePreference_Factory PlaceComponentResult(Provider<Context> provider) {
        return new CsatSurveyCreatedDatePreference_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CsatSurveyCreatedDatePreference(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
