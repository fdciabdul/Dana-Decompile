package zipkin2.reporter.okhttp3;

import java.io.IOException;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import zipkin2.codec.Encoding;

/* loaded from: classes6.dex */
enum RequestBodyMessageEncoder {
    JSON { // from class: zipkin2.reporter.okhttp3.RequestBodyMessageEncoder.1
        @Override // zipkin2.reporter.okhttp3.RequestBodyMessageEncoder
        public final RequestBody encode(List<byte[]> list) {
            return new JsonRequestBody(list);
        }
    },
    THRIFT { // from class: zipkin2.reporter.okhttp3.RequestBodyMessageEncoder.2
        @Override // zipkin2.reporter.okhttp3.RequestBodyMessageEncoder
        final RequestBody encode(List<byte[]> list) {
            return new ThriftRequestBody(list);
        }
    },
    PROTO3 { // from class: zipkin2.reporter.okhttp3.RequestBodyMessageEncoder.3
        @Override // zipkin2.reporter.okhttp3.RequestBodyMessageEncoder
        final RequestBody encode(List<byte[]> list) {
            return new Protobuf3RequestBody(list);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract RequestBody encode(List<byte[]> list);

    /* loaded from: classes6.dex */
    static abstract class StreamingRequestBody extends RequestBody {
        final List<byte[]> MyBillsEntityDataFactory;
        final long PlaceComponentResult;
        final MediaType getAuthRequestContext;

        StreamingRequestBody(Encoding encoding, MediaType mediaType, List<byte[]> list) {
            this.getAuthRequestContext = mediaType;
            this.MyBillsEntityDataFactory = list;
            this.PlaceComponentResult = encoding.listSizeInBytes(list);
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.getAuthRequestContext;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.PlaceComponentResult;
        }
    }

    /* loaded from: classes6.dex */
    static final class JsonRequestBody extends StreamingRequestBody {
        static final MediaType KClassImpl$Data$declaredNonStaticMembers$2 = MediaType.parse("application/json");

        JsonRequestBody(List<byte[]> list) {
            super(Encoding.JSON, KClassImpl$Data$declaredNonStaticMembers$2, list);
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            bufferedSink.PlaceComponentResult(91);
            int size = this.MyBillsEntityDataFactory.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                bufferedSink.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get(i));
                if (i2 < size) {
                    bufferedSink.PlaceComponentResult(44);
                }
                i = i2;
            }
            bufferedSink.PlaceComponentResult(93);
        }
    }

    /* loaded from: classes6.dex */
    static final class ThriftRequestBody extends StreamingRequestBody {
        static final MediaType BuiltInFictitiousFunctionClassFactory = MediaType.parse("application/x-thrift");

        ThriftRequestBody(List<byte[]> list) {
            super(Encoding.THRIFT, BuiltInFictitiousFunctionClassFactory, list);
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            int size = this.MyBillsEntityDataFactory.size();
            bufferedSink.PlaceComponentResult(12);
            bufferedSink.PlaceComponentResult((size >>> 24) & 255);
            bufferedSink.PlaceComponentResult((size >>> 16) & 255);
            bufferedSink.PlaceComponentResult((size >>> 8) & 255);
            bufferedSink.PlaceComponentResult(size & 255);
            for (int i = 0; i < size; i++) {
                bufferedSink.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get(i));
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class Protobuf3RequestBody extends StreamingRequestBody {
        static final MediaType BuiltInFictitiousFunctionClassFactory = MediaType.parse("application/x-protobuf");

        Protobuf3RequestBody(List<byte[]> list) {
            super(Encoding.PROTO3, BuiltInFictitiousFunctionClassFactory, list);
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            int size = this.MyBillsEntityDataFactory.size();
            for (int i = 0; i < size; i++) {
                bufferedSink.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get(i));
            }
        }
    }
}
