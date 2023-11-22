package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes6.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.PlaceComponentResult = versionedParcel.KClassImpl$Data$declaredNonStaticMembers$2(audioAttributesImplBase.PlaceComponentResult, 1);
        audioAttributesImplBase.KClassImpl$Data$declaredNonStaticMembers$2 = versionedParcel.KClassImpl$Data$declaredNonStaticMembers$2(audioAttributesImplBase.KClassImpl$Data$declaredNonStaticMembers$2, 2);
        audioAttributesImplBase.MyBillsEntityDataFactory = versionedParcel.KClassImpl$Data$declaredNonStaticMembers$2(audioAttributesImplBase.MyBillsEntityDataFactory, 3);
        audioAttributesImplBase.BuiltInFictitiousFunctionClassFactory = versionedParcel.KClassImpl$Data$declaredNonStaticMembers$2(audioAttributesImplBase.BuiltInFictitiousFunctionClassFactory, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.BuiltInFictitiousFunctionClassFactory(false, false);
        versionedParcel.BuiltInFictitiousFunctionClassFactory(audioAttributesImplBase.PlaceComponentResult, 1);
        versionedParcel.BuiltInFictitiousFunctionClassFactory(audioAttributesImplBase.KClassImpl$Data$declaredNonStaticMembers$2, 2);
        versionedParcel.BuiltInFictitiousFunctionClassFactory(audioAttributesImplBase.MyBillsEntityDataFactory, 3);
        versionedParcel.BuiltInFictitiousFunctionClassFactory(audioAttributesImplBase.BuiltInFictitiousFunctionClassFactory, 4);
    }
}
