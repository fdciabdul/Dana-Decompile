package id.dana.tutorial;

import dagger.internal.Factory;
import id.dana.domain.danainfo.interactor.GetTutorials;
import id.dana.tutorial.TutorialContract;
import id.dana.tutorial.mapper.TutorialModelMapper;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class TutorialPresenter_Factory implements Factory<TutorialPresenter> {
    private final Provider<TutorialModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetTutorials> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<TutorialContract.View> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TutorialPresenter(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
