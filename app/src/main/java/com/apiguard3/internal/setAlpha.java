package com.apiguard3.internal;

import com.alibaba.fastjson.parser.JSONLexer;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setAlpha {
    private static int valueOf = 1;
    private static int values;
    private final Map<Type, setKeyboardNavigationCluster<?>> AGState;
    private final setVerticalFadingEdgeEnabled getSharedInstance = setVerticalFadingEdgeEnabled.values();

    public setAlpha(Map<Type, setKeyboardNavigationCluster<?>> map) {
        this.AGState = map;
    }

    public final <T> setLeft<T> APIGuard(setScrollbarFadingEnabled<T> setscrollbarfadingenabled) {
        int i = valueOf + 101;
        values = i % 128;
        if (!(i % 2 != 0)) {
            Type sharedInstance = setscrollbarfadingenabled.getSharedInstance();
            Class<? super T> AGState = setscrollbarfadingenabled.AGState();
            setKeyboardNavigationCluster<?> setkeyboardnavigationcluster = this.AGState.get(sharedInstance);
            if (setkeyboardnavigationcluster != null) {
                return new setLeft<T>(sharedInstance) { // from class: com.apiguard3.internal.setAlpha.3
                    private static int getSharedInstance = 1;
                    private static int valueOf;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        valueOf = (getSharedInstance + 45) % 128;
                        T t = (T) setKeyboardNavigationCluster.this.APIGuard();
                        int i2 = valueOf + 77;
                        getSharedInstance = i2 % 128;
                        if ((i2 % 2 == 0 ? '\t' : '\\') == '\\') {
                            return t;
                        }
                        throw null;
                    }
                };
            }
            setKeyboardNavigationCluster<?> setkeyboardnavigationcluster2 = this.AGState.get(AGState);
            if (setkeyboardnavigationcluster2 != null) {
                return new setLeft<T>(sharedInstance) { // from class: com.apiguard3.internal.setAlpha.10
                    private static int AGState = 0;
                    private static int APIGuard = 1;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        AGState = (APIGuard + 31) % 128;
                        T t = (T) setKeyboardNavigationCluster.this.APIGuard();
                        int i2 = AGState + 19;
                        APIGuard = i2 % 128;
                        if (i2 % 2 != 0) {
                            return t;
                        }
                        throw new ArithmeticException();
                    }
                };
            }
            setLeft<T> values2 = values(AGState);
            if (values2 != null) {
                valueOf = (values + 41) % 128;
                return values2;
            }
            setLeft<T> valueOf2 = valueOf(sharedInstance, AGState);
            return valueOf2 != null ? valueOf2 : getSharedInstance(sharedInstance, AGState);
        }
        Type sharedInstance2 = setscrollbarfadingenabled.getSharedInstance();
        setscrollbarfadingenabled.AGState();
        this.AGState.get(sharedInstance2);
        throw new NullPointerException();
    }

    private <T> setLeft<T> values(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if ((!declaredConstructor.isAccessible() ? '%' : (char) 3) != 3) {
                this.getSharedInstance.valueOf(declaredConstructor);
                valueOf = (values + 49) % 128;
            }
            setLeft<T> setleft = new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.7
                private static int APIGuard = 0;
                private static int getSharedInstance = 1;

                @Override // com.apiguard3.internal.setLeft
                public final T values() {
                    APIGuard = (getSharedInstance + 77) % 128;
                    try {
                        T t = (T) declaredConstructor.newInstance(null);
                        APIGuard = (getSharedInstance + 47) % 128;
                        return t;
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        StringBuilder sb = new StringBuilder("Failed to invoke ");
                        sb.append(declaredConstructor);
                        sb.append(" with no args");
                        throw new RuntimeException(sb.toString(), e2);
                    } catch (InvocationTargetException e3) {
                        StringBuilder sb2 = new StringBuilder("Failed to invoke ");
                        sb2.append(declaredConstructor);
                        sb2.append(" with no args");
                        throw new RuntimeException(sb2.toString(), e3.getTargetException());
                    }
                }
            };
            int i = values + 13;
            valueOf = i % 128;
            if (!(i % 2 == 0)) {
                return setleft;
            }
            throw new ArithmeticException();
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> setLeft<T> valueOf(final Type type, Class<? super T> cls) {
        if ((Collection.class.isAssignableFrom(cls) ? Typography.amp : '0') == '&') {
            int i = values + 13;
            valueOf = i % 128;
            if (i % 2 != 0) {
                return SortedSet.class.isAssignableFrom(cls) ? new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.9
                    private static int getSharedInstance = 1;
                    private static int values;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        T t = (T) new TreeSet();
                        int i2 = values + 87;
                        getSharedInstance = i2 % 128;
                        if (i2 % 2 != 0) {
                            return t;
                        }
                        throw new NullPointerException();
                    }
                } : EnumSet.class.isAssignableFrom(cls) ? new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.8
                    private static int AGState = 0;
                    private static int valueOf = 1;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        int i2 = valueOf;
                        int i3 = i2 + 93;
                        AGState = i3 % 128;
                        if ((i3 % 2 != 0 ? '!' : '(') == '!') {
                            throw new ArithmeticException();
                        }
                        if ((type instanceof ParameterizedType ? 'T' : '1') != 'T') {
                            StringBuilder sb = new StringBuilder("Invalid EnumSet type: ");
                            sb.append(type.toString());
                            throw new setDefaultFocusHighlightEnabled(sb.toString());
                        }
                        AGState = (i2 + 91) % 128;
                        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (type2 instanceof Class) {
                            return (T) EnumSet.noneOf((Class) type2);
                        }
                        StringBuilder sb2 = new StringBuilder("Invalid EnumSet type: ");
                        sb2.append(type.toString());
                        throw new setDefaultFocusHighlightEnabled(sb2.toString());
                    }
                } : Set.class.isAssignableFrom(cls) ? new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.12
                    private static int valueOf = 1;
                    private static int values;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        T t = (T) new LinkedHashSet();
                        values = (valueOf + 15) % 128;
                        return t;
                    }
                } : Queue.class.isAssignableFrom(cls) ? new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.15
                    private static int getSharedInstance = 0;
                    private static int valueOf = 1;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        T t = (T) new ArrayDeque();
                        valueOf = (getSharedInstance + 9) % 128;
                        return t;
                    }
                } : new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.13
                    private static int AGState = 1;
                    private static int APIGuard;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        T t = (T) new ArrayList();
                        int i2 = APIGuard + 107;
                        AGState = i2 % 128;
                        if ((i2 % 2 == 0 ? ':' : (char) 1) == 1) {
                            return t;
                        }
                        throw null;
                    }
                };
            }
            throw new ArithmeticException();
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.14
                    private static int AGState = 1;
                    private static int valueOf;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        T t = (T) new ConcurrentSkipListMap();
                        AGState = (valueOf + 9) % 128;
                        return t;
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                setLeft<T> setleft = new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.5
                    private static int AGState = 0;
                    private static int APIGuard = 1;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        T t = (T) new ConcurrentHashMap();
                        AGState = (APIGuard + 23) % 128;
                        return t;
                    }
                };
                int i2 = values + 119;
                valueOf = i2 % 128;
                if ((i2 % 2 == 0 ? JSONLexer.EOI : (char) 23) != 26) {
                    return setleft;
                }
                throw new NullPointerException();
            } else if (SortedMap.class.isAssignableFrom(cls)) {
                return new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.4
                    private static int AGState = 0;
                    private static int values = 1;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        T t = (T) new TreeMap();
                        AGState = (values + 101) % 128;
                        return t;
                    }
                };
            } else {
                if ((type instanceof ParameterizedType ? '2' : (char) 20) != 20) {
                    values = (valueOf + 37) % 128;
                    if (!String.class.isAssignableFrom(setScrollbarFadingEnabled.getSharedInstance(((ParameterizedType) type).getActualTypeArguments()[0]).AGState())) {
                        return new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.1
                            private static int AGState = 0;
                            private static int valueOf = 1;

                            @Override // com.apiguard3.internal.setLeft
                            public final T values() {
                                T t = (T) new LinkedHashMap();
                                AGState = (valueOf + 101) % 128;
                                return t;
                            }
                        };
                    }
                }
                return new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.2
                    private static int getSharedInstance = 1;
                    private static int values;

                    @Override // com.apiguard3.internal.setLeft
                    public final T values() {
                        T t = (T) new setX();
                        getSharedInstance = (values + 1) % 128;
                        return t;
                    }
                };
            }
        } else {
            return null;
        }
    }

    private <T> setLeft<T> getSharedInstance(final Type type, final Class<? super T> cls) {
        setLeft<T> setleft = new setLeft<T>() { // from class: com.apiguard3.internal.setAlpha.6
            private static int AGState = 0;
            private static int valueOf = 1;
            private final setRight getSharedInstance = setRight.values();

            @Override // com.apiguard3.internal.setLeft
            public final T values() {
                valueOf = (AGState + 43) % 128;
                try {
                    T t = (T) this.getSharedInstance.AGState(cls);
                    int i = valueOf + 5;
                    AGState = i % 128;
                    if ((i % 2 != 0 ? 'S' : Typography.dollar) == '$') {
                        return t;
                    }
                    throw new ArithmeticException();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder("Unable to invoke no-args constructor for ");
                    sb.append(type);
                    sb.append(". Registering an InstanceCreator with Gson for this type may fix this problem.");
                    throw new RuntimeException(sb.toString(), e);
                }
            }
        };
        values = (valueOf + 89) % 128;
        return setleft;
    }

    public final String toString() {
        int i = valueOf + 51;
        values = i % 128;
        if (i % 2 == 0) {
            return this.AGState.toString();
        }
        throw null;
    }
}
