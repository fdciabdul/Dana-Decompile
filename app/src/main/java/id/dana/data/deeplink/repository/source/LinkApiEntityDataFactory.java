package id.dana.data.deeplink.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.deeplink.repository.source.network.NetworkLinkApiEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class LinkApiEntityDataFactory extends AbstractEntityDataFactory<LinkApiEntityData> {
    private final NetworkLinkApiEntityData networkLinkApiEntityData;

    @Inject
    public LinkApiEntityDataFactory(NetworkLinkApiEntityData networkLinkApiEntityData) {
        this.networkLinkApiEntityData = networkLinkApiEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public LinkApiEntityData createData2(String str) {
        return this.networkLinkApiEntityData;
    }
}
