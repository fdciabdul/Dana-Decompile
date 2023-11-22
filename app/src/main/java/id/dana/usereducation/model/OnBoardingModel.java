package id.dana.usereducation.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\b\b\u0002\u0010!\u001a\u00020\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\b\b\u0002\u0010#\u001a\u00020\u000b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0012\u0010\u001b\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0012\u0010\u0013\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0012\u0010\u001d\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0012\u0010\u001c\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014"}, d2 = {"Lid/dana/usereducation/model/OnBoardingModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getErrorConfigVersion", "lookAheadTest", "scheduleImpl", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OnBoardingModel implements Parcelable {
    public static final Parcelable.Creator<OnBoardingModel> CREATOR = new Creator();
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public List<ContentOnBoardingModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OnBoardingModel(String str, String str2, List<ContentOnBoardingModel> list, String str3) {
        this(str, str2, list, str3, null, null, null, 112, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str3, "");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof OnBoardingModel) {
            OnBoardingModel onBoardingModel = (OnBoardingModel) p0;
            return Intrinsics.areEqual(this.lookAheadTest, onBoardingModel.lookAheadTest) && Intrinsics.areEqual(this.getErrorConfigVersion, onBoardingModel.getErrorConfigVersion) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, onBoardingModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, onBoardingModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, onBoardingModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, onBoardingModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, onBoardingModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.lookAheadTest.hashCode() * 31) + this.getErrorConfigVersion.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OnBoardingModel(lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.getErrorConfigVersion);
        List<ContentOnBoardingModel> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
        p0.writeInt(list.size());
        Iterator<ContentOnBoardingModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.PlaceComponentResult);
    }

    public OnBoardingModel(String str, String str2, List<ContentOnBoardingModel> list, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.lookAheadTest = str;
        this.getErrorConfigVersion = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.getAuthRequestContext = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.MyBillsEntityDataFactory = str5;
        this.PlaceComponentResult = str6;
    }

    public /* synthetic */ OnBoardingModel(String str, String str2, List list, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<OnBoardingModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OnBoardingModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(ContentOnBoardingModel.CREATOR.createFromParcel(parcel));
            }
            return new OnBoardingModel(readString, readString2, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OnBoardingModel[] newArray(int i) {
            return new OnBoardingModel[i];
        }
    }
}
