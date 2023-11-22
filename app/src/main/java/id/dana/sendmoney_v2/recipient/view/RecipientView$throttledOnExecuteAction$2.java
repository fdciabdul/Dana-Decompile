package id.dana.sendmoney_v2.recipient.view;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.base.ThrottledOnExecuteAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lid/dana/base/ThrottledOnExecuteAction;", BridgeDSL.INVOKE, "()Lid/dana/base/ThrottledOnExecuteAction;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecipientView$throttledOnExecuteAction$2 extends Lambda implements Function0<ThrottledOnExecuteAction> {
    public static final RecipientView$throttledOnExecuteAction$2 INSTANCE = new RecipientView$throttledOnExecuteAction$2();

    RecipientView$throttledOnExecuteAction$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ThrottledOnExecuteAction invoke() {
        return new ThrottledOnExecuteAction();
    }
}
