package com.apiguard3.internal;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class setTransitionAlpha implements setPivotX, Cloneable {
    public static final setTransitionAlpha values = new setTransitionAlpha();
    private static int parseResponseHeaders;
    private static int analyzeResponse = (parseResponseHeaders + 3) % 128;
    private double getSharedInstance = -1.0d;
    private int AGState = 136;
    private boolean valueOf = true;
    private List<setSaveEnabled> APIGuard = Collections.emptyList();
    private List<setSaveEnabled> generateHeaders = Collections.emptyList();

    protected final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = analyzeResponse + 105;
        parseResponseHeaders = i % 128;
        if (i % 2 != 0) {
            values();
            throw null;
        }
        setTransitionAlpha values2 = values();
        int i2 = analyzeResponse + 35;
        parseResponseHeaders = i2 % 128;
        if ((i2 % 2 != 0 ? 'V' : (char) 23) != 'V') {
            return values2;
        }
        throw new NullPointerException();
    }

    private setTransitionAlpha values() {
        parseResponseHeaders = (analyzeResponse + 59) % 128;
        try {
            setTransitionAlpha settransitionalpha = (setTransitionAlpha) super.clone();
            analyzeResponse = (parseResponseHeaders + 13) % 128;
            return settransitionalpha;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    @Override // com.apiguard3.internal.setPivotX
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> com.apiguard3.internal.setScaleX<T> valueOf(final com.apiguard3.internal.setScreenReaderFocusable r6, final com.apiguard3.internal.setScrollbarFadingEnabled<T> r7) {
        /*
            r5 = this;
            int r0 = com.apiguard3.internal.setTransitionAlpha.parseResponseHeaders
            int r0 = r0 + 119
            int r1 = r0 % 128
            com.apiguard3.internal.setTransitionAlpha.analyzeResponse = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L51
            java.lang.Class r0 = r7.AGState()
            boolean r0 = r5.AGState(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L29
            boolean r3 = r5.getSharedInstance(r2)
            r4 = 30
            if (r3 == 0) goto L23
            r3 = 70
            goto L25
        L23:
            r3 = 30
        L25:
            if (r3 != r4) goto L29
            r3 = 0
            goto L2a
        L29:
            r3 = 1
        L2a:
            if (r0 != 0) goto L3b
            boolean r0 = r5.getSharedInstance(r1)
            if (r0 != 0) goto L3b
            int r0 = com.apiguard3.internal.setTransitionAlpha.analyzeResponse
            int r0 = r0 + 107
            int r0 = r0 % 128
            com.apiguard3.internal.setTransitionAlpha.parseResponseHeaders = r0
            goto L3c
        L3b:
            r1 = 1
        L3c:
            r0 = 95
            if (r3 != 0) goto L43
            r2 = 95
            goto L45
        L43:
            r2 = 73
        L45:
            if (r2 != r0) goto L4b
            if (r1 != 0) goto L4b
            r6 = 0
            return r6
        L4b:
            com.apiguard3.internal.setTransitionAlpha$4 r0 = new com.apiguard3.internal.setTransitionAlpha$4
            r0.<init>()
            return r0
        L51:
            java.lang.Class r6 = r7.AGState()
            r5.AGState(r6)
            java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L5e
            r6.<init>()     // Catch: java.lang.Throwable -> L5e
            throw r6     // Catch: java.lang.Throwable -> L5e
        L5e:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setTransitionAlpha.valueOf(com.apiguard3.internal.setScreenReaderFocusable, com.apiguard3.internal.setScrollbarFadingEnabled):com.apiguard3.internal.setScaleX");
    }

    public final boolean AGState(Field field, boolean z) {
        List<setSaveEnabled> list;
        int i = analyzeResponse + 95;
        parseResponseHeaders = i % 128;
        if (i % 2 == 0 ? (this.AGState & field.getModifiers()) != 0 : (this.AGState & field.getModifiers()) != 0) {
            int i2 = analyzeResponse + 93;
            parseResponseHeaders = i2 % 128;
            if ((i2 % 2 != 0 ? (char) 3 : (char) 4) != 3) {
                return true;
            }
            throw new ArithmeticException();
        }
        if ((this.getSharedInstance != -1.0d ? 'J' : (char) 29) == 'J') {
            int i3 = parseResponseHeaders + 9;
            analyzeResponse = i3 % 128;
            if ((i3 % 2 == 0 ? ')' : (char) 7) != 7) {
                APIGuard((setRotationY) field.getAnnotation(setRotationY.class), (setTop) field.getAnnotation(setTop.class));
                throw new ArithmeticException();
            } else if (!APIGuard((setRotationY) field.getAnnotation(setRotationY.class), (setTop) field.getAnnotation(setTop.class))) {
                return true;
            }
        }
        if ((!field.isSynthetic()) != true) {
            analyzeResponse = (parseResponseHeaders + 121) % 128;
            return true;
        }
        if ((!this.valueOf ? (char) 18 : (char) 14) == 18) {
            int i4 = analyzeResponse + 3;
            parseResponseHeaders = i4 % 128;
            if (i4 % 2 != 0) {
                getSharedInstance(field.getType());
                throw new NullPointerException();
            } else if (getSharedInstance(field.getType())) {
                return true;
            }
        }
        if (values(field.getType())) {
            return true;
        }
        if (z) {
            list = this.APIGuard;
        } else {
            list = this.generateHeaders;
            analyzeResponse = (parseResponseHeaders + 77) % 128;
        }
        if (list.isEmpty()) {
            return false;
        }
        new setBottom(field);
        Iterator<setSaveEnabled> it = list.iterator();
        while (it.hasNext()) {
            int i5 = analyzeResponse + 123;
            parseResponseHeaders = i5 % 128;
            if ((i5 % 2 != 0 ? 'X' : ':') != ':') {
                it.next().AGState();
                throw new ArithmeticException();
            }
            if ((it.next().AGState() ? (char) 17 : '@') != '@') {
                return true;
            }
        }
        return false;
    }

    private boolean AGState(Class<?> cls) {
        if ((this.getSharedInstance != -1.0d ? 'U' : 'c') == 'U') {
            parseResponseHeaders = (analyzeResponse + 95) % 128;
            if ((!APIGuard((setRotationY) cls.getAnnotation(setRotationY.class), (setTop) cls.getAnnotation(setTop.class)) ? (char) 14 : (char) 19) != 19) {
                parseResponseHeaders = (analyzeResponse + 15) % 128;
                return true;
            }
        }
        if ((!this.valueOf ? ';' : (char) 7) != 7) {
            analyzeResponse = (parseResponseHeaders + 59) % 128;
            if (getSharedInstance(cls)) {
                int i = parseResponseHeaders + 87;
                analyzeResponse = i % 128;
                return i % 2 != 0;
            }
        }
        if (values(cls)) {
            int i2 = analyzeResponse + 11;
            parseResponseHeaders = i2 % 128;
            if (i2 % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean values(Class<?> cls, boolean z) {
        int i = parseResponseHeaders + 103;
        analyzeResponse = i % 128;
        if (i % 2 != 0) {
            if ((!AGState(cls) ? '\f' : '5') == '\f') {
                int i2 = analyzeResponse + 1;
                parseResponseHeaders = i2 % 128;
                if (i2 % 2 != 0) {
                    getSharedInstance(z);
                    throw new NullPointerException();
                } else if (!getSharedInstance(z)) {
                    return false;
                }
            }
            analyzeResponse = (parseResponseHeaders + 59) % 128;
            return true;
        }
        AGState(cls);
        throw null;
    }

    private boolean getSharedInstance(boolean z) {
        List<setSaveEnabled> list;
        if ((!z) != false) {
            list = this.generateHeaders;
        } else {
            int i = analyzeResponse + 87;
            parseResponseHeaders = i % 128;
            if (i % 2 != 0) {
                throw null;
            }
            list = this.APIGuard;
        }
        Iterator<setSaveEnabled> it = list.iterator();
        do {
            if ((it.hasNext() ? 'I' : 'O') != 'I') {
                return false;
            }
            analyzeResponse = (parseResponseHeaders + 7) % 128;
        } while (!it.next().values());
        parseResponseHeaders = (analyzeResponse + 117) % 128;
        return true;
    }

    private static boolean values(Class<?> cls) {
        parseResponseHeaders = (analyzeResponse + 67) % 128;
        if (Enum.class.isAssignableFrom(cls) || valueOf(cls)) {
            return false;
        }
        if ((!cls.isAnonymousClass() ? '/' : 'U') != 'U') {
            int i = analyzeResponse + 121;
            parseResponseHeaders = i % 128;
            if (i % 2 != 0) {
                throw null;
            } else if (!cls.isLocalClass()) {
                return false;
            }
        }
        return true;
    }

    private static boolean getSharedInstance(Class<?> cls) {
        if (cls.isMemberClass()) {
            if ((!valueOf(cls) ? (char) 7 : (char) 21) != 7) {
                return false;
            }
            int i = analyzeResponse;
            parseResponseHeaders = (i + 57) % 128;
            parseResponseHeaders = (i + 59) % 128;
            return true;
        }
        return false;
    }

    private static boolean valueOf(Class<?> cls) {
        if (!((cls.getModifiers() & 8) != 0)) {
            return false;
        }
        int i = (analyzeResponse + 103) % 128;
        parseResponseHeaders = i;
        int i2 = i + 43;
        analyzeResponse = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 30 : 'T') != 30) {
            return true;
        }
        throw null;
    }

    private boolean APIGuard(setRotationY setrotationy, setTop settop) {
        if ((!valueOf(setrotationy)) == false) {
            int i = analyzeResponse + 119;
            parseResponseHeaders = i % 128;
            if (i % 2 != 0) {
                values(settop);
                throw new ArithmeticException();
            } else if (values(settop)) {
                return true;
            }
        }
        parseResponseHeaders = (analyzeResponse + 17) % 128;
        return false;
    }

    private boolean valueOf(setRotationY setrotationy) {
        if (setrotationy != null) {
            int i = parseResponseHeaders + 39;
            analyzeResponse = i % 128;
            if ((i % 2 == 0 ? (char) 27 : ')') != ')') {
                setrotationy.APIGuard();
                throw new ArithmeticException();
            }
            if (!(setrotationy.APIGuard() <= this.getSharedInstance)) {
                int i2 = parseResponseHeaders + 99;
                analyzeResponse = i2 % 128;
                if ((i2 % 2 == 0 ? 'D' : '0') != 'D') {
                    return false;
                }
                throw new NullPointerException();
            }
        }
        return true;
    }

    private boolean values(setTop settop) {
        int i = parseResponseHeaders + 29;
        analyzeResponse = i % 128;
        if (i % 2 == 0) {
            throw new ArithmeticException();
        }
        if (settop != null) {
            if (settop.AGState() <= this.getSharedInstance) {
                int i2 = parseResponseHeaders + 85;
                analyzeResponse = i2 % 128;
                return (i2 % 2 == 0 ? '%' : '5') != '5';
            }
        }
        parseResponseHeaders = (analyzeResponse + 47) % 128;
        return true;
    }
}
