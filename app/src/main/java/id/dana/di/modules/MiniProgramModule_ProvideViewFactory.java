package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.miniprogram.di.MiniProgramContract;

/* loaded from: classes4.dex */
public final class MiniProgramModule_ProvideViewFactory implements Factory<MiniProgramContract.View> {
    private final MiniProgramModule MyBillsEntityDataFactory;

    private MiniProgramModule_ProvideViewFactory(MiniProgramModule miniProgramModule) {
        this.MyBillsEntityDataFactory = miniProgramModule;
    }

    public static MiniProgramModule_ProvideViewFactory PlaceComponentResult(MiniProgramModule miniProgramModule) {
        return new MiniProgramModule_ProvideViewFactory(miniProgramModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MiniProgramContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getBuiltInFictitiousFunctionClassFactory());
    }
}
