package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferOrderCreateResult;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/sendmoney/mapper/BizTransferOrderCreateResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/sendmoney/repository/source/network/result/BizTransferOrderCreateResult;", "Lid/dana/domain/sendmoney/model/SendMoneyConfirm;", "oldItem", "map", "(Lid/dana/data/sendmoney/repository/source/network/result/BizTransferOrderCreateResult;)Lid/dana/domain/sendmoney/model/SendMoneyConfirm;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BizTransferOrderCreateResultMapper extends BaseMapper<BizTransferOrderCreateResult, SendMoneyConfirm> {
    @Inject
    public BizTransferOrderCreateResultMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public final SendMoneyConfirm map(BizTransferOrderCreateResult oldItem) {
        SendMoneyConfirm sendMoneyConfirm = new SendMoneyConfirm();
        sendMoneyConfirm.setGroupOrderId(oldItem != null ? oldItem.getGroupOrderId() : null);
        sendMoneyConfirm.setOrderId(oldItem != null ? oldItem.getOrderId() : null);
        return sendMoneyConfirm;
    }
}
