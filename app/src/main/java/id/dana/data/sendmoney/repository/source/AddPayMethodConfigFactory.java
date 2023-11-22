package id.dana.data.sendmoney.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.sendmoney.AddPayMethodConfigEntityData;
import id.dana.data.sendmoney.repository.source.local.DefaultAddPayMethodConfig;
import id.dana.data.sendmoney.repository.source.split.SplitAddPayMethodConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class AddPayMethodConfigFactory extends AbstractEntityDataFactory<AddPayMethodConfigEntityData> {
    private DefaultAddPayMethodConfig defaultAddPayMethodConfig;
    private SplitAddPayMethodConfig splitAddPayMethodConfig;

    @Inject
    public AddPayMethodConfigFactory(DefaultAddPayMethodConfig defaultAddPayMethodConfig, SplitAddPayMethodConfig splitAddPayMethodConfig) {
        this.defaultAddPayMethodConfig = defaultAddPayMethodConfig;
        this.splitAddPayMethodConfig = splitAddPayMethodConfig;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public AddPayMethodConfigEntityData createData2(String str) {
        str.hashCode();
        if (str.equals("local")) {
            return this.defaultAddPayMethodConfig;
        }
        return this.splitAddPayMethodConfig;
    }
}
