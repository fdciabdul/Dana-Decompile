package id.dana.data.sendmoney.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.sendmoney.SendMoneyEntityData;
import id.dana.data.sendmoney.repository.source.network.NetworkSendMoneyEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SendMoneyDataFactory extends AbstractEntityDataFactory<SendMoneyEntityData> {
    private final NetworkSendMoneyEntityData networkSendMoneyEntityData;

    @Inject
    public SendMoneyDataFactory(NetworkSendMoneyEntityData networkSendMoneyEntityData) {
        this.networkSendMoneyEntityData = networkSendMoneyEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public SendMoneyEntityData createData2(String str) {
        str.hashCode();
        if (str.equals("network")) {
            return this.networkSendMoneyEntityData;
        }
        return null;
    }
}
