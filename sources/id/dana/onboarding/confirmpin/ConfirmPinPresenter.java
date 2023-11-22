package id.dana.onboarding.confirmpin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.appsflyer.AFInAppEventType;
import dagger.Lazy;
import id.dana.analytics.firebase.FirebaseAnalyticsEvent;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.register.RegistrationTracker;
import id.dana.constants.AnalyticEventConstant;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetAuthenticationTypeFeature;
import id.dana.domain.passkey.model.DanaVizEntryPointConfig;
import id.dana.domain.registration.interactor.CreateProfile;
import id.dana.onboarding.confirmpin.ConfirmPinContract;
import id.dana.tracker.EventConfig;
import id.dana.tracker.EventConfigFactory;
import id.dana.tracker.EventConfigProperty;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.appsflyer.AppsflyerEvent;
import id.dana.tracker.branch.BranchEventStrategy;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.spm.SpmTagConstant;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\b\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u000f\u0012\u0006\u0010\u0007\u001a\u00020\"\u0012\u0006\u0010\t\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u001b\u0012\u0006\u0010&\u001a\u00020\u0019\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004JA\u0010\f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ7\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\f\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0010\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0014\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0014\u0010\u0017\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/onboarding/confirmpin/ConfirmPinPresenter;", "Lid/dana/onboarding/confirmpin/ConfirmPinContract$Presenter;", "", "onDestroy", "()V", "", "p0", "p1", "Ljava/io/File;", "p2", "p3", "p4", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "PlaceComponentResult", "Lid/dana/domain/registration/interactor/CreateProfile;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/registration/interactor/CreateProfile;", "Lid/dana/data/config/DeviceInformationProvider;", "getAuthRequestContext", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/domain/featureconfig/interactor/GetAuthenticationTypeFeature;", "Lid/dana/domain/featureconfig/interactor/GetAuthenticationTypeFeature;", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/domain/account/interactor/GetUserId;", "Ldagger/Lazy;", "Lid/dana/analytics/tracker/register/RegistrationTracker;", "getErrorConfigVersion", "Ldagger/Lazy;", "scheduleImpl", "Lid/dana/onboarding/confirmpin/ConfirmPinContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/onboarding/confirmpin/ConfirmPinContract$View;", "moveToNextValue", "p5", "p6", "<init>", "(Landroid/content/Context;Lid/dana/onboarding/confirmpin/ConfirmPinContract$View;Lid/dana/domain/registration/interactor/CreateProfile;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/domain/featureconfig/interactor/GetAuthenticationTypeFeature;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmPinPresenter implements ConfirmPinContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CreateProfile KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetUserId getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final ConfirmPinContract.View moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final GetAuthenticationTypeFeature BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DeviceInformationProvider MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<RegistrationTracker> scheduleImpl;

    @Inject
    public ConfirmPinPresenter(Context context, ConfirmPinContract.View view, CreateProfile createProfile, DeviceInformationProvider deviceInformationProvider, GetUserId getUserId, GetAuthenticationTypeFeature getAuthenticationTypeFeature, Lazy<RegistrationTracker> lazy) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(createProfile, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        Intrinsics.checkNotNullParameter(getAuthenticationTypeFeature, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.PlaceComponentResult = context;
        this.moveToNextValue = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = createProfile;
        this.MyBillsEntityDataFactory = deviceInformationProvider;
        this.getAuthRequestContext = getUserId;
        this.BuiltInFictitiousFunctionClassFactory = getAuthenticationTypeFeature;
        this.scheduleImpl = lazy;
    }

    @Override // id.dana.onboarding.confirmpin.ConfirmPinContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, String p1, File p2, String p3, String p4) {
        this.moveToNextValue.showProgress();
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(this.PlaceComponentResult);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.REGISTRATION_PIN_CONFIRM;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new CreateProfile.Params(p0, p3, p1, p2, p4), new Function1<Boolean, Unit>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinPresenter$register$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                ConfirmPinContract.View view;
                ConfirmPinContract.View view2;
                view = ConfirmPinPresenter.this.moveToNextValue;
                view.dismissProgress();
                if (!z) {
                    view2 = ConfirmPinPresenter.this.moveToNextValue;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2();
                    ConfirmPinPresenter.BuiltInFictitiousFunctionClassFactory(ConfirmPinPresenter.this, p0);
                    StringBuilder sb = new StringBuilder();
                    sb.append("registration failed!");
                    sb.append(p0);
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REGISTER_TAG, DanaLogConstants.Prefix.CONFIRM_PIN_REGISTER_PREFIX, sb.toString());
                    return;
                }
                final ConfirmPinPresenter confirmPinPresenter = ConfirmPinPresenter.this;
                confirmPinPresenter.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<DanaVizEntryPointConfig, Unit>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinPresenter$checkDanaVizEntryPointEnabled$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(DanaVizEntryPointConfig danaVizEntryPointConfig) {
                        invoke2(danaVizEntryPointConfig);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DanaVizEntryPointConfig danaVizEntryPointConfig) {
                        ConfirmPinContract.View view3;
                        Intrinsics.checkNotNullParameter(danaVizEntryPointConfig, "");
                        view3 = ConfirmPinPresenter.this.moveToNextValue;
                        view3.PlaceComponentResult(danaVizEntryPointConfig.getDanaVizPromptPage(), danaVizEntryPointConfig.getPasskeyEnrollment());
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinPresenter$checkDanaVizEntryPointEnabled$2
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
                        ConfirmPinContract.View view3;
                        Intrinsics.checkNotNullParameter(th, "");
                        view3 = ConfirmPinPresenter.this.moveToNextValue;
                        view3.PlaceComponentResult(false, false);
                    }
                });
                ConfirmPinPresenter.getAuthRequestContext(ConfirmPinPresenter.this);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinPresenter$register$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ConfirmPinContract.View view;
                Context context;
                ConfirmPinContract.View view2;
                Context context2;
                Intrinsics.checkNotNullParameter(th, "");
                view = ConfirmPinPresenter.this.moveToNextValue;
                view.dismissProgress();
                context = ConfirmPinPresenter.this.PlaceComponentResult;
                String MyBillsEntityDataFactory = ErrorUtil.MyBillsEntityDataFactory(context, th);
                view2 = ConfirmPinPresenter.this.moveToNextValue;
                view2.onError(MyBillsEntityDataFactory);
                context2 = ConfirmPinPresenter.this.PlaceComponentResult;
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(context2, TrackerDataKey.NetworkErrorOperationTypeProperty.REGISTER, MyBillsEntityDataFactory, "Registration", th);
                ConfirmPinPresenter.BuiltInFictitiousFunctionClassFactory(ConfirmPinPresenter.this, p0);
                StringBuilder sb = new StringBuilder();
                sb.append("register error: ");
                sb.append(p0);
                sb.append(th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REGISTER_TAG, DanaLogConstants.Prefix.CONFIRM_PIN_REGISTER_PREFIX, sb.toString());
            }
        });
    }

    @Override // id.dana.onboarding.confirmpin.ConfirmPinContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Intrinsics.checkNotNullParameter(p4, "");
        this.scheduleImpl.get().PlaceComponentResult(p0, p1, p2, p3, p4);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getAuthRequestContext.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(final ConfirmPinPresenter confirmPinPresenter) {
        confirmPinPresenter.getAuthRequestContext.execute(new DefaultObserver<String>() { // from class: id.dana.onboarding.confirmpin.ConfirmPinPresenter$userId$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ConfirmPinPresenter.PlaceComponentResult(ConfirmPinPresenter.this, str);
                ConfirmPinPresenter.BuiltInFictitiousFunctionClassFactory(ConfirmPinPresenter.this);
            }
        });
        Unit unit = Unit.INSTANCE;
    }

    public static final /* synthetic */ void PlaceComponentResult(ConfirmPinPresenter confirmPinPresenter, String str) {
        EventConfigProperty.Builder builder = new EventConfigProperty.Builder();
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = confirmPinPresenter.PlaceComponentResult;
        builder.getErrorConfigVersion = str;
        builder.lookAheadTest = confirmPinPresenter.MyBillsEntityDataFactory.getCurrentTrackerId();
        builder.MyBillsEntityDataFactory = "KYC0";
        Iterator<EventConfig> it = EventConfigFactory.getAuthRequestContext(new EventConfigProperty(builder, (byte) 0), confirmPinPresenter.MyBillsEntityDataFactory, TrackerType.APPSFLYER, TrackerType.BRANCH, TrackerType.MIXPANEL, TrackerType.FULLSTORY).iterator();
        while (it.hasNext()) {
            it.next().PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ConfirmPinPresenter confirmPinPresenter) {
        HashMap hashMap = new HashMap();
        String deviceUtdId = confirmPinPresenter.MyBillsEntityDataFactory.getDeviceUtdId();
        Intrinsics.checkNotNullExpressionValue(deviceUtdId, "");
        hashMap.put("UTDID", deviceUtdId);
        Bundle bundle = new Bundle();
        bundle.putString("UTDID", confirmPinPresenter.MyBillsEntityDataFactory.getDeviceUtdId());
        EventTracker.BuiltInFictitiousFunctionClassFactory(new AppsflyerEvent(confirmPinPresenter.PlaceComponentResult, AFInAppEventType.COMPLETE_REGISTRATION, hashMap), new FirebaseAnalyticsEvent(confirmPinPresenter.PlaceComponentResult, AFInAppEventType.COMPLETE_REGISTRATION, bundle));
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ConfirmPinPresenter confirmPinPresenter, String str) {
        new HashMap().put(SpmTagConstant.REGISTRATION.TAG_PHONE_NUMBER, str);
        HashMap hashMap = new HashMap();
        hashMap.put(SpmTagConstant.REGISTRATION.TAG_PHONE_NUMBER, str);
        hashMap.put("UTDID", confirmPinPresenter.MyBillsEntityDataFactory.getDeviceUtdId());
        Bundle bundle = new Bundle();
        bundle.putString(SpmTagConstant.REGISTRATION.TAG_PHONE_NUMBER, str);
        bundle.putString("UTDID", confirmPinPresenter.MyBillsEntityDataFactory.getDeviceUtdId());
        EventTracker.BuiltInFictitiousFunctionClassFactory(new AppsflyerEvent(confirmPinPresenter.PlaceComponentResult, AnalyticEventConstant.AE_FAILED_REGISTRATION, hashMap), new BranchEventStrategy(confirmPinPresenter.PlaceComponentResult, AnalyticEventConstant.AE_FAILED_REGISTRATION, hashMap), new FirebaseAnalyticsEvent(confirmPinPresenter.PlaceComponentResult, AnalyticEventConstant.AE_FAILED_REGISTRATION, bundle));
    }
}
