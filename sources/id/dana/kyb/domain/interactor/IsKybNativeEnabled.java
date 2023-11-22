package id.dana.kyb.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.kyb.domain.KybRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/domain/interactor/IsKybNativeEnabled;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/kyb/domain/KybRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/domain/KybRepository;", "p0", "<init>", "(Lid/dana/kyb/domain/KybRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IsKybNativeEnabled extends BaseUseCase<Boolean, NoParams> {
    private final KybRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable<Boolean> onErrorReturnItem = this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil().onErrorReturnItem(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    @Inject
    public IsKybNativeEnabled(KybRepository kybRepository) {
        Intrinsics.checkNotNullParameter(kybRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = kybRepository;
    }
}
