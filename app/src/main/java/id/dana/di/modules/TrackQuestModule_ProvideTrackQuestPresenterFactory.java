package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.track.TrackQuestContract;
import id.dana.contract.promoquest.track.TrackQuestPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TrackQuestModule_ProvideTrackQuestPresenterFactory implements Factory<TrackQuestContract.Presenter> {
    private final TrackQuestModule MyBillsEntityDataFactory;
    private final Provider<TrackQuestPresenter> getAuthRequestContext;

    private TrackQuestModule_ProvideTrackQuestPresenterFactory(TrackQuestModule trackQuestModule, Provider<TrackQuestPresenter> provider) {
        this.MyBillsEntityDataFactory = trackQuestModule;
        this.getAuthRequestContext = provider;
    }

    public static TrackQuestModule_ProvideTrackQuestPresenterFactory BuiltInFictitiousFunctionClassFactory(TrackQuestModule trackQuestModule, Provider<TrackQuestPresenter> provider) {
        return new TrackQuestModule_ProvideTrackQuestPresenterFactory(trackQuestModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TrackQuestContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
