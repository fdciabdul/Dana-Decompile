package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.promoquest.track.TrackQuestContract;
import id.dana.contract.promoquest.track.TrackQuestPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class TrackQuestModule {
    private final TrackQuestContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public TrackQuestContract.Presenter BuiltInFictitiousFunctionClassFactory(TrackQuestPresenter trackQuestPresenter) {
        return trackQuestPresenter;
    }

    public TrackQuestModule(TrackQuestContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public TrackQuestContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
