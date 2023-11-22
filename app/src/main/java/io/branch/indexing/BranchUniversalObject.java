package io.branch.indexing;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.BranchUtil;
import io.branch.referral.Defines;
import io.branch.referral.PrefHelper;
import io.branch.referral.ServerRequestActionCompleted;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.ContentMetadata;
import io.branch.referral.util.LinkProperties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BranchUniversalObject implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: io.branch.indexing.BranchUniversalObject.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BranchUniversalObject(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BranchUniversalObject[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public CONTENT_INDEX_MODE KClassImpl$Data$declaredNonStaticMembers$2;
    public CONTENT_INDEX_MODE MyBillsEntityDataFactory;
    private long NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String PlaceComponentResult;
    public String getAuthRequestContext;
    private String getErrorConfigVersion;
    private ContentMetadata initRecordTimeStamp;
    public String lookAheadTest;
    private final ArrayList<String> moveToNextValue;
    private long scheduleImpl;

    /* loaded from: classes.dex */
    public enum CONTENT_INDEX_MODE {
        PUBLIC,
        PRIVATE
    }

    /* loaded from: classes2.dex */
    public interface RegisterViewStatusListener {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ BranchUniversalObject(Parcel parcel, byte b) {
        this(parcel);
    }

    public BranchUniversalObject() {
        this.initRecordTimeStamp = new ContentMetadata();
        this.moveToNextValue = new ArrayList<>();
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.getErrorConfigVersion = "";
        this.lookAheadTest = "";
        this.getAuthRequestContext = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CONTENT_INDEX_MODE.PUBLIC;
        this.MyBillsEntityDataFactory = CONTENT_INDEX_MODE.PUBLIC;
        this.scheduleImpl = 0L;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = System.currentTimeMillis();
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 == CONTENT_INDEX_MODE.PUBLIC;
    }

    public final boolean PlaceComponentResult() {
        return this.MyBillsEntityDataFactory == CONTENT_INDEX_MODE.PUBLIC;
    }

    public static BranchUniversalObject BuiltInFictitiousFunctionClassFactory() {
        Branch BuiltInFictitiousFunctionClassFactory = Branch.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory != null) {
            try {
                PrefHelper prefHelper = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))) != null) {
                    PrefHelper prefHelper2 = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))).has("+clicked_branch_link")) {
                        PrefHelper prefHelper3 = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))).getBoolean("+clicked_branch_link")) {
                            PrefHelper prefHelper4 = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            return PlaceComponentResult(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))));
                        }
                    }
                    JSONObject jSONObject = BuiltInFictitiousFunctionClassFactory.scheduleImpl;
                    if (jSONObject != null && jSONObject.length() > 0) {
                        PrefHelper.MyBillsEntityDataFactory("You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link");
                    }
                    if (BuiltInFictitiousFunctionClassFactory.scheduleImpl != null) {
                        JSONObject jSONObject2 = BuiltInFictitiousFunctionClassFactory.scheduleImpl;
                        if (jSONObject2 != null && jSONObject2.length() > 0) {
                            PrefHelper.MyBillsEntityDataFactory("You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link");
                        }
                        if (BuiltInFictitiousFunctionClassFactory.scheduleImpl.length() > 0) {
                            PrefHelper prefHelper5 = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            return PlaceComponentResult(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))));
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private static BranchUniversalObject PlaceComponentResult(JSONObject jSONObject) {
        JSONArray jSONArray = null;
        try {
            BranchUniversalObject branchUniversalObject = new BranchUniversalObject();
            try {
                BranchUtil.JsonReader jsonReader = new BranchUtil.JsonReader(jSONObject);
                String key = Defines.Jsonkey.ContentTitle.getKey();
                String optString = jsonReader.MyBillsEntityDataFactory.optString(key);
                jsonReader.MyBillsEntityDataFactory.remove(key);
                branchUniversalObject.lookAheadTest = optString;
                String key2 = Defines.Jsonkey.CanonicalIdentifier.getKey();
                String optString2 = jsonReader.MyBillsEntityDataFactory.optString(key2);
                jsonReader.MyBillsEntityDataFactory.remove(key2);
                branchUniversalObject.BuiltInFictitiousFunctionClassFactory = optString2;
                String key3 = Defines.Jsonkey.CanonicalUrl.getKey();
                String optString3 = jsonReader.MyBillsEntityDataFactory.optString(key3);
                jsonReader.MyBillsEntityDataFactory.remove(key3);
                branchUniversalObject.getErrorConfigVersion = optString3;
                String key4 = Defines.Jsonkey.ContentDesc.getKey();
                String optString4 = jsonReader.MyBillsEntityDataFactory.optString(key4);
                jsonReader.MyBillsEntityDataFactory.remove(key4);
                branchUniversalObject.getAuthRequestContext = optString4;
                String key5 = Defines.Jsonkey.ContentImgUrl.getKey();
                String optString5 = jsonReader.MyBillsEntityDataFactory.optString(key5);
                jsonReader.MyBillsEntityDataFactory.remove(key5);
                branchUniversalObject.PlaceComponentResult = optString5;
                String key6 = Defines.Jsonkey.ContentExpiryTime.getKey();
                long optLong = jsonReader.MyBillsEntityDataFactory.optLong(key6);
                jsonReader.MyBillsEntityDataFactory.remove(key6);
                branchUniversalObject.scheduleImpl = optLong;
                String key7 = Defines.Jsonkey.ContentKeyWords.getKey();
                Object opt = jsonReader.MyBillsEntityDataFactory.opt(key7);
                jsonReader.MyBillsEntityDataFactory.remove(key7);
                if (opt instanceof JSONArray) {
                    jSONArray = (JSONArray) opt;
                } else if (opt instanceof String) {
                    jSONArray = new JSONArray((String) opt);
                }
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        branchUniversalObject.moveToNextValue.add((String) jSONArray.get(i));
                    }
                }
                String key8 = Defines.Jsonkey.PublicallyIndexable.getKey();
                Object opt2 = jsonReader.MyBillsEntityDataFactory.opt(key8);
                jsonReader.MyBillsEntityDataFactory.remove(key8);
                if (opt2 instanceof Boolean) {
                    branchUniversalObject.KClassImpl$Data$declaredNonStaticMembers$2 = ((Boolean) opt2).booleanValue() ? CONTENT_INDEX_MODE.PUBLIC : CONTENT_INDEX_MODE.PRIVATE;
                } else if (opt2 instanceof Integer) {
                    branchUniversalObject.KClassImpl$Data$declaredNonStaticMembers$2 = ((Integer) opt2).intValue() == 1 ? CONTENT_INDEX_MODE.PUBLIC : CONTENT_INDEX_MODE.PRIVATE;
                }
                branchUniversalObject.MyBillsEntityDataFactory = jsonReader.getAuthRequestContext(Defines.Jsonkey.LocallyIndexable.getKey()) ? CONTENT_INDEX_MODE.PUBLIC : CONTENT_INDEX_MODE.PRIVATE;
                String key9 = Defines.Jsonkey.CreationTimestamp.getKey();
                long optLong2 = jsonReader.MyBillsEntityDataFactory.optLong(key9);
                jsonReader.MyBillsEntityDataFactory.remove(key9);
                branchUniversalObject.NetworkUserEntityData$$ExternalSyntheticLambda0 = optLong2;
                branchUniversalObject.initRecordTimeStamp = ContentMetadata.getAuthRequestContext(jsonReader);
                JSONObject jSONObject2 = jsonReader.MyBillsEntityDataFactory;
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    branchUniversalObject.initRecordTimeStamp.NetworkUserEntityData$$ExternalSyntheticLambda0.put(next, jSONObject2.optString(next));
                }
            } catch (Exception unused) {
            }
            return branchUniversalObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    public final JSONObject getAuthRequestContext() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject authRequestContext = this.initRecordTimeStamp.getAuthRequestContext();
            Iterator<String> keys = authRequestContext.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, authRequestContext.get(next));
            }
            if (!TextUtils.isEmpty(this.lookAheadTest)) {
                jSONObject.put(Defines.Jsonkey.ContentTitle.getKey(), this.lookAheadTest);
            }
            if (!TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
                jSONObject.put(Defines.Jsonkey.CanonicalIdentifier.getKey(), this.BuiltInFictitiousFunctionClassFactory);
            }
            if (!TextUtils.isEmpty(this.getErrorConfigVersion)) {
                jSONObject.put(Defines.Jsonkey.CanonicalUrl.getKey(), this.getErrorConfigVersion);
            }
            if (this.moveToNextValue.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.moveToNextValue.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put(Defines.Jsonkey.ContentKeyWords.getKey(), jSONArray);
            }
            if (!TextUtils.isEmpty(this.getAuthRequestContext)) {
                jSONObject.put(Defines.Jsonkey.ContentDesc.getKey(), this.getAuthRequestContext);
            }
            if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                jSONObject.put(Defines.Jsonkey.ContentImgUrl.getKey(), this.PlaceComponentResult);
            }
            if (this.scheduleImpl > 0) {
                jSONObject.put(Defines.Jsonkey.ContentExpiryTime.getKey(), this.scheduleImpl);
            }
            jSONObject.put(Defines.Jsonkey.PublicallyIndexable.getKey(), KClassImpl$Data$declaredNonStaticMembers$2());
            jSONObject.put(Defines.Jsonkey.LocallyIndexable.getKey(), PlaceComponentResult());
            jSONObject.put(Defines.Jsonkey.CreationTimestamp.getKey(), this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeLong(this.scheduleImpl);
        parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2.ordinal());
        parcel.writeSerializable(this.moveToNextValue);
        parcel.writeParcelable(this.initRecordTimeStamp, i);
        parcel.writeInt(this.MyBillsEntityDataFactory.ordinal());
    }

    private BranchUniversalObject(Parcel parcel) {
        this();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readLong();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.lookAheadTest = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.PlaceComponentResult = parcel.readString();
        this.scheduleImpl = parcel.readLong();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CONTENT_INDEX_MODE.values()[parcel.readInt()];
        ArrayList arrayList = (ArrayList) parcel.readSerializable();
        if (arrayList != null) {
            this.moveToNextValue.addAll(arrayList);
        }
        this.initRecordTimeStamp = (ContentMetadata) parcel.readParcelable(ContentMetadata.class.getClassLoader());
        this.MyBillsEntityDataFactory = CONTENT_INDEX_MODE.values()[parcel.readInt()];
    }

    /* loaded from: classes2.dex */
    class LinkShareListenerWrapper implements Branch.BranchLinkShareListener {
        private final LinkProperties BuiltInFictitiousFunctionClassFactory;
        private final Branch.ShareLinkBuilder KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ BranchUniversalObject MyBillsEntityDataFactory;
        private final Branch.BranchLinkShareListener PlaceComponentResult;

        @Override // io.branch.referral.Branch.BranchLinkShareListener
        public final void MyBillsEntityDataFactory(String str, String str2, BranchError branchError) {
            HashMap hashMap = new HashMap();
            if (branchError == null) {
                hashMap.put(Defines.Jsonkey.SharedLink.getKey(), str);
            } else {
                hashMap.put(Defines.Jsonkey.ShareError.getKey(), branchError.BuiltInFictitiousFunctionClassFactory);
            }
            BranchUniversalObject branchUniversalObject = this.MyBillsEntityDataFactory;
            String name = BRANCH_STANDARD_EVENT.SHARE.getName();
            JSONObject jSONObject = new JSONObject();
            try {
                new JSONArray().put(branchUniversalObject.BuiltInFictitiousFunctionClassFactory);
                jSONObject.put(branchUniversalObject.BuiltInFictitiousFunctionClassFactory, branchUniversalObject.getAuthRequestContext());
                for (String str3 : hashMap.keySet()) {
                    jSONObject.put(str3, hashMap.get(str3));
                }
                if (Branch.BuiltInFictitiousFunctionClassFactory() != null) {
                    Branch BuiltInFictitiousFunctionClassFactory = Branch.BuiltInFictitiousFunctionClassFactory();
                    ServerRequestActionCompleted serverRequestActionCompleted = new ServerRequestActionCompleted(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, name, jSONObject);
                    if (!serverRequestActionCompleted.MyBillsEntityDataFactory && !serverRequestActionCompleted.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult)) {
                        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(serverRequestActionCompleted);
                    }
                }
            } catch (JSONException unused) {
            }
            Branch.BranchLinkShareListener branchLinkShareListener = this.PlaceComponentResult;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.MyBillsEntityDataFactory(str, str2, branchError);
            }
        }

        @Override // io.branch.referral.Branch.BranchLinkShareListener
        public final void BuiltInFictitiousFunctionClassFactory(String str) {
            Branch.BranchLinkShareListener branchLinkShareListener = this.PlaceComponentResult;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.BuiltInFictitiousFunctionClassFactory(str);
            }
            Branch.BranchLinkShareListener branchLinkShareListener2 = this.PlaceComponentResult;
            if ((branchLinkShareListener2 instanceof Branch.ExtendedBranchLinkShareListener) && ((Branch.ExtendedBranchLinkShareListener) branchLinkShareListener2).BuiltInFictitiousFunctionClassFactory()) {
                Branch.ShareLinkBuilder shareLinkBuilder = this.KClassImpl$Data$declaredNonStaticMembers$2;
                shareLinkBuilder.moveToNextValue = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(shareLinkBuilder.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    public final BranchShortLinkBuilder KClassImpl$Data$declaredNonStaticMembers$2(BranchShortLinkBuilder branchShortLinkBuilder, LinkProperties linkProperties) {
        if (linkProperties.lookAheadTest != null) {
            branchShortLinkBuilder.getAuthRequestContext(linkProperties.lookAheadTest);
        }
        if (linkProperties.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            branchShortLinkBuilder.getAuthRequestContext(linkProperties.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (linkProperties.MyBillsEntityDataFactory != null) {
            branchShortLinkBuilder.MyBillsEntityDataFactory(linkProperties.MyBillsEntityDataFactory);
        }
        if (linkProperties.BuiltInFictitiousFunctionClassFactory != null) {
            branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(linkProperties.BuiltInFictitiousFunctionClassFactory);
        }
        if (linkProperties.getErrorConfigVersion != null) {
            branchShortLinkBuilder.PlaceComponentResult(linkProperties.getErrorConfigVersion);
        }
        if (linkProperties.getAuthRequestContext != null) {
            branchShortLinkBuilder.BuiltInFictitiousFunctionClassFactory(linkProperties.getAuthRequestContext);
        }
        if (linkProperties.scheduleImpl > 0) {
            branchShortLinkBuilder.MyBillsEntityDataFactory(linkProperties.scheduleImpl);
        }
        if (!TextUtils.isEmpty(this.lookAheadTest)) {
            branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(Defines.Jsonkey.ContentTitle.getKey(), this.lookAheadTest);
        }
        if (!TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
            branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(Defines.Jsonkey.CanonicalIdentifier.getKey(), this.BuiltInFictitiousFunctionClassFactory);
        }
        if (!TextUtils.isEmpty(this.getErrorConfigVersion)) {
            branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(Defines.Jsonkey.CanonicalUrl.getKey(), this.getErrorConfigVersion);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.moveToNextValue.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        if (jSONArray.length() > 0) {
            branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(Defines.Jsonkey.ContentKeyWords.getKey(), jSONArray);
        }
        if (!TextUtils.isEmpty(this.getAuthRequestContext)) {
            branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(Defines.Jsonkey.ContentDesc.getKey(), this.getAuthRequestContext);
        }
        if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
            branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(Defines.Jsonkey.ContentImgUrl.getKey(), this.PlaceComponentResult);
        }
        if (this.scheduleImpl > 0) {
            String key = Defines.Jsonkey.ContentExpiryTime.getKey();
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheduleImpl);
            branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(key, sb.toString());
        }
        String key2 = Defines.Jsonkey.PublicallyIndexable.getKey();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(KClassImpl$Data$declaredNonStaticMembers$2());
        branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(key2, sb2.toString());
        JSONObject authRequestContext = this.initRecordTimeStamp.getAuthRequestContext();
        try {
            Iterator<String> keys = authRequestContext.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(next, authRequestContext.get(next));
            }
        } catch (JSONException unused) {
        }
        HashMap<String, String> hashMap = linkProperties.PlaceComponentResult;
        for (String str : hashMap.keySet()) {
            branchShortLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2(str, hashMap.get(str));
        }
        return branchShortLinkBuilder;
    }
}
