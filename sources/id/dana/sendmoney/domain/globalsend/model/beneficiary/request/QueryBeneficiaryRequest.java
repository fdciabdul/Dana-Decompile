package id.dana.sendmoney.domain.globalsend.model.beneficiary.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB#\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\t"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest;", "", "", "PlaceComponentResult", "I", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "getAuthRequestContext", "", "Ljava/lang/String;", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueryBeneficiaryRequest {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    private QueryBeneficiaryRequest(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
    }

    public /* synthetic */ QueryBeneficiaryRequest(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "GLOBAL_TRANSFER" : str, i, (i3 & 4) != 0 ? 1 : i2);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest$Companion;", "", "", "p0", "Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest;", "BuiltInFictitiousFunctionClassFactory", "(I)Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static QueryBeneficiaryRequest BuiltInFictitiousFunctionClassFactory(int p0) {
            return new QueryBeneficiaryRequest(null, p0, 0, 5, null);
        }
    }
}
