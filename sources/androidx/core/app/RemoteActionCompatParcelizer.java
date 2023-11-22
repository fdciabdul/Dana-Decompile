package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes6.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.MyBillsEntityDataFactory = (IconCompat) versionedParcel.getAuthRequestContext((VersionedParcel) remoteActionCompat.MyBillsEntityDataFactory);
        remoteActionCompat.getErrorConfigVersion = versionedParcel.BuiltInFictitiousFunctionClassFactory(remoteActionCompat.getErrorConfigVersion, 2);
        remoteActionCompat.getAuthRequestContext = versionedParcel.BuiltInFictitiousFunctionClassFactory(remoteActionCompat.getAuthRequestContext, 3);
        remoteActionCompat.KClassImpl$Data$declaredNonStaticMembers$2 = (PendingIntent) versionedParcel.getAuthRequestContext((VersionedParcel) remoteActionCompat.KClassImpl$Data$declaredNonStaticMembers$2, 4);
        remoteActionCompat.BuiltInFictitiousFunctionClassFactory = versionedParcel.PlaceComponentResult(remoteActionCompat.BuiltInFictitiousFunctionClassFactory, 5);
        remoteActionCompat.PlaceComponentResult = versionedParcel.PlaceComponentResult(remoteActionCompat.PlaceComponentResult, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.BuiltInFictitiousFunctionClassFactory(false, false);
        versionedParcel.MyBillsEntityDataFactory(remoteActionCompat.MyBillsEntityDataFactory);
        versionedParcel.PlaceComponentResult(remoteActionCompat.getErrorConfigVersion, 2);
        versionedParcel.PlaceComponentResult(remoteActionCompat.getAuthRequestContext, 3);
        versionedParcel.PlaceComponentResult(remoteActionCompat.KClassImpl$Data$declaredNonStaticMembers$2, 4);
        versionedParcel.getAuthRequestContext(remoteActionCompat.BuiltInFictitiousFunctionClassFactory, 5);
        versionedParcel.getAuthRequestContext(remoteActionCompat.PlaceComponentResult, 6);
    }
}
