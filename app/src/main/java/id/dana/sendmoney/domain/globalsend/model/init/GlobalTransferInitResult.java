package id.dana.sendmoney.domain.globalsend.model.init;

import id.dana.domain.user.CurrencyAmount;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\t\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitResult;", "", "Lid/dana/domain/user/CurrencyAmount;", "PlaceComponentResult", "Lid/dana/domain/user/CurrencyAmount;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "getAuthRequestContext", "Lid/dana/sendmoney/domain/globalsend/model/init/TransferUserInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/globalsend/model/init/TransferUserInfo;", "", "Lid/dana/sendmoney/domain/globalsend/model/init/SubTransferMethodInfo;", "getErrorConfigVersion", "Ljava/util/List;", "lookAheadTest", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/domain/user/CurrencyAmount;Lid/dana/domain/user/CurrencyAmount;Lid/dana/domain/user/CurrencyAmount;Ljava/util/List;Lid/dana/sendmoney/domain/globalsend/model/init/TransferUserInfo;Lid/dana/sendmoney/domain/globalsend/model/init/TransferUserInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalTransferInitResult {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final TransferUserInfo KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final TransferUserInfo MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final CurrencyAmount getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final CurrencyAmount BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final CurrencyAmount PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final List<SubTransferMethodInfo> lookAheadTest;

    public GlobalTransferInitResult(CurrencyAmount currencyAmount, CurrencyAmount currencyAmount2, CurrencyAmount currencyAmount3, List<SubTransferMethodInfo> list, TransferUserInfo transferUserInfo, TransferUserInfo transferUserInfo2) {
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        Intrinsics.checkNotNullParameter(currencyAmount2, "");
        Intrinsics.checkNotNullParameter(currencyAmount3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(transferUserInfo, "");
        Intrinsics.checkNotNullParameter(transferUserInfo2, "");
        this.PlaceComponentResult = currencyAmount;
        this.getAuthRequestContext = currencyAmount2;
        this.BuiltInFictitiousFunctionClassFactory = currencyAmount3;
        this.lookAheadTest = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = transferUserInfo;
        this.MyBillsEntityDataFactory = transferUserInfo2;
    }
}
