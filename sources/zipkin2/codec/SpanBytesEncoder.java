package zipkin2.codec;

import java.util.List;
import zipkin2.Span;
import zipkin2.internal.JsonCodec;
import zipkin2.internal.Proto3Codec;
import zipkin2.internal.Proto3SpanWriter;
import zipkin2.internal.ThriftCodec;
import zipkin2.internal.V1JsonSpanWriter;
import zipkin2.internal.V1SpanWriter;
import zipkin2.internal.V1ThriftSpanWriter;
import zipkin2.internal.V2SpanWriter;
import zipkin2.internal.WriteBuffer;
import zipkin2.v1.V1Span;

/* loaded from: classes6.dex */
public enum SpanBytesEncoder implements BytesEncoder<Span> {
    JSON_V1 { // from class: zipkin2.codec.SpanBytesEncoder.1
        @Override // zipkin2.codec.BytesEncoder
        public final Encoding encoding() {
            return Encoding.JSON;
        }

        public final int sizeInBytes(Span span) {
            V1JsonSpanWriter v1JsonSpanWriter = new V1JsonSpanWriter();
            V1Span authRequestContext = v1JsonSpanWriter.MyBillsEntityDataFactory.getAuthRequestContext(span);
            V1SpanWriter v1SpanWriter = v1JsonSpanWriter.getAuthRequestContext;
            return V1SpanWriter.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
        }

        @Override // zipkin2.codec.BytesEncoder
        public final byte[] encode(Span span) {
            return JsonCodec.KClassImpl$Data$declaredNonStaticMembers$2(new V1JsonSpanWriter(), span);
        }

        public final byte[] encodeList(List<Span> list) {
            return JsonCodec.MyBillsEntityDataFactory(new V1JsonSpanWriter(), list);
        }

        @Override // zipkin2.codec.SpanBytesEncoder
        public final int encodeList(List<Span> list, byte[] bArr, int i) {
            return JsonCodec.getAuthRequestContext(new V1JsonSpanWriter(), list, bArr, i);
        }
    },
    THRIFT { // from class: zipkin2.codec.SpanBytesEncoder.2
        @Override // zipkin2.codec.BytesEncoder
        public final Encoding encoding() {
            return Encoding.THRIFT;
        }

        public final int sizeInBytes(Span span) {
            return new V1ThriftSpanWriter().PlaceComponentResult(span);
        }

        @Override // zipkin2.codec.BytesEncoder
        public final byte[] encode(Span span) {
            return new V1ThriftSpanWriter().PlaceComponentResult2(span);
        }

        public final byte[] encodeList(List<Span> list) {
            return new V1ThriftSpanWriter().KClassImpl$Data$declaredNonStaticMembers$2(list);
        }

        @Override // zipkin2.codec.SpanBytesEncoder
        public final int encodeList(List<Span> list, byte[] bArr, int i) {
            V1ThriftSpanWriter v1ThriftSpanWriter = new V1ThriftSpanWriter();
            if (list.size() == 0) {
                return 0;
            }
            WriteBuffer BuiltInFictitiousFunctionClassFactory = WriteBuffer.BuiltInFictitiousFunctionClassFactory(bArr, i);
            ThriftCodec.BuiltInFictitiousFunctionClassFactory(v1ThriftSpanWriter, list, BuiltInFictitiousFunctionClassFactory);
            return BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory - i;
        }
    },
    JSON_V2 { // from class: zipkin2.codec.SpanBytesEncoder.3
        final V2SpanWriter writer = new V2SpanWriter();

        @Override // zipkin2.codec.BytesEncoder
        public final Encoding encoding() {
            return Encoding.JSON;
        }

        public final int sizeInBytes(Span span) {
            return V2SpanWriter.KClassImpl$Data$declaredNonStaticMembers$2(span);
        }

        @Override // zipkin2.codec.BytesEncoder
        public final byte[] encode(Span span) {
            return JsonCodec.KClassImpl$Data$declaredNonStaticMembers$2(this.writer, span);
        }

        public final byte[] encodeList(List<Span> list) {
            return JsonCodec.MyBillsEntityDataFactory(this.writer, list);
        }

        @Override // zipkin2.codec.SpanBytesEncoder
        public final int encodeList(List<Span> list, byte[] bArr, int i) {
            return JsonCodec.getAuthRequestContext(this.writer, list, bArr, i);
        }
    },
    PROTO3 { // from class: zipkin2.codec.SpanBytesEncoder.4
        final Proto3Codec codec = new Proto3Codec();

        @Override // zipkin2.codec.BytesEncoder
        public final Encoding encoding() {
            return Encoding.PROTO3;
        }

        public final int sizeInBytes(Span span) {
            Proto3SpanWriter proto3SpanWriter = this.codec.KClassImpl$Data$declaredNonStaticMembers$2;
            return Proto3SpanWriter.KClassImpl$Data$declaredNonStaticMembers$2(span);
        }

        @Override // zipkin2.codec.BytesEncoder
        public final byte[] encode(Span span) {
            return this.codec.getAuthRequestContext(span);
        }

        public final byte[] encodeList(List<Span> list) {
            return this.codec.MyBillsEntityDataFactory(list);
        }

        @Override // zipkin2.codec.SpanBytesEncoder
        public final int encodeList(List<Span> list, byte[] bArr, int i) {
            Proto3SpanWriter proto3SpanWriter = this.codec.KClassImpl$Data$declaredNonStaticMembers$2;
            return Proto3SpanWriter.MyBillsEntityDataFactory(list, bArr, i);
        }
    };

    public abstract int encodeList(List<Span> list, byte[] bArr, int i);
}
