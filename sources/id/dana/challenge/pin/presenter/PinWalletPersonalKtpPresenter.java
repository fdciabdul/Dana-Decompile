package id.dana.challenge.pin.presenter;

import android.app.Activity;
import android.os.Bundle;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.wallet_v3.interactor.VerifyPinPersonalKtp;
import id.dana.domain.wallet_v3.model.VerifyPinKtpModel;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001c\u0012\u0006\u0010\t\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J!\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000eJ?\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\u0010J?\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\n\u0010\u0012J7\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0014\u0010\n\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001d"}, d2 = {"Lid/dana/challenge/pin/presenter/PinWalletPersonalKtpPresenter;", "Lid/dana/challenge/pin/AbstractPinContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "", "p0", "", "p1", "getAuthRequestContext", "(Ljava/lang/String;Z)V", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "p4", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Landroid/app/Activity;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Landroid/os/Bundle;)V", "onDestroy", "Lid/dana/domain/wallet_v3/interactor/VerifyPinPersonalKtp;", "Lid/dana/domain/wallet_v3/interactor/VerifyPinPersonalKtp;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "<init>", "(Lid/dana/challenge/pin/AbstractPinContract$View;Lid/dana/domain/wallet_v3/interactor/VerifyPinPersonalKtp;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PinWalletPersonalKtpPresenter implements AbstractPinContract.Presenter {
    private final VerifyPinPersonalKtp BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
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
    public final void MyBillsEntityDataFactory(String p0, String p1, String p2, String p3) {
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
    public PinWalletPersonalKtpPresenter(AbstractPinContract.View view, VerifyPinPersonalKtp verifyPinPersonalKtp) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(verifyPinPersonalKtp, "");
        this.getAuthRequestContext = view;
        this.BuiltInFictitiousFunctionClassFactory = verifyPinPersonalKtp;
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(new VerifyPinPersonalKtp.Param(p0), new Function1<VerifyPinKtpModel, Unit>() { // from class: id.dana.challenge.pin.presenter.PinWalletPersonalKtpPresenter$inputWalletPocketKtp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(VerifyPinKtpModel verifyPinKtpModel) {
                invoke2(verifyPinKtpModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(VerifyPinKtpModel verifyPinKtpModel) {
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                Intrinsics.checkNotNullParameter(verifyPinKtpModel, "");
                view = PinWalletPersonalKtpPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                view2 = PinWalletPersonalKtpPresenter.this.getAuthRequestContext;
                view2.getAuthRequestContext();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.presenter.PinWalletPersonalKtpPresenter$inputWalletPocketKtp$2
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
                AbstractPinContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PinWalletPersonalKtpPresenter.this.getAuthRequestContext;
                view.dismissProgress();
                PinWalletPersonalKtpPresenter.BuiltInFictitiousFunctionClassFactory(PinWalletPersonalKtpPresenter.this, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PinWalletPersonalKtpPresenter pinWalletPersonalKtpPresenter, Throwable th) {
        if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            pinWalletPersonalKtpPresenter.getAuthRequestContext.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), networkException.getTraceId());
            return;
        }
        pinWalletPersonalKtpPresenter.getAuthRequestContext.onError(th.getMessage());
    }
}
