package id.dana.social.model;

import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.social.state.MyFeedHighlightState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB=\u0012\u0006\u0010\u0002\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\t\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\nR\u0012\u0010\u0011\u001a\u00020\u0003X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0011\u0010\u000e\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0017X\u0007¢\u0006\u0006\n\u0004\b\t\u0010\u0018"}, d2 = {"Lid/dana/social/model/MyFeedHighlightModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "MyBillsEntityDataFactory", "()Z", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "Ljava/lang/String;", "Lkotlin/Function0;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function0;", "Lid/dana/social/state/MyFeedHighlightState;", "Lid/dana/social/state/MyFeedHighlightState;", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/social/state/MyFeedHighlightState;ZLjava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MyFeedHighlightModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final MyFeedHighlightState KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MyFeedHighlightModel) {
            MyFeedHighlightModel myFeedHighlightModel = (MyFeedHighlightModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, myFeedHighlightModel.KClassImpl$Data$declaredNonStaticMembers$2) && this.MyBillsEntityDataFactory == myFeedHighlightModel.MyBillsEntityDataFactory && Intrinsics.areEqual(this.getAuthRequestContext, myFeedHighlightModel.getAuthRequestContext) && this.PlaceComponentResult == myFeedHighlightModel.PlaceComponentResult && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, myFeedHighlightModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        boolean z = this.MyBillsEntityDataFactory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = this.getAuthRequestContext.hashCode();
        boolean z2 = this.PlaceComponentResult;
        return (((((((hashCode * 31) + i) * 31) + hashCode2) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyFeedHighlightModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    private MyFeedHighlightModel(MyFeedHighlightState myFeedHighlightState, boolean z, String str, boolean z2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(myFeedHighlightState, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = myFeedHighlightState;
        this.MyBillsEntityDataFactory = z;
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = z2;
        this.BuiltInFictitiousFunctionClassFactory = function0;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public /* synthetic */ MyFeedHighlightModel(MyFeedHighlightState myFeedHighlightState, boolean z, String str, boolean z2, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(myFeedHighlightState, (i & 2) != 0 ? false : z, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? new Function0<Unit>() { // from class: id.dana.social.model.MyFeedHighlightModel.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass1);
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory && !this.PlaceComponentResult;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0002¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/social/model/MyFeedHighlightModel$Companion;", "", "", "Lid/dana/social/model/MyFeedHighlightModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "p0", "PlaceComponentResult", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)Lid/dana/social/model/MyFeedHighlightModel;", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "Lid/dana/social/model/FeedHighlightModel;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static MyFeedHighlightModel PlaceComponentResult(SocialFeed p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Companion companion = MyFeedHighlightModel.INSTANCE;
            return new MyFeedHighlightModel(new MyFeedHighlightState.Success(getAuthRequestContext(p0.getActivities())), p0.getHasMore(), p0.getMaxId(), false, null, 24, null);
        }

        private static List<FeedHighlightModel> getAuthRequestContext(List<ActivityResponse> list) {
            LinkedHashMap linkedHashMap;
            List<ActivityResponse> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (ActivityResponse activityResponse : list2) {
                String id2 = activityResponse.getId();
                String str = id2 == null ? "" : id2;
                String iconUrl = activityResponse.getIconUrl();
                String str2 = iconUrl == null ? "" : iconUrl;
                String content = activityResponse.getContent();
                String str3 = content == null ? "" : content;
                boolean read = activityResponse.getRead();
                HashMap<String, String> extendInfo = activityResponse.getExtendInfo();
                if (extendInfo != null) {
                    linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, String> entry : extendInfo.entrySet()) {
                        if (entry.getValue() != null) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                } else {
                    linkedHashMap = null;
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap instanceof HashMap ? linkedHashMap : null;
                HashMap hashMap = linkedHashMap2 == null ? new HashMap() : linkedHashMap2;
                String contentType = activityResponse.getContentType();
                arrayList.add(new FeedHighlightModel(str, str2, str3, read, hashMap, 0, contentType == null ? "" : contentType, 32, null));
            }
            return arrayList;
        }

        @JvmStatic
        public static List<MyFeedHighlightModel> KClassImpl$Data$declaredNonStaticMembers$2() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MyFeedHighlightModel(MyFeedHighlightState.Disabled.INSTANCE, false, null, false, null, 30, null));
            return arrayList;
        }
    }
}
