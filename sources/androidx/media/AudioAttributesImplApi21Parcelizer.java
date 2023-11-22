package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes6.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.PlaceComponentResult = (AudioAttributes) versionedParcel.getAuthRequestContext((VersionedParcel) audioAttributesImplApi21.PlaceComponentResult, 1);
        audioAttributesImplApi21.MyBillsEntityDataFactory = versionedParcel.KClassImpl$Data$declaredNonStaticMembers$2(audioAttributesImplApi21.MyBillsEntityDataFactory, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, VersionedParcel versionedParcel) {
        versionedParcel.BuiltInFictitiousFunctionClassFactory(false, false);
        versionedParcel.PlaceComponentResult(audioAttributesImplApi21.PlaceComponentResult, 1);
        versionedParcel.BuiltInFictitiousFunctionClassFactory(audioAttributesImplApi21.MyBillsEntityDataFactory, 2);
    }
}
