package id.dana.sendmoney.ui.groupsend.summary.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 '2\u00020\u0001:\u0001'B[\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\b\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0014¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0006\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0012\u0010\u0013\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0012\u0010\t\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00148\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017R\u0012\u0010\u0012\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001d\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0012\u0010\u0019\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/model/GroupSendIntentModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "", "getAuthRequestContext", "()Ljava/util/List;", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/List;", "scheduleImpl", "getErrorConfigVersion", "moveToNextValue", "lookAheadTest", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendIntentModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public List<? extends RecipientViewModel> scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static final Parcelable.Creator<GroupSendIntentModel> CREATOR = new Creator();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.moveToNextValue);
        List<? extends RecipientViewModel> list = this.scheduleImpl;
        p0.writeInt(list.size());
        Iterator<? extends RecipientViewModel> it = list.iterator();
        while (it.hasNext()) {
            p0.writeParcelable(it.next(), p1);
        }
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.PlaceComponentResult);
        p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
    }

    public GroupSendIntentModel(String str, String str2, List<? extends RecipientViewModel> list, String str3, String str4, String str5, String str6, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.moveToNextValue = str2;
        this.scheduleImpl = list;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.getAuthRequestContext = str4;
        this.MyBillsEntityDataFactory = str5;
        this.PlaceComponentResult = str6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    public /* synthetic */ GroupSendIntentModel(String str, String str2, List list, String str3, String str4, String str5, String str6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? GroupSendRecipientType.CONTACT : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) == 0 ? str6 : "", (i & 128) != 0 ? false : z);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        if (this.PlaceComponentResult.length() > 0) {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", LocaleUtil.BuiltInFictitiousFunctionClassFactory()).parse(this.PlaceComponentResult);
            String format = parse != null ? new SimpleDateFormat("dd/MM/yyyy", LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(parse) : null;
            if (format != null) {
                return format;
            }
        }
        return "";
    }

    public final List<String> getAuthRequestContext() {
        List<? extends RecipientViewModel> list = this.scheduleImpl;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (RecipientViewModel recipientViewModel : list) {
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            String PlaceComponentResult = NumberUtil.PlaceComponentResult(recipientViewModel.DatabaseTableConfigUtil, "62-");
            if (PlaceComponentResult == null) {
                PlaceComponentResult = "";
            }
            arrayList.add(PlaceComponentResult);
        }
        return arrayList;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<GroupSendIntentModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GroupSendIntentModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(parcel.readParcelable(GroupSendIntentModel.class.getClassLoader()));
            }
            return new GroupSendIntentModel(readString, readString2, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GroupSendIntentModel[] newArray(int i) {
            return new GroupSendIntentModel[i];
        }
    }
}
