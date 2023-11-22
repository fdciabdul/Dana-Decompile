package id.dana.cashier.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import id.dana.R;
import id.dana.cashier.model.npssurvey.ExtendNpsSurveyModel;
import id.dana.cashier.model.npssurvey.NpsSurveyAnswerModel;
import id.dana.cashier.model.npssurvey.NpsSurveyModel;
import id.dana.cashier.model.npssurvey.NpsSurveyQuestionModel;
import id.dana.cashier.model.npssurvey.NpsSurveySubmitAnswerModel;
import id.dana.cashier.model.npssurvey.NpsSurveySubmitIdentifierModel;
import id.dana.cashier.model.npssurvey.NpsSurveySubmitRequestModel;
import id.dana.cashier.view.DiscreteSurveySlider;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewNpsSurveyBinding;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.TextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002=>B'\b\u0016\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\u000b¢\u0006\u0004\b9\u0010:B+\b\u0016\u0012\u0006\u00105\u001a\u000204\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u00108\u001a\u00020\u000b\u0012\u0006\u0010;\u001a\u00020\u000b¢\u0006\u0004\b9\u0010<J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\u001dJ\r\u0010#\u001a\u00020\u0005¢\u0006\u0004\b#\u0010\u001dR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010%R\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010&R\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010*R\"\u0010,\u001a\u00020+8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u00102\u001a\u00020\u001e8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b2\u00103"}, d2 = {"Lid/dana/cashier/view/NpsSurveyView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewNpsSurveyBinding;", "", "p0", "", "MyBillsEntityDataFactory", "(Z)V", "Lid/dana/cashier/model/npssurvey/NpsSurveySubmitRequestModel;", "constructSurveyRequest", "()Lid/dana/cashier/model/npssurvey/NpsSurveySubmitRequestModel;", "", "progress", "", "getSeekBarThumbPosX", "(Ljava/lang/Integer;)Ljava/lang/Float;", "getSeekBarThumbPosY", "()Ljava/lang/Float;", "p1", "Lid/dana/cashier/model/npssurvey/NpsSurveySubmitAnswerModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(II)Lid/dana/cashier/model/npssurvey/NpsSurveySubmitAnswerModel;", "value", "", "getSliderLabelMessage", "(I)Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/databinding/ViewNpsSurveyBinding;", "getAuthRequestContext", "()V", "Lid/dana/cashier/model/npssurvey/NpsSurveyModel;", "npsSurvey", "setSurvey", "(Lid/dana/cashier/model/npssurvey/NpsSurveyModel;)V", "setup", "showSuccessSubmit", "", "Ljava/util/List;", "Z", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "I", "Ljava/lang/Integer;", "Lid/dana/cashier/view/NpsSurveyView$OnProgressChangeListener;", "sliderListener", "Lid/dana/cashier/view/NpsSurveyView$OnProgressChangeListener;", "getSliderListener", "()Lid/dana/cashier/view/NpsSurveyView$OnProgressChangeListener;", "setSliderListener", "(Lid/dana/cashier/view/NpsSurveyView$OnProgressChangeListener;)V", "moveToNextValue", "Lid/dana/cashier/model/npssurvey/NpsSurveyModel;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnProgressChangeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NpsSurveyView extends BaseViewBindingRichView<ViewNpsSurveyBinding> {
    public static final int GOOD_ENOUGH = 7;
    public static final int NOT_SELECTED = -1;
    public static final int THUMB_SLIDER_SIZE = 30;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Integer getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final List<NpsSurveySubmitAnswerModel> MyBillsEntityDataFactory;
    private NpsSurveyModel moveToNextValue;
    public OnProgressChangeListener sliderListener;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/view/NpsSurveyView$OnProgressChangeListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnProgressChangeListener {
        void BuiltInFictitiousFunctionClassFactory(boolean p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(int p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NpsSurveyView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NpsSurveyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    @JvmName(name = "getSliderListener")
    public final OnProgressChangeListener getSliderListener() {
        OnProgressChangeListener onProgressChangeListener = this.sliderListener;
        if (onProgressChangeListener != null) {
            return onProgressChangeListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSliderListener")
    public final void setSliderListener(OnProgressChangeListener onProgressChangeListener) {
        Intrinsics.checkNotNullParameter(onProgressChangeListener, "");
        this.sliderListener = onProgressChangeListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NpsSurveyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = -1;
        this.MyBillsEntityDataFactory = new ArrayList();
        this.PlaceComponentResult = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    }

    public /* synthetic */ NpsSurveyView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NpsSurveyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = -1;
        this.MyBillsEntityDataFactory = new ArrayList();
        this.PlaceComponentResult = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewNpsSurveyBinding inflateViewBinding() {
        ViewNpsSurveyBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewNpsSurveyBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final String getSliderLabelMessage(int value) {
        if (value == 0) {
            String string = getContext().getString(R.string.nps_survey_slider_label_not_at_all);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }
        if (value > 0 && value < 7) {
            String string2 = getContext().getString(R.string.nps_survey_slider_label_not_really);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            return string2;
        }
        if (7 <= value && value < 9) {
            String string3 = getContext().getString(R.string.nps_survey_slider_label_sliding_to_right);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            return string3;
        } else if (value == 9) {
            String string4 = getContext().getString(R.string.nps_survey_slider_label_of_course);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            return string4;
        } else if (value == 10) {
            String string5 = getContext().getString(R.string.nps_survey_slider_label_love_it);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            return string5;
        } else {
            String string6 = getContext().getString(R.string.nps_survey_slider_label_slide_start);
            Intrinsics.checkNotNullExpressionValue(string6, "");
            return string6;
        }
    }

    public final Float getSeekBarThumbPosY() {
        DiscreteSurveySlider discreteSurveySlider = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        AppCompatSeekBar discreetSlider = discreteSurveySlider.getDiscreetSlider();
        int top = discreteSurveySlider.getTop();
        ViewGroup.LayoutParams layoutParams = discreetSlider.getLayoutParams();
        return Float.valueOf(top + ((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null ? r1.topMargin : 0));
    }

    public final Float getSeekBarThumbPosX(Integer progress) {
        Rect copyBounds;
        float f;
        Drawable thumb = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getDiscreetSlider().getThumb();
        if (thumb == null || (copyBounds = thumb.copyBounds()) == null) {
            return null;
        }
        boolean z = true;
        if (progress == null || progress.intValue() != -1) {
            IntRange intRange = new IntRange(7, 8);
            if (progress == null || !intRange.contains(progress.intValue())) {
                z = false;
            }
        }
        if (z) {
            f = copyBounds.left - ((r0.getPaddingRight() + 15.0f) + (r0.getThumbOffset() * 2));
        } else {
            f = copyBounds.left - 15.0f;
        }
        return Float.valueOf(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r5v1 */
    public final NpsSurveySubmitRequestModel constructSurveyRequest() {
        int intValue;
        NpsSurveyModel npsSurveyModel = 0;
        NpsSurveySubmitRequestModel npsSurveySubmitRequestModel = new NpsSurveySubmitRequestModel(null, null, false, 7, npsSurveyModel);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != -1) {
            this.MyBillsEntityDataFactory.add(KClassImpl$Data$declaredNonStaticMembers$2$default(this, 1, 0, 2, null));
        }
        Integer num = this.getAuthRequestContext;
        if (num != null && (intValue = num.intValue()) != -1 && this.KClassImpl$Data$declaredNonStaticMembers$2 < 7) {
            this.MyBillsEntityDataFactory.add(KClassImpl$Data$declaredNonStaticMembers$2(2, intValue));
        }
        this.MyBillsEntityDataFactory.add(KClassImpl$Data$declaredNonStaticMembers$2$default(this, 3, 0, 2, null));
        NpsSurveyModel npsSurveyModel2 = this.moveToNextValue;
        if (npsSurveyModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            npsSurveyModel2 = null;
        }
        String str = npsSurveyModel2.lookAheadTest;
        NpsSurveyModel npsSurveyModel3 = this.moveToNextValue;
        if (npsSurveyModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            npsSurveyModel = npsSurveyModel3;
        }
        npsSurveySubmitRequestModel.MyBillsEntityDataFactory = new NpsSurveySubmitIdentifierModel(str, npsSurveyModel.getAuthRequestContext);
        List<NpsSurveySubmitAnswerModel> list = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(list, "");
        npsSurveySubmitRequestModel.PlaceComponentResult = list;
        npsSurveySubmitRequestModel.getAuthRequestContext = true;
        return npsSurveySubmitRequestModel;
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().getAuthRequestContext;
        danaButtonPrimaryView.setClickable(p0);
        danaButtonPrimaryView.setEnabled(p0);
        if (p0) {
            danaButtonPrimaryView.setActiveButton(danaButtonPrimaryView.getContext().getString(R.string.nps_survey_button_submit_text), null);
        } else {
            danaButtonPrimaryView.setDisabled(danaButtonPrimaryView.getContext().getString(R.string.nps_survey_button_submit_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
            return;
        }
        Integer num = this.getAuthRequestContext;
        if (num != null && num.intValue() == -1 && !this.BuiltInFictitiousFunctionClassFactory) {
            MyBillsEntityDataFactory(true);
            return;
        }
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != -1 && i >= 7) {
            MyBillsEntityDataFactory(true);
            return;
        }
        Integer num2 = this.getAuthRequestContext;
        if ((num2 == null || num2.intValue() != -1) && this.KClassImpl$Data$declaredNonStaticMembers$2 < 7) {
            MyBillsEntityDataFactory(true);
        } else {
            MyBillsEntityDataFactory(false);
        }
    }

    static /* synthetic */ NpsSurveySubmitAnswerModel KClassImpl$Data$declaredNonStaticMembers$2$default(NpsSurveyView npsSurveyView, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        return npsSurveyView.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final NpsSurveySubmitAnswerModel KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
        List<NpsSurveyQuestionModel> list;
        Integer num;
        Integer num2 = null;
        NpsSurveySubmitAnswerModel npsSurveySubmitAnswerModel = new NpsSurveySubmitAnswerModel(num2, null, null, 7, null);
        NpsSurveyModel npsSurveyModel = this.moveToNextValue;
        if (npsSurveyModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            npsSurveyModel = null;
        }
        ExtendNpsSurveyModel extendNpsSurveyModel = npsSurveyModel.PlaceComponentResult;
        if (extendNpsSurveyModel != null && (list = extendNpsSurveyModel.scheduleImpl) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Integer num3 = ((NpsSurveyQuestionModel) next).BuiltInFictitiousFunctionClassFactory;
                if (num3 != null && num3.intValue() == p0) {
                    num2 = next;
                    break;
                }
            }
            NpsSurveyQuestionModel npsSurveyQuestionModel = (NpsSurveyQuestionModel) num2;
            if (npsSurveyQuestionModel != null && (num = npsSurveyQuestionModel.BuiltInFictitiousFunctionClassFactory) != null && num.intValue() == p0) {
                npsSurveySubmitAnswerModel.getAuthRequestContext = npsSurveyQuestionModel.MyBillsEntityDataFactory;
                if (p0 == 1) {
                    npsSurveySubmitAnswerModel.BuiltInFictitiousFunctionClassFactory = String.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else if (p0 == 2) {
                    List<NpsSurveyAnswerModel> list2 = npsSurveyQuestionModel.PlaceComponentResult;
                    if (list2 != null && (p1 != -1 || p1 <= list2.size())) {
                        NpsSurveyAnswerModel npsSurveyAnswerModel = list2.get(p1);
                        npsSurveySubmitAnswerModel.BuiltInFictitiousFunctionClassFactory = npsSurveyAnswerModel.scheduleImpl;
                        npsSurveySubmitAnswerModel.MyBillsEntityDataFactory = npsSurveyAnswerModel.PlaceComponentResult;
                    }
                } else if (p0 == 3) {
                    npsSurveySubmitAnswerModel.BuiltInFictitiousFunctionClassFactory = String.valueOf(getBinding().PlaceComponentResult.getText());
                }
            }
        }
        return npsSurveySubmitAnswerModel;
    }

    public final void showSuccessSubmit() {
        ViewNpsSurveyBinding binding = getBinding();
        LinearLayout linearLayout = binding.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
        linearLayout2.setVisibility(0);
    }

    /* renamed from: $r8$lambda$w_ZbEigHXZiS67I9mJg-ocKxCRI  reason: not valid java name */
    public static /* synthetic */ void m597$r8$lambda$w_ZbEigHXZiS67I9mJgocKxCRI(NpsSurveyView npsSurveyView, ChipGroup chipGroup, int i) {
        Intrinsics.checkNotNullParameter(npsSurveyView, "");
        if (i != -1) {
            Integer num = null;
            if (chipGroup != null) {
                View findViewById = npsSurveyView.findViewById(i);
                num = Integer.valueOf(chipGroup.indexOfChild(findViewById instanceof Chip ? (Chip) findViewById : null));
            }
            npsSurveyView.getAuthRequestContext = num;
            npsSurveyView.getAuthRequestContext();
        }
    }

    public static final /* synthetic */ void access$checkSuggestionInputFocused(NpsSurveyView npsSurveyView) {
        if (npsSurveyView.getBinding().PlaceComponentResult.isFocused()) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(npsSurveyView);
            npsSurveyView.getBinding().PlaceComponentResult.clearFocus();
        }
    }

    public static final /* synthetic */ void access$setProgressSlider(NpsSurveyView npsSurveyView, int i) {
        npsSurveyView.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        if (npsSurveyView.sliderListener != null) {
            npsSurveyView.getSliderListener().KClassImpl$Data$declaredNonStaticMembers$2(npsSurveyView.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (npsSurveyView.KClassImpl$Data$declaredNonStaticMembers$2 == -1 || !npsSurveyView.PlaceComponentResult) {
            return;
        }
        if (npsSurveyView.sliderListener != null) {
            npsSurveyView.getSliderListener().BuiltInFictitiousFunctionClassFactory(npsSurveyView.PlaceComponentResult);
        }
        npsSurveyView.PlaceComponentResult = false;
    }

    public static final /* synthetic */ void access$showTagSelection(NpsSurveyView npsSurveyView) {
        if (npsSurveyView.BuiltInFictitiousFunctionClassFactory) {
            ConstraintLayout constraintLayout = npsSurveyView.getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(npsSurveyView.KClassImpl$Data$declaredNonStaticMembers$2 < 7 ? 0 : 8);
        }
    }

    public final void setSurvey(NpsSurveyModel npsSurvey) {
        List<NpsSurveyQuestionModel> list;
        Object obj;
        List<NpsSurveyQuestionModel> list2;
        Object obj2;
        Intrinsics.checkNotNullParameter(npsSurvey, "");
        ExtendNpsSurveyModel extendNpsSurveyModel = npsSurvey.PlaceComponentResult;
        List<NpsSurveyQuestionModel> list3 = extendNpsSurveyModel != null ? extendNpsSurveyModel.scheduleImpl : null;
        if (list3 == null || list3.isEmpty()) {
            return;
        }
        this.moveToNextValue = npsSurvey;
        if (npsSurvey == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            npsSurvey = null;
        }
        ExtendNpsSurveyModel extendNpsSurveyModel2 = npsSurvey.PlaceComponentResult;
        if (extendNpsSurveyModel2 != null && (list2 = extendNpsSurveyModel2.scheduleImpl) != null) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                Integer num = ((NpsSurveyQuestionModel) obj2).BuiltInFictitiousFunctionClassFactory;
                if (num != null && num.intValue() == 1) {
                    break;
                }
            }
            NpsSurveyQuestionModel npsSurveyQuestionModel = (NpsSurveyQuestionModel) obj2;
            if (npsSurveyQuestionModel != null) {
                getBinding().DatabaseTableConfigUtil.setText(npsSurveyQuestionModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
        }
        NpsSurveyModel npsSurveyModel = this.moveToNextValue;
        if (npsSurveyModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            npsSurveyModel = null;
        }
        ExtendNpsSurveyModel extendNpsSurveyModel3 = npsSurveyModel.PlaceComponentResult;
        if (extendNpsSurveyModel3 == null || (list = extendNpsSurveyModel3.scheduleImpl) == null) {
            return;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            Integer num2 = ((NpsSurveyQuestionModel) obj).BuiltInFictitiousFunctionClassFactory;
            boolean z = num2 != null && num2.intValue() == 2;
            if (z) {
                this.BuiltInFictitiousFunctionClassFactory = true;
            }
            if (z) {
                break;
            }
        }
        NpsSurveyQuestionModel npsSurveyQuestionModel2 = (NpsSurveyQuestionModel) obj;
        if (npsSurveyQuestionModel2 != null) {
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2.setText(npsSurveyQuestionModel2.NetworkUserEntityData$$ExternalSyntheticLambda2);
            List<NpsSurveyAnswerModel> list4 = npsSurveyQuestionModel2.PlaceComponentResult;
            ChipGroup chipGroup = getBinding().BuiltInFictitiousFunctionClassFactory;
            if (list4 != null) {
                for (NpsSurveyAnswerModel npsSurveyAnswerModel : list4) {
                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_nps_survey_tag, (ViewGroup) getBinding().BuiltInFictitiousFunctionClassFactory, false);
                    Chip chip = inflate instanceof Chip ? (Chip) inflate : null;
                    if (chip != null) {
                        chip.setId(ViewCompat.MyBillsEntityDataFactory());
                        chip.setText(TextUtil.lookAheadTest(npsSurveyAnswerModel.PlaceComponentResult));
                        chip.setClickable(true);
                        chip.setCheckable(true);
                        chip.setFocusable(true);
                    }
                    if (chip != null) {
                        chipGroup.addView(chip);
                    }
                }
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setSliderChangeListener(new DiscreteSurveySlider.OnSliderChangeListener() { // from class: id.dana.cashier.view.NpsSurveyView$initSliderListener$1
            @Override // id.dana.cashier.view.DiscreteSurveySlider.OnSliderChangeListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                NpsSurveyView.access$setProgressSlider(NpsSurveyView.this, i);
                NpsSurveyView.access$showTagSelection(NpsSurveyView.this);
                NpsSurveyView.this.getAuthRequestContext();
                NpsSurveyView.access$checkSuggestionInputFocused(NpsSurveyView.this);
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() { // from class: id.dana.cashier.view.NpsSurveyView$$ExternalSyntheticLambda0
            @Override // com.google.android.material.chip.ChipGroup.OnCheckedChangeListener
            public final void onCheckedChanged(ChipGroup chipGroup, int i) {
                NpsSurveyView.m597$r8$lambda$w_ZbEigHXZiS67I9mJgocKxCRI(NpsSurveyView.this, chipGroup, i);
            }
        });
        MyBillsEntityDataFactory(false);
        getBinding().getAuthRequestContext.setButtonContentDescription(getContext().getString(R.string.btn_submit_survey));
    }
}
