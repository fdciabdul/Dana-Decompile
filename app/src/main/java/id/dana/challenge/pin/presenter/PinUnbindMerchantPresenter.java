package id.dana.challenge.pin.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.merchantmanagement.interactor.UnbindMerchant;
import id.dana.domain.merchantmanagement.model.UnbindMerchantParam;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001a\u0012\u0006\u0010\t\u001a\u00020\u001f\u0012\u0006\u0010\f\u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J!\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000eJ?\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\u0010J?\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\n\u0010\u0012J7\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\u0013J#\u0010\u0015\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0013\u0010\n\u001a\u00020\b*\u00020\u0018H\u0002¢\u0006\u0004\b\n\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0015\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0014\u0010\n\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010 "}, d2 = {"Lid/dana/challenge/pin/presenter/PinUnbindMerchantPresenter;", "Lid/dana/challenge/pin/AbstractPinContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "", "p0", "", "p1", "getAuthRequestContext", "(Ljava/lang/String;Z)V", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "p4", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Landroid/app/Activity;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Landroid/os/Bundle;)V", "onDestroy", "Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;", "(Lid/dana/domain/merchantmanagement/model/UnbindMerchantParam;)Z", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Lid/dana/domain/merchantmanagement/interactor/UnbindMerchant;", "Lid/dana/domain/merchantmanagement/interactor/UnbindMerchant;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "<init>", "(Landroid/content/Context;Lid/dana/challenge/pin/AbstractPinContract$View;Lid/dana/domain/merchantmanagement/interactor/UnbindMerchant;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PinUnbindMerchantPresenter implements AbstractPinContract.Presenter {
    private final UnbindMerchant BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

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
    public PinUnbindMerchantPresenter(Context context, AbstractPinContract.View view, UnbindMerchant unbindMerchant) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(unbindMerchant, "");
        this.PlaceComponentResult = context;
        this.getAuthRequestContext = view;
        this.BuiltInFictitiousFunctionClassFactory = unbindMerchant;
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, Bundle p1) {
        this.getAuthRequestContext.showProgress();
        String str = p0 == null ? "" : p0;
        Unit unit = null;
        String string = p1 != null ? p1.getString(ChallengeControl.Key.CLIENT_ID) : null;
        String str2 = string == null ? "" : string;
        String string2 = p1 != null ? p1.getString(ChallengeControl.Key.PUB_KEY) : null;
        String str3 = string2 == null ? "" : string2;
        String string3 = p1 != null ? p1.getString(ChallengeControl.Key.MERCHANT_ID) : null;
        String str4 = string3 == null ? "" : string3;
        String string4 = p1 != null ? p1.getString(ChallengeControl.Key.DIVISION_ID) : null;
        String string5 = p1 != null ? p1.getString(ChallengeControl.Key.SECURITY_ID) : null;
        UnbindMerchantParam unbindMerchantParam = new UnbindMerchantParam(str2, str3, str4, string4, str, string5 == null ? "" : string5, p1 != null ? p1.getString(ChallengeControl.Key.UNBIND_ELIGIBILITY_CHECK_ID) : null, p1 != null ? p1.getString(ChallengeControl.Key.USER_BOUND_ID) : null);
        if (!getAuthRequestContext(unbindMerchantParam)) {
            unbindMerchantParam = null;
        }
        if (unbindMerchantParam != null) {
            this.BuiltInFictitiousFunctionClassFactory.execute(new UnbindMerchant.Params(unbindMerchantParam), new Function1<Boolean, Unit>() { // from class: id.dana.challenge.pin.presenter.PinUnbindMerchantPresenter$onSuccessGetBundleData$1
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
                    PinUnbindMerchantPresenter.getAuthRequestContext(PinUnbindMerchantPresenter.this);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.presenter.PinUnbindMerchantPresenter$onSuccessGetBundleData$2
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
                    PinUnbindMerchantPresenter.getAuthRequestContext(PinUnbindMerchantPresenter.this, th);
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.getAuthRequestContext.dismissProgress();
            this.getAuthRequestContext.onError(ErrorUtil.MyBillsEntityDataFactory(this.PlaceComponentResult));
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MERCHANT_MANAGEMENT, "Unbind Merchant bundle data is empty");
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    private static boolean getAuthRequestContext(UnbindMerchantParam unbindMerchantParam) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{unbindMerchantParam.getClientId(), unbindMerchantParam.getPubKey(), unbindMerchantParam.getMerchantId(), unbindMerchantParam.getPin(), unbindMerchantParam.getSecurityId()});
        if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
            Iterator it = listOf.iterator();
            while (it.hasNext()) {
                if ((!StringsKt.isBlank((String) it.next())) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final /* synthetic */ void getAuthRequestContext(PinUnbindMerchantPresenter pinUnbindMerchantPresenter, Throwable th) {
        pinUnbindMerchantPresenter.getAuthRequestContext.dismissProgress();
        if (th instanceof NetworkException) {
            NetworkException networkException = (NetworkException) th;
            pinUnbindMerchantPresenter.getAuthRequestContext.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), networkException.getTraceId());
        } else {
            pinUnbindMerchantPresenter.getAuthRequestContext.onError(ErrorUtil.MyBillsEntityDataFactory(pinUnbindMerchantPresenter.PlaceComponentResult));
        }
        CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.UNBIND_MERCHANT, DanaLogConstants.ExceptionType.MERCHANT_MANAGEMENT_EXCEPTION, th);
    }

    public static final /* synthetic */ void getAuthRequestContext(PinUnbindMerchantPresenter pinUnbindMerchantPresenter) {
        pinUnbindMerchantPresenter.getAuthRequestContext.dismissProgress();
        pinUnbindMerchantPresenter.getAuthRequestContext.getAuthRequestContext();
    }
}
