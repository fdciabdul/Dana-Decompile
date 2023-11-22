package zipkin2.codec;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import zipkin2.Span;
import zipkin2.internal.JsonCodec;
import zipkin2.internal.Nullable;
import zipkin2.internal.Proto3Codec;
import zipkin2.internal.ReadBuffer;
import zipkin2.internal.ThriftCodec;
import zipkin2.internal.V1JsonSpanReader;
import zipkin2.internal.V2SpanReader;
import zipkin2.v1.V1Span;
import zipkin2.v1.V1SpanConverter;

/* loaded from: classes9.dex */
public enum SpanBytesDecoder implements BytesDecoder<Span> {
    JSON_V1 { // from class: zipkin2.codec.SpanBytesDecoder.1
        public final Encoding encoding() {
            return Encoding.JSON;
        }

        public final boolean decode(byte[] bArr, Collection<Span> collection) {
            Span decodeOne = decodeOne(ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr));
            if (decodeOne == null) {
                return false;
            }
            collection.add(decodeOne);
            return true;
        }

        @Override // zipkin2.codec.BytesDecoder
        public final boolean decodeList(byte[] bArr, Collection<Span> collection) {
            return new V1JsonSpanReader().BuiltInFictitiousFunctionClassFactory(ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr), collection);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public final boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection) {
            return new V1JsonSpanReader().BuiltInFictitiousFunctionClassFactory(ReadBuffer.MyBillsEntityDataFactory(byteBuffer), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public final Span decodeOne(byte[] bArr) {
            return decodeOne(ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr));
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        @Nullable
        public final Span decodeOne(ByteBuffer byteBuffer) {
            return decodeOne(ReadBuffer.MyBillsEntityDataFactory(byteBuffer));
        }

        final Span decodeOne(ReadBuffer readBuffer) {
            V1Span v1Span = (V1Span) JsonCodec.PlaceComponentResult(new V1JsonSpanReader(), readBuffer);
            ArrayList arrayList = new ArrayList(1);
            V1SpanConverter PlaceComponentResult = V1SpanConverter.PlaceComponentResult();
            PlaceComponentResult.MyBillsEntityDataFactory(v1Span);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(v1Span);
            PlaceComponentResult.PlaceComponentResult(v1Span);
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(arrayList);
            return (Span) arrayList.get(0);
        }

        public final List<Span> decodeList(byte[] bArr) {
            return doDecodeList(this, bArr);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public final List<Span> decodeList(ByteBuffer byteBuffer) {
            return doDecodeList(this, byteBuffer);
        }
    },
    THRIFT { // from class: zipkin2.codec.SpanBytesDecoder.2
        public final Encoding encoding() {
            return Encoding.THRIFT;
        }

        public final boolean decode(byte[] bArr, Collection<Span> collection) {
            return ThriftCodec.MyBillsEntityDataFactory(ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        public final boolean decodeList(byte[] bArr, Collection<Span> collection) {
            return ThriftCodec.BuiltInFictitiousFunctionClassFactory(ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr), collection);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public final boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection) {
            return ThriftCodec.BuiltInFictitiousFunctionClassFactory(ReadBuffer.MyBillsEntityDataFactory(byteBuffer), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public final Span decodeOne(byte[] bArr) {
            return ThriftCodec.PlaceComponentResult(ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr));
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        @Nullable
        public final Span decodeOne(ByteBuffer byteBuffer) {
            return ThriftCodec.PlaceComponentResult(ReadBuffer.MyBillsEntityDataFactory(byteBuffer));
        }

        public final List<Span> decodeList(byte[] bArr) {
            return doDecodeList(this, bArr);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public final List<Span> decodeList(ByteBuffer byteBuffer) {
            return doDecodeList(this, byteBuffer);
        }
    },
    JSON_V2 { // from class: zipkin2.codec.SpanBytesDecoder.3
        public final Encoding encoding() {
            return Encoding.JSON;
        }

        public final boolean decode(byte[] bArr, Collection<Span> collection) {
            return JsonCodec.MyBillsEntityDataFactory(new V2SpanReader(), ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        public final boolean decodeList(byte[] bArr, Collection<Span> collection) {
            return JsonCodec.getAuthRequestContext(new V2SpanReader(), ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr), collection);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public final boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection) {
            return JsonCodec.getAuthRequestContext(new V2SpanReader(), ReadBuffer.MyBillsEntityDataFactory(byteBuffer), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public final Span decodeOne(byte[] bArr) {
            return (Span) JsonCodec.PlaceComponentResult(new V2SpanReader(), ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr));
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        @Nullable
        public final Span decodeOne(ByteBuffer byteBuffer) {
            return (Span) JsonCodec.PlaceComponentResult(new V2SpanReader(), ReadBuffer.MyBillsEntityDataFactory(byteBuffer));
        }

        public final List<Span> decodeList(byte[] bArr) {
            return doDecodeList(this, bArr);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public final List<Span> decodeList(ByteBuffer byteBuffer) {
            return doDecodeList(this, byteBuffer);
        }
    },
    PROTO3 { // from class: zipkin2.codec.SpanBytesDecoder.4
        public final Encoding encoding() {
            return Encoding.PROTO3;
        }

        public final boolean decode(byte[] bArr, Collection<Span> collection) {
            return Proto3Codec.MyBillsEntityDataFactory(ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        public final boolean decodeList(byte[] bArr, Collection<Span> collection) {
            return Proto3Codec.PlaceComponentResult(ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr), collection);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public final boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection) {
            return Proto3Codec.PlaceComponentResult(ReadBuffer.MyBillsEntityDataFactory(byteBuffer), collection);
        }

        @Override // zipkin2.codec.BytesDecoder
        @Nullable
        public final Span decodeOne(byte[] bArr) {
            return Proto3Codec.BuiltInFictitiousFunctionClassFactory(ReadBuffer.KClassImpl$Data$declaredNonStaticMembers$2(bArr));
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        @Nullable
        public final Span decodeOne(ByteBuffer byteBuffer) {
            return Proto3Codec.BuiltInFictitiousFunctionClassFactory(ReadBuffer.MyBillsEntityDataFactory(byteBuffer));
        }

        public final List<Span> decodeList(byte[] bArr) {
            return doDecodeList(this, bArr);
        }

        @Override // zipkin2.codec.SpanBytesDecoder
        public final List<Span> decodeList(ByteBuffer byteBuffer) {
            return doDecodeList(this, byteBuffer);
        }
    };

    public abstract List<Span> decodeList(ByteBuffer byteBuffer);

    public abstract boolean decodeList(ByteBuffer byteBuffer, Collection<Span> collection);

    @Nullable
    public abstract Span decodeOne(ByteBuffer byteBuffer);

    static List<Span> doDecodeList(SpanBytesDecoder spanBytesDecoder, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        spanBytesDecoder.decodeList(bArr, arrayList);
        return arrayList;
    }

    static List<Span> doDecodeList(SpanBytesDecoder spanBytesDecoder, ByteBuffer byteBuffer) {
        ArrayList arrayList = new ArrayList();
        spanBytesDecoder.decodeList(byteBuffer, arrayList);
        return arrayList;
    }
}
