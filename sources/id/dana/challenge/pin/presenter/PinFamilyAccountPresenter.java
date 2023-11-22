package id.dana.challenge.pin.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.familyaccount.interactor.AcceptFamilyInvitation;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember;
import id.dana.domain.familyaccount.model.InvitationDecisionInfo;
import id.dana.domain.familyaccount.model.InvitationDecisionRequestInfo;
import id.dana.domain.familyaccount.model.InviteMemberRequest;
import id.dana.domain.familyaccount.model.InviteMemberResult;
import id.dana.domain.familyaccount.model.RemoveFamilyAccountResult;
import id.dana.domain.familyaccount.model.RemoveFamilyMemberResult;
import id.dana.domain.twilio.interactor.TwilioVerifySecurityProduct;
import id.dana.domain.twilio.model.TwilioVerify;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020!\u0012\u0006\u0010\b\u001a\u00020$\u0012\u0006\u0010\u000f\u001a\u00020&\u0012\u0006\u0010\u0010\u001a\u00020(\u0012\u0006\u0010\u0014\u001a\u00020\u001e\u0012\u0006\u0010\u0015\u001a\u00020*\u0012\u0006\u00100\u001a\u00020.¢\u0006\u0004\b1\u00102J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u0011J#\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0012J-\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\u0013JK\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u0016J?\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\u0017J?\u0010\r\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\r\u0010\u0019J7\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\u001aJ#\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\n\u0010\u001cJ-\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\u0013J\u000f\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0004R\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0014\u0010\n\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\r\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010\u0005\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u0014\u0010\u0003\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010+\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010/"}, d2 = {"Lid/dana/challenge/pin/presenter/PinFamilyAccountPresenter;", "Lid/dana/challenge/pin/AbstractPinContract$FamilyAccountPinPresenter;", "", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "", "p0", "p1", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct$Param;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct$Param;", "", "getAuthRequestContext", "(Ljava/lang/String;Z)V", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "p4", "p5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Landroid/app/Activity;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "onDestroy", "Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation;", "Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "lookAheadTest", "Landroid/content/Context;", "Lid/dana/domain/familyaccount/interactor/InviteFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/InviteFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", "getErrorConfigVersion", "Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;", "moveToNextValue", "Lid/dana/challenge/pin/AbstractPinContract$View;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "p6", "<init>", "(Landroid/content/Context;Lid/dana/domain/familyaccount/interactor/InviteFamilyAccount;Lid/dana/domain/familyaccount/interactor/RemoveFamilyAccount;Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;Lid/dana/domain/familyaccount/interactor/AcceptFamilyInvitation;Lid/dana/domain/twilio/interactor/TwilioVerifySecurityProduct;Lid/dana/challenge/pin/AbstractPinContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PinFamilyAccountPresenter implements AbstractPinContract.FamilyAccountPinPresenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final AcceptFamilyInvitation KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final AbstractPinContract.View getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final InviteFamilyAccount getAuthRequestContext;
    final RemoveFamilyAccount PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final RemoveFamilyMember MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final TwilioVerifySecurityProduct moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

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
    public PinFamilyAccountPresenter(Context context, InviteFamilyAccount inviteFamilyAccount, RemoveFamilyAccount removeFamilyAccount, RemoveFamilyMember removeFamilyMember, AcceptFamilyInvitation acceptFamilyInvitation, TwilioVerifySecurityProduct twilioVerifySecurityProduct, AbstractPinContract.View view) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(inviteFamilyAccount, "");
        Intrinsics.checkNotNullParameter(removeFamilyAccount, "");
        Intrinsics.checkNotNullParameter(removeFamilyMember, "");
        Intrinsics.checkNotNullParameter(acceptFamilyInvitation, "");
        Intrinsics.checkNotNullParameter(twilioVerifySecurityProduct, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = inviteFamilyAccount;
        this.PlaceComponentResult = removeFamilyAccount;
        this.MyBillsEntityDataFactory = removeFamilyMember;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = acceptFamilyInvitation;
        this.moveToNextValue = twilioVerifySecurityProduct;
        this.getErrorConfigVersion = view;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    public static final /* synthetic */ void PlaceComponentResult(PinFamilyAccountPresenter pinFamilyAccountPresenter, Throwable th) {
        pinFamilyAccountPresenter.getErrorConfigVersion.dismissProgress();
        if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            pinFamilyAccountPresenter.getErrorConfigVersion.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), "");
            return;
        }
        pinFamilyAccountPresenter.getErrorConfigVersion.onError(th.getMessage());
        StringBuilder sb = new StringBuilder();
        sb.append("[PinLogin] input PIN error: ");
        sb.append(th);
        CrashlyticsLogUtil.PlaceComponentResult(DanaLogConstants.TAG.TWILIO_PIN_TAG, sb.toString(), th);
    }

    public static final /* synthetic */ void getAuthRequestContext(VerifySecurityInfo verifySecurityInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("[PinLogin] input PIN error: errorCode = ");
        sb.append(verifySecurityInfo.getErrorCode());
        sb.append(", errorMessage = ");
        sb.append(verifySecurityInfo.getErrorMessage());
        CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_PIN_TAG, sb.toString());
    }

    private static TwilioVerifySecurityProduct.Param BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        if (p0 == null) {
            p0 = "";
        }
        if (p1 == null) {
            p1 = "";
        }
        return new TwilioVerifySecurityProduct.Param(new TwilioVerify(p0, "PASSWORD", p1, ""));
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.FamilyAccountPinPresenter
    public final void getAuthRequestContext(String p0, final String p1) {
        this.getErrorConfigVersion.showProgress();
        this.moveToNextValue.execute(new DefaultObserver<VerifySecurityInfo>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$verifySecurityProduct$2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AbstractPinContract.View view;
                VerifySecurityInfo verifySecurityInfo = (VerifySecurityInfo) obj;
                Intrinsics.checkNotNullParameter(verifySecurityInfo, "");
                view = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                if (verifySecurityInfo.getSuccess()) {
                    final PinFamilyAccountPresenter pinFamilyAccountPresenter = PinFamilyAccountPresenter.this;
                    String str = p1;
                    pinFamilyAccountPresenter.getErrorConfigVersion.showProgress();
                    pinFamilyAccountPresenter.PlaceComponentResult.execute(new RemoveFamilyAccount.Params(str != null ? str : ""), new Function1<RemoveFamilyAccountResult, Unit>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$removeFamilyAccount$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(RemoveFamilyAccountResult removeFamilyAccountResult) {
                            invoke2(removeFamilyAccountResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(RemoveFamilyAccountResult removeFamilyAccountResult) {
                            AbstractPinContract.View view2;
                            AbstractPinContract.View view3;
                            Intrinsics.checkNotNullParameter(removeFamilyAccountResult, "");
                            view2 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            view3 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view3.getAuthRequestContext();
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$removeFamilyAccount$2
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
                            AbstractPinContract.View view2;
                            AbstractPinContract.View view3;
                            Context context;
                            AbstractPinContract.View view4;
                            Intrinsics.checkNotNullParameter(th, "");
                            view2 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            if (th instanceof NetworkException) {
                                view4 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                                NetworkException networkException = (NetworkException) th;
                                view4.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), "");
                            } else {
                                view3 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                                context = PinFamilyAccountPresenter.this.BuiltInFictitiousFunctionClassFactory;
                                view3.onError(ErrorUtil.PlaceComponentResult(th, context));
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(DanaLogConstants.Prefix.FAMILY_ACCOUNT_REMOVE);
                            sb.append(PinFamilyAccountPresenter.this.getClass().getName());
                            sb.append(":onError");
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, sb.toString(), th);
                        }
                    });
                    return;
                }
                PinFamilyAccountPresenter.getAuthRequestContext(verifySecurityInfo);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                PinFamilyAccountPresenter.PlaceComponentResult(PinFamilyAccountPresenter.this, p02);
            }
        }, BuiltInFictitiousFunctionClassFactory(p1, p0));
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.FamilyAccountPinPresenter
    public final void MyBillsEntityDataFactory(String p0, final String p1, final String p2) {
        this.getErrorConfigVersion.showProgress();
        this.moveToNextValue.execute(new DefaultObserver<VerifySecurityInfo>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$verifySecurityProduct$3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AbstractPinContract.View view;
                VerifySecurityInfo verifySecurityInfo = (VerifySecurityInfo) obj;
                Intrinsics.checkNotNullParameter(verifySecurityInfo, "");
                view = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                if (verifySecurityInfo.getSuccess()) {
                    final PinFamilyAccountPresenter pinFamilyAccountPresenter = PinFamilyAccountPresenter.this;
                    String str = p1;
                    String str2 = p2;
                    pinFamilyAccountPresenter.getErrorConfigVersion.showProgress();
                    RemoveFamilyMember removeFamilyMember = pinFamilyAccountPresenter.MyBillsEntityDataFactory;
                    if (str == null) {
                        str = "";
                    }
                    removeFamilyMember.execute(new RemoveFamilyMember.Params(str, str2 != null ? str2 : ""), new Function1<RemoveFamilyMemberResult, Unit>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$removeFamilyMember$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(RemoveFamilyMemberResult removeFamilyMemberResult) {
                            invoke2(removeFamilyMemberResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(RemoveFamilyMemberResult removeFamilyMemberResult) {
                            AbstractPinContract.View view2;
                            AbstractPinContract.View view3;
                            Intrinsics.checkNotNullParameter(removeFamilyMemberResult, "");
                            view2 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            view3 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view3.getAuthRequestContext();
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$removeFamilyMember$2
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
                            AbstractPinContract.View view2;
                            AbstractPinContract.View view3;
                            Context context;
                            AbstractPinContract.View view4;
                            Intrinsics.checkNotNullParameter(th, "");
                            view2 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            if (th instanceof NetworkException) {
                                view4 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                                NetworkException networkException = (NetworkException) th;
                                view4.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), "");
                            } else {
                                view3 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                                context = PinFamilyAccountPresenter.this.BuiltInFictitiousFunctionClassFactory;
                                view3.onError(ErrorUtil.PlaceComponentResult(th, context));
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(DanaLogConstants.Prefix.FAMILY_ACCOUNT_REMOVE_MEMBER);
                            sb.append(PinFamilyAccountPresenter.this.getClass().getName());
                            sb.append(":onError");
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, sb.toString(), th);
                        }
                    });
                    return;
                }
                PinFamilyAccountPresenter.getAuthRequestContext(verifySecurityInfo);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                PinFamilyAccountPresenter.PlaceComponentResult(PinFamilyAccountPresenter.this, p02);
            }
        }, BuiltInFictitiousFunctionClassFactory(p1, p0));
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.FamilyAccountPinPresenter
    public final void getAuthRequestContext(final String p0, final String p1, final String p2, final String p3, final String p4, final String p5) {
        this.getErrorConfigVersion.showProgress();
        this.moveToNextValue.execute(new DefaultObserver<VerifySecurityInfo>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$verifySecurityProduct$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AbstractPinContract.View view;
                VerifySecurityInfo verifySecurityInfo = (VerifySecurityInfo) obj;
                Intrinsics.checkNotNullParameter(verifySecurityInfo, "");
                view = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                if (verifySecurityInfo.getSuccess()) {
                    final PinFamilyAccountPresenter pinFamilyAccountPresenter = PinFamilyAccountPresenter.this;
                    String str = p3;
                    String str2 = p2;
                    String str3 = p0;
                    String str4 = p1;
                    String str5 = p4;
                    String str6 = p5;
                    pinFamilyAccountPresenter.getErrorConfigVersion.showProgress();
                    InviteFamilyAccount inviteFamilyAccount = pinFamilyAccountPresenter.getAuthRequestContext;
                    InviteFamilyAccount.Params.Companion companion = InviteFamilyAccount.Params.INSTANCE;
                    String str7 = str == null ? "" : str;
                    String str8 = str2 == null ? "" : str2;
                    if (str3 == null) {
                        str3 = "";
                    }
                    if (str4 == null) {
                        str4 = "";
                    }
                    String encrypt = RSAHelper.encrypt(str3, str4);
                    String str9 = str5 == null ? "" : str5;
                    String str10 = str6 == null ? "" : str6;
                    Intrinsics.checkNotNullExpressionValue(encrypt, "");
                    inviteFamilyAccount.execute(companion.create(new InviteMemberRequest(false, false, str7, str9, str10, str8, encrypt)), new Function1<InviteMemberResult, Unit>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$inviteFamilyAccount$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(InviteMemberResult inviteMemberResult) {
                            invoke2(inviteMemberResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(InviteMemberResult inviteMemberResult) {
                            AbstractPinContract.View view2;
                            AbstractPinContract.View view3;
                            Intrinsics.checkNotNullParameter(inviteMemberResult, "");
                            view2 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            view3 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view3.getAuthRequestContext();
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$inviteFamilyAccount$2
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
                            AbstractPinContract.View view2;
                            AbstractPinContract.View view3;
                            Context context;
                            AbstractPinContract.View view4;
                            Intrinsics.checkNotNullParameter(th, "");
                            view2 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            if (th instanceof NetworkException) {
                                view4 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                                NetworkException networkException = (NetworkException) th;
                                view4.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), networkException.getTraceId());
                            } else {
                                view3 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                                context = PinFamilyAccountPresenter.this.BuiltInFictitiousFunctionClassFactory;
                                view3.onError(ErrorUtil.PlaceComponentResult(th, context));
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(DanaLogConstants.Prefix.FAMILY_ACCOUNT_INVITE);
                            sb.append(PinFamilyAccountPresenter.this.getClass().getName());
                            sb.append(":onError");
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, sb.toString(), th);
                        }
                    });
                    return;
                }
                PinFamilyAccountPresenter.getAuthRequestContext(verifySecurityInfo);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                AbstractPinContract.View view;
                Intrinsics.checkNotNullParameter(p02, "");
                view = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                PinFamilyAccountPresenter.PlaceComponentResult(PinFamilyAccountPresenter.this, p02);
            }
        }, BuiltInFictitiousFunctionClassFactory(p2, p0));
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.FamilyAccountPinPresenter
    public final void PlaceComponentResult(String p0, final String p1, final String p2) {
        this.getErrorConfigVersion.showProgress();
        this.moveToNextValue.execute(new DefaultObserver<VerifySecurityInfo>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$verifySecurityProductJoinInvitation$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AbstractPinContract.View view;
                VerifySecurityInfo verifySecurityInfo = (VerifySecurityInfo) obj;
                Intrinsics.checkNotNullParameter(verifySecurityInfo, "");
                view = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                if (verifySecurityInfo.getSuccess()) {
                    final PinFamilyAccountPresenter pinFamilyAccountPresenter = PinFamilyAccountPresenter.this;
                    String str = p1;
                    String str2 = p2;
                    pinFamilyAccountPresenter.getErrorConfigVersion.showProgress();
                    pinFamilyAccountPresenter.KClassImpl$Data$declaredNonStaticMembers$2.execute(AcceptFamilyInvitation.Params.INSTANCE.createInvitationRequest(new InvitationDecisionRequestInfo(str2, str)), new Function1<InvitationDecisionInfo, Unit>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$acceptInvitationFamilyAccount$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(InvitationDecisionInfo invitationDecisionInfo) {
                            invoke2(invitationDecisionInfo);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(InvitationDecisionInfo invitationDecisionInfo) {
                            AbstractPinContract.View view2;
                            AbstractPinContract.View view3;
                            Intrinsics.checkNotNullParameter(invitationDecisionInfo, "");
                            view2 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            view3 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view3.getAuthRequestContext();
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.presenter.PinFamilyAccountPresenter$acceptInvitationFamilyAccount$2
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
                            AbstractPinContract.View view2;
                            AbstractPinContract.View view3;
                            Context context;
                            AbstractPinContract.View view4;
                            Intrinsics.checkNotNullParameter(th, "");
                            view2 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                            view2.dismissProgress();
                            if (th instanceof NetworkException) {
                                view4 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                                NetworkException networkException = (NetworkException) th;
                                view4.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), "");
                            } else {
                                view3 = PinFamilyAccountPresenter.this.getErrorConfigVersion;
                                context = PinFamilyAccountPresenter.this.BuiltInFictitiousFunctionClassFactory;
                                view3.onError(ErrorUtil.PlaceComponentResult(th, context));
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(DanaLogConstants.Prefix.FAMILY_ACCOUNT_JOIN);
                            sb.append(PinFamilyAccountPresenter.this.getClass().getName());
                            sb.append(":onError");
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, sb.toString(), th);
                        }
                    });
                    return;
                }
                PinFamilyAccountPresenter.getAuthRequestContext(verifySecurityInfo);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                PinFamilyAccountPresenter.PlaceComponentResult(PinFamilyAccountPresenter.this, p02);
            }
        }, BuiltInFictitiousFunctionClassFactory(p1, p0));
    }
}
