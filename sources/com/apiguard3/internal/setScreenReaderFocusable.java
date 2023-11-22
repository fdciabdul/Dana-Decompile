package com.apiguard3.internal;

import com.alibaba.fastjson.parser.JSONLexer;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setScreenReaderFocusable {
    private Map<setScrollbarFadingEnabled<?>, setScaleX<?>> APIGuard;
    private boolean analyzeResponse;
    private boolean generateHeaders;
    private List<setPivotX> getRequestHeaders;
    private setAlpha getSharedInstance;
    private boolean initialize;
    private boolean parseResponseHeaders;
    private ThreadLocal<Map<setScrollbarFadingEnabled<?>, getSharedInstance<?>>> valueOf;
    private setTranslationZ values;
    private static setScrollbarFadingEnabled<?> AGState = setScrollbarFadingEnabled.valueOf(Object.class);
    private static int log = 1;
    private static int checkCertificates = (log + 45) % 128;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public setScreenReaderFocusable() {
        /*
            r8 = this;
            com.apiguard3.internal.setTransitionAlpha r1 = com.apiguard3.internal.setTransitionAlpha.values
            com.apiguard3.internal.setLongClickable r2 = com.apiguard3.internal.setLongClickable.IDENTITY
            java.util.Map r3 = java.util.Collections.emptyMap()
            com.apiguard3.internal.setRotation r4 = com.apiguard3.internal.setRotation.DEFAULT
            java.util.Collections.emptyList()
            java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            com.apiguard3.internal.setTouchDelegate r6 = com.apiguard3.internal.setTouchDelegate.DOUBLE
            com.apiguard3.internal.setTouchDelegate r7 = com.apiguard3.internal.setTouchDelegate.LAZILY_PARSED_NUMBER
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setScreenReaderFocusable.<init>():void");
    }

    private setScreenReaderFocusable(setTransitionAlpha settransitionalpha, setAccessibilityHeading setaccessibilityheading, Map<Type, setKeyboardNavigationCluster<?>> map, setRotation setrotation, List<setPivotX> list, setCameraDistance setcameradistance, setCameraDistance setcameradistance2) {
        this.valueOf = new ThreadLocal<>();
        this.APIGuard = new ConcurrentHashMap();
        this.getSharedInstance = new setAlpha(map);
        this.analyzeResponse = false;
        this.initialize = false;
        this.parseResponseHeaders = true;
        this.generateHeaders = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add(setHorizontalFadingEdgeEnabled.ScoredEntry);
        arrayList.add(setAnimationMatrix.values(setcameradistance));
        arrayList.add(settransitionalpha);
        arrayList.addAll(list);
        arrayList.add(setHorizontalFadingEdgeEnabled.onInitializationSuccess);
        arrayList.add(setHorizontalFadingEdgeEnabled.initialize);
        arrayList.add(setHorizontalFadingEdgeEnabled.getSharedInstance);
        arrayList.add(setHorizontalFadingEdgeEnabled.APIGuard);
        arrayList.add(setHorizontalFadingEdgeEnabled.generateHeaders);
        setScaleX<Number> valueOf = valueOf(setrotation);
        arrayList.add(setHorizontalFadingEdgeEnabled.AGState(Long.TYPE, Long.class, valueOf));
        arrayList.add(setHorizontalFadingEdgeEnabled.AGState(Double.TYPE, Double.class, getSharedInstance(false)));
        arrayList.add(setHorizontalFadingEdgeEnabled.AGState(Float.TYPE, Float.class, valueOf(false)));
        arrayList.add(setStateListAnimator.valueOf(setcameradistance2));
        arrayList.add(setHorizontalFadingEdgeEnabled.getRequestHeaders);
        arrayList.add(setHorizontalFadingEdgeEnabled.parseResponseHeaders);
        arrayList.add(setHorizontalFadingEdgeEnabled.valueOf(AtomicLong.class, AGState(valueOf)));
        arrayList.add(setHorizontalFadingEdgeEnabled.valueOf(AtomicLongArray.class, valueOf(valueOf)));
        arrayList.add(setHorizontalFadingEdgeEnabled.analyzeResponse);
        arrayList.add(setHorizontalFadingEdgeEnabled.updateKernel);
        arrayList.add(setHorizontalFadingEdgeEnabled.onInitializationFailure);
        arrayList.add(setHorizontalFadingEdgeEnabled.BuildConfig);
        arrayList.add(setHorizontalFadingEdgeEnabled.valueOf(BigDecimal.class, setHorizontalFadingEdgeEnabled.APIGuard$Callback));
        arrayList.add(setHorizontalFadingEdgeEnabled.valueOf(BigInteger.class, setHorizontalFadingEdgeEnabled.APIGuard$InitializationCallback));
        arrayList.add(setHorizontalFadingEdgeEnabled.pushMinPayload);
        arrayList.add(setHorizontalFadingEdgeEnabled.getVersion);
        arrayList.add(setHorizontalFadingEdgeEnabled.AnalysesEntry);
        arrayList.add(setHorizontalFadingEdgeEnabled.pushMaxPayload);
        arrayList.add(setHorizontalFadingEdgeEnabled.FraudScore);
        arrayList.add(setHorizontalFadingEdgeEnabled.send);
        arrayList.add(setHorizontalFadingEdgeEnabled.AGState);
        arrayList.add(setTranslationX.AGState);
        arrayList.add(setHorizontalFadingEdgeEnabled.clearCallback);
        if (setVerticalScrollBarEnabled.values) {
            arrayList.add(setVerticalScrollBarEnabled.valueOf);
            arrayList.add(setVerticalScrollBarEnabled.AGState);
            arrayList.add(setVerticalScrollBarEnabled.APIGuard);
        }
        arrayList.add(setTranslationY.APIGuard);
        arrayList.add(setHorizontalFadingEdgeEnabled.valueOf);
        arrayList.add(new setElevation(this.getSharedInstance));
        arrayList.add(new setOutlineProvider(this.getSharedInstance, false));
        setTranslationZ settranslationz = new setTranslationZ(this.getSharedInstance);
        this.values = settranslationz;
        arrayList.add(settranslationz);
        arrayList.add(setHorizontalFadingEdgeEnabled.Config);
        arrayList.add(new setOutlineSpotShadowColor(this.getSharedInstance, setaccessibilityheading, settransitionalpha, this.values));
        this.getRequestHeaders = Collections.unmodifiableList(arrayList);
    }

    private setScaleX<Number> getSharedInstance(boolean z) {
        setScaleX<Number> setscalex = new setScaleX<Number>() { // from class: com.apiguard3.internal.setScreenReaderFocusable.5
            private static int AGState = 0;
            private static int APIGuard = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
                APIGuard = (AGState + 95) % 128;
                APIGuard(setlayertype, number);
                APIGuard = (AGState + 3) % 128;
            }

            private static void APIGuard(setLayerType setlayertype, Number number) throws IOException {
                AGState = (APIGuard + 125) % 128;
                if (!(number != null)) {
                    setlayertype.analyzeResponse();
                    return;
                }
                setScreenReaderFocusable.valueOf(number.doubleValue());
                setlayertype.APIGuard(number);
                AGState = (APIGuard + 71) % 128;
            }
        };
        checkCertificates = (log + 13) % 128;
        return setscalex;
    }

    private setScaleX<Number> valueOf(boolean z) {
        setScaleX<Number> setscalex = new setScaleX<Number>() { // from class: com.apiguard3.internal.setScreenReaderFocusable.2
            private static int APIGuard = 0;
            private static int getSharedInstance = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
                getSharedInstance = (APIGuard + 93) % 128;
                valueOf(setlayertype, number);
                int i = getSharedInstance + 125;
                APIGuard = i % 128;
                if ((i % 2 != 0 ? 'P' : 'Y') == 'Y') {
                    return;
                }
                throw new NullPointerException();
            }

            private static void valueOf(setLayerType setlayertype, Number number) throws IOException {
                int i = APIGuard + 45;
                getSharedInstance = i % 128;
                if (i % 2 == 0) {
                    throw new NullPointerException();
                }
                if ((number == null ? Typography.quote : (char) 25) != 25) {
                    setlayertype.analyzeResponse();
                    return;
                }
                setScreenReaderFocusable.valueOf(number.floatValue());
                setlayertype.APIGuard(number);
                APIGuard = (getSharedInstance + 9) % 128;
            }
        };
        checkCertificates = (log + 3) % 128;
        return setscalex;
    }

    static void valueOf(double d) {
        if ((!Double.isNaN(d)) == true) {
            log = (checkCertificates + 31) % 128;
            if (!Double.isInfinite(d)) {
                int i = log + 55;
                checkCertificates = i % 128;
                if ((i % 2 != 0 ? '6' : ']') != '6') {
                    return;
                }
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d);
        sb.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        throw new IllegalArgumentException(sb.toString());
    }

    private static setScaleX<Number> valueOf(setRotation setrotation) {
        int i = log + 45;
        checkCertificates = i % 128;
        if ((i % 2 != 0 ? (char) 17 : (char) 28) != 17) {
            if (setrotation == setRotation.DEFAULT) {
                int i2 = checkCertificates + 21;
                log = i2 % 128;
                if (i2 % 2 != 0) {
                    return setHorizontalFadingEdgeEnabled.getState;
                }
                setScaleX<Number> setscalex = setHorizontalFadingEdgeEnabled.getState;
                throw null;
            }
            return new setScaleX<Number>() { // from class: com.apiguard3.internal.setScreenReaderFocusable.1
                private static int AGState = 1;
                private static int APIGuard;

                @Override // com.apiguard3.internal.setScaleX
                public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, Number number) throws IOException {
                    int i3 = AGState + 99;
                    APIGuard = i3 % 128;
                    boolean z = i3 % 2 == 0;
                    values(setlayertype, number);
                    if (!z) {
                        throw null;
                    }
                    AGState = (APIGuard + 123) % 128;
                }

                private static void values(setLayerType setlayertype, Number number) throws IOException {
                    AGState = (APIGuard + 93) % 128;
                    if (!(number == null)) {
                        setlayertype.AGState(number.toString());
                        return;
                    }
                    setlayertype.analyzeResponse();
                    AGState = (APIGuard + 11) % 128;
                }
            };
        }
        setRotation setrotation2 = setRotation.DEFAULT;
        throw new NullPointerException();
    }

    private static setScaleX<AtomicLong> AGState(final setScaleX<Number> setscalex) {
        setScaleX<AtomicLong> AGState2 = new setScaleX<AtomicLong>() { // from class: com.apiguard3.internal.setScreenReaderFocusable.4
            private static int AGState = 1;
            private static int values;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, AtomicLong atomicLong) throws IOException {
                AGState = (values + 59) % 128;
                APIGuard(setlayertype, atomicLong);
                int i = AGState + 9;
                values = i % 128;
                if ((i % 2 != 0 ? Typography.quote : '*') != '\"') {
                    return;
                }
                throw new NullPointerException();
            }

            private void APIGuard(setLayerType setlayertype, AtomicLong atomicLong) throws IOException {
                int i = AGState + 19;
                values = i % 128;
                if ((i % 2 != 0 ? JSONLexer.EOI : 'E') == 'E') {
                    setScaleX.this.getSharedInstance(setlayertype, Long.valueOf(atomicLong.get()));
                } else {
                    setScaleX.this.getSharedInstance(setlayertype, Long.valueOf(atomicLong.get()));
                    throw new ArithmeticException();
                }
            }
        }.AGState();
        int i = log + 5;
        checkCertificates = i % 128;
        if ((i % 2 != 0 ? 'a' : '+') == '+') {
            return AGState2;
        }
        throw null;
    }

    private static setScaleX<AtomicLongArray> valueOf(final setScaleX<Number> setscalex) {
        setScaleX<AtomicLongArray> AGState2 = new setScaleX<AtomicLongArray>() { // from class: com.apiguard3.internal.setScreenReaderFocusable.3
            private static int getSharedInstance = 0;
            private static int valueOf = 1;

            @Override // com.apiguard3.internal.setScaleX
            public final /* synthetic */ void getSharedInstance(setLayerType setlayertype, AtomicLongArray atomicLongArray) throws IOException {
                int i = getSharedInstance + 45;
                valueOf = i % 128;
                boolean z = i % 2 == 0;
                values(setlayertype, atomicLongArray);
                if (z) {
                    throw new ArithmeticException();
                }
            }

            private void values(setLayerType setlayertype, AtomicLongArray atomicLongArray) throws IOException {
                int length;
                int i;
                int i2 = valueOf + 5;
                getSharedInstance = i2 % 128;
                if ((i2 % 2 != 0 ? '4' : (char) 29) != '4') {
                    setlayertype.valueOf();
                    length = atomicLongArray.length();
                    i = 0;
                } else {
                    setlayertype.valueOf();
                    length = atomicLongArray.length();
                    i = 1;
                }
                while (true) {
                    if (i < length) {
                        setScaleX.this.getSharedInstance(setlayertype, Long.valueOf(atomicLongArray.get(i)));
                        i++;
                    } else {
                        setlayertype.values();
                        getSharedInstance = (valueOf + 107) % 128;
                        return;
                    }
                }
            }
        }.AGState();
        checkCertificates = (log + 93) % 128;
        return AGState2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> setScaleX<T> AGState(setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
        boolean z;
        setScaleX<T> setscalex = (setScaleX<T>) this.APIGuard.get(setscrollbarfadingenabled == null ? AGState : setscrollbarfadingenabled);
        if (setscalex != null) {
            return setscalex;
        }
        Map<setScrollbarFadingEnabled<?>, getSharedInstance<?>> map = this.valueOf.get();
        if (map == null) {
            map = new HashMap<>();
            this.valueOf.set(map);
            z = true;
        } else {
            z = false;
        }
        getSharedInstance<?> getsharedinstance = map.get(setscrollbarfadingenabled);
        if (getsharedinstance == null) {
            try {
                getSharedInstance<?> getsharedinstance2 = new getSharedInstance<>();
                map.put(setscrollbarfadingenabled, getsharedinstance2);
                Iterator<setPivotX> it = this.getRequestHeaders.iterator();
                while (it.hasNext()) {
                    setScaleX setscalex2 = (setScaleX<T>) it.next().valueOf(this, setscrollbarfadingenabled);
                    if (!(setscalex2 == null)) {
                        getsharedinstance2.values(setscalex2);
                        this.APIGuard.put(setscrollbarfadingenabled, setscalex2);
                        map.remove(setscrollbarfadingenabled);
                        if ((z ? (char) 14 : '6') == 14) {
                            this.valueOf.remove();
                        }
                        return setscalex2;
                    }
                    log = (checkCertificates + 13) % 128;
                }
                throw new IllegalArgumentException("GSON (2.8.9) cannot handle ".concat(String.valueOf(setscrollbarfadingenabled)));
            } catch (Throwable th) {
                map.remove(setscrollbarfadingenabled);
                if (z) {
                    this.valueOf.remove();
                    log = (checkCertificates + 89) % 128;
                }
                throw th;
            }
        }
        checkCertificates = (log + 119) % 128;
        return getsharedinstance;
    }

    public final <T> setScaleX<T> APIGuard(setPivotX setpivotx, setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
        if (!this.getRequestHeaders.contains(setpivotx)) {
            setpivotx = this.values;
        }
        Iterator<setPivotX> it = this.getRequestHeaders.iterator();
        boolean z = false;
        while (true) {
            if ((it.hasNext() ? 'E' : '_') != 'E') {
                throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(setscrollbarfadingenabled)));
            }
            checkCertificates = (log + 17) % 128;
            setPivotX next = it.next();
            if ((!z) == true) {
                checkCertificates = (log + 31) % 128;
                if ((next == setpivotx ? (char) 29 : '\t') == 29) {
                    z = true;
                }
            } else {
                setScaleX<T> valueOf = next.valueOf(this, setscrollbarfadingenabled);
                if (valueOf != null) {
                    int i = checkCertificates + 51;
                    log = i % 128;
                    if (i % 2 != 0) {
                        return valueOf;
                    }
                    throw new NullPointerException();
                }
            }
        }
    }

    public final <T> setScaleX<T> valueOf(Class<T> cls) {
        log = (checkCertificates + 93) % 128;
        setScaleX<T> AGState2 = AGState(setScrollbarFadingEnabled.valueOf(cls));
        log = (checkCertificates + 11) % 128;
        return AGState2;
    }

    public final String valueOf(Object obj) {
        int i = checkCertificates;
        log = (i + 91) % 128;
        if ((obj == null ? '.' : '\b') != '\b') {
            int i2 = i + 45;
            log = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return APIGuard(setAccessibilityLiveRegion.getSharedInstance);
            }
            APIGuard(setAccessibilityLiveRegion.getSharedInstance);
            throw new NullPointerException();
        }
        return getSharedInstance(obj, obj.getClass());
    }

    private String getSharedInstance(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        valueOf(obj, type, stringWriter);
        String obj2 = stringWriter.toString();
        log = (checkCertificates + 41) % 128;
        return obj2;
    }

    private void valueOf(Object obj, Type type, Appendable appendable) throws setDefaultFocusHighlightEnabled {
        checkCertificates = (log + 117) % 128;
        try {
            getSharedInstance(obj, type, getSharedInstance(setBottom.AGState(appendable)));
            int i = checkCertificates + 57;
            log = i % 128;
            if (!(i % 2 == 0)) {
                return;
            }
            throw new NullPointerException();
        } catch (IOException e) {
            throw new setDefaultFocusHighlightEnabled(e);
        }
    }

    private void getSharedInstance(Object obj, Type type, setLayerType setlayertype) throws setDefaultFocusHighlightEnabled {
        log = (checkCertificates + 119) % 128;
        setScaleX AGState2 = AGState(setScrollbarFadingEnabled.getSharedInstance(type));
        boolean parseResponseHeaders = setlayertype.parseResponseHeaders();
        setlayertype.AGState(true);
        boolean generateHeaders = setlayertype.generateHeaders();
        setlayertype.getSharedInstance(this.parseResponseHeaders);
        boolean requestHeaders = setlayertype.getRequestHeaders();
        setlayertype.valueOf(false);
        try {
            try {
                AGState2.getSharedInstance(setlayertype, obj);
                setlayertype.AGState(parseResponseHeaders);
                setlayertype.getSharedInstance(generateHeaders);
                setlayertype.valueOf(requestHeaders);
                log = (checkCertificates + 123) % 128;
            } catch (IOException e) {
                throw new setDefaultFocusHighlightEnabled(e);
            } catch (AssertionError e2) {
                StringBuilder sb = new StringBuilder("AssertionError (GSON 2.8.9): ");
                sb.append(e2.getMessage());
                AssertionError assertionError = new AssertionError(sb.toString());
                assertionError.initCause(e2);
                throw assertionError;
            }
        } catch (Throwable th) {
            setlayertype.AGState(parseResponseHeaders);
            setlayertype.getSharedInstance(generateHeaders);
            setlayertype.valueOf(requestHeaders);
            throw th;
        }
    }

    private String APIGuard(setHovered sethovered) {
        StringWriter stringWriter = new StringWriter();
        valueOf(sethovered, stringWriter);
        String obj = stringWriter.toString();
        log = (checkCertificates + 57) % 128;
        return obj;
    }

    private void valueOf(setHovered sethovered, Appendable appendable) throws setDefaultFocusHighlightEnabled {
        int i = checkCertificates + 85;
        log = i % 128;
        try {
            if (i % 2 != 0) {
                values(sethovered, getSharedInstance(setBottom.AGState(appendable)));
                checkCertificates = (log + 123) % 128;
                return;
            }
            values(sethovered, getSharedInstance(setBottom.AGState(appendable)));
            throw null;
        } catch (IOException e) {
            throw new setDefaultFocusHighlightEnabled(e);
        }
    }

    private setLayerType getSharedInstance(Writer writer) throws IOException {
        setLayerType setlayertype = new setLayerType(writer);
        setlayertype.valueOf(false);
        int i = log + 61;
        checkCertificates = i % 128;
        if (i % 2 == 0) {
            return setlayertype;
        }
        throw new ArithmeticException();
    }

    private void values(setHovered sethovered, setLayerType setlayertype) throws setDefaultFocusHighlightEnabled {
        log = (checkCertificates + 5) % 128;
        boolean parseResponseHeaders = setlayertype.parseResponseHeaders();
        setlayertype.AGState(true);
        boolean generateHeaders = setlayertype.generateHeaders();
        setlayertype.getSharedInstance(this.parseResponseHeaders);
        boolean requestHeaders = setlayertype.getRequestHeaders();
        setlayertype.valueOf(false);
        try {
            try {
                try {
                    setBottom.APIGuard(sethovered, setlayertype);
                    setlayertype.AGState(parseResponseHeaders);
                    setlayertype.getSharedInstance(generateHeaders);
                    setlayertype.valueOf(requestHeaders);
                    int i = checkCertificates + 57;
                    log = i % 128;
                    if (i % 2 == 0) {
                        throw new ArithmeticException();
                    }
                } catch (AssertionError e) {
                    StringBuilder sb = new StringBuilder("AssertionError (GSON 2.8.9): ");
                    sb.append(e.getMessage());
                    AssertionError assertionError = new AssertionError(sb.toString());
                    assertionError.initCause(e);
                    throw assertionError;
                }
            } catch (IOException e2) {
                throw new setDefaultFocusHighlightEnabled(e2);
            }
        } catch (Throwable th) {
            setlayertype.AGState(parseResponseHeaders);
            setlayertype.getSharedInstance(generateHeaders);
            setlayertype.valueOf(requestHeaders);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class getSharedInstance<T> extends setScaleX<T> {
        private static int AGState = 1;
        private static int getSharedInstance;
        private setScaleX<T> APIGuard;

        getSharedInstance() {
        }

        public final void values(setScaleX<T> setscalex) {
            int i = (AGState + 77) % 128;
            getSharedInstance = i;
            if (this.APIGuard != null) {
                throw new AssertionError();
            }
            this.APIGuard = setscalex;
            AGState = (i + 11) % 128;
        }

        @Override // com.apiguard3.internal.setScaleX
        public final void getSharedInstance(setLayerType setlayertype, T t) throws IOException {
            int i = getSharedInstance + 5;
            AGState = i % 128;
            if (i % 2 != 0) {
                setScaleX<T> setscalex = this.APIGuard;
                if (setscalex == null) {
                    throw new IllegalStateException();
                }
                setscalex.getSharedInstance(setlayertype, t);
                int i2 = getSharedInstance + 93;
                AGState = i2 % 128;
                if ((i2 % 2 == 0 ? '8' : (char) 7) == 7) {
                    return;
                }
                throw null;
            }
            throw null;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{serializeNulls:false");
        sb.append(",factories:");
        sb.append(this.getRequestHeaders);
        sb.append(",instanceCreators:");
        sb.append(this.getSharedInstance);
        sb.append("}");
        String obj = sb.toString();
        int i = log + 45;
        checkCertificates = i % 128;
        if (i % 2 != 0) {
            throw new NullPointerException();
        }
        return obj;
    }
}
