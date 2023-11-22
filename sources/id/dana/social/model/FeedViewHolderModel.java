package id.dana.social.model;

import android.content.Context;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.model.FeedModel;
import id.dana.social.utils.FeedRegexData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BM\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001a\u0012\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010*\u001a\u00020\u0003¢\u0006\u0004\b+\u0010,J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\fJ\u001d\u0010\n\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\n\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u001aX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0007¢\u0006\u0006\n\u0004\b\n\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b\u001e\u0010#R\u0011\u0010&\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lid/dana/social/model/FeedViewHolderModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "getAuthRequestContext", "(Ljava/lang/String;)Z", "()Z", "Landroid/content/Context;", "Lid/dana/social/adapter/SocialFeedClickListener;", "p1", "Lid/dana/social/utils/FeedRegexData;", "(Landroid/content/Context;Lid/dana/social/adapter/SocialFeedClickListener;)Lid/dana/social/utils/FeedRegexData;", "Lid/dana/social/model/SocialFeedModel;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/social/model/SocialFeedModel;", "toString", "()Ljava/lang/String;", "Lid/dana/social/model/FeedModel;", "MyBillsEntityDataFactory", "Lid/dana/social/model/FeedModel;", "Lid/dana/social/model/GroupedFeedModel;", "Lid/dana/social/model/GroupedFeedModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "PlaceComponentResult", "", "Lid/dana/feeds/ui/model/FriendModel;", "Ljava/util/List;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "lookAheadTest", "I", "getErrorConfigVersion", "p2", "p3", "p4", "p5", "<init>", "(ILid/dana/social/model/FeedModel;Lid/dana/social/model/GroupedFeedModel;Ljava/util/List;Lid/dana/feeds/ui/model/RelationshipItemModel;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeedViewHolderModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public GroupedFeedModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean PlaceComponentResult;
    public FeedModel MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final RelationshipItemModel getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<FriendModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final int getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof FeedViewHolderModel) {
            FeedViewHolderModel feedViewHolderModel = (FeedViewHolderModel) p0;
            return this.getErrorConfigVersion == feedViewHolderModel.getErrorConfigVersion && Intrinsics.areEqual(this.MyBillsEntityDataFactory, feedViewHolderModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, feedViewHolderModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, feedViewHolderModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, feedViewHolderModel.getAuthRequestContext) && this.PlaceComponentResult == feedViewHolderModel.PlaceComponentResult;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int i = this.getErrorConfigVersion;
        FeedModel feedModel = this.MyBillsEntityDataFactory;
        int hashCode = feedModel == null ? 0 : feedModel.hashCode();
        GroupedFeedModel groupedFeedModel = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = groupedFeedModel == null ? 0 : groupedFeedModel.hashCode();
        int hashCode3 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        RelationshipItemModel relationshipItemModel = this.getAuthRequestContext;
        int hashCode4 = relationshipItemModel != null ? relationshipItemModel.hashCode() : 0;
        boolean z = this.PlaceComponentResult;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (((((((((i * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedViewHolderModel(getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    private FeedViewHolderModel(int i, FeedModel feedModel, GroupedFeedModel groupedFeedModel, List<FriendModel> list, RelationshipItemModel relationshipItemModel, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.getErrorConfigVersion = i;
        this.MyBillsEntityDataFactory = feedModel;
        this.BuiltInFictitiousFunctionClassFactory = groupedFeedModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.getAuthRequestContext = relationshipItemModel;
        this.PlaceComponentResult = z;
    }

    public /* synthetic */ FeedViewHolderModel(int i, FeedModel feedModel, GroupedFeedModel groupedFeedModel, List list, RelationshipItemModel relationshipItemModel, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : feedModel, (i2 & 4) != 0 ? null : groupedFeedModel, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) == 0 ? relationshipItemModel : null, (i2 & 32) != 0 ? false : z);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public final SocialFeedModel BuiltInFictitiousFunctionClassFactory() {
        FeedModel feedModel;
        String str;
        int i;
        int i2;
        int i3;
        HashMap hashMap;
        int i4;
        GroupedFeedModel groupedFeedModel = this.BuiltInFictitiousFunctionClassFactory;
        if (groupedFeedModel == null || (feedModel = (FeedModel) CollectionsKt.firstOrNull((List) groupedFeedModel.BuiltInFictitiousFunctionClassFactory)) == null) {
            FeedModel feedModel2 = this.MyBillsEntityDataFactory;
            if (feedModel2 != null) {
                return new SocialFeedModel(feedModel2.NetworkUserEntityData$$ExternalSyntheticLambda1, feedModel2.NetworkUserEntityData$$ExternalSyntheticLambda2, feedModel2.scheduleImpl, feedModel2.isLayoutRequested, feedModel2.PrepareContext, feedModel2.lookAheadTest, feedModel2.getErrorConfigVersion, feedModel2.PlaceComponentResult, 0, null, 0, 1792, null);
            }
            return new SocialFeedModel(null, null, null, null, null, null, null, null, 0, null, 0, 2047, null);
        }
        String str2 = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        GroupedFeedModel groupedFeedModel2 = this.BuiltInFictitiousFunctionClassFactory;
        String str3 = null;
        if (groupedFeedModel2 != null) {
            HashMap hashMap2 = (HashMap) CollectionsKt.getOrNull(groupedFeedModel2.getErrorConfigVersion, 0);
            str = hashMap2 != null ? ExtendInfoUtilKt.getProfileAvatar(hashMap2) : null;
        } else {
            str = null;
        }
        String str4 = feedModel.scheduleImpl;
        String str5 = feedModel.isLayoutRequested;
        String str6 = feedModel.PrepareContext;
        HashMap<String, String> hashMap3 = feedModel.lookAheadTest;
        Long l = feedModel.getErrorConfigVersion;
        String str7 = feedModel.PlaceComponentResult;
        GroupedFeedModel groupedFeedModel3 = this.BuiltInFictitiousFunctionClassFactory;
        if (groupedFeedModel3 != null) {
            i = (!groupedFeedModel3.PlaceComponentResult() || (i4 = groupedFeedModel3.KClassImpl$Data$declaredNonStaticMembers$2) <= 1) ? groupedFeedModel3.KClassImpl$Data$declaredNonStaticMembers$2 : i4 - 1;
        } else {
            i = 1;
        }
        GroupedFeedModel groupedFeedModel4 = this.BuiltInFictitiousFunctionClassFactory;
        if (groupedFeedModel4 != null && (hashMap = (HashMap) CollectionsKt.getOrNull(groupedFeedModel4.getErrorConfigVersion, 1)) != null) {
            str3 = ExtendInfoUtilKt.getProfileAvatar(hashMap);
        }
        String str8 = str3;
        GroupedFeedModel groupedFeedModel5 = this.BuiltInFictitiousFunctionClassFactory;
        if (groupedFeedModel5 != null) {
            i2 = ((!groupedFeedModel5.PlaceComponentResult() || (i3 = groupedFeedModel5.KClassImpl$Data$declaredNonStaticMembers$2) <= 1) ? groupedFeedModel5.KClassImpl$Data$declaredNonStaticMembers$2 : i3 + (-1)) > 1 ? 2 : 1;
        } else {
            i2 = 1;
        }
        return new SocialFeedModel(str2, str, str4, str5, str6, hashMap3, l, str7, i, str8, i2);
    }

    public final FeedRegexData getAuthRequestContext(Context p0, SocialFeedClickListener p1) {
        HashMap<String, String> hashMap;
        HashMap<String, String> hashMap2;
        List<FeedModel> list;
        FeedModel feedModel;
        List<FeedModel> list2;
        FeedModel feedModel2;
        List<FeedModel> list3;
        FeedModel feedModel3;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        FeedModel feedModel4 = this.MyBillsEntityDataFactory;
        if (feedModel4 == null) {
            GroupedFeedModel groupedFeedModel = this.BuiltInFictitiousFunctionClassFactory;
            String str = (groupedFeedModel == null || (list3 = groupedFeedModel.BuiltInFictitiousFunctionClassFactory) == null || (feedModel3 = (FeedModel) CollectionsKt.firstOrNull((List) list3)) == null) ? null : feedModel3.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str2 = str == null ? "" : str;
            GroupedFeedModel groupedFeedModel2 = this.BuiltInFictitiousFunctionClassFactory;
            String str3 = (groupedFeedModel2 == null || (list2 = groupedFeedModel2.BuiltInFictitiousFunctionClassFactory) == null || (feedModel2 = (FeedModel) CollectionsKt.firstOrNull((List) list2)) == null) ? null : feedModel2.scheduleImpl;
            String str4 = str3 == null ? "" : str3;
            GroupedFeedModel groupedFeedModel3 = this.BuiltInFictitiousFunctionClassFactory;
            if (groupedFeedModel3 == null || (hashMap2 = groupedFeedModel3.PlaceComponentResult) == null) {
                hashMap2 = new HashMap<>();
            }
            HashMap<String, String> hashMap3 = hashMap2;
            FeedViewHolderModel$toFeedRegexData$1 feedViewHolderModel$toFeedRegexData$1 = new FeedViewHolderModel$toFeedRegexData$1(p1);
            GroupedFeedModel groupedFeedModel4 = this.BuiltInFictitiousFunctionClassFactory;
            if (groupedFeedModel4 != null && (list = groupedFeedModel4.BuiltInFictitiousFunctionClassFactory) != null && (feedModel = (FeedModel) CollectionsKt.firstOrNull((List) list)) != null) {
                r2 = feedModel.PlaceComponentResult;
            }
            return new FeedRegexData(str2, str4, hashMap3, feedViewHolderModel$toFeedRegexData$1, p0, r2 == null ? "" : r2);
        }
        String str5 = feedModel4 != null ? feedModel4.NetworkUserEntityData$$ExternalSyntheticLambda1 : null;
        String str6 = str5 == null ? "" : str5;
        FeedModel feedModel5 = this.MyBillsEntityDataFactory;
        String str7 = feedModel5 != null ? feedModel5.scheduleImpl : null;
        String str8 = str7 == null ? "" : str7;
        FeedModel feedModel6 = this.MyBillsEntityDataFactory;
        if (feedModel6 == null || (hashMap = feedModel6.lookAheadTest) == null) {
            hashMap = new HashMap<>();
        }
        HashMap<String, String> hashMap4 = hashMap;
        FeedViewHolderModel$toFeedRegexData$2 feedViewHolderModel$toFeedRegexData$2 = new FeedViewHolderModel$toFeedRegexData$2(p1);
        FeedModel feedModel7 = this.MyBillsEntityDataFactory;
        r2 = feedModel7 != null ? feedModel7.PlaceComponentResult : null;
        return new FeedRegexData(str6, str8, hashMap4, feedViewHolderModel$toFeedRegexData$2, p0, r2 == null ? "" : r2);
    }

    public final boolean getAuthRequestContext() {
        return this.getAuthRequestContext != null;
    }

    public final boolean getAuthRequestContext(String p0) {
        FeedModel feedModel;
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.getErrorConfigVersion == 1 && (feedModel = this.MyBillsEntityDataFactory) != null) {
            Intrinsics.checkNotNull(feedModel);
            String str = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (!(str == null || str.length() == 0)) {
                FeedModel feedModel2 = this.MyBillsEntityDataFactory;
                Intrinsics.checkNotNull(feedModel2);
                if (StringsKt.equals$default(feedModel2.NetworkUserEntityData$$ExternalSyntheticLambda4, p0, false, 2, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/social/model/FeedViewHolderModel$Companion;", "", "", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "p0", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "p1", "Lid/dana/social/model/FeedViewHolderModel;", "getAuthRequestContext", "(Ljava/util/List;Lid/dana/feeds/ui/model/MyFeedHeaderModel;)Ljava/util/List;", "(Lid/dana/feeds/domain/share/model/PreviewActivityData;Lid/dana/feeds/ui/model/MyFeedHeaderModel;)Lid/dana/social/model/FeedViewHolderModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static FeedViewHolderModel getAuthRequestContext(PreviewActivityData p0, MyFeedHeaderModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            FeedModel.Companion companion = FeedModel.INSTANCE;
            return new FeedViewHolderModel(5, FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(p0.getShareFeedRequestId(), p0.getContent(), "", p1, p0.getExtendInfo(), p0.getWidget(), null, 64), null, null, null, false, 60, null);
        }

        public static List<FeedViewHolderModel> getAuthRequestContext(List<PreviewActivityData> p0, MyFeedHeaderModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            List<PreviewActivityData> list = p0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (PreviewActivityData previewActivityData : list) {
                Companion companion = FeedViewHolderModel.INSTANCE;
                arrayList.add(getAuthRequestContext(previewActivityData, p1));
            }
            return arrayList;
        }
    }
}
