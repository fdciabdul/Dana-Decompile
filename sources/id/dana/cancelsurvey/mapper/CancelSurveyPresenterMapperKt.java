package id.dana.cancelsurvey.mapper;

import id.dana.cancelsurvey.model.CancelReasonModel;
import id.dana.domain.cancelsurvey.model.CancelReason;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lid/dana/domain/cancelsurvey/model/CancelReason;", "", "Lid/dana/cancelsurvey/model/CancelReasonModel;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CancelSurveyPresenterMapperKt {
    public static final List<CancelReasonModel> MyBillsEntityDataFactory(List<CancelReason> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<CancelReason> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (CancelReason cancelReason : list2) {
            arrayList.add(new CancelReasonModel(cancelReason.getReasonCode(), cancelReason.getReasonMsg(), false, false, 12, null));
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }
}
