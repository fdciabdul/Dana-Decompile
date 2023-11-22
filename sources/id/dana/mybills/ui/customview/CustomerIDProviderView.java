package id.dana.mybills.ui.customview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.view.C0207ViewKt;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ViewCustomerIdProviderBinding;
import id.dana.mybills.ui.customview.CustomerIDProviderView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00029:B/\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00105\u001a\u000204\u0012\b\b\u0002\u00106\u001a\u000204¢\u0006\u0004\b7\u00108J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\fJ!\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\fJ\u0015\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0011\u0010$\u001a\u00020!8G¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010&\u001a\u00020!8G¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\u00138\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b \u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0011\u0010/\u001a\u00020-8G¢\u0006\u0006\u001a\u0004\b\u0004\u0010."}, d2 = {"Lid/dana/mybills/ui/customview/CustomerIDProviderView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/ViewCustomerIdProviderBinding;", "", "getText", "()Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/mybills/databinding/ViewCustomerIdProviderBinding;", "", "isVisible", "", "setClearTextVisible", "(Z)V", "isEnable", "setCustomerIDEnable", ContainerUIProvider.KEY_SHOW, "msg", "setErrorMessage", "(ZLjava/lang/String;)V", "Lid/dana/mybills/ui/customview/CustomerIDProviderView$OnTextChangedListener;", "onTextChanged", "setListenerTextChanged", "(Lid/dana/mybills/ui/customview/CustomerIDProviderView$OnTextChangedListener;)V", "isShow", "setLoadingVisibility", "str", "setText", "(Ljava/lang/String;)V", "setup", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "getAuthRequestContext", "Landroid/widget/TextView;", "getLabelText", "()Landroid/widget/TextView;", "labelText", "getLoadingText", "loadingText", "Lid/dana/mybills/ui/customview/CustomerIDProviderView$OnTextChangedListener;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/Job;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/Job;", "PlaceComponentResult", "Landroid/widget/EditText;", "()Landroid/widget/EditText;", "text", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnTextChangedListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class CustomerIDProviderView extends BaseViewBindingRichView<ViewCustomerIdProviderBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Job PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private OnTextChangedListener MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/ui/customview/CustomerIDProviderView$OnTextChangedListener;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnTextChangedListener {
        void MyBillsEntityDataFactory(String p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerIDProviderView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerIDProviderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomerIDProviderView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ CustomerIDProviderView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerIDProviderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @JvmName(name = "getLabelText")
    public final TextView getLabelText() {
        TextView textView = getBinding().getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        return textView;
    }

    @JvmName(name = "getText")
    public final EditText getText() {
        EditText editText = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        return editText;
    }

    @JvmName(name = "getLoadingText")
    public final TextView getLoadingText() {
        TextView textView = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        return textView;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCustomerIdProviderBinding inflateViewBinding() {
        ViewCustomerIdProviderBinding BuiltInFictitiousFunctionClassFactory = ViewCustomerIdProviderBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        final ViewCustomerIdProviderBinding binding = getBinding();
        binding.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.CustomerIDProviderView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomerIDProviderView.$r8$lambda$GlVI5YI4xLq3oNCwfHiMsZqWtMk(ViewCustomerIdProviderBinding.this, view);
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.mybills.ui.customview.CustomerIDProviderView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                CustomerIDProviderView.$r8$lambda$QNbdLMMexBWIKTySZlPad2VnUvU(CustomerIDProviderView.this, view, z);
            }
        });
        EditText editText = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.mybills.ui.customview.CustomerIDProviderView$setup$lambda-3$$inlined$doAfterTextChanged$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                Job job;
                LifecycleCoroutineScope PlaceComponentResult;
                CustomerIDProviderView.OnTextChangedListener onTextChangedListener;
                CustomerIDProviderView.access$setFocusCustomerID(CustomerIDProviderView.this);
                Job job2 = null;
                CustomerIDProviderView.OnTextChangedListener onTextChangedListener2 = null;
                job2 = null;
                if (String.valueOf(p0).length() == 0) {
                    CustomerIDProviderView.this.setLoadingVisibility(false);
                    onTextChangedListener = CustomerIDProviderView.this.MyBillsEntityDataFactory;
                    if (onTextChangedListener == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        onTextChangedListener2 = onTextChangedListener;
                    }
                    onTextChangedListener2.MyBillsEntityDataFactory("");
                    return;
                }
                CustomerIDProviderView.this.setLoadingVisibility(true);
                job = CustomerIDProviderView.this.PlaceComponentResult;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                CustomerIDProviderView customerIDProviderView = CustomerIDProviderView.this;
                LifecycleOwner PlaceComponentResult2 = C0207ViewKt.PlaceComponentResult(customerIDProviderView);
                if (PlaceComponentResult2 != null && (PlaceComponentResult = LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult2)) != null) {
                    job2 = BuildersKt__Builders_commonKt.launch$default(PlaceComponentResult, null, null, new CustomerIDProviderView$setup$1$2$1(CustomerIDProviderView.this, p0, null), 3, null);
                }
                customerIDProviderView.PlaceComponentResult = job2;
            }
        });
        binding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.CustomerIDProviderView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomerIDProviderView.m2681$r8$lambda$MXCm2Ht9DsWjCnrS1v9eKMBWx8(CustomerIDProviderView.this, view);
            }
        });
    }

    public final void setCustomerIDEnable(boolean isEnable) {
        getBinding().BuiltInFictitiousFunctionClassFactory.setEnabled(isEnable);
    }

    public final void setClearTextVisible(boolean isVisible) {
        ImageView imageView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(isVisible ? 0 : 8);
    }

    public static /* synthetic */ void setErrorMessage$default(CustomerIDProviderView customerIDProviderView, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        customerIDProviderView.setErrorMessage(z, str);
    }

    public final void setErrorMessage(boolean r4, String msg) {
        this.getAuthRequestContext = r4;
        ViewCustomerIdProviderBinding binding = getBinding();
        TextView textView = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(r4 ? 0 : 8);
        binding.scheduleImpl.setText(msg);
        binding.scheduleImpl.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.DatabaseTableConfigUtil));
        if (this.getAuthRequestContext) {
            binding.getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_red_border_8dp);
        } else {
            binding.getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_grey_border_8dp);
        }
    }

    public final void setLoadingVisibility(boolean isShow) {
        ViewCustomerIdProviderBinding binding = getBinding();
        ProgressBar progressBar = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(progressBar, "");
        progressBar.setVisibility(isShow ? 0 : 8);
        TextView textView = binding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(isShow ? 0 : 8);
    }

    public final void setListenerTextChanged(OnTextChangedListener onTextChanged) {
        Intrinsics.checkNotNullParameter(onTextChanged, "");
        this.MyBillsEntityDataFactory = onTextChanged;
    }

    /* renamed from: getText */
    public final String m2682getText() {
        return getBinding().BuiltInFictitiousFunctionClassFactory.getText().toString();
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        getBinding().BuiltInFictitiousFunctionClassFactory.setText(str);
    }

    public static /* synthetic */ void $r8$lambda$GlVI5YI4xLq3oNCwfHiMsZqWtMk(ViewCustomerIdProviderBinding viewCustomerIdProviderBinding, View view) {
        Intrinsics.checkNotNullParameter(viewCustomerIdProviderBinding, "");
        viewCustomerIdProviderBinding.BuiltInFictitiousFunctionClassFactory.setFocusable(true);
    }

    /* renamed from: $r8$lambda$MXCm2Ht9DsWjCnrS1v9e-KMBWx8 */
    public static /* synthetic */ void m2681$r8$lambda$MXCm2Ht9DsWjCnrS1v9eKMBWx8(CustomerIDProviderView customerIDProviderView, View view) {
        Intrinsics.checkNotNullParameter(customerIDProviderView, "");
        customerIDProviderView.getBinding().BuiltInFictitiousFunctionClassFactory.setText("");
        customerIDProviderView.setClearTextVisible(false);
        setErrorMessage$default(customerIDProviderView, false, null, 2, null);
        customerIDProviderView.getBinding().getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_yellow_border_8dp);
    }

    public static /* synthetic */ void $r8$lambda$QNbdLMMexBWIKTySZlPad2VnUvU(CustomerIDProviderView customerIDProviderView, View view, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(customerIDProviderView, "");
        ConstraintLayout constraintLayout = customerIDProviderView.getBinding().getAuthRequestContext;
        if (customerIDProviderView.getAuthRequestContext) {
            i = R.drawable.bg_white_rounded_red_border_8dp;
        } else {
            i = z ? R.drawable.bg_white_rounded_yellow_border_8dp : R.drawable.bg_white_rounded_grey_border_8dp;
        }
        constraintLayout.setBackgroundResource(i);
        if (z) {
            return;
        }
        KeyboardHelper.getAuthRequestContext(view);
    }

    public static final /* synthetic */ void access$setFocusCustomerID(CustomerIDProviderView customerIDProviderView) {
        customerIDProviderView.setClearTextVisible(false);
        setErrorMessage$default(customerIDProviderView, false, null, 2, null);
        customerIDProviderView.getBinding().getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_yellow_border_8dp);
    }
}
