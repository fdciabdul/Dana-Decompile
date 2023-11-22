package id.dana.miniprogram.di;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.miniprogram.interactor.GetMiniPrograms;
import id.dana.domain.miniprogram.interactor.SetFavoriteMiniPrograms;
import id.dana.domain.miniprogram.interactor.SetRecentMiniProgram;
import id.dana.miniprogram.di.MiniProgramContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class MiniProgramPresenter_Factory implements Factory<MiniProgramPresenter> {
    private final Provider<MiniProgramContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SetFavoriteMiniPrograms> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetMiniPrograms> MyBillsEntityDataFactory;
    private final Provider<SetRecentMiniProgram> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MiniProgramPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
