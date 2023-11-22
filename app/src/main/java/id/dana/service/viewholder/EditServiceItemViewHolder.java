package id.dana.service.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.model.ThirdPartyService;
import id.dana.service.adapter.ServiceAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/service/viewholder/EditServiceItemViewHolder;", "Lid/dana/service/viewholder/ServiceItemViewHolder;", "Lid/dana/model/ThirdPartyService;", "p0", "", "getAuthRequestContext", "(Lid/dana/model/ThirdPartyService;)V", "Landroid/view/ViewGroup;", "Lid/dana/service/adapter/ServiceAdapter$EditItemBadgeLookup;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/service/adapter/ServiceAdapter$EditItemBadgeLookup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EditServiceItemViewHolder extends ServiceItemViewHolder {
    @Override // id.dana.service.viewholder.ServiceItemViewHolder, id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ThirdPartyService thirdPartyService) {
        bindData(thirdPartyService);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditServiceItemViewHolder(ViewGroup viewGroup, ServiceAdapter.EditItemBadgeLookup editItemBadgeLookup) {
        super(viewGroup, editItemBadgeLookup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(editItemBadgeLookup, "");
    }

    @Override // id.dana.service.viewholder.ServiceItemViewHolder
    /* renamed from: getAuthRequestContext */
    public final void bindData(ThirdPartyService p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        TextView textView = (TextView) this.itemView.findViewById(R.id.custom_gridview_text);
        if (textView != null) {
            textView.setText(getBuiltInFictitiousFunctionClassFactory() ? R.string.services_save : R.string.services_edit);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.custom_gridview_image);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(0);
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.ic_service_selector_edit_save);
            } else {
                appCompatImageView.setImageResource(R.drawable.ic_service_selector_edit_save);
            }
            appCompatImageView.setSelected(getBuiltInFictitiousFunctionClassFactory());
        }
    }
}
