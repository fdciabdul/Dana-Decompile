package id.dana.sendmoney.ui.globalsend.form.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.TextViewCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ViewEditTextFormBinding;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\u0018\u0000 \u007f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u007f\u0080\u0001\u0081\u0001B/\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010{\u001a\u00020\u0015\u0012\b\b\u0002\u0010|\u001a\u00020\u0015¢\u0006\u0004\b}\u0010~J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\b\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0007J\u0015\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0007J\u0015\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u0016J\u0015\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\"\u0010!J\u0015\u0010#\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b#\u0010\u0007J\u0015\u0010$\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b$\u0010\u0007J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010!J\u0015\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\f¢\u0006\u0004\b'\u0010(R*\u0010.\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\u0016R*\u00101\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010*\u001a\u0004\b/\u0010,\"\u0004\b0\u0010\u0016R*\u00106\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00038\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u0007R*\u00109\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00038\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u00103\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u0007R*\u0010<\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010*\u001a\u0004\b:\u0010,\"\u0004\b;\u0010\u0016R\u0016\u0010\b\u001a\u00020\u001c8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b=\u0010>R*\u0010C\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010(R*\u0010F\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010*\u001a\u0004\bE\u0010,\"\u0004\b#\u0010\u0016R*\u0010J\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010*\u001a\u0004\bH\u0010,\"\u0004\bI\u0010\u0016R*\u0010L\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010@\u001a\u0004\bL\u0010\u000e\"\u0004\bM\u0010(R*\u0010O\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010@\u001a\u0004\bO\u0010\u000e\"\u0004\bP\u0010(R*\u0010R\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010@\u001a\u0004\bR\u0010\u000e\"\u0004\bS\u0010(R*\u0010U\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010@\u001a\u0004\bU\u0010\u000e\"\u0004\bV\u0010(R\u0016\u00102\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bW\u0010@R*\u0010[\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010*\u001a\u0004\bY\u0010,\"\u0004\bZ\u0010\u0016R6\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00050\\2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\\8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR.\u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050d8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR*\u0010o\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010*\u001a\u0004\bm\u0010,\"\u0004\bn\u0010\u0016R\u0016\u0010 \u001a\u00020p8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bq\u0010rR:\u0010z\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0d\u0012\u0004\u0012\u00020\u00150s8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010y"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/EditTextFormView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/sendmoney/databinding/ViewEditTextFormBinding;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "getAuthRequestContext", "()Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ViewEditTextFormBinding;", "", "isFormValid", "()Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "(I)V", "text", "setAdditionalInfo", "setContent", "accessibilityId", "setEditTextAccessibilityId", "Lid/dana/sendmoney/ui/globalsend/form/view/EditTextFormView$FormValidityListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setFormValidityListener", "(Lid/dana/sendmoney/ui/globalsend/form/view/EditTextFormView$FormValidityListener;)V", "BuiltInFictitiousFunctionClassFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "setHeaderText", "setHint", "setup", "isError", "showErrorText", "(Z)V", "value", "I", "getAdditionalInfoTextRes", "()I", "setAdditionalInfoTextRes", "additionalInfoTextRes", "getCheckBoxText", "setCheckBoxText", "checkBoxText", "PlaceComponentResult", "Ljava/lang/String;", "getEditTextContent", "setEditTextContent", "editTextContent", "getErrorMessageString", "setErrorMessageString", "errorMessageString", "getFormInputType", "setFormInputType", "formInputType", "lookAheadTest", "Lid/dana/sendmoney/ui/globalsend/form/view/EditTextFormView$FormValidityListener;", "scheduleImpl", "Z", "getHasCharCounter", "setHasCharCounter", "hasCharCounter", "getErrorConfigVersion", "getHeaderText", "headerText", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getHintText", "setHintText", "hintText", "moveToNextValue", "isFormEnabled", "setFormEnabled", "NetworkUserEntityData$$ExternalSyntheticLambda2", "isNeedToShowIconSpinner", "setNeedToShowIconSpinner", "initRecordTimeStamp", "isShowCheckBox", "setShowCheckBox", "GetContactSyncConfig", "isShowInfoIcon", "setShowInfoIcon", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "getMaxLengthFormInput", "setMaxLengthFormInput", "maxLengthFormInput", "Lkotlin/Function0;", "isLayoutRequested", "Lkotlin/jvm/functions/Function0;", "getOnImeButtonClickListener", "()Lkotlin/jvm/functions/Function0;", "setOnImeButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "onImeButtonClickListener", "Lkotlin/Function1;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lkotlin/jvm/functions/Function1;", "getOnTextFormChanged", "()Lkotlin/jvm/functions/Function1;", "setOnTextFormChanged", "(Lkotlin/jvm/functions/Function1;)V", "onTextFormChanged", "newProxyInstance", "getSecondaryAdditionalInfoText", "setSecondaryAdditionalInfoText", "secondaryAdditionalInfoText", "Landroid/content/res/TypedArray;", "PrepareContext", "Landroid/content/res/TypedArray;", "", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Ljava/util/Map;", "getValidationRuleList", "()Ljava/util/Map;", "setValidationRuleList", "(Ljava/util/Map;)V", "validationRuleList", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "FormInputType", "FormValidityListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EditTextFormView extends BaseViewBindingRichView<ViewEditTextFormBinding> {
    public static final int DEFAULT_VALUE_INT = 0;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int formInputType;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private int maxLengthFormInput;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean isShowInfoIcon;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int additionalInfoTextRes;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int checkBoxText;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int hintText;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean isNeedToShowIconSpinner;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private Map<Function1<String, Boolean>, Integer> validationRuleList;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private Function1<? super String, Unit> onTextFormChanged;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String editTextContent;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private TypedArray BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String errorMessageString;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int headerText;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean isShowCheckBox;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private Function0<Unit> onImeButtonClickListener;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FormValidityListener getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean isFormEnabled;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private int secondaryAdditionalInfoText;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean hasCharCounter;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/EditTextFormView$FormInputType;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class FormInputType {
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/EditTextFormView$FormValidityListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface FormValidityListener {
        void BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EditTextFormView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EditTextFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EditTextFormView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ EditTextFormView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextFormView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = true;
        this.onTextFormChanged = new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView$onTextFormChanged$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        };
        this.headerText = R.string.header_form_country_destination;
        this.hintText = R.string.header_form_first_name;
        this.isFormEnabled = true;
        this.editTextContent = "";
        this.formInputType = 8192;
        this.checkBoxText = R.string.same_address_checkbox_text;
        this.errorMessageString = "";
        this.onImeButtonClickListener = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView$onImeButtonClickListener$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.validationRuleList = MapsKt.emptyMap();
    }

    @JvmName(name = "getOnTextFormChanged")
    public final Function1<String, Unit> getOnTextFormChanged() {
        return this.onTextFormChanged;
    }

    @JvmName(name = "setOnTextFormChanged")
    public final void setOnTextFormChanged(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onTextFormChanged = function1;
    }

    @JvmName(name = "getHeaderText")
    public final int getHeaderText() {
        return this.headerText;
    }

    @JvmName(name = "setHeaderText")
    public final void setHeaderText(int i) {
        this.headerText = i;
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2.setText(this.headerText);
    }

    @JvmName(name = "getHintText")
    public final int getHintText() {
        return this.hintText;
    }

    @JvmName(name = "setHintText")
    public final void setHintText(int i) {
        this.hintText = i;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setHint(this.hintText);
    }

    @JvmName(name = "isFormEnabled")
    /* renamed from: isFormEnabled  reason: from getter */
    public final boolean getIsFormEnabled() {
        return this.isFormEnabled;
    }

    @JvmName(name = "setFormEnabled")
    public final void setFormEnabled(boolean z) {
        this.isFormEnabled = z;
        DanaTextBoxView danaTextBoxView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        danaTextBoxView.setEnabled(this.isFormEnabled);
        danaTextBoxView.setFocusable(this.isFormEnabled);
    }

    @JvmName(name = "getEditTextContent")
    public final String getEditTextContent() {
        return this.editTextContent;
    }

    @JvmName(name = "setEditTextContent")
    public final void setEditTextContent(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.editTextContent = str;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(this.editTextContent);
    }

    @JvmName(name = "isNeedToShowIconSpinner")
    /* renamed from: isNeedToShowIconSpinner  reason: from getter */
    public final boolean getIsNeedToShowIconSpinner() {
        return this.isNeedToShowIconSpinner;
    }

    @JvmName(name = "setNeedToShowIconSpinner")
    public final void setNeedToShowIconSpinner(boolean z) {
        this.isNeedToShowIconSpinner = z;
        ImageView imageView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(this.isNeedToShowIconSpinner ? 0 : 8);
    }

    @JvmName(name = "getFormInputType")
    public final int getFormInputType() {
        return this.formInputType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005c, code lost:
    
        if (r0 != 4) goto L15;
     */
    @kotlin.jvm.JvmName(name = "setFormInputType")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setFormInputType(int r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L67
            r5.formInputType = r6
            java.lang.String r0 = ""
            r1 = 4
            if (r6 != r1) goto L30
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            id.dana.sendmoney.databinding.ViewEditTextFormBinding r6 = (id.dana.sendmoney.databinding.ViewEditTextFormBinding) r6
            id.dana.component.edittextcomponent.DanaTextBoxView r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            androidx.viewbinding.ViewBinding r2 = r5.getBinding()
            id.dana.sendmoney.databinding.ViewEditTextFormBinding r2 = (id.dana.sendmoney.databinding.ViewEditTextFormBinding) r2
            id.dana.component.edittextcomponent.DanaTextBoxView r2 = r2.KClassImpl$Data$declaredNonStaticMembers$2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.widget.EditText r2 = (android.widget.EditText) r2
            id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView$setupTextChangedListener$1 r0 = new id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView$setupTextChangedListener$1
            r0.<init>()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            id.dana.sendmoney.util.CardNumberTextWatcher r3 = new id.dana.sendmoney.util.CardNumberTextWatcher
            r3.<init>(r2, r0)
            android.text.TextWatcher r3 = (android.text.TextWatcher) r3
            r6.addTextChangedListener(r3)
            goto L47
        L30:
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            id.dana.sendmoney.databinding.ViewEditTextFormBinding r6 = (id.dana.sendmoney.databinding.ViewEditTextFormBinding) r6
            id.dana.component.edittextcomponent.DanaTextBoxView r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            android.widget.TextView r6 = (android.widget.TextView) r6
            id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView$setupTextChangedListener$$inlined$addTextChangedListener$default$1 r0 = new id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView$setupTextChangedListener$$inlined$addTextChangedListener$default$1
            r0.<init>()
            android.text.TextWatcher r0 = (android.text.TextWatcher) r0
            r6.addTextChangedListener(r0)
        L47:
            androidx.viewbinding.ViewBinding r6 = r5.getBinding()
            id.dana.sendmoney.databinding.ViewEditTextFormBinding r6 = (id.dana.sendmoney.databinding.ViewEditTextFormBinding) r6
            id.dana.component.edittextcomponent.DanaTextBoxView r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r5.formInputType
            r2 = 1
            r3 = 2
            r4 = 8192(0x2000, float:1.14794E-41)
            if (r0 == r2) goto L62
            if (r0 == r3) goto L5f
            r2 = 3
            if (r0 == r2) goto L64
            if (r0 == r1) goto L64
            goto L62
        L5f:
            r3 = 32
            goto L64
        L62:
            r3 = 8192(0x2000, float:1.14794E-41)
        L64:
            r6.setInputType(r3)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView.setFormInputType(int):void");
    }

    @JvmName(name = "isShowCheckBox")
    /* renamed from: isShowCheckBox  reason: from getter */
    public final boolean getIsShowCheckBox() {
        return this.isShowCheckBox;
    }

    @JvmName(name = "setShowCheckBox")
    public final void setShowCheckBox(boolean z) {
        this.isShowCheckBox = z;
        Group group = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(this.isShowCheckBox ? 0 : 8);
    }

    @JvmName(name = "getCheckBoxText")
    public final int getCheckBoxText() {
        return this.checkBoxText;
    }

    @JvmName(name = "setCheckBoxText")
    public final void setCheckBoxText(int i) {
        this.checkBoxText = i;
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(this.checkBoxText);
    }

    @JvmName(name = "getHasCharCounter")
    public final boolean getHasCharCounter() {
        return this.hasCharCounter;
    }

    @JvmName(name = "setHasCharCounter")
    public final void setHasCharCounter(boolean z) {
        if (this.hasCharCounter != z) {
            this.hasCharCounter = z;
            getAuthRequestContext(this.headerText);
        }
    }

    @JvmName(name = "getAdditionalInfoTextRes")
    public final int getAdditionalInfoTextRes() {
        return this.additionalInfoTextRes;
    }

    @JvmName(name = "setAdditionalInfoTextRes")
    public final void setAdditionalInfoTextRes(int i) {
        if (i != 0) {
            this.additionalInfoTextRes = i;
            getBinding().lookAheadTest.setText(this.additionalInfoTextRes);
            TextView textView = getBinding().lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = getBinding().lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(8);
    }

    @JvmName(name = "isShowInfoIcon")
    /* renamed from: isShowInfoIcon  reason: from getter */
    public final boolean getIsShowInfoIcon() {
        return this.isShowInfoIcon;
    }

    @JvmName(name = "setShowInfoIcon")
    public final void setShowInfoIcon(boolean z) {
        this.isShowInfoIcon = z;
        ImageView imageView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(this.isShowInfoIcon ? 0 : 8);
    }

    @JvmName(name = "getSecondaryAdditionalInfoText")
    public final int getSecondaryAdditionalInfoText() {
        return this.secondaryAdditionalInfoText;
    }

    @JvmName(name = "setSecondaryAdditionalInfoText")
    public final void setSecondaryAdditionalInfoText(int i) {
        if (i != 0) {
            this.secondaryAdditionalInfoText = i;
            getBinding().initRecordTimeStamp.setText(this.secondaryAdditionalInfoText);
            CardView cardView = getBinding().scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(cardView, "");
            cardView.setVisibility(0);
            return;
        }
        CardView cardView2 = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(cardView2, "");
        cardView2.setVisibility(8);
    }

    @JvmName(name = "getErrorMessageString")
    public final String getErrorMessageString() {
        return this.errorMessageString;
    }

    @JvmName(name = "setErrorMessageString")
    public final void setErrorMessageString(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (Intrinsics.areEqual(str, this.errorMessageString)) {
            return;
        }
        this.errorMessageString = str;
        getBinding().moveToNextValue.setText(this.errorMessageString);
    }

    @JvmName(name = "getOnImeButtonClickListener")
    public final Function0<Unit> getOnImeButtonClickListener() {
        return this.onImeButtonClickListener;
    }

    @JvmName(name = "setOnImeButtonClickListener")
    public final void setOnImeButtonClickListener(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.onImeButtonClickListener = function0;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnEditorActionListener(new EditTextFormView$setupImeActionListener$1(this));
    }

    @JvmName(name = "getMaxLengthFormInput")
    public final int getMaxLengthFormInput() {
        return this.maxLengthFormInput;
    }

    @JvmName(name = "setMaxLengthFormInput")
    public final void setMaxLengthFormInput(int i) {
        if (i > 0) {
            this.maxLengthFormInput = i;
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        }
    }

    private final String getAuthRequestContext() {
        if (this.formInputType == 4) {
            String valueOf = String.valueOf(getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getText());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < valueOf.length(); i++) {
                char charAt = valueOf.charAt(i);
                if (!CharsKt.isWhitespace(charAt)) {
                    sb.append(charAt);
                }
            }
            String obj = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return obj;
        }
        return String.valueOf(getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getText());
    }

    @JvmName(name = "getValidationRuleList")
    public final Map<Function1<String, Boolean>, Integer> getValidationRuleList() {
        return this.validationRuleList;
    }

    @JvmName(name = "setValidationRuleList")
    public final void setValidationRuleList(Map<Function1<String, Boolean>, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.validationRuleList = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(String p0) {
        for (Map.Entry<Function1<String, Boolean>, Integer> entry : this.validationRuleList.entrySet()) {
            Function1<String, Boolean> key = entry.getKey();
            int intValue = entry.getValue().intValue();
            FormValidityListener formValidityListener = null;
            if (!key.invoke(p0).booleanValue()) {
                this.PlaceComponentResult = false;
                FormValidityListener formValidityListener2 = this.getAuthRequestContext;
                if (formValidityListener2 != null) {
                    if (formValidityListener2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        formValidityListener = formValidityListener2;
                    }
                    formValidityListener.BuiltInFictitiousFunctionClassFactory();
                }
                getBinding().moveToNextValue.setText(intValue);
                TextView textView = getBinding().moveToNextValue;
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setVisibility(0);
                KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            this.PlaceComponentResult = true;
            FormValidityListener formValidityListener3 = this.getAuthRequestContext;
            if (formValidityListener3 != null) {
                if (formValidityListener3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    formValidityListener = formValidityListener3;
                }
                formValidityListener.BuiltInFictitiousFunctionClassFactory();
            }
            TextView textView2 = getBinding().moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            textView2.setVisibility(8);
            BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.sendmoney.ui.globalsend.form.view.EditTextFormView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                EditTextFormView.$r8$lambda$PAlV_qmOo5fgdo0eWejolnngvMI(EditTextFormView.this, view, z);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnEditorActionListener(new EditTextFormView$setupImeActionListener$1(this));
    }

    public final void showErrorText(boolean isError) {
        if (isError) {
            setEditTextContent("");
            this.onTextFormChanged.invoke(this.editTextContent);
        }
        TextView textView = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(isError ? 0 : 8);
        if (isError) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    /* renamed from: isFormValid  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewEditTextFormBinding inflateViewBinding() {
        ViewEditTextFormBinding MyBillsEntityDataFactory = ViewEditTextFormBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] iArr = R.styleable.Z;
            Intrinsics.checkNotNullExpressionValue(iArr, "");
            if (context != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr, 0, 0);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes;
            }
            TypedArray typedArray = null;
            try {
                TypedArray typedArray2 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray2 = null;
                }
                setHeaderText(typedArray2.getResourceId(R.styleable.c, R.string.header_form_country_destination));
                TypedArray typedArray3 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray3 = null;
                }
                setHintText(typedArray3.getResourceId(R.styleable.g, R.string.hint_form_first_name));
                TypedArray typedArray4 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray4 = null;
                }
                setFormEnabled(typedArray4.getBoolean(R.styleable.FillAnimation, true));
                TypedArray typedArray5 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray5 = null;
                }
                String string = typedArray5.getString(R.styleable.b);
                if (string == null) {
                    string = "";
                }
                setEditTextContent(string);
                TypedArray typedArray6 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray6 = null;
                }
                setNeedToShowIconSpinner(typedArray6.getBoolean(R.styleable.e, false));
                TypedArray typedArray7 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray7 = null;
                }
                setFormInputType(typedArray7.getInt(R.styleable.QrExpiredActivity, 0));
                TypedArray typedArray8 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray8 = null;
                }
                setShowCheckBox(typedArray8.getBoolean(R.styleable.f, false));
                TypedArray typedArray9 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray9 = null;
                }
                setCheckBoxText(typedArray9.getResourceId(R.styleable.f8231a, R.string.header_form_country_destination));
                TypedArray typedArray10 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray10 = null;
                }
                setAdditionalInfoTextRes(typedArray10.getResourceId(R.styleable.d, 0));
                TypedArray typedArray11 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray11 = null;
                }
                setShowInfoIcon(typedArray11.getBoolean(R.styleable.FlowViewUtil$textChanges$2, false));
                TypedArray typedArray12 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray12 = null;
                }
                setSecondaryAdditionalInfoText(typedArray12.getResourceId(R.styleable.TypeProjectionImpl, 0));
            } finally {
                TypedArray typedArray13 = this.BuiltInFictitiousFunctionClassFactory;
                if (typedArray13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    typedArray = typedArray13;
                }
                typedArray.recycle();
            }
        }
    }

    public final void setContent(String text) {
        Intrinsics.checkNotNullParameter(text, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(text);
    }

    public final void setHint(String text) {
        Intrinsics.checkNotNullParameter(text, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setHint(text);
    }

    public final void setHeaderText(String text) {
        Intrinsics.checkNotNullParameter(text, "");
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2.setText(text);
    }

    public final void setAdditionalInfo(String text) {
        Intrinsics.checkNotNullParameter(text, "");
        getBinding().lookAheadTest.setText(text);
    }

    public final void setEditTextAccessibilityId(int accessibilityId) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getContext().getString(accessibilityId));
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2, R.style.PlaceComponentResult);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda1, null));
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2, R.style.BuiltInFictitiousFunctionClassFactory);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.DatabaseTableConfigUtil, null));
    }

    public final void setFormValidityListener(FormValidityListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.getAuthRequestContext = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(int p0) {
        TextView textView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getBinding().getErrorConfigVersion.getContext().getString(R.string.text_header_with_char_counter);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{getBinding().getErrorConfigVersion.getContext().getString(p0), Integer.valueOf(String.valueOf(getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getText()).length()), Integer.valueOf(this.maxLengthFormInput)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
    }

    public static /* synthetic */ void $r8$lambda$PAlV_qmOo5fgdo0eWejolnngvMI(EditTextFormView editTextFormView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(editTextFormView, "");
        if (z) {
            if (editTextFormView.PlaceComponentResult) {
                editTextFormView.BuiltInFictitiousFunctionClassFactory();
            } else {
                editTextFormView.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
        if (z) {
            return;
        }
        editTextFormView.onTextFormChanged.invoke(editTextFormView.getAuthRequestContext());
        editTextFormView.MyBillsEntityDataFactory(editTextFormView.getAuthRequestContext());
        if (!editTextFormView.PlaceComponentResult) {
            editTextFormView.KClassImpl$Data$declaredNonStaticMembers$2();
            return;
        }
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(editTextFormView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2, R.style.MyBillsEntityDataFactory);
        editTextFormView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(editTextFormView.getResources(), R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda0, null));
    }
}
