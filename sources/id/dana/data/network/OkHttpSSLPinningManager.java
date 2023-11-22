package id.dana.data.network;

import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.lang.reflect.Field;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.text.Typography;
import o.A;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;

@Singleton
/* loaded from: classes2.dex */
public class OkHttpSSLPinningManager implements IOkHttpSSLPinningManager {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String BuiltInFictitiousFunctionClassFactory = "OkHttpSSLPinningManager";
    private static final String MyBillsEntityDataFactory;
    private static int initRecordTimeStamp = 1;
    private static int lookAheadTest;
    private static int scheduleImpl;
    private OkHttpClient KClassImpl$Data$declaredNonStaticMembers$2;
    private OkHttpClient NetworkUserEntityData$$ExternalSyntheticLambda0;
    private List<String> PlaceComponentResult;
    private List<Certificate> getAuthRequestContext;
    private OkHttpClient getErrorConfigVersion;
    private int moveToNextValue;

    static {
        getAuthRequestContext();
        Object[] objArr = new Object[1];
        a(new char[]{1, 65531, 65529, '\f', 65533, 65512, 1, 6, 6, 65533, '\n', 65531, 65533, '\n', '\f', 1, 65534}, 231 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 17 - ((Process.getThreadPriority(0) + 20) >> 6), false, MotionEvent.axisFromString("") + 12, objArr);
        MyBillsEntityDataFactory = ((String) objArr[0]).intern();
        int i = initRecordTimeStamp + 87;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? '?' : ')') != '?') {
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
    }

    static void getAuthRequestContext() {
        lookAheadTest = 269894746;
    }

    @Inject
    public OkHttpSSLPinningManager(OkHttpClient okHttpClient, @Named("SECURED_OKHTTP") OkHttpClient okHttpClient2, @Named("SECURED_OKHTTP_NAMECHECK") OkHttpClient okHttpClient3) {
        try {
            this.moveToNextValue = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = okHttpClient;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = okHttpClient2;
            this.getErrorConfigVersion = okHttpClient3;
            this.getAuthRequestContext = new ArrayList();
            this.PlaceComponentResult = new ArrayList();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.network.IOkHttpSSLPinningManager
    public void getAuthRequestContext(int i) {
        int i2 = initRecordTimeStamp + 23;
        scheduleImpl = i2 % 128;
        int i3 = i2 % 2;
        try {
            this.moveToNextValue = i;
            try {
                PlaceComponentResult();
                int i4 = initRecordTimeStamp + 35;
                scheduleImpl = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        if ((r4 == null) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        if ((r4 != null) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        r0 = id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp + 53;
        id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r4.size() <= 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        r0 = 'C';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        r0 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        if (r0 == '\b') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        r0 = id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl + 41;
        id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004f, code lost:
    
        r3.getAuthRequestContext.addAll(r4);
        r4 = id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl + 21;
        id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        PlaceComponentResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        return;
     */
    @Override // id.dana.data.network.IOkHttpSSLPinningManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void PlaceComponentResult(java.util.List<java.security.cert.Certificate> r4) {
        /*
            r3 = this;
            int r0 = id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp     // Catch: java.lang.Exception -> L66
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl = r1     // Catch: java.lang.Exception -> L64
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r1) goto L1e
            java.util.List<java.security.cert.Certificate> r0 = r3.getAuthRequestContext
            r0.clear()
            if (r4 == 0) goto L1b
            r1 = 0
        L1b:
            if (r1 == 0) goto L2c
            goto L5e
        L1e:
            java.util.List<java.security.cert.Certificate> r0 = r3.getAuthRequestContext
            r0.clear()
            r0 = 84
            int r0 = r0 / r2
            if (r4 == 0) goto L29
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r1 == 0) goto L5e
        L2c:
            int r0 = id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp
            int r0 = r0 + 53
            int r1 = r0 % 128
            id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl = r1
            int r0 = r0 % 2
            int r0 = r4.size()     // Catch: java.lang.Exception -> L64
            r1 = 8
            if (r0 <= 0) goto L41
            r0 = 67
            goto L43
        L41:
            r0 = 8
        L43:
            if (r0 == r1) goto L5e
            int r0 = id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl     // Catch: java.lang.Exception -> L64
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp = r1     // Catch: java.lang.Exception -> L64
            int r0 = r0 % 2
            java.util.List<java.security.cert.Certificate> r0 = r3.getAuthRequestContext
            r0.addAll(r4)
            int r4 = id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl
            int r4 = r4 + 21
            int r0 = r4 % 128
            id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp = r0
            int r4 = r4 % 2
        L5e:
            r3.PlaceComponentResult()     // Catch: java.lang.Exception -> L66
            return
        L62:
            r4 = move-exception
            throw r4
        L64:
            r4 = move-exception
            throw r4
        L66:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.network.OkHttpSSLPinningManager.PlaceComponentResult(java.util.List):void");
    }

    @Override // id.dana.data.network.IOkHttpSSLPinningManager
    public void getAuthRequestContext(List<String> list) {
        int i = initRecordTimeStamp + 11;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            this.PlaceComponentResult.clear();
            if (list != null) {
                int i3 = scheduleImpl + 113;
                initRecordTimeStamp = i3 % 128;
                int i4 = i3 % 2;
                if ((list.size() > 0 ? 'N' : (char) 16) == 'N') {
                    int i5 = scheduleImpl + 115;
                    initRecordTimeStamp = i5 % 128;
                    int i6 = i5 % 2;
                    this.PlaceComponentResult.addAll(list);
                }
            }
            try {
                PlaceComponentResult();
                int i7 = scheduleImpl + 121;
                initRecordTimeStamp = i7 % 128;
                if (i7 % 2 == 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r4 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (BuiltInFictitiousFunctionClassFactory(r7.getAuthRequestContext) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r4 = r7.PlaceComponentResult;
        r5 = new java.lang.StringBuilder();
        r5.append("hostWhitelist:");
        r5.append(r4);
        id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r5.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r4 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if (r1 == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        if (r4.size() <= 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        r1 = MyBillsEntityDataFactory(r7.getAuthRequestContext, r4);
        BuiltInFictitiousFunctionClassFactory(r7.KClassImpl$Data$declaredNonStaticMembers$2, r1);
        BuiltInFictitiousFunctionClassFactory(r7.NetworkUserEntityData$$ExternalSyntheticLambda0, r1);
        BuiltInFictitiousFunctionClassFactory(r7.getErrorConfigVersion, r1);
        r2 = new java.lang.StringBuilder();
        r2.append("reset:");
        r2.append(r1.toString());
        id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r2.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0085, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r7.KClassImpl$Data$declaredNonStaticMembers$2, okhttp3.CertificatePinner.DEFAULT);
        BuiltInFictitiousFunctionClassFactory(r7.NetworkUserEntityData$$ExternalSyntheticLambda0, okhttp3.CertificatePinner.DEFAULT);
        BuiltInFictitiousFunctionClassFactory(r7.getErrorConfigVersion, okhttp3.CertificatePinner.DEFAULT);
        id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, "reset:DEFAULT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a2, code lost:
    
        r0 = id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp + 123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
    
        if ((r0 % 2) == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ad, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void PlaceComponentResult() {
        /*
            r7 = this;
            int r0 = id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl     // Catch: java.lang.Exception -> Lb3
            int r0 = r0 + 65
            int r1 = r0 % 128
            id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp = r1     // Catch: java.lang.Exception -> Lb1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            java.lang.String r4 = "resetCertificatePinner"
            if (r0 == 0) goto L29
            java.lang.String r0 = id.dana.data.network.OkHttpSSLPinningManager.BuiltInFictitiousFunctionClassFactory
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r4)
            java.util.List<java.security.cert.Certificate> r4 = r7.getAuthRequestContext
            boolean r4 = r7.BuiltInFictitiousFunctionClassFactory(r4)
            r3.hashCode()     // Catch: java.lang.Throwable -> L27
            if (r4 == 0) goto L86
            goto L36
        L27:
            r0 = move-exception
            throw r0
        L29:
            java.lang.String r0 = id.dana.data.network.OkHttpSSLPinningManager.BuiltInFictitiousFunctionClassFactory
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r4)
            java.util.List<java.security.cert.Certificate> r4 = r7.getAuthRequestContext
            boolean r4 = r7.BuiltInFictitiousFunctionClassFactory(r4)
            if (r4 == 0) goto L86
        L36:
            java.util.List<java.lang.String> r4 = r7.PlaceComponentResult
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "hostWhitelist:"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r5)
            if (r4 == 0) goto L4f
            goto L50
        L4f:
            r1 = 0
        L50:
            if (r1 == 0) goto L86
            int r1 = r4.size()     // Catch: java.lang.Exception -> Lb3
            if (r1 <= 0) goto L86
            java.util.List<java.security.cert.Certificate> r1 = r7.getAuthRequestContext
            okhttp3.CertificatePinner r1 = MyBillsEntityDataFactory(r1, r4)
            okhttp3.OkHttpClient r2 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            BuiltInFictitiousFunctionClassFactory(r2, r1)
            okhttp3.OkHttpClient r2 = r7.NetworkUserEntityData$$ExternalSyntheticLambda0
            BuiltInFictitiousFunctionClassFactory(r2, r1)
            okhttp3.OkHttpClient r2 = r7.getErrorConfigVersion
            BuiltInFictitiousFunctionClassFactory(r2, r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "reset:"
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r1)
            return
        L86:
            okhttp3.OkHttpClient r1 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            okhttp3.CertificatePinner r2 = okhttp3.CertificatePinner.DEFAULT
            BuiltInFictitiousFunctionClassFactory(r1, r2)
            okhttp3.OkHttpClient r1 = r7.NetworkUserEntityData$$ExternalSyntheticLambda0
            okhttp3.CertificatePinner r2 = okhttp3.CertificatePinner.DEFAULT
            BuiltInFictitiousFunctionClassFactory(r1, r2)
            okhttp3.OkHttpClient r1 = r7.getErrorConfigVersion
            okhttp3.CertificatePinner r2 = okhttp3.CertificatePinner.DEFAULT
            BuiltInFictitiousFunctionClassFactory(r1, r2)
            java.lang.String r1 = "reset:DEFAULT"
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r1)
            int r0 = id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp     // Catch: java.lang.Exception -> Lb1
            int r0 = r0 + 123
            int r1 = r0 % 128
            id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl = r1     // Catch: java.lang.Exception -> Lb3
            int r0 = r0 % 2
            if (r0 == 0) goto Lb0
            int r0 = r3.length     // Catch: java.lang.Throwable -> Lae
            return
        Lae:
            r0 = move-exception
            throw r0
        Lb0:
            return
        Lb1:
            r0 = move-exception
            throw r0
        Lb3:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.network.OkHttpSSLPinningManager.PlaceComponentResult():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean BuiltInFictitiousFunctionClassFactory(java.util.List<java.security.cert.Certificate> r6) {
        /*
            r5 = this;
            java.lang.String r0 = id.dana.data.network.OkHttpSSLPinningManager.BuiltInFictitiousFunctionClassFactory
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "pinningMode:"
            r1.append(r2)
            int r2 = r5.moveToNextValue
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Certificate size:"
            r1.append(r2)
            r2 = 60
            if (r6 != 0) goto L29
            r3 = 60
            goto L2b
        L29:
            r3 = 15
        L2b:
            r4 = 0
            if (r3 == r2) goto L35
            int r2 = r6.size()     // Catch: java.lang.Exception -> L33
            goto L40
        L33:
            r6 = move-exception
            throw r6
        L35:
            int r2 = id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp
            int r2 = r2 + 17
            int r3 = r2 % 128
            id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl = r3
            int r2 = r2 % 2
            r2 = 0
        L40:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            id.dana.utils.foundation.logger.log.DanaLog.MyBillsEntityDataFactory(r0, r1)
            if (r6 == 0) goto L7d
            int r0 = id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp = r2
            int r0 = r0 % 2
            int r6 = r6.size()
            if (r6 <= 0) goto L5e
            r6 = 1
            goto L5f
        L5e:
            r6 = 0
        L5f:
            if (r6 == r1) goto L62
            goto L7d
        L62:
            int r6 = id.dana.data.network.OkHttpSSLPinningManager.scheduleImpl
            int r6 = r6 + 51
            int r0 = r6 % 128
            id.dana.data.network.OkHttpSSLPinningManager.initRecordTimeStamp = r0
            int r6 = r6 % 2
            if (r6 != 0) goto L73
            int r6 = r5.moveToNextValue
            if (r6 != 0) goto L7d
            goto L7c
        L73:
            int r6 = r5.moveToNextValue
            if (r6 != r1) goto L79
            r6 = 0
            goto L7a
        L79:
            r6 = 1
        L7a:
            if (r6 == r1) goto L7d
        L7c:
            return r1
        L7d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.network.OkHttpSSLPinningManager.BuiltInFictitiousFunctionClassFactory(java.util.List):boolean");
    }

    private static CertificatePinner MyBillsEntityDataFactory(List<Certificate> list, List<String> list2) {
        CertificatePinner.Builder builder = new CertificatePinner.Builder();
        Iterator<String> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                return builder.build();
            }
            try {
                String next = it.next();
                Iterator<Certificate> it2 = list.iterator();
                while (true) {
                    if ((it2.hasNext() ? '7' : '?') != '?') {
                        int i = scheduleImpl + 47;
                        initRecordTimeStamp = i % 128;
                        int i2 = i % 2;
                        try {
                            builder.add(next, CertificatePinner.pin(it2.next()));
                            int i3 = initRecordTimeStamp + 77;
                            scheduleImpl = i3 % 128;
                            int i4 = i3 % 2;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(OkHttpClient okHttpClient, CertificatePinner certificatePinner) {
        int i = scheduleImpl + 67;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            Class<?> cls = okHttpClient.getClass();
            Object[] objArr = new Object[1];
            a(new char[]{1, 65531, 65529, '\f', 65533, 65512, 1, 6, 6, 65533, '\n', 65531, 65533, '\n', '\f', 1, 65534}, TextUtils.getOffsetBefore("", 0) + 231, TextUtils.indexOf("", "", 0, 0) + 17, false, 11 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr);
            Field declaredField = cls.getDeclaredField(((String) objArr[0]).intern());
            declaredField.setAccessible(true);
            declaredField.set(okHttpClient, certificatePinner);
            DanaLog.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, "replace success");
            int i3 = scheduleImpl + 47;
            initRecordTimeStamp = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object[] objArr2 = null;
                int length = objArr2.length;
            }
        } catch (IllegalAccessException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, e.toString());
        } catch (NoSuchFieldException e2) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, e2.toString());
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        int i4 = $10 + 125;
        $11 = i4 % 128;
        while (true) {
            int i5 = i4 % 2;
            if (a2.MyBillsEntityDataFactory >= i2) {
                break;
            }
            int i6 = $11 + 63;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i8 = a2.MyBillsEntityDataFactory;
            cArr2[i8] = (char) (cArr2[i8] - ((int) (lookAheadTest ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
            i4 = $10 + 95;
            $11 = i4 % 128;
        }
        if (i3 > 0) {
            int i9 = $11 + 45;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if ((z ? (char) 17 : (char) 0) != 0) {
            char[] cArr4 = new char[i2];
            try {
                a2.MyBillsEntityDataFactory = 0;
                while (true) {
                    if ((a2.MyBillsEntityDataFactory < i2 ? (char) 5 : Typography.less) != 5) {
                        break;
                    }
                    int i11 = $10 + 49;
                    $11 = i11 % 128;
                    if (i11 % 2 == 0) {
                        cArr4[a2.MyBillsEntityDataFactory] = cArr2[(a2.MyBillsEntityDataFactory + i2) >> 1];
                        a2.MyBillsEntityDataFactory %= 0;
                    } else {
                        cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                        a2.MyBillsEntityDataFactory++;
                    }
                }
                int i12 = $10 + 39;
                $11 = i12 % 128;
                int i13 = i12 % 2;
                cArr2 = cArr4;
            } catch (Exception e) {
                throw e;
            }
        }
        objArr[0] = new String(cArr2);
    }
}
