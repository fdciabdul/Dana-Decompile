package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u001a\u0010\u0001\u001a\u00020\u00008\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u00008\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u0014\u0010\u0007\u001a\u00020\u00008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0002\"\u0014\u0010\b\u001a\u00020\u00008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0002\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"", "ALREADY_SELECTED", "Ljava/lang/Object;", "getALREADY_SELECTED", "()Ljava/lang/Object;", "NOT_SELECTED", "getNOT_SELECTED", "RESUMED", "UNDECIDED", "Lkotlinx/coroutines/selects/SeqNumber;", "selectOpSequenceNumber", "Lkotlinx/coroutines/selects/SeqNumber;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectKt {
    private static final Object NOT_SELECTED = new Symbol("NOT_SELECTED");
    private static final Object ALREADY_SELECTED = new Symbol("ALREADY_SELECTED");
    private static final Object UNDECIDED = new Symbol("UNDECIDED");
    private static final Object RESUMED = new Symbol("RESUMED");
    private static final SeqNumber selectOpSequenceNumber = new SeqNumber();

    @JvmName(name = "getNOT_SELECTED")
    public static final Object getNOT_SELECTED() {
        return NOT_SELECTED;
    }

    @JvmName(name = "getALREADY_SELECTED")
    public static final Object getALREADY_SELECTED() {
        return ALREADY_SELECTED;
    }
}
