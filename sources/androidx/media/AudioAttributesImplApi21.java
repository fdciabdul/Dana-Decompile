package androidx.media;

import android.media.AudioAttributes;

/* loaded from: classes6.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {
    int MyBillsEntityDataFactory = -1;
    AudioAttributes PlaceComponentResult;

    public int hashCode() {
        return this.PlaceComponentResult.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.PlaceComponentResult.equals(((AudioAttributesImplApi21) obj).PlaceComponentResult);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioAttributesCompat: audioattributes=");
        sb.append(this.PlaceComponentResult);
        return sb.toString();
    }
}
