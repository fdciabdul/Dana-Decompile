package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.SendMoneyScenarioEntity;
import id.dana.domain.sendmoney.model.SendMoneyScenario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class SendMoneyScenariosMapper extends BaseMapper<List<SendMoneyScenarioEntity>, List<SendMoneyScenario>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public SendMoneyScenariosMapper() {
    }

    public SendMoneyScenario transform(SendMoneyScenarioEntity sendMoneyScenarioEntity) {
        if (sendMoneyScenarioEntity != null) {
            SendMoneyScenario sendMoneyScenario = new SendMoneyScenario();
            sendMoneyScenario.setKey(sendMoneyScenarioEntity.key);
            sendMoneyScenario.setAction(sendMoneyScenarioEntity.action);
            sendMoneyScenario.setIcon(sendMoneyScenarioEntity.icon);
            sendMoneyScenario.setTitle(sendMoneyScenarioEntity.title);
            sendMoneyScenario.setSubTitle(sendMoneyScenarioEntity.subTitle);
            sendMoneyScenario.setRedirectUrl(sendMoneyScenarioEntity.redirectUrl);
            sendMoneyScenario.setPromoActive(sendMoneyScenarioEntity.promoActive);
            sendMoneyScenario.setPromoTitle(sendMoneyScenarioEntity.promoTitle);
            sendMoneyScenario.setPromoDesc(sendMoneyScenarioEntity.promoDesc);
            sendMoneyScenario.setHasRedDot(sendMoneyScenarioEntity.hasRedDot);
            sendMoneyScenario.setNew(sendMoneyScenarioEntity.isNew);
            sendMoneyScenario.setClientId(sendMoneyScenarioEntity.clientId);
            sendMoneyScenario.setHttpMethod(sendMoneyScenarioEntity.httpMethod);
            sendMoneyScenario.setScopes(sendMoneyScenarioEntity.scopes);
            return sendMoneyScenario;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<SendMoneyScenario> map(List<SendMoneyScenarioEntity> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<SendMoneyScenarioEntity> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(transform(it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
