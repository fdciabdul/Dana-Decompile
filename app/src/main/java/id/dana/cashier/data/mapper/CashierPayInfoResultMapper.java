package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.CashierPayInfoResult;
import id.dana.cashier.data.repository.source.network.result.ConfigCashierResult;
import id.dana.cashier.data.repository.source.network.result.ConfigCashierResultKt;
import id.dana.cashier.domain.model.Attribute;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.data.base.BaseMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/cashier/data/mapper/CashierPayInfoResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/data/repository/source/network/result/CashierPayInfoResult;", "Lid/dana/cashier/domain/model/CashierPay;", "oldItem", "map", "(Lid/dana/cashier/data/repository/source/network/result/CashierPayInfoResult;)Lid/dana/cashier/domain/model/CashierPay;", "Lid/dana/cashier/data/mapper/AttributesResultMapper;", "attributesResultMapper", "Lid/dana/cashier/data/mapper/AttributesResultMapper;", "<init>", "(Lid/dana/cashier/data/mapper/AttributesResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CashierPayInfoResultMapper extends BaseMapper<CashierPayInfoResult, CashierPay> {
    private final AttributesResultMapper attributesResultMapper;

    @Inject
    public CashierPayInfoResultMapper(AttributesResultMapper attributesResultMapper) {
        Intrinsics.checkNotNullParameter(attributesResultMapper, "");
        this.attributesResultMapper = attributesResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final CashierPay map(CashierPayInfoResult oldItem) {
        if (oldItem != null) {
            Attribute apply = this.attributesResultMapper.apply(oldItem.getAttributes());
            String cashierOrderId = oldItem.getCashierOrderId();
            boolean z = oldItem.success;
            String errorMsg = oldItem.getErrorMsg();
            String str = oldItem.errorCode;
            ConfigCashierResult config = oldItem.getConfig();
            return new CashierPay(apply, cashierOrderId, Boolean.valueOf(z), errorMsg, str, config != null ? ConfigCashierResultKt.toConfigCashierInfo(config) : null, null, null, 192, null);
        }
        return null;
    }
}
