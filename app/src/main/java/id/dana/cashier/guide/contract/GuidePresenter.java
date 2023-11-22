package id.dana.cashier.guide.contract;

import id.dana.cashier.domain.interactor.GetCdpGuide;
import id.dana.cashier.guide.contract.GuideContract;
import id.dana.domain.promotion.Space;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/cashier/guide/contract/GuidePresenter;", "Lid/dana/cashier/guide/contract/GuideContract$Presenter;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "onDestroy", "()V", "Lid/dana/cashier/domain/interactor/GetCdpGuide;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/domain/interactor/GetCdpGuide;", "Lid/dana/cashier/guide/contract/GuideContract$View;", "PlaceComponentResult", "Lid/dana/cashier/guide/contract/GuideContract$View;", "p1", "<init>", "(Lid/dana/cashier/guide/contract/GuideContract$View;Lid/dana/cashier/domain/interactor/GetCdpGuide;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuidePresenter implements GuideContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetCdpGuide MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GuideContract.View BuiltInFictitiousFunctionClassFactory;

    @Inject
    public GuidePresenter(GuideContract.View view, GetCdpGuide getCdpGuide) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getCdpGuide, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = getCdpGuide;
    }

    @Override // id.dana.cashier.guide.contract.GuideContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.execute(p0, new Function1<Space, Unit>() { // from class: id.dana.cashier.guide.contract.GuidePresenter$getCdpGuide$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Space space) {
                invoke2(space);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Space space) {
                GuideContract.View view;
                Intrinsics.checkNotNullParameter(space, "");
                view = GuidePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.PlaceComponentResult(space);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.guide.contract.GuidePresenter$getCdpGuide$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                GuideContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = GuidePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
