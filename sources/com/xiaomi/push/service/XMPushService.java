package com.xiaomi.push.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.zxing.pdf417.PDF417Common;
import com.xiaomi.channel.commonutils.android.Region;
import com.xiaomi.push.au;
import com.xiaomi.push.cl;
import com.xiaomi.push.cq;
import com.xiaomi.push.cu;
import com.xiaomi.push.cx;
import com.xiaomi.push.cz;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.ee;
import com.xiaomi.push.ej;
import com.xiaomi.push.service.az;
import com.xiaomi.push.service.n;
import com.xiaomi.push.service.o;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes8.dex */
public class XMPushService extends Service implements com.xiaomi.push.bv {
    private static int[] PlaceComponentResult;
    private static boolean b;

    /* renamed from: a */
    private ContentObserver f394a;

    /* renamed from: a */
    private com.xiaomi.push.bp f396a;

    /* renamed from: a */
    private com.xiaomi.push.bt f397a;

    /* renamed from: a */
    private com.xiaomi.push.bu f398a;

    /* renamed from: a */
    private a f400a;

    /* renamed from: a */
    private f f401a;

    /* renamed from: a */
    private k f402a;

    /* renamed from: a */
    private r f403a;

    /* renamed from: a */
    private t f404a;

    /* renamed from: a */
    private bi f406a;

