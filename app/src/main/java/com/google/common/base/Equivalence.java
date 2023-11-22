package com.google.common.base;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
public abstract class Equivalence<T> {
    protected abstract boolean doEquivalent(T t, T t2);

    protected abstract int doHash(T t);

    public final boolean equivalent(@CheckForNull T t, @CheckForNull T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return doEquivalent(t, t2);
    }

    public final int hash(@CheckForNull T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <F> Equivalence<F> onResultOf(Function<? super F, ? extends T> function) {
        return new FunctionalEquivalence(function, this);
    }

    public final <S extends T> Wrapper<S> wrap(@ParametricNullness S s) {
        return new Wrapper<>(s);
    }

    /* loaded from: classes7.dex */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        @ParametricNullness
        private final T reference;

        private Wrapper(Equivalence<? super T> equivalence, @ParametricNullness T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.reference = t;
        }

        @ParametricNullness
        public final T get() {
            return this.reference;
        }

        public final boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Wrapper) {
                Wrapper wrapper = (Wrapper) obj;
                if (this.equivalence.equals(wrapper.equivalence)) {
                    return this.equivalence.equivalent((T) this.reference, (T) wrapper.reference);
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            return this.equivalence.hash((T) this.reference);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.equivalence);
            sb.append(".wrap(");
            sb.append(this.reference);
            sb.append(")");
            return sb.toString();
        }
    }

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final Predicate<T> equivalentTo(@CheckForNull T t) {
        return new EquivalentToPredicate(this, t);
    }

    /* loaded from: classes7.dex */
    static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;
        @CheckForNull
        private final T target;

        EquivalentToPredicate(Equivalence<T> equivalence, @CheckForNull T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.target = t;
        }

        @Override // com.google.common.base.Predicate
        public final boolean apply(@CheckForNull T t) {
            return this.equivalence.equivalent(t, this.target);
        }

        @Override // com.google.common.base.Predicate
        public final boolean equals(@CheckForNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EquivalentToPredicate) {
                EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
                return this.equivalence.equals(equivalentToPredicate.equivalence) && Objects.equal(this.target, equivalentToPredicate.target);
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(this.equivalence, this.target);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.equivalence);
            sb.append(".equivalentTo(");
            sb.append(this.target);
            sb.append(")");
            return sb.toString();
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        @Override // com.google.common.base.Equivalence
        protected final boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        protected final int doHash(Object obj) {
            return obj.hashCode();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    /* loaded from: classes3.dex */
    static final class Identity extends Equivalence<Object> implements Serializable {
        private static final long serialVersionUID = 1;
        public static final byte[] MyBillsEntityDataFactory = {72, -11, 97, 122, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int PlaceComponentResult = 32;
        static final Identity INSTANCE = new Identity();

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0038). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r7, int r8, byte r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 4
                int r8 = r8 + 16
                int r7 = r7 + 105
                int r9 = r9 * 15
                int r9 = 18 - r9
                byte[] r0 = com.google.common.base.Equivalence.Identity.MyBillsEntityDataFactory
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r7 = r8
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                goto L38
            L1a:
                r3 = 0
            L1b:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r9 = r9 + 1
                if (r3 != r8) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                r4 = r0[r9]
                int r3 = r3 + 1
                r5 = r8
                r8 = r7
                r7 = r5
                r6 = r10
                r10 = r9
                r9 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r6
            L38:
                int r9 = -r9
                int r8 = r8 + r9
                int r8 = r8 + 2
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r7
                r7 = r5
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Equivalence.Identity.a(int, int, byte, java.lang.Object[]):void");
        }

        @Override // com.google.common.base.Equivalence
        protected final boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        Identity() {
        }

        @Override // com.google.common.base.Equivalence
        protected final int doHash(Object obj) {
            try {
                Object[] objArr = {obj};
                byte b = MyBillsEntityDataFactory[5];
                byte b2 = (byte) (b - 1);
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr3 = new Object[1];
                a(b3, b3, MyBillsEntityDataFactory[5], objArr3);
                return ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }
}
