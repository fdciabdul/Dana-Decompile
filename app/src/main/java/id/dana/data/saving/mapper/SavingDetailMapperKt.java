package id.dana.data.saving.mapper;

import id.dana.data.saving.model.SavingViewKt;
import id.dana.data.saving.model.TopUpViewEntity;
import id.dana.data.saving.repository.source.network.response.SavingDetailResult;
import id.dana.domain.saving.model.SavingDetail;
import id.dana.domain.saving.model.SavingGoalView;
import id.dana.domain.saving.model.TopUpView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;", "Lid/dana/domain/saving/model/SavingDetail;", "toSavingDetail", "(Lid/dana/data/saving/repository/source/network/response/SavingDetailResult;)Lid/dana/domain/saving/model/SavingDetail;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavingDetailMapperKt {
    public static final SavingDetail toSavingDetail(SavingDetailResult savingDetailResult) {
        Intrinsics.checkNotNullParameter(savingDetailResult, "");
        SavingGoalView savingGoalView = SavingViewKt.toSavingGoalView(savingDetailResult.getSavingView());
        List<TopUpViewEntity> topUpViews = savingDetailResult.getTopUpViews();
        List<TopUpView> topUpViews2 = topUpViews != null ? TopUpViewMapperKt.toTopUpViews(topUpViews) : null;
        if (topUpViews2 == null) {
            topUpViews2 = CollectionsKt.emptyList();
        }
        return new SavingDetail(savingGoalView, topUpViews2, savingDetailResult.getHasNext());
    }
}
