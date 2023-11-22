package id.dana.core.ui.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0007¢\u0006\u0004\b/\u00100J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005R\"\u0010\u000e\u001a\u00020\u00078\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0016\u001a\u00020\u00138\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\"\u0010!\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR\"\u0010%\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\rR\"\u0010)\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\t\u001a\u0004\b'\u0010\u000b\"\u0004\b(\u0010\r"}, d2 = {"Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "lavLottieAnimationView", "", "setupIntroMinMaxFrame", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "setupLoopMinMaxFrame", "", "BuiltInFictitiousFunctionClassFactory", "I", "getIntroMaxFrame", "()I", "setIntroMaxFrame", "(I)V", "introMaxFrame", "getAuthRequestContext", "getIntroMinFrame", "setIntroMinFrame", "introMinFrame", "", "MyBillsEntityDataFactory", "Z", "isLoopFinished", "()Z", "setLoopFinished", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "getLoopMaxFrame", "setLoopMaxFrame", "loopMaxFrame", "PlaceComponentResult", "getLoopMinFrame", "setLoopMinFrame", "loopMinFrame", "moveToNextValue", "getOutroMaxFrame", "setOutroMaxFrame", "outroMaxFrame", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getOutroMinFrame", "setOutroMinFrame", "outroMinFrame", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoadingLottieAnimationView extends LottieAnimationView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int introMaxFrame;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int loopMaxFrame;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean isLoopFinished;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int outroMinFrame;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int loopMinFrame;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int introMinFrame;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private int outroMaxFrame;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingLottieAnimationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingLottieAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TypefaceCompatApi26Impl, 0, 0);
        this.introMinFrame = obtainStyledAttributes.getInteger(R.styleable.x, 0);
        this.introMaxFrame = obtainStyledAttributes.getInteger(R.styleable.w, 0);
        this.loopMinFrame = obtainStyledAttributes.getInteger(R.styleable.z, 0);
        this.loopMaxFrame = obtainStyledAttributes.getInteger(R.styleable.u, 0);
        this.outroMinFrame = obtainStyledAttributes.getInteger(R.styleable.y, 0);
        this.outroMaxFrame = obtainStyledAttributes.getInteger(R.styleable.initAnimators, 0);
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ LoadingLottieAnimationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getIntroMinFrame")
    public final int getIntroMinFrame() {
        return this.introMinFrame;
    }

    @JvmName(name = "setIntroMinFrame")
    public final void setIntroMinFrame(int i) {
        this.introMinFrame = i;
    }

    @JvmName(name = "getIntroMaxFrame")
    public final int getIntroMaxFrame() {
        return this.introMaxFrame;
    }

    @JvmName(name = "setIntroMaxFrame")
    public final void setIntroMaxFrame(int i) {
        this.introMaxFrame = i;
    }

    @JvmName(name = "getLoopMinFrame")
    public final int getLoopMinFrame() {
        return this.loopMinFrame;
    }

    @JvmName(name = "setLoopMinFrame")
    public final void setLoopMinFrame(int i) {
        this.loopMinFrame = i;
    }

    @JvmName(name = "getLoopMaxFrame")
    public final int getLoopMaxFrame() {
        return this.loopMaxFrame;
    }

    @JvmName(name = "setLoopMaxFrame")
    public final void setLoopMaxFrame(int i) {
        this.loopMaxFrame = i;
    }

    @JvmName(name = "getOutroMinFrame")
    public final int getOutroMinFrame() {
        return this.outroMinFrame;
    }

    @JvmName(name = "setOutroMinFrame")
    public final void setOutroMinFrame(int i) {
        this.outroMinFrame = i;
    }

    @JvmName(name = "getOutroMaxFrame")
    public final int getOutroMaxFrame() {
        return this.outroMaxFrame;
    }

    @JvmName(name = "setOutroMaxFrame")
    public final void setOutroMaxFrame(int i) {
        this.outroMaxFrame = i;
    }

    @JvmName(name = "isLoopFinished")
    /* renamed from: isLoopFinished  reason: from getter */
    public final boolean getIsLoopFinished() {
        return this.isLoopFinished;
    }

    @JvmName(name = "setLoopFinished")
    public final void setLoopFinished(boolean z) {
        this.isLoopFinished = z;
    }

    public final void setupIntroMinMaxFrame(LottieAnimationView lavLottieAnimationView) {
        Intrinsics.checkNotNullParameter(lavLottieAnimationView, "");
        lavLottieAnimationView.setMinFrame(this.introMinFrame);
        lavLottieAnimationView.setMaxFrame(this.introMaxFrame);
    }

    public final void setupLoopMinMaxFrame(LottieAnimationView lavLottieAnimationView) {
        Intrinsics.checkNotNullParameter(lavLottieAnimationView, "");
        lavLottieAnimationView.setMinFrame(this.loopMinFrame);
        lavLottieAnimationView.setMaxFrame(this.loopMaxFrame);
    }
}
