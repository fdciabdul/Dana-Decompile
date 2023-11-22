package id.dana.sendmoney.summary.factory;

import id.dana.sendmoney.summary.state.BankSendMoneySummary;
import id.dana.sendmoney.summary.state.ContactSendMoneySummary;
import id.dana.sendmoney.summary.state.LinkSendMoneySummary;
import id.dana.sendmoney.summary.state.OtcSendMoneySummary;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\r"}, d2 = {"Lid/dana/sendmoney/summary/factory/SendMoneySummaryFactory;", "", "Lid/dana/sendmoney/summary/state/BankSendMoneySummary;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/summary/state/BankSendMoneySummary;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/summary/state/ContactSendMoneySummary;", "Lid/dana/sendmoney/summary/state/ContactSendMoneySummary;", "PlaceComponentResult", "Lid/dana/sendmoney/summary/state/LinkSendMoneySummary;", "getAuthRequestContext", "Lid/dana/sendmoney/summary/state/LinkSendMoneySummary;", "Lid/dana/sendmoney/summary/state/OtcSendMoneySummary;", "Lid/dana/sendmoney/summary/state/OtcSendMoneySummary;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/sendmoney/summary/state/BankSendMoneySummary;Lid/dana/sendmoney/summary/state/ContactSendMoneySummary;Lid/dana/sendmoney/summary/state/OtcSendMoneySummary;Lid/dana/sendmoney/summary/state/LinkSendMoneySummary;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneySummaryFactory {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final BankSendMoneySummary MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ContactSendMoneySummary PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final OtcSendMoneySummary BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final LinkSendMoneySummary KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public SendMoneySummaryFactory(BankSendMoneySummary bankSendMoneySummary, ContactSendMoneySummary contactSendMoneySummary, OtcSendMoneySummary otcSendMoneySummary, LinkSendMoneySummary linkSendMoneySummary) {
        Intrinsics.checkNotNullParameter(bankSendMoneySummary, "");
        Intrinsics.checkNotNullParameter(contactSendMoneySummary, "");
        Intrinsics.checkNotNullParameter(otcSendMoneySummary, "");
        Intrinsics.checkNotNullParameter(linkSendMoneySummary, "");
        this.MyBillsEntityDataFactory = bankSendMoneySummary;
        this.PlaceComponentResult = contactSendMoneySummary;
        this.BuiltInFictitiousFunctionClassFactory = otcSendMoneySummary;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linkSendMoneySummary;
    }
}
