package id.dana.cardbinding.viewmodel;

import android.app.Application;
import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.cardbinding.viewmodel.OtpCardBindingUiState;
import id.dana.cashier.domain.interactor.CreateCashierAgreementFlow;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.model.SendBankOtpModelKt;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.otp.interactor.ReceiveSmsFlow;
import id.dana.domain.otp.interactor.SendBankOtp;
import id.dana.domain.otp.interactor.SendBankOtpFlow;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.otp.interactor.SendOtpFlow;
import id.dana.domain.otp.interactor.VerifyOtpOneKlikFlow;
import id.dana.domain.otp.model.SendOtpResponse;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0001+BA\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000b\u0012\u0006\u0010#\u001a\u00020\u000f\u0012\u0006\u0010$\u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020\u0017\u0012\u0006\u0010&\u001a\u00020\u0015\u0012\u0006\u0010'\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020\u0012¢\u0006\u0004\b)\u0010*J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\f\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u001fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010 R\u0014\u0010\u001c\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\""}, d2 = {"Lid/dana/cardbinding/viewmodel/OtpCardBindingViewModel;", "Landroidx/lifecycle/ViewModel;", "Lid/dana/cashier/model/SendBankOtpModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/SendBankOtpModel;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingUiState;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "PlaceComponentResult", "Landroid/app/Application;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/app/Application;", "getAuthRequestContext", "Lid/dana/cashier/domain/interactor/CreateCashierAgreementFlow;", "Lid/dana/cashier/domain/interactor/CreateCashierAgreementFlow;", "MyBillsEntityDataFactory", "Lid/dana/data/config/DeviceInformationProvider;", "lookAheadTest", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/domain/otp/interactor/ReceiveSmsFlow;", "Lid/dana/domain/otp/interactor/ReceiveSmsFlow;", "Lid/dana/domain/otp/interactor/SendBankOtpFlow;", "moveToNextValue", "Lid/dana/domain/otp/interactor/SendBankOtpFlow;", "scheduleImpl", "Lid/dana/domain/otp/interactor/SendOtpFlow;", "getErrorConfigVersion", "Lid/dana/domain/otp/interactor/SendOtpFlow;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lid/dana/domain/otp/interactor/VerifyOtpOneKlikFlow;", "Lid/dana/domain/otp/interactor/VerifyOtpOneKlikFlow;", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Landroid/app/Application;Lid/dana/cashier/domain/interactor/CreateCashierAgreementFlow;Lid/dana/domain/otp/interactor/SendOtpFlow;Lid/dana/domain/otp/interactor/SendBankOtpFlow;Lid/dana/domain/otp/interactor/ReceiveSmsFlow;Lid/dana/domain/otp/interactor/VerifyOtpOneKlikFlow;Lid/dana/data/config/DeviceInformationProvider;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OtpCardBindingViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MutableStateFlow<OtpCardBindingUiState> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Application getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final StateFlow<OtpCardBindingUiState> moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final VerifyOtpOneKlikFlow getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ReceiveSmsFlow BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final CreateCashierAgreementFlow MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final SendOtpFlow NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final DeviceInformationProvider KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final SendBankOtpFlow scheduleImpl;

    @Inject
    public OtpCardBindingViewModel(Application application, CreateCashierAgreementFlow createCashierAgreementFlow, SendOtpFlow sendOtpFlow, SendBankOtpFlow sendBankOtpFlow, ReceiveSmsFlow receiveSmsFlow, VerifyOtpOneKlikFlow verifyOtpOneKlikFlow, DeviceInformationProvider deviceInformationProvider) {
        Intrinsics.checkNotNullParameter(application, "");
        Intrinsics.checkNotNullParameter(createCashierAgreementFlow, "");
        Intrinsics.checkNotNullParameter(sendOtpFlow, "");
        Intrinsics.checkNotNullParameter(sendBankOtpFlow, "");
        Intrinsics.checkNotNullParameter(receiveSmsFlow, "");
        Intrinsics.checkNotNullParameter(verifyOtpOneKlikFlow, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.getAuthRequestContext = application;
        this.MyBillsEntityDataFactory = createCashierAgreementFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = sendOtpFlow;
        this.scheduleImpl = sendBankOtpFlow;
        this.BuiltInFictitiousFunctionClassFactory = receiveSmsFlow;
        this.getErrorConfigVersion = verifyOtpOneKlikFlow;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deviceInformationProvider;
        MutableStateFlow<OtpCardBindingUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(OtpCardBindingUiState.None.INSTANCE);
        this.PlaceComponentResult = MutableStateFlow;
        this.moveToNextValue = FlowKt.asStateFlow(MutableStateFlow);
    }

    public static /* synthetic */ void PlaceComponentResult(final OtpCardBindingViewModel otpCardBindingViewModel, String str, String str2) {
        SendOtp.Params forSendOtp;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        SendOtpFlow sendOtpFlow = otpCardBindingViewModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        forSendOtp = SendOtp.Params.INSTANCE.forSendOtp(str, null, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : false, (i & 16) != 0 ? null : null, (i & 32) != 0 ? null : null, (i & 64) != 0 ? null : null);
        final boolean z = false;
        sendOtpFlow.execute(forSendOtp, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$sendOtp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                if (z) {
                    mutableStateFlow2 = otpCardBindingViewModel.PlaceComponentResult;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, OtpCardBindingUiState.ShowSkeletonLoading.INSTANCE));
                    return;
                }
                mutableStateFlow = otpCardBindingViewModel.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState2 = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, OtpCardBindingUiState.ShowProgress.INSTANCE));
            }
        }, new Function1<SendOtpResponse, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$sendOtp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SendOtpResponse sendOtpResponse) {
                invoke2(sendOtpResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SendOtpResponse sendOtpResponse) {
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(sendOtpResponse, "");
                if (sendOtpResponse.isSuccess()) {
                    String errorCode = sendOtpResponse.getErrorCode();
                    if (errorCode == null || errorCode.length() == 0) {
                        if (sendOtpResponse.getOtpCodeLength() == 0) {
                            sendOtpResponse.setOtpCodeLength(4);
                        }
                        mutableStateFlow2 = OtpCardBindingViewModel.this.PlaceComponentResult;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value2;
                        } while (!mutableStateFlow2.compareAndSet(value2, new OtpCardBindingUiState.OnSuccessSendOtp(sendOtpResponse.getExpirySeconds(), sendOtpResponse.getRetrySendSeconds(), sendOtpResponse.getOtpCodeLength())));
                        return;
                    }
                }
                mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState2 = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnErrorSendOtp(sendOtpResponse.getErrorMessage())));
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpCardBinding]send OTP error: errorCode = ");
                sb.append(sendOtpResponse.getErrorCode());
                sb.append(", errorMessage = ");
                sb.append(sendOtpResponse.getErrorMessage());
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CARD_BINDING_TAG, sb.toString());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$sendOtp$3
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Application application;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                OtpCardBindingViewModel otpCardBindingViewModel2 = OtpCardBindingViewModel.this;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                    application = otpCardBindingViewModel2.getAuthRequestContext;
                } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnErrorSendOtp(ErrorUtil.PlaceComponentResult(th, application.getApplicationContext()))));
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpCardBinding]send OTP  error: ");
                sb.append(th);
                CrashlyticsLogUtil.PlaceComponentResult(DanaLogConstants.TAG.CARD_BINDING_TAG, sb.toString(), th);
            }
        }, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$sendOtp$4
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, OtpCardBindingUiState.DismissProgress.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(otpCardBindingViewModel));
    }

    public static /* synthetic */ void PlaceComponentResult(final OtpCardBindingViewModel otpCardBindingViewModel, SendBankOtpModel sendBankOtpModel) {
        Intrinsics.checkNotNullParameter(sendBankOtpModel, "");
        final boolean z = false;
        otpCardBindingViewModel.scheduleImpl.execute(new SendBankOtp.Params(SendBankOtpModelKt.MyBillsEntityDataFactory(sendBankOtpModel, false)), new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$sendBankOtp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                if (z) {
                    mutableStateFlow2 = otpCardBindingViewModel.PlaceComponentResult;
                    do {
                        value2 = mutableStateFlow2.getValue();
                        OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value2;
                    } while (!mutableStateFlow2.compareAndSet(value2, OtpCardBindingUiState.ShowSkeletonLoading.INSTANCE));
                    return;
                }
                mutableStateFlow = otpCardBindingViewModel.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState2 = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, OtpCardBindingUiState.ShowProgress.INSTANCE));
            }
        }, new Function1<SendOtpResponse, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$sendBankOtp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SendOtpResponse sendOtpResponse) {
                invoke2(sendOtpResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SendOtpResponse sendOtpResponse) {
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(sendOtpResponse, "");
                if (sendOtpResponse.isSuccess()) {
                    String errorCode = sendOtpResponse.getErrorCode();
                    if (errorCode == null || errorCode.length() == 0) {
                        if (sendOtpResponse.getOtpCodeLength() == 0 && z) {
                            sendOtpResponse.setOtpCodeLength(6);
                        }
                        mutableStateFlow2 = otpCardBindingViewModel.PlaceComponentResult;
                        do {
                            value2 = mutableStateFlow2.getValue();
                            OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value2;
                        } while (!mutableStateFlow2.compareAndSet(value2, new OtpCardBindingUiState.OnSuccessSendOtp(sendOtpResponse.getExpirySeconds(), sendOtpResponse.getRetrySendSeconds(), sendOtpResponse.getOtpCodeLength())));
                        return;
                    }
                }
                mutableStateFlow = otpCardBindingViewModel.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState2 = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnErrorSendOtp(sendOtpResponse.getErrorMessage())));
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpCardBinding]send bank OTP error: errorCode = ");
                sb.append(sendOtpResponse.getErrorCode());
                sb.append(", errorMessage = ");
                sb.append(sendOtpResponse.getErrorMessage());
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CARD_BINDING_TAG, sb.toString());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$sendBankOtp$3
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Application application;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                OtpCardBindingViewModel otpCardBindingViewModel2 = OtpCardBindingViewModel.this;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                    application = otpCardBindingViewModel2.getAuthRequestContext;
                } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnErrorSendOtp(ErrorUtil.PlaceComponentResult(th, application.getApplicationContext()))));
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpCardBinding]send bank OTP  error: ");
                sb.append(th);
                CrashlyticsLogUtil.PlaceComponentResult(DanaLogConstants.TAG.CARD_BINDING_TAG, sb.toString(), th);
            }
        }, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$sendBankOtp$4
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, OtpCardBindingUiState.DismissProgress.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(otpCardBindingViewModel));
    }

    public final void BuiltInFictitiousFunctionClassFactory(SendBankOtpModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.scheduleImpl.execute(new SendBankOtp.Params(SendBankOtpModelKt.MyBillsEntityDataFactory(p0, true)), new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$verifyBankPhoneOtp$1
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, OtpCardBindingUiState.ShowProgress.INSTANCE));
            }
        }, new Function1<SendOtpResponse, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$verifyBankPhoneOtp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SendOtpResponse sendOtpResponse) {
                invoke2(sendOtpResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SendOtpResponse sendOtpResponse) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(sendOtpResponse, "");
                mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnVerifyBankPhoneOtp(sendOtpResponse.getExpirySeconds(), sendOtpResponse.getRetrySendSeconds(), sendOtpResponse.getOtpCodeLength())));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$verifyBankPhoneOtp$3
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
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new OtpCardBindingUiState.OnError(th.getMessage())));
            }
        }, new Function0<Unit>() { // from class: id.dana.cardbinding.viewmodel.OtpCardBindingViewModel$verifyBankPhoneOtp$4
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
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = OtpCardBindingViewModel.this.PlaceComponentResult;
                do {
                    value = mutableStateFlow.getValue();
                    OtpCardBindingUiState otpCardBindingUiState = (OtpCardBindingUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, OtpCardBindingUiState.DismissProgress.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(this));
    }
}
