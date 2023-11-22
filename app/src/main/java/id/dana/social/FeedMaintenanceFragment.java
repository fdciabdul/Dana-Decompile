package id.dana.social;

import android.view.View;
import android.widget.TextView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.BaseWithToolbarFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/FeedMaintenanceFragment;", "Lid/dana/base/BaseWithToolbarFragment;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/view/View;", "p0", "onClickLeftMenuButton", "(Landroid/view/View;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeedMaintenanceFragment extends BaseWithToolbarFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    @JvmStatic
    public static final FeedMaintenanceFragment MyBillsEntityDataFactory() {
        return Companion.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_feed_maintenance;
    }

    @Override // id.dana.base.BaseWithToolbarFragment
    public final void onClickLeftMenuButton(View p0) {
        getBaseActivity().onBackPressed();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/social/FeedMaintenanceFragment$Companion;", "", "Lid/dana/social/FeedMaintenanceFragment;", "MyBillsEntityDataFactory", "()Lid/dana/social/FeedMaintenanceFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static FeedMaintenanceFragment MyBillsEntityDataFactory() {
            return new FeedMaintenanceFragment();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeedMaintenanceFragment feedMaintenanceFragment) {
        Intrinsics.checkNotNullParameter(feedMaintenanceFragment, "");
        feedMaintenanceFragment.getBaseActivity().onBackPressed();
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        String string = getString(R.string.feeds_page_title);
        TextView textView = this.toolbarTitle;
        if (textView != null) {
            textView.setText(string);
        }
        MyBillsEntityDataFactory(R.drawable.arrow_left_white);
        int i = R.id.getNameOrBuilderList_res_0x7f0a0161;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (view = view2.findViewById(i)) == null) {
                view = null;
            } else {
                map.put(Integer.valueOf(i), view);
            }
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) view;
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.FeedMaintenanceFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    FeedMaintenanceFragment.KClassImpl$Data$declaredNonStaticMembers$2(FeedMaintenanceFragment.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
