package id.dana.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import id.dana.R;
import id.dana.data.constant.DanaUrl;
import id.dana.data.util.NumberUtils;
import id.dana.sendmoney.paymethod.PaymentIconFactory;
import id.dana.utils.LocaleUtil;
import id.dana.utils.NumberFormatterUtil;
import id.dana.utils.TextUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* loaded from: classes5.dex */
public class PayMethodModel implements Parcelable {
    public static final Parcelable.Creator<PayMethodModel> CREATOR = new Parcelable.Creator<PayMethodModel>() { // from class: id.dana.model.PayMethodModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayMethodModel createFromParcel(Parcel parcel) {
            return new PayMethodModel(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayMethodModel[] newArray(int i) {
            return new PayMethodModel[i];
        }
    };
    public CurrencyAmountModel BuiltInFictitiousFunctionClassFactory;
    public CurrencyAmountModel DatabaseTableConfigUtil;
    private boolean FragmentBottomSheetPaymentSettingBinding;
    public CurrencyAmountModel GetContactSyncConfig;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    public long NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public String NetworkUserEntityData$$ExternalSyntheticLambda7;
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;
    public CurrencyAmountModel PlaceComponentResult;
    public boolean PrepareContext;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;
    public String initRecordTimeStamp;
    public String isLayoutRequested;
    public String lookAheadTest;
    public String moveToNextValue;
    public String newProxyInstance;
    public long scheduleImpl;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface CashierSectionTitle {
        public static final String BALANCE = "DANA Balance";
        public static final String BALANCE_FAMILY = "Family Account";
        public static final String BANK_CARD = "Debit/Credit Card";
        public static final String CREDIT_CARD = "Credit Card";
        public static final String DANA_CICIL = "DANA CICIL";
        public static final String DANA_PLUS = "DANA Plus Balance";
        public static final String DEBIT_CARD = "Debit Card";
        public static final String ONLINE_CREDIT = "PayLater";
        public static final String VIRTUAL_ACCOUNT = "Virtual Account";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SectionTitle {
        public static final String ADD_CARD = "ADD CARD";
        public static final String BALANCE = "BALANCE";
        public static final String DEBIT_CARD = "DEBIT CARD";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ViewType {
        public static final int ADD_CARD = 0;
        public static final int ADD_ONEKLIK = 7;
        public static final int DANA_CARD = 1;
        public static final int DEBIT_CARD = 2;
        public static final int DIRECT_DEBIT = 3;
        public static final int ONE_CLICK = 4;
        public static final int OTHER_CARD = 5;
        public static final int SECTION = 6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ PayMethodModel(Parcel parcel, byte b) {
        this(parcel);
    }

    public PayMethodModel() {
    }

    private PayMethodModel(Parcel parcel) {
        this.PlaceComponentResult = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.getAuthRequestContext = parcel.readString();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readString();
        this.MyBillsEntityDataFactory = ((Boolean) parcel.readValue(Boolean.class.getClassLoader())).booleanValue();
        this.lookAheadTest = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = parcel.readString();
        this.initRecordTimeStamp = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = parcel.readString();
        this.newProxyInstance = parcel.readString();
        this.DatabaseTableConfigUtil = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.GetContactSyncConfig = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.BuiltInFictitiousFunctionClassFactory = (CurrencyAmountModel) parcel.readParcelable(CurrencyAmountModel.class.getClassLoader());
        this.moveToNextValue = parcel.readString();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = parcel.readString();
        this.getErrorConfigVersion = parcel.readString();
        this.scheduleImpl = parcel.readLong();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = parcel.readLong();
        this.isLayoutRequested = parcel.readString();
    }

    public final boolean lookAheadTest() {
        return this.PrepareContext;
    }

    public final String PlaceComponentResult() {
        if (TextUtils.isEmpty(this.lookAheadTest)) {
            return null;
        }
        return String.format(DanaUrl.BANK_ICON_URL, this.lookAheadTest.toLowerCase());
    }

    public final boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }

    public final String getAuthRequestContext(Context context) {
        if (scheduleImpl()) {
            Locale authRequestContext = LocaleUtil.getAuthRequestContext();
            CurrencyAmountModel currencyAmountModel = this.PlaceComponentResult;
            return NumberFormatterUtil.MyBillsEntityDataFactory(authRequestContext, Integer.parseInt(NumberUtils.getCleanDot(currencyAmountModel != null ? currencyAmountModel.MyBillsEntityDataFactory : "")), "Rp");
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            return context.getString(R.string.add_and_use_this_card);
        } else {
            if (this.FragmentBottomSheetPaymentSettingBinding) {
                return TextUtil.getErrorConfigVersion(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
            return TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda2) ? "" : TextUtil.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        String errorConfigVersion;
        String str;
        Object[] objArr = new Object[3];
        objArr[0] = BuiltInFictitiousFunctionClassFactory(context);
        String str2 = "";
        if (scheduleImpl()) {
            Locale authRequestContext = LocaleUtil.getAuthRequestContext();
            CurrencyAmountModel currencyAmountModel = this.PlaceComponentResult;
            errorConfigVersion = NumberFormatterUtil.MyBillsEntityDataFactory(authRequestContext, Integer.parseInt(NumberUtils.getCleanDot(currencyAmountModel == null ? "" : currencyAmountModel.MyBillsEntityDataFactory)), "Rp");
        } else {
            errorConfigVersion = (!this.FragmentBottomSheetPaymentSettingBinding || (str = this.NetworkUserEntityData$$ExternalSyntheticLambda2) == null) ? "" : TextUtil.getErrorConfigVersion(str);
        }
        objArr[1] = errorConfigVersion;
        if (GetContactSyncConfig()) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(context.getString(R.string.debit_card));
            sb.append(")");
            str2 = sb.toString();
        } else if (!NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            if (moveToNextValue()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("(");
                sb2.append(context.getString(R.string.express_pay));
                sb2.append(")");
                str2 = sb2.toString();
            } else if (getErrorConfigVersion()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("(");
                sb3.append(context.getString(R.string.oneklik));
                sb3.append(")");
                str2 = sb3.toString();
            }
        }
        objArr[2] = str2;
        return String.format("%s %s %s", objArr);
    }

    public final boolean scheduleImpl() {
        return "BALANCE".equals(this.newProxyInstance);
    }

    public final int MyBillsEntityDataFactory() {
        if (scheduleImpl()) {
            return R.drawable.ic_dana_balance_border;
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            return this.FragmentBottomSheetPaymentSettingBinding ? R.drawable.ic_add_card : R.drawable.ic_add_debit_card;
        }
        return PaymentIconFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.lookAheadTest);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.PlaceComponentResult, i);
        parcel.writeString(this.getAuthRequestContext);
        parcel.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeValue(Boolean.valueOf(this.MyBillsEntityDataFactory));
        parcel.writeString(this.lookAheadTest);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        parcel.writeString(this.initRecordTimeStamp);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        parcel.writeString(this.newProxyInstance);
        parcel.writeParcelable(this.DatabaseTableConfigUtil, i);
        parcel.writeParcelable(this.GetContactSyncConfig, i);
        parcel.writeParcelable(this.BuiltInFictitiousFunctionClassFactory, i);
        parcel.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        parcel.writeString(this.getErrorConfigVersion);
        parcel.writeLong(this.scheduleImpl);
        parcel.writeLong(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        parcel.writeString(this.isLayoutRequested);
    }

    public final String PlaceComponentResult(Context context) {
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            return lookAheadTest(context);
        }
        if ((!GetContactSyncConfig() && !moveToNextValue() && !getErrorConfigVersion()) || TextUtils.isEmpty(this.lookAheadTest)) {
            if (scheduleImpl()) {
                return context.getString(R.string.dana_balance);
            }
            String string = context.getString(R.string.debit_card);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = string;
            return string;
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public final String BuiltInFictitiousFunctionClassFactory(Context context) {
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            return lookAheadTest(context);
        }
        if ((GetContactSyncConfig() || moveToNextValue() || getErrorConfigVersion()) && !TextUtils.isEmpty(this.lookAheadTest)) {
            return !TextUtils.isEmpty(this.getErrorConfigVersion) ? this.getErrorConfigVersion : "";
        } else if (scheduleImpl()) {
            return context.getString(R.string.dana_balance);
        } else {
            String string = context.getString(R.string.debit_card);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = string;
            return string;
        }
    }

    private String lookAheadTest(Context context) {
        if (TextUtils.isEmpty(this.lookAheadTest)) {
            return "";
        }
        String string = context.getString(R.string.add_new_card_format);
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(this.getErrorConfigVersion) ? "" : this.getErrorConfigVersion;
        return String.format(string, objArr);
    }

    private boolean GetContactSyncConfig() {
        return "DEBIT_CARD".equals(this.newProxyInstance);
    }

    public final boolean moveToNextValue() {
        return "DIRECT_DEBIT_DEBIT_CARD".equals(this.newProxyInstance) || "DIRECT_DEBIT_CREDIT_CARD".equals(this.newProxyInstance);
    }

    public final boolean getErrorConfigVersion() {
        return "NET_BANKING".equals(this.newProxyInstance);
    }

    public final String MyBillsEntityDataFactory(Context context) {
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            return context.getString(R.string.add_and_use_this_card);
        }
        if (TextUtils.isEmpty(TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda2) ? "" : TextUtil.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) || scheduleImpl()) {
            return KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return TextUtil.BuiltInFictitiousFunctionClassFactory(TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda2) ? "" : TextUtil.BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        StringBuilder sb = new StringBuilder();
        CurrencyAmountModel currencyAmountModel = this.PlaceComponentResult;
        sb.append(currencyAmountModel == null ? "" : currencyAmountModel.BuiltInFictitiousFunctionClassFactory);
        CurrencyAmountModel currencyAmountModel2 = this.PlaceComponentResult;
        sb.append(currencyAmountModel2 != null ? currencyAmountModel2.MyBillsEntityDataFactory : "");
        return sb.toString();
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        if (scheduleImpl()) {
            return 1;
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            return 0;
        }
        if (initRecordTimeStamp()) {
            return 7;
        }
        if (GetContactSyncConfig()) {
            return 2;
        }
        if (moveToNextValue()) {
            return 3;
        }
        if (getErrorConfigVersion()) {
            return 4;
        }
        return NetworkUserEntityData$$ExternalSyntheticLambda1() ? 6 : 5;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null;
    }

    public final boolean DatabaseTableConfigUtil() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    private boolean initRecordTimeStamp() {
        return "ADD_ONEKLIK_CARD".equalsIgnoreCase(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return "ADD_CARD".equalsIgnoreCase(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
