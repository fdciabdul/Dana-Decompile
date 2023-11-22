package io.opentelemetry.sdk.metrics.internal.view;

import j$.util.function.Predicate;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: classes9.dex */
public final class StringPredicates {
    public static final Predicate<String> ALL = new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.StringPredicates$$ExternalSyntheticLambda2
        @Override // j$.util.function.Predicate
        public final /* synthetic */ Predicate and(Predicate predicate) {
            return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
        }

        @Override // j$.util.function.Predicate
        public final /* synthetic */ Predicate negate() {
            return Predicate.CC.PlaceComponentResult(this);
        }

        @Override // j$.util.function.Predicate
        public final /* synthetic */ Predicate or(Predicate predicate) {
            return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
        }

        @Override // j$.util.function.Predicate
        public final boolean test(Object obj) {
            return StringPredicates.lambda$static$0((String) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$static$0(String str) {
        return true;
    }

    private StringPredicates() {
    }

    public static Predicate<String> exact(final String str) {
        Objects.requireNonNull(str);
        return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.StringPredicates$$ExternalSyntheticLambda0
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equals((String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$regex$1(Pattern pattern, String str) {
        return str != null && pattern.matcher(str).matches();
    }

    public static Predicate<String> regex(final Pattern pattern) {
        return new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.view.StringPredicates$$ExternalSyntheticLambda1
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return StringPredicates.lambda$regex$1(pattern, (String) obj);
            }
        };
    }
}
