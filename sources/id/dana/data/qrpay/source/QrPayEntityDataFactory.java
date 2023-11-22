package id.dana.data.qrpay.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.qrpay.source.remote.RemoteQrPayEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class QrPayEntityDataFactory extends AbstractEntityDataFactory<QrPayEntityData> {
    private final RemoteQrPayEntityData remoteQrPayEntityData;

    @Inject
    public QrPayEntityDataFactory(RemoteQrPayEntityData remoteQrPayEntityData) {
        this.remoteQrPayEntityData = remoteQrPayEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public QrPayEntityData createData2(String str) {
        return this.remoteQrPayEntityData;
    }
}
