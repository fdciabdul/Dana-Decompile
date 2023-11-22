package com.alipay.mobile.beehive.poiselect.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alipay.mobile.beehive.poiselect.service.PoiSelectService;
import com.alipay.mobile.framework.service.GeocodeService;
import com.alipay.mobile.framework.service.LBSLocationManagerService;

/* loaded from: classes6.dex */
public class BasePoiFragment extends Fragment {
    protected static final int MAX_RESULT = 40;
    protected static final int PAGE_SIZE = 20;

    public static View createListViewHeader(Context context, View view) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PoiSelectService findPoiSelectService() {
        return (PoiSelectService) RVProxy.get(PoiSelectService.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeocodeService getGeocodeService() {
        return (GeocodeService) RVProxy.get(GeocodeService.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LBSLocationManagerService getLBSLocationManagerService() {
        return (LBSLocationManagerService) RVProxy.get(LBSLocationManagerService.class);
    }
}
