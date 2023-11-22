package id.dana.cashier.model;

import id.dana.cashier.domain.model.AddonImportantInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/cashier/domain/model/AddonImportantInfo;", "Lid/dana/cashier/model/AddonImportantInfoModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddonImportantInfoModelKt {
    public static final List<AddonImportantInfoModel> MyBillsEntityDataFactory(List<AddonImportantInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<AddonImportantInfo> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (AddonImportantInfo addonImportantInfo : list2) {
            Intrinsics.checkNotNullParameter(addonImportantInfo, "");
            arrayList.add(new AddonImportantInfoModel(addonImportantInfo.getInfoIcon(), addonImportantInfo.getInfoValue()));
        }
        return arrayList;
    }
}