    /* renamed from: a */
    private com.xiaomi.push.service.j f407a;
    public static final byte[] $$a = {Ascii.GS, SignedBytes.MAX_POWER_OF_TWO, 35, 67, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 207;
    public static final byte[] getAuthRequestContext = {33, -64, 37, -91, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 73;

    /* renamed from: a */
    private boolean f412a = false;

    /* renamed from: a */
    private int f7792a = 0;

    /* renamed from: b */
    private int f413b = 0;

    /* renamed from: a */
    private long f393a = 0;

    /* renamed from: a */
    protected Class f409a = XMJobService.class;

    /* renamed from: a */
    private ax f405a = null;

    /* renamed from: a */
    private com.xiaomi.push.service.o f408a = null;

    /* renamed from: a */
    Messenger f395a = null;

    /* renamed from: a */
    private Collection<ak> f411a = Collections.synchronizedCollection(new ArrayList());

    /* renamed from: a */
    private ArrayList<n> f410a = new ArrayList<>();

    /* renamed from: a */
    private com.xiaomi.push.bx f399a = new bx(this);

    /* loaded from: classes8.dex */
    public class b extends j {
        az.b BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(az.b bVar) {
            super(9);
            XMPushService.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            String obj;
            try {
                if (!XMPushService.this.m394d()) {
                    com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("trying bind while the connection is not created, quit!");
                    return;
                }
                az.b MyBillsEntityDataFactory = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance, this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil);
                if (MyBillsEntityDataFactory == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ignore bind because the channel ");
                    sb.append(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance);
                    sb.append(" is removed ");
                    obj = sb.toString();
                } else if (MyBillsEntityDataFactory.lookAheadTest == az.c.unbind) {
                    MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(az.c.binding, 0, 0, (String) null, (String) null);
                    XMPushService.this.f397a.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
                    return;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("trying duplicate bind, ingore! ");
                    sb2.append(MyBillsEntityDataFactory.lookAheadTest);
                    obj = sb2.toString();
                }
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(obj);
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Meet error when trying to bind. ");
                sb3.append(e);
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb3.toString());
                XMPushService.this.a(10, e);
            } catch (Throwable unused) {
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            StringBuilder sb = new StringBuilder();
            sb.append("bind the client. ");
            sb.append(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance);
            return sb.toString();
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends j {
        private final az.b MyBillsEntityDataFactory;

        public c(az.b bVar) {
            super(12);
            this.MyBillsEntityDataFactory = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(az.c.unbind, 1, 21, (String) null, (String) null);
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return TextUtils.equals(((c) obj).MyBillsEntityDataFactory.newProxyInstance, this.MyBillsEntityDataFactory.newProxyInstance);
            }
            return false;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            StringBuilder sb = new StringBuilder();
            sb.append("bind time out. chid=");
            sb.append(this.MyBillsEntityDataFactory.newProxyInstance);
            return sb.toString();
        }

        public int hashCode() {
            return this.MyBillsEntityDataFactory.newProxyInstance.hashCode();
        }
    }

    /* loaded from: classes8.dex */
    public class e extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            XMPushService.this = r1;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            if (XMPushService.this.m392b()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                    return;
                }
            }
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("should not connect. quit the job.");
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            return "do reconnect..";
        }
    }

    /* loaded from: classes8.dex */
    public class f extends BroadcastReceiver {
        f() {
            XMPushService.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb = new StringBuilder();
            sb.append("network changed, ");
            sb.append(com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2(intent));
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes8.dex */
    public class g extends j {
        public Exception BuiltInFictitiousFunctionClassFactory;
        public int PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i) {
            super(2);
            XMPushService.this = r1;
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = null;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            XMPushService.this.a(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            return "disconnect the connection.";
        }
    }

    /* loaded from: classes8.dex */
    class h extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h() {
            super(65535);
            XMPushService.this = r1;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            XMPushService.this.c();
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            return "Init Job";
        }
    }

    /* loaded from: classes8.dex */
    class i extends j {
        private Intent PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Intent intent) {
            super(15);
            XMPushService.this = r1;
            this.PlaceComponentResult = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            XMPushService.this.d(this.PlaceComponentResult);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            StringBuilder sb = new StringBuilder();
            sb.append("Handle intent action = ");
            sb.append(this.PlaceComponentResult.getAction());
            return sb.toString();
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class j extends o.b {
        public j(int i) {
            super(i);
        }

        public abstract void KClassImpl$Data$declaredNonStaticMembers$2();

        public abstract String getAuthRequestContext();

        @Override // java.lang.Runnable
        public void run() {
            if (this.lookAheadTest != 4 && this.lookAheadTest != 8) {
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(com.xiaomi.channel.commonutils.logger.a.MyBillsEntityDataFactory, getAuthRequestContext());
            }
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    /* loaded from: classes8.dex */
    class k extends BroadcastReceiver {
        k() {
            XMPushService.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb = new StringBuilder();
            sb.append("[HB] hold short heartbeat, ");
            sb.append(com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2(intent));
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes8.dex */
    public interface n {
        void MyBillsEntityDataFactory();
    }

    /* loaded from: classes8.dex */
    public class o extends j {
        boolean MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(boolean z) {
            super(4);
            XMPushService.this = r1;
            this.MyBillsEntityDataFactory = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            if (XMPushService.this.m394d()) {
                try {
                    XMPushService.this.f397a.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                } catch (com.xiaomi.push.cd e) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                    XMPushService.this.a(10, e);
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            return "send ping..";
        }
    }

    /* loaded from: classes8.dex */
    public class p extends j {
        az.b BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(az.b bVar) {
            super(4);
            XMPushService.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = bVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            try {
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(az.c.unbind, 1, 16, (String) null, (String) null);
                XMPushService.this.f397a.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance, this.BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil);
                XMPushService xMPushService = XMPushService.this;
                xMPushService.a(new b(this.BuiltInFictitiousFunctionClassFactory), 300L);
            } catch (com.xiaomi.push.cd e) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                XMPushService.this.a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            StringBuilder sb = new StringBuilder();
            sb.append("rebind the client. ");
            sb.append(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance);
            return sb.toString();
        }
    }

    /* loaded from: classes8.dex */
    public class q extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q() {
            super(3);
            XMPushService.this = r1;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            XMPushService.this.a(11, (Exception) null);
            if (XMPushService.this.m392b()) {
                XMPushService xMPushService = XMPushService.this;
                if (xMPushService.a(xMPushService.getApplicationContext())) {
                    XMPushService.this.f();
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            return "reset the connection.";
        }
    }

    /* loaded from: classes8.dex */
    class r extends BroadcastReceiver {
        r() {
            XMPushService.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.onStart(intent, 1);
        }
    }

    /* loaded from: classes8.dex */
    public class s extends j {
        String BuiltInFictitiousFunctionClassFactory;
        String KClassImpl$Data$declaredNonStaticMembers$2;
        az.b MyBillsEntityDataFactory;
        int getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(az.b bVar, int i, String str, String str2) {
            super(9);
            XMPushService.this = r1;
            this.MyBillsEntityDataFactory = bVar;
            this.getAuthRequestContext = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.MyBillsEntityDataFactory.lookAheadTest != az.c.unbind && XMPushService.this.f397a != null) {
                try {
                    XMPushService.this.f397a.PlaceComponentResult(this.MyBillsEntityDataFactory.newProxyInstance, this.MyBillsEntityDataFactory.DatabaseTableConfigUtil);
                } catch (com.xiaomi.push.cd e) {
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                    XMPushService.this.a(10, e);
                }
            }
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(az.c.unbind, this.getAuthRequestContext, 0, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            StringBuilder sb = new StringBuilder();
            sb.append("unbind the channel. ");
            sb.append(this.MyBillsEntityDataFactory.newProxyInstance);
            return sb.toString();
        }
    }

    /* loaded from: classes8.dex */
    class t extends BroadcastReceiver {
        t() {
            XMPushService.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!XMPushService.this.f412a) {
                XMPushService.this.f412a = true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[HB] wifi changed, ");
            sb.append(com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2(intent));
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            XMPushService.this.onStart(intent, 1);
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult = new int[]{196389253, -1400733758, -617862214, 1059067476, 2012223032, 1249306525, -364296772, -746163761, -660009612, 1331608, -1103752116, 593626412, 1382552272, -404637754, 2055114059, 1348397256, -2095340054, 663302472};
    }

    private az.b a(String str, Intent intent) {
        az.b MyBillsEntityDataFactory = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(str, intent.getStringExtra(bd.getSupportButtonTintMode));
        if (MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory = new az.b(this);
        }
        MyBillsEntityDataFactory.newProxyInstance = intent.getStringExtra(bd.A);
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = intent.getStringExtra(bd.getSupportButtonTintMode);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = intent.getStringExtra(bd.B);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = intent.getStringExtra(bd.PlaceComponentResult);
        MyBillsEntityDataFactory.GetContactSyncConfig = intent.getStringExtra(bd.getAuthRequestContext);
        MyBillsEntityDataFactory.PrepareContext = intent.getStringExtra(bd.MyBillsEntityDataFactory);
        MyBillsEntityDataFactory.scheduleImpl = intent.getBooleanExtra(bd.getOnBoardingScenario, false);
        MyBillsEntityDataFactory.isLayoutRequested = intent.getStringExtra(bd.C);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = intent.getStringExtra(bd.NetworkUserEntityData$$ExternalSyntheticLambda0);
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = intent.getStringExtra(bd.VerifyPinStateManager$executeRiskChallenge$2$1);
        MyBillsEntityDataFactory.getErrorConfigVersion = this.f407a;
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory((Messenger) intent.getParcelableExtra(bd.GetContactSyncConfig));
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = getApplicationContext();
        az.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(MyBillsEntityDataFactory);
        return MyBillsEntityDataFactory;
    }

    private String a() {
        String KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2("ro.miui.region");
        return TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$22) ? com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2("ro.product.locale.region") : KClassImpl$Data$declaredNonStaticMembers$22;
    }

    private void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (IllegalArgumentException e2) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e2);
            }
        }
    }

    private void a(Intent intent, int i2) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        dt dtVar = new dt();
        try {
            ee.BuiltInFictitiousFunctionClassFactory(dtVar, byteArrayExtra);
            com.xiaomi.push.o.PlaceComponentResult(getApplicationContext()).KClassImpl$Data$declaredNonStaticMembers$2(new com.xiaomi.push.service.b(dtVar, new WeakReference(this), booleanExtra), i2);
        } catch (ej unused) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("aw_ping : send help app ping  error");
        }
    }

    private void a(com.xiaomi.push.service.a aVar) {
        String str;
        StringBuilder sb;
        if (aVar == null || !TextUtils.isEmpty(aVar.PlaceComponentResult()) || TextUtils.isEmpty(aVar.KClassImpl$Data$declaredNonStaticMembers$2())) {
            str = "no need to check country code";
        } else {
            String a2 = "com.xiaomi.xmsf".equals(getPackageName()) ? a() : com.xiaomi.channel.commonutils.android.f.KClassImpl$Data$declaredNonStaticMembers$2();
            if (!TextUtils.isEmpty(a2)) {
                String MyBillsEntityDataFactory = com.xiaomi.channel.commonutils.android.f.MyBillsEntityDataFactory(a2);
                if (TextUtils.equals(MyBillsEntityDataFactory, aVar.KClassImpl$Data$declaredNonStaticMembers$2())) {
                    aVar.KClassImpl$Data$declaredNonStaticMembers$2(a2);
                    sb = new StringBuilder();
                    sb.append("update country code： ");
                    sb.append(a2);
                } else {
                    sb = new StringBuilder();
                    sb.append("not update country code, because not equals ");
                    sb.append(MyBillsEntityDataFactory);
                }
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                return;
            }
            str = "check no country code";
        }
        com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(str);
    }

    private static void a(String str) {
        String str2;
        String str3 = "resolver.msg.global.xiaomi.net";
        if (Region.Global.name().equals(str)) {
            com.xiaomi.push.ak.MyBillsEntityDataFactory("app.chat.global.xiaomi.net", "app.chat.global.xiaomi.net");
            com.xiaomi.push.ak.MyBillsEntityDataFactory("resolver.msg.global.xiaomi.net", "47.241.174.254:443");
            str2 = "47.241.56.51:443";
        } else if (Region.Europe.name().equals(str)) {
            com.xiaomi.push.ak.MyBillsEntityDataFactory("fr.app.chat.global.xiaomi.net", "fr.app.chat.global.xiaomi.net");
            str3 = "fr.resolver.msg.global.xiaomi.net";
            str2 = "fr-resolver-msg-global-xiaomi-n-916220403.eu-central-1.elb.amazonaws.com";
        } else if (Region.Russia.name().equals(str)) {
            com.xiaomi.push.ak.MyBillsEntityDataFactory("ru.app.chat.global.xiaomi.net", "ru.app.chat.global.xiaomi.net");
            str3 = "ru.resolver.msg.global.xiaomi.net";
            str2 = "107.155.52.31:443";
        } else if (!Region.India.name().equals(str)) {
            return;
        } else {
            com.xiaomi.push.ak.MyBillsEntityDataFactory("idmb.app.chat.global.xiaomi.net", "idmb.app.chat.global.xiaomi.net");
            str3 = "mb.resolver.msg.global.xiaomi.net";
            str2 = "resolver-msg-xiaomi-net-665721575.ap-south-1.elb.amazonaws.com";
        }
        com.xiaomi.push.ak.MyBillsEntityDataFactory(str3, str2);
    }

    private void a(String str, int i2) {
        Collection<az.b> authRequestContext = az.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(str);
        if (authRequestContext != null) {
            for (az.b bVar : authRequestContext) {
                if (bVar != null) {
                    a(new s(bVar, i2, null, null));
                }
            }
        }
        az.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(str);
    }

    public boolean a(Context context) {
        int i2;
        try {
            com.xiaomi.push.u.BuiltInFictitiousFunctionClassFactory();
        } catch (Exception unused) {
        }
        for (i2 = 100; i2 > 0; i2--) {
            if (com.xiaomi.push.y.BuiltInFictitiousFunctionClassFactory(context)) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("network connectivity ok.");
                return true;
            }
            try {
                Thread.sleep(100L);
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m378a(String str, Intent intent) {
        az.b MyBillsEntityDataFactory = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(str, intent.getStringExtra(bd.getSupportButtonTintMode));
        boolean z = false;
        if (MyBillsEntityDataFactory == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(bd.NetworkUserEntityData$$ExternalSyntheticLambda0);
        String stringExtra2 = intent.getStringExtra(bd.C);
        if (!TextUtils.isEmpty(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8) && !TextUtils.equals(stringExtra, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
            StringBuilder sb = new StringBuilder();
            sb.append("session changed. old session=");
            sb.append(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8);
            sb.append(", new session=");
            sb.append(stringExtra);
            sb.append(" chid = ");
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            z = true;
        }
        if (stringExtra2.equals(MyBillsEntityDataFactory.isLayoutRequested)) {
            return z;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("security changed. chid = ");
        sb2.append(str);
        sb2.append(" sechash = ");
        sb2.append(com.xiaomi.push.ac.BuiltInFictitiousFunctionClassFactory(stringExtra2));
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        return true;
    }

    /* renamed from: a */
    private int[] m379a() {
        String[] split;
        if (TextUtils.isEmpty("") || (split = "".split(",")) == null || split.length < 2) {
            return null;
        }
        int[] iArr = new int[2];
        try {
            iArr[0] = Integer.valueOf(split[0]).intValue();
            int intValue = Integer.valueOf(split[1]).intValue();
            iArr[1] = intValue;
            int i2 = iArr[0];
            if (i2 < 0 || i2 > 23 || intValue < 0 || intValue > 23 || i2 == intValue) {
                return null;
            }
            return iArr;
        } catch (NumberFormatException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse falldown time range failure: ");
            sb.append(e2);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            return null;
        }
    }

    private String b() {
        com.xiaomi.push.u.BuiltInFictitiousFunctionClassFactory();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object obj = new Object();
        String str = null;
        if ("com.xiaomi.xmsf".equals(getPackageName())) {
            bf PlaceComponentResult2 = bf.PlaceComponentResult(this);
            while (true) {
                if (!TextUtils.isEmpty(str) && PlaceComponentResult2.MyBillsEntityDataFactory() != 0) {
                    break;
                }
                if (TextUtils.isEmpty(str)) {
                    str = a();
                }
                try {
                    synchronized (obj) {
                        obj.wait(100L);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("wait countryCode :");
        sb.append(str);
        sb.append(" cost = ");
        sb.append(elapsedRealtime2 - elapsedRealtime);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        return str;
    }

    private void b(boolean z) {
        if (com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory() || !z) {
            return;
        }
        com.xiaomi.push.ak.PlaceComponentResult();
    }

    public void c() {
        com.xiaomi.push.ak.MyBillsEntityDataFactory();
        com.xiaomi.push.ak.getErrorConfigVersion();
        boolean m388a = m388a();
        if (m384i() && m388a) {
            ch chVar = new ch(this);
            a(chVar);
            com.xiaomi.push.service.r.MyBillsEntityDataFactory(new ci(this, chVar));
        }
        try {
            if (com.xiaomi.channel.commonutils.android.j.MyBillsEntityDataFactory()) {
                com.xiaomi.push.service.j.getAuthRequestContext(this);
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e2);
        }
    }

    private void c(boolean z) {
        this.f393a = SystemClock.elapsedRealtime();
        if (m394d()) {
            if (com.xiaomi.push.y.MyBillsEntityDataFactory(this)) {
                c(new o(z));
                return;
            }
            c(new g(17));
        }
        a(true);
    }

    private void d(boolean z) {
        try {
            if (com.xiaomi.channel.commonutils.android.j.MyBillsEntityDataFactory()) {
                if (!z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                for (ak akVar : (ak[]) this.f411a.toArray(new ak[0])) {
                    akVar.PlaceComponentResult();
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e2);
        }
    }

    public void e() {
        if (!m392b()) {
            com.xiaomi.push.bc.MyBillsEntityDataFactory();
        } else if (com.xiaomi.push.bc.KClassImpl$Data$declaredNonStaticMembers$2()) {
        } else {
            com.xiaomi.push.bc.BuiltInFictitiousFunctionClassFactory(true);
        }
    }

    /* renamed from: f */
    public static boolean m381f() {
        return b;
    }

    private void g() {
        try {
            this.f396a.PlaceComponentResult(this.f399a, new ca(this));
            this.f396a.initRecordTimeStamp();
            this.f397a = this.f396a;
        } catch (com.xiaomi.push.cd e2) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("fail to create Slim connection", e2);
            this.f396a.getAuthRequestContext(3, e2);
        }
    }

    /* renamed from: g */
    private boolean m382g() {
        if (SystemClock.elapsedRealtime() - this.f393a < 30000) {
            return false;
        }
        return com.xiaomi.push.y.PlaceComponentResult(this);
    }

    private void h() {
    }

    /* renamed from: h */
    public boolean m383h() {
        return "com.xiaomi.xmsf".equals(getPackageName()) && Settings.System.getInt(getContentResolver(), "power_supersave_mode_open", 0) == 1;
    }

    private void i() {
        synchronized (this.f410a) {
            this.f410a.clear();
        }
    }

    /* renamed from: i */
    private boolean m384i() {
        boolean KClassImpl$Data$declaredNonStaticMembers$22;
        if (com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory() && "com.xiaomi.xmsf".equals(getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("current sdk expect region is global");
            KClassImpl$Data$declaredNonStaticMembers$22 = "China".equals(com.xiaomi.push.service.a.BuiltInFictitiousFunctionClassFactory(getApplicationContext()).KClassImpl$Data$declaredNonStaticMembers$2());
        } else {
            KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.push.service.s.getAuthRequestContext(this).KClassImpl$Data$declaredNonStaticMembers$2(getPackageName());
        }
        return !KClassImpl$Data$declaredNonStaticMembers$22;
    }

    private boolean j() {
        return getApplicationContext().getPackageName().equals("com.xiaomi.xmsf") && k() && !com.xiaomi.channel.commonutils.android.c.BuiltInFictitiousFunctionClassFactory(this) && !com.xiaomi.channel.commonutils.android.c.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext());
    }

    private boolean k() {
        int intValue = Integer.valueOf(String.format("%tH", new Date())).intValue();
        int i2 = this.f7792a;
        int i3 = this.f413b;
        if (i2 > i3) {
            if (intValue >= i2 || intValue < i3) {
                return true;
            }
        } else if (i2 < i3 && intValue >= i2 && intValue < i3) {
            return true;
        }
        return false;
    }

    private boolean l() {
        TextUtils.equals(getPackageName(), "com.xiaomi.xmsf");
        return false;
    }

    private static void m(short s2, byte b2, int i2, Object[] objArr) {
        int i3 = 106 - i2;
        int i4 = s2 + 4;
        int i5 = 16 - (b2 * 3);
        byte[] bArr = getAuthRequestContext;
        byte[] bArr2 = new byte[i5];
        int i6 = -1;
        int i7 = i5 - 1;
        if (bArr == null) {
            i3 = i7 + i4 + 2;
            i4 = i4;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
        }
        while (true) {
            int i8 = i6 + 1;
            bArr2[i8] = (byte) i3;
            int i9 = i4 + 1;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = i3 + bArr[i9] + 2;
            i4 = i9;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i8;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void n(short r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 2
            int r9 = 103 - r9
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r0 = com.xiaomi.push.service.XMPushService.$$a
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r9 = r8
            r3 = r9
            r4 = 0
            r8 = r7
            goto L2c
        L16:
            r3 = 0
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2c:
            int r3 = -r3
            int r9 = r9 + 1
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.n(short, int, byte, java.lang.Object[]):void");
    }

    /* renamed from: a */
    public com.xiaomi.push.bt m385a() {
        return this.f397a;
    }

    /* renamed from: a */
    public com.xiaomi.push.service.j m386a() {
        return new com.xiaomi.push.service.j();
    }

    /* renamed from: a */
    void m387a() {
        if (SystemClock.elapsedRealtime() - this.f393a >= com.xiaomi.push.by.getAuthRequestContext() && com.xiaomi.push.y.PlaceComponentResult(this)) {
            c(true);
        }
    }

    public void a(int i2, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("disconnect ");
        sb.append(hashCode());
        sb.append(", ");
        com.xiaomi.push.bt btVar = this.f397a;
        sb.append(btVar == null ? null : Integer.valueOf(btVar.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        com.xiaomi.push.bt btVar2 = this.f397a;
        if (btVar2 != null) {
            btVar2.getAuthRequestContext(i2, exc);
            this.f397a = null;
        }
        a(7);
        a(4);
        az.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(i2);
    }

    public void a(com.xiaomi.push.bi biVar) {
        com.xiaomi.push.bt btVar = this.f397a;
        if (btVar == null) {
            throw new com.xiaomi.push.cd("try send msg while connection is null.");
        }
        btVar.PlaceComponentResult(biVar);
    }

    @Override // com.xiaomi.push.bv
    public void a(com.xiaomi.push.bt btVar) {
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("begin to connect...");
    }

    @Override // com.xiaomi.push.bv
    public void a(com.xiaomi.push.bt btVar, int i2, Exception exc) {
        if (j()) {
            return;
        }
        a(false);
    }

    @Override // com.xiaomi.push.bv
    public void a(com.xiaomi.push.bt btVar, Exception exc) {
        d(false);
        if (j()) {
            return;
        }
        a(false);
    }

    public void a(j jVar) {
        a(jVar, 0L);
    }

    public void a(n nVar) {
        synchronized (this.f410a) {
            this.f410a.add(nVar);
        }
    }

    public void a(String str, String str2, int i2, String str3, String str4) {
        az.b MyBillsEntityDataFactory = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(str, str2);
        if (MyBillsEntityDataFactory != null) {
            a(new s(MyBillsEntityDataFactory, i2, str4, str3));
        }
        az.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(str, str2);
    }

    public void a(String str, byte[] bArr, boolean z) {
        Collection<az.b> authRequestContext = az.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext("5");
        if (authRequestContext.isEmpty()) {
            if (!z) {
                return;
            }
        } else if (authRequestContext.iterator().next().lookAheadTest == az.c.binded) {
            a(new by(this, str, bArr));
            return;
        } else if (!z) {
            return;
        }
        u.MyBillsEntityDataFactory(str, bArr);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            u.BuiltInFictitiousFunctionClassFactory(this, str, bArr, 70000003, "null payload");
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("register request without payload");
            return;
        }
        dq dqVar = new dq();
        try {
            ee.BuiltInFictitiousFunctionClassFactory(dqVar, bArr);
            if (dqVar.f222a != cz.Registration) {
                u.BuiltInFictitiousFunctionClassFactory(this, str, bArr, 70000003, " registration action required.");
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("register request with invalid payload");
                return;
            }
            du duVar = new du();
            try {
                ee.BuiltInFictitiousFunctionClassFactory(duVar, dqVar.m314a());
                a(new com.xiaomi.push.service.t(this, dqVar.b(), duVar.b(), duVar.c(), bArr));
            } catch (ej e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("app register error. ");
                sb.append(e2);
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
                u.BuiltInFictitiousFunctionClassFactory(this, str, bArr, 70000003, " data action error.");
            }
        } catch (ej e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("app register fail. ");
            sb2.append(e3);
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
            u.BuiltInFictitiousFunctionClassFactory(this, str, bArr, 70000003, " data container error.");
        }
    }

    public void a(com.xiaomi.push.bi[] biVarArr) {
        com.xiaomi.push.bt btVar = this.f397a;
        if (btVar == null) {
            throw new com.xiaomi.push.cd("try send msg while connection is null.");
        }
        btVar.getAuthRequestContext(biVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0118  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m388a() {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.m388a():boolean");
    }

    /* renamed from: a */
    public boolean m389a(int i2) {
        return this.f408a.KClassImpl$Data$declaredNonStaticMembers$2(i2);
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        o(KeyEvent.normalizeMetaState(0) + 18, new int[]{1397153751, 2059287705, 1827337338, 104944004, -1097763837, -1570518474, 1455766992, -1855940030, -2106095408, 2016117893}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        o((KeyEvent.getMaxKeyCode() >> 16) + 5, new int[]{-218793522, -708874484, 1892200437, 415742354}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    o((Process.myTid() >> 22) + 48, new int[]{1270127336, 27402130, -1658871299, -485766234, 202282041, 1323999509, -2060660779, 1030534381, 92330462, 227656037, 1618095216, -1688032002, 1703886256, -164770223, -153364153, -779299493, -1897945088, 1716397085, -641549238, 1650341198, 1602257656, 1698208283, 1050242886, -2068533237}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    o(64 - (ViewConfiguration.getScrollBarSize() >> 8), new int[]{1900662582, 645338018, 761142835, -1719676087, -454330855, -1152813195, 1370297749, 951543806, -1415236153, -1094120379, 496188790, -348792153, 1932744265, 1776290679, 780947660, -759492316, 38055131, 2046762691, -1209033829, 263194406, 58529535, 902423969, 167758816, -1053061739, -1110877320, 102346562, -1328352392, 598194832, 987810180, -342841297, -61546080, 1153576009}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    o(MotionEvent.axisFromString("") + 65, new int[]{-1665543460, 1153821900, 860872279, 693232930, 1847694476, -173196312, -347945893, 1282308370, -719133228, 2065900327, 154337529, -465107155, -512734981, -488412420, 1480934340, 1246994982, 2082643009, -671795213, 1386197403, 119730009, -2073508694, -1968090426, -1682219112, 1261623507, 2130786762, -275852094, -682999540, -1869231003, 1186206049, -1121178652, -812986422, -453734577}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    o(60 - TextUtils.getCapsMode("", 0, 0), new int[]{2101094642, 666715446, 572243334, -1153833472, -1574427025, 16870588, -1378288368, 1646316971, -1907683772, 455911805, 150493370, -783464652, 1760038918, 1199095803, -1033895923, 5003227, 830789029, 1220124144, -1310456209, 1616213435, 945493238, -1667605184, -2097038353, 1507662536, -1591714336, 110758289, 1202862946, 85238918, 246412662, -1855036757}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    o(TextUtils.getOffsetBefore("", 0) + 6, new int[]{678246226, 177905996, 784239909, -5517479}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                byte b2 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr13 = new Object[1];
                m((short) 14, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = getAuthRequestContext[5];
                Object[] objArr14 = new Object[1];
                m(b3, (byte) (b3 + 1), (byte) (-getAuthRequestContext[5]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Color.alpha(0), 3 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                        byte b4 = $$a[47];
                        Object[] objArr16 = new Object[1];
                        n(b4, (byte) (b4 - 1), (byte) (-$$a[12]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getTapTimeout() >> 16), (-16777201) - Color.rgb(0, 0, 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 800, 15 - TextUtils.indexOf("", "", 0), (char) (Process.getGidForName("") + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 30, (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 800, 15 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (Process.myTid() >> 22)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j2 = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 'S' - AndroidCharacter.getMirror('0'), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1377156881, Long.valueOf(j2), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), 18 - TextUtils.indexOf("", ""), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
                                        } catch (Throwable th3) {
                                            Throwable cause3 = th3.getCause();
                                            if (cause3 == null) {
                                                throw th3;
                                            }
                                            throw cause3;
                                        }
                                    } catch (Throwable th4) {
                                        Throwable cause4 = th4.getCause();
                                        if (cause4 == null) {
                                            throw th4;
                                        }
                                        throw cause4;
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr19 = {this};
                byte b5 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr20 = new Object[1];
                m((short) 14, b5, b5, objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b6 = getAuthRequestContext[5];
                Object[] objArr21 = new Object[1];
                m(b6, (byte) (b6 + 1), (byte) (-getAuthRequestContext[5]), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 61, (ViewConfiguration.getTouchSlop() >> 8) + 46, (char) View.getDefaultSize(0, 0));
                        byte b7 = (byte) ($$a[47] - 1);
                        Object[] objArr23 = new Object[1];
                        n(b7, (byte) (b7 | Ascii.ETB), (byte) ($$a[47] - 1), objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i2 = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr25 = {1377156881, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr26 = {this};
                byte b8 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr27 = new Object[1];
                m((short) 14, b8, b8, objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b9 = getAuthRequestContext[5];
                Object[] objArr28 = new Object[1];
                m(b9, (byte) (b9 + 1), (byte) (-getAuthRequestContext[5]), objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - KeyEvent.getDeadChar(0, 0), 3 - Color.blue(0), (char) (38967 - ImageFormat.getBitsPerPixel(0)));
                        byte b10 = (byte) ($$a[47] - 1);
                        Object[] objArr30 = new Object[1];
                        n(b10, (byte) (b10 | Ascii.ETB), (byte) ($$a[47] - 1), objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i3 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, Color.alpha(0) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {1377156881, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 17 - Process.getGidForName(""), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr33 = {this};
                byte b11 = (byte) (getAuthRequestContext[5] + 1);
                Object[] objArr34 = new Object[1];
                m((short) 14, b11, b11, objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b12 = getAuthRequestContext[5];
                Object[] objArr35 = new Object[1];
                m(b12, (byte) (b12 + 1), (byte) (-getAuthRequestContext[5]), objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 107, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 2, (char) View.resolveSize(0, 0));
                        Object[] objArr37 = new Object[1];
                        n((byte) (-$$a[8]), (byte) (-$$a[53]), (byte) (-$$a[9]), objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i4 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i4) {
                        long j5 = ((r1 ^ i4) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), Color.argb(0, 0, 0, 0) + 35, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr39 = {1377156881, Long.valueOf(j5), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.blue(0), View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    /* renamed from: b */
    public com.xiaomi.push.service.j m390b() {
        return this.f407a;
    }

    /* renamed from: b */
    public boolean m392b() {
        boolean MyBillsEntityDataFactory = com.xiaomi.push.y.MyBillsEntityDataFactory(this);
        boolean z = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory() > 0;
        boolean z2 = !m393c();
        boolean m384i = m384i();
        boolean z3 = !m383h();
        boolean z4 = MyBillsEntityDataFactory && z && z2 && m384i && z3;
        if (!z4) {
            com.xiaomi.channel.commonutils.logger.b.moveToNextValue(String.format("not conn, net=%s;cnt=%s;!dis=%s;enb=%s;!spm=%s;", Boolean.valueOf(MyBillsEntityDataFactory), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(m384i), Boolean.valueOf(z3)));
        }
        return z4;
    }

    /* renamed from: c */
    public boolean m393c() {
        Field field;
        Field field2;
        Field field3;
        try {
            Class<?> PlaceComponentResult2 = com.xiaomi.channel.commonutils.android.j.PlaceComponentResult(this, "miui.os.Build");
            field = PlaceComponentResult2.getField("IS_CM_CUSTOMIZATION_TEST");
            field2 = PlaceComponentResult2.getField("IS_CU_CUSTOMIZATION_TEST");
            field3 = PlaceComponentResult2.getField("IS_CT_CUSTOMIZATION_TEST");
        } catch (Throwable unused) {
        }
        if (!field.getBoolean(null) && !field2.getBoolean(null)) {
            if (!field3.getBoolean(null)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public boolean m394d() {
        com.xiaomi.push.bt btVar = this.f397a;
        return btVar != null && btVar.moveToNextValue();
    }

    /* renamed from: e */
    public boolean m395e() {
        com.xiaomi.push.bt btVar = this.f397a;
        return btVar != null && btVar.NetworkUserEntityData$$ExternalSyntheticLambda0();
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

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f395a.getBinder();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("onStart() with intent NULL");
        } else {
            try {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(String.format("onStart() with intent.Action = %s, chid = %s, pkg = %s|%s", intent.getAction(), intent.getStringExtra(bd.A), intent.getStringExtra(bd.PlaceComponentResult), intent.getStringExtra("mipush_app_package")));
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("onStart() cause error: ");
                sb.append(th.getMessage());
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
                return;
            }
        }
        if (intent != null && intent.getAction() != null) {
            if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction()) || "com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                if (this.f408a.PlaceComponentResult()) {
                    com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("ERROR, the job controller is blocked.");
                    az.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(14);
                    stopSelf();
                } else {
                    iVar = new i(intent);
                    a(iVar);
                }
            } else if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                iVar = new i(intent);
                a(iVar);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 50) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[Prefs] spend ");
            sb2.append(currentTimeMillis2);
            sb2.append(" ms, too more times.");
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb2.toString());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 1;
    }

    /* loaded from: classes8.dex */
    public class a extends BroadcastReceiver {
        private final Object KClassImpl$Data$declaredNonStaticMembers$2;

        private a() {
            XMPushService.this = r1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
        }

        /* synthetic */ a(XMPushService xMPushService, byte b) {
            this();
        }

        static /* synthetic */ void MyBillsEntityDataFactory(a aVar) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("[Alarm] Cannot perform lock.notifyAll in the UI thread!");
                return;
            }
            synchronized (aVar.KClassImpl$Data$declaredNonStaticMembers$2) {
                try {
                    aVar.KClassImpl$Data$declaredNonStaticMembers$2.notifyAll();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[Alarm] notify lock. ");
                    sb.append(e);
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("[Alarm] heartbeat alarm has been triggered.");
            if (!bd.readMicros.equals(intent.getAction())) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("[Alarm] cancel the old ping timer");
                com.xiaomi.push.bc.MyBillsEntityDataFactory();
            } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
                com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("[Alarm] Ping XMChannelService on timer");
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.putExtra("time_stamp", System.currentTimeMillis());
                    intent2.setAction("com.xiaomi.push.timer");
                    ServiceClient.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext(intent2);
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("[Alarm] Cannot perform lock.wait in the UI thread!");
                    } else {
                        synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                            try {
                                this.KClassImpl$Data$declaredNonStaticMembers$2.wait(3000L);
                            } catch (InterruptedException e) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("[Alarm] interrupt from waiting state. ");
                                sb.append(e);
                                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                            }
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("[Alarm] heartbeat alarm finish in ");
                    sb2.append(System.currentTimeMillis() - currentTimeMillis);
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    class l extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l() {
            super(5);
            XMPushService.this = r1;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            return "ask the job queue to quit";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            com.xiaomi.push.service.o oVar = XMPushService.this.f408a;
            StringBuilder sb = new StringBuilder();
            sb.append("quit. finalizer:");
            sb.append(oVar.BuiltInFictitiousFunctionClassFactory);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            o.c cVar = oVar.getAuthRequestContext;
            synchronized (cVar) {
                cVar.getAuthRequestContext = true;
                o.c.a aVar = cVar.KClassImpl$Data$declaredNonStaticMembers$2;
                aVar.KClassImpl$Data$declaredNonStaticMembers$2 = new o.d[aVar.PlaceComponentResult];
                aVar.MyBillsEntityDataFactory = 0;
                cVar.notify();
            }
        }
    }

    private com.xiaomi.push.cj a(com.xiaomi.push.cj cjVar, String str, String str2) {
        StringBuilder sb;
        String str3;
        az BuiltInFictitiousFunctionClassFactory = az.BuiltInFictitiousFunctionClassFactory();
        List<String> MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(str);
        if (MyBillsEntityDataFactory.isEmpty()) {
            sb = new StringBuilder();
            str3 = "open channel should be called first before sending a packet, pkg=";
        } else {
            cjVar.NetworkUserEntityData$$ExternalSyntheticLambda6 = str;
            str = cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (TextUtils.isEmpty(str)) {
                str = MyBillsEntityDataFactory.get(0);
                cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3 = str;
            }
            az.b MyBillsEntityDataFactory2 = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(str, cjVar.NetworkUserEntityData$$ExternalSyntheticLambda8);
            if (!m394d()) {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not connected, chid=";
            } else if (MyBillsEntityDataFactory2 != null && MyBillsEntityDataFactory2.lookAheadTest == az.c.binded) {
                if (TextUtils.equals(str2, MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
                    return cjVar;
                }
                sb = new StringBuilder();
                sb.append("invalid session. ");
                sb.append(str2);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                return null;
            } else {
                sb = new StringBuilder();
                str3 = "drop a packet as the channel is not opened, chid=";
            }
        }
        sb.append(str3);
        sb.append(str);
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
        return null;
    }

    /* loaded from: classes8.dex */
    class d extends j {
        private com.xiaomi.push.bi getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.xiaomi.push.bi biVar) {
            super(8);
            XMPushService.this = r1;
            this.getAuthRequestContext = biVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            String str;
            StringBuilder sb;
            bn bnVar;
            bn bnVar2;
            az.c cVar;
            int i;
            az.b MyBillsEntityDataFactory;
            ax axVar = XMPushService.this.f405a;
            com.xiaomi.push.bi biVar = this.getAuthRequestContext;
            if (5 != biVar.PlaceComponentResult.PlaceComponentResult) {
                String scheduleImpl = biVar.scheduleImpl();
                String num = Integer.toString(biVar.PlaceComponentResult.PlaceComponentResult);
                if (!TextUtils.isEmpty(scheduleImpl) && !TextUtils.isEmpty(num) && (MyBillsEntityDataFactory = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(num, scheduleImpl)) != null) {
                    cx.KClassImpl$Data$declaredNonStaticMembers$2(axVar.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, biVar.PlaceComponentResult(), true, true, System.currentTimeMillis());
                }
            }
            try {
                String str2 = biVar.PlaceComponentResult.lookAheadTest;
                if (biVar.PlaceComponentResult.PlaceComponentResult != 0) {
                    String num2 = Integer.toString(biVar.PlaceComponentResult.PlaceComponentResult);
                    if (!"SECMSG".equals(biVar.PlaceComponentResult.lookAheadTest)) {
                        if (!"BIND".equals(str2)) {
                            if ("KICK".equals(str2)) {
                                au.g authRequestContext = au.g.getAuthRequestContext(biVar.KClassImpl$Data$declaredNonStaticMembers$2());
                                String scheduleImpl2 = biVar.scheduleImpl();
                                String str3 = authRequestContext.MyBillsEntityDataFactory;
                                String str4 = authRequestContext.PlaceComponentResult;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("kicked by server, chid=");
                                sb2.append(num2);
                                sb2.append(" res= ");
                                sb2.append(az.b.MyBillsEntityDataFactory(scheduleImpl2));
                                sb2.append(" type=");
                                sb2.append(str3);
                                sb2.append(" reason=");
                                sb2.append(str4);
                                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                                if (!"wait".equals(str3)) {
                                    axVar.BuiltInFictitiousFunctionClassFactory.a(num2, scheduleImpl2, 3, str4, str3);
                                    az.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(num2, scheduleImpl2);
                                    return;
                                }
                                az.b MyBillsEntityDataFactory2 = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(num2, scheduleImpl2);
                                if (MyBillsEntityDataFactory2 != null) {
                                    axVar.BuiltInFictitiousFunctionClassFactory.a(MyBillsEntityDataFactory2);
                                    MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(az.c.unbind, 3, 0, str4, str3);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        au.d MyBillsEntityDataFactory3 = au.d.MyBillsEntityDataFactory(biVar.KClassImpl$Data$declaredNonStaticMembers$2());
                        String scheduleImpl3 = biVar.scheduleImpl();
                        az.b MyBillsEntityDataFactory4 = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(num2, scheduleImpl3);
                        if (MyBillsEntityDataFactory4 != null) {
                            if (MyBillsEntityDataFactory3.BuiltInFictitiousFunctionClassFactory()) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("SMACK: channel bind succeeded, chid=");
                                sb3.append(biVar.PlaceComponentResult.PlaceComponentResult);
                                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb3.toString());
                                MyBillsEntityDataFactory4.KClassImpl$Data$declaredNonStaticMembers$2(az.c.binded, 1, 0, (String) null, (String) null);
                                return;
                            }
                            String str5 = MyBillsEntityDataFactory3.getAuthRequestContext;
                            if ("auth".equals(str5)) {
                                if ("invalid-sig".equals(MyBillsEntityDataFactory3.MyBillsEntityDataFactory)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("SMACK: bind error invalid-sig token = ");
                                    sb4.append(MyBillsEntityDataFactory4.NetworkUserEntityData$$ExternalSyntheticLambda2);
                                    sb4.append(" sec = ");
                                    sb4.append(MyBillsEntityDataFactory4.isLayoutRequested);
                                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb4.toString());
                                }
                                cVar = az.c.unbind;
                                i = 5;
                            } else if (!"cancel".equals(str5)) {
                                if ("wait".equals(str5)) {
                                    axVar.BuiltInFictitiousFunctionClassFactory.a(MyBillsEntityDataFactory4);
                                    MyBillsEntityDataFactory4.KClassImpl$Data$declaredNonStaticMembers$2(az.c.unbind, 1, 7, MyBillsEntityDataFactory3.MyBillsEntityDataFactory, str5);
                                }
                                sb = new StringBuilder();
                                sb.append("SMACK: channel bind failed, chid=");
                                sb.append(num2);
                                sb.append(" reason=");
                                sb.append(MyBillsEntityDataFactory3.MyBillsEntityDataFactory);
                                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                            } else {
                                cVar = az.c.unbind;
                                i = 7;
                            }
                            MyBillsEntityDataFactory4.KClassImpl$Data$declaredNonStaticMembers$2(cVar, 1, i, MyBillsEntityDataFactory3.MyBillsEntityDataFactory, str5);
                            az.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(num2, scheduleImpl3);
                            sb = new StringBuilder();
                            sb.append("SMACK: channel bind failed, chid=");
                            sb.append(num2);
                            sb.append(" reason=");
                            sb.append(MyBillsEntityDataFactory3.MyBillsEntityDataFactory);
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                        }
                        return;
                    } else if (!biVar.BuiltInFictitiousFunctionClassFactory()) {
                        com.xiaomi.push.service.j m390b = axVar.BuiltInFictitiousFunctionClassFactory.m390b();
                        XMPushService xMPushService = axVar.BuiltInFictitiousFunctionClassFactory;
                        az.b MyBillsEntityDataFactory5 = com.xiaomi.push.service.j.MyBillsEntityDataFactory(biVar);
                        if (MyBillsEntityDataFactory5 == null) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("error while notify channel closed! channel ");
                            sb5.append(num2);
                            sb5.append(" not registered");
                            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb5.toString());
                            return;
                        } else if ("5".equalsIgnoreCase(num2)) {
                            v vVar = m390b.BuiltInFictitiousFunctionClassFactory;
                            v.KClassImpl$Data$declaredNonStaticMembers$2(xMPushService, biVar, MyBillsEntityDataFactory5);
                            return;
                        } else {
                            String str6 = MyBillsEntityDataFactory5.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            Intent intent = new Intent();
                            intent.setAction("com.xiaomi.push.new_msg");
                            intent.setPackage(str6);
                            intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
                            intent.putExtra("ext_chid", num2);
                            intent.putExtra("ext_raw_packet", biVar.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory5.isLayoutRequested));
                            intent.putExtra(bd.NetworkUserEntityData$$ExternalSyntheticLambda0, MyBillsEntityDataFactory5.NetworkUserEntityData$$ExternalSyntheticLambda8);
                            intent.putExtra(bd.C, MyBillsEntityDataFactory5.isLayoutRequested);
                            if (MyBillsEntityDataFactory5.BuiltInFictitiousFunctionClassFactory != null) {
                                try {
                                    MyBillsEntityDataFactory5.BuiltInFictitiousFunctionClassFactory.send(Message.obtain(null, 17, intent));
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("message was sent by messenger for chid=");
                                    sb6.append(num2);
                                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb6.toString());
                                    return;
                                } catch (RemoteException unused) {
                                    MyBillsEntityDataFactory5.BuiltInFictitiousFunctionClassFactory = null;
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append("peer may died: ");
                                    sb7.append(MyBillsEntityDataFactory5.DatabaseTableConfigUtil.substring(MyBillsEntityDataFactory5.DatabaseTableConfigUtil.lastIndexOf(64)));
                                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb7.toString());
                                }
                            }
                            if ("com.xiaomi.xmsf".equals(str6)) {
                                return;
                            }
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", MyBillsEntityDataFactory5.newProxyInstance, MyBillsEntityDataFactory5.NetworkUserEntityData$$ExternalSyntheticLambda0, biVar.MyBillsEntityDataFactory()));
                            com.xiaomi.push.service.j.PlaceComponentResult(xMPushService, intent, MyBillsEntityDataFactory5);
                            return;
                        }
                    } else {
                        sb = new StringBuilder();
                        sb.append("Recv SECMSG errCode = ");
                        sb.append(biVar.PlaceComponentResult.moveToNextValue);
                        sb.append(" errStr = ");
                        str = biVar.PlaceComponentResult.isLayoutRequested;
                    }
                } else if ("PING".equals(str2)) {
                    byte[] KClassImpl$Data$declaredNonStaticMembers$2 = biVar.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (KClassImpl$Data$declaredNonStaticMembers$2 != null && KClassImpl$Data$declaredNonStaticMembers$2.length > 0) {
                        au.j authRequestContext2 = au.j.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
                        if (authRequestContext2.MyBillsEntityDataFactory()) {
                            bnVar2 = bn.BuiltInFictitiousFunctionClassFactory;
                            bnVar2.MyBillsEntityDataFactory(authRequestContext2.BuiltInFictitiousFunctionClassFactory);
                        }
                    }
                    if (!"com.xiaomi.xmsf".equals(axVar.BuiltInFictitiousFunctionClassFactory.getPackageName())) {
                        axVar.BuiltInFictitiousFunctionClassFactory.m387a();
                    }
                    if ("1".equals(biVar.MyBillsEntityDataFactory())) {
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("received a server ping");
                    }
                    axVar.BuiltInFictitiousFunctionClassFactory.m391b();
                    return;
                } else if ("SYNC".equals(str2)) {
                    if ("CONF".equals(biVar.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                        au.b PlaceComponentResult = au.b.PlaceComponentResult(biVar.KClassImpl$Data$declaredNonStaticMembers$2());
                        bnVar = bn.BuiltInFictitiousFunctionClassFactory;
                        bnVar.MyBillsEntityDataFactory(PlaceComponentResult);
                        return;
                    } else if (TextUtils.equals("U", biVar.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                        com.xiaomi.push.bi biVar2 = new com.xiaomi.push.bi();
                        au.a aVar = biVar2.PlaceComponentResult;
                        aVar.getAuthRequestContext = true;
                        aVar.PlaceComponentResult = 0;
                        biVar2.getAuthRequestContext(biVar.PlaceComponentResult.lookAheadTest, "UCA");
                        String MyBillsEntityDataFactory6 = biVar.MyBillsEntityDataFactory();
                        au.a aVar2 = biVar2.PlaceComponentResult;
                        aVar2.PrepareContext = true;
                        aVar2.initRecordTimeStamp = MyBillsEntityDataFactory6;
                        XMPushService xMPushService2 = axVar.BuiltInFictitiousFunctionClassFactory;
                        xMPushService2.a(new bl(xMPushService2, biVar2));
                        return;
                    } else if (!TextUtils.equals("P", biVar.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                        return;
                    } else {
                        au.i authRequestContext3 = au.i.getAuthRequestContext(biVar.KClassImpl$Data$declaredNonStaticMembers$2());
                        com.xiaomi.push.bi biVar3 = new com.xiaomi.push.bi();
                        au.a aVar3 = biVar3.PlaceComponentResult;
                        aVar3.getAuthRequestContext = true;
                        aVar3.PlaceComponentResult = 0;
                        biVar3.getAuthRequestContext(biVar.PlaceComponentResult.lookAheadTest, "PCA");
                        String MyBillsEntityDataFactory7 = biVar.MyBillsEntityDataFactory();
                        au.a aVar4 = biVar3.PlaceComponentResult;
                        aVar4.PrepareContext = true;
                        aVar4.initRecordTimeStamp = MyBillsEntityDataFactory7;
                        au.i iVar = new au.i();
                        if (authRequestContext3.KClassImpl$Data$declaredNonStaticMembers$2()) {
                            com.xiaomi.push.a aVar5 = authRequestContext3.MyBillsEntityDataFactory;
                            iVar.BuiltInFictitiousFunctionClassFactory = true;
                            iVar.MyBillsEntityDataFactory = aVar5;
                        }
                        biVar3.BuiltInFictitiousFunctionClassFactory(iVar.moveToNextValue(), (String) null);
                        XMPushService xMPushService3 = axVar.BuiltInFictitiousFunctionClassFactory;
                        xMPushService3.a(new bl(xMPushService3, biVar3));
                        sb = new StringBuilder();
                        sb.append("ACK msgP: id = ");
                        str = biVar.MyBillsEntityDataFactory();
                    }
                } else if (!"NOTIFY".equals(biVar.PlaceComponentResult.lookAheadTest)) {
                    return;
                } else {
                    au.h authRequestContext4 = au.h.getAuthRequestContext(biVar.KClassImpl$Data$declaredNonStaticMembers$2());
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("notify by server err = ");
                    sb8.append(authRequestContext4.PlaceComponentResult);
                    sb8.append(" desc = ");
                    str = authRequestContext4.MyBillsEntityDataFactory;
                    sb = sb8;
                }
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            } catch (Exception e) {
                StringBuilder sb9 = new StringBuilder();
                sb9.append("handle Blob chid = ");
                sb9.append(biVar.PlaceComponentResult.PlaceComponentResult);
                sb9.append(" cmd = ");
                sb9.append(biVar.PlaceComponentResult.lookAheadTest);
                sb9.append(" packetid = ");
                sb9.append(biVar.MyBillsEntityDataFactory());
                sb9.append(" failure ");
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb9.toString(), e);
            }
        }
    }

    /* loaded from: classes8.dex */
    class m extends j {
        private com.xiaomi.push.cj MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(com.xiaomi.push.cj cjVar) {
            super(8);
            XMPushService.this = r1;
            this.MyBillsEntityDataFactory = cjVar;
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final String getAuthRequestContext() {
            return "receive a message.";
        }

        @Override // com.xiaomi.push.service.XMPushService.j
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            String str;
            String str2;
            az.b MyBillsEntityDataFactory;
            ax axVar = XMPushService.this.f405a;
            com.xiaomi.push.cj cjVar = this.MyBillsEntityDataFactory;
            if (!"5".equals(cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3)) {
                String str3 = cjVar.NetworkUserEntityData$$ExternalSyntheticLambda7;
                String str4 = cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && (MyBillsEntityDataFactory = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(str4, str3)) != null) {
                    cx.KClassImpl$Data$declaredNonStaticMembers$2(axVar.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, cx.PlaceComponentResult(cjVar.MyBillsEntityDataFactory()), true, true, System.currentTimeMillis());
                }
            }
            String str5 = cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (TextUtils.isEmpty(str5)) {
                cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3 = "1";
                str5 = "1";
            }
            if (str5.equals("0")) {
                StringBuilder sb = new StringBuilder();
                sb.append("Received wrong packet with chid = 0 : ");
                sb.append(cjVar.MyBillsEntityDataFactory());
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            }
            boolean z = cjVar instanceof com.xiaomi.push.ch;
            if (z) {
                com.xiaomi.push.cg KClassImpl$Data$declaredNonStaticMembers$2 = cjVar.KClassImpl$Data$declaredNonStaticMembers$2("kick");
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    String str6 = cjVar.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    String PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult("type");
                    String PlaceComponentResult2 = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(ZdocRecordService.REASON);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("kicked by server, chid=");
                    sb2.append(str5);
                    sb2.append(" res=");
                    sb2.append(az.b.MyBillsEntityDataFactory(str6));
                    sb2.append(" type=");
                    sb2.append(PlaceComponentResult);
                    sb2.append(" reason=");
                    sb2.append(PlaceComponentResult2);
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                    if (!"wait".equals(PlaceComponentResult)) {
                        axVar.BuiltInFictitiousFunctionClassFactory.a(str5, str6, 3, PlaceComponentResult2, PlaceComponentResult);
                        az.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(str5, str6);
                        return;
                    }
                    az.b MyBillsEntityDataFactory2 = az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(str5, str6);
                    if (MyBillsEntityDataFactory2 != null) {
                        axVar.BuiltInFictitiousFunctionClassFactory.a(MyBillsEntityDataFactory2);
                        MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2(az.c.unbind, 3, 0, PlaceComponentResult2, PlaceComponentResult);
                        return;
                    }
                    return;
                }
            } else if (cjVar instanceof com.xiaomi.push.ci) {
                com.xiaomi.push.ci ciVar = (com.xiaomi.push.ci) cjVar;
                if ("redir".equals(ciVar.PlaceComponentResult)) {
                    com.xiaomi.push.cg KClassImpl$Data$declaredNonStaticMembers$22 = ciVar.KClassImpl$Data$declaredNonStaticMembers$2("hosts");
                    if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                        boolean isEmpty = TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory);
                        String str7 = KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory;
                        if (!isEmpty) {
                            str7 = cu.PlaceComponentResult(str7);
                        }
                        if (TextUtils.isEmpty(str7)) {
                            return;
                        }
                        String[] split = str7.split(";");
                        com.xiaomi.push.ag MyBillsEntityDataFactory3 = com.xiaomi.push.ak.MyBillsEntityDataFactory().MyBillsEntityDataFactory(com.xiaomi.push.bu.PlaceComponentResult(), false);
                        if (MyBillsEntityDataFactory3 == null || split.length <= 0) {
                            return;
                        }
                        MyBillsEntityDataFactory3.MyBillsEntityDataFactory(split);
                        axVar.BuiltInFictitiousFunctionClassFactory.a(20, (Exception) null);
                        axVar.BuiltInFictitiousFunctionClassFactory.a(true);
                        return;
                    }
                    return;
                }
            }
            com.xiaomi.push.service.j m390b = axVar.BuiltInFictitiousFunctionClassFactory.m390b();
            XMPushService xMPushService = axVar.BuiltInFictitiousFunctionClassFactory;
            az.b PlaceComponentResult3 = com.xiaomi.push.service.j.PlaceComponentResult(cjVar);
            if (PlaceComponentResult3 != null) {
                if ("5".equalsIgnoreCase(str5)) {
                    v vVar = m390b.BuiltInFictitiousFunctionClassFactory;
                    v.BuiltInFictitiousFunctionClassFactory(xMPushService, cjVar, PlaceComponentResult3);
                    return;
                }
                String str8 = PlaceComponentResult3.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (cjVar instanceof com.xiaomi.push.ci) {
                    str2 = "com.xiaomi.push.new_msg";
                } else if (z) {
                    str2 = "com.xiaomi.push.new_iq";
                } else if (cjVar instanceof cl) {
                    str2 = "com.xiaomi.push.new_pres";
                } else {
                    str = "unknown packet type, drop it";
                }
                Intent intent = new Intent();
                intent.setAction(str2);
                intent.setPackage(str8);
                intent.putExtra("ext_chid", str5);
                intent.putExtra("ext_packet", cjVar.KClassImpl$Data$declaredNonStaticMembers$2());
                intent.putExtra(bd.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult3.NetworkUserEntityData$$ExternalSyntheticLambda8);
                intent.putExtra(bd.C, PlaceComponentResult3.isLayoutRequested);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(String.format("[Bcst] notify packet arrival. %s,%s,%s", PlaceComponentResult3.newProxyInstance, PlaceComponentResult3.NetworkUserEntityData$$ExternalSyntheticLambda0, cjVar.getAuthRequestContext()));
                com.xiaomi.push.service.j.PlaceComponentResult(xMPushService, intent, PlaceComponentResult3);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("error while notify channel closed! channel ");
            sb3.append(str5);
            sb3.append(" not registered");
            str = sb3.toString();
            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(str);
        }
    }

    private void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("digest");
        com.xiaomi.push.service.n KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.push.service.n.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext());
        synchronized (KClassImpl$Data$declaredNonStaticMembers$22) {
            if (!TextUtils.isEmpty(string) && !KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext.getBoolean(n.a.MyBillsEntityDataFactory(), false)) {
                KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext.edit().putBoolean(n.a.MyBillsEntityDataFactory(), true).apply();
            }
            if (KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext() && !TextUtils.isEmpty(string)) {
                StringBuilder sb = new StringBuilder();
                sb.append("W-");
                sb.append(string);
                KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult(sb.toString());
            }
        }
    }

    private void b(Intent intent) {
        long j2;
        String stringExtra = intent.getStringExtra(bd.PlaceComponentResult);
        String stringExtra2 = intent.getStringExtra(bd.NetworkUserEntityData$$ExternalSyntheticLambda0);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        az BuiltInFictitiousFunctionClassFactory = az.BuiltInFictitiousFunctionClassFactory();
        com.xiaomi.push.bi biVar = null;
        if (bundleExtra != null) {
            com.xiaomi.push.ci ciVar = (com.xiaomi.push.ci) a(new com.xiaomi.push.ci(bundleExtra), stringExtra, stringExtra2);
            if (ciVar == null) {
                return;
            }
            biVar = com.xiaomi.push.bi.BuiltInFictitiousFunctionClassFactory(ciVar, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(ciVar.NetworkUserEntityData$$ExternalSyntheticLambda3, ciVar.NetworkUserEntityData$$ExternalSyntheticLambda8).isLayoutRequested);
        } else {
            byte[] byteArrayExtra = intent.getByteArrayExtra("ext_raw_packet");
            if (byteArrayExtra != null) {
                try {
                    j2 = Long.parseLong(intent.getStringExtra(bd.getSupportButtonTintMode));
                } catch (NumberFormatException unused) {
                    j2 = 0;
                }
                String stringExtra3 = intent.getStringExtra(bd.whenAvailable);
                String stringExtra4 = intent.getStringExtra(bd.BottomSheetCardBindingView$watcherCardNumberView$1);
                String stringExtra5 = intent.getStringExtra("ext_chid");
                az.b MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(stringExtra5, String.valueOf(j2));
                if (MyBillsEntityDataFactory != null) {
                    com.xiaomi.push.bi biVar2 = new com.xiaomi.push.bi();
                    try {
                        int parseInt = Integer.parseInt(stringExtra5);
                        au.a aVar = biVar2.PlaceComponentResult;
                        aVar.getAuthRequestContext = true;
                        aVar.PlaceComponentResult = parseInt;
                    } catch (NumberFormatException unused2) {
                    }
                    biVar2.getAuthRequestContext("SECMSG", null);
                    if (TextUtils.isEmpty(stringExtra3)) {
                        stringExtra3 = "xiaomi.com";
                    }
                    biVar2.KClassImpl$Data$declaredNonStaticMembers$2(j2, stringExtra3, stringExtra4);
                    String stringExtra6 = intent.getStringExtra("ext_pkt_id");
                    au.a aVar2 = biVar2.PlaceComponentResult;
                    aVar2.PrepareContext = true;
                    aVar2.initRecordTimeStamp = stringExtra6;
                    biVar2.BuiltInFictitiousFunctionClassFactory(byteArrayExtra, MyBillsEntityDataFactory.isLayoutRequested);
                    StringBuilder sb = new StringBuilder();
                    sb.append("send a message: chid=");
                    sb.append(stringExtra5);
                    sb.append(", packetId=");
                    sb.append(intent.getStringExtra("ext_pkt_id"));
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                    biVar = biVar2;
                }
            }
        }
        if (biVar != null) {
            c(new bl(this, biVar));
        }
    }

    private void c(Intent intent) {
        String stringExtra = intent.getStringExtra(bd.PlaceComponentResult);
        String stringExtra2 = intent.getStringExtra(bd.NetworkUserEntityData$$ExternalSyntheticLambda0);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int length = parcelableArrayExtra.length;
        com.xiaomi.push.ci[] ciVarArr = new com.xiaomi.push.ci[length];
        intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            com.xiaomi.push.ci ciVar = new com.xiaomi.push.ci((Bundle) parcelableArrayExtra[i2]);
            ciVarArr[i2] = ciVar;
            com.xiaomi.push.ci ciVar2 = (com.xiaomi.push.ci) a(ciVar, stringExtra, stringExtra2);
            ciVarArr[i2] = ciVar2;
            if (ciVar2 == null) {
                return;
            }
        }
        az BuiltInFictitiousFunctionClassFactory = az.BuiltInFictitiousFunctionClassFactory();
        com.xiaomi.push.bi[] biVarArr = new com.xiaomi.push.bi[length];
        for (int i3 = 0; i3 < length; i3++) {
            com.xiaomi.push.ci ciVar3 = ciVarArr[i3];
            biVarArr[i3] = com.xiaomi.push.bi.BuiltInFictitiousFunctionClassFactory(ciVar3, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(ciVar3.NetworkUserEntityData$$ExternalSyntheticLambda3, ciVar3.NetworkUserEntityData$$ExternalSyntheticLambda8).isLayoutRequested);
        }
        c(new com.xiaomi.push.service.c(this, biVarArr));
    }

    private void c(j jVar) {
        int i2;
        com.xiaomi.push.service.o oVar = this.f408a;
        i2 = com.xiaomi.channel.commonutils.logger.b.PlaceComponentResult;
        if (i2 <= 0) {
            try {
                byte b2 = (byte) (-com.xiaomi.push.service.o.KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b3 = b2;
                Object[] objArr = new Object[1];
                com.xiaomi.push.service.o.a(b2, b3, (byte) (b3 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b4 = (byte) (com.xiaomi.push.service.o.KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                Object[] objArr2 = new Object[1];
                com.xiaomi.push.service.o.a(b4, b4, (byte) (-com.xiaomi.push.service.o.KClassImpl$Data$declaredNonStaticMembers$2[15]), objArr2);
                if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != oVar.getAuthRequestContext) {
                    com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("run job outside job job thread");
                    throw new RejectedExecutionException("Run job outside job thread");
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        jVar.run();
    }

    private void d() {
        NetworkInfo networkInfo;
        j gVar;
        String str = null;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e2);
            networkInfo = null;
        }
        com.xiaomi.push.service.n KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.push.service.n.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext());
        synchronized (KClassImpl$Data$declaredNonStaticMembers$22) {
            if (KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext()) {
                if (networkInfo != null) {
                    if (networkInfo.getType() == 0) {
                        String subtypeName = networkInfo.getSubtypeName();
                        if (!TextUtils.isEmpty(subtypeName) && !"UNKNOWN".equalsIgnoreCase(subtypeName)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("M-");
                            sb.append(subtypeName);
                            str = sb.toString();
                        }
                        KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult(str);
                        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = 0;
                    } else {
                        if (networkInfo.getType() != 1) {
                            if (networkInfo.getType() == 6) {
                            }
                        }
                        KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult("WIFI-ID-UNKNOWN");
                        KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = 1;
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult(null);
                KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory = -1;
            }
        }
        if (networkInfo != null) {
            StringBuilder sb2 = new StringBuilder("[");
            sb2.append("type: ");
            sb2.append(networkInfo.getTypeName());
            sb2.append("[");
            sb2.append(networkInfo.getSubtypeName());
            sb2.append("], state: ");
            sb2.append(networkInfo.getState());
            sb2.append("/");
            sb2.append(networkInfo.getDetailedState());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("network changed,");
            sb3.append(sb2.toString());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb3.toString());
            NetworkInfo.State state = networkInfo.getState();
            if (state == NetworkInfo.State.SUSPENDED || state == NetworkInfo.State.UNKNOWN) {
                return;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("network changed, no active network");
        }
        cx.MyBillsEntityDataFactory(this);
        com.xiaomi.push.bp bpVar = this.f396a;
        synchronized (bpVar.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            bpVar.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
        }
        if (com.xiaomi.push.y.MyBillsEntityDataFactory(this)) {
            if (m394d() && m382g()) {
                c(false);
            }
            if (!m394d() && !m395e()) {
                com.xiaomi.push.service.o oVar = this.f408a;
                synchronized (oVar.getAuthRequestContext) {
                    oVar.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(1);
                }
                gVar = new e();
            }
            e();
        }
        gVar = new g(2);
        a(gVar);
        e();
    }

    /* JADX WARN: Removed duplicated region for block: B:601:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:612:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:850:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(android.content.Intent r12) {
        /*
            Method dump skipped, instructions count: 2304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.d(android.content.Intent):void");
    }

    public void f() {
        String str;
        com.xiaomi.push.bt btVar = this.f397a;
        if (btVar == null || !btVar.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            com.xiaomi.push.bt btVar2 = this.f397a;
            if (btVar2 == null || !btVar2.moveToNextValue()) {
                this.f398a.scheduleImpl = com.xiaomi.push.y.KClassImpl$Data$declaredNonStaticMembers$2(this);
                g();
                if (this.f397a == null) {
                    az BuiltInFictitiousFunctionClassFactory = az.BuiltInFictitiousFunctionClassFactory();
                    synchronized (BuiltInFictitiousFunctionClassFactory) {
                        Iterator<HashMap<String, az.b>> it = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.values().iterator();
                        while (it.hasNext()) {
                            Iterator<az.b> it2 = it.next().values().iterator();
                            while (it2.hasNext()) {
                                it2.next().KClassImpl$Data$declaredNonStaticMembers$2(az.c.unbind, 1, 3, (String) null, (String) null);
                            }
                        }
                    }
                    d(false);
                    return;
                }
                return;
            }
            str = "try to connect while is connected.";
        } else {
            str = "try to connect while connecting.";
        }
        com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(str);
    }

    public void a(int i2) {
        com.xiaomi.push.service.o oVar = this.f408a;
        synchronized (oVar.getAuthRequestContext) {
            oVar.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(i2);
        }
    }

    public void a(j jVar, long j2) {
        try {
            com.xiaomi.push.service.o oVar = this.f408a;
            if (j2 >= 0) {
                oVar.PlaceComponentResult(jVar, j2);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("delay < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } catch (IllegalStateException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("can't execute job err = ");
            sb2.append(e2.getMessage());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
        }
    }

    public void a(az.b bVar) {
        if (bVar != null) {
            long random = (((long) ((Math.random() * 20.0d) - 10.0d)) + ((bVar.PlaceComponentResult + 1) * 15)) * 1000;
            StringBuilder sb = new StringBuilder();
            sb.append("schedule rebind job in ");
            sb.append(random / 1000);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            a(new b(bVar), random);
        }
    }

    public void a(boolean z) {
        double d2;
        bi biVar = this.f406a;
        if (!biVar.PlaceComponentResult.m392b()) {
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("should not reconnect as no client or network.");
        } else if (z) {
            if (!biVar.PlaceComponentResult.m389a(1)) {
                biVar.MyBillsEntityDataFactory++;
            }
            biVar.PlaceComponentResult.a(1);
            XMPushService xMPushService = biVar.PlaceComponentResult;
            xMPushService.a(new e());
        } else if (biVar.PlaceComponentResult.m389a(1)) {
        } else {
            int i2 = 0;
            if (biVar.MyBillsEntityDataFactory > 8) {
                i2 = 300000;
            } else {
                double random = (Math.random() * 2.0d) + 1.0d;
                int i3 = biVar.MyBillsEntityDataFactory;
                if (i3 > 4) {
                    d2 = 60000.0d;
                } else if (i3 > 1) {
                    d2 = 10000.0d;
                } else if (biVar.getAuthRequestContext != 0) {
                    if (System.currentTimeMillis() - biVar.getAuthRequestContext < 310000) {
                        i2 = biVar.BuiltInFictitiousFunctionClassFactory;
                        int i4 = bi.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (i2 < i4) {
                            int i5 = biVar.moveToNextValue + 1;
                            biVar.moveToNextValue = i5;
                            if (i5 >= 4) {
                                i2 = i4;
                            } else {
                                double d3 = i2;
                                Double.isNaN(d3);
                                biVar.BuiltInFictitiousFunctionClassFactory = (int) (d3 * 1.5d);
                            }
                        }
                    } else {
                        biVar.BuiltInFictitiousFunctionClassFactory = 1000;
                        biVar.moveToNextValue = 0;
                    }
                }
                i2 = (int) (random * d2);
            }
            biVar.MyBillsEntityDataFactory++;
            StringBuilder sb = new StringBuilder();
            sb.append("schedule reconnect in ");
            sb.append(i2);
            sb.append("ms");
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            XMPushService xMPushService2 = biVar.PlaceComponentResult;
            xMPushService2.a(new e(), i2);
            if (biVar.MyBillsEntityDataFactory == 2) {
                aj.BuiltInFictitiousFunctionClassFactory();
            }
            if (biVar.MyBillsEntityDataFactory == 3) {
                aj.KClassImpl$Data$declaredNonStaticMembers$2.getActiveCount();
            }
        }
    }

    /* renamed from: b */
    void m391b() {
        com.xiaomi.push.service.n KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.push.service.n.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext());
        if (KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext() && KClassImpl$Data$declaredNonStaticMembers$22.scheduleImpl) {
            KClassImpl$Data$declaredNonStaticMembers$22.NetworkUserEntityData$$ExternalSyntheticLambda0.getAndSet(0);
        }
        Iterator it = new ArrayList(this.f410a).iterator();
        while (it.hasNext()) {
            ((n) it.next()).MyBillsEntityDataFactory();
        }
    }

    @Override // com.xiaomi.push.bv
    public void b(com.xiaomi.push.bt btVar) {
        d(true);
        bi biVar = this.f406a;
        biVar.getAuthRequestContext = System.currentTimeMillis();
        biVar.PlaceComponentResult.a(1);
        biVar.MyBillsEntityDataFactory = 0;
        if (!com.xiaomi.push.bc.KClassImpl$Data$declaredNonStaticMembers$2() && !j()) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("reconnection successful, reactivate alarm.");
            com.xiaomi.push.bc.BuiltInFictitiousFunctionClassFactory(true);
        }
        Iterator<az.b> it = az.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2().iterator();
        while (it.hasNext()) {
            a(new b(it.next()));
        }
        if (this.f412a || !com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(getApplicationContext())) {
            return;
        }
        com.xiaomi.push.o PlaceComponentResult2 = com.xiaomi.push.o.PlaceComponentResult(getApplicationContext());
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory.schedule(new cb(this), 0L, TimeUnit.SECONDS);
    }

    public void b(j jVar) {
        com.xiaomi.push.service.o oVar = this.f408a;
        int i2 = jVar.lookAheadTest;
        synchronized (oVar.getAuthRequestContext) {
            o.c.a aVar = oVar.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            for (int i3 = 0; i3 < aVar.MyBillsEntityDataFactory; i3++) {
                if (aVar.KClassImpl$Data$declaredNonStaticMembers$2[i3].getAuthRequestContext == jVar) {
                    aVar.KClassImpl$Data$declaredNonStaticMembers$2[i3].getAuthRequestContext();
                }
            }
            aVar.MyBillsEntityDataFactory();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        String[] split;
        String str;
        try {
            byte b2 = 0;
            byte b3 = (byte) (getAuthRequestContext[5] + 1);
            Object[] objArr = new Object[1];
            m((short) 14, b3, b3, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b4 = getAuthRequestContext[5];
            Object[] objArr2 = new Object[1];
            m(b4, (byte) (b4 + 1), (byte) (-getAuthRequestContext[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 4 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) KeyEvent.keyCodeFromString(""));
                    Object[] objArr4 = new Object[1];
                    n((byte) (-$$a[8]), (byte) (-$$a[53]), (byte) (-$$a[9]), objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i2 = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i2) {
                    long j2 = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1697781792, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                super.onCreate();
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(getApplicationContext());
                com.xiaomi.channel.commonutils.android.j.MyBillsEntityDataFactory(this);
                com.xiaomi.push.service.q KClassImpl$Data$declaredNonStaticMembers$22 = com.xiaomi.push.service.r.KClassImpl$Data$declaredNonStaticMembers$2(this);
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                    com.xiaomi.push.j.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult);
                }
                if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(getApplicationContext())) {
                    HandlerThread handlerThread = new HandlerThread("hb-alarm");
                    handlerThread.start();
                    Handler handler = new Handler(handlerThread.getLooper());
                    this.f400a = new a(this, b2);
                    com.xiaomi.channel.commonutils.android.g.KClassImpl$Data$declaredNonStaticMembers$2(this, this.f400a, new IntentFilter(bd.readMicros), "com.xiaomi.xmsf.permission.MIPUSH_RECEIVE", handler, 4);
                    b = true;
                    handler.post(new cc(this));
                }
                this.f395a = new Messenger(new cd(this));
                be.getAuthRequestContext(this);
                ce ceVar = new ce(this, "xiaomi.com");
                this.f398a = ceVar;
                ceVar.PlaceComponentResult = true;
                this.f396a = new com.xiaomi.push.bp(this, this.f398a);
                this.f407a = m386a();
                com.xiaomi.push.bc.BuiltInFictitiousFunctionClassFactory(this);
                com.xiaomi.push.bp bpVar = this.f396a;
                if (!bpVar.lookAheadTest.contains(this)) {
                    bpVar.lookAheadTest.add(this);
                }
                this.f405a = new ax(this);
                this.f406a = new bi(this);
                cq.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory("all", "xm:chat", new com.xiaomi.push.service.k());
                this.f408a = new com.xiaomi.push.service.o("Connection Controller Thread");
                az BuiltInFictitiousFunctionClassFactory = az.BuiltInFictitiousFunctionClassFactory();
                synchronized (BuiltInFictitiousFunctionClassFactory) {
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.clear();
                }
                cf cfVar = new cf(this);
                synchronized (BuiltInFictitiousFunctionClassFactory) {
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.add(cfVar);
                }
                if (l()) {
                    h();
                }
                a(new bv(this));
                if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(this)) {
                    a(new ay());
                }
                a(new h());
                this.f411a.add(bp.getAuthRequestContext(this));
                if (m384i()) {
                    this.f401a = new f();
                    registerReceiver(this.f401a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
                if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(getApplicationContext())) {
                    this.f404a = new t();
                    com.xiaomi.channel.commonutils.android.g.KClassImpl$Data$declaredNonStaticMembers$2(this, this.f404a, new IntentFilter("miui.net.wifi.DIGEST_INFORMATION_CHANGED"), "miui.net.wifi.permission.ACCESS_WIFI_DIGEST_INFO", null, 2);
                    k kVar = new k();
                    this.f402a = kVar;
                    com.xiaomi.channel.commonutils.android.g.KClassImpl$Data$declaredNonStaticMembers$2(this, kVar, new IntentFilter("com.xiaomi.xmsf.USE_INTELLIGENT_HB"), "com.xiaomi.xmsf.permission.INTELLIGENT_HB", null, 2);
                }
                com.xiaomi.push.service.n.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext());
                if ("com.xiaomi.xmsf".equals(getPackageName())) {
                    Uri uriFor = Settings.System.getUriFor("power_supersave_mode_open");
                    if (uriFor != null) {
                        this.f394a = new cg(this, new Handler(Looper.getMainLooper()));
                        try {
                            getContentResolver().registerContentObserver(uriFor, false, this.f394a);
                        } catch (Throwable th3) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("register super-power-mode observer err:");
                            sb.append(th3.getMessage());
                            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
                        }
                    }
                    int[] m379a = m379a();
                    if (m379a != null) {
                        this.f403a = new r();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        registerReceiver(this.f403a, intentFilter);
                        this.f7792a = m379a[0];
                        this.f413b = m379a[1];
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("falldown initialized: ");
                        sb2.append(this.f7792a);
                        sb2.append(",");
                        sb2.append(this.f413b);
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
                    }
                }
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                    if (!TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory) && (split = KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory.split(AUScreenAdaptTool.PREFIX_ID)) != null && split.length > 0) {
                        str = split[0];
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("XMPushService created. pid=");
                        sb3.append(Process.myPid());
                        sb3.append(", uid=");
                        sb3.append(Process.myUid());
                        sb3.append(", vc=");
                        sb3.append(com.xiaomi.channel.commonutils.android.a.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext(), getPackageName()));
                        sb3.append(", uuid=");
                        sb3.append(str);
                        com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb3.toString());
                    }
                }
                str = "";
                StringBuilder sb32 = new StringBuilder();
                sb32.append("XMPushService created. pid=");
                sb32.append(Process.myPid());
                sb32.append(", uid=");
                sb32.append(Process.myUid());
                sb32.append(", vc=");
                sb32.append(com.xiaomi.channel.commonutils.android.a.KClassImpl$Data$declaredNonStaticMembers$2(getApplicationContext(), getPackageName()));
                sb32.append(", uuid=");
                sb32.append(str);
                com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb32.toString());
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        } catch (Throwable th5) {
            Throwable cause4 = th5.getCause();
            if (cause4 == null) {
                throw th5;
            }
            throw cause4;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        bn bnVar;
        f fVar = this.f401a;
        if (fVar != null) {
            a(fVar);
            this.f401a = null;
        }
        t tVar = this.f404a;
        if (tVar != null) {
            a(tVar);
            this.f404a = null;
        }
        k kVar = this.f402a;
        if (kVar != null) {
            a(kVar);
            this.f402a = null;
        }
        r rVar = this.f403a;
        if (rVar != null) {
            a(rVar);
            this.f403a = null;
        }
        a aVar = this.f400a;
        if (aVar != null) {
            a(aVar);
            this.f400a = null;
        }
        if ("com.xiaomi.xmsf".equals(getPackageName()) && this.f394a != null) {
            try {
                getContentResolver().unregisterContentObserver(this.f394a);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("unregister super-power-mode err:");
                sb.append(th.getMessage());
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            }
        }
        this.f411a.clear();
        com.xiaomi.push.service.o oVar = this.f408a;
        synchronized (oVar.getAuthRequestContext) {
            o.c.a aVar2 = oVar.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            aVar2.KClassImpl$Data$declaredNonStaticMembers$2 = new o.d[aVar2.PlaceComponentResult];
            aVar2.MyBillsEntityDataFactory = 0;
        }
        a(new bz(this));
        a(new l());
        az BuiltInFictitiousFunctionClassFactory = az.BuiltInFictitiousFunctionClassFactory();
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.clear();
        }
        az.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(15);
        az BuiltInFictitiousFunctionClassFactory2 = az.BuiltInFictitiousFunctionClassFactory();
        synchronized (BuiltInFictitiousFunctionClassFactory2) {
            Iterator<az.b> it = BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2().iterator();
            while (it.hasNext()) {
                it.next().MyBillsEntityDataFactory();
            }
            BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult.clear();
        }
        this.f396a.lookAheadTest.remove(this);
        bnVar = bn.BuiltInFictitiousFunctionClassFactory;
        synchronized (bnVar) {
            bnVar.getAuthRequestContext.clear();
        }
        com.xiaomi.push.bc.MyBillsEntityDataFactory();
        i();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("Service destroyed");
    }

    private static void o(int i2, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = PlaceComponentResult;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr3[i3] = (int) (iArr2[i3] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = PlaceComponentResult;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i4 = 0; i4 < length3; i4++) {
                iArr6[i4] = (int) (iArr5[i4] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i5 = 0; i5 < 16; i5++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i5];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            }
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i7;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i9 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i2);
    }
}
