package id.dana.sendmoney_v2.recipient.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class RecipientView$setupRecyclerView$1$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public RecipientView$setupRecyclerView$1$1$1(Object obj) {
        super(1, obj, RecipientView.class, "onItemClick", "onItemClick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        RecipientView.access$onItemClick((RecipientView) this.receiver, i);
    }
}
