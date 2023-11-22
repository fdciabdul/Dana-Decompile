package com.akamai.botman;

import android.app.Application;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.text.Typography;
import o.D;

/* loaded from: classes.dex */
public class x extends y {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long DatabaseTableConfigUtil = 0;
    private static final x NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static int PrepareContext = 1;
    private static int isLayoutRequested = 0;
    private static final String moveToNextValue = "x";
    public String BuiltInFictitiousFunctionClassFactory;
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public a getAuthRequestContext;
    private long initRecordTimeStamp = System.currentTimeMillis();
    private String GetContactSyncConfig = "";

    /* loaded from: classes3.dex */
    public interface a {
        void BuiltInFictitiousFunctionClassFactory(float f);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();

        void getAuthRequestContext(String str);
    }

    static /* synthetic */ String BuiltInFictitiousFunctionClassFactory() {
        int i = PrepareContext + 81;
        isLayoutRequested = i % 128;
        if (!(i % 2 == 0)) {
            String str = moveToNextValue;
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return moveToNextValue;
    }

    static /* synthetic */ boolean MyBillsEntityDataFactory(x xVar, String str) {
        int i = isLayoutRequested + 71;
        PrepareContext = i % 128;
        int i2 = i % 2;
        boolean PlaceComponentResult = xVar.PlaceComponentResult(str);
        int i3 = PrepareContext + 31;
        isLayoutRequested = i3 % 128;
        int i4 = i3 % 2;
        return PlaceComponentResult;
    }

    static {
        try {
            DatabaseTableConfigUtil = 9101406409200617789L;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = new x();
            int i = PrepareContext + 113;
            isLayoutRequested = i % 128;
            if ((i % 2 != 0 ? 'M' : (char) 4) != 4) {
                int i2 = 17 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private x() {
    }

    public static x KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = isLayoutRequested + 19;
        PrepareContext = i % 128;
        if (i % 2 == 0) {
            try {
                x xVar = NetworkUserEntityData$$ExternalSyntheticLambda0;
                Object obj = null;
                obj.hashCode();
                return xVar;
            } catch (Exception e) {
                throw e;
            }
        }
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final String MyBillsEntityDataFactory() {
        synchronized (this) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 != null && System.currentTimeMillis() <= this.initRecordTimeStamp) {
                return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
            return "";
        }
    }

    @Override // com.akamai.botman.y
    final String getAuthRequestContext() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("/_bm/get_params?type=sdk-cca");
        StringBuilder sb2 = new StringBuilder(sb.toString());
        try {
            String str = this.BuiltInFictitiousFunctionClassFactory;
            if ((str != null ? '\r' : (char) 11) != 11) {
                int i = isLayoutRequested + 77;
                PrepareContext = i % 128;
                int i2 = i % 2;
                if ((!str.equals("") ? (char) 7 : 'B') != 'B') {
                    sb2.append("&context=");
                    String str2 = this.BuiltInFictitiousFunctionClassFactory;
                    Object[] objArr = new Object[1];
                    a(-ExpandableListView.getPackedPositionChild(0L), new char[]{15321, 15244, 26854, 60519, 480, 2060, 42560, 10258, 10421}, objArr);
                    sb2.append(URLEncoder.encode(str2, ((String) objArr[0]).intern()));
                    int i3 = PrepareContext + 61;
                    isLayoutRequested = i3 % 128;
                    int i4 = i3 % 2;
                }
            }
            String str3 = this.GetContactSyncConfig;
            if ((str3 != null ? 'A' : Typography.dollar) != '$' && !str3.equals("")) {
                int i5 = isLayoutRequested + 71;
                PrepareContext = i5 % 128;
                int i6 = i5 % 2;
                sb2.append("&payload=");
                String str4 = this.GetContactSyncConfig;
                Object[] objArr2 = new Object[1];
                a((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1, new char[]{15321, 15244, 26854, 60519, 480, 2060, 42560, 10258, 10421}, objArr2);
                sb2.append(URLEncoder.encode(str4, ((String) objArr2[0]).intern()));
            }
        } catch (UnsupportedEncodingException unused) {
        }
        this.GetContactSyncConfig = "";
        return sb2.toString();
    }

    @Override // com.akamai.botman.y
    protected final void PlaceComponentResult() {
        new Thread(new Runnable() { // from class: com.akamai.botman.x.1
            {
                x.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                x xVar = x.this;
                x.MyBillsEntityDataFactory(xVar, xVar.scheduleImpl);
                x.BuiltInFictitiousFunctionClassFactory();
            }
        }).start();
        int i = PrepareContext + 115;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
    }

    @Override // com.akamai.botman.y
    protected final void MyBillsEntityDataFactory(int i) {
        int i2 = isLayoutRequested + 121;
        PrepareContext = i2 % 128;
        int i3 = i2 % 2;
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(i / 10.0f);
        try {
            int i4 = PrepareContext + 21;
            try {
                isLayoutRequested = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // com.akamai.botman.y
    protected final void getAuthRequestContext(String str) {
        int i = PrepareContext + 21;
        isLayoutRequested = i % 128;
        if ((i % 2 != 0 ? '-' : (char) 4) != '-') {
            String str2 = moveToNextValue;
            ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Error: ".concat(String.valueOf(str)), new Throwable[0]);
        } else {
            String str3 = moveToNextValue;
            ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Error: ".concat(String.valueOf(str)), new Throwable[1]);
        }
        this.getAuthRequestContext.PlaceComponentResult();
        this.getAuthRequestContext.getAuthRequestContext(str);
        int i2 = PrepareContext + 11;
        isLayoutRequested = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 5 : 'J') != 5) {
            return;
        }
        int i3 = 18 / 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.akamai.botman.y
    public final void scheduleImpl() {
        super.scheduleImpl();
        this.getAuthRequestContext.PlaceComponentResult();
        this.getAuthRequestContext.getAuthRequestContext();
        synchronized (this) {
            this.PlaceComponentResult = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:195:0x01dc, code lost:
    
        if (r2 != null) goto L196;
     */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean PlaceComponentResult(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.akamai.botman.x.PlaceComponentResult(java.lang.String):boolean");
    }

    @Override // com.akamai.botman.y
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Application application, String str) {
        int i = PrepareContext + 97;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        this.MyBillsEntityDataFactory = str;
        this.lookAheadTest = r.KClassImpl$Data$declaredNonStaticMembers$2(application);
        int i3 = isLayoutRequested + 115;
        PrepareContext = i3 % 128;
        int i4 = i3 % 2;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(DatabaseTableConfigUtil ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            if (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
                int i2 = $11 + 45;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (DatabaseTableConfigUtil ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            } else {
                String str = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                try {
                    int i4 = $10 + 97;
                    $11 = i4 % 128;
                    int i5 = i4 % 2;
                    objArr[0] = str;
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }
}
