package id.dana.cardbinding.domain.interactor;

import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxConvertKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cardbinding/domain/interactor/GetIsCardBindingV2Enabled;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/cardbinding/domain/CardBindingRepository;", "PlaceComponentResult", "Lid/dana/cardbinding/domain/CardBindingRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/cardbinding/domain/CardBindingRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetIsCardBindingV2Enabled extends BaseUseCase<Boolean, NoParams> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CardBindingRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return RxConvertKt.asObservable$default(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(), null, 1, null);
    }

    @Inject
    public GetIsCardBindingV2Enabled(CardBindingRepository cardBindingRepository) {
        Intrinsics.checkNotNullParameter(cardBindingRepository, "");
        this.MyBillsEntityDataFactory = cardBindingRepository;
    }
}
