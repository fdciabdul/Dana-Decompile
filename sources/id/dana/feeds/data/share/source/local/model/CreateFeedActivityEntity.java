package id.dana.feeds.data.share.source.local.model;

import id.dana.feeds.data.share.source.network.request.CreateActivityRequest;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\u0011\u001a\u00020\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/feeds/data/share/source/local/model/CreateFeedActivityEntity;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;", "getAuthRequestContext", "Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "PlaceComponentResult", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "<init>", "(Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;Ljava/lang/String;Lid/dana/feeds/domain/timeline/enums/FeedActivityState;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateFeedActivityEntity {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public FeedActivityState PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final CreateActivityRequest KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CreateFeedActivityEntity) {
            CreateFeedActivityEntity createFeedActivityEntity = (CreateFeedActivityEntity) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, createFeedActivityEntity.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, createFeedActivityEntity.BuiltInFictitiousFunctionClassFactory) && this.PlaceComponentResult == createFeedActivityEntity.PlaceComponentResult;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateFeedActivityEntity(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    private CreateFeedActivityEntity(CreateActivityRequest createActivityRequest, String str, FeedActivityState feedActivityState) {
        Intrinsics.checkNotNullParameter(createActivityRequest, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(feedActivityState, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = createActivityRequest;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = feedActivityState;
    }

    public /* synthetic */ CreateFeedActivityEntity(CreateActivityRequest createActivityRequest, String str, FeedActivityState feedActivityState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(createActivityRequest, str, (i & 4) != 0 ? FeedActivityState.INIT : feedActivityState);
    }
}
