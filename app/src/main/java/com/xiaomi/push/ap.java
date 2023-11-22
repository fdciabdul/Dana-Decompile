package com.xiaomi.push;

import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
class ap implements Comparable<ap> {
    protected int BuiltInFictitiousFunctionClassFactory;
    private long KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    private final LinkedList<af> getAuthRequestContext;

    public ap() {
        this(null, 0);
    }

    public ap(String str) {
        this(str, 0);
    }

    public ap(String str, int i) {
        this.getAuthRequestContext = new LinkedList<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(":");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        return sb.toString();
    }

    public final ap getAuthRequestContext(JSONObject jSONObject) {
        synchronized (this) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject.getLong(RVParams.TRANSPARENT);
            this.BuiltInFictitiousFunctionClassFactory = jSONObject.getInt("wt");
            this.MyBillsEntityDataFactory = jSONObject.getString("host");
            JSONArray jSONArray = jSONObject.getJSONArray("ah");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                LinkedList<af> linkedList = this.getAuthRequestContext;
                af afVar = new af();
                afVar.MyBillsEntityDataFactory = jSONObject2.getLong(GriverMonitorConstants.KEY_COST);
                afVar.PlaceComponentResult = jSONObject2.getLong(GriverMonitorConstants.KEY_SIZE);
                afVar.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject2.getLong("ts");
                afVar.BuiltInFictitiousFunctionClassFactory = jSONObject2.getInt("wt");
                afVar.getAuthRequestContext = jSONObject2.optString("expt");
                linkedList.add(afVar);
            }
        }
        return this;
    }

    public final JSONObject getAuthRequestContext() {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
            jSONObject.put(RVParams.TRANSPARENT, this.KClassImpl$Data$declaredNonStaticMembers$2);
            jSONObject.put("wt", this.BuiltInFictitiousFunctionClassFactory);
            jSONObject.put("host", this.MyBillsEntityDataFactory);
            JSONArray jSONArray = new JSONArray();
            Iterator<af> it = this.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                af next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GriverMonitorConstants.KEY_COST, next.MyBillsEntityDataFactory);
                jSONObject2.put(GriverMonitorConstants.KEY_SIZE, next.PlaceComponentResult);
                jSONObject2.put("ts", next.KClassImpl$Data$declaredNonStaticMembers$2);
                jSONObject2.put("wt", next.BuiltInFictitiousFunctionClassFactory);
                jSONObject2.put("expt", next.getAuthRequestContext);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("ah", jSONArray);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(af afVar) {
        synchronized (this) {
            if (afVar != null) {
                this.getAuthRequestContext.add(afVar);
                int i = afVar.BuiltInFictitiousFunctionClassFactory;
                if (i > 0) {
                    this.BuiltInFictitiousFunctionClassFactory += afVar.BuiltInFictitiousFunctionClassFactory;
                } else {
                    int i2 = 0;
                    for (int size = this.getAuthRequestContext.size() - 1; size >= 0 && this.getAuthRequestContext.get(size).BuiltInFictitiousFunctionClassFactory < 0; size--) {
                        i2++;
                    }
                    this.BuiltInFictitiousFunctionClassFactory += i * i2;
                }
                if (this.getAuthRequestContext.size() > 30) {
                    this.BuiltInFictitiousFunctionClassFactory -= this.getAuthRequestContext.remove().BuiltInFictitiousFunctionClassFactory;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(ap apVar) {
        ap apVar2 = apVar;
        if (apVar2 == null) {
            return 1;
        }
        return apVar2.BuiltInFictitiousFunctionClassFactory - this.BuiltInFictitiousFunctionClassFactory;
    }
}
