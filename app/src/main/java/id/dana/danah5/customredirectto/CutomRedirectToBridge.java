package id.dana.danah5.customredirectto;

import android.app.Application;
import android.os.Bundle;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.iap.ac.android.common.utils.security.RSAHelper;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.DanaH5;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.account.AccountEntity;
import id.dana.data.miniprogram.source.local.MiniProgramPreference;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.utils.danah5.DanaH5Listener;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u000eJ/\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/danah5/customredirectto/CutomRedirectToBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", "url", "publicKey", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", BridgeName.CUSTOM_REDIRECT_TO, "(Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "handleCustomRedirect", "(Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "handleCustomRedirectBukalapak", "onInitialized", "()V", "Lid/dana/data/miniprogram/source/local/MiniProgramPreference;", "miniProgramPreference", "Lid/dana/data/miniprogram/source/local/MiniProgramPreference;", "getMiniProgramPreference", "()Lid/dana/data/miniprogram/source/local/MiniProgramPreference;", "setMiniProgramPreference", "(Lid/dana/data/miniprogram/source/local/MiniProgramPreference;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CutomRedirectToBridge extends SimpleBridgeExtension {
    @Inject
    public MiniProgramPreference miniProgramPreference;

    @JvmName(name = "getMiniProgramPreference")
    public final MiniProgramPreference getMiniProgramPreference() {
        MiniProgramPreference miniProgramPreference = this.miniProgramPreference;
        if (miniProgramPreference != null) {
            return miniProgramPreference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMiniProgramPreference")
    public final void setMiniProgramPreference(MiniProgramPreference miniProgramPreference) {
        Intrinsics.checkNotNullParameter(miniProgramPreference, "");
        this.miniProgramPreference = miniProgramPreference;
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void customRedirectTo(@BindingParam(name = {"url"}) String url, @BindingParam(name = {"publicKey"}) String publicKey, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(url, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        String str = url;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) CustomRedirectURLKt.BUKALAPAK, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) CustomRedirectURLKt.DUMMY, false, 2, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) CustomRedirectURLKt.BUKALAPAK, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) CustomRedirectURLKt.DUMMY, false, 2, (Object) null)) {
                handleCustomRedirectBukalapak(url, publicKey, bridgeCallback);
                return;
            } else {
                handleCustomRedirect(url, bridgeCallback);
                return;
            }
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
    }

    private final void handleCustomRedirectBukalapak(String url, String publicKey, final BridgeCallback bridgeCallback) {
        AccountEntity account = getMiniProgramPreference().BuiltInFictitiousFunctionClassFactory.getAccount();
        String encrypt = RSAHelper.encrypt(account != null ? account.getPhoneNumber() : null, String.valueOf(publicKey));
        Intrinsics.checkNotNullExpressionValue(encrypt, "");
        DanaH5.startContainerFullUrl(StringsKt.replace$default(url, "{phonenumber}", encrypt, false, 4, (Object) null), new DanaH5Listener() { // from class: id.dana.danah5.customredirectto.CutomRedirectToBridge$handleCustomRedirectBukalapak$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                BridgeCallback.this.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        });
    }

    private final void handleCustomRedirect(String url, final BridgeCallback bridgeCallback) {
        DanaH5.startContainerFullUrl(url, new DanaH5Listener() { // from class: id.dana.danah5.customredirectto.CutomRedirectToBridge$handleCustomRedirect$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle bundle) {
                BridgeCallback.this.sendBridgeResponse(BridgeResponse.SUCCESS);
            }
        });
    }
}
