package com.akamai.botman;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class y {
    private static final Locale BuiltInFictitiousFunctionClassFactory = Locale.US;
    private static final y getAuthRequestContext = new y();
    private long DatabaseTableConfigUtil;
    private long GetContactSyncConfig;
    long KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    private long NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    private long NetworkUserEntityData$$ExternalSyntheticLambda4;
    private String NetworkUserEntityData$$ExternalSyntheticLambda7;
    private long NetworkUserEntityData$$ExternalSyntheticLambda8;
    private String PrepareContext;
    private long initRecordTimeStamp;
    private int isLayoutRequested;
    String lookAheadTest;
    private int newProxyInstance;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private ArrayList<String> FragmentBottomSheetPaymentSettingBinding = new ArrayList<>();
    private ArrayList<Long> NetworkUserEntityData$$ExternalSyntheticLambda3 = new ArrayList<>();
    private ArrayList<Integer> NetworkUserEntityData$$ExternalSyntheticLambda6 = new ArrayList<>();
    private String NetworkUserEntityData$$ExternalSyntheticLambda5 = "";
    String scheduleImpl = "";
    private int getSupportButtonTintMode = 0;
    public String getErrorConfigVersion = "";
    public int PlaceComponentResult = 0;
    private int moveToNextValue = 0;

    protected void MyBillsEntityDataFactory(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void scheduleImpl() {
    }

    public static y lookAheadTest() {
        return getAuthRequestContext;
    }

    public final String moveToNextValue() {
        z zVar;
        synchronized (this) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                return "";
            }
            if (this.scheduleImpl.length() == 0) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda5.length() == 0) {
                    zVar = z.getAuthRequestContext;
                    Context context = zVar.BuiltInFictitiousFunctionClassFactory.get();
                    if (context == null) {
                        ah.MyBillsEntityDataFactory("SensorDataCache", "getPoWResponse: Context is null", new Throwable[0]);
                    } else {
                        String string = context.getSharedPreferences("com.akamai.botman.preferences", 0).getString("pow_response", null);
                        if (string != null) {
                            return string;
                        }
                    }
                    return "";
                }
                return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            }
            int i = this.getSupportButtonTintMode + 1;
            this.getSupportButtonTintMode = i;
            double d = i;
            double d2 = this.initRecordTimeStamp;
            Double.isNaN(d2);
            if (d >= d2 * 0.9d) {
                new Timer().schedule(new AnonymousClass1(0), 100L);
            }
            return this.scheduleImpl;
        }
    }

    /* renamed from: com.akamai.botman.y$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 extends TimerTask {
        final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;

        public AnonymousClass1(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            new Thread(new Runnable() { // from class: com.akamai.botman.y.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    y.KClassImpl$Data$declaredNonStaticMembers$2(y.this, AnonymousClass1.this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.akamai.botman.y$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass2 extends TimerTask {
        final /* synthetic */ int getAuthRequestContext;

        AnonymousClass2(int i) {
            this.getAuthRequestContext = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            new Thread(new Runnable() { // from class: com.akamai.botman.y.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    y.BuiltInFictitiousFunctionClassFactory(y.this, AnonymousClass2.this.getAuthRequestContext);
                }
            }).start();
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        this.newProxyInstance = 0;
        this.isLayoutRequested = 0;
        this.FragmentBottomSheetPaymentSettingBinding = new ArrayList<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = new ArrayList<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new ArrayList<>();
        scheduleImpl();
    }

    private void MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        sb.append(";");
        Iterator<String> it = this.FragmentBottomSheetPaymentSettingBinding.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";");
        Iterator<Long> it2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";");
        Iterator<Integer> it3 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        synchronized (this) {
            this.scheduleImpl = sb.toString();
            this.getSupportButtonTintMode = 0;
        }
        StringBuilder sb2 = new StringBuilder("PoW Data: ");
        sb2.append(this.scheduleImpl);
        ah.PlaceComponentResult("PoW", sb2.toString(), new Throwable[0]);
        long uptimeMillis = SystemClock.uptimeMillis() - this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        StringBuilder sb3 = new StringBuilder("Time taken to solve PoW challenge: ");
        sb3.append(uptimeMillis);
        sb3.append("ms");
        ah.PlaceComponentResult("PoW", sb3.toString(), new Throwable[0]);
        StringBuilder sb4 = new StringBuilder("Solved in ");
        sb4.append(uptimeMillis);
        sb4.append("ms");
        this.getErrorConfigVersion = sb4.toString();
    }

    String getAuthRequestContext() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("/_bm/get_params?type=sdk-pow");
        return sb.toString();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (this) {
            this.PlaceComponentResult = 0;
        }
    }

    protected void PlaceComponentResult() {
        z zVar;
        zVar = z.getAuthRequestContext;
        String str = this.scheduleImpl;
        synchronized (zVar) {
            Context context = zVar.BuiltInFictitiousFunctionClassFactory.get();
            if (context == null) {
                ah.MyBillsEntityDataFactory("SensorDataCache", "savePoWResponse: Context is null", new Throwable[0]);
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("com.akamai.botman.preferences", 0).edit();
            edit.putString("pow_response", str);
            edit.commit();
        }
    }

    protected void getAuthRequestContext(String str) {
        ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Error: ".concat(String.valueOf(str)), new Throwable[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0134, code lost:
    
        if (r3 == null) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(com.akamai.botman.y r8, int r9) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.y.KClassImpl$Data$declaredNonStaticMembers$2(com.akamai.botman.y, int):void");
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(y yVar, int i) {
        if (yVar.PlaceComponentResult == 2) {
            yVar.BuiltInFictitiousFunctionClassFactory();
            return;
        }
        StringBuilder sb = new StringBuilder("computeProofOfWork, Challenge Count: ");
        sb.append(yVar.newProxyInstance);
        ah.PlaceComponentResult("PoW", sb.toString(), new Throwable[0]);
        StringBuilder sb2 = new StringBuilder("Solving MC: ");
        sb2.append(yVar.newProxyInstance);
        yVar.getErrorConfigVersion = sb2.toString();
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = yVar.GetContactSyncConfig + yVar.newProxyInstance;
            Random random = new Random();
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(BuiltInFictitiousFunctionClassFactory);
            decimalFormat.applyPattern("#.############");
            long j2 = 0;
            boolean z = false;
            while (true) {
                if (z) {
                    break;
                }
                String format = decimalFormat.format(random.nextDouble());
                int i2 = yVar.isLayoutRequested;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(yVar.NetworkUserEntityData$$ExternalSyntheticLambda7);
                sb3.append(j);
                sb3.append(format);
                String obj = sb3.toString();
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(obj.getBytes());
                Random random2 = random;
                int i3 = 0;
                long j3 = 0;
                while (i3 < messageDigest.digest().length) {
                    j3 = ((j3 << 8) | (r11[i3] & 255)) % j;
                    i3++;
                    j2 = j2;
                }
                long j4 = j2;
                if (j3 == 0) {
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    long j5 = uptimeMillis2 - uptimeMillis;
                    long j6 = uptimeMillis2 - yVar.NetworkUserEntityData$$ExternalSyntheticLambda4;
                    StringBuilder sb4 = new StringBuilder("Challenge (");
                    sb4.append(obj);
                    sb4.append(") ");
                    sb4.append(yVar.newProxyInstance);
                    sb4.append(" solved at iteration: ");
                    sb4.append(yVar.isLayoutRequested);
                    sb4.append(" in ");
                    sb4.append(j6);
                    sb4.append("ms");
                    ah.PlaceComponentResult("PoW", sb4.toString(), new Throwable[0]);
                    yVar.FragmentBottomSheetPaymentSettingBinding.add(format);
                    yVar.NetworkUserEntityData$$ExternalSyntheticLambda6.add(Integer.valueOf(yVar.isLayoutRequested));
                    yVar.NetworkUserEntityData$$ExternalSyntheticLambda3.add(Long.valueOf(j6));
                    j2 = j5;
                    z = true;
                } else {
                    int i4 = yVar.isLayoutRequested + 1;
                    yVar.isLayoutRequested = i4;
                    if (i4 % 1000 == 0) {
                        j2 = SystemClock.uptimeMillis() - uptimeMillis;
                        long j7 = yVar.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (j2 > j7 && yVar.PlaceComponentResult != 2) {
                            new Timer().schedule(new AnonymousClass2(i), j7 + 1000);
                            break;
                        }
                    } else {
                        j2 = j4;
                    }
                }
                if (yVar.PlaceComponentResult == 2) {
                    yVar.BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                random = random2;
            }
            if (z) {
                yVar.newProxyInstance++;
                yVar.NetworkUserEntityData$$ExternalSyntheticLambda4 = SystemClock.uptimeMillis();
                yVar.MyBillsEntityDataFactory(yVar.newProxyInstance);
                if (yVar.newProxyInstance < 10) {
                    yVar.isLayoutRequested = 0;
                    new Timer().schedule(new AnonymousClass2(i), yVar.DatabaseTableConfigUtil + j2);
                    return;
                }
                yVar.isLayoutRequested = 0;
                yVar.MyBillsEntityDataFactory();
                yVar.FragmentBottomSheetPaymentSettingBinding = new ArrayList<>();
                yVar.NetworkUserEntityData$$ExternalSyntheticLambda3 = new ArrayList<>();
                yVar.NetworkUserEntityData$$ExternalSyntheticLambda6 = new ArrayList<>();
                yVar.KClassImpl$Data$declaredNonStaticMembers$2();
                if (SystemClock.uptimeMillis() - yVar.NetworkUserEntityData$$ExternalSyntheticLambda8 > yVar.KClassImpl$Data$declaredNonStaticMembers$2 * 1000 && i == 0) {
                    new Timer().schedule(new AnonymousClass1(i), 100L);
                }
                yVar.PlaceComponentResult();
            }
        } catch (NoSuchAlgorithmException e) {
            StringBuilder sb5 = new StringBuilder("computeProofOfWork: ");
            sb5.append(e.toString());
            ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, sb5.toString(), new Throwable[0]);
        }
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(Application application, String str) {
        this.MyBillsEntityDataFactory = str;
        this.lookAheadTest = r.KClassImpl$Data$declaredNonStaticMembers$2(application);
        new Timer().schedule(new AnonymousClass1(0), 1000L);
    }
}
