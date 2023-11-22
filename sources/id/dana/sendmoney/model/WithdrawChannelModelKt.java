package id.dana.sendmoney.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/sendmoney/model/WithdrawChannelModel;", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawChannelModelKt {
    public static final List<ExternalWithdrawChannelModel> BuiltInFictitiousFunctionClassFactory(List<WithdrawChannelModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<WithdrawChannelModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (WithdrawChannelModel withdrawChannelModel : list2) {
            arrayList.add(new ExternalWithdrawChannelModel(withdrawChannelModel.PlaceComponentResult, withdrawChannelModel.MyBillsEntityDataFactory, withdrawChannelModel.BuiltInFictitiousFunctionClassFactory, withdrawChannelModel.getErrorConfigVersion, withdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda0, null, null, null, null, null, withdrawChannelModel.getAuthRequestContext, 992, null));
        }
        return arrayList;
    }
}
