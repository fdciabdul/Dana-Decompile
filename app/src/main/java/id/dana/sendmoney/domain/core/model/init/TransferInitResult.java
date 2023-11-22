package id.dana.sendmoney.domain.core.model.init;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0013\u0010\t\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\n"}, d2 = {"Lid/dana/sendmoney/domain/core/model/init/TransferInitResult;", "", "Lid/dana/domain/nearbyme/model/MoneyView;", "getAuthRequestContext", "Lid/dana/domain/nearbyme/model/MoneyView;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/domain/core/model/init/TransferUserInfo;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/core/model/init/TransferUserInfo;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/sendmoney/domain/core/model/init/TransferUserInfo;Lid/dana/sendmoney/domain/core/model/init/TransferUserInfo;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferInitResult {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final TransferUserInfo MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final TransferUserInfo BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MoneyView PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final MoneyView getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final MoneyView KClassImpl$Data$declaredNonStaticMembers$2;

    public TransferInitResult() {
        this(null, null, null, null, null, 31, null);
    }

    public TransferInitResult(MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, TransferUserInfo transferUserInfo, TransferUserInfo transferUserInfo2) {
        this.PlaceComponentResult = moneyView;
        this.getAuthRequestContext = moneyView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moneyView3;
        this.BuiltInFictitiousFunctionClassFactory = transferUserInfo;
        this.MyBillsEntityDataFactory = transferUserInfo2;
    }

    public /* synthetic */ TransferInitResult(MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, TransferUserInfo transferUserInfo, TransferUserInfo transferUserInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView, (i & 2) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView2, (i & 4) != 0 ? new MoneyView(null, null, null, 7, null) : moneyView3, (i & 8) != 0 ? new TransferUserInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null) : transferUserInfo, (i & 16) != 0 ? new TransferUserInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null) : transferUserInfo2);
    }
}
