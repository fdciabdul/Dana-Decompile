package id.dana.sendmoney.ui.groupsend.summary.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.FlowViewUtil;
import id.dana.domain.expresspurchase.interaction.SaveLastActionToPreference;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ViewDialogEditGroupNameBinding;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010(\u001a\u00020&¢\u0006\u0004\b)\u0010*J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u00020\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\r\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0005R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendEditNameDialog;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/sendmoney/databinding/ViewDialogEditGroupNameBinding;", "", SaveLastActionToPreference.DISMISS_EP, "()V", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ViewDialogEditGroupNameBinding;", "", "isRootVisible", "()Z", "Lkotlin/Function0;", "onDismiss", "setOnDismissDialogListener", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "", "onPositiveButtonClicked", "setOnPositiveButtonClicked", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "setTextChangeListenerLifecycle", "(Lkotlinx/coroutines/CoroutineScope;)V", "setup", ContainerUIProvider.KEY_SHOW, "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendEditNameDialog extends BaseViewBindingRichView<ViewDialogEditGroupNameBinding> {
    private Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Function1<? super String, Unit> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupSendEditNameDialog(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupSendEditNameDialog(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupSendEditNameDialog(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ GroupSendEditNameDialog(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupSendEditNameDialog(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = "";
        this.BuiltInFictitiousFunctionClassFactory = new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.GroupSendEditNameDialog$onPositiveButtonClicked$1
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
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.GroupSendEditNameDialog$onDismiss$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDialogEditGroupNameBinding inflateViewBinding() {
        ViewDialogEditGroupNameBinding MyBillsEntityDataFactory = ViewDialogEditGroupNameBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.GroupSendEditNameDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupSendEditNameDialog.m2924$r8$lambda$iOGobA4QNdc8AZ5prbfjdoQemA(GroupSendEditNameDialog.this, view);
            }
        });
    }

    public final void setOnPositiveButtonClicked(Function1<? super String, Unit> onPositiveButtonClicked) {
        Intrinsics.checkNotNullParameter(onPositiveButtonClicked, "");
        this.BuiltInFictitiousFunctionClassFactory = onPositiveButtonClicked;
    }

    public final void setOnDismissDialogListener(Function0<Unit> onDismiss) {
        Intrinsics.checkNotNullParameter(onDismiss, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onDismiss;
    }

    public final boolean isRootVisible() {
        FrameLayout frameLayout = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout.getVisibility() == 0;
    }

    public final void dismiss() {
        FrameLayout frameLayout = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        if (frameLayout.getVisibility() == 0) {
            FrameLayout frameLayout2 = getBinding().scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "");
            frameLayout2.setVisibility(8);
        }
        Editable text = getBinding().PlaceComponentResult.getText();
        if (text != null) {
            text.clear();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
    }

    public final void show() {
        ViewDialogEditGroupNameBinding binding = getBinding();
        FrameLayout frameLayout = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(0);
        binding.scheduleImpl.setFocusable(true);
        binding.scheduleImpl.setClickable(true);
    }

    public final void setTextChangeListenerLifecycle(CoroutineScope lifecycleScope) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "");
        FlowViewUtil flowViewUtil = FlowViewUtil.INSTANCE;
        DanaTextBoxView danaTextBoxView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(danaTextBoxView, "");
        FlowKt.launchIn(FlowKt.onEach(FlowViewUtil.PlaceComponentResult(danaTextBoxView), new GroupSendEditNameDialog$setTextChangeListenerLifecycle$1(this, null)), lifecycleScope);
    }

    /* renamed from: $r8$lambda$iOGobA4Q-Ndc8AZ5prbfjdoQemA  reason: not valid java name */
    public static /* synthetic */ void m2924$r8$lambda$iOGobA4QNdc8AZ5prbfjdoQemA(GroupSendEditNameDialog groupSendEditNameDialog, View view) {
        Intrinsics.checkNotNullParameter(groupSendEditNameDialog, "");
        groupSendEditNameDialog.dismiss();
    }

    public static final /* synthetic */ void access$setMaxCharCounterTextView(GroupSendEditNameDialog groupSendEditNameDialog) {
        TextView textView = groupSendEditNameDialog.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = groupSendEditNameDialog.getBinding().scheduleImpl.getContext().getString(R.string.res_0x7f130e13_access_setshowcaseshowing_p);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(groupSendEditNameDialog.MyBillsEntityDataFactory.length())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
    }
}
