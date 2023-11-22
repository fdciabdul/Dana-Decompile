package id.dana.cardbinding.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.cardbinding.helper.CardBindingErrorHelper;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_content_DialogInterface_OnDismissListener$0;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_view_View_OnClickListener$0;
import id.dana.component.extension.ViewExtKt;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.utils.DANAToast;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a\u0016\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005\u001a\u001c\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e\u001a\u0018\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u001a\u0010\u0010\u0011\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\n\u001a8\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u0016"}, d2 = {"handleSubmitCardErrorDialog", "", HummerConstants.CONTEXT, "Landroid/app/Activity;", "errorCode", "", "errorMessage", "isBcaOneKlik", "", "showCardActivationDialog", "Landroid/content/Context;", "message", "showCashierMainErrorDialog", "onRetry", "Lkotlin/Function0;", "showDialogSaveCardSuccess", WalletConstant.CARD_INDEX_NO, "showOtpLimitDialog", "showSubmitCardErrorDialog", "title", "img", "", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CardBindingDialogExtKt {
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Activity activity, String str, String str2, int i) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        Intrinsics.checkNotNullParameter(activity, "");
        CardBindingErrorHelper cardBindingErrorHelper = new CardBindingErrorHelper(activity, str, str2);
        if (Intrinsics.areEqual(cardBindingErrorHelper.lookAheadTest, "VIEW_TYPE_DIALOG")) {
            PlaceComponentResult(activity, cardBindingErrorHelper.BuiltInFictitiousFunctionClassFactory, cardBindingErrorHelper.MyBillsEntityDataFactory, cardBindingErrorHelper.PlaceComponentResult);
            return;
        }
        DANAToast dANAToast = DANAToast.PlaceComponentResult;
        String str3 = cardBindingErrorHelper.BuiltInFictitiousFunctionClassFactory;
        if (str3 == null) {
            str3 = activity.getString(R.string.card_binding_cashier_main_error_description);
            Intrinsics.checkNotNullExpressionValue(str3, "");
        }
        DANAToast.PlaceComponentResult(activity, str3);
    }

    public static /* synthetic */ void getAuthRequestContext(Activity activity) {
        PlaceComponentResult(activity, activity.getString(R.string.card_binding_save_card_dialog_server_error_title), activity.getString(R.string.card_binding_save_card_dialog_desc), R.drawable.ic_save_card_server_failed);
    }

    public static void PlaceComponentResult(final Activity activity, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(activity, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(activity);
        builder.SubSequence = str;
        builder.GetContactSyncConfig = str2;
        builder.DatabaseTableConfigUtil = i;
        CustomDialog.Builder PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        PlaceComponentResult.whenAvailable = activity.getString(R.string.cardbind_lbl_failed_save_card_title);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda4 = activity.getString(R.string.cardbind_btn_help_failed_save);
        PlaceComponentResult.newProxyInstance = activity.getString(R.string.cardbind_btn_close_failed_save);
        Function1<DialogInterface, Unit> function1 = new Function1<DialogInterface, Unit>() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showSubmitCardErrorDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DialogInterface dialogInterface) {
                Intrinsics.checkNotNullParameter(dialogInterface, "");
                activity.finish();
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        PlaceComponentResult.getErrorConfigVersion = new CustomDialog$sam$android_content_DialogInterface_OnDismissListener$0(function1);
        String string = activity.getString(R.string.card_binding_button_need_help);
        final String str3 = DanaUrl.CARD_PROBLEM_INFORMATION_URL;
        Function1<View, Unit> function12 = new Function1<View, Unit>() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showSubmitCardErrorDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                String str4 = str3;
                final Activity activity2 = activity;
                DanaH5.startContainerFullUrl(str4, new DanaH5Listener() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showSubmitCardErrorDialog$2.1
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerCreated(Bundle p0) {
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerDestroyed(Bundle p0) {
                        activity2.finish();
                    }
                });
            }
        };
        Intrinsics.checkNotNullParameter(function12, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(function12);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        PlaceComponentResult.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
        String string2 = activity.getString(R.string.card_binding_button_close);
        Function1<View, Unit> function13 = new Function1<View, Unit>() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showSubmitCardErrorDialog$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                activity.finish();
            }
        };
        Intrinsics.checkNotNullParameter(function13, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$02 = new CustomDialog$sam$android_view_View_OnClickListener$0(function13);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7 = string2;
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8 = customDialog$sam$android_view_View_OnClickListener$02;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(final Activity activity, final String str) {
        Intrinsics.checkNotNullParameter(activity, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(activity);
        builder.DatabaseTableConfigUtil = R.drawable.ic_save_card_success;
        builder.SubSequence = activity.getString(R.string.card_binding_success_save_card_text);
        builder.GetContactSyncConfig = activity.getString(R.string.card_binding_desc_success_save_card_text);
        CustomDialog.Builder PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        PlaceComponentResult.whenAvailable = activity.getString(R.string.cardbind_lbl_success_save_card_title);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda4 = activity.getString(R.string.cardbind_btn_success_save_got_it);
        Function1<DialogInterface, Unit> function1 = new Function1<DialogInterface, Unit>() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showDialogSaveCardSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface) {
                invoke2(dialogInterface);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DialogInterface dialogInterface) {
                Intrinsics.checkNotNullParameter(dialogInterface, "");
                activity.finish();
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        PlaceComponentResult.getErrorConfigVersion = new CustomDialog$sam$android_content_DialogInterface_OnDismissListener$0(function1);
        String string = activity.getString(R.string.card_binding_button_got_it_text);
        Function1<View, Unit> function12 = new Function1<View, Unit>() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showDialogSaveCardSuccess$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] objArr = new Object[1];
                String str2 = str;
                if (str2 == null) {
                    str2 = "";
                }
                objArr[0] = str2;
                String format = String.format("https://m.dana.id/m/portal/bankcarddetail?cardIndexNo=%s", Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                final Activity activity2 = activity;
                DanaH5.startContainerFullUrl(format, new DanaH5Listener() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showDialogSaveCardSuccess$2.1
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerCreated(Bundle p0) {
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerDestroyed(Bundle p0) {
                        activity2.finish();
                    }
                });
            }
        };
        Intrinsics.checkNotNullParameter(function12, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(function12);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        PlaceComponentResult.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
        ViewExtKt.getAuthRequestContext(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(), PlaceComponentResult.moveToNextValue);
    }

    public static final void PlaceComponentResult(final Activity activity, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(function0, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(activity);
        builder.SubSequence = activity.getString(R.string.card_binding_cashier_main_error_title);
        builder.GetContactSyncConfig = activity.getString(R.string.card_binding_cashier_main_error_description);
        builder.DatabaseTableConfigUtil = R.drawable.ic_cashier_main_error;
        CustomDialog.Builder PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        String string = activity.getString(R.string.card_binding_cashier_main_error_positive_button);
        Function1<View, Unit> function1 = new Function1<View, Unit>() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showCashierMainErrorDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                function0.invoke();
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(function1);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        PlaceComponentResult.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
        String string2 = activity.getString(R.string.card_binding_cashier_main_error_negative_button);
        Function1<View, Unit> function12 = new Function1<View, Unit>() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showCashierMainErrorDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                activity.finish();
            }
        };
        Intrinsics.checkNotNullParameter(function12, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$02 = new CustomDialog$sam$android_view_View_OnClickListener$0(function12);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7 = string2;
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8 = customDialog$sam$android_view_View_OnClickListener$02;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final void getAuthRequestContext(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.SubSequence = context.getString(R.string.card_binding_activate_dialog_title);
        builder.GetContactSyncConfig = str;
        CustomDialog.TextAlignment textAlignment = CustomDialog.TextAlignment.LEFT;
        Intrinsics.checkNotNullParameter(textAlignment, "");
        builder.PrepareContext = textAlignment;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_bank_card_activation_dialog;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = 64;
        CustomDialog.Builder PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        String string = context.getString(R.string.card_binding_button_got_it_text);
        CardBindingDialogExtKt$showCardActivationDialog$1 cardBindingDialogExtKt$showCardActivationDialog$1 = new Function1<View, Unit>() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showCardActivationDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullParameter(cardBindingDialogExtKt$showCardActivationDialog$1, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(cardBindingDialogExtKt$showCardActivationDialog$1);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        PlaceComponentResult.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final void BuiltInFictitiousFunctionClassFactory(Context context) {
        if (context != null) {
            CustomDialog.Builder builder = new CustomDialog.Builder(context);
            builder.SubSequence = context.getString(R.string.otp_limit_dialog_title);
            builder.GetContactSyncConfig = context.getString(R.string.otp_limit_dialog_desc);
            builder.DatabaseTableConfigUtil = R.drawable.ic_too_many_request_otp_account_freeze;
            String string = context.getString(R.string.otp_limit_dialog_action);
            CardBindingDialogExtKt$showOtpLimitDialog$1$1 cardBindingDialogExtKt$showOtpLimitDialog$1$1 = new Function1<View, Unit>() { // from class: id.dana.cardbinding.view.CardBindingDialogExtKt$showOtpLimitDialog$1$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }
            };
            Intrinsics.checkNotNullParameter(cardBindingDialogExtKt$showOtpLimitDialog$1$1, "");
            CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(cardBindingDialogExtKt$showOtpLimitDialog$1$1);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
            builder.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
            CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult(false).KClassImpl$Data$declaredNonStaticMembers$2(false);
            KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = 0L;
            MaterialDialog BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
            DialogLayout view = BuiltInFictitiousFunctionClassFactory.getView();
            int BuiltInFictitiousFunctionClassFactory2 = ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.f26522131100321);
            ((TextView) view.findViewById(16908310)).setTextColor(BuiltInFictitiousFunctionClassFactory2);
            TextView textView = (TextView) view.findViewById(16908304);
            textView.setTextColor(BuiltInFictitiousFunctionClassFactory2);
            textView.setTypeface(ResourcesCompat.PlaceComponentResult(context, (int) R.font.sf_pro_regular));
            BuiltInFictitiousFunctionClassFactory.show();
        }
    }
}
