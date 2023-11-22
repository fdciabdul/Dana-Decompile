package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* loaded from: classes6.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {
        final MediaSessionManager.RemoteUserInfo PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RemoteUserInfoImplApi28(String str, int i, int i2) {
            this.PlaceComponentResult = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.PlaceComponentResult = remoteUserInfo;
        }

        public final int hashCode() {
            return ObjectsCompat.PlaceComponentResult(this.PlaceComponentResult);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfoImplApi28) {
                return this.PlaceComponentResult.equals(((RemoteUserInfoImplApi28) obj).PlaceComponentResult);
            }
            return false;
        }
    }
}
