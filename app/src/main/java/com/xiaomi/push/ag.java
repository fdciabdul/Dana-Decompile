package com.xiaomi.push;

import android.text.TextUtils;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ag {
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private long NetworkUserEntityData$$ExternalSyntheticLambda1;
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public String PlaceComponentResult;
    public String lookAheadTest;
    public String moveToNextValue;
    protected String scheduleImpl;
    private ArrayList<ap> GetContactSyncConfig = new ArrayList<>();
    double getAuthRequestContext = 0.1d;
    String getErrorConfigVersion = "s.mi1.cc";
    private long initRecordTimeStamp = 86400000;

    public ag(String str) {
        this.BuiltInFictitiousFunctionClassFactory = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = System.currentTimeMillis();
        this.GetContactSyncConfig.add(new ap(str, -1));
        this.BuiltInFictitiousFunctionClassFactory = ak.BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    private void BuiltInFictitiousFunctionClassFactory(String str) {
        synchronized (this) {
            Iterator<ap> it = this.GetContactSyncConfig.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().MyBillsEntityDataFactory, str)) {
                    it.remove();
                }
            }
        }
    }

    public final ArrayList<String> BuiltInFictitiousFunctionClassFactory() {
        ArrayList<String> PlaceComponentResult;
        synchronized (this) {
            PlaceComponentResult = PlaceComponentResult(false);
        }
        return PlaceComponentResult;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return TextUtils.equals(this.BuiltInFictitiousFunctionClassFactory, ak.BuiltInFictitiousFunctionClassFactory());
    }

    public final String MyBillsEntityDataFactory() {
        synchronized (this) {
            if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            } else if (TextUtils.isEmpty(this.lookAheadTest)) {
                return "hardcode_isp";
            } else {
                String MyBillsEntityDataFactory = ad.MyBillsEntityDataFactory(new String[]{this.lookAheadTest, this.MyBillsEntityDataFactory, this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue}, "_");
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = MyBillsEntityDataFactory;
                return MyBillsEntityDataFactory;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(ap apVar) {
        synchronized (this) {
            BuiltInFictitiousFunctionClassFactory(apVar.MyBillsEntityDataFactory);
            this.GetContactSyncConfig.add(apVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        r1.BuiltInFictitiousFunctionClassFactory(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void MyBillsEntityDataFactory(java.lang.String r4, com.xiaomi.push.af r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList<com.xiaomi.push.ap> r0 = r3.GetContactSyncConfig     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L20
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L20
            com.xiaomi.push.ap r1 = (com.xiaomi.push.ap) r1     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r1.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L20
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L7
            r1.BuiltInFictitiousFunctionClassFactory(r5)     // Catch: java.lang.Throwable -> L20
        L1e:
            monitor-exit(r3)
            return
        L20:
            r4 = move-exception
            monitor-exit(r3)
            goto L24
        L23:
            throw r4
        L24:
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ag.MyBillsEntityDataFactory(java.lang.String, com.xiaomi.push.af):void");
    }

    public final boolean MyBillsEntityDataFactory(ag agVar) {
        return TextUtils.equals(this.BuiltInFictitiousFunctionClassFactory, agVar.BuiltInFictitiousFunctionClassFactory);
    }

    public ArrayList<String> PlaceComponentResult(boolean z) {
        ArrayList<String> arrayList;
        int indexOf;
        synchronized (this) {
            int size = this.GetContactSyncConfig.size();
            ap[] apVarArr = new ap[size];
            this.GetContactSyncConfig.toArray(apVarArr);
            Arrays.sort(apVarArr);
            arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ap apVar = apVarArr[i];
                arrayList.add((z || (indexOf = apVar.MyBillsEntityDataFactory.indexOf(":")) == -1) ? apVar.MyBillsEntityDataFactory : apVar.MyBillsEntityDataFactory.substring(0, indexOf));
            }
        }
        return arrayList;
    }

    public final JSONObject PlaceComponentResult() {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
            jSONObject.put("net", this.BuiltInFictitiousFunctionClassFactory);
            jSONObject.put("ttl", this.initRecordTimeStamp);
            jSONObject.put("pct", this.getAuthRequestContext);
            jSONObject.put("ts", this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            jSONObject.put("city", this.PlaceComponentResult);
            jSONObject.put("prv", this.MyBillsEntityDataFactory);
            jSONObject.put("cty", this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            jSONObject.put("isp", this.lookAheadTest);
            jSONObject.put(SemanticAttributes.NetTransportValues.IP, this.moveToNextValue);
            jSONObject.put("host", this.KClassImpl$Data$declaredNonStaticMembers$2);
            jSONObject.put("xf", this.scheduleImpl);
            JSONArray jSONArray = new JSONArray();
            Iterator<ap> it = this.GetContactSyncConfig.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().getAuthRequestContext());
            }
            jSONObject.put("fbs", jSONArray);
        }
        return jSONObject;
    }

    public final void getAuthRequestContext(long j) {
        if (j > 0) {
            this.initRecordTimeStamp = j;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("the duration is invalid ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean getAuthRequestContext() {
        return System.currentTimeMillis() - this.NetworkUserEntityData$$ExternalSyntheticLambda1 < this.initRecordTimeStamp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean moveToNextValue() {
        long j = this.initRecordTimeStamp;
        if (864000000 >= j) {
            j = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return currentTimeMillis > j || (currentTimeMillis > this.initRecordTimeStamp && this.BuiltInFictitiousFunctionClassFactory.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append("\n");
        sb.append(MyBillsEntityDataFactory());
        Iterator<ap> it = this.GetContactSyncConfig.iterator();
        while (it.hasNext()) {
            ap next = it.next();
            sb.append("\n");
            sb.append(next.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    public final ag PlaceComponentResult(JSONObject jSONObject) {
        int i;
        synchronized (this) {
            this.BuiltInFictitiousFunctionClassFactory = jSONObject.optString("net");
            this.initRecordTimeStamp = jSONObject.getLong("ttl");
            this.getAuthRequestContext = jSONObject.getDouble("pct");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = jSONObject.getLong("ts");
            this.PlaceComponentResult = jSONObject.optString("city");
            this.MyBillsEntityDataFactory = jSONObject.optString("prv");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = jSONObject.optString("cty");
            this.lookAheadTest = jSONObject.optString("isp");
            this.moveToNextValue = jSONObject.optString(SemanticAttributes.NetTransportValues.IP);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject.optString("host");
            this.scheduleImpl = jSONObject.optString("xf");
            JSONArray jSONArray = jSONObject.getJSONArray("fbs");
            i = 0;
            while (i < jSONArray.length()) {
                ap authRequestContext = new ap().getAuthRequestContext(jSONArray.getJSONObject(i));
                synchronized (this) {
                    BuiltInFictitiousFunctionClassFactory(authRequestContext.MyBillsEntityDataFactory);
                    this.GetContactSyncConfig.add(authRequestContext);
                }
            }
            return this;
        }
        i++;
    }

    public final ArrayList<String> MyBillsEntityDataFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = PlaceComponentResult(true).iterator();
            while (it.hasNext()) {
                ai PlaceComponentResult = ai.PlaceComponentResult(it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.MyBillsEntityDataFactory, url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        synchronized (this) {
            ap apVar = new ap(str);
            synchronized (this) {
                BuiltInFictitiousFunctionClassFactory(apVar.MyBillsEntityDataFactory);
                this.GetContactSyncConfig.add(apVar);
            }
        }
    }

    public final void MyBillsEntityDataFactory(String str, long j, long j2, Exception exc) {
        try {
            MyBillsEntityDataFactory(new URL(str).getHost(), new af(-1, j, j2, exc));
        } catch (MalformedURLException unused) {
        }
    }

    public final void MyBillsEntityDataFactory(String[] strArr) {
        int i;
        synchronized (this) {
            int size = this.GetContactSyncConfig.size() - 1;
            while (true) {
                i = 0;
                if (size < 0) {
                    break;
                }
                int length = strArr.length;
                while (true) {
                    if (i < length) {
                        if (TextUtils.equals(this.GetContactSyncConfig.get(size).MyBillsEntityDataFactory, strArr[i])) {
                            this.GetContactSyncConfig.remove(size);
                            break;
                        }
                        i++;
                    }
                }
                size--;
            }
            Iterator<ap> it = this.GetContactSyncConfig.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                ap next = it.next();
                if (next.BuiltInFictitiousFunctionClassFactory > i2) {
                    i2 = next.BuiltInFictitiousFunctionClassFactory;
                }
            }
            while (i < strArr.length) {
                ap apVar = new ap(strArr[i], (strArr.length + i2) - i);
                synchronized (this) {
                    BuiltInFictitiousFunctionClassFactory(apVar.MyBillsEntityDataFactory);
                    this.GetContactSyncConfig.add(apVar);
                }
            }
            return;
        }
        i++;
    }
}
