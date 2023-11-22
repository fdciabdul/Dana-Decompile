package j$.util;

import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;

/* loaded from: classes2.dex */
public interface Comparator<T> {

    /* renamed from: j$.util.Comparator$-CC */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC<T> {
        public static <T extends Comparable<? super T>> java.util.Comparator<T> BuiltInFictitiousFunctionClassFactory() {
            return Comparators$NaturalOrderComparator.INSTANCE;
        }

        public static java.util.Comparator BuiltInFictitiousFunctionClassFactory(java.util.Comparator comparator, Function function, java.util.Comparator comparator2) {
            return Objects.BuiltInFictitiousFunctionClassFactory(comparator, new Comparator$$ExternalSyntheticLambda1(comparator2, function, 1));
        }

        public static java.util.Comparator KClassImpl$Data$declaredNonStaticMembers$2(java.util.Comparator comparator, java.util.Comparator comparator2) {
            return new Comparator$$ExternalSyntheticLambda1(comparator, comparator2, 0);
        }

        public static java.util.Comparator MyBillsEntityDataFactory(java.util.Comparator comparator, ToDoubleFunction toDoubleFunction) {
            return Objects.BuiltInFictitiousFunctionClassFactory(comparator, new Comparator$$ExternalSyntheticLambda0(0, toDoubleFunction));
        }

        public static java.util.Comparator PlaceComponentResult(java.util.Comparator comparator, ToIntFunction toIntFunction) {
            return Objects.BuiltInFictitiousFunctionClassFactory(comparator, new Comparator$$ExternalSyntheticLambda0(1, toIntFunction));
        }

        public static java.util.Comparator PlaceComponentResult(java.util.Comparator comparator, ToLongFunction toLongFunction) {
            return Objects.BuiltInFictitiousFunctionClassFactory(comparator, new Comparator$$ExternalSyntheticLambda0(2, toLongFunction));
        }

        public static <T, U extends Comparable<? super U>> java.util.Comparator<T> comparing(Function<? super T, ? extends U> function) {
            return new Comparator$$ExternalSyntheticLambda0(3, function);
        }

        public static <T> java.util.Comparator<T> getAuthRequestContext(ToLongFunction<? super T> toLongFunction) {
            return new Comparator$$ExternalSyntheticLambda0(2, toLongFunction);
        }

        public static java.util.Comparator getAuthRequestContext(java.util.Comparator comparator, Function function) {
            return Objects.BuiltInFictitiousFunctionClassFactory(comparator, comparing(function));
        }
    }

    java.util.Comparator<T> thenComparing(java.util.Comparator<? super T> comparator);
}
