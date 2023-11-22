package id.dana.electronicmoney;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0003\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0012\u0010\n\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0012\u0010\r\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0012\u0010\f\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\t8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u0003\u0010\u000f"}, d2 = {"Lid/dana/electronicmoney/BalanceResult;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "lookAheadTest", "moveToNextValue", "scheduleImpl", "()Z", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BalanceResult {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String lookAheadTest;
    private boolean scheduleImpl;

    public BalanceResult() {
        this(false, null, null, null, null, null, false, null, null, 511, null);
    }

    private BalanceResult(boolean z, String str, String str2, String str3, String str4, String str5, boolean z2, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.scheduleImpl = z;
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.moveToNextValue = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z2;
        this.lookAheadTest = str6;
        this.getAuthRequestContext = str7;
    }

    public /* synthetic */ BalanceResult(boolean z, String str, String str2, String str3, String str4, String str5, boolean z2, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) == 0 ? z2 : false, (i & 128) != 0 ? "" : str6, (i & 256) == 0 ? str7 : "");
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getScheduleImpl() {
        return this.scheduleImpl;
    }
}
