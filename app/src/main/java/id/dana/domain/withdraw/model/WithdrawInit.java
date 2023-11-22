package id.dana.domain.withdraw.model;

import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.List;

/* loaded from: classes8.dex */
public class WithdrawInit extends BaseRpcResponse {
    private boolean needSenderName;
    private List<TransferMethodView> transferMethodView;

    private WithdrawInit() {
    }

    public boolean isNeedSenderName() {
        return this.needSenderName;
    }

    public List<TransferMethodView> getTransferMethodView() {
        return this.transferMethodView;
    }

    /* loaded from: classes8.dex */
    public static class Builder {
        private boolean needSenderName;
        private List<TransferMethodView> transferMethodView;

        public Builder needSenderName(boolean z) {
            this.needSenderName = z;
            return this;
        }

        public Builder withdrawMethodView(List<TransferMethodView> list) {
            this.transferMethodView = list;
            return this;
        }

        public WithdrawInit build() {
            WithdrawInit withdrawInit = new WithdrawInit();
            withdrawInit.needSenderName = this.needSenderName;
            withdrawInit.transferMethodView = this.transferMethodView;
            return withdrawInit;
        }
    }
}
