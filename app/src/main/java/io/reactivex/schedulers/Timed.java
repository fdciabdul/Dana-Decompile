package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class Timed<T> {
    public final T MyBillsEntityDataFactory;
    public final TimeUnit PlaceComponentResult;
    public final long getAuthRequestContext;

    public Timed(T t, long j, TimeUnit timeUnit) {
        this.MyBillsEntityDataFactory = t;
        this.getAuthRequestContext = j;
        this.PlaceComponentResult = (TimeUnit) ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Timed) {
            Timed timed = (Timed) obj;
            return ObjectHelper.getAuthRequestContext(this.MyBillsEntityDataFactory, timed.MyBillsEntityDataFactory) && this.getAuthRequestContext == timed.getAuthRequestContext && ObjectHelper.getAuthRequestContext(this.PlaceComponentResult, timed.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        T t = this.MyBillsEntityDataFactory;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.getAuthRequestContext;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Timed[time=");
        sb.append(this.getAuthRequestContext);
        sb.append(", unit=");
        sb.append(this.PlaceComponentResult);
        sb.append(", value=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("]");
        return sb.toString();
    }
}
