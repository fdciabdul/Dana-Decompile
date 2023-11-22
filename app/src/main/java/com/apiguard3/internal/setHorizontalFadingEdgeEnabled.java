package com.apiguard3.internal;

import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.cashier.view.InputCardNumberView;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setHorizontalFadingEdgeEnabled {
    public static final setPivotX AGState;
    public static final setPivotX APIGuard;
    public static final setScaleX<BigDecimal> APIGuard$Callback;
    public static final setScaleX<BigInteger> APIGuard$InitializationCallback;
    public static final setPivotX AnalysesEntry;
    private static setScaleX<Class> BHT = null;
    public static final setPivotX BuildConfig;
    private static setScaleX<Number> C = null;
    public static final setPivotX Config;
    private static setScaleX<StringBuffer> D = null;
    private static setScaleX<Currency> E = null;
    private static int FU = 1;
    public static final setPivotX FraudScore;
    public static final setScaleX<setHovered> SConfig;
    public static final setPivotX ScoredEntry;
    private static setScaleX<Number> am;
    public static final setPivotX analyzeResponse;
    private static setScaleX<Boolean> ce;
    private static setScaleX<Character> cf;
    public static final setScaleX<Number> checkCertificates;
    public static final setPivotX clearCallback;
    private static setScaleX<StringBuilder> cs;

    /* renamed from: de  reason: collision with root package name */
    private static setScaleX<String> f7414de;
    private static int dpi;
    private static setScaleX<AtomicBoolean> gc;
    public static final setPivotX generateHeaders;
    public static final setPivotX getRequestHeaders;
    public static final setPivotX getSharedInstance;
    public static final setScaleX<Number> getState;
    public static final setPivotX getVersion;
    private static setScaleX<AtomicIntegerArray> gt;
    public static final setPivotX initialize;
    private static setScaleX<URI> ipi;
    public static final setScaleX<Number> log;
    public static final setPivotX onInitializationFailure;
    public static final setPivotX onInitializationSuccess;
    public static final setPivotX parseResponseHeaders;
    public static final setPivotX pushMaxPayload;
    public static final setPivotX pushMinPayload;
    private static setScaleX<Calendar> readObject;
    private static setScaleX<BitSet> rf;
    private static setScaleX<Number> rm;
    private static setScaleX<URL> sc;
    private static setScaleX<UUID> sdf;
    public static final setPivotX send;
    private static setScaleX<InetAddress> spi;
    private static setScaleX<AtomicInteger> ss;
    public static final setPivotX updateKernel;
    public static final setPivotX valueOf;
    public static final setScaleX<Boolean> values;
    private static setScaleX<Locale> writeReplace;

    static {
        setScaleX<Class> AGState2 = new setScaleX<Class>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.1
            private static int AGState = 0;
            private static int getSharedInstance = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Class cls) throws IOException {
                int i = AGState + 109;
                getSharedInstance = i % 128;
                boolean z = i % 2 == 0;
                getSharedInstance(cls);
                if (z) {
                    throw new ArithmeticException();
                }
                getSharedInstance = (AGState + 41) % 128;
            }

            private static void getSharedInstance(Class cls) throws IOException {
                StringBuilder sb = new StringBuilder("Attempted to serialize java.lang.Class: ");
                sb.append(cls.getName());
                sb.append(". Forgot to register a type adapter?");
                throw new UnsupportedOperationException(sb.toString());
            }
        }.AGState();
        BHT = AGState2;
        valueOf = valueOf(Class.class, AGState2);
        setScaleX<BitSet> AGState3 = new setScaleX<BitSet>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.12
            private static int valueOf = 1;
            private static int values;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, BitSet bitSet) throws IOException {
                valueOf = (values + 63) % 128;
                APIGuard(setlayertype, bitSet);
                valueOf = (values + 11) % 128;
            }

            private static void APIGuard(setLayerType setlayertype, BitSet bitSet) throws IOException {
                setlayertype.valueOf();
                int length = bitSet.length();
                values = (valueOf + 99) % 128;
                int i = 0;
                while (true) {
                    if (!(i < length)) {
                        setlayertype.values();
                        return;
                    }
                    int i2 = valueOf + 113;
                    values = i2 % 128;
                    if (i2 % 2 != 0) {
                        bitSet.get(i);
                        throw null;
                    } else {
                        setlayertype.AGState(bitSet.get(i) ? 1L : 0L);
                        i++;
                    }
                }
            }
        }.AGState();
        rf = AGState3;
        AGState = valueOf(BitSet.class, AGState3);
        ce = new setScaleX<Boolean>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.25
            private static int APIGuard = 0;
            private static int valueOf = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Boolean bool) throws IOException {
                APIGuard = (valueOf + 115) % 128;
                valueOf(setlayertype, bool);
                valueOf = (APIGuard + 65) % 128;
            }

            private static void valueOf(setLayerType setlayertype, Boolean bool) throws IOException {
                int i = APIGuard + 67;
                valueOf = i % 128;
                char c = i % 2 == 0 ? (char) 5 : (char) 22;
                setlayertype.valueOf(bool);
                if (c == 5) {
                    throw new ArithmeticException();
                }
                valueOf = (APIGuard + 11) % 128;
            }
        };
        values = new setScaleX<Boolean>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.28
            private static int APIGuard = 0;
            private static int values = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Boolean bool) throws IOException {
                int i = APIGuard + 21;
                values = i % 128;
                char c = i % 2 == 0 ? 'G' : (char) 17;
                values(setlayertype, bool);
                if (c == 17) {
                    return;
                }
                throw new NullPointerException();
            }

            private static void values(setLayerType setlayertype, Boolean bool) throws IOException {
                String obj;
                int i = values;
                int i2 = i + 7;
                APIGuard = i2 % 128;
                if ((i2 % 2 != 0 ? 'L' : '#') != '#') {
                    throw new ArithmeticException();
                }
                if (!(bool != null)) {
                    int i3 = i + 35;
                    APIGuard = i3 % 128;
                    if (i3 % 2 != 0) {
                        throw new NullPointerException();
                    }
                    obj = "null";
                } else {
                    obj = bool.toString();
                    APIGuard = (values + 61) % 128;
                }
                setlayertype.AGState(obj);
            }
        };
        getSharedInstance = AGState(Boolean.TYPE, Boolean.class, ce);
        rm = new setScaleX<Number>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.30
            private static int valueOf = 0;
            private static int values = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
                values = (valueOf + 49) % 128;
                values(setlayertype, number);
                int i = values + 87;
                valueOf = i % 128;
                if ((i % 2 != 0 ? '\r' : '\\') == '\\') {
                    return;
                }
                throw new ArithmeticException();
            }

            private static void values(setLayerType setlayertype, Number number) throws IOException {
                valueOf = (values + 93) % 128;
                setlayertype.APIGuard(number);
                int i = values + 89;
                valueOf = i % 128;
                if (i % 2 == 0) {
                    return;
                }
                throw null;
            }
        };
        APIGuard = AGState(Byte.TYPE, Byte.class, rm);
        C = new setScaleX<Number>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.29
            private static int AGState = 1;
            private static int getSharedInstance;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
                int i = getSharedInstance + 53;
                AGState = i % 128;
                char c = i % 2 == 0 ? '\b' : 'S';
                getSharedInstance2(setlayertype, number);
                if (c != '\b') {
                    return;
                }
                throw new ArithmeticException();
            }

            /* renamed from: getSharedInstance  reason: avoid collision after fix types in other method */
            private static void getSharedInstance2(setLayerType setlayertype, Number number) throws IOException {
                AGState = (getSharedInstance + 65) % 128;
                setlayertype.APIGuard(number);
                int i = AGState + 19;
                getSharedInstance = i % 128;
                if ((i % 2 != 0 ? (char) 17 : 'T') == 'T') {
                    return;
                }
                throw new ArithmeticException();
            }
        };
        generateHeaders = AGState(Short.TYPE, Short.class, C);
        am = new setScaleX<Number>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.26
            private static int valueOf = 1;
            private static int values;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
                int i = values + 19;
                valueOf = i % 128;
                boolean z = i % 2 != 0;
                values(setlayertype, number);
                if (z) {
                    return;
                }
                throw new ArithmeticException();
            }

            private static void values(setLayerType setlayertype, Number number) throws IOException {
                values = (valueOf + 59) % 128;
                setlayertype.APIGuard(number);
                int i = valueOf + 17;
                values = i % 128;
                if (i % 2 == 0) {
                    return;
                }
                throw new ArithmeticException();
            }
        };
        initialize = AGState(Integer.TYPE, Integer.class, am);
        setScaleX<AtomicInteger> AGState4 = new setScaleX<AtomicInteger>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.34
            private static int AGState = 1;
            private static int APIGuard;

            @Override // com.apiguard3.internal.setScaleX
            public final /* bridge */ /* synthetic */ void getSharedInstance(setLayerType setlayertype, AtomicInteger atomicInteger) throws IOException {
                APIGuard = (AGState + 75) % 128;
                getSharedInstance2(setlayertype, atomicInteger);
                AGState = (APIGuard + 89) % 128;
            }

            /* renamed from: getSharedInstance  reason: avoid collision after fix types in other method */
            private static void getSharedInstance2(setLayerType setlayertype, AtomicInteger atomicInteger) throws IOException {
                int i = AGState + 15;
                APIGuard = i % 128;
                boolean z = i % 2 != 0;
                int i2 = atomicInteger.get();
                if (z) {
                    setlayertype.AGState(i2);
                    throw new NullPointerException();
                }
                setlayertype.AGState(i2);
                int i3 = AGState + 49;
                APIGuard = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 18 : (char) 2) == 18) {
                    return;
                }
                throw new ArithmeticException();
            }
        }.AGState();
        ss = AGState4;
        getRequestHeaders = valueOf(AtomicInteger.class, AGState4);
        setScaleX<AtomicBoolean> AGState5 = new setScaleX<AtomicBoolean>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.33
            private static int APIGuard = 1;
            private static int getSharedInstance;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, AtomicBoolean atomicBoolean) throws IOException {
                int i = getSharedInstance + 83;
                APIGuard = i % 128;
                char c = i % 2 == 0 ? (char) 29 : '9';
                values(setlayertype, atomicBoolean);
                if (c != '9') {
                    throw new NullPointerException();
                }
                getSharedInstance = (APIGuard + 87) % 128;
            }

            private static void values(setLayerType setlayertype, AtomicBoolean atomicBoolean) throws IOException {
                int i = getSharedInstance + 91;
                APIGuard = i % 128;
                char c = i % 2 == 0 ? (char) 30 : '*';
                setlayertype.values(atomicBoolean.get());
                if (c == '*') {
                    return;
                }
                throw new NullPointerException();
            }
        }.AGState();
        gc = AGState5;
        parseResponseHeaders = valueOf(AtomicBoolean.class, AGState5);
        setScaleX<AtomicIntegerArray> AGState6 = new setScaleX<AtomicIntegerArray>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.3
            private static int valueOf = 0;
            private static int values = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, AtomicIntegerArray atomicIntegerArray) throws IOException {
                int i = values + 33;
                valueOf = i % 128;
                char c = i % 2 != 0 ? '+' : (char) 25;
                getSharedInstance2(setlayertype, atomicIntegerArray);
                if (c == '+') {
                    throw new ArithmeticException();
                }
                values = (valueOf + 95) % 128;
            }

            /* renamed from: getSharedInstance  reason: avoid collision after fix types in other method */
            private static void getSharedInstance2(setLayerType setlayertype, AtomicIntegerArray atomicIntegerArray) throws IOException {
                int i = valueOf + 21;
                values = i % 128;
                int i2 = i % 2;
                setlayertype.valueOf();
                int length = atomicIntegerArray.length();
                int i3 = 0;
                while (i3 < length) {
                    int i4 = values + 47;
                    valueOf = i4 % 128;
                    if (i4 % 2 == 0) {
                        setlayertype.AGState(atomicIntegerArray.get(i3));
                        i3++;
                    } else {
                        setlayertype.AGState(atomicIntegerArray.get(i3));
                        i3 += 116;
                    }
                }
                setlayertype.values();
                int i5 = valueOf + 35;
                values = i5 % 128;
                if (i5 % 2 != 0) {
                    return;
                }
                throw new NullPointerException();
            }
        }.AGState();
        gt = AGState6;
        analyzeResponse = valueOf(AtomicIntegerArray.class, AGState6);
        getState = new setScaleX<Number>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.5
            private static int AGState = 1;
            private static int valueOf;

            @Override // com.apiguard3.internal.setScaleX
            public final /* bridge */ /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
                valueOf = (AGState + 75) % 128;
                getSharedInstance2(setlayertype, number);
                AGState = (valueOf + 81) % 128;
            }

            /* renamed from: getSharedInstance  reason: avoid collision after fix types in other method */
            private static void getSharedInstance2(setLayerType setlayertype, Number number) throws IOException {
                int i = AGState + 3;
                valueOf = i % 128;
                boolean z = i % 2 != 0;
                setlayertype.APIGuard(number);
                if (!z) {
                    return;
                }
                throw new ArithmeticException();
            }
        };
        checkCertificates = new setScaleX<Number>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.4
            private static int AGState = 0;
            private static int valueOf = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
                AGState = (valueOf + 53) % 128;
                AGState(setlayertype, number);
                valueOf = (AGState + 105) % 128;
            }

            private static void AGState(setLayerType setlayertype, Number number) throws IOException {
                int i = valueOf + 117;
                AGState = i % 128;
                char c = i % 2 != 0 ? 'c' : '-';
                setlayertype.APIGuard(number);
                if (c != 'c') {
                    return;
                }
                throw new NullPointerException();
            }
        };
        log = new setScaleX<Number>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.2
            private static int getSharedInstance = 0;
            private static int valueOf = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
                int i = getSharedInstance + 89;
                valueOf = i % 128;
                boolean z = i % 2 == 0;
                APIGuard(setlayertype, number);
                if (!z) {
                    return;
                }
                throw new ArithmeticException();
            }

            private static void APIGuard(setLayerType setlayertype, Number number) throws IOException {
                getSharedInstance = (valueOf + 45) % 128;
                setlayertype.APIGuard(number);
                int i = valueOf + 119;
                getSharedInstance = i % 128;
                if ((i % 2 != 0 ? 'X' : '?') != 'X') {
                    return;
                }
                throw new ArithmeticException();
            }
        };
        cf = new setScaleX<Character>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.8
            private static int valueOf = 1;
            private static int values;

            @Override // com.apiguard3.internal.setScaleX
            public final /* bridge */ /* synthetic */ void getSharedInstance(setLayerType setlayertype, Character ch) throws IOException {
                int i = values + 9;
                valueOf = i % 128;
                boolean z = i % 2 != 0;
                getSharedInstance2(setlayertype, ch);
                if (z) {
                    return;
                }
                throw null;
            }

            /* renamed from: getSharedInstance  reason: avoid collision after fix types in other method */
            private static void getSharedInstance2(setLayerType setlayertype, Character ch) throws IOException {
                int i = valueOf;
                int i2 = i + 1;
                values = i2 % 128;
                String str = null;
                if (!(i2 % 2 == 0)) {
                    throw null;
                }
                if (ch == null) {
                    values = (i + 29) % 128;
                } else {
                    str = String.valueOf(ch);
                }
                setlayertype.AGState(str);
            }
        };
        updateKernel = AGState(Character.TYPE, Character.class, cf);
        f7414de = new setScaleX<String>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.9
            private static int AGState = 0;
            private static int valueOf = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, String str) throws IOException {
                AGState = (valueOf + 11) % 128;
                values(setlayertype, str);
                int i = AGState + 125;
                valueOf = i % 128;
                if ((i % 2 == 0 ? (char) 5 : (char) 17) == 17) {
                    return;
                }
                throw null;
            }

            private static void values(setLayerType setlayertype, String str) throws IOException {
                valueOf = (AGState + 3) % 128;
                setlayertype.AGState(str);
                valueOf = (AGState + 3) % 128;
            }
        };
        APIGuard$Callback = new setScaleX<BigDecimal>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.6
            private static int APIGuard = 0;
            private static int getSharedInstance = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, BigDecimal bigDecimal) throws IOException {
                int i = getSharedInstance + 95;
                APIGuard = i % 128;
                char c = i % 2 != 0 ? Typography.quote : InputCardNumberView.DIVIDER;
                values(setlayertype, bigDecimal);
                if (c != '\"') {
                    return;
                }
                throw new NullPointerException();
            }

            private static void values(setLayerType setlayertype, BigDecimal bigDecimal) throws IOException {
                APIGuard = (getSharedInstance + 81) % 128;
                setlayertype.APIGuard(bigDecimal);
                int i = APIGuard + 121;
                getSharedInstance = i % 128;
                if (i % 2 != 0) {
                    return;
                }
                throw null;
            }
        };
        APIGuard$InitializationCallback = new setScaleX<BigInteger>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.7
            private static int AGState = 1;
            private static int APIGuard;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, BigInteger bigInteger) throws IOException {
                AGState = (APIGuard + 19) % 128;
                values(setlayertype, bigInteger);
                APIGuard = (AGState + 79) % 128;
            }

            private static void values(setLayerType setlayertype, BigInteger bigInteger) throws IOException {
                int i = AGState + 77;
                APIGuard = i % 128;
                boolean z = i % 2 == 0;
                setlayertype.APIGuard(bigInteger);
                if (z) {
                    return;
                }
                throw null;
            }
        };
        onInitializationSuccess = valueOf(String.class, f7414de);
        setScaleX<StringBuilder> setscalex = new setScaleX<StringBuilder>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.10
            private static int APIGuard = 0;
            private static int values = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, StringBuilder sb) throws IOException {
                values = (APIGuard + 87) % 128;
                valueOf(setlayertype, sb);
                APIGuard = (values + 59) % 128;
            }

            private static void valueOf(setLayerType setlayertype, StringBuilder sb) throws IOException {
                String str;
                int i;
                if ((sb == null ? '\r' : '*') != '\r') {
                    str = sb.toString();
                    i = values + 87;
                } else {
                    str = null;
                    i = values + 89;
                }
                APIGuard = i % 128;
                setlayertype.AGState(str);
            }
        };
        cs = setscalex;
        onInitializationFailure = valueOf(StringBuilder.class, setscalex);
        setScaleX<StringBuffer> setscalex2 = new setScaleX<StringBuffer>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.13
            private static int AGState = 1;
            private static int valueOf;

            @Override // com.apiguard3.internal.setScaleX
            public final /* bridge */ /* synthetic */ void getSharedInstance(setLayerType setlayertype, StringBuffer stringBuffer) throws IOException {
                AGState = (valueOf + 35) % 128;
                getSharedInstance2(setlayertype, stringBuffer);
                AGState = (valueOf + 67) % 128;
            }

            /* renamed from: getSharedInstance  reason: avoid collision after fix types in other method */
            private static void getSharedInstance2(setLayerType setlayertype, StringBuffer stringBuffer) throws IOException {
                int i = valueOf + 115;
                int i2 = i % 128;
                AGState = i2;
                String str = null;
                if (i % 2 == 0) {
                    throw null;
                }
                if ((stringBuffer == null ? 'W' : 'V') != 'V') {
                    int i3 = i2 + 53;
                    valueOf = i3 % 128;
                    if (i3 % 2 != 0) {
                        throw new NullPointerException();
                    }
                } else {
                    str = stringBuffer.toString();
                    AGState = (valueOf + 45) % 128;
                }
                setlayertype.AGState(str);
            }
        };
        D = setscalex2;
        BuildConfig = valueOf(StringBuffer.class, setscalex2);
        setScaleX<URL> setscalex3 = new setScaleX<URL>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.11
            private static int APIGuard = 1;
            private static int valueOf;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, URL url) throws IOException {
                valueOf = (APIGuard + 93) % 128;
                APIGuard(setlayertype, url);
                int i = valueOf + 31;
                APIGuard = i % 128;
                if ((i % 2 == 0 ? '!' : 'S') == 'S') {
                    return;
                }
                throw null;
            }

            private static void APIGuard(setLayerType setlayertype, URL url) throws IOException {
                String externalForm;
                int i = (valueOf + 3) % 128;
                APIGuard = i;
                if ((url == null ? (char) 30 : '7') != '7') {
                    valueOf = (i + 57) % 128;
                    externalForm = null;
                } else {
                    externalForm = url.toExternalForm();
                }
                setlayertype.AGState(externalForm);
            }
        };
        sc = setscalex3;
        pushMinPayload = valueOf(URL.class, setscalex3);
        setScaleX<URI> setscalex4 = new setScaleX<URI>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.14
            private static int APIGuard = 1;
            private static int values;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, URI uri) throws IOException {
                values = (APIGuard + 45) % 128;
                AGState(setlayertype, uri);
                int i = APIGuard + 113;
                values = i % 128;
                if (!(i % 2 != 0)) {
                    return;
                }
                throw new ArithmeticException();
            }

            private static void AGState(setLayerType setlayertype, URI uri) throws IOException {
                String aSCIIString;
                if ((uri == null ? (char) 0 : 'X') != 'X') {
                    APIGuard = (values + 97) % 128;
                    aSCIIString = null;
                } else {
                    aSCIIString = uri.toASCIIString();
                }
                setlayertype.AGState(aSCIIString);
                int i = values + 87;
                APIGuard = i % 128;
                if (i % 2 == 0) {
                    throw new NullPointerException();
                }
            }
        };
        ipi = setscalex4;
        getVersion = valueOf(URI.class, setscalex4);
        setScaleX<InetAddress> setscalex5 = new setScaleX<InetAddress>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.15
            private static int AGState = 0;
            private static int APIGuard = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, InetAddress inetAddress) throws IOException {
                AGState = (APIGuard + 57) % 128;
                APIGuard(setlayertype, inetAddress);
                int i = AGState + 113;
                APIGuard = i % 128;
                if ((i % 2 == 0 ? (char) 16 : (char) 30) == 30) {
                    return;
                }
                throw null;
            }

            private static void APIGuard(setLayerType setlayertype, InetAddress inetAddress) throws IOException {
                AGState = (APIGuard + 95) % 128;
                setlayertype.AGState((inetAddress == null ? '%' : 'V') != 'V' ? null : inetAddress.getHostAddress());
                APIGuard = (AGState + 25) % 128;
            }
        };
        spi = setscalex5;
        send = values(InetAddress.class, setscalex5);
        setScaleX<UUID> setscalex6 = new setScaleX<UUID>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.19
            private static int APIGuard = 0;
            private static int valueOf = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, UUID uuid) throws IOException {
                APIGuard = (valueOf + 11) % 128;
                valueOf(setlayertype, uuid);
                int i = APIGuard + 31;
                valueOf = i % 128;
                if (!(i % 2 == 0)) {
                    return;
                }
                throw null;
            }

            private static void valueOf(setLayerType setlayertype, UUID uuid) throws IOException {
                String str;
                valueOf = (APIGuard + 121) % 128;
                if ((uuid == null ? (char) 14 : '6') != 14) {
                    str = uuid.toString();
                    APIGuard = (valueOf + 53) % 128;
                } else {
                    str = null;
                }
                setlayertype.AGState(str);
            }
        };
        sdf = setscalex6;
        AnalysesEntry = valueOf(UUID.class, setscalex6);
        setScaleX<Currency> AGState7 = new setScaleX<Currency>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.16
            private static int AGState = 0;
            private static int APIGuard = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Currency currency) throws IOException {
                APIGuard = (AGState + 115) % 128;
                valueOf(setlayertype, currency);
                int i = AGState + 63;
                APIGuard = i % 128;
                if ((i % 2 == 0 ? Typography.quote : '`') != '\"') {
                    return;
                }
                throw null;
            }

            private static void valueOf(setLayerType setlayertype, Currency currency) throws IOException {
                int i = AGState + 17;
                APIGuard = i % 128;
                boolean z = i % 2 == 0;
                setlayertype.AGState(currency.getCurrencyCode());
                if (z) {
                    throw new ArithmeticException();
                }
                AGState = (APIGuard + 95) % 128;
            }
        }.AGState();
        E = AGState7;
        pushMaxPayload = valueOf(Currency.class, AGState7);
        setScaleX<Calendar> setscalex7 = new setScaleX<Calendar>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.20
            private static int AGState = 0;
            private static int getSharedInstance = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Calendar calendar) throws IOException {
                getSharedInstance = (AGState + 19) % 128;
                AGState(setlayertype, calendar);
                int i = AGState + 77;
                getSharedInstance = i % 128;
                if (i % 2 == 0) {
                    throw new NullPointerException();
                }
            }

            private static void AGState(setLayerType setlayertype, Calendar calendar) throws IOException {
                if (calendar == null) {
                    int i = AGState + 113;
                    getSharedInstance = i % 128;
                    char c = i % 2 == 0 ? '2' : 'a';
                    setlayertype.analyzeResponse();
                    if (c != 'a') {
                        throw new ArithmeticException();
                    }
                    int i2 = AGState + 31;
                    getSharedInstance = i2 % 128;
                    if ((i2 % 2 == 0 ? (char) 25 : (char) 27) != 25) {
                        return;
                    }
                    throw new ArithmeticException();
                }
                setlayertype.AGState();
                setlayertype.APIGuard("year");
                setlayertype.AGState(calendar.get(1));
                setlayertype.APIGuard("month");
                setlayertype.AGState(calendar.get(2));
                setlayertype.APIGuard("dayOfMonth");
                setlayertype.AGState(calendar.get(5));
                setlayertype.APIGuard("hourOfDay");
                setlayertype.AGState(calendar.get(11));
                setlayertype.APIGuard("minute");
                setlayertype.AGState(calendar.get(12));
                setlayertype.APIGuard("second");
                setlayertype.AGState(calendar.get(13));
                setlayertype.getSharedInstance();
                getSharedInstance = (AGState + 73) % 128;
            }
        };
        readObject = setscalex7;
        clearCallback = values(Calendar.class, GregorianCalendar.class, setscalex7);
        setScaleX<Locale> setscalex8 = new setScaleX<Locale>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.18
            private static int APIGuard = 0;
            private static int values = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Locale locale) throws IOException {
                values = (APIGuard + 75) % 128;
                valueOf(setlayertype, locale);
                values = (APIGuard + 25) % 128;
            }

            private static void valueOf(setLayerType setlayertype, Locale locale) throws IOException {
                String obj;
                if (locale == null) {
                    int i = values + 85;
                    APIGuard = i % 128;
                    if ((i % 2 != 0 ? (char) 4 : (char) 1) != 1) {
                        throw new NullPointerException();
                    }
                    obj = null;
                } else {
                    obj = locale.toString();
                }
                setlayertype.AGState(obj);
                int i2 = APIGuard + 39;
                values = i2 % 128;
                if ((i2 % 2 == 0 ? '=' : (char) 28) != '=') {
                    return;
                }
                throw new NullPointerException();
            }
        };
        writeReplace = setscalex8;
        FraudScore = valueOf(Locale.class, setscalex8);
        setScaleX<setHovered> setscalex9 = new setScaleX<setHovered>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.17
            private static int AGState = 0;
            private static int getSharedInstance = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, setHovered sethovered) throws IOException {
                int i = getSharedInstance + 7;
                AGState = i % 128;
                char c = i % 2 != 0 ? 'K' : (char) 29;
                APIGuard(setlayertype, sethovered);
                if (c == 29) {
                    return;
                }
                throw new ArithmeticException();
            }

            private void APIGuard(setLayerType setlayertype, setHovered sethovered) throws IOException {
                if ((sethovered != null ? 'A' : '^') == '^' || sethovered.parseResponseHeaders()) {
                    setlayertype.analyzeResponse();
                } else if (sethovered.getRequestHeaders()) {
                    setScrollY analyzeResponse2 = sethovered.analyzeResponse();
                    if (analyzeResponse2.updateKernel()) {
                        setlayertype.APIGuard(analyzeResponse2.AGState());
                        return;
                    }
                    if ((analyzeResponse2.getState() ? JSONLexer.EOI : 'Q') != 'Q') {
                        setlayertype.values(analyzeResponse2.valueOf());
                    } else {
                        setlayertype.AGState(analyzeResponse2.getSharedInstance());
                    }
                } else {
                    if ((sethovered.values() ? 'X' : '7') == 'X') {
                        setlayertype.valueOf();
                        Iterator<setHovered> it = sethovered.generateHeaders().iterator();
                        while (it.hasNext()) {
                            int i = getSharedInstance + 43;
                            AGState = i % 128;
                            if (i % 2 != 0) {
                                APIGuard(setlayertype, it.next());
                                throw new ArithmeticException();
                            }
                            APIGuard(setlayertype, it.next());
                        }
                        setlayertype.values();
                        return;
                    }
                    if ((sethovered.APIGuard() ? '=' : 'W') == 'W') {
                        StringBuilder sb = new StringBuilder("Couldn't write ");
                        sb.append(sethovered.getClass());
                        throw new IllegalArgumentException(sb.toString());
                    }
                    int i2 = AGState + 49;
                    getSharedInstance = i2 % 128;
                    if (i2 % 2 == 0) {
                        setlayertype.AGState();
                        sethovered.initialize().updateKernel().iterator();
                        throw null;
                    }
                    setlayertype.AGState();
                    Iterator<Map.Entry<String, setHovered>> it2 = sethovered.initialize().updateKernel().iterator();
                    while (it2.hasNext()) {
                        int i3 = AGState + 51;
                        getSharedInstance = i3 % 128;
                        if (i3 % 2 == 0) {
                            Map.Entry<String, setHovered> next = it2.next();
                            setlayertype.APIGuard(next.getKey());
                            APIGuard(setlayertype, next.getValue());
                            throw new ArithmeticException();
                        }
                        Map.Entry<String, setHovered> next2 = it2.next();
                        setlayertype.APIGuard(next2.getKey());
                        APIGuard(setlayertype, next2.getValue());
                    }
                    setlayertype.getSharedInstance();
                }
            }
        };
        SConfig = setscalex9;
        ScoredEntry = values(setHovered.class, setscalex9);
        Config = new setPivotX() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.22
            private static int AGState = 1;
            private static int valueOf;

            @Override // com.apiguard3.internal.setPivotX
            public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
                Class AGState8 = setscrollbarfadingenabled.AGState();
                if (Enum.class.isAssignableFrom(AGState8)) {
                    int i = AGState + 83;
                    valueOf = i % 128;
                    if ((i % 2 != 0 ? (char) 21 : 'Q') == 'Q') {
                        if (!(AGState8 == Enum.class)) {
                            if ((!AGState8.isEnum() ? '9' : Typography.amp) == '9') {
                                int i2 = AGState + 73;
                                valueOf = i2 % 128;
                                boolean z = i2 % 2 == 0;
                                AGState8 = (Class<? super Object>) AGState8.getSuperclass();
                                if (!z) {
                                    throw new ArithmeticException();
                                }
                            }
                            return new APIGuard(AGState8);
                        }
                    } else {
                        throw null;
                    }
                }
                AGState = (valueOf + 49) % 128;
                return null;
            }
        };
        FU = (dpi + 73) % 128;
    }

    /* loaded from: classes7.dex */
    static final class APIGuard<T extends Enum<T>> extends setScaleX<T> {
        private static int AGState = 0;
        private static int values = 1;
        private final Map<String, T> valueOf = new HashMap();
        private final Map<T, String> APIGuard = new HashMap();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.apiguard3.internal.setScaleX
        public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Object obj) throws IOException {
            AGState = (values + 29) % 128;
            values(setlayertype, (Enum) obj);
            values = (AGState + 109) % 128;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public APIGuard(Class<T> cls) {
            try {
                for (final Field field : cls.getDeclaredFields()) {
                    if (field.isEnumConstant()) {
                        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.APIGuard.4
                            private static int getSharedInstance = 1;
                            private static int values;

                            @Override // java.security.PrivilegedAction
                            public final /* synthetic */ Void run() {
                                getSharedInstance = (values + 107) % 128;
                                Void sharedInstance = getSharedInstance();
                                getSharedInstance = (values + 37) % 128;
                                return sharedInstance;
                            }

                            private Void getSharedInstance() {
                                int i = getSharedInstance + 33;
                                values = i % 128;
                                int i2 = i % 2;
                                field.setAccessible(true);
                                int i3 = values + 95;
                                getSharedInstance = i3 % 128;
                                if ((i3 % 2 == 0 ? '\t' : (char) 22) != '\t') {
                                    return null;
                                }
                                throw new NullPointerException();
                            }
                        });
                        Enum r4 = (Enum) field.get(null);
                        String name = r4.name();
                        setRotationX setrotationx = (setRotationX) field.getAnnotation(setRotationX.class);
                        if (setrotationx != null) {
                            name = setrotationx.valueOf();
                            for (String str : setrotationx.getSharedInstance()) {
                                this.valueOf.put(str, r4);
                            }
                        }
                        this.valueOf.put(name, r4);
                        this.APIGuard.put(r4, name);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }

        private void values(setLayerType setlayertype, T t) throws IOException {
            String str;
            if (t != null) {
                str = this.APIGuard.get(t);
            } else {
                int i = AGState;
                values = (i + 31) % 128;
                values = (i + 81) % 128;
                str = null;
            }
            setlayertype.AGState(str);
        }
    }

    public static <TT> setPivotX valueOf(final Class<TT> cls, final setScaleX<TT> setscalex) {
        setPivotX setpivotx = new setPivotX() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.21
            private static int APIGuard = 0;
            private static int valueOf = 1;

            @Override // com.apiguard3.internal.setPivotX
            public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
                APIGuard = (valueOf + 113) % 128;
                if (!(setscrollbarfadingenabled.AGState() == cls)) {
                    APIGuard = (valueOf + 115) % 128;
                    return null;
                }
                int i = APIGuard + 27;
                valueOf = i % 128;
                if (i % 2 != 0) {
                    return setscalex;
                }
                throw new NullPointerException();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Factory[type=");
                sb.append(cls.getName());
                sb.append(",adapter=");
                sb.append(setscalex);
                sb.append("]");
                String obj = sb.toString();
                int i = valueOf + 33;
                APIGuard = i % 128;
                if (i % 2 == 0) {
                    return obj;
                }
                throw new ArithmeticException();
            }
        };
        int i = dpi + 19;
        FU = i % 128;
        if ((i % 2 == 0 ? ']' : ',') == ',') {
            return setpivotx;
        }
        throw new NullPointerException();
    }

    public static <TT> setPivotX AGState(final Class<TT> cls, final Class<TT> cls2, final setScaleX<? super TT> setscalex) {
        setPivotX setpivotx = new setPivotX() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.23
            private static int getSharedInstance = 1;
            private static int values;

            @Override // com.apiguard3.internal.setPivotX
            public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
                Class<? super T> AGState2 = setscrollbarfadingenabled.AGState();
                if (!(AGState2 == cls)) {
                    int i = (getSharedInstance + 83) % 128;
                    values = i;
                    if ((AGState2 == cls2 ? 'H' : '\'') != 'H') {
                        getSharedInstance = (i + 117) % 128;
                        return null;
                    }
                }
                return setscalex;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Factory[type=");
                sb.append(cls2.getName());
                sb.append("+");
                sb.append(cls.getName());
                sb.append(",adapter=");
                sb.append(setscalex);
                sb.append("]");
                String obj = sb.toString();
                getSharedInstance = (values + 107) % 128;
                return obj;
            }
        };
        dpi = (FU + 21) % 128;
        return setpivotx;
    }

    private static <TT> setPivotX values(final Class<TT> cls, final Class<? extends TT> cls2, final setScaleX<? super TT> setscalex) {
        setPivotX setpivotx = new setPivotX() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.24
            private static int APIGuard = 1;
            private static int getSharedInstance;

            @Override // com.apiguard3.internal.setPivotX
            public final <T> setScaleX<T> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
                Class<? super T> AGState2 = setscrollbarfadingenabled.AGState();
                if ((AGState2 != cls ? 'Z' : '\f') != '\f' && AGState2 != cls2) {
                    int i = APIGuard + 91;
                    getSharedInstance = i % 128;
                    if ((i % 2 != 0 ? (char) 27 : '^') == '^') {
                        return null;
                    }
                    throw new ArithmeticException();
                }
                setScaleX<T> setscalex2 = setscalex;
                int i2 = getSharedInstance + 83;
                APIGuard = i2 % 128;
                if ((i2 % 2 == 0 ? '/' : (char) 1) == 1) {
                    return setscalex2;
                }
                throw new ArithmeticException();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Factory[type=");
                sb.append(cls.getName());
                sb.append("+");
                sb.append(cls2.getName());
                sb.append(",adapter=");
                sb.append(setscalex);
                sb.append("]");
                String obj = sb.toString();
                int i = getSharedInstance + 9;
                APIGuard = i % 128;
                if ((i % 2 == 0 ? 'G' : 'T') == 'T') {
                    return obj;
                }
                throw null;
            }
        };
        int i = dpi + 11;
        FU = i % 128;
        if ((i % 2 == 0 ? '\t' : (char) 28) == 28) {
            return setpivotx;
        }
        throw new ArithmeticException();
    }

    private static <T1> setPivotX values(final Class<T1> cls, final setScaleX<T1> setscalex) {
        setPivotX setpivotx = new setPivotX() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.27
            private static int getSharedInstance = 1;
            private static int values;

            @Override // com.apiguard3.internal.setPivotX
            public final <T2> setScaleX<T2> valueOf(setScreenReaderFocusable setscreenreaderfocusable, setScrollbarFadingEnabled<T2> setscrollbarfadingenabled) {
                getSharedInstance = (values + 41) % 128;
                if ((!cls.isAssignableFrom(setscrollbarfadingenabled.AGState()) ? Typography.dollar : 'J') != '$') {
                    return (setScaleX<T2>) new setScaleX<T1>() { // from class: com.apiguard3.internal.setHorizontalFadingEdgeEnabled.27.5
                        private static int getSharedInstance = 1;
                        private static int valueOf;

                        @Override // com.apiguard3.internal.setScaleX
                        public final void getSharedInstance(setLayerType setlayertype, T1 t1) throws IOException {
                            int i = valueOf + 103;
                            getSharedInstance = i % 128;
                            if (!(i % 2 == 0)) {
                                setscalex.getSharedInstance(setlayertype, t1);
                            } else {
                                setscalex.getSharedInstance(setlayertype, t1);
                                throw new NullPointerException();
                            }
                        }
                    };
                }
                int i = getSharedInstance + 33;
                values = i % 128;
                if (i % 2 != 0) {
                    throw new ArithmeticException();
                }
                return null;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Factory[typeHierarchy=");
                sb.append(cls.getName());
                sb.append(",adapter=");
                sb.append(setscalex);
                sb.append("]");
                String obj = sb.toString();
                int i = values + 59;
                getSharedInstance = i % 128;
                if ((i % 2 == 0 ? InputCardNumberView.DIVIDER : '=') != ' ') {
                    return obj;
                }
                throw new ArithmeticException();
            }
        };
        dpi = (FU + 123) % 128;
        return setpivotx;
    }
}
