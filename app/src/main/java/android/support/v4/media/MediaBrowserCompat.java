package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi23;
import android.support.v4.media.MediaBrowserCompatApi26;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserServiceCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public final class MediaBrowserCompat {
    static final boolean getAuthRequestContext = Log.isLoggable("MediaBrowserCompat", 3);
    private final MediaBrowserImpl BuiltInFictitiousFunctionClassFactory;

    /* loaded from: classes6.dex */
    public static abstract class CustomActionCallback {
        public void BuiltInFictitiousFunctionClassFactory(String str, Bundle bundle, Bundle bundle2) {
        }

        public void PlaceComponentResult(String str, Bundle bundle, Bundle bundle2) {
        }

        public void getAuthRequestContext(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* loaded from: classes6.dex */
    interface MediaBrowserImpl {
        void BuiltInFictitiousFunctionClassFactory();

        void getAuthRequestContext();

        MediaSessionCompat.Token moveToNextValue();
    }

    /* loaded from: classes6.dex */
    interface MediaBrowserServiceCallbackImpl {
        void BuiltInFictitiousFunctionClassFactory(Messenger messenger);

        void MyBillsEntityDataFactory(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void MyBillsEntityDataFactory(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);
    }

    /* loaded from: classes6.dex */
    public static abstract class SearchCallback {
        public void BuiltInFictitiousFunctionClassFactory(String str, Bundle bundle) {
        }

        public void PlaceComponentResult(String str, Bundle bundle, List<MediaItem> list) {
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.BuiltInFictitiousFunctionClassFactory = new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.BuiltInFictitiousFunctionClassFactory = new MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.BuiltInFictitiousFunctionClassFactory = new MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
        } else {
            this.BuiltInFictitiousFunctionClassFactory = new MediaBrowserImplBase(context, componentName, connectionCallback, bundle);
        }
    }

    public final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
    }

    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
    }

    public final MediaSessionCompat.Token KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory.moveToNextValue();
    }

    /* loaded from: classes6.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
            public final MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
            public final MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        private final int MyBillsEntityDataFactory;
        private final MediaDescriptionCompat PlaceComponentResult;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface Flags {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static MediaItem BuiltInFictitiousFunctionClassFactory(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.PlaceComponentResult(MediaBrowserCompatApi21.MediaItem.getAuthRequestContext(obj)), MediaBrowserCompatApi21.MediaItem.BuiltInFictitiousFunctionClassFactory(obj));
        }

        public static List<MediaItem> PlaceComponentResult(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(BuiltInFictitiousFunctionClassFactory(it.next()));
            }
            return arrayList;
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.BuiltInFictitiousFunctionClassFactory())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = mediaDescriptionCompat;
        }

        MediaItem(Parcel parcel) {
            this.MyBillsEntityDataFactory = parcel.readInt();
            this.PlaceComponentResult = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.MyBillsEntityDataFactory);
            this.PlaceComponentResult.writeToParcel(parcel, i);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", mDescription=");
            sb.append(this.PlaceComponentResult);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class ConnectionCallback {
        ConnectionCallbackInternal BuiltInFictitiousFunctionClassFactory;
        final Object MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public interface ConnectionCallbackInternal {
            void KClassImpl$Data$declaredNonStaticMembers$2();

            void MyBillsEntityDataFactory();

            void PlaceComponentResult();
        }

        public void BuiltInFictitiousFunctionClassFactory() {
        }

        public void PlaceComponentResult() {
        }

        public void getAuthRequestContext() {
        }

        public ConnectionCallback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.MyBillsEntityDataFactory = MediaBrowserCompatApi21.BuiltInFictitiousFunctionClassFactory((MediaBrowserCompatApi21.ConnectionCallback) new StubApi21());
            } else {
                this.MyBillsEntityDataFactory = null;
            }
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(ConnectionCallbackInternal connectionCallbackInternal) {
            this.BuiltInFictitiousFunctionClassFactory = connectionCallbackInternal;
        }

        /* loaded from: classes6.dex */
        class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
            StubApi21() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void getAuthRequestContext() {
                if (ConnectionCallback.this.BuiltInFictitiousFunctionClassFactory != null) {
                    ConnectionCallback.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
                }
                ConnectionCallback.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void BuiltInFictitiousFunctionClassFactory() {
                if (ConnectionCallback.this.BuiltInFictitiousFunctionClassFactory != null) {
                    ConnectionCallback.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                }
                ConnectionCallback.this.getAuthRequestContext();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void PlaceComponentResult() {
                if (ConnectionCallback.this.BuiltInFictitiousFunctionClassFactory != null) {
                    ConnectionCallback.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                ConnectionCallback.this.PlaceComponentResult();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class SubscriptionCallback {
        final Object MyBillsEntityDataFactory;
        final IBinder PlaceComponentResult = new Binder();
        WeakReference<Subscription> getAuthRequestContext;

        public void KClassImpl$Data$declaredNonStaticMembers$2(String str, List<MediaItem> list, Bundle bundle) {
        }

        public void MyBillsEntityDataFactory(String str, Bundle bundle) {
        }

        public void getAuthRequestContext(String str) {
        }

        public void getAuthRequestContext(String str, List<MediaItem> list) {
        }

        public SubscriptionCallback() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.MyBillsEntityDataFactory = MediaBrowserCompatApi26.MyBillsEntityDataFactory(new StubApi26());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.MyBillsEntityDataFactory = MediaBrowserCompatApi21.PlaceComponentResult((MediaBrowserCompatApi21.SubscriptionCallback) new StubApi21());
            } else {
                this.MyBillsEntityDataFactory = null;
            }
        }

        /* loaded from: classes6.dex */
        class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
            StubApi21() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void KClassImpl$Data$declaredNonStaticMembers$2(String str, List<?> list) {
                Subscription subscription = SubscriptionCallback.this.getAuthRequestContext == null ? null : SubscriptionCallback.this.getAuthRequestContext.get();
                if (subscription == null) {
                    SubscriptionCallback.this.getAuthRequestContext(str, MediaItem.PlaceComponentResult(list));
                    return;
                }
                List<MediaItem> PlaceComponentResult = MediaItem.PlaceComponentResult(list);
                List<SubscriptionCallback> BuiltInFictitiousFunctionClassFactory = subscription.BuiltInFictitiousFunctionClassFactory();
                List<Bundle> KClassImpl$Data$declaredNonStaticMembers$2 = subscription.KClassImpl$Data$declaredNonStaticMembers$2();
                for (int i = 0; i < BuiltInFictitiousFunctionClassFactory.size(); i++) {
                    Bundle bundle = KClassImpl$Data$declaredNonStaticMembers$2.get(i);
                    if (bundle == null) {
                        SubscriptionCallback.this.getAuthRequestContext(str, PlaceComponentResult);
                    } else {
                        SubscriptionCallback.this.KClassImpl$Data$declaredNonStaticMembers$2(str, PlaceComponentResult(PlaceComponentResult, bundle), bundle);
                    }
                }
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void getAuthRequestContext(String str) {
                SubscriptionCallback.this.getAuthRequestContext(str);
            }

            List<MediaItem> PlaceComponentResult(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i;
                int i4 = i3 + i2;
                if (i < 0 || i2 <= 0 || i3 >= list.size()) {
                    return Collections.emptyList();
                }
                if (i4 > list.size()) {
                    i4 = list.size();
                }
                return list.subList(i3, i4);
            }
        }

        /* loaded from: classes6.dex */
        class StubApi26 extends StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
            StubApi26() {
                super();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void PlaceComponentResult(String str, List<?> list, Bundle bundle) {
                SubscriptionCallback.this.KClassImpl$Data$declaredNonStaticMembers$2(str, MediaItem.PlaceComponentResult(list), bundle);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle) {
                SubscriptionCallback.this.MyBillsEntityDataFactory(str, bundle);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class ItemCallback {
        final Object MyBillsEntityDataFactory;

        public void MyBillsEntityDataFactory(MediaItem mediaItem) {
        }

        public void PlaceComponentResult(String str) {
        }

        public ItemCallback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.MyBillsEntityDataFactory = MediaBrowserCompatApi23.KClassImpl$Data$declaredNonStaticMembers$2(new StubApi23());
            } else {
                this.MyBillsEntityDataFactory = null;
            }
        }

        /* loaded from: classes6.dex */
        class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
            StubApi23() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void KClassImpl$Data$declaredNonStaticMembers$2(Parcel parcel) {
                if (parcel == null) {
                    ItemCallback.this.MyBillsEntityDataFactory(null);
                    return;
                }
                parcel.setDataPosition(0);
                MediaItem createFromParcel = MediaItem.CREATOR.createFromParcel(parcel);
                parcel.recycle();
                ItemCallback.this.MyBillsEntityDataFactory(createFromParcel);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void getAuthRequestContext(String str) {
                ItemCallback.this.PlaceComponentResult(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        final Context BuiltInFictitiousFunctionClassFactory;
        private String DatabaseTableConfigUtil;
        private MediaSessionCompat.Token GetContactSyncConfig;
        final ConnectionCallback MyBillsEntityDataFactory;
        private Bundle NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Bundle NetworkUserEntityData$$ExternalSyntheticLambda1;
        final Bundle PlaceComponentResult;
        Messenger getAuthRequestContext;
        MediaServiceConnection getErrorConfigVersion;
        final ComponentName lookAheadTest;
        ServiceBinderWrapper moveToNextValue;
        final CallbackHandler KClassImpl$Data$declaredNonStaticMembers$2 = new CallbackHandler(this);
        private final ArrayMap<String, Subscription> NetworkUserEntityData$$ExternalSyntheticLambda2 = new ArrayMap<>();
        int scheduleImpl = 1;

        public MediaBrowserImplBase(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (connectionCallback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.BuiltInFictitiousFunctionClassFactory = context;
            this.lookAheadTest = componentName;
            this.MyBillsEntityDataFactory = connectionCallback;
            this.PlaceComponentResult = bundle == null ? null : new Bundle(bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void BuiltInFictitiousFunctionClassFactory() {
            int i = this.scheduleImpl;
            if (i != 0 && i != 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("connect() called while neigther disconnecting nor disconnected (state=");
                sb.append(BuiltInFictitiousFunctionClassFactory(this.scheduleImpl));
                sb.append(")");
                throw new IllegalStateException(sb.toString());
            }
            this.scheduleImpl = 2;
            this.KClassImpl$Data$declaredNonStaticMembers$2.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserImplBase.this.scheduleImpl == 0) {
                        return;
                    }
                    MediaBrowserImplBase.this.scheduleImpl = 2;
                    if (MediaBrowserCompat.getAuthRequestContext && MediaBrowserImplBase.this.getErrorConfigVersion != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("mServiceConnection should be null. Instead it is ");
                        sb2.append(MediaBrowserImplBase.this.getErrorConfigVersion);
                        throw new RuntimeException(sb2.toString());
                    } else if (MediaBrowserImplBase.this.moveToNextValue != null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("mServiceBinderWrapper should be null. Instead it is ");
                        sb3.append(MediaBrowserImplBase.this.moveToNextValue);
                        throw new RuntimeException(sb3.toString());
                    } else if (MediaBrowserImplBase.this.getAuthRequestContext != null) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("mCallbacksMessenger should be null. Instead it is ");
                        sb4.append(MediaBrowserImplBase.this.getAuthRequestContext);
                        throw new RuntimeException(sb4.toString());
                    } else {
                        Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                        intent.setComponent(MediaBrowserImplBase.this.lookAheadTest);
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        mediaBrowserImplBase.getErrorConfigVersion = new MediaServiceConnection();
                        boolean z = false;
                        try {
                            z = MediaBrowserImplBase.this.BuiltInFictitiousFunctionClassFactory.bindService(intent, MediaBrowserImplBase.this.getErrorConfigVersion, 1);
                        } catch (Exception unused) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Failed binding to service ");
                            sb5.append(MediaBrowserImplBase.this.lookAheadTest);
                            InstrumentInjector.log_e("MediaBrowserCompat", sb5.toString());
                        }
                        if (!z) {
                            MediaBrowserImplBase.this.MyBillsEntityDataFactory();
                            MediaBrowserImplBase.this.MyBillsEntityDataFactory.PlaceComponentResult();
                        }
                        if (MediaBrowserCompat.getAuthRequestContext) {
                            InstrumentInjector.log_d("MediaBrowserCompat", "connect...");
                            MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getAuthRequestContext() {
            this.scheduleImpl = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserImplBase.this.getAuthRequestContext != null) {
                        try {
                            MediaBrowserImplBase.this.moveToNextValue.PlaceComponentResult(MediaBrowserImplBase.this.getAuthRequestContext);
                        } catch (RemoteException unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("RemoteException during connect for ");
                            sb.append(MediaBrowserImplBase.this.lookAheadTest);
                            InstrumentInjector.log_w("MediaBrowserCompat", sb.toString());
                        }
                    }
                    int i = MediaBrowserImplBase.this.scheduleImpl;
                    MediaBrowserImplBase.this.MyBillsEntityDataFactory();
                    if (i != 0) {
                        MediaBrowserImplBase.this.scheduleImpl = i;
                    }
                    if (MediaBrowserCompat.getAuthRequestContext) {
                        InstrumentInjector.log_d("MediaBrowserCompat", "disconnect...");
                        MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }
            });
        }

        void MyBillsEntityDataFactory() {
            MediaServiceConnection mediaServiceConnection = this.getErrorConfigVersion;
            if (mediaServiceConnection != null) {
                this.BuiltInFictitiousFunctionClassFactory.unbindService(mediaServiceConnection);
            }
            this.scheduleImpl = 1;
            this.getErrorConfigVersion = null;
            this.moveToNextValue = null;
            this.getAuthRequestContext = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(null);
            this.DatabaseTableConfigUtil = null;
            this.GetContactSyncConfig = null;
        }

        public boolean PlaceComponentResult() {
            return this.scheduleImpl == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token moveToNextValue() {
            if (!PlaceComponentResult()) {
                StringBuilder sb = new StringBuilder();
                sb.append("getSessionToken() called while not connected(state=");
                sb.append(this.scheduleImpl);
                sb.append(")");
                throw new IllegalStateException(sb.toString());
            }
            return this.GetContactSyncConfig;
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ ItemCallback BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ String getAuthRequestContext;

            @Override // java.lang.Runnable
            public void run() {
                this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.getAuthRequestContext);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$4  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ String PlaceComponentResult;
            final /* synthetic */ ItemCallback getAuthRequestContext;

            @Override // java.lang.Runnable
            public void run() {
                this.getAuthRequestContext.PlaceComponentResult(this.PlaceComponentResult);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$5  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ Bundle BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ SearchCallback MyBillsEntityDataFactory;
            final /* synthetic */ String getAuthRequestContext;

            @Override // java.lang.Runnable
            public void run() {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$6  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass6 implements Runnable {
            final /* synthetic */ Bundle KClassImpl$Data$declaredNonStaticMembers$2;
            final /* synthetic */ CustomActionCallback MyBillsEntityDataFactory;
            final /* synthetic */ String getAuthRequestContext;

            @Override // java.lang.Runnable
            public void run() {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, null);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void MyBillsEntityDataFactory(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (BuiltInFictitiousFunctionClassFactory(messenger, "onConnect")) {
                if (this.scheduleImpl != 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onConnect from service while mState=");
                    sb.append(BuiltInFictitiousFunctionClassFactory(this.scheduleImpl));
                    sb.append("... ignoring");
                    InstrumentInjector.log_w("MediaBrowserCompat", sb.toString());
                    return;
                }
                this.DatabaseTableConfigUtil = str;
                this.GetContactSyncConfig = token;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = bundle;
                this.scheduleImpl = 3;
                if (MediaBrowserCompat.getAuthRequestContext) {
                    InstrumentInjector.log_d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    KClassImpl$Data$declaredNonStaticMembers$2();
                }
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                try {
                    for (Map.Entry<String, Subscription> entry : this.NetworkUserEntityData$$ExternalSyntheticLambda2.entrySet()) {
                        String key = entry.getKey();
                        Subscription value = entry.getValue();
                        List<SubscriptionCallback> BuiltInFictitiousFunctionClassFactory = value.BuiltInFictitiousFunctionClassFactory();
                        List<Bundle> KClassImpl$Data$declaredNonStaticMembers$2 = value.KClassImpl$Data$declaredNonStaticMembers$2();
                        for (int i = 0; i < BuiltInFictitiousFunctionClassFactory.size(); i++) {
                            this.moveToNextValue.PlaceComponentResult(key, BuiltInFictitiousFunctionClassFactory.get(i).PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.get(i), this.getAuthRequestContext);
                        }
                    }
                } catch (RemoteException unused) {
                    InstrumentInjector.log_d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void BuiltInFictitiousFunctionClassFactory(Messenger messenger) {
            StringBuilder sb = new StringBuilder();
            sb.append("onConnectFailed for ");
            sb.append(this.lookAheadTest);
            InstrumentInjector.log_e("MediaBrowserCompat", sb.toString());
            if (BuiltInFictitiousFunctionClassFactory(messenger, "onConnectFailed")) {
                if (this.scheduleImpl != 2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onConnect from service while mState=");
                    sb2.append(BuiltInFictitiousFunctionClassFactory(this.scheduleImpl));
                    sb2.append("... ignoring");
                    InstrumentInjector.log_w("MediaBrowserCompat", sb2.toString());
                    return;
                }
                MyBillsEntityDataFactory();
                this.MyBillsEntityDataFactory.PlaceComponentResult();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void MyBillsEntityDataFactory(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (BuiltInFictitiousFunctionClassFactory(messenger, "onLoadChildren")) {
                if (MediaBrowserCompat.getAuthRequestContext) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onLoadChildren for ");
                    sb.append(this.lookAheadTest);
                    sb.append(" id=");
                    sb.append(str);
                    InstrumentInjector.log_d("MediaBrowserCompat", sb.toString());
                }
                Subscription subscription = this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(str);
                if (subscription == null) {
                    if (MediaBrowserCompat.getAuthRequestContext) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onLoadChildren for id that isn't subscribed id=");
                        sb2.append(str);
                        InstrumentInjector.log_d("MediaBrowserCompat", sb2.toString());
                        return;
                    }
                    return;
                }
                SubscriptionCallback authRequestContext = subscription.getAuthRequestContext(bundle);
                if (authRequestContext != null) {
                    if (bundle == null) {
                        if (list == null) {
                            authRequestContext.getAuthRequestContext(str);
                            return;
                        }
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = bundle2;
                        authRequestContext.getAuthRequestContext(str, list);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
                    } else if (list == null) {
                        authRequestContext.MyBillsEntityDataFactory(str, bundle);
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = bundle2;
                        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str, list, bundle);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
                    }
                }
            }
        }

        private static String BuiltInFictitiousFunctionClassFactory(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("UNKNOWN/");
                                sb.append(i);
                                return sb.toString();
                            }
                            return "CONNECT_STATE_SUSPENDED";
                        }
                        return "CONNECT_STATE_CONNECTED";
                    }
                    return "CONNECT_STATE_CONNECTING";
                }
                return "CONNECT_STATE_DISCONNECTED";
            }
            return "CONNECT_STATE_DISCONNECTING";
        }

        private boolean BuiltInFictitiousFunctionClassFactory(Messenger messenger, String str) {
            int i;
            if (this.getAuthRequestContext != messenger || (i = this.scheduleImpl) == 0 || i == 1) {
                int i2 = this.scheduleImpl;
                if (i2 == 0 || i2 == 1) {
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" for ");
                sb.append(this.lookAheadTest);
                sb.append(" with mCallbacksMessenger=");
                sb.append(this.getAuthRequestContext);
                sb.append(" this=");
                sb.append(this);
                InstrumentInjector.log_i("MediaBrowserCompat", sb.toString());
                return false;
            }
            return true;
        }

        void KClassImpl$Data$declaredNonStaticMembers$2() {
            InstrumentInjector.log_d("MediaBrowserCompat", "MediaBrowserCompat...");
            StringBuilder sb = new StringBuilder();
            sb.append("  mServiceComponent=");
            sb.append(this.lookAheadTest);
            InstrumentInjector.log_d("MediaBrowserCompat", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  mCallback=");
            sb2.append(this.MyBillsEntityDataFactory);
            InstrumentInjector.log_d("MediaBrowserCompat", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  mRootHints=");
            sb3.append(this.PlaceComponentResult);
            InstrumentInjector.log_d("MediaBrowserCompat", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("  mState=");
            sb4.append(BuiltInFictitiousFunctionClassFactory(this.scheduleImpl));
            InstrumentInjector.log_d("MediaBrowserCompat", sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("  mServiceConnection=");
            sb5.append(this.getErrorConfigVersion);
            InstrumentInjector.log_d("MediaBrowserCompat", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("  mServiceBinderWrapper=");
            sb6.append(this.moveToNextValue);
            InstrumentInjector.log_d("MediaBrowserCompat", sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("  mCallbacksMessenger=");
            sb7.append(this.getAuthRequestContext);
            InstrumentInjector.log_d("MediaBrowserCompat", sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("  mRootId=");
            sb8.append(this.DatabaseTableConfigUtil);
            InstrumentInjector.log_d("MediaBrowserCompat", sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("  mMediaSessionToken=");
            sb9.append(this.GetContactSyncConfig);
            InstrumentInjector.log_d("MediaBrowserCompat", sb9.toString());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes6.dex */
        public class MediaServiceConnection implements ServiceConnection {
            public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {36, -25, -14, -85, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
            public static final int getAuthRequestContext = 26;

            /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0037). Please submit an issue!!! */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private static void a(short r6, byte r7, byte r8, java.lang.Object[] r9) {
                /*
                    int r6 = r6 + 4
                    int r8 = r8 * 7
                    int r8 = r8 + 99
                    int r7 = r7 * 3
                    int r7 = 16 - r7
                    byte[] r0 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.KClassImpl$Data$declaredNonStaticMembers$2
                    byte[] r1 = new byte[r7]
                    int r7 = r7 + (-1)
                    r2 = 0
                    if (r0 != 0) goto L1b
                    r8 = r7
                    r3 = r1
                    r4 = 0
                    r7 = r6
                    r1 = r0
                    r0 = r9
                    r9 = r8
                    goto L37
                L1b:
                    r3 = 0
                L1c:
                    byte r4 = (byte) r8
                    r1[r3] = r4
                    if (r3 != r7) goto L29
                    java.lang.String r6 = new java.lang.String
                    r6.<init>(r1, r2)
                    r9[r2] = r6
                    return
                L29:
                    int r6 = r6 + 1
                    r4 = r0[r6]
                    int r3 = r3 + 1
                    r5 = r7
                    r7 = r6
                    r6 = r4
                    r4 = r3
                    r3 = r1
                    r1 = r0
                    r0 = r9
                    r9 = r5
                L37:
                    int r6 = -r6
                    int r8 = r8 + r6
                    int r8 = r8 + 2
                    r6 = r7
                    r7 = r9
                    r9 = r0
                    r0 = r1
                    r1 = r3
                    r3 = r4
                    goto L1c
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.a(short, byte, byte, java.lang.Object[]):void");
            }

            MediaServiceConnection() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                KClassImpl$Data$declaredNonStaticMembers$2(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.getAuthRequestContext) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("MediaServiceConnection.onServiceConnected name=");
                            sb.append(componentName);
                            sb.append(" binder=");
                            sb.append(iBinder);
                            InstrumentInjector.log_d("MediaBrowserCompat", sb.toString());
                            MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                        if (MediaServiceConnection.this.PlaceComponentResult("onServiceConnected")) {
                            MediaBrowserImplBase.this.moveToNextValue = new ServiceBinderWrapper(iBinder, MediaBrowserImplBase.this.PlaceComponentResult);
                            MediaBrowserImplBase.this.getAuthRequestContext = new Messenger(MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2);
                            MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(MediaBrowserImplBase.this.getAuthRequestContext);
                            MediaBrowserImplBase.this.scheduleImpl = 2;
                            try {
                                if (MediaBrowserCompat.getAuthRequestContext) {
                                    InstrumentInjector.log_d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2();
                                }
                                MediaBrowserImplBase.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(MediaBrowserImplBase.this.BuiltInFictitiousFunctionClassFactory, MediaBrowserImplBase.this.getAuthRequestContext);
                            } catch (RemoteException unused) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("RemoteException during connect for ");
                                sb2.append(MediaBrowserImplBase.this.lookAheadTest);
                                InstrumentInjector.log_w("MediaBrowserCompat", sb2.toString());
                                if (MediaBrowserCompat.getAuthRequestContext) {
                                    InstrumentInjector.log_d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2();
                                }
                            }
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName componentName) {
                KClassImpl$Data$declaredNonStaticMembers$2(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.getAuthRequestContext) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("MediaServiceConnection.onServiceDisconnected name=");
                            sb.append(componentName);
                            sb.append(" this=");
                            sb.append(this);
                            sb.append(" mServiceConnection=");
                            sb.append(MediaBrowserImplBase.this.getErrorConfigVersion);
                            InstrumentInjector.log_d("MediaBrowserCompat", sb.toString());
                            MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                        if (MediaServiceConnection.this.PlaceComponentResult("onServiceDisconnected")) {
                            MediaBrowserImplBase.this.moveToNextValue = null;
                            MediaBrowserImplBase.this.getAuthRequestContext = null;
                            MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(null);
                            MediaBrowserImplBase.this.scheduleImpl = 4;
                            MediaBrowserImplBase.this.MyBillsEntityDataFactory.getAuthRequestContext();
                        }
                    }
                });
            }

            private void KClassImpl$Data$declaredNonStaticMembers$2(Runnable runnable) {
                try {
                    Object[] objArr = new Object[1];
                    a(KClassImpl$Data$declaredNonStaticMembers$2[16], (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1), (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b = KClassImpl$Data$declaredNonStaticMembers$2[15];
                    byte b2 = (byte) (-b);
                    Object[] objArr2 = new Object[1];
                    a(b, b2, (byte) (b2 - 1), objArr2);
                    if (cls.getMethod((String) objArr2[0], null).invoke(null, null) == MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2.getLooper().getThread()) {
                        runnable.run();
                    } else {
                        MediaBrowserImplBase.this.KClassImpl$Data$declaredNonStaticMembers$2.post(runnable);
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }

            boolean PlaceComponentResult(String str) {
                if (MediaBrowserImplBase.this.getErrorConfigVersion != this || MediaBrowserImplBase.this.scheduleImpl == 0 || MediaBrowserImplBase.this.scheduleImpl == 1) {
                    if (MediaBrowserImplBase.this.scheduleImpl == 0 || MediaBrowserImplBase.this.scheduleImpl == 1) {
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" for ");
                    sb.append(MediaBrowserImplBase.this.lookAheadTest);
                    sb.append(" with mServiceConnection=");
                    sb.append(MediaBrowserImplBase.this.getErrorConfigVersion);
                    sb.append(" this=");
                    sb.append(this);
                    InstrumentInjector.log_i("MediaBrowserCompat", sb.toString());
                    return false;
                }
                return true;
            }
        }
    }

    /* loaded from: classes6.dex */
    static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        protected final Object BuiltInFictitiousFunctionClassFactory;
        protected final Bundle KClassImpl$Data$declaredNonStaticMembers$2;
        protected Messenger MyBillsEntityDataFactory;
        protected int NetworkUserEntityData$$ExternalSyntheticLambda0;
        final Context getAuthRequestContext;
        protected ServiceBinderWrapper getErrorConfigVersion;
        private MediaSessionCompat.Token lookAheadTest;
        private Bundle moveToNextValue;
        protected final CallbackHandler PlaceComponentResult = new CallbackHandler(this);
        private final ArrayMap<String, Subscription> scheduleImpl = new ArrayMap<>();

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void BuiltInFictitiousFunctionClassFactory(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void MyBillsEntityDataFactory(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            this.getAuthRequestContext = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle2;
            bundle2.putInt("extra_client_version", 1);
            connectionCallback.KClassImpl$Data$declaredNonStaticMembers$2(this);
            this.BuiltInFictitiousFunctionClassFactory = MediaBrowserCompatApi21.getAuthRequestContext(context, componentName, connectionCallback.MyBillsEntityDataFactory, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void BuiltInFictitiousFunctionClassFactory() {
            MediaBrowserCompatApi21.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getAuthRequestContext() {
            Messenger messenger;
            ServiceBinderWrapper serviceBinderWrapper = this.getErrorConfigVersion;
            if (serviceBinderWrapper != null && (messenger = this.MyBillsEntityDataFactory) != null) {
                try {
                    serviceBinderWrapper.getAuthRequestContext(messenger);
                } catch (RemoteException unused) {
                    InstrumentInjector.log_i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            MediaBrowserCompatApi21.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token moveToNextValue() {
            MediaSessionCompat.Token PlaceComponentResult;
            if (this.lookAheadTest == null) {
                PlaceComponentResult = MediaSessionCompat.Token.PlaceComponentResult(MediaBrowserCompatApi21.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory), null);
                this.lookAheadTest = PlaceComponentResult;
            }
            return this.lookAheadTest;
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ ItemCallback BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // java.lang.Runnable
            public void run() {
                this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$2  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ ItemCallback BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // java.lang.Runnable
            public void run() {
                this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$3  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ ItemCallback MyBillsEntityDataFactory;
            final /* synthetic */ String getAuthRequestContext;

            @Override // java.lang.Runnable
            public void run() {
                this.MyBillsEntityDataFactory.PlaceComponentResult(this.getAuthRequestContext);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$4  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
            final /* synthetic */ Bundle PlaceComponentResult;
            final /* synthetic */ SearchCallback getAuthRequestContext;

            @Override // java.lang.Runnable
            public void run() {
                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$5  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ SearchCallback BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ String PlaceComponentResult;
            final /* synthetic */ Bundle getAuthRequestContext;

            @Override // java.lang.Runnable
            public void run() {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.getAuthRequestContext);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$6  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass6 implements Runnable {
            final /* synthetic */ CustomActionCallback BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ String MyBillsEntityDataFactory;
            final /* synthetic */ Bundle getAuthRequestContext;

            @Override // java.lang.Runnable
            public void run() {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.getAuthRequestContext, null);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$7  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass7 implements Runnable {
            final /* synthetic */ CustomActionCallback BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ Bundle PlaceComponentResult;
            final /* synthetic */ String getAuthRequestContext;

            @Override // java.lang.Runnable
            public void run() {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.PlaceComponentResult, null);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void MyBillsEntityDataFactory() {
            Bundle authRequestContext = MediaBrowserCompatApi21.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
            if (authRequestContext == null) {
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = authRequestContext.getInt("extra_service_version", 0);
            IBinder BuiltInFictitiousFunctionClassFactory = BundleCompat.BuiltInFictitiousFunctionClassFactory(authRequestContext, "extra_messenger");
            if (BuiltInFictitiousFunctionClassFactory != null) {
                this.getErrorConfigVersion = new ServiceBinderWrapper(BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                Messenger messenger = new Messenger(this.PlaceComponentResult);
                this.MyBillsEntityDataFactory = messenger;
                this.PlaceComponentResult.getAuthRequestContext(messenger);
                try {
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
                } catch (RemoteException unused) {
                    InstrumentInjector.log_i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
            IMediaSession asInterface = IMediaSession.Stub.asInterface(BundleCompat.BuiltInFictitiousFunctionClassFactory(authRequestContext, "extra_session_binder"));
            if (asInterface != null) {
                this.lookAheadTest = MediaSessionCompat.Token.PlaceComponentResult(MediaBrowserCompatApi21.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory), asInterface);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void PlaceComponentResult() {
            this.getErrorConfigVersion = null;
            this.MyBillsEntityDataFactory = null;
            this.lookAheadTest = null;
            this.PlaceComponentResult.getAuthRequestContext(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void MyBillsEntityDataFactory(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.MyBillsEntityDataFactory != messenger) {
                return;
            }
            Subscription subscription = this.scheduleImpl.get(str);
            if (subscription == null) {
                if (MediaBrowserCompat.getAuthRequestContext) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onLoadChildren for id that isn't subscribed id=");
                    sb.append(str);
                    InstrumentInjector.log_d("MediaBrowserCompat", sb.toString());
                    return;
                }
                return;
            }
            SubscriptionCallback authRequestContext = subscription.getAuthRequestContext(bundle);
            if (authRequestContext != null) {
                if (bundle == null) {
                    if (list == null) {
                        authRequestContext.getAuthRequestContext(str);
                        return;
                    }
                    this.moveToNextValue = bundle2;
                    authRequestContext.getAuthRequestContext(str, list);
                    this.moveToNextValue = null;
                } else if (list == null) {
                    authRequestContext.MyBillsEntityDataFactory(str, bundle);
                } else {
                    this.moveToNextValue = bundle2;
                    authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str, list, bundle);
                    this.moveToNextValue = null;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
    }

    /* loaded from: classes6.dex */
    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
    }

    /* loaded from: classes6.dex */
    static class Subscription {
        private final List<SubscriptionCallback> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        private final List<Bundle> BuiltInFictitiousFunctionClassFactory = new ArrayList();

        public List<Bundle> KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public List<SubscriptionCallback> BuiltInFictitiousFunctionClassFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public SubscriptionCallback getAuthRequestContext(Bundle bundle) {
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory.size(); i++) {
                if (MediaBrowserCompatUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get(i), bundle)) {
                    return this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> BuiltInFictitiousFunctionClassFactory;
        private WeakReference<Messenger> MyBillsEntityDataFactory;

        CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<Messenger> weakReference = this.MyBillsEntityDataFactory;
            if (weakReference == null || weakReference.get() == null || this.BuiltInFictitiousFunctionClassFactory.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.PlaceComponentResult(data);
            MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.BuiltInFictitiousFunctionClassFactory.get();
            Messenger messenger = this.MyBillsEntityDataFactory.get();
            try {
                int i = message.what;
                if (i == 1) {
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.PlaceComponentResult(bundle);
                    mediaBrowserServiceCallbackImpl.MyBillsEntityDataFactory(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                } else if (i == 2) {
                    mediaBrowserServiceCallbackImpl.BuiltInFictitiousFunctionClassFactory(messenger);
                } else if (i == 3) {
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.PlaceComponentResult(bundle2);
                    Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                    MediaSessionCompat.PlaceComponentResult(bundle3);
                    mediaBrowserServiceCallbackImpl.MyBillsEntityDataFactory(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unhandled message: ");
                    sb.append(message);
                    sb.append("\n  Client version: ");
                    sb.append(1);
                    sb.append("\n  Service version: ");
                    sb.append(message.arg1);
                    InstrumentInjector.log_w("MediaBrowserCompat", sb.toString());
                }
            } catch (BadParcelableException unused) {
                InstrumentInjector.log_e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    mediaBrowserServiceCallbackImpl.BuiltInFictitiousFunctionClassFactory(messenger);
                }
            }
        }

        void getAuthRequestContext(Messenger messenger) {
            this.MyBillsEntityDataFactory = new WeakReference<>(messenger);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ServiceBinderWrapper {
        private Messenger KClassImpl$Data$declaredNonStaticMembers$2;
        private Bundle PlaceComponentResult;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new Messenger(iBinder);
            this.PlaceComponentResult = bundle;
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.PlaceComponentResult);
            PlaceComponentResult(1, bundle, messenger);
        }

        void PlaceComponentResult(Messenger messenger) throws RemoteException {
            PlaceComponentResult(2, null, messenger);
        }

        void PlaceComponentResult(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            BundleCompat.KClassImpl$Data$declaredNonStaticMembers$2(bundle2, "data_callback_token", iBinder);
            bundle2.putBundle("data_options", bundle);
            PlaceComponentResult(3, bundle2, messenger);
        }

        void MyBillsEntityDataFactory(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.PlaceComponentResult);
            PlaceComponentResult(6, bundle, messenger);
        }

        void getAuthRequestContext(Messenger messenger) throws RemoteException {
            PlaceComponentResult(7, null, messenger);
        }

        private void PlaceComponentResult(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.KClassImpl$Data$declaredNonStaticMembers$2.send(obtain);
        }
    }

    /* loaded from: classes6.dex */
    static class ItemReceiver extends ResultReceiver {
        private final ItemCallback KClassImpl$Data$declaredNonStaticMembers$2;
        private final String MyBillsEntityDataFactory;

        @Override // android.support.v4.os.ResultReceiver
        public void PlaceComponentResult(int i, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.MyBillsEntityDataFactory);
                return;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory((MediaItem) parcelable);
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.MyBillsEntityDataFactory);
            }
        }
    }

    /* loaded from: classes6.dex */
    static class SearchResultReceiver extends ResultReceiver {
        private final Bundle KClassImpl$Data$declaredNonStaticMembers$2;
        private final SearchCallback MyBillsEntityDataFactory;
        private final String scheduleImpl;

        @Override // android.support.v4.os.ResultReceiver
        public void PlaceComponentResult(int i, Bundle bundle) {
            MediaSessionCompat.PlaceComponentResult(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.MyBillsEntityDataFactory.PlaceComponentResult(this.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2, arrayList);
        }
    }

    /* loaded from: classes6.dex */
    static class CustomActionResultReceiver extends ResultReceiver {
        private final String KClassImpl$Data$declaredNonStaticMembers$2;
        private final CustomActionCallback MyBillsEntityDataFactory;
        private final Bundle lookAheadTest;

        @Override // android.support.v4.os.ResultReceiver
        public void PlaceComponentResult(int i, Bundle bundle) {
            if (this.MyBillsEntityDataFactory == null) {
                return;
            }
            MediaSessionCompat.PlaceComponentResult(bundle);
            if (i == -1) {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, bundle);
            } else if (i == 0) {
                this.MyBillsEntityDataFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, bundle);
            } else if (i == 1) {
                this.MyBillsEntityDataFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, bundle);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown result code: ");
                sb.append(i);
                sb.append(" (extras=");
                sb.append(this.lookAheadTest);
                sb.append(", resultData=");
                sb.append(bundle);
                sb.append(")");
                InstrumentInjector.log_w("MediaBrowserCompat", sb.toString());
            }
        }
    }
}
