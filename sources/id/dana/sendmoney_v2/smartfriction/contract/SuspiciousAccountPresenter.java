package id.dana.sendmoney_v2.smartfriction.contract;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.sendmoney.interactor.GetStateSuspiciousAccountSmartFriction;
import id.dana.domain.sendmoney.interactor.SaveStateSuspiciousAccountSmartFriction;
import id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountPresenter;", "Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$Presenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "onDestroy", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)V", "Lid/dana/domain/sendmoney/interactor/GetStateSuspiciousAccountSmartFriction;", "MyBillsEntityDataFactory", "Lid/dana/domain/sendmoney/interactor/GetStateSuspiciousAccountSmartFriction;", "PlaceComponentResult", "Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction;", "Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction;", "Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$View;", "p1", "p2", "<init>", "(Lid/dana/sendmoney_v2/smartfriction/contract/SuspiciousAccountContract$View;Lid/dana/domain/sendmoney/interactor/GetStateSuspiciousAccountSmartFriction;Lid/dana/domain/sendmoney/interactor/SaveStateSuspiciousAccountSmartFriction;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SuspiciousAccountPresenter implements SuspiciousAccountContract.Presenter {
    private final SuspiciousAccountContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetStateSuspiciousAccountSmartFriction PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SaveStateSuspiciousAccountSmartFriction MyBillsEntityDataFactory;

    @Inject
    public SuspiciousAccountPresenter(SuspiciousAccountContract.View view, GetStateSuspiciousAccountSmartFriction getStateSuspiciousAccountSmartFriction, SaveStateSuspiciousAccountSmartFriction saveStateSuspiciousAccountSmartFriction) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getStateSuspiciousAccountSmartFriction, "");
        Intrinsics.checkNotNullParameter(saveStateSuspiciousAccountSmartFriction, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.PlaceComponentResult = getStateSuspiciousAccountSmartFriction;
        this.MyBillsEntityDataFactory = saveStateSuspiciousAccountSmartFriction;
    }

    @Override // id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        BaseUseCase.execute$default(this.PlaceComponentResult, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountPresenter$getStateSmartFrictionSuspiciousAccount$1
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
                SuspiciousAccountContract.View view;
                view = SuspiciousAccountPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }, null, 4, null);
    }

    @Override // id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountContract.Presenter
    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseUseCase.execute$default(this.MyBillsEntityDataFactory, SaveStateSuspiciousAccountSmartFriction.Param.INSTANCE.create(true), new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney_v2.smartfriction.contract.SuspiciousAccountPresenter$saveStateSmartFrictionSuspiciousAccount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                SuspiciousAccountContract.View view;
                view = SuspiciousAccountPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.BuiltInFictitiousFunctionClassFactory(p0);
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }
}
