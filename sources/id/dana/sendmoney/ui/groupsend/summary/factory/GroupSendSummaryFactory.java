package id.dana.sendmoney.ui.groupsend.summary.factory;

import id.dana.sendmoney.ui.groupsend.summary.state.X2BGroupSendSummary;
import id.dana.sendmoney.ui.groupsend.summary.state.X2PGroupSendSummary;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/factory/GroupSendSummaryFactory;", "", "Lid/dana/sendmoney/ui/groupsend/summary/state/X2BGroupSendSummary;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/groupsend/summary/state/X2BGroupSendSummary;", "Lid/dana/sendmoney/ui/groupsend/summary/state/X2PGroupSendSummary;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/ui/groupsend/summary/state/X2PGroupSendSummary;", "p0", "p1", "<init>", "(Lid/dana/sendmoney/ui/groupsend/summary/state/X2PGroupSendSummary;Lid/dana/sendmoney/ui/groupsend/summary/state/X2BGroupSendSummary;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendSummaryFactory {
    public final X2PGroupSendSummary BuiltInFictitiousFunctionClassFactory;
    public final X2BGroupSendSummary PlaceComponentResult;

    @Inject
    public GroupSendSummaryFactory(X2PGroupSendSummary x2PGroupSendSummary, X2BGroupSendSummary x2BGroupSendSummary) {
        Intrinsics.checkNotNullParameter(x2PGroupSendSummary, "");
        Intrinsics.checkNotNullParameter(x2BGroupSendSummary, "");
        this.BuiltInFictitiousFunctionClassFactory = x2PGroupSendSummary;
        this.PlaceComponentResult = x2BGroupSendSummary;
    }
}
