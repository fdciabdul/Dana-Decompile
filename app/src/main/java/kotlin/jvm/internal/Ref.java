package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Ref {
    private Ref() {
    }

    /* loaded from: classes.dex */
    public static final class ObjectRef<T> implements Serializable {
        public T element;

        public final String toString() {
            return String.valueOf(this.element);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ByteRef implements Serializable {
        public byte element;

        public final String toString() {
            return String.valueOf((int) this.element);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ShortRef implements Serializable {
        public short element;

        public final String toString() {
            return String.valueOf((int) this.element);
        }
    }

    /* loaded from: classes2.dex */
    public static final class IntRef implements Serializable {
        public int element;

        public final String toString() {
            return String.valueOf(this.element);
        }
    }

    /* loaded from: classes2.dex */
    public static final class LongRef implements Serializable {
        public long element;

        public final String toString() {
            return String.valueOf(this.element);
        }
    }

    /* loaded from: classes2.dex */
    public static final class FloatRef implements Serializable {
        public float element;

        public final String toString() {
            return String.valueOf(this.element);
        }
    }

    /* loaded from: classes2.dex */
    public static final class DoubleRef implements Serializable {
        public double element;

        public final String toString() {
            return String.valueOf(this.element);
        }
    }

    /* loaded from: classes2.dex */
    public static final class CharRef implements Serializable {
        public char element;

        public final String toString() {
            return String.valueOf(this.element);
        }
    }

    /* loaded from: classes.dex */
    public static final class BooleanRef implements Serializable {
        public boolean element;

        public final String toString() {
            return String.valueOf(this.element);
        }
    }
}
