package id.dana.network.base;

import android.content.Context;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.network.rpc.RpcConnector;
import id.dana.network.util.BaseNetworkUtils;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.foundation.facede.ApSecurity;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.michaelrocks.libphonenumber.android.Phonenumber;

/* loaded from: classes2.dex */
public abstract class SecureBaseNetwork<T> extends BaseNetwork<T> {
    private final Context context;
    private final ApSecurity securityFacade;

    public SecureBaseNetwork(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurity apSecurity, Context context) {
        super(rpcConnector, threadExecutor);
        this.securityFacade = apSecurity;
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }

    public String getClientKey() {
        ApSecurity apSecurity = this.securityFacade;
        if (apSecurity == null) {
            return null;
        }
        return apSecurity.MyBillsEntityDataFactory();
    }

    @Override // id.dana.network.base.BaseNetwork
    public Context passContext() {
        return getContext();
    }

    public MobileEnvInfo generateMobileEnvInfo() {
        return BaseNetworkUtils.generateMobileEnvInfo(this.securityFacade, this.context);
    }

    public String normalizePhoneNumber(String str) {
        try {
            Phonenumber.PhoneNumber parse = PhoneNumberUtil.createInstance(this.context).parse(str, "ID");
            int countryCode = parse.getCountryCode();
            long nationalNumber = parse.getNationalNumber();
            StringBuilder sb = new StringBuilder();
            sb.append(countryCode);
            sb.append("-");
            sb.append(nationalNumber);
            return sb.toString();
        } catch (NumberParseException unused) {
            return str;
        }
    }
}
