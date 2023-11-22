package zipkin2.v1;

import java.util.Locale;
import java.util.Map;
import zipkin2.Annotation;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.internal.HexCodec;
import zipkin2.v1.V1Span;

/* loaded from: classes6.dex */
public final class V2SpanConverter {
    final V1Span.Builder MyBillsEntityDataFactory = V1Span.KClassImpl$Data$declaredNonStaticMembers$2();
    final V1SpanMetadata PlaceComponentResult = new V1SpanMetadata();

    public static V2SpanConverter BuiltInFictitiousFunctionClassFactory() {
        return new V2SpanConverter();
    }

    public final V1Span getAuthRequestContext(Span span) {
        this.PlaceComponentResult.MyBillsEntityDataFactory(span);
        V1Span.Builder KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(span.traceId());
        String parentId = span.parentId();
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = parentId != null ? HexCodec.BuiltInFictitiousFunctionClassFactory(parentId) : 0L;
        String id2 = span.id();
        if (id2 == null) {
            throw new NullPointerException("id == null");
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = HexCodec.BuiltInFictitiousFunctionClassFactory(id2);
        String name = span.name();
        KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (name == null || name.isEmpty()) ? null : name.toLowerCase(Locale.ROOT);
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = span.debug();
        if (!Boolean.TRUE.equals(span.shared())) {
            this.MyBillsEntityDataFactory.moveToNextValue = span.timestampAsLong();
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory = span.durationAsLong();
        }
        boolean z = false;
        boolean z2 = (this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0 || this.PlaceComponentResult.MyBillsEntityDataFactory == null) ? false : true;
        boolean z3 = (this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == 0 || this.PlaceComponentResult.getAuthRequestContext == null) ? false : true;
        Endpoint localEndpoint = span.localEndpoint();
        int size = span.annotations().size();
        if (z2) {
            size++;
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult.MyBillsEntityDataFactory, localEndpoint);
        }
        int size2 = span.annotations().size();
        for (int i = 0; i < size2; i++) {
            Annotation annotation = span.annotations().get(i);
            if ((!z2 || !annotation.value().equals(this.PlaceComponentResult.MyBillsEntityDataFactory)) && (!z3 || !annotation.value().equals(this.PlaceComponentResult.getAuthRequestContext))) {
                this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(annotation.timestamp(), annotation.value(), localEndpoint);
            }
        }
        if (z3) {
            size++;
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult.getAuthRequestContext, localEndpoint);
        }
        for (Map.Entry<String, String> entry : span.tags().entrySet()) {
            this.MyBillsEntityDataFactory.getAuthRequestContext(entry.getKey(), entry.getValue(), localEndpoint);
        }
        boolean z4 = size == 0 && localEndpoint != null && span.tags().isEmpty();
        if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 != null && span.remoteEndpoint() != null) {
            z = true;
        }
        if (z4) {
            this.MyBillsEntityDataFactory.getAuthRequestContext("lc", "", localEndpoint);
        }
        if (z) {
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, span.remoteEndpoint());
        }
        return new V1Span(this.MyBillsEntityDataFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class V1SpanMetadata {
        long BuiltInFictitiousFunctionClassFactory;
        String KClassImpl$Data$declaredNonStaticMembers$2;
        String MyBillsEntityDataFactory;
        long NetworkUserEntityData$$ExternalSyntheticLambda0;
        long PlaceComponentResult;
        String getAuthRequestContext;
        long getErrorConfigVersion;
        long moveToNextValue;
        long scheduleImpl;

        V1SpanMetadata() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x0145, code lost:
        
            if (r5 < r1) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x015b, code lost:
        
            if (r5 > r1) goto L73;
         */
        /* JADX WARN: Code restructure failed: missing block: B:87:0x0196, code lost:
        
            if (r5 < r1) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x01ac, code lost:
        
            if (r5 > r1) goto L95;
         */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0169  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x01a4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final void MyBillsEntityDataFactory(zipkin2.Span r17) {
            /*
                Method dump skipped, instructions count: 460
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: zipkin2.v1.V2SpanConverter.V1SpanMetadata.MyBillsEntityDataFactory(zipkin2.Span):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: zipkin2.v1.V2SpanConverter$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Span.Kind.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Span.Kind.CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Span.Kind.SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Span.Kind.PRODUCER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Span.Kind.CONSUMER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    V2SpanConverter() {
    }
}
