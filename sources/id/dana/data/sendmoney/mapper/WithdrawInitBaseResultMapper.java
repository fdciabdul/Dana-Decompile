package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.BaseWithdrawInit;
import id.dana.domain.sendmoney.model.WithdrawInitBase;
import id.dana.domain.sendmoney.model.WithdrawInitMethodOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/sendmoney/mapper/WithdrawInitBaseResultMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/data/sendmoney/model/BaseWithdrawInit;", "Lid/dana/domain/sendmoney/model/WithdrawInitBase;", "oldItem", "map", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/sendmoney/mapper/WithdrawInitMethodOptionResultMapper;", "withdrawInitMethodOptionResultMapper", "Lid/dana/data/sendmoney/mapper/WithdrawInitMethodOptionResultMapper;", "<init>", "(Lid/dana/data/sendmoney/mapper/WithdrawInitMethodOptionResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WithdrawInitBaseResultMapper extends BaseMapper<List<? extends BaseWithdrawInit>, List<? extends WithdrawInitBase>> {
    private final WithdrawInitMethodOptionResultMapper withdrawInitMethodOptionResultMapper;

    @Override // id.dana.data.base.BaseMapper
    public final /* bridge */ /* synthetic */ List<? extends WithdrawInitBase> map(List<? extends BaseWithdrawInit> list) {
        return map2((List<BaseWithdrawInit>) list);
    }

    @Inject
    public WithdrawInitBaseResultMapper(WithdrawInitMethodOptionResultMapper withdrawInitMethodOptionResultMapper) {
        Intrinsics.checkNotNullParameter(withdrawInitMethodOptionResultMapper, "");
        this.withdrawInitMethodOptionResultMapper = withdrawInitMethodOptionResultMapper;
    }

    /* renamed from: map  reason: avoid collision after fix types in other method */
    protected final List<WithdrawInitBase> map2(List<BaseWithdrawInit> oldItem) {
        ArrayList arrayList;
        if (oldItem != null) {
            List<BaseWithdrawInit> list = oldItem;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                List<? extends WithdrawInitMethodOption> apply = this.withdrawInitMethodOptionResultMapper.apply(((BaseWithdrawInit) it.next()).getWithdrawMethodViews());
                Intrinsics.checkNotNullExpressionValue(apply, "");
                arrayList2.add(new WithdrawInitBase(apply));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}
