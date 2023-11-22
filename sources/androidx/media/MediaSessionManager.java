package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

/* loaded from: classes6.dex */
public final class MediaSessionManager {
    static final boolean getAuthRequestContext = Log.isLoggable("MediaSessionManager", 3);
    private static final Object MyBillsEntityDataFactory = new Object();

    /* loaded from: classes6.dex */
    interface MediaSessionManagerImpl {
    }

    /* loaded from: classes6.dex */
    interface RemoteUserInfoImpl {
    }

    /* loaded from: classes6.dex */
    public static final class RemoteUserInfo {
        RemoteUserInfoImpl getAuthRequestContext;

        public RemoteUserInfo(String str, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.getAuthRequestContext = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i, i2);
            } else {
                this.getAuthRequestContext = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i, i2);
            }
        }

        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.getAuthRequestContext = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfo) {
                return this.getAuthRequestContext.equals(((RemoteUserInfo) obj).getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            return this.getAuthRequestContext.hashCode();
        }
    }
}
