package id.dana.sendmoney.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCorePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/sendmoney/di/module/SendMoneyCoreModule;", "", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCorePresenter;", "p0", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/core/presenter/SendMoneyCorePresenter;)Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$Presenter;", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;", "<init>", "(Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class SendMoneyCoreModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SendMoneyCoreContract.View BuiltInFictitiousFunctionClassFactory;

    public SendMoneyCoreModule(SendMoneyCoreContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final SendMoneyCoreContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    public final SendMoneyCoreContract.Presenter BuiltInFictitiousFunctionClassFactory(SendMoneyCorePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
