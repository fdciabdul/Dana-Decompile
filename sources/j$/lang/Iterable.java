package j$.lang;

import j$.util.DesugarCollections;
import j$.util.function.Consumer;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface Iterable {

    /* renamed from: j$.lang.Iterable$-CC */
    /* loaded from: classes6.dex */
    public abstract /* synthetic */ class CC {
        public static /* synthetic */ int BuiltInFictitiousFunctionClassFactory(long j) {
            int i = (int) j;
            if (j == i) {
                return i;
            }
            throw new ArithmeticException();
        }

        public static /* synthetic */ long BuiltInFictitiousFunctionClassFactory(long j, long j2) {
            long j3 = j + j2;
            if (((j2 ^ j) < 0) || ((j ^ j3) >= 0)) {
                return j3;
            }
            throw new ArithmeticException();
        }

        public static /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2(long j, long j2) {
            long j3 = j % j2;
            if (j3 == 0) {
                return 0L;
            }
            return (((j ^ j2) >> 63) | 1) > 0 ? j3 : j3 + j2;
        }

        public static /* synthetic */ long MyBillsEntityDataFactory(long j, long j2) {
            long j3 = j - j2;
            if (((j2 ^ j) >= 0) || ((j ^ j3) >= 0)) {
                return j3;
            }
            throw new ArithmeticException();
        }

        public static /* synthetic */ long PlaceComponentResult(long j, long j2) {
            long j3 = j / j2;
            return (j - (j2 * j3) != 0 && (((j ^ j2) >> 63) | 1) < 0) ? j3 - 1 : j3;
        }

        public static /* synthetic */ long getAuthRequestContext(long j, long j2) {
            int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
            int numberOfLeadingZeros2 = Long.numberOfLeadingZeros((-1) ^ j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(j ^ (-1)) + numberOfLeadingZeros;
            if (numberOfLeadingZeros2 > 65) {
                return j * j2;
            }
            if (numberOfLeadingZeros2 >= 64) {
                if ((j2 != Long.MIN_VALUE) | (j >= 0)) {
                    long j3 = j * j2;
                    if (j == 0 || j3 / j == j2) {
                        return j3;
                    }
                }
            }
            throw new ArithmeticException();
        }
    }

    /* renamed from: j$.lang.Iterable$-EL */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class EL {
        public static void MyBillsEntityDataFactory(java.lang.Iterable iterable, Consumer consumer) {
            if (iterable instanceof Iterable) {
                ((Iterable) iterable).forEach(consumer);
            } else if (iterable instanceof Collection) {
                Iterator it = ((Collection) iterable).iterator();
                while (it.hasNext()) {
                    consumer.accept(it.next());
                }
            } else if (DesugarCollections.KClassImpl$Data$declaredNonStaticMembers$2.isInstance(iterable)) {
                DesugarCollections.KClassImpl$Data$declaredNonStaticMembers$2(iterable, consumer);
            } else {
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    consumer.accept(it2.next());
                }
            }
        }
    }

    void forEach(Consumer consumer);
}
