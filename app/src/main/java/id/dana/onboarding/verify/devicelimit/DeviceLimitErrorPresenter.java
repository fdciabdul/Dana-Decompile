package id.dana.onboarding.verify.devicelimit;

import dagger.Lazy;
import id.dana.base.AbstractContractKt;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.registration.interactor.GetHelpButtonOtpLimitDevice;
import id.dana.domain.registration.model.HelpButtonOtpLimitDeviceModel;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\bR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\n0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorPresenter;", "Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "onDestroy", "Ldagger/Lazy;", "Lid/dana/domain/registration/interactor/GetHelpButtonOtpLimitDevice;", "Ldagger/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/onboarding/verify/devicelimit/DeviceLimitErrorContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceLimitErrorPresenter implements DeviceLimitErrorContract.Presenter {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<DeviceLimitErrorContract.View> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<GetHelpButtonOtpLimitDevice> BuiltInFictitiousFunctionClassFactory;

    @Inject
    public DeviceLimitErrorPresenter(Lazy<GetHelpButtonOtpLimitDevice> lazy, Lazy<DeviceLimitErrorContract.View> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.MyBillsEntityDataFactory = lazy2;
    }

    @Override // id.dana.onboarding.verify.devicelimit.DeviceLimitErrorContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<HelpButtonOtpLimitDeviceModel, Unit>() { // from class: id.dana.onboarding.verify.devicelimit.DeviceLimitErrorPresenter$getHelpButtonDeviceLimit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(HelpButtonOtpLimitDeviceModel helpButtonOtpLimitDeviceModel) {
                invoke2(helpButtonOtpLimitDeviceModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HelpButtonOtpLimitDeviceModel helpButtonOtpLimitDeviceModel) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(helpButtonOtpLimitDeviceModel, "");
                lazy = DeviceLimitErrorPresenter.this.MyBillsEntityDataFactory;
                ((DeviceLimitErrorContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(helpButtonOtpLimitDeviceModel);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.verify.devicelimit.DeviceLimitErrorPresenter$getHelpButtonDeviceLimit$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = DeviceLimitErrorPresenter.this.MyBillsEntityDataFactory;
                ((DeviceLimitErrorContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(new HelpButtonOtpLimitDeviceModel(false, ""));
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }
}
