package com.mixpanel.android.mpmetrics;

import android.R;
import android.content.Context;
import android.util.SparseArray;
import com.mixpanel.android.util.MPLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class ResourceReader implements ResourceIds {
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final Map<String, Integer> getAuthRequestContext = new HashMap();
    private final SparseArray<String> PlaceComponentResult = new SparseArray<>();

    protected abstract Class<?> MyBillsEntityDataFactory();

    protected abstract String PlaceComponentResult();

    /* loaded from: classes.dex */
    public static class Ids extends ResourceReader {
        private final String PlaceComponentResult;

        public Ids(String str, Context context) {
            super(context);
            this.PlaceComponentResult = str;
            getAuthRequestContext();
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        protected final Class<?> MyBillsEntityDataFactory() {
            return R.id.class;
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        protected final String PlaceComponentResult() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.PlaceComponentResult);
            sb.append(".R$id");
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class Drawables extends ResourceReader {
        private final String BuiltInFictitiousFunctionClassFactory;

        /* JADX INFO: Access modifiers changed from: protected */
        public Drawables(String str, Context context) {
            super(context);
            this.BuiltInFictitiousFunctionClassFactory = str;
            getAuthRequestContext();
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        protected final Class<?> MyBillsEntityDataFactory() {
            return R.drawable.class;
        }

        @Override // com.mixpanel.android.mpmetrics.ResourceReader
        protected final String PlaceComponentResult() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(".R$drawable");
            return sb.toString();
        }
    }

    protected ResourceReader(Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // com.mixpanel.android.mpmetrics.ResourceIds
    public final boolean MyBillsEntityDataFactory(String str) {
        return this.getAuthRequestContext.containsKey(str);
    }

    @Override // com.mixpanel.android.mpmetrics.ResourceIds
    public final int BuiltInFictitiousFunctionClassFactory(String str) {
        return this.getAuthRequestContext.get(str).intValue();
    }

    @Override // com.mixpanel.android.mpmetrics.ResourceIds
    public final String BuiltInFictitiousFunctionClassFactory(int i) {
        return this.PlaceComponentResult.get(i);
    }

    private static void MyBillsEntityDataFactory(Class<?> cls, String str, Map<String, Integer> map) {
        try {
            for (Field field : cls.getFields()) {
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE) {
                    try {
                        String name = field.getName();
                        int i = field.getInt(null);
                        if (str != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(":");
                            sb.append(name);
                            name = sb.toString();
                        }
                        map.put(name, Integer.valueOf(i));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Can't read built-in id name from ");
                        sb2.append(cls.getName());
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.RsrcReader", sb2.toString(), e);
                    }
                }
            }
        } catch (IllegalAccessException e2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Can't read built-in id names from ");
            sb3.append(cls.getName());
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.RsrcReader", sb3.toString(), e2);
        }
    }

    protected final void getAuthRequestContext() {
        this.getAuthRequestContext.clear();
        this.PlaceComponentResult.clear();
        MyBillsEntityDataFactory(MyBillsEntityDataFactory(), "android", this.getAuthRequestContext);
        String PlaceComponentResult = PlaceComponentResult();
        try {
            MyBillsEntityDataFactory(Class.forName(PlaceComponentResult), null, this.getAuthRequestContext);
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't load names for Android view ids from '");
            sb.append(PlaceComponentResult);
            sb.append("', ids by name will not be available in the events editor.");
            MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.RsrcReader", sb.toString());
            MPLog.MyBillsEntityDataFactory("MixpanelAPI.RsrcReader", "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the Mixpanel library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.mixpanel.android.MPConfig.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag.");
        }
        for (Map.Entry<String, Integer> entry : this.getAuthRequestContext.entrySet()) {
            this.PlaceComponentResult.put(entry.getValue().intValue(), entry.getKey());
        }
    }
}
