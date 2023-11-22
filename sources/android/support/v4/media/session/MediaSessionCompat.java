package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.support.v4.media.session.MediaSessionCompatApi24;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class MediaSessionCompat {
    private final MediaControllerCompat BuiltInFictitiousFunctionClassFactory;

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 extends Callback {
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 extends Callback {
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass3 extends Callback {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface MediaSessionImpl {
        MediaSessionManager.RemoteUserInfo MyBillsEntityDataFactory();

        PlaybackStateCompat PlaceComponentResult();

        void PlaceComponentResult(MediaSessionManager.RemoteUserInfo remoteUserInfo);
    }

    /* loaded from: classes6.dex */
    public interface OnActiveChangeListener {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SessionFlags {
    }

    public MediaControllerCompat BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public static void PlaceComponentResult(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    static PlaybackStateCompat getAuthRequestContext(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat != null) {
            long j = -1;
            if (playbackStateCompat.KClassImpl$Data$declaredNonStaticMembers$2() == -1) {
                return playbackStateCompat;
            }
            if (playbackStateCompat.PlaceComponentResult() == 3 || playbackStateCompat.PlaceComponentResult() == 4 || playbackStateCompat.PlaceComponentResult() == 5) {
                if (playbackStateCompat.BuiltInFictitiousFunctionClassFactory() > 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long authRequestContext = (playbackStateCompat.getAuthRequestContext() * ((float) (elapsedRealtime - r0))) + playbackStateCompat.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (mediaMetadataCompat != null && mediaMetadataCompat.getAuthRequestContext("android.media.metadata.DURATION")) {
                        j = mediaMetadataCompat.PlaceComponentResult("android.media.metadata.DURATION");
                    }
                    return new PlaybackStateCompat.Builder(playbackStateCompat).getAuthRequestContext(playbackStateCompat.PlaceComponentResult(), (j < 0 || authRequestContext <= j) ? authRequestContext < 0 ? 0L : authRequestContext : j, playbackStateCompat.getAuthRequestContext(), elapsedRealtime).KClassImpl$Data$declaredNonStaticMembers$2();
                }
                return playbackStateCompat;
            }
            return playbackStateCompat;
        }
        return playbackStateCompat;
    }

    /* loaded from: classes6.dex */
    public static abstract class Callback {
        WeakReference<MediaSessionImpl> BuiltInFictitiousFunctionClassFactory;
        final Object KClassImpl$Data$declaredNonStaticMembers$2;
        private CallbackHandler PlaceComponentResult = null;
        private boolean getAuthRequestContext;

        public void BuiltInFictitiousFunctionClassFactory() {
        }

        public void BuiltInFictitiousFunctionClassFactory(int i) {
        }

        public void BuiltInFictitiousFunctionClassFactory(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void BuiltInFictitiousFunctionClassFactory(String str, Bundle bundle) {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle) {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void MyBillsEntityDataFactory() {
        }

        public void MyBillsEntityDataFactory(long j) {
        }

        public void MyBillsEntityDataFactory(Uri uri, Bundle bundle) {
        }

        public void MyBillsEntityDataFactory(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void MyBillsEntityDataFactory(String str, Bundle bundle) {
        }

        public void MyBillsEntityDataFactory(boolean z) {
        }

        public void PlaceComponentResult() {
        }

        public void PlaceComponentResult(long j) {
        }

        public void PlaceComponentResult(RatingCompat ratingCompat) {
        }

        public void PlaceComponentResult(String str, Bundle bundle) {
        }

        public void getAuthRequestContext() {
        }

        public void getAuthRequestContext(int i) {
        }

        public void getAuthRequestContext(Uri uri, Bundle bundle) {
        }

        public void getAuthRequestContext(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void getAuthRequestContext(String str, Bundle bundle) {
        }

        public void lookAheadTest() {
        }

        public void moveToNextValue() {
        }

        public void scheduleImpl() {
        }

        public Callback() {
            if (Build.VERSION.SDK_INT >= 24) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = MediaSessionCompatApi24.MyBillsEntityDataFactory((MediaSessionCompatApi24.Callback) new StubApi24());
            } else if (Build.VERSION.SDK_INT >= 23) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = MediaSessionCompatApi23.MyBillsEntityDataFactory(new StubApi23());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = MediaSessionCompatApi21.BuiltInFictitiousFunctionClassFactory(new StubApi21());
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
        }

        public boolean getAuthRequestContext(Intent intent) {
            MediaSessionImpl mediaSessionImpl;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27 || (mediaSessionImpl = this.BuiltInFictitiousFunctionClassFactory.get()) == null || this.PlaceComponentResult == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            MediaSessionManager.RemoteUserInfo MyBillsEntityDataFactory = mediaSessionImpl.MyBillsEntityDataFactory();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 79 || keyCode == 85) {
                if (keyEvent.getRepeatCount() > 0) {
                    KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                } else if (this.getAuthRequestContext) {
                    this.PlaceComponentResult.removeMessages(1);
                    this.getAuthRequestContext = false;
                    PlaybackStateCompat PlaceComponentResult = mediaSessionImpl.PlaceComponentResult();
                    if (((PlaceComponentResult == null ? 0L : PlaceComponentResult.MyBillsEntityDataFactory()) & 32) != 0) {
                        lookAheadTest();
                    }
                } else {
                    this.getAuthRequestContext = true;
                    CallbackHandler callbackHandler = this.PlaceComponentResult;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, MyBillsEntityDataFactory), ViewConfiguration.getDoubleTapTimeout());
                }
                return true;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
            return false;
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            if (this.getAuthRequestContext) {
                this.getAuthRequestContext = false;
                this.PlaceComponentResult.removeMessages(1);
                MediaSessionImpl mediaSessionImpl = this.BuiltInFictitiousFunctionClassFactory.get();
                if (mediaSessionImpl == null) {
                    return;
                }
                PlaybackStateCompat PlaceComponentResult = mediaSessionImpl.PlaceComponentResult();
                long MyBillsEntityDataFactory = PlaceComponentResult == null ? 0L : PlaceComponentResult.MyBillsEntityDataFactory();
                boolean z = PlaceComponentResult != null && PlaceComponentResult.PlaceComponentResult() == 3;
                boolean z2 = (516 & MyBillsEntityDataFactory) != 0;
                boolean z3 = (MyBillsEntityDataFactory & 514) != 0;
                mediaSessionImpl.PlaceComponentResult(remoteUserInfo);
                if (z && z3) {
                    BuiltInFictitiousFunctionClassFactory();
                } else if (!z && z2) {
                    MyBillsEntityDataFactory();
                }
                mediaSessionImpl.PlaceComponentResult(null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class CallbackHandler extends Handler {
            final /* synthetic */ Callback BuiltInFictitiousFunctionClassFactory;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2((MediaSessionManager.RemoteUserInfo) message.obj);
                }
            }
        }

        /* loaded from: classes6.dex */
        class StubApi21 implements MediaSessionCompatApi21.Callback {
            StubApi21() {
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle, ResultReceiver resultReceiver) {
                try {
                    QueueItem queueItem = null;
                    IBinder asBinder = null;
                    queueItem = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionImplApi21) Callback.this.BuiltInFictitiousFunctionClassFactory.get();
                        if (mediaSessionImplApi21 != null) {
                            Bundle bundle2 = new Bundle();
                            Token authRequestContext = mediaSessionImplApi21.getAuthRequestContext();
                            IMediaSession MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory();
                            if (MyBillsEntityDataFactory != null) {
                                asBinder = MyBillsEntityDataFactory.asBinder();
                            }
                            BundleCompat.KClassImpl$Data$declaredNonStaticMembers$2(bundle2, "android.support.v4.media.session.EXTRA_BINDER", asBinder);
                            bundle2.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", authRequestContext.PlaceComponentResult());
                            resultReceiver.send(0, bundle2);
                        }
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        Callback.this.BuiltInFictitiousFunctionClassFactory((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        Callback.this.MyBillsEntityDataFactory((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        Callback.this.KClassImpl$Data$declaredNonStaticMembers$2((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        MediaSessionImplApi21 mediaSessionImplApi212 = (MediaSessionImplApi21) Callback.this.BuiltInFictitiousFunctionClassFactory.get();
                        if (mediaSessionImplApi212 == null || mediaSessionImplApi212.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                            return;
                        }
                        int i = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                        if (i >= 0 && i < mediaSessionImplApi212.NetworkUserEntityData$$ExternalSyntheticLambda0.size()) {
                            queueItem = mediaSessionImplApi212.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i);
                        }
                        if (queueItem != null) {
                            Callback.this.KClassImpl$Data$declaredNonStaticMembers$2(queueItem.BuiltInFictitiousFunctionClassFactory());
                        }
                    } else {
                        Callback.this.KClassImpl$Data$declaredNonStaticMembers$2(str, bundle, resultReceiver);
                    }
                } catch (BadParcelableException unused) {
                    InstrumentInjector.log_e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public boolean PlaceComponentResult(Intent intent) {
                return Callback.this.getAuthRequestContext(intent);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void BuiltInFictitiousFunctionClassFactory() {
                Callback.this.MyBillsEntityDataFactory();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle) {
                Callback.this.KClassImpl$Data$declaredNonStaticMembers$2(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void PlaceComponentResult(String str, Bundle bundle) {
                Callback.this.getAuthRequestContext(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void getAuthRequestContext(long j) {
                Callback.this.MyBillsEntityDataFactory(j);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void getAuthRequestContext() {
                Callback.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void MyBillsEntityDataFactory() {
                Callback.this.lookAheadTest();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void lookAheadTest() {
                Callback.this.moveToNextValue();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void KClassImpl$Data$declaredNonStaticMembers$2() {
                Callback.this.getAuthRequestContext();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void PlaceComponentResult() {
                Callback.this.PlaceComponentResult();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void getErrorConfigVersion() {
                Callback.this.scheduleImpl();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void BuiltInFictitiousFunctionClassFactory(long j) {
                Callback.this.PlaceComponentResult(j);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
                Callback.this.PlaceComponentResult(RatingCompat.PlaceComponentResult(obj));
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void BuiltInFictitiousFunctionClassFactory(String str, Bundle bundle) {
                Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                MediaSessionCompat.PlaceComponentResult(bundle2);
                if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                    Callback.this.getAuthRequestContext((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle2);
                } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                    Callback.this.KClassImpl$Data$declaredNonStaticMembers$2();
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                    Callback.this.MyBillsEntityDataFactory(bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID"), bundle2);
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                    Callback.this.PlaceComponentResult(bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY"), bundle2);
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                    Callback.this.MyBillsEntityDataFactory((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle2);
                } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                    Callback.this.MyBillsEntityDataFactory(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                    Callback.this.getAuthRequestContext(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                    Callback.this.BuiltInFictitiousFunctionClassFactory(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                    Callback.this.getAuthRequestContext((RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), bundle2);
                } else {
                    Callback.this.BuiltInFictitiousFunctionClassFactory(str, bundle);
                }
            }
        }

        /* loaded from: classes6.dex */
        class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            StubApi23() {
                super();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, Bundle bundle) {
                Callback.this.getAuthRequestContext(uri, bundle);
            }
        }

        /* loaded from: classes6.dex */
        class StubApi24 extends StubApi23 implements MediaSessionCompatApi24.Callback {
            StubApi24() {
                super();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void scheduleImpl() {
                Callback.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void MyBillsEntityDataFactory(String str, Bundle bundle) {
                Callback.this.MyBillsEntityDataFactory(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void getAuthRequestContext(String str, Bundle bundle) {
                Callback.this.PlaceComponentResult(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void PlaceComponentResult(Uri uri, Bundle bundle) {
                Callback.this.MyBillsEntityDataFactory(uri, bundle);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() { // from class: android.support.v4.media.session.MediaSessionCompat.Token.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
            public final Token createFromParcel(Parcel parcel) {
                Object readStrongBinder;
                if (Build.VERSION.SDK_INT >= 21) {
                    readStrongBinder = parcel.readParcelable(null);
                } else {
                    readStrongBinder = parcel.readStrongBinder();
                }
                return new Token(readStrongBinder);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
            public final Token[] newArray(int i) {
                return new Token[i];
            }
        };
        private final Object BuiltInFictitiousFunctionClassFactory;
        private Bundle MyBillsEntityDataFactory;
        private IMediaSession PlaceComponentResult;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, null);
        }

        Token(Object obj, IMediaSession iMediaSession, Bundle bundle) {
            this.BuiltInFictitiousFunctionClassFactory = obj;
            this.PlaceComponentResult = iMediaSession;
            this.MyBillsEntityDataFactory = bundle;
        }

        public static Token PlaceComponentResult(Object obj, IMediaSession iMediaSession) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(MediaSessionCompatApi21.getAuthRequestContext(obj), iMediaSession);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.BuiltInFictitiousFunctionClassFactory, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.BuiltInFictitiousFunctionClassFactory);
            }
        }

        public final int hashCode() {
            Object obj = this.BuiltInFictitiousFunctionClassFactory;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Token) {
                Token token = (Token) obj;
                Object obj2 = this.BuiltInFictitiousFunctionClassFactory;
                if (obj2 == null) {
                    return token.BuiltInFictitiousFunctionClassFactory == null;
                }
                Object obj3 = token.BuiltInFictitiousFunctionClassFactory;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            }
            return false;
        }

        public final Object KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public final IMediaSession MyBillsEntityDataFactory() {
            return this.PlaceComponentResult;
        }

        public final void PlaceComponentResult(IMediaSession iMediaSession) {
            this.PlaceComponentResult = iMediaSession;
        }

        public final Bundle PlaceComponentResult() {
            return this.MyBillsEntityDataFactory;
        }

        public final void BuiltInFictitiousFunctionClassFactory(Bundle bundle) {
            this.MyBillsEntityDataFactory = bundle;
        }
    }

    /* loaded from: classes6.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() { // from class: android.support.v4.media.session.MediaSessionCompat.QueueItem.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
            public final QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
            public final QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        private Object BuiltInFictitiousFunctionClassFactory;
        private final long KClassImpl$Data$declaredNonStaticMembers$2;
        private final MediaDescriptionCompat getAuthRequestContext;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.getAuthRequestContext = mediaDescriptionCompat;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            this.BuiltInFictitiousFunctionClassFactory = obj;
        }

        QueueItem(Parcel parcel) {
            this.getAuthRequestContext = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readLong();
        }

        public final MediaDescriptionCompat BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            this.getAuthRequestContext.writeToParcel(parcel, i);
            parcel.writeLong(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public static QueueItem KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            Object description;
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            description = ((MediaSession.QueueItem) obj).getDescription();
            return new QueueItem(obj, MediaDescriptionCompat.PlaceComponentResult(description), MediaSessionCompatApi21.QueueItem.PlaceComponentResult(obj));
        }

        public static List<QueueItem> MyBillsEntityDataFactory(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2(it.next()));
            }
            return arrayList;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MediaSession.QueueItem {Description=");
            sb.append(this.getAuthRequestContext);
            sb.append(", Id=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(" }");
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() { // from class: android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
            public final ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
            public final ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };
        ResultReceiver KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.writeToParcel(parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class MediaSessionImplBase implements MediaSessionImpl {
        volatile Callback BuiltInFictitiousFunctionClassFactory;
        final String DatabaseTableConfigUtil;
        int GetContactSyncConfig;
        final AudioManager KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        MediaMetadataCompat NetworkUserEntityData$$ExternalSyntheticLambda0;
        CharSequence NetworkUserEntityData$$ExternalSyntheticLambda1;
        List<QueueItem> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private MediaSessionManager.RemoteUserInfo NetworkUserEntityData$$ExternalSyntheticLambda3;
        private MessageHandler NetworkUserEntityData$$ExternalSyntheticLambda5;
        int NetworkUserEntityData$$ExternalSyntheticLambda6;
        PendingIntent NetworkUserEntityData$$ExternalSyntheticLambda7;
        int NetworkUserEntityData$$ExternalSyntheticLambda8;
        boolean PlaceComponentResult;
        VolumeProviderCompat PrepareContext;
        final RemoteCallbackList<IMediaControllerCallback> getAuthRequestContext;
        int getErrorConfigVersion;
        int initRecordTimeStamp;
        final String isLayoutRequested;
        Bundle lookAheadTest;
        int moveToNextValue;
        PlaybackStateCompat newProxyInstance;
        final Object scheduleImpl;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass1 extends VolumeProviderCompat.Callback {
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, int i3, Object obj, Bundle bundle) {
            synchronized (this.scheduleImpl) {
                MessageHandler messageHandler = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (messageHandler != null) {
                    Message obtainMessage = messageHandler.obtainMessage(i, i2, i3, obj);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("data_calling_pkg", "android.media.session.MediaController");
                    bundle2.putInt("data_calling_pid", Binder.getCallingPid());
                    bundle2.putInt("data_calling_uid", Binder.getCallingUid());
                    if (bundle != null) {
                        bundle2.putBundle("data_extras", bundle);
                    }
                    obtainMessage.setData(bundle2);
                    obtainMessage.sendToTarget();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat PlaceComponentResult() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.scheduleImpl) {
                playbackStateCompat = this.newProxyInstance;
            }
            return playbackStateCompat;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo MyBillsEntityDataFactory() {
            MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.scheduleImpl) {
                remoteUserInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            }
            return remoteUserInfo;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void PlaceComponentResult(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.scheduleImpl) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = remoteUserInfo;
            }
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 == 2) {
                VolumeProviderCompat volumeProviderCompat = this.PrepareContext;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.KClassImpl$Data$declaredNonStaticMembers$2(i);
                    return;
                }
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.adjustStreamVolume(this.getErrorConfigVersion, i, i2);
        }

        void getAuthRequestContext(int i, int i2) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda6 == 2) {
                VolumeProviderCompat volumeProviderCompat = this.PrepareContext;
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.PlaceComponentResult(i);
                    return;
                }
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.setStreamVolume(this.getErrorConfigVersion, i, i2);
        }

        /* loaded from: classes6.dex */
        class MediaSessionStub extends IMediaSession.Stub {
            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
            }

            MediaSessionStub() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                postToHandler(1, new Command(str, bundle, resultReceiverWrapper.KClassImpl$Data$declaredNonStaticMembers$2));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) {
                boolean z = (MediaSessionImplBase.this.moveToNextValue & 1) != 0;
                if (z) {
                    postToHandler(21, keyEvent);
                }
                return z;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (MediaSessionImplBase.this.MyBillsEntityDataFactory) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
                MediaSessionImplBase.this.getAuthRequestContext.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo("android.media.session.MediaController", getCallingPid(), getCallingUid()));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplBase.this.getAuthRequestContext.unregister(iMediaControllerCallback);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                return MediaSessionImplBase.this.DatabaseTableConfigUtil;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                return MediaSessionImplBase.this.isLayoutRequested;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (MediaSessionImplBase.this.scheduleImpl) {
                    pendingIntent = MediaSessionImplBase.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                }
                return pendingIntent;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                long j;
                synchronized (MediaSessionImplBase.this.scheduleImpl) {
                    j = MediaSessionImplBase.this.moveToNextValue;
                }
                return j;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                int i;
                int i2;
                int streamMaxVolume;
                int streamVolume;
                int i3;
                synchronized (MediaSessionImplBase.this.scheduleImpl) {
                    i = MediaSessionImplBase.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    i2 = MediaSessionImplBase.this.getErrorConfigVersion;
                    VolumeProviderCompat volumeProviderCompat = MediaSessionImplBase.this.PrepareContext;
                    if (i == 2) {
                        int KClassImpl$Data$declaredNonStaticMembers$2 = volumeProviderCompat.KClassImpl$Data$declaredNonStaticMembers$2();
                        int PlaceComponentResult = volumeProviderCompat.PlaceComponentResult();
                        streamVolume = volumeProviderCompat.getAuthRequestContext();
                        streamMaxVolume = PlaceComponentResult;
                        i3 = KClassImpl$Data$declaredNonStaticMembers$2;
                    } else {
                        streamMaxVolume = MediaSessionImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2.getStreamMaxVolume(i2);
                        streamVolume = MediaSessionImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2.getStreamVolume(i2);
                        i3 = 2;
                    }
                }
                return new ParcelableVolumeInfo(i, i2, i3, streamMaxVolume, streamVolume);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i, int i2, String str) {
                MediaSessionImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i, int i2, String str) {
                MediaSessionImplBase.this.getAuthRequestContext(i, i2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                postToHandler(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                postToHandler(4, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                postToHandler(5, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                postToHandler(6, uri, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                postToHandler(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                postToHandler(8, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                postToHandler(9, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                postToHandler(10, uri, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) {
                postToHandler(11, Long.valueOf(j));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                postToHandler(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                postToHandler(13);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                postToHandler(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                postToHandler(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                postToHandler(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                postToHandler(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws RemoteException {
                postToHandler(18, Long.valueOf(j));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat) throws RemoteException {
                postToHandler(19, ratingCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                postToHandler(31, ratingCompat, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                postToHandler(29, Boolean.valueOf(z));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i) throws RemoteException {
                postToHandler(23, i);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i) throws RemoteException {
                postToHandler(30, i);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                postToHandler(20, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (MediaSessionImplBase.this.scheduleImpl) {
                    playbackStateCompat = MediaSessionImplBase.this.newProxyInstance;
                    mediaMetadataCompat = MediaSessionImplBase.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                }
                return MediaSessionCompat.getAuthRequestContext(playbackStateCompat, mediaMetadataCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                synchronized (MediaSessionImplBase.this.scheduleImpl) {
                    list = MediaSessionImplBase.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                }
                return list;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(25, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                postToHandler(26, mediaDescriptionCompat, i);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(27, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i) {
                postToHandler(28, i);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Bundle bundle;
                synchronized (MediaSessionImplBase.this.scheduleImpl) {
                    bundle = MediaSessionImplBase.this.lookAheadTest;
                }
                return bundle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return MediaSessionImplBase.this.initRecordTimeStamp;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return MediaSessionImplBase.this.PlaceComponentResult;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return MediaSessionImplBase.this.GetContactSyncConfig;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return MediaSessionImplBase.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                return (MediaSessionImplBase.this.moveToNextValue & 2) != 0;
            }

            void postToHandler(int i) {
                MediaSessionImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2(i, 0, 0, null, null);
            }

            void postToHandler(int i, int i2) {
                MediaSessionImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, 0, null, null);
            }

            void postToHandler(int i, Object obj) {
                MediaSessionImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2(i, 0, 0, obj, null);
            }

            void postToHandler(int i, Object obj, int i2) {
                MediaSessionImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2(i, i2, 0, obj, null);
            }

            void postToHandler(int i, Object obj, Bundle bundle) {
                MediaSessionImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2(i, 0, 0, obj, bundle);
            }
        }

        /* loaded from: classes6.dex */
        static final class Command {
            public final ResultReceiver KClassImpl$Data$declaredNonStaticMembers$2;
            public final Bundle PlaceComponentResult;
            public final String getAuthRequestContext;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.getAuthRequestContext = str;
                this.PlaceComponentResult = bundle;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = resultReceiver;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class MessageHandler extends Handler {
            final /* synthetic */ MediaSessionImplBase MyBillsEntityDataFactory;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Callback callback = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                if (callback == null) {
                    return;
                }
                Bundle data = message.getData();
                MediaSessionCompat.PlaceComponentResult(data);
                this.MyBillsEntityDataFactory.PlaceComponentResult(new MediaSessionManager.RemoteUserInfo(data.getString("data_calling_pkg"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                Bundle bundle = data.getBundle("data_extras");
                MediaSessionCompat.PlaceComponentResult(bundle);
                try {
                    switch (message.what) {
                        case 1:
                            Command command = (Command) message.obj;
                            callback.KClassImpl$Data$declaredNonStaticMembers$2(command.getAuthRequestContext, command.PlaceComponentResult, command.KClassImpl$Data$declaredNonStaticMembers$2);
                            break;
                        case 2:
                            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(message.arg1, 0);
                            break;
                        case 3:
                            callback.KClassImpl$Data$declaredNonStaticMembers$2();
                            break;
                        case 4:
                            callback.MyBillsEntityDataFactory((String) message.obj, bundle);
                            break;
                        case 5:
                            callback.PlaceComponentResult((String) message.obj, bundle);
                            break;
                        case 6:
                            callback.MyBillsEntityDataFactory((Uri) message.obj, bundle);
                            break;
                        case 7:
                            callback.MyBillsEntityDataFactory();
                            break;
                        case 8:
                            callback.KClassImpl$Data$declaredNonStaticMembers$2((String) message.obj, bundle);
                            break;
                        case 9:
                            callback.getAuthRequestContext((String) message.obj, bundle);
                            break;
                        case 10:
                            callback.getAuthRequestContext((Uri) message.obj, bundle);
                            break;
                        case 11:
                            callback.MyBillsEntityDataFactory(((Long) message.obj).longValue());
                            break;
                        case 12:
                            callback.BuiltInFictitiousFunctionClassFactory();
                            break;
                        case 13:
                            callback.scheduleImpl();
                            break;
                        case 14:
                            callback.lookAheadTest();
                            break;
                        case 15:
                            callback.moveToNextValue();
                            break;
                        case 16:
                            callback.getAuthRequestContext();
                            break;
                        case 17:
                            callback.PlaceComponentResult();
                            break;
                        case 18:
                            callback.PlaceComponentResult(((Long) message.obj).longValue());
                            break;
                        case 19:
                            callback.PlaceComponentResult((RatingCompat) message.obj);
                            break;
                        case 20:
                            callback.BuiltInFictitiousFunctionClassFactory((String) message.obj, bundle);
                            break;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!callback.getAuthRequestContext(intent)) {
                                PlaceComponentResult(keyEvent, callback);
                                break;
                            }
                            break;
                        case 22:
                            this.MyBillsEntityDataFactory.getAuthRequestContext(message.arg1, 0);
                            break;
                        case 23:
                            callback.getAuthRequestContext(message.arg1);
                            break;
                        case 25:
                            callback.BuiltInFictitiousFunctionClassFactory((MediaDescriptionCompat) message.obj);
                            break;
                        case 26:
                            callback.MyBillsEntityDataFactory((MediaDescriptionCompat) message.obj, message.arg1);
                            break;
                        case 27:
                            callback.KClassImpl$Data$declaredNonStaticMembers$2((MediaDescriptionCompat) message.obj);
                            break;
                        case 28:
                            if (this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
                                QueueItem queueItem = (message.arg1 < 0 || message.arg1 >= this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2.size()) ? null : this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2.get(message.arg1);
                                if (queueItem != null) {
                                    callback.KClassImpl$Data$declaredNonStaticMembers$2(queueItem.BuiltInFictitiousFunctionClassFactory());
                                    break;
                                }
                            }
                            break;
                        case 29:
                            callback.MyBillsEntityDataFactory(((Boolean) message.obj).booleanValue());
                            break;
                        case 30:
                            callback.BuiltInFictitiousFunctionClassFactory(message.arg1);
                            break;
                        case 31:
                            callback.getAuthRequestContext((RatingCompat) message.obj, bundle);
                            break;
                    }
                } finally {
                    this.MyBillsEntityDataFactory.PlaceComponentResult(null);
                }
            }

            private void PlaceComponentResult(KeyEvent keyEvent, Callback callback) {
                if (keyEvent == null || keyEvent.getAction() != 0) {
                    return;
                }
                long MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.newProxyInstance == null ? 0L : this.MyBillsEntityDataFactory.newProxyInstance.MyBillsEntityDataFactory();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79) {
                    if (keyCode == 126) {
                        if ((MyBillsEntityDataFactory & 4) != 0) {
                            callback.MyBillsEntityDataFactory();
                            return;
                        }
                        return;
                    } else if (keyCode == 127) {
                        if ((MyBillsEntityDataFactory & 2) != 0) {
                            callback.BuiltInFictitiousFunctionClassFactory();
                            return;
                        }
                        return;
                    } else {
                        switch (keyCode) {
                            case 85:
                                break;
                            case 86:
                                if ((MyBillsEntityDataFactory & 1) != 0) {
                                    callback.scheduleImpl();
                                    return;
                                }
                                return;
                            case 87:
                                if ((MyBillsEntityDataFactory & 32) != 0) {
                                    callback.lookAheadTest();
                                    return;
                                }
                                return;
                            case 88:
                                if ((MyBillsEntityDataFactory & 16) != 0) {
                                    callback.moveToNextValue();
                                    return;
                                }
                                return;
                            case 89:
                                if ((MyBillsEntityDataFactory & 8) != 0) {
                                    callback.PlaceComponentResult();
                                    return;
                                }
                                return;
                            case 90:
                                if ((MyBillsEntityDataFactory & 64) != 0) {
                                    callback.getAuthRequestContext();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
                InstrumentInjector.log_w("MediaSessionCompat", "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
            }
        }
    }

    /* loaded from: classes6.dex */
    static class MediaSessionImplApi18 extends MediaSessionImplBase {

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass1 implements RemoteControlClient.OnPlaybackPositionUpdateListener {
            final /* synthetic */ MediaSessionImplApi18 KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
            public void onPlaybackPositionUpdate(long j) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(18, -1, -1, Long.valueOf(j), null);
            }
        }
    }

    /* loaded from: classes6.dex */
    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass1 implements RemoteControlClient.OnMetadataUpdateListener {
            final /* synthetic */ MediaSessionImplApi19 MyBillsEntityDataFactory;

            @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
            public void onMetadataUpdate(int i, Object obj) {
                if (i == 268435457 && (obj instanceof Rating)) {
                    this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(19, -1, -1, RatingCompat.PlaceComponentResult(obj), null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    static class MediaSessionImplApi21 implements MediaSessionImpl {
        boolean BuiltInFictitiousFunctionClassFactory;
        final Token GetContactSyncConfig;
        MediaMetadataCompat KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        List<QueueItem> NetworkUserEntityData$$ExternalSyntheticLambda0;
        final RemoteCallbackList<IMediaControllerCallback> PlaceComponentResult;
        PlaybackStateCompat getAuthRequestContext;
        final Object getErrorConfigVersion;
        int lookAheadTest;
        int moveToNextValue;
        int scheduleImpl;

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo MyBillsEntityDataFactory() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void PlaceComponentResult(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }

        public Token getAuthRequestContext() {
            return this.GetContactSyncConfig;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat PlaceComponentResult() {
            return this.getAuthRequestContext;
        }

        public String BuiltInFictitiousFunctionClassFactory() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return MediaSessionCompatApi24.MyBillsEntityDataFactory(this.getErrorConfigVersion);
        }

        /* loaded from: classes6.dex */
        class ExtraSession extends IMediaSession.Stub {
            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
            }

            ExtraSession() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                if (MediaSessionImplApi21.this.MyBillsEntityDataFactory) {
                    return;
                }
                String BuiltInFictitiousFunctionClassFactory = MediaSessionImplApi21.this.BuiltInFictitiousFunctionClassFactory();
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    BuiltInFictitiousFunctionClassFactory = "android.media.session.MediaController";
                }
                MediaSessionImplApi21.this.PlaceComponentResult.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(BuiltInFictitiousFunctionClassFactory, getCallingPid(), getCallingUid()));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21.this.PlaceComponentResult.unregister(iMediaControllerCallback);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i, int i2, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i, int i2, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionCompat.getAuthRequestContext(MediaSessionImplApi21.this.getAuthRequestContext, MediaSessionImplApi21.this.KClassImpl$Data$declaredNonStaticMembers$2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return MediaSessionImplApi21.this.scheduleImpl;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return MediaSessionImplApi21.this.BuiltInFictitiousFunctionClassFactory;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return MediaSessionImplApi21.this.moveToNextValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return MediaSessionImplApi21.this.lookAheadTest;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }
        }
    }

    /* loaded from: classes6.dex */
    static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void PlaceComponentResult(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public final MediaSessionManager.RemoteUserInfo MyBillsEntityDataFactory() {
            return new MediaSessionManager.RemoteUserInfo(((MediaSession) this.getErrorConfigVersion).getCurrentControllerInfo());
        }
    }
}
