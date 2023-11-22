package id.dana.sendmoney.domain.globalsend.model.init;

import id.dana.domain.user.CurrencyAmount;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0011\u0010\n\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\b"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/init/CurrencyRate;", "", "Lid/dana/domain/user/CurrencyAmount;", "getAuthRequestContext", "Lid/dana/domain/user/CurrencyAmount;", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/domain/user/CurrencyAmount;Lid/dana/domain/user/CurrencyAmount;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrencyRate {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final CurrencyAmount getAuthRequestContext;
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final CurrencyAmount MyBillsEntityDataFactory;

    public CurrencyRate() {
        this(null, null, null, null, 15, null);
    }

    public CurrencyRate(CurrencyAmount currencyAmount, CurrencyAmount currencyAmount2, String str, String str2) {
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        Intrinsics.checkNotNullParameter(currencyAmount2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.getAuthRequestContext = currencyAmount;
        this.MyBillsEntityDataFactory = currencyAmount2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = str2;
    }

    public /* synthetic */ CurrencyRate(CurrencyAmount currencyAmount, CurrencyAmount currencyAmount2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CurrencyAmount("", "") : currencyAmount, (i & 2) != 0 ? new CurrencyAmount("", "") : currencyAmount2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2);
    }
}
