package id.dana.statement.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.model.CurrencyAmountModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0006\u001a\u00020\u0013\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u001c\u0012\b\b\u0002\u0010!\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0016\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0012\u0010\u001d\u001a\u00020\u001cX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/statement/model/StatementSummaryModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/model/CurrencyAmountModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/model/CurrencyAmountModel;", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "Z", "()Z", "", "KClassImpl$Data$declaredNonStaticMembers$2", LogConstants.RESULT_FALSE, "p2", "p3", "p4", "<init>", "(Lid/dana/model/CurrencyAmountModel;Ljava/lang/String;Ljava/lang/String;FZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StatementSummaryModel implements Parcelable {
    public static final Parcelable.Creator<StatementSummaryModel> CREATOR = new Creator();
    public final CurrencyAmountModel BuiltInFictitiousFunctionClassFactory;
    public float KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof StatementSummaryModel) {
            StatementSummaryModel statementSummaryModel = (StatementSummaryModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, statementSummaryModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, statementSummaryModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, statementSummaryModel.PlaceComponentResult) && Intrinsics.areEqual((Object) Float.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), (Object) Float.valueOf(statementSummaryModel.KClassImpl$Data$declaredNonStaticMembers$2)) && this.MyBillsEntityDataFactory == statementSummaryModel.MyBillsEntityDataFactory;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode2 = this.getAuthRequestContext.hashCode();
        int hashCode3 = this.PlaceComponentResult.hashCode();
        int floatToIntBits = Float.floatToIntBits(this.KClassImpl$Data$declaredNonStaticMembers$2);
        boolean z = this.MyBillsEntityDataFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + floatToIntBits) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatementSummaryModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeParcelable(this.BuiltInFictitiousFunctionClassFactory, p1);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.PlaceComponentResult);
        p0.writeFloat(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
    }

    public StatementSummaryModel(CurrencyAmountModel currencyAmountModel, String str, String str2, float f, boolean z) {
        Intrinsics.checkNotNullParameter(currencyAmountModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = currencyAmountModel;
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
        this.MyBillsEntityDataFactory = z;
    }

    public /* synthetic */ StatementSummaryModel(CurrencyAmountModel currencyAmountModel, String str, String str2, float f, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(currencyAmountModel, str, str2, (i & 8) != 0 ? 0.0f : f, (i & 16) != 0 ? true : z);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<StatementSummaryModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StatementSummaryModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new StatementSummaryModel((CurrencyAmountModel) parcel.readParcelable(StatementSummaryModel.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readFloat(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StatementSummaryModel[] newArray(int i) {
            return new StatementSummaryModel[i];
        }
    }
}
