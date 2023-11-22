package com.google.common.io;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class Resources {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {90, -83, 93, -67, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 20;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 12
            int r7 = 16 - r7
            int r8 = r8 * 3
            int r8 = r8 + 13
            byte[] r0 = com.google.common.io.Resources.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 * 7
            int r6 = r6 + 99
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r6 = r6 + r8
            int r6 = r6 + 2
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.Resources.a(int, short, short, java.lang.Object[]):void");
    }

    private Resources() {
    }

    public static ByteSource asByteSource(URL url) {
        return new UrlByteSource(url);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class UrlByteSource extends ByteSource {
        private final URL url;

        private UrlByteSource(URL url) {
            this.url = (URL) Preconditions.checkNotNull(url);
        }

        @Override // com.google.common.io.ByteSource
        public final InputStream openStream() throws IOException {
            return this.url.openStream();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Resources.asByteSource(");
            sb.append(this.url);
            sb.append(")");
            return sb.toString();
        }
    }

    public static CharSource asCharSource(URL url, Charset charset) {
        return asByteSource(url).asCharSource(charset);
    }

    public static byte[] toByteArray(URL url) throws IOException {
        return asByteSource(url).read();
    }

    public static String toString(URL url, Charset charset) throws IOException {
        return asCharSource(url, charset).read();
    }

    @ParametricNullness
    public static <T> T readLines(URL url, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return (T) asCharSource(url, charset).readLines(lineProcessor);
    }

    public static List<String> readLines(URL url, Charset charset) throws IOException {
        return (List) readLines(url, charset, new LineProcessor<List<String>>() { // from class: com.google.common.io.Resources.1
            final List<String> result = Lists.newArrayList();

            @Override // com.google.common.io.LineProcessor
            public boolean processLine(String str) {
                this.result.add(str);
                return true;
            }

            @Override // com.google.common.io.LineProcessor
            public List<String> getResult() {
                return this.result;
            }
        });
    }

    public static void copy(URL url, OutputStream outputStream) throws IOException {
        asByteSource(url).copyTo(outputStream);
    }

    public static URL getResource(String str) {
        try {
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr = new Object[1];
            a(b, (byte) (b - 1), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            URL resource = ((ClassLoader) MoreObjects.firstNonNull(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getContextClassLoader(), Resources.class.getClassLoader())).getResource(str);
            Preconditions.checkArgument(resource != null, "resource %s not found.", str);
            return resource;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static URL getResource(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        Preconditions.checkArgument(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }
}
