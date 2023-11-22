package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: classes6.dex */
final class RequestBuilder {
    @Nullable
    MediaType KClassImpl$Data$declaredNonStaticMembers$2;
    @Nullable
    FormBody.Builder MyBillsEntityDataFactory;
    @Nullable
    MultipartBody.Builder NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Nullable
    HttpUrl.Builder NetworkUserEntityData$$ExternalSyntheticLambda2;
    final HttpUrl PlaceComponentResult;
    @Nullable
    RequestBody getAuthRequestContext;
    @Nullable
    String getErrorConfigVersion;
    final Request.Builder initRecordTimeStamp = new Request.Builder();
    final boolean lookAheadTest;
    final String moveToNextValue;
    final Headers.Builder scheduleImpl;
    private static final char[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestBuilder(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.moveToNextValue = str;
        this.PlaceComponentResult = httpUrl;
        this.getErrorConfigVersion = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = mediaType;
        this.lookAheadTest = z;
        if (headers != null) {
            this.scheduleImpl = headers.newBuilder();
        } else {
            this.scheduleImpl = new Headers.Builder();
        }
        if (z2) {
            this.MyBillsEntityDataFactory = new FormBody.Builder();
        } else if (z3) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = MediaType.get(str2);
                return;
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed content type: ");
                sb.append(str2);
                throw new IllegalArgumentException(sb.toString(), e);
            }
        }
        this.scheduleImpl.add(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String PlaceComponentResult(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.PlaceComponentResult(str, 0, i);
                Buffer buffer2 = null;
                while (i < length) {
                    int codePointAt2 = str.codePointAt(i);
                    if (!z || (codePointAt2 != 9 && codePointAt2 != 10 && codePointAt2 != 12 && codePointAt2 != 13)) {
                        if (codePointAt2 < 32 || codePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt2) != -1 || (!z && (codePointAt2 == 47 || codePointAt2 == 37))) {
                            if (buffer2 == null) {
                                buffer2 = new Buffer();
                            }
                            buffer2.getErrorConfigVersion(codePointAt2);
                            while (!buffer2.lookAheadTest()) {
                                int initRecordTimeStamp = buffer2.initRecordTimeStamp() & 255;
                                buffer.PlaceComponentResult(37);
                                char[] cArr = NetworkUserEntityData$$ExternalSyntheticLambda1;
                                buffer.PlaceComponentResult((int) cArr[(initRecordTimeStamp >> 4) & 15]);
                                buffer.PlaceComponentResult((int) cArr[initRecordTimeStamp & 15]);
                            }
                        } else {
                            buffer.getErrorConfigVersion(codePointAt2);
                        }
                    }
                    i += Character.charCount(codePointAt2);
                }
                return buffer.FragmentBottomSheetPaymentSettingBinding();
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(String str, @Nullable String str2, boolean z) {
        String str3 = this.getErrorConfigVersion;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.PlaceComponentResult.newBuilder(str3);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = newBuilder;
            if (newBuilder == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.PlaceComponentResult);
                sb.append(", Relative: ");
                sb.append(this.getErrorConfigVersion);
                throw new IllegalArgumentException(sb.toString());
            }
            this.getErrorConfigVersion = null;
        }
        if (z) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.addEncodedQueryParameter(str, str2);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.addQueryParameter(str, str2);
        }
    }

    /* loaded from: classes6.dex */
    static class ContentTypeOverridingRequestBody extends RequestBody {
        private final RequestBody BuiltInFictitiousFunctionClassFactory;
        private final MediaType KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.BuiltInFictitiousFunctionClassFactory = requestBody;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = mediaType;
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.BuiltInFictitiousFunctionClassFactory.contentLength();
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.BuiltInFictitiousFunctionClassFactory.writeTo(bufferedSink);
        }
    }
}
