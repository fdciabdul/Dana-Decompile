package id.dana.domain.saving.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.model.SavingCategory;
import id.dana.domain.saving.model.SavingDetail;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/saving/interactor/GetSavingDetail;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/saving/model/SavingDetail;", "Lid/dana/domain/saving/interactor/GetSavingDetail$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/saving/interactor/GetSavingDetail$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/saving/SavingCategoryRepository;", "savingCategoryRepository", "Lid/dana/domain/saving/SavingCategoryRepository;", "Lid/dana/domain/saving/SavingRepository;", "savingRepository", "Lid/dana/domain/saving/SavingRepository;", "<init>", "(Lid/dana/domain/saving/SavingRepository;Lid/dana/domain/saving/SavingCategoryRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetSavingDetail extends BaseUseCase<SavingDetail, Param> {
    private final SavingCategoryRepository savingCategoryRepository;
    private final SavingRepository savingRepository;

    @Inject
    public GetSavingDetail(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        Intrinsics.checkNotNullParameter(savingRepository, "");
        Intrinsics.checkNotNullParameter(savingCategoryRepository, "");
        this.savingRepository = savingRepository;
        this.savingCategoryRepository = savingCategoryRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<SavingDetail> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.savingRepository.getSavingDetail(params.getSavingId(), params.getTopUpViewsPage(), params.getTopUpViewsSize()).flatMap(new Function() { // from class: id.dana.domain.saving.interactor.GetSavingDetail$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2480buildUseCase$lambda2;
                m2480buildUseCase$lambda2 = GetSavingDetail.m2480buildUseCase$lambda2(GetSavingDetail.this, (SavingDetail) obj);
                return m2480buildUseCase$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final ObservableSource m2480buildUseCase$lambda2(GetSavingDetail getSavingDetail, final SavingDetail savingDetail) {
        Intrinsics.checkNotNullParameter(getSavingDetail, "");
        Intrinsics.checkNotNullParameter(savingDetail, "");
        return getSavingDetail.savingCategoryRepository.getSavingCategoriesByKeys(new String[]{savingDetail.getSavingGoalView().getCategoryCode(), "OTHERS"}).flatMap(new Function() { // from class: id.dana.domain.saving.interactor.GetSavingDetail$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2481buildUseCase$lambda2$lambda1;
                m2481buildUseCase$lambda2$lambda1 = GetSavingDetail.m2481buildUseCase$lambda2$lambda1(SavingDetail.this, (List) obj);
                return m2481buildUseCase$lambda2$lambda1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2$lambda-1  reason: not valid java name */
    public static final ObservableSource m2481buildUseCase$lambda2$lambda1(SavingDetail savingDetail, List list) {
        Intrinsics.checkNotNullParameter(savingDetail, "");
        Intrinsics.checkNotNullParameter(list, "");
        savingDetail.getSavingGoalView().setSavingCategory((SavingCategory) list.get(0));
        return Observable.just(savingDetail);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0007"}, d2 = {"Lid/dana/domain/saving/interactor/GetSavingDetail$Param;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "component3", "savingId", "topUpViewsPage", "topUpViewsSize", "copy", "(Ljava/lang/String;JJ)Lid/dana/domain/saving/interactor/GetSavingDetail$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSavingId", "J", "getTopUpViewsPage", "getTopUpViewsSize", "<init>", "(Ljava/lang/String;JJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final String savingId;
        private final long topUpViewsPage;
        private final long topUpViewsSize;

        public static /* synthetic */ Param copy$default(Param param, String str, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.savingId;
            }
            if ((i & 2) != 0) {
                j = param.topUpViewsPage;
            }
            long j3 = j;
            if ((i & 4) != 0) {
                j2 = param.topUpViewsSize;
            }
            return param.copy(str, j3, j2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getSavingId() {
            return this.savingId;
        }

        /* renamed from: component2  reason: from getter */
        public final long getTopUpViewsPage() {
            return this.topUpViewsPage;
        }

        /* renamed from: component3  reason: from getter */
        public final long getTopUpViewsSize() {
            return this.topUpViewsSize;
        }

        public final Param copy(String savingId, long topUpViewsPage, long topUpViewsSize) {
            Intrinsics.checkNotNullParameter(savingId, "");
            return new Param(savingId, topUpViewsPage, topUpViewsSize);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.savingId, param.savingId) && this.topUpViewsPage == param.topUpViewsPage && this.topUpViewsSize == param.topUpViewsSize;
            }
            return false;
        }

        public final int hashCode() {
            return (((this.savingId.hashCode() * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.topUpViewsPage)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.topUpViewsSize);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(savingId=");
            sb.append(this.savingId);
            sb.append(", topUpViewsPage=");
            sb.append(this.topUpViewsPage);
            sb.append(", topUpViewsSize=");
            sb.append(this.topUpViewsSize);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, long j, long j2) {
            Intrinsics.checkNotNullParameter(str, "");
            this.savingId = str;
            this.topUpViewsPage = j;
            this.topUpViewsSize = j2;
        }

        @JvmName(name = "getSavingId")
        public final String getSavingId() {
            return this.savingId;
        }

        @JvmName(name = "getTopUpViewsPage")
        public final long getTopUpViewsPage() {
            return this.topUpViewsPage;
        }

        @JvmName(name = "getTopUpViewsSize")
        public final long getTopUpViewsSize() {
            return this.topUpViewsSize;
        }
    }
}
