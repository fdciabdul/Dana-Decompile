package id.dana.danah5.danaprotection.riskchallenge;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.danaprotection.DanaProtectionKey;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.Account;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.riskChallenges.ui.danaprotection.ActivityVerificationLauncher;
import id.dana.riskChallenges.ui.util.bridge.BaseRiskChallengeBridge;
import id.dana.riskChallenges.ui.util.uicomponent.UIComponentType;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\bC\u0010 J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010 J9\u0010'\u001a\u00020\n2\b\b\u0001\u0010\"\u001a\u00020\u000e2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010$\u001a\u00020#2\b\b\u0001\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u00105R\"\u00107\u001a\u0002068\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020=8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A"}, d2 = {"Lid/dana/danah5/danaprotection/riskchallenge/RiskChallengeBridge;", "Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;", "Landroid/os/Bundle;", "result", "Lkotlin/Pair;", "", "getListenerResult", "(Landroid/os/Bundle;)Lkotlin/Pair;", "Lcom/alibaba/fastjson/JSONObject;", "info", "", "getRiskChallengeStatus", "(Lcom/alibaba/fastjson/JSONObject;)V", "Lkotlin/Function2;", "", "callback", "getUserAccount", "(Lkotlin/jvm/functions/Function2;)V", "userId", "phoneNumber", RiskChallengeBridge.EVENT_ID, "action", "launchVerifyRiskChallenge", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onFinalized", "()V", "onInitialized", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.RISK_CHALLENGE, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "isApiSuccess", "isVerifySuccess", "sendBridgeJsonResponse", "(ZZ)V", "sendRiskChallengeResponse", "(Landroid/os/Bundle;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationLauncher;", "activityVerificationLauncher", "Lid/dana/riskChallenges/ui/danaprotection/ActivityVerificationLauncher;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/domain/account/interactor/GetAccount;", "getAccount", "Lid/dana/domain/account/interactor/GetAccount;", "getGetAccount", "()Lid/dana/domain/account/interactor/GetAccount;", "setGetAccount", "(Lid/dana/domain/account/interactor/GetAccount;)V", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "uiComponentRiskVerification$delegate", "Lkotlin/Lazy;", "getUiComponentRiskVerification", "()Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "uiComponentRiskVerification", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RiskChallengeBridge extends BaseRiskChallengeBridge {
    private static final String EVENT_ID = "eventId";
    private static final String IS_ME_ACTION = "isMeAction";
    private static final String ITS_ME = "ITS_ME";
    private static final String ITS_NOT_ME = "ITS_NOT_ME";
    private Activity activity;
    private ActivityVerificationLauncher activityVerificationLauncher;
    private BridgeCallback bridgeCallback;
    @Inject
    public GetAccount getAccount;

    /* renamed from: uiComponentRiskVerification$delegate  reason: from kotlin metadata */
    private final Lazy uiComponentRiskVerification = LazyKt.lazy(new Function0<UiComponent>() { // from class: id.dana.danah5.danaprotection.riskchallenge.RiskChallengeBridge$uiComponentRiskVerification$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UiComponent invoke() {
            return new UiComponent(UIComponentType.Full, R.color.f27072131100488, R.string.activity_identification);
        }
    });

    @JvmName(name = "getGetAccount")
    public final GetAccount getGetAccount() {
        GetAccount getAccount = this.getAccount;
        if (getAccount != null) {
            return getAccount;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetAccount")
    public final void setGetAccount(GetAccount getAccount) {
        Intrinsics.checkNotNullParameter(getAccount, "");
        this.getAccount = getAccount;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void riskChallenge(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        if (!Intrinsics.areEqual(eventName, DanaProtectionKey.EventName.HANDLE_RISK_CHALLENGE) || info == null) {
            return;
        }
        getRiskChallengeStatus(info);
    }

    private final void getRiskChallengeStatus(JSONObject info) {
        Object obj = info.get(EVENT_ID);
        final String str = obj instanceof String ? (String) obj : null;
        final String str2 = Intrinsics.areEqual(info.get(IS_ME_ACTION), Boolean.TRUE) ? ITS_ME : ITS_NOT_ME;
        getUserAccount(new Function2<String, String, Unit>() { // from class: id.dana.danah5.danaprotection.riskchallenge.RiskChallengeBridge$getRiskChallengeStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(String str3, String str4) {
                invoke2(str3, str4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str3, String str4) {
                Intrinsics.checkNotNullParameter(str3, "");
                Intrinsics.checkNotNullParameter(str4, "");
                RiskChallengeBridge riskChallengeBridge = RiskChallengeBridge.this;
                String str5 = str;
                riskChallengeBridge.launchVerifyRiskChallenge(str3, str4, str5 != null ? str5 : "", str2);
            }
        });
    }

    @JvmName(name = "getUiComponentRiskVerification")
    private final UiComponent getUiComponentRiskVerification() {
        return (UiComponent) this.uiComponentRiskVerification.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchVerifyRiskChallenge(String userId, String phoneNumber, String eventId, String action) {
        Activity activity = this.activity;
        Activity activity2 = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        if (activity instanceof GriverBaseActivity) {
            Activity activity3 = this.activity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                activity2 = activity3;
            }
            ActivityVerificationLauncher.Builder builder = new ActivityVerificationLauncher.Builder((GriverBaseActivity) activity2, this);
            Intrinsics.checkNotNullParameter(phoneNumber, "");
            builder.PlaceComponentResult = phoneNumber;
            Intrinsics.checkNotNullParameter(userId, "");
            builder.getErrorConfigVersion = userId;
            Intrinsics.checkNotNullParameter(eventId, "");
            builder.getAuthRequestContext = eventId;
            Intrinsics.checkNotNullParameter(action, "");
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = action;
            Intrinsics.checkNotNullParameter("Landing Page", "");
            builder.MyBillsEntityDataFactory = "Landing Page";
            UiComponent uiComponentRiskVerification = getUiComponentRiskVerification();
            Intrinsics.checkNotNullParameter(uiComponentRiskVerification, "");
            builder.scheduleImpl = uiComponentRiskVerification;
            Function1<Bundle, Unit> function1 = new Function1<Bundle, Unit>() { // from class: id.dana.danah5.danaprotection.riskchallenge.RiskChallengeBridge$launchVerifyRiskChallenge$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle) {
                    Intrinsics.checkNotNullParameter(bundle, "");
                    RiskChallengeBridge.this.sendRiskChallengeResponse(bundle);
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            builder.getErrorConfigVersion = function1;
            Function1<Bundle, Unit> function12 = new Function1<Bundle, Unit>() { // from class: id.dana.danah5.danaprotection.riskchallenge.RiskChallengeBridge$launchVerifyRiskChallenge$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Bundle bundle) {
                    invoke2(bundle);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Bundle bundle) {
                    Intrinsics.checkNotNullParameter(bundle, "");
                    RiskChallengeBridge.this.sendRiskChallengeResponse(bundle);
                }
            };
            Intrinsics.checkNotNullParameter(function12, "");
            builder.PlaceComponentResult = function12;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.danah5.danaprotection.riskchallenge.RiskChallengeBridge$launchVerifyRiskChallenge$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RiskChallengeBridge.this.sendBridgeJsonResponse(true, false);
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
            ActivityVerificationLauncher KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
            this.activityVerificationLauncher = KClassImpl$Data$declaredNonStaticMembers$2;
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    private final Pair<Boolean, Boolean> getListenerResult(Bundle result) {
        return new Pair<>(Boolean.valueOf(result.getBoolean("KEY_RESULT")), Boolean.valueOf(result.getBoolean("KEY_RISK_RESULT")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendBridgeJsonResponse(boolean isApiSuccess, boolean isVerifySuccess) {
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DanaProtectionKey.DanaProtectionResultParamsKey.CALL_API_SUCCESS, (Object) Boolean.valueOf(isApiSuccess));
        jSONObject.put(DanaProtectionKey.DanaProtectionResultParamsKey.RISK_CHALLENGE_SUCCESS, (Object) Boolean.valueOf(isVerifySuccess));
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    @Override // id.dana.riskChallenges.ui.util.bridge.BaseRiskChallengeBridge, id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ActivityVerificationLauncher activityVerificationLauncher = this.activityVerificationLauncher;
        if (activityVerificationLauncher != null) {
            activityVerificationLauncher.getAuthRequestContext(resultCode, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendRiskChallengeResponse(Bundle result) {
        Pair<Boolean, Boolean> listenerResult = getListenerResult(result);
        sendBridgeJsonResponse(listenerResult.component1().booleanValue(), listenerResult.component2().booleanValue());
    }

    private final void getUserAccount(final Function2<? super String, ? super String, Unit> callback) {
        getGetAccount().execute(new DefaultObserver<Account>() { // from class: id.dana.danah5.danaprotection.riskchallenge.RiskChallengeBridge$getUserAccount$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onNext(Account account) {
                Intrinsics.checkNotNullParameter(account, "");
                Function2<String, String, Unit> function2 = callback;
                String userId = account.getUserId();
                Intrinsics.checkNotNullExpressionValue(userId, "");
                String phoneNumber = account.getPhoneNumber();
                Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
                function2.invoke(userId, phoneNumber);
            }
        });
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(this);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        getGetAccount().dispose();
    }
}
