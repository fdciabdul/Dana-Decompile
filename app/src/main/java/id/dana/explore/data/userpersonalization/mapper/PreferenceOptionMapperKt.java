package id.dana.explore.data.userpersonalization.mapper;

import id.dana.explore.data.userpersonalization.source.network.result.PreferenceOptionInfoEntity;
import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionInfoEntity;", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PreferenceOptionMapperKt {
    public static final List<UserPersonalizationModel> KClassImpl$Data$declaredNonStaticMembers$2(List<PreferenceOptionInfoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PreferenceOptionInfoEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (PreferenceOptionInfoEntity preferenceOptionInfoEntity : list2) {
            Intrinsics.checkNotNullParameter(preferenceOptionInfoEntity, "");
            String iconUrl = preferenceOptionInfoEntity.getIconUrl();
            String str = iconUrl == null ? "" : iconUrl;
            String displayName = preferenceOptionInfoEntity.getDisplayName();
            String str2 = displayName == null ? "" : displayName;
            String preferenceId = preferenceOptionInfoEntity.getPreferenceId();
            String str3 = preferenceId == null ? "" : preferenceId;
            List<String> merchantMccList = preferenceOptionInfoEntity.getMerchantMccList();
            if (merchantMccList == null) {
                merchantMccList = CollectionsKt.emptyList();
            }
            List<String> list3 = merchantMccList;
            List<String> serviceCodeList = preferenceOptionInfoEntity.getServiceCodeList();
            if (serviceCodeList == null) {
                serviceCodeList = CollectionsKt.emptyList();
            }
            arrayList.add(new UserPersonalizationModel(str, str2, str3, list3, serviceCodeList));
        }
        return arrayList;
    }
}
