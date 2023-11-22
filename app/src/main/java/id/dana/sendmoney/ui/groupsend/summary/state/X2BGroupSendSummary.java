package id.dana.sendmoney.ui.groupsend.summary.state;

import id.dana.sendmoney.R;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/state/X2BGroupSendSummary;", "Lid/dana/sendmoney/ui/groupsend/summary/state/GroupSendSummary;", "", "MyBillsEntityDataFactory", "()I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class X2BGroupSendSummary extends GroupSendSummary {
    @Inject
    public X2BGroupSendSummary() {
    }

    @Override // id.dana.sendmoney.ui.groupsend.summary.state.GroupSendSummary
    public final int MyBillsEntityDataFactory() {
        return R.string.send_to_group_toolbar;
    }
}
