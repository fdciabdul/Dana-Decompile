package id.dana.data.deeplink.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.deeplink.repository.source.branch.BranchGenerateLinkEntityData;
import id.dana.data.deeplink.repository.source.local.PreferencesGenerateLinkEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class GenerateLinkEntityDataFactory extends AbstractEntityDataFactory<GenerateLinkEntityData> {
    private final BranchGenerateLinkEntityData branchGenerateLinkEntityData;
    private final PreferencesGenerateLinkEntityData preferencesGenerateLinkEntityData;

    @Inject
    public GenerateLinkEntityDataFactory(BranchGenerateLinkEntityData branchGenerateLinkEntityData, PreferencesGenerateLinkEntityData preferencesGenerateLinkEntityData) {
        this.branchGenerateLinkEntityData = branchGenerateLinkEntityData;
        this.preferencesGenerateLinkEntityData = preferencesGenerateLinkEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public GenerateLinkEntityData createData2(String str) {
        if ("local".equals(str)) {
            return this.preferencesGenerateLinkEntityData;
        }
        return this.branchGenerateLinkEntityData;
    }
}
