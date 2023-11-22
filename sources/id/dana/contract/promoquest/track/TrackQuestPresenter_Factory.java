package id.dana.contract.promoquest.track;

import dagger.internal.Factory;
import id.dana.contract.promoquest.track.TrackQuestContract;
import id.dana.domain.promoquest.interactor.TrackUserQuest;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TrackQuestPresenter_Factory implements Factory<TrackQuestPresenter> {
    private final Provider<TrackQuestContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<TrackUserQuest> MyBillsEntityDataFactory;

    private TrackQuestPresenter_Factory(Provider<TrackQuestContract.View> provider, Provider<TrackUserQuest> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static TrackQuestPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<TrackQuestContract.View> provider, Provider<TrackUserQuest> provider2) {
        return new TrackQuestPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TrackQuestPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
