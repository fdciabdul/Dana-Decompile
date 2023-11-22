package id.dana.data.sendmoney.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.sendmoney.model.QrisTcicoEntryPointInfoEntity;
import id.dana.data.sendmoney.model.TransferMethodInfoResult;
import id.dana.data.sendmoney.model.TransferUserInfoResult;
import java.util.List;

/* loaded from: classes4.dex */
public class BizTransferInitResult extends BaseRpcResult {
    public boolean needSenderName;
    public TransferUserInfoResult payeeUserInfo;
    public TransferUserInfoResult payerUserInfo;
    public QrisTcicoEntryPointInfoEntity qrisTcicoEntryPointInfo;
    public List<TransferMethodInfoResult> transferMethodInfo;

    public int getFreeBankTransferCount(String str) {
        if (this.transferMethodInfo.isEmpty()) {
            return 0;
        }
        TransferMethodInfoResult bankTransferMethod = getBankTransferMethod(str);
        if (bankTransferMethod.isNullObject()) {
            return 0;
        }
        return (int) bankTransferMethod.getFreeRemainingTimes();
    }

    private TransferMethodInfoResult getBankTransferMethod(String str) {
        for (TransferMethodInfoResult transferMethodInfoResult : this.transferMethodInfo) {
            if (str.equals(transferMethodInfoResult.getTransferMethod())) {
                return transferMethodInfoResult;
            }
        }
        return TransferMethodInfoResult.createNullObject();
    }
}
