package id.dana.sendmoney.ui.groupsend.groupdetail.activity;

import android.widget.CompoundButton;
import androidx.view.Lifecycle;
import androidx.view.RepeatOnLifecycleKt;
import androidx.view.result.ActivityResultLauncher;
import com.google.android.material.switchmaterial.SwitchMaterial;
import id.dana.core.ui.util.DANAToast;
import id.dana.core.ui.util.MaskedTextUtil;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ActivityGroupDetailBinding;
import id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$initLifecycleActivity$1;
import id.dana.sendmoney.ui.groupsend.groupdetail.adapter.GroupDetailAdapter;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.BizGroupDetailResultModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.GroupDetailModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.ParticipantDetailModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailUiState;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$getTotalFavoriteAccountCount$1;
import id.dana.sendmoney.ui.groupsend.landing.model.GroupModel;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.sendmoney.util.SourceTypeProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$initLifecycleActivity$1", f = "GroupDetailActivity.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GroupDetailActivity$initLifecycleActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GroupDetailActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupDetailActivity$initLifecycleActivity$1(GroupDetailActivity groupDetailActivity, Continuation<? super GroupDetailActivity$initLifecycleActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = groupDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GroupDetailActivity$initLifecycleActivity$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GroupDetailActivity$initLifecycleActivity$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$initLifecycleActivity$1$1", f = "GroupDetailActivity.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$initLifecycleActivity$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GroupDetailActivity groupDetailActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = groupDetailActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GroupDetailActivity.access$getVm(this.this$0).NetworkUserEntityData$$ExternalSyntheticLambda1.collect(new C01911(this.this$0), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$initLifecycleActivity$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C01911<T> implements FlowCollector {
            final /* synthetic */ GroupDetailActivity PlaceComponentResult;

            C01911(GroupDetailActivity groupDetailActivity) {
                this.PlaceComponentResult = groupDetailActivity;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
            public final Object emit(GroupDetailUiState groupDetailUiState, Continuation<? super Unit> continuation) {
                RecentRecipient recentRecipient;
                RecentRecipient recentRecipient2;
                ActivityGroupDetailBinding binding;
                RecentRecipient recentRecipient3;
                ActivityGroupDetailBinding binding2;
                BizGroupDetailResultModel bizGroupDetailResultModel;
                RecentRecipient recentRecipient4;
                ActivityGroupDetailBinding binding3;
                BizGroupDetailResultModel bizGroupDetailResultModel2;
                RecentRecipient recentRecipient5;
                GroupDetailAdapter groupDetailAdapter;
                GroupDetailAdapter groupDetailAdapter2;
                ActivityGroupDetailBinding binding4;
                ActivityGroupDetailBinding binding5;
                ActivityGroupDetailBinding binding6;
                ActivityGroupDetailBinding binding7;
                ActivityGroupDetailBinding binding8;
                BizGroupDetailResultModel bizGroupDetailResultModel3;
                ActivityResultLauncher activityResultLauncher;
                ActivityGroupDetailBinding binding9;
                boolean z;
                RecentRecipient recentRecipient6;
                ActivityGroupDetailBinding binding10;
                RecentRecipient recentRecipient7;
                ActivityGroupDetailBinding binding11;
                ActivityGroupDetailBinding binding12;
                if (groupDetailUiState instanceof GroupDetailUiState.Error) {
                    binding12 = this.PlaceComponentResult.getBinding();
                    GroupDetailActivityExtKt.getAuthRequestContext(binding12, true);
                    GroupSendTrackerHelper groupSendTrackerHelper = this.PlaceComponentResult.getGroupSendTrackerHelper();
                    GroupDetailUiState.Error error = (GroupDetailUiState.Error) groupDetailUiState;
                    Throwable th = error.MyBillsEntityDataFactory;
                    String str = error.PlaceComponentResult;
                    String string = this.PlaceComponentResult.getString(R.string.general_error_desc_failed_load);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    groupSendTrackerHelper.MyBillsEntityDataFactory(th, str, string, SourceTypeProperty.GROUP_SEND_GROUP_DETAIL);
                } else if (groupDetailUiState instanceof GroupDetailUiState.OnErrorWithShowToast) {
                    GroupDetailUiState.OnErrorWithShowToast onErrorWithShowToast = (GroupDetailUiState.OnErrorWithShowToast) groupDetailUiState;
                    String string2 = this.PlaceComponentResult.getString(onErrorWithShowToast.getAuthRequestContext);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                    DANAToast.MyBillsEntityDataFactory(this.PlaceComponentResult, string2, "");
                    this.PlaceComponentResult.getGroupSendTrackerHelper().MyBillsEntityDataFactory(onErrorWithShowToast.MyBillsEntityDataFactory, onErrorWithShowToast.PlaceComponentResult, string2, onErrorWithShowToast.BuiltInFictitiousFunctionClassFactory);
                } else if (groupDetailUiState instanceof GroupDetailUiState.DanaLogoLoading) {
                    GroupDetailActivity.access$setDanaLogoLoading(this.PlaceComponentResult, ((GroupDetailUiState.DanaLogoLoading) groupDetailUiState).getBuiltInFictitiousFunctionClassFactory());
                } else if (groupDetailUiState instanceof GroupDetailUiState.ShimmerLoading) {
                    GroupDetailShimmerExt groupDetailShimmerExt = GroupDetailShimmerExt.INSTANCE;
                    boolean builtInFictitiousFunctionClassFactory = ((GroupDetailUiState.ShimmerLoading) groupDetailUiState).getBuiltInFictitiousFunctionClassFactory();
                    binding11 = this.PlaceComponentResult.getBinding();
                    Intrinsics.checkNotNullParameter(binding11, "");
                    if (!builtInFictitiousFunctionClassFactory) {
                        GroupDetailShimmerExt.PlaceComponentResult();
                    } else {
                        GroupDetailShimmerExt.PlaceComponentResult(binding11);
                        GroupDetailShimmerExt.BuiltInFictitiousFunctionClassFactory(binding11);
                        GroupDetailShimmerExt.MyBillsEntityDataFactory(binding11);
                        GroupDetailShimmerExt.getAuthRequestContext(binding11);
                    }
                } else {
                    RecentRecipient recentRecipient8 = null;
                    RecentRecipient recentRecipient9 = null;
                    BizGroupDetailResultModel bizGroupDetailResultModel4 = null;
                    BizGroupDetailResultModel bizGroupDetailResultModel5 = null;
                    if (groupDetailUiState instanceof GroupDetailUiState.OnSuccessGetGroupDetail) {
                        GroupDetailUiState.OnSuccessGetGroupDetail onSuccessGetGroupDetail = (GroupDetailUiState.OnSuccessGetGroupDetail) groupDetailUiState;
                        this.PlaceComponentResult.getAuthRequestContext = onSuccessGetGroupDetail.MyBillsEntityDataFactory;
                        this.PlaceComponentResult.getErrorConfigVersion = new RecentRecipient();
                        recentRecipient5 = this.PlaceComponentResult.getErrorConfigVersion;
                        if (recentRecipient5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            recentRecipient5 = null;
                        }
                        recentRecipient5.setType(2);
                        recentRecipient5.setId(onSuccessGetGroupDetail.MyBillsEntityDataFactory.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
                        recentRecipient5.setName(onSuccessGetGroupDetail.MyBillsEntityDataFactory.MyBillsEntityDataFactory.getAuthRequestContext);
                        recentRecipient5.setImageUrl(onSuccessGetGroupDetail.MyBillsEntityDataFactory.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
                        recentRecipient5.setParticipantCount(Boxing.boxInt(onSuccessGetGroupDetail.MyBillsEntityDataFactory.getAuthRequestContext.size()));
                        groupDetailAdapter = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (groupDetailAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            groupDetailAdapter = null;
                        }
                        final GroupDetailActivity groupDetailActivity = this.PlaceComponentResult;
                        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity.initLifecycleActivity.1.1.1.2
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
                                BizGroupDetailResultModel bizGroupDetailResultModel6;
                                GroupDetailActivity groupDetailActivity2 = GroupDetailActivity.this;
                                bizGroupDetailResultModel6 = groupDetailActivity2.getAuthRequestContext;
                                if (bizGroupDetailResultModel6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    bizGroupDetailResultModel6 = null;
                                }
                                GroupDetailActivity.access$navigateToRecipientActivity(groupDetailActivity2, bizGroupDetailResultModel6);
                            }
                        };
                        Intrinsics.checkNotNullParameter(function0, "");
                        groupDetailAdapter.MyBillsEntityDataFactory = function0;
                        groupDetailAdapter2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (groupDetailAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            groupDetailAdapter2 = null;
                        }
                        List<ParticipantDetailModel> list = onSuccessGetGroupDetail.MyBillsEntityDataFactory.getAuthRequestContext;
                        Intrinsics.checkNotNullParameter(list, "");
                        ArrayList arrayList = new ArrayList();
                        for (ParticipantDetailModel participantDetailModel : list) {
                            String str2 = participantDetailModel.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                            String KClassImpl$Data$declaredNonStaticMembers$2 = GroupDetailAdapter.KClassImpl$Data$declaredNonStaticMembers$2(participantDetailModel);
                            MaskedTextUtil maskedTextUtil = MaskedTextUtil.INSTANCE;
                            arrayList.add(new GroupDetailModel(1, str2, KClassImpl$Data$declaredNonStaticMembers$2, MaskedTextUtil.PlaceComponentResult(participantDetailModel.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp), Boolean.valueOf(GroupDetailAdapter.getAuthRequestContext(participantDetailModel.getAuthRequestContext))));
                        }
                        groupDetailAdapter2.BuiltInFictitiousFunctionClassFactory = arrayList;
                        if (groupDetailAdapter2.BuiltInFictitiousFunctionClassFactory.size() > 6) {
                            int i = 0;
                            for (T t : CollectionsKt.slice((List) groupDetailAdapter2.BuiltInFictitiousFunctionClassFactory, new IntRange(0, 5))) {
                                int i2 = i + 1;
                                if (i < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                groupDetailAdapter2.KClassImpl$Data$declaredNonStaticMembers$2.add(i2, (GroupDetailModel) t);
                                i = i2;
                            }
                        } else {
                            int i3 = 0;
                            for (T t2 : groupDetailAdapter2.BuiltInFictitiousFunctionClassFactory) {
                                int i4 = i3 + 1;
                                if (i3 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                groupDetailAdapter2.KClassImpl$Data$declaredNonStaticMembers$2.add(i4, (GroupDetailModel) t2);
                                i3 = i4;
                            }
                        }
                        groupDetailAdapter2.notifyDataSetChanged();
                        binding4 = this.PlaceComponentResult.getBinding();
                        GroupDetailActivityExtKt.MyBillsEntityDataFactory(binding4, onSuccessGetGroupDetail);
                        GroupDetailActivity groupDetailActivity2 = this.PlaceComponentResult;
                        GroupDetailActivity groupDetailActivity3 = groupDetailActivity2;
                        binding5 = groupDetailActivity2.getBinding();
                        GroupDetailActivityExtKt.PlaceComponentResult(groupDetailActivity3, binding5, onSuccessGetGroupDetail.MyBillsEntityDataFactory.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
                        GroupDetailActivity groupDetailActivity4 = this.PlaceComponentResult;
                        GroupDetailActivity groupDetailActivity5 = groupDetailActivity4;
                        binding6 = groupDetailActivity4.getBinding();
                        GroupDetailActivityExtKt.PlaceComponentResult(groupDetailActivity5, binding6, onSuccessGetGroupDetail);
                        binding7 = this.PlaceComponentResult.getBinding();
                        GroupDetailActivityExtKt.getAuthRequestContext(binding7, false);
                        GroupDetailActivity groupDetailActivity6 = this.PlaceComponentResult;
                        GroupDetailActivity groupDetailActivity7 = groupDetailActivity6;
                        binding8 = groupDetailActivity6.getBinding();
                        bizGroupDetailResultModel3 = this.PlaceComponentResult.getAuthRequestContext;
                        if (bizGroupDetailResultModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            bizGroupDetailResultModel3 = null;
                        }
                        activityResultLauncher = this.PlaceComponentResult.initRecordTimeStamp;
                        GroupDetailActivityExtKt.PlaceComponentResult(groupDetailActivity7, binding8, bizGroupDetailResultModel3, activityResultLauncher);
                        GroupDetailActivity groupDetailActivity8 = this.PlaceComponentResult;
                        GroupDetailActivity groupDetailActivity9 = groupDetailActivity8;
                        binding9 = groupDetailActivity8.getBinding();
                        GroupDetailActivityExtKt.BuiltInFictitiousFunctionClassFactory(groupDetailActivity9, binding9);
                        z = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (z) {
                            recentRecipient6 = this.PlaceComponentResult.getErrorConfigVersion;
                            if (recentRecipient6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                recentRecipient6 = null;
                            }
                            binding10 = this.PlaceComponentResult.getBinding();
                            recentRecipient6.setFavorite(binding10.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0.isChecked());
                            GroupDetailViewModel access$getVm = GroupDetailActivity.access$getVm(this.PlaceComponentResult);
                            recentRecipient7 = this.PlaceComponentResult.getErrorConfigVersion;
                            if (recentRecipient7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                recentRecipient9 = recentRecipient7;
                            }
                            access$getVm.getAuthRequestContext(recentRecipient9);
                        }
                    } else if (groupDetailUiState instanceof GroupDetailUiState.OnSuccessDeleteGroup) {
                        this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                        DANAToast dANAToast2 = DANAToast.BuiltInFictitiousFunctionClassFactory;
                        GroupDetailActivity groupDetailActivity10 = this.PlaceComponentResult;
                        GroupDetailActivity groupDetailActivity11 = groupDetailActivity10;
                        String string3 = groupDetailActivity10.getString(((GroupDetailUiState.OnSuccessDeleteGroup) groupDetailUiState).MyBillsEntityDataFactory);
                        Intrinsics.checkNotNullExpressionValue(string3, "");
                        String string4 = this.PlaceComponentResult.getApplicationContext().getString(R.string.res_0x7f131720_navigationmenupresenter_headerviewholder);
                        Intrinsics.checkNotNullExpressionValue(string4, "");
                        DANAToast.PlaceComponentResult(groupDetailActivity11, string3, string4);
                        GroupDetailActivity.access$setResultAndNavigateBackToLandingActivity(this.PlaceComponentResult);
                        this.PlaceComponentResult.finish();
                    } else if (groupDetailUiState instanceof GroupDetailUiState.OnSuccessModifyGroupName) {
                        this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                        recentRecipient4 = this.PlaceComponentResult.getErrorConfigVersion;
                        if (recentRecipient4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            recentRecipient4 = null;
                        }
                        GroupDetailUiState.OnSuccessModifyGroupName onSuccessModifyGroupName = (GroupDetailUiState.OnSuccessModifyGroupName) groupDetailUiState;
                        recentRecipient4.setName(onSuccessModifyGroupName.BuiltInFictitiousFunctionClassFactory);
                        DANAToast dANAToast3 = DANAToast.BuiltInFictitiousFunctionClassFactory;
                        GroupDetailActivity groupDetailActivity12 = this.PlaceComponentResult;
                        GroupDetailActivity groupDetailActivity13 = groupDetailActivity12;
                        String string5 = groupDetailActivity12.getString(onSuccessModifyGroupName.MyBillsEntityDataFactory);
                        Intrinsics.checkNotNullExpressionValue(string5, "");
                        String string6 = this.PlaceComponentResult.getString(R.string.toast_success_edit_group_name);
                        Intrinsics.checkNotNullExpressionValue(string6, "");
                        DANAToast.PlaceComponentResult(groupDetailActivity13, string5, string6);
                        binding3 = this.PlaceComponentResult.getBinding();
                        binding3.moveToNextValue.scheduleImpl.setText(onSuccessModifyGroupName.BuiltInFictitiousFunctionClassFactory);
                        bizGroupDetailResultModel2 = this.PlaceComponentResult.getAuthRequestContext;
                        if (bizGroupDetailResultModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            bizGroupDetailResultModel4 = bizGroupDetailResultModel2;
                        }
                        GroupModel groupModel = bizGroupDetailResultModel4.MyBillsEntityDataFactory;
                        String str3 = onSuccessModifyGroupName.BuiltInFictitiousFunctionClassFactory;
                        Intrinsics.checkNotNullParameter(str3, "");
                        groupModel.getAuthRequestContext = str3;
                    } else if (groupDetailUiState instanceof GroupDetailUiState.OnSuccessModifyGroupImage) {
                        recentRecipient3 = this.PlaceComponentResult.getErrorConfigVersion;
                        if (recentRecipient3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            recentRecipient3 = null;
                        }
                        GroupDetailUiState.OnSuccessModifyGroupImage onSuccessModifyGroupImage = (GroupDetailUiState.OnSuccessModifyGroupImage) groupDetailUiState;
                        recentRecipient3.setImageUrl(onSuccessModifyGroupImage.MyBillsEntityDataFactory);
                        this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                        GroupDetailActivity groupDetailActivity14 = this.PlaceComponentResult;
                        GroupDetailActivity groupDetailActivity15 = groupDetailActivity14;
                        binding2 = groupDetailActivity14.getBinding();
                        GroupDetailActivityExtKt.PlaceComponentResult(groupDetailActivity15, binding2, onSuccessModifyGroupImage.MyBillsEntityDataFactory);
                        bizGroupDetailResultModel = this.PlaceComponentResult.getAuthRequestContext;
                        if (bizGroupDetailResultModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            bizGroupDetailResultModel5 = bizGroupDetailResultModel;
                        }
                        GroupModel groupModel2 = bizGroupDetailResultModel5.MyBillsEntityDataFactory;
                        String str4 = onSuccessModifyGroupImage.MyBillsEntityDataFactory;
                        Intrinsics.checkNotNullParameter(str4, "");
                        groupModel2.MyBillsEntityDataFactory = str4;
                        DANAToast dANAToast4 = DANAToast.BuiltInFictitiousFunctionClassFactory;
                        GroupDetailActivity groupDetailActivity16 = this.PlaceComponentResult;
                        GroupDetailActivity groupDetailActivity17 = groupDetailActivity16;
                        String string7 = groupDetailActivity16.getString(onSuccessModifyGroupImage.BuiltInFictitiousFunctionClassFactory);
                        Intrinsics.checkNotNullExpressionValue(string7, "");
                        String string8 = this.PlaceComponentResult.getString(R.string.toast_success_edit_icon);
                        Intrinsics.checkNotNullExpressionValue(string8, "");
                        DANAToast.PlaceComponentResult(groupDetailActivity17, string7, string8);
                    } else if (groupDetailUiState instanceof GroupDetailUiState.OnSuccessGetGroupFavoriteValue) {
                        binding = this.PlaceComponentResult.getBinding();
                        SwitchMaterial switchMaterial = binding.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        final GroupDetailActivity groupDetailActivity18 = this.PlaceComponentResult;
                        switchMaterial.setChecked(((GroupDetailUiState.OnSuccessGetGroupFavoriteValue) groupDetailUiState).getPlaceComponentResult());
                        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity$initLifecycleActivity$1$1$1$$ExternalSyntheticLambda0
                            @Override // android.widget.CompoundButton.OnCheckedChangeListener
                            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                                GroupDetailActivity$initLifecycleActivity$1.AnonymousClass1.C01911.getAuthRequestContext(GroupDetailActivity.this, z2);
                            }
                        });
                    } else if (groupDetailUiState instanceof GroupDetailUiState.OnSuccessGetMaxFavoriteAccount) {
                        this.PlaceComponentResult.DatabaseTableConfigUtil = ((GroupDetailUiState.OnSuccessGetMaxFavoriteAccount) groupDetailUiState).PlaceComponentResult;
                    } else if (groupDetailUiState instanceof GroupDetailUiState.OnSuccessGetTotalFavoriteAccount) {
                        this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2 = ((GroupDetailUiState.OnSuccessGetTotalFavoriteAccount) groupDetailUiState).BuiltInFictitiousFunctionClassFactory;
                    } else if (groupDetailUiState instanceof GroupDetailUiState.OnSuccessGetLeastTransactionFavoriteAccount) {
                        this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1 = ((GroupDetailUiState.OnSuccessGetLeastTransactionFavoriteAccount) groupDetailUiState).MyBillsEntityDataFactory;
                    } else if (groupDetailUiState instanceof GroupDetailUiState.OnSuccessUpdateGroupFavoriteState) {
                        recentRecipient = this.PlaceComponentResult.getErrorConfigVersion;
                        if (recentRecipient == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            recentRecipient = null;
                        }
                        GroupDetailUiState.OnSuccessUpdateGroupFavoriteState onSuccessUpdateGroupFavoriteState = (GroupDetailUiState.OnSuccessUpdateGroupFavoriteState) groupDetailUiState;
                        recentRecipient.setFavorite(onSuccessUpdateGroupFavoriteState.getGetAuthRequestContext());
                        String str5 = onSuccessUpdateGroupFavoriteState.BuiltInFictitiousFunctionClassFactory;
                        recentRecipient2 = this.PlaceComponentResult.getErrorConfigVersion;
                        if (recentRecipient2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            recentRecipient8 = recentRecipient2;
                        }
                        if (Intrinsics.areEqual(str5, recentRecipient8.getId())) {
                            GroupDetailActivity.access$showToastAfterManageFavorite(this.PlaceComponentResult, onSuccessUpdateGroupFavoriteState.getGetAuthRequestContext());
                        }
                        GroupDetailViewModel access$getVm2 = GroupDetailActivity.access$getVm(this.PlaceComponentResult);
                        BaseUseCase.execute$default(access$getVm2.KClassImpl$Data$declaredNonStaticMembers$2, NoParams.INSTANCE, new GroupDetailViewModel$getTotalFavoriteAccountCount$1(access$getVm2), null, 4, null);
                    }
                }
                return Unit.INSTANCE;
            }

            public static /* synthetic */ void getAuthRequestContext(GroupDetailActivity groupDetailActivity, boolean z) {
                boolean z2;
                RecentRecipient recentRecipient;
                int i;
                int i2;
                int i3;
                Intrinsics.checkNotNullParameter(groupDetailActivity, "");
                if (z) {
                    i = groupDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    i2 = groupDetailActivity.DatabaseTableConfigUtil;
                    if (i == i2) {
                        i3 = groupDetailActivity.DatabaseTableConfigUtil;
                        GroupDetailActivity.access$showFavoriteAccountExceedLimitDialog(groupDetailActivity, i3);
                        return;
                    }
                }
                z2 = groupDetailActivity.lookAheadTest;
                if (!z2) {
                    GroupDetailViewModel access$getVm = GroupDetailActivity.access$getVm(groupDetailActivity);
                    recentRecipient = groupDetailActivity.getErrorConfigVersion;
                    if (recentRecipient == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        recentRecipient = null;
                    }
                    access$getVm.BuiltInFictitiousFunctionClassFactory(recentRecipient, z);
                }
                groupDetailActivity.lookAheadTest = false;
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.KClassImpl$Data$declaredNonStaticMembers$2(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
