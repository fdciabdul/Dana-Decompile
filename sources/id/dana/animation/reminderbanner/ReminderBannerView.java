package id.dana.animation.reminderbanner;

import android.content.Context;
import androidx.core.content.res.ResourcesCompat;
import id.dana.R;
import id.dana.component.cellcomponent.DanaCellSimpleView;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.SizeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B#\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/home/reminderbanner/ReminderBannerView;", "Lid/dana/onboarding/view/BaseSimpleView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ReminderBannerView extends BaseSimpleView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.onboarding.view.BaseSimpleView
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return R.layout.view_reminder_banner;
    }

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    public ReminderBannerView(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str3, "");
        this.getAuthRequestContext = str;
        this.PlaceComponentResult = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, "shimmerReminder")) {
            ShimmeringUtil.PlaceComponentResult((DanaCellSimpleView) m_().findViewById(R.id.CreateRemoteWorkerExtension_res_0x7f0a03d7), R.layout.view_reminder_banner_skeleton);
            return;
        }
        int authRequestContext = SizeUtil.getAuthRequestContext(56);
        DanaCellSimpleView danaCellSimpleView = (DanaCellSimpleView) m_().findViewById(R.id.CreateRemoteWorkerExtension_res_0x7f0a03d7);
        danaCellSimpleView.setTitle(String.valueOf(this.getAuthRequestContext));
        danaCellSimpleView.setSubitle(String.valueOf(this.PlaceComponentResult));
        danaCellSimpleView.setIcon(StringsKt.equals(this.KClassImpl$Data$declaredNonStaticMembers$2, "PRE", true) ? R.drawable.ic_invoice_reminder : R.drawable.ic_biller_failed_reminder);
        danaCellSimpleView.setArrowIcon(R.drawable.ic_arrow_right_reminder);
        danaCellSimpleView.setRadius(6.0f);
        danaCellSimpleView.setIconSize(authRequestContext, authRequestContext);
        danaCellSimpleView.setParentHeight(-1);
        danaCellSimpleView.setDrawableBorder(R.drawable.rounded_grey_border);
        Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            context = null;
        }
        danaCellSimpleView.setFontTitle(ResourcesCompat.PlaceComponentResult(context, (int) R.font.sf_pro_semibold));
        Context context3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (context3 != null) {
            context2 = context3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        danaCellSimpleView.setFontSubtitle(ResourcesCompat.PlaceComponentResult(context2, (int) R.font.sf_pro_regular));
    }
}
