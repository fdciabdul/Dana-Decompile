package id.dana.danapoly.ui.dailycheck.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.component.utils.SizeUtil;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ItemDailyCheckPointBinding;
import id.dana.danapoly.ui.dailycheck.adapter.DailyCheckViewHolder;
import id.dana.danapoly.ui.model.DailyCheckItemModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0003X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckViewHolder;", "", "getItemCount", "()I", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "", "Lid/dana/danapoly/ui/model/DailyCheckItemModel;", "PlaceComponentResult", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyCheckAdapter extends RecyclerView.Adapter<DailyCheckViewHolder> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public List<DailyCheckItemModel> KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.danapoly.ui.dailycheck.adapter.DailyCheckAdapter$itemCheckPointWidth$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(DailyCheckAdapter.KClassImpl$Data$declaredNonStaticMembers$2());
        }
    });

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(DailyCheckViewHolder dailyCheckViewHolder, int i) {
        DailyCheckViewHolder dailyCheckViewHolder2 = dailyCheckViewHolder;
        Intrinsics.checkNotNullParameter(dailyCheckViewHolder2, "");
        if (i != -1) {
            DailyCheckItemModel dailyCheckItemModel = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
            Intrinsics.checkNotNullParameter(dailyCheckItemModel, "");
            int i2 = DailyCheckViewHolder.WhenMappings.getAuthRequestContext[dailyCheckItemModel.getState().ordinal()];
            if (i2 == 1) {
                dailyCheckViewHolder2.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setBackground(ContextCompat.PlaceComponentResult(dailyCheckViewHolder2.PlaceComponentResult, R.drawable.bg_rounded8dp_blue60));
                TextView textView = dailyCheckViewHolder2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
                StringBuilder sb = new StringBuilder();
                sb.append('+');
                sb.append(dailyCheckItemModel.getPoint());
                textView.setText(sb.toString());
                dailyCheckViewHolder2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(dailyCheckViewHolder2.PlaceComponentResult, R.color.NetworkUserEntityData$$ExternalSyntheticLambda2));
                dailyCheckViewHolder2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.setImageDrawable(ContextCompat.PlaceComponentResult(dailyCheckViewHolder2.PlaceComponentResult, R.drawable.res_0x7f080899_networkuserentitydata_externalsyntheticlambda3));
                TextView textView2 = dailyCheckViewHolder2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(textView2, "");
                textView2.setVisibility(0);
                TextView textView3 = dailyCheckViewHolder2.MyBillsEntityDataFactory.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(textView3, "");
                textView3.setVisibility(4);
                FrameLayout frameLayout = dailyCheckViewHolder2.MyBillsEntityDataFactory.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "");
                frameLayout.setVisibility(4);
            } else if (i2 == 2) {
                dailyCheckViewHolder2.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setBackground(ContextCompat.PlaceComponentResult(dailyCheckViewHolder2.PlaceComponentResult, R.drawable.bg_daily_check_active));
                TextView textView4 = dailyCheckViewHolder2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
                StringBuilder sb2 = new StringBuilder();
                sb2.append('+');
                sb2.append(dailyCheckItemModel.getPoint());
                textView4.setText(sb2.toString());
                dailyCheckViewHolder2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(dailyCheckViewHolder2.PlaceComponentResult, R.color.NetworkUserEntityData$$ExternalSyntheticLambda2));
                dailyCheckViewHolder2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.setImageDrawable(ContextCompat.PlaceComponentResult(dailyCheckViewHolder2.PlaceComponentResult, R.drawable.res_0x7f080899_networkuserentitydata_externalsyntheticlambda3));
                TextView textView5 = dailyCheckViewHolder2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(textView5, "");
                textView5.setVisibility(0);
                TextView textView6 = dailyCheckViewHolder2.MyBillsEntityDataFactory.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(textView6, "");
                textView6.setVisibility(4);
                FrameLayout frameLayout2 = dailyCheckViewHolder2.MyBillsEntityDataFactory.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "");
                frameLayout2.setVisibility(0);
            } else if (i2 == 3) {
                dailyCheckViewHolder2.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setBackground(ContextCompat.PlaceComponentResult(dailyCheckViewHolder2.PlaceComponentResult, R.drawable.bg_daily_check_missed));
                dailyCheckViewHolder2.MyBillsEntityDataFactory.scheduleImpl.setText(dailyCheckViewHolder2.PlaceComponentResult.getString(R.string.res_0x7f130548_networkuserentitydata_externalsyntheticlambda8));
                dailyCheckViewHolder2.MyBillsEntityDataFactory.scheduleImpl.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(dailyCheckViewHolder2.PlaceComponentResult, R.color.initRecordTimeStamp));
                dailyCheckViewHolder2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.setImageDrawable(ContextCompat.PlaceComponentResult(dailyCheckViewHolder2.PlaceComponentResult, R.drawable.res_0x7f08089b_networkuserentitydata_externalsyntheticlambda4));
                TextView textView7 = dailyCheckViewHolder2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(textView7, "");
                textView7.setVisibility(4);
                TextView textView8 = dailyCheckViewHolder2.MyBillsEntityDataFactory.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(textView8, "");
                textView8.setVisibility(0);
                FrameLayout frameLayout3 = dailyCheckViewHolder2.MyBillsEntityDataFactory.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "");
                frameLayout3.setVisibility(4);
            } else if (i2 == 4) {
                dailyCheckViewHolder2.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setBackground(ContextCompat.PlaceComponentResult(dailyCheckViewHolder2.PlaceComponentResult, R.drawable.bg_rounded8dp_blue40));
                dailyCheckViewHolder2.MyBillsEntityDataFactory.scheduleImpl.setText(dailyCheckViewHolder2.PlaceComponentResult.getString(R.string.daily_check_in_collected));
                dailyCheckViewHolder2.MyBillsEntityDataFactory.scheduleImpl.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(dailyCheckViewHolder2.PlaceComponentResult, R.color.NetworkUserEntityData$$ExternalSyntheticLambda2));
                dailyCheckViewHolder2.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.setImageDrawable(ContextCompat.PlaceComponentResult(dailyCheckViewHolder2.PlaceComponentResult, R.drawable.res_0x7f08089a_networkuserentitydata_externalsyntheticlambda6));
                TextView textView9 = dailyCheckViewHolder2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(textView9, "");
                textView9.setVisibility(4);
                TextView textView10 = dailyCheckViewHolder2.MyBillsEntityDataFactory.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(textView10, "");
                textView10.setVisibility(0);
                FrameLayout frameLayout4 = dailyCheckViewHolder2.MyBillsEntityDataFactory.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(frameLayout4, "");
                frameLayout4.setVisibility(4);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ DailyCheckViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemDailyCheckPointBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemDailyCheckPointBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return new DailyCheckViewHolder(context, KClassImpl$Data$declaredNonStaticMembers$2, ((Number) this.BuiltInFictitiousFunctionClassFactory.getValue()).intValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.size();
    }

    public static final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2() {
        return (Resources.getSystem().getDisplayMetrics().widthPixels / 5) - SizeUtil.PlaceComponentResult(16);
    }
}
