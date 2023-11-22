package id.dana.dialog;

import android.content.Context;
import id.dana.R;
import id.dana.core.ui.dialog.ClickableString;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.dialog.LinksString;
import id.dana.data.constant.DanaUrl;
import id.dana.utils.UrlUtil;
import id.dana.webview.WebViewActivity;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0006"}, d2 = {"Lid/dana/dialog/RiskRejectDialog;", "", "Landroid/content/Context;", "p0", "Lid/dana/core/ui/dialog/DanaAlertDialog$Builder;", "PlaceComponentResult", "(Landroid/content/Context;)Lid/dana/core/ui/dialog/DanaAlertDialog$Builder;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "moveToNextValue", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RiskRejectDialog {
    @Inject
    public RiskRejectDialog() {
    }

    public static DanaAlertDialog.Builder getAuthRequestContext(final Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(p0);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_risk_reject;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_blacklist_title);
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_blacklist_message);
        LinksString linksString = new LinksString(new ClickableString[]{new ClickableString(DanaAlertDialog.LinkKey.TNC, R.string.risk_reject_blacklist_link, Boolean.FALSE, Integer.valueOf((int) R.color.f23182131099816))});
        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.dialog.RiskRejectDialog$buildBlacklistDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                if (Intrinsics.areEqual(str, DanaAlertDialog.LinkKey.TNC)) {
                    Context context = p0;
                    context.startActivity(WebViewActivity.ContentBuilder(context, context.getString(R.string.tnc), UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION)));
                }
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = linksString;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = function1;
        DanaAlertDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(R.string.general_got_it, new Function1<String, Unit>() { // from class: id.dana.dialog.RiskRejectDialog$buildBlacklistDialog$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullExpressionValue(str.toUpperCase(Locale.ROOT), "");
            }
        });
        BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig = Integer.valueOf(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getResources().getDimensionPixelSize(R.dimen.f33722131166048));
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = Boolean.FALSE;
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static DanaAlertDialog.Builder MyBillsEntityDataFactory(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(p0);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_risk_reject;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_suspicious_title);
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_suspicious_message);
        DanaAlertDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(R.string.general_got_it, new Function1<String, Unit>() { // from class: id.dana.dialog.RiskRejectDialog$buildSuspiciousDialog$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullExpressionValue(str.toUpperCase(Locale.ROOT), "");
            }
        });
        BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig = Integer.valueOf(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getResources().getDimensionPixelSize(R.dimen.f33722131166048));
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = Boolean.FALSE;
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static DanaAlertDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(p0);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_retry_1_day_title);
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_retry_1_day_message);
        DanaAlertDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(R.string.general_got_it, new Function1<String, Unit>() { // from class: id.dana.dialog.RiskRejectDialog$buildRetry1DayDialog$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullExpressionValue(str.toUpperCase(Locale.ROOT), "");
            }
        });
        BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig = Integer.valueOf(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getResources().getDimensionPixelSize(R.dimen.f33722131166048));
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = Boolean.FALSE;
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static DanaAlertDialog.Builder BuiltInFictitiousFunctionClassFactory(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(p0);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_retry_7_day_title);
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_retry_7_day_message);
        DanaAlertDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(R.string.general_got_it, new Function1<String, Unit>() { // from class: id.dana.dialog.RiskRejectDialog$buildRetry7DayDialog$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullExpressionValue(str.toUpperCase(Locale.ROOT), "");
            }
        });
        BuiltInFictitiousFunctionClassFactory.GetContactSyncConfig = Integer.valueOf(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getResources().getDimensionPixelSize(R.dimen.f33722131166048));
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = Boolean.FALSE;
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static DanaAlertDialog.Builder moveToNextValue(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(p0);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.temp_account_freeze_title);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.temp_account_freeze_desc);
        builder.BuiltInFictitiousFunctionClassFactory(R.string.general_got_it, new Function1<String, Unit>() { // from class: id.dana.dialog.RiskRejectDialog$buildTemporaryAccountFreezeDialog$1$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullExpressionValue(str.toUpperCase(Locale.ROOT), "");
            }
        });
        builder.lookAheadTest = Boolean.FALSE;
        return builder;
    }

    public static DanaAlertDialog.Builder PlaceComponentResult(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(p0);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_app_update;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_app_update_title_dialog);
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_app_update_desc_dialog);
        builder.lookAheadTest = Boolean.FALSE;
        DanaAlertDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(R.string.general_update, new Function1<String, Unit>() { // from class: id.dana.dialog.RiskRejectDialog$buildAppForceUpdateDialog$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullExpressionValue(str.toUpperCase(Locale.ROOT), "");
            }
        });
        RiskRejectDialog$buildAppForceUpdateDialog$2 riskRejectDialog$buildAppForceUpdateDialog$2 = new Function1<String, Unit>() { // from class: id.dana.dialog.RiskRejectDialog$buildAppForceUpdateDialog$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullExpressionValue(str.toUpperCase(Locale.ROOT), "");
            }
        };
        Intrinsics.checkNotNullParameter(riskRejectDialog$buildAppForceUpdateDialog$2, "");
        String string = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getString(R.string.general_maybe_later);
        Intrinsics.checkNotNullExpressionValue(string, "");
        riskRejectDialog$buildAppForceUpdateDialog$2.invoke((RiskRejectDialog$buildAppForceUpdateDialog$2) string);
        BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = string;
        return BuiltInFictitiousFunctionClassFactory;
    }
}
