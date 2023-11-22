package id.dana.savings.mapper;

import id.dana.domain.saving.model.MainEmptyState;
import id.dana.savings.model.MainEmptyStateModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/saving/model/MainEmptyState;", "Lid/dana/savings/model/MainEmptyStateModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/saving/model/MainEmptyState;)Lid/dana/savings/model/MainEmptyStateModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainEmptyStateModelMapperKt {
    public static final MainEmptyStateModel MyBillsEntityDataFactory(MainEmptyState mainEmptyState) {
        Intrinsics.checkNotNullParameter(mainEmptyState, "");
        return new MainEmptyStateModel(mainEmptyState.getIcon(), mainEmptyState.getTitle(), mainEmptyState.getSubtitle());
    }
}
