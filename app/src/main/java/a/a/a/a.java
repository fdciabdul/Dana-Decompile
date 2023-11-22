package a.a.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public class a {
    public ArrayList KClassImpl$Data$declaredNonStaticMembers$2;

    public a() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    public a(d dVar) {
        this();
        char c;
        char KClassImpl$Data$declaredNonStaticMembers$2;
        char KClassImpl$Data$declaredNonStaticMembers$22 = dVar.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$22 == '[') {
            c = ']';
        } else if (KClassImpl$Data$declaredNonStaticMembers$22 != '(') {
            throw dVar.BuiltInFictitiousFunctionClassFactory("A JSONArray text must start with '['");
        } else {
            c = ')';
        }
        if (dVar.KClassImpl$Data$declaredNonStaticMembers$2() == ']') {
            return;
        }
        dVar.MyBillsEntityDataFactory();
        while (true) {
            if (dVar.KClassImpl$Data$declaredNonStaticMembers$2() == ',') {
                dVar.MyBillsEntityDataFactory();
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(null);
            } else {
                dVar.MyBillsEntityDataFactory();
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(dVar.getAuthRequestContext());
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = dVar.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 == ')') {
                break;
            } else if (KClassImpl$Data$declaredNonStaticMembers$2 == ',' || KClassImpl$Data$declaredNonStaticMembers$2 == ';') {
                if (dVar.KClassImpl$Data$declaredNonStaticMembers$2() == ']') {
                    return;
                }
                dVar.MyBillsEntityDataFactory();
            } else if (KClassImpl$Data$declaredNonStaticMembers$2 != ']') {
                throw dVar.BuiltInFictitiousFunctionClassFactory("Expected a ',' or ']'");
            }
        }
        if (c == KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        StringBuilder sb = new StringBuilder("Expected a '");
        sb.append(Character.valueOf(c));
        sb.append("'");
        throw dVar.BuiltInFictitiousFunctionClassFactory(sb.toString());
    }

    public a(String str) {
        this(new d(str));
    }

    public a(Collection collection) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(Array.get(obj, i));
            }
            return;
        }
        throw new b("JSONArray initial value should be a string or collection or array.");
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder("[");
            int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(c.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.get(i)));
            }
            sb.append(stringBuffer.toString());
            sb.append(']');
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public final Object BuiltInFictitiousFunctionClassFactory(int i) {
        Object obj = (i < 0 || i >= this.KClassImpl$Data$declaredNonStaticMembers$2.size()) ? null : this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder("JSONArray[");
        sb.append(i);
        sb.append("] not found.");
        throw new b(sb.toString());
    }
}
