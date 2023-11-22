package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class Position implements Serializable {
    public static final Companion Companion = new Companion(null);
    private static final Position NO_POSITION = new Position(-1, -1);
    private final int column;
    private final int line;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Position) {
            Position position = (Position) obj;
            return this.line == position.line && this.column == position.column;
        }
        return false;
    }

    public final int hashCode() {
        return (this.line * 31) + this.column;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Position(line=");
        sb.append(this.line);
        sb.append(", column=");
        sb.append(this.column);
        sb.append(')');
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Position getNO_POSITION() {
            return Position.NO_POSITION;
        }
    }

    public Position(int i, int i2) {
        this.line = i;
        this.column = i2;
    }
}
