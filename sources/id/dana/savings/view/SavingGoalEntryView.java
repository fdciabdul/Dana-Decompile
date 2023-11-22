package id.dana.savings.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.textfield.TextInputLayout;
import com.jakewharton.rxbinding2.widget.RxTextView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.dialog.DialogWithImage;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.requestmoney.BundleKey;
import id.dana.savings.view.MonthlyAutoTopUpBottomSheet;
import id.dana.savings.view.WeeklyAutoTopUpBottomSheet;
import id.dana.utils.LocaleUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u0001:\u0002DEB%\u0012\u0006\u0010>\u001a\u00020=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010A\u001a\u00020\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001f\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u000e\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010!J\u0017\u0010\"\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010\u0013R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0#8\u0007¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010&R\"\u0010+\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010(\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\u0013R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00102\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010/\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\u0016R\"\u00104\u001a\u0002038\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010;"}, d2 = {"Lid/dana/savings/view/SavingGoalEntryView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getTargetAmount", "()Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "", "getTitle", "()Ljava/lang/String;", "Lkotlin/Pair;", "p0", "", "getAuthRequestContext", "(Lkotlin/Pair;)Z", "text", "", "setGoal", "(Ljava/lang/String;)V", "moneyViewModel", "setMaximumAmount", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V", GriverEvents.EVENT_SET_TITLE, "setup", "()V", "Landroid/widget/EditText;", "Lcom/google/android/material/textfield/TextInputLayout;", "p1", "p2", "p3", "BuiltInFictitiousFunctionClassFactory", "(Landroid/widget/EditText;Lcom/google/android/material/textfield/TextInputLayout;II)V", "(ZZ)V", "PlaceComponentResult", "", "Ljava/util/Set;", "getDays", "()Ljava/util/Set;", "days", "Ljava/lang/String;", "getGoalAmount", "setGoalAmount", "goalAmount", "MyBillsEntityDataFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getMinAmount", "setMinAmount", BundleKey.MINIMUM_AMOUNT, "Lid/dana/savings/view/SavingGoalEntryView$OnGoalChangeListener;", "onGoalChangeListener", "Lid/dana/savings/view/SavingGoalEntryView$OnGoalChangeListener;", "getOnGoalChangeListener", "()Lid/dana/savings/view/SavingGoalEntryView$OnGoalChangeListener;", "setOnGoalChangeListener", "(Lid/dana/savings/view/SavingGoalEntryView$OnGoalChangeListener;)V", "scheduleImpl", "I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "OnGoalChangeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingGoalEntryView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String goalAmount;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private MoneyViewModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private MoneyViewModel minAmount;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Set<String> days;
    public OnGoalChangeListener onGoalChangeListener;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private int PlaceComponentResult;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/view/SavingGoalEntryView$OnGoalChangeListener;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Z)V", "", "getAuthRequestContext", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnGoalChangeListener {
        void MyBillsEntityDataFactory(boolean p0);

        void getAuthRequestContext(String p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavingGoalEntryView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavingGoalEntryView(Context context, AttributeSet attributeSet) {
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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_saving_goal_entry;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavingGoalEntryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = new MoneyViewModel("1", "Rp", null, 4, null);
        this.minAmount = new MoneyViewModel("1", "Rp", null, 4, null);
        this.MyBillsEntityDataFactory = -1;
        this.PlaceComponentResult = -1;
        String string = context.getString(R.string.sunday);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = context.getString(R.string.monday);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = context.getString(R.string.tuesday);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = context.getString(R.string.wednesday);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = context.getString(R.string.thursday);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = context.getString(R.string.friday);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        String string7 = context.getString(R.string.saturday);
        Intrinsics.checkNotNullExpressionValue(string7, "");
        this.days = SetsKt.setOf((Object[]) new String[]{string, string2, string3, string4, string5, string6, string7});
        this.goalAmount = "0";
    }

    public /* synthetic */ SavingGoalEntryView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getMinAmount")
    public final MoneyViewModel getMinAmount() {
        return this.minAmount;
    }

    @JvmName(name = "setMinAmount")
    public final void setMinAmount(MoneyViewModel moneyViewModel) {
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        this.minAmount = moneyViewModel;
    }

    @JvmName(name = "getDays")
    public final Set<String> getDays() {
        return this.days;
    }

    @JvmName(name = "getGoalAmount")
    public final String getGoalAmount() {
        return this.goalAmount;
    }

    @JvmName(name = "setGoalAmount")
    public final void setGoalAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.goalAmount = str;
    }

    @JvmName(name = "getOnGoalChangeListener")
    public final OnGoalChangeListener getOnGoalChangeListener() {
        OnGoalChangeListener onGoalChangeListener = this.onGoalChangeListener;
        if (onGoalChangeListener != null) {
            return onGoalChangeListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOnGoalChangeListener")
    public final void setOnGoalChangeListener(OnGoalChangeListener onGoalChangeListener) {
        Intrinsics.checkNotNullParameter(onGoalChangeListener, "");
        this.onGoalChangeListener = onGoalChangeListener;
    }

    private final void BuiltInFictitiousFunctionClassFactory(final EditText p0, final TextInputLayout p1, final int p2, final int p3) {
        final View.OnFocusChangeListener onFocusChangeListener = p0 != null ? p0.getOnFocusChangeListener() : null;
        if (p0 != null) {
            p0.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.savings.view.SavingGoalEntryView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    SavingGoalEntryView.m2890$r8$lambda$f4Bod2c3asxs9sYXoe2wcMhONA(onFocusChangeListener, p1, p0, this, p3, p2, view, z);
                }
            });
        }
    }

    public final void setTitle(String text) {
        Intrinsics.checkNotNullParameter(text, "");
        DanaTextBoxView danaTextBoxView = (DanaTextBoxView) _$_findCachedViewById(R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a0696);
        if (danaTextBoxView != null) {
            danaTextBoxView.setText(text);
        }
        DanaTextBoxView danaTextBoxView2 = (DanaTextBoxView) _$_findCachedViewById(R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a0696);
        if (danaTextBoxView2 != null) {
            danaTextBoxView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        TextInputLayout textInputLayout = (TextInputLayout) _$_findCachedViewById(R.id.til_goal_title);
        if (textInputLayout != null) {
            textInputLayout.setEndIconVisible(false);
        }
    }

    public final void setGoal(String text) {
        Intrinsics.checkNotNullParameter(text, "");
        DanaTextBoxView danaTextBoxView = (DanaTextBoxView) _$_findCachedViewById(R.id.MatrixEvaluator);
        if (danaTextBoxView != null) {
            danaTextBoxView.setText(text);
        }
        TextInputLayout textInputLayout = (TextInputLayout) _$_findCachedViewById(R.id.GetGroupFavoriteValue);
        if (textInputLayout != null) {
            textInputLayout.setHint(getContext().getString(R.string.goal_hint_focused));
        }
        TextInputLayout textInputLayout2 = (TextInputLayout) _$_findCachedViewById(R.id.GetGroupFavoriteValue);
        if (textInputLayout2 != null) {
            textInputLayout2.setEndIconVisible(false);
        }
    }

    public final void setMaximumAmount(MoneyViewModel moneyViewModel) {
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        this.BuiltInFictitiousFunctionClassFactory = moneyViewModel;
        DanaTextBoxView danaTextBoxView = (DanaTextBoxView) _$_findCachedViewById(R.id.MatrixEvaluator);
        if (danaTextBoxView != null) {
            Editable text = danaTextBoxView.getText();
            String obj = text != null ? text.toString() : null;
            PlaceComponentResult(obj != null ? obj : "");
        }
    }

    private final void getAuthRequestContext(boolean p0, boolean p1) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = !p0;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tv_maximum_target);
        int i = R.color.f26712131100373;
        if (appCompatTextView != null) {
            String string = getContext().getString(!p0 || p1 ? R.string.maximum_savings_target_warning : R.string.minimum_savings_target_warning);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Object[] objArr = new Object[1];
            objArr[0] = (p1 ? this.BuiltInFictitiousFunctionClassFactory : this.minAmount).getAuthRequestContext();
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            appCompatTextView.setText(format);
            appCompatTextView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(appCompatTextView.getContext(), p0 ? R.color.f26712131100373 : R.color.f23982131099995));
        }
        TextInputLayout textInputLayout = (TextInputLayout) _$_findCachedViewById(R.id.GetGroupFavoriteValue);
        if (textInputLayout != null) {
            Context context = textInputLayout.getContext();
            if (!p0) {
                i = R.color.f23982131099995;
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(context.getResources(), i, context.getTheme());
            textInputLayout.setHintTextColor(KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    private final boolean getAuthRequestContext(Pair<String, String> p0) {
        MoneyViewModel moneyViewModel = new MoneyViewModel(p0.getFirst(), null, null, 6, null);
        return (!(p0.getSecond().length() > 0) || moneyViewModel.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory) || moneyViewModel.PlaceComponentResult(this.minAmount)) ? false : true;
    }

    private final void PlaceComponentResult(String p0) {
        if (p0.length() == 0) {
            getAuthRequestContext(false, true);
            return;
        }
        MoneyViewModel moneyViewModel = new MoneyViewModel(p0, null, null, 6, null);
        if (moneyViewModel.PlaceComponentResult(this.minAmount)) {
            getAuthRequestContext(true, false);
        } else if (moneyViewModel.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory)) {
            getAuthRequestContext(true, true);
        } else {
            getAuthRequestContext(false, true);
        }
    }

    public final MoneyViewModel getTargetAmount() {
        Editable text;
        DanaTextBoxView danaTextBoxView = (DanaTextBoxView) _$_findCachedViewById(R.id.MatrixEvaluator);
        String obj = (danaTextBoxView == null || (text = danaTextBoxView.getText()) == null) ? null : text.toString();
        if (obj == null) {
            obj = "";
        }
        return new MoneyViewModel(obj, null, null, 6, null);
    }

    public final String getTitle() {
        Editable text;
        DanaTextBoxView danaTextBoxView = (DanaTextBoxView) _$_findCachedViewById(R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a0696);
        String obj = (danaTextBoxView == null || (text = danaTextBoxView.getText()) == null) ? null : text.toString();
        return obj == null ? "" : obj;
    }

    /* renamed from: $r8$lambda$08TBUdk7XvxJuraXZlpm38-enwY  reason: not valid java name */
    public static /* synthetic */ void m2889$r8$lambda$08TBUdk7XvxJuraXZlpm38enwY(final SavingGoalEntryView savingGoalEntryView, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(savingGoalEntryView, "");
        switch (i) {
            case R.id.rb_monthly /* 2131365930 */:
                LinearLayout linearLayout = (LinearLayout) savingGoalEntryView._$_findCachedViewById(R.id.ll_set_auto_topup);
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                TextView textView = (TextView) savingGoalEntryView._$_findCachedViewById(R.id.res_0x7f0a1627_r8_lambda_sfgehzrhmhpulclap_98izzwonq);
                if (textView != null) {
                    textView.setText(savingGoalEntryView.getContext().getString(R.string.auto_top_up_date));
                }
                TextView textView2 = (TextView) savingGoalEntryView._$_findCachedViewById(R.id.tv_auto_topup_amount);
                if (textView2 != null) {
                    textView2.setText(savingGoalEntryView.getContext().getString(R.string.auto_top_up_amount));
                }
                DanaTextBoxView danaTextBoxView = (DanaTextBoxView) savingGoalEntryView._$_findCachedViewById(R.id.et_auto_topup);
                if (danaTextBoxView != null) {
                    danaTextBoxView.setText(String.valueOf(Calendar.getInstance().get(5)));
                }
                DanaTextBoxView danaTextBoxView2 = (DanaTextBoxView) savingGoalEntryView._$_findCachedViewById(R.id.et_auto_topup);
                if (danaTextBoxView2 != null) {
                    danaTextBoxView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.SavingGoalEntryView$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SavingGoalEntryView.$r8$lambda$JKje8Hh1XYZqQAt8KCeME9jgUho(SavingGoalEntryView.this, view);
                        }
                    });
                    return;
                }
                return;
            case R.id.f4090rb_not_active /* 2131365931 */:
                LinearLayout linearLayout2 = (LinearLayout) savingGoalEntryView._$_findCachedViewById(R.id.ll_set_auto_topup);
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                    return;
                }
                return;
            case R.id.f4091rb_selected_card /* 2131365932 */:
            case R.id.f4092rb_selected_reason /* 2131365933 */:
            default:
                return;
            case R.id.rb_weekly /* 2131365934 */:
                LinearLayout linearLayout3 = (LinearLayout) savingGoalEntryView._$_findCachedViewById(R.id.ll_set_auto_topup);
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(0);
                }
                TextView textView3 = (TextView) savingGoalEntryView._$_findCachedViewById(R.id.res_0x7f0a1627_r8_lambda_sfgehzrhmhpulclap_98izzwonq);
                if (textView3 != null) {
                    textView3.setText(savingGoalEntryView.getContext().getString(R.string.auto_top_up_day));
                }
                TextView textView4 = (TextView) savingGoalEntryView._$_findCachedViewById(R.id.tv_auto_topup_amount);
                if (textView4 != null) {
                    textView4.setText(savingGoalEntryView.getContext().getString(R.string.auto_top_up_amount));
                }
                DanaTextBoxView danaTextBoxView3 = (DanaTextBoxView) savingGoalEntryView._$_findCachedViewById(R.id.et_auto_topup);
                if (danaTextBoxView3 != null) {
                    danaTextBoxView3.setText((CharSequence) CollectionsKt.elementAt(savingGoalEntryView.days, Calendar.getInstance().get(7) - 1));
                }
                DanaTextBoxView danaTextBoxView4 = (DanaTextBoxView) savingGoalEntryView._$_findCachedViewById(R.id.et_auto_topup);
                if (danaTextBoxView4 != null) {
                    danaTextBoxView4.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.SavingGoalEntryView$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SavingGoalEntryView.$r8$lambda$S1Ehr2YVft3yZFjrprfOJ1yVDTg(SavingGoalEntryView.this, view);
                        }
                    });
                    return;
                }
                return;
        }
    }

    public static /* synthetic */ void $r8$lambda$6nu25XiEe9gWql_a9X5OJldFH_E(SavingGoalEntryView savingGoalEntryView, Pair pair) {
        savingGoalEntryView.PlaceComponentResult((String) pair.getFirst());
        boolean authRequestContext = savingGoalEntryView.getAuthRequestContext(pair);
        savingGoalEntryView.getOnGoalChangeListener().MyBillsEntityDataFactory(authRequestContext);
        if (authRequestContext) {
            savingGoalEntryView.getOnGoalChangeListener().getAuthRequestContext((String) pair.getSecond());
        }
    }

    public static /* synthetic */ Pair $r8$lambda$HYmPEr4vser9LhRk6j_Gz9bu44M(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return TuplesKt.to(str, str2);
    }

    public static /* synthetic */ void $r8$lambda$JKje8Hh1XYZqQAt8KCeME9jgUho(final SavingGoalEntryView savingGoalEntryView, View view) {
        Intrinsics.checkNotNullParameter(savingGoalEntryView, "");
        MonthlyAutoTopUpBottomSheet monthlyAutoTopUpBottomSheet = new MonthlyAutoTopUpBottomSheet();
        int i = savingGoalEntryView.PlaceComponentResult;
        if (i == -1) {
            i = Calendar.getInstance().get(5);
        }
        monthlyAutoTopUpBottomSheet.getAuthRequestContext = i;
        MonthlyAutoTopUpBottomSheet.MonthlyAutoTopUpListener monthlyAutoTopUpListener = new MonthlyAutoTopUpBottomSheet.MonthlyAutoTopUpListener() { // from class: id.dana.savings.view.SavingGoalEntryView$showMonthlyAutoTopupBottomSheet$1
            @Override // id.dana.savings.view.MonthlyAutoTopUpBottomSheet.MonthlyAutoTopUpListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                SavingGoalEntryView.this.PlaceComponentResult = p0;
                DanaTextBoxView danaTextBoxView = (DanaTextBoxView) SavingGoalEntryView.this._$_findCachedViewById(R.id.et_auto_topup);
                if (danaTextBoxView != null) {
                    danaTextBoxView.setText(String.valueOf(p0));
                }
            }
        };
        Intrinsics.checkNotNullParameter(monthlyAutoTopUpListener, "");
        monthlyAutoTopUpBottomSheet.BuiltInFictitiousFunctionClassFactory = monthlyAutoTopUpListener;
        Context context = savingGoalEntryView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
        monthlyAutoTopUpBottomSheet.show(((FragmentActivity) context).getSupportFragmentManager(), "MonthlyAutoTopUpBottomSheet");
    }

    public static /* synthetic */ void $r8$lambda$K7fanJtCrkN3UyJMRFXNOU6jeUE(SavingGoalEntryView savingGoalEntryView, View view) {
        Intrinsics.checkNotNullParameter(savingGoalEntryView, "");
        DialogWithImage.Builder builder = new DialogWithImage.Builder();
        builder.MyBillsEntityDataFactory = R.drawable.maximum_limit;
        builder.moveToNextValue = savingGoalEntryView.getContext().getString(R.string.pop_up_title_saving_limit_about_info);
        builder.PlaceComponentResult = savingGoalEntryView.getContext().getString(R.string.pop_up_description_saving_limit_about_info);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = savingGoalEntryView.getContext().getString(R.string.res_0x7f130923_otpregistrationpresenter_input_2);
        new DialogWithImage(savingGoalEntryView.getContext(), builder.lookAheadTest, builder, (byte) 0).MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void $r8$lambda$S1Ehr2YVft3yZFjrprfOJ1yVDTg(final SavingGoalEntryView savingGoalEntryView, View view) {
        Intrinsics.checkNotNullParameter(savingGoalEntryView, "");
        WeeklyAutoTopUpBottomSheet weeklyAutoTopUpBottomSheet = new WeeklyAutoTopUpBottomSheet();
        int i = savingGoalEntryView.MyBillsEntityDataFactory;
        if (i == -1) {
            i = Calendar.getInstance().get(7);
        }
        weeklyAutoTopUpBottomSheet.getAuthRequestContext = i;
        WeeklyAutoTopUpBottomSheet.WeeklyAutoTopUpListener weeklyAutoTopUpListener = new WeeklyAutoTopUpBottomSheet.WeeklyAutoTopUpListener() { // from class: id.dana.savings.view.SavingGoalEntryView$showWeeklyAutoTopupBottomSheet$1
            @Override // id.dana.savings.view.WeeklyAutoTopUpBottomSheet.WeeklyAutoTopUpListener
            public final void MyBillsEntityDataFactory(int p0) {
                SavingGoalEntryView.this.MyBillsEntityDataFactory = p0;
                DanaTextBoxView danaTextBoxView = (DanaTextBoxView) SavingGoalEntryView.this._$_findCachedViewById(R.id.et_auto_topup);
                if (danaTextBoxView != null) {
                    danaTextBoxView.setText((CharSequence) CollectionsKt.elementAt(SavingGoalEntryView.this.getDays(), p0 - 1));
                }
            }
        };
        Intrinsics.checkNotNullParameter(weeklyAutoTopUpListener, "");
        weeklyAutoTopUpBottomSheet.BuiltInFictitiousFunctionClassFactory = weeklyAutoTopUpListener;
        Context context = savingGoalEntryView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
        weeklyAutoTopUpBottomSheet.show(((FragmentActivity) context).getSupportFragmentManager(), "WeeklyReminderDialogFragment");
    }

    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0150  */
    /* renamed from: $r8$lambda$f4Bod2c3asxs9sYXoe2wcMhO-NA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void m2890$r8$lambda$f4Bod2c3asxs9sYXoe2wcMhONA(android.view.View.OnFocusChangeListener r2, com.google.android.material.textfield.TextInputLayout r3, android.widget.EditText r4, id.dana.savings.view.SavingGoalEntryView r5, int r6, int r7, android.view.View r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.view.SavingGoalEntryView.m2890$r8$lambda$f4Bod2c3asxs9sYXoe2wcMhONA(android.view.View$OnFocusChangeListener, com.google.android.material.textfield.TextInputLayout, android.widget.EditText, id.dana.savings.view.SavingGoalEntryView, int, int, android.view.View, boolean):void");
    }

    public static /* synthetic */ String $r8$lambda$oBW59nyfSYt4c6AOTkkNiprFY9Q(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return new Regex("[^0-9]").replace(charSequence.toString(), "");
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        BuiltInFictitiousFunctionClassFactory((DanaTextBoxView) _$_findCachedViewById(R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a0696), (TextInputLayout) _$_findCachedViewById(R.id.til_goal_title), R.string.goal_title_hint, R.string.goal_title_hint_focused);
        BuiltInFictitiousFunctionClassFactory((DanaTextBoxView) _$_findCachedViewById(R.id.MatrixEvaluator), (TextInputLayout) _$_findCachedViewById(R.id.GetGroupFavoriteValue), R.string.goal_hint, R.string.goal_hint_focused);
        BuiltInFictitiousFunctionClassFactory((DanaTextBoxView) _$_findCachedViewById(R.id.createOauthGrantLoadingIntent), (TextInputLayout) _$_findCachedViewById(R.id.til_auto_topup_amount), R.string.goal_hint, R.string.goal_hint_focused);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_total_saving_limit_tooltip);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.SavingGoalEntryView$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SavingGoalEntryView.$r8$lambda$K7fanJtCrkN3UyJMRFXNOU6jeUE(SavingGoalEntryView.this, view);
                }
            });
        }
        final DanaTextBoxView danaTextBoxView = (DanaTextBoxView) _$_findCachedViewById(R.id.MatrixEvaluator);
        if (danaTextBoxView != null) {
            danaTextBoxView.addTextChangedListener(new TextWatcher() { // from class: id.dana.savings.view.SavingGoalEntryView$setupGoalTarget$1$1

                /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
                private int KClassImpl$Data$declaredNonStaticMembers$2;

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    String obj;
                    String format;
                    if (p0 == null || (obj = p0.toString()) == null) {
                        return;
                    }
                    String replace = new Regex("[^0-9]").replace(obj, "");
                    if (replace != null) {
                        DanaTextBoxView danaTextBoxView2 = DanaTextBoxView.this;
                        if (replace.length() == 0) {
                            danaTextBoxView2.setText("0");
                            return;
                        }
                        SavingGoalEntryView$setupGoalTarget$1$1 savingGoalEntryView$setupGoalTarget$1$1 = this;
                        danaTextBoxView2.removeTextChangedListener(savingGoalEntryView$setupGoalTarget$1$1);
                        if (StringsKt.startsWith$default(replace, "0", false, 2, (Object) null)) {
                            replace = replace.substring(1);
                            Intrinsics.checkNotNullExpressionValue(replace, "");
                        }
                        Locale authRequestContext = LocaleUtil.getAuthRequestContext();
                        Long longOrNull = StringsKt.toLongOrNull(replace);
                        format = NumberFormat.getNumberInstance(authRequestContext).format(longOrNull != null ? longOrNull.longValue() : 0L);
                        Intrinsics.checkNotNullExpressionValue(format, "");
                        danaTextBoxView2.setText(format);
                        Editable text = danaTextBoxView2.getText();
                        int length = text != null ? text.length() : 0;
                        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (i >= length) {
                            i = length;
                        }
                        danaTextBoxView2.setSelection(Math.max(length, i));
                        danaTextBoxView2.addTextChangedListener(savingGoalEntryView$setupGoalTarget$1$1);
                    }
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = String.valueOf(DanaTextBoxView.this.getText()).length() - DanaTextBoxView.this.getSelectionStart();
                }
            });
            danaTextBoxView.addTextChangedListener(new TextWatcher() { // from class: id.dana.savings.view.SavingGoalEntryView$setupGoalTarget$lambda-4$$inlined$doAfterTextChanged$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    TextInputLayout textInputLayout = (TextInputLayout) DanaTextBoxView.this.findViewById(R.id.GetGroupFavoriteValue);
                    if (textInputLayout != null) {
                        Context context = DanaTextBoxView.this.getContext();
                        boolean z = false;
                        if (p0 != null) {
                            if (p0.length() == 0) {
                                z = true;
                            }
                        }
                        textInputLayout.setHint(context.getString(z ? R.string.goal_hint : R.string.goal_hint_focused));
                    }
                }
            });
        }
        final DanaTextBoxView danaTextBoxView2 = (DanaTextBoxView) _$_findCachedViewById(R.id.createOauthGrantLoadingIntent);
        if (danaTextBoxView2 != null) {
            danaTextBoxView2.addTextChangedListener(new TextWatcher() { // from class: id.dana.savings.view.SavingGoalEntryView$setupGoalTarget$2$1
                private int PlaceComponentResult;

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    String obj;
                    String format;
                    if (p0 == null || (obj = p0.toString()) == null) {
                        return;
                    }
                    String replace = new Regex("[^0-9]").replace(obj, "");
                    if (replace != null) {
                        DanaTextBoxView danaTextBoxView3 = DanaTextBoxView.this;
                        if (replace.length() == 0) {
                            danaTextBoxView3.setText("0");
                            return;
                        }
                        SavingGoalEntryView$setupGoalTarget$2$1 savingGoalEntryView$setupGoalTarget$2$1 = this;
                        danaTextBoxView3.removeTextChangedListener(savingGoalEntryView$setupGoalTarget$2$1);
                        if (StringsKt.startsWith$default(replace, "0", false, 2, (Object) null)) {
                            replace = replace.substring(1);
                            Intrinsics.checkNotNullExpressionValue(replace, "");
                        }
                        Locale authRequestContext = LocaleUtil.getAuthRequestContext();
                        Long longOrNull = StringsKt.toLongOrNull(replace);
                        format = NumberFormat.getNumberInstance(authRequestContext).format(longOrNull != null ? longOrNull.longValue() : 0L);
                        Intrinsics.checkNotNullExpressionValue(format, "");
                        danaTextBoxView3.setText(format);
                        Editable text = danaTextBoxView3.getText();
                        int length = text != null ? text.length() : 0;
                        int i = this.PlaceComponentResult;
                        if (i >= length) {
                            i = length;
                        }
                        danaTextBoxView3.setSelection(Math.max(length, i));
                        danaTextBoxView3.addTextChangedListener(savingGoalEntryView$setupGoalTarget$2$1);
                    }
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    this.PlaceComponentResult = String.valueOf(DanaTextBoxView.this.getText()).length() - DanaTextBoxView.this.getSelectionStart();
                }
            });
        }
        RadioButton radioButton = (RadioButton) _$_findCachedViewById(R.id.rb_not_active);
        if (radioButton != null) {
            radioButton.setChecked(true);
        }
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(R.id.res_0x7f0a1075_descriptorvisibilities_4);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: id.dana.savings.view.SavingGoalEntryView$$ExternalSyntheticLambda2
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    SavingGoalEntryView.m2889$r8$lambda$08TBUdk7XvxJuraXZlpm38enwY(SavingGoalEntryView.this, radioGroup2, i);
                }
            });
        }
        DanaTextBoxView danaTextBoxView3 = (DanaTextBoxView) _$_findCachedViewById(R.id.MatrixEvaluator);
        if (danaTextBoxView3 != null) {
            addDisposable(Observable.combineLatest(RxTextView.textChanges(danaTextBoxView3).subscribeOn(Schedulers.MyBillsEntityDataFactory()).debounce(100L, TimeUnit.MILLISECONDS).map(new Function() { // from class: id.dana.savings.view.SavingGoalEntryView$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SavingGoalEntryView.$r8$lambda$oBW59nyfSYt4c6AOTkkNiprFY9Q((CharSequence) obj);
                }
            }).observeOn(AndroidSchedulers.PlaceComponentResult()), RxTextView.textChanges((DanaTextBoxView) _$_findCachedViewById(R.id.NetworkMerchantInfoEntityData_Factory_res_0x7f0a0696)).subscribeOn(Schedulers.MyBillsEntityDataFactory()).debounce(100L, TimeUnit.MILLISECONDS).map(new Function() { // from class: id.dana.savings.view.SavingGoalEntryView$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    String obj2;
                    obj2 = ((CharSequence) obj).toString();
                    return obj2;
                }
            }).observeOn(AndroidSchedulers.PlaceComponentResult()), new BiFunction() { // from class: id.dana.savings.view.SavingGoalEntryView$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SavingGoalEntryView.$r8$lambda$HYmPEr4vser9LhRk6j_Gz9bu44M((String) obj, (String) obj2);
                }
            }).subscribe(new Consumer() { // from class: id.dana.savings.view.SavingGoalEntryView$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    SavingGoalEntryView.$r8$lambda$6nu25XiEe9gWql_a9X5OJldFH_E(SavingGoalEntryView.this, (Pair) obj);
                }
            }));
        }
    }
}
