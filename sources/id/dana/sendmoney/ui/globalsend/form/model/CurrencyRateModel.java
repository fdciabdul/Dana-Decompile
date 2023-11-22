package id.dana.sendmoney.ui.globalsend.form.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.core.ui.model.CurrencyAmountModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0011\u0010\u0013\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/core/ui/model/CurrencyAmountModel;", "MyBillsEntityDataFactory", "Lid/dana/core/ui/model/CurrencyAmountModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "p2", "p3", "<init>", "(Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrencyRateModel implements Parcelable {
    public static final Parcelable.Creator<CurrencyRateModel> CREATOR = new Creator();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2;
    public final CurrencyAmountModel PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeParcelable(this.PlaceComponentResult, p1);
        p0.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, p1);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
    }

    public CurrencyRateModel(CurrencyAmountModel currencyAmountModel, CurrencyAmountModel currencyAmountModel2, String str, String str2) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        Intrinsics.checkNotNullParameter(currencyAmountModel2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.PlaceComponentResult = currencyAmountModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = currencyAmountModel2;
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<CurrencyRateModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CurrencyRateModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new CurrencyRateModel((CurrencyAmountModel) parcel.readParcelable(CurrencyRateModel.class.getClassLoader()), (CurrencyAmountModel) parcel.readParcelable(CurrencyRateModel.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CurrencyRateModel[] newArray(int i) {
            return new CurrencyRateModel[i];
        }
    }
}
