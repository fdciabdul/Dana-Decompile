package id.dana.data.deeplink.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.deeplink.repository.source.branch.BranchDeepLinkEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class DeepLinkEntityDataFactory extends AbstractEntityDataFactory<DeepLinkEntityData> {
    private final BranchDeepLinkEntityData branchDeepLinkEntityData;

    @Inject
    public DeepLinkEntityDataFactory(BranchDeepLinkEntityData branchDeepLinkEntityData) {
        this.branchDeepLinkEntityData = branchDeepLinkEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public DeepLinkEntityData createData2(String str) {
        return this.branchDeepLinkEntityData;
    }
}
