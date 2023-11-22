package com.mixpanel.android.viewcrawler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.zebra.data.BoxData;
import com.mixpanel.android.mpmetrics.ResourceIds;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.MPPair;
import com.mixpanel.android.viewcrawler.Pathfinder;
import com.mixpanel.android.viewcrawler.ViewVisitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class EditProtocol {
    private static final Class<?>[] MyBillsEntityDataFactory = new Class[0];
    private static final List<Pathfinder.PathElement> PlaceComponentResult = Collections.emptyList();
    private final ViewVisitor.OnLayoutErrorListener BuiltInFictitiousFunctionClassFactory;
    private final ImageStore KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context getAuthRequestContext;
    private final ResourceIds lookAheadTest;

    /* loaded from: classes.dex */
    public static class BadInstructionsException extends Exception {
        private static final long serialVersionUID = -4062004792184145311L;

        public BadInstructionsException(String str) {
            super(str);
        }

        public BadInstructionsException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes.dex */
    public static class InapplicableInstructionsException extends BadInstructionsException {
        private static final long serialVersionUID = 3977056710817909104L;

        public InapplicableInstructionsException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static class CantGetEditAssetsException extends Exception {
        public CantGetEditAssetsException(String str) {
            super(str);
        }

        public CantGetEditAssetsException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* loaded from: classes.dex */
    public static class Edit {
        public final ViewVisitor BuiltInFictitiousFunctionClassFactory;
        public final List<String> getAuthRequestContext;

        /* synthetic */ Edit(ViewVisitor viewVisitor, List list, byte b) {
            this(viewVisitor, list);
        }

        private Edit(ViewVisitor viewVisitor, List<String> list) {
            this.BuiltInFictitiousFunctionClassFactory = viewVisitor;
            this.getAuthRequestContext = list;
        }
    }

    public EditProtocol(Context context, ResourceIds resourceIds, ImageStore imageStore, ViewVisitor.OnLayoutErrorListener onLayoutErrorListener) {
        this.getAuthRequestContext = context;
        this.lookAheadTest = resourceIds;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageStore;
        this.BuiltInFictitiousFunctionClassFactory = onLayoutErrorListener;
    }

    public final ViewVisitor MyBillsEntityDataFactory(JSONObject jSONObject, ViewVisitor.OnEventListener onEventListener) throws BadInstructionsException {
        try {
            String string = jSONObject.getString("event_name");
            String string2 = jSONObject.getString("event_type");
            List<Pathfinder.PathElement> authRequestContext = getAuthRequestContext(jSONObject.getJSONArray("path"), this.lookAheadTest);
            if (authRequestContext.size() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("event '");
                sb.append(string);
                sb.append("' will not be bound to any element in the UI.");
                throw new InapplicableInstructionsException(sb.toString());
            } else if (DynamicLayerModel.TYPE_CLICK.equals(string2)) {
                return new ViewVisitor.AddAccessibilityEventVisitor(authRequestContext, 1, string, onEventListener);
            } else {
                if ("selected".equals(string2)) {
                    return new ViewVisitor.AddAccessibilityEventVisitor(authRequestContext, 4, string, onEventListener);
                }
                if ("text_changed".equals(string2)) {
                    return new ViewVisitor.AddTextChangeListener(authRequestContext, string, onEventListener);
                }
                if ("detected".equals(string2)) {
                    return new ViewVisitor.ViewDetectorVisitor(authRequestContext, string, onEventListener);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Mixpanel can't track event type \"");
                sb2.append(string2);
                sb2.append("\"");
                throw new BadInstructionsException(sb2.toString());
            }
        } catch (JSONException e) {
            throw new BadInstructionsException("Can't interpret instructions due to JSONException", e);
        }
    }

    public final Edit MyBillsEntityDataFactory(JSONObject jSONObject) throws BadInstructionsException, CantGetEditAssetsException {
        ViewVisitor layoutUpdateVisitor;
        Integer BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList();
        try {
            List<Pathfinder.PathElement> authRequestContext = getAuthRequestContext(jSONObject.getJSONArray("path"), this.lookAheadTest);
            if (authRequestContext.size() == 0) {
                throw new InapplicableInstructionsException("Edit will not be bound to any element in the UI.");
            }
            byte b = 0;
            if (jSONObject.getString("change_type").equals("property")) {
                String string = jSONObject.getJSONObject("property").getString("classname");
                if (string == null) {
                    throw new BadInstructionsException("Can't bind an edit property without a target class");
                }
                try {
                    PropertyDescription KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(Class.forName(string), jSONObject.getJSONObject("property"));
                    JSONArray jSONArray = jSONObject.getJSONArray("args");
                    Object[] objArr = new Object[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                        objArr[i] = getAuthRequestContext(jSONArray2.get(0), jSONArray2.getString(1), arrayList);
                    }
                    String str = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
                    Caller caller = str == null ? null : new Caller(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, str, objArr, Void.TYPE);
                    if (caller == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Can't update a read-only property ");
                        sb.append(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
                        sb.append(" (add a mutator to make this work)");
                        throw new BadInstructionsException(sb.toString());
                    }
                    layoutUpdateVisitor = new ViewVisitor.PropertySetVisitor(authRequestContext, caller, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                } catch (ClassNotFoundException e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Can't find class for visit path: ");
                    sb2.append(string);
                    throw new BadInstructionsException(sb2.toString(), e);
                }
            } else if (jSONObject.getString("change_type").equals(BoxData.ATTR_LAYOUT)) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("args");
                ArrayList arrayList2 = new ArrayList();
                int length = jSONArray3.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray3.optJSONObject(i2);
                    String string2 = optJSONObject.getString("view_id_name");
                    String string3 = optJSONObject.getString("anchor_id_name");
                    Integer BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(-1, string2, this.lookAheadTest);
                    if (string3.equals("0")) {
                        BuiltInFictitiousFunctionClassFactory = 0;
                    } else if (string3.equals("-1")) {
                        BuiltInFictitiousFunctionClassFactory = -1;
                    } else {
                        BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(-1, string3, this.lookAheadTest);
                    }
                    if (BuiltInFictitiousFunctionClassFactory2 == null || BuiltInFictitiousFunctionClassFactory == null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("View (");
                        sb3.append(string2);
                        sb3.append(") or anchor (");
                        sb3.append(string3);
                        sb3.append(") not found.");
                        MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.EProtocol", sb3.toString());
                    } else {
                        arrayList2.add(new ViewVisitor.LayoutRule(BuiltInFictitiousFunctionClassFactory2.intValue(), optJSONObject.getInt("verb"), BuiltInFictitiousFunctionClassFactory.intValue()));
                    }
                }
                layoutUpdateVisitor = new ViewVisitor.LayoutUpdateVisitor(authRequestContext, arrayList2, jSONObject.getString("name"), this.BuiltInFictitiousFunctionClassFactory);
            } else {
                throw new BadInstructionsException("Can't figure out the edit type");
            }
            return new Edit(layoutUpdateVisitor, arrayList, b);
        } catch (NoSuchMethodException e2) {
            throw new BadInstructionsException("Can't create property mutator", e2);
        } catch (JSONException e3) {
            throw new BadInstructionsException("Can't interpret instructions due to JSONException", e3);
        }
    }

    public final ViewSnapshot BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) throws BadInstructionsException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("config").getJSONArray("classes");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Class<?> cls = Class.forName(jSONObject2.getString("name"));
                JSONArray jSONArray2 = jSONObject2.getJSONArray("properties");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2(cls, jSONArray2.getJSONObject(i2)));
                }
            }
            return new ViewSnapshot(this.getAuthRequestContext, arrayList, this.lookAheadTest);
        } catch (ClassNotFoundException e) {
            throw new BadInstructionsException("Can't resolve types for snapshot configuration", e);
        } catch (JSONException e2) {
            throw new BadInstructionsException("Can't read snapshot configuration", e2);
        }
    }

    public static MPPair<String, Object> KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject) throws BadInstructionsException {
        Object string;
        try {
            String string2 = jSONObject.getString("name");
            String string3 = jSONObject.getString("type");
            if ("number".equals(string3)) {
                String string4 = jSONObject.getString("encoding");
                if (d.f7256a.equals(string4)) {
                    string = Double.valueOf(jSONObject.getDouble("value"));
                } else if ("l".equals(string4)) {
                    string = Long.valueOf(jSONObject.getLong("value"));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("number must have encoding of type \"l\" for long or \"d\" for double in: ");
                    sb.append(jSONObject);
                    throw new BadInstructionsException(sb.toString());
                }
            } else if ("boolean".equals(string3)) {
                string = Boolean.valueOf(jSONObject.getBoolean("value"));
            } else if ("string".equals(string3)) {
                string = jSONObject.getString("value");
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unrecognized tweak type ");
                sb2.append(string3);
                sb2.append(" in: ");
                sb2.append(jSONObject);
                throw new BadInstructionsException(sb2.toString());
            }
            return new MPPair<>(string2, string);
        } catch (JSONException e) {
            throw new BadInstructionsException("Can't read tweak update", e);
        }
    }

    private static List<Pathfinder.PathElement> getAuthRequestContext(JSONArray jSONArray, ResourceIds resourceIds) throws JSONException {
        int i;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            String PlaceComponentResult2 = JSONUtils.PlaceComponentResult(jSONObject, "prefix");
            String PlaceComponentResult3 = JSONUtils.PlaceComponentResult(jSONObject, "view_class");
            int optInt = jSONObject.optInt("index", -1);
            String PlaceComponentResult4 = JSONUtils.PlaceComponentResult(jSONObject, "contentDescription");
            int optInt2 = jSONObject.optInt("id", -1);
            String PlaceComponentResult5 = JSONUtils.PlaceComponentResult(jSONObject, "mp_id_name");
            String PlaceComponentResult6 = JSONUtils.PlaceComponentResult(jSONObject, "tag");
            if ("shortest".equals(PlaceComponentResult2)) {
                i = 1;
            } else if (PlaceComponentResult2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized prefix type \"");
                sb.append(PlaceComponentResult2);
                sb.append("\". No views will be matched");
                MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.EProtocol", sb.toString());
                return PlaceComponentResult;
            } else {
                i = 0;
            }
            Integer BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(optInt2, PlaceComponentResult5, resourceIds);
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return PlaceComponentResult;
            }
            arrayList.add(new Pathfinder.PathElement(i, PlaceComponentResult3, optInt, BuiltInFictitiousFunctionClassFactory.intValue(), PlaceComponentResult4, PlaceComponentResult6));
        }
        return arrayList;
    }

    private static Integer BuiltInFictitiousFunctionClassFactory(int i, String str, ResourceIds resourceIds) {
        int i2;
        if (str == null) {
            i2 = -1;
        } else if (resourceIds.MyBillsEntityDataFactory(str)) {
            i2 = resourceIds.BuiltInFictitiousFunctionClassFactory(str);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \"");
            sb.append(str);
            sb.append("\"");
            MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.EProtocol", sb.toString());
            return null;
        }
        if (-1 != i2 && -1 != i && i2 != i) {
            MPLog.getAuthRequestContext("MixpanelAPI.EProtocol", "Path contains both a named and an explicit id, and they don't match. No views will be matched.");
            return null;
        } else if (-1 != i2) {
            return Integer.valueOf(i2);
        } else {
            return Integer.valueOf(i);
        }
    }

    private static PropertyDescription KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls, JSONObject jSONObject) throws BadInstructionsException {
        Caller caller;
        try {
            String string = jSONObject.getString("name");
            if (jSONObject.has("get")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("get");
                caller = new Caller(cls, jSONObject2.getString("selector"), MyBillsEntityDataFactory, Class.forName(jSONObject2.getJSONObject("result").getString("type")));
            } else {
                caller = null;
            }
            return new PropertyDescription(string, cls, caller, jSONObject.has("set") ? jSONObject.getJSONObject("set").getString("selector") : null);
        } catch (ClassNotFoundException e) {
            throw new BadInstructionsException("Can't read property JSON, relevant arg/return class not found", e);
        } catch (NoSuchMethodException e2) {
            throw new BadInstructionsException("Can't create property reader", e2);
        } catch (JSONException e3) {
            throw new BadInstructionsException("Can't read property JSON", e3);
        }
    }

    private Object getAuthRequestContext(Object obj, String str, List<String> list) throws BadInstructionsException, CantGetEditAssetsException {
        try {
            if (!"java.lang.CharSequence".equals(str) && !"boolean".equals(str) && !"java.lang.Boolean".equals(str)) {
                if (!"int".equals(str) && !"java.lang.Integer".equals(str)) {
                    if (!"float".equals(str) && !"java.lang.Float".equals(str)) {
                        if ("android.graphics.drawable.Drawable".equals(str)) {
                            return BuiltInFictitiousFunctionClassFactory((JSONObject) obj, list);
                        }
                        if ("android.graphics.drawable.BitmapDrawable".equals(str)) {
                            return BuiltInFictitiousFunctionClassFactory((JSONObject) obj, list);
                        }
                        if ("android.graphics.drawable.ColorDrawable".equals(str)) {
                            return new ColorDrawable(((Number) obj).intValue());
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Don't know how to interpret type ");
                        sb.append(str);
                        sb.append(" (arg was ");
                        sb.append(obj);
                        sb.append(")");
                        throw new BadInstructionsException(sb.toString());
                    }
                    return Float.valueOf(((Number) obj).floatValue());
                }
                return Integer.valueOf(((Number) obj).intValue());
            }
            return obj;
        } catch (ClassCastException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Couldn't interpret <");
            sb2.append(obj);
            sb2.append("> as ");
            sb2.append(str);
            throw new BadInstructionsException(sb2.toString());
        }
    }

    private Drawable BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject, List<String> list) throws BadInstructionsException, CantGetEditAssetsException {
        int i;
        int i2;
        int i3;
        int i4;
        try {
            if (jSONObject.isNull("url")) {
                throw new BadInstructionsException("Can't construct a BitmapDrawable with a null url");
            }
            String string = jSONObject.getString("url");
            boolean isNull = jSONObject.isNull("dimensions");
            boolean z = false;
            if (isNull) {
                i3 = 0;
                i = 0;
                i2 = 0;
                i4 = isNull;
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject("dimensions");
                int i5 = jSONObject2.getInt("left");
                int i6 = jSONObject2.getInt("right");
                i = jSONObject2.getInt("top");
                i2 = jSONObject2.getInt("bottom");
                i3 = i6;
                z = true;
                i4 = i5;
            }
            try {
                Bitmap KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(string);
                list.add(string);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(Resources.getSystem(), KClassImpl$Data$declaredNonStaticMembers$2);
                if (z) {
                    bitmapDrawable.setBounds(i4, i, i3, i2);
                }
                return bitmapDrawable;
            } catch (ImageStore.CantGetImageException e) {
                throw new CantGetEditAssetsException(e.getMessage(), e.getCause());
            }
        } catch (JSONException e2) {
            throw new BadInstructionsException("Couldn't read drawable description", e2);
        }
    }
}
