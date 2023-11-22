package id.dana.domain.saving.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.model.SavingLimit;
import id.dana.domain.saving.model.SavingUpdateInit;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/saving/interactor/InitSavingUpdate;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/saving/model/SavingUpdateInit;", "", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/saving/SavingCategoryRepository;", "savingCategoryRepository", "Lid/dana/domain/saving/SavingCategoryRepository;", "Lid/dana/domain/saving/SavingRepository;", "savingRepository", "Lid/dana/domain/saving/SavingRepository;", "<init>", "(Lid/dana/domain/saving/SavingRepository;Lid/dana/domain/saving/SavingCategoryRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InitSavingUpdate extends BaseUseCase<SavingUpdateInit, String> {
    private final SavingCategoryRepository savingCategoryRepository;
    private final SavingRepository savingRepository;

    @Inject
    public InitSavingUpdate(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        Intrinsics.checkNotNullParameter(savingRepository, "");
        Intrinsics.checkNotNullParameter(savingCategoryRepository, "");
        this.savingRepository = savingRepository;
        this.savingCategoryRepository = savingCategoryRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<SavingUpdateInit> buildUseCase(String params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<SavingUpdateInit> flatMap = Observable.zip(this.savingRepository.initSavingUpdate(params), this.savingRepository.getSavingLimit(), new BiFunction() { // from class: id.dana.domain.saving.interactor.InitSavingUpdate$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                SavingUpdateInit m2487buildUseCase$lambda1;
                m2487buildUseCase$lambda1 = InitSavingUpdate.m2487buildUseCase$lambda1((SavingUpdateInit) obj, (SavingLimit) obj2);
                return m2487buildUseCase$lambda1;
            }
        }).flatMap(new Function() { // from class: id.dana.domain.saving.interactor.InitSavingUpdate$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2488buildUseCase$lambda4;
                m2488buildUseCase$lambda4 = InitSavingUpdate.m2488buildUseCase$lambda4(InitSavingUpdate.this, (SavingUpdateInit) obj);
                return m2488buildUseCase$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final SavingUpdateInit m2487buildUseCase$lambda1(SavingUpdateInit savingUpdateInit, SavingLimit savingLimit) {
        Intrinsics.checkNotNullParameter(savingUpdateInit, "");
        Intrinsics.checkNotNullParameter(savingLimit, "");
        savingUpdateInit.setMaxSavingCountNonKyc(savingLimit.getMaxSavingCountNonKyc());
        savingUpdateInit.setMaxSavingAmountNonKyc(savingLimit.getMaxSavingAmountNonKyc());
        savingUpdateInit.setMaxSavingAmountKyc(savingLimit.getMaxSavingAmountKyc());
        return savingUpdateInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-4  reason: not valid java name */
    public static final ObservableSource m2488buildUseCase$lambda4(InitSavingUpdate initSavingUpdate, final SavingUpdateInit savingUpdateInit) {
        Intrinsics.checkNotNullParameter(initSavingUpdate, "");
        Intrinsics.checkNotNullParameter(savingUpdateInit, "");
        SavingCategoryRepository savingCategoryRepository = initSavingUpdate.savingCategoryRepository;
        Object[] array = savingUpdateInit.getCategoryCodes().toArray(new String[0]);
        if (array != null) {
            return savingCategoryRepository.getSavingCategoriesByKeys((String[]) array).flatMap(new Function() { // from class: id.dana.domain.saving.interactor.InitSavingUpdate$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2489buildUseCase$lambda4$lambda3;
                    m2489buildUseCase$lambda4$lambda3 = InitSavingUpdate.m2489buildUseCase$lambda4$lambda3(SavingUpdateInit.this, (List) obj);
                    return m2489buildUseCase$lambda4$lambda3;
                }
            });
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-4$lambda-3  reason: not valid java name */
    public static final ObservableSource m2489buildUseCase$lambda4$lambda3(SavingUpdateInit savingUpdateInit, List list) {
        Intrinsics.checkNotNullParameter(savingUpdateInit, "");
        Intrinsics.checkNotNullParameter(list, "");
        savingUpdateInit.getSavingCategories().addAll(list);
        return Observable.just(savingUpdateInit);
    }
}
