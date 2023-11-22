package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;
import androidx.media.MediaBrowserServiceCompatApi26;
import androidx.media.MediaSessionManager;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    private MediaBrowserServiceImpl MyBillsEntityDataFactory;
    ConnectionRecord mCurConnection;
    MediaSessionCompat.Token mSession;
    static final String TAG = "MBServiceCompat";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap<>();
    final ServiceHandler mHandler = new ServiceHandler();

    /* loaded from: classes6.dex */
    interface MediaBrowserServiceImpl {
        Bundle BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        MediaSessionManager.RemoteUserInfo MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(MediaSessionCompat.Token token);

        IBinder PlaceComponentResult(Intent intent);

        void getAuthRequestContext();

        void getAuthRequestContext(String str, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface ServiceCallbacks {
        void BuiltInFictitiousFunctionClassFactory() throws RemoteException;

        void BuiltInFictitiousFunctionClassFactory(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        IBinder MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    public abstract BrowserRoot onGetRoot(String str, int i, Bundle bundle);

    public abstract void onLoadChildren(String str, Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onSubscribe(String str, Bundle bundle) {
    }

    public void onUnsubscribe(String str) {
    }

    /* loaded from: classes6.dex */
    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger PlaceComponentResult;

        MediaBrowserServiceImplBase() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void getAuthRequestContext() {
            this.PlaceComponentResult = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder PlaceComponentResult(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.PlaceComponentResult.getBinder();
            }
            return null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void MyBillsEntityDataFactory(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator<ConnectionRecord> it = MediaBrowserServiceCompat.this.mConnections.values().iterator();
                    while (it.hasNext()) {
                        ConnectionRecord next = it.next();
                        try {
                            next.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(next.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(), token, next.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext());
                        } catch (RemoteException unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Connection for ");
                            sb.append(next.MyBillsEntityDataFactory);
                            sb.append(" is no longer valid.");
                            InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb.toString());
                            it.remove();
                        }
                    }
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void getAuthRequestContext(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator<IBinder> it = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
                    while (it.hasNext()) {
                        MediaBrowserServiceImplBase.this.PlaceComponentResult(MediaBrowserServiceCompat.this.mConnections.get(it.next()), str, bundle);
                    }
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void KClassImpl$Data$declaredNonStaticMembers$2(final MediaSessionManager.RemoteUserInfo remoteUserInfo, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.3
                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.size(); i++) {
                        ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.moveToNextValue[(i << 1) + 1];
                        if (connectionRecord.KClassImpl$Data$declaredNonStaticMembers$2.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplBase.this.PlaceComponentResult(connectionRecord, str, bundle);
                            return;
                        }
                    }
                }
            });
        }

        void PlaceComponentResult(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list = connectionRecord.moveToNextValue.get(str);
            if (list != null) {
                for (Pair<IBinder, Bundle> pair : list) {
                    if (MediaBrowserCompatUtils.MyBillsEntityDataFactory(bundle, pair.PlaceComponentResult)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.PlaceComponentResult, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle BuiltInFictitiousFunctionClassFactory() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (MediaBrowserServiceCompat.this.mCurConnection.scheduleImpl == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.scheduleImpl);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo MyBillsEntityDataFactory() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return MediaBrowserServiceCompat.this.mCurConnection.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes6.dex */
    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        final List<Bundle> BuiltInFictitiousFunctionClassFactory = new ArrayList();
        Messenger KClassImpl$Data$declaredNonStaticMembers$2;
        Object PlaceComponentResult;

        MediaBrowserServiceImplApi21() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void getAuthRequestContext() {
            Object MyBillsEntityDataFactory = MediaBrowserServiceCompatApi21.MyBillsEntityDataFactory(MediaBrowserServiceCompat.this, this);
            this.PlaceComponentResult = MyBillsEntityDataFactory;
            MediaBrowserServiceCompatApi21.PlaceComponentResult(MyBillsEntityDataFactory);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder PlaceComponentResult(Intent intent) {
            return MediaBrowserServiceCompatApi21.PlaceComponentResult(this.PlaceComponentResult, intent);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void MyBillsEntityDataFactory(final MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!MediaBrowserServiceImplApi21.this.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                        IMediaSession MyBillsEntityDataFactory = token.MyBillsEntityDataFactory();
                        if (MyBillsEntityDataFactory != null) {
                            Iterator<Bundle> it = MediaBrowserServiceImplApi21.this.BuiltInFictitiousFunctionClassFactory.iterator();
                            while (it.hasNext()) {
                                BundleCompat.KClassImpl$Data$declaredNonStaticMembers$2(it.next(), "extra_session_binder", MyBillsEntityDataFactory.asBinder());
                            }
                        }
                        MediaBrowserServiceImplApi21.this.BuiltInFictitiousFunctionClassFactory.clear();
                    }
                    MediaBrowserServiceCompatApi21.getAuthRequestContext(MediaBrowserServiceImplApi21.this.PlaceComponentResult, token.KClassImpl$Data$declaredNonStaticMembers$2());
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void getAuthRequestContext(String str, Bundle bundle) {
            KClassImpl$Data$declaredNonStaticMembers$2(str, bundle);
            PlaceComponentResult(str, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void KClassImpl$Data$declaredNonStaticMembers$2(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            BuiltInFictitiousFunctionClassFactory(remoteUserInfo, str, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot getAuthRequestContext(String str, int i, Bundle bundle) {
            Bundle bundle2;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                BundleCompat.KClassImpl$Data$declaredNonStaticMembers$2(bundle2, "extra_messenger", this.KClassImpl$Data$declaredNonStaticMembers$2.getBinder());
                if (MediaBrowserServiceCompat.this.mSession != null) {
                    IMediaSession MyBillsEntityDataFactory = MediaBrowserServiceCompat.this.mSession.MyBillsEntityDataFactory();
                    BundleCompat.KClassImpl$Data$declaredNonStaticMembers$2(bundle2, "extra_session_binder", MyBillsEntityDataFactory == null ? null : MyBillsEntityDataFactory.asBinder());
                } else {
                    this.BuiltInFictitiousFunctionClassFactory.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.mCurConnection = new ConnectionRecord(str, -1, i, bundle, null);
            BrowserRoot onGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            MediaBrowserServiceCompat.this.mCurConnection = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getAuthRequestContext();
            } else if (onGetRoot.getAuthRequestContext() != null) {
                bundle2.putAll(onGetRoot.getAuthRequestContext());
            }
            return new MediaBrowserServiceCompatApi21.BrowserRoot(onGetRoot.KClassImpl$Data$declaredNonStaticMembers$2(), bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void KClassImpl$Data$declaredNonStaticMembers$2(String str, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                public void PlaceComponentResult(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.KClassImpl$Data$declaredNonStaticMembers$2((MediaBrowserServiceCompatApi21.ResultWrapper) arrayList);
                }
            });
        }

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle) {
            MediaBrowserServiceCompatApi21.PlaceComponentResult(this.PlaceComponentResult, str);
        }

        void PlaceComponentResult(final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.3
                @Override // java.lang.Runnable
                public void run() {
                    Iterator<IBinder> it = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
                    while (it.hasNext()) {
                        MediaBrowserServiceImplApi21.this.PlaceComponentResult(MediaBrowserServiceCompat.this.mConnections.get(it.next()), str, bundle);
                    }
                }
            });
        }

        void BuiltInFictitiousFunctionClassFactory(final MediaSessionManager.RemoteUserInfo remoteUserInfo, final String str, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.4
                @Override // java.lang.Runnable
                public void run() {
                    for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.size(); i++) {
                        ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.moveToNextValue[(i << 1) + 1];
                        if (connectionRecord.KClassImpl$Data$declaredNonStaticMembers$2.equals(remoteUserInfo)) {
                            MediaBrowserServiceImplApi21.this.PlaceComponentResult(connectionRecord, str, bundle);
                        }
                    }
                }
            });
        }

        void PlaceComponentResult(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list = connectionRecord.moveToNextValue.get(str);
            if (list != null) {
                for (Pair<IBinder, Bundle> pair : list) {
                    if (MediaBrowserCompatUtils.MyBillsEntityDataFactory(bundle, pair.PlaceComponentResult)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.PlaceComponentResult, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle BuiltInFictitiousFunctionClassFactory() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (MediaBrowserServiceCompat.this.mCurConnection.scheduleImpl != null) {
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.scheduleImpl);
            }
            return null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo MyBillsEntityDataFactory() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return MediaBrowserServiceCompat.this.mCurConnection.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes6.dex */
    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        MediaBrowserServiceImplApi23() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void getAuthRequestContext() {
            this.PlaceComponentResult = MediaBrowserServiceCompatApi23.BuiltInFictitiousFunctionClassFactory(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.PlaceComponentResult(this.PlaceComponentResult);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void BuiltInFictitiousFunctionClassFactory(String str, final MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
                public void PlaceComponentResult(MediaBrowserCompat.MediaItem mediaItem) {
                    if (mediaItem == null) {
                        resultWrapper.KClassImpl$Data$declaredNonStaticMembers$2((MediaBrowserServiceCompatApi21.ResultWrapper) null);
                        return;
                    }
                    Parcel obtain = Parcel.obtain();
                    mediaItem.writeToParcel(obtain, 0);
                    resultWrapper.KClassImpl$Data$declaredNonStaticMembers$2((MediaBrowserServiceCompatApi21.ResultWrapper) obtain);
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        MediaBrowserServiceImplApi26() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void getAuthRequestContext() {
            this.PlaceComponentResult = MediaBrowserServiceCompatApi26.getAuthRequestContext(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.PlaceComponentResult(this.PlaceComponentResult);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void PlaceComponentResult(String str, final MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
                public void PlaceComponentResult(List<MediaBrowserCompat.MediaItem> list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (MediaBrowserCompat.MediaItem mediaItem : list) {
                            Parcel obtain = Parcel.obtain();
                            mediaItem.writeToParcel(obtain, 0);
                            arrayList.add(obtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.PlaceComponentResult(arrayList, KClassImpl$Data$declaredNonStaticMembers$2());
                }
            }, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle BuiltInFictitiousFunctionClassFactory() {
            Bundle browserRootHints;
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                browserRootHints = ((MediaBrowserService) this.PlaceComponentResult).getBrowserRootHints();
                return browserRootHints;
            } else if (MediaBrowserServiceCompat.this.mCurConnection.scheduleImpl == null) {
                return null;
            } else {
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.scheduleImpl);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        void KClassImpl$Data$declaredNonStaticMembers$2(String str, Bundle bundle) {
            if (bundle != null) {
                MediaBrowserServiceCompatApi26.PlaceComponentResult(this.PlaceComponentResult, str, bundle);
            } else {
                super.KClassImpl$Data$declaredNonStaticMembers$2(str, bundle);
            }
        }
    }

    /* loaded from: classes6.dex */
    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        MediaBrowserServiceImplApi28() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo MyBillsEntityDataFactory() {
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                return MediaBrowserServiceCompat.this.mCurConnection.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.PlaceComponentResult).getCurrentBrowserInfo());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class ServiceHandler extends Handler {
        public static final byte[] BuiltInFictitiousFunctionClassFactory = {8, -125, -40, -38, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int PlaceComponentResult = 234;
        private final ServiceBinderImpl getAuthRequestContext;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0036). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r6, byte r7, int r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 12
                int r8 = 16 - r8
                int r7 = r7 * 3
                int r7 = r7 + 13
                int r6 = r6 * 7
                int r6 = 106 - r6
                byte[] r0 = androidx.media.MediaBrowserServiceCompat.ServiceHandler.BuiltInFictitiousFunctionClassFactory
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L1b
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L36
            L1b:
                r3 = 0
                r5 = r8
                r8 = r6
                r6 = r5
            L1f:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r7) goto L2e
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2e:
                r3 = r0[r6]
                r5 = r9
                r9 = r6
                r6 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L36:
                int r6 = -r6
                int r8 = r8 + r6
                int r8 = r8 + 2
                int r6 = r9 + 1
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1f
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media.MediaBrowserServiceCompat.ServiceHandler.a(int, byte, int, java.lang.Object[]):void");
        }

        ServiceHandler() {
            this.getAuthRequestContext = new ServiceBinderImpl();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.PlaceComponentResult(bundle);
                    this.getAuthRequestContext.getAuthRequestContext(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 2:
                    this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.PlaceComponentResult(bundle2);
                    this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(data.getString("data_media_item_id"), BundleCompat.BuiltInFictitiousFunctionClassFactory(data, "data_callback_token"), bundle2, new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 4:
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(data.getString("data_media_item_id"), BundleCompat.BuiltInFictitiousFunctionClassFactory(data, "data_callback_token"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 5:
                    this.getAuthRequestContext.getAuthRequestContext(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.PlaceComponentResult(bundle3);
                    this.getAuthRequestContext.MyBillsEntityDataFactory(new ServiceCallbacksCompat(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    return;
                case 7:
                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.PlaceComponentResult(bundle4);
                    this.getAuthRequestContext.PlaceComponentResult(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.PlaceComponentResult(bundle5);
                    this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    return;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unhandled message: ");
                    sb.append(message);
                    sb.append("\n  Service version: ");
                    sb.append(2);
                    sb.append("\n  Client version: ");
                    sb.append(message.arg1);
                    InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb.toString());
                    return;
            }
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }

        public final void BuiltInFictitiousFunctionClassFactory(Runnable runnable) {
            try {
                byte b = (byte) (BuiltInFictitiousFunctionClassFactory[15] + 1);
                byte b2 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[15]);
                Object[] objArr2 = new Object[1];
                a(b3, (byte) (b3 - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[15]), objArr2);
                if (cls.getMethod((String) objArr2[0], null).invoke(null, null) == getLooper().getThread()) {
                    runnable.run();
                } else {
                    post(runnable);
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ConnectionRecord implements IBinder.DeathRecipient {
        public BrowserRoot BuiltInFictitiousFunctionClassFactory;
        public final MediaSessionManager.RemoteUserInfo KClassImpl$Data$declaredNonStaticMembers$2;
        public final String MyBillsEntityDataFactory;
        public final ServiceCallbacks PlaceComponentResult;
        public final int getAuthRequestContext;
        public final int getErrorConfigVersion;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> moveToNextValue = new HashMap<>();
        public final Bundle scheduleImpl;

        ConnectionRecord(String str, int i, int i2, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.MyBillsEntityDataFactory = str;
            this.getAuthRequestContext = i;
            this.getErrorConfigVersion = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new MediaSessionManager.RemoteUserInfo(str, i, i2);
            this.scheduleImpl = bundle;
            this.PlaceComponentResult = serviceCallbacks;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ConnectionRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserServiceCompat.this.mConnections.remove(ConnectionRecord.this.PlaceComponentResult.MyBillsEntityDataFactory());
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static class Result<T> {
        private int BuiltInFictitiousFunctionClassFactory;
        private boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final Object MyBillsEntityDataFactory;
        private boolean PlaceComponentResult;
        private boolean getAuthRequestContext;

        void PlaceComponentResult(T t) {
        }

        Result(Object obj) {
            this.MyBillsEntityDataFactory = obj;
        }

        public void MyBillsEntityDataFactory(T t) {
            if (this.getAuthRequestContext || this.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendResult() called when either sendResult() or sendError() had already been called for: ");
                sb.append(this.MyBillsEntityDataFactory);
                throw new IllegalStateException(sb.toString());
            }
            this.getAuthRequestContext = true;
            PlaceComponentResult((Result<T>) t);
        }

        public void MyBillsEntityDataFactory(Bundle bundle) {
            if (this.getAuthRequestContext || this.PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("sendError() called when either sendResult() or sendError() had already been called for: ");
                sb.append(this.MyBillsEntityDataFactory);
                throw new IllegalStateException(sb.toString());
            }
            this.PlaceComponentResult = true;
            PlaceComponentResult(bundle);
        }

        boolean getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 || this.getAuthRequestContext || this.PlaceComponentResult;
        }

        void getAuthRequestContext(int i) {
            this.BuiltInFictitiousFunctionClassFactory = i;
        }

        int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        void PlaceComponentResult(Bundle bundle) {
            StringBuilder sb = new StringBuilder();
            sb.append("It is not supported to send an error for ");
            sb.append(this.MyBillsEntityDataFactory);
            throw new UnsupportedOperationException(sb.toString());
        }
    }

    /* loaded from: classes6.dex */
    class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void getAuthRequestContext(final String str, final int i, final int i2, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
            if (!MediaBrowserServiceCompat.this.isValidPackage(str, i2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Package/uid mismatch: uid=");
                sb.append(i2);
                sb.append(" package=");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    IBinder MyBillsEntityDataFactory = serviceCallbacks.MyBillsEntityDataFactory();
                    MediaBrowserServiceCompat.this.mConnections.remove(MyBillsEntityDataFactory);
                    ConnectionRecord connectionRecord = new ConnectionRecord(str, i, i2, bundle, serviceCallbacks);
                    MediaBrowserServiceCompat.this.mCurConnection = connectionRecord;
                    connectionRecord.BuiltInFictitiousFunctionClassFactory = MediaBrowserServiceCompat.this.onGetRoot(str, i2, bundle);
                    MediaBrowserServiceCompat.this.mCurConnection = null;
                    if (connectionRecord.BuiltInFictitiousFunctionClassFactory == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("No root for client ");
                        sb2.append(str);
                        sb2.append(" from service ");
                        sb2.append(getClass().getName());
                        InstrumentInjector.log_i(MediaBrowserServiceCompat.TAG, sb2.toString());
                        try {
                            serviceCallbacks.BuiltInFictitiousFunctionClassFactory();
                            return;
                        } catch (RemoteException unused) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Calling onConnectFailed() failed. Ignoring. pkg=");
                            sb3.append(str);
                            InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb3.toString());
                            return;
                        }
                    }
                    try {
                        MediaBrowserServiceCompat.this.mConnections.put(MyBillsEntityDataFactory, connectionRecord);
                        MyBillsEntityDataFactory.linkToDeath(connectionRecord, 0);
                        if (MediaBrowserServiceCompat.this.mSession != null) {
                            serviceCallbacks.BuiltInFictitiousFunctionClassFactory(connectionRecord.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(), MediaBrowserServiceCompat.this.mSession, connectionRecord.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext());
                        }
                    } catch (RemoteException unused2) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Calling onConnect() failed. Dropping client. pkg=");
                        sb4.append(str);
                        InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb4.toString());
                        MediaBrowserServiceCompat.this.mConnections.remove(MyBillsEntityDataFactory);
                    }
                }
            });
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.mConnections.remove(serviceCallbacks.MyBillsEntityDataFactory());
                    if (remove != null) {
                        remove.PlaceComponentResult.MyBillsEntityDataFactory().unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(final String str, final IBinder iBinder, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.MyBillsEntityDataFactory());
                    if (connectionRecord == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("addSubscription for callback that isn't registered id=");
                        sb.append(str);
                        InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb.toString());
                        return;
                    }
                    MediaBrowserServiceCompat.this.addSubscription(str, connectionRecord, iBinder, bundle);
                }
            });
        }

        public void BuiltInFictitiousFunctionClassFactory(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.MyBillsEntityDataFactory());
                    if (connectionRecord == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("removeSubscription for callback that isn't registered id=");
                        sb.append(str);
                        InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb.toString());
                    } else if (MediaBrowserServiceCompat.this.removeSubscription(str, connectionRecord, iBinder)) {
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("removeSubscription called for ");
                        sb2.append(str);
                        sb2.append(" which is not subscribed");
                        InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb2.toString());
                    }
                }
            });
        }

        public void getAuthRequestContext(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.MyBillsEntityDataFactory());
                    if (connectionRecord == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("getMediaItem for callback that isn't registered id=");
                        sb.append(str);
                        InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb.toString());
                        return;
                    }
                    MediaBrowserServiceCompat.this.performLoadItem(str, connectionRecord, resultReceiver);
                }
            });
        }

        public void MyBillsEntityDataFactory(final ServiceCallbacks serviceCallbacks, final String str, final int i, final int i2, final Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    IBinder MyBillsEntityDataFactory = serviceCallbacks.MyBillsEntityDataFactory();
                    MediaBrowserServiceCompat.this.mConnections.remove(MyBillsEntityDataFactory);
                    ConnectionRecord connectionRecord = new ConnectionRecord(str, i, i2, bundle, serviceCallbacks);
                    MediaBrowserServiceCompat.this.mConnections.put(MyBillsEntityDataFactory, connectionRecord);
                    try {
                        MyBillsEntityDataFactory.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, "IBinder is already dead.");
                    }
                }
            });
        }

        public void BuiltInFictitiousFunctionClassFactory(final ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    IBinder MyBillsEntityDataFactory = serviceCallbacks.MyBillsEntityDataFactory();
                    ConnectionRecord remove = MediaBrowserServiceCompat.this.mConnections.remove(MyBillsEntityDataFactory);
                    if (remove != null) {
                        MyBillsEntityDataFactory.unlinkToDeath(remove, 0);
                    }
                }
            });
        }

        public void PlaceComponentResult(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.MyBillsEntityDataFactory());
                    if (connectionRecord == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("search for callback that isn't registered query=");
                        sb.append(str);
                        InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb.toString());
                        return;
                    }
                    MediaBrowserServiceCompat.this.performSearch(str, bundle, connectionRecord, resultReceiver);
                }
            });
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.mHandler.BuiltInFictitiousFunctionClassFactory(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(serviceCallbacks.MyBillsEntityDataFactory());
                    if (connectionRecord == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("sendCustomAction for callback that isn't registered action=");
                        sb.append(str);
                        sb.append(", extras=");
                        sb.append(bundle);
                        InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb.toString());
                        return;
                    }
                    MediaBrowserServiceCompat.this.performCustomAction(str, bundle, connectionRecord, resultReceiver);
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger MyBillsEntityDataFactory;

        ServiceCallbacksCompat(Messenger messenger) {
            this.MyBillsEntityDataFactory = messenger;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder MyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void BuiltInFictitiousFunctionClassFactory(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            getAuthRequestContext(1, bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void BuiltInFictitiousFunctionClassFactory() throws RemoteException {
            getAuthRequestContext(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void MyBillsEntityDataFactory(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            getAuthRequestContext(3, bundle3);
        }

        private void getAuthRequestContext(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.MyBillsEntityDataFactory.send(obtain);
        }
    }

    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            this.MyBillsEntityDataFactory = new MediaBrowserServiceImplApi28();
        } else if (Build.VERSION.SDK_INT >= 26) {
            this.MyBillsEntityDataFactory = new MediaBrowserServiceImplApi26();
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.MyBillsEntityDataFactory = new MediaBrowserServiceImplApi23();
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.MyBillsEntityDataFactory = new MediaBrowserServiceImplApi21();
        } else {
            this.MyBillsEntityDataFactory = new MediaBrowserServiceImplBase();
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.MyBillsEntityDataFactory.PlaceComponentResult(intent);
    }

    public void onLoadChildren(String str, Result<List<MediaBrowserCompat.MediaItem>> result, Bundle bundle) {
        result.getAuthRequestContext(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, Result<MediaBrowserCompat.MediaItem> result) {
        result.getAuthRequestContext(2);
        result.MyBillsEntityDataFactory((Result<MediaBrowserCompat.MediaItem>) null);
    }

    public void onSearch(String str, Bundle bundle, Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.getAuthRequestContext(4);
        result.MyBillsEntityDataFactory((Result<List<MediaBrowserCompat.MediaItem>>) null);
    }

    public void onCustomAction(String str, Bundle bundle, Result<Bundle> result) {
        result.MyBillsEntityDataFactory((Bundle) null);
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        }
        this.mSession = token;
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(token);
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    public final Bundle getBrowserRootHints() {
        return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
    }

    public void notifyChildrenChanged(String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext(str, null);
    }

    public void notifyChildrenChanged(String str, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext(str, bundle);
    }

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(remoteUserInfo, str, bundle);
    }

    boolean isValidPackage(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    void addSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair<IBinder, Bundle>> list = connectionRecord.moveToNextValue.get(str);
        if (list == null) {
            list = new ArrayList<>();
        }
        for (Pair<IBinder, Bundle> pair : list) {
            if (iBinder == pair.getAuthRequestContext && MediaBrowserCompatUtils.getAuthRequestContext(bundle, pair.PlaceComponentResult)) {
                return;
            }
        }
        list.add(new Pair<>(iBinder, bundle));
        connectionRecord.moveToNextValue.put(str, list);
        performLoadChildren(str, connectionRecord, bundle, null);
        this.mCurConnection = connectionRecord;
        onSubscribe(str, bundle);
        this.mCurConnection = null;
    }

    boolean removeSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder == null) {
                return connectionRecord.moveToNextValue.remove(str) != null;
            }
            List<Pair<IBinder, Bundle>> list = connectionRecord.moveToNextValue.get(str);
            if (list != null) {
                Iterator<Pair<IBinder, Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().getAuthRequestContext) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.moveToNextValue.remove(str);
                }
            }
            return z;
        } finally {
            this.mCurConnection = connectionRecord;
            onUnsubscribe(str);
            this.mCurConnection = null;
        }
    }

    void performLoadChildren(final String str, final ConnectionRecord connectionRecord, final Bundle bundle, final Bundle bundle2) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
            public void PlaceComponentResult(List<MediaBrowserCompat.MediaItem> list) {
                if (MediaBrowserServiceCompat.this.mConnections.get(connectionRecord.PlaceComponentResult.MyBillsEntityDataFactory()) != connectionRecord) {
                    if (MediaBrowserServiceCompat.DEBUG) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                        sb.append(connectionRecord.MyBillsEntityDataFactory);
                        sb.append(" id=");
                        sb.append(str);
                        InstrumentInjector.log_d(MediaBrowserServiceCompat.TAG, sb.toString());
                        return;
                    }
                    return;
                }
                if ((KClassImpl$Data$declaredNonStaticMembers$2() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.applyOptions(list, bundle);
                }
                try {
                    connectionRecord.PlaceComponentResult.MyBillsEntityDataFactory(str, list, bundle, bundle2);
                } catch (RemoteException unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calling onLoadChildren() failed for id=");
                    sb2.append(str);
                    sb2.append(" package=");
                    sb2.append(connectionRecord.MyBillsEntityDataFactory);
                    InstrumentInjector.log_w(MediaBrowserServiceCompat.TAG, sb2.toString());
                }
            }
        };
        this.mCurConnection = connectionRecord;
        if (bundle == null) {
            onLoadChildren(str, result);
        } else {
            onLoadChildren(str, result, bundle);
        }
        this.mCurConnection = null;
        if (result.getAuthRequestContext()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onLoadChildren must call detach() or sendResult() before returning for package=");
        sb.append(connectionRecord.MyBillsEntityDataFactory);
        sb.append(" id=");
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
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

    void performLoadItem(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media.MediaBrowserServiceCompat.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
            public void PlaceComponentResult(MediaBrowserCompat.MediaItem mediaItem) {
                if ((KClassImpl$Data$declaredNonStaticMembers$2() & 2) != 0) {
                    resultReceiver.BuiltInFictitiousFunctionClassFactory(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
                resultReceiver.BuiltInFictitiousFunctionClassFactory(0, bundle);
            }
        };
        this.mCurConnection = connectionRecord;
        onLoadItem(str, result);
        this.mCurConnection = null;
        if (result.getAuthRequestContext()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onLoadItem must call detach() or sendResult() before returning for id=");
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    void performSearch(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void PlaceComponentResult(List<MediaBrowserCompat.MediaItem> list) {
                if ((KClassImpl$Data$declaredNonStaticMembers$2() & 4) != 0 || list == null) {
                    resultReceiver.BuiltInFictitiousFunctionClassFactory(-1, null);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.BuiltInFictitiousFunctionClassFactory(0, bundle2);
            }
        };
        this.mCurConnection = connectionRecord;
        onSearch(str, bundle, result);
        this.mCurConnection = null;
        if (result.getAuthRequestContext()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onSearch must call detach() or sendResult() before returning for query=");
        sb.append(str);
        throw new IllegalStateException(sb.toString());
    }

    void performCustomAction(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result<Bundle> result = new Result<Bundle>(str) { // from class: androidx.media.MediaBrowserServiceCompat.4
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
            public void PlaceComponentResult(Bundle bundle2) {
                resultReceiver.BuiltInFictitiousFunctionClassFactory(0, bundle2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            void PlaceComponentResult(Bundle bundle2) {
                resultReceiver.BuiltInFictitiousFunctionClassFactory(-1, bundle2);
            }
        };
        this.mCurConnection = connectionRecord;
        onCustomAction(str, bundle, result);
        this.mCurConnection = null;
        if (result.getAuthRequestContext()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onCustomAction must call detach() or sendResult() or sendError() before returning for action=");
        sb.append(str);
        sb.append(" extras=");
        sb.append(bundle);
        throw new IllegalStateException(sb.toString());
    }

    /* loaded from: classes6.dex */
    public static final class BrowserRoot {
        private final Bundle MyBillsEntityDataFactory;
        private final String PlaceComponentResult;

        public final String KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult;
        }

        public final Bundle getAuthRequestContext() {
            return this.MyBillsEntityDataFactory;
        }
    }
}
