package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.util.MPLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DisplayTrigger implements Parcelable {
    public static final Parcelable.Creator<DisplayTrigger> CREATOR = new Parcelable.Creator<DisplayTrigger>() { // from class: com.mixpanel.android.mpmetrics.DisplayTrigger.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ DisplayTrigger createFromParcel(Parcel parcel) {
            return new DisplayTrigger(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DisplayTrigger[] newArray(int i) {
            return new DisplayTrigger[i];
        }
    };
    private final String BuiltInFictitiousFunctionClassFactory;
    private final SelectorEvaluator MyBillsEntityDataFactory;
    private final JSONObject getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DisplayTrigger(JSONObject jSONObject) throws BadDecideObjectException {
        try {
            this.BuiltInFictitiousFunctionClassFactory = jSONObject.getString("event");
            JSONObject optJSONObject = jSONObject.optJSONObject("selector");
            this.getAuthRequestContext = optJSONObject;
            this.MyBillsEntityDataFactory = optJSONObject != null ? new SelectorEvaluator(optJSONObject) : null;
        } catch (JSONException e) {
            throw new BadDecideObjectException("Event triggered notification JSON was unexpected or bad", e);
        }
    }

    public DisplayTrigger(Parcel parcel) {
        JSONObject jSONObject;
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DisplayTrigger", "Error parsing selector from display_trigger", e);
            jSONObject = null;
        }
        this.getAuthRequestContext = jSONObject;
        this.MyBillsEntityDataFactory = jSONObject != null ? new SelectorEvaluator(jSONObject) : null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.getAuthRequestContext.toString());
    }

    public final boolean MyBillsEntityDataFactory(AnalyticsMessages.EventDescription eventDescription) {
        if (eventDescription == null || !(this.BuiltInFictitiousFunctionClassFactory.equals("$any_event") || eventDescription.BuiltInFictitiousFunctionClassFactory.equals(this.BuiltInFictitiousFunctionClassFactory))) {
            return false;
        }
        SelectorEvaluator selectorEvaluator = this.MyBillsEntityDataFactory;
        if (selectorEvaluator != null) {
            try {
                return selectorEvaluator.BuiltInFictitiousFunctionClassFactory(eventDescription.MyBillsEntityDataFactory);
            } catch (Exception e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.DisplayTrigger", "Error evaluating selector", e);
                return false;
            }
        }
        return true;
    }
}
