package com.mixpanel.android.mpmetrics;

import android.content.Context;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.mpmetrics.MPDbAdapter;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.UpdatesFromMixpanel;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DecideMessages {
    private static final Set<Integer> PlaceComponentResult = new HashSet();
    Boolean BuiltInFictitiousFunctionClassFactory;
    final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final Set<Integer> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final UpdatesFromMixpanel NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final OnNewResultsListener getErrorConfigVersion;
    private Context moveToNextValue;
    private String scheduleImpl = null;
    final List<InAppNotification> getAuthRequestContext = new LinkedList();
    final List<InAppNotification> MyBillsEntityDataFactory = new LinkedList();
    private JSONArray initRecordTimeStamp = null;
    private Set<String> lookAheadTest = new HashSet();

    /* loaded from: classes.dex */
    public interface OnNewResultsListener {
        void MyBillsEntityDataFactory();
    }

    public DecideMessages(Context context, String str, OnNewResultsListener onNewResultsListener, UpdatesFromMixpanel updatesFromMixpanel, HashSet<Integer> hashSet) {
        this.moveToNextValue = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getErrorConfigVersion = onNewResultsListener;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = updatesFromMixpanel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new HashSet(hashSet);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        synchronized (this) {
            String str2 = this.scheduleImpl;
            if (str2 == null || !str2.equals(str)) {
                this.getAuthRequestContext.clear();
            }
            this.scheduleImpl = str;
        }
    }

    public final String MyBillsEntityDataFactory() {
        String str;
        synchronized (this) {
            str = this.scheduleImpl;
        }
        return str;
    }

    public final void BuiltInFictitiousFunctionClassFactory(List<InAppNotification> list, List<InAppNotification> list2, JSONArray jSONArray, JSONArray jSONArray2, boolean z, JSONArray jSONArray3) {
        boolean z2;
        OnNewResultsListener onNewResultsListener;
        synchronized (this) {
            int length = jSONArray2.length();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(jSONArray);
            boolean z3 = true;
            boolean z4 = false;
            for (InAppNotification inAppNotification : list) {
                int PlaceComponentResult2 = inAppNotification.PlaceComponentResult();
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.contains(Integer.valueOf(PlaceComponentResult2))) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(Integer.valueOf(PlaceComponentResult2));
                    this.getAuthRequestContext.add(inAppNotification);
                    z4 = true;
                }
            }
            for (InAppNotification inAppNotification2 : list2) {
                int PlaceComponentResult3 = inAppNotification2.PlaceComponentResult();
                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.contains(Integer.valueOf(PlaceComponentResult3))) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(Integer.valueOf(PlaceComponentResult3));
                    this.MyBillsEntityDataFactory.add(inAppNotification2);
                    z4 = true;
                }
            }
            this.initRecordTimeStamp = jSONArray2;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = false;
                    break;
                }
                try {
                } catch (JSONException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not convert variants[");
                    sb.append(i);
                    sb.append("] into a JSONObject while comparing the new variants");
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DecideUpdts", sb.toString(), e);
                }
                if (!PlaceComponentResult.contains(Integer.valueOf(jSONArray2.getJSONObject(i).getInt("id")))) {
                    z2 = true;
                    z4 = true;
                    break;
                }
                i++;
            }
            if (z2 && this.initRecordTimeStamp != null) {
                PlaceComponentResult.clear();
                for (int i2 = 0; i2 < length; i2++) {
                    try {
                        PlaceComponentResult.add(Integer.valueOf(this.initRecordTimeStamp.getJSONObject(i2).getInt("id")));
                    } catch (JSONException e2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Could not convert variants[");
                        sb2.append(i2);
                        sb2.append("] into a JSONObject while updating the map");
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DecideUpdts", sb2.toString(), e2);
                    }
                }
            }
            if (length == 0) {
                this.initRecordTimeStamp = new JSONArray();
                Set<Integer> set = PlaceComponentResult;
                if (set.size() > 0) {
                    set.clear();
                    z4 = true;
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult(this.initRecordTimeStamp);
            if (this.BuiltInFictitiousFunctionClassFactory == null && !z) {
                MPDbAdapter authRequestContext = MPDbAdapter.getAuthRequestContext(this.moveToNextValue);
                String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
                synchronized (authRequestContext) {
                    authRequestContext.PlaceComponentResult(MPDbAdapter.Table.EVENTS, str);
                    authRequestContext.PlaceComponentResult(MPDbAdapter.Table.PEOPLE, str);
                    authRequestContext.PlaceComponentResult(MPDbAdapter.Table.GROUPS, str);
                }
            }
            this.BuiltInFictitiousFunctionClassFactory = Boolean.valueOf(z);
            if (jSONArray3 != null) {
                try {
                    HashSet hashSet = new HashSet();
                    for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                        hashSet.add(jSONArray3.getString(i3));
                    }
                    if (this.lookAheadTest.equals(hashSet)) {
                        z3 = z4;
                    } else {
                        this.lookAheadTest = hashSet;
                    }
                    z4 = z3;
                } catch (JSONException e3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Got an integration id from ");
                    sb3.append(jSONArray3.toString());
                    sb3.append(" that wasn't an int");
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DecideUpdts", sb3.toString(), e3);
                }
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("New Decide content has become available. ");
            sb4.append(list.size());
            sb4.append(" notifications and ");
            sb4.append(jSONArray2.length());
            sb4.append(" experiments have been added.");
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DecideUpdts", sb4.toString());
            if (z4 && (onNewResultsListener = this.getErrorConfigVersion) != null) {
                onNewResultsListener.MyBillsEntityDataFactory();
            }
        }
    }

    public final JSONArray BuiltInFictitiousFunctionClassFactory() {
        JSONArray jSONArray;
        synchronized (this) {
            jSONArray = this.initRecordTimeStamp;
        }
        return jSONArray;
    }

    public final InAppNotification MyBillsEntityDataFactory(boolean z) {
        synchronized (this) {
            if (this.getAuthRequestContext.isEmpty()) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DecideUpdts", "No unseen notifications exist, none will be returned.");
                return null;
            }
            InAppNotification remove = this.getAuthRequestContext.remove(0);
            if (z) {
                this.getAuthRequestContext.add(remove);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Recording notification ");
                sb.append(remove);
                sb.append(" as seen.");
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DecideUpdts", sb.toString());
            }
            return remove;
        }
    }

    public final InAppNotification getAuthRequestContext(AnalyticsMessages.EventDescription eventDescription, boolean z) {
        synchronized (this) {
            if (this.MyBillsEntityDataFactory.isEmpty()) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DecideUpdts", "No unseen triggered notifications exist, none will be returned.");
                return null;
            }
            for (int i = 0; i < this.MyBillsEntityDataFactory.size(); i++) {
                InAppNotification inAppNotification = this.MyBillsEntityDataFactory.get(i);
                if (inAppNotification.getAuthRequestContext(eventDescription)) {
                    if (!z) {
                        this.MyBillsEntityDataFactory.remove(i);
                        StringBuilder sb = new StringBuilder();
                        sb.append("recording triggered notification ");
                        sb.append(inAppNotification.PlaceComponentResult());
                        sb.append(" as seen ");
                        sb.append(eventDescription.BuiltInFictitiousFunctionClassFactory);
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DecideUpdts", sb.toString());
                    }
                    return inAppNotification;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("triggered notification ");
                sb2.append(inAppNotification.PlaceComponentResult());
                sb2.append(" does not match event ");
                sb2.append(eventDescription.BuiltInFictitiousFunctionClassFactory);
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DecideUpdts", sb2.toString());
            }
            return null;
        }
    }

    public final Set<String> KClassImpl$Data$declaredNonStaticMembers$2() {
        Set<String> set;
        synchronized (this) {
            set = this.lookAheadTest;
        }
        return set;
    }

    public final boolean getAuthRequestContext() {
        Boolean bool = this.BuiltInFictitiousFunctionClassFactory;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }
}
