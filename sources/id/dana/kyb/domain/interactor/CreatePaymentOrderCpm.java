package id.dana.kyb.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.model.PaymentOrderCpm;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/domain/interactor/CreatePaymentOrderCpm;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/kyb/domain/model/PaymentOrderCpm;", "Lid/dana/kyb/domain/interactor/CreatePaymentOrderCpm$Params;", "Lid/dana/kyb/domain/KybRepository;", "PlaceComponentResult", "Lid/dana/kyb/domain/KybRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/kyb/domain/KybRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreatePaymentOrderCpm extends BaseUseCase<PaymentOrderCpm, Params> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final KybRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<PaymentOrderCpm> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(params2.BuiltInFictitiousFunctionClassFactory, params2.PlaceComponentResult);
    }

    @Inject
    public CreatePaymentOrderCpm(KybRepository kybRepository) {
        Intrinsics.checkNotNullParameter(kybRepository, "");
        this.MyBillsEntityDataFactory = kybRepository;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\r"}, d2 = {"Lid/dana/kyb/domain/interactor/CreatePaymentOrderCpm$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "PlaceComponentResult", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        String PlaceComponentResult;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, params.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, params.PlaceComponentResult);
            }
            return false;
        }

        public final int hashCode() {
            return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.PlaceComponentResult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = str2;
        }
    }
}
