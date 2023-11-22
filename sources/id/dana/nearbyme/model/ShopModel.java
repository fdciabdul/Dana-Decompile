package id.dana.nearbyme.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import id.dana.domain.nearbyme.model.MerchantStatusEnum;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.nearbyme.MerchantViewType;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopOpenHourModel;
import id.dana.utils.NumberFormatterUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ShopModel implements Parcelable {
    public static final Parcelable.Creator<ShopModel> CREATOR = new Parcelable.Creator<ShopModel>() { // from class: id.dana.nearbyme.model.ShopModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ShopModel createFromParcel(Parcel parcel) {
            return new ShopModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ShopModel[] newArray(int i) {
            return new ShopModel[i];
        }
    };
    protected static final List<String> PlaceComponentResult = Arrays.asList(Shop.XENDIT_MERCHANT_ID, Shop.XENDIT_QRIS_MERCHANT_ID);
    public int A;
    private List<Integer> AppCompatEmojiTextHelper;
    public String B;
    public String BottomSheetCardBindingView$watcherCardNumberView$1;
    public String BuiltInFictitiousFunctionClassFactory;
    public List<ShopOpenHourModel> C;
    public String D;
    public double DatabaseTableConfigUtil;
    public int E;
    public String FragmentBottomSheetPaymentSettingBinding;
    private boolean G;
    public String GetContactSyncConfig;
    private int I;
    public List<ContactAddressModel> KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public Map<String, String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    public String NetworkUserEntityData$$ExternalSyntheticLambda3;
    public List<MerchantImageModel> NetworkUserEntityData$$ExternalSyntheticLambda4;
    public List<String> NetworkUserEntityData$$ExternalSyntheticLambda5;
    public String NetworkUserEntityData$$ExternalSyntheticLambda6;
    public Map<String, String> NetworkUserEntityData$$ExternalSyntheticLambda7;
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;
    public double PrepareContext;
    public double SubSequence;
    public MerchantStatusEnum VerifyPinStateManager$executeRiskChallenge$2$1;
    public Long VerifyPinStateManager$executeRiskChallenge$2$2;
    public String getAuthRequestContext;
    public List<PromoInfoModel> getCallingPid;
    public double getErrorConfigVersion;
    public List<MerchantSubcategoryModel> getOnBoardingScenario;
    public String getSupportButtonTintMode;
    public boolean getValueOfTouchPositionAbsolute;
    public boolean initRecordTimeStamp;
    public List<String> isLayoutRequested;
    public String lookAheadTest;
    public boolean moveToNextValue;
    public String newProxyInstance;
    public double readMicros;
    public boolean scheduleImpl;
    public int whenAvailable;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ShopModel() {
        this.AppCompatEmojiTextHelper = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.E = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        FragmentBottomSheetPaymentSettingBinding();
        NetworkUserEntityData$$ExternalSyntheticLambda5();
        NetworkUserEntityData$$ExternalSyntheticLambda3();
        NetworkUserEntityData$$ExternalSyntheticLambda6();
    }

    public ShopModel(String str, String str2) {
        this.AppCompatEmojiTextHelper = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.E = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = str;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = str2;
        FragmentBottomSheetPaymentSettingBinding();
        NetworkUserEntityData$$ExternalSyntheticLambda5();
        NetworkUserEntityData$$ExternalSyntheticLambda3();
        NetworkUserEntityData$$ExternalSyntheticLambda6();
    }

    protected ShopModel(Parcel parcel) {
        this.AppCompatEmojiTextHelper = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
        this.E = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        this.MyBillsEntityDataFactory = parcel.readString();
        this.getAuthRequestContext = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.createTypedArrayList(ContactAddressModel.CREATOR);
        this.getErrorConfigVersion = parcel.readDouble();
        this.lookAheadTest = parcel.readString();
        this.DatabaseTableConfigUtil = parcel.readDouble();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = parcel.readString();
        this.PrepareContext = parcel.readDouble();
        this.newProxyInstance = parcel.readString();
        this.isLayoutRequested = parcel.createStringArrayList();
        this.getOnBoardingScenario = parcel.createTypedArrayList(MerchantSubcategoryModel.CREATOR);
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = parcel.readString();
        this.getSupportButtonTintMode = parcel.readString();
        this.B = parcel.readString();
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = parcel.readString();
        this.D = parcel.readString();
        this.I = parcel.readInt();
        this.GetContactSyncConfig = parcel.readString();
        this.getCallingPid = parcel.createTypedArrayList(PromoInfoModel.CREATOR);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = parcel.createStringArrayList();
        this.readMicros = parcel.readDouble();
        this.SubSequence = parcel.readDouble();
        this.moveToNextValue = parcel.readByte() != 0;
        this.G = parcel.readByte() != 0;
        this.C = parcel.createTypedArrayList(ShopOpenHourModel.INSTANCE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = parcel.readString();
        this.FragmentBottomSheetPaymentSettingBinding = parcel.readString();
        this.scheduleImpl = parcel.readByte() != 0;
        FragmentBottomSheetPaymentSettingBinding();
        NetworkUserEntityData$$ExternalSyntheticLambda5();
        NetworkUserEntityData$$ExternalSyntheticLambda3();
        NetworkUserEntityData$$ExternalSyntheticLambda6();
    }

    private void FragmentBottomSheetPaymentSettingBinding() {
        List<Integer> list = this.AppCompatEmojiTextHelper;
        String str = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        list.add(Integer.valueOf(str == null ? 0 : str.hashCode()));
        this.AppCompatEmojiTextHelper.add(Integer.valueOf((int) this.getErrorConfigVersion));
        this.AppCompatEmojiTextHelper.add(Integer.valueOf((int) this.DatabaseTableConfigUtil));
        this.AppCompatEmojiTextHelper.add(Integer.valueOf((int) this.PrepareContext));
        this.AppCompatEmojiTextHelper.add(Integer.valueOf((int) this.readMicros));
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        List<Integer> list = this.AppCompatEmojiTextHelper;
        String str = this.MyBillsEntityDataFactory;
        list.add(Integer.valueOf(str == null ? 0 : str.hashCode()));
        List<Integer> list2 = this.AppCompatEmojiTextHelper;
        String str2 = this.getAuthRequestContext;
        list2.add(Integer.valueOf(str2 == null ? 0 : str2.hashCode()));
        this.AppCompatEmojiTextHelper.add(Integer.valueOf((int) this.SubSequence));
        List<Integer> list3 = this.AppCompatEmojiTextHelper;
        String str3 = this.BuiltInFictitiousFunctionClassFactory;
        list3.add(Integer.valueOf(str3 == null ? 0 : str3.hashCode()));
        List<Integer> list4 = this.AppCompatEmojiTextHelper;
        String str4 = this.lookAheadTest;
        list4.add(Integer.valueOf(str4 == null ? 0 : str4.hashCode()));
        List<Integer> list5 = this.AppCompatEmojiTextHelper;
        Map<String, String> map = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        list5.add(Integer.valueOf(map != null ? map.hashCode() : 0));
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        List<Integer> list = this.AppCompatEmojiTextHelper;
        List<ContactAddressModel> list2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        list.add(Integer.valueOf(list2 == null ? 0 : list2.hashCode()));
        List<Integer> list3 = this.AppCompatEmojiTextHelper;
        String str = this.GetContactSyncConfig;
        list3.add(Integer.valueOf(str == null ? 0 : str.hashCode()));
        List<Integer> list4 = this.AppCompatEmojiTextHelper;
        String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        list4.add(Integer.valueOf(str2 == null ? 0 : str2.hashCode()));
        List<Integer> list5 = this.AppCompatEmojiTextHelper;
        String str3 = this.newProxyInstance;
        list5.add(Integer.valueOf(str3 == null ? 0 : str3.hashCode()));
        List<Integer> list6 = this.AppCompatEmojiTextHelper;
        Map<String, String> map = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        list6.add(Integer.valueOf(map == null ? 0 : map.hashCode()));
        List<Integer> list7 = this.AppCompatEmojiTextHelper;
        List<String> list8 = this.isLayoutRequested;
        list7.add(Integer.valueOf(list8 == null ? 0 : list8.hashCode()));
        List<Integer> list9 = this.AppCompatEmojiTextHelper;
        List<PromoInfoModel> list10 = this.getCallingPid;
        list9.add(Integer.valueOf(list10 == null ? 0 : list10.hashCode()));
        List<Integer> list11 = this.AppCompatEmojiTextHelper;
        List<String> list12 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        list11.add(Integer.valueOf(list12 != null ? list12.hashCode() : 0));
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        List<Integer> list = this.AppCompatEmojiTextHelper;
        String str = this.getSupportButtonTintMode;
        list.add(Integer.valueOf(str == null ? 0 : str.hashCode()));
        List<Integer> list2 = this.AppCompatEmojiTextHelper;
        String str2 = this.B;
        list2.add(Integer.valueOf(str2 == null ? 0 : str2.hashCode()));
        List<Integer> list3 = this.AppCompatEmojiTextHelper;
        MerchantStatusEnum merchantStatusEnum = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        list3.add(Integer.valueOf(merchantStatusEnum == null ? 0 : merchantStatusEnum.hashCode()));
        List<Integer> list4 = this.AppCompatEmojiTextHelper;
        String str3 = this.D;
        list4.add(Integer.valueOf(str3 == null ? 0 : str3.hashCode()));
        List<Integer> list5 = this.AppCompatEmojiTextHelper;
        List<MerchantSubcategoryModel> list6 = this.getOnBoardingScenario;
        list5.add(Integer.valueOf(list6 != null ? list6.hashCode() : 0));
        this.AppCompatEmojiTextHelper.add(Integer.valueOf(this.I));
    }

    public final boolean moveToNextValue() {
        return this.moveToNextValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeTypedList(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeDouble(this.getErrorConfigVersion);
        parcel.writeString(this.lookAheadTest);
        parcel.writeDouble(this.DatabaseTableConfigUtil);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        parcel.writeDouble(this.PrepareContext);
        parcel.writeString(this.newProxyInstance);
        parcel.writeStringList(this.isLayoutRequested);
        parcel.writeTypedList(this.getOnBoardingScenario);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        parcel.writeString(this.getSupportButtonTintMode);
        parcel.writeString(this.B);
        parcel.writeString(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        parcel.writeString(this.D);
        parcel.writeInt(this.I);
        parcel.writeString(this.GetContactSyncConfig);
        parcel.writeTypedList(this.getCallingPid);
        parcel.writeStringList(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        parcel.writeDouble(this.readMicros);
        parcel.writeDouble(this.SubSequence);
        parcel.writeByte(this.moveToNextValue ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.G ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.C);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        parcel.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        parcel.writeByte(this.scheduleImpl ? (byte) 1 : (byte) 0);
    }

    public final boolean PlaceComponentResult() {
        return (!this.NetworkUserEntityData$$ExternalSyntheticLambda1 || PrepareContext() || SubSequence()) ? false : true;
    }

    public final ContactAddressModel BuiltInFictitiousFunctionClassFactory() {
        for (ContactAddressModel contactAddressModel : this.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (contactAddressModel.getErrorConfigVersion != null && contactAddressModel.getErrorConfigVersion.equals("OFFICE_ADD")) {
                return contactAddressModel;
            }
        }
        return new ContactAddressModel();
    }

    public final String getAuthRequestContext(boolean z, String str) {
        List<MerchantSubcategoryModel> list = this.getOnBoardingScenario;
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (MerchantSubcategoryModel merchantSubcategoryModel : this.getOnBoardingScenario) {
            if (merchantSubcategoryModel.KClassImpl$Data$declaredNonStaticMembers$2 != null && !BuiltInFictitiousFunctionClassFactory(merchantSubcategoryModel)) {
                if (z) {
                    return merchantSubcategoryModel.KClassImpl$Data$declaredNonStaticMembers$2;
                }
                if (merchantSubcategoryModel.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    if (sb.length() > 0) {
                        sb.append(str);
                    }
                    sb.append(merchantSubcategoryModel.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
        }
        return sb.toString();
    }

    public final boolean PlaceComponentResult(List<MerchantCategoryModel> list) {
        List<MerchantSubcategoryModel> list2 = this.getOnBoardingScenario;
        if (list2 == null || list2.isEmpty()) {
            return false;
        }
        Iterator<MerchantCategoryModel> it = list.iterator();
        while (it.hasNext()) {
            if (BuiltInFictitiousFunctionClassFactory(it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(MerchantCategoryModel merchantCategoryModel) {
        List<MerchantSubcategoryModel> list = this.getOnBoardingScenario;
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<MerchantSubcategoryModel> it = this.getOnBoardingScenario.iterator();
        while (it.hasNext()) {
            if (it.next().BuiltInFictitiousFunctionClassFactory.contains(merchantCategoryModel.MyBillsEntityDataFactory)) {
                return true;
            }
        }
        return false;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        if (this.FragmentBottomSheetPaymentSettingBinding == null || !getErrorConfigVersion()) {
            return;
        }
        MerchantSubcategoryModel merchantSubcategoryModel = new MerchantSubcategoryModel();
        List<String> list = merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory;
        if (list != null && !list.contains(MerchantViewType.MERCHANT_CAT_DANA_BISNIS)) {
            merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory.add(MerchantViewType.MERCHANT_CAT_DANA_BISNIS);
        }
        if (this.getOnBoardingScenario == null) {
            this.getOnBoardingScenario = new ArrayList();
        }
        this.getOnBoardingScenario.add(merchantSubcategoryModel);
    }

    public final boolean GetContactSyncConfig() {
        return NetworkUserEntityData$$ExternalSyntheticLambda7() && this.getCallingPid.get(0).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final String scheduleImpl() {
        return NetworkUserEntityData$$ExternalSyntheticLambda7() ? this.getCallingPid.get(0).getErrorConfigVersion : "";
    }

    public final void MyBillsEntityDataFactory(List<PromoInfoModel> list) {
        this.G = true;
        this.getCallingPid = list;
        if (list == null || list.isEmpty()) {
            return;
        }
        MerchantSubcategoryModel merchantSubcategoryModel = new MerchantSubcategoryModel();
        List<String> list2 = merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory;
        if (list2 != null && !list2.contains(MerchantViewType.MERCHANT_CAT_PROMO)) {
            merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory.add(MerchantViewType.MERCHANT_CAT_PROMO);
        }
        if (this.getOnBoardingScenario == null) {
            this.getOnBoardingScenario = new ArrayList();
        }
        this.getOnBoardingScenario.add(merchantSubcategoryModel);
    }

    private static String PlaceComponentResult(String str) {
        if (str.endsWith("%")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("%");
        return sb.toString();
    }

    private String whenAvailable() {
        return NetworkUserEntityData$$ExternalSyntheticLambda7() ? this.getCallingPid.get(0).initRecordTimeStamp : "";
    }

    public final boolean initRecordTimeStamp() {
        List<String> list = this.isLayoutRequested;
        return list != null && list.contains("9998");
    }

    public final boolean PrepareContext() {
        return "216620000020928274717".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
    }

    private boolean SubSequence() {
        return "216620000013750392977".equals(this.NetworkUserEntityData$$ExternalSyntheticLambda3) || PlaceComponentResult.contains(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
    }

    public final boolean getErrorConfigVersion() {
        return "UMI".equals(this.FragmentBottomSheetPaymentSettingBinding) || "UME".equals(this.FragmentBottomSheetPaymentSettingBinding) || "UKE".equals(this.FragmentBottomSheetPaymentSettingBinding);
    }

    public final void BuiltInFictitiousFunctionClassFactory(List<ShopOpenHourModel> list) {
        this.C = list;
        if (NetworkUserEntityData$$ExternalSyntheticLambda4() || moveToNextValue()) {
            MerchantSubcategoryModel merchantSubcategoryModel = new MerchantSubcategoryModel();
            List<String> list2 = merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory;
            if (list2 != null && !list2.contains(MerchantViewType.MERCHANT_CAT_OPEN_NOW)) {
                merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory.add(MerchantViewType.MERCHANT_CAT_OPEN_NOW);
            }
            if (this.getOnBoardingScenario == null) {
                this.getOnBoardingScenario = new ArrayList();
            }
            this.getOnBoardingScenario.add(merchantSubcategoryModel);
        }
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda4() {
        List<ShopOpenHourModel> list = this.C;
        return list != null && !list.isEmpty() && this.C.size() > (Calendar.getInstance().get(7) + 5) % 7 && this.C.get((Calendar.getInstance().get(7) + 5) % 7).MyBillsEntityDataFactory() == ShopOpenHourModel.OpenHourType.OPEN;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2() {
        return (Calendar.getInstance().get(7) + 5) % 7;
    }

    public int hashCode() {
        Iterator<Integer> it = this.AppCompatEmojiTextHelper.iterator();
        int i = 7;
        while (it.hasNext()) {
            i *= it.next().intValue() + 31;
        }
        return i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ShopModel) {
            ShopModel shopModel = (ShopModel) obj;
            return shopModel.E == 0 && shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda3) && shopModel.BottomSheetCardBindingView$watcherCardNumberView$1.equals(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        }
        return false;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.initRecordTimeStamp;
    }

    public final String getAuthRequestContext() {
        List<String> list = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        return (list == null || list.isEmpty()) ? "" : this.NetworkUserEntityData$$ExternalSyntheticLambda5.get(0);
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.G;
    }

    public final String MyBillsEntityDataFactory() {
        if (!TextUtils.isEmpty(this.newProxyInstance) && this.newProxyInstance.length() > 15) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.newProxyInstance.substring(0, 15));
            sb.append("...");
            return sb.toString();
        }
        return this.newProxyInstance;
    }

    public final boolean isLayoutRequested() {
        return this.getValueOfTouchPositionAbsolute;
    }

    public final boolean DatabaseTableConfigUtil() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String str) {
        return (TextUtils.isEmpty(this.BottomSheetCardBindingView$watcherCardNumberView$1) || TextUtils.isEmpty(str) || !this.BottomSheetCardBindingView$watcherCardNumberView$1.equals(str)) ? false : true;
    }

    public final boolean lookAheadTest() {
        return this.scheduleImpl;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(MerchantSubcategoryModel merchantSubcategoryModel) {
        return merchantSubcategoryModel.BuiltInFictitiousFunctionClassFactory.contains(MerchantViewType.MERCHANT_CAT_PROMO);
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        String PlaceComponentResult2;
        if (this.getCallingPid.get(0).moveToNextValue != null && !this.getCallingPid.get(0).moveToNextValue.equalsIgnoreCase("PERCENTAGE")) {
            PlaceComponentResult2 = NumberFormatterUtil.MyBillsEntityDataFactory(whenAvailable());
        } else {
            PlaceComponentResult2 = PlaceComponentResult(whenAvailable());
        }
        if (GetContactSyncConfig()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Max ");
            sb.append(PlaceComponentResult2);
            return sb.toString();
        }
        return PlaceComponentResult2;
    }

    public final String PlaceComponentResult(Context context) {
        List<ShopOpenHourModel> list = this.C;
        return (list == null || list.isEmpty()) ? "" : this.C.get((Calendar.getInstance().get(7) + 5) % 7).MyBillsEntityDataFactory(context);
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        List<PromoInfoModel> list = this.getCallingPid;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public final boolean newProxyInstance() {
        try {
            return this.isLayoutRequested.contains("9999");
        } catch (NullPointerException unused) {
            return false;
        }
    }
}
