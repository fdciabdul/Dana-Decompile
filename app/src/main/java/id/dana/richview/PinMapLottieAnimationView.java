package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;

/* loaded from: classes5.dex */
public class PinMapLottieAnimationView extends LottieAnimationView {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private int PlaceComponentResult;

    public PinMapLottieAnimationView(Context context) {
        super(context);
    }

    public PinMapLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        PlaceComponentResult(attributeSet);
    }

    public PinMapLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        PlaceComponentResult(attributeSet);
    }

    private void PlaceComponentResult(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.access$getFeaturedBankListAdapter$p);
            this.MyBillsEntityDataFactory = obtainStyledAttributes.getInteger(1, 0);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInt(0, 0);
            this.PlaceComponentResult = obtainStyledAttributes.getInt(3, 0);
            this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(2, 0);
        }
    }

    public int getPullOutMinFrame() {
        return this.MyBillsEntityDataFactory;
    }

    public void setPullOutMinFrame(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    public int getPullOutMaxFrame() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public void setPullOutMaxFrame(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    public int getPutDownMinFrame() {
        return this.PlaceComponentResult;
    }

    public void setPutDownMinFrame(int i) {
        this.PlaceComponentResult = i;
    }

    public int getPutDownMaxFrame() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public void setPutDownMaxFrame(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    public boolean isPutDownPinMap() {
        return (getMaxFrame() == ((float) getPullOutMaxFrame()) || getMinFrame() == ((float) getPullOutMinFrame())) ? false : true;
    }

    public void pullOutPinMap() {
        if (isPutDownPinMap()) {
            setMinFrame(getPullOutMinFrame());
            setMaxFrame(getPullOutMaxFrame());
            playAnimation();
        }
    }

    public void putDownPinMap() {
        setMinFrame(getPutDownMinFrame());
        setMaxFrame(getPutDownMaxFrame());
        playAnimation();
    }
}
