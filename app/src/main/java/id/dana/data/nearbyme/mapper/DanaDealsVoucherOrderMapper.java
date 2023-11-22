package id.dana.data.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.constant.UrlParam;
import id.dana.data.nearbyme.repository.source.network.request.ProductOrderRequest;
import id.dana.data.nearbyme.util.SystemUtils;
import id.dana.domain.nearbyme.model.DanaDealsOrderRequest;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/nearbyme/mapper/DanaDealsVoucherOrderMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;", "Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;", "", UrlParam.REQUEST_ID, "generateUniqueRequestId", "(Ljava/lang/String;)Ljava/lang/String;", "oldItem", "map", "(Lid/dana/domain/nearbyme/model/DanaDealsOrderRequest;)Lid/dana/data/nearbyme/repository/source/network/request/ProductOrderRequest;", "Lid/dana/data/nearbyme/util/SystemUtils;", "systemUtils", "Lid/dana/data/nearbyme/util/SystemUtils;", "<init>", "(Lid/dana/data/nearbyme/util/SystemUtils;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaDealsVoucherOrderMapper extends BaseMapper<DanaDealsOrderRequest, ProductOrderRequest> {
    private final SystemUtils systemUtils;

    @Inject
    public DanaDealsVoucherOrderMapper(SystemUtils systemUtils) {
        Intrinsics.checkNotNullParameter(systemUtils, "");
        this.systemUtils = systemUtils;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final ProductOrderRequest map(DanaDealsOrderRequest oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        return new ProductOrderRequest(oldItem.getProductCode(), oldItem.getGoodsId(), oldItem.getAggregatorGoodsId(), generateUniqueRequestId(oldItem.getRequestId()), "", oldItem.getSecondaryBizParam(), new MoneyViewEntity(oldItem.getPrice().getAmount(), oldItem.getPrice().getCurrency(), oldItem.getPrice().getCurrencyCode()), oldItem.getBizType());
    }

    private final String generateUniqueRequestId(String requestId) {
        StringBuilder sb = new StringBuilder();
        sb.append(requestId);
        sb.append(this.systemUtils.currentTimeMillis());
        sb.append(this.systemUtils.nextInt());
        return sb.toString();
    }
}
