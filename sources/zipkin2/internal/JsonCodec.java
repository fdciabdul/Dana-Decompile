package zipkin2.internal;

import android.view.Gravity;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import o.getOnBoardingScenario;
import zipkin2.internal.WriteBuffer;
import zipkin2.internal.gson.stream.JsonToken;

/* loaded from: classes6.dex */
public final class JsonCodec {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static long KClassImpl$Data$declaredNonStaticMembers$2;
    static final Charset PlaceComponentResult;
    private static int getAuthRequestContext;

    /* loaded from: classes9.dex */
    public interface JsonReaderAdapter<T> {
        T KClassImpl$Data$declaredNonStaticMembers$2(JsonReader jsonReader) throws IOException;
    }

    static void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2 = -2693207913609302149L;
    }

    static {
        PlaceComponentResult();
        Object[] objArr = new Object[1];
        a(Gravity.getAbsoluteGravity(0, 0) + 28097, new char[]{15981, 21421, 58876, 30550, 35076}, objArr);
        PlaceComponentResult = Charset.forName(((String) objArr[0]).intern());
        int i = BuiltInFictitiousFunctionClassFactory + 11;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    /* loaded from: classes9.dex */
    public static final class JsonReader {
        public final zipkin2.internal.gson.stream.JsonReader BuiltInFictitiousFunctionClassFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public JsonReader(ReadBuffer readBuffer) {
            this.BuiltInFictitiousFunctionClassFactory = new zipkin2.internal.gson.stream.JsonReader(new InputStreamReader(readBuffer, JsonCodec.PlaceComponentResult));
        }

        public final boolean getAuthRequestContext() throws IOException {
            return this.BuiltInFictitiousFunctionClassFactory.lookAheadTest();
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
            return this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
        }

        public final boolean BuiltInFictitiousFunctionClassFactory() throws IOException {
            return this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2() == JsonToken.STRING;
        }

        public final boolean PlaceComponentResult() throws IOException {
            return this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2() == JsonToken.BOOLEAN;
        }

        public final boolean MyBillsEntityDataFactory() throws IOException {
            return this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2() == JsonToken.NULL;
        }

        public final String toString() {
            return this.BuiltInFictitiousFunctionClassFactory.toString();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if ((r5.available() == 0 ? 'Y' : '#') != 'Y') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if ((r5.available() == 0 ? '+' : 'c') != '+') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        r6.add(r4.KClassImpl$Data$declaredNonStaticMembers$2(new zipkin2.internal.JsonCodec.JsonReader(r5)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        r5 = zipkin2.internal.JsonCodec.getAuthRequestContext + 49;
        zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        if ((r5 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        r5 = 'A';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
    
        r5 = kotlin.text.Typography.less;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        if (r5 == '<') goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0064, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        throw getAuthRequestContext(r4.toString(), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
    
        r4 = zipkin2.internal.JsonCodec.getAuthRequestContext + 119;
        zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        if ((r4 % 2) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007a, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> boolean MyBillsEntityDataFactory(zipkin2.internal.JsonCodec.JsonReaderAdapter<T> r4, zipkin2.internal.ReadBuffer r5, java.util.Collection<T> r6) {
        /*
            int r0 = zipkin2.internal.JsonCodec.getAuthRequestContext
            int r0 = r0 + 11
            int r1 = r0 % 128
            zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 56
            if (r0 != 0) goto L11
            r0 = 12
            goto L13
        L11:
            r0 = 56
        L13:
            r2 = 0
            r3 = 0
            if (r0 == r1) goto L2c
            int r0 = r5.available()
            r1 = 49
            int r1 = r1 / r3
            r1 = 89
            if (r0 != 0) goto L25
            r0 = 89
            goto L27
        L25:
            r0 = 35
        L27:
            if (r0 == r1) goto L6e
            goto L3b
        L2a:
            r4 = move-exception
            throw r4
        L2c:
            int r0 = r5.available()
            r1 = 43
            if (r0 != 0) goto L37
            r0 = 43
            goto L39
        L37:
            r0 = 99
        L39:
            if (r0 == r1) goto L6e
        L3b:
            zipkin2.internal.JsonCodec$JsonReader r0 = new zipkin2.internal.JsonCodec$JsonReader     // Catch: java.lang.Exception -> L64
            r0.<init>(r5)     // Catch: java.lang.Exception -> L64
            java.lang.Object r5 = r4.KClassImpl$Data$declaredNonStaticMembers$2(r0)     // Catch: java.lang.Exception -> L64
            r6.add(r5)     // Catch: java.lang.Exception -> L64
            r4 = 1
            int r5 = zipkin2.internal.JsonCodec.getAuthRequestContext
            int r5 = r5 + 49
            int r6 = r5 % 128
            zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r6
            int r5 = r5 % 2
            r6 = 60
            if (r5 != 0) goto L59
            r5 = 65
            goto L5b
        L59:
            r5 = 60
        L5b:
            if (r5 == r6) goto L63
            r2.hashCode()     // Catch: java.lang.Throwable -> L61
            return r4
        L61:
            r4 = move-exception
            throw r4
        L63:
            return r4
        L64:
            r5 = move-exception
            java.lang.String r4 = r4.toString()
            java.lang.IllegalArgumentException r4 = getAuthRequestContext(r4, r5)
            throw r4
        L6e:
            int r4 = zipkin2.internal.JsonCodec.getAuthRequestContext
            int r4 = r4 + 119
            int r5 = r4 % 128
            zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L80
            r2.hashCode()     // Catch: java.lang.Throwable -> L7e
            return r3
        L7e:
            r4 = move-exception
            throw r4
        L80:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.internal.JsonCodec.MyBillsEntityDataFactory(zipkin2.internal.JsonCodec$JsonReaderAdapter, zipkin2.internal.ReadBuffer, java.util.Collection):boolean");
    }

    @Nullable
    public static <T> T PlaceComponentResult(JsonReaderAdapter<T> jsonReaderAdapter, ReadBuffer readBuffer) {
        ArrayList arrayList = new ArrayList(1);
        Object obj = null;
        if (!(MyBillsEntityDataFactory(jsonReaderAdapter, readBuffer, arrayList))) {
            int i = BuiltInFictitiousFunctionClassFactory + 65;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return null;
        }
        T t = (T) arrayList.get(0);
        int i3 = getAuthRequestContext + 87;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return t;
        }
        obj.hashCode();
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
    
        if ((r5.available() == 0) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        r0 = new zipkin2.internal.JsonCodec.JsonReader(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        if (r0.getAuthRequestContext() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        if (r5 == true) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        if (r0.getAuthRequestContext() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        r5 = 'I';
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:
    
        r5 = '\'';
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        if (r5 == '\'') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
    
        r6.add(r4.KClassImpl$Data$declaredNonStaticMembers$2(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        r4 = zipkin2.internal.JsonCodec.getAuthRequestContext + 85;
        zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0066, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0067, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append("List<");
        r6.append(r4);
        r6.append(com.j256.ormlite.stmt.query.SimpleComparison.GREATER_THAN_OPERATION);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        throw getAuthRequestContext(r6.toString(), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (r0 == 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> boolean getAuthRequestContext(zipkin2.internal.JsonCodec.JsonReaderAdapter<T> r4, zipkin2.internal.ReadBuffer r5, java.util.Collection<T> r6) {
        /*
            int r0 = zipkin2.internal.JsonCodec.getAuthRequestContext
            int r0 = r0 + 69
            int r1 = r0 % 128
            zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L1d
            int r0 = r5.available()     // Catch: java.lang.Exception -> L1b
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L19
            if (r0 != 0) goto L29
            goto L28
        L19:
            r4 = move-exception
            throw r4
        L1b:
            r4 = move-exception
            throw r4
        L1d:
            int r0 = r5.available()
            if (r0 != 0) goto L25
            r0 = 1
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 == 0) goto L29
        L28:
            return r2
        L29:
            zipkin2.internal.JsonCodec$JsonReader r0 = new zipkin2.internal.JsonCodec$JsonReader
            r0.<init>(r5)
            zipkin2.internal.gson.stream.JsonReader r5 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L66
            r5.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Exception -> L66
            boolean r5 = r0.getAuthRequestContext()     // Catch: java.lang.Exception -> L66
            if (r5 != 0) goto L3b
            r5 = 1
            goto L3c
        L3b:
            r5 = 0
        L3c:
            if (r5 == r1) goto L5b
        L3e:
            boolean r5 = r0.getAuthRequestContext()     // Catch: java.lang.Exception -> L66
            r2 = 39
            if (r5 == 0) goto L49
            r5 = 73
            goto L4b
        L49:
            r5 = 39
        L4b:
            if (r5 == r2) goto L55
            java.lang.Object r5 = r4.KClassImpl$Data$declaredNonStaticMembers$2(r0)     // Catch: java.lang.Exception -> L66
            r6.add(r5)     // Catch: java.lang.Exception -> L66
            goto L3e
        L55:
            zipkin2.internal.gson.stream.JsonReader r5 = r0.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L66
            r5.MyBillsEntityDataFactory()     // Catch: java.lang.Exception -> L66
            return r1
        L5b:
            int r4 = zipkin2.internal.JsonCodec.getAuthRequestContext
            int r4 = r4 + 85
            int r5 = r4 % 128
            zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r5
            int r4 = r4 % 2
            return r2
        L66:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "List<"
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ">"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.IllegalArgumentException r4 = getAuthRequestContext(r4, r5)
            goto L83
        L82:
            throw r4
        L83:
            goto L82
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.internal.JsonCodec.getAuthRequestContext(zipkin2.internal.JsonCodec$JsonReaderAdapter, zipkin2.internal.ReadBuffer, java.util.Collection):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r0 > 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> int getAuthRequestContext(zipkin2.internal.WriteBuffer.Writer<T> r7, java.util.List<T> r8) {
        /*
            int r0 = zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 71
            int r1 = r0 % 128
            zipkin2.internal.JsonCodec.getAuthRequestContext = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L24
            int r0 = r8.size()
            r4 = 45
            if (r0 <= r3) goto L1e
            r3 = 45
            goto L20
        L1e:
            r3 = 40
        L20:
            if (r3 == r4) goto L2b
            r4 = 2
            goto L2f
        L24:
            int r0 = r8.size()
            r4 = 4
            if (r0 <= r3) goto L2f
        L2b:
            int r3 = r0 + (-1)
            int r4 = r3 + 2
        L2f:
            int r3 = zipkin2.internal.JsonCodec.getAuthRequestContext
            int r3 = r3 + 105
            int r5 = r3 % 128
            zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r5
            int r3 = r3 % r1
            r3 = 0
        L39:
            if (r3 >= r0) goto L64
            int r5 = zipkin2.internal.JsonCodec.getAuthRequestContext
            int r5 = r5 + 19
            int r6 = r5 % 128
            zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r6
            int r5 = r5 % r1
            if (r5 != 0) goto L49
            r5 = 64
            goto L4a
        L49:
            r5 = 0
        L4a:
            if (r5 == 0) goto L58
            java.lang.Object r5 = r8.get(r3)
            int r5 = r7.PlaceComponentResult(r5)
            int r4 = r4 / r5
            int r3 = r3 + 55
            goto L39
        L58:
            java.lang.Object r5 = r8.get(r3)
            int r5 = r7.PlaceComponentResult(r5)
            int r4 = r4 + r5
            int r3 = r3 + 1
            goto L39
        L64:
            int r7 = zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 + 23
            int r8 = r7 % 128
            zipkin2.internal.JsonCodec.getAuthRequestContext = r8
            int r7 = r7 % r1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.internal.JsonCodec.getAuthRequestContext(zipkin2.internal.WriteBuffer$Writer, java.util.List):int");
    }

    public static <T> byte[] KClassImpl$Data$declaredNonStaticMembers$2(WriteBuffer.Writer<T> writer, T t) {
        int PlaceComponentResult2 = writer.PlaceComponentResult(t);
        byte[] bArr = new byte[PlaceComponentResult2];
        try {
            writer.KClassImpl$Data$declaredNonStaticMembers$2(t, WriteBuffer.getAuthRequestContext(bArr));
            return bArr;
        } catch (RuntimeException e) {
            int i = 0;
            while (true) {
                if (i < PlaceComponentResult2) {
                    if (bArr[i] == 0) {
                        break;
                    }
                    i++;
                    try {
                        int i2 = getAuthRequestContext + 57;
                        try {
                            BuiltInFictitiousFunctionClassFactory = i2 % 128;
                            int i3 = i2 % 2;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } catch (Exception e3) {
                        throw e3;
                    }
                } else {
                    int i4 = BuiltInFictitiousFunctionClassFactory + 109;
                    getAuthRequestContext = i4 % 128;
                    int i5 = i4 % 2;
                    i = PlaceComponentResult2;
                    break;
                }
            }
            AssertionError assertionError = new AssertionError(String.format("Bug found using %s to write %s as json. Wrote %s/%s bytes: %s", writer.getClass().getSimpleName(), t.getClass().getSimpleName(), Integer.valueOf(i), Integer.valueOf(PlaceComponentResult2), new String(bArr, 0, i, PlaceComponentResult)));
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public static <T> byte[] MyBillsEntityDataFactory(WriteBuffer.Writer<T> writer, List<T> list) {
        int i = BuiltInFictitiousFunctionClassFactory + 95;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (!(list.isEmpty())) {
            byte[] bArr = new byte[getAuthRequestContext(writer, list)];
            getAuthRequestContext(writer, list, WriteBuffer.getAuthRequestContext(bArr));
            int i3 = getAuthRequestContext + 67;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return bArr;
        }
        return new byte[]{91, 93};
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
    
        if (r6.isEmpty() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0026, code lost:
    
        if ((r6.isEmpty()) != true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        r7 = zipkin2.internal.WriteBuffer.BuiltInFictitiousFunctionClassFactory(r7, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
    
        getAuthRequestContext(r5, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        r5 = r7.MyBillsEntityDataFactory - r8;
        r6 = zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory + 119;
        zipkin2.internal.JsonCodec.getAuthRequestContext = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if ((r6 % 2) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        if (r2 == true) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
    
        r6 = r6.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0047, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        r7[r8] = 91;
        r7[r8 + 1] = 93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0051, code lost:
    
        return 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> int getAuthRequestContext(zipkin2.internal.WriteBuffer.Writer<T> r5, java.util.List<T> r6, byte[] r7, int r8) {
        /*
            int r0 = zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L54
            int r0 = r0 + 3
            int r1 = r0 % 128
            zipkin2.internal.JsonCodec.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L54
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L1a
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L28
            goto L48
        L1a:
            boolean r0 = r6.isEmpty()
            r4 = 45
            int r4 = r4 / r2
            if (r0 == 0) goto L25
            r0 = 1
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 == r3) goto L48
        L28:
            zipkin2.internal.WriteBuffer r7 = zipkin2.internal.WriteBuffer.BuiltInFictitiousFunctionClassFactory(r7, r8)     // Catch: java.lang.Exception -> L54
            getAuthRequestContext(r5, r6, r7)     // Catch: java.lang.Exception -> L46
            int r5 = r7.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L46
            int r5 = r5 - r8
            int r6 = zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 119
            int r7 = r6 % 128
            zipkin2.internal.JsonCodec.getAuthRequestContext = r7
            int r6 = r6 % r1
            if (r6 == 0) goto L3e
            r2 = 1
        L3e:
            if (r2 == r3) goto L41
            return r5
        L41:
            r6 = 0
            int r6 = r6.length     // Catch: java.lang.Throwable -> L44
            return r5
        L44:
            r5 = move-exception
            throw r5
        L46:
            r5 = move-exception
            throw r5
        L48:
            r5 = 91
            r7[r8] = r5
            int r8 = r8 + r3
            r5 = 93
            r7[r8] = r5
            return r1
        L52:
            r5 = move-exception
            throw r5
        L54:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.internal.JsonCodec.getAuthRequestContext(zipkin2.internal.WriteBuffer$Writer, java.util.List, byte[], int):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:31:0x0060
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static java.lang.IllegalArgumentException getAuthRequestContext(java.lang.String r7, java.lang.Exception r8) {
        /*
            java.lang.String r0 = r8.getMessage()
            r1 = 22
            if (r0 != 0) goto Lb
            r0 = 81
            goto Ld
        Lb:
            r0 = 22
        Ld:
            r2 = 2
            if (r0 == r1) goto L13
            java.lang.String r0 = "Error"
            goto L20
        L13:
            java.lang.String r0 = r8.getMessage()
            int r1 = zipkin2.internal.JsonCodec.getAuthRequestContext
            int r1 = r1 + 75
            int r3 = r1 % 128
            zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r3
            int r1 = r1 % r2
        L20:
            java.lang.String r1 = "Expected BEGIN_OBJECT"
            int r1 = r0.indexOf(r1)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 != r3) goto L2d
            r1 = 1
            goto L2e
        L2d:
            r1 = 0
        L2e:
            if (r1 == r5) goto L31
            goto L54
        L31:
            int r1 = zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 73
            int r6 = r1 % 128
            zipkin2.internal.JsonCodec.getAuthRequestContext = r6
            int r1 = r1 % r2
            java.lang.String r6 = "malformed"
            if (r1 == 0) goto L4e
            int r1 = r0.indexOf(r6)
            r6 = 4
            int r6 = r6 / r4
            if (r1 == r3) goto L48
            r1 = 0
            goto L49
        L48:
            r1 = 1
        L49:
            if (r1 == r5) goto L62
            goto L54
        L4c:
            r7 = move-exception
            throw r7
        L4e:
            int r1 = r0.indexOf(r6)
            if (r1 == r3) goto L62
        L54:
            java.lang.String r0 = "Malformed"
            int r1 = zipkin2.internal.JsonCodec.getAuthRequestContext
            int r1 = r1 + 57
            int r3 = r1 % 128
            zipkin2.internal.JsonCodec.BuiltInFictitiousFunctionClassFactory = r3
            int r1 = r1 % r2
            goto L62
        L60:
            r7 = move-exception
            throw r7
        L62:
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r1[r4] = r0
            r1[r5] = r7
            java.lang.String r7 = "%s reading %s from json"
            java.lang.String r7 = java.lang.String.format(r7, r1)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.internal.JsonCodec.getAuthRequestContext(java.lang.String, java.lang.Exception):java.lang.IllegalArgumentException");
    }

    private static <T> void getAuthRequestContext(WriteBuffer.Writer<T> writer, List<T> list, WriteBuffer writeBuffer) {
        int i = BuiltInFictitiousFunctionClassFactory + 95;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            byte[] bArr = writeBuffer.PlaceComponentResult;
            int i3 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i3 + 1;
            bArr[i3] = 91;
            int size = list.size();
            int i4 = BuiltInFictitiousFunctionClassFactory + 119;
            getAuthRequestContext = i4 % 128;
            int i5 = i4 % 2;
            int i6 = 0;
            while (true) {
                if (!(i6 >= size)) {
                    int i7 = i6 + 1;
                    writer.KClassImpl$Data$declaredNonStaticMembers$2(list.get(i6), writeBuffer);
                    if (i7 < size) {
                        byte[] bArr2 = writeBuffer.PlaceComponentResult;
                        int i8 = writeBuffer.MyBillsEntityDataFactory;
                        writeBuffer.MyBillsEntityDataFactory = i8 + 1;
                        bArr2[i8] = 44;
                    }
                    int i9 = BuiltInFictitiousFunctionClassFactory + 43;
                    getAuthRequestContext = i9 % 128;
                    int i10 = i9 % 2;
                    i6 = i7;
                } else {
                    byte[] bArr3 = writeBuffer.PlaceComponentResult;
                    int i11 = writeBuffer.MyBillsEntityDataFactory;
                    writeBuffer.MyBillsEntityDataFactory = i11 + 1;
                    bArr3[i11] = 93;
                    return;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        try {
            getonboardingscenario.MyBillsEntityDataFactory = i;
            int length = cArr.length;
            long[] jArr = new long[length];
            getonboardingscenario.getAuthRequestContext = 0;
            while (true) {
                if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                    break;
                }
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
                int i3 = $11 + 121;
                $10 = i3 % 128;
                int i4 = i3 % 2;
            }
            char[] cArr2 = new char[length];
            try {
                getonboardingscenario.getAuthRequestContext = 0;
                while (true) {
                    if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                        objArr[0] = new String(cArr2);
                        return;
                    }
                    int i5 = $11 + 59;
                    $10 = i5 % 128;
                    if (i5 % 2 == 0) {
                        cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                        i2 = getonboardingscenario.getAuthRequestContext + 1;
                    } else {
                        cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                        i2 = getonboardingscenario.getAuthRequestContext - 1;
                    }
                    getonboardingscenario.getAuthRequestContext = i2;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
