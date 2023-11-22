package id.dana.social.model;

import id.dana.feeds.domain.detail.model.FeedCommentResult;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.social.state.ViewHolderState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB+\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0012\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/social/model/FeedCommentResultModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/social/state/ViewHolderState$Item;", "Lid/dana/feeds/ui/model/FeedCommentModel;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "p1", "p2", "<init>", "(Ljava/util/List;Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeedCommentResultModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<ViewHolderState.Item<FeedCommentModel>> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof FeedCommentResultModel) {
            FeedCommentResultModel feedCommentResultModel = (FeedCommentResultModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, feedCommentResultModel.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, feedCommentResultModel.MyBillsEntityDataFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2 == feedCommentResultModel.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        int hashCode2 = this.MyBillsEntityDataFactory.hashCode();
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedCommentResultModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public FeedCommentResultModel(List<ViewHolderState.Item<FeedCommentModel>> list, String str, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = list;
        this.MyBillsEntityDataFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/model/FeedCommentResultModel$Companion;", "", "Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "p0", "Lid/dana/social/model/FeedCommentResultModel;", "MyBillsEntityDataFactory", "(Lid/dana/feeds/domain/detail/model/FeedCommentResult;)Lid/dana/social/model/FeedCommentResultModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static FeedCommentResultModel MyBillsEntityDataFactory(FeedCommentResult p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new FeedCommentResultModel(FeedCommentResultModelKt.PlaceComponentResult(p0.getComments()), p0.getMaxId(), p0.getHasNext());
        }
    }
}
