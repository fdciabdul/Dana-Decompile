package id.dana.feeds.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.feeds.domain.detail.model.Comment;
import id.dana.feeds.ui.model.ActivityReactionsUserModel;
import id.dana.feeds.ui.state.FeedCommentModelState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 /2\u00020\u0001:\u0001/B{\u0012\b\b\u0002\u0010\f\u001a\u00020\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\u0011\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020!\u0012\b\b\u0002\u0010&\u001a\u00020\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\u0011\u0012\b\b\u0002\u0010)\u001a\u00020\u001e\u0012\b\b\u0002\u0010*\u001a\u00020\u0011\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0012\u0010\u0006\u001a\u00020\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u0012\u0010\t\u001a\u00020\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0013\u0010\u0007R\u0012\u0010\u0019\u001a\u00020\u0011X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0012\u0010\u001d\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0012\u0010\u001a\u001a\u00020\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0012\u0010 \u001a\u00020\u001eX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001fR\u0011\u0010\"\u001a\u00020!X\u0007¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lid/dana/feeds/ui/model/FeedCommentModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Ljava/lang/String;", "PlaceComponentResult", "", "Ljava/util/List;", "initRecordTimeStamp", "Z", "getErrorConfigVersion", "moveToNextValue", "scheduleImpl", "lookAheadTest", "I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/feeds/ui/state/FeedCommentModelState;", "Lid/dana/feeds/ui/state/FeedCommentModelState;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILid/dana/feeds/ui/model/ActivityReactionsUserModel;Ljava/lang/String;ZLjava/lang/String;Lid/dana/feeds/ui/state/FeedCommentModelState;Ljava/lang/String;ILjava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedCommentModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<FeedCommentModel> getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public FeedCommentModelState NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final ActivityReactionsUserModel NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public int NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final boolean getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public int scheduleImpl;
    public String moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public List<FeedCommentModel> lookAheadTest;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<FeedCommentModel> CREATOR = new Creator();

    public FeedCommentModel() {
        this(null, null, 0, null, null, false, null, null, null, 0, null, 2047, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.writeToParcel(p0, p1);
        p0.writeString(this.PlaceComponentResult);
        p0.writeInt(this.getErrorConfigVersion ? 1 : 0);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1.name());
        p0.writeString(this.moveToNextValue);
        p0.writeInt(this.scheduleImpl);
        List<FeedCommentModel> list = this.lookAheadTest;
        p0.writeInt(list.size());
        Iterator<FeedCommentModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
    }

    public FeedCommentModel(String str, String str2, int i, ActivityReactionsUserModel activityReactionsUserModel, String str3, boolean z, String str4, FeedCommentModelState feedCommentModelState, String str5, int i2, List<FeedCommentModel> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(activityReactionsUserModel, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(feedCommentModelState, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.MyBillsEntityDataFactory = str2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = activityReactionsUserModel;
        this.PlaceComponentResult = str3;
        this.getErrorConfigVersion = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = feedCommentModelState;
        this.moveToNextValue = str5;
        this.scheduleImpl = i2;
        this.lookAheadTest = list;
        this.getAuthRequestContext = new ArrayList();
    }

    public /* synthetic */ FeedCommentModel(String str, String str2, int i, ActivityReactionsUserModel activityReactionsUserModel, String str3, boolean z, String str4, FeedCommentModelState feedCommentModelState, String str5, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? new ActivityReactionsUserModel(null, null, null, null, null, null, null, 127, null) : activityReactionsUserModel, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? "" : str4, (i3 & 128) != 0 ? FeedCommentModelState.DEFAULT : feedCommentModelState, (i3 & 256) == 0 ? str5 : "", (i3 & 512) == 0 ? i2 : 0, (i3 & 1024) != 0 ? new ArrayList() : list);
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getGetErrorConfigVersion() {
        return this.getErrorConfigVersion;
    }

    public final boolean getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0 > 0 && this.scheduleImpl != 0;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult;
        return str == null || str.length() == 0;
    }

    public final boolean MyBillsEntityDataFactory() {
        if (this.BuiltInFictitiousFunctionClassFactory.length() > 0) {
            return this.moveToNextValue.length() > 0;
        }
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0 > 0;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lid/dana/feeds/ui/model/FeedCommentModel$Companion;", "", "()V", "toFeedCommentModel", "Lid/dana/feeds/ui/model/FeedCommentModel;", "Lid/dana/feeds/domain/detail/model/Comment;", "state", "Lid/dana/feeds/ui/state/FeedCommentModelState;", "feature-feeds_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static FeedCommentModel getAuthRequestContext(Comment comment, FeedCommentModelState feedCommentModelState) {
            Intrinsics.checkNotNullParameter(comment, "");
            Intrinsics.checkNotNullParameter(feedCommentModelState, "");
            String id2 = comment.getId();
            String activityId = comment.getActivityId();
            String parentCommentId = comment.getParentCommentId();
            int replyCounts = comment.getReplyCounts();
            ActivityReactionsUserModel.Companion companion = ActivityReactionsUserModel.INSTANCE;
            return new FeedCommentModel(id2, activityId, replyCounts, ActivityReactionsUserModel.Companion.getAuthRequestContext(comment.getUser()), comment.getContent(), comment.getOwnComment(), comment.getCreatedTime(), feedCommentModelState, parentCommentId, 0, null, 1536, null);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<FeedCommentModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FeedCommentModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ActivityReactionsUserModel createFromParcel = ActivityReactionsUserModel.CREATOR.createFromParcel(parcel);
            String readString3 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String readString4 = parcel.readString();
            FeedCommentModelState valueOf = FeedCommentModelState.valueOf(parcel.readString());
            String readString5 = parcel.readString();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i != readInt3; i++) {
                arrayList.add(FeedCommentModel.CREATOR.createFromParcel(parcel));
            }
            return new FeedCommentModel(readString, readString2, readInt, createFromParcel, readString3, z, readString4, valueOf, readString5, readInt2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FeedCommentModel[] newArray(int i) {
            return new FeedCommentModel[i];
        }
    }
}
