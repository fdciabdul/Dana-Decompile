package id.dana.data.wallet_v3.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import id.dana.data.wallet_v3.repository.source.persistence.entity.KtpDaoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/wallet_v3/mapper/KtpInfoResultMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/data/wallet_v3/repository/source/persistence/entity/KtpDaoEntity;", "Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "oldItem", "map", "(Ljava/util/List;)Ljava/util/List;", "ktpDaoEntity", "transformKtpResult", "(Lid/dana/data/wallet_v3/repository/source/persistence/entity/KtpDaoEntity;)Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KtpInfoResultMapper extends BaseMapper<List<? extends KtpDaoEntity>, List<? extends KtpResult>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* bridge */ /* synthetic */ List<? extends KtpResult> map(List<? extends KtpDaoEntity> list) {
        return map2((List<KtpDaoEntity>) list);
    }

    @Inject
    public KtpInfoResultMapper() {
    }

    /* renamed from: map  reason: avoid collision after fix types in other method */
    protected final List<KtpResult> map2(List<KtpDaoEntity> oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = oldItem.iterator();
        while (it.hasNext()) {
            KtpResult transformKtpResult = transformKtpResult((KtpDaoEntity) it.next());
            if (transformKtpResult != null) {
                arrayList.add(transformKtpResult);
            }
        }
        return arrayList;
    }

    private final KtpResult transformKtpResult(KtpDaoEntity ktpDaoEntity) {
        KtpResult ktpResult = new KtpResult(ktpDaoEntity.getBackgroundUrl(), ktpDaoEntity.getCreatedDate(), ktpDaoEntity.getIconUrl(), ktpDaoEntity.getLogoUrl(), ktpDaoEntity.getPocketId(), ktpDaoEntity.getPocketStatus(), ktpDaoEntity.getPocketType(), ktpDaoEntity.getCardTitle());
        ktpResult.extendInfo = ktpDaoEntity.getExtendInfo();
        return ktpResult;
    }
}
