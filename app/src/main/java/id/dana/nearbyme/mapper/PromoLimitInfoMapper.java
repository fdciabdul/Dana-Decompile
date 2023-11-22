package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.PromoLimitInfo;
import id.dana.nearbyme.model.PromoLimitInfoModel;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyme/mapper/PromoLimitInfoMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/nearbyme/model/PromoLimitInfo;", "Lid/dana/nearbyme/model/PromoLimitInfoModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoLimitInfoMapper extends BaseMapper<PromoLimitInfo, PromoLimitInfoModel> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ PromoLimitInfoModel map(PromoLimitInfo promoLimitInfo) {
        PromoLimitInfo promoLimitInfo2 = promoLimitInfo;
        PromoLimitInfoModel promoLimitInfoModel = new PromoLimitInfoModel();
        promoLimitInfoModel.BuiltInFictitiousFunctionClassFactory = promoLimitInfo2 != null ? promoLimitInfo2.getLimitCount() : null;
        promoLimitInfoModel.KClassImpl$Data$declaredNonStaticMembers$2 = promoLimitInfo2 != null ? promoLimitInfo2.getLimitType() : null;
        promoLimitInfoModel.MyBillsEntityDataFactory = promoLimitInfo2 != null ? promoLimitInfo2.getLimitRangeType() : null;
        return promoLimitInfoModel;
    }

    @Inject
    public PromoLimitInfoMapper() {
    }
}
