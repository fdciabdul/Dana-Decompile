package com.mixpanel.android.mpmetrics;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.messaging.Constants;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class InAppNotification implements Parcelable {
    private static final Pattern moveToNextValue = Pattern.compile("(\\.[^./]+$)");
    public final String BuiltInFictitiousFunctionClassFactory;
    private final List<DisplayTrigger> GetContactSyncConfig;
    protected final JSONObject KClassImpl$Data$declaredNonStaticMembers$2;
    protected final JSONObject MyBillsEntityDataFactory;
    final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final int PlaceComponentResult;
    public final int getAuthRequestContext;
    public Bitmap getErrorConfigVersion;
    protected final int lookAheadTest;
    protected final int scheduleImpl;

    /* loaded from: classes.dex */
    public enum Type {
        UNKNOWN { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.1
            @Override // java.lang.Enum
            public final String toString() {
                return "*unknown_type*";
            }
        },
        MINI { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.2
            @Override // java.lang.Enum
            public final String toString() {
                return "mini";
            }
        },
        TAKEOVER { // from class: com.mixpanel.android.mpmetrics.InAppNotification.Type.3
            @Override // java.lang.Enum
            public final String toString() {
                return "takeover";
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract Type getAuthRequestContext();

    public InAppNotification() {
        this.MyBillsEntityDataFactory = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.lookAheadTest = 0;
        this.scheduleImpl = 0;
        this.PlaceComponentResult = 0;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.GetContactSyncConfig = null;
    }

    public InAppNotification(Parcel parcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject = new JSONObject(parcel.readString());
        } catch (JSONException unused) {
        }
        try {
            jSONObject3 = new JSONObject(parcel.readString());
        } catch (JSONException unused2) {
            jSONObject2 = jSONObject;
            MPLog.getAuthRequestContext("MixpanelAPI.InAppNotif", "Error reading JSON when creating InAppNotification from Parcel");
            jSONObject = jSONObject2;
            this.MyBillsEntityDataFactory = jSONObject;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject3;
            this.lookAheadTest = parcel.readInt();
            this.scheduleImpl = parcel.readInt();
            this.PlaceComponentResult = parcel.readInt();
            this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
            this.getAuthRequestContext = parcel.readInt();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
            this.getErrorConfigVersion = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
            ArrayList arrayList = new ArrayList();
            this.GetContactSyncConfig = arrayList;
            parcel.readList(arrayList, null);
        }
        this.MyBillsEntityDataFactory = jSONObject;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject3;
        this.lookAheadTest = parcel.readInt();
        this.scheduleImpl = parcel.readInt();
        this.PlaceComponentResult = parcel.readInt();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.getAuthRequestContext = parcel.readInt();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readString();
        this.getErrorConfigVersion = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        this.GetContactSyncConfig = arrayList2;
        parcel.readList(arrayList2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InAppNotification(JSONObject jSONObject) throws BadDecideObjectException {
        this.GetContactSyncConfig = new ArrayList();
        try {
            this.MyBillsEntityDataFactory = jSONObject;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject.getJSONObject("extras");
            this.lookAheadTest = jSONObject.getInt("id");
            this.scheduleImpl = jSONObject.getInt(Constants.MessagePayloadKeys.MSGID_SERVER);
            this.PlaceComponentResult = jSONObject.getInt("bg_color");
            this.BuiltInFictitiousFunctionClassFactory = JSONUtils.PlaceComponentResult(jSONObject, "body");
            this.getAuthRequestContext = jSONObject.optInt("body_color");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = jSONObject.getString("image_url");
            this.getErrorConfigVersion = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
            JSONArray optJSONArray = jSONObject.optJSONArray("display_triggers");
            int i = 0;
            while (optJSONArray != null) {
                if (i >= optJSONArray.length()) {
                    return;
                }
                this.GetContactSyncConfig.add(new DisplayTrigger(optJSONArray.getJSONObject(i)));
                i++;
            }
        } catch (JSONException e) {
            throw new BadDecideObjectException("Notification JSON was unexpected or bad", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject MyBillsEntityDataFactory() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("campaign_id", this.lookAheadTest);
            jSONObject.put(Constants.MessagePayloadKeys.MSGID_SERVER, this.scheduleImpl);
            jSONObject.put(Constants.MessagePayloadKeys.MESSAGE_TYPE, "inapp");
            jSONObject.put("message_subtype", getAuthRequestContext().toString());
        } catch (JSONException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.InAppNotif", "Impossible JSON Exception", e);
        }
        return jSONObject;
    }

    public final int PlaceComponentResult() {
        return this.lookAheadTest;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory != null;
    }

    public final boolean moveToNextValue() {
        List<DisplayTrigger> list = this.GetContactSyncConfig;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public final boolean getAuthRequestContext(AnalyticsMessages.EventDescription eventDescription) {
        if (moveToNextValue()) {
            Iterator<DisplayTrigger> it = this.GetContactSyncConfig.iterator();
            while (it.hasNext()) {
                if (it.next().MyBillsEntityDataFactory(eventDescription)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAuthRequestContext(String str, String str2) {
        Matcher matcher = moveToNextValue.matcher(str);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("$1");
            return matcher.replaceFirst(sb.toString());
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JSONObject BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.MyBillsEntityDataFactory.toString());
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2.toString());
        parcel.writeInt(this.lookAheadTest);
        parcel.writeInt(this.scheduleImpl);
        parcel.writeInt(this.PlaceComponentResult);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeInt(this.getAuthRequestContext);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeParcelable(this.getErrorConfigVersion, i);
        parcel.writeList(this.GetContactSyncConfig);
    }

    public String toString() {
        return this.MyBillsEntityDataFactory.toString();
    }
}
