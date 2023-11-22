package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import j$.util.DesugarTimeZone;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public abstract class cj {
    private static long KClassImpl$Data$declaredNonStaticMembers$2;
    private static String MyBillsEntityDataFactory;
    public static final DateFormat initRecordTimeStamp;
    private final Map<String, Object> BuiltInFictitiousFunctionClassFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda3;
    public String NetworkUserEntityData$$ExternalSyntheticLambda6;
    public String NetworkUserEntityData$$ExternalSyntheticLambda7;
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;
    List<cg> PrepareContext;
    private String getAuthRequestContext;
    cn isLayoutRequested;
    String newProxyInstance;
    protected static final String DatabaseTableConfigUtil = Locale.getDefault().getLanguage().toLowerCase();
    private static String PlaceComponentResult = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        initRecordTimeStamp = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC"));
        StringBuilder sb = new StringBuilder();
        sb.append(cu.PlaceComponentResult());
        sb.append("-");
        MyBillsEntityDataFactory = sb.toString();
        KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
    }

    public cj() {
        this.getAuthRequestContext = PlaceComponentResult;
        this.newProxyInstance = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
        this.PrepareContext = new CopyOnWriteArrayList();
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        this.isLayoutRequested = null;
    }

    public cj(Bundle bundle) {
        this.getAuthRequestContext = PlaceComponentResult;
        this.newProxyInstance = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
        this.PrepareContext = new CopyOnWriteArrayList();
        this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        this.isLayoutRequested = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = bundle.getString("ext_to");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = bundle.getString("ext_from");
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = bundle.getString("ext_chid");
        this.newProxyInstance = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.PrepareContext = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                this.PrepareContext.add(cg.KClassImpl$Data$declaredNonStaticMembers$2((Bundle) parcelable));
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.isLayoutRequested = new cn(bundle2);
        }
    }

    private Object BuiltInFictitiousFunctionClassFactory(String str) {
        synchronized (this) {
            Map<String, Object> map = this.BuiltInFictitiousFunctionClassFactory;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
    }

    public static String BuiltInFictitiousFunctionClassFactory() {
        String obj;
        synchronized (cj.class) {
            StringBuilder sb = new StringBuilder();
            sb.append(MyBillsEntityDataFactory);
            long j = KClassImpl$Data$declaredNonStaticMembers$2;
            KClassImpl$Data$declaredNonStaticMembers$2 = 1 + j;
            sb.append(Long.toString(j));
            obj = sb.toString();
        }
        return obj;
    }

    private Collection<cg> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        synchronized (this) {
            if (this.PrepareContext == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(new ArrayList(this.PrepareContext));
        }
    }

    public static String PlaceComponentResult() {
        return DatabaseTableConfigUtil;
    }

    private Collection<String> getErrorConfigVersion() {
        synchronized (this) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                return Collections.emptySet();
            }
            return Collections.unmodifiableSet(new HashSet(this.BuiltInFictitiousFunctionClassFactory.keySet()));
        }
    }

    public abstract String MyBillsEntityDataFactory();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        cj cjVar = (cj) obj;
        cn cnVar = this.isLayoutRequested;
        if (cnVar == null ? cjVar.isLayoutRequested == null : cnVar.equals(cjVar.isLayoutRequested)) {
            String str = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (str == null ? cjVar.NetworkUserEntityData$$ExternalSyntheticLambda8 == null : str.equals(cjVar.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
                if (this.PrepareContext.equals(cjVar.PrepareContext)) {
                    String str2 = this.newProxyInstance;
                    if (str2 == null ? cjVar.newProxyInstance == null : str2.equals(cjVar.newProxyInstance)) {
                        String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                        if (str3 == null ? cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3 == null : str3.equals(cjVar.NetworkUserEntityData$$ExternalSyntheticLambda3)) {
                            Map<String, Object> map = this.BuiltInFictitiousFunctionClassFactory;
                            if (map == null ? cjVar.BuiltInFictitiousFunctionClassFactory == null : map.equals(cjVar.BuiltInFictitiousFunctionClassFactory)) {
                                String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                                if (str4 == null ? cjVar.NetworkUserEntityData$$ExternalSyntheticLambda7 == null : str4.equals(cjVar.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
                                    String str5 = this.getAuthRequestContext;
                                    String str6 = cjVar.getAuthRequestContext;
                                    if (str5 != null) {
                                        if (str5.equals(str6)) {
                                            return true;
                                        }
                                    } else if (str6 == null) {
                                        return true;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final String getAuthRequestContext() {
        if ("ID_NOT_AVAILABLE".equals(this.newProxyInstance)) {
            return null;
        }
        if (this.newProxyInstance == null) {
            this.newProxyInstance = BuiltInFictitiousFunctionClassFactory();
        }
        return this.newProxyInstance;
    }

    public int hashCode() {
        String str = this.getAuthRequestContext;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.newProxyInstance;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int hashCode4 = str4 != null ? str4.hashCode() : 0;
        String str5 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        int hashCode5 = str5 != null ? str5.hashCode() : 0;
        int hashCode6 = this.PrepareContext.hashCode();
        int hashCode7 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        cn cnVar = this.isLayoutRequested;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (cnVar != null ? cnVar.hashCode() : 0);
    }

    public final String moveToNextValue() {
        return this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String scheduleImpl() {
        String obj;
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            Iterator<cg> it = NetworkUserEntityData$$ExternalSyntheticLambda0().iterator();
            while (it.hasNext()) {
                sb.append(it.next().BuiltInFictitiousFunctionClassFactory());
            }
            Map<String, Object> map = this.BuiltInFictitiousFunctionClassFactory;
            if (map != null && !map.isEmpty()) {
                sb.append(aa.getAuthRequestContext("PHByb3BlcnRpZXMgeG1sbnM9Imh0dHA6Ly93d3cuaml2ZXNvZnR3YXJlLmNvbS94bWxucy94bXBwL3Byb3BlcnRpZXMiPg=="));
                for (String str : getErrorConfigVersion()) {
                    Object BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str);
                    sb.append("<property>");
                    sb.append("<name>");
                    sb.append(cu.BuiltInFictitiousFunctionClassFactory(str));
                    sb.append("</name>");
                    sb.append("<value type=\"");
                    if (BuiltInFictitiousFunctionClassFactory instanceof Integer) {
                        sb.append("integer\">");
                    } else if (BuiltInFictitiousFunctionClassFactory instanceof Long) {
                        sb.append("long\">");
                    } else if (BuiltInFictitiousFunctionClassFactory instanceof Float) {
                        sb.append("float\">");
                    } else if (BuiltInFictitiousFunctionClassFactory instanceof Double) {
                        sb.append("double\">");
                    } else if (BuiltInFictitiousFunctionClassFactory instanceof Boolean) {
                        sb.append("boolean\">");
                    } else if (BuiltInFictitiousFunctionClassFactory instanceof String) {
                        sb.append("string\">");
                        sb.append(cu.BuiltInFictitiousFunctionClassFactory((String) BuiltInFictitiousFunctionClassFactory));
                        sb.append("</value>");
                        sb.append("</property>");
                    } else {
                        ObjectOutputStream objectOutputStream2 = null;
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            } catch (Exception unused) {
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Exception unused2) {
                            byteArrayOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = null;
                        }
                        try {
                            objectOutputStream.writeObject(BuiltInFictitiousFunctionClassFactory);
                            sb.append("java-object\">");
                            sb.append(cu.MyBillsEntityDataFactory(byteArrayOutputStream.toByteArray()));
                            sb.append("</value>");
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        } catch (Exception unused4) {
                            objectOutputStream2 = objectOutputStream;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception unused5) {
                                }
                            }
                            if (byteArrayOutputStream == null) {
                                sb.append("</property>");
                            }
                            byteArrayOutputStream.close();
                            sb.append("</property>");
                        } catch (Throwable th3) {
                            th = th3;
                            objectOutputStream2 = objectOutputStream;
                            if (objectOutputStream2 != null) {
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception unused6) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused7) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused8) {
                        }
                        sb.append("</property>");
                    }
                    sb.append(BuiltInFictitiousFunctionClassFactory);
                    sb.append("</value>");
                    sb.append("</property>");
                }
                sb.append("</properties>");
            }
            obj = sb.toString();
        }
        return obj;
    }

    public Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.getAuthRequestContext)) {
            bundle.putString("ext_ns", this.getAuthRequestContext);
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
            bundle.putString("ext_from", this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
            bundle.putString("ext_to", this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }
        if (!TextUtils.isEmpty(this.newProxyInstance)) {
            bundle.putString("ext_pkt_id", this.newProxyInstance);
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda3)) {
            bundle.putString("ext_chid", this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        }
        cn cnVar = this.isLayoutRequested;
        int i = 0;
        if (cnVar != null) {
            Bundle bundle2 = new Bundle();
            String str = cnVar.PlaceComponentResult;
            if (str != null) {
                bundle2.putString("ext_err_type", str);
            }
            bundle2.putInt("ext_err_code", cnVar.getAuthRequestContext);
            String str2 = cnVar.MyBillsEntityDataFactory;
            if (str2 != null) {
                bundle2.putString("ext_err_reason", str2);
            }
            String str3 = cnVar.BuiltInFictitiousFunctionClassFactory;
            if (str3 != null) {
                bundle2.putString("ext_err_cond", str3);
            }
            String str4 = cnVar.getErrorConfigVersion;
            if (str4 != null) {
                bundle2.putString("ext_err_msg", str4);
            }
            List<cg> list = cnVar.KClassImpl$Data$declaredNonStaticMembers$2;
            if (list != null) {
                Bundle[] bundleArr = new Bundle[list.size()];
                Iterator<cg> it = cnVar.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    bundleArr[i2] = it.next().getAuthRequestContext();
                    i2++;
                }
                bundle2.putParcelableArray("ext_exts", bundleArr);
            }
            bundle.putBundle("ext_ERROR", bundle2);
        }
        List<cg> list2 = this.PrepareContext;
        if (list2 != null) {
            Bundle[] bundleArr2 = new Bundle[list2.size()];
            Iterator<cg> it2 = this.PrepareContext.iterator();
            while (it2.hasNext()) {
                bundleArr2[i] = it2.next().getAuthRequestContext();
                i++;
            }
            bundle.putParcelableArray("ext_exts", bundleArr2);
        }
        return bundle;
    }

    public final cg KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        for (cg cgVar : this.PrepareContext) {
            if (str.equals(cgVar.PlaceComponentResult)) {
                return cgVar;
            }
        }
        return null;
    }
}
