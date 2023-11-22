package id.dana.myprofile.mepagerevamp.smartpay;

import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.model.AuthenticationTypeOption;
import id.dana.domain.autoroute.model.AutoRouteInit;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayPresenter;", "Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "Lid/dana/domain/autoroute/interactor/GetAutoRouteInitialSetting;", "MyBillsEntityDataFactory", "Lid/dana/domain/autoroute/interactor/GetAutoRouteInitialSetting;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/user/interactor/GetUserInfo;", "PlaceComponentResult", "Lid/dana/domain/user/interactor/GetUserInfo;", "", "Z", "getAuthRequestContext", "Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayContract$View;", "Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayContract$View;", "p0", "p1", "p2", "<init>", "(Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayContract$View;Lid/dana/domain/user/interactor/GetUserInfo;Lid/dana/domain/autoroute/interactor/GetAutoRouteInitialSetting;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmartPayPresenter implements SmartPayContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetAutoRouteInitialSetting BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetUserInfo MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SmartPayContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public SmartPayPresenter(SmartPayContract.View view, GetUserInfo getUserInfo, GetAutoRouteInitialSetting getAutoRouteInitialSetting) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        Intrinsics.checkNotNullParameter(getAutoRouteInitialSetting, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = getUserInfo;
        this.BuiltInFictitiousFunctionClassFactory = getAutoRouteInitialSetting;
    }

    @Override // id.dana.myprofile.mepagerevamp.smartpay.SmartPayContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.getAuthRequestContext) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<AutoRouteInit, Unit>() { // from class: id.dana.myprofile.mepagerevamp.smartpay.SmartPayPresenter$getAutoSwitchInitialState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AutoRouteInit autoRouteInit) {
                invoke2(autoRouteInit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(AutoRouteInit autoRouteInit) {
                String str;
                SmartPayContract.View view;
                Intrinsics.checkNotNullParameter(autoRouteInit, "");
                Boolean autorouteFeatureEnable = autoRouteInit.getAutorouteFeatureEnable();
                Boolean autorouteConfigEnable = autoRouteInit.getAutorouteConfigEnable();
                List<AuthenticationTypeOption> authenticationSettingOptions = autoRouteInit.getAuthenticationSettingOptions();
                if (authenticationSettingOptions == null || authenticationSettingOptions.isEmpty()) {
                    str = null;
                } else {
                    List<AuthenticationTypeOption> authenticationSettingOptions2 = autoRouteInit.getAuthenticationSettingOptions();
                    Intrinsics.checkNotNull(authenticationSettingOptions2);
                    str = authenticationSettingOptions2.get(0).getAuthenticationType();
                }
                view = SmartPayPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.onGetAutoSwitchInitialState(autorouteFeatureEnable != null ? autorouteFeatureEnable.booleanValue() : false, autorouteConfigEnable != null ? autorouteConfigEnable.booleanValue() : false, str);
                SmartPayPresenter.this.getAuthRequestContext = false;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.mepagerevamp.smartpay.SmartPayPresenter$getAutoSwitchInitialState$2
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
                SmartPayContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SmartPayPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.onGetAutoSwitchInitialState(false, false, null);
                SmartPayPresenter.KClassImpl$Data$declaredNonStaticMembers$2(SmartPayPresenter.this, DanaLogConstants.Prefix.AUTO_ROUTE_INIT, th);
            }
        });
        this.getAuthRequestContext = true;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SmartPayPresenter smartPayPresenter, String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(smartPayPresenter.getClass().getName());
        sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, sb.toString(), th);
    }
}
