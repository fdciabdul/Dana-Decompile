package id.dana.data.security.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.security.source.network.NetworkSecurityEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SecurityEntityDataFactory extends AbstractEntityDataFactory<SecurityEntityData> {
    private final NetworkSecurityEntityData networkSecurityEntityData;

    @Inject
    public SecurityEntityDataFactory(NetworkSecurityEntityData networkSecurityEntityData) {
        this.networkSecurityEntityData = networkSecurityEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    public SecurityEntityData createData(String str) {
        return this.networkSecurityEntityData;
    }
}
