package id.dana.common.smoothscroller;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/common/smoothscroller/LinearSmoothScrollerWithVerticalOffset;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroid/view/View;", "p0", "", "p1", "calculateDyToMakeVisible", "(Landroid/view/View;I)I", "getVerticalSnapPreference", "()I", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", LogConstants.RESULT_FALSE, "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public class LinearSmoothScrollerWithVerticalOffset extends LinearSmoothScroller {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final float getAuthRequestContext;

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int getVerticalSnapPreference() {
        return -1;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public int calculateDyToMakeVisible(View p0, int p1) {
        return super.calculateDyToMakeVisible(p0, p1) + ConvertUtils.toDp(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
    }
}
