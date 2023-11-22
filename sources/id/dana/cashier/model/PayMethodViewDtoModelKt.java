package id.dana.cashier.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/cashier/model/PayMethodViewDtoModel;", "Lid/dana/cashier/model/CashierPayMethodModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayMethodViewDtoModelKt {
    public static final List<CashierPayMethodModel> KClassImpl$Data$declaredNonStaticMembers$2(List<PayMethodViewDtoModel> list) {
        List<CashierPayChannelModel> list2;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (PayMethodViewDtoModel payMethodViewDtoModel : list) {
                if (!payMethodViewDtoModel.getAuthRequestContext()) {
                    if (!payMethodViewDtoModel.PlaceComponentResult()) {
                        if (payMethodViewDtoModel.KClassImpl$Data$declaredNonStaticMembers$2() && (list2 = payMethodViewDtoModel.MyBillsEntityDataFactory) != null) {
                            arrayList.addAll(CashierPayChannelModelKt.MyBillsEntityDataFactory(list2));
                        }
                    } else {
                        List<CashierPayChannelModel> list3 = payMethodViewDtoModel.MyBillsEntityDataFactory;
                        if (list3 != null) {
                            arrayList.addAll(CashierPayChannelModelKt.getAuthRequestContext(list3));
                        }
                    }
                } else {
                    List<AssetCardModel> list4 = payMethodViewDtoModel.getAuthRequestContext;
                    if (list4 != null) {
                        arrayList.addAll(AssetCardModelKt.KClassImpl$Data$declaredNonStaticMembers$2(list4));
                    }
                }
            }
        }
        return arrayList;
    }
}
