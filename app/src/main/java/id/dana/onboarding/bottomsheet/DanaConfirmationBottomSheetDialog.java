package id.dana.onboarding.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.BottomSheetOnboardingWithTwoBtnAndIconBinding;
import id.dana.utils.StringWrapper;
import id.dana.utils.StringWrapperKt;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\t\b\u0016¢\u0006\u0004\b!\u0010\bBa\u0012\u0006\u0010\f\u001a\u00020\u000e\u0012\u0006\u0010\"\u001a\u00020\u000e\u0012\u0006\u0010#\u001a\u00020\u000e\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010%\u001a\u00020\u0011\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014\u0012\b\b\u0002\u0010(\u001a\u00020\u001b¢\u0006\u0004\b!\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\rR\u0014\u0010\u0007\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0010"}, d2 = {"Lid/dana/onboarding/bottomsheet/DanaConfirmationBottomSheetDialog;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/BottomSheetOnboardingWithTwoBtnAndIconBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "Landroidx/fragment/app/FragmentManager;", "p0", "(Landroidx/fragment/app/FragmentManager;)V", "Lid/dana/utils/StringWrapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/utils/StringWrapper;", "", "I", "initRecordTimeStamp", "Lkotlin/Function0;", "GetContactSyncConfig", "Lkotlin/jvm/functions/Function0;", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "scheduleImpl", "", "DatabaseTableConfigUtil", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda8", "lookAheadTest", "<init>", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "(Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;Lid/dana/utils/StringWrapper;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaConfirmationBottomSheetDialog extends BaseViewBindingBottomSheetDialogFragment<BottomSheetOnboardingWithTwoBtnAndIconBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Function0<Unit> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final StringWrapper getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final StringWrapper scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final StringWrapper lookAheadTest;
    public Map<Integer, View> PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final StringWrapper KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.clear();
    }

    private DanaConfirmationBottomSheetDialog(StringWrapper stringWrapper, StringWrapper stringWrapper2, StringWrapper stringWrapper3, StringWrapper stringWrapper4, int i, Function0<Unit> function0, Function0<Unit> function02, boolean z) {
        Intrinsics.checkNotNullParameter(stringWrapper, "");
        Intrinsics.checkNotNullParameter(stringWrapper2, "");
        Intrinsics.checkNotNullParameter(stringWrapper3, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.PlaceComponentResult = new LinkedHashMap();
        this.lookAheadTest = stringWrapper;
        this.getAuthRequestContext = stringWrapper2;
        this.scheduleImpl = stringWrapper3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = stringWrapper4;
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = function0;
        this.PlaceComponentResult = function02;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetOnboardingWithTwoBtnAndIconBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetOnboardingWithTwoBtnAndIconBinding MyBillsEntityDataFactory = BottomSheetOnboardingWithTwoBtnAndIconBinding.MyBillsEntityDataFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public /* synthetic */ DanaConfirmationBottomSheetDialog(StringWrapper stringWrapper, StringWrapper stringWrapper2, StringWrapper stringWrapper3, StringWrapper stringWrapper4, int i, Function0 function0, Function0 function02, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(stringWrapper, stringWrapper2, stringWrapper3, (i2 & 8) != 0 ? null : stringWrapper4, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? new Function0<Unit>() { // from class: id.dana.onboarding.bottomsheet.DanaConfirmationBottomSheetDialog.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function0, (i2 & 64) != 0 ? null : function02, (i2 & 128) != 0 ? true : z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DanaConfirmationBottomSheetDialog() {
        /*
            r12 = this;
            id.dana.utils.StringWrapper$Companion r0 = id.dana.utils.StringWrapper.INSTANCE
            id.dana.utils.StringWrapper$StringValue r0 = id.dana.utils.StringWrapper.Companion.KClassImpl$Data$declaredNonStaticMembers$2()
            r2 = r0
            id.dana.utils.StringWrapper r2 = (id.dana.utils.StringWrapper) r2
            id.dana.utils.StringWrapper$Companion r0 = id.dana.utils.StringWrapper.INSTANCE
            id.dana.utils.StringWrapper$StringValue r0 = id.dana.utils.StringWrapper.Companion.KClassImpl$Data$declaredNonStaticMembers$2()
            r3 = r0
            id.dana.utils.StringWrapper r3 = (id.dana.utils.StringWrapper) r3
            id.dana.utils.StringWrapper$Companion r0 = id.dana.utils.StringWrapper.INSTANCE
            id.dana.utils.StringWrapper$StringValue r0 = id.dana.utils.StringWrapper.Companion.KClassImpl$Data$declaredNonStaticMembers$2()
            r4 = r0
            id.dana.utils.StringWrapper r4 = (id.dana.utils.StringWrapper) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 248(0xf8, float:3.48E-43)
            r11 = 0
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.dismiss()     // Catch: java.lang.Exception -> L2a
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.bottomsheet.DanaConfirmationBottomSheetDialog.<init>():void");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View view = getView();
            if (view != null) {
                view.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(view, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            AppCompatImageView appCompatImageView = ((BottomSheetOnboardingWithTwoBtnAndIconBinding) vb).getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            int i = this.BuiltInFictitiousFunctionClassFactory;
            Context context = appCompatImageView2.getContext();
            if (context != null) {
                GlideApp.getAuthRequestContext(context).PlaceComponentResult(Integer.valueOf(i)).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.welcome_circle_illustration).PlaceComponentResult((int) R.drawable.welcome_circle_illustration).MyBillsEntityDataFactory((ImageView) appCompatImageView2);
            }
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                AppCompatTextView appCompatTextView = ((BottomSheetOnboardingWithTwoBtnAndIconBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0;
                Context context2 = getContext();
                String authRequestContext = context2 != null ? StringWrapperKt.getAuthRequestContext(context2, this.lookAheadTest) : null;
                if (authRequestContext == null) {
                    authRequestContext = "";
                }
                appCompatTextView.setText(authRequestContext);
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    AppCompatTextView appCompatTextView2 = ((BottomSheetOnboardingWithTwoBtnAndIconBinding) vb3).lookAheadTest;
                    Context context3 = getContext();
                    String authRequestContext2 = context3 != null ? StringWrapperKt.getAuthRequestContext(context3, this.getAuthRequestContext) : null;
                    if (authRequestContext2 == null) {
                        authRequestContext2 = "";
                    }
                    appCompatTextView2.setText(authRequestContext2);
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        VB vb4 = this.MyBillsEntityDataFactory;
                        if (vb4 != 0) {
                            AppCompatTextView appCompatTextView3 = ((BottomSheetOnboardingWithTwoBtnAndIconBinding) vb4).PlaceComponentResult;
                            Context context4 = getContext();
                            String authRequestContext3 = context4 != null ? StringWrapperKt.getAuthRequestContext(context4, this.KClassImpl$Data$declaredNonStaticMembers$2) : null;
                            if (authRequestContext3 == null) {
                                authRequestContext3 = "";
                            }
                            String upperCase = authRequestContext3.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "");
                            appCompatTextView3.setText(upperCase);
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        VB vb5 = this.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            ((BottomSheetOnboardingWithTwoBtnAndIconBinding) vb5).PlaceComponentResult.setVisibility(8);
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                    VB vb6 = this.MyBillsEntityDataFactory;
                    if (vb6 != 0) {
                        ((BottomSheetOnboardingWithTwoBtnAndIconBinding) vb6).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.bottomsheet.DanaConfirmationBottomSheetDialog$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                DanaConfirmationBottomSheetDialog.PlaceComponentResult(DanaConfirmationBottomSheetDialog.this);
                            }
                        });
                        VB vb7 = this.MyBillsEntityDataFactory;
                        if (vb7 != 0) {
                            DanaButtonPrimaryView danaButtonPrimaryView = ((BottomSheetOnboardingWithTwoBtnAndIconBinding) vb7).KClassImpl$Data$declaredNonStaticMembers$2;
                            Context context5 = getContext();
                            String authRequestContext4 = context5 != null ? StringWrapperKt.getAuthRequestContext(context5, this.scheduleImpl) : null;
                            if (authRequestContext4 == null) {
                                authRequestContext4 = "";
                            }
                            String upperCase2 = authRequestContext4.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase2, "");
                            danaButtonPrimaryView.setActiveButton(upperCase2, null);
                            VB vb8 = this.MyBillsEntityDataFactory;
                            if (vb8 != 0) {
                                ((BottomSheetOnboardingWithTwoBtnAndIconBinding) vb8).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.bottomsheet.DanaConfirmationBottomSheetDialog$$ExternalSyntheticLambda1
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        DanaConfirmationBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(DanaConfirmationBottomSheetDialog.this);
                                    }
                                });
                                Dialog dialog = getDialog();
                                if (dialog != null) {
                                    dialog.setCanceledOnTouchOutside(false);
                                }
                                setCancelable(false);
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
    }

    public final void getAuthRequestContext(FragmentManager p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.show(p0, "DanaConfirmationBottomSheetDialog");
    }

    public static /* synthetic */ void PlaceComponentResult(DanaConfirmationBottomSheetDialog danaConfirmationBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(danaConfirmationBottomSheetDialog, "");
        Function0<Unit> function0 = danaConfirmationBottomSheetDialog.PlaceComponentResult;
        if (function0 != null) {
            function0.invoke();
        } else {
            danaConfirmationBottomSheetDialog.dismiss();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DanaConfirmationBottomSheetDialog danaConfirmationBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(danaConfirmationBottomSheetDialog, "");
        danaConfirmationBottomSheetDialog.MyBillsEntityDataFactory.invoke();
        if (danaConfirmationBottomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            danaConfirmationBottomSheetDialog.dismiss();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetOnboardingWithTwoBtnAndIconBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
