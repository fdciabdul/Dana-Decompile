package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.withdraw.model.WithdrawSavedCardChannelView;
import id.dana.sendmoney.model.WithdrawSavedCardChannelModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/mapper/WithdrawSavedCardChannelModelMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/withdraw/model/WithdrawSavedCardChannelView;", "Lid/dana/sendmoney/model/WithdrawSavedCardChannelModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawSavedCardChannelModelMapper extends BaseMapper<List<? extends WithdrawSavedCardChannelView>, List<? extends WithdrawSavedCardChannelModel>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends WithdrawSavedCardChannelModel> map(List<? extends WithdrawSavedCardChannelView> list) {
        List<? extends WithdrawSavedCardChannelView> list2 = list;
        if (list2 != null) {
            List<? extends WithdrawSavedCardChannelView> list3 = list2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (Iterator it = list3.iterator(); it.hasNext(); it = it) {
                WithdrawSavedCardChannelView withdrawSavedCardChannelView = (WithdrawSavedCardChannelView) it.next();
                String bindingId = withdrawSavedCardChannelView.getBindingId();
                String cardIndexNo = withdrawSavedCardChannelView.getCardIndexNo();
                int cardNoLength = withdrawSavedCardChannelView.getCardNoLength();
                boolean isDisable = withdrawSavedCardChannelView.isDisable();
                arrayList.add(new WithdrawSavedCardChannelModel(bindingId, cardIndexNo, Integer.valueOf(cardNoLength), Boolean.valueOf(isDisable), withdrawSavedCardChannelView.getFormattedHolderName(), withdrawSavedCardChannelView.getFormattedMaskedCardNo(), withdrawSavedCardChannelView.getInstId(), withdrawSavedCardChannelView.getInstLocalName(), withdrawSavedCardChannelView.getInstName(), withdrawSavedCardChannelView.getPayMethod(), withdrawSavedCardChannelView.getPayOption(), Boolean.valueOf(withdrawSavedCardChannelView.isValidData())));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    @Inject
    public WithdrawSavedCardChannelModelMapper() {
    }
}
