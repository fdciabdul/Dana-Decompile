package id.dana.data.useremailaddress.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.useremailaddress.UserEmailAddressEntityData;
import id.dana.data.useremailaddress.repository.source.network.NetworkUserEmailAddressEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UserEmailAddressEntityDataFactory extends AbstractEntityDataFactory<UserEmailAddressEntityData> {
    private final NetworkUserEmailAddressEntityData networkUserEmailAddressEntityData;

    @Inject
    public UserEmailAddressEntityDataFactory(NetworkUserEmailAddressEntityData networkUserEmailAddressEntityData) {
        this.networkUserEmailAddressEntityData = networkUserEmailAddressEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public UserEmailAddressEntityData createData2(String str) {
        return this.networkUserEmailAddressEntityData;
    }
}
