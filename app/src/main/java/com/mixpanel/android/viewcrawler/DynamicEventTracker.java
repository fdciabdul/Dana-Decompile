package com.mixpanel.android.viewcrawler;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.ViewVisitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DynamicEventTracker implements ViewVisitor.OnEventListener {
    private static String MyBillsEntityDataFactory = "MixpanelAPI.DynamicEventTracker";
    private final Handler BuiltInFictitiousFunctionClassFactory;
    private final MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2;
    private final Map<Signature, UnsentEvent> getAuthRequestContext = new HashMap();
    private final Runnable PlaceComponentResult = new SendDebouncedTask(this, 0);

    public DynamicEventTracker(MixpanelAPI mixpanelAPI, Handler handler) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = mixpanelAPI;
        this.BuiltInFictitiousFunctionClassFactory = handler;
    }

    @Override // com.mixpanel.android.viewcrawler.ViewVisitor.OnEventListener
    public final void BuiltInFictitiousFunctionClassFactory(View view, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$text", getAuthRequestContext(view));
            jSONObject.put("$from_binding", true);
            jSONObject.put("time", currentTimeMillis / 1000);
        } catch (JSONException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, "Can't format properties from view due to JSON issue", e);
        }
        if (z) {
            Signature signature = new Signature(view, str);
            UnsentEvent unsentEvent = new UnsentEvent(str, jSONObject, currentTimeMillis);
            synchronized (this.getAuthRequestContext) {
                boolean isEmpty = this.getAuthRequestContext.isEmpty();
                this.getAuthRequestContext.put(signature, unsentEvent);
                if (isEmpty) {
                    this.BuiltInFictitiousFunctionClassFactory.postDelayed(this.PlaceComponentResult, 1000L);
                }
            }
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(str, jSONObject);
    }

    /* loaded from: classes.dex */
    final class SendDebouncedTask implements Runnable {
        private SendDebouncedTask() {
        }

        /* synthetic */ SendDebouncedTask(DynamicEventTracker dynamicEventTracker, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (DynamicEventTracker.this.getAuthRequestContext) {
                Iterator it = DynamicEventTracker.this.getAuthRequestContext.entrySet().iterator();
                while (it.hasNext()) {
                    UnsentEvent unsentEvent = (UnsentEvent) ((Map.Entry) it.next()).getValue();
                    if (currentTimeMillis - unsentEvent.MyBillsEntityDataFactory > 1000) {
                        DynamicEventTracker.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(unsentEvent.getAuthRequestContext, unsentEvent.BuiltInFictitiousFunctionClassFactory);
                        it.remove();
                    }
                }
                if (!DynamicEventTracker.this.getAuthRequestContext.isEmpty()) {
                    DynamicEventTracker.this.BuiltInFictitiousFunctionClassFactory.postDelayed(this, 500L);
                }
            }
        }
    }

    private static String getAuthRequestContext(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                return text.toString();
            }
            return null;
        } else if (view instanceof ViewGroup) {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount && sb.length() < 128; i++) {
                String authRequestContext = getAuthRequestContext(viewGroup.getChildAt(i));
                if (authRequestContext != null && authRequestContext.length() > 0) {
                    if (z) {
                        sb.append(", ");
                    }
                    sb.append(authRequestContext);
                    z = true;
                }
            }
            if (sb.length() > 128) {
                return sb.substring(0, 128);
            }
            if (z) {
                return sb.toString();
            }
            return null;
        } else {
            return null;
        }
    }

    /* loaded from: classes.dex */
    static class Signature {
        private final int MyBillsEntityDataFactory;

        public Signature(View view, String str) {
            this.MyBillsEntityDataFactory = view.hashCode() ^ str.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof Signature) && this.MyBillsEntityDataFactory == obj.hashCode();
        }

        public int hashCode() {
            return this.MyBillsEntityDataFactory;
        }
    }

    /* loaded from: classes.dex */
    static class UnsentEvent {
        public final JSONObject BuiltInFictitiousFunctionClassFactory;
        public final long MyBillsEntityDataFactory;
        public final String getAuthRequestContext;

        public UnsentEvent(String str, JSONObject jSONObject, long j) {
            this.getAuthRequestContext = str;
            this.BuiltInFictitiousFunctionClassFactory = jSONObject;
            this.MyBillsEntityDataFactory = j;
        }
    }
}
