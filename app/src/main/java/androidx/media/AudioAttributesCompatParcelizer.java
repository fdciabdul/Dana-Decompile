package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes6.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.PlaceComponentResult = (AudioAttributesImpl) versionedParcel.getAuthRequestContext((VersionedParcel) audioAttributesCompat.PlaceComponentResult);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.BuiltInFictitiousFunctionClassFactory(false, false);
        versionedParcel.MyBillsEntityDataFactory(audioAttributesCompat.PlaceComponentResult);
    }
}
