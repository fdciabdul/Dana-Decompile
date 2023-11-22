package okhttp3;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

/* loaded from: classes6.dex */
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String encodedName(int i) {
        return this.encodedNames.get(i);
    }

    public final String name(int i) {
        return HttpUrl.percentDecode(encodedName(i), true);
    }

    public final String encodedValue(int i) {
        return this.encodedValues.get(i);
    }

    public final String value(int i) {
        return HttpUrl.percentDecode(encodedValue(i), true);
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return CONTENT_TYPE;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }

    private long writeOrCountBytes(@Nullable BufferedSink bufferedSink, boolean z) {
        Buffer KClassImpl$Data$declaredNonStaticMembers$2;
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2 = new Buffer();
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = bufferedSink.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(38);
            }
            String str = this.encodedNames.get(i);
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(str, 0, str.length());
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(61);
            String str2 = this.encodedValues.get(i);
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(str2, 0, str2.length());
        }
        if (z) {
            long j = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
                return j;
            } catch (EOFException e) {
                throw new AssertionError(e);
            }
        }
        return 0L;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null);
        }

        public Builder(Charset charset) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset;
        }

        public final Builder add(String str, String str2) {
            if (str != null) {
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public final Builder addEncoded(String str, String str2) {
            if (str != null) {
                if (str2 == null) {
                    throw new NullPointerException("value == null");
                }
                this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }
}
