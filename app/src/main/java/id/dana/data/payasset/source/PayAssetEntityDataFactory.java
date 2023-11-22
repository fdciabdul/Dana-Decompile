package id.dana.data.payasset.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.payasset.source.network.NetworkPayAssetEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PayAssetEntityDataFactory extends AbstractEntityDataFactory<PayAssetEntityData> {
    private final NetworkPayAssetEntityData networkPayAssetEntityData;

    @Inject
    public PayAssetEntityDataFactory(NetworkPayAssetEntityData networkPayAssetEntityData) {
        this.networkPayAssetEntityData = networkPayAssetEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public PayAssetEntityData createData2(String str) {
        return this.networkPayAssetEntityData;
    }
}
