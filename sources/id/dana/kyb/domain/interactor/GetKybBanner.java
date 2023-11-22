package id.dana.kyb.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.promotion.Space;
import id.dana.kyb.domain.KybRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/domain/interactor/GetKybBanner;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/promotion/Space;", "Lid/dana/kyb/domain/interactor/GetKybBanner$Param;", "Lid/dana/kyb/domain/KybRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/domain/KybRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/kyb/domain/KybRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetKybBanner extends BaseUseCase<Space, Param> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final KybRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Space> buildUseCase(Param param) {
        Param param2 = param;
        Intrinsics.checkNotNullParameter(param2, "");
        return this.getAuthRequestContext.MyBillsEntityDataFactory(param2.getGetAuthRequestContext());
    }

    @Inject
    public GetKybBanner(KybRepository kybRepository) {
        Intrinsics.checkNotNullParameter(kybRepository, "");
        this.getAuthRequestContext = kybRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/domain/interactor/GetKybBanner$Param;", "", "", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "()Z", "getAuthRequestContext", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Param {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private boolean getAuthRequestContext;

        public Param(boolean z) {
            this.getAuthRequestContext = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }
}
