package androidx.emoji.text;

import androidx.text.emoji.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* loaded from: classes6.dex */
class MetadataListReader {

    /* loaded from: classes6.dex */
    interface OpenTypeReader {
        int BuiltInFictitiousFunctionClassFactory() throws IOException;

        int MyBillsEntityDataFactory() throws IOException;

        void MyBillsEntityDataFactory(int i) throws IOException;

        long PlaceComponentResult() throws IOException;

        long getAuthRequestContext();
    }

    static int BuiltInFictitiousFunctionClassFactory(short s) {
        return s & UShort.MAX_VALUE;
    }

    static long PlaceComponentResult(int i) {
        return i & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataList PlaceComponentResult(ByteBuffer byteBuffer) throws IOException {
        long j;
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBufferReader byteBufferReader = new ByteBufferReader(duplicate);
        byteBufferReader.MyBillsEntityDataFactory(4);
        int MyBillsEntityDataFactory = byteBufferReader.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferReader.MyBillsEntityDataFactory(6);
        int i = 0;
        while (true) {
            if (i >= MyBillsEntityDataFactory) {
                j = -1;
                break;
            }
            int BuiltInFictitiousFunctionClassFactory = byteBufferReader.BuiltInFictitiousFunctionClassFactory();
            byteBufferReader.MyBillsEntityDataFactory(4);
            j = byteBufferReader.PlaceComponentResult();
            byteBufferReader.MyBillsEntityDataFactory(4);
            if (1835365473 == BuiltInFictitiousFunctionClassFactory) {
                break;
            }
            i++;
        }
        if (j != -1) {
            byteBufferReader.MyBillsEntityDataFactory((int) (j - byteBufferReader.getAuthRequestContext()));
            byteBufferReader.MyBillsEntityDataFactory(12);
            long PlaceComponentResult = byteBufferReader.PlaceComponentResult();
            for (int i2 = 0; i2 < PlaceComponentResult; i2++) {
                int BuiltInFictitiousFunctionClassFactory2 = byteBufferReader.BuiltInFictitiousFunctionClassFactory();
                long PlaceComponentResult2 = byteBufferReader.PlaceComponentResult();
                long PlaceComponentResult3 = byteBufferReader.PlaceComponentResult();
                if (1164798569 == BuiltInFictitiousFunctionClassFactory2 || 1701669481 == BuiltInFictitiousFunctionClassFactory2) {
                    duplicate.position((int) new OffsetInfo(PlaceComponentResult2 + j, PlaceComponentResult3).PlaceComponentResult);
                    return MetadataList.getAuthRequestContext(duplicate);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    /* loaded from: classes6.dex */
    static class OffsetInfo {
        private final long KClassImpl$Data$declaredNonStaticMembers$2;
        final long PlaceComponentResult;

        OffsetInfo(long j, long j2) {
            this.PlaceComponentResult = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j2;
        }
    }

    /* loaded from: classes6.dex */
    static class InputStreamOpenTypeReader implements OpenTypeReader {
        private final byte[] BuiltInFictitiousFunctionClassFactory;
        private long KClassImpl$Data$declaredNonStaticMembers$2;
        private final ByteBuffer MyBillsEntityDataFactory;
        private final InputStream PlaceComponentResult;

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final int MyBillsEntityDataFactory() throws IOException {
            this.MyBillsEntityDataFactory.position(0);
            getAuthRequestContext(2);
            return MetadataListReader.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getShort());
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final long PlaceComponentResult() throws IOException {
            this.MyBillsEntityDataFactory.position(0);
            getAuthRequestContext(4);
            return MetadataListReader.PlaceComponentResult(this.MyBillsEntityDataFactory.getInt());
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final int BuiltInFictitiousFunctionClassFactory() throws IOException {
            this.MyBillsEntityDataFactory.position(0);
            getAuthRequestContext(4);
            return this.MyBillsEntityDataFactory.getInt();
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final void MyBillsEntityDataFactory(int i) throws IOException {
            while (i > 0) {
                int skip = (int) this.PlaceComponentResult.skip(i);
                if (skip <= 0) {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
                i -= skip;
                this.KClassImpl$Data$declaredNonStaticMembers$2 += skip;
            }
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final long getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        private void getAuthRequestContext(int i) throws IOException {
            if (this.PlaceComponentResult.read(this.BuiltInFictitiousFunctionClassFactory, 0, i) != i) {
                throw new IOException("read failed");
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 += i;
        }
    }

    /* loaded from: classes6.dex */
    static class ByteBufferReader implements OpenTypeReader {
        private final ByteBuffer MyBillsEntityDataFactory;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.MyBillsEntityDataFactory = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final int MyBillsEntityDataFactory() throws IOException {
            return MetadataListReader.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getShort());
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final long PlaceComponentResult() throws IOException {
            return MetadataListReader.PlaceComponentResult(this.MyBillsEntityDataFactory.getInt());
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final int BuiltInFictitiousFunctionClassFactory() throws IOException {
            return this.MyBillsEntityDataFactory.getInt();
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final void MyBillsEntityDataFactory(int i) throws IOException {
            ByteBuffer byteBuffer = this.MyBillsEntityDataFactory;
            byteBuffer.position(byteBuffer.position() + i);
        }

        @Override // androidx.emoji.text.MetadataListReader.OpenTypeReader
        public final long getAuthRequestContext() {
            return this.MyBillsEntityDataFactory.position();
        }
    }

    private MetadataListReader() {
    }
}
