package id.dana.data.sendmoney.repository.source;

import id.dana.data.sendmoney.model.SendMoneyScenarioEntity;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface SendMoneyScenariosEntityData {
    Observable<List<SendMoneyScenarioEntity>> getSendMoneyScenarios();
}
