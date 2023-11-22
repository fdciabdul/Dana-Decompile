package androidx.versionedparcelable;

import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public abstract class VersionedParcel {
    protected final ArrayMap<String, Method> BuiltInFictitiousFunctionClassFactory;
    protected final ArrayMap<String, Class> MyBillsEntityDataFactory;
    protected final ArrayMap<String, Method> getAuthRequestContext;

    protected abstract void BuiltInFictitiousFunctionClassFactory(int i);

    protected abstract void BuiltInFictitiousFunctionClassFactory(Parcelable parcelable);

    protected abstract void BuiltInFictitiousFunctionClassFactory(String str);

    public void BuiltInFictitiousFunctionClassFactory(boolean z, boolean z2) {
    }

    protected abstract boolean BuiltInFictitiousFunctionClassFactory();

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2();

    protected abstract void MyBillsEntityDataFactory(int i);

    protected abstract void MyBillsEntityDataFactory(boolean z);

    public boolean MyBillsEntityDataFactory() {
        return false;
    }

    protected abstract CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0();

    protected abstract void PlaceComponentResult(CharSequence charSequence);

    protected abstract void PlaceComponentResult(byte[] bArr);

    protected abstract byte[] PlaceComponentResult();

    protected abstract VersionedParcel getAuthRequestContext();

    protected abstract boolean getAuthRequestContext(int i);

    protected abstract <T extends Parcelable> T getErrorConfigVersion();

    protected abstract String moveToNextValue();

    protected abstract int scheduleImpl();

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.BuiltInFictitiousFunctionClassFactory = arrayMap;
        this.getAuthRequestContext = arrayMap2;
        this.MyBillsEntityDataFactory = arrayMap3;
    }

    public final void getAuthRequestContext(boolean z, int i) {
        MyBillsEntityDataFactory(i);
        MyBillsEntityDataFactory(z);
    }

    public final void getAuthRequestContext(byte[] bArr) {
        MyBillsEntityDataFactory(2);
        PlaceComponentResult(bArr);
    }

    public final void PlaceComponentResult(CharSequence charSequence, int i) {
        MyBillsEntityDataFactory(i);
        PlaceComponentResult(charSequence);
    }

    public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        MyBillsEntityDataFactory(i2);
        BuiltInFictitiousFunctionClassFactory(i);
    }

    public final void PlaceComponentResult(String str, int i) {
        MyBillsEntityDataFactory(i);
        BuiltInFictitiousFunctionClassFactory(str);
    }

    public final void PlaceComponentResult(Parcelable parcelable, int i) {
        MyBillsEntityDataFactory(i);
        BuiltInFictitiousFunctionClassFactory(parcelable);
    }

    public final boolean PlaceComponentResult(boolean z, int i) {
        return !getAuthRequestContext(i) ? z : BuiltInFictitiousFunctionClassFactory();
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        return !getAuthRequestContext(i2) ? i : scheduleImpl();
    }

    public final String getAuthRequestContext(String str, int i) {
        return !getAuthRequestContext(i) ? str : moveToNextValue();
    }

    public final byte[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        return !getAuthRequestContext(2) ? bArr : PlaceComponentResult();
    }

    public final <T extends Parcelable> T getAuthRequestContext(T t, int i) {
        return !getAuthRequestContext(i) ? t : (T) getErrorConfigVersion();
    }

    public final CharSequence BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, int i) {
        return !getAuthRequestContext(i) ? charSequence : NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public final void MyBillsEntityDataFactory(VersionedParcelable versionedParcelable) {
        MyBillsEntityDataFactory(1);
        PlaceComponentResult(versionedParcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final void PlaceComponentResult(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            BuiltInFictitiousFunctionClassFactory((String) null);
            return;
        }
        try {
            BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory((Class<? extends VersionedParcelable>) versionedParcelable.getClass()).getName());
            VersionedParcel authRequestContext = getAuthRequestContext();
            try {
                Class<?> cls = versionedParcelable.getClass();
                Method method = this.getAuthRequestContext.get(cls.getName());
                if (method == null) {
                    method = BuiltInFictitiousFunctionClassFactory((Class<? extends VersionedParcelable>) cls).getDeclaredMethod("write", cls, VersionedParcel.class);
                    this.getAuthRequestContext.put(cls.getName(), method);
                }
                method.invoke(null, versionedParcelable, authRequestContext);
                authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (e4.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e4.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
        } catch (ClassNotFoundException e5) {
            StringBuilder sb = new StringBuilder();
            sb.append(versionedParcelable.getClass().getSimpleName());
            sb.append(" does not have a Parcelizer");
            throw new RuntimeException(sb.toString(), e5);
        }
    }

    public final <T extends VersionedParcelable> T getAuthRequestContext(T t) {
        if (getAuthRequestContext(1)) {
            String moveToNextValue = moveToNextValue();
            if (moveToNextValue == null) {
                return null;
            }
            return (T) PlaceComponentResult(moveToNextValue, getAuthRequestContext());
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T extends VersionedParcelable> T lookAheadTest() {
        String moveToNextValue = moveToNextValue();
        if (moveToNextValue == null) {
            return null;
        }
        return (T) PlaceComponentResult(moveToNextValue, getAuthRequestContext());
    }

    /* renamed from: androidx.versionedparcelable.VersionedParcel$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 extends ObjectInputStream {
        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
            return cls != null ? cls : super.resolveClass(objectStreamClass);
        }
    }

    private Class BuiltInFictitiousFunctionClassFactory(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.MyBillsEntityDataFactory.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.MyBillsEntityDataFactory.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    /* loaded from: classes6.dex */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    private <T extends VersionedParcelable> T PlaceComponentResult(String str, VersionedParcel versionedParcel) {
        try {
            Method method = this.BuiltInFictitiousFunctionClassFactory.get(str);
            if (method == null) {
                method = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
                this.BuiltInFictitiousFunctionClassFactory.put(str, method);
            }
            return (T) method.invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }
}
