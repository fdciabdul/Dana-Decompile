package id.dana.riskChallenges.domain.passkey.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002\u0012\u0004\u0012\u00020\u00060\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyRemoveCredential;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lkotlin/Pair;", "", "", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyRemoveCredential$Params;", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyRemoveCredential extends BaseUseCase<Pair<? extends String, ? extends List<? extends VerificationMethodModel>>, Params> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final PasskeyRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Pair<? extends String, ? extends List<? extends VerificationMethodModel>>> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(params2.getBuiltInFictitiousFunctionClassFactory());
    }

    @Inject
    public PasskeyRemoveCredential(PasskeyRepository passkeyRepository) {
        Intrinsics.checkNotNullParameter(passkeyRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = passkeyRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyRemoveCredential$Params;", "", "", "MyBillsEntityDataFactory", "Z", "PlaceComponentResult", "()Z", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public Params() {
            this(false, 1, null);
        }

        public Params(boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        public /* synthetic */ Params(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }
}
