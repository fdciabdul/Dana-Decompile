package id.dana.sendmoney.ui.globalsend.form.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000f\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/model/TransferValidateResultModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "<init>", "(Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferValidateResultModel implements Parcelable {
    public static final Parcelable.Creator<TransferValidateResultModel> CREATOR = new Creator();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final BeneficiaryInfoModel PlaceComponentResult;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.writeToParcel(p0, p1);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.MyBillsEntityDataFactory);
    }

    public TransferValidateResultModel(BeneficiaryInfoModel beneficiaryInfoModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(beneficiaryInfoModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.PlaceComponentResult = beneficiaryInfoModel;
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = str2;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<TransferValidateResultModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TransferValidateResultModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new TransferValidateResultModel(BeneficiaryInfoModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TransferValidateResultModel[] newArray(int i) {
            return new TransferValidateResultModel[i];
        }
    }
}
