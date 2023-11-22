package id.dana.requestmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.data.constant.DanaUrl;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0006\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\n\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010 \u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000e\u0010\fJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015"}, d2 = {"Lid/dana/requestmoney/model/UserBankModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "hashCode", "toString", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserBankModel implements Parcelable {
    public static final Parcelable.Creator<UserBankModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    final String scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof UserBankModel) {
            UserBankModel userBankModel = (UserBankModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, userBankModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, userBankModel.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, userBankModel.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, userBankModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, userBankModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.scheduleImpl, userBankModel.scheduleImpl) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, userBankModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode()) * 31) + this.scheduleImpl.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserBankModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
    }

    public UserBankModel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = str2;
        this.getAuthRequestContext = str3;
        this.MyBillsEntityDataFactory = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str5;
        this.scheduleImpl = str6;
        this.BuiltInFictitiousFunctionClassFactory = str7;
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        if ((!StringsKt.isBlank(this.MyBillsEntityDataFactory)) == true) {
            String str = this.MyBillsEntityDataFactory;
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            String format = String.format(DanaUrl.BANK_ICON_URL, Arrays.copyOf(new Object[]{lowerCase}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            return format;
        }
        return "";
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<UserBankModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserBankModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new UserBankModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserBankModel[] newArray(int i) {
            return new UserBankModel[i];
        }
    }
}
