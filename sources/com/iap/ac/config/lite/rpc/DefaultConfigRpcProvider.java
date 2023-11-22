package com.iap.ac.config.lite.rpc;

import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.config.lite.common.AmcsConstants;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.delegate.ConfigRpcProvider;
import com.iap.ac.config.lite.facade.config.AmcsConfigRpcFacade;
import com.iap.ac.config.lite.facade.request.AmcsConfigByKeysRpcRequest;
import com.iap.ac.config.lite.facade.request.AmcsConfigByKeysRpcV1Request;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcRequest;
import com.iap.ac.config.lite.facade.request.AmcsConfigRpcV1Request;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;

/* loaded from: classes3.dex */
public class DefaultConfigRpcProvider implements ConfigRpcProvider {
    private static final String b = e.b("DefaultConfigRpcProvider");

    /* renamed from: a  reason: collision with root package name */
    private String f7650a;

    private AmcsConfigRpcFacade a() {
        if (TextUtils.isEmpty(this.f7650a)) {
            if (RPCProxyHost.isRpcProxyExist(AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE)) {
                return (AmcsConfigRpcFacade) RPCProxyHost.getInterfaceProxy(AmcsConfigRpcFacade.class, AmcsConstants.BIZ_CODE_AMCSLITE_FOR_MULTI_INSTANCE);
            }
            return (AmcsConfigRpcFacade) RPCProxyHost.getInterfaceProxy(AmcsConfigRpcFacade.class);
        }
        return (AmcsConfigRpcFacade) RPCProxyHost.getInterfaceProxy(AmcsConfigRpcFacade.class, this.f7650a);
    }

    @Override // com.iap.ac.config.lite.delegate.ConfigRpcProvider
    public AmcsConfigRpcResult fetchConfig(AmcsConfigRpcRequest amcsConfigRpcRequest) throws Exception {
        ACLog.i(b, String.format("DefaultConfigRpcProvider with bizCode [%s]. fetchConfig", this.f7650a));
        return a().fetchConfig(amcsConfigRpcRequest);
    }

    @Override // com.iap.ac.config.lite.delegate.ConfigRpcProvider
    public AmcsConfigRpcResult fetchConfigByKeys(AmcsConfigByKeysRpcRequest amcsConfigByKeysRpcRequest) throws Exception {
        ACLog.i(b, String.format("DefaultConfigRpcProvider with bizCode [%s]. fetchConfigByKeys", this.f7650a));
        return a().fetchConfigListByKeys(amcsConfigByKeysRpcRequest);
    }

    @Override // com.iap.ac.config.lite.delegate.ConfigRpcProvider
    public AmcsConfigRpcResult fetchConfigByKeysV1(AmcsConfigByKeysRpcV1Request amcsConfigByKeysRpcV1Request) throws Exception {
        ACLog.i(b, String.format("DefaultConfigRpcProvider with bizCode [%s]. fetchConfigByKeysV1", this.f7650a));
        return a().fetchConfigListByKeysV1(amcsConfigByKeysRpcV1Request);
    }

    @Override // com.iap.ac.config.lite.delegate.ConfigRpcProvider
    public AmcsConfigRpcResult fetchConfigV1(AmcsConfigRpcV1Request amcsConfigRpcV1Request) throws Exception {
        ACLog.i(b, String.format("DefaultConfigRpcProvider with bizCode [%s]. fetchConfigV1", this.f7650a));
        return a().fetchConfigV1(amcsConfigRpcV1Request);
    }

    public void setBizCode(String str) {
        this.f7650a = str;
    }
}
