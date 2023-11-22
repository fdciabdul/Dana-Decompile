package id.dana.familyaccount.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FamilyAccountTrackerModule_ProvideTrackerFactory implements Factory<FamilyAccountAnalyticalTracker> {
    private final Provider<FamilyAccountMixpanelTracker> BuiltInFictitiousFunctionClassFactory;
    private final FamilyAccountTrackerModule PlaceComponentResult;

    private FamilyAccountTrackerModule_ProvideTrackerFactory(FamilyAccountTrackerModule familyAccountTrackerModule, Provider<FamilyAccountMixpanelTracker> provider) {
        this.PlaceComponentResult = familyAccountTrackerModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static FamilyAccountTrackerModule_ProvideTrackerFactory PlaceComponentResult(FamilyAccountTrackerModule familyAccountTrackerModule, Provider<FamilyAccountMixpanelTracker> provider) {
        return new FamilyAccountTrackerModule_ProvideTrackerFactory(familyAccountTrackerModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FamilyAccountAnalyticalTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
