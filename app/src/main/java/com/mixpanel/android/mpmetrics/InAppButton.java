package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.fullstory.instrumentation.InstrumentInjector;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppButton implements Parcelable {
    public static final Parcelable.Creator<InAppButton> CREATOR = new Parcelable.Creator<InAppButton>() { // from class: com.mixpanel.android.mpmetrics.InAppButton.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ InAppButton createFromParcel(Parcel parcel) {
            return new InAppButton(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppButton[] newArray(int i) {
            return new InAppButton[i];
        }
    };
    public int BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public String PlaceComponentResult;
    public int getAuthRequestContext;
    private JSONObject scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public InAppButton(Parcel parcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException unused) {
            InstrumentInjector.log_e("MixpanelAPI.InAppButton", "Error reading JSON when creating InAppButton from Parcel");
        }
        this.scheduleImpl = jSONObject;
        this.PlaceComponentResult = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readInt();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        this.getAuthRequestContext = parcel.readInt();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InAppButton(JSONObject jSONObject) throws JSONException {
        this.scheduleImpl = jSONObject;
        this.PlaceComponentResult = jSONObject.getString("text");
        this.MyBillsEntityDataFactory = jSONObject.getInt("text_color");
        this.BuiltInFictitiousFunctionClassFactory = jSONObject.getInt("bg_color");
        this.getAuthRequestContext = jSONObject.getInt("border_color");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject.getString("cta_url");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.scheduleImpl.toString());
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeInt(this.MyBillsEntityDataFactory);
        parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeInt(this.getAuthRequestContext);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public String toString() {
        return this.scheduleImpl.toString();
    }
}
