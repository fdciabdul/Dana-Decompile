package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes6.dex */
public final class MediaControllerCompat {
    private final HashSet<Callback> BuiltInFictitiousFunctionClassFactory = new HashSet<>();
    private final MediaSessionCompat.Token MyBillsEntityDataFactory;
    private final MediaControllerImpl getAuthRequestContext;

    /* loaded from: classes6.dex */
    static class MediaControllerExtraData extends ComponentActivity.ExtraData {
    }

    /* loaded from: classes6.dex */
    interface MediaControllerImpl {
        boolean MyBillsEntityDataFactory(KeyEvent keyEvent);
    }

    /* loaded from: classes6.dex */
    static class TransportControlsApi21 extends TransportControls {
    }

    /* loaded from: classes6.dex */
    static class TransportControlsApi23 extends TransportControlsApi21 {
    }

    /* loaded from: classes6.dex */
    static class TransportControlsApi24 extends TransportControlsApi23 {
    }

    /* loaded from: classes6.dex */
    static class TransportControlsBase extends TransportControls {
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) throws RemoteException {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.MyBillsEntityDataFactory = token;
        if (Build.VERSION.SDK_INT >= 24) {
            this.getAuthRequestContext = new MediaControllerImplApi24(context, token);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.getAuthRequestContext = new MediaControllerImplApi23(context, token);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.getAuthRequestContext = new MediaControllerImplApi21(context, token);
        } else {
            this.getAuthRequestContext = new MediaControllerImplBase(token);
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return this.getAuthRequestContext.MyBillsEntityDataFactory(keyEvent);
    }

    /* loaded from: classes6.dex */
    public static abstract class Callback implements IBinder.DeathRecipient {
        MessageHandler KClassImpl$Data$declaredNonStaticMembers$2;
        IMediaControllerCallback MyBillsEntityDataFactory;
        final Object getAuthRequestContext;

        public void BuiltInFictitiousFunctionClassFactory() {
        }

        public void BuiltInFictitiousFunctionClassFactory(PlaybackInfo playbackInfo) {
        }

        public void BuiltInFictitiousFunctionClassFactory(PlaybackStateCompat playbackStateCompat) {
        }

        public void BuiltInFictitiousFunctionClassFactory(List<MediaSessionCompat.QueueItem> list) {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        public void MyBillsEntityDataFactory(int i) {
        }

        public void MyBillsEntityDataFactory(String str, Bundle bundle) {
        }

        public void MyBillsEntityDataFactory(boolean z) {
        }

        public void PlaceComponentResult(int i) {
        }

        public void getAuthRequestContext(Bundle bundle) {
        }

        public void getAuthRequestContext(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void getAuthRequestContext(CharSequence charSequence) {
        }

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.getAuthRequestContext = MediaControllerCompatApi21.MyBillsEntityDataFactory(new StubApi21(this));
                return;
            }
            StubCompat stubCompat = new StubCompat(this);
            this.MyBillsEntityDataFactory = stubCompat;
            this.getAuthRequestContext = stubCompat;
        }

        void getAuthRequestContext(int i, Object obj, Bundle bundle) {
            MessageHandler messageHandler = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (messageHandler != null) {
                Message obtainMessage = messageHandler.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        /* loaded from: classes6.dex */
        static class StubApi21 implements MediaControllerCompatApi21.Callback {
            private final WeakReference<Callback> getAuthRequestContext;

            StubApi21(Callback callback) {
                this.getAuthRequestContext = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void PlaceComponentResult() {
                Callback callback = this.getAuthRequestContext.get();
                if (callback != null) {
                    callback.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void MyBillsEntityDataFactory(String str, Bundle bundle) {
                Callback callback = this.getAuthRequestContext.get();
                if (callback != null) {
                    if (callback.MyBillsEntityDataFactory == null || Build.VERSION.SDK_INT >= 23) {
                        callback.MyBillsEntityDataFactory(str, bundle);
                    }
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void MyBillsEntityDataFactory(Object obj) {
                Callback callback = this.getAuthRequestContext.get();
                if (callback == null || callback.MyBillsEntityDataFactory != null) {
                    return;
                }
                callback.BuiltInFictitiousFunctionClassFactory(PlaybackStateCompat.getAuthRequestContext(obj));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void BuiltInFictitiousFunctionClassFactory(Object obj) {
                Callback callback = this.getAuthRequestContext.get();
                if (callback != null) {
                    callback.getAuthRequestContext(MediaMetadataCompat.PlaceComponentResult(obj));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void KClassImpl$Data$declaredNonStaticMembers$2(List<?> list) {
                Callback callback = this.getAuthRequestContext.get();
                if (callback != null) {
                    callback.BuiltInFictitiousFunctionClassFactory(MediaSessionCompat.QueueItem.MyBillsEntityDataFactory(list));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void MyBillsEntityDataFactory(CharSequence charSequence) {
                Callback callback = this.getAuthRequestContext.get();
                if (callback != null) {
                    callback.getAuthRequestContext(charSequence);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void PlaceComponentResult(Bundle bundle) {
                Callback callback = this.getAuthRequestContext.get();
                if (callback != null) {
                    callback.getAuthRequestContext(bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void getAuthRequestContext(int i, int i2, int i3, int i4, int i5) {
                Callback callback = this.getAuthRequestContext.get();
                if (callback != null) {
                    callback.BuiltInFictitiousFunctionClassFactory(new PlaybackInfo(i, i2, i3, i4, i5));
                }
            }
        }

        /* loaded from: classes6.dex */
        static class StubCompat extends IMediaControllerCallback.Stub {
            private final WeakReference<Callback> BuiltInFictitiousFunctionClassFactory;

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z) throws RemoteException {
            }

            StubCompat(Callback callback) {
                this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(11, Boolean.valueOf(z), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int i) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(9, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int i) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(12, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(7, bundle, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.PlaceComponentResult, parcelableVolumeInfo.getAuthRequestContext, parcelableVolumeInfo.MyBillsEntityDataFactory, parcelableVolumeInfo.BuiltInFictitiousFunctionClassFactory, parcelableVolumeInfo.KClassImpl$Data$declaredNonStaticMembers$2) : null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Callback callback = this.BuiltInFictitiousFunctionClassFactory.get();
                if (callback != null) {
                    callback.getAuthRequestContext(13, null, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class MessageHandler extends Handler {
            boolean BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ Callback KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.PlaceComponentResult(data);
                            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory((String) message.obj, data);
                            return;
                        case 2:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((PlaybackInfo) message.obj);
                            return;
                        case 5:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((List) message.obj);
                            return;
                        case 6:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.PlaceComponentResult(bundle);
                            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(bundle);
                            return;
                        case 8:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                            return;
                        case 9:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(((Integer) message.obj).intValue());
                            return;
                        case 10:
                        default:
                            return;
                        case 11:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
                            return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class TransportControls {
        TransportControls() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class PlaybackInfo {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private final int PlaceComponentResult;
        private final int getAuthRequestContext;

        PlaybackInfo(int i, int i2, int i3, int i4, int i5) {
            this.getAuthRequestContext = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.PlaceComponentResult = i3;
            this.BuiltInFictitiousFunctionClassFactory = i4;
            this.MyBillsEntityDataFactory = i5;
        }
    }

    /* loaded from: classes6.dex */
    static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession MyBillsEntityDataFactory;

        public MediaControllerImplBase(MediaSessionCompat.Token token) {
            this.MyBillsEntityDataFactory = IMediaSession.Stub.asInterface((IBinder) token.KClassImpl$Data$declaredNonStaticMembers$2());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean MyBillsEntityDataFactory(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.MyBillsEntityDataFactory.sendMediaButton(keyEvent);
                return false;
            } catch (RemoteException e) {
                InstrumentInjector.log_e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
                return false;
            }
        }
    }

    /* loaded from: classes6.dex */
    static class MediaControllerImplApi21 implements MediaControllerImpl {
        protected final Object KClassImpl$Data$declaredNonStaticMembers$2;
        final MediaSessionCompat.Token PlaceComponentResult;
        final Object MyBillsEntityDataFactory = new Object();
        private final List<Callback> getAuthRequestContext = new ArrayList();
        private HashMap<Callback, ExtraCallback> BuiltInFictitiousFunctionClassFactory = new HashMap<>();

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.PlaceComponentResult = token;
            Object PlaceComponentResult = MediaControllerCompatApi21.PlaceComponentResult(context, token.KClassImpl$Data$declaredNonStaticMembers$2());
            this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
            if (PlaceComponentResult == null) {
                throw new RemoteException();
            }
            if (token.MyBillsEntityDataFactory() == null) {
                BuiltInFictitiousFunctionClassFactory();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean MyBillsEntityDataFactory(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, keyEvent);
        }

        public void getAuthRequestContext(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, str, bundle, resultReceiver);
        }

        private void BuiltInFictitiousFunctionClassFactory() {
            getAuthRequestContext("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        void getAuthRequestContext() {
            if (this.PlaceComponentResult.MyBillsEntityDataFactory() == null) {
                return;
            }
            for (Callback callback : this.getAuthRequestContext) {
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.BuiltInFictitiousFunctionClassFactory.put(callback, extraCallback);
                callback.MyBillsEntityDataFactory = extraCallback;
                try {
                    this.PlaceComponentResult.MyBillsEntityDataFactory().registerCallbackListener(extraCallback);
                    callback.getAuthRequestContext(13, null, null);
                } catch (RemoteException e) {
                    InstrumentInjector.log_e("MediaControllerCompat", "Dead object in registerCallback.", e);
                }
            }
            this.getAuthRequestContext.clear();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> PlaceComponentResult;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.PlaceComponentResult = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.PlaceComponentResult.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.MyBillsEntityDataFactory) {
                    mediaControllerImplApi21.PlaceComponentResult.PlaceComponentResult(IMediaSession.Stub.asInterface(BundleCompat.BuiltInFictitiousFunctionClassFactory(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerImplApi21.getAuthRequestContext();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }
        }
    }

    /* loaded from: classes6.dex */
    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }

    /* loaded from: classes6.dex */
    static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context context, MediaSessionCompat.Token token) throws RemoteException {
            super(context, token);
        }
    }
}
