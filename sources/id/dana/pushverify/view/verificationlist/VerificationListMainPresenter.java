package id.dana.pushverify.view.verificationlist;

import id.dana.base.AbstractContractKt;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.pushverify.interactor.IsNotificationPromptDisabled;
import id.dana.domain.pushverify.interactor.SaveDisabledNotificationPromptPreference;
import id.dana.pushverify.view.verificationlist.VerificationListMainContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000e"}, d2 = {"Lid/dana/pushverify/view/verificationlist/VerificationListMainPresenter;", "Lid/dana/pushverify/view/verificationlist/VerificationListMainContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "MyBillsEntityDataFactory", "onDestroy", "Lid/dana/domain/pushverify/interactor/SaveDisabledNotificationPromptPreference;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/pushverify/interactor/SaveDisabledNotificationPromptPreference;", "PlaceComponentResult", "Lid/dana/domain/pushverify/interactor/IsNotificationPromptDisabled;", "Lid/dana/domain/pushverify/interactor/IsNotificationPromptDisabled;", "Lid/dana/pushverify/view/verificationlist/VerificationListMainContract$View;", "Lid/dana/pushverify/view/verificationlist/VerificationListMainContract$View;", "p0", "p1", "p2", "<init>", "(Lid/dana/pushverify/view/verificationlist/VerificationListMainContract$View;Lid/dana/domain/pushverify/interactor/IsNotificationPromptDisabled;Lid/dana/domain/pushverify/interactor/SaveDisabledNotificationPromptPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationListMainPresenter implements VerificationListMainContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SaveDisabledNotificationPromptPreference PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final IsNotificationPromptDisabled MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final VerificationListMainContract.View BuiltInFictitiousFunctionClassFactory;

    @Inject
    public VerificationListMainPresenter(VerificationListMainContract.View view, IsNotificationPromptDisabled isNotificationPromptDisabled, SaveDisabledNotificationPromptPreference saveDisabledNotificationPromptPreference) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(isNotificationPromptDisabled, "");
        Intrinsics.checkNotNullParameter(saveDisabledNotificationPromptPreference, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = isNotificationPromptDisabled;
        this.PlaceComponentResult = saveDisabledNotificationPromptPreference;
    }

    @Override // id.dana.pushverify.view.verificationlist.VerificationListMainContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        BaseUseCase.execute$default(this.MyBillsEntityDataFactory, NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.pushverify.view.verificationlist.VerificationListMainPresenter$checkEnableNotificationPrompt$1
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
                VerificationListMainContract.View view;
                if (z) {
                    return;
                }
                view = VerificationListMainPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.showEnableNotificationPrompt();
            }
        }, null, 4, null);
    }

    @Override // id.dana.pushverify.view.verificationlist.VerificationListMainContract.Presenter
    public final void MyBillsEntityDataFactory() {
        CompletableUseCase.execute$default(this.PlaceComponentResult, NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.pushverify.view.verificationlist.VerificationListMainPresenter$disableNotificationPrompt$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VerificationListMainContract.View view;
                view = VerificationListMainPresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.successDisableNotificationPrompt();
            }
        }, null, 4, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.MyBillsEntityDataFactory.dispose();
        this.PlaceComponentResult.dispose();
    }
}
