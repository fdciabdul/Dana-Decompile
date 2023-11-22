package id.dana.riskChallenges.ui.resetpin.confirm.viewmodel;

import androidx.view.ViewModel;
import dagger.Lazy;
import id.dana.analytics.tracker.createpin.InputConfirmPinTracker;
import id.dana.analytics.tracker.createpin.InputConfirmPinTrackerImpl;
import id.dana.domain.resetpin.interactor.SelfUnfreeze;
import id.dana.network.exception.NetworkException;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.domain.forgetpassword.interactor.ResetPassword;
import id.dana.riskChallenges.domain.forgetpassword.model.ResetPasswordResponseModel;
import id.dana.riskChallenges.ui.resetpin.confirm.SelfUnfreezeErrorCode;
import id.dana.riskChallenges.ui.resetpin.confirm.viewmodel.InputConfirmPinUiState;
import id.dana.riskChallenges.ui.util.StringWrapperExtKt;
import id.dana.utils.StringWrapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B-\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\f\u001a\u00020\u0015\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100 X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010!"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/analytics/tracker/createpin/InputConfirmPinTracker;", "Lid/dana/network/exception/NetworkException;", "p0", "Lid/dana/utils/StringWrapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/network/exception/NetworkException;)Lid/dana/utils/StringWrapper;", "", "onCleared", "()V", "", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinUiState;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/analytics/tracker/createpin/InputConfirmPinTrackerImpl;", "Lid/dana/analytics/tracker/createpin/InputConfirmPinTrackerImpl;", "getAuthRequestContext", "Ldagger/Lazy;", "Lid/dana/riskChallenges/domain/forgetpassword/interactor/ResetPassword;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ldagger/Lazy;", "scheduleImpl", "Lid/dana/domain/resetpin/interactor/SelfUnfreeze;", "getErrorConfigVersion", "moveToNextValue", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "p2", "<init>", "(Ldagger/Lazy;Lid/dana/analytics/tracker/createpin/InputConfirmPinTrackerImpl;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputConfirmPinViewModel extends ViewModel implements InputConfirmPinTracker {
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MutableStateFlow<InputConfirmPinUiState> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<ResetPassword> scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final InputConfirmPinTrackerImpl KClassImpl$Data$declaredNonStaticMembers$2;
    public String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final Lazy<SelfUnfreeze> moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final StateFlow<InputConfirmPinUiState> NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public InputConfirmPinViewModel(Lazy<ResetPassword> lazy, InputConfirmPinTrackerImpl inputConfirmPinTrackerImpl, Lazy<SelfUnfreeze> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(inputConfirmPinTrackerImpl, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.scheduleImpl = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = inputConfirmPinTrackerImpl;
        this.moveToNextValue = lazy2;
        MutableStateFlow<InputConfirmPinUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(InputConfirmPinUiState.None.INSTANCE);
        this.MyBillsEntityDataFactory = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MutableStateFlow<InputConfirmPinUiState> mutableStateFlow = this.MyBillsEntityDataFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), InputConfirmPinUiState.ShowLoading.INSTANCE));
        ResetPassword resetPassword = this.scheduleImpl.get();
        String str = this.PlaceComponentResult;
        if (str == null) {
            str = "";
        }
        String str2 = this.BuiltInFictitiousFunctionClassFactory;
        resetPassword.execute(new ResetPassword.Params(str, p1, p0, str2 != null ? str2 : ""), new Function1<ResetPasswordResponseModel, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.viewmodel.InputConfirmPinViewModel$resetPassword$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ResetPasswordResponseModel resetPasswordResponseModel) {
                invoke2(resetPasswordResponseModel);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ResetPasswordResponseModel resetPasswordResponseModel) {
                MutableStateFlow mutableStateFlow2;
                Object value;
                InputConfirmPinTrackerImpl inputConfirmPinTrackerImpl;
                MutableStateFlow mutableStateFlow3;
                Object value2;
                ?? r5;
                MutableStateFlow mutableStateFlow4;
                Object value3;
                Intrinsics.checkNotNullParameter(resetPasswordResponseModel, "");
                mutableStateFlow2 = InputConfirmPinViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow2.getValue();
                    InputConfirmPinUiState inputConfirmPinUiState = (InputConfirmPinUiState) value;
                } while (!mutableStateFlow2.compareAndSet(value, InputConfirmPinUiState.DismissLoading.INSTANCE));
                inputConfirmPinTrackerImpl = InputConfirmPinViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                inputConfirmPinTrackerImpl.getAuthRequestContext(Intrinsics.areEqual(resetPasswordResponseModel.KClassImpl$Data$declaredNonStaticMembers$2, Boolean.TRUE));
                if (Intrinsics.areEqual(resetPasswordResponseModel.KClassImpl$Data$declaredNonStaticMembers$2, Boolean.TRUE)) {
                    mutableStateFlow4 = InputConfirmPinViewModel.this.MyBillsEntityDataFactory;
                    do {
                        value3 = mutableStateFlow4.getValue();
                        InputConfirmPinUiState inputConfirmPinUiState2 = (InputConfirmPinUiState) value3;
                    } while (!mutableStateFlow4.compareAndSet(value3, InputConfirmPinUiState.SuccessResetPin.INSTANCE));
                    return;
                }
                mutableStateFlow3 = InputConfirmPinViewModel.this.MyBillsEntityDataFactory;
                do {
                    value2 = mutableStateFlow3.getValue();
                    InputConfirmPinUiState inputConfirmPinUiState3 = (InputConfirmPinUiState) value2;
                    r5 = 0;
                } while (!mutableStateFlow3.compareAndSet(value2, new InputConfirmPinUiState.FailedResetPin("", new StringWrapper.ResValue(R.string.general_error_message, r5, 2, r5))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.viewmodel.InputConfirmPinViewModel$resetPassword$3
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
                Intrinsics.checkNotNullParameter(th, "");
                InputConfirmPinViewModel.MyBillsEntityDataFactory(InputConfirmPinViewModel.this, th);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    private static StringWrapper KClassImpl$Data$declaredNonStaticMembers$2(NetworkException p0) {
        String errorCode = p0.getErrorCode();
        int i = 2;
        ?? r2 = 0;
        if (errorCode != null) {
            switch (errorCode.hashCode()) {
                case -882494585:
                    if (errorCode.equals(SelfUnfreezeErrorCode.FREEZE_RECORD_NOT_EXIST)) {
                        return new StringWrapper.ResValue(R.string.general_error_message, r2, i, r2);
                    }
                    break;
                case -882494584:
                    if (errorCode.equals(SelfUnfreezeErrorCode.APP_VERSION_IS_NOT_ELIGIBLE)) {
                        return new StringWrapper.ResValue(R.string.res_0x7f13135a_summaryvoucherview_externalsyntheticlambda0, r2, i, r2);
                    }
                    break;
                case -753412089:
                    if (errorCode.equals(SelfUnfreezeErrorCode.RISK_REJECT)) {
                        return new StringWrapper.ResValue(R.string.reset_pin_error_risk_reject, r2, i, r2);
                    }
                    break;
            }
        }
        return StringWrapperExtKt.getAuthRequestContext(p0, new StringWrapper.ResValue(R.string.general_error_message, r2, i, r2));
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        MutableStateFlow<InputConfirmPinUiState> mutableStateFlow = this.MyBillsEntityDataFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), InputConfirmPinUiState.None.INSTANCE));
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        super.onCleared();
        this.scheduleImpl.get().dispose();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static final /* synthetic */ void MyBillsEntityDataFactory(InputConfirmPinViewModel inputConfirmPinViewModel, Throwable th) {
        InputConfirmPinUiState.FailedResetPin failedResetPin;
        MutableStateFlow<InputConfirmPinUiState> mutableStateFlow = inputConfirmPinViewModel.MyBillsEntityDataFactory;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), InputConfirmPinUiState.DismissLoading.INSTANCE));
        inputConfirmPinViewModel.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(false);
        int i = 2;
        ?? r3 = 0;
        if (th instanceof NoInternetConnectionException) {
            failedResetPin = new InputConfirmPinUiState.FailedResetPin("", new StringWrapper.ResValue(R.string.general_no_connection_error_message, r3, i, r3));
        } else if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            if (Intrinsics.areEqual(networkException.getErrorCode(), SelfUnfreezeErrorCode.RISK_REJECT) || Intrinsics.areEqual(networkException.getErrorCode(), SelfUnfreezeErrorCode.FREEZE_RECORD_NOT_EXIST) || Intrinsics.areEqual(networkException.getErrorCode(), SelfUnfreezeErrorCode.APP_VERSION_IS_NOT_ELIGIBLE)) {
                failedResetPin = new InputConfirmPinUiState.FailedSelfUnfreeze(KClassImpl$Data$declaredNonStaticMembers$2(networkException));
            } else {
                String errorCode = networkException.getErrorCode();
                Intrinsics.checkNotNullExpressionValue(errorCode, "");
                failedResetPin = new InputConfirmPinUiState.FailedResetPin(errorCode, KClassImpl$Data$declaredNonStaticMembers$2(networkException));
            }
        } else {
            failedResetPin = new InputConfirmPinUiState.FailedResetPin("", new StringWrapper.ResValue(R.string.general_error_message, r3, i, r3));
        }
        InputConfirmPinUiState inputConfirmPinUiState = failedResetPin;
        MutableStateFlow<InputConfirmPinUiState> mutableStateFlow2 = inputConfirmPinViewModel.MyBillsEntityDataFactory;
        do {
        } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), inputConfirmPinUiState));
    }
}
