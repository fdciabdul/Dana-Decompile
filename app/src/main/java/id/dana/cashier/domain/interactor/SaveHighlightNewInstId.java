package id.dana.cashier.domain.interactor;

import id.dana.cashier.domain.CashierRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/domain/interactor/SaveHighlightNewInstId;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/CashierRepository;", "cashierRepository", "Lid/dana/cashier/domain/CashierRepository;", "<init>", "(Lid/dana/cashier/domain/CashierRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveHighlightNewInstId extends BaseUseCase<Boolean, String> {
    private static final String HIGHLIGHT_NEW_SHOWN = "highlight_new_shown";
    private final CashierRepository cashierRepository;

    @Inject
    public SaveHighlightNewInstId(CashierRepository cashierRepository) {
        Intrinsics.checkNotNullParameter(cashierRepository, "");
        this.cashierRepository = cashierRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(final String params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.cashierRepository.getHighlightNewInstId().flatMap(new Function() { // from class: id.dana.cashier.domain.interactor.SaveHighlightNewInstId$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m591buildUseCase$lambda0;
                m591buildUseCase$lambda0 = SaveHighlightNewInstId.m591buildUseCase$lambda0(SaveHighlightNewInstId.this, params, (String) obj);
                return m591buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m591buildUseCase$lambda0(SaveHighlightNewInstId saveHighlightNewInstId, String str, String str2) {
        Intrinsics.checkNotNullParameter(saveHighlightNewInstId, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        CashierRepository cashierRepository = saveHighlightNewInstId.cashierRepository;
        if (str2.hashCode() == -136638489 && str2.equals(HIGHLIGHT_NEW_SHOWN)) {
            str = HIGHLIGHT_NEW_SHOWN;
        }
        return cashierRepository.saveHighlightNewInstId(str);
    }
}
