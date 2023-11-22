package id.dana.cashier.presenter;

import android.content.Context;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.cashier.CashierRiskChallengeContract;
import id.dana.cashier.domain.interactor.CreateCashierAgreement;
import id.dana.cashier.helper.CashierErrorHelper;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.helper.CashierErrorType;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.model.SendBankOtpModelKt;
import id.dana.core.ui.model.UiTextModel;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.DefaultObserver;
import id.dana.domain.otp.interactor.ReceiveSms;
import id.dana.domain.otp.interactor.SendBankOtp;
import id.dana.domain.otp.interactor.SendOtp;
import id.dana.domain.otp.interactor.VerifyOtpOneKlik;
import id.dana.domain.otp.model.SendOtpResponse;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0001.BI\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0012\u0012\u0006\u0010\b\u001a\u00020%\u0012\u0006\u0010\t\u001a\u00020\u0014\u0012\u0006\u0010\r\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020\u001c\u0012\u0006\u0010)\u001a\u00020\u001a\u0012\u0006\u0010*\u001a\u00020\"\u0012\u0006\u0010+\u001a\u00020\u0018¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0010\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000e\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0014\u0010\n\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\u0015\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001d\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010&"}, d2 = {"Lid/dana/cashier/presenter/CashierRiskChallengePresenter;", "Lid/dana/cashier/CashierRiskChallengeContract$Presenter;", "", "onDestroy", "()V", "Lid/dana/cashier/model/SendBankOtpModel;", "p0", "", "p1", "p2", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/SendBankOtpModel;ZZ)V", "", "p3", "getAuthRequestContext", "(Ljava/lang/String;ZLjava/lang/String;Z)V", "PlaceComponentResult", "(Lid/dana/cashier/model/SendBankOtpModel;)V", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/cashier/domain/interactor/CreateCashierAgreement;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/domain/interactor/CreateCashierAgreement;", "MyBillsEntityDataFactory", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/domain/otp/interactor/ReceiveSms;", "Lid/dana/domain/otp/interactor/ReceiveSms;", "Lid/dana/domain/otp/interactor/SendBankOtp;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/otp/interactor/SendBankOtp;", "Lid/dana/domain/otp/interactor/SendOtp;", "moveToNextValue", "Lid/dana/domain/otp/interactor/SendOtp;", "Lid/dana/domain/otp/interactor/VerifyOtpOneKlik;", "Lid/dana/domain/otp/interactor/VerifyOtpOneKlik;", "scheduleImpl", "Lid/dana/cashier/CashierRiskChallengeContract$View;", "Lid/dana/cashier/CashierRiskChallengeContract$View;", "getErrorConfigVersion", "p4", "p5", "p6", "p7", "<init>", "(Landroid/content/Context;Lid/dana/cashier/CashierRiskChallengeContract$View;Lid/dana/cashier/domain/interactor/CreateCashierAgreement;Lid/dana/domain/otp/interactor/SendOtp;Lid/dana/domain/otp/interactor/SendBankOtp;Lid/dana/domain/otp/interactor/ReceiveSms;Lid/dana/domain/otp/interactor/VerifyOtpOneKlik;Lid/dana/data/config/DeviceInformationProvider;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierRiskChallengePresenter implements CashierRiskChallengeContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final DeviceInformationProvider getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final CreateCashierAgreement MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final VerifyOtpOneKlik scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final SendBankOtp KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ReceiveSms BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final SendOtp NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final CashierRiskChallengeContract.View getErrorConfigVersion;

    @Inject
    public CashierRiskChallengePresenter(Context context, CashierRiskChallengeContract.View view, CreateCashierAgreement createCashierAgreement, SendOtp sendOtp, SendBankOtp sendBankOtp, ReceiveSms receiveSms, VerifyOtpOneKlik verifyOtpOneKlik, DeviceInformationProvider deviceInformationProvider) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(createCashierAgreement, "");
        Intrinsics.checkNotNullParameter(sendOtp, "");
        Intrinsics.checkNotNullParameter(sendBankOtp, "");
        Intrinsics.checkNotNullParameter(receiveSms, "");
        Intrinsics.checkNotNullParameter(verifyOtpOneKlik, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.PlaceComponentResult = context;
        this.getErrorConfigVersion = view;
        this.MyBillsEntityDataFactory = createCashierAgreement;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = sendOtp;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sendBankOtp;
        this.BuiltInFictitiousFunctionClassFactory = receiveSms;
        this.scheduleImpl = verifyOtpOneKlik;
        this.getAuthRequestContext = deviceInformationProvider;
    }

    public final void getAuthRequestContext(String p0, boolean p1, String p2, boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (p1) {
            this.getErrorConfigVersion.DatabaseTableConfigUtil();
        } else {
            this.getErrorConfigVersion.showProgress();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DefaultObserver<SendOtpResponse>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$sendOtp$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                CashierRiskChallengeContract.View view;
                CashierRiskChallengeContract.View view2;
                CashierRiskChallengeContract.View view3;
                SendOtpResponse sendOtpResponse = (SendOtpResponse) obj;
                Intrinsics.checkNotNullParameter(sendOtpResponse, "");
                if (sendOtpResponse.isSuccess()) {
                    String errorCode = sendOtpResponse.getErrorCode();
                    if (errorCode == null || errorCode.length() == 0) {
                        if (sendOtpResponse.getOtpCodeLength() == 0) {
                            sendOtpResponse.setOtpCodeLength(4);
                        }
                        view3 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                        sendOtpResponse.getExpirySeconds();
                        view3.KClassImpl$Data$declaredNonStaticMembers$2(sendOtpResponse.getRetrySendSeconds(), sendOtpResponse.getOtpCodeLength());
                        view2 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                        view2.dismissProgress();
                    }
                }
                view = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                String errorMessage = sendOtpResponse.getErrorMessage();
                view.KClassImpl$Data$declaredNonStaticMembers$2(new CashierErrorState(CashierErrorType.OTP_ERROR, new UiTextModel.DynamicString(errorMessage != null ? errorMessage : ""), sendOtpResponse.getErrorCode()));
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpCashier]send OTP error: errorCode = ");
                sb.append(sendOtpResponse.getErrorCode());
                sb.append(", errorMessage = ");
                sb.append(sendOtpResponse.getErrorMessage());
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString());
                view2 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                view2.dismissProgress();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                CashierRiskChallengeContract.View view;
                CashierRiskChallengeContract.View view2;
                CashierRiskChallengeContract.View view3;
                Context context;
                Intrinsics.checkNotNullParameter(p02, "");
                view = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                view2 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(CashierErrorHelper.MyBillsEntityDataFactory(p02));
                view3 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                CashierErrorHelper cashierErrorHelper2 = CashierErrorHelper.INSTANCE;
                UiTextModel uiTextModel = CashierErrorHelper.MyBillsEntityDataFactory(p02).getAuthRequestContext;
                context = CashierRiskChallengePresenter.this.PlaceComponentResult;
                view3.MyBillsEntityDataFactory("alipayplus.mobilewallet.user.security.sendOtp", uiTextModel.asString(context), p02);
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpCashier]send OTP  error: ");
                sb.append(p02);
                CrashlyticsLogUtil.PlaceComponentResult(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), p02);
            }
        }, SendOtp.Params.Companion.forSendOtp$default(SendOtp.Params.INSTANCE, p0, null, p2, p3, null, null, null, 112, null));
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(SendBankOtpModel p0, final boolean p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p2) {
            this.getErrorConfigVersion.DatabaseTableConfigUtil();
        } else {
            this.getErrorConfigVersion.showProgress();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new SendBankOtp.Params(SendBankOtpModelKt.MyBillsEntityDataFactory(p0, false)), new Function1<SendOtpResponse, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$sendBankOtp$1
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
                CashierRiskChallengeContract.View view;
                CashierRiskChallengeContract.View view2;
                CashierRiskChallengeContract.View view3;
                Intrinsics.checkNotNullParameter(sendOtpResponse, "");
                if (sendOtpResponse.isSuccess()) {
                    String errorCode = sendOtpResponse.getErrorCode();
                    if (errorCode == null || errorCode.length() == 0) {
                        if (sendOtpResponse.getOtpCodeLength() == 0 && p1) {
                            sendOtpResponse.setOtpCodeLength(6);
                        }
                        view3 = this.getErrorConfigVersion;
                        sendOtpResponse.getExpirySeconds();
                        view3.KClassImpl$Data$declaredNonStaticMembers$2(sendOtpResponse.getRetrySendSeconds(), sendOtpResponse.getOtpCodeLength());
                        view2 = this.getErrorConfigVersion;
                        view2.dismissProgress();
                    }
                }
                view = this.getErrorConfigVersion;
                String errorMessage = sendOtpResponse.getErrorMessage();
                view.MyBillsEntityDataFactory(new CashierErrorState(CashierErrorType.OTP_BANK_ERROR, new UiTextModel.DynamicString(errorMessage != null ? errorMessage : ""), sendOtpResponse.getErrorCode()));
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpCashier]send OTP error: errorCode = ");
                sb.append(sendOtpResponse.getErrorCode());
                sb.append(", errorMessage = ");
                sb.append(sendOtpResponse.getErrorMessage());
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString());
                view2 = this.getErrorConfigVersion;
                view2.dismissProgress();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$sendBankOtp$2
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
                CashierRiskChallengeContract.View view;
                CashierRiskChallengeContract.View view2;
                CashierRiskChallengeContract.View view3;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                view2 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                view2.MyBillsEntityDataFactory(CashierErrorHelper.MyBillsEntityDataFactory(th));
                view3 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                CashierErrorHelper cashierErrorHelper2 = CashierErrorHelper.INSTANCE;
                UiTextModel uiTextModel = CashierErrorHelper.MyBillsEntityDataFactory(th).getAuthRequestContext;
                context = CashierRiskChallengePresenter.this.PlaceComponentResult;
                view3.MyBillsEntityDataFactory(TrackerDataKey.NetworkErrorOperationTypeProperty.SEND_OTP_BANK, uiTextModel.asString(context), th);
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpCashier]send OTP  error: ");
                sb.append(th);
                CrashlyticsLogUtil.PlaceComponentResult(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    public final void PlaceComponentResult(SendBankOtpModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getErrorConfigVersion.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new SendBankOtp.Params(SendBankOtpModelKt.MyBillsEntityDataFactory(p0, true)), new Function1<SendOtpResponse, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$verifyBankPhoneOtp$1
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
                CashierRiskChallengeContract.View view;
                CashierRiskChallengeContract.View view2;
                Intrinsics.checkNotNullParameter(sendOtpResponse, "");
                view = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                sendOtpResponse.getExpirySeconds();
                view.getAuthRequestContext(sendOtpResponse.getRetrySendSeconds(), sendOtpResponse.getOtpCodeLength());
                view2 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                view2.dismissProgress();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierRiskChallengePresenter$verifyBankPhoneOtp$2
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
                CashierRiskChallengeContract.View view;
                CashierRiskChallengeContract.View view2;
                CashierRiskChallengeContract.View view3;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                view2 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                CashierErrorHelper cashierErrorHelper = CashierErrorHelper.INSTANCE;
                view2.getErrorConfigVersion(CashierErrorHelper.MyBillsEntityDataFactory(th));
                view3 = CashierRiskChallengePresenter.this.getErrorConfigVersion;
                CashierErrorHelper cashierErrorHelper2 = CashierErrorHelper.INSTANCE;
                UiTextModel uiTextModel = CashierErrorHelper.MyBillsEntityDataFactory(th).getAuthRequestContext;
                context = CashierRiskChallengePresenter.this.PlaceComponentResult;
                view3.MyBillsEntityDataFactory(TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_BANK_PHONE, uiTextModel.asString(context), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.scheduleImpl.dispose();
    }
}
