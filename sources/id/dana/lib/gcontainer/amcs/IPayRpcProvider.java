package id.dana.lib.gcontainer.amcs;

import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.alipay.plus.android.config.sdk.facade.config.AmcsConfigRpcFacade;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigByKeysLiteRpcRequest;
import com.alipay.plus.android.config.sdk.facade.result.AmcsConfigRpcResult;
import com.alipay.plus.android.config.sdk.rpc.DefaultConfigRpcProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/lib/gcontainer/amcs/IPayRpcProvider;", "Lcom/alipay/plus/android/config/sdk/rpc/DefaultConfigRpcProvider;", "Lcom/alipay/plus/android/config/sdk/facade/request/AmcsConfigByKeysLiteRpcRequest;", "request", "Lcom/alipay/plus/android/config/sdk/facade/result/AmcsConfigRpcResult;", "fetchApps", "(Lcom/alipay/plus/android/config/sdk/facade/request/AmcsConfigByKeysLiteRpcRequest;)Lcom/alipay/plus/android/config/sdk/facade/result/AmcsConfigRpcResult;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class IPayRpcProvider extends DefaultConfigRpcProvider {
    @Override // com.alipay.plus.android.config.sdk.rpc.DefaultConfigRpcProvider, com.alipay.plus.android.config.sdk.delegate.ConfigRpcProvider
    public final AmcsConfigRpcResult fetchApps(AmcsConfigByKeysLiteRpcRequest request) throws Throwable {
        Intrinsics.checkNotNullParameter(request, "");
        return ((AmcsConfigRpcFacade) RPCProxyHost.getInterfaceProxy(AmcsConfigRpcFacade.class)).fetchLiteConfigByKeys(request);
    }
}
