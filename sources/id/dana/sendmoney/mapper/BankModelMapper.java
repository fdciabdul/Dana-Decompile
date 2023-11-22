package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawMethodOptionResult;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.withdraw.model.TransferMethodView;
import id.dana.domain.withdraw.model.WithdrawChannelView;
import id.dana.domain.withdraw.model.WithdrawMethodOption;
import id.dana.sendmoney.model.BankModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class BankModelMapper extends BaseMapper<TransferInit, List<BankModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<BankModel> map(TransferInit transferInit) {
        List emptyList;
        TransferInit transferInit2 = transferInit;
        if (transferInit2 != null) {
            List<TransferMethodView> transferMethod = transferInit2.getTransferMethod();
            if (transferMethod != null && !transferMethod.isEmpty()) {
                emptyList = new ArrayList();
                Iterator<TransferMethodView> it = transferMethod.iterator();
                while (it.hasNext()) {
                    List<WithdrawMethodOption> withdrawMethodOptions = it.next().getWithdrawMethodOptions();
                    if (withdrawMethodOptions != null && !withdrawMethodOptions.isEmpty()) {
                        Iterator<WithdrawMethodOption> it2 = withdrawMethodOptions.iterator();
                        while (it2.hasNext() && PlaceComponentResult(it2.next(), emptyList)) {
                        }
                    }
                }
            } else {
                emptyList = Collections.emptyList();
            }
            Iterator it3 = emptyList.iterator();
            while (it3.hasNext()) {
                List<WithdrawChannelView> withdrawChannelOptions = ((WithdrawMethodOption) it3.next()).getWithdrawChannelOptions();
                if (withdrawChannelOptions != null && !withdrawChannelOptions.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (WithdrawChannelView withdrawChannelView : withdrawChannelOptions) {
                        BankModel.Builder builder = new BankModel.Builder();
                        builder.MyBillsEntityDataFactory = withdrawChannelView.isEnableStatus();
                        String instId = withdrawChannelView.getInstId();
                        String str = "";
                        if (instId == null) {
                            instId = "";
                        }
                        builder.KClassImpl$Data$declaredNonStaticMembers$2 = instId;
                        String instLocalName = withdrawChannelView.getInstLocalName();
                        if (instLocalName == null) {
                            instLocalName = "";
                        }
                        builder.getErrorConfigVersion = instLocalName;
                        String instName = withdrawChannelView.getInstName();
                        if (instName == null) {
                            instName = "";
                        }
                        builder.moveToNextValue = instName;
                        String payMethod = withdrawChannelView.getPayMethod();
                        if (payMethod == null) {
                            payMethod = "";
                        }
                        builder.initRecordTimeStamp = payMethod;
                        String payOption = withdrawChannelView.getPayOption();
                        if (payOption != null) {
                            str = payOption;
                        }
                        builder.DatabaseTableConfigUtil = str;
                        arrayList.add(builder.BuiltInFictitiousFunctionClassFactory());
                    }
                    return arrayList;
                }
            }
        }
        return Collections.emptyList();
    }

    @Inject
    public BankModelMapper() {
    }

    private static boolean PlaceComponentResult(WithdrawMethodOption withdrawMethodOption, List<WithdrawMethodOption> list) {
        if (WithdrawMethodOptionResult.WithdrawMethod.WITHDRAW_BANKCARD.equals(withdrawMethodOption.getWithdrawMethod())) {
            return list.add(withdrawMethodOption);
        }
        return false;
    }
}
