package com.mixpanel.android.mpmetrics;

import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.mixpanel.android.util.MPLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Tweaks {
    private final ConcurrentMap<String, TweakValue> getAuthRequestContext = new ConcurrentHashMap();
    private final ConcurrentMap<String, TweakValue> KClassImpl$Data$declaredNonStaticMembers$2 = new ConcurrentHashMap();
    public final ConcurrentMap<String, TweakValue> PlaceComponentResult = new ConcurrentHashMap();
    public final List<OnTweakDeclaredListener> MyBillsEntityDataFactory = new ArrayList();

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Tweak<String> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$10  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass10 implements Tweak<Byte> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$11  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass11 implements Tweak<Short> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$12  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass12 implements Tweak<Boolean> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$2  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Tweak<Double> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$3  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Tweak<Double> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$4  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements Tweak<Float> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$5  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 implements Tweak<Float> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$6  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 implements Tweak<Long> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$7  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass7 implements Tweak<Long> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$8  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass8 implements Tweak<Integer> {
    }

    /* renamed from: com.mixpanel.android.mpmetrics.Tweaks$9  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass9 implements Tweak<Integer> {
    }

    /* loaded from: classes.dex */
    public interface OnTweakDeclaredListener {
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, Object obj) {
        synchronized (this) {
            if (!this.getAuthRequestContext.containsKey(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Attempt to set a tweak \"");
                sb.append(str);
                sb.append("\" which has never been defined.");
                MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.Tweaks", sb.toString());
                return;
            }
            TweakValue tweakValue = this.getAuthRequestContext.get(str);
            this.getAuthRequestContext.put(str, new TweakValue(tweakValue.getAuthRequestContext, tweakValue.PlaceComponentResult, tweakValue.MyBillsEntityDataFactory, tweakValue.KClassImpl$Data$declaredNonStaticMembers$2, obj, tweakValue.BuiltInFictitiousFunctionClassFactory));
        }
    }

    public final boolean MyBillsEntityDataFactory(String str, Object obj) {
        synchronized (this) {
            if (this.getAuthRequestContext.containsKey(str)) {
                return !this.getAuthRequestContext.get(str).getErrorConfigVersion.equals(obj);
            }
            return false;
        }
    }

    public final Map<String, TweakValue> getAuthRequestContext() {
        HashMap hashMap;
        synchronized (this) {
            hashMap = new HashMap(this.getAuthRequestContext);
        }
        return hashMap;
    }

    public final Map<String, TweakValue> KClassImpl$Data$declaredNonStaticMembers$2() {
        HashMap hashMap;
        synchronized (this) {
            hashMap = new HashMap(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return hashMap;
    }

    /* loaded from: classes.dex */
    public static class TweakValue {
        final String BuiltInFictitiousFunctionClassFactory;
        public final Number KClassImpl$Data$declaredNonStaticMembers$2;
        public final Number MyBillsEntityDataFactory;
        public final Object PlaceComponentResult;
        public final int getAuthRequestContext;
        public final Object getErrorConfigVersion;

        TweakValue(int i, Object obj, Number number, Number number2, Object obj2, String str) {
            Object obj3;
            Long l = obj2;
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.MyBillsEntityDataFactory = number;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = number2;
            if (number == null || number2 == null) {
                obj3 = obj;
            } else {
                if (MyBillsEntityDataFactory(obj)) {
                    obj3 = obj;
                } else {
                    obj3 = Long.valueOf(Math.min(Math.max(((Number) obj).longValue(), number.longValue()), number2.longValue()));
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempt to define a tweak \"");
                    sb.append(str);
                    sb.append("\" with default value ");
                    sb.append(obj3);
                    sb.append(" out of its bounds [");
                    sb.append(number);
                    sb.append(", ");
                    sb.append(number2);
                    sb.append("]Tweak \"");
                    sb.append(str);
                    sb.append("\" new default value: ");
                    sb.append(obj3);
                    sb.append(".");
                    MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.Tweaks", sb.toString());
                }
                if (!MyBillsEntityDataFactory(l)) {
                    Long valueOf = Long.valueOf(Math.min(Math.max(((Number) l).longValue(), number.longValue()), number2.longValue()));
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Attempt to define a tweak \"");
                    sb2.append(str);
                    sb2.append("\" with value ");
                    sb2.append(obj3);
                    sb2.append(" out of its bounds [");
                    sb2.append(number);
                    sb2.append(", ");
                    sb2.append(number2);
                    sb2.append("]Tweak \"");
                    sb2.append(str);
                    sb2.append("\" new value: ");
                    sb2.append(valueOf);
                    sb2.append(".");
                    MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.Tweaks", sb2.toString());
                    l = valueOf;
                }
            }
            this.PlaceComponentResult = obj3;
            this.getErrorConfigVersion = l;
        }

        private boolean MyBillsEntityDataFactory(Object obj) {
            try {
                Number number = (Number) obj;
                if (Math.min(Math.max(number.longValue(), this.MyBillsEntityDataFactory.longValue()), this.KClassImpl$Data$declaredNonStaticMembers$2.longValue()) != this.MyBillsEntityDataFactory.longValue()) {
                    return Math.min(Math.max(number.longValue(), this.MyBillsEntityDataFactory.longValue()), this.KClassImpl$Data$declaredNonStaticMembers$2.longValue()) != this.KClassImpl$Data$declaredNonStaticMembers$2.longValue();
                }
                return false;
            } catch (ClassCastException unused) {
                return true;
            }
        }

        public final String getAuthRequestContext() {
            String str;
            try {
                str = (String) this.PlaceComponentResult;
            } catch (ClassCastException unused) {
                str = null;
            }
            try {
                return (String) this.getErrorConfigVersion;
            } catch (ClassCastException unused2) {
                return str;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Number] */
        public final Number KClassImpl$Data$declaredNonStaticMembers$2() {
            int i = 0;
            Object obj = this.PlaceComponentResult;
            if (obj != null) {
                try {
                    i = (Number) obj;
                } catch (ClassCastException unused) {
                }
            }
            Object obj2 = this.getErrorConfigVersion;
            if (obj2 != null) {
                try {
                    return (Number) obj2;
                } catch (ClassCastException unused2) {
                    return i;
                }
            }
            return i;
        }

        public final Boolean MyBillsEntityDataFactory() {
            Boolean bool = Boolean.FALSE;
            Object obj = this.PlaceComponentResult;
            if (obj != null) {
                try {
                    bool = (Boolean) obj;
                } catch (ClassCastException unused) {
                }
            }
            Object obj2 = this.getErrorConfigVersion;
            if (obj2 != null) {
                try {
                    return (Boolean) obj2;
                } catch (ClassCastException unused2) {
                    return bool;
                }
            }
            return bool;
        }

        public static TweakValue PlaceComponentResult(JSONObject jSONObject) {
            String string;
            String string2;
            Object string3;
            Number number;
            Number number2;
            Object obj;
            int i;
            Object valueOf;
            Object valueOf2;
            Number valueOf3;
            Number valueOf4;
            try {
                string = jSONObject.getString("name");
                string2 = jSONObject.getString("type");
            } catch (JSONException unused) {
            }
            if ("number".equals(string2)) {
                String string4 = jSONObject.getString("encoding");
                int i2 = 3;
                if (d.f7256a.equals(string4)) {
                    valueOf = Double.valueOf(jSONObject.getDouble("value"));
                    valueOf2 = Double.valueOf(jSONObject.getDouble("default"));
                    valueOf3 = !jSONObject.isNull("minimum") ? Double.valueOf(jSONObject.getDouble("minimum")) : null;
                    if (jSONObject.isNull("maximum")) {
                        i2 = 2;
                        valueOf4 = null;
                        number2 = valueOf4;
                        obj = valueOf;
                        string3 = valueOf2;
                        int i3 = i2;
                        number = valueOf3;
                        i = i3;
                    } else {
                        valueOf4 = Double.valueOf(jSONObject.getDouble("maximum"));
                        i2 = 2;
                        number2 = valueOf4;
                        obj = valueOf;
                        string3 = valueOf2;
                        int i32 = i2;
                        number = valueOf3;
                        i = i32;
                    }
                } else if (!"l".equals(string4)) {
                    return null;
                } else {
                    valueOf = Long.valueOf(jSONObject.getLong("value"));
                    valueOf2 = Long.valueOf(jSONObject.getLong("default"));
                    valueOf3 = !jSONObject.isNull("minimum") ? Long.valueOf(jSONObject.getLong("minimum")) : null;
                    if (!jSONObject.isNull("maximum")) {
                        valueOf4 = Long.valueOf(jSONObject.getLong("maximum"));
                        number2 = valueOf4;
                        obj = valueOf;
                        string3 = valueOf2;
                        int i322 = i2;
                        number = valueOf3;
                        i = i322;
                    }
                    valueOf4 = null;
                    number2 = valueOf4;
                    obj = valueOf;
                    string3 = valueOf2;
                    int i3222 = i2;
                    number = valueOf3;
                    i = i3222;
                }
                return null;
            } else if ("boolean".equals(string2)) {
                boolean z = jSONObject.getBoolean("value");
                string3 = Boolean.valueOf(jSONObject.getBoolean("default"));
                number = null;
                number2 = null;
                obj = Boolean.valueOf(z);
                i = 1;
            } else {
                if ("string".equals(string2)) {
                    Object string5 = jSONObject.getString("value");
                    string3 = jSONObject.getString("default");
                    number = null;
                    number2 = null;
                    obj = string5;
                    i = 4;
                }
                return null;
            }
            return new TweakValue(i, string3, number, number2, obj, string);
        }
    }
}
