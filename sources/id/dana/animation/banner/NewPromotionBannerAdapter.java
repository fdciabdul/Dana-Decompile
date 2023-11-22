package id.dana.animation.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import id.dana.animation.subscription.SubscriptionBannerView;
import id.dana.model.CdpContentModel;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.richview.CircularPagerAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class NewPromotionBannerAdapter extends CircularPagerAdapter<CdpContentModel> {
    private final List<BaseSimpleView> DatabaseTableConfigUtil;
    public OnSubscriptionItemClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    private final View.OnTouchListener MyBillsEntityDataFactory;
    private final boolean moveToNextValue;
    private final boolean scheduleImpl;

    /* loaded from: classes5.dex */
    public interface OnSubscriptionItemClickListener {
        void getAuthRequestContext(CdpContentModel cdpContentModel);
    }

    public NewPromotionBannerAdapter(Context context, View.OnTouchListener onTouchListener, boolean z, boolean z2) {
        super(context, true);
        this.DatabaseTableConfigUtil = new ArrayList();
        this.moveToNextValue = z;
        this.scheduleImpl = z2;
        this.MyBillsEntityDataFactory = onTouchListener;
    }

    @Override // id.dana.richview.CircularPagerAdapter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<CdpContentModel> list) {
        if (list != null) {
            String obj = UUID.randomUUID().toString();
            this.DatabaseTableConfigUtil.clear();
            ArrayList arrayList = new ArrayList();
            for (CdpContentModel cdpContentModel : list) {
                if (!cdpContentModel.DatabaseTableConfigUtil.equalsIgnoreCase("SUBSCRIPTION")) {
                    arrayList.add(cdpContentModel);
                    this.DatabaseTableConfigUtil.add(new NewSimplePromotionView(this.MyBillsEntityDataFactory, cdpContentModel, this.moveToNextValue, this.scheduleImpl, obj));
                } else {
                    List<CdpContentModel> list2 = cdpContentModel.PlaceComponentResult;
                    if (list2 != null) {
                        arrayList.add(cdpContentModel);
                        this.DatabaseTableConfigUtil.add(new SubscriptionBannerView(list2, this.KClassImpl$Data$declaredNonStaticMembers$2));
                    }
                }
            }
            super.KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
        }
    }

    @Override // id.dana.richview.CircularPagerAdapter
    public final View PlaceComponentResult(ViewGroup viewGroup, int i) {
        this.DatabaseTableConfigUtil.get(i).KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, viewGroup);
        View view = this.DatabaseTableConfigUtil.get(i).MyBillsEntityDataFactory;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    public final boolean getAuthRequestContext(int i) {
        return MyBillsEntityDataFactory() == null || MyBillsEntityDataFactory().isEmpty() || i >= MyBillsEntityDataFactory().size() || MyBillsEntityDataFactory().get(i) == null;
    }
}
