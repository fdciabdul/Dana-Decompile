package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.mixpanel.android.mpmetrics.MPDbAdapter;
import com.mixpanel.android.util.HttpService;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.RemoteService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import o.E;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AnalyticsMessages {
    protected final Context MyBillsEntityDataFactory;
    final Worker PlaceComponentResult = new Worker();
    protected final MPConfig getAuthRequestContext;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {45, -61, Ascii.ETB, 105, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 26;
    private static final Map<Context, AnalyticsMessages> moveToNextValue = new HashMap();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r0 = com.mixpanel.android.mpmetrics.AnalyticsMessages.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1b:
            r3 = 0
        L1c:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.AnalyticsMessages.a(byte, short, int, java.lang.Object[]):void");
    }

    private AnalyticsMessages(Context context) {
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = MPConfig.getAuthRequestContext(context);
        new HttpService().getAuthRequestContext();
    }

    public static AnalyticsMessages BuiltInFictitiousFunctionClassFactory(Context context) {
        AnalyticsMessages analyticsMessages;
        Map<Context, AnalyticsMessages> map = moveToNextValue;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (!map.containsKey(applicationContext)) {
                analyticsMessages = new AnalyticsMessages(applicationContext);
                map.put(applicationContext, analyticsMessages);
            } else {
                analyticsMessages = map.get(applicationContext);
            }
        }
        return analyticsMessages;
    }

    public final void MyBillsEntityDataFactory(EventDescription eventDescription) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = eventDescription;
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(obtain);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(FlushDescription flushDescription) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = flushDescription.getAuthRequestContext;
        obtain.arg1 = flushDescription.KClassImpl$Data$declaredNonStaticMembers$2() ? 1 : 0;
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(obtain);
    }

    protected static MPDbAdapter getAuthRequestContext(Context context) {
        return MPDbAdapter.getAuthRequestContext(context);
    }

    protected static RemoteService BuiltInFictitiousFunctionClassFactory() {
        return new HttpService();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class EventDescription extends MixpanelMessageDescription {
        final String BuiltInFictitiousFunctionClassFactory;
        final JSONObject KClassImpl$Data$declaredNonStaticMembers$2;
        private final boolean PlaceComponentResult;

        public EventDescription(String str, JSONObject jSONObject, String str2) {
            this(str, jSONObject, str2, false, new JSONObject());
        }

        public EventDescription(String str, JSONObject jSONObject, String str2, boolean z, JSONObject jSONObject2) {
            super(str2, jSONObject);
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.PlaceComponentResult = z;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject2;
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PeopleDescription extends MixpanelMessageDescription {
        public PeopleDescription(JSONObject jSONObject, String str) {
            super(str, jSONObject);
        }

        public final boolean MyBillsEntityDataFactory() {
            return !this.MyBillsEntityDataFactory.has("$distinct_id");
        }

        public String toString() {
            return this.MyBillsEntityDataFactory.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PushAnonymousPeopleDescription extends MixpanelDescription {
        final String BuiltInFictitiousFunctionClassFactory;

        public PushAnonymousPeopleDescription(String str, String str2) {
            super(str2);
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        public String toString() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    /* loaded from: classes.dex */
    public static class FlushDescription extends MixpanelDescription {
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        public FlushDescription(String str) {
            this(str, true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public FlushDescription(String str, boolean z) {
            super(str);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MixpanelMessageDescription extends MixpanelDescription {
        final JSONObject MyBillsEntityDataFactory;

        public MixpanelMessageDescription(String str, JSONObject jSONObject) {
            super(str);
            if (jSONObject != null && jSONObject.length() > 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.get(next);
                    } catch (AssertionError e) {
                        jSONObject.remove(next);
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Messages", "Removing people profile property from update (see https://github.com/mixpanel/mixpanel-android/issues/567)", e);
                    } catch (JSONException unused) {
                    }
                }
            }
            this.MyBillsEntityDataFactory = jSONObject;
        }
    }

    /* loaded from: classes.dex */
    static class UpdateEventsPropertiesDescription extends MixpanelDescription {
        Map<String, String> BuiltInFictitiousFunctionClassFactory;

        public UpdateEventsPropertiesDescription(String str, Map<String, String> map) {
            super(str);
            this.BuiltInFictitiousFunctionClassFactory = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MixpanelDescription {
        final String getAuthRequestContext;

        public MixpanelDescription(String str) {
            this.getAuthRequestContext = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Worker {
        private Handler PlaceComponentResult;
        private SystemInformation scheduleImpl;
        private final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
        private long getAuthRequestContext = 0;
        private long BuiltInFictitiousFunctionClassFactory = 0;
        private long getErrorConfigVersion = -1;

        static /* synthetic */ Handler BuiltInFictitiousFunctionClassFactory(Worker worker) {
            worker.PlaceComponentResult = null;
            return null;
        }

        public Worker() {
            HandlerThread handlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 10);
            handlerThread.start();
            this.PlaceComponentResult = new AnalyticsMessageHandler(handlerThread.getLooper());
        }

        public final void BuiltInFictitiousFunctionClassFactory(Message message) {
            synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                Handler handler = this.PlaceComponentResult;
                if (handler == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Dead mixpanel worker dropping a message: ");
                    sb.append(message.what);
                    AnalyticsMessages.PlaceComponentResult(sb.toString());
                } else {
                    handler.sendMessage(message);
                }
            }
        }

        /* loaded from: classes.dex */
        class AnalyticsMessageHandler extends Handler {
            private static int $10 = 0;
            private static int $11 = 1;
            private static int DatabaseTableConfigUtil = 0;
            private static int GetContactSyncConfig = 0;
            public static final int KClassImpl$Data$declaredNonStaticMembers$2;
            private static int NetworkUserEntityData$$ExternalSyntheticLambda1 = 1;
            public static final byte[] PlaceComponentResult;
            private static long getErrorConfigVersion;
            private static char initRecordTimeStamp;
            private final DecideChecker MyBillsEntityDataFactory;
            private long NetworkUserEntityData$$ExternalSyntheticLambda0;
            private MPDbAdapter getAuthRequestContext;
            private final long lookAheadTest;
            private int moveToNextValue;
            private long scheduleImpl;

            static {
                BuiltInFictitiousFunctionClassFactory();
                PlaceComponentResult = new byte[]{Ascii.DC4, -68, -64, 70, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
                KClassImpl$Data$declaredNonStaticMembers$2 = 93;
                int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 105;
                GetContactSyncConfig = i % 128;
                int i2 = i % 2;
            }

            static void BuiltInFictitiousFunctionClassFactory() {
                initRecordTimeStamp = (char) 13492;
                getErrorConfigVersion = -2091881955734661958L;
                DatabaseTableConfigUtil = -956812108;
            }

            private static void b(int i, byte b, int i2, Object[] objArr) {
                int i3 = 15 - (i * 12);
                byte[] bArr = PlaceComponentResult;
                int i4 = (b * 3) + 13;
                int i5 = (i2 * 7) + 99;
                byte[] bArr2 = new byte[i4];
                int i6 = -1;
                int i7 = i4 - 1;
                if (bArr == null) {
                    int i8 = GetContactSyncConfig + 105;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i8 % 128;
                    if (i8 % 2 == 0) {
                        int i9 = 50 / 0;
                    }
                    objArr = objArr;
                    bArr = bArr;
                    bArr2 = bArr2;
                    i6 = -1;
                    i5 = i5 + i7 + 2;
                    i7 = i7;
                }
                while (true) {
                    int i10 = i6 + 1;
                    bArr2[i10] = (byte) i5;
                    if (i10 == i7) {
                        objArr[0] = new String(bArr2, 0);
                        return;
                    }
                    i3++;
                    byte b2 = bArr[i3];
                    int i11 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 105;
                    GetContactSyncConfig = i11 % 128;
                    int i12 = i11 % 2;
                    objArr = objArr;
                    bArr = bArr;
                    bArr2 = bArr2;
                    i6 = i10;
                    i5 = i5 + b2 + 2;
                    i7 = i7;
                }
            }

            public AnalyticsMessageHandler(Looper looper) {
                super(looper);
                this.getAuthRequestContext = null;
                Worker.this.scheduleImpl = SystemInformation.KClassImpl$Data$declaredNonStaticMembers$2(AnalyticsMessages.this.MyBillsEntityDataFactory);
                this.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2();
                this.lookAheadTest = AnalyticsMessages.this.getAuthRequestContext.moveToNextValue;
            }

            private DecideChecker KClassImpl$Data$declaredNonStaticMembers$2() {
                DecideChecker decideChecker = new DecideChecker(AnalyticsMessages.this.MyBillsEntityDataFactory, AnalyticsMessages.this.getAuthRequestContext);
                int i = NetworkUserEntityData$$ExternalSyntheticLambda1 + 47;
                GetContactSyncConfig = i % 128;
                int i2 = i % 2;
                return decideChecker;
            }

            /* JADX WARN: Removed duplicated region for block: B:130:0x0397 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void handleMessage(android.os.Message r11) {
                /*
                    Method dump skipped, instructions count: 954
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler.handleMessage(android.os.Message):void");
            }

            private void getAuthRequestContext(MPDbAdapter mPDbAdapter, String str) {
                AnalyticsMessages analyticsMessages = AnalyticsMessages.this;
                if (AnalyticsMessages.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2(AnalyticsMessages.this.MyBillsEntityDataFactory, AnalyticsMessages.this.getAuthRequestContext.scheduleImpl())) {
                    try {
                        getAuthRequestContext(mPDbAdapter, str, MPDbAdapter.Table.EVENTS, AnalyticsMessages.this.getAuthRequestContext.scheduleImpl);
                        getAuthRequestContext(mPDbAdapter, str, MPDbAdapter.Table.PEOPLE, AnalyticsMessages.this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda8);
                        getAuthRequestContext(mPDbAdapter, str, MPDbAdapter.Table.GROUPS, AnalyticsMessages.this.getAuthRequestContext.lookAheadTest);
                        int i = GetContactSyncConfig + 13;
                        NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                        if (i % 2 == 0) {
                            Object[] objArr = null;
                            int length = objArr.length;
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 3;
                GetContactSyncConfig = i2 % 128;
                if (!(i2 % 2 != 0)) {
                    AnalyticsMessages analyticsMessages2 = AnalyticsMessages.this;
                    AnalyticsMessages.PlaceComponentResult("Not flushing data to Mixpanel because the device is not connected to the internet.");
                    return;
                }
                try {
                    AnalyticsMessages analyticsMessages3 = AnalyticsMessages.this;
                    AnalyticsMessages.PlaceComponentResult("Not flushing data to Mixpanel because the device is not connected to the internet.");
                    int i3 = 35 / 0;
                } catch (Exception e2) {
                    throw e2;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
            /* JADX WARN: Removed duplicated region for block: B:146:0x02dc  */
            /* JADX WARN: Removed duplicated region for block: B:147:0x02de  */
            /* JADX WARN: Removed duplicated region for block: B:149:0x02e1  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:180:0x031b A[SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private void getAuthRequestContext(com.mixpanel.android.mpmetrics.MPDbAdapter r29, java.lang.String r30, com.mixpanel.android.mpmetrics.MPDbAdapter.Table r31, java.lang.String r32) {
                /*
                    Method dump skipped, instructions count: 883
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler.getAuthRequestContext(com.mixpanel.android.mpmetrics.MPDbAdapter, java.lang.String, com.mixpanel.android.mpmetrics.MPDbAdapter$Table, java.lang.String):void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:86:0x01bd, code lost:
            
                if (r0.getType() == 0) goto L93;
             */
            /* JADX WARN: Code restructure failed: missing block: B:92:0x01cd, code lost:
            
                if ((r0.getType() == 1 ? 14 : kotlin.text.Typography.quote) != '\"') goto L93;
             */
            /* JADX WARN: Code restructure failed: missing block: B:94:0x01d3, code lost:
            
                if (r0.isConnected() != false) goto L96;
             */
            /* JADX WARN: Code restructure failed: missing block: B:96:0x01d6, code lost:
            
                r0 = true;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private org.json.JSONObject MyBillsEntityDataFactory() throws org.json.JSONException {
                /*
                    Method dump skipped, instructions count: 782
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler.MyBillsEntityDataFactory():org.json.JSONObject");
            }

            private JSONObject PlaceComponentResult(EventDescription eventDescription) throws JSONException {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = eventDescription.MyBillsEntityDataFactory;
                JSONObject MyBillsEntityDataFactory = MyBillsEntityDataFactory();
                MyBillsEntityDataFactory.put("token", eventDescription.getAuthRequestContext);
                if (!(jSONObject2 == null)) {
                    int i = GetContactSyncConfig + 77;
                    NetworkUserEntityData$$ExternalSyntheticLambda1 = i % 128;
                    int i2 = i % 2;
                    try {
                        Iterator<String> keys = jSONObject2.keys();
                        while (true) {
                            if ((keys.hasNext() ? 'L' : (char) 22) != 'L') {
                                break;
                            }
                            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda1 + 45;
                            GetContactSyncConfig = i3 % 128;
                            int i4 = i3 % 2;
                            String next = keys.next();
                            MyBillsEntityDataFactory.put(next, jSONObject2.get(next));
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
                jSONObject.put("event", eventDescription.BuiltInFictitiousFunctionClassFactory);
                jSONObject.put("properties", MyBillsEntityDataFactory);
                jSONObject.put("$mp_metadata", eventDescription.KClassImpl$Data$declaredNonStaticMembers$2);
                return jSONObject;
            }

            private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
                E e = new E();
                int length = cArr2.length;
                char[] cArr4 = new char[length];
                int length2 = cArr3.length;
                char[] cArr5 = new char[length2];
                System.arraycopy(cArr2, 0, cArr4, 0, length);
                System.arraycopy(cArr3, 0, cArr5, 0, length2);
                cArr4[0] = (char) (cArr4[0] ^ c);
                cArr5[2] = (char) (cArr5[2] + ((char) i));
                int length3 = cArr.length;
                char[] cArr6 = new char[length3];
                e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                int i2 = $10 + 47;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                while (true) {
                    if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? 'P' : (char) 28) != 28) {
                        int i4 = $11 + 5;
                        $10 = i4 % 128;
                        int i5 = i4 % 2;
                        int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                        int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                        e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
                        cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
                        cArr4[i7] = e.MyBillsEntityDataFactory;
                        cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getErrorConfigVersion ^ 4360990799332652212L)) ^ ((int) (DatabaseTableConfigUtil ^ 4360990799332652212L))) ^ ((char) (initRecordTimeStamp ^ 4360990799332652212L)));
                        e.KClassImpl$Data$declaredNonStaticMembers$2++;
                    } else {
                        objArr[0] = new String(cArr6);
                        return;
                    }
                }
            }
        }

        static /* synthetic */ void getAuthRequestContext(Worker worker) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = worker.getAuthRequestContext;
            long j2 = 1 + j;
            long j3 = worker.getErrorConfigVersion;
            if (j3 > 0) {
                long j4 = ((currentTimeMillis - j3) + (worker.BuiltInFictitiousFunctionClassFactory * j)) / j2;
                worker.BuiltInFictitiousFunctionClassFactory = j4;
                AnalyticsMessages analyticsMessages = AnalyticsMessages.this;
                StringBuilder sb = new StringBuilder();
                sb.append("Average send frequency approximately ");
                sb.append(j4 / 1000);
                sb.append(" seconds.");
                AnalyticsMessages.PlaceComponentResult(sb.toString());
            }
            worker.getErrorConfigVersion = currentTimeMillis;
            worker.getAuthRequestContext = j2;
        }
    }

    /* loaded from: classes.dex */
    static class GroupDescription extends MixpanelMessageDescription {
        public String toString() {
            return this.MyBillsEntityDataFactory.toString();
        }
    }

    static /* synthetic */ void PlaceComponentResult(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (Thread ");
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
            Object[] objArr = new Object[1];
            a(b, b, KClassImpl$Data$declaredNonStaticMembers$2[16], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            Object[] objArr2 = new Object[1];
            a(b2, b2, KClassImpl$Data$declaredNonStaticMembers$2[15], objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
            sb.append(")");
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Messages", sb.toString());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (Thread ");
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
            Object[] objArr = new Object[1];
            a(b, b, KClassImpl$Data$declaredNonStaticMembers$2[16], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            Object[] objArr2 = new Object[1];
            a(b2, b2, KClassImpl$Data$declaredNonStaticMembers$2[15], objArr2);
            sb.append(((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId());
            sb.append(")");
            MPLog.MyBillsEntityDataFactory("MixpanelAPI.Messages", sb.toString(), th);
        } catch (Throwable th2) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                throw th2;
            }
            throw cause;
        }
    }
}
