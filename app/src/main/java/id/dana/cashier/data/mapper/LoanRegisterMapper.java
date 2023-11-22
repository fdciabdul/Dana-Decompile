package id.dana.cashier.data.mapper;

import id.dana.cashier.domain.model.paylater.LoanRegisterResultInfo;
import id.dana.data.model.cashier.PayMethodRiskResult;
import id.dana.data.paylater.repository.source.network.result.LoanRegisterResult;
import id.dana.data.sendmoney.mapper.PayMethodRiskResultMapper;
import id.dana.domain.model.cashier.PayMethodRisk;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0006*\u00020\b0\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/data/mapper/LoanRegisterMapper;", "", "Lid/dana/data/paylater/repository/source/network/result/LoanRegisterResult;", "oldItem", "Lid/dana/cashier/domain/model/paylater/LoanRegisterResultInfo;", "toLoanRegisterResultInfo", "(Lid/dana/data/paylater/repository/source/network/result/LoanRegisterResult;)Lid/dana/cashier/domain/model/paylater/LoanRegisterResultInfo;", "Lid/dana/data/model/cashier/PayMethodRiskResult;", "Lid/dana/domain/model/cashier/PayMethodRisk;", "toPayMethodRisk", "(Lid/dana/data/model/cashier/PayMethodRiskResult;)Lid/dana/domain/model/cashier/PayMethodRisk;", "Lid/dana/data/sendmoney/mapper/PayMethodRiskResultMapper;", "payMethodRiskResultMapper", "Lid/dana/data/sendmoney/mapper/PayMethodRiskResultMapper;", "<init>", "(Lid/dana/data/sendmoney/mapper/PayMethodRiskResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LoanRegisterMapper {
    private final PayMethodRiskResultMapper payMethodRiskResultMapper;

    @Inject
    public LoanRegisterMapper(PayMethodRiskResultMapper payMethodRiskResultMapper) {
        Intrinsics.checkNotNullParameter(payMethodRiskResultMapper, "");
        this.payMethodRiskResultMapper = payMethodRiskResultMapper;
    }

    public final LoanRegisterResultInfo toLoanRegisterResultInfo(LoanRegisterResult oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        String assetType = oldItem.getAssetType();
        String str = assetType == null ? "" : assetType;
        String serviceInstId = oldItem.getServiceInstId();
        String str2 = serviceInstId == null ? "" : serviceInstId;
        String securityId = oldItem.getSecurityId();
        String str3 = securityId == null ? "" : securityId;
        PayMethodRiskResult riskResult = oldItem.getRiskResult();
        PayMethodRisk payMethodRisk = riskResult != null ? toPayMethodRisk(riskResult) : null;
        if (payMethodRisk == null) {
            payMethodRisk = new PayMethodRisk();
        }
        PayMethodRisk payMethodRisk2 = payMethodRisk;
        String orderId = oldItem.getOrderId();
        String str4 = orderId == null ? "" : orderId;
        String assetStatus = oldItem.getAssetStatus();
        String str5 = assetStatus == null ? "" : assetStatus;
        String pubKey = oldItem.getPubKey();
        String str6 = pubKey == null ? "" : pubKey;
        Integer identFailedCount = oldItem.getIdentFailedCount();
        int intValue = identFailedCount != null ? identFailedCount.intValue() : 0;
        Integer maxFailedLimit = oldItem.getMaxFailedLimit();
        int intValue2 = maxFailedLimit != null ? maxFailedLimit.intValue() : 0;
        Integer lockedExpireMins = oldItem.getLockedExpireMins();
        return new LoanRegisterResultInfo(str, str2, null, str3, payMethodRisk2, str4, str5, str6, intValue, intValue2, lockedExpireMins != null ? lockedExpireMins.intValue() : 0, 4, null);
    }

    private final PayMethodRisk toPayMethodRisk(PayMethodRiskResult payMethodRiskResult) {
        return this.payMethodRiskResultMapper.apply(payMethodRiskResult);
    }
}
