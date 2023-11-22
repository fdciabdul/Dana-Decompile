package id.dana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.data.util.NumberUtils;
import id.dana.domain.user.CurrencyAmount;
import id.dana.utils.foundation.logger.log.DanaLog;

/* loaded from: classes5.dex */
public class CurrencyAmountModel implements Parcelable {
    public static final Parcelable.Creator<CurrencyAmountModel> CREATOR = new Parcelable.Creator<CurrencyAmountModel>() { // from class: id.dana.model.CurrencyAmountModel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ CurrencyAmountModel createFromParcel(Parcel parcel) {
            return new CurrencyAmountModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CurrencyAmountModel[] newArray(int i) {
            return new CurrencyAmountModel[i];
        }
    };
    public String BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;
    private boolean getAuthRequestContext;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected CurrencyAmountModel(Parcel parcel) {
        this.MyBillsEntityDataFactory = parcel.readString();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readString();
    }

    public CurrencyAmountModel(String str, String str2) {
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
    }

    public CurrencyAmountModel(String str, String str2, boolean z) {
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.getAuthRequestContext = z;
    }

    public CurrencyAmountModel(CurrencyAmount currencyAmount) {
        this.MyBillsEntityDataFactory = currencyAmount.getAmount();
        this.BuiltInFictitiousFunctionClassFactory = currencyAmount.getCurrency();
    }

    public CurrencyAmountModel(String str) {
        this.MyBillsEntityDataFactory = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.MyBillsEntityDataFactory);
        parcel.writeString(this.BuiltInFictitiousFunctionClassFactory);
    }

    public final boolean getAuthRequestContext(CurrencyAmountModel currencyAmountModel) {
        if (currencyAmountModel == null || currencyAmountModel.MyBillsEntityDataFactory.isEmpty() || NumberUtils.getCleanAll(currencyAmountModel.MyBillsEntityDataFactory).isEmpty()) {
            return false;
        }
        String cleanAll = NumberUtils.getCleanAll(this.MyBillsEntityDataFactory);
        return ((cleanAll == null || cleanAll.isEmpty()) ? 0L : Long.parseLong(cleanAll)) > Long.parseLong(NumberUtils.getCleanAll(currencyAmountModel.MyBillsEntityDataFactory));
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(CurrencyAmountModel currencyAmountModel) {
        String str;
        if (currencyAmountModel == null || (str = currencyAmountModel.MyBillsEntityDataFactory) == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return Long.parseLong(NumberUtils.getCleanAll(this.MyBillsEntityDataFactory)) < Long.parseLong(NumberUtils.getCleanAll(currencyAmountModel.MyBillsEntityDataFactory));
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        String str = this.MyBillsEntityDataFactory;
        return str == null || str.isEmpty() || Long.parseLong(NumberUtils.getCleanAll(this.MyBillsEntityDataFactory)) < 1;
    }

    public final String getAuthRequestContext() {
        String str;
        try {
            if (this.BuiltInFictitiousFunctionClassFactory == null || (str = this.MyBillsEntityDataFactory) == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
                return null;
            }
            return NumberFormatterUtil.PlaceComponentResult(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), BuiltInFictitiousFunctionClassFactory(), this.BuiltInFictitiousFunctionClassFactory);
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("error getCurrencyAndAmountValue ");
            sb.append(e);
            DanaLog.BuiltInFictitiousFunctionClassFactory("CurrencyAmountModel", sb.toString());
            return null;
        }
    }

    public final double BuiltInFictitiousFunctionClassFactory() {
        try {
            if (this.MyBillsEntityDataFactory != null) {
                String str = this.BuiltInFictitiousFunctionClassFactory;
                if (str != null && !str.isEmpty() && !this.BuiltInFictitiousFunctionClassFactory.equals("Rp") && !this.BuiltInFictitiousFunctionClassFactory.equals(GlobalNetworkConstants.IDR_CURRENCY)) {
                    return Double.parseDouble(this.MyBillsEntityDataFactory.replace(",", ""));
                }
                if (this.MyBillsEntityDataFactory.endsWith(".0")) {
                    this.MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.substring(0, r3.length() - 2);
                }
                return Double.parseDouble(this.MyBillsEntityDataFactory.replace(".", "").replace(",", "."));
            }
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("error getAmountDouble ");
            sb.append(e);
            DanaLog.BuiltInFictitiousFunctionClassFactory("CurrencyAmountModel", sb.toString());
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
    }
}
