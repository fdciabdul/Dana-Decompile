package id.dana.data.splitbill.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.splitbill.repository.source.network.NetworkSplitBillEntityData;
import id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SplitBillEntityDataFactory extends AbstractEntityDataFactory<SplitBillEntityData> {
    private final NetworkSplitBillEntityData networkSplitBillEntityData;
    private final PersistenceSplitBillEntityData persistenceSplitBillEntityData;

    @Inject
    public SplitBillEntityDataFactory(PersistenceSplitBillEntityData persistenceSplitBillEntityData, NetworkSplitBillEntityData networkSplitBillEntityData) {
        this.persistenceSplitBillEntityData = persistenceSplitBillEntityData;
        this.networkSplitBillEntityData = networkSplitBillEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public SplitBillEntityData createData2(String str) {
        str.hashCode();
        if (str.equals("local")) {
            return this.persistenceSplitBillEntityData;
        }
        if (str.equals("network")) {
            return this.networkSplitBillEntityData;
        }
        return null;
    }
}
