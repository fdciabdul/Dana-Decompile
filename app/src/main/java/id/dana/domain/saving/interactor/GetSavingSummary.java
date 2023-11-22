package id.dana.domain.saving.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.model.SavingCategory;
import id.dana.domain.saving.model.SavingGoalView;
import id.dana.domain.saving.model.SavingLimit;
import id.dana.domain.saving.model.SavingSummary;
import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/saving/interactor/GetSavingSummary;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/saving/model/SavingSummary;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/saving/SavingCategoryRepository;", "savingCategoryRepository", "Lid/dana/domain/saving/SavingCategoryRepository;", "Lid/dana/domain/saving/SavingRepository;", "savingRepository", "Lid/dana/domain/saving/SavingRepository;", "<init>", "(Lid/dana/domain/saving/SavingRepository;Lid/dana/domain/saving/SavingCategoryRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetSavingSummary extends BaseUseCase<SavingSummary, NoParams> {
    private final SavingCategoryRepository savingCategoryRepository;
    private final SavingRepository savingRepository;

    @Inject
    public GetSavingSummary(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        Intrinsics.checkNotNullParameter(savingRepository, "");
        Intrinsics.checkNotNullParameter(savingCategoryRepository, "");
        this.savingRepository = savingRepository;
        this.savingCategoryRepository = savingCategoryRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<SavingSummary> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<SavingSummary> zip = Observable.zip(this.savingRepository.getSavingSummary(), this.savingRepository.getSavingLimit(), this.savingCategoryRepository.getSavingCategoriesMap(), new Function3() { // from class: id.dana.domain.saving.interactor.GetSavingSummary$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                SavingSummary m2482buildUseCase$lambda2;
                m2482buildUseCase$lambda2 = GetSavingSummary.m2482buildUseCase$lambda2((SavingSummary) obj, (SavingLimit) obj2, (Map) obj3);
                return m2482buildUseCase$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final SavingSummary m2482buildUseCase$lambda2(SavingSummary savingSummary, SavingLimit savingLimit, Map map) {
        Intrinsics.checkNotNullParameter(savingSummary, "");
        Intrinsics.checkNotNullParameter(savingLimit, "");
        Intrinsics.checkNotNullParameter(map, "");
        savingSummary.setMaxSavingCountNonKyc(savingLimit.getMaxSavingCountNonKyc());
        savingSummary.setMaxSavingAmountNonKyc(savingLimit.getMaxSavingAmountNonKyc());
        savingSummary.setMaxSavingAmountKyc(savingLimit.getMaxSavingAmountKyc());
        for (SavingGoalView savingGoalView : savingSummary.getSavingGoalViews()) {
            SavingCategory savingCategory = (SavingCategory) map.get(savingGoalView.getCategoryCode());
            if (savingCategory == null) {
                savingCategory = (SavingCategory) map.get("OTHERS");
            }
            savingGoalView.setSavingCategory(savingCategory);
        }
        return savingSummary;
    }
}
