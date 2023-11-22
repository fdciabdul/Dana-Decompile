package id.dana.data.homeinfo.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.homeinfo.repository.source.network.NetworkHomeEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class HomeInfoEntityDataFactory extends AbstractEntityDataFactory<HomeEntityData> {
    private final NetworkHomeEntityData networkHomeEntityData;

    @Inject
    public HomeInfoEntityDataFactory(NetworkHomeEntityData networkHomeEntityData) {
        this.networkHomeEntityData = networkHomeEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public HomeEntityData createData2(String str) {
        return this.networkHomeEntityData;
    }
}
