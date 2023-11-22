package com.squareup.wire;

import android.telephony.cdma.CdmaCellLocation;
import android.util.TypedValue;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.cashier.view.InputCardNumberView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import o.getCallingPid;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class WireInput {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String ENCOUNTERED_A_MALFORMED_VARINT = "WireInput encountered a malformed varint.";
    private static final String ENCOUNTERED_A_NEGATIVE_SIZE = "Encountered a negative size";
    private static final String INPUT_ENDED_UNEXPECTEDLY = "The input ended unexpectedly in the middle of a field";
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static int MyBillsEntityDataFactory = 0;
    private static final String PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO = "Protocol message contained an invalid tag (zero).";
    private static final String PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG = "Protocol message end-group tag did not match expected tag.";
    private static char PlaceComponentResult = 0;
    public static final int RECURSION_LIMIT = 64;
    private static final Charset UTF_8;
    private static int getAuthRequestContext = 1;
    private int lastTag;
    public int recursionDepth;
    private final BufferedSource source;
    private int pos = 0;
    private int currentLimit = Integer.MAX_VALUE;

    public static int decodeZigZag32(int i) {
        int i2 = MyBillsEntityDataFactory + 49;
        getAuthRequestContext = i2 % 128;
        return (i >>> 1) ^ (-((i2 % 2 == 0 ? '[' : 'N') != '[' ? i & 1 : i ^ 1));
    }

    public static long decodeZigZag64(long j) {
        int i = getAuthRequestContext + 77;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        long j2 = (j >>> 1) ^ (-(1 & j));
        try {
            int i3 = MyBillsEntityDataFactory + 99;
            getAuthRequestContext = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return j2;
            }
            Object obj = null;
            obj.hashCode();
            return j2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void getAuthRequestContext() {
        PlaceComponentResult = (char) 42070;
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{42068, 42070, 42065, 37346, 42071, 37274, 37275, 37367, 37257};
    }

    static {
        getAuthRequestContext();
        Object[] objArr = new Object[1];
        a(new char[]{3, '\b', 6, 5, 13784}, (byte) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 54), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 5, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        int i = getAuthRequestContext + 97;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? (char) 7 : 'D') != 7) {
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
    }

    public static WireInput newInstance(byte[] bArr) {
        WireInput wireInput = new WireInput(new Buffer().KClassImpl$Data$declaredNonStaticMembers$2(bArr));
        int i = MyBillsEntityDataFactory + 1;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            int i2 = 43 / 0;
            return wireInput;
        }
        return wireInput;
    }

    public static WireInput newInstance(byte[] bArr, int i, int i2) {
        WireInput wireInput = new WireInput(new Buffer().MyBillsEntityDataFactory(bArr, i, i2));
        try {
            int i3 = MyBillsEntityDataFactory + 79;
            try {
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                return wireInput;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static WireInput newInstance(InputStream inputStream) {
        try {
            WireInput wireInput = new WireInput(Okio.KClassImpl$Data$declaredNonStaticMembers$2(Okio.getAuthRequestContext(inputStream)));
            int i = getAuthRequestContext + 1;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return wireInput;
        } catch (Exception e) {
            throw e;
        }
    }

    public static WireInput newInstance(Source source) {
        try {
            WireInput wireInput = new WireInput(Okio.KClassImpl$Data$declaredNonStaticMembers$2(source));
            int i = getAuthRequestContext + 29;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 != 0 ? '2' : (char) 30) != 30) {
                int i2 = 79 / 0;
                return wireInput;
            }
            return wireInput;
        } catch (Exception e) {
            throw e;
        }
    }

    public final int readTag() throws IOException {
        if (isAtEnd()) {
            try {
                int i = getAuthRequestContext + 67;
                MyBillsEntityDataFactory = i % 128;
                if ((i % 2 != 0 ? '^' : (char) 27) != '^') {
                    this.lastTag = 0;
                    return 0;
                }
                this.lastTag = 0;
                return 1;
            } catch (Exception e) {
                throw e;
            }
        }
        int readVarint32 = readVarint32();
        this.lastTag = readVarint32;
        if (!(readVarint32 == 0)) {
            int i2 = MyBillsEntityDataFactory + 37;
            getAuthRequestContext = i2 % 128;
            if (i2 % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            return readVarint32;
        }
        throw new IOException(PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (r3.lastTag == r4) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        r4 = com.squareup.wire.WireInput.getAuthRequestContext + 27;
        com.squareup.wire.WireInput.MyBillsEntityDataFactory = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        throw new java.io.IOException(com.squareup.wire.WireInput.PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r3.lastTag == r4) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkLastTagWas(int r4) throws java.io.IOException {
        /*
            r3 = this;
            int r0 = com.squareup.wire.WireInput.getAuthRequestContext
            int r0 = r0 + 11
            int r1 = r0 % 128
            com.squareup.wire.WireInput.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            if (r0 == 0) goto L1c
            int r0 = r3.lastTag
            r2 = 17
            int r2 = r2 / r1
            if (r0 != r4) goto L2d
            goto L20
        L1a:
            r4 = move-exception
            throw r4
        L1c:
            int r0 = r3.lastTag
            if (r0 != r4) goto L2d
        L20:
            int r4 = com.squareup.wire.WireInput.getAuthRequestContext     // Catch: java.lang.Exception -> L2b
            int r4 = r4 + 27
            int r0 = r4 % 128
            com.squareup.wire.WireInput.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> L2b
            int r4 = r4 % 2
            return
        L2b:
            r4 = move-exception
            throw r4
        L2d:
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r0 = "Protocol message end-group tag did not match expected tag."
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.WireInput.checkLastTagWas(int):void");
    }

    public final String readString() throws IOException {
        String KClassImpl$Data$declaredNonStaticMembers$22;
        int i = getAuthRequestContext + 121;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            int readVarint32 = readVarint32();
            this.pos += readVarint32;
            KClassImpl$Data$declaredNonStaticMembers$22 = this.source.KClassImpl$Data$declaredNonStaticMembers$2(readVarint32, UTF_8);
        } else {
            try {
                int readVarint322 = readVarint32();
                this.pos >>= readVarint322;
                KClassImpl$Data$declaredNonStaticMembers$22 = this.source.KClassImpl$Data$declaredNonStaticMembers$2(readVarint322, UTF_8);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = getAuthRequestContext + 115;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    public final ByteString readBytes() throws IOException {
        ByteString readBytes;
        int i = MyBillsEntityDataFactory + 19;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? 'P' : ';') != 'P') {
            readBytes = readBytes(readVarint32());
        } else {
            readBytes = readBytes(readVarint32());
            int i2 = 77 / 0;
        }
        int i3 = MyBillsEntityDataFactory + 17;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return readBytes;
    }

    public final ByteString readBytes(int i) throws IOException {
        ByteString MyBillsEntityDataFactory2;
        int i2 = getAuthRequestContext + 79;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 4 : (char) 21) != 21) {
            this.pos /= i;
            long j = i;
            this.source.lookAheadTest(j);
            MyBillsEntityDataFactory2 = this.source.MyBillsEntityDataFactory(j);
        } else {
            try {
                this.pos += i;
                long j2 = i;
                this.source.lookAheadTest(j2);
                MyBillsEntityDataFactory2 = this.source.MyBillsEntityDataFactory(j2);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = getAuthRequestContext + 79;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 33 / 0;
            return MyBillsEntityDataFactory2;
        }
        return MyBillsEntityDataFactory2;
    }

    public final int readVarint32() throws IOException {
        int i;
        try {
            this.pos++;
            byte initRecordTimeStamp = this.source.initRecordTimeStamp();
            if (initRecordTimeStamp >= 0) {
                return initRecordTimeStamp;
            }
            int i2 = initRecordTimeStamp & Byte.MAX_VALUE;
            this.pos++;
            byte initRecordTimeStamp2 = this.source.initRecordTimeStamp();
            if (initRecordTimeStamp2 < 0) {
                i2 |= (initRecordTimeStamp2 & Byte.MAX_VALUE) << 7;
                this.pos++;
                byte initRecordTimeStamp3 = this.source.initRecordTimeStamp();
                if ((initRecordTimeStamp3 >= 0 ? Typography.dollar : '_') != '$') {
                    i2 |= (initRecordTimeStamp3 & Byte.MAX_VALUE) << 14;
                    this.pos++;
                    byte initRecordTimeStamp4 = this.source.initRecordTimeStamp();
                    if (initRecordTimeStamp4 < 0) {
                        this.pos++;
                        byte initRecordTimeStamp5 = this.source.initRecordTimeStamp();
                        int i3 = i2 | ((initRecordTimeStamp4 & Byte.MAX_VALUE) << 21) | (initRecordTimeStamp5 << Ascii.FS);
                        if (!(initRecordTimeStamp5 < 0)) {
                            return i3;
                        }
                        int i4 = getAuthRequestContext + 13;
                        MyBillsEntityDataFactory = i4 % 128;
                        if (i4 % 2 != 0) {
                        }
                        int i5 = 0;
                        while (true) {
                            if (!(i5 >= 5)) {
                                this.pos++;
                                if (this.source.initRecordTimeStamp() >= 0) {
                                    int i6 = getAuthRequestContext + 13;
                                    MyBillsEntityDataFactory = i6 % 128;
                                    int i7 = i6 % 2;
                                    return i3;
                                }
                                i5++;
                                int i8 = MyBillsEntityDataFactory + 59;
                                getAuthRequestContext = i8 % 128;
                                int i9 = i8 % 2;
                            } else {
                                throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
                            }
                        }
                    } else {
                        int i10 = getAuthRequestContext + 25;
                        MyBillsEntityDataFactory = i10 % 128;
                        int i11 = i10 % 2;
                        i = initRecordTimeStamp4 << Ascii.NAK;
                    }
                } else {
                    i = initRecordTimeStamp3 << 14;
                }
            } else {
                i = initRecordTimeStamp2 << 7;
                int i12 = MyBillsEntityDataFactory + 35;
                getAuthRequestContext = i12 % 128;
                int i13 = i12 % 2;
            }
            return i2 | i;
        } catch (Exception e) {
            throw e;
        }
    }

    public final long readVarint64() throws IOException {
        int i = getAuthRequestContext + 57;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        long j = 0;
        int i3 = 0;
        while (true) {
            if (!(i3 >= 64)) {
                int i4 = getAuthRequestContext + 119;
                MyBillsEntityDataFactory = i4 % 128;
                int i5 = i4 % 2;
                this.pos++;
                j |= (r4 & Byte.MAX_VALUE) << i3;
                if ((this.source.initRecordTimeStamp() & 128) == 0) {
                    int i6 = getAuthRequestContext + 37;
                    MyBillsEntityDataFactory = i6 % 128;
                    if (i6 % 2 != 0) {
                        Object[] objArr = null;
                        int length = objArr.length;
                        return j;
                    }
                    return j;
                }
                i3 += 7;
            } else {
                throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
            }
        }
    }

    public final int readFixed32() throws IOException {
        int NetworkUserEntityData$$ExternalSyntheticLambda7;
        int i = getAuthRequestContext + 123;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? InputCardNumberView.DIVIDER : ']') != ' ') {
            try {
                try {
                    this.pos += 4;
                    NetworkUserEntityData$$ExternalSyntheticLambda7 = this.source.NetworkUserEntityData$$ExternalSyntheticLambda7();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            this.pos -= 5;
            NetworkUserEntityData$$ExternalSyntheticLambda7 = this.source.NetworkUserEntityData$$ExternalSyntheticLambda7();
        }
        int i2 = MyBillsEntityDataFactory + 41;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return NetworkUserEntityData$$ExternalSyntheticLambda7;
    }

    public final long readFixed64() throws IOException {
        int i = MyBillsEntityDataFactory + 113;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        this.pos += 8;
        long PrepareContext = this.source.PrepareContext();
        int i3 = MyBillsEntityDataFactory + 69;
        getAuthRequestContext = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return PrepareContext;
        }
        Object obj = null;
        obj.hashCode();
        return PrepareContext;
    }

    private WireInput(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public final int pushLimit(int i) throws IOException {
        int i2 = getAuthRequestContext + 11;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        if (i >= 0) {
            int i4 = i + this.pos;
            int i5 = this.currentLimit;
            if (!(i4 <= i5)) {
                throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
            }
            try {
                int i6 = MyBillsEntityDataFactory + 95;
                getAuthRequestContext = i6 % 128;
                int i7 = i6 % 2;
                this.currentLimit = i4;
                try {
                    int i8 = MyBillsEntityDataFactory + 7;
                    getAuthRequestContext = i8 % 128;
                    if (i8 % 2 != 0) {
                        return i5;
                    }
                    Object[] objArr = null;
                    int length = objArr.length;
                    return i5;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
    }

    public final void popLimit(int i) {
        int i2 = getAuthRequestContext + 29;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        this.currentLimit = i;
        try {
            int i4 = getAuthRequestContext + 41;
            MyBillsEntityDataFactory = i4 % 128;
            if ((i4 % 2 != 0 ? '\n' : JSONLexer.EOI) != '\n') {
                return;
            }
            int i5 = 57 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private boolean isAtEnd() throws IOException {
        int i = MyBillsEntityDataFactory + 47;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (getPosition() == ((long) this.currentLimit)) {
            try {
                int i3 = MyBillsEntityDataFactory + 105;
                getAuthRequestContext = i3 % 128;
                return (i3 % 2 == 0 ? '.' : (char) 14) == 14;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.source.lookAheadTest();
    }

    public final long getPosition() {
        try {
            int i = getAuthRequestContext + 39;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            long j = this.pos;
            int i3 = MyBillsEntityDataFactory + 79;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return j;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void skipGroup() throws IOException {
        while (true) {
            int readTag = readTag();
            if (readTag == 0) {
                break;
            }
            int i = MyBillsEntityDataFactory + 57;
            getAuthRequestContext = i % 128;
            char c = i % 2 == 0 ? '(' : '1';
            boolean skipField = skipField(readTag);
            if (c == '(') {
                Object obj = null;
                obj.hashCode();
                if (skipField) {
                    break;
                }
            } else if (skipField) {
                break;
            }
        }
        int i2 = getAuthRequestContext + 115;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.squareup.wire.WireInput$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$squareup$wire$WireType;

        static {
            int[] iArr = new int[WireType.values().length];
            $SwitchMap$com$squareup$wire$WireType = iArr;
            try {
                iArr[WireType.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.LENGTH_DELIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.START_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$squareup$wire$WireType[WireType.END_GROUP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private boolean skipField(int i) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$squareup$wire$WireType[WireType.valueOf(i).ordinal()]) {
            case 1:
                readVarint64();
                return false;
            case 2:
                readFixed32();
                int i2 = MyBillsEntityDataFactory + 79;
                getAuthRequestContext = i2 % 128;
                if ((i2 % 2 == 0 ? ';' : 'D') != 'D') {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return false;
                }
                return false;
            case 3:
                readFixed64();
                int i3 = getAuthRequestContext + 63;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return false;
            case 4:
                skip(readVarint32());
                return false;
            case 5:
                skipGroup();
                checkLastTagWas((i & (-8)) | WireType.END_GROUP.value());
                return false;
            case 6:
                return true;
            default:
                throw new AssertionError();
        }
    }

    private void skip(long j) throws IOException {
        int i = MyBillsEntityDataFactory + 57;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
        }
        this.pos = (int) (this.pos + j);
        this.source.NetworkUserEntityData$$ExternalSyntheticLambda0(j);
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (cArr2 != null) {
            try {
                int i3 = $11 + 33;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i5 = 0;
                while (true) {
                    if (!(i5 < length)) {
                        break;
                    }
                    cArr3[i5] = (char) (cArr2[i5] ^ (-1549216646985767851L));
                    i5++;
                }
                cArr2 = cArr3;
            } catch (Exception e) {
                throw e;
            }
        }
        char c = (char) ((-1549216646985767851L) ^ PlaceComponentResult);
        char[] cArr4 = new char[i];
        if ((i % 2 != 0 ? Typography.quote : 'E') != '\"') {
            i2 = i;
        } else {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        }
        if (i2 > 1) {
            int i6 = $11 + 119;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        int i8 = $11 + 103;
                        $10 = i8 % 128;
                        int i9 = i8 % 2;
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i10 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i11 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i10];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i11];
                    } else {
                        if (!(getcallingpid.BuiltInFictitiousFunctionClassFactory != getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2)) {
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                        } else {
                            int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i14];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i15];
                        }
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
                int i16 = $10 + 69;
                $11 = i16 % 128;
                int i17 = i16 % 2;
            }
        }
        int i18 = 0;
        while (i18 < i) {
            int i19 = $10 + 31;
            $11 = i19 % 128;
            if (i19 % 2 == 0) {
                cArr4[i18] = (char) (cArr4[i18] ^ 16879);
                i18 += 59;
            } else {
                cArr4[i18] = (char) (cArr4[i18] ^ 13722);
                i18++;
            }
        }
        objArr[0] = new String(cArr4);
    }
}
