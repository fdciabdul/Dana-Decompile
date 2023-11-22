package id.dana.mybills.ui.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.component.dividercomponent.DanaDividerView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ViewDropdownMyBillsBinding;
import id.dana.mybills.ui.model.DropdownOptionsModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\\]B'\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010W\u001a\u00020P¢\u0006\u0004\bX\u0010YB+\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010W\u001a\u00020P\u0012\u0006\u0010Z\u001a\u00020P¢\u0006\u0004\bX\u0010[J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u0019J#\u0010!\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0003¢\u0006\u0004\b#\u0010\u0005J!\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020%¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\r¢\u0006\u0004\b-\u0010\u0010J\u0015\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020%¢\u0006\u0004\b/\u0010+J\u0015\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b4\u0010\u0010J\u001b\u00106\u001a\u00020\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u00020\rH\u0002¢\u0006\u0004\b9\u0010\u0010J\u0015\u0010;\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\b¢\u0006\u0004\b;\u0010<J\u0015\u0010>\u001a\u00020\u00032\u0006\u0010=\u001a\u00020%¢\u0006\u0004\b>\u0010+J\u0015\u0010@\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\r¢\u0006\u0004\b@\u0010\u0010J\u000f\u0010A\u001a\u00020\u0003H\u0002¢\u0006\u0004\bA\u0010\u0005J\u000f\u0010B\u001a\u00020\u0003H\u0016¢\u0006\u0004\bB\u0010\u0005J\u001b\u0010C\u001a\u00020\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\bC\u00107J\u000f\u0010D\u001a\u00020\u0003H\u0002¢\u0006\u0004\bD\u0010\u0005J\u0015\u0010E\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\r¢\u0006\u0004\bE\u0010\u0010R\u0016\u0010G\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010FR\u0014\u00109\u001a\u00020\r8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\bD\u0010HR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010HR\u0016\u0010A\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010D\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010IR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010HR\u0016\u0010V\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010F"}, d2 = {"Lid/dana/mybills/ui/customview/CustomDropdownView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/ViewDropdownMyBillsBinding;", "", "clearSelectedOption", "()V", "closeDropDownButton", "", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "getItemOptions", "()Ljava/util/List;", "getSelectedOption", "()Lid/dana/mybills/ui/model/DropdownOptionsModel;", "", "isShow", "hasToShowDropdownSelectedValue", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "inflateViewBinding", "()Lid/dana/mybills/databinding/ViewDropdownMyBillsBinding;", "isActivated", "dropdownArrowHidden", "isDropDownViewActivated", "(ZZ)V", "isOnFocusSearchBar", "()Z", "isOptionHasSelected", "()Ljava/lang/Boolean;", "isOptionsVisible", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "resetDropdown", ContainerUIProvider.KEY_SHOW, "", "msg", "setErrorMessage", "(ZLjava/lang/String;)V", "hint", "setHintDropdown", "(Ljava/lang/String;)V", "value", "setIsNeedToShowSearchText", "message", "setLabelInformation", "Lid/dana/mybills/ui/customview/CustomDropdownView$OnItemSelectedListener;", "onItemSelectedListener", "setListenerItemSelected", "(Lid/dana/mybills/ui/customview/CustomDropdownView$OnItemSelectedListener;)V", "setLoadingVisibility", SecurityConstants.KEY_OPTIONS, "setOptions", "(Ljava/util/List;)V", "p0", "MyBillsEntityDataFactory", "selectedOption", "setSelected", "(Lid/dana/mybills/ui/model/DropdownOptionsModel;)V", "title", GriverEvents.EVENT_SET_TITLE, "isVisible", "setTvDropdownSelectedValueVisible", "PlaceComponentResult", "setup", "setupRecyclerView", "BuiltInFictitiousFunctionClassFactory", "showOptions", "Ljava/lang/String;", "getAuthRequestContext", "Z", "Lid/dana/mybills/ui/customview/CustomDropdownView$OnItemSelectedListener;", "Lid/dana/mybills/ui/customview/DropdownOptionAdapter;", "lookAheadTest", "Lid/dana/mybills/ui/customview/DropdownOptionAdapter;", "scheduleImpl", "Ljava/util/List;", "moveToNextValue", "", "getErrorConfigVersion", "I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnItemSelectedListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomDropdownView extends BaseViewBindingRichView<ViewDropdownMyBillsBinding> {
    public static final float ITEM_HEIGHT = 40.0f;
    public static final int MAX_VISIBLE_OPTIONS = 3;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private OnItemSelectedListener BuiltInFictitiousFunctionClassFactory;
    private DropdownOptionsModel NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    private int getErrorConfigVersion;
    private final DropdownOptionAdapter lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private List<DropdownOptionsModel> moveToNextValue;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/ui/customview/CustomDropdownView$OnItemSelectedListener;", "", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/ui/model/DropdownOptionsModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnItemSelectedListener {
        void BuiltInFictitiousFunctionClassFactory(DropdownOptionsModel p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomDropdownView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomDropdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    public /* synthetic */ CustomDropdownView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomDropdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
        this.getAuthRequestContext = "";
        this.getErrorConfigVersion = R.drawable.ic_arrow_grey_80;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DropdownOptionsModel(null, null, null, null, null, 31, null);
        this.moveToNextValue = new ArrayList();
        this.scheduleImpl = true;
        this.lookAheadTest = new DropdownOptionAdapter(new Function1<DropdownOptionsModel, Unit>() { // from class: id.dana.mybills.ui.customview.CustomDropdownView$optionAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DropdownOptionsModel dropdownOptionsModel) {
                invoke2(dropdownOptionsModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DropdownOptionsModel dropdownOptionsModel) {
                DropdownOptionsModel dropdownOptionsModel2;
                Intrinsics.checkNotNullParameter(dropdownOptionsModel, "");
                CustomDropdownView.this.MyBillsEntityDataFactory(false);
                CustomDropdownView.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = dropdownOptionsModel;
                CustomDropdownView customDropdownView = CustomDropdownView.this;
                dropdownOptionsModel2 = customDropdownView.NetworkUserEntityData$$ExternalSyntheticLambda0;
                customDropdownView.setSelected(dropdownOptionsModel2);
                CustomDropdownView.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomDropdownView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
        this.getAuthRequestContext = "";
        this.getErrorConfigVersion = R.drawable.ic_arrow_grey_80;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DropdownOptionsModel(null, null, null, null, null, 31, null);
        this.moveToNextValue = new ArrayList();
        this.scheduleImpl = true;
        this.lookAheadTest = new DropdownOptionAdapter(new Function1<DropdownOptionsModel, Unit>() { // from class: id.dana.mybills.ui.customview.CustomDropdownView$optionAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DropdownOptionsModel dropdownOptionsModel) {
                invoke2(dropdownOptionsModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DropdownOptionsModel dropdownOptionsModel) {
                DropdownOptionsModel dropdownOptionsModel2;
                Intrinsics.checkNotNullParameter(dropdownOptionsModel, "");
                CustomDropdownView.this.MyBillsEntityDataFactory(false);
                CustomDropdownView.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = dropdownOptionsModel;
                CustomDropdownView customDropdownView = CustomDropdownView.this;
                dropdownOptionsModel2 = customDropdownView.NetworkUserEntityData$$ExternalSyntheticLambda0;
                customDropdownView.setSelected(dropdownOptionsModel2);
                CustomDropdownView.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDropdownMyBillsBinding inflateViewBinding() {
        ViewDropdownMyBillsBinding authRequestContext = ViewDropdownMyBillsBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context r3, AttributeSet attrs) {
        Resources.Theme theme;
        TypedArray obtainStyledAttributes;
        if (attrs == null || r3 == null || (theme = r3.getTheme()) == null || (obtainStyledAttributes = theme.obtainStyledAttributes(attrs, R.styleable.O, 0, 0)) == null) {
            return;
        }
        try {
            String string = obtainStyledAttributes.getString(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda0);
            if (string == null) {
                string = "";
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = string;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void closeDropDownButton() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            return;
        }
        getBinding().getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_grey_border_8dp);
        KClassImpl$Data$declaredNonStaticMembers$2();
        MyBillsEntityDataFactory(false);
    }

    public final boolean isOnFocusSearchBar() {
        return getBinding().KClassImpl$Data$declaredNonStaticMembers$2.hasFocus();
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        getBinding().DatabaseTableConfigUtil.setText(str);
    }

    public final void setHintDropdown(String hint) {
        Intrinsics.checkNotNullParameter(hint, "");
        if (hint.length() > 0) {
            this.getAuthRequestContext = hint;
        }
        PlaceComponentResult();
    }

    public final void setTvDropdownSelectedValueVisible(boolean isVisible) {
        TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(isVisible ? 0 : 8);
    }

    public final void hasToShowDropdownSelectedValue(boolean isShow) {
        this.scheduleImpl = isShow;
    }

    public static /* synthetic */ void isDropDownViewActivated$default(CustomDropdownView customDropdownView, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        customDropdownView.isDropDownViewActivated(z, z2);
    }

    public final void isDropDownViewActivated(boolean isActivated, boolean dropdownArrowHidden) {
        Drawable PlaceComponentResult;
        ViewDropdownMyBillsBinding binding = getBinding();
        binding.getAuthRequestContext.setEnabled(isActivated);
        if (dropdownArrowHidden) {
            RelativeLayout relativeLayout = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
            relativeLayout.setVisibility(isActivated ? 0 : 8);
        }
        binding.lookAheadTest.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.initRecordTimeStamp));
        ConstraintLayout constraintLayout = binding.getAuthRequestContext;
        if (isActivated) {
            PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), R.drawable.bg_white_rounded_grey_border_8dp);
        } else {
            PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), R.drawable.bg_grey_rounded_grey_border_8dp);
        }
        constraintLayout.setBackground(PlaceComponentResult);
    }

    public final void MyBillsEntityDataFactory(boolean p0) {
        ViewDropdownMyBillsBinding binding = getBinding();
        if (p0) {
            this.getErrorConfigVersion = R.drawable.ic_search_provider;
            binding.BuiltInFictitiousFunctionClassFactory.setRotation(0.0f);
        } else {
            this.getErrorConfigVersion = R.drawable.ic_arrow_grey_80;
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setText("");
        }
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().BuiltInFictitiousFunctionClassFactory, this.getErrorConfigVersion);
        EditText editText = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        editText.setVisibility(p0 ? 0 : 8);
        TextView textView = binding.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(p0 ^ true ? 0 : 8);
    }

    public final void setSelected(DropdownOptionsModel selectedOption) {
        Integer icon;
        Intrinsics.checkNotNullParameter(selectedOption, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = selectedOption;
        DropdownOptionAdapter dropdownOptionAdapter = this.lookAheadTest;
        dropdownOptionAdapter.getAuthRequestContext = selectedOption;
        dropdownOptionAdapter.notifyDataSetChanged();
        TextView textView = getBinding().lookAheadTest;
        textView.setText(selectedOption.getName());
        textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getBinding().getErrorConfigVersion.getContext(), R.color.getErrorConfigVersion));
        TextView textView2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(this.scheduleImpl ? 0 : 8);
        textView2.setText(selectedOption.getValue());
        if (selectedOption.getIcon() != null && ((icon = selectedOption.getIcon()) == null || icon.intValue() != 0)) {
            ImageView imageView = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            imageView.setVisibility(0);
            Glide.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().getErrorConfigVersion.getContext()).getAuthRequestContext(selectedOption.getIcon()).MyBillsEntityDataFactory(imageView);
        } else {
            ImageView imageView2 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(imageView2, "");
            imageView2.setVisibility(8);
        }
        OnItemSelectedListener onItemSelectedListener = this.BuiltInFictitiousFunctionClassFactory;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.BuiltInFictitiousFunctionClassFactory(selectedOption);
        }
    }

    private final void PlaceComponentResult() {
        TextView textView = getBinding().lookAheadTest;
        textView.setText(this.getAuthRequestContext);
        textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getBinding().getErrorConfigVersion.getContext(), R.color.scheduleImpl));
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1.setText("");
        ImageView imageView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
    }

    public final void setOptions(List<DropdownOptionsModel> r4) {
        Intrinsics.checkNotNullParameter(r4, "");
        this.moveToNextValue = r4;
        setupRecyclerView(r4);
        int size = r4.size();
        int authRequestContext = ViewExtKt.getAuthRequestContext(40.0f);
        ViewGroup.LayoutParams layoutParams = getBinding().scheduleImpl.getLayoutParams();
        if (size > 3) {
            layoutParams.height = authRequestContext * 3;
        } else {
            layoutParams.height = authRequestContext * size;
        }
        getBinding().scheduleImpl.setLayoutParams(layoutParams);
    }

    public final List<DropdownOptionsModel> getItemOptions() {
        return this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void setupRecyclerView(List<DropdownOptionsModel> r4) {
        Intrinsics.checkNotNullParameter(r4, "");
        this.lookAheadTest.PlaceComponentResult = this.scheduleImpl;
        DropdownOptionAdapter dropdownOptionAdapter = this.lookAheadTest;
        Intrinsics.checkNotNullParameter(r4, "");
        dropdownOptionAdapter.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        dropdownOptionAdapter.KClassImpl$Data$declaredNonStaticMembers$2.addAll(r4);
        dropdownOptionAdapter.getAuthRequestContext = null;
        dropdownOptionAdapter.notifyDataSetChanged();
        DropdownOptionAdapter dropdownOptionAdapter2 = this.lookAheadTest;
        dropdownOptionAdapter2.getAuthRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        dropdownOptionAdapter2.notifyDataSetChanged();
        getBinding().scheduleImpl.setAdapter(this.lookAheadTest);
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult = true;
        ViewDropdownMyBillsBinding binding = getBinding();
        binding.BuiltInFictitiousFunctionClassFactory.setRotation(180.0f);
        RecyclerView recyclerView = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(this.PlaceComponentResult ? 0 : 8);
        DanaDividerView danaDividerView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(danaDividerView, "");
        danaDividerView.setVisibility(this.PlaceComponentResult ? 0 : 8);
        binding.scheduleImpl.requestFocus();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult = false;
        String name = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getName();
        if (!(name == null || name.length() == 0)) {
            setSelected(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        } else {
            setHintDropdown(this.getAuthRequestContext);
        }
        ViewDropdownMyBillsBinding binding = getBinding();
        binding.BuiltInFictitiousFunctionClassFactory.setRotation(0.0f);
        RecyclerView recyclerView = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(this.PlaceComponentResult ? 0 : 8);
        DanaDividerView danaDividerView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(danaDividerView, "");
        danaDividerView.setVisibility(this.PlaceComponentResult ? 0 : 8);
    }

    public final void showOptions(boolean r1) {
        if (r1) {
            BuiltInFictitiousFunctionClassFactory();
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public final Boolean isOptionHasSelected() {
        String id2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getId();
        if (id2 != null) {
            return Boolean.valueOf(id2.length() > 0);
        }
        return null;
    }

    /* renamed from: getSelectedOption  reason: from getter */
    public final DropdownOptionsModel getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final void clearSelectedOption() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DropdownOptionsModel(null, null, null, null, null, 31, null);
        PlaceComponentResult();
    }

    public final void setListenerItemSelected(OnItemSelectedListener onItemSelectedListener) {
        Intrinsics.checkNotNullParameter(onItemSelectedListener, "");
        this.BuiltInFictitiousFunctionClassFactory = onItemSelectedListener;
    }

    public final boolean isOptionsVisible() {
        RecyclerView recyclerView = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        return recyclerView.getVisibility() == 0;
    }

    public final void setLabelInformation(String message) {
        Intrinsics.checkNotNullParameter(message, "");
        TextView textView = getBinding().initRecordTimeStamp;
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, R.style.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        textView.setText(message);
        getBinding().getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_grey_border_8dp);
    }

    public static /* synthetic */ void setErrorMessage$default(CustomDropdownView customDropdownView, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        customDropdownView.setErrorMessage(z, str);
    }

    public final void setErrorMessage(boolean r4, String msg) {
        ViewDropdownMyBillsBinding binding = getBinding();
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(binding.initRecordTimeStamp, R.style.PlaceComponentResult);
        TextView textView = binding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(r4 ? 0 : 8);
        binding.initRecordTimeStamp.setText(msg);
        if (r4) {
            binding.getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_red_border_8dp);
        } else {
            binding.getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_grey_border_8dp);
        }
    }

    public final void setLoadingVisibility(boolean isShow) {
        AppCompatImageView appCompatImageView = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(isShow ^ true ? 0 : 8);
        ProgressBar progressBar = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(progressBar, "");
        progressBar.setVisibility(isShow ? 0 : 8);
    }

    public static /* synthetic */ void $r8$lambda$GN9YUP4HUgGbPTn9lmi7iPVqe2I(CustomDropdownView customDropdownView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        if (z) {
            return;
        }
        customDropdownView.MyBillsEntityDataFactory(false);
        KeyboardHelper.getAuthRequestContext(view);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(customDropdownView.getBinding().BuiltInFictitiousFunctionClassFactory, customDropdownView.getErrorConfigVersion);
        customDropdownView.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* renamed from: $r8$lambda$S02-r6pn6SWhApDO4B6XyudAESY */
    public static /* synthetic */ void m2678$r8$lambda$S02r6pn6SWhApDO4B6XyudAESY(CustomDropdownView customDropdownView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        KeyboardHelper.getAuthRequestContext(view);
        if (z) {
            customDropdownView.getBinding().getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_yellow_border_8dp);
            customDropdownView.BuiltInFictitiousFunctionClassFactory();
        } else if (customDropdownView.MyBillsEntityDataFactory) {
        } else {
            customDropdownView.getBinding().getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_grey_border_8dp);
            customDropdownView.KClassImpl$Data$declaredNonStaticMembers$2();
            customDropdownView.MyBillsEntityDataFactory(false);
        }
    }

    public final void resetDropdown() {
        DropdownOptionAdapter dropdownOptionAdapter = this.lookAheadTest;
        dropdownOptionAdapter.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        dropdownOptionAdapter.getAuthRequestContext = null;
        clearSelectedOption();
        showOptions(false);
    }

    public final void setIsNeedToShowSearchText(boolean value) {
        this.MyBillsEntityDataFactory = value;
        MyBillsEntityDataFactory(value);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        setTitle(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        ViewDropdownMyBillsBinding binding = getBinding();
        RecyclerView recyclerView = binding.scheduleImpl;
        recyclerView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.mybills.ui.customview.CustomDropdownView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                CustomDropdownView.m2678$r8$lambda$S02r6pn6SWhApDO4B6XyudAESY(CustomDropdownView.this, view, z);
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.mybills.ui.customview.CustomDropdownView$setupView$1$1$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 == 0) {
                    CustomDropdownView.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                } else if (p1 == 1) {
                    CustomDropdownView.this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                }
            }
        });
        EditText editText = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.mybills.ui.customview.CustomDropdownView$setupView$lambda-8$lambda-7$$inlined$doAfterTextChanged$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                List<DropdownOptionsModel> list;
                ArrayList arrayList = new ArrayList();
                list = CustomDropdownView.this.moveToNextValue;
                for (DropdownOptionsModel dropdownOptionsModel : list) {
                    String name = dropdownOptionsModel.getName();
                    if (name == null) {
                        name = "";
                    }
                    String str = name;
                    String obj = p0 != null ? p0.toString() : null;
                    if (StringsKt.contains((CharSequence) str, (CharSequence) (obj != null ? obj : ""), true)) {
                        arrayList.add(dropdownOptionsModel);
                    }
                }
                CustomDropdownView.this.setupRecyclerView(arrayList);
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.mybills.ui.customview.CustomDropdownView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                CustomDropdownView.$r8$lambda$GN9YUP4HUgGbPTn9lmi7iPVqe2I(CustomDropdownView.this, view, z);
            }
        });
    }
}
