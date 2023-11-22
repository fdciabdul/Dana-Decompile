package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import o.A;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final int KClassImpl$Data$declaredNonStaticMembers$2;
    private static int MyBillsEntityDataFactory = 1;
    private static int PlaceComponentResult;
    private static final ThreadFactory THREAD_FACTORY;
    public static final byte[] getAuthRequestContext;
    private final Context applicationContext;
    private final Executor backgroundExecutor;
    private final Set<HeartBeatConsumer> consumers;
    private final Provider<HeartBeatInfoStorage> storageProvider;
    private final Provider<UserAgentPublisher> userAgentProvider;

    static void PlaceComponentResult() {
        PlaceComponentResult = 269894837;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0058 -> B:33:0x005d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r11) {
        /*
            int r0 = com.google.firebase.heartbeatinfo.DefaultHeartBeatController.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.google.firebase.heartbeatinfo.DefaultHeartBeatController.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 22
            r2 = 97
            r3 = 0
            r4 = 1
            if (r0 != 0) goto L29
            r0 = 50
            r5 = 5
            byte[] r6 = com.google.firebase.heartbeatinfo.DefaultHeartBeatController.getAuthRequestContext     // Catch: java.lang.Exception -> L27
            r7 = 100
            byte[] r7 = new byte[r7]     // Catch: java.lang.Exception -> L27
            if (r6 != 0) goto L1f
            r8 = 0
            goto L20
        L1f:
            r8 = 1
        L20:
            r0 = 1
            if (r8 == r4) goto L24
            goto L3e
        L24:
            r2 = 50
            goto L5d
        L27:
            r11 = move-exception
            goto L72
        L29:
            r5 = 4
            byte[] r6 = com.google.firebase.heartbeatinfo.DefaultHeartBeatController.getAuthRequestContext
            r0 = 23
            byte[] r7 = new byte[r0]
            r0 = 37
            if (r6 != 0) goto L37
            r8 = 37
            goto L39
        L37:
            r8 = 45
        L39:
            if (r8 == r0) goto L3d
            r0 = 0
            goto L5d
        L3d:
            r0 = 0
        L3e:
            int r8 = com.google.firebase.heartbeatinfo.DefaultHeartBeatController.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L73
            int r8 = r8 + 65
            int r9 = r8 % 128
            com.google.firebase.heartbeatinfo.DefaultHeartBeatController.BuiltInFictitiousFunctionClassFactory = r9     // Catch: java.lang.Exception -> L27
            int r8 = r8 % 2
            if (r8 == 0) goto L4c
            r8 = 1
            goto L4d
        L4c:
            r8 = 0
        L4d:
            if (r8 == r4) goto L54
            r2 = 22
            r8 = 97
            goto L58
        L54:
            r2 = 69
            r8 = 51
        L58:
            int r8 = -r8
            int r2 = r2 + r8
            int r2 = r2 + (-8)
            int r5 = r5 + r4
        L5d:
            byte r8 = (byte) r2
            r7[r0] = r8
            int r8 = r0 + 1
            if (r0 != r1) goto L6c
            java.lang.String r0 = new java.lang.String
            r0.<init>(r7, r3)
            r11[r3] = r0
            return
        L6c:
            r0 = r6[r5]
            r10 = r8
            r8 = r0
            r0 = r10
            goto L58
        L72:
            throw r11
        L73:
            r11 = move-exception
            goto L76
        L75:
            throw r11
        L76:
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.heartbeatinfo.DefaultHeartBeatController.a(java.lang.Object[]):void");
    }

    static {
        PlaceComponentResult();
        getAuthRequestContext = new byte[]{Ascii.RS, 119, -63, 113, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
        KClassImpl$Data$declaredNonStaticMembers$2 = 26;
        THREAD_FACTORY = new ThreadFactory() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return DefaultHeartBeatController.lambda$static$0(runnable);
            }
        };
        int i = MyBillsEntityDataFactory + 47;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? 'J' : (char) 20) != 20) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "heartbeat-information-executor");
        int i = BuiltInFictitiousFunctionClassFactory + 115;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return thread;
        }
        return thread;
    }

    public Task<Void> registerHeartBeat() {
        if ((this.consumers.size() <= 0 ? (char) 6 : '/') == '/') {
            if ((!UserManagerCompat.PlaceComponentResult(this.applicationContext)) != false) {
                int i = BuiltInFictitiousFunctionClassFactory + 101;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                return Tasks.forResult(null);
            }
            return Tasks.call(this.backgroundExecutor, new Callable() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return DefaultHeartBeatController.this.m162x785c653();
                }
            });
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 109;
        MyBillsEntityDataFactory = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 23 / 0;
            return Tasks.forResult(null);
        }
        try {
            return Tasks.forResult(null);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$registerHeartBeat$1$com-google-firebase-heartbeatinfo-DefaultHeartBeatController  reason: not valid java name */
    public /* synthetic */ Void m162x785c653() throws Exception {
        synchronized (this) {
            this.storageProvider.get().storeHeartBeat(System.currentTimeMillis(), this.userAgentProvider.get().getUserAgent());
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if ((androidx.core.os.UserManagerCompat.PlaceComponentResult(r4.applicationContext) || true) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        if ((!androidx.core.os.UserManagerCompat.PlaceComponentResult(r4.applicationContext)) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        return com.google.android.gms.tasks.Tasks.forResult("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        r0 = com.google.android.gms.tasks.Tasks.call(r4.backgroundExecutor, new com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda1(r4));
        r2 = com.google.firebase.heartbeatinfo.DefaultHeartBeatController.BuiltInFictitiousFunctionClassFactory + 5;
        com.google.firebase.heartbeatinfo.DefaultHeartBeatController.MyBillsEntityDataFactory = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if ((r2 % 2) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        r2 = 'M';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        r2 = 23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        if (r2 == 'M') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        r2 = 21 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        return r0;
     */
    @Override // com.google.firebase.heartbeatinfo.HeartBeatController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.tasks.Task<java.lang.String> getHeartBeatsHeader() {
        /*
            r4 = this;
            int r0 = com.google.firebase.heartbeatinfo.DefaultHeartBeatController.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 33
            int r1 = r0 % 128
            com.google.firebase.heartbeatinfo.DefaultHeartBeatController.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L1c
            android.content.Context r0 = r4.applicationContext     // Catch: java.lang.Exception -> L55
            boolean r0 = androidx.core.os.UserManagerCompat.PlaceComponentResult(r0)     // Catch: java.lang.Exception -> L53
            r0 = r0 | r2
            if (r0 == 0) goto L18
            goto L19
        L18:
            r2 = 0
        L19:
            if (r2 == 0) goto L2c
            goto L25
        L1c:
            android.content.Context r0 = r4.applicationContext     // Catch: java.lang.Exception -> L55
            boolean r0 = androidx.core.os.UserManagerCompat.PlaceComponentResult(r0)     // Catch: java.lang.Exception -> L53
            r0 = r0 ^ r2
            if (r0 == 0) goto L2c
        L25:
            java.lang.String r0 = ""
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forResult(r0)
            return r0
        L2c:
            java.util.concurrent.Executor r0 = r4.backgroundExecutor
            com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda1 r2 = new com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda1
            r2.<init>()
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.call(r0, r2)
            int r2 = com.google.firebase.heartbeatinfo.DefaultHeartBeatController.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 5
            int r3 = r2 % 128
            com.google.firebase.heartbeatinfo.DefaultHeartBeatController.MyBillsEntityDataFactory = r3
            int r2 = r2 % 2
            r3 = 77
            if (r2 != 0) goto L48
            r2 = 77
            goto L4a
        L48:
            r2 = 23
        L4a:
            if (r2 == r3) goto L4d
            return r0
        L4d:
            r2 = 21
            int r2 = r2 / r1
            return r0
        L51:
            r0 = move-exception
            throw r0
        L53:
            r0 = move-exception
            throw r0
        L55:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.heartbeatinfo.DefaultHeartBeatController.getHeartBeatsHeader():com.google.android.gms.tasks.Task");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getHeartBeatsHeader$2$com-google-firebase-heartbeatinfo-DefaultHeartBeatController  reason: not valid java name */
    public /* synthetic */ String m161xc85c8491() throws Exception {
        String byteArrayOutputStream;
        synchronized (this) {
            HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
            List<HeartBeatResult> allHeartBeats = heartBeatInfoStorage.getAllHeartBeats();
            heartBeatInfoStorage.deleteAllHeartBeats();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < allHeartBeats.size(); i++) {
                HeartBeatResult heartBeatResult = allHeartBeats.get(i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", heartBeatResult.getUserAgent());
                jSONObject.put("dates", new JSONArray((Collection) heartBeatResult.getUsedDates()));
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", jSONArray);
            jSONObject2.put("version", "2");
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                try {
                    String jSONObject3 = jSONObject2.toString();
                    Object[] objArr = new Object[1];
                    b(new char[]{2, 65513, 65524, 17, 16}, 212 - View.resolveSize(0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 5, false, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 2, objArr);
                    gZIPOutputStream.write(jSONObject3.getBytes(((String) objArr[0]).intern()));
                    gZIPOutputStream.close();
                    base64OutputStream.close();
                    Object[] objArr2 = new Object[1];
                    b(new char[]{2, 65513, 65524, 17, 16}, 212 - TextUtils.getOffsetAfter("", 0), ((Process.getThreadPriority(0) + 20) >> 6) + 5, false, (ViewConfiguration.getPressedStateDuration() >> 16) + 3, objArr2);
                    byteArrayOutputStream = byteArrayOutputStream2.toString(((String) objArr2[0]).intern());
                } finally {
                }
            } finally {
            }
        }
        return byteArrayOutputStream;
    }

    private DefaultHeartBeatController(final Context context, final String str, Set<HeartBeatConsumer> set, Provider<UserAgentPublisher> provider) {
        this(new Provider() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda4
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return DefaultHeartBeatController.lambda$new$3(context, str);
            }
        }, set, new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), THREAD_FACTORY), provider, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HeartBeatInfoStorage lambda$new$3(Context context, String str) {
        HeartBeatInfoStorage heartBeatInfoStorage = new HeartBeatInfoStorage(context, str);
        int i = MyBillsEntityDataFactory + 37;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return heartBeatInfoStorage;
    }

    DefaultHeartBeatController(Provider<HeartBeatInfoStorage> provider, Set<HeartBeatConsumer> set, Executor executor, Provider<UserAgentPublisher> provider2, Context context) {
        try {
            this.storageProvider = provider;
            this.consumers = set;
            this.backgroundExecutor = executor;
            this.userAgentProvider = provider2;
            this.applicationContext = context;
        } catch (Exception e) {
            throw e;
        }
    }

    public static Component<DefaultHeartBeatController> component() {
        Component.Builder builder = Component.builder(DefaultHeartBeatController.class, HeartBeatController.class, HeartBeatInfo.class);
        Object[] objArr = new Object[1];
        a(objArr);
        Component<DefaultHeartBeatController> build = builder.add(Dependency.required(Class.forName((String) objArr[0]))).add(Dependency.required(FirebaseApp.class)).add(Dependency.setOf(HeartBeatConsumer.class)).add(Dependency.requiredProvider(UserAgentPublisher.class)).factory(new ComponentFactory() { // from class: com.google.firebase.heartbeatinfo.DefaultHeartBeatController$$ExternalSyntheticLambda3
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return DefaultHeartBeatController.lambda$component$4(componentContainer);
            }
        }).build();
        int i = BuiltInFictitiousFunctionClassFactory + 41;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ DefaultHeartBeatController lambda$component$4(ComponentContainer componentContainer) {
        try {
            Object[] objArr = new Object[1];
            a(objArr);
            DefaultHeartBeatController defaultHeartBeatController = new DefaultHeartBeatController((Context) componentContainer.get(Class.forName((String) objArr[0])), ((FirebaseApp) componentContainer.get(FirebaseApp.class)).getPersistenceKey(), componentContainer.setOf(HeartBeatConsumer.class), componentContainer.getProvider(UserAgentPublisher.class));
            int i = MyBillsEntityDataFactory + 23;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            return defaultHeartBeatController;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public HeartBeatInfo.HeartBeat getHeartBeatCode(String str) {
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            HeartBeatInfoStorage heartBeatInfoStorage = this.storageProvider.get();
            if (heartBeatInfoStorage.shouldSendGlobalHeartBeat(currentTimeMillis)) {
                heartBeatInfoStorage.postHeartBeatCleanUp();
                return HeartBeatInfo.HeartBeat.GLOBAL;
            }
            return HeartBeatInfo.HeartBeat.NONE;
        }
    }

    private static void b(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        char[] cArr2;
        A a2 = new A();
        char[] cArr3 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((a2.MyBillsEntityDataFactory < i2 ? (char) 15 : '\n') != 15) {
                break;
            }
            int i4 = $10 + 5;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr3[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i6 = a2.MyBillsEntityDataFactory;
            cArr3[i6] = (char) (cArr3[i6] - ((int) (PlaceComponentResult ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i3 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr4 = new char[i2];
            System.arraycopy(cArr3, 0, cArr4, 0, i2);
            System.arraycopy(cArr4, 0, cArr3, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr4, a2.BuiltInFictitiousFunctionClassFactory, cArr3, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if ((z ? (char) 7 : 'B') != 'B') {
            int i7 = $11 + 23;
            $10 = i7 % 128;
            if ((i7 % 2 != 0 ? '@' : (char) 2) != 2) {
                cArr2 = new char[i2];
                try {
                    a2.MyBillsEntityDataFactory = 1;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                cArr2 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
            }
            while (true) {
                if (!(a2.MyBillsEntityDataFactory < i2)) {
                    break;
                }
                int i8 = $11 + 109;
                $10 = i8 % 128;
                int i9 = i8 % 2;
                cArr2[a2.MyBillsEntityDataFactory] = cArr3[(i2 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr3 = cArr2;
        }
        objArr[0] = new String(cArr3);
    }
}
