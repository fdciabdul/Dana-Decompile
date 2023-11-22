package id.dana.social.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.utils.FeedRegexData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u0000 V2\u00020\u0001:\u0001VB\u00ad\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010D\u001a\u00020\u0007\u0012,\b\u0002\u0010E\u001a&\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010$j\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`%\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010H\u001a\u00020\u0007\u0012\b\b\u0002\u0010I\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020805\u0012\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020605\u0012\b\b\u0002\u0010L\u001a\u00020\n\u0012\b\b\u0002\u0010M\u001a\u00020\n\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010O\u001a\u00020=\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u001d\u0012\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020.0-\u0012\b\b\u0002\u0010R\u001a\u00020\u0007\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u000101¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0015\u0010\fJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\r\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u001dX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u001eR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u001cR\u0012\u0010\u000b\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010 R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0014\u0010\u0010\u001a\u0004\u0018\u00010!X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\"R\u0014\u0010#\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u001cR6\u0010&\u001a&\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010$j\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`%X\u0086\u0002¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010*\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b#\u0010\u001cR\u0011\u0010,\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b+\u0010\u001cR\u0018\u00100\u001a\b\u0012\u0004\u0012\u00020.0-X\u0087\u0002¢\u0006\u0006\n\u0004\b,\u0010/R\u0014\u00103\u001a\u0004\u0018\u000101X\u0087\u0002¢\u0006\u0006\n\u0004\b0\u00102R\u001a\u0010+\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b4\u0010)\u001a\u0004\b\u001b\u0010\u0011R\u0018\u00107\u001a\b\u0012\u0004\u0012\u00020605X\u0087\u0002¢\u0006\u0006\n\u0004\b3\u0010/R\u0018\u00109\u001a\b\u0012\u0004\u0012\u00020805X\u0087\u0002¢\u0006\u0006\n\u0004\b*\u0010/R\u001a\u0010:\u001a\u00020\u00078\u0007X\u0087\u0006¢\u0006\f\n\u0004\b:\u0010)\u001a\u0004\b\u001f\u0010\u0011R\u0012\u0010;\u001a\u00020\nX\u0087\u0002¢\u0006\u0006\n\u0004\b7\u0010\u001cR\u0012\u0010<\u001a\u00020\nX\u0087\u0002¢\u0006\u0006\n\u0004\b;\u0010\u001cR\u0012\u00104\u001a\u00020=X\u0087\u0002¢\u0006\u0006\n\u0004\b9\u0010>R\u0014\u0010?\u001a\u0004\u0018\u00010\nX\u0087\u0002¢\u0006\u0006\n\u0004\b<\u0010\u001c"}, d2 = {"Lid/dana/social/model/FeedModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "getAuthRequestContext", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "hashCode", "getErrorConfigVersion", "()Z", "moveToNextValue", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "toString", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "PlaceComponentResult", "Ljava/lang/String;", "Lid/dana/feeds/ui/model/ActivityWidgetModel;", "Lid/dana/feeds/ui/model/ActivityWidgetModel;", "MyBillsEntityDataFactory", "I", "", "Ljava/lang/Long;", "scheduleImpl", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "lookAheadTest", "Ljava/util/HashMap;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Ljava/util/List;", "GetContactSyncConfig", "Lid/dana/feeds/ui/model/FeedCommentModel;", "Lid/dana/feeds/ui/model/FeedCommentModel;", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda6", "", "Lid/dana/social/model/OwnReactionModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/social/model/ReactionCountModel;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "isLayoutRequested", "PrepareContext", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLjava/util/HashMap;Ljava/lang/String;Ljava/lang/String;ZILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/feeds/domain/timeline/enums/FeedActivityState;Lid/dana/feeds/ui/model/ActivityWidgetModel;Ljava/util/List;ZLid/dana/feeds/ui/model/FeedCommentModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeedModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public int getAuthRequestContext;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public List<OwnReactionModel> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public FeedCommentModel DatabaseTableConfigUtil;
    public ActivityWidgetModel KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public List<MerchantImageModel> GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public List<ReactionCountModel> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    String isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public FeedActivityState NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    String PrepareContext;
    public HashMap<String, String> lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public Long getErrorConfigVersion;
    public boolean newProxyInstance;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<FeedModel> CREATOR = new Creator();

    public FeedModel() {
        this(null, null, null, null, null, null, false, null, null, null, false, 0, null, null, null, null, null, null, null, null, false, null, 4194303, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof FeedModel) {
            FeedModel feedModel = (FeedModel) p0;
            return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda4, feedModel.NetworkUserEntityData$$ExternalSyntheticLambda4) && Intrinsics.areEqual(this.scheduleImpl, feedModel.scheduleImpl) && Intrinsics.areEqual(this.getErrorConfigVersion, feedModel.getErrorConfigVersion) && Intrinsics.areEqual(this.moveToNextValue, feedModel.moveToNextValue) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, feedModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && this.newProxyInstance == feedModel.newProxyInstance && Intrinsics.areEqual(this.lookAheadTest, feedModel.lookAheadTest) && Intrinsics.areEqual(this.PlaceComponentResult, feedModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, feedModel.BuiltInFictitiousFunctionClassFactory) && this.initRecordTimeStamp == feedModel.initRecordTimeStamp && this.getAuthRequestContext == feedModel.getAuthRequestContext && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, feedModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, feedModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.isLayoutRequested, feedModel.isLayoutRequested) && Intrinsics.areEqual(this.PrepareContext, feedModel.PrepareContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, feedModel.MyBillsEntityDataFactory) && this.NetworkUserEntityData$$ExternalSyntheticLambda6 == feedModel.NetworkUserEntityData$$ExternalSyntheticLambda6 && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, feedModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.GetContactSyncConfig, feedModel.GetContactSyncConfig) && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == feedModel.NetworkUserEntityData$$ExternalSyntheticLambda0 && Intrinsics.areEqual(this.DatabaseTableConfigUtil, feedModel.DatabaseTableConfigUtil);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode();
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.scheduleImpl;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        Long l = this.getErrorConfigVersion;
        int hashCode4 = l == null ? 0 : l.hashCode();
        String str3 = this.moveToNextValue;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        boolean z = this.newProxyInstance;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        HashMap<String, String> hashMap = this.lookAheadTest;
        int hashCode7 = hashMap == null ? 0 : hashMap.hashCode();
        String str5 = this.PlaceComponentResult;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        boolean z2 = this.initRecordTimeStamp;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = this.getAuthRequestContext;
        int hashCode10 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.hashCode();
        int hashCode11 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.hashCode();
        int hashCode12 = this.isLayoutRequested.hashCode();
        int hashCode13 = this.PrepareContext.hashCode();
        String str7 = this.MyBillsEntityDataFactory;
        int hashCode14 = str7 == null ? 0 : str7.hashCode();
        int hashCode15 = this.NetworkUserEntityData$$ExternalSyntheticLambda6.hashCode();
        ActivityWidgetModel activityWidgetModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode16 = activityWidgetModel == null ? 0 : activityWidgetModel.hashCode();
        int hashCode17 = this.GetContactSyncConfig.hashCode();
        boolean z3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i4 = !z3 ? z3 ? 1 : 0 : 1;
        FeedCommentModel feedCommentModel = this.DatabaseTableConfigUtil;
        return (((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + i2) * 31) + i3) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + i4) * 31) + (feedCommentModel != null ? feedCommentModel.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedModel(NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda4=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda6=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        p0.writeString(this.scheduleImpl);
        Long l = this.getErrorConfigVersion;
        if (l == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l.longValue());
        }
        p0.writeString(this.moveToNextValue);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeInt(this.newProxyInstance ? 1 : 0);
        HashMap<String, String> hashMap = this.lookAheadTest;
        if (hashMap == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(hashMap.size());
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                p0.writeString(entry.getKey());
                p0.writeString(entry.getValue());
            }
        }
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeInt(this.initRecordTimeStamp ? 1 : 0);
        p0.writeInt(this.getAuthRequestContext);
        List<ReactionCountModel> list = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        p0.writeInt(list.size());
        Iterator<ReactionCountModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        List<OwnReactionModel> list2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        p0.writeInt(list2.size());
        Iterator<OwnReactionModel> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(p0, p1);
        }
        p0.writeString(this.isLayoutRequested);
        p0.writeString(this.PrepareContext);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6.name());
        p0.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, p1);
        List<MerchantImageModel> list3 = this.GetContactSyncConfig;
        p0.writeInt(list3.size());
        Iterator<MerchantImageModel> it3 = list3.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(p0, p1);
        }
        p0.writeInt(this.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 1 : 0);
        p0.writeParcelable(this.DatabaseTableConfigUtil, p1);
    }

    public FeedModel(String str, String str2, String str3, Long l, String str4, String str5, boolean z, HashMap<String, String> hashMap, String str6, String str7, boolean z2, int i, List<ReactionCountModel> list, List<OwnReactionModel> list2, String str8, String str9, String str10, FeedActivityState feedActivityState, ActivityWidgetModel activityWidgetModel, List<MerchantImageModel> list3, boolean z3, FeedCommentModel feedCommentModel) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(feedActivityState, "");
        Intrinsics.checkNotNullParameter(list3, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = str2;
        this.scheduleImpl = str3;
        this.getErrorConfigVersion = l;
        this.moveToNextValue = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str5;
        this.newProxyInstance = z;
        this.lookAheadTest = hashMap;
        this.PlaceComponentResult = str6;
        this.BuiltInFictitiousFunctionClassFactory = str7;
        this.initRecordTimeStamp = z2;
        this.getAuthRequestContext = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = list;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = list2;
        this.isLayoutRequested = str8;
        this.PrepareContext = str9;
        this.MyBillsEntityDataFactory = str10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = feedActivityState;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = activityWidgetModel;
        this.GetContactSyncConfig = list3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z3;
        this.DatabaseTableConfigUtil = feedCommentModel;
    }

    public /* synthetic */ FeedModel(String str, String str2, String str3, Long l, String str4, String str5, boolean z, HashMap hashMap, String str6, String str7, boolean z2, int i, List list, List list2, String str8, String str9, String str10, FeedActivityState feedActivityState, ActivityWidgetModel activityWidgetModel, List list3, boolean z3, FeedCommentModel feedCommentModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? 0L : l, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? true : z, (i2 & 128) != 0 ? new HashMap() : hashMap, (i2 & 256) != 0 ? "" : str6, (i2 & 512) != 0 ? "" : str7, (i2 & 1024) != 0 ? false : z2, (i2 & 2048) != 0 ? 0 : i, (i2 & 4096) != 0 ? new ArrayList() : list, (i2 & 8192) != 0 ? new ArrayList() : list2, (i2 & 16384) != 0 ? "" : str8, (i2 & 32768) != 0 ? "" : str9, (i2 & 65536) != 0 ? "" : str10, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? FeedActivityState.SUCCESS : feedActivityState, (i2 & 262144) != 0 ? null : activityWidgetModel, (i2 & 524288) != 0 ? CollectionsKt.emptyList() : list3, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? false : z3, (i2 & 2097152) == 0 ? feedCommentModel : null);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getNewProxyInstance() {
        return this.newProxyInstance;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getInitRecordTimeStamp() {
        return this.initRecordTimeStamp;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        List<ReactionCountModel> list = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((ReactionCountModel) it.next()).getAuthRequestContext));
        }
        return CollectionsKt.sumOfInt(arrayList);
    }

    public final String getAuthRequestContext() {
        String NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
        String str = null;
        if (!(NetworkUserEntityData$$ExternalSyntheticLambda0.length() > 0)) {
            NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            sb.append(NetworkUserEntityData$$ExternalSyntheticLambda0);
            str = sb.toString();
        }
        return str == null ? "" : str;
    }

    public final String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        String username;
        HashMap<String, String> hashMap = this.lookAheadTest;
        if (hashMap != null && (username = ExtendInfoUtilKt.getUsername(hashMap)) != null) {
            if (!(username.length() > 0)) {
                username = null;
            }
            if (username != null) {
                return username;
            }
        }
        HashMap<String, String> hashMap2 = this.lookAheadTest;
        String str = hashMap2 != null ? hashMap2.get("username") : null;
        return str == null ? "" : str;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        HashMap<String, String> hashMap = this.lookAheadTest;
        if ((hashMap != null ? hashMap.get(ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID) : null) != null) {
            HashMap<String, String> hashMap2 = this.lookAheadTest;
            if (Intrinsics.areEqual(hashMap2 != null ? hashMap2.get(ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID) : null, p0)) {
                return true;
            }
        }
        return false;
    }

    public final boolean getErrorConfigVersion() {
        String str = this.MyBillsEntityDataFactory;
        return !(str == null || str.length() == 0);
    }

    public final boolean moveToNextValue() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda6 == FeedActivityState.SUCCESS;
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\u0006J%\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0005\u001a\u00020\u00112\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0005\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0006J\r\u0010\f\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0016J\r\u0010\u0005\u001a\u00020\u0011¢\u0006\u0004\b\u0005\u0010\u0016J\u0015\u0010\f\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0017¢\u0006\u0004\b\f\u0010\u0018J%\u0010\f\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u001a¢\u0006\u0004\b\f\u0010\u001c"}, d2 = {"Lid/dana/social/model/FeedModel$Companion;", "", "", "p0", "Lid/dana/social/model/FeedModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/social/model/FeedModel;", "p1", "p2", "p3", "", "p4", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/social/model/FeedModel;", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "", "Lid/dana/feeds/ui/model/FriendModel;", "Lid/dana/social/model/FeedViewHolderModel;", "MyBillsEntityDataFactory", "(Lid/dana/feeds/ui/model/MyFeedHeaderModel;Ljava/util/List;)Lid/dana/social/model/FeedViewHolderModel;", "(Ljava/util/List;)Lid/dana/social/model/FeedViewHolderModel;", "getAuthRequestContext", "()Lid/dana/social/model/FeedViewHolderModel;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "(Lid/dana/feeds/ui/model/RelationshipItemModel;)Lid/dana/social/model/FeedViewHolderModel;", "Landroid/content/Context;", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/utils/FeedRegexData;", "(Landroid/content/Context;Lid/dana/social/model/FeedModel;Lid/dana/social/adapter/SocialFeedClickListener;)Lid/dana/social/utils/FeedRegexData;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static FeedModel KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            return new FeedModel(null, p0, null, null, null, null, false, null, null, null, false, 0, null, null, null, null, null, null, null, null, false, null, 4194301, null);
        }

        public static FeedModel KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            HashMap hashMap = new HashMap();
            hashMap.put("kyc_level", str3);
            Companion companion = FeedModel.INSTANCE;
            hashMap.put("show_privacy_key", "hide");
            Unit unit = Unit.INSTANCE;
            return new FeedModel(str, str2, null, null, null, null, false, hashMap, null, null, false, 0, null, null, null, null, null, null, null, null, false, null, 4194140, null);
        }

        /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static FeedViewHolderModel BuiltInFictitiousFunctionClassFactory(List<FriendModel> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ?? r9 = 0;
            return new FeedViewHolderModel(3, new FeedModel(null, null, r9, null, null, null, false, null, null, null, false, 0, null, null, null, null, null, null, null, null, false, null, 4194303, null), null, p0, null, false, 52, r9);
        }

        /* JADX WARN: Type inference failed for: r9v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        public static FeedViewHolderModel KClassImpl$Data$declaredNonStaticMembers$2(RelationshipItemModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ?? r9 = 0;
            return new FeedViewHolderModel(8, new FeedModel(null, r9, null, null, null, null, false, null, null, null, false, 0, null, null, null, null, null, null, null, null, false, null, 4194303, null), null, null, p0, false, 44, r9);
        }

        public static FeedViewHolderModel BuiltInFictitiousFunctionClassFactory() {
            return new FeedViewHolderModel(0, null, null, null, null, false, 62, null);
        }

        public static FeedViewHolderModel KClassImpl$Data$declaredNonStaticMembers$2() {
            return new FeedViewHolderModel(17, null, null, null, null, false, 62, null);
        }

        public static FeedModel getAuthRequestContext(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new FeedModel(p0, null, null, null, null, null, false, null, null, null, false, 0, null, null, null, null, null, null, null, null, false, null, 4194302, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x003d, code lost:
        
            if (r6 == null) goto L50;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static /* synthetic */ id.dana.social.model.FeedModel KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r31, java.lang.String r32, java.lang.String r33, id.dana.feeds.ui.model.MyFeedHeaderModel r34, java.util.HashMap r35, id.dana.feeds.domain.timeline.model.ActivityWidget r36, java.lang.String r37, int r38) {
            /*
                r0 = r31
                r1 = r34
                r2 = r38 & 32
                r3 = 0
                if (r2 == 0) goto Lb
                r2 = r3
                goto Ld
            Lb:
                r2 = r36
            Ld:
                r4 = r38 & 64
                java.lang.String r5 = ""
                if (r4 == 0) goto L15
                r4 = r5
                goto L17
            L15:
                r4 = r37
            L17:
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
                r9 = r32
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r5)
                r14 = r33
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r5)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
                id.dana.feeds.domain.timeline.enums.FeedActivityState r24 = id.dana.feeds.domain.timeline.enums.FeedActivityState.INIT
                long r10 = java.lang.System.currentTimeMillis()
                if (r35 == 0) goto L37
                java.lang.String r6 = id.dana.domain.social.ExtendInfoUtilKt.getProfileAvatar(r35)
                if (r6 == 0) goto L37
            L35:
                r5 = r6
                goto L3f
            L37:
                if (r1 == 0) goto L3c
                java.lang.String r6 = r1.MyBillsEntityDataFactory
                goto L3d
            L3c:
                r6 = r3
            L3d:
                if (r6 != 0) goto L35
            L3f:
                r12 = r5
                if (r2 == 0) goto L48
                id.dana.feeds.ui.model.ActivityWidgetModel$Companion r3 = id.dana.feeds.ui.model.ActivityWidgetModel.INSTANCE
                id.dana.feeds.ui.model.ActivityWidgetModel r3 = id.dana.feeds.ui.model.ActivityWidgetModel.Companion.getAuthRequestContext(r2, r4)
            L48:
                r25 = r3
                id.dana.social.model.FeedModel r2 = new id.dana.social.model.FeedModel
                r6 = r2
                r7 = 0
                r8 = 0
                java.lang.Long r10 = java.lang.Long.valueOf(r10)
                r11 = 0
                r13 = 0
                r15 = 0
                r16 = 0
                r17 = 1
                r18 = 0
                r19 = 0
                r20 = 0
                r21 = 0
                r22 = 0
                r26 = 0
                r27 = 0
                r28 = 0
                r29 = 3734355(0x38fb53, float:5.232946E-39)
                r30 = 0
                r9 = r32
                r14 = r35
                r23 = r33
                r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
                if (r1 == 0) goto L89
                java.util.HashMap<java.lang.String, java.lang.String> r3 = r2.lookAheadTest
                if (r3 == 0) goto L89
                java.lang.String r4 = r1.PlaceComponentResult
                java.lang.String r5 = r1.MyBillsEntityDataFactory
                java.lang.String r6 = r1.NetworkUserEntityData$$ExternalSyntheticLambda0
                java.lang.String r1 = r1.getAuthRequestContext
                id.dana.domain.social.ExtendInfoUtilKt.setUserInfo(r3, r4, r5, r6, r1)
            L89:
                java.util.HashMap<java.lang.String, java.lang.String> r1 = r2.lookAheadTest
                if (r1 == 0) goto L90
                id.dana.domain.social.ExtendInfoUtilKt.setShareFeedRequestId(r1, r0)
            L90:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.social.model.FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String, java.lang.String, java.lang.String, id.dana.feeds.ui.model.MyFeedHeaderModel, java.util.HashMap, id.dana.feeds.domain.timeline.model.ActivityWidget, java.lang.String, int):id.dana.social.model.FeedModel");
        }

        public static FeedModel BuiltInFictitiousFunctionClassFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            FeedModel feedModel = new FeedModel(null, null, null, null, null, null, false, null, null, null, false, 0, null, null, null, null, null, FeedActivityState.ERROR, null, null, false, null, 4063231, null);
            HashMap<String, String> hashMap = feedModel.lookAheadTest;
            if (hashMap != null) {
                ExtendInfoUtilKt.setShareFeedRequestId(hashMap, p0);
            }
            return feedModel;
        }

        /* JADX WARN: Type inference failed for: r23v0, types: [id.dana.social.model.GroupedFeedModel, java.lang.String] */
        /* JADX WARN: Type inference failed for: r25v0, types: [id.dana.feeds.ui.model.RelationshipItemModel, java.lang.String] */
        /* JADX WARN: Type inference failed for: r28v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.util.HashMap] */
        public static FeedViewHolderModel MyBillsEntityDataFactory(MyFeedHeaderModel p0, List<FriendModel> p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            String str = p0 != null ? p0.getAuthRequestContext : null;
            String str2 = str == null ? "" : str;
            String str3 = p0 != null ? p0.MyBillsEntityDataFactory : null;
            String str4 = str3 == null ? "" : str3;
            String str5 = p0 != null ? p0.PlaceComponentResult : null;
            FriendModel friendModel = new FriendModel(str2, str4, str5 == null ? "" : str5, true, null, null, null, 0, false, 0L, false, 2032, null);
            ?? r23 = 0;
            ?? r25 = 0;
            ?? r28 = 0;
            FeedModel feedModel = new FeedModel(null, null, r23, null, r25, null, false, r28, null, null, false, 0, null, null, null, null, null, null, null, null, false, null, 4194303, null);
            ArrayList arrayList = new ArrayList();
            arrayList.add(friendModel);
            arrayList.addAll(p1);
            Unit unit = Unit.INSTANCE;
            return new FeedViewHolderModel(3, feedModel, r23, arrayList, r25, false, 52, r28);
        }

        public static FeedRegexData KClassImpl$Data$declaredNonStaticMembers$2(Context p0, FeedModel p1, SocialFeedClickListener p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            String str = p1.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str2 = p1.scheduleImpl;
            String str3 = str2 == null ? "" : str2;
            HashMap<String, String> hashMap = p1.lookAheadTest;
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            HashMap<String, String> hashMap2 = hashMap;
            FeedModel$Companion$toFeedRegexData$1$1 feedModel$Companion$toFeedRegexData$1$1 = new FeedModel$Companion$toFeedRegexData$1$1(p2);
            String str4 = p1.PlaceComponentResult;
            return new FeedRegexData(str, str3, hashMap2, feedModel$Companion$toFeedRegexData$1$1, p0, str4 == null ? "" : str4);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<FeedModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FeedModel createFromParcel(Parcel parcel) {
            HashMap hashMap;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                hashMap = null;
            } else {
                int readInt = parcel.readInt();
                hashMap = new HashMap(readInt);
                for (int i = 0; i != readInt; i++) {
                    hashMap.put(parcel.readString(), parcel.readString());
                }
            }
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            int i2 = 0;
            while (i2 != readInt3) {
                arrayList.add(ReactionCountModel.CREATOR.createFromParcel(parcel));
                i2++;
                readInt3 = readInt3;
            }
            ArrayList arrayList2 = arrayList;
            int readInt4 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(readInt4);
            int i3 = 0;
            while (i3 != readInt4) {
                arrayList3.add(OwnReactionModel.CREATOR.createFromParcel(parcel));
                i3++;
                readInt4 = readInt4;
            }
            ArrayList arrayList4 = arrayList3;
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            FeedActivityState valueOf2 = FeedActivityState.valueOf(parcel.readString());
            ActivityWidgetModel activityWidgetModel = (ActivityWidgetModel) parcel.readParcelable(FeedModel.class.getClassLoader());
            int readInt5 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(readInt5);
            int i4 = 0;
            while (i4 != readInt5) {
                arrayList5.add(MerchantImageModel.CREATOR.createFromParcel(parcel));
                i4++;
                readInt5 = readInt5;
            }
            return new FeedModel(readString, readString2, readString3, valueOf, readString4, readString5, z, hashMap, readString6, readString7, z2, readInt2, arrayList2, arrayList4, readString8, readString9, readString10, valueOf2, activityWidgetModel, arrayList5, parcel.readInt() != 0, (FeedCommentModel) parcel.readParcelable(FeedModel.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FeedModel[] newArray(int i) {
            return new FeedModel[i];
        }
    }
}
