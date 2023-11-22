package id.dana.richview.servicescard.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.richview.servicescard.adapter.viewholder.ServiceShimmerViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0014\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018"}, d2 = {"Lid/dana/richview/servicescard/adapter/ShimmerServiceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/richview/servicescard/adapter/viewholder/ServiceShimmerViewHolder;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "", "BuiltInFictitiousFunctionClassFactory", "Z", "MyBillsEntityDataFactory", "I", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "scheduleImpl", "lookAheadTest", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "", LogConstants.RESULT_FALSE, "moveToNextValue", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShimmerServiceAdapter extends RecyclerView.Adapter<ServiceShimmerViewHolder> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    boolean MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    int PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    int getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    int KClassImpl$Data$declaredNonStaticMembers$2;
    int getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    Drawable scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    float moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    int lookAheadTest;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return p0 == 0 ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(ServiceShimmerViewHolder serviceShimmerViewHolder, int i) {
        ServiceShimmerViewHolder serviceShimmerViewHolder2 = serviceShimmerViewHolder;
        Intrinsics.checkNotNullParameter(serviceShimmerViewHolder2, "");
        serviceShimmerViewHolder2.MyBillsEntityDataFactory.startShimmerAnimation();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ ServiceShimmerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        } else if (i == 1) {
            i2 = this.BuiltInFictitiousFunctionClassFactory;
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "");
        ServiceShimmerViewHolder serviceShimmerViewHolder = new ServiceShimmerViewHolder(from, viewGroup, i2);
        serviceShimmerViewHolder.MyBillsEntityDataFactory.setShimmerColor(this.getErrorConfigVersion);
        serviceShimmerViewHolder.MyBillsEntityDataFactory.setShimmerAngle(this.getAuthRequestContext);
        serviceShimmerViewHolder.MyBillsEntityDataFactory.setMaskWidth(this.moveToNextValue);
        Drawable drawable = this.scheduleImpl;
        if (drawable != null) {
            serviceShimmerViewHolder.MyBillsEntityDataFactory.setBackground(drawable);
        }
        serviceShimmerViewHolder.MyBillsEntityDataFactory.setShimmerAnimationDuration(this.lookAheadTest);
        serviceShimmerViewHolder.MyBillsEntityDataFactory.setAnimationReversed(this.MyBillsEntityDataFactory);
        return serviceShimmerViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount  reason: from getter */
    public final int getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
