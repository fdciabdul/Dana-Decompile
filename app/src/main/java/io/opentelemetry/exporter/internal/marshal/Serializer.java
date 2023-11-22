package io.opentelemetry.exporter.internal.marshal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
public abstract class Serializer implements AutoCloseable {
    @Override // java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract void serializeRepeatedMessage(ProtoFieldInfo protoFieldInfo, List<? extends Marshaler> list) throws IOException;

    public abstract void serializeRepeatedMessage(ProtoFieldInfo protoFieldInfo, Marshaler[] marshalerArr) throws IOException;

    public abstract void writeBool(ProtoFieldInfo protoFieldInfo, boolean z) throws IOException;

    protected abstract void writeBytes(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException;

    public abstract void writeDouble(ProtoFieldInfo protoFieldInfo, double d) throws IOException;

    protected abstract void writeDoubleValue(double d) throws IOException;

    protected abstract void writeEndMessage() throws IOException;

    protected abstract void writeEndRepeatedPrimitive() throws IOException;

    protected abstract void writeEndRepeatedVarint() throws IOException;

    protected abstract void writeEnum(ProtoFieldInfo protoFieldInfo, ProtoEnumInfo protoEnumInfo) throws IOException;

    protected abstract void writeFixed32(ProtoFieldInfo protoFieldInfo, int i) throws IOException;

    protected abstract void writeFixed64(ProtoFieldInfo protoFieldInfo, long j) throws IOException;

    protected abstract void writeFixed64Value(long j) throws IOException;

    public abstract void writeInt64(ProtoFieldInfo protoFieldInfo, long j) throws IOException;

    protected abstract void writeSInt32(ProtoFieldInfo protoFieldInfo, int i) throws IOException;

    public abstract void writeSerializedMessage(byte[] bArr, String str) throws IOException;

    protected abstract void writeSpanId(ProtoFieldInfo protoFieldInfo, String str) throws IOException;

    protected abstract void writeStartMessage(ProtoFieldInfo protoFieldInfo, int i) throws IOException;

    protected abstract void writeStartRepeatedPrimitive(ProtoFieldInfo protoFieldInfo, int i, int i2) throws IOException;

    protected abstract void writeStartRepeatedVarint(ProtoFieldInfo protoFieldInfo, int i) throws IOException;

    public abstract void writeString(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException;

    protected abstract void writeTraceId(ProtoFieldInfo protoFieldInfo, String str) throws IOException;

    protected abstract void writeUInt64Value(long j) throws IOException;

    protected abstract void writeUint32(ProtoFieldInfo protoFieldInfo, int i) throws IOException;

    protected abstract void writeint32(ProtoFieldInfo protoFieldInfo, int i) throws IOException;

    public void serializeTraceId(ProtoFieldInfo protoFieldInfo, @Nullable String str) throws IOException {
        if (str == null) {
            return;
        }
        writeTraceId(protoFieldInfo, str);
    }

    public void serializeSpanId(ProtoFieldInfo protoFieldInfo, @Nullable String str) throws IOException {
        if (str == null) {
            return;
        }
        writeSpanId(protoFieldInfo, str);
    }

    public void serializeBool(ProtoFieldInfo protoFieldInfo, boolean z) throws IOException {
        if (z) {
            writeBool(protoFieldInfo, z);
        }
    }

    public void serializeEnum(ProtoFieldInfo protoFieldInfo, ProtoEnumInfo protoEnumInfo) throws IOException {
        if (protoEnumInfo.getEnumNumber() == 0) {
            return;
        }
        writeEnum(protoFieldInfo, protoEnumInfo);
    }

    public void serializeUInt32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        if (i == 0) {
            return;
        }
        writeUint32(protoFieldInfo, i);
    }

    public void serializeSInt32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        if (i == 0) {
            return;
        }
        writeSInt32(protoFieldInfo, i);
    }

    public void serializeInt32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        if (i == 0) {
            return;
        }
        writeint32(protoFieldInfo, i);
    }

    public void serializeInt64(ProtoFieldInfo protoFieldInfo, long j) throws IOException {
        if (j == 0) {
            return;
        }
        writeInt64(protoFieldInfo, j);
    }

    public void serializeFixed64(ProtoFieldInfo protoFieldInfo, long j) throws IOException {
        if (j == 0) {
            return;
        }
        writeFixed64(protoFieldInfo, j);
    }

    public void serializeFixed64Optional(ProtoFieldInfo protoFieldInfo, long j) throws IOException {
        writeFixed64(protoFieldInfo, j);
    }

    public void serializeFixed32(ProtoFieldInfo protoFieldInfo, int i) throws IOException {
        if (i == 0) {
            return;
        }
        writeFixed32(protoFieldInfo, i);
    }

    public void serializeDouble(ProtoFieldInfo protoFieldInfo, double d) throws IOException {
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return;
        }
        writeDouble(protoFieldInfo, d);
    }

    public void serializeDoubleOptional(ProtoFieldInfo protoFieldInfo, double d) throws IOException {
        writeDouble(protoFieldInfo, d);
    }

    public void serializeString(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException {
        if (bArr.length == 0) {
            return;
        }
        writeString(protoFieldInfo, bArr);
    }

    public void serializeBytes(ProtoFieldInfo protoFieldInfo, byte[] bArr) throws IOException {
        if (bArr.length == 0) {
            return;
        }
        writeBytes(protoFieldInfo, bArr);
    }

    public void serializeMessage(ProtoFieldInfo protoFieldInfo, Marshaler marshaler) throws IOException {
        writeStartMessage(protoFieldInfo, marshaler.getBinarySerializedSize());
        marshaler.writeTo(this);
        writeEndMessage();
    }

    public void serializeRepeatedFixed64(ProtoFieldInfo protoFieldInfo, List<Long> list) throws IOException {
        if (list.isEmpty()) {
            return;
        }
        writeStartRepeatedPrimitive(protoFieldInfo, 8, list.size());
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            writeFixed64Value(it.next().longValue());
        }
        writeEndRepeatedPrimitive();
    }

    public void serializeRepeatedFixed64(ProtoFieldInfo protoFieldInfo, long[] jArr) throws IOException {
        if (jArr.length == 0) {
            return;
        }
        writeStartRepeatedPrimitive(protoFieldInfo, 8, jArr.length);
        for (long j : jArr) {
            writeFixed64Value(j);
        }
        writeEndRepeatedPrimitive();
    }

    public void serializeRepeatedUInt64(ProtoFieldInfo protoFieldInfo, long[] jArr) throws IOException {
        if (jArr.length == 0) {
            return;
        }
        int i = 0;
        for (long j : jArr) {
            i += CodedOutputStream.computeUInt64SizeNoTag(j);
        }
        writeStartRepeatedVarint(protoFieldInfo, i);
        for (long j2 : jArr) {
            writeUInt64Value(j2);
        }
        writeEndRepeatedVarint();
    }

    public void serializeRepeatedDouble(ProtoFieldInfo protoFieldInfo, List<Double> list) throws IOException {
        if (list.isEmpty()) {
            return;
        }
        writeStartRepeatedPrimitive(protoFieldInfo, 8, list.size());
        Iterator<Double> it = list.iterator();
        while (it.hasNext()) {
            writeDoubleValue(it.next().doubleValue());
        }
        writeEndRepeatedPrimitive();
    }
}
