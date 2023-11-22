package com.apiguard3.internal;

import com.alibaba.fastjson.parser.JSONLexer;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public abstract class setRight {
    private static int APIGuard = 1;
    private static int getSharedInstance;

    public abstract <T> T AGState(Class<T> cls) throws Exception;

    public static setRight values() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = cls.getMethod("allocateInstance", Class.class);
            setRight setright = new setRight() { // from class: com.apiguard3.internal.setRight.2
                private static int AGState = 0;
                private static int getSharedInstance = 1;

                @Override // com.apiguard3.internal.setRight
                public final <T> T AGState(Class<T> cls2) throws Exception {
                    int i = AGState + 103;
                    getSharedInstance = i % 128;
                    int i2 = i % 2;
                    APIGuard(cls2);
                    return (T) method.invoke(obj, cls2);
                }
            };
            APIGuard = (getSharedInstance + 91) % 128;
            return setright;
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    final int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new setRight() { // from class: com.apiguard3.internal.setRight.5
                        private static int APIGuard = 0;
                        private static int valueOf = 1;

                        @Override // com.apiguard3.internal.setRight
                        public final <T> T AGState(Class<T> cls2) throws Exception {
                            T t;
                            int i = valueOf + 115;
                            APIGuard = i % 128;
                            if ((i % 2 != 0 ? JSONLexer.EOI : Typography.quote) != '\"') {
                                APIGuard(cls2);
                                Method method2 = declaredMethod2;
                                Object[] objArr = new Object[2];
                                objArr[1] = cls2;
                                objArr[1] = Integer.valueOf(intValue);
                                t = (T) method2.invoke(null, objArr);
                            } else {
                                APIGuard(cls2);
                                t = (T) declaredMethod2.invoke(null, cls2, Integer.valueOf(intValue));
                            }
                            int i2 = APIGuard + 17;
                            valueOf = i2 % 128;
                            if (i2 % 2 != 0) {
                                return t;
                            }
                            throw new ArithmeticException();
                        }
                    };
                } catch (Exception unused2) {
                    return new setRight() { // from class: com.apiguard3.internal.setRight.3
                        @Override // com.apiguard3.internal.setRight
                        public final <T> T AGState(Class<T> cls2) {
                            throw new UnsupportedOperationException("Cannot allocate ".concat(String.valueOf(cls2)));
                        }
                    };
                }
            } catch (Exception unused3) {
                final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new setRight() { // from class: com.apiguard3.internal.setRight.4
                    private static int AGState = 1;
                    private static int valueOf;

                    @Override // com.apiguard3.internal.setRight
                    public final <T> T AGState(Class<T> cls2) throws Exception {
                        valueOf = (AGState + 91) % 128;
                        APIGuard(cls2);
                        T t = (T) declaredMethod3.invoke(null, cls2, Object.class);
                        int i = AGState + 105;
                        valueOf = i % 128;
                        if (i % 2 == 0) {
                            return t;
                        }
                        throw new ArithmeticException();
                    }
                };
            }
        }
    }

    static void APIGuard(Class<?> cls) {
        APIGuard = (getSharedInstance + 89) % 128;
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder sb = new StringBuilder("Interface can't be instantiated! Interface name: ");
            sb.append(cls.getName());
            throw new UnsupportedOperationException(sb.toString());
        } else if (Modifier.isAbstract(modifiers)) {
            StringBuilder sb2 = new StringBuilder("Abstract class can't be instantiated! Class name: ");
            sb2.append(cls.getName());
            throw new UnsupportedOperationException(sb2.toString());
        } else {
            int i = APIGuard + 113;
            getSharedInstance = i % 128;
            if (i % 2 != 0) {
                throw null;
            }
        }
    }
}
