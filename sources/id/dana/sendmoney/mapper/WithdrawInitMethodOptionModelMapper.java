package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.WithdrawInitMethodOption;
import id.dana.sendmoney.model.WithdrawInitMethodOptionModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/mapper/WithdrawInitMethodOptionModelMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/sendmoney/model/WithdrawInitMethodOption;", "Lid/dana/sendmoney/model/WithdrawInitMethodOptionModel;", "Lid/dana/sendmoney/mapper/WithdrawInitChannelOptionModelMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/mapper/WithdrawInitChannelOptionModelMapper;", "Lid/dana/sendmoney/mapper/WithdrawSavedCardChannelModelMapper;", "getAuthRequestContext", "Lid/dana/sendmoney/mapper/WithdrawSavedCardChannelModelMapper;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/sendmoney/mapper/WithdrawSavedCardChannelModelMapper;Lid/dana/sendmoney/mapper/WithdrawInitChannelOptionModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawInitMethodOptionModelMapper extends BaseMapper<List<? extends WithdrawInitMethodOption>, List<? extends WithdrawInitMethodOptionModel>> {
    private final WithdrawInitChannelOptionModelMapper KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final WithdrawSavedCardChannelModelMapper MyBillsEntityDataFactory;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends WithdrawInitMethodOptionModel> map(List<? extends WithdrawInitMethodOption> list) {
        ArrayList arrayList;
        List<? extends WithdrawInitMethodOption> list2 = list;
        if (list2 != null) {
            List<? extends WithdrawInitMethodOption> list3 = list2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (WithdrawInitMethodOption withdrawInitMethodOption : list3) {
                arrayList2.add(new WithdrawInitMethodOptionModel(this.MyBillsEntityDataFactory.apply(withdrawInitMethodOption.getWithdrawCardOptions()), this.KClassImpl$Data$declaredNonStaticMembers$2.apply(withdrawInitMethodOption.getWithdrawChannelOptions()), withdrawInitMethodOption.getWithdrawMethod()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    @Inject
    public WithdrawInitMethodOptionModelMapper(WithdrawSavedCardChannelModelMapper withdrawSavedCardChannelModelMapper, WithdrawInitChannelOptionModelMapper withdrawInitChannelOptionModelMapper) {
        Intrinsics.checkNotNullParameter(withdrawSavedCardChannelModelMapper, "");
        Intrinsics.checkNotNullParameter(withdrawInitChannelOptionModelMapper, "");
        this.MyBillsEntityDataFactory = withdrawSavedCardChannelModelMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = withdrawInitChannelOptionModelMapper;
    }
}
