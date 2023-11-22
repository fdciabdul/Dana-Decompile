package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.WithdrawInitMethodViewResult;
import id.dana.domain.sendmoney.model.WithdrawInitMethodOption;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/sendmoney/mapper/WithdrawInitMethodOptionResultMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/data/sendmoney/model/WithdrawInitMethodViewResult;", "Lid/dana/domain/sendmoney/model/WithdrawInitMethodOption;", "oldItem", "map", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/sendmoney/mapper/WithdrawInitChannelOptionResultMapper;", "withdrawInitChannelOptionResultMapper", "Lid/dana/data/sendmoney/mapper/WithdrawInitChannelOptionResultMapper;", "Lid/dana/data/sendmoney/mapper/WithdrawSavedCardChannelViewResultMapper;", "withdrawSavedCardChannelViewResultMapper", "Lid/dana/data/sendmoney/mapper/WithdrawSavedCardChannelViewResultMapper;", "<init>", "(Lid/dana/data/sendmoney/mapper/WithdrawSavedCardChannelViewResultMapper;Lid/dana/data/sendmoney/mapper/WithdrawInitChannelOptionResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WithdrawInitMethodOptionResultMapper extends BaseMapper<List<? extends WithdrawInitMethodViewResult>, List<? extends WithdrawInitMethodOption>> {
    private final WithdrawInitChannelOptionResultMapper withdrawInitChannelOptionResultMapper;
    private final WithdrawSavedCardChannelViewResultMapper withdrawSavedCardChannelViewResultMapper;

    @Override // id.dana.data.base.BaseMapper
    public final /* bridge */ /* synthetic */ List<? extends WithdrawInitMethodOption> map(List<? extends WithdrawInitMethodViewResult> list) {
        return map2((List<WithdrawInitMethodViewResult>) list);
    }

    @Inject
    public WithdrawInitMethodOptionResultMapper(WithdrawSavedCardChannelViewResultMapper withdrawSavedCardChannelViewResultMapper, WithdrawInitChannelOptionResultMapper withdrawInitChannelOptionResultMapper) {
        Intrinsics.checkNotNullParameter(withdrawSavedCardChannelViewResultMapper, "");
        Intrinsics.checkNotNullParameter(withdrawInitChannelOptionResultMapper, "");
        this.withdrawSavedCardChannelViewResultMapper = withdrawSavedCardChannelViewResultMapper;
        this.withdrawInitChannelOptionResultMapper = withdrawInitChannelOptionResultMapper;
    }

    /* renamed from: map  reason: avoid collision after fix types in other method */
    protected final List<WithdrawInitMethodOption> map2(List<WithdrawInitMethodViewResult> oldItem) {
        ArrayList arrayList;
        if (oldItem != null) {
            List<WithdrawInitMethodViewResult> list = oldItem;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (WithdrawInitMethodViewResult withdrawInitMethodViewResult : list) {
                arrayList2.add(new WithdrawInitMethodOption(this.withdrawSavedCardChannelViewResultMapper.apply(withdrawInitMethodViewResult.getWithdrawCardOptions()), this.withdrawInitChannelOptionResultMapper.apply(withdrawInitMethodViewResult.getWithdrawChannelOptions()), withdrawInitMethodViewResult.getWithdrawMethod()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}
