package id.dana.appshortcut;

import id.dana.appshortcut.DanaAppShortcutContract;
import id.dana.domain.appshortcut.interactor.GetAppShortcutConfig;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b"}, d2 = {"Lid/dana/appshortcut/DanaAppShortcutPresenter;", "Lid/dana/appshortcut/DanaAppShortcutContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "Lid/dana/domain/appshortcut/interactor/GetAppShortcutConfig;", "MyBillsEntityDataFactory", "Lid/dana/domain/appshortcut/interactor/GetAppShortcutConfig;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/appshortcut/DanaAppShortcutContract$View;", "Lid/dana/appshortcut/DanaAppShortcutContract$View;", "PlaceComponentResult", "p0", "p1", "<init>", "(Lid/dana/appshortcut/DanaAppShortcutContract$View;Lid/dana/domain/appshortcut/interactor/GetAppShortcutConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaAppShortcutPresenter implements DanaAppShortcutContract.Presenter {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DanaAppShortcutContract.View PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetAppShortcutConfig BuiltInFictitiousFunctionClassFactory;

    @Inject
    public DanaAppShortcutPresenter(DanaAppShortcutContract.View view, GetAppShortcutConfig getAppShortcutConfig) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getAppShortcutConfig, "");
        this.PlaceComponentResult = view;
        this.BuiltInFictitiousFunctionClassFactory = getAppShortcutConfig;
    }

    @Override // id.dana.appshortcut.DanaAppShortcutContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        BaseUseCase.execute$default(this.BuiltInFictitiousFunctionClassFactory, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.appshortcut.DanaAppShortcutPresenter$getGetAppShortcutEnabledFlag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                DanaAppShortcutContract.View view;
                view = DanaAppShortcutPresenter.this.PlaceComponentResult;
                view.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
