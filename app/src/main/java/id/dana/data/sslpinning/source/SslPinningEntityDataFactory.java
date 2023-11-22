package id.dana.data.sslpinning.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.sslpinning.source.remote.RemoteSslPinningEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SslPinningEntityDataFactory extends AbstractEntityDataFactory<SslPinningEntityData> {
    private final RemoteSslPinningEntityData remoteSslPinningEntityData;

    @Inject
    public SslPinningEntityDataFactory(RemoteSslPinningEntityData remoteSslPinningEntityData) {
        this.remoteSslPinningEntityData = remoteSslPinningEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public SslPinningEntityData createData2(String str) {
        return this.remoteSslPinningEntityData;
    }
}
