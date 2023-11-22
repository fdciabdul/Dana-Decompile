package a.a.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class c {
    public static final Object PlaceComponentResult = new a(0);
    public Map getAuthRequestContext;

    /* loaded from: classes3.dex */
    static final class a {
        protected final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return "null";
        }

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public c() {
        this.getAuthRequestContext = new HashMap();
    }

    public c(d dVar) {
        this();
        if (dVar.KClassImpl$Data$declaredNonStaticMembers$2() != '{') {
            throw dVar.BuiltInFictitiousFunctionClassFactory("A JSONObject text must begin with '{'");
        }
        while (true) {
            char KClassImpl$Data$declaredNonStaticMembers$2 = dVar.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                throw dVar.BuiltInFictitiousFunctionClassFactory("A JSONObject text must end with '}'");
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2 == '}') {
                return;
            }
            dVar.MyBillsEntityDataFactory();
            String obj = dVar.getAuthRequestContext().toString();
            char KClassImpl$Data$declaredNonStaticMembers$22 = dVar.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$22 == '=') {
                if (dVar.PlaceComponentResult() != '>') {
                    dVar.MyBillsEntityDataFactory();
                }
            } else if (KClassImpl$Data$declaredNonStaticMembers$22 != ':') {
                throw dVar.BuiltInFictitiousFunctionClassFactory("Expected a ':' after a key");
            }
            Object authRequestContext = dVar.getAuthRequestContext();
            if (obj != null) {
                if (authRequestContext != null) {
                    MyBillsEntityDataFactory(authRequestContext);
                    this.getAuthRequestContext.put(obj, authRequestContext);
                } else {
                    this.getAuthRequestContext.remove(obj);
                }
                char KClassImpl$Data$declaredNonStaticMembers$23 = dVar.KClassImpl$Data$declaredNonStaticMembers$2();
                if (KClassImpl$Data$declaredNonStaticMembers$23 != ',' && KClassImpl$Data$declaredNonStaticMembers$23 != ';') {
                    if (KClassImpl$Data$declaredNonStaticMembers$23 != '}') {
                        throw dVar.BuiltInFictitiousFunctionClassFactory("Expected a ',' or '}'");
                    }
                    return;
                } else if (dVar.KClassImpl$Data$declaredNonStaticMembers$2() == '}') {
                    return;
                } else {
                    dVar.MyBillsEntityDataFactory();
                }
            } else {
                throw new b("Null key.");
            }
        }
    }

    public c(Map map) {
        this.getAuthRequestContext = map == null ? new HashMap() : map;
    }

    public c(String str) {
        this(new d(str));
    }

    public static String PlaceComponentResult(String str) {
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append(Typography.quote);
        int i = 0;
        char c = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                stringBuffer.append("\\f");
            } else if (charAt != '\r') {
                if (charAt != '\"') {
                    if (charAt == '/') {
                        if (c == '<') {
                            stringBuffer.append('\\');
                        }
                        stringBuffer.append(charAt);
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                stringBuffer.append("\\b");
                                continue;
                            case '\t':
                                stringBuffer.append("\\t");
                                continue;
                            case '\n':
                                stringBuffer.append("\\n");
                                continue;
                            default:
                                if (charAt < ' ' || ((charAt >= 128 && charAt < 160) || (charAt >= 8192 && charAt < 8448))) {
                                    StringBuilder sb = new StringBuilder("000");
                                    sb.append(Integer.toHexString(charAt));
                                    String obj = sb.toString();
                                    StringBuilder sb2 = new StringBuilder("\\u");
                                    sb2.append(obj.substring(obj.length() - 4));
                                    stringBuffer.append(sb2.toString());
                                    break;
                                } else {
                                    stringBuffer.append(charAt);
                                    continue;
                                }
                                break;
                        }
                    }
                }
                stringBuffer.append('\\');
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append("\\r");
            }
            i++;
            c = charAt;
        }
        stringBuffer.append(Typography.quote);
        return stringBuffer.toString();
    }

    private static void MyBillsEntityDataFactory(Object obj) {
        if (obj != null) {
            if (obj instanceof Double) {
                Double d = (Double) obj;
                if (d.isInfinite() || d.isNaN()) {
                    throw new b("JSON does not allow non-finite numbers.");
                }
            } else if (obj instanceof Float) {
                Float f = (Float) obj;
                if (f.isInfinite() || f.isNaN()) {
                    throw new b("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String PlaceComponentResult(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (number == null) {
                throw new b("Null pointer");
            }
            MyBillsEntityDataFactory(number);
            String obj2 = number.toString();
            if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
                return obj2;
            }
            while (obj2.endsWith("0")) {
                obj2 = obj2.substring(0, obj2.length() - 1);
            }
            return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
        } else if ((obj instanceof Boolean) || (obj instanceof c) || (obj instanceof a.a.a.a)) {
            return obj.toString();
        } else {
            if (obj instanceof Map) {
                return new c((Map) obj).toString();
            }
            if (obj instanceof Collection) {
                return new a.a.a.a((Collection) obj).toString();
            }
            if (obj.getClass().isArray()) {
                return new a.a.a.a(obj).toString();
            }
            return PlaceComponentResult(obj.toString());
        }
    }

    public final Object BuiltInFictitiousFunctionClassFactory(String str) {
        Object obj = str == null ? null : this.getAuthRequestContext.get(str);
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder("JSONObject[");
        sb.append(PlaceComponentResult(str));
        sb.append("] not found.");
        throw new b(sb.toString());
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{");
            for (Object obj : this.getAuthRequestContext.keySet()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                stringBuffer.append(PlaceComponentResult(obj.toString()));
                stringBuffer.append(':');
                stringBuffer.append(PlaceComponentResult(this.getAuthRequestContext.get(obj)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
