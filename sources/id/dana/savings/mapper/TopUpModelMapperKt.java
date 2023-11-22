package id.dana.savings.mapper;

import id.dana.domain.saving.model.TopUpView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.savings.model.TopUpModel;
import id.dana.savings.model.TopUpStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/domain/saving/model/TopUpView;", "Lid/dana/savings/model/TopUpModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TopUpModelMapperKt {
    public static final List<TopUpModel> KClassImpl$Data$declaredNonStaticMembers$2(List<TopUpView> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<TopUpView> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (TopUpView topUpView : list2) {
            Intrinsics.checkNotNullParameter(topUpView, "");
            String topUpId = topUpView.getTopUpId();
            MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
            arrayList.add(new TopUpModel(topUpId, MoneyViewModel.Companion.PlaceComponentResult(topUpView.getFundAmount()), TopUpStatus.valueOf(topUpView.getStatus()), topUpView.getCreatedTime(), topUpView.getBizOrderId(), topUpView.getExtendInfo(), 0, 64, null));
        }
        return arrayList;
    }
}
