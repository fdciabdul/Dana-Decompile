package id.dana.challenge.pin;

import android.app.Activity;
import android.os.Bundle;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.model.TwilioVerify;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0018\u0012\u0006\u0010\t\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J!\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000eJ?\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\u0010J?\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\n\u0010\u0012J7\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\u0013J#\u0010\u0015\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\n\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001c"}, d2 = {"Lid/dana/challenge/pin/PinTwilioPresenter;", "Lid/dana/challenge/pin/AbstractPinContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "", "p0", "", "p1", "getAuthRequestContext", "(Ljava/lang/String;Z)V", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "p4", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Landroid/app/Activity;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Landroid/os/Bundle;)V", "onDestroy", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/challenge/pin/AbstractPinContract$View;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "<init>", "(Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;Lid/dana/challenge/pin/AbstractPinContract$View;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PinTwilioPresenter implements AbstractPinContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final TwilioVerifySecurityProduct KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AbstractPinContract.View getAuthRequestContext;

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        AbstractPinContract.Presenter.CC.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
        AbstractPinContract.Presenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, Bundle p1) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Trust2RiskLoginModel trust2RiskLoginModel) {
        AbstractPinContract.Presenter.CC.getErrorConfigVersion();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        AbstractPinContract.Presenter.CC.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        AbstractPinContract.Presenter.CC.moveToNextValue();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void MyBillsEntityDataFactory(String str, String str2) {
        AbstractPinContract.Presenter.CC.getAuthRequestContext();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void PlaceComponentResult() {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void PlaceComponentResult(String p0, String p1, boolean p2, String p3, String p4) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void getAuthRequestContext(String str) {
        AbstractPinContract.Presenter.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, String p2, Boolean p3, Activity p4) {
        Intrinsics.checkNotNullParameter(p4, "");
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, String p2, boolean p3) {
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final /* synthetic */ void getAuthRequestContext(String str, String str2, boolean z, boolean z2) {
        AbstractPinContract.Presenter.CC.PlaceComponentResult();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, boolean p1) {
    }

    @Inject
    public PinTwilioPresenter(TwilioVerifySecurityProduct twilioVerifySecurityProduct, AbstractPinContract.View view) {
        Intrinsics.checkNotNullParameter(twilioVerifySecurityProduct, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = twilioVerifySecurityProduct;
        this.getAuthRequestContext = view;
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1, String p2, String p3) {
        this.getAuthRequestContext.showProgress();
        TwilioVerifySecurityProduct twilioVerifySecurityProduct = this.KClassImpl$Data$declaredNonStaticMembers$2;
        DefaultObserver<VerifySecurityInfo> defaultObserver = new DefaultObserver<VerifySecurityInfo>() { // from class: id.dana.challenge.pin.PinTwilioPresenter$inputTwilio$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                AbstractPinContract.View view3;
                VerifySecurityInfo verifySecurityInfo = (VerifySecurityInfo) obj;
                Intrinsics.checkNotNullParameter(verifySecurityInfo, "");
                view = PinTwilioPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                if (verifySecurityInfo.getSuccess()) {
                    view3 = PinTwilioPresenter.this.getAuthRequestContext;
                    view3.getAuthRequestContext();
                    return;
                }
                view2 = PinTwilioPresenter.this.getAuthRequestContext;
                view2.onError(verifySecurityInfo.getErrorMessage());
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpTwilio] input OTP error: errorCode = ");
                sb.append(verifySecurityInfo.getErrorCode());
                sb.append(", errorMessage = ");
                sb.append(verifySecurityInfo.getErrorMessage());
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_PIN_TAG, sb.toString());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                AbstractPinContract.View view3;
                Intrinsics.checkNotNullParameter(p02, "");
                view = PinTwilioPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                if (p02 instanceof NetworkException) {
                    view3 = PinTwilioPresenter.this.getAuthRequestContext;
                    NetworkException networkException = (NetworkException) p02;
                    view3.MyBillsEntityDataFactory(networkException.getErrorCode(), p02.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), networkException.getTraceId());
                    return;
                }
                view2 = PinTwilioPresenter.this.getAuthRequestContext;
                view2.onError(p02.getMessage());
                StringBuilder sb = new StringBuilder();
                sb.append("[OtpTwilio] input OTP  error: ");
                sb.append(p02);
                CrashlyticsLogUtil.PlaceComponentResult(DanaLogConstants.TAG.TWILIO_PIN_TAG, sb.toString(), p02);
            }
        };
        if (p2 == null) {
            p2 = "";
        }
        if (p0 == null) {
            p0 = "";
        }
        if (p3 == null) {
            p3 = "";
        }
        twilioVerifySecurityProduct.execute(defaultObserver, new TwilioVerifySecurityProduct.Param(new TwilioVerify(p2, "PASSWORD", p0, p3)));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}
