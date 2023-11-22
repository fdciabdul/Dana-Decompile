package id.dana.data.risk.riskevent.config;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.split.SplitConfigEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class RiskServicesConfigEntityDataFactory extends AbstractEntityDataFactory<ConfigEntityData> {
    private final SplitConfigEntityData splitConfigEntityData;

    @Inject
    public RiskServicesConfigEntityDataFactory(SplitConfigEntityData splitConfigEntityData) {
        this.splitConfigEntityData = splitConfigEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public ConfigEntityData createData2(String str) {
        return this.splitConfigEntityData;
    }
}
