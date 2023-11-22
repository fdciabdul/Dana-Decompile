package id.dana.promodiscovery.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promodiscovery.model.ActionButtonModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/promodiscovery/viewholder/ActionButtonViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/ActionButtonModel;", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActionButtonViewHolder extends BaseRecyclerViewHolder<ActionButtonModel> {
    public final ViewGroup MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ActionButtonModel actionButtonModel) {
        final ActionButtonModel actionButtonModel2 = actionButtonModel;
        if (actionButtonModel2 != null) {
            ((AppCompatTextView) this.itemView.findViewById(R.id.setDrawValueAboveBar)).setText(actionButtonModel2.PlaceComponentResult);
            ((AppCompatTextView) this.itemView.findViewById(R.id.paramsForAnalyticsIntent)).setText(actionButtonModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.BottomSheetType);
            int i = actionButtonModel2.BuiltInFictitiousFunctionClassFactory;
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            } else {
                appCompatImageView.setImageResource(i);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.ActionButtonViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ActionButtonViewHolder.getAuthRequestContext(ActionButtonModel.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionButtonViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.action_button_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.MyBillsEntityDataFactory = viewGroup;
    }

    public static /* synthetic */ void getAuthRequestContext(ActionButtonModel actionButtonModel) {
        Intrinsics.checkNotNullParameter(actionButtonModel, "");
        actionButtonModel.MyBillsEntityDataFactory.invoke();
    }
}
