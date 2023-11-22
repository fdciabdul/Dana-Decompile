package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.withdraw.model.TransferMethodView;
import id.dana.domain.withdraw.model.WithdrawChannelView;
import id.dana.domain.withdraw.model.WithdrawMethodOption;
import id.dana.sendmoney.model.WithdrawOTCModel;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class WithdrawOTCMapper extends BaseMapper<TransferInit, WithdrawOTCModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ WithdrawOTCModel map(TransferInit transferInit) {
        TransferInit transferInit2 = transferInit;
        if (transferInit2 != null) {
            for (TransferMethodView transferMethodView : transferInit2.getTransferMethod()) {
                if ("OTC".equals(transferMethodView.getTransferMethod())) {
                    List<WithdrawMethodOption> withdrawMethodOptions = transferMethodView.getWithdrawMethodOptions();
                    if (MyBillsEntityDataFactory(withdrawMethodOptions)) {
                        WithdrawChannelView withdrawChannelView = withdrawMethodOptions.get(0).getWithdrawChannelOptions().get(0);
                        WithdrawOTCModel withdrawOTCModel = new WithdrawOTCModel();
                        if (withdrawChannelView != null) {
                            withdrawOTCModel.MyBillsEntityDataFactory = withdrawChannelView.getInstId();
                            withdrawOTCModel.lookAheadTest = withdrawChannelView.getInstName();
                            withdrawOTCModel.PlaceComponentResult = withdrawChannelView.getInstLocalName();
                            withdrawOTCModel.getErrorConfigVersion = withdrawChannelView.getPayMethod();
                            withdrawOTCModel.scheduleImpl = withdrawChannelView.getPayOption();
                        }
                        return withdrawOTCModel;
                    }
                }
            }
            return null;
        }
        return null;
    }

    @Inject
    public WithdrawOTCMapper() {
    }

    private static boolean MyBillsEntityDataFactory(List<WithdrawMethodOption> list) {
        return (list == null || list.get(0).getWithdrawChannelOptions() == null) ? false : true;
    }
}
