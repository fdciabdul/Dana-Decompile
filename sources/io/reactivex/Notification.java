package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

/* loaded from: classes2.dex */
public final class Notification<T> {
    static final Notification<Object> getAuthRequestContext = new Notification<>(null);
    public final Object MyBillsEntityDataFactory;

    private Notification(Object obj) {
        this.MyBillsEntityDataFactory = obj;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory == null;
    }

    public final boolean PlaceComponentResult() {
        return NotificationLite.isError(this.MyBillsEntityDataFactory);
    }

    public final boolean getAuthRequestContext() {
        Object obj = this.MyBillsEntityDataFactory;
        return (obj == null || NotificationLite.isError(obj)) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.getAuthRequestContext(this.MyBillsEntityDataFactory, ((Notification) obj).MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.MyBillsEntityDataFactory;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        Object obj = this.MyBillsEntityDataFactory;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnErrorNotification[");
            sb.append(NotificationLite.getError(obj));
            sb.append("]");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("OnNextNotification[");
        sb2.append(this.MyBillsEntityDataFactory);
        sb2.append("]");
        return sb2.toString();
    }

    public static <T> Notification<T> BuiltInFictitiousFunctionClassFactory(T t) {
        ObjectHelper.PlaceComponentResult(t, "value is null");
        return new Notification<>(t);
    }

    public static <T> Notification<T> MyBillsEntityDataFactory(Throwable th) {
        ObjectHelper.PlaceComponentResult(th, "error is null");
        return new Notification<>(NotificationLite.error(th));
    }

    public static <T> Notification<T> MyBillsEntityDataFactory() {
        return (Notification<T>) getAuthRequestContext;
    }
}
