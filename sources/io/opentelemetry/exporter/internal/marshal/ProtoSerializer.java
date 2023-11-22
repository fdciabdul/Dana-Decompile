package io.opentelemetry.exporter.internal.marshal;

import io.opentelemetry.api.internal.OtelEncodingUtils;
import io.opentelemetry.api.trace.SpanId;
import io.opentelemetry.api.trace.TraceId;
import j$.util.Map;
import j$.util.function.Function;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
final class ProtoSerializer extends Serializer implements AutoCloseable {
    private static final ThreadLocal<Map<String, byte[]>> THREAD_LOCAL_ID_CACHE = new ThreadLocal<>();
    private final Map<String, byte[]> idCache = getIdCache();
    private final CodedOutputStream output;

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeEndMessage() {
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeEndRepeatedPrimitive() {
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeEndRepeatedVarint() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoSerializer(OutputStream outputStream) {
        this.output = CodedOutputStream.newInstance(outputStream);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeTraceId(ProtoFieldInfo protoFieldInfo, String str) throws IOException {
        writeBytes(protoFieldInfo, (byte[]) Map.EL.BuiltInFictitiousFunctionClassFactory((java.util.Map) this.idCache, (Object) str, new Function() { // from class: io.opentelemetry.exporter.internal.marshal.ProtoSerializer$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                byte[] bytesFromBase16;
                bytesFromBase16 = OtelEncodingUtils.bytesFromBase16((String) obj, TraceId.getLength());
                return bytesFromBase16;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }));
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeSpanId(ProtoFieldInfo protoFieldInfo, String str) throws IOException {
        writeBytes(protoFieldInfo, (byte[]) Map.EL.BuiltInFictitiousFunctionClassFactory((java.util.Map) this.idCache, (Object) str, new Function() { // from class: io.opentelemetry.exporter.internal.marshal.ProtoSerializer$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                byte[] bytesFromBase16;
                bytesFromBase16 = OtelEncodingUtils.bytesFromBase16((String) obj, SpanId.getLength());
                return bytesFromBase16;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }));
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeBool(ProtoFieldInfo protoFieldInfo, boolean z) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeBoolNoTag(z);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeEnum(ProtoFieldInfo protoFieldInfo, ProtoEnumInfo protoEnumInfo) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeEnumNoTag(protoEnumInfo.getEnumNumber());
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeUint32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeUInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeSInt32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeSInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeint32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeInt64(ProtoFieldInfo protoFieldInfo, long j) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeInt64NoTag(j);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeFixed64(ProtoFieldInfo protoFieldInfo, long j) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeFixed64NoTag(j);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeFixed64Value(long j) throws IOException {
        this.output.writeFixed64NoTag(j);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeUInt64Value(long j) throws IOException {
        this.output.writeUInt64NoTag(j);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeFixed32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeFixed32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeDouble(ProtoFieldInfo protoFieldInfo, double d) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeDoubleNoTag(d);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeDoubleValue(double d) throws IOException {
        this.output.writeDoubleNoTag(d);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeString(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException {
        writeBytes(protoFieldInfo, bArr);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeBytes(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeByteArrayNoTag(bArr);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeStartMessage(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeUInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeStartRepeatedPrimitive(ProtoFieldInfo protoFieldInfo, int i, int i2) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeUInt32NoTag(i * i2);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeStartRepeatedVarint(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.output.writeUInt32NoTag(protoFieldInfo.getTag());
        this.output.writeUInt32NoTag(i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void serializeRepeatedMessage(ProtoFieldInfo protoFieldInfo, Marshaler[] marshalerArr) throws IOException {
        for (Marshaler marshaler : marshalerArr) {
            serializeMessage(protoFieldInfo, marshaler);
        }
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void serializeRepeatedMessage(ProtoFieldInfo protoFieldInfo, List<? extends Marshaler> list) throws IOException {
        Iterator<? extends Marshaler> it = list.iterator();
        while (it.hasNext()) {
            serializeMessage(protoFieldInfo, it.next());
        }
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeSerializedMessage(byte[] bArr, String str) throws IOException {
        this.output.writeRawBytes(bArr);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.output.flush();
        this.idCache.clear();
    }

    private static java.util.Map<String, byte[]> getIdCache() {
        ThreadLocal<java.util.Map<String, byte[]>> threadLocal = THREAD_LOCAL_ID_CACHE;
        java.util.Map<String, byte[]> map = threadLocal.get();
        if (map == null) {
            HashMap hashMap = new HashMap();
            threadLocal.set(hashMap);
            return hashMap;
        }
        return map;
    }
}
