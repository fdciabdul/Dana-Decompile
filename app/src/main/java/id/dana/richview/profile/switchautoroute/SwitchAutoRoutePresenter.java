package id.dana.richview.profile.switchautoroute;

import id.dana.di.PerActivity;
import id.dana.domain.autoroute.interactor.IsHavingAutoRouteAsset;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.autoroute.model.Risk;
import id.dana.domain.autoroute.model.SecurityContext;
import id.dana.domain.autoroute.model.UserAutoRouteConfigStore;
import id.dana.domain.autoroute.model.UserAutoRouteConfigSwitch;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B!\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0013\u0012\u0006\u0010\t\u001a\u00020\u0010\u0012\u0006\u0010\n\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J5\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "", "p0", "", "p1", "p2", "p3", "MyBillsEntityDataFactory", "(ZLjava/lang/String;)V", "Lid/dana/domain/autoroute/interactor/IsHavingAutoRouteAsset;", "Lid/dana/domain/autoroute/interactor/IsHavingAutoRouteAsset;", "Lid/dana/domain/autoroute/interactor/SwitchAutoRouting;", "PlaceComponentResult", "Lid/dana/domain/autoroute/interactor/SwitchAutoRouting;", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;", "<init>", "(Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteContract$View;Lid/dana/domain/autoroute/interactor/SwitchAutoRouting;Lid/dana/domain/autoroute/interactor/IsHavingAutoRouteAsset;)V", "RiskResultValue"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class SwitchAutoRoutePresenter implements SwitchAutoRouteContract.Presenter {
    private final SwitchAutoRouteContract.View BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final IsHavingAutoRouteAsset MyBillsEntityDataFactory;
    private final SwitchAutoRouting PlaceComponentResult;

    @Inject
    public SwitchAutoRoutePresenter(SwitchAutoRouteContract.View view, SwitchAutoRouting switchAutoRouting, IsHavingAutoRouteAsset isHavingAutoRouteAsset) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(switchAutoRouting, "");
        Intrinsics.checkNotNullParameter(isHavingAutoRouteAsset, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.PlaceComponentResult = switchAutoRouting;
        this.MyBillsEntityDataFactory = isHavingAutoRouteAsset;
    }

    public final void MyBillsEntityDataFactory(final boolean z, String str) {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        UserAutoRouteConfigStore userAutoRouteConfigStore = new UserAutoRouteConfigStore(null, null, null, null, null, 31, null);
        userAutoRouteConfigStore.setAutoroute(Boolean.valueOf(z));
        userAutoRouteConfigStore.setAuthenticationType(str);
        userAutoRouteConfigStore.setSecurityId(null);
        userAutoRouteConfigStore.setValidateData(null);
        this.PlaceComponentResult.execute(userAutoRouteConfigStore, new Function1<UserAutoRouteConfigSwitch, Unit>() { // from class: id.dana.richview.profile.switchautoroute.SwitchAutoRoutePresenter$switchAutoRouteState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                SwitchAutoRouteContract.View view;
                Intrinsics.checkNotNullParameter(userAutoRouteConfigSwitch, "");
                view = SwitchAutoRoutePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                SwitchAutoRoutePresenter.getAuthRequestContext(SwitchAutoRoutePresenter.this, userAutoRouteConfigSwitch, z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.richview.profile.switchautoroute.SwitchAutoRoutePresenter$switchAutoRouteState$2
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
                SwitchAutoRouteContract.View view;
                SwitchAutoRouteContract.View view2;
                view = SwitchAutoRoutePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.dismissProgress();
                view2 = SwitchAutoRoutePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.onError(th != null ? th.getMessage() : null);
                SwitchAutoRoutePresenter.MyBillsEntityDataFactory(SwitchAutoRoutePresenter.this, th);
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.richview.profile.switchautoroute.SwitchAutoRoutePresenter$isHavingAutorouteAsset$1
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
                SwitchAutoRouteContract.View view;
                view = SwitchAutoRoutePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onCheckHavingAutorouteAsset(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.richview.profile.switchautoroute.SwitchAutoRoutePresenter$isHavingAutorouteAsset$2
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
                SwitchAutoRouteContract.View view;
                SwitchAutoRouteContract.View view2;
                view = SwitchAutoRoutePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view.onCheckHavingAutorouteAsset(false);
                view2 = SwitchAutoRoutePresenter.this.BuiltInFictitiousFunctionClassFactory;
                view2.onError(th != null ? th.getMessage() : null);
                SwitchAutoRoutePresenter.MyBillsEntityDataFactory(SwitchAutoRoutePresenter.this, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/richview/profile/switchautoroute/SwitchAutoRoutePresenter$RiskResultValue;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class RiskResultValue {
        public static final RiskResultValue INSTANCE = new RiskResultValue();

        private RiskResultValue() {
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(SwitchAutoRoutePresenter switchAutoRoutePresenter, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(DanaLogConstants.Prefix.AUTO_ROUTE_SWITCH);
        sb.append(switchAutoRoutePresenter.getClass().getName());
        sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.AUTO_ROUTE_SWITCH, sb.toString(), th);
    }

    public static final /* synthetic */ void getAuthRequestContext(SwitchAutoRoutePresenter switchAutoRoutePresenter, UserAutoRouteConfigSwitch userAutoRouteConfigSwitch, boolean z) {
        String str;
        String pubKey;
        Risk riskResult = userAutoRouteConfigSwitch.getRiskResult();
        String result = riskResult != null ? riskResult.getResult() : null;
        if (result == null ? true : Intrinsics.areEqual(result, "ACCEPT")) {
            switchAutoRoutePresenter.BuiltInFictitiousFunctionClassFactory.onSwitchResultAccept(z);
        } else if (!Intrinsics.areEqual(result, "VERIFICATION")) {
            switchAutoRoutePresenter.BuiltInFictitiousFunctionClassFactory.onSwitchResultReject(z);
        } else {
            Risk riskResult2 = userAutoRouteConfigSwitch.getRiskResult();
            String str2 = "";
            if (riskResult2 == null || (str = riskResult2.getSecurityId()) == null) {
                str = "";
            }
            SecurityContext securityContextResult = userAutoRouteConfigSwitch.getSecurityContextResult();
            if (securityContextResult != null && (pubKey = securityContextResult.getPubKey()) != null) {
                str2 = pubKey;
            }
            switchAutoRoutePresenter.BuiltInFictitiousFunctionClassFactory.onSwitchResultRisk(z, str, str2);
        }
    }
}
