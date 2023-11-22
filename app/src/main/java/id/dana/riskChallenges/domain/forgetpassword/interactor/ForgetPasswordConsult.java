package id.dana.riskChallenges.domain.forgetpassword.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.riskChallenges.domain.forgetpassword.ResetPasswordRepository;
import id.dana.riskChallenges.domain.forgetpassword.model.RiskChallenges;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/riskChallenges/domain/forgetpassword/interactor/ForgetPasswordConsult;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/riskChallenges/domain/forgetpassword/model/RiskChallenges;", "Lid/dana/riskChallenges/domain/forgetpassword/interactor/ForgetPasswordConsult$Params;", "Lid/dana/riskChallenges/domain/forgetpassword/ResetPasswordRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/domain/forgetpassword/ResetPasswordRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/riskChallenges/domain/forgetpassword/ResetPasswordRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ForgetPasswordConsult extends BaseUseCase<RiskChallenges, Params> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ResetPasswordRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<RiskChallenges> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(params2.MyBillsEntityDataFactory, params2.PlaceComponentResult, params2.getGetAuthRequestContext(), params2.getBuiltInFictitiousFunctionClassFactory());
    }

    @Inject
    public ForgetPasswordConsult(ResetPasswordRepository resetPasswordRepository) {
        Intrinsics.checkNotNullParameter(resetPasswordRepository, "");
        this.getAuthRequestContext = resetPasswordRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0011\u0010\n\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\tX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b"}, d2 = {"Lid/dana/riskChallenges/domain/forgetpassword/interactor/ForgetPasswordConsult$Params;", "", "", "BuiltInFictitiousFunctionClassFactory", "Z", "PlaceComponentResult", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "p0", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {
        private final boolean BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;
        final String MyBillsEntityDataFactory;
        final String PlaceComponentResult;

        public Params(String str, String str2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = str;
            this.PlaceComponentResult = str2;
            this.getAuthRequestContext = z;
            this.BuiltInFictitiousFunctionClassFactory = z2;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }
}
