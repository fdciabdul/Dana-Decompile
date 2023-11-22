package io.branch.referral.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.branch.referral.BranchUtil;
import io.branch.referral.Defines;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ContentMetadata implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: io.branch.referral.util.ContentMetadata.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ContentMetadata(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ContentMetadata[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public Double DatabaseTableConfigUtil;
    private final ArrayList<String> FragmentBottomSheetPaymentSettingBinding;
    public Double GetContactSyncConfig;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public final HashMap<String, String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public Double NetworkUserEntityData$$ExternalSyntheticLambda3;
    public String NetworkUserEntityData$$ExternalSyntheticLambda5;
    public String NetworkUserEntityData$$ExternalSyntheticLambda7;
    public Double NetworkUserEntityData$$ExternalSyntheticLambda8;
    public String PlaceComponentResult;
    public Double PrepareContext;
    public String getAuthRequestContext;
    BranchContentSchema getErrorConfigVersion;
    public ProductCategory initRecordTimeStamp;
    public Double isLayoutRequested;
    public CONDITION lookAheadTest;
    public CurrencyType moveToNextValue;
    public Integer newProxyInstance;
    public Double scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ ContentMetadata(Parcel parcel, byte b) {
        this(parcel);
    }

    /* loaded from: classes.dex */
    public enum CONDITION {
        OTHER,
        NEW,
        GOOD,
        FAIR,
        POOR,
        USED,
        REFURBISHED,
        EXCELLENT;

        public static CONDITION getValue(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (CONDITION condition : values()) {
                    if (condition.name().equalsIgnoreCase(str)) {
                        return condition;
                    }
                }
            }
            return null;
        }
    }

    public ContentMetadata() {
        this.FragmentBottomSheetPaymentSettingBinding = new ArrayList<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new HashMap<>();
    }

    public final JSONObject getAuthRequestContext() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.getErrorConfigVersion != null) {
                jSONObject.put(Defines.Jsonkey.ContentSchema.getKey(), this.getErrorConfigVersion.name());
            }
            if (this.PrepareContext != null) {
                jSONObject.put(Defines.Jsonkey.Quantity.getKey(), this.PrepareContext);
            }
            if (this.DatabaseTableConfigUtil != null) {
                jSONObject.put(Defines.Jsonkey.Price.getKey(), this.DatabaseTableConfigUtil);
            }
            if (this.moveToNextValue != null) {
                jSONObject.put(Defines.Jsonkey.PriceCurrency.getKey(), this.moveToNextValue.toString());
            }
            if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda5)) {
                jSONObject.put(Defines.Jsonkey.SKU.getKey(), this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            }
            if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                jSONObject.put(Defines.Jsonkey.ProductName.getKey(), this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
            if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
                jSONObject.put(Defines.Jsonkey.ProductBrand.getKey(), this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
            if (this.initRecordTimeStamp != null) {
                jSONObject.put(Defines.Jsonkey.ProductCategory.getKey(), this.initRecordTimeStamp.getName());
            }
            if (this.lookAheadTest != null) {
                jSONObject.put(Defines.Jsonkey.Condition.getKey(), this.lookAheadTest.name());
            }
            if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
                jSONObject.put(Defines.Jsonkey.ProductVariant.getKey(), this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            }
            if (this.isLayoutRequested != null) {
                jSONObject.put(Defines.Jsonkey.Rating.getKey(), this.isLayoutRequested);
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
                jSONObject.put(Defines.Jsonkey.RatingAverage.getKey(), this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            }
            if (this.newProxyInstance != null) {
                jSONObject.put(Defines.Jsonkey.RatingCount.getKey(), this.newProxyInstance);
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 != null) {
                jSONObject.put(Defines.Jsonkey.RatingMax.getKey(), this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            }
            if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
                jSONObject.put(Defines.Jsonkey.AddressStreet.getKey(), this.PlaceComponentResult);
            }
            if (!TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                jSONObject.put(Defines.Jsonkey.AddressCity.getKey(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (!TextUtils.isEmpty(this.getAuthRequestContext)) {
                jSONObject.put(Defines.Jsonkey.AddressRegion.getKey(), this.getAuthRequestContext);
            }
            if (!TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
                jSONObject.put(Defines.Jsonkey.AddressCountry.getKey(), this.MyBillsEntityDataFactory);
            }
            if (!TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
                jSONObject.put(Defines.Jsonkey.AddressPostalCode.getKey(), this.BuiltInFictitiousFunctionClassFactory);
            }
            if (this.scheduleImpl != null) {
                jSONObject.put(Defines.Jsonkey.Latitude.getKey(), this.scheduleImpl);
            }
            if (this.GetContactSyncConfig != null) {
                jSONObject.put(Defines.Jsonkey.Longitude.getKey(), this.GetContactSyncConfig);
            }
            if (this.FragmentBottomSheetPaymentSettingBinding.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put(Defines.Jsonkey.ImageCaptions.getKey(), jSONArray);
                Iterator<String> it = this.FragmentBottomSheetPaymentSettingBinding.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() > 0) {
                for (String str : this.NetworkUserEntityData$$ExternalSyntheticLambda0.keySet()) {
                    jSONObject.put(str, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(str));
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static ContentMetadata getAuthRequestContext(BranchUtil.JsonReader jsonReader) {
        Integer num;
        ContentMetadata contentMetadata = new ContentMetadata();
        String key = Defines.Jsonkey.ContentSchema.getKey();
        String optString = jsonReader.MyBillsEntityDataFactory.optString(key);
        jsonReader.MyBillsEntityDataFactory.remove(key);
        contentMetadata.getErrorConfigVersion = BranchContentSchema.getValue(optString);
        contentMetadata.PrepareContext = jsonReader.MyBillsEntityDataFactory(Defines.Jsonkey.Quantity.getKey(), null);
        contentMetadata.DatabaseTableConfigUtil = jsonReader.MyBillsEntityDataFactory(Defines.Jsonkey.Price.getKey(), null);
        String key2 = Defines.Jsonkey.PriceCurrency.getKey();
        String optString2 = jsonReader.MyBillsEntityDataFactory.optString(key2);
        jsonReader.MyBillsEntityDataFactory.remove(key2);
        contentMetadata.moveToNextValue = CurrencyType.getValue(optString2);
        String key3 = Defines.Jsonkey.SKU.getKey();
        String optString3 = jsonReader.MyBillsEntityDataFactory.optString(key3);
        jsonReader.MyBillsEntityDataFactory.remove(key3);
        contentMetadata.NetworkUserEntityData$$ExternalSyntheticLambda5 = optString3;
        String key4 = Defines.Jsonkey.ProductName.getKey();
        String optString4 = jsonReader.MyBillsEntityDataFactory.optString(key4);
        jsonReader.MyBillsEntityDataFactory.remove(key4);
        contentMetadata.NetworkUserEntityData$$ExternalSyntheticLambda1 = optString4;
        String key5 = Defines.Jsonkey.ProductBrand.getKey();
        String optString5 = jsonReader.MyBillsEntityDataFactory.optString(key5);
        jsonReader.MyBillsEntityDataFactory.remove(key5);
        contentMetadata.NetworkUserEntityData$$ExternalSyntheticLambda2 = optString5;
        String key6 = Defines.Jsonkey.ProductCategory.getKey();
        String optString6 = jsonReader.MyBillsEntityDataFactory.optString(key6);
        jsonReader.MyBillsEntityDataFactory.remove(key6);
        contentMetadata.initRecordTimeStamp = ProductCategory.getValue(optString6);
        String key7 = Defines.Jsonkey.Condition.getKey();
        String optString7 = jsonReader.MyBillsEntityDataFactory.optString(key7);
        jsonReader.MyBillsEntityDataFactory.remove(key7);
        contentMetadata.lookAheadTest = CONDITION.getValue(optString7);
        String key8 = Defines.Jsonkey.ProductVariant.getKey();
        String optString8 = jsonReader.MyBillsEntityDataFactory.optString(key8);
        jsonReader.MyBillsEntityDataFactory.remove(key8);
        contentMetadata.NetworkUserEntityData$$ExternalSyntheticLambda7 = optString8;
        contentMetadata.isLayoutRequested = jsonReader.MyBillsEntityDataFactory(Defines.Jsonkey.Rating.getKey(), null);
        contentMetadata.NetworkUserEntityData$$ExternalSyntheticLambda8 = jsonReader.MyBillsEntityDataFactory(Defines.Jsonkey.RatingAverage.getKey(), null);
        String key9 = Defines.Jsonkey.RatingCount.getKey();
        if (jsonReader.MyBillsEntityDataFactory.has(key9)) {
            num = Integer.valueOf(jsonReader.MyBillsEntityDataFactory.optInt(key9));
            jsonReader.MyBillsEntityDataFactory.remove(key9);
        } else {
            num = null;
        }
        contentMetadata.newProxyInstance = num;
        contentMetadata.NetworkUserEntityData$$ExternalSyntheticLambda3 = jsonReader.MyBillsEntityDataFactory(Defines.Jsonkey.RatingMax.getKey(), null);
        String key10 = Defines.Jsonkey.AddressStreet.getKey();
        String optString9 = jsonReader.MyBillsEntityDataFactory.optString(key10);
        jsonReader.MyBillsEntityDataFactory.remove(key10);
        contentMetadata.PlaceComponentResult = optString9;
        String key11 = Defines.Jsonkey.AddressCity.getKey();
        String optString10 = jsonReader.MyBillsEntityDataFactory.optString(key11);
        jsonReader.MyBillsEntityDataFactory.remove(key11);
        contentMetadata.KClassImpl$Data$declaredNonStaticMembers$2 = optString10;
        String key12 = Defines.Jsonkey.AddressRegion.getKey();
        String optString11 = jsonReader.MyBillsEntityDataFactory.optString(key12);
        jsonReader.MyBillsEntityDataFactory.remove(key12);
        contentMetadata.getAuthRequestContext = optString11;
        String key13 = Defines.Jsonkey.AddressCountry.getKey();
        String optString12 = jsonReader.MyBillsEntityDataFactory.optString(key13);
        jsonReader.MyBillsEntityDataFactory.remove(key13);
        contentMetadata.MyBillsEntityDataFactory = optString12;
        String key14 = Defines.Jsonkey.AddressPostalCode.getKey();
        String optString13 = jsonReader.MyBillsEntityDataFactory.optString(key14);
        jsonReader.MyBillsEntityDataFactory.remove(key14);
        contentMetadata.BuiltInFictitiousFunctionClassFactory = optString13;
        contentMetadata.scheduleImpl = jsonReader.MyBillsEntityDataFactory(Defines.Jsonkey.Latitude.getKey(), null);
        contentMetadata.GetContactSyncConfig = jsonReader.MyBillsEntityDataFactory(Defines.Jsonkey.Longitude.getKey(), null);
        String key15 = Defines.Jsonkey.ImageCaptions.getKey();
        JSONArray optJSONArray = jsonReader.MyBillsEntityDataFactory.optJSONArray(key15);
        jsonReader.MyBillsEntityDataFactory.remove(key15);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                contentMetadata.FragmentBottomSheetPaymentSettingBinding.add(optJSONArray.optString(i));
            }
        }
        try {
            JSONObject jSONObject = jsonReader.MyBillsEntityDataFactory;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                contentMetadata.NetworkUserEntityData$$ExternalSyntheticLambda0.put(next, jSONObject.optString(next));
            }
        } catch (Exception unused) {
        }
        return contentMetadata;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        BranchContentSchema branchContentSchema = this.getErrorConfigVersion;
        parcel.writeString(branchContentSchema != null ? branchContentSchema.name() : "");
        parcel.writeSerializable(this.PrepareContext);
        parcel.writeSerializable(this.DatabaseTableConfigUtil);
        CurrencyType currencyType = this.moveToNextValue;
        parcel.writeString(currencyType != null ? currencyType.name() : "");
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        ProductCategory productCategory = this.initRecordTimeStamp;
        parcel.writeString(productCategory != null ? productCategory.getName() : "");
        CONDITION condition = this.lookAheadTest;
        parcel.writeString(condition != null ? condition.name() : "");
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        parcel.writeSerializable(this.isLayoutRequested);
        parcel.writeSerializable(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        parcel.writeSerializable(this.newProxyInstance);
        parcel.writeSerializable(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        parcel.writeString(this.PlaceComponentResult);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeSerializable(this.scheduleImpl);
        parcel.writeSerializable(this.GetContactSyncConfig);
        parcel.writeSerializable(this.FragmentBottomSheetPaymentSettingBinding);
        parcel.writeSerializable(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    private ContentMetadata(Parcel parcel) {
        this();
        this.getErrorConfigVersion = BranchContentSchema.getValue(parcel.readString());
        this.PrepareContext = (Double) parcel.readSerializable();
        this.DatabaseTableConfigUtil = (Double) parcel.readSerializable();
        this.moveToNextValue = CurrencyType.getValue(parcel.readString());
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = parcel.readString();
        this.initRecordTimeStamp = ProductCategory.getValue(parcel.readString());
        this.lookAheadTest = CONDITION.getValue(parcel.readString());
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = parcel.readString();
        this.isLayoutRequested = (Double) parcel.readSerializable();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (Double) parcel.readSerializable();
        this.newProxyInstance = (Integer) parcel.readSerializable();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = (Double) parcel.readSerializable();
        this.PlaceComponentResult = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.MyBillsEntityDataFactory = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.scheduleImpl = (Double) parcel.readSerializable();
        this.GetContactSyncConfig = (Double) parcel.readSerializable();
        this.FragmentBottomSheetPaymentSettingBinding.addAll((ArrayList) parcel.readSerializable());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.putAll((HashMap) parcel.readSerializable());
    }
}
