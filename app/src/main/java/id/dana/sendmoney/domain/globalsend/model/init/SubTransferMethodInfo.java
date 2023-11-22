package id.dana.sendmoney.domain.globalsend.model.init;

import id.dana.domain.user.CurrencyAmount;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010 R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0011\u0010\f\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0011\u0010\r\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0011\u0010\u0011\u001a\u00020\u000eX\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000f\u001a\u00020\u000eX\u0007¢\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u0012X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/init/SubTransferMethodInfo;", "", "", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "getAuthRequestContext", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "lookAheadTest", "Lid/dana/domain/user/CurrencyAmount;", "scheduleImpl", "Lid/dana/domain/user/CurrencyAmount;", "getErrorConfigVersion", "Lid/dana/sendmoney/domain/globalsend/model/init/CurrencyRate;", "Lid/dana/sendmoney/domain/globalsend/model/init/CurrencyRate;", "moveToNextValue", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Lid/dana/sendmoney/domain/globalsend/model/init/CurrencyRate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/user/CurrencyAmount;Lid/dana/domain/user/CurrencyAmount;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubTransferMethodInfo {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final CurrencyRate moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final CurrencyAmount scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final CurrencyAmount getErrorConfigVersion;

    public SubTransferMethodInfo() {
        this(null, null, null, null, null, null, null, null, null, false, 1023, null);
    }

    public SubTransferMethodInfo(CurrencyRate currencyRate, String str, String str2, String str3, String str4, String str5, String str6, CurrencyAmount currencyAmount, CurrencyAmount currencyAmount2, boolean z) {
        Intrinsics.checkNotNullParameter(currencyRate, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        Intrinsics.checkNotNullParameter(currencyAmount2, "");
        this.moveToNextValue = currencyRate;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.PlaceComponentResult = str2;
        this.MyBillsEntityDataFactory = str3;
        this.getAuthRequestContext = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
        this.lookAheadTest = str6;
        this.scheduleImpl = currencyAmount;
        this.getErrorConfigVersion = currencyAmount2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    public /* synthetic */ SubTransferMethodInfo(CurrencyRate currencyRate, String str, String str2, String str3, String str4, String str5, String str6, CurrencyAmount currencyAmount, CurrencyAmount currencyAmount2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CurrencyRate(null, null, null, null, 15, null) : currencyRate, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) == 0 ? str6 : "", (i & 128) != 0 ? new CurrencyAmount() : currencyAmount, (i & 256) != 0 ? new CurrencyAmount() : currencyAmount2, (i & 512) != 0 ? false : z);
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
