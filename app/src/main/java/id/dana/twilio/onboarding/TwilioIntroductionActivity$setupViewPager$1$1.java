package id.dana.twilio.onboarding;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class TwilioIntroductionActivity$setupViewPager$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TwilioIntroductionActivity$setupViewPager$1$1(Object obj) {
        super(1, obj, ViewPager2.class, "setCurrentItem", "setCurrentItem(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((ViewPager2) this.receiver).setCurrentItem(i);
    }
}
