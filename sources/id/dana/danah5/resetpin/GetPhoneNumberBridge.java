package id.dana.danah5.resetpin;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.registration.interactor.GetPhoneNumberAttempt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0016\u0010\fJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\"\u0010\t\u001a\u00020\u00108\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/danah5/resetpin/GetPhoneNumberBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", "phoneNumber", "changePhoneNumberFormat", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "getPhoneNumber", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "getPhoneNumberFromRegManager", "()V", "onFinalized", "onInitialized", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/domain/registration/interactor/GetPhoneNumberAttempt;", "Lid/dana/domain/registration/interactor/GetPhoneNumberAttempt;", "getGetPhoneNumber", "()Lid/dana/domain/registration/interactor/GetPhoneNumberAttempt;", "setGetPhoneNumber", "(Lid/dana/domain/registration/interactor/GetPhoneNumberAttempt;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetPhoneNumberBridge extends SimpleBridgeExtension {
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String PHONE_NUMBER_ID_FORMAT = "0";
    private static final String PHONE_NUMBER_INTERNATIONAL_FORMAT = "+62";
    private static final String SUCCESS = "success";
    private BridgeCallback bridgeCallback;
    @Inject
    public GetPhoneNumberAttempt getPhoneNumber;

    @JvmName(name = "getGetPhoneNumber")
    public final GetPhoneNumberAttempt getGetPhoneNumber() {
        GetPhoneNumberAttempt getPhoneNumberAttempt = this.getPhoneNumber;
        if (getPhoneNumberAttempt != null) {
            return getPhoneNumberAttempt;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetPhoneNumber")
    public final void setGetPhoneNumber(GetPhoneNumberAttempt getPhoneNumberAttempt) {
        Intrinsics.checkNotNullParameter(getPhoneNumberAttempt, "");
        this.getPhoneNumber = getPhoneNumberAttempt;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void getPhoneNumber(@BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        this.bridgeCallback = bridgeCallback;
        getPhoneNumberFromRegManager();
    }

    private final void getPhoneNumberFromRegManager() {
        getGetPhoneNumber().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.danah5.resetpin.GetPhoneNumberBridge$getPhoneNumberFromRegManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                String changePhoneNumberFormat;
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(str, "");
                changePhoneNumberFormat = GetPhoneNumberBridge.this.changePhoneNumberFormat(str);
                bridgeCallback = GetPhoneNumberBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", (Object) Boolean.TRUE);
                jSONObject.put("phoneNumber", (Object) changePhoneNumberFormat);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.resetpin.GetPhoneNumberBridge$getPhoneNumberFromRegManager$2
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
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(th, "");
                bridgeCallback = GetPhoneNumberBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", (Object) Boolean.FALSE);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String changePhoneNumberFormat(String phoneNumber) {
        return phoneNumber.length() > 0 ? StringsKt.replace$default(phoneNumber, PHONE_NUMBER_INTERNATIONAL_FORMAT, "0", false, 4, (Object) null) : phoneNumber;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
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

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        getGetPhoneNumber().dispose();
    }
}
