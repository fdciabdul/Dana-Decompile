package id.dana.sendmoney_v2.recipient.activity;

import android.content.DialogInterface;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.core.ui.model.UiTextModel;
import id.dana.databinding.ActivityRecipientV2Binding;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.ui.core.model.SendMoneyApiMigrationConfigModel;
import id.dana.sendmoney.ui.core.model.TransferInitResultModel;
import id.dana.sendmoney.ui.core.model.TransferUserInfoModel;
import id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract;
import id.dana.sendmoney_v2.recipient.view.RecipientView;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DateTimeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0003\u0010\u0011J1\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\b\u0010\u0016J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/SearchRecipientActivity$getSendMoneyCoreModule$1;", "Lid/dana/sendmoney/ui/core/presenter/SendMoneyCoreContract$View;", "", "PlaceComponentResult", "()V", "getAuthRequestContext", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/Throwable;)V", "Lid/dana/core/ui/model/UiTextModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/core/ui/model/UiTextModel;)V", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;)V", "Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "(Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;)V", "", "p1", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchRecipientActivity$getSendMoneyCoreModule$1 implements SendMoneyCoreContract.View {
    final /* synthetic */ SearchRecipientActivity KClassImpl$Data$declaredNonStaticMembers$2;

    public static /* synthetic */ void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void PlaceComponentResult() {
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void getAuthRequestContext() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchRecipientActivity$getSendMoneyCoreModule$1(SearchRecipientActivity searchRecipientActivity) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = searchRecipientActivity;
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void BuiltInFictitiousFunctionClassFactory(SendMoneyApiMigrationConfigModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void PlaceComponentResult(TransferInitResultModel p0) {
        RecipientModel recipientModel;
        RecipientModel recipientModel2;
        boolean z;
        RecipientModel recipientModel3;
        ActivityRecipientV2Binding binding;
        RecipientModel recipientModel4;
        RecipientModel recipientModel5;
        RecipientModel recipientModel6;
        RecipientModel recipientModel7;
        RecipientModel recipientModel8;
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = p0;
        TransferUserInfoModel transferUserInfoModel = p0.PlaceComponentResult;
        SearchRecipientActivity.access$updateRecipientModel(this.KClassImpl$Data$declaredNonStaticMembers$2, transferUserInfoModel);
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = SearchRecipientActivity.access$getSendMoneyFeatureTime(this.KClassImpl$Data$declaredNonStaticMembers$2);
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = true;
        SearchRecipientActivity searchRecipientActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        recipientModel = searchRecipientActivity.MyBillsEntityDataFactory;
        RecipientModel recipientModel9 = null;
        if (recipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel = null;
        }
        String str = recipientModel.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(str, "");
        searchRecipientActivity.getAuthRequestContext(str, transferUserInfoModel.MyBillsEntityDataFactory() ? null : TrackerKey.SmartFrictionProperties.NON_DANA_USER);
        if (transferUserInfoModel.MyBillsEntityDataFactory()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = true;
            binding = this.KClassImpl$Data$declaredNonStaticMembers$2.getBinding();
            RecipientView recipientView = binding.BuiltInFictitiousFunctionClassFactory;
            SearchRecipientActivity searchRecipientActivity2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            recipientModel4 = searchRecipientActivity2.MyBillsEntityDataFactory;
            if (recipientModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recipientModel4 = null;
            }
            if (Intrinsics.areEqual(recipientModel4.SubSequence, "Manual Input")) {
                recipientModel8 = searchRecipientActivity2.MyBillsEntityDataFactory;
                if (recipientModel8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel8 = null;
                }
                recipientModel8.SubSequence = RecipientSource.SEARCH_MANUAL_INPUT;
            } else {
                recipientModel5 = searchRecipientActivity2.MyBillsEntityDataFactory;
                if (recipientModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientModel5 = null;
                }
                recipientModel5.SubSequence = RecipientSource.SEARCH;
            }
            recipientModel6 = searchRecipientActivity2.MyBillsEntityDataFactory;
            if (recipientModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recipientModel6 = null;
            }
            recipientModel7 = searchRecipientActivity2.MyBillsEntityDataFactory;
            if (recipientModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                recipientModel9 = recipientModel7;
            }
            searchRecipientActivity2.BuiltInFictitiousFunctionClassFactory(recipientModel6, searchRecipientActivity2.isNewNumber(recipientModel9));
            return;
        }
        recipientModel2 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        if (recipientModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel2 = null;
        }
        recipientModel2.GetContactSyncConfig = false;
        z = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        if (z) {
            return;
        }
        SearchRecipientActivity searchRecipientActivity3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        recipientModel3 = searchRecipientActivity3.MyBillsEntityDataFactory;
        if (recipientModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recipientModel9 = recipientModel3;
        }
        SearchRecipientActivity.access$showUnregisteredUserDialog(searchRecipientActivity3, recipientModel9);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void MyBillsEntityDataFactory(Throwable p0) {
        RecipientModel recipientModel;
        RecipientModel recipientModel2;
        RecipientModel recipientModel3;
        boolean z;
        RecipientModel recipientModel4;
        RecipientModel recipientModel5;
        RecipientModel recipientModel6;
        Intrinsics.checkNotNullParameter(p0, "");
        recipientModel = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        RecipientModel recipientModel7 = null;
        if (recipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel = null;
        }
        recipientModel.GetContactSyncConfig = false;
        SendMoneyFeatureTime access$getSendMoneyFeatureTime = SearchRecipientActivity.access$getSendMoneyFeatureTime(this.KClassImpl$Data$declaredNonStaticMembers$2);
        access$getSendMoneyFeatureTime.PlaceComponentResult = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        access$getSendMoneyFeatureTime.MyBillsEntityDataFactory = false;
        SearchRecipientActivity searchRecipientActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        recipientModel2 = searchRecipientActivity.MyBillsEntityDataFactory;
        if (recipientModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel2 = null;
        }
        String str = recipientModel2.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(str, "");
        searchRecipientActivity.getAuthRequestContext(str, TrackerKey.SmartFrictionProperties.NON_DANA_USER);
        recipientModel3 = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        if (recipientModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientModel3 = null;
        }
        recipientModel3.GetContactSyncConfig = false;
        z = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        if (z) {
            SearchRecipientActivity searchRecipientActivity2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            recipientModel5 = searchRecipientActivity2.MyBillsEntityDataFactory;
            if (recipientModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recipientModel5 = null;
            }
            SearchRecipientActivity searchRecipientActivity3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            recipientModel6 = searchRecipientActivity3.MyBillsEntityDataFactory;
            if (recipientModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                recipientModel7 = recipientModel6;
            }
            searchRecipientActivity2.BuiltInFictitiousFunctionClassFactory(recipientModel5, searchRecipientActivity3.isNewNumber(recipientModel7));
            return;
        }
        SearchRecipientActivity searchRecipientActivity4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        recipientModel4 = searchRecipientActivity4.MyBillsEntityDataFactory;
        if (recipientModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recipientModel7 = recipientModel4;
        }
        SearchRecipientActivity.access$showUnregisteredUserDialog(searchRecipientActivity4, recipientModel7);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(UiTextModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SearchRecipientActivity searchRecipientActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        searchRecipientActivity.showWarningDialog(p0.asString(searchRecipientActivity), new DialogInterface.OnDismissListener() { // from class: id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity$getSendMoneyCoreModule$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SearchRecipientActivity$getSendMoneyCoreModule$1.MyBillsEntityDataFactory();
            }
        }, true, 3000);
    }

    @Override // id.dana.sendmoney.ui.core.presenter.SendMoneyCoreContract.View
    public final void MyBillsEntityDataFactory(Throwable p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (p2.length() > 0) {
            MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, p1, p2, p3, p0);
        }
    }
}
