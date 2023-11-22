package id.dana.data.otp.repository.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.otp.repository.source.network.NetworkOtpEntityData;
import id.dana.data.otp.repository.source.network.OtpApi;
import id.dana.data.otp.repository.source.smsreceiver.SmsReceiverEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class OtpEntityDataFactory extends AbstractEntityDataFactory<OtpEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final ThreadExecutor executor;
    private final OtpApi otpApi;
    private final RpcConnector rpcConnector;

    @Inject
    public OtpEntityDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, OtpApi otpApi, Context context) {
        this.rpcConnector = rpcConnector;
        this.executor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
        this.otpApi = otpApi;
        this.context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public OtpEntityData createData2(String str) {
        if ("local".equals(str)) {
            return new SmsReceiverEntityData();
        }
        return new NetworkOtpEntityData(this.rpcConnector, this.executor, this.apSecurityFacade, this.otpApi, this.context);
    }
}
