package zipkin2.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import zipkin2.Span;
import zipkin2.internal.SpanNode;

/* loaded from: classes9.dex */
public final class DependencyLinker {
    final Map<Pair, Long> KClassImpl$Data$declaredNonStaticMembers$2;
    final SpanNode.Builder MyBillsEntityDataFactory;
    final Logger PlaceComponentResult;
    final Map<Pair, Long> getAuthRequestContext;

    public DependencyLinker() {
        this(Logger.getLogger(DependencyLinker.class.getName()));
    }

    private DependencyLinker(Logger logger) {
        this.getAuthRequestContext = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.PlaceComponentResult = logger;
        this.MyBillsEntityDataFactory = SpanNode.PlaceComponentResult(logger);
    }

    /* renamed from: zipkin2.internal.DependencyLinker$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Span.Kind.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Span.Kind.SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Span.Kind.CONSUMER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Span.Kind.CLIENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[Span.Kind.PRODUCER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class Pair {
        final String KClassImpl$Data$declaredNonStaticMembers$2;
        final String MyBillsEntityDataFactory;

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                return this.MyBillsEntityDataFactory.equals(pair.MyBillsEntityDataFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2.equals(pair.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return false;
        }

        public final int hashCode() {
            return ((this.MyBillsEntityDataFactory.hashCode() ^ 1000003) * 1000003) ^ this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }
    }
}
