package id.dana.data.verifytoken.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.verifytoken.repository.source.network.NetworkVerifyTokenEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class VerifyTokenEntityDataFactory extends AbstractEntityDataFactory<VerifyTokenEntityData> {
    private final NetworkVerifyTokenEntityData networkVerifyTokenEntityData;

    @Inject
    public VerifyTokenEntityDataFactory(NetworkVerifyTokenEntityData networkVerifyTokenEntityData) {
        this.networkVerifyTokenEntityData = networkVerifyTokenEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public VerifyTokenEntityData createData2(String str) {
        return this.networkVerifyTokenEntityData;
    }
}
