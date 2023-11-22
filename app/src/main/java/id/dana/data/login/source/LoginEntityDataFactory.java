package id.dana.data.login.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.login.source.network.NetworkLoginEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class LoginEntityDataFactory extends AbstractEntityDataFactory<LoginEntityData> {
    private final NetworkLoginEntityData networkLoginEntityData;

    @Inject
    public LoginEntityDataFactory(NetworkLoginEntityData networkLoginEntityData) {
        this.networkLoginEntityData = networkLoginEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public LoginEntityData createData2(String str) {
        return this.networkLoginEntityData;
    }
}
