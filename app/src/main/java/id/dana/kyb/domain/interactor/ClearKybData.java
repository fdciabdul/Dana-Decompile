package id.dana.kyb.domain.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.kyb.domain.KybRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/kyb/domain/interactor/ClearKybData;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/kyb/domain/KybRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/domain/KybRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/kyb/domain/KybRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClearKybData extends CompletableUseCase<NoParams> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final KybRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final /* synthetic */ Completable buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
    }

    @Inject
    public ClearKybData(KybRepository kybRepository) {
        Intrinsics.checkNotNullParameter(kybRepository, "");
        this.MyBillsEntityDataFactory = kybRepository;
    }
}
