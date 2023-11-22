package id.dana.sendmoney.util;

import android.content.Context;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.sendmoney.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jt\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aJ\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lid/dana/sendmoney/util/GlobalSendErrorHelper;", "", "()V", "ERROR_BENEFICIARY_ACCEPT_RESTRICTED", "", "ERROR_BENEFICIARY_FASTFUND_NOT_SUPPORTED", "ERROR_BENEFICIARY_INFO_INVALID", "ERROR_BENEFICIARY_INFO_NOT_MATCH", "ERROR_BENEFICIARY_NOT_EXIST", "ERROR_DESTINATION_COUNTRY_IS_IN_MAINTENANCE", "ERROR_PARAM_ILLEGAL", "ERROR_SYSTEM_ERROR", "ERROR_THIRD_PARTY_FAILED", "ERROR_UNKNOWN_ERROR", "PAYER_USER_KYC_INCOMPLETE", "showErrorDialog", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "imgSrcLocal", "", CdpConstants.CONTENT_IMAGE_URL, "title", "message", "positiveBtnText", "positiveBtnOnClick", "Lkotlin/Function0;", "negativeBtnText", "negativeBtnOnClick", "showMaintenanceDialog", "onPositiveButtonClicked", "feature-sendmoney_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSendErrorHelper {
    public static final GlobalSendErrorHelper getAuthRequestContext = new GlobalSendErrorHelper();

    private GlobalSendErrorHelper() {
    }

    public static /* synthetic */ void PlaceComponentResult(Context context) {
        int i = R.drawable.res_0x7f0808ee_networkuserentitydata_externalsyntheticlambda4;
        String string = context.getString(R.string.title_error_sysbusy_dialog);
        String string2 = context.getString(R.string.desc_error_sysbusy_dialog);
        String string3 = context.getString(R.string.res_0x7f130398_verifypinstatemanager_executeriskchallenge_2_1);
        final GlobalSendErrorHelper$showErrorDialog$1 globalSendErrorHelper$showErrorDialog$1 = new Function0<Unit>() { // from class: id.dana.sendmoney.util.GlobalSendErrorHelper$showErrorDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        final GlobalSendErrorHelper$showErrorDialog$2 globalSendErrorHelper$showErrorDialog$2 = new Function0<Unit>() { // from class: id.dana.sendmoney.util.GlobalSendErrorHelper$showErrorDialog$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(globalSendErrorHelper$showErrorDialog$1, "");
        Intrinsics.checkNotNullParameter(globalSendErrorHelper$showErrorDialog$2, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.DatabaseTableConfigUtil = i;
        builder.initRecordTimeStamp = null;
        builder.SubSequence = string;
        builder.GetContactSyncConfig = string2;
        builder.BuiltInFictitiousFunctionClassFactory(string3, new Function1<View, Unit>() { // from class: id.dana.sendmoney.util.GlobalSendErrorHelper$showErrorDialog$3
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
                globalSendErrorHelper$showErrorDialog$1.invoke();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(null, new Function1<View, Unit>() { // from class: id.dana.sendmoney.util.GlobalSendErrorHelper$showErrorDialog$4
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
                globalSendErrorHelper$showErrorDialog$2.invoke();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory().show();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        getAuthRequestContext(context, new Function0<Unit>() { // from class: id.dana.sendmoney.util.GlobalSendErrorHelper$showMaintenanceDialog$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    public static void getAuthRequestContext(Context context, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(function0, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.DatabaseTableConfigUtil = R.drawable.ic_transfermethod_maintenance;
        builder.SubSequence = context.getString(R.string.transfermethod_empty_title);
        builder.GetContactSyncConfig = context.getString(R.string.transfermethod_empty_message);
        CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(context.getString(R.string.res_0x7f130923_otpregistrationpresenter_input_2), new Function1<View, Unit>() { // from class: id.dana.sendmoney.util.GlobalSendErrorHelper$showMaintenanceDialog$2
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
        });
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = context.getString(R.string.res_0x7f13030b_networkuserentitydata_externalsyntheticlambda6);
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory().show();
    }
}
