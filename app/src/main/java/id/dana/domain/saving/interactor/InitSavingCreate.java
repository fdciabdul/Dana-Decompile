package id.dana.domain.saving.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.saving.model.SavingCreateInit;
import id.dana.domain.saving.model.SavingLimit;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/domain/saving/interactor/InitSavingCreate;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/saving/model/SavingCreateInit;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/saving/SavingCategoryRepository;", "savingCategoryRepository", "Lid/dana/domain/saving/SavingCategoryRepository;", "Lid/dana/domain/saving/SavingRepository;", "savingRepository", "Lid/dana/domain/saving/SavingRepository;", "<init>", "(Lid/dana/domain/saving/SavingRepository;Lid/dana/domain/saving/SavingCategoryRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InitSavingCreate extends BaseUseCase<SavingCreateInit, NoParams> {
    private final SavingCategoryRepository savingCategoryRepository;
    private final SavingRepository savingRepository;

    @Inject
    public InitSavingCreate(SavingRepository savingRepository, SavingCategoryRepository savingCategoryRepository) {
        Intrinsics.checkNotNullParameter(savingRepository, "");
        Intrinsics.checkNotNullParameter(savingCategoryRepository, "");
        this.savingRepository = savingRepository;
        this.savingCategoryRepository = savingCategoryRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<SavingCreateInit> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<SavingCreateInit> flatMap = Observable.zip(this.savingRepository.initSavingCreate(), this.savingRepository.getSavingLimit(), new BiFunction() { // from class: id.dana.domain.saving.interactor.InitSavingCreate$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                SavingCreateInit m2484buildUseCase$lambda1;
                m2484buildUseCase$lambda1 = InitSavingCreate.m2484buildUseCase$lambda1((SavingCreateInit) obj, (SavingLimit) obj2);
                return m2484buildUseCase$lambda1;
            }
        }).flatMap(new Function() { // from class: id.dana.domain.saving.interactor.InitSavingCreate$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2485buildUseCase$lambda4;
                m2485buildUseCase$lambda4 = InitSavingCreate.m2485buildUseCase$lambda4(InitSavingCreate.this, (SavingCreateInit) obj);
                return m2485buildUseCase$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final SavingCreateInit m2484buildUseCase$lambda1(SavingCreateInit savingCreateInit, SavingLimit savingLimit) {
        Intrinsics.checkNotNullParameter(savingCreateInit, "");
        Intrinsics.checkNotNullParameter(savingLimit, "");
        savingCreateInit.setMaxSavingCountNonKyc(savingLimit.getMaxSavingCountNonKyc());
        savingCreateInit.setMaxSavingAmountNonKyc(savingLimit.getMaxSavingAmountNonKyc());
        savingCreateInit.setMaxSavingAmountKyc(savingLimit.getMaxSavingAmountKyc());
        return savingCreateInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-4  reason: not valid java name */
    public static final ObservableSource m2485buildUseCase$lambda4(InitSavingCreate initSavingCreate, final SavingCreateInit savingCreateInit) {
        Intrinsics.checkNotNullParameter(initSavingCreate, "");
        Intrinsics.checkNotNullParameter(savingCreateInit, "");
        SavingCategoryRepository savingCategoryRepository = initSavingCreate.savingCategoryRepository;
        Object[] array = savingCreateInit.getCategoryCodes().toArray(new String[0]);
        if (array != null) {
            return savingCategoryRepository.getSavingCategoriesByKeys((String[]) array).flatMap(new Function() { // from class: id.dana.domain.saving.interactor.InitSavingCreate$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2486buildUseCase$lambda4$lambda3;
                    m2486buildUseCase$lambda4$lambda3 = InitSavingCreate.m2486buildUseCase$lambda4$lambda3(SavingCreateInit.this, (List) obj);
                    return m2486buildUseCase$lambda4$lambda3;
                }
            });
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-4$lambda-3  reason: not valid java name */
    public static final ObservableSource m2486buildUseCase$lambda4$lambda3(SavingCreateInit savingCreateInit, List list) {
        Intrinsics.checkNotNullParameter(savingCreateInit, "");
        Intrinsics.checkNotNullParameter(list, "");
        savingCreateInit.getSavingCategories().addAll(list);
        return Observable.just(savingCreateInit);
    }
}
