package id.dana.promocenter.viewholders;

import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promocenter.model.PromoSectionModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H$¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/promocenter/viewholders/BasePromoCenterSectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promocenter/model/PromoSectionModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/promocenter/model/PromoSectionModel;)V", "Lid/dana/promocenter/model/PromoSectionModel$State;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/promocenter/model/PromoSectionModel$State;)V", "Landroid/view/ViewGroup;", "", "p1", "<init>", "(Landroid/view/ViewGroup;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BasePromoCenterSectionViewHolder extends BaseRecyclerViewHolder<PromoSectionModel> {
    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(PromoSectionModel.State p0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePromoCenterSectionViewHolder(ViewGroup viewGroup, int i) {
        super(viewGroup.getContext(), i, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public void bindData(PromoSectionModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.bindData(p0);
        addDisposable(p0.getAuthRequestContext.subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.promocenter.viewholders.BasePromoCenterSectionViewHolder$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BasePromoCenterSectionViewHolder.getAuthRequestContext(BasePromoCenterSectionViewHolder.this, (PromoSectionModel.State) obj);
            }
        }));
    }

    public static /* synthetic */ void getAuthRequestContext(BasePromoCenterSectionViewHolder basePromoCenterSectionViewHolder, PromoSectionModel.State state) {
        Intrinsics.checkNotNullParameter(basePromoCenterSectionViewHolder, "");
        Intrinsics.checkNotNullExpressionValue(state, "");
        basePromoCenterSectionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(state);
    }
}
