package id.dana.danapoly.ui.board.viewmodel;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.interactor.GetLastBackgroundColor;
import id.dana.danapoly.domain.config.interactor.GetPlayBoard;
import id.dana.danapoly.domain.config.interactor.GetPlayerInfo;
import id.dana.danapoly.domain.config.interactor.HasShownTutorial;
import id.dana.danapoly.domain.config.interactor.SaveLastBackgroundColor;
import id.dana.danapoly.domain.config.interactor.SaveShownTutorial;
import id.dana.danapoly.domain.dailycheck.interactor.FetchCheckInHistory;
import id.dana.danapoly.domain.play.interactor.PlayDanapoly;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanapolyBoardViewModel_Factory implements Factory<DanapolyBoardViewModel> {
    private final Provider<GetLastBackgroundColor> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FetchCheckInHistory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetPlayBoard> MyBillsEntityDataFactory;
    private final Provider<SaveShownTutorial> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetPlayerInfo> PlaceComponentResult;
    private final Provider<HasShownTutorial> getAuthRequestContext;
    private final Provider<PlayDanapoly> getErrorConfigVersion;
    private final Provider<SaveLastBackgroundColor> scheduleImpl;

    private DanapolyBoardViewModel_Factory(Provider<GetPlayerInfo> provider, Provider<PlayDanapoly> provider2, Provider<SaveLastBackgroundColor> provider3, Provider<GetLastBackgroundColor> provider4, Provider<GetPlayBoard> provider5, Provider<HasShownTutorial> provider6, Provider<SaveShownTutorial> provider7, Provider<FetchCheckInHistory> provider8) {
        this.PlaceComponentResult = provider;
        this.getErrorConfigVersion = provider2;
        this.scheduleImpl = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.getAuthRequestContext = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider8;
    }

    public static DanapolyBoardViewModel_Factory getAuthRequestContext(Provider<GetPlayerInfo> provider, Provider<PlayDanapoly> provider2, Provider<SaveLastBackgroundColor> provider3, Provider<GetLastBackgroundColor> provider4, Provider<GetPlayBoard> provider5, Provider<HasShownTutorial> provider6, Provider<SaveShownTutorial> provider7, Provider<FetchCheckInHistory> provider8) {
        return new DanapolyBoardViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanapolyBoardViewModel(this.PlaceComponentResult.get(), this.getErrorConfigVersion.get(), this.scheduleImpl.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
