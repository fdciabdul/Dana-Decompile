package com.apiguard3.internal;

import id.dana.cashier.view.InputCardNumberView;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setX<K, V> extends AbstractMap<K, V> implements Serializable {
    private static int AGState = 124;
    private static /* synthetic */ boolean APIGuard = true;
    private static final Comparator<Comparable> getSharedInstance = new Comparator<Comparable>() { // from class: com.apiguard3.internal.setX.5
        private static int getSharedInstance = 0;
        private static int values = 1;

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Comparable comparable, Comparable comparable2) {
            int i = getSharedInstance + 123;
            values = i % 128;
            char c = i % 2 == 0 ? 'X' : Typography.greater;
            int AGState2 = AGState(comparable, comparable2);
            if (c == 'X') {
                throw new ArithmeticException();
            }
            values = (getSharedInstance + 49) % 128;
            return AGState2;
        }

        private static int AGState(Comparable comparable, Comparable comparable2) {
            int i = getSharedInstance + 117;
            values = i % 128;
            if (i % 2 == 0) {
                comparable.compareTo(comparable2);
                throw new NullPointerException();
            }
            int compareTo = comparable.compareTo(comparable2);
            values = (getSharedInstance + 113) % 128;
            return compareTo;
        }
    };
    private static int valueOf = 1;
    Comparator<? super K> comparator;
    private setX<K, V>.getSharedInstance entrySet;
    final AGState<K, V> header;
    private setX<K, V>.valueOf keySet;
    int modCount;
    AGState<K, V> root;
    int size;

    public setX() {
        this(getSharedInstance);
    }

    private setX(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new AGState<>();
        this.comparator = comparator == null ? getSharedInstance : comparator;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        int i = AGState + 91;
        int i2 = i % 128;
        valueOf = i2;
        if (!(i % 2 != 0)) {
            throw new NullPointerException();
        }
        int i3 = this.size;
        int i4 = i2 + 89;
        AGState = i4 % 128;
        if (i4 % 2 != 0) {
            throw new NullPointerException();
        }
        return i3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        AGState = (valueOf + 109) % 128;
        AGState<K, V> values2 = values(obj);
        if (!(values2 != null)) {
            return null;
        }
        int i = valueOf + 69;
        AGState = i % 128;
        boolean z = i % 2 == 0;
        V v = values2.initialize;
        if (!z) {
            throw new NullPointerException();
        }
        int i2 = AGState + 31;
        valueOf = i2 % 128;
        if (i2 % 2 != 0) {
            return v;
        }
        throw new ArithmeticException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        valueOf = (AGState + 21) % 128;
        if ((values(obj) != null ? (char) 17 : 'B') != 'B') {
            return true;
        }
        int i = valueOf + 51;
        AGState = i % 128;
        if (i % 2 == 0) {
            return false;
        }
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        int i = AGState + 87;
        valueOf = i % 128;
        if ((i % 2 == 0 ? 'C' : 'K') == 'C') {
            throw null;
        } else if (k == null) {
            throw new NullPointerException("key == null");
        } else {
            AGState<K, V> sharedInstance = getSharedInstance((setX<K, V>) k, true);
            V v2 = sharedInstance.initialize;
            sharedInstance.initialize = v;
            AGState = (valueOf + 107) % 128;
            return v2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        int i;
        int i2 = AGState + 45;
        valueOf = i2 % 128;
        if (!(i2 % 2 != 0)) {
            this.root = null;
            this.size = 0;
            i = this.modCount * 1;
        } else {
            this.root = null;
            this.size = 0;
            i = this.modCount + 1;
        }
        this.modCount = i;
        AGState<K, V> aGState = this.header;
        aGState.AGState = aGState;
        aGState.APIGuard = aGState;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        valueOf = (AGState + 9) % 128;
        AGState<K, V> AGState2 = AGState(obj);
        if (!(AGState2 == null)) {
            int i = valueOf + 3;
            AGState = i % 128;
            V v = AGState2.initialize;
            if (i % 2 != 0) {
                throw new ArithmeticException();
            }
            int i2 = AGState + 25;
            valueOf = i2 % 128;
            if (i2 % 2 != 0) {
                return v;
            }
            throw new ArithmeticException();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (r4 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.apiguard3.internal.setX.AGState<K, V> getSharedInstance(K r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setX.getSharedInstance(java.lang.Object, boolean):com.apiguard3.internal.setX$AGState");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AGState<K, V> values(Object obj) {
        if (obj == 0) {
            int i = valueOf + 1;
            AGState = i % 128;
            if ((i % 2 != 0 ? InputCardNumberView.DIVIDER : 'K') != ' ') {
                return null;
            }
            throw new NullPointerException();
        }
        int i2 = valueOf + 17;
        AGState = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                return getSharedInstance((setX<K, V>) obj, false);
            }
            return getSharedInstance((setX<K, V>) obj, true);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.apiguard3.internal.setX.AGState<K, V> valueOf(java.util.Map.Entry<?, ?> r3) {
        /*
            r2 = this;
            int r0 = com.apiguard3.internal.setX.valueOf
            int r0 = r0 + 73
            int r0 = r0 % 128
            com.apiguard3.internal.setX.AGState = r0
            java.lang.Object r0 = r3.getKey()
            com.apiguard3.internal.setX$AGState r0 = r2.values(r0)
            if (r0 == 0) goto L28
            int r1 = com.apiguard3.internal.setX.AGState
            int r1 = r1 + 101
            int r1 = r1 % 128
            com.apiguard3.internal.setX.valueOf = r1
            V r1 = r0.initialize
            java.lang.Object r3 = r3.getValue()
            boolean r3 = values(r1, r3)
            if (r3 == 0) goto L28
            r3 = 1
            goto L31
        L28:
            int r3 = com.apiguard3.internal.setX.AGState
            int r3 = r3 + 29
            int r3 = r3 % 128
            com.apiguard3.internal.setX.valueOf = r3
            r3 = 0
        L31:
            r1 = 4
            if (r3 == 0) goto L36
            r3 = 4
            goto L38
        L36:
            r3 = 49
        L38:
            if (r3 == r1) goto L44
            int r3 = com.apiguard3.internal.setX.AGState
            int r3 = r3 + 69
            int r3 = r3 % 128
            com.apiguard3.internal.setX.valueOf = r3
            r3 = 0
            return r3
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setX.valueOf(java.util.Map$Entry):com.apiguard3.internal.setX$AGState");
    }

    private static boolean values(Object obj, Object obj2) {
        int i = (valueOf + 125) % 128;
        AGState = i;
        if (obj != obj2) {
            valueOf = (i + 43) % 128;
            if (obj == null || !obj.equals(obj2)) {
                int i2 = valueOf + 111;
                AGState = i2 % 128;
                if ((i2 % 2 != 0 ? '/' : ':') == ':') {
                    return false;
                }
                throw new ArithmeticException();
            }
            return true;
        }
        return true;
    }

    final void APIGuard(AGState<K, V> aGState, boolean z) {
        AGState<K, V> APIGuard2;
        int i;
        if (z) {
            aGState.AGState.APIGuard = aGState.APIGuard;
            aGState.APIGuard.AGState = aGState.AGState;
        }
        AGState<K, V> aGState2 = aGState.values;
        AGState<K, V> aGState3 = aGState.valueOf;
        AGState<K, V> aGState4 = aGState.getSharedInstance;
        int i2 = 0;
        if ((aGState2 != null ? '+' : (char) 7) == '+') {
            int i3 = AGState;
            valueOf = (i3 + 91) % 128;
            if (aGState3 != null) {
                int i4 = i3 + 17;
                valueOf = i4 % 128;
                if (i4 % 2 == 0) {
                    int i5 = aGState2.analyzeResponse;
                    int i6 = aGState3.analyzeResponse;
                    throw new NullPointerException();
                }
                if (aGState2.analyzeResponse > aGState3.analyzeResponse) {
                    APIGuard2 = aGState2.getSharedInstance();
                } else {
                    APIGuard2 = aGState3.APIGuard();
                    AGState = (valueOf + 11) % 128;
                }
                APIGuard(APIGuard2, false);
                AGState<K, V> aGState5 = aGState.values;
                if (aGState5 == null) {
                    i = 0;
                } else {
                    i = aGState5.analyzeResponse;
                    APIGuard2.values = aGState5;
                    aGState5.getSharedInstance = APIGuard2;
                    aGState.values = null;
                    AGState = (valueOf + 31) % 128;
                }
                AGState<K, V> aGState6 = aGState.valueOf;
                if (aGState6 != null) {
                    i2 = aGState6.analyzeResponse;
                    APIGuard2.valueOf = aGState6;
                    aGState6.getSharedInstance = APIGuard2;
                    aGState.valueOf = null;
                }
                APIGuard2.analyzeResponse = Math.max(i, i2) + 1;
                getSharedInstance(aGState, APIGuard2);
                return;
            }
        }
        if ((aGState2 != null ? '/' : 'M') != '/') {
            if (!(aGState3 == null)) {
                getSharedInstance(aGState, aGState3);
                aGState.valueOf = null;
            } else {
                getSharedInstance(aGState, (AGState) null);
            }
        } else {
            getSharedInstance(aGState, aGState2);
            aGState.values = null;
        }
        getSharedInstance((AGState) aGState4, false);
        this.size--;
        this.modCount++;
    }

    final AGState<K, V> AGState(Object obj) {
        valueOf = (AGState + 53) % 128;
        AGState<K, V> values2 = values(obj);
        if ((values2 == null ? (char) 14 : '5') != 14) {
            int i = AGState + 49;
            valueOf = i % 128;
            APIGuard(values2, (i % 2 == 0 ? 'a' : (char) 7) != 'a');
        }
        return values2;
    }

    private void getSharedInstance(AGState<K, V> aGState, AGState<K, V> aGState2) {
        int i = AGState + 63;
        valueOf = i % 128;
        if (i % 2 == 0) {
            AGState<K, V> aGState3 = aGState.getSharedInstance;
            aGState.getSharedInstance = null;
            throw null;
        }
        AGState<K, V> aGState4 = aGState.getSharedInstance;
        aGState.getSharedInstance = null;
        if (!(aGState2 == null)) {
            aGState2.getSharedInstance = aGState4;
        }
        if (aGState4 == null) {
            this.root = aGState2;
            return;
        }
        int i2 = AGState + 69;
        valueOf = i2 % 128;
        if (i2 % 2 == 0) {
            AGState<K, V> aGState5 = aGState4.values;
            throw new ArithmeticException();
        } else if (aGState4.values != aGState) {
            if (!APIGuard && aGState4.valueOf != aGState) {
                throw new AssertionError();
            }
            aGState4.valueOf = aGState2;
            AGState = (valueOf + 81) % 128;
        } else {
            int i3 = valueOf + 61;
            AGState = i3 % 128;
            if (i3 % 2 != 0) {
                aGState4.values = aGState2;
                throw new ArithmeticException();
            } else {
                aGState4.values = aGState2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b5, code lost:
    
        if ((r14 ? '\\' : 'Q') != 'Q') goto L71;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getSharedInstance(com.apiguard3.internal.setX.AGState<K, V> r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setX.getSharedInstance(com.apiguard3.internal.setX$AGState, boolean):void");
    }

    private void getSharedInstance(AGState<K, V> aGState) {
        int i;
        AGState<K, V> aGState2 = aGState.values;
        AGState<K, V> aGState3 = aGState.valueOf;
        AGState<K, V> aGState4 = aGState3.values;
        AGState<K, V> aGState5 = aGState3.valueOf;
        aGState.valueOf = aGState4;
        if ((aGState4 != null ? ',' : (char) 2) != 2) {
            int i2 = valueOf + 107;
            AGState = i2 % 128;
            if (i2 % 2 != 0) {
                aGState4.getSharedInstance = aGState;
                throw null;
            } else {
                aGState4.getSharedInstance = aGState;
                AGState = (valueOf + 47) % 128;
            }
        }
        getSharedInstance(aGState, aGState3);
        aGState3.values = aGState;
        aGState.getSharedInstance = aGState3;
        int i3 = 0;
        int i4 = aGState2 != null ? aGState2.analyzeResponse : 0;
        if ((aGState4 != null ? Typography.less : '#') != '#') {
            int i5 = AGState + 33;
            valueOf = i5 % 128;
            if (i5 % 2 == 0) {
                int i6 = aGState4.analyzeResponse;
                throw new NullPointerException();
            }
            i = aGState4.analyzeResponse;
        } else {
            i = 0;
        }
        aGState.analyzeResponse = Math.max(i4, i) + 1;
        int i7 = aGState.analyzeResponse;
        if ((aGState5 != null ? (char) 19 : 'c') != 'c') {
            i3 = aGState5.analyzeResponse;
        } else {
            AGState = (valueOf + 61) % 128;
        }
        aGState3.analyzeResponse = Math.max(i7, i3) + 1;
    }

    private void values(AGState<K, V> aGState) {
        int i;
        int i2;
        AGState<K, V> aGState2 = aGState.values;
        AGState<K, V> aGState3 = aGState.valueOf;
        AGState<K, V> aGState4 = aGState2.values;
        AGState<K, V> aGState5 = aGState2.valueOf;
        aGState.values = aGState5;
        if (!(aGState5 == null)) {
            aGState5.getSharedInstance = aGState;
        }
        getSharedInstance(aGState, aGState2);
        aGState2.valueOf = aGState;
        aGState.getSharedInstance = aGState2;
        if (aGState3 != null) {
            i = aGState3.analyzeResponse;
            valueOf = (AGState + 111) % 128;
        } else {
            i = 0;
        }
        if ((aGState5 != null ? 'C' : '\n') != '\n') {
            i2 = aGState5.analyzeResponse;
            AGState = (valueOf + 83) % 128;
        } else {
            i2 = 0;
        }
        aGState.analyzeResponse = Math.max(i, i2) + 1;
        aGState2.analyzeResponse = Math.max(aGState.analyzeResponse, aGState4 == null ? 0 : aGState4.analyzeResponse) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        setX<K, V>.getSharedInstance getsharedinstance = this.entrySet;
        if ((getsharedinstance != null ? (char) 29 : (char) 19) == 19) {
            setX<K, V>.getSharedInstance getsharedinstance2 = new getSharedInstance();
            this.entrySet = getsharedinstance2;
            AGState = (valueOf + 71) % 128;
            return getsharedinstance2;
        }
        int i = valueOf + 69;
        AGState = i % 128;
        if ((i % 2 != 0 ? 'b' : '3') == '3') {
            return getsharedinstance;
        }
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        int i = valueOf;
        AGState = (i + 19) % 128;
        setX<K, V>.valueOf valueof = this.keySet;
        if ((valueof != null ? '\n' : '6') != '6') {
            AGState = (i + 73) % 128;
            return valueof;
        }
        setX<K, V>.valueOf valueof2 = new valueOf();
        this.keySet = valueof2;
        return valueof2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class AGState<K, V> implements Map.Entry<K, V> {
        private static int generateHeaders = 1;
        private static int parseResponseHeaders;
        AGState<K, V> AGState;
        AGState<K, V> APIGuard;
        int analyzeResponse;
        final K getRequestHeaders;
        AGState<K, V> getSharedInstance;
        V initialize;
        AGState<K, V> valueOf;
        AGState<K, V> values;

        AGState() {
            this.getRequestHeaders = null;
            this.AGState = this;
            this.APIGuard = this;
        }

        AGState(AGState<K, V> aGState, K k, AGState<K, V> aGState2, AGState<K, V> aGState3) {
            this.getSharedInstance = aGState;
            this.getRequestHeaders = k;
            this.analyzeResponse = 1;
            this.APIGuard = aGState2;
            this.AGState = aGState3;
            aGState3.APIGuard = this;
            aGState2.AGState = this;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            int i = generateHeaders + 49;
            parseResponseHeaders = i % 128;
            if ((i % 2 != 0 ? (char) 6 : '5') != 6) {
                return this.getRequestHeaders;
            }
            throw null;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            int i = (parseResponseHeaders + 101) % 128;
            generateHeaders = i;
            V v = this.initialize;
            parseResponseHeaders = (i + 75) % 128;
            return v;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            int i = parseResponseHeaders + 53;
            generateHeaders = i % 128;
            if (i % 2 != 0) {
                V v2 = this.initialize;
                this.initialize = v;
                return v2;
            }
            this.initialize = v;
            throw new ArithmeticException();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        
            if ((r1.equals(r5.getKey()) ? '4' : '7') != '7') goto L23;
         */
        @Override // java.util.Map.Entry
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean equals(java.lang.Object r5) {
            /*
                r4 = this;
                int r0 = com.apiguard3.internal.setX.AGState.generateHeaders
                int r1 = r0 + 71
                int r1 = r1 % 128
                com.apiguard3.internal.setX.AGState.parseResponseHeaders = r1
                boolean r1 = r5 instanceof java.util.Map.Entry
                r2 = 0
                if (r1 == 0) goto L78
                int r0 = r0 + 47
                int r0 = r0 % 128
                com.apiguard3.internal.setX.AGState.parseResponseHeaders = r0
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                K r1 = r4.getRequestHeaders
                r3 = 55
                if (r1 != 0) goto L43
                int r0 = r0 + 61
                int r1 = r0 % 128
                com.apiguard3.internal.setX.AGState.generateHeaders = r1
                int r0 = r0 % 2
                r1 = 12
                if (r0 != 0) goto L2a
                r0 = 12
                goto L2c
            L2a:
                r0 = 34
            L2c:
                if (r0 == r1) goto L3c
                java.lang.Object r0 = r5.getKey()
                if (r0 != 0) goto L70
                int r0 = com.apiguard3.internal.setX.AGState.parseResponseHeaders
                int r0 = r0 + r3
                int r0 = r0 % 128
                com.apiguard3.internal.setX.AGState.generateHeaders = r0
                goto L54
            L3c:
                r5.getKey()
                r5 = 0
                throw r5     // Catch: java.lang.Throwable -> L41
            L41:
                r5 = move-exception
                throw r5
            L43:
                java.lang.Object r0 = r5.getKey()
                boolean r0 = r1.equals(r0)
                if (r0 == 0) goto L50
                r0 = 52
                goto L52
            L50:
                r0 = 55
            L52:
                if (r0 == r3) goto L70
            L54:
                V r0 = r4.initialize
                r1 = 1
                if (r0 != 0) goto L5b
                r3 = 0
                goto L5c
            L5b:
                r3 = 1
            L5c:
                if (r3 == r1) goto L65
                java.lang.Object r5 = r5.getValue()
                if (r5 != 0) goto L70
                goto L6f
            L65:
                java.lang.Object r5 = r5.getValue()
                boolean r5 = r0.equals(r5)
                if (r5 == 0) goto L70
            L6f:
                return r1
            L70:
                int r5 = com.apiguard3.internal.setX.AGState.generateHeaders
                int r5 = r5 + 71
                int r5 = r5 % 128
                com.apiguard3.internal.setX.AGState.parseResponseHeaders = r5
            L78:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setX.AGState.equals(java.lang.Object):boolean");
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int hashCode;
            K k = this.getRequestHeaders;
            int i = 0;
            if (k != null) {
                hashCode = k.hashCode();
            } else {
                int i2 = generateHeaders + 29;
                parseResponseHeaders = i2 % 128;
                hashCode = !(i2 % 2 == 0) ? 1 : 0;
            }
            V v = this.initialize;
            if (!(v == null)) {
                i = v.hashCode();
            } else {
                parseResponseHeaders = (generateHeaders + 67) % 128;
            }
            return hashCode ^ i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getRequestHeaders);
            sb.append("=");
            sb.append(this.initialize);
            String obj = sb.toString();
            parseResponseHeaders = (generateHeaders + 89) % 128;
            return obj;
        }

        public final AGState<K, V> APIGuard() {
            parseResponseHeaders = (generateHeaders + 41) % 128;
            AGState<K, V> aGState = this.values;
            AGState<K, V> aGState2 = this;
            while (true) {
                if (!(aGState != null)) {
                    return aGState2;
                }
                AGState<K, V> aGState3 = aGState.values;
                parseResponseHeaders = (generateHeaders + 125) % 128;
                aGState2 = aGState;
                aGState = aGState3;
            }
        }

        public final AGState<K, V> getSharedInstance() {
            parseResponseHeaders = (generateHeaders + 91) % 128;
            AGState<K, V> aGState = this.valueOf;
            AGState<K, V> aGState2 = this;
            while (true) {
                if ((aGState != null ? '\\' : '(') != '\\') {
                    return aGState2;
                }
                int i = generateHeaders + 95;
                parseResponseHeaders = i % 128;
                if (!(i % 2 == 0)) {
                    AGState<K, V> aGState3 = aGState.valueOf;
                    throw null;
                }
                aGState2 = aGState;
                aGState = aGState.valueOf;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public abstract class values<T> implements Iterator<T>, j$.util.Iterator {
        private static int getRequestHeaders = 1;
        private static int valueOf;
        private int AGState;
        private AGState<K, V> APIGuard;
        private AGState<K, V> getSharedInstance = null;

        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.getAuthRequestContext(this, consumer);
        }

        @Override // java.util.Iterator
        public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
            forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
        }

        values() {
            this.APIGuard = setX.this.header.APIGuard;
            this.AGState = setX.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.APIGuard == setX.this.header) {
                return false;
            }
            int i = (getRequestHeaders + 25) % 128;
            valueOf = i;
            getRequestHeaders = (i + 11) % 128;
            return true;
        }

        final AGState<K, V> APIGuard() {
            valueOf = (getRequestHeaders + 121) % 128;
            AGState<K, V> aGState = this.APIGuard;
            if (aGState == setX.this.header) {
                throw new NoSuchElementException();
            }
            if (setX.this.modCount != this.AGState) {
                throw new ConcurrentModificationException();
            }
            this.APIGuard = aGState.APIGuard;
            this.getSharedInstance = aGState;
            int i = getRequestHeaders + 69;
            valueOf = i % 128;
            if (i % 2 == 0) {
                return aGState;
            }
            throw new NullPointerException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            int i = getRequestHeaders + 95;
            valueOf = i % 128;
            if (!(i % 2 != 0)) {
                AGState<K, V> aGState = this.getSharedInstance;
                if (aGState == null) {
                    throw new IllegalStateException();
                }
                setX.this.APIGuard(aGState, true);
                this.getSharedInstance = null;
                this.AGState = setX.this.modCount;
                valueOf = (getRequestHeaders + 9) % 128;
                return;
            }
            throw new NullPointerException();
        }
    }

    /* loaded from: classes7.dex */
    class getSharedInstance extends AbstractSet<Map.Entry<K, V>> {
        private static int AGState = 1;
        private static int values;

        getSharedInstance() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int i = AGState + 75;
            values = i % 128;
            if ((i % 2 != 0 ? (char) 20 : 'X') != 'X') {
                int i2 = setX.this.size;
                throw null;
            }
            int i3 = setX.this.size;
            AGState = (values + 67) % 128;
            return i3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public java.util.Iterator<Map.Entry<K, V>> iterator() {
            values valuesVar = new values(this) { // from class: com.apiguard3.internal.setX.getSharedInstance.5
                private static int getSharedInstance = 0;
                private static int values = 1;

                {
                    setX setx = setX.this;
                }

                @Override // java.util.Iterator
                public final /* synthetic */ Object next() {
                    int i = getSharedInstance + 5;
                    values = i % 128;
                    if (!(i % 2 == 0)) {
                        return AGState();
                    }
                    AGState();
                    throw new ArithmeticException();
                }

                private Map.Entry<K, V> AGState() {
                    int i = values + 71;
                    getSharedInstance = i % 128;
                    if (i % 2 == 0) {
                        return APIGuard();
                    }
                    APIGuard();
                    throw new NullPointerException();
                }
            };
            int i = AGState + 61;
            values = i % 128;
            if ((i % 2 != 0 ? 'T' : '8') != 'T') {
                return valuesVar;
            }
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int i = AGState + 15;
            values = i % 128;
            if ((i % 2 != 0 ? '2' : '!') != '!') {
                throw new ArithmeticException();
            }
            if ((obj instanceof Map.Entry ? '[' : '1') != '[' || setX.this.valueOf((Map.Entry) obj) == null) {
                return false;
            }
            int i2 = values + 35;
            AGState = i2 % 128;
            return (i2 % 2 == 0 ? '*' : 'W') != '*';
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            AGState = (values + 1) % 128;
            if ((!(obj instanceof Map.Entry) ? (char) 24 : ')') != 24) {
                AGState<K, V> valueOf = setX.this.valueOf((Map.Entry) obj);
                if ((valueOf == null ? '@' : ':') == ':') {
                    setX.this.APIGuard(valueOf, true);
                    return true;
                }
                AGState = (values + 19) % 128;
                return false;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            values = (AGState + 55) % 128;
            setX.this.clear();
            values = (AGState + 9) % 128;
        }
    }

    /* loaded from: classes7.dex */
    final class valueOf extends AbstractSet<K> {
        private static int AGState = 1;
        private static int getSharedInstance;

        valueOf() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            int i = AGState + 107;
            getSharedInstance = i % 128;
            if (!(i % 2 != 0)) {
                return setX.this.size;
            }
            int i2 = setX.this.size;
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final java.util.Iterator<K> iterator() {
            values valuesVar = new values(this) { // from class: com.apiguard3.internal.setX.valueOf.3
                private static int APIGuard = 1;
                private static int getSharedInstance;

                {
                    setX setx = setX.this;
                }

                @Override // java.util.Iterator
                public final K next() {
                    APIGuard = (getSharedInstance + 57) % 128;
                    K k = APIGuard().getRequestHeaders;
                    APIGuard = (getSharedInstance + 93) % 128;
                    return k;
                }
            };
            int i = AGState + 109;
            getSharedInstance = i % 128;
            if ((i % 2 != 0 ? '4' : 'E') != '4') {
                return valuesVar;
            }
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            int i = AGState + 43;
            getSharedInstance = i % 128;
            if (!(i % 2 == 0)) {
                setX.this.containsKey(obj);
                throw new NullPointerException();
            }
            boolean containsKey = setX.this.containsKey(obj);
            AGState = (getSharedInstance + 103) % 128;
            return containsKey;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (!(setX.this.AGState(obj) == null)) {
                AGState = (getSharedInstance + 71) % 128;
                return true;
            }
            int i = getSharedInstance + 47;
            AGState = i % 128;
            if (i % 2 != 0) {
                return false;
            }
            throw new NullPointerException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            int i = AGState + 105;
            getSharedInstance = i % 128;
            if (!(i % 2 == 0)) {
                setX.this.clear();
                throw new ArithmeticException();
            }
            setX.this.clear();
            getSharedInstance = (AGState + 119) % 128;
        }
    }

    private Object writeReplace() throws ObjectStreamException {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this);
        int i = AGState + 47;
        valueOf = i % 128;
        if (i % 2 != 0) {
            return linkedHashMap;
        }
        throw new ArithmeticException();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }
}
