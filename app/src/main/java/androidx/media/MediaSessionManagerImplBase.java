package androidx.media;

import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* loaded from: classes6.dex */
class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {
    private static final boolean getAuthRequestContext = MediaSessionManager.getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {
        private String KClassImpl$Data$declaredNonStaticMembers$2;
        private int PlaceComponentResult;
        private int getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RemoteUserInfoImplBase(String str, int i, int i2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.getAuthRequestContext = i;
            this.PlaceComponentResult = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfoImplBase) {
                RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
                return TextUtils.equals(this.KClassImpl$Data$declaredNonStaticMembers$2, remoteUserInfoImplBase.KClassImpl$Data$declaredNonStaticMembers$2) && this.getAuthRequestContext == remoteUserInfoImplBase.getAuthRequestContext && this.PlaceComponentResult == remoteUserInfoImplBase.PlaceComponentResult;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, Integer.valueOf(this.getAuthRequestContext), Integer.valueOf(this.PlaceComponentResult));
        }
    }
}
