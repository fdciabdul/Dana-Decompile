package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.withdraw.model.WithdrawMethodOption;
import id.dana.sendmoney.model.WithdrawChannelModel;
import id.dana.sendmoney.model.WithdrawMethodOptionModel;
import id.dana.sendmoney.model.WithdrawSavedCardChannelModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/mapper/WithdrawMethodOptionModelMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/withdraw/model/WithdrawMethodOption;", "Lid/dana/sendmoney/model/WithdrawMethodOptionModel;", "Lid/dana/sendmoney/mapper/WithdrawChannelModelMapper;", "PlaceComponentResult", "Lid/dana/sendmoney/mapper/WithdrawChannelModelMapper;", "Lid/dana/sendmoney/mapper/WithdrawSavedCardChannelModelMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/mapper/WithdrawSavedCardChannelModelMapper;", "p0", "p1", "<init>", "(Lid/dana/sendmoney/mapper/WithdrawSavedCardChannelModelMapper;Lid/dana/sendmoney/mapper/WithdrawChannelModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WithdrawMethodOptionModelMapper extends BaseMapper<List<? extends WithdrawMethodOption>, List<? extends WithdrawMethodOptionModel>> {
    private final WithdrawSavedCardChannelModelMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final WithdrawChannelModelMapper PlaceComponentResult;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends WithdrawMethodOptionModel> map(List<? extends WithdrawMethodOption> list) {
        ArrayList arrayList;
        List<? extends WithdrawMethodOption> list2 = list;
        if (list2 != null) {
            List<? extends WithdrawMethodOption> list3 = list2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (WithdrawMethodOption withdrawMethodOption : list3) {
                List<? extends WithdrawSavedCardChannelModel> apply = this.KClassImpl$Data$declaredNonStaticMembers$2.apply(withdrawMethodOption.getWithdrawCardOptions());
                Intrinsics.checkNotNullExpressionValue(apply, "");
                List<? extends WithdrawChannelModel> apply2 = this.PlaceComponentResult.apply(withdrawMethodOption.getWithdrawChannelOptions());
                Intrinsics.checkNotNullExpressionValue(apply2, "");
                String withdrawMethod = withdrawMethodOption.getWithdrawMethod();
                Intrinsics.checkNotNullExpressionValue(withdrawMethod, "");
                arrayList2.add(new WithdrawMethodOptionModel(apply, apply2, withdrawMethod));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    @Inject
    public WithdrawMethodOptionModelMapper(WithdrawSavedCardChannelModelMapper withdrawSavedCardChannelModelMapper, WithdrawChannelModelMapper withdrawChannelModelMapper) {
        Intrinsics.checkNotNullParameter(withdrawSavedCardChannelModelMapper, "");
        Intrinsics.checkNotNullParameter(withdrawChannelModelMapper, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = withdrawSavedCardChannelModelMapper;
        this.PlaceComponentResult = withdrawChannelModelMapper;
    }
}
