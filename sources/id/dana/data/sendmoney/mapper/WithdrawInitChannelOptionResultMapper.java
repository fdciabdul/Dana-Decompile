package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.WithdrawInitChannelOptionViewResult;
import id.dana.domain.sendmoney.model.WithdrawInitChannelOption;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/sendmoney/mapper/WithdrawInitChannelOptionResultMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/data/sendmoney/model/WithdrawInitChannelOptionViewResult;", "Lid/dana/domain/sendmoney/model/WithdrawInitChannelOption;", "oldItem", "map", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class WithdrawInitChannelOptionResultMapper extends BaseMapper<List<? extends WithdrawInitChannelOptionViewResult>, List<? extends WithdrawInitChannelOption>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* bridge */ /* synthetic */ List<? extends WithdrawInitChannelOption> map(List<? extends WithdrawInitChannelOptionViewResult> list) {
        return map2((List<WithdrawInitChannelOptionViewResult>) list);
    }

    @Inject
    public WithdrawInitChannelOptionResultMapper() {
    }

    /* renamed from: map  reason: avoid collision after fix types in other method */
    protected final List<WithdrawInitChannelOption> map2(List<WithdrawInitChannelOptionViewResult> oldItem) {
        ArrayList arrayList = new ArrayList();
        if (oldItem != null) {
            for (WithdrawInitChannelOptionViewResult withdrawInitChannelOptionViewResult : oldItem) {
                arrayList.add(new WithdrawInitChannelOption(withdrawInitChannelOptionViewResult.getCardNoLength(), withdrawInitChannelOptionViewResult.getChannelIndex(), withdrawInitChannelOptionViewResult.getDisable(), withdrawInitChannelOptionViewResult.getInstId(), withdrawInitChannelOptionViewResult.getInstLocalName(), withdrawInitChannelOptionViewResult.getInstName(), withdrawInitChannelOptionViewResult.getPayMethod(), withdrawInitChannelOptionViewResult.getPayOption(), withdrawInitChannelOptionViewResult.getSelected(), withdrawInitChannelOptionViewResult.getValidData(), withdrawInitChannelOptionViewResult.getDisableReason(), withdrawInitChannelOptionViewResult.getErrorCode(), withdrawInitChannelOptionViewResult.getErrorMsg()));
            }
        }
        return arrayList;
    }
}
