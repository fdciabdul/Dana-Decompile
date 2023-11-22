package id.dana.data.promocenter.repository;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.promocenter.repository.source.local.LocalPromoCenterEntityData;
import id.dana.data.promocenter.repository.source.network.NetworkPromoCenterEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PromoCenterEntityDataFactory extends AbstractEntityDataFactory<PromoCenterEntityData> {
    private final LocalPromoCenterEntityData localPromoCenterEntityData;
    private final NetworkPromoCenterEntityData networkPromoCenterEntityData;

    @Inject
    public PromoCenterEntityDataFactory(NetworkPromoCenterEntityData networkPromoCenterEntityData, LocalPromoCenterEntityData localPromoCenterEntityData) {
        this.networkPromoCenterEntityData = networkPromoCenterEntityData;
        this.localPromoCenterEntityData = localPromoCenterEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public PromoCenterEntityData createData2(String str) {
        str.hashCode();
        if (str.equals("local")) {
            return this.localPromoCenterEntityData;
        }
        if (str.equals("network")) {
            return this.networkPromoCenterEntityData;
        }
        return null;
    }
}
