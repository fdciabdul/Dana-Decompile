package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Util;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class JsonUtf8Reader extends JsonReader {
    private long DatabaseTableConfigUtil;
    private final Buffer GetContactSyncConfig;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private final BufferedSource isLayoutRequested;
    private String newProxyInstance;
    private static final ByteString getErrorConfigVersion = ByteString.encodeUtf8("'\\");
    private static final ByteString lookAheadTest = ByteString.encodeUtf8("\"\\");
    private static final ByteString initRecordTimeStamp = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString scheduleImpl = ByteString.encodeUtf8("\n\r");
    private static final ByteString moveToNextValue = ByteString.encodeUtf8("*/");

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.isLayoutRequested = bufferedSource;
        this.GetContactSyncConfig = bufferedSource.KClassImpl$Data$declaredNonStaticMembers$2();
        MyBillsEntityDataFactory(6);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void getAuthRequestContext() throws IOException {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 3) {
            MyBillsEntityDataFactory(1);
            this.getAuthRequestContext[this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1] = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append(GetContactSyncConfig());
        sb.append(" at path ");
        sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
        throw new JsonDataException(sb.toString());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void MyBillsEntityDataFactory() throws IOException {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 4) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0--;
            int[] iArr = this.getAuthRequestContext;
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
            iArr[i2] = iArr[i2] + 1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected END_ARRAY but was ");
        sb.append(GetContactSyncConfig());
        sb.append(" at path ");
        sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
        throw new JsonDataException(sb.toString());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void BuiltInFictitiousFunctionClassFactory() throws IOException {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 1) {
            MyBillsEntityDataFactory(3);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append(GetContactSyncConfig());
        sb.append(" at path ");
        sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
        throw new JsonDataException(sb.toString());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void PlaceComponentResult() throws IOException {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 2) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0--;
            this.MyBillsEntityDataFactory[this.NetworkUserEntityData$$ExternalSyntheticLambda0] = null;
            int[] iArr = this.getAuthRequestContext;
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
            iArr[i2] = iArr[i2] + 1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected END_OBJECT but was ");
        sb.append(GetContactSyncConfig());
        sb.append(" at path ");
        sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
        throw new JsonDataException(sb.toString());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final JsonReader.Token GetContactSyncConfig() throws IOException {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        switch (i) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x01da, code lost:
    
        if (BuiltInFictitiousFunctionClassFactory(r8) != false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01ff, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0200, code lost:
    
        if (r1 != 2) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0202, code lost:
    
        if (r4 == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0208, code lost:
    
        if (r6 != Long.MIN_VALUE) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x020a, code lost:
    
        if (r5 == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0210, code lost:
    
        if (r6 != 0) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0212, code lost:
    
        if (r5 != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0214, code lost:
    
        if (r5 != false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0216, code lost:
    
        r6 = -r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0217, code lost:
    
        r16.DatabaseTableConfigUtil = r6;
        r16.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0(r2);
        r16.NetworkUserEntityData$$ExternalSyntheticLambda2 = 16;
        r5 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0226, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0227, code lost:
    
        if (r1 == r3) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x022a, code lost:
    
        if (r1 == 4) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x022d, code lost:
    
        if (r1 != 7) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0232, code lost:
    
        r16.NetworkUserEntityData$$ExternalSyntheticLambda1 = r2;
        r16.NetworkUserEntityData$$ExternalSyntheticLambda2 = 17;
        r5 = 17;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x023c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int NetworkUserEntityData$$ExternalSyntheticLambda1() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 836
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.NetworkUserEntityData$$ExternalSyntheticLambda1():int");
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() throws IOException {
        String str;
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 14) {
            str = initRecordTimeStamp();
        } else if (i == 13) {
            str = BuiltInFictitiousFunctionClassFactory(lookAheadTest);
        } else if (i == 12) {
            str = BuiltInFictitiousFunctionClassFactory(getErrorConfigVersion);
        } else if (i == 15) {
            str = this.newProxyInstance;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a name but was ");
            sb.append(GetContactSyncConfig());
            sb.append(" at path ");
            sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb.toString());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        this.MyBillsEntityDataFactory[this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final int PlaceComponentResult(JsonReader.Options options) throws IOException {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return BuiltInFictitiousFunctionClassFactory(this.newProxyInstance, options);
        }
        int MyBillsEntityDataFactory = this.isLayoutRequested.MyBillsEntityDataFactory(options.PlaceComponentResult);
        if (MyBillsEntityDataFactory != -1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            this.MyBillsEntityDataFactory[this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1] = options.getAuthRequestContext[MyBillsEntityDataFactory];
            return MyBillsEntityDataFactory;
        }
        String str = this.MyBillsEntityDataFactory[this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1];
        String NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
        int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda0, options);
        if (BuiltInFictitiousFunctionClassFactory == -1) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 15;
            this.newProxyInstance = NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.MyBillsEntityDataFactory[this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1] = str;
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() throws IOException {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot skip unexpected ");
            sb.append(GetContactSyncConfig());
            sb.append(" at ");
            sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb.toString());
        }
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 14) {
            newProxyInstance();
        } else if (i == 13) {
            MyBillsEntityDataFactory(lookAheadTest);
        } else if (i == 12) {
            MyBillsEntityDataFactory(getErrorConfigVersion);
        } else if (i != 15) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected a name but was ");
            sb2.append(GetContactSyncConfig());
            sb2.append(" at path ");
            sb2.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb2.toString());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        this.MyBillsEntityDataFactory[this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1] = "null";
    }

    private int BuiltInFictitiousFunctionClassFactory(String str, JsonReader.Options options) {
        int length = options.getAuthRequestContext.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(options.getAuthRequestContext[i])) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
                this.MyBillsEntityDataFactory[this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1] = str;
                return i;
            }
        }
        return -1;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final String moveToNextValue() throws IOException {
        String KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 10) {
            KClassImpl$Data$declaredNonStaticMembers$2 = initRecordTimeStamp();
        } else if (i == 9) {
            KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory(lookAheadTest);
        } else if (i == 8) {
            KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory(getErrorConfigVersion);
        } else if (i == 11) {
            KClassImpl$Data$declaredNonStaticMembers$2 = this.newProxyInstance;
            this.newProxyInstance = null;
        } else if (i == 16) {
            KClassImpl$Data$declaredNonStaticMembers$2 = Long.toString(this.DatabaseTableConfigUtil);
        } else if (i != 17) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a string but was ");
            sb.append(GetContactSyncConfig());
            sb.append(" at path ");
            sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb.toString());
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1, Util.PlaceComponentResult);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        int[] iArr = this.getAuthRequestContext;
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
        iArr[i2] = iArr[i2] + 1;
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final boolean getErrorConfigVersion() throws IOException {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 5) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            int[] iArr = this.getAuthRequestContext;
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            int[] iArr2 = this.getAuthRequestContext;
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a boolean but was ");
            sb.append(GetContactSyncConfig());
            sb.append(" at path ");
            sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb.toString());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final double lookAheadTest() throws IOException {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 16) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            int[] iArr = this.getAuthRequestContext;
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.DatabaseTableConfigUtil;
        }
        if (i == 17) {
            this.newProxyInstance = this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1, Util.PlaceComponentResult);
        } else if (i == 9) {
            this.newProxyInstance = BuiltInFictitiousFunctionClassFactory(lookAheadTest);
        } else if (i == 8) {
            this.newProxyInstance = BuiltInFictitiousFunctionClassFactory(getErrorConfigVersion);
        } else if (i == 10) {
            this.newProxyInstance = initRecordTimeStamp();
        } else if (i != 11) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a double but was ");
            sb.append(GetContactSyncConfig());
            sb.append(" at path ");
            sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb.toString());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 11;
        try {
            double parseDouble = Double.parseDouble(this.newProxyInstance);
            if (!this.PlaceComponentResult && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("JSON forbids NaN and infinities: ");
                sb2.append(parseDouble);
                sb2.append(" at path ");
                sb2.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
                throw new JsonEncodingException(sb2.toString());
            }
            this.newProxyInstance = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            int[] iArr2 = this.getAuthRequestContext;
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Expected a double but was ");
            sb3.append(this.newProxyInstance);
            sb3.append(" at path ");
            sb3.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb3.toString());
        }
    }

    private String BuiltInFictitiousFunctionClassFactory(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long MyBillsEntityDataFactory = this.isLayoutRequested.MyBillsEntityDataFactory(byteString);
            if (MyBillsEntityDataFactory == -1) {
                throw BuiltInFictitiousFunctionClassFactory("Unterminated string");
            }
            if (this.GetContactSyncConfig.getAuthRequestContext(MyBillsEntityDataFactory) != 92) {
                if (sb != null) {
                    sb.append(this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, Util.PlaceComponentResult));
                    this.GetContactSyncConfig.initRecordTimeStamp();
                    return sb.toString();
                }
                String KClassImpl$Data$declaredNonStaticMembers$2 = this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, Util.PlaceComponentResult);
                this.GetContactSyncConfig.initRecordTimeStamp();
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, Util.PlaceComponentResult));
            this.GetContactSyncConfig.initRecordTimeStamp();
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda8());
        }
    }

    private String initRecordTimeStamp() throws IOException {
        long MyBillsEntityDataFactory = this.isLayoutRequested.MyBillsEntityDataFactory(initRecordTimeStamp);
        if (MyBillsEntityDataFactory == -1) {
            return this.GetContactSyncConfig.FragmentBottomSheetPaymentSettingBinding();
        }
        return this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, Util.PlaceComponentResult);
    }

    private void MyBillsEntityDataFactory(ByteString byteString) throws IOException {
        while (true) {
            long MyBillsEntityDataFactory = this.isLayoutRequested.MyBillsEntityDataFactory(byteString);
            if (MyBillsEntityDataFactory == -1) {
                throw BuiltInFictitiousFunctionClassFactory("Unterminated string");
            }
            if (this.GetContactSyncConfig.getAuthRequestContext(MyBillsEntityDataFactory) == 92) {
                this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0(MyBillsEntityDataFactory + 1);
                NetworkUserEntityData$$ExternalSyntheticLambda8();
            } else {
                this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0(MyBillsEntityDataFactory + 1);
                return;
            }
        }
    }

    private void newProxyInstance() throws IOException {
        long MyBillsEntityDataFactory = this.isLayoutRequested.MyBillsEntityDataFactory(initRecordTimeStamp);
        Buffer buffer = this.GetContactSyncConfig;
        if (MyBillsEntityDataFactory == -1) {
            MyBillsEntityDataFactory = buffer.getAuthRequestContext;
        }
        buffer.NetworkUserEntityData$$ExternalSyntheticLambda0(MyBillsEntityDataFactory);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final int scheduleImpl() throws IOException {
        String BuiltInFictitiousFunctionClassFactory;
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (i == 16) {
            long j = this.DatabaseTableConfigUtil;
            int i2 = (int) j;
            if (j != i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected an int but was ");
                sb.append(this.DatabaseTableConfigUtil);
                sb.append(" at path ");
                sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
                throw new JsonDataException(sb.toString());
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            int[] iArr = this.getAuthRequestContext;
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 17) {
            this.newProxyInstance = this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1, Util.PlaceComponentResult);
        } else if (i == 9 || i == 8) {
            if (i == 9) {
                BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(lookAheadTest);
            } else {
                BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(getErrorConfigVersion);
            }
            this.newProxyInstance = BuiltInFictitiousFunctionClassFactory;
            try {
                int parseInt = Integer.parseInt(BuiltInFictitiousFunctionClassFactory);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
                int[] iArr2 = this.getAuthRequestContext;
                int i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected an int but was ");
            sb2.append(GetContactSyncConfig());
            sb2.append(" at path ");
            sb2.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb2.toString());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 11;
        try {
            double parseDouble = Double.parseDouble(this.newProxyInstance);
            int i5 = (int) parseDouble;
            if (i5 != parseDouble) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Expected an int but was ");
                sb3.append(this.newProxyInstance);
                sb3.append(" at path ");
                sb3.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
                throw new JsonDataException(sb3.toString());
            }
            this.newProxyInstance = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            int[] iArr3 = this.getAuthRequestContext;
            int i6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        } catch (NumberFormatException unused2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Expected an int but was ");
            sb4.append(this.newProxyInstance);
            sb4.append(" at path ");
            sb4.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb4.toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        this.BuiltInFictitiousFunctionClassFactory[0] = 8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
        Buffer buffer = this.GetContactSyncConfig;
        try {
            buffer.NetworkUserEntityData$$ExternalSyntheticLambda0(buffer.getAuthRequestContext);
            this.isLayoutRequested.close();
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void DatabaseTableConfigUtil() throws IOException {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot skip unexpected ");
            sb.append(GetContactSyncConfig());
            sb.append(" at ");
            sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
            throw new JsonDataException(sb.toString());
        }
        int i = 0;
        do {
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (i2 == 0) {
                i2 = NetworkUserEntityData$$ExternalSyntheticLambda1();
            }
            if (i2 == 3) {
                MyBillsEntityDataFactory(1);
            } else if (i2 == 1) {
                MyBillsEntityDataFactory(3);
            } else {
                if (i2 == 4) {
                    i--;
                    if (i < 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected a value but was ");
                        sb2.append(GetContactSyncConfig());
                        sb2.append(" at path ");
                        sb2.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
                        throw new JsonDataException(sb2.toString());
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0--;
                } else if (i2 == 2) {
                    i--;
                    if (i < 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Expected a value but was ");
                        sb3.append(GetContactSyncConfig());
                        sb3.append(" at path ");
                        sb3.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
                        throw new JsonDataException(sb3.toString());
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0--;
                } else if (i2 == 14 || i2 == 10) {
                    newProxyInstance();
                } else if (i2 == 9 || i2 == 13) {
                    MyBillsEntityDataFactory(lookAheadTest);
                } else if (i2 == 8 || i2 == 12) {
                    MyBillsEntityDataFactory(getErrorConfigVersion);
                } else if (i2 == 17) {
                    this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                } else if (i2 == 18) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Expected a value but was ");
                    sb4.append(GetContactSyncConfig());
                    sb4.append(" at path ");
                    sb4.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
                    throw new JsonDataException(sb4.toString());
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            }
            i++;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
        } while (i != 0);
        int[] iArr = this.getAuthRequestContext;
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.MyBillsEntityDataFactory[this.NetworkUserEntityData$$ExternalSyntheticLambda0 - 1] = "null";
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r6.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0((long) (r2 - 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        if (r0 != 47) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (r6.isLayoutRequested.getErrorConfigVersion(2) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        if (r6.PlaceComponentResult == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
    
        r1 = r6.GetContactSyncConfig.getAuthRequestContext(1L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if (r1 == 42) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if (r1 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        r6.GetContactSyncConfig.initRecordTimeStamp();
        r6.GetContactSyncConfig.initRecordTimeStamp();
        NetworkUserEntityData$$ExternalSyntheticLambda7();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
    
        r6.GetContactSyncConfig.initRecordTimeStamp();
        r6.GetContactSyncConfig.initRecordTimeStamp();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        if (PrepareContext() == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        throw BuiltInFictitiousFunctionClassFactory("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
    
        throw BuiltInFictitiousFunctionClassFactory("Use JsonReader.setLenient(true) to accept malformed JSON");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        if (r0 != 35) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
    
        if (r6.PlaceComponentResult == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
    
        NetworkUserEntityData$$ExternalSyntheticLambda7();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008b, code lost:
    
        throw BuiltInFictitiousFunctionClassFactory("Use JsonReader.setLenient(true) to accept malformed JSON");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int MyBillsEntityDataFactory(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
        L0:
            r0 = 0
        L1:
            okio.BufferedSource r1 = r6.isLayoutRequested
            int r2 = r0 + 1
            long r3 = (long) r2
            boolean r1 = r1.getErrorConfigVersion(r3)
            if (r1 == 0) goto L90
            okio.Buffer r1 = r6.GetContactSyncConfig
            long r3 = (long) r0
            byte r0 = r1.getAuthRequestContext(r3)
            r1 = 10
            if (r0 == r1) goto L8d
            r1 = 32
            if (r0 == r1) goto L8d
            r1 = 13
            if (r0 == r1) goto L8d
            r1 = 9
            if (r0 == r1) goto L8d
            okio.Buffer r1 = r6.GetContactSyncConfig
            int r2 = r2 + (-1)
            long r2 = (long) r2
            r1.NetworkUserEntityData$$ExternalSyntheticLambda0(r2)
            java.lang.String r1 = "Use JsonReader.setLenient(true) to accept malformed JSON"
            r2 = 47
            if (r0 != r2) goto L7a
            okio.BufferedSource r3 = r6.isLayoutRequested
            r4 = 2
            boolean r3 = r3.getErrorConfigVersion(r4)
            if (r3 != 0) goto L3c
            return r0
        L3c:
            boolean r3 = r6.PlaceComponentResult
            if (r3 == 0) goto L75
            okio.Buffer r1 = r6.GetContactSyncConfig
            r3 = 1
            byte r1 = r1.getAuthRequestContext(r3)
            r3 = 42
            if (r1 == r3) goto L5d
            if (r1 == r2) goto L4f
            return r0
        L4f:
            okio.Buffer r0 = r6.GetContactSyncConfig
            r0.initRecordTimeStamp()
            okio.Buffer r0 = r6.GetContactSyncConfig
            r0.initRecordTimeStamp()
            r6.NetworkUserEntityData$$ExternalSyntheticLambda7()
            goto L0
        L5d:
            okio.Buffer r0 = r6.GetContactSyncConfig
            r0.initRecordTimeStamp()
            okio.Buffer r0 = r6.GetContactSyncConfig
            r0.initRecordTimeStamp()
            boolean r0 = r6.PrepareContext()
            if (r0 == 0) goto L6e
            goto L0
        L6e:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.BuiltInFictitiousFunctionClassFactory(r7)
            throw r7
        L75:
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.BuiltInFictitiousFunctionClassFactory(r1)
            throw r7
        L7a:
            r2 = 35
            if (r0 != r2) goto L8c
            boolean r0 = r6.PlaceComponentResult
            if (r0 == 0) goto L87
            r6.NetworkUserEntityData$$ExternalSyntheticLambda7()
            goto L0
        L87:
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.BuiltInFictitiousFunctionClassFactory(r1)
            throw r7
        L8c:
            return r0
        L8d:
            r0 = r2
            goto L1
        L90:
            if (r7 != 0) goto L94
            r7 = -1
            return r7
        L94:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            goto L9d
        L9c:
            throw r7
        L9d:
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.MyBillsEntityDataFactory(boolean):int");
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda7() throws IOException {
        long MyBillsEntityDataFactory = this.isLayoutRequested.MyBillsEntityDataFactory(scheduleImpl);
        Buffer buffer = this.GetContactSyncConfig;
        buffer.NetworkUserEntityData$$ExternalSyntheticLambda0(MyBillsEntityDataFactory != -1 ? MyBillsEntityDataFactory + 1 : buffer.getAuthRequestContext);
    }

    private boolean PrepareContext() throws IOException {
        long KClassImpl$Data$declaredNonStaticMembers$2 = this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2(moveToNextValue);
        boolean z = KClassImpl$Data$declaredNonStaticMembers$2 != -1;
        Buffer buffer = this.GetContactSyncConfig;
        buffer.NetworkUserEntityData$$ExternalSyntheticLambda0(z ? KClassImpl$Data$declaredNonStaticMembers$2 + r1.size() : buffer.getAuthRequestContext);
        return z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JsonReader(");
        sb.append(this.isLayoutRequested);
        sb.append(")");
        return sb.toString();
    }

    private char NetworkUserEntityData$$ExternalSyntheticLambda8() throws IOException {
        int i;
        int i2;
        if (!this.isLayoutRequested.getErrorConfigVersion(1L)) {
            throw BuiltInFictitiousFunctionClassFactory("Unterminated escape sequence");
        }
        byte initRecordTimeStamp2 = this.GetContactSyncConfig.initRecordTimeStamp();
        if (initRecordTimeStamp2 == 10 || initRecordTimeStamp2 == 34 || initRecordTimeStamp2 == 39 || initRecordTimeStamp2 == 47 || initRecordTimeStamp2 == 92) {
            return (char) initRecordTimeStamp2;
        }
        if (initRecordTimeStamp2 != 98) {
            if (initRecordTimeStamp2 != 102) {
                if (initRecordTimeStamp2 != 110) {
                    if (initRecordTimeStamp2 != 114) {
                        if (initRecordTimeStamp2 != 116) {
                            if (initRecordTimeStamp2 == 117) {
                                if (!this.isLayoutRequested.getErrorConfigVersion(4L)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Unterminated escape sequence at path ");
                                    sb.append(JsonScope.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
                                    throw new EOFException(sb.toString());
                                }
                                char c = 0;
                                for (int i3 = 0; i3 < 4; i3++) {
                                    byte authRequestContext = this.GetContactSyncConfig.getAuthRequestContext(i3);
                                    char c2 = (char) (c << 4);
                                    if (authRequestContext < 48 || authRequestContext > 57) {
                                        if (authRequestContext >= 97 && authRequestContext <= 102) {
                                            i = authRequestContext - 97;
                                        } else if (authRequestContext < 65 || authRequestContext > 70) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("\\u");
                                            sb2.append(this.GetContactSyncConfig.KClassImpl$Data$declaredNonStaticMembers$2(4L, Util.PlaceComponentResult));
                                            throw BuiltInFictitiousFunctionClassFactory(sb2.toString());
                                        } else {
                                            i = authRequestContext - 65;
                                        }
                                        i2 = i + 10;
                                    } else {
                                        i2 = authRequestContext - 48;
                                    }
                                    c = (char) (c2 + i2);
                                }
                                this.GetContactSyncConfig.NetworkUserEntityData$$ExternalSyntheticLambda0(4L);
                                return c;
                            } else if (this.PlaceComponentResult) {
                                return (char) initRecordTimeStamp2;
                            } else {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Invalid escape sequence: \\");
                                sb3.append((char) initRecordTimeStamp2);
                                throw BuiltInFictitiousFunctionClassFactory(sb3.toString());
                            }
                        }
                        return '\t';
                    }
                    return '\r';
                }
                return '\n';
            }
            return '\f';
        }
        return '\b';
    }

    private boolean BuiltInFictitiousFunctionClassFactory(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        if (this.PlaceComponentResult) {
            return false;
        }
        throw BuiltInFictitiousFunctionClassFactory("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
}
