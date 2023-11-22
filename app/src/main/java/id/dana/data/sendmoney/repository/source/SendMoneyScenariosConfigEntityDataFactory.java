package id.dana.data.sendmoney.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData;
import id.dana.data.sendmoney.repository.source.split.SplitSendMoneyScenariosEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class SendMoneyScenariosConfigEntityDataFactory extends AbstractEntityDataFactory<SendMoneyScenariosEntityData> {
    private final DefaultSendMoneyScenariosEntityData defaultRecipientScenarioEntityData;
    private final SplitSendMoneyScenariosEntityData splitSendMoneyScenarioEntityData;

    @Inject
    public SendMoneyScenariosConfigEntityDataFactory(SplitSendMoneyScenariosEntityData splitSendMoneyScenariosEntityData, DefaultSendMoneyScenariosEntityData defaultSendMoneyScenariosEntityData) {
        this.splitSendMoneyScenarioEntityData = splitSendMoneyScenariosEntityData;
        this.defaultRecipientScenarioEntityData = defaultSendMoneyScenariosEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public SendMoneyScenariosEntityData createData2(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 103145323) {
            if (hashCode == 109648666 && str.equals("split")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("local")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            return this.splitSendMoneyScenarioEntityData;
        }
        return this.defaultRecipientScenarioEntityData;
    }
}
