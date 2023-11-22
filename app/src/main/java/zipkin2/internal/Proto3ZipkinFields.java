package zipkin2.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipkin2.Annotation;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.internal.Proto3Fields;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class Proto3ZipkinFields {
    static final Logger PlaceComponentResult = Logger.getLogger(Proto3ZipkinFields.class.getName());
    static final SpanField BuiltInFictitiousFunctionClassFactory = new SpanField();

    Proto3ZipkinFields() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class EndpointField extends Proto3Fields.LengthDelimitedField<Endpoint> {
        static final Proto3Fields.Utf8Field moveToNextValue = new Proto3Fields.Utf8Field(10);
        static final Proto3Fields.BytesField getAuthRequestContext = new Proto3Fields.BytesField(18);
        static final Proto3Fields.BytesField PlaceComponentResult = new Proto3Fields.BytesField(26);
        static final Proto3Fields.VarintField lookAheadTest = new Proto3Fields.VarintField(32);

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory(Endpoint endpoint) {
            Endpoint endpoint2 = endpoint;
            Proto3Fields.Utf8Field utf8Field = moveToNextValue;
            String serviceName = endpoint2.serviceName();
            int MyBillsEntityDataFactory = serviceName == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(utf8Field.BuiltInFictitiousFunctionClassFactory(serviceName));
            Proto3Fields.BytesField bytesField = getAuthRequestContext;
            byte[] ipv4Bytes = endpoint2.ipv4Bytes();
            int MyBillsEntityDataFactory2 = ipv4Bytes == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(bytesField.BuiltInFictitiousFunctionClassFactory(ipv4Bytes));
            Proto3Fields.BytesField bytesField2 = PlaceComponentResult;
            byte[] ipv6Bytes = endpoint2.ipv6Bytes();
            return MyBillsEntityDataFactory + 0 + MyBillsEntityDataFactory2 + (ipv6Bytes == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(bytesField2.BuiltInFictitiousFunctionClassFactory(ipv6Bytes))) + Proto3Fields.VarintField.BuiltInFictitiousFunctionClassFactory(endpoint2.portAsInt());
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WriteBuffer writeBuffer, Endpoint endpoint) {
            Endpoint endpoint2 = endpoint;
            moveToNextValue.PlaceComponentResult(writeBuffer, endpoint2.serviceName());
            getAuthRequestContext.PlaceComponentResult(writeBuffer, endpoint2.ipv4Bytes());
            PlaceComponentResult.PlaceComponentResult(writeBuffer, endpoint2.ipv6Bytes());
            lookAheadTest.PlaceComponentResult(writeBuffer, endpoint2.portAsInt());
        }

        EndpointField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public final /* synthetic */ Endpoint MyBillsEntityDataFactory(ReadBuffer readBuffer, int i) {
            int BuiltInFictitiousFunctionClassFactory = readBuffer.BuiltInFictitiousFunctionClassFactory();
            Endpoint.Builder newBuilder = Endpoint.newBuilder();
            while (readBuffer.BuiltInFictitiousFunctionClassFactory() < BuiltInFictitiousFunctionClassFactory + i) {
                int scheduleImpl = readBuffer.scheduleImpl();
                r4 = null;
                String str = null;
                if (scheduleImpl == 10) {
                    Proto3Fields.Utf8Field utf8Field = moveToNextValue;
                    int scheduleImpl2 = readBuffer.scheduleImpl();
                    String MyBillsEntityDataFactory = scheduleImpl2 == 0 ? null : utf8Field.MyBillsEntityDataFactory(readBuffer, scheduleImpl2);
                    if (MyBillsEntityDataFactory != null && !MyBillsEntityDataFactory.isEmpty()) {
                        str = MyBillsEntityDataFactory.toLowerCase(Locale.ROOT);
                    }
                    newBuilder.lookAheadTest = str;
                } else if (scheduleImpl == 18) {
                    Proto3Fields.BytesField bytesField = getAuthRequestContext;
                    int scheduleImpl3 = readBuffer.scheduleImpl();
                    newBuilder.PlaceComponentResult(scheduleImpl3 != 0 ? bytesField.MyBillsEntityDataFactory(readBuffer, scheduleImpl3) : null);
                } else if (scheduleImpl == 26) {
                    Proto3Fields.BytesField bytesField2 = PlaceComponentResult;
                    int scheduleImpl4 = readBuffer.scheduleImpl();
                    newBuilder.PlaceComponentResult(scheduleImpl4 != 0 ? bytesField2.MyBillsEntityDataFactory(readBuffer, scheduleImpl4) : null);
                } else if (scheduleImpl == 32) {
                    newBuilder.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer.scheduleImpl());
                } else {
                    Proto3ZipkinFields.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer, scheduleImpl);
                }
            }
            return new Endpoint(newBuilder);
        }
    }

    /* loaded from: classes6.dex */
    static abstract class SpanBuilderField<T> extends Proto3Fields.LengthDelimitedField<T> {
        abstract boolean getAuthRequestContext(ReadBuffer readBuffer, Span.Builder builder);

        SpanBuilderField(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public final T MyBillsEntityDataFactory(ReadBuffer readBuffer, int i) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class AnnotationField extends SpanBuilderField<Annotation> {
        static final Proto3Fields.Fixed64Field getAuthRequestContext = new Proto3Fields.Fixed64Field(9);
        static final Proto3Fields.Utf8Field PlaceComponentResult = new Proto3Fields.Utf8Field(18);

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory(Object obj) {
            Annotation annotation = (Annotation) obj;
            int BuiltInFictitiousFunctionClassFactory = Proto3Fields.Fixed64Field.BuiltInFictitiousFunctionClassFactory(annotation.timestamp());
            Proto3Fields.Utf8Field utf8Field = PlaceComponentResult;
            String value = annotation.value();
            return BuiltInFictitiousFunctionClassFactory + (value == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(utf8Field.BuiltInFictitiousFunctionClassFactory(value)));
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WriteBuffer writeBuffer, Object obj) {
            Annotation annotation = (Annotation) obj;
            getAuthRequestContext.getAuthRequestContext(writeBuffer, annotation.timestamp());
            PlaceComponentResult.PlaceComponentResult(writeBuffer, annotation.value());
        }

        AnnotationField() {
            super(82);
        }

        @Override // zipkin2.internal.Proto3ZipkinFields.SpanBuilderField
        final boolean getAuthRequestContext(ReadBuffer readBuffer, Span.Builder builder) {
            int scheduleImpl = readBuffer.scheduleImpl();
            if (scheduleImpl == 0) {
                return false;
            }
            int BuiltInFictitiousFunctionClassFactory = readBuffer.BuiltInFictitiousFunctionClassFactory();
            long j = 0;
            String str = null;
            while (readBuffer.BuiltInFictitiousFunctionClassFactory() < BuiltInFictitiousFunctionClassFactory + scheduleImpl) {
                int scheduleImpl2 = readBuffer.scheduleImpl();
                if (scheduleImpl2 == 9) {
                    j = Proto3Fields.Fixed64Field.PlaceComponentResult(readBuffer);
                } else if (scheduleImpl2 == 18) {
                    Proto3Fields.Utf8Field utf8Field = PlaceComponentResult;
                    int scheduleImpl3 = readBuffer.scheduleImpl();
                    str = scheduleImpl3 == 0 ? null : utf8Field.MyBillsEntityDataFactory(readBuffer, scheduleImpl3);
                } else {
                    Proto3ZipkinFields.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer, scheduleImpl2);
                }
            }
            if (j == 0 || str == null) {
                return false;
            }
            builder.KClassImpl$Data$declaredNonStaticMembers$2(j, str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class TagField extends SpanBuilderField<Map.Entry<String, String>> {
        static final Proto3Fields.Utf8Field getAuthRequestContext = new Proto3Fields.Utf8Field(10);
        static final Proto3Fields.Utf8Field PlaceComponentResult = new Proto3Fields.Utf8Field(18);

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Proto3Fields.Utf8Field utf8Field = getAuthRequestContext;
            Object key = entry.getKey();
            int MyBillsEntityDataFactory = key == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(utf8Field.BuiltInFictitiousFunctionClassFactory(key));
            Proto3Fields.Utf8Field utf8Field2 = PlaceComponentResult;
            Object value = entry.getValue();
            return MyBillsEntityDataFactory + (value != null ? Proto3Fields.MyBillsEntityDataFactory(utf8Field2.BuiltInFictitiousFunctionClassFactory(value)) : 0);
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WriteBuffer writeBuffer, Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            getAuthRequestContext.PlaceComponentResult(writeBuffer, entry.getKey());
            PlaceComponentResult.PlaceComponentResult(writeBuffer, entry.getValue());
        }

        TagField() {
            super(90);
        }

        @Override // zipkin2.internal.Proto3ZipkinFields.SpanBuilderField
        final boolean getAuthRequestContext(ReadBuffer readBuffer, Span.Builder builder) {
            int scheduleImpl = readBuffer.scheduleImpl();
            if (scheduleImpl == 0) {
                return false;
            }
            int BuiltInFictitiousFunctionClassFactory = readBuffer.BuiltInFictitiousFunctionClassFactory();
            String str = "";
            String str2 = null;
            while (readBuffer.BuiltInFictitiousFunctionClassFactory() < BuiltInFictitiousFunctionClassFactory + scheduleImpl) {
                int scheduleImpl2 = readBuffer.scheduleImpl();
                if (scheduleImpl2 == 10) {
                    Proto3Fields.Utf8Field utf8Field = getAuthRequestContext;
                    int scheduleImpl3 = readBuffer.scheduleImpl();
                    str2 = scheduleImpl3 == 0 ? null : utf8Field.MyBillsEntityDataFactory(readBuffer, scheduleImpl3);
                } else if (scheduleImpl2 == 18) {
                    Proto3Fields.Utf8Field utf8Field2 = PlaceComponentResult;
                    int scheduleImpl4 = readBuffer.scheduleImpl();
                    String MyBillsEntityDataFactory = scheduleImpl4 == 0 ? null : utf8Field2.MyBillsEntityDataFactory(readBuffer, scheduleImpl4);
                    if (MyBillsEntityDataFactory != null) {
                        str = MyBillsEntityDataFactory;
                    }
                } else {
                    Proto3ZipkinFields.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer, scheduleImpl2);
                }
            }
            if (str2 == null) {
                return false;
            }
            builder.PlaceComponentResult(str2, str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SpanField extends Proto3Fields.LengthDelimitedField<Span> {
        static final Proto3Fields.HexField PrepareContext = new Proto3Fields.HexField(10);
        static final Proto3Fields.HexField GetContactSyncConfig = new Proto3Fields.HexField(18);
        static final Proto3Fields.HexField getErrorConfigVersion = new Proto3Fields.HexField(26);
        static final Proto3Fields.VarintField scheduleImpl = new Proto3Fields.VarintField(32);
        static final Proto3Fields.Utf8Field lookAheadTest = new Proto3Fields.Utf8Field(42);
        static final Proto3Fields.Fixed64Field NetworkUserEntityData$$ExternalSyntheticLambda2 = new Proto3Fields.Fixed64Field(49);
        static final Proto3Fields.VarintField NetworkUserEntityData$$ExternalSyntheticLambda0 = new Proto3Fields.VarintField(56);
        static final EndpointField moveToNextValue = new EndpointField(66);
        static final EndpointField DatabaseTableConfigUtil = new EndpointField(74);
        static final AnnotationField PlaceComponentResult = new AnnotationField();
        static final TagField NetworkUserEntityData$$ExternalSyntheticLambda1 = new TagField();
        static final Proto3Fields.BooleanField getAuthRequestContext = new Proto3Fields.BooleanField(96);
        static final Proto3Fields.BooleanField initRecordTimeStamp = new Proto3Fields.BooleanField(104);

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory(Span span) {
            return PlaceComponentResult(span);
        }

        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WriteBuffer writeBuffer, Span span) {
            KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer, span);
        }

        SpanField() {
            super(10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int PlaceComponentResult(Span span) {
            Proto3Fields.HexField hexField = PrepareContext;
            String traceId = span.traceId();
            int MyBillsEntityDataFactory = traceId == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(hexField.BuiltInFictitiousFunctionClassFactory(traceId));
            Proto3Fields.HexField hexField2 = GetContactSyncConfig;
            String parentId = span.parentId();
            int MyBillsEntityDataFactory2 = parentId == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(hexField2.BuiltInFictitiousFunctionClassFactory(parentId));
            Proto3Fields.HexField hexField3 = getErrorConfigVersion;
            String id2 = span.id();
            int MyBillsEntityDataFactory3 = id2 == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(hexField3.BuiltInFictitiousFunctionClassFactory(id2));
            int BuiltInFictitiousFunctionClassFactory = Proto3Fields.VarintField.BuiltInFictitiousFunctionClassFactory(span.kind() != null ? 1 : 0);
            Proto3Fields.Utf8Field utf8Field = lookAheadTest;
            String name = span.name();
            int MyBillsEntityDataFactory4 = name == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(utf8Field.BuiltInFictitiousFunctionClassFactory(name));
            int BuiltInFictitiousFunctionClassFactory2 = Proto3Fields.Fixed64Field.BuiltInFictitiousFunctionClassFactory(span.timestampAsLong());
            int authRequestContext = Proto3Fields.VarintField.getAuthRequestContext(span.durationAsLong());
            EndpointField endpointField = moveToNextValue;
            Endpoint localEndpoint = span.localEndpoint();
            int MyBillsEntityDataFactory5 = MyBillsEntityDataFactory + MyBillsEntityDataFactory2 + MyBillsEntityDataFactory3 + BuiltInFictitiousFunctionClassFactory + MyBillsEntityDataFactory4 + BuiltInFictitiousFunctionClassFactory2 + authRequestContext + (localEndpoint == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(endpointField.BuiltInFictitiousFunctionClassFactory(localEndpoint)));
            EndpointField endpointField2 = DatabaseTableConfigUtil;
            Endpoint remoteEndpoint = span.remoteEndpoint();
            int MyBillsEntityDataFactory6 = MyBillsEntityDataFactory5 + (remoteEndpoint == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(endpointField2.BuiltInFictitiousFunctionClassFactory(remoteEndpoint)));
            List<Annotation> annotations = span.annotations();
            int size = annotations.size();
            for (int i = 0; i < size; i++) {
                AnnotationField annotationField = PlaceComponentResult;
                Annotation annotation = annotations.get(i);
                MyBillsEntityDataFactory6 += annotation == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(annotationField.BuiltInFictitiousFunctionClassFactory(annotation));
            }
            Map<String, String> tags = span.tags();
            if (tags.size() > 0) {
                Iterator<Map.Entry<String, String>> it = tags.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    MyBillsEntityDataFactory6 += next == null ? 0 : Proto3Fields.MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(next));
                }
            }
            return MyBillsEntityDataFactory6 + Proto3Fields.BooleanField.KClassImpl$Data$declaredNonStaticMembers$2(Boolean.TRUE.equals(span.debug())) + Proto3Fields.BooleanField.KClassImpl$Data$declaredNonStaticMembers$2(Boolean.TRUE.equals(span.shared()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static void KClassImpl$Data$declaredNonStaticMembers$2(WriteBuffer writeBuffer, Span span) {
            PrepareContext.PlaceComponentResult(writeBuffer, span.traceId());
            GetContactSyncConfig.PlaceComponentResult(writeBuffer, span.parentId());
            getErrorConfigVersion.PlaceComponentResult(writeBuffer, span.id());
            Proto3Fields.VarintField varintField = scheduleImpl;
            Span.Kind kind = span.kind();
            varintField.PlaceComponentResult(writeBuffer, kind != null ? kind.ordinal() + 1 : 0);
            lookAheadTest.PlaceComponentResult(writeBuffer, span.name());
            NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext(writeBuffer, span.timestampAsLong());
            NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(writeBuffer, span.durationAsLong());
            moveToNextValue.PlaceComponentResult(writeBuffer, span.localEndpoint());
            DatabaseTableConfigUtil.PlaceComponentResult(writeBuffer, span.remoteEndpoint());
            List<Annotation> annotations = span.annotations();
            int size = annotations.size();
            for (int i = 0; i < size; i++) {
                PlaceComponentResult.PlaceComponentResult(writeBuffer, annotations.get(i));
            }
            Map<String, String> tags = span.tags();
            if (!tags.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = tags.entrySet().iterator();
                while (it.hasNext()) {
                    NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult(writeBuffer, it.next());
                }
            }
            getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(writeBuffer, Boolean.TRUE.equals(span.debug()));
            initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(writeBuffer, Boolean.TRUE.equals(span.shared()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // zipkin2.internal.Proto3Fields.LengthDelimitedField
        public final /* synthetic */ Span MyBillsEntityDataFactory(ReadBuffer readBuffer, int i) {
            long j;
            readBuffer.KClassImpl$Data$declaredNonStaticMembers$2(i);
            int BuiltInFictitiousFunctionClassFactory = readBuffer.BuiltInFictitiousFunctionClassFactory();
            Span.Builder newBuilder = Span.newBuilder();
            while (readBuffer.BuiltInFictitiousFunctionClassFactory() < BuiltInFictitiousFunctionClassFactory + i) {
                int scheduleImpl2 = readBuffer.scheduleImpl();
                r6 = null;
                String str = null;
                switch (scheduleImpl2) {
                    case 10:
                        Proto3Fields.HexField hexField = PrepareContext;
                        int scheduleImpl3 = readBuffer.scheduleImpl();
                        newBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = Span.normalizeTraceId(scheduleImpl3 != 0 ? hexField.MyBillsEntityDataFactory(readBuffer, scheduleImpl3) : null);
                        break;
                    case 18:
                        Proto3Fields.HexField hexField2 = GetContactSyncConfig;
                        int scheduleImpl4 = readBuffer.scheduleImpl();
                        newBuilder.PlaceComponentResult(scheduleImpl4 != 0 ? hexField2.MyBillsEntityDataFactory(readBuffer, scheduleImpl4) : null);
                        break;
                    case 26:
                        Proto3Fields.HexField hexField3 = getErrorConfigVersion;
                        int scheduleImpl5 = readBuffer.scheduleImpl();
                        newBuilder.KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl5 != 0 ? hexField3.MyBillsEntityDataFactory(readBuffer, scheduleImpl5) : null);
                        break;
                    case 32:
                        int scheduleImpl6 = readBuffer.scheduleImpl();
                        if (scheduleImpl6 != 0 && scheduleImpl6 <= Span.Kind.values().length) {
                            newBuilder.KClassImpl$Data$declaredNonStaticMembers$2 = Span.Kind.values()[scheduleImpl6 - 1];
                            break;
                        }
                        break;
                    case 42:
                        Proto3Fields.Utf8Field utf8Field = lookAheadTest;
                        int scheduleImpl7 = readBuffer.scheduleImpl();
                        String MyBillsEntityDataFactory = scheduleImpl7 == 0 ? null : utf8Field.MyBillsEntityDataFactory(readBuffer, scheduleImpl7);
                        if (MyBillsEntityDataFactory != null && !MyBillsEntityDataFactory.isEmpty()) {
                            str = MyBillsEntityDataFactory.toLowerCase(Locale.ROOT);
                        }
                        newBuilder.scheduleImpl = str;
                        break;
                    case 49:
                        long PlaceComponentResult2 = Proto3Fields.Fixed64Field.PlaceComponentResult(readBuffer);
                        newBuilder.NetworkUserEntityData$$ExternalSyntheticLambda1 = PlaceComponentResult2 >= 0 ? PlaceComponentResult2 : 0L;
                        break;
                    case 56:
                        int MyBillsEntityDataFactory2 = readBuffer.MyBillsEntityDataFactory();
                        if (MyBillsEntityDataFactory2 >= 0) {
                            j = MyBillsEntityDataFactory2;
                        } else {
                            long j2 = MyBillsEntityDataFactory2 & 127;
                            for (int i2 = 1; MyBillsEntityDataFactory2 < 0 && i2 < 10; i2++) {
                                MyBillsEntityDataFactory2 = readBuffer.MyBillsEntityDataFactory();
                                if (i2 == 9 && (MyBillsEntityDataFactory2 & 240) != 0) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Greater than 64-bit varint at position ");
                                    sb.append(readBuffer.BuiltInFictitiousFunctionClassFactory() - 1);
                                    throw new IllegalArgumentException(sb.toString());
                                }
                                j2 |= (MyBillsEntityDataFactory2 & 127) << (i2 * 7);
                            }
                            j = j2;
                        }
                        newBuilder.getAuthRequestContext = j >= 0 ? j : 0L;
                        break;
                    case 66:
                        EndpointField endpointField = moveToNextValue;
                        int scheduleImpl8 = readBuffer.scheduleImpl();
                        Endpoint MyBillsEntityDataFactory3 = scheduleImpl8 == 0 ? null : endpointField.MyBillsEntityDataFactory(readBuffer, scheduleImpl8);
                        newBuilder.getErrorConfigVersion = Span.EMPTY_ENDPOINT.equals(MyBillsEntityDataFactory3) ? null : MyBillsEntityDataFactory3;
                        break;
                    case 74:
                        EndpointField endpointField2 = DatabaseTableConfigUtil;
                        int scheduleImpl9 = readBuffer.scheduleImpl();
                        Endpoint MyBillsEntityDataFactory4 = scheduleImpl9 == 0 ? null : endpointField2.MyBillsEntityDataFactory(readBuffer, scheduleImpl9);
                        newBuilder.NetworkUserEntityData$$ExternalSyntheticLambda0 = Span.EMPTY_ENDPOINT.equals(MyBillsEntityDataFactory4) ? null : MyBillsEntityDataFactory4;
                        break;
                    case 82:
                        PlaceComponentResult.getAuthRequestContext(readBuffer, newBuilder);
                        break;
                    case 90:
                        NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(readBuffer, newBuilder);
                        break;
                    case 96:
                        if (Proto3Fields.BooleanField.getAuthRequestContext(readBuffer)) {
                            newBuilder.getAuthRequestContext(true);
                            break;
                        } else {
                            break;
                        }
                    case 104:
                        if (Proto3Fields.BooleanField.getAuthRequestContext(readBuffer)) {
                            int i3 = newBuilder.BuiltInFictitiousFunctionClassFactory | 16;
                            newBuilder.BuiltInFictitiousFunctionClassFactory = i3;
                            newBuilder.BuiltInFictitiousFunctionClassFactory = i3 | 8;
                            break;
                        } else {
                            break;
                        }
                    default:
                        Proto3ZipkinFields.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer, scheduleImpl2);
                        break;
                }
            }
            return newBuilder.getAuthRequestContext();
        }
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2(ReadBuffer readBuffer, int i) {
        int authRequestContext = Proto3Fields.Field.getAuthRequestContext(i, readBuffer.BuiltInFictitiousFunctionClassFactory());
        Logger logger = PlaceComponentResult;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("Skipping field: byte=%s, fieldNumber=%s, wireType=%s", Integer.valueOf(readBuffer.BuiltInFictitiousFunctionClassFactory()), Integer.valueOf(Proto3Fields.Field.BuiltInFictitiousFunctionClassFactory(i, readBuffer.BuiltInFictitiousFunctionClassFactory())), Integer.valueOf(authRequestContext)));
        }
        Proto3Fields.Field.getAuthRequestContext(readBuffer, authRequestContext);
    }
}
