package id.dana.onboarding.view;

import android.widget.ImageView;
import android.widget.TextView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\f"}, d2 = {"Lid/dana/onboarding/view/SimpleIntroductionView;", "Lid/dana/onboarding/view/BaseSimpleView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "I", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SimpleIntroductionView extends BaseSimpleView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.onboarding.view.BaseSimpleView
    public int KClassImpl$Data$declaredNonStaticMembers$2() {
        return R.layout.view_simple_introduction;
    }

    public SimpleIntroductionView(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = i;
        this.getAuthRequestContext = str2;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        ImageView imageView;
        if (this.MyBillsEntityDataFactory == 0 && (imageView = (ImageView) m_().findViewById(R.id.Interceptor4getComponentAuth)) != null) {
            imageView.setVisibility(8);
        }
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        TextView textView = (TextView) m_().findViewById(R.id.onGetNegativeButtonString);
        if (textView != null) {
            textView.setText(str);
        }
        int i = this.MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory = i;
        ImageView imageView2 = (ImageView) m_().findViewById(R.id.Interceptor4getComponentAuth);
        if (imageView2 != null) {
            InstrumentInjector.Resources_setImageResource(imageView2, i);
        }
        String str2 = this.getAuthRequestContext;
        this.getAuthRequestContext = str2;
        TextView textView2 = (TextView) m_().findViewById(R.id.getBackgroundScanPeriod);
        if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
