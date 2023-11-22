package android.support.v4.media.session;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MediaControllerCompatApi21 {

    /* loaded from: classes6.dex */
    public interface Callback {
        void BuiltInFictitiousFunctionClassFactory(Object obj);

        void KClassImpl$Data$declaredNonStaticMembers$2(List<?> list);

        void MyBillsEntityDataFactory(CharSequence charSequence);

        void MyBillsEntityDataFactory(Object obj);

        void MyBillsEntityDataFactory(String str, Bundle bundle);

        void PlaceComponentResult();

        void PlaceComponentResult(Bundle bundle);

        void getAuthRequestContext(int i, int i2, int i3, int i4, int i5);
    }

    public static Object PlaceComponentResult(Context context, Object obj) {
        return new MediaController(context, (MediaSession.Token) obj);
    }

    public static Object MyBillsEntityDataFactory(Callback callback) {
        return new CallbackProxy(callback);
    }

    public static boolean PlaceComponentResult(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    public static void BuiltInFictitiousFunctionClassFactory(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    /* loaded from: classes6.dex */
    public static class TransportControls {
        private TransportControls() {
        }
    }

    /* loaded from: classes6.dex */
    public static class PlaybackInfo {
        public static AudioAttributes BuiltInFictitiousFunctionClassFactory(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int PlaceComponentResult(Object obj) {
            return MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory(obj));
        }

        private static int MyBillsEntityDataFactory(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            int usage = audioAttributes.getUsage();
            if (usage != 13) {
                switch (usage) {
                    case 2:
                        return 0;
                    case 3:
                        return 8;
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
                    default:
                        return 3;
                }
            }
            return 1;
        }

        private PlaybackInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CallbackProxy<T extends Callback> extends MediaController.Callback {
        protected final T PlaceComponentResult;

        public CallbackProxy(T t) {
            this.PlaceComponentResult = t;
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.PlaceComponentResult.PlaceComponentResult();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            this.PlaceComponentResult.MyBillsEntityDataFactory(str, bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.PlaceComponentResult.MyBillsEntityDataFactory(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(list);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.PlaceComponentResult.MyBillsEntityDataFactory(charSequence);
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            this.PlaceComponentResult.PlaceComponentResult(bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.PlaceComponentResult.getAuthRequestContext(playbackInfo.getPlaybackType(), PlaybackInfo.PlaceComponentResult(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }

    private MediaControllerCompatApi21() {
    }
}
