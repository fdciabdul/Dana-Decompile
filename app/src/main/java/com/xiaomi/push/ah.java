package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
class ah {
    String MyBillsEntityDataFactory;
    final ArrayList<ag> PlaceComponentResult = new ArrayList<>();

    public ah() {
    }

    public ah(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.MyBillsEntityDataFactory = str;
    }

    public final ah BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) {
        synchronized (this) {
            this.MyBillsEntityDataFactory = jSONObject.getString("host");
            JSONArray jSONArray = jSONObject.getJSONArray("fbs");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.PlaceComponentResult.add(new ag(this.MyBillsEntityDataFactory).PlaceComponentResult(jSONArray.getJSONObject(i)));
            }
        }
        return this;
    }

    public final JSONObject BuiltInFictitiousFunctionClassFactory() {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
            jSONObject.put("host", this.MyBillsEntityDataFactory);
            JSONArray jSONArray = new JSONArray();
            Iterator<ag> it = this.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().PlaceComponentResult());
            }
            jSONObject.put("fbs", jSONArray);
        }
        return jSONObject;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ag agVar) {
        synchronized (this) {
            int i = 0;
            while (true) {
                if (i >= this.PlaceComponentResult.size()) {
                    break;
                } else if (this.PlaceComponentResult.get(i).MyBillsEntityDataFactory(agVar)) {
                    this.PlaceComponentResult.set(i, agVar);
                    break;
                } else {
                    i++;
                }
            }
            if (i >= this.PlaceComponentResult.size()) {
                this.PlaceComponentResult.add(agVar);
            }
        }
    }

    public final ag PlaceComponentResult() {
        synchronized (this) {
            for (int size = this.PlaceComponentResult.size() - 1; size >= 0; size--) {
                ag agVar = this.PlaceComponentResult.get(size);
                if (agVar.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    ak.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(agVar.MyBillsEntityDataFactory());
                    return agVar;
                }
            }
            return null;
        }
    }

    public final void getAuthRequestContext() {
        synchronized (this) {
            for (int size = this.PlaceComponentResult.size() - 1; size >= 0; size--) {
                if (this.PlaceComponentResult.get(size).moveToNextValue()) {
                    this.PlaceComponentResult.remove(size);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("\n");
        Iterator<ag> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
