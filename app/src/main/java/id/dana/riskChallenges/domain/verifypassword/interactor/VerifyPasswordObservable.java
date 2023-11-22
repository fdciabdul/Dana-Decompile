package id.dana.riskChallenges.domain.verifypassword.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.riskChallenges.domain.verifypassword.VerifyPasswordRepository;
import id.dana.riskChallenges.domain.verifypassword.model.VerifyPassword;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/riskChallenges/domain/verifypassword/interactor/VerifyPasswordObservable;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/riskChallenges/domain/verifypassword/model/VerifyPassword;", "Lid/dana/riskChallenges/domain/verifypassword/interactor/VerifyPasswordObservable$Params;", "Lid/dana/riskChallenges/domain/verifypassword/VerifyPasswordRepository;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/domain/verifypassword/VerifyPasswordRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/riskChallenges/domain/verifypassword/VerifyPasswordRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPasswordObservable extends BaseUseCase<VerifyPassword, Params> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final VerifyPasswordRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<VerifyPassword> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        if (Intrinsics.areEqual(params2.KClassImpl$Data$declaredNonStaticMembers$2, "AP_DAPROT_ACTIVITY")) {
            return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(params2.MyBillsEntityDataFactory, params2.getAuthRequestContext, params2.BuiltInFictitiousFunctionClassFactory, params2.KClassImpl$Data$declaredNonStaticMembers$2, params2.lookAheadTest);
        }
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(params2.BuiltInFictitiousFunctionClassFactory, params2.KClassImpl$Data$declaredNonStaticMembers$2, params2.lookAheadTest, params2.getPlaceComponentResult());
    }

    @Inject
    public VerifyPasswordObservable(VerifyPasswordRepository verifyPasswordRepository) {
        Intrinsics.checkNotNullParameter(verifyPasswordRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = verifyPasswordRepository;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000e\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0011\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012"}, d2 = {"Lid/dana/riskChallenges/domain/verifypassword/interactor/VerifyPasswordObservable$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "moveToNextValue", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String lookAheadTest;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;
        final String MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        final String getAuthRequestContext;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, params.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, params.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.lookAheadTest, params.lookAheadTest) && this.PlaceComponentResult == params.PlaceComponentResult && Intrinsics.areEqual(this.MyBillsEntityDataFactory, params.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, params.getAuthRequestContext);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            int hashCode2 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            int hashCode3 = this.lookAheadTest.hashCode();
            boolean z = this.PlaceComponentResult;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, String str3, boolean z, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            this.lookAheadTest = str3;
            this.PlaceComponentResult = z;
            this.MyBillsEntityDataFactory = str4;
            this.getAuthRequestContext = str5;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }
}
