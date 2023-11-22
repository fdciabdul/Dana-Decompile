package kotlin;

import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0001\u001a\u00020\u0000*\u00020\u00028Ç\u0002¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"", "code", "", "Char", "(I)C", "getCode", "(C)I", "getCode$annotations", "(C)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class CharCodeKt {
    @JvmName(name = "getCode")
    private static final int getCode(char c) {
        return c;
    }

    public static /* synthetic */ void getCode$annotations(char c) {
    }

    private static final char Char(int i) {
        if (i < 0 || i > 65535) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid Char code: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        return (char) i;
    }
}
