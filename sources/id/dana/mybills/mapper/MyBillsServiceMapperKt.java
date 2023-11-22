package id.dana.mybills.mapper;

import id.dana.domain.mybills.model.MyBillsServiceModel;
import id.dana.model.ThirdPartyService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/model/ThirdPartyService;", "Lid/dana/domain/mybills/model/MyBillsServiceModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillsServiceMapperKt {
    public static final List<MyBillsServiceModel> MyBillsEntityDataFactory(List<ThirdPartyService> list) {
        Intrinsics.checkNotNullParameter(list, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ThirdPartyService) obj).getDatabaseTableConfigUtil()) {
                arrayList.add(obj);
            }
        }
        ArrayList<ThirdPartyService> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ThirdPartyService thirdPartyService : arrayList2) {
            Intrinsics.checkNotNullParameter(thirdPartyService, "");
            arrayList3.add(new MyBillsServiceModel(thirdPartyService.FragmentBottomSheetPaymentSettingBinding, thirdPartyService.GetContactSyncConfig, thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda6, thirdPartyService.AppCompatEmojiTextHelper));
        }
        return arrayList3;
    }
}
