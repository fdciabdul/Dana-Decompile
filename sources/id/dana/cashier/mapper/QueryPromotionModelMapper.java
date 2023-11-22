package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.QueryPromotionInfo;
import id.dana.cashier.model.QueryPromotionModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.data.base.BaseMapper;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/mapper/QueryPromotionModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/domain/model/QueryPromotionInfo;", "Lid/dana/cashier/model/QueryPromotionModel;", "Lid/dana/cashier/mapper/VoucherCashierModelsMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/mapper/VoucherCashierModelsMapper;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/cashier/mapper/VoucherCashierModelsMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryPromotionModelMapper extends BaseMapper<QueryPromotionInfo, QueryPromotionModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final VoucherCashierModelsMapper MyBillsEntityDataFactory;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ QueryPromotionModel map(QueryPromotionInfo queryPromotionInfo) {
        QueryPromotionInfo queryPromotionInfo2 = queryPromotionInfo;
        Intrinsics.checkNotNullParameter(queryPromotionInfo2, "");
        Boolean success = queryPromotionInfo2.getSuccess();
        List<? extends VoucherCashierModel> apply = this.MyBillsEntityDataFactory.apply(queryPromotionInfo2.getVoucherList());
        Intrinsics.checkNotNullExpressionValue(apply, "");
        return new QueryPromotionModel(success, apply);
    }

    @Inject
    public QueryPromotionModelMapper(VoucherCashierModelsMapper voucherCashierModelsMapper) {
        Intrinsics.checkNotNullParameter(voucherCashierModelsMapper, "");
        this.MyBillsEntityDataFactory = voucherCashierModelsMapper;
    }
}
