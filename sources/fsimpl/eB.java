package fsimpl;

import java.util.Date;

/* loaded from: classes4.dex */
public enum eB {
    Unhandled,
    Boolean,
    Int,
    Long,
    Float,
    Double,
    CharSequence,
    Date;

    public static eB a(Class cls) {
        return (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Byte.class || cls == Short.class || cls == Integer.class) ? Int : (cls == Long.TYPE || cls == Long.class) ? Long : (cls == Float.TYPE || cls == Float.class) ? Float : (cls == Double.TYPE || cls == Double.class) ? Double : (cls == Boolean.TYPE || cls == Boolean.class) ? Boolean : Date.class.isAssignableFrom(cls) ? Date : CharSequence.class.isAssignableFrom(cls) ? CharSequence : Unhandled;
    }
}
