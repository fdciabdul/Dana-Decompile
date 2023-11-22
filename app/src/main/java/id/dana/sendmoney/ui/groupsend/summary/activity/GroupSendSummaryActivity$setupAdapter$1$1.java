package id.dana.sendmoney.ui.groupsend.summary.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class GroupSendSummaryActivity$setupAdapter$1$1 extends FunctionReferenceImpl implements Function2<String, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GroupSendSummaryActivity$setupAdapter$1$1(Object obj) {
        super(2, obj, GroupSendSummaryActivity.class, "onAmountChanged", "onAmountChanged(Ljava/lang/String;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* synthetic */ Unit invoke(String str, Boolean bool) {
        invoke(str, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        GroupSendSummaryActivity.access$onAmountChanged((GroupSendSummaryActivity) this.receiver, str, z);
    }
}
