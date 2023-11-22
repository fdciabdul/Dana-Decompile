package id.dana.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitModule_ProvideSplitPreference$app_productionReleaseFactory implements Factory<PreferenceFacade> {
    private final Provider<Context> MyBillsEntityDataFactory;
    private final SplitModule PlaceComponentResult;

    private SplitModule_ProvideSplitPreference$app_productionReleaseFactory(SplitModule splitModule, Provider<Context> provider) {
        this.PlaceComponentResult = splitModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static SplitModule_ProvideSplitPreference$app_productionReleaseFactory PlaceComponentResult(SplitModule splitModule, Provider<Context> provider) {
        return new SplitModule_ProvideSplitPreference$app_productionReleaseFactory(splitModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
