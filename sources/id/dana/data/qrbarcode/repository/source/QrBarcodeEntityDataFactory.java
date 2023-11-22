package id.dana.data.qrbarcode.repository.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.qrbarcode.repository.source.mock.MockQrBarcodeEntityData;
import id.dana.data.qrbarcode.repository.source.network.NetworkQrBarcodeEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class QrBarcodeEntityDataFactory extends AbstractEntityDataFactory<QrBarcodeEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final RpcConnector rpcConnector;
    private final ThreadExecutor threadExecutor;

    @Inject
    public QrBarcodeEntityDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        this.rpcConnector = rpcConnector;
        this.threadExecutor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
        this.context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public QrBarcodeEntityData createData2(String str) {
        if (str.equals("mock")) {
            return new MockQrBarcodeEntityData();
        }
        return new NetworkQrBarcodeEntityData(this.rpcConnector, this.threadExecutor, this.apSecurityFacade, this.context);
    }
}
