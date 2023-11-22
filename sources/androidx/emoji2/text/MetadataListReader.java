package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* loaded from: classes6.dex */
class MetadataListReader {

    /* loaded from: classes6.dex */
    interface OpenTypeReader {
        long BuiltInFictitiousFunctionClassFactory();

        long KClassImpl$Data$declaredNonStaticMembers$2() throws IOException;

        int MyBillsEntityDataFactory() throws IOException;

        void PlaceComponentResult(int i) throws IOException;

        int getAuthRequestContext() throws IOException;
    }

    static int KClassImpl$Data$declaredNonStaticMembers$2(short s) {
        return s & UShort.MAX_VALUE;
    }

    static long MyBillsEntityDataFactory(int i) {
        return i & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataList getAuthRequestContext(ByteBuffer byteBuffer) throws IOException {
        long j;
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBufferReader byteBufferReader = new ByteBufferReader(duplicate);
        byteBufferReader.PlaceComponentResult(4);
        int MyBillsEntityDataFactory = byteBufferReader.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferReader.PlaceComponentResult(6);
        int i = 0;
        while (true) {
            if (i >= MyBillsEntityDataFactory) {
                j = -1;
                break;
            }
            int authRequestContext = byteBufferReader.getAuthRequestContext();
            byteBufferReader.PlaceComponentResult(4);
            j = byteBufferReader.KClassImpl$Data$declaredNonStaticMembers$2();
            byteBufferReader.PlaceComponentResult(4);
            if (1835365473 == authRequestContext) {
                break;
            }
            i++;
        }
        if (j != -1) {
            byteBufferReader.PlaceComponentResult((int) (j - byteBufferReader.BuiltInFictitiousFunctionClassFactory()));
            byteBufferReader.PlaceComponentResult(12);
            long KClassImpl$Data$declaredNonStaticMembers$2 = byteBufferReader.KClassImpl$Data$declaredNonStaticMembers$2();
            for (int i2 = 0; i2 < KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
                int authRequestContext2 = byteBufferReader.getAuthRequestContext();
                long KClassImpl$Data$declaredNonStaticMembers$22 = byteBufferReader.KClassImpl$Data$declaredNonStaticMembers$2();
                long KClassImpl$Data$declaredNonStaticMembers$23 = byteBufferReader.KClassImpl$Data$declaredNonStaticMembers$2();
                if (1164798569 == authRequestContext2 || 1701669481 == authRequestContext2) {
                    duplicate.position((int) new OffsetInfo(KClassImpl$Data$declaredNonStaticMembers$22 + j, KClassImpl$Data$declaredNonStaticMembers$23).BuiltInFictitiousFunctionClassFactory);
                    return MetadataList.BuiltInFictitiousFunctionClassFactory(duplicate);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    /* loaded from: classes6.dex */
    static class OffsetInfo {
        final long BuiltInFictitiousFunctionClassFactory;
        private final long getAuthRequestContext;

        OffsetInfo(long j, long j2) {
            this.BuiltInFictitiousFunctionClassFactory = j;
            this.getAuthRequestContext = j2;
        }
    }

    /* loaded from: classes6.dex */
    static class InputStreamOpenTypeReader implements OpenTypeReader {
        private long BuiltInFictitiousFunctionClassFactory;
        private final InputStream KClassImpl$Data$declaredNonStaticMembers$2;
        private final ByteBuffer MyBillsEntityDataFactory;
        private final byte[] PlaceComponentResult;

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final int MyBillsEntityDataFactory() throws IOException {
            this.MyBillsEntityDataFactory.position(0);
            KClassImpl$Data$declaredNonStaticMembers$2(2);
            return MetadataListReader.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final long KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
            this.MyBillsEntityDataFactory.position(0);
            KClassImpl$Data$declaredNonStaticMembers$2(4);
            return MetadataListReader.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final int getAuthRequestContext() throws IOException {
            this.MyBillsEntityDataFactory.position(0);
            KClassImpl$Data$declaredNonStaticMembers$2(4);
            return this.MyBillsEntityDataFactory.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final void PlaceComponentResult(int i) throws IOException {
            while (i > 0) {
                int skip = (int) this.KClassImpl$Data$declaredNonStaticMembers$2.skip(i);
                if (skip <= 0) {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
                i -= skip;
                this.BuiltInFictitiousFunctionClassFactory += skip;
            }
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final long BuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(int i) throws IOException {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.read(this.PlaceComponentResult, 0, i) != i) {
                throw new IOException("read failed");
            }
            this.BuiltInFictitiousFunctionClassFactory += i;
        }
    }

    /* loaded from: classes6.dex */
    static class ByteBufferReader implements OpenTypeReader {
        private final ByteBuffer BuiltInFictitiousFunctionClassFactory;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.BuiltInFictitiousFunctionClassFactory = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final int MyBillsEntityDataFactory() throws IOException {
            return MetadataListReader.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final long KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
            return MetadataListReader.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final int getAuthRequestContext() throws IOException {
            return this.BuiltInFictitiousFunctionClassFactory.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final void PlaceComponentResult(int i) throws IOException {
            ByteBuffer byteBuffer = this.BuiltInFictitiousFunctionClassFactory;
            byteBuffer.position(byteBuffer.position() + i);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public final long BuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory.position();
        }
    }

    private MetadataListReader() {
    }
}
