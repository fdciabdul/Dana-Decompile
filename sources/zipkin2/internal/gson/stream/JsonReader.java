package zipkin2.internal.gson.stream;

import com.google.gson.Gson;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import kotlin.text.Typography;
import zipkin2.internal.gson.internal.JsonReaderInternalAccess;

/* loaded from: classes9.dex */
public class JsonReader implements Closeable {
    private static final char[] getAuthRequestContext = Gson.JSON_NON_EXECUTABLE_PREFIX.toCharArray();
    private int[] GetContactSyncConfig;
    private final Reader KClassImpl$Data$declaredNonStaticMembers$2;
    private int[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private long initRecordTimeStamp;
    private String[] scheduleImpl;
    private boolean MyBillsEntityDataFactory = false;
    private final char[] BuiltInFictitiousFunctionClassFactory = new char[1024];
    private int DatabaseTableConfigUtil = 0;
    private int moveToNextValue = 0;
    private int getErrorConfigVersion = 0;
    private int lookAheadTest = 0;
    int PlaceComponentResult = 0;
    private int newProxyInstance = 1;

    static {
        JsonReaderInternalAccess.MyBillsEntityDataFactory = new JsonReaderInternalAccess() { // from class: zipkin2.internal.gson.stream.JsonReader.1
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.GetContactSyncConfig = iArr;
        iArr[0] = 6;
        this.scheduleImpl = new String[32];
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new int[32];
        this.KClassImpl$Data$declaredNonStaticMembers$2 = reader;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        if (i == 3) {
            KClassImpl$Data$declaredNonStaticMembers$2(1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0[this.newProxyInstance - 1] = 0;
            this.PlaceComponentResult = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
        throw new IllegalStateException(sb.toString());
    }

    public final void MyBillsEntityDataFactory() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        if (i == 4) {
            int i2 = this.newProxyInstance - 1;
            this.newProxyInstance = i2;
            int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.PlaceComponentResult = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected END_ARRAY but was ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
        throw new IllegalStateException(sb.toString());
    }

    public final void BuiltInFictitiousFunctionClassFactory() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        if (i == 1) {
            KClassImpl$Data$declaredNonStaticMembers$2(3);
            this.PlaceComponentResult = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
        throw new IllegalStateException(sb.toString());
    }

    public final void getAuthRequestContext() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        if (i == 2) {
            int i2 = this.newProxyInstance - 1;
            this.newProxyInstance = i2;
            this.scheduleImpl[i2] = null;
            int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.PlaceComponentResult = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected END_OBJECT but was ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
        throw new IllegalStateException(sb.toString());
    }

    public final boolean lookAheadTest() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final JsonToken NetworkUserEntityData$$ExternalSyntheticLambda2() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    private int NetworkUserEntityData$$ExternalSyntheticLambda3() throws IOException {
        int BuiltInFictitiousFunctionClassFactory;
        int[] iArr = this.GetContactSyncConfig;
        int i = this.newProxyInstance - 1;
        int i2 = iArr[i];
        if (i2 == 1) {
            iArr[i] = 2;
        } else if (i2 == 2) {
            int BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(true);
            if (BuiltInFictitiousFunctionClassFactory2 != 44) {
                if (BuiltInFictitiousFunctionClassFactory2 != 59) {
                    if (BuiltInFictitiousFunctionClassFactory2 == 93) {
                        this.PlaceComponentResult = 4;
                        return 4;
                    }
                    throw getAuthRequestContext("Unterminated array");
                } else if (!this.MyBillsEntityDataFactory) {
                    throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
                }
            }
        } else if (i2 == 3 || i2 == 5) {
            iArr[i] = 4;
            if (i2 == 5 && (BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(true)) != 44) {
                if (BuiltInFictitiousFunctionClassFactory != 59) {
                    if (BuiltInFictitiousFunctionClassFactory == 125) {
                        this.PlaceComponentResult = 2;
                        return 2;
                    }
                    throw getAuthRequestContext("Unterminated object");
                } else if (!this.MyBillsEntityDataFactory) {
                    throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
                }
            }
            int BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(true);
            if (BuiltInFictitiousFunctionClassFactory3 == 34) {
                this.PlaceComponentResult = 13;
                return 13;
            } else if (BuiltInFictitiousFunctionClassFactory3 == 39) {
                if (this.MyBillsEntityDataFactory) {
                    this.PlaceComponentResult = 12;
                    return 12;
                }
                throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
            } else if (BuiltInFictitiousFunctionClassFactory3 == 125) {
                if (i2 != 5) {
                    this.PlaceComponentResult = 2;
                    return 2;
                }
                throw getAuthRequestContext("Expected name");
            } else if (this.MyBillsEntityDataFactory) {
                this.DatabaseTableConfigUtil--;
                if (KClassImpl$Data$declaredNonStaticMembers$2((char) BuiltInFictitiousFunctionClassFactory3)) {
                    this.PlaceComponentResult = 14;
                    return 14;
                }
                throw getAuthRequestContext("Expected name");
            } else {
                throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
            }
        } else if (i2 == 4) {
            iArr[i] = 5;
            int BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(true);
            if (BuiltInFictitiousFunctionClassFactory4 != 58) {
                if (BuiltInFictitiousFunctionClassFactory4 != 61) {
                    throw getAuthRequestContext("Expected ':'");
                }
                if (this.MyBillsEntityDataFactory) {
                    if (this.DatabaseTableConfigUtil < this.moveToNextValue || PlaceComponentResult(1)) {
                        char[] cArr = this.BuiltInFictitiousFunctionClassFactory;
                        int i3 = this.DatabaseTableConfigUtil;
                        if (cArr[i3] == '>') {
                            this.DatabaseTableConfigUtil = i3 + 1;
                        }
                    }
                } else {
                    throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
                }
            }
        } else if (i2 == 6) {
            if (this.MyBillsEntityDataFactory) {
                NetworkUserEntityData$$ExternalSyntheticLambda1();
            }
            this.GetContactSyncConfig[this.newProxyInstance - 1] = 7;
        } else if (i2 == 7) {
            if (BuiltInFictitiousFunctionClassFactory(false) == -1) {
                this.PlaceComponentResult = 17;
                return 17;
            } else if (this.MyBillsEntityDataFactory) {
                this.DatabaseTableConfigUtil--;
            } else {
                throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
            }
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int BuiltInFictitiousFunctionClassFactory5 = BuiltInFictitiousFunctionClassFactory(true);
        if (BuiltInFictitiousFunctionClassFactory5 == 34) {
            this.PlaceComponentResult = 9;
            return 9;
        } else if (BuiltInFictitiousFunctionClassFactory5 == 39) {
            if (this.MyBillsEntityDataFactory) {
                this.PlaceComponentResult = 8;
                return 8;
            }
            throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
        } else {
            if (BuiltInFictitiousFunctionClassFactory5 != 44 && BuiltInFictitiousFunctionClassFactory5 != 59) {
                if (BuiltInFictitiousFunctionClassFactory5 == 91) {
                    this.PlaceComponentResult = 3;
                    return 3;
                } else if (BuiltInFictitiousFunctionClassFactory5 != 93) {
                    if (BuiltInFictitiousFunctionClassFactory5 == 123) {
                        this.PlaceComponentResult = 1;
                        return 1;
                    }
                    this.DatabaseTableConfigUtil--;
                    int newProxyInstance = newProxyInstance();
                    if (newProxyInstance != 0) {
                        return newProxyInstance;
                    }
                    int NetworkUserEntityData$$ExternalSyntheticLambda8 = NetworkUserEntityData$$ExternalSyntheticLambda8();
                    if (NetworkUserEntityData$$ExternalSyntheticLambda8 != 0) {
                        return NetworkUserEntityData$$ExternalSyntheticLambda8;
                    }
                    if (!KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory[this.DatabaseTableConfigUtil])) {
                        throw getAuthRequestContext("Expected value");
                    }
                    if (this.MyBillsEntityDataFactory) {
                        this.PlaceComponentResult = 10;
                        return 10;
                    }
                    throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
                } else if (i2 == 1) {
                    this.PlaceComponentResult = 4;
                    return 4;
                }
            }
            if (i2 != 1 && i2 != 2) {
                throw getAuthRequestContext("Unexpected value");
            }
            if (this.MyBillsEntityDataFactory) {
                this.DatabaseTableConfigUtil--;
                this.PlaceComponentResult = 7;
                return 7;
            }
            throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int newProxyInstance() throws IOException {
        int i;
        String str;
        String str2;
        char c = this.BuiltInFictitiousFunctionClassFactory[this.DatabaseTableConfigUtil];
        if (c == 't' || c == 'T') {
            i = 5;
            str = SummaryActivity.CHECKED;
            str2 = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.DatabaseTableConfigUtil + i2 >= this.moveToNextValue && !PlaceComponentResult(i2 + 1)) {
                return 0;
            }
            char c2 = this.BuiltInFictitiousFunctionClassFactory[this.DatabaseTableConfigUtil + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.DatabaseTableConfigUtil + length < this.moveToNextValue || PlaceComponentResult(length + 1)) && KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory[this.DatabaseTableConfigUtil + length])) {
            return 0;
        }
        this.DatabaseTableConfigUtil += length;
        this.PlaceComponentResult = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0091, code lost:
    
        if (KClassImpl$Data$declaredNonStaticMembers$2(r14) != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        if (r9 != 2) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
    
        if (r10 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009b, code lost:
    
        if (r12 != Long.MIN_VALUE) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009d, code lost:
    
        if (r11 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a3, code lost:
    
        if (r12 != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a5, code lost:
    
        if (r11 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a7, code lost:
    
        if (r11 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a9, code lost:
    
        r12 = -r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00aa, code lost:
    
        r18.initRecordTimeStamp = r12;
        r18.DatabaseTableConfigUtil += r8;
        r18.PlaceComponentResult = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b5, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b6, code lost:
    
        if (r9 == 2) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b9, code lost:
    
        if (r9 == 4) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bc, code lost:
    
        if (r9 == 7) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c0, code lost:
    
        r18.NetworkUserEntityData$$ExternalSyntheticLambda2 = r8;
        r18.PlaceComponentResult = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c6, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int NetworkUserEntityData$$ExternalSyntheticLambda8() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.internal.gson.stream.JsonReader.NetworkUserEntityData$$ExternalSyntheticLambda8():int");
    }

    public final String getErrorConfigVersion() throws IOException {
        String PlaceComponentResult;
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        if (i == 14) {
            PlaceComponentResult = GetContactSyncConfig();
        } else if (i == 12) {
            PlaceComponentResult = PlaceComponentResult('\'');
        } else if (i == 13) {
            PlaceComponentResult = PlaceComponentResult(Typography.quote);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a name but was ");
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
            throw new IllegalStateException(sb.toString());
        }
        this.PlaceComponentResult = 0;
        this.scheduleImpl[this.newProxyInstance - 1] = PlaceComponentResult;
        return PlaceComponentResult;
    }

    public final String initRecordTimeStamp() throws IOException {
        String str;
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        if (i == 10) {
            str = GetContactSyncConfig();
        } else if (i == 8) {
            str = PlaceComponentResult('\'');
        } else if (i == 9) {
            str = PlaceComponentResult(Typography.quote);
        } else if (i == 11) {
            str = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        } else if (i == 15) {
            str = Long.toString(this.initRecordTimeStamp);
        } else if (i == 16) {
            str = new String(this.BuiltInFictitiousFunctionClassFactory, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.DatabaseTableConfigUtil += this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a string but was ");
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
            throw new IllegalStateException(sb.toString());
        }
        this.PlaceComponentResult = 0;
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i2 = this.newProxyInstance - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final boolean moveToNextValue() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        if (i == 5) {
            this.PlaceComponentResult = 0;
            int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i2 = this.newProxyInstance - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.PlaceComponentResult = 0;
            int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i3 = this.newProxyInstance - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a boolean but was ");
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
            throw new IllegalStateException(sb.toString());
        }
    }

    public final long NetworkUserEntityData$$ExternalSyntheticLambda0() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        if (i == 15) {
            this.PlaceComponentResult = 0;
            int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i2 = this.newProxyInstance - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.initRecordTimeStamp;
        }
        if (i == 16) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new String(this.BuiltInFictitiousFunctionClassFactory, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.DatabaseTableConfigUtil += this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetContactSyncConfig();
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PlaceComponentResult(i == 8 ? '\'' : Typography.quote);
            }
            try {
                long parseLong = Long.parseLong(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                this.PlaceComponentResult = 0;
                int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                int i3 = this.newProxyInstance - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a long but was ");
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
            throw new IllegalStateException(sb.toString());
        }
        this.PlaceComponentResult = 11;
        double parseDouble = Double.parseDouble(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        long j = (long) parseDouble;
        if (j != parseDouble) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected a long but was ");
            sb2.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            sb2.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
            throw new NumberFormatException(sb2.toString());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.PlaceComponentResult = 0;
        int[] iArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i4 = this.newProxyInstance - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r4 - r2) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0069, code lost:
    
        r1.append(r0, r2, r4 - r2);
        r9.DatabaseTableConfigUtil = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String PlaceComponentResult(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.BuiltInFictitiousFunctionClassFactory
            r1 = 0
        L3:
            int r2 = r9.DatabaseTableConfigUtil
            int r3 = r9.moveToNextValue
        L7:
            r4 = r2
        L8:
            r5 = 16
            r6 = 1
            if (r4 >= r3) goto L5a
            int r7 = r4 + 1
            char r4 = r0[r4]
            if (r4 != r10) goto L27
            r9.DatabaseTableConfigUtil = r7
            int r7 = r7 - r2
            int r7 = r7 - r6
            if (r1 != 0) goto L1f
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r2, r7)
            return r10
        L1f:
            r1.append(r0, r2, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L27:
            r8 = 92
            if (r4 != r8) goto L4d
            r9.DatabaseTableConfigUtil = r7
            int r7 = r7 - r2
            int r7 = r7 - r6
            if (r1 != 0) goto L3e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r3 = r7 + 1
            int r3 = r3 * 2
            int r3 = java.lang.Math.max(r3, r5)
            r1.<init>(r3)
        L3e:
            r1.append(r0, r2, r7)
            char r2 = r9.NetworkUserEntityData$$ExternalSyntheticLambda7()
            r1.append(r2)
            int r2 = r9.DatabaseTableConfigUtil
            int r3 = r9.moveToNextValue
            goto L7
        L4d:
            r5 = 10
            if (r4 != r5) goto L58
            int r4 = r9.getErrorConfigVersion
            int r4 = r4 + r6
            r9.getErrorConfigVersion = r4
            r9.lookAheadTest = r7
        L58:
            r4 = r7
            goto L8
        L5a:
            if (r1 != 0) goto L69
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r3 = r4 - r2
            int r3 = r3 * 2
            int r3 = java.lang.Math.max(r3, r5)
            r1.<init>(r3)
        L69:
            int r3 = r4 - r2
            r1.append(r0, r2, r3)
            r9.DatabaseTableConfigUtil = r4
            boolean r2 = r9.PlaceComponentResult(r6)
            if (r2 == 0) goto L77
            goto L3
        L77:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.getAuthRequestContext(r10)
            goto L7f
        L7e:
            throw r10
        L7f:
            goto L7e
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.internal.gson.stream.JsonReader.PlaceComponentResult(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004a, code lost:
    
        if (r5.MyBillsEntityDataFactory == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0053, code lost:
    
        throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String GetContactSyncConfig() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
        L1:
            r1 = 0
            r2 = 0
        L3:
            int r3 = r5.DatabaseTableConfigUtil
            int r3 = r3 + r2
            int r4 = r5.moveToNextValue
            if (r3 >= r4) goto L54
            char[] r4 = r5.BuiltInFictitiousFunctionClassFactory
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L61
            r4 = 10
            if (r3 == r4) goto L61
            r4 = 12
            if (r3 == r4) goto L61
            r4 = 13
            if (r3 == r4) goto L61
            r4 = 32
            if (r3 == r4) goto L61
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L61
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L61
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L61
            r4 = 58
            if (r3 == r4) goto L61
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L61;
                case 92: goto L48;
                case 93: goto L61;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            boolean r1 = r5.MyBillsEntityDataFactory
            if (r1 == 0) goto L4d
            goto L61
        L4d:
            java.lang.String r0 = "Use JsonReader.setLenient(true) to accept malformed JSON"
            java.io.IOException r0 = r5.getAuthRequestContext(r0)
            throw r0
        L54:
            char[] r3 = r5.BuiltInFictitiousFunctionClassFactory
            int r3 = r3.length
            if (r2 >= r3) goto L63
            int r3 = r2 + 1
            boolean r3 = r5.PlaceComponentResult(r3)
            if (r3 != 0) goto L3
        L61:
            r1 = r2
            goto L83
        L63:
            if (r0 != 0) goto L70
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L70:
            char[] r3 = r5.BuiltInFictitiousFunctionClassFactory
            int r4 = r5.DatabaseTableConfigUtil
            r0.append(r3, r4, r2)
            int r3 = r5.DatabaseTableConfigUtil
            int r3 = r3 + r2
            r5.DatabaseTableConfigUtil = r3
            r2 = 1
            boolean r2 = r5.PlaceComponentResult(r2)
            if (r2 != 0) goto L1
        L83:
            if (r0 != 0) goto L8f
            java.lang.String r0 = new java.lang.String
            char[] r2 = r5.BuiltInFictitiousFunctionClassFactory
            int r3 = r5.DatabaseTableConfigUtil
            r0.<init>(r2, r3, r1)
            goto L9a
        L8f:
            char[] r2 = r5.BuiltInFictitiousFunctionClassFactory
            int r3 = r5.DatabaseTableConfigUtil
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L9a:
            int r2 = r5.DatabaseTableConfigUtil
            int r2 = r2 + r1
            r5.DatabaseTableConfigUtil = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.internal.gson.stream.JsonReader.GetContactSyncConfig():java.lang.String");
    }

    private void BuiltInFictitiousFunctionClassFactory(char c) throws IOException {
        char[] cArr = this.BuiltInFictitiousFunctionClassFactory;
        while (true) {
            int i = this.DatabaseTableConfigUtil;
            int i2 = this.moveToNextValue;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.DatabaseTableConfigUtil = i3;
                        return;
                    } else if (c2 == '\\') {
                        this.DatabaseTableConfigUtil = i3;
                        NetworkUserEntityData$$ExternalSyntheticLambda7();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.getErrorConfigVersion++;
                            this.lookAheadTest = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.DatabaseTableConfigUtil = i;
                    if (!PlaceComponentResult(1)) {
                        throw getAuthRequestContext("Unterminated string");
                    }
                }
            }
        }
    }

    private void PrepareContext() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.DatabaseTableConfigUtil + i;
                if (i2 < this.moveToNextValue) {
                    char c = this.BuiltInFictitiousFunctionClassFactory[i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.DatabaseTableConfigUtil = i2;
                }
            }
            if (!this.MyBillsEntityDataFactory) {
                throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
            }
            this.DatabaseTableConfigUtil += i;
            return;
        } while (PlaceComponentResult(1));
    }

    public final int scheduleImpl() throws IOException {
        int i = this.PlaceComponentResult;
        if (i == 0) {
            i = NetworkUserEntityData$$ExternalSyntheticLambda3();
        }
        if (i == 15) {
            long j = this.initRecordTimeStamp;
            int i2 = (int) j;
            if (j != i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected an int but was ");
                sb.append(this.initRecordTimeStamp);
                sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
                throw new NumberFormatException(sb.toString());
            }
            this.PlaceComponentResult = 0;
            int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i3 = this.newProxyInstance - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new String(this.BuiltInFictitiousFunctionClassFactory, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            this.DatabaseTableConfigUtil += this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = GetContactSyncConfig();
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PlaceComponentResult(i == 8 ? '\'' : Typography.quote);
            }
            try {
                int parseInt = Integer.parseInt(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                this.PlaceComponentResult = 0;
                int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                int i4 = this.newProxyInstance - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected an int but was ");
            sb2.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
            sb2.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
            throw new IllegalStateException(sb2.toString());
        }
        this.PlaceComponentResult = 11;
        double parseDouble = Double.parseDouble(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        int i5 = (int) parseDouble;
        if (i5 != parseDouble) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Expected an int but was ");
            sb3.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            sb3.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
            throw new NumberFormatException(sb3.toString());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.PlaceComponentResult = 0;
        int[] iArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i6 = this.newProxyInstance - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.PlaceComponentResult = 0;
        this.GetContactSyncConfig[0] = 8;
        this.newProxyInstance = 1;
        this.KClassImpl$Data$declaredNonStaticMembers$2.close();
    }

    public final void DatabaseTableConfigUtil() throws IOException {
        int i = 0;
        do {
            int i2 = this.PlaceComponentResult;
            if (i2 == 0) {
                i2 = NetworkUserEntityData$$ExternalSyntheticLambda3();
            }
            if (i2 == 3) {
                KClassImpl$Data$declaredNonStaticMembers$2(1);
            } else if (i2 == 1) {
                KClassImpl$Data$declaredNonStaticMembers$2(3);
            } else {
                if (i2 == 4) {
                    this.newProxyInstance--;
                } else if (i2 == 2) {
                    this.newProxyInstance--;
                } else {
                    if (i2 == 14 || i2 == 10) {
                        PrepareContext();
                    } else if (i2 == 8 || i2 == 12) {
                        BuiltInFictitiousFunctionClassFactory('\'');
                    } else if (i2 == 9 || i2 == 13) {
                        BuiltInFictitiousFunctionClassFactory(Typography.quote);
                    } else if (i2 == 16) {
                        this.DatabaseTableConfigUtil += this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    }
                    this.PlaceComponentResult = 0;
                }
                i--;
                this.PlaceComponentResult = 0;
            }
            i++;
            this.PlaceComponentResult = 0;
        } while (i != 0);
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i3 = this.newProxyInstance - 1;
        iArr[i3] = iArr[i3] + 1;
        this.scheduleImpl[i3] = "null";
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int i2 = this.newProxyInstance;
        int[] iArr = this.GetContactSyncConfig;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.GetContactSyncConfig = Arrays.copyOf(iArr, i3);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Arrays.copyOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0, i3);
            this.scheduleImpl = (String[]) Arrays.copyOf(this.scheduleImpl, i3);
        }
        int[] iArr2 = this.GetContactSyncConfig;
        int i4 = this.newProxyInstance;
        this.newProxyInstance = i4 + 1;
        iArr2[i4] = i;
    }

    private boolean PlaceComponentResult(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.BuiltInFictitiousFunctionClassFactory;
        int i4 = this.lookAheadTest;
        int i5 = this.DatabaseTableConfigUtil;
        this.lookAheadTest = i4 - i5;
        int i6 = this.moveToNextValue;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.moveToNextValue = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.moveToNextValue = 0;
        }
        this.DatabaseTableConfigUtil = 0;
        do {
            Reader reader = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i8 = this.moveToNextValue;
            int read = reader.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.moveToNextValue + read;
            this.moveToNextValue = i2;
            if (this.getErrorConfigVersion == 0 && (i3 = this.lookAheadTest) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.DatabaseTableConfigUtil++;
                this.lookAheadTest = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private int BuiltInFictitiousFunctionClassFactory(boolean z) throws IOException {
        char[] cArr = this.BuiltInFictitiousFunctionClassFactory;
        int i = this.DatabaseTableConfigUtil;
        int i2 = this.moveToNextValue;
        while (true) {
            if (i == i2) {
                this.DatabaseTableConfigUtil = i;
                if (!PlaceComponentResult(1)) {
                    if (z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("End of input");
                        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
                        throw new EOFException(sb.toString());
                    }
                    return -1;
                }
                i = this.DatabaseTableConfigUtil;
                i2 = this.moveToNextValue;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.getErrorConfigVersion++;
                this.lookAheadTest = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.DatabaseTableConfigUtil = i3;
                    if (i3 == i2) {
                        this.DatabaseTableConfigUtil = i3 - 1;
                        boolean PlaceComponentResult = PlaceComponentResult(2);
                        this.DatabaseTableConfigUtil++;
                        if (!PlaceComponentResult) {
                            return c;
                        }
                    }
                    if (this.MyBillsEntityDataFactory) {
                        int i4 = this.DatabaseTableConfigUtil;
                        char c2 = cArr[i4];
                        if (c2 == '*') {
                            this.DatabaseTableConfigUtil = i4 + 1;
                            if (!KClassImpl$Data$declaredNonStaticMembers$2("*/")) {
                                throw getAuthRequestContext("Unterminated comment");
                            }
                            i = this.DatabaseTableConfigUtil + 2;
                            i2 = this.moveToNextValue;
                        } else if (c2 != '/') {
                            return c;
                        } else {
                            this.DatabaseTableConfigUtil = i4 + 1;
                            isLayoutRequested();
                            i = this.DatabaseTableConfigUtil;
                            i2 = this.moveToNextValue;
                        }
                    } else {
                        throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
                    }
                } else if (c == '#') {
                    this.DatabaseTableConfigUtil = i3;
                    if (this.MyBillsEntityDataFactory) {
                        isLayoutRequested();
                        i = this.DatabaseTableConfigUtil;
                        i2 = this.moveToNextValue;
                    } else {
                        throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
                    }
                } else {
                    this.DatabaseTableConfigUtil = i3;
                    return c;
                }
            }
            i = i3;
        }
    }

    private void isLayoutRequested() throws IOException {
        char c;
        do {
            if (this.DatabaseTableConfigUtil >= this.moveToNextValue && !PlaceComponentResult(1)) {
                return;
            }
            char[] cArr = this.BuiltInFictitiousFunctionClassFactory;
            int i = this.DatabaseTableConfigUtil;
            int i2 = i + 1;
            this.DatabaseTableConfigUtil = i2;
            c = cArr[i];
            if (c == '\n') {
                this.getErrorConfigVersion++;
                this.lookAheadTest = i2;
                return;
            }
        } while (c != '\r');
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.DatabaseTableConfigUtil + length > this.moveToNextValue && !PlaceComponentResult(length)) {
                return false;
            }
            char[] cArr = this.BuiltInFictitiousFunctionClassFactory;
            int i = this.DatabaseTableConfigUtil;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.BuiltInFictitiousFunctionClassFactory[this.DatabaseTableConfigUtil + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.getErrorConfigVersion++;
            this.lookAheadTest = i + 1;
            this.DatabaseTableConfigUtil++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
        return sb.toString();
    }

    private String NetworkUserEntityData$$ExternalSyntheticLambda6() {
        int i = this.getErrorConfigVersion;
        int i2 = this.DatabaseTableConfigUtil;
        int i3 = this.lookAheadTest;
        StringBuilder sb = new StringBuilder();
        sb.append(" at line ");
        sb.append(i + 1);
        sb.append(" column ");
        sb.append((i2 - i3) + 1);
        sb.append(" path ");
        sb.append(PlaceComponentResult());
        return sb.toString();
    }

    public final String PlaceComponentResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        int i = this.newProxyInstance;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.GetContactSyncConfig[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.scheduleImpl[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    private char NetworkUserEntityData$$ExternalSyntheticLambda7() throws IOException {
        int i;
        int i2;
        if (this.DatabaseTableConfigUtil == this.moveToNextValue && !PlaceComponentResult(1)) {
            throw getAuthRequestContext("Unterminated escape sequence");
        }
        char[] cArr = this.BuiltInFictitiousFunctionClassFactory;
        int i3 = this.DatabaseTableConfigUtil;
        int i4 = i3 + 1;
        this.DatabaseTableConfigUtil = i4;
        char c = cArr[i3];
        if (c == '\n') {
            this.getErrorConfigVersion++;
            this.lookAheadTest = i4;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c != 'b') {
                if (c != 'f') {
                    if (c != 'n') {
                        if (c != 'r') {
                            if (c != 't') {
                                if (c == 'u') {
                                    if (i4 + 4 > this.moveToNextValue && !PlaceComponentResult(4)) {
                                        throw getAuthRequestContext("Unterminated escape sequence");
                                    }
                                    char c2 = 0;
                                    int i5 = this.DatabaseTableConfigUtil;
                                    for (int i6 = i5; i6 < i5 + 4; i6++) {
                                        char c3 = this.BuiltInFictitiousFunctionClassFactory[i6];
                                        char c4 = (char) (c2 << 4);
                                        if (c3 < '0' || c3 > '9') {
                                            if (c3 >= 'a' && c3 <= 'f') {
                                                i = c3 - 'a';
                                            } else if (c3 < 'A' || c3 > 'F') {
                                                StringBuilder sb = new StringBuilder();
                                                sb.append("\\u");
                                                sb.append(new String(this.BuiltInFictitiousFunctionClassFactory, this.DatabaseTableConfigUtil, 4));
                                                throw new NumberFormatException(sb.toString());
                                            } else {
                                                i = c3 - 'A';
                                            }
                                            i2 = i + 10;
                                        } else {
                                            i2 = c3 - '0';
                                        }
                                        c2 = (char) (c4 + i2);
                                    }
                                    this.DatabaseTableConfigUtil += 4;
                                    return c2;
                                }
                                throw getAuthRequestContext("Invalid escape sequence");
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
        return c;
    }

    private IOException getAuthRequestContext(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda6());
        throw new MalformedJsonException(sb.toString());
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda1() throws IOException {
        BuiltInFictitiousFunctionClassFactory(true);
        int i = this.DatabaseTableConfigUtil - 1;
        this.DatabaseTableConfigUtil = i;
        char[] cArr = getAuthRequestContext;
        if (i + cArr.length > this.moveToNextValue && !PlaceComponentResult(cArr.length)) {
            return;
        }
        int i2 = 0;
        while (true) {
            char[] cArr2 = getAuthRequestContext;
            if (i2 < cArr2.length) {
                if (this.BuiltInFictitiousFunctionClassFactory[this.DatabaseTableConfigUtil + i2] != cArr2[i2]) {
                    return;
                }
                i2++;
            } else {
                this.DatabaseTableConfigUtil += cArr2.length;
                return;
            }
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        if (this.MyBillsEntityDataFactory) {
            return false;
        }
        throw getAuthRequestContext("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
}
