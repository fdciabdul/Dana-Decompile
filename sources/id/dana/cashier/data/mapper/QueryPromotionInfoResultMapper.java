package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.QueryPromotionInfoResult;
import id.dana.cashier.domain.model.QueryPromotionInfo;
import id.dana.cashier.domain.model.VoucherCashierInfo;
import id.dana.data.base.BaseMapper;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/data/mapper/QueryPromotionInfoResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/data/repository/source/network/result/QueryPromotionInfoResult;", "Lid/dana/cashier/domain/model/QueryPromotionInfo;", "oldItem", "map", "(Lid/dana/cashier/data/repository/source/network/result/QueryPromotionInfoResult;)Lid/dana/cashier/domain/model/QueryPromotionInfo;", "toQueryPromotionInfo", "Lid/dana/cashier/data/mapper/VoucherInfoResultsMapper;", "voucherInfoResultsMapper", "Lid/dana/cashier/data/mapper/VoucherInfoResultsMapper;", "<init>", "(Lid/dana/cashier/data/mapper/VoucherInfoResultsMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class QueryPromotionInfoResultMapper extends BaseMapper<QueryPromotionInfoResult, QueryPromotionInfo> {
    private final VoucherInfoResultsMapper voucherInfoResultsMapper;

    @Inject
    public QueryPromotionInfoResultMapper(VoucherInfoResultsMapper voucherInfoResultsMapper) {
        Intrinsics.checkNotNullParameter(voucherInfoResultsMapper, "");
        this.voucherInfoResultsMapper = voucherInfoResultsMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final QueryPromotionInfo map(QueryPromotionInfoResult oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        return toQueryPromotionInfo(oldItem);
    }

    private final QueryPromotionInfo toQueryPromotionInfo(QueryPromotionInfoResult queryPromotionInfoResult) {
        boolean z = queryPromotionInfoResult.success;
        List<? extends VoucherCashierInfo> apply = this.voucherInfoResultsMapper.apply(queryPromotionInfoResult.getVoucherList());
        Intrinsics.checkNotNullExpressionValue(apply, "");
        return new QueryPromotionInfo(Boolean.valueOf(z), apply);
    }
}
