package id.dana.sendmoney.domain.globalsend.model.validate;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019BQ\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000eR\u0011\u0010\f\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "PlaceComponentResult", "Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "", "scheduleImpl", "Z", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferValidateRequest {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final BeneficiaryInfo getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    private TransferValidateRequest(BeneficiaryInfo beneficiaryInfo, String str, String str2, boolean z, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(beneficiaryInfo, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = beneficiaryInfo;
        this.scheduleImpl = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        this.PlaceComponentResult = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.MyBillsEntityDataFactory = str5;
    }

    public /* synthetic */ TransferValidateRequest(BeneficiaryInfo beneficiaryInfo, String str, String str2, boolean z, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(beneficiaryInfo, (i & 2) != 0 ? "GLOBAL_TRANSFER" : str, (i & 4) != 0 ? null : str2, z, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest$Companion;", "", "", "p0", "Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;", "p1", "p2", "Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;Ljava/lang/String;)Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/domain/globalsend/model/validate/BeneficiaryInfo;)Lid/dana/sendmoney/domain/globalsend/model/validate/TransferValidateRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static TransferValidateRequest BuiltInFictitiousFunctionClassFactory(String p0, BeneficiaryInfo p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            return new TransferValidateRequest(p1, null, null, false, p2, p0, null, 70, null);
        }

        public static TransferValidateRequest MyBillsEntityDataFactory(BeneficiaryInfo p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new TransferValidateRequest(p0, null, null, true, null, null, p0.scheduleImpl, 54, null);
        }
    }
}
