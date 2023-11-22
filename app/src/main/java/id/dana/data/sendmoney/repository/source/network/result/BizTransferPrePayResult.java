package id.dana.data.sendmoney.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.sendmoney.model.CouponChannelInfoResult;
import java.util.List;

/* loaded from: classes4.dex */
public class BizTransferPrePayResult extends BaseRpcResult {
    private List<CouponChannelInfoResult> couponChannelInfos;

    public List<CouponChannelInfoResult> getCouponChannelInfos() {
        return this.couponChannelInfos;
    }

    public void setCouponChannelInfos(List<CouponChannelInfoResult> list) {
        this.couponChannelInfos = list;
    }
}
