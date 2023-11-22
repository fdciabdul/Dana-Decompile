package id.dana.data.login.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.login.source.network.NetworkHoldLoginEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class HoldLoginEntityDataFactory extends AbstractEntityDataFactory<HoldLoginEntityData> {
    public NetworkHoldLoginEntityData networkHoldLoginEntityData;

    @Inject
    public HoldLoginEntityDataFactory(NetworkHoldLoginEntityData networkHoldLoginEntityData) {
        this.networkHoldLoginEntityData = networkHoldLoginEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public HoldLoginEntityData createData2(String str) {
        return this.networkHoldLoginEntityData;
    }
}
