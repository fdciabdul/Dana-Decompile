package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public class FlatBufferBuilder {
    int BuiltInFictitiousFunctionClassFactory;
    int DatabaseTableConfigUtil;
    int[] GetContactSyncConfig;
    ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean PlaceComponentResult;
    ByteBufferFactory getAuthRequestContext;
    final Utf8 getErrorConfigVersion;
    int[] initRecordTimeStamp;
    int lookAheadTest;
    boolean moveToNextValue;
    int scheduleImpl;

    /* loaded from: classes6.dex */
    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer getAuthRequestContext(int i);
    }

    private FlatBufferBuilder(ByteBufferFactory byteBufferFactory, Utf8 utf8) {
        this.BuiltInFictitiousFunctionClassFactory = 1;
        this.initRecordTimeStamp = null;
        this.DatabaseTableConfigUtil = 0;
        this.moveToNextValue = false;
        this.MyBillsEntityDataFactory = false;
        this.GetContactSyncConfig = new int[16];
        this.scheduleImpl = 0;
        this.lookAheadTest = 0;
        this.PlaceComponentResult = false;
        this.getAuthRequestContext = byteBufferFactory;
        ByteBuffer authRequestContext = byteBufferFactory.getAuthRequestContext(1024);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
        this.getErrorConfigVersion = utf8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext.capacity();
    }

    private FlatBufferBuilder(byte b) {
        this(HeapByteBufferFactory.KClassImpl$Data$declaredNonStaticMembers$2, Utf8.getAuthRequestContext());
    }

    public FlatBufferBuilder() {
        this((byte) 0);
    }

    /* loaded from: classes6.dex */
    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory KClassImpl$Data$declaredNonStaticMembers$2 = new HeapByteBufferFactory();

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public final ByteBuffer getAuthRequestContext(int i) {
            return ByteBuffer.allocate(1024).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    /* loaded from: classes6.dex */
    static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer getAuthRequestContext;

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.getAuthRequestContext.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }
}
