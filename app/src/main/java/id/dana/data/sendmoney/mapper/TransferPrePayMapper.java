package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferPrePayResult;
import id.dana.domain.sendmoney.model.TransferPrepay;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class TransferPrePayMapper extends BaseMapper<BizTransferPrePayResult, TransferPrepay> {
    private final CouponChannelInfoResultMapper couponChannelInfoResultMapper;

    @Inject
    public TransferPrePayMapper(CouponChannelInfoResultMapper couponChannelInfoResultMapper) {
        this.couponChannelInfoResultMapper = couponChannelInfoResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public TransferPrepay map(BizTransferPrePayResult bizTransferPrePayResult) {
        if (bizTransferPrePayResult != null) {
            TransferPrepay transferPrepay = new TransferPrepay();
            transferPrepay.setCouponChannelInfo(this.couponChannelInfoResultMapper.map(bizTransferPrePayResult.getCouponChannelInfos()));
            return transferPrepay;
        }
        return null;
    }
}
