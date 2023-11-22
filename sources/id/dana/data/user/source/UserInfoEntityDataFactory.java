package id.dana.data.user.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.user.source.network.NetworkUserEntityData;
import id.dana.data.user.source.persistence.LocalUserInfoData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UserInfoEntityDataFactory extends AbstractEntityDataFactory<UserEntityData> {
    private final LocalUserInfoData localUserInfoData;
    private final NetworkUserEntityData networkUserEntityData;

    @Inject
    public UserInfoEntityDataFactory(NetworkUserEntityData networkUserEntityData, LocalUserInfoData localUserInfoData) {
        this.networkUserEntityData = networkUserEntityData;
        this.localUserInfoData = localUserInfoData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public UserEntityData createData2(String str) {
        if ("network".equals(str)) {
            return this.networkUserEntityData;
        }
        return this.localUserInfoData;
    }
}
