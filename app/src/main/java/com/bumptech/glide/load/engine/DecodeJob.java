package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda3 = {75, -23, 102, -23, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda4 = 103;
    private Stage B;
    private long BottomSheetCardBindingView$watcherCardNumberView$1;
    volatile DataFetcherGenerator BuiltInFictitiousFunctionClassFactory;
    boolean DatabaseTableConfigUtil;
    private Key FragmentBottomSheetPaymentSettingBinding;
    int GetContactSyncConfig;
    Callback<R> KClassImpl$Data$declaredNonStaticMembers$2;
    DiskCacheStrategy NetworkUserEntityData$$ExternalSyntheticLambda0;
    EngineKey NetworkUserEntityData$$ExternalSyntheticLambda1;
    Object NetworkUserEntityData$$ExternalSyntheticLambda2;
    private DataSource NetworkUserEntityData$$ExternalSyntheticLambda5;
    private Object NetworkUserEntityData$$ExternalSyntheticLambda6;
    int NetworkUserEntityData$$ExternalSyntheticLambda7;
    Key NetworkUserEntityData$$ExternalSyntheticLambda8;
    Priority PrepareContext;
    private DataFetcher<?> SubSequence;
    Key getAuthRequestContext;
    private final Pools.Pool<DecodeJob<?>> getCallingPid;
    GlideContext getErrorConfigVersion;
    private volatile boolean getSupportButtonTintMode;
    Options initRecordTimeStamp;
    final DiskCacheProvider lookAheadTest;
    volatile boolean moveToNextValue;
    RunReason newProxyInstance;
    private Thread readMicros;
    int scheduleImpl;
    private boolean whenAvailable;
    final DecodeHelper<R> MyBillsEntityDataFactory = new DecodeHelper<>();
    private final List<Throwable> A = new ArrayList();
    private final StateVerifier VerifyPinStateManager$executeRiskChallenge$2$1 = StateVerifier.KClassImpl$Data$declaredNonStaticMembers$2();
    final DeferredEncodeManager<?> PlaceComponentResult = new DeferredEncodeManager<>();
    final ReleaseManager isLayoutRequested = new ReleaseManager();

    /* loaded from: classes3.dex */
    public interface Callback<R> {
        void BuiltInFictitiousFunctionClassFactory(Resource<R> resource, DataSource dataSource, boolean z);

        void KClassImpl$Data$declaredNonStaticMembers$2(GlideException glideException);

        void MyBillsEntityDataFactory(DecodeJob<?> decodeJob);
    }

    /* loaded from: classes3.dex */
    public interface DiskCacheProvider {
        DiskCache KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* loaded from: classes3.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* loaded from: classes3.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 12
            int r8 = 16 - r8
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r9 = r9 * 3
            int r9 = r9 + 13
            byte[] r0 = com.bumptech.glide.load.engine.DecodeJob.NetworkUserEntityData$$ExternalSyntheticLambda3
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L33
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r7 = r7 + r8
            int r7 = r7 + 2
            int r8 = r9 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.a(byte, short, short, java.lang.Object[]):void");
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(DecodeJob<?> decodeJob) {
        DecodeJob<?> decodeJob2 = decodeJob;
        int ordinal = this.PrepareContext.ordinal() - decodeJob2.PrepareContext.ordinal();
        return ordinal == 0 ? this.GetContactSyncConfig - decodeJob2.GetContactSyncConfig : ordinal;
    }

    public DecodeJob(DiskCacheProvider diskCacheProvider, Pools.Pool<DecodeJob<?>> pool) {
        this.lookAheadTest = diskCacheProvider;
        this.getCallingPid = pool;
    }

    public final boolean MyBillsEntityDataFactory() {
        Stage authRequestContext = getAuthRequestContext(Stage.INITIALIZE);
        return authRequestContext == Stage.RESOURCE_CACHE || authRequestContext == Stage.DATA_CACHE;
    }

    public final void PlaceComponentResult() {
        ReleaseManager releaseManager = this.isLayoutRequested;
        synchronized (releaseManager) {
            releaseManager.BuiltInFictitiousFunctionClassFactory = false;
            releaseManager.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            releaseManager.getAuthRequestContext = false;
        }
        DeferredEncodeManager<?> deferredEncodeManager = this.PlaceComponentResult;
        deferredEncodeManager.PlaceComponentResult = null;
        deferredEncodeManager.BuiltInFictitiousFunctionClassFactory = null;
        deferredEncodeManager.MyBillsEntityDataFactory = null;
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        this.getSupportButtonTintMode = false;
        this.getErrorConfigVersion = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        this.initRecordTimeStamp = null;
        this.PrepareContext = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.B = null;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.readMicros = null;
        this.getAuthRequestContext = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
        this.SubSequence = null;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = 0L;
        this.moveToNextValue = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        this.A.clear();
        this.getCallingPid.MyBillsEntityDataFactory(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.PlaceComponentResult();
        DataFetcher<?> dataFetcher = this.SubSequence;
        try {
            try {
                try {
                    if (this.moveToNextValue) {
                        moveToNextValue();
                        if (dataFetcher != null) {
                            dataFetcher.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                        GlideTrace.MyBillsEntityDataFactory();
                        return;
                    }
                    int i = AnonymousClass1.MyBillsEntityDataFactory[this.newProxyInstance.ordinal()];
                    if (i == 1) {
                        this.B = getAuthRequestContext(Stage.INITIALIZE);
                        this.BuiltInFictitiousFunctionClassFactory = scheduleImpl();
                        NetworkUserEntityData$$ExternalSyntheticLambda0();
                    } else if (i == 2) {
                        NetworkUserEntityData$$ExternalSyntheticLambda0();
                    } else if (i == 3) {
                        BuiltInFictitiousFunctionClassFactory();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unrecognized run reason: ");
                        sb.append(this.newProxyInstance);
                        throw new IllegalStateException(sb.toString());
                    }
                    if (dataFetcher != null) {
                        dataFetcher.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                    GlideTrace.MyBillsEntityDataFactory();
                } catch (Throwable th) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("DecodeJob threw unexpectedly, isCancelled: ");
                        sb2.append(this.moveToNextValue);
                        sb2.append(", stage: ");
                        sb2.append(this.B);
                        InstrumentInjector.log_d("DecodeJob", sb2.toString(), th);
                    }
                    if (this.B != Stage.ENCODE) {
                        this.A.add(th);
                        moveToNextValue();
                    }
                    if (!this.moveToNextValue) {
                        throw th;
                    }
                    throw th;
                }
            } catch (CallbackException e) {
                throw e;
            }
        } catch (Throwable th2) {
            if (dataFetcher != null) {
                dataFetcher.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            GlideTrace.MyBillsEntityDataFactory();
            throw th2;
        }
    }

    private DataFetcherGenerator scheduleImpl() {
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[this.B.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unrecognized stage: ");
                    sb.append(this.B);
                    throw new IllegalStateException(sb.toString());
                }
                return new SourceGenerator(this.MyBillsEntityDataFactory, this);
            }
            return new DataCacheGenerator(this.MyBillsEntityDataFactory, this);
        }
        return new ResourceCacheGenerator(this.MyBillsEntityDataFactory, this);
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda3[15] - 1);
            Object[] objArr = new Object[1];
            a(b, b, NetworkUserEntityData$$ExternalSyntheticLambda3[15], objArr);
            boolean z = false;
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda3[15];
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            this.readMicros = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = LogTime.PlaceComponentResult();
            while (!this.moveToNextValue && this.BuiltInFictitiousFunctionClassFactory != null && !(z = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext())) {
                this.B = getAuthRequestContext(this.B);
                this.BuiltInFictitiousFunctionClassFactory = scheduleImpl();
                if (this.B == Stage.SOURCE) {
                    this.newProxyInstance = RunReason.SWITCH_TO_SOURCE_SERVICE;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this);
                    return;
                }
            }
            if ((this.B == Stage.FINISHED || this.moveToNextValue) && !z) {
                moveToNextValue();
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private void moveToNextValue() {
        getErrorConfigVersion();
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(new GlideException("Failed to load resource", new ArrayList(this.A)));
        if (this.isLayoutRequested.PlaceComponentResult()) {
            PlaceComponentResult();
        }
    }

    private void getErrorConfigVersion() {
        Throwable th;
        this.VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult();
        if (this.getSupportButtonTintMode) {
            if (this.A.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.A;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.getSupportButtonTintMode = true;
    }

    private Stage getAuthRequestContext(Stage stage) {
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[stage.ordinal()];
        if (i == 1) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext()) {
                return Stage.DATA_CACHE;
            }
            return getAuthRequestContext(Stage.DATA_CACHE);
        } else if (i == 2) {
            return this.DatabaseTableConfigUtil ? Stage.FINISHED : Stage.SOURCE;
        } else if (i == 3 || i == 4) {
            return Stage.FINISHED;
        } else {
            if (i == 5) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory()) {
                    return Stage.RESOURCE_CACHE;
                }
                return getAuthRequestContext(Stage.RESOURCE_CACHE);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized stage: ");
            sb.append(stage);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.newProxyInstance = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void BuiltInFictitiousFunctionClassFactory(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.getAuthRequestContext = key;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = obj;
        this.SubSequence = dataFetcher;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = dataSource;
        this.FragmentBottomSheetPaymentSettingBinding = key2;
        this.whenAvailable = key != this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2().get(0);
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda3[15] - 1);
            Object[] objArr = new Object[1];
            a(b, b, NetworkUserEntityData$$ExternalSyntheticLambda3[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda3[15];
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != this.readMicros) {
                this.newProxyInstance = RunReason.DECODE_DATA;
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this);
                return;
            }
            GlideTrace.BuiltInFictitiousFunctionClassFactory();
            try {
                BuiltInFictitiousFunctionClassFactory();
            } finally {
                GlideTrace.MyBillsEntityDataFactory();
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public final void PlaceComponentResult(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.KClassImpl$Data$declaredNonStaticMembers$2();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.getAuthRequestContext());
        this.A.add(glideException);
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda3[15] - 1);
            Object[] objArr = new Object[1];
            a(b, b, NetworkUserEntityData$$ExternalSyntheticLambda3[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda3[15];
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != this.readMicros) {
                this.newProxyInstance = RunReason.SWITCH_TO_SOURCE_SERVICE;
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this);
                return;
            }
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        LockedResource lockedResource;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.BottomSheetCardBindingView$watcherCardNumberView$1;
            StringBuilder sb = new StringBuilder();
            sb.append("data: ");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            sb.append(", cache key: ");
            sb.append(this.getAuthRequestContext);
            sb.append(", fetcher: ");
            sb.append(this.SubSequence);
            KClassImpl$Data$declaredNonStaticMembers$2("Retrieved data", j, sb.toString());
        }
        LockedResource lockedResource2 = null;
        try {
            lockedResource = BuiltInFictitiousFunctionClassFactory(this.SubSequence, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        } catch (GlideException e) {
            e.setLoggingDetails(this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.A.add(e);
            lockedResource = null;
        }
        if (lockedResource != null) {
            DataSource dataSource = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            boolean z = this.whenAvailable;
            if (lockedResource instanceof Initializable) {
                ((Initializable) lockedResource).BuiltInFictitiousFunctionClassFactory();
            }
            if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2()) {
                lockedResource2 = LockedResource.getAuthRequestContext(lockedResource);
                lockedResource = lockedResource2;
            }
            getErrorConfigVersion();
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(lockedResource, dataSource, z);
            this.B = Stage.ENCODE;
            try {
                if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    DeferredEncodeManager<?> deferredEncodeManager = this.PlaceComponentResult;
                    DiskCacheProvider diskCacheProvider = this.lookAheadTest;
                    Options options = this.initRecordTimeStamp;
                    GlideTrace.BuiltInFictitiousFunctionClassFactory();
                    try {
                        diskCacheProvider.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(deferredEncodeManager.PlaceComponentResult, new DataCacheWriter(deferredEncodeManager.BuiltInFictitiousFunctionClassFactory, deferredEncodeManager.MyBillsEntityDataFactory, options));
                        deferredEncodeManager.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                        GlideTrace.MyBillsEntityDataFactory();
                    } catch (Throwable th) {
                        deferredEncodeManager.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                        GlideTrace.MyBillsEntityDataFactory();
                        throw th;
                    }
                }
                if (this.isLayoutRequested.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    PlaceComponentResult();
                    return;
                }
                return;
            } finally {
                if (lockedResource2 != null) {
                    lockedResource2.BuiltInFictitiousFunctionClassFactory();
                }
            }
        }
        NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    private <Data> Resource<R> BuiltInFictitiousFunctionClassFactory(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            return null;
        }
        try {
            long PlaceComponentResult = LogTime.PlaceComponentResult();
            DecodeHelper<R> decodeHelper = this.MyBillsEntityDataFactory;
            Resource<R> PlaceComponentResult2 = PlaceComponentResult(data, dataSource, decodeHelper.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(data.getClass(), decodeHelper.getErrorConfigVersion, decodeHelper.initRecordTimeStamp));
            if (Log.isLoggable("DecodeJob", 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Decoded result ");
                sb.append(PlaceComponentResult2);
                KClassImpl$Data$declaredNonStaticMembers$2(sb.toString(), PlaceComponentResult, null);
            }
            return PlaceComponentResult2;
        } finally {
            dataFetcher.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.MyBillsEntityDataFactory(j));
        sb.append(", load key: ");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        if (str2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(", ");
            sb2.append(str2);
            str3 = sb2.toString();
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda3[15] - 1);
            Object[] objArr = new Object[1];
            a(b, b, NetworkUserEntityData$$ExternalSyntheticLambda3[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda3[15];
            byte b3 = b2;
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            InstrumentInjector.log_v("DecodeJob", sb.toString());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public final StateVerifier d_() {
        return this.VerifyPinStateManager$executeRiskChallenge$2$1;
    }

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] MyBillsEntityDataFactory;
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            MyBillsEntityDataFactory = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                MyBillsEntityDataFactory[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                MyBillsEntityDataFactory[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
        private final DataSource BuiltInFictitiousFunctionClassFactory;

        DecodeCallback(DataSource dataSource) {
            DecodeJob.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
        public final Resource<Z> BuiltInFictitiousFunctionClassFactory(Resource<Z> resource) {
            Resource<Z> resource2;
            Transformation<Z> transformation;
            EncodeStrategy encodeStrategy;
            Key dataCacheKey;
            DecodeJob decodeJob = DecodeJob.this;
            DataSource dataSource = this.BuiltInFictitiousFunctionClassFactory;
            Class<?> cls = resource.getAuthRequestContext().getClass();
            ResourceEncoder<Z> resourceEncoder = null;
            if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
                Transformation<Z> authRequestContext = decodeJob.MyBillsEntityDataFactory.getAuthRequestContext(cls);
                transformation = authRequestContext;
                resource2 = authRequestContext.PlaceComponentResult(decodeJob.getErrorConfigVersion, resource, decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda7, decodeJob.scheduleImpl);
            } else {
                resource2 = resource;
                transformation = null;
            }
            if (!resource.equals(resource2)) {
                resource.lookAheadTest();
            }
            if (!decodeJob.MyBillsEntityDataFactory.MyBillsEntityDataFactory(resource2)) {
                encodeStrategy = EncodeStrategy.NONE;
            } else {
                resourceEncoder = decodeJob.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(resource2.KClassImpl$Data$declaredNonStaticMembers$2());
                if (resourceEncoder != null) {
                    encodeStrategy = resourceEncoder.KClassImpl$Data$declaredNonStaticMembers$2(decodeJob.initRecordTimeStamp);
                } else {
                    throw new Registry.NoResultEncoderAvailableException(resource2.KClassImpl$Data$declaredNonStaticMembers$2());
                }
            }
            ResourceEncoder<Z> resourceEncoder2 = resourceEncoder;
            if (decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(!decodeJob.MyBillsEntityDataFactory.PlaceComponentResult(decodeJob.getAuthRequestContext), dataSource, encodeStrategy)) {
                if (resourceEncoder2 == null) {
                    throw new Registry.NoResultEncoderAvailableException(resource2.getAuthRequestContext().getClass());
                }
                int i = AnonymousClass1.getAuthRequestContext[encodeStrategy.ordinal()];
                if (i == 1) {
                    dataCacheKey = new DataCacheKey(decodeJob.getAuthRequestContext, decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda8);
                } else if (i == 2) {
                    dataCacheKey = new ResourceCacheKey(decodeJob.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, decodeJob.getAuthRequestContext, decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda8, decodeJob.NetworkUserEntityData$$ExternalSyntheticLambda7, decodeJob.scheduleImpl, transformation, cls, decodeJob.initRecordTimeStamp);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unknown strategy: ");
                    sb.append(encodeStrategy);
                    throw new IllegalArgumentException(sb.toString());
                }
                LockedResource<Z> authRequestContext2 = LockedResource.getAuthRequestContext(resource2);
                DeferredEncodeManager<?> deferredEncodeManager = decodeJob.PlaceComponentResult;
                deferredEncodeManager.PlaceComponentResult = dataCacheKey;
                deferredEncodeManager.BuiltInFictitiousFunctionClassFactory = resourceEncoder2;
                deferredEncodeManager.MyBillsEntityDataFactory = authRequestContext2;
                return authRequestContext2;
            }
            return resource2;
        }
    }

    /* loaded from: classes3.dex */
    public static class ReleaseManager {
        boolean BuiltInFictitiousFunctionClassFactory;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        boolean getAuthRequestContext;

        ReleaseManager() {
        }

        public final boolean MyBillsEntityDataFactory() {
            boolean MyBillsEntityDataFactory;
            synchronized (this) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(false);
            }
            return MyBillsEntityDataFactory;
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            boolean MyBillsEntityDataFactory;
            synchronized (this) {
                this.BuiltInFictitiousFunctionClassFactory = true;
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(false);
            }
            return MyBillsEntityDataFactory;
        }

        final boolean PlaceComponentResult() {
            boolean MyBillsEntityDataFactory;
            synchronized (this) {
                this.getAuthRequestContext = true;
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(false);
            }
            return MyBillsEntityDataFactory;
        }

        private boolean MyBillsEntityDataFactory(boolean z) {
            return (this.getAuthRequestContext || this.BuiltInFictitiousFunctionClassFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes3.dex */
    public static class DeferredEncodeManager<Z> {
        ResourceEncoder<Z> BuiltInFictitiousFunctionClassFactory;
        LockedResource<Z> MyBillsEntityDataFactory;
        Key PlaceComponentResult;

        DeferredEncodeManager() {
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.MyBillsEntityDataFactory != null;
        }
    }

    private <Data, ResourceType> Resource<R> PlaceComponentResult(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options options = this.initRecordTimeStamp;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
            Option<Boolean> option = Downsampler.MyBillsEntityDataFactory;
            Boolean bool = (Boolean) (options.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(option) ? options.KClassImpl$Data$declaredNonStaticMembers$2.get(option) : option.PlaceComponentResult);
            if (bool == null || (bool.booleanValue() && !z)) {
                options = new Options();
                options.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2);
                options.KClassImpl$Data$declaredNonStaticMembers$2.put(Downsampler.MyBillsEntityDataFactory, Boolean.valueOf(z));
            }
        }
        Options options2 = options;
        DataRewinder<Data> MyBillsEntityDataFactory = this.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.MyBillsEntityDataFactory(data);
        try {
            return loadPath.getAuthRequestContext(MyBillsEntityDataFactory, options2, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.scheduleImpl, new DecodeCallback(dataSource));
        } finally {
            MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        }
    }
}
