package id.dana.data.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.data.nearbyme.model.PromoInfoEntity;
import id.dana.data.nearbyme.model.PromoLimitInfoEntity;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.PromoLimitInfo;
import id.dana.domain.user.CurrencyAmount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/data/nearbyme/mapper/PromoInfoEntityMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/nearbyme/model/PromoInfoEntity;", "Lid/dana/domain/nearbyme/model/PromoInfo;", "oldItem", "map", "(Lid/dana/data/nearbyme/model/PromoInfoEntity;)Lid/dana/domain/nearbyme/model/PromoInfo;", "Lid/dana/data/model/CurrencyAmountResult;", "entity", "Lid/dana/domain/user/CurrencyAmount;", "transform", "(Lid/dana/data/model/CurrencyAmountResult;)Lid/dana/domain/user/CurrencyAmount;", "Lid/dana/data/nearbyme/model/PromoLimitInfoEntity;", "promoLimitInfoEntity", "Lid/dana/domain/nearbyme/model/PromoLimitInfo;", "transformPromoLimitInfo", "(Lid/dana/data/nearbyme/model/PromoLimitInfoEntity;)Lid/dana/domain/nearbyme/model/PromoLimitInfo;", "", "promoLimitInfoEntities", "", "transformPromoLimitInfoEntities", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PromoInfoEntityMapper extends BaseMapper<PromoInfoEntity, PromoInfo> {
    @Inject
    public PromoInfoEntityMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public final PromoInfo map(PromoInfoEntity oldItem) {
        PromoInfo promoInfo = new PromoInfo(null, null, null, null, null, null, null, 0L, 0L, null, null, 2047, null);
        if (oldItem != null) {
            promoInfo.setActivityId(oldItem.getActivityId());
            promoInfo.setPrizeType(oldItem.getPrizeType());
            promoInfo.setPaymentMethods(oldItem.getPaymentMethods());
            promoInfo.setMinTransactionAmount(transform(oldItem.getMinTransactionAmount()));
            promoInfo.setEndDate(oldItem.getEndDate());
            promoInfo.setBeginDate(oldItem.getBeginDate());
            promoInfo.setMaxAmount(transform(oldItem.getMaxAmount()));
            promoInfo.setPromoDescription(oldItem.getPromoDescription());
            promoInfo.setPromoValue(oldItem.getPromoValue());
            promoInfo.setPromoType(oldItem.getPromoType());
            promoInfo.setLimitRule(transformPromoLimitInfoEntities(oldItem.getLimitRule()));
            return promoInfo;
        }
        return promoInfo;
    }

    private final List<PromoLimitInfo> transformPromoLimitInfoEntities(List<? extends PromoLimitInfoEntity> promoLimitInfoEntities) {
        ArrayList arrayList = new ArrayList();
        if (promoLimitInfoEntities != null) {
            List<? extends PromoLimitInfoEntity> list = promoLimitInfoEntities;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Boolean.valueOf(arrayList.add(transformPromoLimitInfo((PromoLimitInfoEntity) it.next()))));
            }
        }
        return arrayList;
    }

    private final PromoLimitInfo transformPromoLimitInfo(PromoLimitInfoEntity promoLimitInfoEntity) {
        PromoLimitInfo promoLimitInfo = new PromoLimitInfo(null, null, null, 7, null);
        if (promoLimitInfoEntity != null) {
            promoLimitInfo.setLimitCount(promoLimitInfoEntity.getLimitCount());
            promoLimitInfo.setLimitType(promoLimitInfoEntity.getLimitType());
            promoLimitInfo.setLimitRangeType(promoLimitInfoEntity.getLimitRangeType());
        }
        return promoLimitInfo;
    }

    private final CurrencyAmount transform(CurrencyAmountResult entity) {
        if (entity != null) {
            return new CurrencyAmount(entity.getAmount(), entity.getCurrency());
        }
        return null;
    }
}
