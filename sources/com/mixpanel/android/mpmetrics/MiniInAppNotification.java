package com.mixpanel.android.mpmetrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MiniInAppNotification extends InAppNotification {
    public static final Parcelable.Creator<MiniInAppNotification> CREATOR = new Parcelable.Creator<MiniInAppNotification>() { // from class: com.mixpanel.android.mpmetrics.MiniInAppNotification.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ MiniInAppNotification createFromParcel(Parcel parcel) {
            return new MiniInAppNotification(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MiniInAppNotification[] newArray(int i) {
            return new MiniInAppNotification[i];
        }
    };
    final String GetContactSyncConfig;
    final int NetworkUserEntityData$$ExternalSyntheticLambda1;
    final int moveToNextValue;

    public MiniInAppNotification(Parcel parcel) {
        super(parcel);
        this.GetContactSyncConfig = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readInt();
        this.moveToNextValue = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniInAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        super(jSONObject);
        try {
            this.GetContactSyncConfig = JSONUtils.PlaceComponentResult(jSONObject, "cta_url");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = jSONObject.getInt("image_tint_color");
            this.moveToNextValue = jSONObject.getInt("border_color");
        } catch (JSONException e) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e);
        }
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.GetContactSyncConfig);
        parcel.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeInt(this.moveToNextValue);
    }

    @Override // com.mixpanel.android.mpmetrics.InAppNotification
    public final InAppNotification.Type getAuthRequestContext() {
        return InAppNotification.Type.MINI;
    }
}
