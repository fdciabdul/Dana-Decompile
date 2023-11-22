package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;

/* loaded from: classes6.dex */
class PlaybackStateCompatApi21 {
    public static int scheduleImpl(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    public static long moveToNextValue(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    public static long PlaceComponentResult(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    public static float getErrorConfigVersion(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    public static long getAuthRequestContext(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    public static CharSequence BuiltInFictitiousFunctionClassFactory(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    public static long lookAheadTest(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    public static long MyBillsEntityDataFactory(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class CustomAction {
        public static CharSequence BuiltInFictitiousFunctionClassFactory(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        public static int PlaceComponentResult(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        public static Bundle getAuthRequestContext(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }

        private CustomAction() {
        }
    }

    private PlaybackStateCompatApi21() {
    }
}
