package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a9\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004j\u0002`\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a1\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0082\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012\"\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019*(\b\u0002\u0010\u001a\"\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00042\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0004"}, d2 = {"", "E", "Ljava/lang/Class;", "clz", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "createConstructor", "(Ljava/lang/Class;)Lkotlin/jvm/functions/Function1;", "Ljava/lang/reflect/Constructor;", "constructor", "createSafeConstructor", "(Ljava/lang/reflect/Constructor;)Lkotlin/jvm/functions/Function1;", "exception", "tryCopyException", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "", "accumulator", "fieldsCount", "(Ljava/lang/Class;I)I", "defaultValue", "fieldsCountOrDefault", "Lkotlinx/coroutines/internal/CtorCache;", "ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "I", "Ctor"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    public static final /* synthetic */ Function1 access$createConstructor(Class cls) {
        return createConstructor(cls);
    }

    static {
        WeakMapCtorCache weakMapCtorCache;
        try {
            weakMapCtorCache = FastServiceLoaderKt.getANDROID_DETECTED() ? WeakMapCtorCache.INSTANCE : ClassValueCtorCache.INSTANCE;
        } catch (Throwable unused) {
            weakMapCtorCache = WeakMapCtorCache.INSTANCE;
        }
        ctorCache = weakMapCtorCache;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E tryCopyException(E e) {
        Object m3179constructorimpl;
        if (e instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m3179constructorimpl = Result.m3179constructorimpl(((CopyableThrowable) e).createCopy());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m3185isFailureimpl(m3179constructorimpl)) {
                m3179constructorimpl = null;
            }
            return (E) m3179constructorimpl;
        }
        return (E) ctorCache.get(e.getClass()).invoke(e);
    }

    public static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> cls) {
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Throwable th) {
                return null;
            }
        };
        if (throwableFields != fieldsCountOrDefault(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        Iterator it = ArraysKt.sortedWith(cls.getConstructors(), new Comparator() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
            }
        }).iterator();
        while (it.hasNext()) {
            Function1<Throwable, Throwable> createSafeConstructor = createSafeConstructor((Constructor) it.next());
            if (createSafeConstructor != null) {
                return createSafeConstructor;
            }
        }
        return exceptionsConstructorKt$createConstructor$nullResult$1;
    }

    private static final Function1<Throwable, Throwable> createSafeConstructor(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                    return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Throwable invoke(Throwable th) {
                            Object m3179constructorimpl;
                            Object newInstance;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                newInstance = constructor.newInstance(th.getMessage(), th);
                            } catch (Throwable th2) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th2));
                            }
                            if (newInstance != null) {
                                m3179constructorimpl = Result.m3179constructorimpl((Throwable) newInstance);
                                if (Result.m3185isFailureimpl(m3179constructorimpl)) {
                                    m3179constructorimpl = null;
                                }
                                return (Throwable) m3179constructorimpl;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                    };
                }
                return null;
            }
            Class<?> cls = parameterTypes[0];
            if (!Intrinsics.areEqual(cls, Throwable.class)) {
                if (Intrinsics.areEqual(cls, String.class)) {
                    return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Throwable invoke(Throwable th) {
                            Object m3179constructorimpl;
                            Object newInstance;
                            try {
                                Result.Companion companion = Result.INSTANCE;
                                newInstance = constructor.newInstance(th.getMessage());
                            } catch (Throwable th2) {
                                Result.Companion companion2 = Result.INSTANCE;
                                m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th2));
                            }
                            if (newInstance != null) {
                                Throwable th3 = (Throwable) newInstance;
                                th3.initCause(th);
                                m3179constructorimpl = Result.m3179constructorimpl(th3);
                                if (Result.m3185isFailureimpl(m3179constructorimpl)) {
                                    m3179constructorimpl = null;
                                }
                                return (Throwable) m3179constructorimpl;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                    };
                }
                return null;
            }
            return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Throwable invoke(Throwable th) {
                    Object m3179constructorimpl;
                    Object newInstance;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        newInstance = constructor.newInstance(th);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (newInstance != null) {
                        m3179constructorimpl = Result.m3179constructorimpl((Throwable) newInstance);
                        if (Result.m3185isFailureimpl(m3179constructorimpl)) {
                            m3179constructorimpl = null;
                        }
                        return (Throwable) m3179constructorimpl;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
            };
        }
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(Throwable th) {
                Object m3179constructorimpl;
                Object newInstance;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    newInstance = constructor.newInstance(new Object[0]);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th2));
                }
                if (newInstance != null) {
                    Throwable th3 = (Throwable) newInstance;
                    th3.initCause(th);
                    m3179constructorimpl = Result.m3179constructorimpl(th3);
                    if (Result.m3185isFailureimpl(m3179constructorimpl)) {
                        m3179constructorimpl = null;
                    }
                    return (Throwable) m3179constructorimpl;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
        };
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Object m3179constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3185isFailureimpl(m3179constructorimpl)) {
            m3179constructorimpl = Integer.valueOf(i);
        }
        return ((Number) m3179constructorimpl).intValue();
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        do {
            int length = cls.getDeclaredFields().length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if ((!Modifier.isStatic(r0[i3].getModifiers())) != false) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }
}
