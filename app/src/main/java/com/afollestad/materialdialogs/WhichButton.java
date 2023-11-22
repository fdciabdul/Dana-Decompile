package com.afollestad.materialdialogs;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f"}, d2 = {"Lcom/afollestad/materialdialogs/WhichButton;", "", "", "index", "I", "getIndex", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "POSITIVE", "NEGATIVE", "NEUTRAL"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public enum WhichButton {
    POSITIVE(0),
    NEGATIVE(1),
    NEUTRAL(2);


    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int index;

    WhichButton(int i) {
        this.index = i;
    }

    @JvmName(name = "getIndex")
    public final int getIndex() {
        return this.index;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/afollestad/materialdialogs/WhichButton$Companion;", "", "", "index", "Lcom/afollestad/materialdialogs/WhichButton;", "fromIndex", "(I)Lcom/afollestad/materialdialogs/WhichButton;", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WhichButton fromIndex(int index) {
            if (index != 0) {
                if (index != 1) {
                    if (index == 2) {
                        return WhichButton.NEUTRAL;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(index);
                    sb.append(" is not an action button index.");
                    throw new IndexOutOfBoundsException(sb.toString());
                }
                return WhichButton.NEGATIVE;
            }
            return WhichButton.POSITIVE;
        }
    }
}
