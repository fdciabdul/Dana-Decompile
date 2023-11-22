package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes6.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda1 = versionedParcel.KClassImpl$Data$declaredNonStaticMembers$2(iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda1, 1);
        iconCompat.BuiltInFictitiousFunctionClassFactory = versionedParcel.KClassImpl$Data$declaredNonStaticMembers$2(iconCompat.BuiltInFictitiousFunctionClassFactory);
        iconCompat.moveToNextValue = versionedParcel.getAuthRequestContext((VersionedParcel) iconCompat.moveToNextValue, 3);
        iconCompat.MyBillsEntityDataFactory = versionedParcel.KClassImpl$Data$declaredNonStaticMembers$2(iconCompat.MyBillsEntityDataFactory, 4);
        iconCompat.PlaceComponentResult = versionedParcel.KClassImpl$Data$declaredNonStaticMembers$2(iconCompat.PlaceComponentResult, 5);
        iconCompat.lookAheadTest = (ColorStateList) versionedParcel.getAuthRequestContext((VersionedParcel) iconCompat.lookAheadTest, 6);
        iconCompat.getErrorConfigVersion = versionedParcel.getAuthRequestContext(iconCompat.getErrorConfigVersion, 7);
        iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda0 = versionedParcel.getAuthRequestContext(iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda0, 8);
        iconCompat.lookAheadTest();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.BuiltInFictitiousFunctionClassFactory(true, true);
        iconCompat.getAuthRequestContext(versionedParcel.MyBillsEntityDataFactory());
        if (-1 != iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            versionedParcel.BuiltInFictitiousFunctionClassFactory(iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda1, 1);
        }
        if (iconCompat.BuiltInFictitiousFunctionClassFactory != null) {
            versionedParcel.getAuthRequestContext(iconCompat.BuiltInFictitiousFunctionClassFactory);
        }
        if (iconCompat.moveToNextValue != null) {
            versionedParcel.PlaceComponentResult(iconCompat.moveToNextValue, 3);
        }
        if (iconCompat.MyBillsEntityDataFactory != 0) {
            versionedParcel.BuiltInFictitiousFunctionClassFactory(iconCompat.MyBillsEntityDataFactory, 4);
        }
        if (iconCompat.PlaceComponentResult != 0) {
            versionedParcel.BuiltInFictitiousFunctionClassFactory(iconCompat.PlaceComponentResult, 5);
        }
        if (iconCompat.lookAheadTest != null) {
            versionedParcel.PlaceComponentResult(iconCompat.lookAheadTest, 6);
        }
        if (iconCompat.getErrorConfigVersion != null) {
            versionedParcel.PlaceComponentResult(iconCompat.getErrorConfigVersion, 7);
        }
        if (iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            versionedParcel.PlaceComponentResult(iconCompat.NetworkUserEntityData$$ExternalSyntheticLambda0, 8);
        }
    }
}
