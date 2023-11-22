package id.dana.data.wallet_v3.mapper;

import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import id.dana.data.wallet_v3.repository.source.persistence.entity.KtpDaoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "Lid/dana/data/wallet_v3/repository/source/persistence/entity/KtpDaoEntity;", "toKtpDaoEntity", "(Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;)Lid/dana/data/wallet_v3/repository/source/persistence/entity/KtpDaoEntity;", "", "toKtpEntities", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserIdentityAssetsDaoMapperKt {
    public static final List<KtpDaoEntity> toKtpEntities(List<KtpResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<KtpResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toKtpDaoEntity((KtpResult) it.next()));
        }
        return arrayList;
    }

    public static final KtpDaoEntity toKtpDaoEntity(KtpResult ktpResult) {
        Intrinsics.checkNotNullParameter(ktpResult, "");
        String pocketId = ktpResult.getPocketId();
        return new KtpDaoEntity(pocketId == null ? "" : pocketId, ktpResult.getPocketStatus(), ktpResult.getPocketType(), ktpResult.getBackgroundUrl(), ktpResult.getCreatedDate(), ktpResult.getIconUrl(), ktpResult.getLogoUrl(), ktpResult.extendInfo, "KTP");
    }
}
