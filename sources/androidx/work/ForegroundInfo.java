package androidx.work;

import android.app.Notification;

/* loaded from: classes3.dex */
public final class ForegroundInfo {
    public final Notification BuiltInFictitiousFunctionClassFactory;
    public final int MyBillsEntityDataFactory;
    public final int PlaceComponentResult;

    public ForegroundInfo(int i, Notification notification, int i2) {
        this.MyBillsEntityDataFactory = i;
        this.BuiltInFictitiousFunctionClassFactory = notification;
        this.PlaceComponentResult = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) obj;
        if (this.MyBillsEntityDataFactory == foregroundInfo.MyBillsEntityDataFactory && this.PlaceComponentResult == foregroundInfo.PlaceComponentResult) {
            return this.BuiltInFictitiousFunctionClassFactory.equals(foregroundInfo.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.MyBillsEntityDataFactory * 31) + this.PlaceComponentResult) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ForegroundInfo{");
        sb.append("mNotificationId=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", mForegroundServiceType=");
        sb.append(this.PlaceComponentResult);
        sb.append(", mNotification=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append('}');
        return sb.toString();
    }
}
