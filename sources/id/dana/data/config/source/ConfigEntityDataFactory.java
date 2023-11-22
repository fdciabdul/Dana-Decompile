package id.dana.data.config.source;

import dagger.Lazy;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.config.source.split.SplitConfigEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ConfigEntityDataFactory extends AbstractEntityDataFactory<ConfigEntityData> {
    private final Lazy<SplitConfigEntityData> splitConfigEntityData;

    @Inject
    public ConfigEntityDataFactory(Lazy<SplitConfigEntityData> lazy) {
        this.splitConfigEntityData = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public ConfigEntityData createData2(String str) {
        return this.splitConfigEntityData.get();
    }
}
