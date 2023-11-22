package id.dana.danah5.userinfo;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.account.Account;
import id.dana.domain.account.interactor.GetAccount;
import io.reactivex.observers.DisposableObserver;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0010\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/danah5/userinfo/GetUsernameBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", BridgeName.GET_USERNAME, "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "onInitialized", "()V", "Lid/dana/domain/account/interactor/GetAccount;", "getAccount", "Lid/dana/domain/account/interactor/GetAccount;", "getGetAccount", "()Lid/dana/domain/account/interactor/GetAccount;", "setGetAccount", "(Lid/dana/domain/account/interactor/GetAccount;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetUsernameBridge extends SimpleBridgeExtension {
    public static final String USERNAME_KEY = "username";
    @Inject
    public GetAccount getAccount;

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
    public final void getUsername(@BindingCallback final BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        getGetAccount().execute(new DisposableObserver<Account>() { // from class: id.dana.danah5.userinfo.GetUsernameBridge$getUsername$1
            @Override // io.reactivex.Observer
            public final void onComplete() {
            }

            @Override // io.reactivex.Observer
            public final void onNext(Account account) {
                Intrinsics.checkNotNullParameter(account, "");
                BridgeCallback bridgeCallback2 = BridgeCallback.this;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", (Object) account.getUsername());
                bridgeCallback2.sendBridgeResponse(new BridgeResponse(jSONObject));
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable error) {
                Intrinsics.checkNotNullParameter(error, "");
                BridgeCallback.this.sendBridgeResponse(BridgeResponse.newError(5, error.getMessage()));
            }
        });
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(this);
    }
}
