package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes8.dex */
public class cg implements ck {
    private String[] BuiltInFictitiousFunctionClassFactory;
    private List<cg> KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    String PlaceComponentResult;
    private String getAuthRequestContext;
    private String[] moveToNextValue;

    public cg(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.moveToNextValue = null;
    }

    public cg(String str, String str2, String[] strArr, String[] strArr2, String str3, List<cg> list) {
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = str2;
        this.BuiltInFictitiousFunctionClassFactory = strArr;
        this.moveToNextValue = strArr2;
        this.MyBillsEntityDataFactory = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    public static cg KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(KClassImpl$Data$declaredNonStaticMembers$2((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new cg(string, string2, strArr, strArr2, string3, arrayList);
    }

    @Override // com.xiaomi.push.ck
    public final String BuiltInFictitiousFunctionClassFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(this.PlaceComponentResult);
        if (!TextUtils.isEmpty(this.getAuthRequestContext)) {
            sb.append(" ");
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.getAuthRequestContext);
            sb.append("\"");
        }
        String[] strArr = this.BuiltInFictitiousFunctionClassFactory;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory.length; i++) {
                if (!TextUtils.isEmpty(this.moveToNextValue[i])) {
                    sb.append(" ");
                    sb.append(this.BuiltInFictitiousFunctionClassFactory[i]);
                    sb.append("=\"");
                    sb.append(cu.BuiltInFictitiousFunctionClassFactory(this.moveToNextValue[i]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
            List<cg> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            Iterator<cg> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                sb.append(it.next().BuiltInFictitiousFunctionClassFactory());
            }
        } else {
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            sb.append(this.MyBillsEntityDataFactory);
        }
        sb.append("</");
        sb.append(this.PlaceComponentResult);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    public final String PlaceComponentResult(String str) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.BuiltInFictitiousFunctionClassFactory;
            if (i >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i])) {
                return this.moveToNextValue[i];
            }
            i++;
        }
    }

    public final Bundle getAuthRequestContext() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.PlaceComponentResult);
        bundle.putString("ext_ns", this.getAuthRequestContext);
        bundle.putString("ext_text", this.MyBillsEntityDataFactory);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.BuiltInFictitiousFunctionClassFactory;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.BuiltInFictitiousFunctionClassFactory;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.moveToNextValue[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<cg> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
        return bundle;
    }

    public String toString() {
        return BuiltInFictitiousFunctionClassFactory();
    }

    private static Parcelable[] PlaceComponentResult(List<cg> list) {
        cg[] cgVarArr = (cg[]) list.toArray(new cg[list.size()]);
        if (cgVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[cgVarArr.length];
        for (int i = 0; i < cgVarArr.length; i++) {
            parcelableArr[i] = cgVarArr[i].getAuthRequestContext();
        }
        return parcelableArr;
    }
}
