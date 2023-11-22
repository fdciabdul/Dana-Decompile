package io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.TextView;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.push.e;
import id.dana.data.constant.BranchLinkConstant;
import io.branch.indexing.ContentDiscoveryManifest;
import io.branch.referral.PrefHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ContentDiscoverer {
    private static ContentDiscoverer NetworkUserEntityData$$ExternalSyntheticLambda0;
    public JSONObject BuiltInFictitiousFunctionClassFactory;
    private String DatabaseTableConfigUtil;
    public WeakReference<Activity> MyBillsEntityDataFactory;
    private int lookAheadTest;
    private ContentDiscoveryManifest moveToNextValue;
    private int initRecordTimeStamp = 15;
    public ArrayList<String> PlaceComponentResult = new ArrayList<>();
    public Runnable getAuthRequestContext = new Runnable() { // from class: io.branch.indexing.ContentDiscoverer.1
        @Override // java.lang.Runnable
        public void run() {
            JSONArray jSONArray;
            boolean z;
            JSONArray jSONArray2;
            try {
                ContentDiscoverer.KClassImpl$Data$declaredNonStaticMembers$2(ContentDiscoverer.this);
                if (!ContentDiscoverer.this.moveToNextValue.MyBillsEntityDataFactory() || ContentDiscoverer.this.MyBillsEntityDataFactory == null || ContentDiscoverer.this.MyBillsEntityDataFactory.get() == null) {
                    return;
                }
                Activity activity = (Activity) ContentDiscoverer.this.MyBillsEntityDataFactory.get();
                ContentDiscoverer.this.BuiltInFictitiousFunctionClassFactory = new JSONObject();
                ContentDiscoverer.this.BuiltInFictitiousFunctionClassFactory.put("ts", System.currentTimeMillis());
                if (!TextUtils.isEmpty(ContentDiscoverer.this.DatabaseTableConfigUtil)) {
                    ContentDiscoverer.this.BuiltInFictitiousFunctionClassFactory.put("rl", ContentDiscoverer.this.DatabaseTableConfigUtil);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("/");
                sb.append(activity.getClass().getSimpleName());
                String obj = sb.toString();
                ContentDiscoverer.this.BuiltInFictitiousFunctionClassFactory.put(SecurityConstants.KEY_VALUE, obj);
                ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
                if (viewGroup != null) {
                    ContentDiscoveryManifest.CDPathProperties BuiltInFictitiousFunctionClassFactory = ContentDiscoverer.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(activity);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        boolean KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                        ContentDiscoverer.this.BuiltInFictitiousFunctionClassFactory.put("h", !KClassImpl$Data$declaredNonStaticMembers$2);
                        z = KClassImpl$Data$declaredNonStaticMembers$2;
                        jSONArray = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
                    } else {
                        jSONArray = null;
                        z = false;
                    }
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        if (!ContentDiscoverer.this.PlaceComponentResult.contains(obj)) {
                            JSONArray jSONArray3 = new JSONArray();
                            ContentDiscoverer.this.BuiltInFictitiousFunctionClassFactory.put("ck", jSONArray3);
                            ContentDiscoverer.this.MyBillsEntityDataFactory(viewGroup, jSONArray3, activity.getResources());
                        }
                    } else {
                        JSONArray jSONArray4 = new JSONArray();
                        ContentDiscoverer.this.BuiltInFictitiousFunctionClassFactory.put("ck", jSONArray4);
                        JSONArray jSONArray5 = new JSONArray();
                        ContentDiscoverer.this.BuiltInFictitiousFunctionClassFactory.put(RVParams.CAN_DESTROY, jSONArray5);
                        ContentDiscoverer.getAuthRequestContext(ContentDiscoverer.this, jSONArray, jSONArray5, jSONArray4, activity, z);
                    }
                    ContentDiscoverer.this.PlaceComponentResult.add(obj);
                    PrefHelper.BuiltInFictitiousFunctionClassFactory(activity);
                    JSONObject jSONObject = ContentDiscoverer.this.BuiltInFictitiousFunctionClassFactory;
                    String lookAheadTest = PrefHelper.lookAheadTest("bnc_session_id");
                    if (!lookAheadTest.equals("bnc_no_value")) {
                        if (PrefHelper.BuiltInFictitiousFunctionClassFactory == null) {
                            PrefHelper.BuiltInFictitiousFunctionClassFactory = PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                        try {
                            if (PrefHelper.BuiltInFictitiousFunctionClassFactory.has(lookAheadTest)) {
                                jSONArray2 = PrefHelper.BuiltInFictitiousFunctionClassFactory.getJSONArray(lookAheadTest);
                            } else {
                                JSONArray jSONArray6 = new JSONArray();
                                PrefHelper.BuiltInFictitiousFunctionClassFactory.put(lookAheadTest, jSONArray6);
                                jSONArray2 = jSONArray6;
                            }
                            jSONArray2.put(jSONObject);
                            PrefHelper.getAuthRequestContext("bnc_branch_analytical_data", PrefHelper.BuiltInFictitiousFunctionClassFactory.toString());
                        } catch (JSONException unused) {
                        }
                    }
                    int i = ContentDiscoverer.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(activity).BuiltInFictitiousFunctionClassFactory;
                    ContentDiscoverer contentDiscoverer = ContentDiscoverer.this;
                    contentDiscoverer.initRecordTimeStamp = contentDiscoverer.moveToNextValue.BuiltInFictitiousFunctionClassFactory(activity).PlaceComponentResult;
                    if (ContentDiscoverer.this.lookAheadTest >= ContentDiscoverer.this.initRecordTimeStamp || i < 500 || jSONArray == null || jSONArray.length() <= 0) {
                        return;
                    }
                    ContentDiscoverer.this.KClassImpl$Data$declaredNonStaticMembers$2.postDelayed(ContentDiscoverer.this.getAuthRequestContext, i);
                }
            } catch (Exception unused2) {
            }
        }
    };
    public ViewTreeObserver.OnScrollChangedListener getErrorConfigVersion = new ViewTreeObserver.OnScrollChangedListener() { // from class: io.branch.indexing.ContentDiscoverer.2
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            ContentDiscoverer.this.KClassImpl$Data$declaredNonStaticMembers$2.removeCallbacks(ContentDiscoverer.this.GetContactSyncConfig);
            if (ContentDiscoverer.this.initRecordTimeStamp > ContentDiscoverer.this.lookAheadTest) {
                ContentDiscoverer.this.KClassImpl$Data$declaredNonStaticMembers$2.postDelayed(ContentDiscoverer.this.GetContactSyncConfig, 1500L);
            }
        }
    };
    private Runnable GetContactSyncConfig = new Runnable() { // from class: io.branch.indexing.ContentDiscoverer.3
        @Override // java.lang.Runnable
        public void run() {
            ContentDiscoverer.this.getAuthRequestContext.run();
        }
    };
    public Handler KClassImpl$Data$declaredNonStaticMembers$2 = new Handler();
    private final HashHelper NetworkUserEntityData$$ExternalSyntheticLambda1 = new HashHelper();
    public final Map<String, WeakReference<ViewTreeObserver>> scheduleImpl = new HashMap();

    static /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2(ContentDiscoverer contentDiscoverer) {
        int i = contentDiscoverer.lookAheadTest;
        contentDiscoverer.lookAheadTest = i + 1;
        return i;
    }

    public static ContentDiscoverer MyBillsEntityDataFactory() {
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            NetworkUserEntityData$$ExternalSyntheticLambda0 = new ContentDiscoverer();
        }
        return NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    private ContentDiscoverer() {
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, String str) {
        ContentDiscoveryManifest authRequestContext = ContentDiscoveryManifest.getAuthRequestContext(activity);
        this.moveToNextValue = authRequestContext;
        this.DatabaseTableConfigUtil = str;
        ContentDiscoveryManifest.CDPathProperties BuiltInFictitiousFunctionClassFactory = authRequestContext.BuiltInFictitiousFunctionClassFactory(activity);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory()) {
                return;
            }
            PlaceComponentResult(activity);
        } else if (TextUtils.isEmpty(this.DatabaseTableConfigUtil)) {
        } else {
            PlaceComponentResult(activity);
        }
    }

    private void PlaceComponentResult(Activity activity) {
        this.lookAheadTest = 0;
        if (this.PlaceComponentResult.size() < this.moveToNextValue.getErrorConfigVersion) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.removeCallbacks(this.getAuthRequestContext);
            this.MyBillsEntityDataFactory = new WeakReference<>(activity);
            this.KClassImpl$Data$declaredNonStaticMembers$2.postDelayed(this.getAuthRequestContext, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MyBillsEntityDataFactory(ViewGroup viewGroup, JSONArray jSONArray, Resources resources) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                if ((childAt instanceof AbsListView) || childAt.getClass().getSimpleName().equals("RecyclerView")) {
                    BuiltInFictitiousFunctionClassFactory((ViewGroup) childAt, resources, jSONArray);
                } else if (childAt instanceof ViewGroup) {
                    MyBillsEntityDataFactory((ViewGroup) childAt, jSONArray, resources);
                } else if (childAt instanceof TextView) {
                    jSONArray.put(MyBillsEntityDataFactory(childAt, resources));
                }
            }
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(ViewGroup viewGroup, Resources resources, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (viewGroup == null || viewGroup.getChildCount() < 0) {
            return;
        }
        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() <= 1 ? 0 : 1);
        if (childAt != null) {
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONObject.put(MyBillsEntityDataFactory(viewGroup, resources), jSONArray2);
            } catch (JSONException unused) {
            }
            if (childAt instanceof ViewGroup) {
                MyBillsEntityDataFactory((ViewGroup) childAt, jSONArray2, resources);
            } else if (childAt instanceof TextView) {
                jSONArray2.put(MyBillsEntityDataFactory(childAt, resources));
            }
            if (jSONObject.length() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("$");
                sb.append(jSONObject);
                jSONArray.put(sb.toString());
            }
        }
    }

    private static String MyBillsEntityDataFactory(View view, Resources resources) {
        String valueOf = String.valueOf(view.getId());
        try {
            return resources.getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return valueOf;
        }
    }

    private String getAuthRequestContext(View view, boolean z) {
        TextView textView = (TextView) view;
        if (textView.getText() != null) {
            String substring = textView.getText().toString().substring(0, Math.min(textView.getText().toString().length(), this.moveToNextValue.scheduleImpl));
            return !z ? this.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(substring) : substring;
        }
        return null;
    }

    public final JSONObject getAuthRequestContext(Context context) {
        JSONObject jSONObject;
        PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
        JSONObject KClassImpl$Data$declaredNonStaticMembers$2 = PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2.length() <= 0 || KClassImpl$Data$declaredNonStaticMembers$2.toString().length() >= this.moveToNextValue.MyBillsEntityDataFactory) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            try {
                ContentDiscoveryManifest authRequestContext = ContentDiscoveryManifest.getAuthRequestContext(context);
                jSONObject.put("mv", TextUtils.isEmpty(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2) ? "-1" : authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2).put(e.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2);
                if (context != null) {
                    jSONObject.put(BranchLinkConstant.PayloadKey.PROMO_CODE, context.getPackageName());
                    jSONObject.put(BranchLinkConstant.PayloadKey.PROMO_CODE, context.getPackageName());
                }
            } catch (JSONException unused) {
            }
        }
        PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
        PrefHelper.BuiltInFictitiousFunctionClassFactory = null;
        PrefHelper.getAuthRequestContext("bnc_branch_analytical_data", "");
        return jSONObject;
    }

    static /* synthetic */ void getAuthRequestContext(ContentDiscoverer contentDiscoverer, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, Activity activity, boolean z) {
        String str;
        JSONArray jSONArray4;
        Activity activity2;
        JSONArray jSONArray5;
        JSONArray jSONArray6;
        JSONObject jSONObject;
        int i;
        JSONArray jSONArray7 = jSONArray;
        JSONArray jSONArray8 = jSONArray2;
        JSONArray jSONArray9 = jSONArray3;
        Activity activity3 = activity;
        String str2 = "$";
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                String string = jSONArray7.getString(i2);
                if (!string.startsWith(str2)) {
                    str = str2;
                    jSONArray4 = jSONArray;
                    activity2 = activity;
                    View findViewById = activity2.findViewById(activity.getResources().getIdentifier(jSONArray4.getString(i2), "id", activity.getPackageName()));
                    if (findViewById instanceof TextView) {
                        jSONArray5 = jSONArray2;
                        jSONArray5.put(contentDiscoverer.getAuthRequestContext(findViewById, z));
                        jSONArray6 = jSONArray3;
                        jSONArray6.put(string);
                    } else {
                        jSONArray5 = jSONArray2;
                        jSONArray6 = jSONArray3;
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONArray9.put(string);
                    jSONArray8.put(jSONObject2);
                    String replace = string.replace(str2, "");
                    try {
                        jSONObject = new JSONObject(replace);
                    } catch (JSONException unused) {
                    }
                    if (jSONObject.length() > 0) {
                        String next = jSONObject.keys().next();
                        int identifier = activity.getResources().getIdentifier(next, "id", activity.getPackageName());
                        View findViewById2 = activity.getCurrentFocus() != null ? activity.getCurrentFocus().findViewById(identifier) : null;
                        if (findViewById2 == null) {
                            findViewById2 = activity3.findViewById(identifier);
                        }
                        if (findViewById2 != null && (findViewById2 instanceof ViewGroup)) {
                            ViewGroup viewGroup = (ViewGroup) findViewById2;
                            JSONArray jSONArray10 = jSONObject.getJSONArray(next);
                            int length = jSONArray10.length();
                            str = str2;
                            try {
                                int[] iArr = new int[length];
                                for (int i3 = 0; i3 < jSONArray10.length(); i3++) {
                                    iArr[i3] = activity.getResources().getIdentifier(jSONArray10.getString(i3), "id", activity.getPackageName());
                                }
                                int firstVisiblePosition = viewGroup instanceof AbsListView ? ((AbsListView) viewGroup).getFirstVisiblePosition() : 0;
                                int i4 = 0;
                                while (i4 < viewGroup.getChildCount()) {
                                    if (viewGroup.getChildAt(i4) != null) {
                                        JSONObject jSONObject3 = new JSONObject();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(i4 + firstVisiblePosition);
                                        jSONObject2.put(sb.toString(), jSONObject3);
                                        int i5 = 0;
                                        while (i5 < length) {
                                            if (viewGroup.getChildAt(i4) != null) {
                                                i = firstVisiblePosition;
                                                View findViewById3 = viewGroup.getChildAt(i4).findViewById(iArr[i5]);
                                                if (findViewById3 instanceof TextView) {
                                                    jSONObject3.put(jSONArray10.getString(i5), contentDiscoverer.getAuthRequestContext(findViewById3, z));
                                                }
                                            } else {
                                                i = firstVisiblePosition;
                                            }
                                            i5++;
                                            firstVisiblePosition = i;
                                        }
                                    }
                                    i4++;
                                    firstVisiblePosition = firstVisiblePosition;
                                }
                                if ((jSONObject.has("bnc_esw") && jSONObject.getBoolean("bnc_esw")) && !contentDiscoverer.scheduleImpl.containsKey(replace)) {
                                    viewGroup.getViewTreeObserver().addOnScrollChangedListener(contentDiscoverer.getErrorConfigVersion);
                                    contentDiscoverer.scheduleImpl.put(replace, new WeakReference<>(viewGroup.getViewTreeObserver()));
                                }
                            } catch (JSONException unused2) {
                            }
                            jSONArray4 = jSONArray;
                            jSONArray5 = jSONArray2;
                            jSONArray6 = jSONArray3;
                            activity2 = activity;
                        }
                    }
                    str = str2;
                    jSONArray4 = jSONArray;
                    jSONArray5 = jSONArray2;
                    jSONArray6 = jSONArray3;
                    activity2 = activity;
                }
                i2++;
                str2 = str;
                Activity activity4 = activity2;
                jSONArray9 = jSONArray6;
                jSONArray7 = jSONArray4;
                jSONArray8 = jSONArray5;
                activity3 = activity4;
            } catch (JSONException unused3) {
                return;
            }
        }
    }
}
