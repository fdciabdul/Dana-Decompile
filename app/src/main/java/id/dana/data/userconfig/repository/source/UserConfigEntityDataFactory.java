package id.dana.data.userconfig.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.userconfig.repository.source.local.PersistenceUserConfigEntityData;
import id.dana.data.userconfig.repository.source.network.NetworkUserConfigEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class UserConfigEntityDataFactory extends AbstractEntityDataFactory<UserConfigEntityData> {
    private final PersistenceUserConfigEntityData localDataSource;
    private final NetworkUserConfigEntityData networkDataSource;

    @Inject
    public UserConfigEntityDataFactory(NetworkUserConfigEntityData networkUserConfigEntityData, PersistenceUserConfigEntityData persistenceUserConfigEntityData) {
        this.networkDataSource = networkUserConfigEntityData;
        this.localDataSource = persistenceUserConfigEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public UserConfigEntityData createData2(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 103145323) {
            if (hashCode == 1843485230 && str.equals("network")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("local")) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0) {
            return this.localDataSource;
        }
        return this.networkDataSource;
    }
}
