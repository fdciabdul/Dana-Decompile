package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes3.dex */
public abstract class JsonReader implements Closeable {
    private static final String[] moveToNextValue = new String[128];
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean PlaceComponentResult;
    int[] BuiltInFictitiousFunctionClassFactory = new int[32];
    String[] MyBillsEntityDataFactory = new String[32];
    int[] getAuthRequestContext = new int[32];

    /* loaded from: classes3.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public abstract void BuiltInFictitiousFunctionClassFactory() throws IOException;

    public abstract void DatabaseTableConfigUtil() throws IOException;

    public abstract Token GetContactSyncConfig() throws IOException;

    public abstract boolean KClassImpl$Data$declaredNonStaticMembers$2() throws IOException;

    public abstract void MyBillsEntityDataFactory() throws IOException;

    public abstract String NetworkUserEntityData$$ExternalSyntheticLambda0() throws IOException;

    public abstract void NetworkUserEntityData$$ExternalSyntheticLambda2() throws IOException;

    public abstract int PlaceComponentResult(Options options) throws IOException;

    public abstract void PlaceComponentResult() throws IOException;

    public abstract void getAuthRequestContext() throws IOException;

    public abstract boolean getErrorConfigVersion() throws IOException;

    public abstract double lookAheadTest() throws IOException;

    public abstract String moveToNextValue() throws IOException;

    public abstract int scheduleImpl() throws IOException;

    static {
        for (int i = 0; i <= 31; i++) {
            moveToNextValue[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = moveToNextValue;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader KClassImpl$Data$declaredNonStaticMembers$2(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    public final void MyBillsEntityDataFactory(int i) {
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int[] iArr = this.BuiltInFictitiousFunctionClassFactory;
        if (i2 == iArr.length) {
            if (i2 == 256) {
                StringBuilder sb = new StringBuilder();
                sb.append("Nesting too deep at ");
                sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
                throw new JsonDataException(sb.toString());
            }
            this.BuiltInFictitiousFunctionClassFactory = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.getAuthRequestContext;
            this.getAuthRequestContext = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.BuiltInFictitiousFunctionClassFactory;
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 + 1;
        iArr3[i3] = i;
    }

    public final JsonEncodingException BuiltInFictitiousFunctionClassFactory(String str) throws JsonEncodingException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" at path ");
        sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
        throw new JsonEncodingException(sb.toString());
    }

    /* loaded from: classes3.dex */
    public static final class Options {
        final okio.Options PlaceComponentResult;
        final String[] getAuthRequestContext;

        private Options(String[] strArr, okio.Options options) {
            this.getAuthRequestContext = strArr;
            this.PlaceComponentResult = options;
        }

        public static Options BuiltInFictitiousFunctionClassFactory(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonReader.getAuthRequestContext(buffer, strArr[i]);
                    buffer.initRecordTimeStamp();
                    byteStringArr[i] = new ByteString(buffer.NetworkUserEntityData$$ExternalSyntheticLambda1());
                }
                return new Options((String[]) strArr.clone(), okio.Options.getAuthRequestContext(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void getAuthRequestContext(okio.BufferedSink r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.moveToNextValue
            r1 = 34
            r7.PlaceComponentResult(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.PlaceComponentResult(r8, r4, r3)
        L2e:
            r7.BuiltInFictitiousFunctionClassFactory(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.PlaceComponentResult(r8, r4, r2)
        L3b:
            r7.PlaceComponentResult(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.getAuthRequestContext(okio.BufferedSink, java.lang.String):void");
    }
}
