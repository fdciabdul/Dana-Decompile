package id.dana.sendmoney.ui.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.button.MaterialButton;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ViewEmptyStateCommonBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010E\u001a\u000202\u0012\b\b\u0002\u0010F\u001a\u000202¢\u0006\u0004\bG\u0010HJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u0010\u0010\u000fR*\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R*\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R*\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R*\u0010-\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020&8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u00101\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020&8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R*\u00109\u001a\u0002022\u0006\u0010\u0012\u001a\u0002028\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010\u001a\u001a\u00020:8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b;\u0010<R*\u0010@\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0014\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R*\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010\u0014\u001a\u0004\bB\u0010\u0016\"\u0004\bC\u0010\u0018"}, d2 = {"Lid/dana/sendmoney/ui/common/EmptyStateView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/sendmoney/databinding/ViewEmptyStateCommonBinding;", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ViewEmptyStateCommonBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/Function0;", "onClickListener", "setOnBottomActionClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnCenterActionClickListener", "", "value", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getBottomAction", "()Ljava/lang/String;", "setBottomAction", "(Ljava/lang/String;)V", "bottomAction", "getAuthRequestContext", "getCenterAction", "setCenterAction", "centerAction", "KClassImpl$Data$declaredNonStaticMembers$2", "getDesc", "setDesc", "desc", "MyBillsEntityDataFactory", "getDescContentDescription", "setDescContentDescription", "descContentDescription", "", "PlaceComponentResult", "Z", "getHasBottomAction", "()Z", "setHasBottomAction", "(Z)V", "hasBottomAction", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getHasCenterAction", "setHasCenterAction", "hasCenterAction", "", "moveToNextValue", "I", "getIcon", "()I", "setIcon", "(I)V", "icon", "Landroid/content/res/TypedArray;", "scheduleImpl", "Landroid/content/res/TypedArray;", "getErrorConfigVersion", "getTitle", GriverEvents.EVENT_SET_TITLE, "title", "lookAheadTest", "getTitleContentDescription", "setTitleContentDescription", "titleContentDescription", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmptyStateView extends BaseViewBindingRichView<ViewEmptyStateCommonBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String bottomAction;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String desc;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String descContentDescription;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean hasCenterAction;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean hasBottomAction;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String centerAction;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String title;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String titleContentDescription;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private int icon;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private TypedArray getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ EmptyStateView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.icon = R.drawable.ic_general_empty_state;
        this.title = "";
        this.desc = "";
        this.centerAction = "";
        this.bottomAction = "";
        this.titleContentDescription = "";
        this.descContentDescription = "";
    }

    @JvmName(name = "getIcon")
    public final int getIcon() {
        return this.icon;
    }

    @JvmName(name = "setIcon")
    public final void setIcon(int i) {
        this.icon = i;
        getBinding().BuiltInFictitiousFunctionClassFactory.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), i));
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.title = str;
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(str);
    }

    @JvmName(name = "getDesc")
    public final String getDesc() {
        return this.desc;
    }

    @JvmName(name = "setDesc")
    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.desc = str;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(str);
    }

    @JvmName(name = "getCenterAction")
    public final String getCenterAction() {
        return this.centerAction;
    }

    @JvmName(name = "setCenterAction")
    public final void setCenterAction(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.centerAction = str;
        getBinding().MyBillsEntityDataFactory.setText(str);
    }

    @JvmName(name = "getHasCenterAction")
    public final boolean getHasCenterAction() {
        return this.hasCenterAction;
    }

    @JvmName(name = "setHasCenterAction")
    public final void setHasCenterAction(boolean z) {
        this.hasCenterAction = z;
        MaterialButton materialButton = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(materialButton, "");
        materialButton.setVisibility(z ? 0 : 8);
    }

    @JvmName(name = "getBottomAction")
    public final String getBottomAction() {
        return this.bottomAction;
    }

    @JvmName(name = "setBottomAction")
    public final void setBottomAction(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.bottomAction = str;
        getBinding().PlaceComponentResult.setActiveButton(str, null);
    }

    @JvmName(name = "getHasBottomAction")
    public final boolean getHasBottomAction() {
        return this.hasBottomAction;
    }

    @JvmName(name = "setHasBottomAction")
    public final void setHasBottomAction(boolean z) {
        this.hasBottomAction = z;
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setVisibility(z ? 0 : 8);
    }

    @JvmName(name = "getTitleContentDescription")
    public final String getTitleContentDescription() {
        return this.titleContentDescription;
    }

    @JvmName(name = "setTitleContentDescription")
    public final void setTitleContentDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.titleContentDescription = str;
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setContentDescription(str);
    }

    @JvmName(name = "getDescContentDescription")
    public final String getDescContentDescription() {
        return this.descContentDescription;
    }

    @JvmName(name = "setDescContentDescription")
    public final void setDescContentDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.descContentDescription = str;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(str);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewEmptyStateCommonBinding inflateViewBinding() {
        ViewEmptyStateCommonBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewEmptyStateCommonBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] iArr = R.styleable.connectForeground;
            Intrinsics.checkNotNullExpressionValue(iArr, "");
            if (context != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr, 0, 0);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
                this.getAuthRequestContext = obtainStyledAttributes;
            }
            TypedArray typedArray = null;
            try {
                TypedArray typedArray2 = this.getAuthRequestContext;
                if (typedArray2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray2 = null;
                }
                setIcon(typedArray2.getResourceId(R.styleable.m, R.drawable.ic_general_empty_state));
                TypedArray typedArray3 = this.getAuthRequestContext;
                if (typedArray3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray3 = null;
                }
                String string = typedArray3.getString(R.styleable.j);
                if (string == null) {
                    string = "";
                }
                setTitle(string);
                TypedArray typedArray4 = this.getAuthRequestContext;
                if (typedArray4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray4 = null;
                }
                String string2 = typedArray4.getString(R.styleable.access$throwIllegalArgumentType);
                if (string2 == null) {
                    string2 = "";
                }
                setDesc(string2);
                TypedArray typedArray5 = this.getAuthRequestContext;
                if (typedArray5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray5 = null;
                }
                String string3 = typedArray5.getString(R.styleable.FlowViewUtil$textChanges$1);
                if (string3 == null) {
                    string3 = "";
                }
                setCenterAction(string3);
                TypedArray typedArray6 = this.getAuthRequestContext;
                if (typedArray6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray6 = null;
                }
                setHasCenterAction(typedArray6.getBoolean(R.styleable.k, false));
                TypedArray typedArray7 = this.getAuthRequestContext;
                if (typedArray7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray7 = null;
                }
                String string4 = typedArray7.getString(R.styleable.i);
                if (string4 == null) {
                    string4 = "";
                }
                setBottomAction(string4);
                TypedArray typedArray8 = this.getAuthRequestContext;
                if (typedArray8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray8 = null;
                }
                setHasBottomAction(typedArray8.getBoolean(R.styleable.l, false));
                TypedArray typedArray9 = this.getAuthRequestContext;
                if (typedArray9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray9 = null;
                }
                String string5 = typedArray9.getString(R.styleable.f8232o);
                if (string5 == null) {
                    string5 = "";
                }
                setTitleContentDescription(string5);
                TypedArray typedArray10 = this.getAuthRequestContext;
                if (typedArray10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray10 = null;
                }
                String string6 = typedArray10.getString(R.styleable.h);
                if (string6 == null) {
                    string6 = "";
                }
                setDescContentDescription(string6);
            } finally {
                TypedArray typedArray11 = this.getAuthRequestContext;
                if (typedArray11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    typedArray = typedArray11;
                }
                typedArray.recycle();
            }
        }
    }

    public final void setOnCenterActionClickListener(final Function0<Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.common.EmptyStateView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmptyStateView.m2913$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM(Function0.this, view);
            }
        });
    }

    public final void setOnBottomActionClickListener(final Function0<Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.common.EmptyStateView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmptyStateView.$r8$lambda$gquWwcq5WVLAsx0VaBPKVJIib1Q(Function0.this, view);
            }
        });
    }

    /* renamed from: $r8$lambda$Z7cCkiMOp-RjsRTg6ix8npYCD-M  reason: not valid java name */
    public static /* synthetic */ void m2913$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    public static /* synthetic */ void $r8$lambda$gquWwcq5WVLAsx0VaBPKVJIib1Q(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
