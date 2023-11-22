package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.WithdrawInitChannelOption;
import id.dana.sendmoney.model.WithdrawInitChannelOptionModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/mapper/WithdrawInitChannelOptionModelMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/sendmoney/model/WithdrawInitChannelOption;", "Lid/dana/sendmoney/model/WithdrawInitChannelOptionModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawInitChannelOptionModelMapper extends BaseMapper<List<? extends WithdrawInitChannelOption>, List<? extends WithdrawInitChannelOptionModel>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends WithdrawInitChannelOptionModel> map(List<? extends WithdrawInitChannelOption> list) {
        ArrayList arrayList;
        List<? extends WithdrawInitChannelOption> list2 = list;
        if (list2 != null) {
            List<? extends WithdrawInitChannelOption> list3 = list2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (WithdrawInitChannelOption withdrawInitChannelOption : list3) {
                arrayList2.add(new WithdrawInitChannelOptionModel(withdrawInitChannelOption.getCardNoLength(), withdrawInitChannelOption.getChannelIndex(), withdrawInitChannelOption.getDisable(), withdrawInitChannelOption.getInstId(), withdrawInitChannelOption.getInstLocalName(), withdrawInitChannelOption.getInstName(), withdrawInitChannelOption.getPayMethod(), withdrawInitChannelOption.getPayOption(), withdrawInitChannelOption.getSelected(), withdrawInitChannelOption.getValidData(), withdrawInitChannelOption.getDisableReason(), withdrawInitChannelOption.getErrorCode(), withdrawInitChannelOption.getErrorMsg()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    @Inject
    public WithdrawInitChannelOptionModelMapper() {
    }
}
