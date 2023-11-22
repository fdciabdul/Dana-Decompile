package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.promoquest.track.TrackQuestContract;

/* loaded from: classes4.dex */
public final class TrackQuestModule_ProvideTrackQuestViewFactory implements Factory<TrackQuestContract.View> {
    private final TrackQuestModule MyBillsEntityDataFactory;

    private TrackQuestModule_ProvideTrackQuestViewFactory(TrackQuestModule trackQuestModule) {
        this.MyBillsEntityDataFactory = trackQuestModule;
    }

    public static TrackQuestModule_ProvideTrackQuestViewFactory getAuthRequestContext(TrackQuestModule trackQuestModule) {
        return new TrackQuestModule_ProvideTrackQuestViewFactory(trackQuestModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TrackQuestContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
