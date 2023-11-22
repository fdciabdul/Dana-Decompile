package id.dana.sendmoney.ui.groupsend.groupdetail.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.view.ViewModelKt;
import androidx.view.result.ActivityResultLauncher;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.edittextcomponent.DanaTextBoxView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.data.constant.DanaUrl;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.network.util.DanaH5Helper;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ActivityGroupDetailBinding;
import id.dana.sendmoney.databinding.ViewDialogEditGroupNameBinding;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupName;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.BizGroupDetailResultModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailUiState;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel;
import id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity;
import id.dana.sendmoney.ui.groupsend.summary.model.GroupSendIntentModel;
import id.dana.sendmoney.util.SourceTypeProperty;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000e\u001a%\u0010\n\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000f\u001a5\u0010\n\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\n\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a3\u0010\n\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00182\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\n\u0010\u001b\"\u001c\u0010\u0005\u001a\u0004\u0018\u00010\b@\u0007X\u0086\n¢\u0006\f\n\u0004\b\n\u0010\u001c\"\u0004\b\u0016\u0010\u001d"}, d2 = {"Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;", "p0", "", "p1", "", "getAuthRequestContext", "(Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;Z)V", "Landroid/content/Context;", "", "p2", "PlaceComponentResult", "(Landroid/content/Context;Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;Ljava/lang/String;)V", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetGroupDetail;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetGroupDetail;)V", "(Landroid/content/Context;Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState$OnSuccessGetGroupDetail;)V", "Lid/dana/sendmoney/ui/groupsend/groupdetail/activity/GroupDetailActivity;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailViewModel;", "p3", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "p4", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/activity/GroupDetailActivity;Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailViewModel;Ljava/lang/String;Lid/dana/domain/recentrecipient/model/RecentRecipient;)V", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;)V", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "(Landroid/content/Context;Lid/dana/sendmoney/databinding/ActivityGroupDetailBinding;Lid/dana/sendmoney/ui/groupsend/groupdetail/model/BizGroupDetailResultModel;Landroidx/activity/result/ActivityResultLauncher;)V", "Ljava/lang/String;", "(Ljava/lang/String;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupDetailActivityExtKt {
    private static String PlaceComponentResult = "";

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static final void BuiltInFictitiousFunctionClassFactory(String str) {
        PlaceComponentResult = str;
    }

    public static final void MyBillsEntityDataFactory(ActivityGroupDetailBinding activityGroupDetailBinding, GroupDetailUiState.OnSuccessGetGroupDetail onSuccessGetGroupDetail) {
        Intrinsics.checkNotNullParameter(activityGroupDetailBinding, "");
        Intrinsics.checkNotNullParameter(onSuccessGetGroupDetail, "");
        activityGroupDetailBinding.moveToNextValue.scheduleImpl.setText(onSuccessGetGroupDetail.MyBillsEntityDataFactory.MyBillsEntityDataFactory.getAuthRequestContext);
    }

    public static final void PlaceComponentResult(Context context, ActivityGroupDetailBinding activityGroupDetailBinding, String str) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(activityGroupDetailBinding, "");
        Intrinsics.checkNotNullParameter(str, "");
        GlideApp.getAuthRequestContext(context).PlaceComponentResult(str).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) activityGroupDetailBinding.moveToNextValue.getAuthRequestContext);
    }

    public static final void PlaceComponentResult(final Context context, ActivityGroupDetailBinding activityGroupDetailBinding, final BizGroupDetailResultModel bizGroupDetailResultModel, final ActivityResultLauncher<Intent> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(activityGroupDetailBinding, "");
        Intrinsics.checkNotNullParameter(bizGroupDetailResultModel, "");
        Intrinsics.checkNotNullParameter(activityResultLauncher, "");
        activityGroupDetailBinding.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivityExtKt$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupDetailActivityExtKt.KClassImpl$Data$declaredNonStaticMembers$2(BizGroupDetailResultModel.this, context, activityResultLauncher);
            }
        });
    }

    public static final void BuiltInFictitiousFunctionClassFactory(final Context context, ActivityGroupDetailBinding activityGroupDetailBinding) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(activityGroupDetailBinding, "");
        activityGroupDetailBinding.scheduleImpl.getErrorConfigVersion.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivityExtKt$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupDetailActivityExtKt.PlaceComponentResult(context);
            }
        });
    }

    public static final void getAuthRequestContext(ActivityGroupDetailBinding activityGroupDetailBinding, boolean z) {
        Intrinsics.checkNotNullParameter(activityGroupDetailBinding, "");
        NestedScrollView nestedScrollView = activityGroupDetailBinding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
        boolean z2 = !z;
        nestedScrollView.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = activityGroupDetailBinding.lookAheadTest.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(z2 ? 0 : 8);
        EmptyStateView emptyStateView = activityGroupDetailBinding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
        emptyStateView.setVisibility(z ? 0 : 8);
        AppCompatImageView appCompatImageView = activityGroupDetailBinding.PlaceComponentResult.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(z2 ? 0 : 8);
    }

    public static final void PlaceComponentResult(Context context, ActivityGroupDetailBinding activityGroupDetailBinding, GroupDetailUiState.OnSuccessGetGroupDetail onSuccessGetGroupDetail) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(activityGroupDetailBinding, "");
        Intrinsics.checkNotNullParameter(onSuccessGetGroupDetail, "");
        TextView textView = activityGroupDetailBinding.moveToNextValue.lookAheadTest;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(R.string.text_desc_group_detail);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(onSuccessGetGroupDetail.MyBillsEntityDataFactory.getAuthRequestContext.size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
        Group group = activityGroupDetailBinding.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(onSuccessGetGroupDetail.MyBillsEntityDataFactory.getAuthRequestContext.size() == 10 ? 0 : 8);
    }

    public static final void PlaceComponentResult(final GroupDetailActivity groupDetailActivity, ActivityGroupDetailBinding activityGroupDetailBinding, final GroupDetailViewModel groupDetailViewModel, final String str, final RecentRecipient recentRecipient) {
        Intrinsics.checkNotNullParameter(groupDetailActivity, "");
        Intrinsics.checkNotNullParameter(activityGroupDetailBinding, "");
        Intrinsics.checkNotNullParameter(groupDetailViewModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        final ViewDialogEditGroupNameBinding viewDialogEditGroupNameBinding = activityGroupDetailBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        FrameLayout frameLayout = viewDialogEditGroupNameBinding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(0);
        viewDialogEditGroupNameBinding.scheduleImpl.setFocusable(true);
        viewDialogEditGroupNameBinding.scheduleImpl.setClickable(true);
        DanaTextBoxView danaTextBoxView = viewDialogEditGroupNameBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(danaTextBoxView, "");
        danaTextBoxView.addTextChangedListener(new TextWatcher() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivityExtKt$toEditNameGroupDialog$lambda-4$$inlined$onTextChanged$1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                String obj = p0 != null ? p0.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                TextView textView = ViewDialogEditGroupNameBinding.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = groupDetailActivity.getString(R.string.res_0x7f130e13_access_setshowcaseshowing_p);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(obj.length())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                textView.setText(format);
                if (StringsKt.isBlank(obj)) {
                    Editable text = ViewDialogEditGroupNameBinding.this.PlaceComponentResult.getText();
                    if (text != null) {
                        text.clear();
                    }
                    Intrinsics.checkNotNullExpressionValue(ViewDialogEditGroupNameBinding.this, "");
                    GroupDetailActivityExtKt.KClassImpl$Data$declaredNonStaticMembers$2(ViewDialogEditGroupNameBinding.this, groupDetailActivity);
                } else {
                    Intrinsics.checkNotNullExpressionValue(ViewDialogEditGroupNameBinding.this, "");
                    GroupDetailActivityExtKt.PlaceComponentResult(ViewDialogEditGroupNameBinding.this, groupDetailActivity, groupDetailViewModel, str, recentRecipient);
                }
                GroupDetailActivityExtKt.BuiltInFictitiousFunctionClassFactory(obj);
            }
        });
        viewDialogEditGroupNameBinding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivityExtKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupDetailActivityExtKt.MyBillsEntityDataFactory(ViewDialogEditGroupNameBinding.this, groupDetailActivity);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BizGroupDetailResultModel bizGroupDetailResultModel, Context context, ActivityResultLauncher activityResultLauncher) {
        Intrinsics.checkNotNullParameter(bizGroupDetailResultModel, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(activityResultLauncher, "");
        GroupSendSummaryActivity.Companion companion = GroupSendSummaryActivity.INSTANCE;
        activityResultLauncher.MyBillsEntityDataFactory(GroupSendSummaryActivity.Companion.getAuthRequestContext(new GroupSendIntentModel(GroupDetailActivity.ACTIVITY_NAME, bizGroupDetailResultModel.KClassImpl$Data$declaredNonStaticMembers$2(), bizGroupDetailResultModel.PlaceComponentResult(context), bizGroupDetailResultModel.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, bizGroupDetailResultModel.MyBillsEntityDataFactory.getAuthRequestContext, bizGroupDetailResultModel.MyBillsEntityDataFactory.MyBillsEntityDataFactory, bizGroupDetailResultModel.MyBillsEntityDataFactory.PlaceComponentResult, false, 128, null), SourceTypeProperty.GROUP_DETAIL, context), null);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ViewDialogEditGroupNameBinding viewDialogEditGroupNameBinding, GroupDetailActivity groupDetailActivity) {
        Intrinsics.checkNotNullParameter(viewDialogEditGroupNameBinding, "");
        Intrinsics.checkNotNullParameter(groupDetailActivity, "");
        FrameLayout frameLayout = viewDialogEditGroupNameBinding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(8);
        Editable text = viewDialogEditGroupNameBinding.PlaceComponentResult.getText();
        if (text != null) {
            text.clear();
        }
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(groupDetailActivity);
    }

    public static /* synthetic */ void getAuthRequestContext(final GroupDetailViewModel groupDetailViewModel, String str, final RecentRecipient recentRecipient, ViewDialogEditGroupNameBinding viewDialogEditGroupNameBinding, GroupDetailActivity groupDetailActivity) {
        Intrinsics.checkNotNullParameter(groupDetailViewModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        Intrinsics.checkNotNullParameter(viewDialogEditGroupNameBinding, "");
        Intrinsics.checkNotNullParameter(groupDetailActivity, "");
        final String str2 = PlaceComponentResult;
        if (str2 == null) {
            str2 = "";
        }
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        groupDetailViewModel.scheduleImpl.execute(new ModifyGroupName.Param(str, str2), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyGroupName$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.DanaLogoLoading(true)));
            }
        }, new Function1<BizGroupModifyResult, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyGroupName$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BizGroupModifyResult bizGroupModifyResult) {
                invoke2(bizGroupModifyResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BizGroupModifyResult bizGroupModifyResult) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(bizGroupModifyResult, "");
                RecentRecipient.this.setName(str2);
                groupDetailViewModel.getAuthRequestContext(RecentRecipient.this);
                mutableStateFlow = groupDetailViewModel.getAuthRequestContext;
                String str3 = str2;
                do {
                    value = mutableStateFlow.getValue();
                    GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnSuccessModifyGroupName(0, str3, 1, null)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyGroupName$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnErrorWithShowToast(0, th, GroupSendOperationType.GROUP_MODIFY, SourceTypeProperty.GROUP_SEND_MODIFY_GROUP_NAME, 1, null)));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyGroupName$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.DanaLogoLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(groupDetailViewModel));
        FrameLayout frameLayout = viewDialogEditGroupNameBinding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(8);
        Editable text = viewDialogEditGroupNameBinding.PlaceComponentResult.getText();
        if (text != null) {
            text.clear();
        }
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(groupDetailActivity);
    }

    public static /* synthetic */ void PlaceComponentResult(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        DanaH5Helper.INSTANCE.openUrl(context, DanaUrl.HISTORY_TRANSACTION_GROUP_SEND);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ViewDialogEditGroupNameBinding viewDialogEditGroupNameBinding, Context context) {
        DanaButtonPrimaryView danaButtonPrimaryView = viewDialogEditGroupNameBinding.getAuthRequestContext;
        danaButtonPrimaryView.setDisabled(context.getString(R.string.res_0x7f1313a5_securitysettingsactivity_createpinlauncher_2_2));
        danaButtonPrimaryView.setEnabled(false);
    }

    public static final /* synthetic */ void PlaceComponentResult(final ViewDialogEditGroupNameBinding viewDialogEditGroupNameBinding, final GroupDetailActivity groupDetailActivity, final GroupDetailViewModel groupDetailViewModel, final String str, final RecentRecipient recentRecipient) {
        DanaButtonPrimaryView danaButtonPrimaryView = viewDialogEditGroupNameBinding.getAuthRequestContext;
        danaButtonPrimaryView.setActiveButton(danaButtonPrimaryView.getContext().getString(R.string.res_0x7f1313a5_securitysettingsactivity_createpinlauncher_2_2), null);
        danaButtonPrimaryView.setEnabled(true);
        danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivityExtKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupDetailActivityExtKt.getAuthRequestContext(GroupDetailViewModel.this, str, recentRecipient, viewDialogEditGroupNameBinding, groupDetailActivity);
            }
        });
    }
}
