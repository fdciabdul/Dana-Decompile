package id.dana.contract.switchfaceauth;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract;
import id.dana.domain.auth.face.interactor.ConsultFaceAuthPopUp;
import id.dana.domain.auth.face.result.FaceAuthPopUpConsultationResult;
import id.dana.domain.core.usecase.NoParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "neverShow", "", BridgeDSL.INVOKE, "(Z)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
final class FaceAuthPopUpConsultationPresenter$checkIfShouldDisplaySuggestionPopUpAgain$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ boolean $$parallelMode;
    final /* synthetic */ boolean $$withKycStatus;
    final /* synthetic */ FaceAuthPopUpConsultationPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FaceAuthPopUpConsultationPresenter$checkIfShouldDisplaySuggestionPopUpAgain$1(FaceAuthPopUpConsultationPresenter faceAuthPopUpConsultationPresenter, boolean z, boolean z2) {
        super(1);
        this.this$0 = faceAuthPopUpConsultationPresenter;
        this.$$parallelMode = z;
        this.$$withKycStatus = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        FaceAuthPopUpConsultationContract.View view;
        if (z) {
            view = this.this$0.lookAheadTest;
            view.MyBillsEntityDataFactory();
            return;
        }
        r3.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationPresenter$checkTemporarySuggestionScreenDismiss$1
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

            public final void invoke(boolean z2) {
                FaceAuthPopUpConsultationContract.View view2;
                if (!z2) {
                    view2 = FaceAuthPopUpConsultationPresenter.this.lookAheadTest;
                    view2.MyBillsEntityDataFactory();
                    return;
                }
                final FaceAuthPopUpConsultationPresenter faceAuthPopUpConsultationPresenter = FaceAuthPopUpConsultationPresenter.this;
                faceAuthPopUpConsultationPresenter.MyBillsEntityDataFactory.execute(new ConsultFaceAuthPopUp.Params(r2, r3), new Function1<FaceAuthPopUpConsultationResult, Unit>() { // from class: id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationPresenter$consultToBackend$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult) {
                        invoke2(faceAuthPopUpConsultationResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(FaceAuthPopUpConsultationResult faceAuthPopUpConsultationResult) {
                        FaceAuthPopUpConsultationContract.View view3;
                        Intrinsics.checkNotNullParameter(faceAuthPopUpConsultationResult, "");
                        view3 = FaceAuthPopUpConsultationPresenter.this.lookAheadTest;
                        faceAuthPopUpConsultationResult.getShouldShowPopUp();
                        view3.MyBillsEntityDataFactory();
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationPresenter$consultToBackend$2
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
                        FaceAuthPopUpConsultationContract.View view3;
                        Intrinsics.checkNotNullParameter(th, "");
                        view3 = FaceAuthPopUpConsultationPresenter.this.lookAheadTest;
                        view3.onError(th.getMessage());
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationPresenter$checkTemporarySuggestionScreenDismiss$2
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
                FaceAuthPopUpConsultationContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view2 = FaceAuthPopUpConsultationPresenter.this.lookAheadTest;
                view2.onError(th.getMessage());
            }
        });
    }
}
