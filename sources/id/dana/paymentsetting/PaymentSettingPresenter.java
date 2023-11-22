package id.dana.paymentsetting;

import dagger.Lazy;
import id.dana.domain.DefaultObserver;
import id.dana.domain.autoroute.interactor.GetAutoRouteInitialSetting;
import id.dana.domain.autoroute.interactor.SwitchAutoRouting;
import id.dana.domain.autoroute.model.AutoRouteInit;
import id.dana.domain.autoroute.model.Risk;
import id.dana.domain.autoroute.model.SecurityContext;
import id.dana.domain.autoroute.model.UserAutoRouteConfigStore;
import id.dana.domain.autoroute.model.UserAutoRouteConfigSwitch;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.paymentsetting.interactor.PaymentSettingCheck;
import id.dana.domain.paymentsetting.interactor.SavePaymentSettingCheck;
import id.dana.domain.profilemenu.interactor.ControlSwitchPaymentAuthentication;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.interactor.InitPaymentAuthentication;
import id.dana.domain.profilemenu.model.PaymentSecurityInit;
import id.dana.domain.profilemenu.model.PaymentSecuritySwitch;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mapper.PaymentSecurityInitMapper;
import id.dana.myprofile.mapper.PaymentSecuritySwitchMapper;
import id.dana.paymentsetting.PaymentSettingContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u0001:\u0001.B\u008f\u0001\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020$\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020!0\u0013\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\u0013\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0013¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J5\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\tJ1\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\u0012R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00160\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00170\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020#0\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001d\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010%"}, d2 = {"Lid/dana/paymentsetting/PaymentSettingPresenter;", "Lid/dana/paymentsetting/PaymentSettingContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "MyBillsEntityDataFactory", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)V", "Lid/dana/domain/profilemenu/model/SettingModel;", "p1", "(Ljava/lang/String;Lid/dana/domain/profilemenu/model/SettingModel;)V", "onDestroy", "", "p2", "p3", "PlaceComponentResult", "(ZLjava/lang/String;Ljava/lang/String;Lid/dana/domain/profilemenu/model/SettingModel;)V", "Ldagger/Lazy;", "Lid/dana/domain/profilemenu/interactor/ControlSwitchPaymentAuthentication;", "Ldagger/Lazy;", "Lid/dana/domain/autoroute/interactor/GetAutoRouteInitialSetting;", "Lid/dana/domain/profilemenu/interactor/GetSettingByKey;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/profilemenu/interactor/InitPaymentAuthentication;", "Lid/dana/myprofile/mapper/PaymentSecurityInitMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/myprofile/mapper/PaymentSecuritySwitchMapper;", "getErrorConfigVersion", "scheduleImpl", "Lid/dana/domain/paymentsetting/interactor/PaymentSettingCheck;", "lookAheadTest", "Lid/dana/domain/paymentsetting/interactor/SavePaymentSettingCheck;", "moveToNextValue", "Lid/dana/domain/autoroute/interactor/SwitchAutoRouting;", "Lid/dana/paymentsetting/PaymentSettingContract$View;", "Lid/dana/paymentsetting/PaymentSettingContract$View;", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Lid/dana/paymentsetting/PaymentSettingContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentSettingPresenter implements PaymentSettingContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<GetSettingByKey> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Lazy<SavePaymentSettingCheck> moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<ControlSwitchPaymentAuthentication> PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<PaymentSecurityInitMapper> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<GetAutoRouteInitialSetting> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<InitPaymentAuthentication> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<PaymentSecuritySwitchMapper> scheduleImpl;
    private final Lazy<PaymentSettingCheck> lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final PaymentSettingContract.View getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<SwitchAutoRouting> NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public PaymentSettingPresenter(PaymentSettingContract.View view, Lazy<PaymentSettingCheck> lazy, Lazy<SavePaymentSettingCheck> lazy2, Lazy<GetSettingByKey> lazy3, Lazy<GetAutoRouteInitialSetting> lazy4, Lazy<SwitchAutoRouting> lazy5, Lazy<InitPaymentAuthentication> lazy6, Lazy<PaymentSecurityInitMapper> lazy7, Lazy<ControlSwitchPaymentAuthentication> lazy8, Lazy<PaymentSecuritySwitchMapper> lazy9) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        this.getErrorConfigVersion = view;
        this.lookAheadTest = lazy;
        this.moveToNextValue = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy5;
        this.BuiltInFictitiousFunctionClassFactory = lazy6;
        this.getAuthRequestContext = lazy7;
        this.PlaceComponentResult = lazy8;
        this.scheduleImpl = lazy9;
    }

    @Override // id.dana.paymentsetting.PaymentSettingContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.lookAheadTest.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$checkPaymentSetting$1
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
                PaymentSettingContract.View view;
                view = PaymentSettingPresenter.this.getErrorConfigVersion;
                view.getAuthRequestContext(z);
                PaymentSettingPresenter.this.moveToNextValue.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$savePaymentSettingCheck$1
                    public final void invoke(boolean z2) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$savePaymentSettingCheck$2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYMENT_SETTING_TAG, th.getMessage(), th);
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$checkPaymentSetting$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYMENT_SETTING_TAG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.paymentsetting.PaymentSettingContract.Presenter
    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.get().execute(new DefaultObserver<SettingModel>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$getProfileSettingModel$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                PaymentSettingContract.View view;
                PaymentSettingContract.View view2;
                SettingModel settingModel = (SettingModel) obj;
                Intrinsics.checkNotNullParameter(settingModel, "");
                if (Intrinsics.areEqual(p0, "SWITCH_AOUTOROUTE_ON")) {
                    view2 = this.getErrorConfigVersion;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2(settingModel);
                    return;
                }
                view = this.getErrorConfigVersion;
                view.MyBillsEntityDataFactory(settingModel);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                PaymentSettingContract.View view;
                Intrinsics.checkNotNullParameter(p02, "");
                view = this.getErrorConfigVersion;
                view.MyBillsEntityDataFactory(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYMENT_SETTING_TAG, p02.getMessage(), p02);
            }
        }, GetSettingByKey.Params.forSettingKey("setting_more"));
    }

    @Override // id.dana.paymentsetting.PaymentSettingContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1<AutoRouteInit, Unit>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$getAutoRouteInitialState$1
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
                PaymentSettingContract.View view;
                PaymentSettingContract.View view2;
                PaymentSettingContract.View view3;
                Intrinsics.checkNotNullParameter(autoRouteInit, "");
                Boolean autorouteAssetExist = autoRouteInit.getAutorouteAssetExist();
                boolean booleanValue = autorouteAssetExist != null ? autorouteAssetExist.booleanValue() : false;
                Boolean autorouteConfigEnable = autoRouteInit.getAutorouteConfigEnable();
                boolean booleanValue2 = autorouteConfigEnable != null ? autorouteConfigEnable.booleanValue() : false;
                if (booleanValue && booleanValue2) {
                    view3 = PaymentSettingPresenter.this.getErrorConfigVersion;
                    view3.getAuthRequestContext();
                } else if (!booleanValue || booleanValue2) {
                    view = PaymentSettingPresenter.this.getErrorConfigVersion;
                    view.KClassImpl$Data$declaredNonStaticMembers$2();
                } else {
                    view2 = PaymentSettingPresenter.this.getErrorConfigVersion;
                    view2.getAuthRequestContext(autoRouteInit.getAuthenticationSettingOptions());
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$getAutoRouteInitialState$2
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
                PaymentSettingContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PaymentSettingPresenter.this.getErrorConfigVersion;
                view.BuiltInFictitiousFunctionClassFactory();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYMENT_SETTING_TAG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.paymentsetting.PaymentSettingContract.Presenter
    public final void PlaceComponentResult(String str) {
        this.getErrorConfigVersion.showProgress();
        UserAutoRouteConfigStore userAutoRouteConfigStore = new UserAutoRouteConfigStore(null, null, null, null, null, 31, null);
        userAutoRouteConfigStore.setAutoroute(Boolean.TRUE);
        userAutoRouteConfigStore.setAuthenticationType(str);
        userAutoRouteConfigStore.setSecurityId(null);
        userAutoRouteConfigStore.setValidateData(null);
        final boolean z = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(userAutoRouteConfigStore, new Function1<UserAutoRouteConfigSwitch, Unit>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$switchAutoRouteState$1
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
                PaymentSettingContract.View view;
                Intrinsics.checkNotNullParameter(userAutoRouteConfigSwitch, "");
                view = PaymentSettingPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                PaymentSettingPresenter.getAuthRequestContext(PaymentSettingPresenter.this, userAutoRouteConfigSwitch, z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$switchAutoRouteState$2
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
                PaymentSettingContract.View view;
                PaymentSettingContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = PaymentSettingPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                view2 = PaymentSettingPresenter.this.getErrorConfigVersion;
                view2.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.paymentsetting.PaymentSettingContract.Presenter
    public final void MyBillsEntityDataFactory(final String p0, final SettingModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getErrorConfigVersion.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.get().execute(new DefaultObserver<PaymentSecurityInit>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$initPaymentAuth$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                PaymentSettingContract.View view;
                PaymentSettingContract.View view2;
                Lazy lazy;
                PaymentSecurityInit paymentSecurityInit = (PaymentSecurityInit) obj;
                Intrinsics.checkNotNullParameter(paymentSecurityInit, "");
                view = PaymentSettingPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                view2 = PaymentSettingPresenter.this.getErrorConfigVersion;
                lazy = PaymentSettingPresenter.this.getAuthRequestContext;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(((PaymentSecurityInitMapper) lazy.get()).apply(paymentSecurityInit), p0, p1);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                PaymentSettingContract.View view;
                PaymentSettingContract.View view2;
                Intrinsics.checkNotNullParameter(p02, "");
                view = PaymentSettingPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                view2 = PaymentSettingPresenter.this.getErrorConfigVersion;
                view2.MyBillsEntityDataFactory(p0, p1);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYMENT_SETTING_TAG, p02.getMessage(), p02);
            }
        });
    }

    @Override // id.dana.paymentsetting.PaymentSettingContract.Presenter
    public final void getAuthRequestContext(boolean p0, String p1, final String p2, final SettingModel p3) {
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.getErrorConfigVersion.showProgress();
        this.PlaceComponentResult.get().execute(new DefaultObserver<PaymentSecuritySwitch>() { // from class: id.dana.paymentsetting.PaymentSettingPresenter$switchPaymentAuth$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                PaymentSettingContract.View view;
                PaymentSettingContract.View view2;
                Lazy lazy;
                PaymentSettingContract.View view3;
                PaymentSecuritySwitch paymentSecuritySwitch = (PaymentSecuritySwitch) obj;
                Intrinsics.checkNotNullParameter(paymentSecuritySwitch, "");
                view = PaymentSettingPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                if (Intrinsics.areEqual("ACCEPT", paymentSecuritySwitch.getRisk().getResult())) {
                    view3 = PaymentSettingPresenter.this.getErrorConfigVersion;
                    view3.getAuthRequestContext(p2, p3, true);
                    return;
                }
                view2 = PaymentSettingPresenter.this.getErrorConfigVersion;
                lazy = PaymentSettingPresenter.this.scheduleImpl;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(((PaymentSecuritySwitchMapper) lazy.get()).apply(paymentSecuritySwitch), p2, p3);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                PaymentSettingContract.View view;
                PaymentSettingContract.View view2;
                Intrinsics.checkNotNullParameter(p02, "");
                view = PaymentSettingPresenter.this.getErrorConfigVersion;
                view.dismissProgress();
                view2 = PaymentSettingPresenter.this.getErrorConfigVersion;
                view2.getAuthRequestContext(p2, p3, false);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYMENT_SETTING_TAG, p02.getMessage(), p02);
            }
        }, ControlSwitchPaymentAuthentication.Params.forPaymentSecuritySwitchOn(p0, p1));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.lookAheadTest.get().dispose();
        this.moveToNextValue.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.PlaceComponentResult.get().dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(PaymentSettingPresenter paymentSettingPresenter, UserAutoRouteConfigSwitch userAutoRouteConfigSwitch, boolean z) {
        String str;
        String pubKey;
        Risk riskResult = userAutoRouteConfigSwitch.getRiskResult();
        String result = riskResult != null ? riskResult.getResult() : null;
        if (result == null ? true : Intrinsics.areEqual(result, "ACCEPT")) {
            paymentSettingPresenter.getErrorConfigVersion.PlaceComponentResult();
        } else if (!Intrinsics.areEqual(result, "VERIFICATION")) {
            paymentSettingPresenter.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory();
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
            paymentSettingPresenter.getErrorConfigVersion.PlaceComponentResult(z, str, str2);
        }
    }
}
