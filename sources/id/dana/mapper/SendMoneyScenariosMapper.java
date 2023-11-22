package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.SendMoneyScenario;
import id.dana.model.SendMoneyScenarioModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001B\t\b\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mapper/SendMoneyScenariosMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/sendmoney/model/SendMoneyScenario;", "", "Lid/dana/model/SendMoneyScenarioModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyScenariosMapper extends BaseMapper<List<? extends SendMoneyScenario>, List<SendMoneyScenarioModel>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<SendMoneyScenarioModel> map(List<? extends SendMoneyScenario> list) {
        ArrayList emptyList;
        List<? extends SendMoneyScenario> list2 = list;
        if (list2 != null) {
            List<? extends SendMoneyScenario> list3 = list2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(SendMoneyScenariosMapperKt.getAuthRequestContext((SendMoneyScenario) it.next()));
            }
            emptyList = arrayList;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        return CollectionsKt.toMutableList((Collection) emptyList);
    }

    @Inject
    public SendMoneyScenariosMapper() {
    }
}
