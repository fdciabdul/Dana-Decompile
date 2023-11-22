package io.opentelemetry.exporter.internal.marshal;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes9.dex */
public abstract class Marshaler {
    public abstract int getBinarySerializedSize();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void writeTo(Serializer serializer) throws IOException;

    public final void writeBinaryTo(OutputStream outputStream) throws IOException {
        ProtoSerializer protoSerializer = new ProtoSerializer(outputStream);
        try {
            writeTo(protoSerializer);
            protoSerializer.close();
        } catch (Throwable th) {
            try {
                protoSerializer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void writeJsonTo(OutputStream outputStream) throws IOException {
        JsonSerializer jsonSerializer = new JsonSerializer(outputStream);
        try {
            jsonSerializer.writeMessageValue(this);
            jsonSerializer.close();
        } catch (Throwable th) {
            try {
                jsonSerializer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void writeJsonTo(JsonGenerator jsonGenerator) throws IOException {
        JsonSerializer jsonSerializer = new JsonSerializer(jsonGenerator);
        try {
            jsonSerializer.writeMessageValue(this);
            jsonSerializer.close();
        } catch (Throwable th) {
            try {
                jsonSerializer.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
