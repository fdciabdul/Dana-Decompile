package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.withdraw.model.WithdrawChannelView;
import id.dana.sendmoney.model.WithdrawChannelModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/mapper/WithdrawChannelModelMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/withdraw/model/WithdrawChannelView;", "Lid/dana/sendmoney/model/WithdrawChannelModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawChannelModelMapper extends BaseMapper<List<? extends WithdrawChannelView>, List<? extends WithdrawChannelModel>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends WithdrawChannelModel> map(List<? extends WithdrawChannelView> list) {
        List<? extends WithdrawChannelView> list2 = list;
        if (list2 != null) {
            List<? extends WithdrawChannelView> list3 = list2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (WithdrawChannelView withdrawChannelView : list3) {
                String channelIndex = withdrawChannelView.getChannelIndex();
                boolean isEnableStatus = withdrawChannelView.isEnableStatus();
                arrayList.add(new WithdrawChannelModel(channelIndex, Boolean.valueOf(isEnableStatus), withdrawChannelView.getInstId(), withdrawChannelView.getInstLocalName(), withdrawChannelView.getInstName(), withdrawChannelView.getPayMethod(), withdrawChannelView.getPayOption()));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    @Inject
    public WithdrawChannelModelMapper() {
    }
}
