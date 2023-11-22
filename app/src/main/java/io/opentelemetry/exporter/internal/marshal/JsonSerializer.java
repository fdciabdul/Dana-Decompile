package io.opentelemetry.exporter.internal.marshal;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
final class JsonSerializer extends Serializer {
    private static final JsonFactory JSON_FACTORY = new JsonFactory();
    private final JsonGenerator generator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonSerializer(OutputStream outputStream) throws IOException {
        this(JSON_FACTORY.createGenerator(outputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonSerializer(JsonGenerator jsonGenerator) {
        this.generator = jsonGenerator;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeTraceId(ProtoFieldInfo protoFieldInfo, String str) throws IOException {
        this.generator.writeStringField(protoFieldInfo.getJsonName(), str);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeSpanId(ProtoFieldInfo protoFieldInfo, String str) throws IOException {
        this.generator.writeStringField(protoFieldInfo.getJsonName(), str);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeBool(ProtoFieldInfo protoFieldInfo, boolean z) throws IOException {
        this.generator.writeBooleanField(protoFieldInfo.getJsonName(), z);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeEnum(ProtoFieldInfo protoFieldInfo, ProtoEnumInfo protoEnumInfo) throws IOException {
        this.generator.writeStringField(protoFieldInfo.getJsonName(), protoEnumInfo.getJsonName());
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeUint32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.generator.writeNumberField(protoFieldInfo.getJsonName(), i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeSInt32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.generator.writeNumberField(protoFieldInfo.getJsonName(), i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeint32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.generator.writeNumberField(protoFieldInfo.getJsonName(), i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeInt64(ProtoFieldInfo protoFieldInfo, long j) throws IOException {
        this.generator.writeStringField(protoFieldInfo.getJsonName(), Long.toString(j));
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeFixed64(ProtoFieldInfo protoFieldInfo, long j) throws IOException {
        this.generator.writeStringField(protoFieldInfo.getJsonName(), Long.toString(j));
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeFixed64Value(long j) throws IOException {
        this.generator.writeString(Long.toString(j));
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeUInt64Value(long j) throws IOException {
        this.generator.writeString(Long.toString(j));
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeFixed32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.generator.writeNumberField(protoFieldInfo.getJsonName(), i);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeDouble(ProtoFieldInfo protoFieldInfo, double d) throws IOException {
        this.generator.writeNumberField(protoFieldInfo.getJsonName(), d);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeDoubleValue(double d) throws IOException {
        this.generator.writeNumber(d);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeString(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException {
        this.generator.writeFieldName(protoFieldInfo.getJsonName());
        this.generator.writeString(new String(bArr, StandardCharsets.UTF_8));
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeBytes(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException {
        this.generator.writeBinaryField(protoFieldInfo.getJsonName(), bArr);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeStartMessage(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.generator.writeObjectFieldStart(protoFieldInfo.getJsonName());
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeEndMessage() throws IOException {
        this.generator.writeEndObject();
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeStartRepeatedPrimitive(ProtoFieldInfo protoFieldInfo, int i, int i2) throws IOException {
        this.generator.writeArrayFieldStart(protoFieldInfo.getJsonName());
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeEndRepeatedPrimitive() throws IOException {
        this.generator.writeEndArray();
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeStartRepeatedVarint(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        this.generator.writeArrayFieldStart(protoFieldInfo.getJsonName());
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    protected final void writeEndRepeatedVarint() throws IOException {
        this.generator.writeEndArray();
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void serializeRepeatedMessage(ProtoFieldInfo protoFieldInfo, Marshaler[] marshalerArr) throws IOException {
        this.generator.writeArrayFieldStart(protoFieldInfo.getJsonName());
        for (Marshaler marshaler : marshalerArr) {
            writeMessageValue(marshaler);
        }
        this.generator.writeEndArray();
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void serializeRepeatedMessage(ProtoFieldInfo protoFieldInfo, List<? extends Marshaler> list) throws IOException {
        this.generator.writeArrayFieldStart(protoFieldInfo.getJsonName());
        Iterator<? extends Marshaler> it = list.iterator();
        while (it.hasNext()) {
            writeMessageValue(it.next());
        }
        this.generator.writeEndArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void writeMessageValue(Marshaler marshaler) throws IOException {
        this.generator.writeStartObject();
        marshaler.writeTo(this);
        this.generator.writeEndObject();
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer
    public final void writeSerializedMessage(byte[] bArr, String str) throws IOException {
        this.generator.writeRaw(str);
    }

    @Override // io.opentelemetry.exporter.internal.marshal.Serializer, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.generator.close();
    }
}
