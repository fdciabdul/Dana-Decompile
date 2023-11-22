package io.branch.referral.util;

import android.os.Parcel;
import android.os.Parcelable;
import io.branch.referral.Branch;
import io.branch.referral.PrefHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LinkProperties implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: io.branch.referral.util.LinkProperties.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LinkProperties(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LinkProperties[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public final HashMap<String, String> PlaceComponentResult;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;
    public final ArrayList<String> lookAheadTest;
    public int scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ LinkProperties(Parcel parcel, byte b) {
        this(parcel);
    }

    public LinkProperties() {
        this.lookAheadTest = new ArrayList<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "Share";
        this.PlaceComponentResult = new HashMap<>();
        this.MyBillsEntityDataFactory = "";
        this.getErrorConfigVersion = "";
        this.scheduleImpl = 0;
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.getAuthRequestContext = "";
    }

    public static LinkProperties MyBillsEntityDataFactory() {
        Branch BuiltInFictitiousFunctionClassFactory = Branch.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory != null) {
            PrefHelper prefHelper = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))) != null) {
                PrefHelper prefHelper2 = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
                JSONObject BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params")));
                try {
                    if (BuiltInFictitiousFunctionClassFactory2.has("+clicked_branch_link") && BuiltInFictitiousFunctionClassFactory2.getBoolean("+clicked_branch_link")) {
                        LinkProperties linkProperties = new LinkProperties();
                        try {
                            if (BuiltInFictitiousFunctionClassFactory2.has("~channel")) {
                                linkProperties.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory2.getString("~channel");
                            }
                            if (BuiltInFictitiousFunctionClassFactory2.has("~feature")) {
                                linkProperties.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2.getString("~feature");
                            }
                            if (BuiltInFictitiousFunctionClassFactory2.has("~stage")) {
                                linkProperties.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory2.getString("~stage");
                            }
                            if (BuiltInFictitiousFunctionClassFactory2.has("~campaign")) {
                                linkProperties.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2.getString("~campaign");
                            }
                            if (BuiltInFictitiousFunctionClassFactory2.has("~duration")) {
                                linkProperties.scheduleImpl = BuiltInFictitiousFunctionClassFactory2.getInt("~duration");
                            }
                            if (BuiltInFictitiousFunctionClassFactory2.has("$match_duration")) {
                                linkProperties.scheduleImpl = BuiltInFictitiousFunctionClassFactory2.getInt("$match_duration");
                            }
                            if (BuiltInFictitiousFunctionClassFactory2.has("~tags")) {
                                JSONArray jSONArray = BuiltInFictitiousFunctionClassFactory2.getJSONArray("~tags");
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    linkProperties.lookAheadTest.add(jSONArray.getString(i));
                                }
                            }
                            Iterator<String> keys = BuiltInFictitiousFunctionClassFactory2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                if (next.startsWith("$")) {
                                    linkProperties.PlaceComponentResult.put(next, BuiltInFictitiousFunctionClassFactory2.getString(next));
                                }
                            }
                        } catch (Exception unused) {
                        }
                        return linkProperties;
                    }
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeInt(this.scheduleImpl);
        parcel.writeSerializable(this.lookAheadTest);
        parcel.writeInt(this.PlaceComponentResult.size());
        for (Map.Entry<String, String> entry : this.PlaceComponentResult.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    private LinkProperties(Parcel parcel) {
        this();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.scheduleImpl = parcel.readInt();
        this.lookAheadTest.addAll((ArrayList) parcel.readSerializable());
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.PlaceComponentResult.put(parcel.readString(), parcel.readString());
        }
    }
}
