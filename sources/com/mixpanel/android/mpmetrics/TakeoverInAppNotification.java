package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.util.JSONUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TakeoverInAppNotification extends InAppNotification {
    public static final Parcelable.Creator<TakeoverInAppNotification> CREATOR = new Parcelable.Creator<TakeoverInAppNotification>() { // from class: com.mixpanel.android.mpmetrics.TakeoverInAppNotification.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TakeoverInAppNotification createFromParcel(Parcel parcel) {
            return new TakeoverInAppNotification(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TakeoverInAppNotification[] newArray(int i) {
            return new TakeoverInAppNotification[i];
        }
    };
    public final int DatabaseTableConfigUtil;
    private final boolean GetContactSyncConfig;
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final int NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final ArrayList<InAppButton> moveToNextValue;

    public TakeoverInAppNotification(Parcel parcel) {
        super(parcel);
        this.moveToNextValue = parcel.createTypedArrayList(InAppButton.CREATOR);
        this.DatabaseTableConfigUtil = parcel.readInt();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = parcel.readInt();
        this.GetContactSyncConfig = parcel.readByte() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TakeoverInAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        super(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("buttons");
            this.moveToNextValue = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.moveToNextValue.add(new InAppButton((JSONObject) jSONArray.get(i)));
            }
            this.DatabaseTableConfigUtil = jSONObject.getInt("close_color");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = JSONUtils.PlaceComponentResult(jSONObject, "title");
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = jSONObject.optInt("title_color");
            this.GetContactSyncConfig = BuiltInFictitiousFunctionClassFactory().getBoolean("image_fade");
        } catch (JSONException e) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e);
        }
    }

    public final boolean scheduleImpl() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1 != null;
    }

    public final boolean lookAheadTest() {
        return this.GetContactSyncConfig;
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.moveToNextValue);
        parcel.writeInt(this.DatabaseTableConfigUtil);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeByte(this.GetContactSyncConfig ? (byte) 1 : (byte) 0);
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    public final InAppNotification.Type getAuthRequestContext() {
        return InAppNotification.Type.TAKEOVER;
    }
}
