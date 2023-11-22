package id.dana.animation.banner;

import android.view.View;
import android.view.ViewGroup;
import id.dana.animation.reminderbanner.ReminderBannerView;
import id.dana.model.CdpContentModel;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.richview.CircularPagerAdapter;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes8.dex */
public class PromotionBannerAdapter extends CircularPagerAdapter<CdpContentModel> {
    private boolean DatabaseTableConfigUtil;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    public List<BaseSimpleView> MyBillsEntityDataFactory;
    private final int moveToNextValue;
    private boolean scheduleImpl;

    @Override // id.dana.richview.CircularPagerAdapter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<CdpContentModel> list) {
        if (list != null) {
            this.MyBillsEntityDataFactory.clear();
            String obj = UUID.randomUUID().toString();
            for (CdpContentModel cdpContentModel : list) {
                if (cdpContentModel.DatabaseTableConfigUtil.equalsIgnoreCase("PRE") || cdpContentModel.DatabaseTableConfigUtil.equalsIgnoreCase("POST") || cdpContentModel.DatabaseTableConfigUtil.equalsIgnoreCase("shimmerReminder")) {
                    this.MyBillsEntityDataFactory.add(new ReminderBannerView(cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda1, cdpContentModel.GetContactSyncConfig, cdpContentModel.DatabaseTableConfigUtil));
                } else {
                    this.MyBillsEntityDataFactory.add(new SimplePromotionView(cdpContentModel, this.scheduleImpl, this.DatabaseTableConfigUtil, this.KClassImpl$Data$declaredNonStaticMembers$2, this.moveToNextValue, obj));
                }
            }
            super.KClassImpl$Data$declaredNonStaticMembers$2(list);
        }
    }

    @Override // id.dana.richview.CircularPagerAdapter
    public final View PlaceComponentResult(ViewGroup viewGroup, int i) {
        this.MyBillsEntityDataFactory.get(i).KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, viewGroup);
        View view = this.MyBillsEntityDataFactory.get(i).MyBillsEntityDataFactory;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }
}
