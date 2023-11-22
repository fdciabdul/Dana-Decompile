package id.dana.data.risk.riskevent;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SendRiskEventEntityDataFactory extends AbstractEntityDataFactory<SendRiskEventEntityData> {
    private NetworkSendRiskEventEntityData networkSendRiskEventEntityData;

    @Inject
    public SendRiskEventEntityDataFactory(NetworkSendRiskEventEntityData networkSendRiskEventEntityData) {
        this.networkSendRiskEventEntityData = networkSendRiskEventEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public SendRiskEventEntityData createData2(String str) {
        return this.networkSendRiskEventEntityData;
    }
}
