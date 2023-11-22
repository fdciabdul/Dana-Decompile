package com.apiguard3.internal;

import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setScrollbarFadingEnabled<T> {
    private static int getSharedInstance = 1;
    private static int values;
    private int AGState;
    private Class<? super T> APIGuard;
    private Type valueOf;

    protected setScrollbarFadingEnabled() {
        Type APIGuard = APIGuard(getClass());
        this.valueOf = APIGuard;
        this.APIGuard = (Class<? super T>) setForceDarkAllowed.AGState(APIGuard);
        this.AGState = this.valueOf.hashCode();
    }

    private setScrollbarFadingEnabled(Type type) {
        Type sharedInstance = setForceDarkAllowed.getSharedInstance((Type) setBottom.getSharedInstance(type));
        this.valueOf = sharedInstance;
        this.APIGuard = (Class<? super T>) setForceDarkAllowed.AGState(sharedInstance);
        this.AGState = this.valueOf.hashCode();
    }

    private static Type APIGuard(Class<?> cls) {
        values = (getSharedInstance + 121) % 128;
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        Type sharedInstance = setForceDarkAllowed.getSharedInstance(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        int i = values + 91;
        getSharedInstance = i % 128;
        if (i % 2 != 0) {
            return sharedInstance;
        }
        throw new NullPointerException();
    }

    public final Class<? super T> AGState() {
        int i = getSharedInstance + 73;
        values = i % 128;
        if ((i % 2 != 0 ? (char) 18 : '\'') == '\'') {
            return this.APIGuard;
        }
        throw new ArithmeticException();
    }

    public final Type getSharedInstance() {
        int i = getSharedInstance + 63;
        int i2 = i % 128;
        values = i2;
        if ((i % 2 != 0 ? 'K' : 'P') != 'P') {
            throw new NullPointerException();
        }
        Type type = this.valueOf;
        int i3 = i2 + 27;
        getSharedInstance = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 21 : Typography.greater) != 21) {
            return type;
        }
        throw null;
    }

    public final int hashCode() {
        int i = values + 83;
        int i2 = i % 128;
        getSharedInstance = i2;
        if ((i % 2 == 0 ? ',' : (char) 25) != 25) {
            throw new ArithmeticException();
        }
        int i3 = this.AGState;
        int i4 = i2 + 21;
        values = i4 % 128;
        if (i4 % 2 == 0) {
            return i3;
        }
        throw new ArithmeticException();
    }

    public final boolean equals(Object obj) {
        int i = (values + 99) % 128;
        getSharedInstance = i;
        if (obj instanceof setScrollbarFadingEnabled) {
            values = (i + 123) % 128;
            if ((setForceDarkAllowed.AGState(this.valueOf, ((setScrollbarFadingEnabled) obj).valueOf) ? JSONLexer.EOI : 'H') == 26) {
                return true;
            }
        }
        int i2 = getSharedInstance + 25;
        values = i2 % 128;
        if (i2 % 2 == 0) {
            return false;
        }
        throw null;
    }

    public final String toString() {
        int i = getSharedInstance + 83;
        values = i % 128;
        if ((i % 2 != 0 ? (char) 11 : Typography.amp) == '&') {
            return setForceDarkAllowed.values(this.valueOf);
        }
        setForceDarkAllowed.values(this.valueOf);
        throw null;
    }

    public static setScrollbarFadingEnabled<?> getSharedInstance(Type type) {
        setScrollbarFadingEnabled<?> setscrollbarfadingenabled = new setScrollbarFadingEnabled<>(type);
        int i = values + 89;
        getSharedInstance = i % 128;
        if (i % 2 != 0) {
            return setscrollbarfadingenabled;
        }
        throw new ArithmeticException();
    }

    public static <T> setScrollbarFadingEnabled<T> valueOf(Class<T> cls) {
        setScrollbarFadingEnabled<T> setscrollbarfadingenabled = new setScrollbarFadingEnabled<>(cls);
        int i = getSharedInstance + 49;
        values = i % 128;
        if (i % 2 == 0) {
            return setscrollbarfadingenabled;
        }
        throw new NullPointerException();
    }
}
