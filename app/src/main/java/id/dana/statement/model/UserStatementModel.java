package id.dana.statement.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.model.CurrencyAmountModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b \u0010\u0018R\u0012\u0010!\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/statement/model/UserStatementModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/model/CurrencyAmountModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/model/CurrencyAmountModel;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "", "Lid/dana/statement/model/StatementSummaryModel;", "PlaceComponentResult", "Ljava/util/List;", "MyBillsEntityDataFactory", "lookAheadTest", "moveToNextValue", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/model/CurrencyAmountModel;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserStatementModel implements Parcelable {
    public static final Parcelable.Creator<UserStatementModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final CurrencyAmountModel getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<StatementSummaryModel> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String lookAheadTest;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof UserStatementModel) {
            UserStatementModel userStatementModel = (UserStatementModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, userStatementModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, userStatementModel.MyBillsEntityDataFactory) && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == userStatementModel.NetworkUserEntityData$$ExternalSyntheticLambda0 && Intrinsics.areEqual(this.PlaceComponentResult, userStatementModel.PlaceComponentResult) && Intrinsics.areEqual(this.lookAheadTest, userStatementModel.lookAheadTest) && Intrinsics.areEqual(this.moveToNextValue, userStatementModel.moveToNextValue) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, userStatementModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, userStatementModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        CurrencyAmountModel currencyAmountModel = this.getAuthRequestContext;
        int hashCode = currencyAmountModel == null ? 0 : currencyAmountModel.hashCode();
        List<StatementSummaryModel> list = this.MyBillsEntityDataFactory;
        int hashCode2 = list == null ? 0 : list.hashCode();
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str = this.PlaceComponentResult;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.lookAheadTest;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.moveToNextValue;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserStatementModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeParcelable(this.getAuthRequestContext, p1);
        List<StatementSummaryModel> list = this.MyBillsEntityDataFactory;
        if (list == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list.size());
            Iterator<StatementSummaryModel> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(p0, p1);
            }
        }
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public UserStatementModel(CurrencyAmountModel currencyAmountModel, List<StatementSummaryModel> list, int i, String str, String str2, String str3, String str4, String str5) {
        this.getAuthRequestContext = currencyAmountModel;
        this.MyBillsEntityDataFactory = list;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.PlaceComponentResult = str;
        this.lookAheadTest = str2;
        this.moveToNextValue = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
    }

    public /* synthetic */ UserStatementModel(CurrencyAmountModel currencyAmountModel, List list, int i, String str, String str2, String str3, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(currencyAmountModel, list, i, (i2 & 8) != 0 ? "" : str, (i2 & 16) != 0 ? "" : str2, (i2 & 32) != 0 ? "" : str3, (i2 & 64) != 0 ? "" : str4, (i2 & 128) != 0 ? "" : str5);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<UserStatementModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserStatementModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "");
            CurrencyAmountModel currencyAmountModel = (CurrencyAmountModel) parcel.readParcelable(UserStatementModel.class.getClassLoader());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(StatementSummaryModel.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new UserStatementModel(currencyAmountModel, arrayList, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserStatementModel[] newArray(int i) {
            return new UserStatementModel[i];
        }
    }
}
