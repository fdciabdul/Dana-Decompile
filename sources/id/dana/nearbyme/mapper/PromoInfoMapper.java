package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.PromoLimitInfo;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyme/mapper/PromoInfoMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/nearbyme/model/PromoInfo;", "Lid/dana/nearbyme/model/PromoInfoModel;", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "getAuthRequestContext", "Lid/dana/nearbyme/mapper/PromoLimitInfoMapper;", "PlaceComponentResult", "Lid/dana/nearbyme/mapper/PromoLimitInfoMapper;", "p0", "p1", "<init>", "(Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;Lid/dana/nearbyme/mapper/PromoLimitInfoMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoInfoMapper extends BaseMapper<PromoInfo, PromoInfoModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final CurrencyAmountModelMapper getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PromoLimitInfoMapper MyBillsEntityDataFactory;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ PromoInfoModel map(PromoInfo promoInfo) {
        List<PromoLimitInfo> limitRule;
        PromoInfo promoInfo2 = promoInfo;
        PromoInfoModel promoInfoModel = new PromoInfoModel();
        ArrayList arrayList = null;
        String activityId = promoInfo2 != null ? promoInfo2.getActivityId() : null;
        if (activityId == null) {
            activityId = "";
        }
        promoInfoModel.BuiltInFictitiousFunctionClassFactory = activityId;
        String prizeType = promoInfo2 != null ? promoInfo2.getPrizeType() : null;
        promoInfoModel.getErrorConfigVersion = prizeType != null ? prizeType : "";
        List<String> paymentMethods = promoInfo2 != null ? promoInfo2.getPaymentMethods() : null;
        if (paymentMethods == null) {
            paymentMethods = CollectionsKt.emptyList();
        }
        promoInfoModel.lookAheadTest = paymentMethods;
        promoInfoModel.scheduleImpl = this.getAuthRequestContext.apply(promoInfo2 != null ? promoInfo2.getMinTransactionAmount() : null);
        promoInfoModel.getAuthRequestContext = promoInfo2 != null ? promoInfo2.getEndDate() : 0L;
        promoInfoModel.MyBillsEntityDataFactory = promoInfo2 != null ? promoInfo2.getBeginDate() : 0L;
        promoInfoModel.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.apply(promoInfo2 != null ? promoInfo2.getMaxAmount() : null);
        promoInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = promoInfo2 != null ? promoInfo2.getPromoDescription() : null;
        promoInfoModel.initRecordTimeStamp = promoInfo2 != null ? promoInfo2.getPromoValue() : null;
        promoInfoModel.moveToNextValue = promoInfo2 != null ? promoInfo2.getPromoType() : null;
        if (promoInfo2 != null && (limitRule = promoInfo2.getLimitRule()) != null) {
            List<PromoLimitInfo> list = limitRule;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(this.MyBillsEntityDataFactory.apply((PromoLimitInfo) it.next()));
            }
            arrayList = arrayList2;
        }
        promoInfoModel.PlaceComponentResult = arrayList;
        return promoInfoModel;
    }

    @Inject
    public PromoInfoMapper(CurrencyAmountModelMapper currencyAmountModelMapper, PromoLimitInfoMapper promoLimitInfoMapper) {
        Intrinsics.checkNotNullParameter(currencyAmountModelMapper, "");
        Intrinsics.checkNotNullParameter(promoLimitInfoMapper, "");
        this.getAuthRequestContext = currencyAmountModelMapper;
        this.MyBillsEntityDataFactory = promoLimitInfoMapper;
    }
}
