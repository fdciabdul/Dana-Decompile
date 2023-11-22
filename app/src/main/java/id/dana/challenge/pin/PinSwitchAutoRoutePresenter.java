package id.dana.challenge.pin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alipay.iap.android.common.utils.security.RSAHelper;
import id.dana.challenge.pin.AbstractPinContract;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.autoroute.model.UserAutoRouteConfigStore;
import id.dana.domain.autoroute.model.UserAutoRouteConfigSwitch;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B!\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0018\u0012\u0006\u0010\t\u001a\u00020\u001a\u0012\u0006\u0010\f\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J!\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000eJ?\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\u0010J?\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\n\u0010\u0012J7\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0003\u0010\u0013J#\u0010\u0015\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\n\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001d"}, d2 = {"Lid/dana/challenge/pin/PinSwitchAutoRoutePresenter;", "Lid/dana/challenge/pin/AbstractPinContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "", "p0", "", "p1", "getAuthRequestContext", "(Ljava/lang/String;Z)V", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "p4", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Landroid/app/Activity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Landroid/app/Activity;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Landroid/os/Bundle;)V", "onDestroy", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/domain/autoroute/interactor/SwitchAutoRouting;", "Lid/dana/domain/autoroute/interactor/SwitchAutoRouting;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "Lid/dana/challenge/pin/AbstractPinContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroid/content/Context;Lid/dana/domain/autoroute/interactor/SwitchAutoRouting;Lid/dana/challenge/pin/AbstractPinContract$View;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PinSwitchAutoRoutePresenter implements AbstractPinContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final SwitchAutoRouting getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AbstractPinContract.View KClassImpl$Data$declaredNonStaticMembers$2;

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
    public final /* synthetic */ void getAuthRequestContext(String str, String str2, boolean z, boolean z2) {
        AbstractPinContract.Presenter.CC.PlaceComponentResult();
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, boolean p1) {
    }

    @Inject
    public PinSwitchAutoRoutePresenter(Context context, SwitchAutoRouting switchAutoRouting, AbstractPinContract.View view) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(switchAutoRouting, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = context;
        this.getAuthRequestContext = switchAutoRouting;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Override // id.dana.challenge.pin.AbstractPinContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, String p2, boolean p3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.showProgress();
        this.getAuthRequestContext.execute(new UserAutoRouteConfigStore(Boolean.valueOf(p3), "PASSWORD", p2, RSAHelper.encrypt(p0, p1), null, 16, null), new Function1<UserAutoRouteConfigSwitch, Unit>() { // from class: id.dana.challenge.pin.PinSwitchAutoRoutePresenter$inputAutoRoute$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserAutoRouteConfigSwitch userAutoRouteConfigSwitch) {
                invoke2(userAutoRouteConfigSwitch);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserAutoRouteConfigSwitch userAutoRouteConfigSwitch) {
                AbstractPinContract.View view;
                AbstractPinContract.View view2;
                Intrinsics.checkNotNullParameter(userAutoRouteConfigSwitch, "");
                view = PinSwitchAutoRoutePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                view2 = PinSwitchAutoRoutePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view2.getAuthRequestContext();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.challenge.pin.PinSwitchAutoRoutePresenter$inputAutoRoute$2
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
                AbstractPinContract.View view2;
                Context context;
                AbstractPinContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = PinSwitchAutoRoutePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.dismissProgress();
                if (th instanceof NetworkException) {
                    view3 = PinSwitchAutoRoutePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    NetworkException networkException = (NetworkException) th;
                    view3.MyBillsEntityDataFactory(networkException.getErrorCode(), th.getMessage(), ErrorUtil.getAuthRequestContext(networkException.getLeftTimes()), networkException.getTraceId());
                } else {
                    view2 = PinSwitchAutoRoutePresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    context = PinSwitchAutoRoutePresenter.this.PlaceComponentResult;
                    view2.onError(ErrorUtil.PlaceComponentResult(th, context));
                }
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.AUTO_ROUTE_SWITCH);
                sb.append(PinSwitchAutoRoutePresenter.this.getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.AUTO_ROUTE_SWITCH, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
    }
}
