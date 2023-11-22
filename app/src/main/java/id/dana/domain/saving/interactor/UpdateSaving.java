package id.dana.domain.saving.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.model.SavingCategory;
import id.dana.domain.saving.model.SavingGoalView;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/saving/interactor/UpdateSaving;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/saving/model/SavingGoalView;", "Lid/dana/domain/saving/interactor/UpdateSaving$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/saving/interactor/UpdateSaving$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/saving/SavingCategoryRepository;", "savingCategoryRepository", "Lid/dana/domain/saving/SavingCategoryRepository;", "Lid/dana/domain/saving/SavingRepository;", "savingRepository", "Lid/dana/domain/saving/SavingRepository;", "<init>", "(Lid/dana/domain/saving/SavingRepository;Lid/dana/domain/saving/SavingCategoryRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UpdateSaving extends BaseUseCase<SavingGoalView, Param> {
    private final SavingCategoryRepository savingCategoryRepository;
    private final SavingRepository savingRepository;

    @Inject
    public UpdateSaving(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        Intrinsics.checkNotNullParameter(savingRepository, "");
        Intrinsics.checkNotNullParameter(savingCategoryRepository, "");
        this.savingRepository = savingRepository;
        this.savingCategoryRepository = savingCategoryRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<SavingGoalView> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<SavingGoalView> zip = Observable.zip(this.savingRepository.updateSaving(params.getSavingId(), params.getCategoryCode(), params.getTitle(), params.getTargetAmount()), this.savingCategoryRepository.getSavingCategoriesMap(), new BiFunction() { // from class: id.dana.domain.saving.interactor.UpdateSaving$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                SavingGoalView m2490buildUseCase$lambda1;
                m2490buildUseCase$lambda1 = UpdateSaving.m2490buildUseCase$lambda1((SavingGoalView) obj, (Map) obj2);
                return m2490buildUseCase$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final SavingGoalView m2490buildUseCase$lambda1(SavingGoalView savingGoalView, Map map) {
        Intrinsics.checkNotNullParameter(savingGoalView, "");
        Intrinsics.checkNotNullParameter(map, "");
        SavingCategory savingCategory = (SavingCategory) map.get(savingGoalView.getCategoryCode());
        if (savingCategory == null) {
            savingCategory = (SavingCategory) map.get("OTHERS");
        }
        savingGoalView.setSavingCategory(savingCategory);
        return savingGoalView;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/saving/interactor/UpdateSaving$Param;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "savingId", "categoryCode", "title", "targetAmount", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/saving/interactor/UpdateSaving$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCategoryCode", "getSavingId", "getTargetAmount", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final String categoryCode;
        private final String savingId;
        private final String targetAmount;
        private final String title;

        public static /* synthetic */ Param copy$default(Param param, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.savingId;
            }
            if ((i & 2) != 0) {
                str2 = param.categoryCode;
            }
            if ((i & 4) != 0) {
                str3 = param.title;
            }
            if ((i & 8) != 0) {
                str4 = param.targetAmount;
            }
            return param.copy(str, str2, str3, str4);
        }

        /* renamed from: component1  reason: from getter */
        public final String getSavingId() {
            return this.savingId;
        }

        /* renamed from: component2  reason: from getter */
        public final String getCategoryCode() {
            return this.categoryCode;
        }

        /* renamed from: component3  reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component4  reason: from getter */
        public final String getTargetAmount() {
            return this.targetAmount;
        }

        public final Param copy(String savingId, String categoryCode, String title, String targetAmount) {
            Intrinsics.checkNotNullParameter(savingId, "");
            Intrinsics.checkNotNullParameter(categoryCode, "");
            Intrinsics.checkNotNullParameter(title, "");
            Intrinsics.checkNotNullParameter(targetAmount, "");
            return new Param(savingId, categoryCode, title, targetAmount);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.savingId, param.savingId) && Intrinsics.areEqual(this.categoryCode, param.categoryCode) && Intrinsics.areEqual(this.title, param.title) && Intrinsics.areEqual(this.targetAmount, param.targetAmount);
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.savingId.hashCode() * 31) + this.categoryCode.hashCode()) * 31) + this.title.hashCode()) * 31) + this.targetAmount.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(savingId=");
            sb.append(this.savingId);
            sb.append(", categoryCode=");
            sb.append(this.categoryCode);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", targetAmount=");
            sb.append(this.targetAmount);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            this.savingId = str;
            this.categoryCode = str2;
            this.title = str3;
            this.targetAmount = str4;
        }

        @JvmName(name = "getSavingId")
        public final String getSavingId() {
            return this.savingId;
        }

        @JvmName(name = "getCategoryCode")
        public final String getCategoryCode() {
            return this.categoryCode;
        }

        @JvmName(name = "getTitle")
        public final String getTitle() {
            return this.title;
        }

        @JvmName(name = "getTargetAmount")
        public final String getTargetAmount() {
            return this.targetAmount;
        }
    }
}
