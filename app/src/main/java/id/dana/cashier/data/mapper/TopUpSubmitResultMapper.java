package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.TopUpPayEntityResult;
import id.dana.cashier.domain.model.TopUpPay;
import id.dana.data.base.BaseMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/cashier/data/mapper/TopUpSubmitResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/data/repository/source/network/result/TopUpPayEntityResult;", "Lid/dana/cashier/domain/model/TopUpPay;", "oldItem", "map", "(Lid/dana/cashier/data/repository/source/network/result/TopUpPayEntityResult;)Lid/dana/cashier/domain/model/TopUpPay;", "Lid/dana/cashier/data/mapper/AttributesResultMapper;", "attributesResultMapper", "Lid/dana/cashier/data/mapper/AttributesResultMapper;", "<init>", "(Lid/dana/cashier/data/mapper/AttributesResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TopUpSubmitResultMapper extends BaseMapper<TopUpPayEntityResult, TopUpPay> {
    private final AttributesResultMapper attributesResultMapper;

    @Inject
    public TopUpSubmitResultMapper(AttributesResultMapper attributesResultMapper) {
        Intrinsics.checkNotNullParameter(attributesResultMapper, "");
        this.attributesResultMapper = attributesResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final TopUpPay map(TopUpPayEntityResult oldItem) {
        if (oldItem != null) {
            return new TopUpPay(this.attributesResultMapper.apply(oldItem.getAttributes()), oldItem.getCashierOrderId(), null, null, null, null, null, null, Boolean.valueOf(oldItem.success), 252, null);
        }
        return null;
    }
}
