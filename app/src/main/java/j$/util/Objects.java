package j$.util;

import j$.util.Comparator;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;

/* loaded from: classes.dex */
public abstract class Objects {
    public static /* synthetic */ java.util.Comparator BuiltInFictitiousFunctionClassFactory(java.util.Comparator comparator, java.util.Comparator comparator2) {
        return comparator instanceof Comparator ? ((Comparator) comparator).thenComparing(comparator2) : Comparator.CC.KClassImpl$Data$declaredNonStaticMembers$2(comparator, comparator2);
    }

    public static void BuiltInFictitiousFunctionClassFactory(Spliterator.OfInt ofInt, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            ofInt.KClassImpl$Data$declaredNonStaticMembers$2((IntConsumer) consumer);
        } else if (Tripwire.MyBillsEntityDataFactory) {
            Tripwire.MyBillsEntityDataFactory(ofInt.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
            throw null;
        } else {
            ofInt.KClassImpl$Data$declaredNonStaticMembers$2(new PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(consumer));
        }
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Spliterator.OfDouble ofDouble, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            return ofDouble.MyBillsEntityDataFactory((DoubleConsumer) consumer);
        }
        if (Tripwire.MyBillsEntityDataFactory) {
            Tripwire.MyBillsEntityDataFactory(ofDouble.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
            throw null;
        }
        return ofDouble.MyBillsEntityDataFactory(new PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(consumer));
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Spliterator spliterator, int i) {
        return (spliterator.BuiltInFictitiousFunctionClassFactory() & i) == i;
    }

    public static boolean MyBillsEntityDataFactory(Spliterator.OfInt ofInt, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            return ofInt.MyBillsEntityDataFactory((IntConsumer) consumer);
        }
        if (Tripwire.MyBillsEntityDataFactory) {
            Tripwire.MyBillsEntityDataFactory(ofInt.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
            throw null;
        }
        return ofInt.MyBillsEntityDataFactory((IntConsumer) new PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(consumer));
    }

    public static boolean MyBillsEntityDataFactory(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void PlaceComponentResult(Spliterator.OfDouble ofDouble, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            ofDouble.KClassImpl$Data$declaredNonStaticMembers$2((DoubleConsumer) consumer);
        } else if (Tripwire.MyBillsEntityDataFactory) {
            Tripwire.MyBillsEntityDataFactory(ofDouble.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
            throw null;
        } else {
            ofDouble.KClassImpl$Data$declaredNonStaticMembers$2(new PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(consumer));
        }
    }

    public static boolean PlaceComponentResult(Spliterator.OfLong ofLong, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            return ofLong.MyBillsEntityDataFactory((LongConsumer) consumer);
        }
        if (Tripwire.MyBillsEntityDataFactory) {
            Tripwire.MyBillsEntityDataFactory(ofLong.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
            throw null;
        }
        return ofLong.MyBillsEntityDataFactory(new PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(consumer));
    }

    public static long getAuthRequestContext(Spliterator spliterator) {
        if ((spliterator.BuiltInFictitiousFunctionClassFactory() & 64) == 0) {
            return -1L;
        }
        return spliterator.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static void getAuthRequestContext(Spliterator.OfLong ofLong, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            ofLong.KClassImpl$Data$declaredNonStaticMembers$2((LongConsumer) consumer);
        } else if (Tripwire.MyBillsEntityDataFactory) {
            Tripwire.MyBillsEntityDataFactory(ofLong.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
            throw null;
        } else {
            ofLong.KClassImpl$Data$declaredNonStaticMembers$2(new PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(consumer));
        }
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        return 16448;
    }

    public final long KClassImpl$Data$declaredNonStaticMembers$2() {
        return 0L;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
    }

    public final Spliterator MyBillsEntityDataFactory() {
        return null;
    }

    public final boolean MyBillsEntityDataFactory(Object obj) {
        return false;
    }
}
