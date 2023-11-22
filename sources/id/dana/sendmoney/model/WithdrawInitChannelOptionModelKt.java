package id.dana.sendmoney.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/sendmoney/model/WithdrawInitChannelOptionModel;", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawInitChannelOptionModelKt {
    public static final List<ExternalWithdrawChannelModel> MyBillsEntityDataFactory(List<WithdrawInitChannelOptionModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<WithdrawInitChannelOptionModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (WithdrawInitChannelOptionModel withdrawInitChannelOptionModel : list2) {
            arrayList.add(new ExternalWithdrawChannelModel(withdrawInitChannelOptionModel.NetworkUserEntityData$$ExternalSyntheticLambda0, withdrawInitChannelOptionModel.moveToNextValue, withdrawInitChannelOptionModel.getErrorConfigVersion, withdrawInitChannelOptionModel.scheduleImpl, withdrawInitChannelOptionModel.NetworkUserEntityData$$ExternalSyntheticLambda1, withdrawInitChannelOptionModel.KClassImpl$Data$declaredNonStaticMembers$2, withdrawInitChannelOptionModel.getAuthRequestContext, withdrawInitChannelOptionModel.PlaceComponentResult, withdrawInitChannelOptionModel.lookAheadTest, null, null, 1536, null));
        }
        return arrayList;
    }
}
