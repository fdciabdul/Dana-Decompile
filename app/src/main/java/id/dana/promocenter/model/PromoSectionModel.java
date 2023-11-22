package id.dana.promocenter.model;

import androidx.recyclerview.widget.RecyclerView;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB)\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR#\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0015X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019"}, d2 = {"Lid/dana/promocenter/model/PromoSectionModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "Lid/dana/promocenter/model/PromoSectionModel$State;", "PlaceComponentResult", "()Lid/dana/promocenter/model/PromoSectionModel$State;", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promocenter/model/PromoModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/base/BaseRecyclerViewAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getAuthRequestContext", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "Lio/reactivex/subjects/BehaviorSubject;", "Lio/reactivex/subjects/BehaviorSubject;", "p1", "<init>", "(Lid/dana/base/BaseRecyclerViewAdapter;Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PromoSectionModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final BaseRecyclerViewAdapter<BaseRecyclerViewHolder<PromoModel>, PromoModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final BehaviorSubject<State> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final RecyclerView.LayoutManager PlaceComponentResult;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007"}, d2 = {"Lid/dana/promocenter/model/PromoSectionModel$State;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_SHOW_LOADING", "STATE_HIDE_LOADING", "STATE_SHOW", "STATE_HIDDEN"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum State {
        STATE_SHOW_LOADING,
        STATE_HIDE_LOADING,
        STATE_SHOW,
        STATE_HIDDEN
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PromoSectionModel) {
            PromoSectionModel promoSectionModel = (PromoSectionModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, promoSectionModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, promoSectionModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoSectionModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public PromoSectionModel(BaseRecyclerViewAdapter<BaseRecyclerViewHolder<PromoModel>, PromoModel> baseRecyclerViewAdapter, RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(baseRecyclerViewAdapter, "");
        Intrinsics.checkNotNullParameter(layoutManager, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = baseRecyclerViewAdapter;
        this.PlaceComponentResult = layoutManager;
        BehaviorSubject<State> authRequestContext = BehaviorSubject.getAuthRequestContext(State.STATE_SHOW_LOADING);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        this.getAuthRequestContext = authRequestContext;
    }

    public final State PlaceComponentResult() {
        Object obj = this.getAuthRequestContext.getErrorConfigVersion.get();
        return (State) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
    }
}
