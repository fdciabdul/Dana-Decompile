package id.dana.data.csatsurvey.repository.source;

import dagger.internal.Factory;
import id.dana.data.csatsurvey.repository.source.network.NetworkDismissCsatSurveyEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DismissCsatSurveyDataFactory_Factory implements Factory<DismissCsatSurveyDataFactory> {
    private final Provider<NetworkDismissCsatSurveyEntityData> MyBillsEntityDataFactory;

    private DismissCsatSurveyDataFactory_Factory(Provider<NetworkDismissCsatSurveyEntityData> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static DismissCsatSurveyDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<NetworkDismissCsatSurveyEntityData> provider) {
        return new DismissCsatSurveyDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DismissCsatSurveyDataFactory(this.MyBillsEntityDataFactory.get());
    }
}
