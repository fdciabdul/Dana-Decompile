package androidx.media;

import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public class AudioAttributesCompat implements VersionedParcelable {
    private static final int[] BuiltInFictitiousFunctionClassFactory;
    private static final SparseIntArray getAuthRequestContext;
    AudioAttributesImpl PlaceComponentResult;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AttributeUsage {
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private int PlaceComponentResult = 0;
        private int MyBillsEntityDataFactory = 0;
        private int getAuthRequestContext = 0;
        private int BuiltInFictitiousFunctionClassFactory = -1;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        getAuthRequestContext = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
        BuiltInFictitiousFunctionClassFactory = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    public int hashCode() {
        return this.PlaceComponentResult.hashCode();
    }

    public String toString() {
        return this.PlaceComponentResult.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String BuiltInFictitiousFunctionClassFactory(int i) {
        switch (i) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("unknown usage ");
                sb.append(i);
                return sb.toString();
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    /* loaded from: classes6.dex */
    static abstract class AudioManagerHidden {
        private AudioManagerHidden() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAuthRequestContext(boolean z, int i, int i2) {
        if ((i & 1) == 1) {
            return z ? 1 : 7;
        } else if ((i & 4) == 4) {
            return z ? 0 : 6;
        } else {
            switch (i2) {
                case 0:
                    return z ? Integer.MIN_VALUE : 3;
                case 1:
                case 12:
                case 14:
                case 16:
                    return 3;
                case 2:
                    return 0;
                case 3:
                    return z ? 0 : 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 11:
                    return 10;
                case 13:
                    return 1;
                case 15:
                default:
                    if (z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unknown usage value ");
                        sb.append(i2);
                        sb.append(" in audio attributes");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    return 3;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesCompat) {
            AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
            AudioAttributesImpl audioAttributesImpl = this.PlaceComponentResult;
            if (audioAttributesImpl == null) {
                return audioAttributesCompat.PlaceComponentResult == null;
            }
            return audioAttributesImpl.equals(audioAttributesCompat.PlaceComponentResult);
        }
        return false;
    }
}
