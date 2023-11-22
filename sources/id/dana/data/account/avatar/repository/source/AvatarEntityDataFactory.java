package id.dana.data.account.avatar.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.account.avatar.repository.source.network.NetworkFileUploadEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
public class AvatarEntityDataFactory extends AbstractEntityDataFactory<AvatarEntityData> {
    private final NetworkFileUploadEntityData networkFileUploadEntityData;

    @Inject
    public AvatarEntityDataFactory(NetworkFileUploadEntityData networkFileUploadEntityData) {
        this.networkFileUploadEntityData = networkFileUploadEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public AvatarEntityData createData2(String str) {
        return this.networkFileUploadEntityData;
    }
}
