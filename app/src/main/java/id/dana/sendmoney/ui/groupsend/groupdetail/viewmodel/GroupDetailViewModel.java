package id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel;

import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentrecipient.interactor.GetFavoriteAccountCount;
import id.dana.domain.recentrecipient.interactor.GetGroupFavoriteValue;
import id.dana.domain.recentrecipient.interactor.GetLeastTransactionFavoriteAccount;
import id.dana.domain.recentrecipient.interactor.GetMaxFavoriteAccount;
import id.dana.domain.recentrecipient.interactor.RemoveRecentGroup;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.sendmoney.constants.GroupSendRecipientType;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.DeleteGroup;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendDetail;
import id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupImage;
import id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupName;
import id.dana.sendmoney.domain.groupsend.model.detail.BizGroupDetailResult;
import id.dana.sendmoney.ui.groupsend.groupdetail.mapper.GroupSendDetailModelMapperKt;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailUiState;
import id.dana.sendmoney.util.SourceTypeProperty;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001Bi\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001d\u0012\u0006\u0010\u000e\u001a\u00020\u0016\u0012\u0006\u00109\u001a\u00020(\u0012\u0006\u0010:\u001a\u00020&\u0012\u0006\u0010;\u001a\u00020*\u0012\u0006\u0010<\u001a\u00020\u001a\u0012\u0006\u0010=\u001a\u00020\u0018\u0012\u0006\u0010>\u001a\u00020#\u0012\u0006\u0010?\u001a\u00020 \u0012\u0006\u0010@\u001a\u000204\u0012\u0006\u0010A\u001a\u00020-\u0012\u0006\u0010B\u001a\u000201¢\u0006\u0004\bC\u0010DJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0005\u0010\u0010J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\t\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0010R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0011\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u000f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010$R\u0014\u0010\u001e\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010'R\u0014\u0010\u0014\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010)R\u0014\u0010\u001b\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u0010+\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001307X\u0006¢\u0006\u0006\n\u0004\b\"\u00108"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "PlaceComponentResult", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "getAuthRequestContext", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;)V", "onCleared", "()V", "", "p1", "MyBillsEntityDataFactory", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;Z)V", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailUiState;", "scheduleImpl", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/domain/groupsend/interactor/DeleteGroup;", "Lid/dana/sendmoney/domain/groupsend/interactor/DeleteGroup;", "Lid/dana/domain/recentrecipient/interactor/GetFavoriteAccountCount;", "Lid/dana/domain/recentrecipient/interactor/GetFavoriteAccountCount;", "Lid/dana/domain/recentrecipient/interactor/GetGroupFavoriteValue;", "lookAheadTest", "Lid/dana/domain/recentrecipient/interactor/GetGroupFavoriteValue;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendDetail;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendDetail;", "Lid/dana/domain/recentrecipient/interactor/GetLeastTransactionFavoriteAccount;", "Lid/dana/domain/recentrecipient/interactor/GetLeastTransactionFavoriteAccount;", "moveToNextValue", "Lid/dana/domain/recentrecipient/interactor/GetMaxFavoriteAccount;", "Lid/dana/domain/recentrecipient/interactor/GetMaxFavoriteAccount;", "getErrorConfigVersion", "Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupImage;", "Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupImage;", "Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupName;", "Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupName;", "Lid/dana/domain/recentrecipient/interactor/RemoveRecentGroup;", "initRecordTimeStamp", "Lid/dana/domain/recentrecipient/interactor/RemoveRecentGroup;", "Lid/dana/domain/recentbank/interactor/SaveRecentBank;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/recentbank/interactor/SaveRecentBank;", "GetContactSyncConfig", "Lid/dana/domain/recentcontact/interactor/SaveRecentContact;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/recentcontact/interactor/SaveRecentContact;", "Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup;", "DatabaseTableConfigUtil", "Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "<init>", "(Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendDetail;Lid/dana/sendmoney/domain/groupsend/interactor/DeleteGroup;Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupName;Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupImage;Lid/dana/domain/recentrecipient/interactor/RemoveRecentGroup;Lid/dana/domain/recentrecipient/interactor/GetGroupFavoriteValue;Lid/dana/domain/recentrecipient/interactor/GetFavoriteAccountCount;Lid/dana/domain/recentrecipient/interactor/GetMaxFavoriteAccount;Lid/dana/domain/recentrecipient/interactor/GetLeastTransactionFavoriteAccount;Lid/dana/domain/recentrecipient/interactor/SaveRecentGroup;Lid/dana/domain/recentbank/interactor/SaveRecentBank;Lid/dana/domain/recentcontact/interactor/SaveRecentContact;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupDetailViewModel extends ViewModel {
    public final DeleteGroup BuiltInFictitiousFunctionClassFactory;
    private final SaveRecentGroup DatabaseTableConfigUtil;
    public final GetFavoriteAccountCount KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final GetMaxFavoriteAccount getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetGroupSendDetail MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final SaveRecentBank GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final SaveRecentContact initRecordTimeStamp;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ModifyGroupImage NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final GetLeastTransactionFavoriteAccount moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final ModifyGroupName scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final RemoveRecentGroup lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetGroupFavoriteValue PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final StateFlow<GroupDetailUiState> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final MutableStateFlow<GroupDetailUiState> getAuthRequestContext;

    @Inject
    public GroupDetailViewModel(GetGroupSendDetail getGroupSendDetail, DeleteGroup deleteGroup, ModifyGroupName modifyGroupName, ModifyGroupImage modifyGroupImage, RemoveRecentGroup removeRecentGroup, GetGroupFavoriteValue getGroupFavoriteValue, GetFavoriteAccountCount getFavoriteAccountCount, GetMaxFavoriteAccount getMaxFavoriteAccount, GetLeastTransactionFavoriteAccount getLeastTransactionFavoriteAccount, SaveRecentGroup saveRecentGroup, SaveRecentBank saveRecentBank, SaveRecentContact saveRecentContact) {
        Intrinsics.checkNotNullParameter(getGroupSendDetail, "");
        Intrinsics.checkNotNullParameter(deleteGroup, "");
        Intrinsics.checkNotNullParameter(modifyGroupName, "");
        Intrinsics.checkNotNullParameter(modifyGroupImage, "");
        Intrinsics.checkNotNullParameter(removeRecentGroup, "");
        Intrinsics.checkNotNullParameter(getGroupFavoriteValue, "");
        Intrinsics.checkNotNullParameter(getFavoriteAccountCount, "");
        Intrinsics.checkNotNullParameter(getMaxFavoriteAccount, "");
        Intrinsics.checkNotNullParameter(getLeastTransactionFavoriteAccount, "");
        Intrinsics.checkNotNullParameter(saveRecentGroup, "");
        Intrinsics.checkNotNullParameter(saveRecentBank, "");
        Intrinsics.checkNotNullParameter(saveRecentContact, "");
        this.MyBillsEntityDataFactory = getGroupSendDetail;
        this.BuiltInFictitiousFunctionClassFactory = deleteGroup;
        this.scheduleImpl = modifyGroupName;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = modifyGroupImage;
        this.lookAheadTest = removeRecentGroup;
        this.PlaceComponentResult = getGroupFavoriteValue;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getFavoriteAccountCount;
        this.getErrorConfigVersion = getMaxFavoriteAccount;
        this.moveToNextValue = getLeastTransactionFavoriteAccount;
        this.DatabaseTableConfigUtil = saveRecentGroup;
        this.GetContactSyncConfig = saveRecentBank;
        this.initRecordTimeStamp = saveRecentContact;
        MutableStateFlow<GroupDetailUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(GroupDetailUiState.None.INSTANCE);
        this.getAuthRequestContext = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.execute(new GetGroupSendDetail.Param(p0), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$getGroupDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.ShimmerLoading(true)));
            }
        }, new Function1<BizGroupDetailResult, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$getGroupDetail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BizGroupDetailResult bizGroupDetailResult) {
                invoke2(bizGroupDetailResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BizGroupDetailResult bizGroupDetailResult) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(bizGroupDetailResult, "");
                mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnSuccessGetGroupDetail(GroupSendDetailModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(bizGroupDetailResult))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$getGroupDetail$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.Error(th, GroupSendOperationType.GROUP_DETAIL)));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$getGroupDetail$4
            /* JADX INFO: Access modifiers changed from: package-private */
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
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.ShimmerLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(this));
    }

    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseUseCase.execute$default(this.PlaceComponentResult, p0, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$getGroupFavoriteValue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnSuccessGetGroupFavoriteValue(z)));
            }
        }, null, 4, null);
    }

    public final void BuiltInFictitiousFunctionClassFactory(RecentRecipient p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        int type = p0.getType();
        if (type == 0) {
            KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        } else if (type == 1) {
            MyBillsEntityDataFactory(p0, p1);
        } else if (type == 2) {
            getAuthRequestContext(p0, p1);
        }
    }

    private final void getAuthRequestContext(final RecentRecipient p0, final boolean p1) {
        SaveRecentGroup saveRecentGroup = this.DatabaseTableConfigUtil;
        SaveRecentGroup.Params.Companion companion = SaveRecentGroup.Params.INSTANCE;
        String id2 = p0.getId();
        Intrinsics.checkNotNullExpressionValue(id2, "");
        String name = p0.getName();
        Intrinsics.checkNotNullExpressionValue(name, "");
        String imageUrl = p0.getImageUrl();
        Intrinsics.checkNotNullExpressionValue(imageUrl, "");
        int participantCount = p0.getParticipantCount();
        if (participantCount == null) {
            participantCount = 0;
        }
        saveRecentGroup.execute(companion.forUpdateRecentGroup(id2, name, imageUrl, participantCount.intValue(), GroupSendRecipientType.CONTACT, p1), new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$updateRecentGroupFavoriteState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                MutableStateFlow mutableStateFlow;
                Object value;
                String id3;
                mutableStateFlow = GroupDetailViewModel.this.getAuthRequestContext;
                boolean z2 = p1;
                RecentRecipient recentRecipient = p0;
                do {
                    value = mutableStateFlow.getValue();
                    GroupDetailUiState groupDetailUiState = (GroupDetailUiState) value;
                    id3 = recentRecipient.getId();
                    Intrinsics.checkNotNullExpressionValue(id3, "");
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnSuccessUpdateGroupFavoriteState(z, z2, id3)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$updateRecentGroupFavoriteState$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                } while (!mutableStateFlow.compareAndSet(value, new GroupDetailUiState.OnErrorWithShowToast(0, th, "saveRecentGroup", SourceTypeProperty.GROUP_SEND_GROUP_DETAIL, 1, null)));
            }
        });
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(RecentRecipient p0, boolean p1) {
        this.initRecordTimeStamp.execute(new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$updateRecentContactFavoriteState$1
        }, SaveRecentContact.Params.forUpdateRecentContact(p0.getName(), p0.getNumber(), p0.getId(), p0.getImageUrl(), p0.getTransactionCount(), p1));
    }

    private final void MyBillsEntityDataFactory(RecentRecipient p0, boolean p1) {
        this.GetContactSyncConfig.execute(new DefaultObserver<Boolean>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$updateRecentBankFavoriteState$1
        }, SaveRecentBank.Params.forUpdateRecentBank(p0.getRecipientName(), p0.getInstLocalName(), p0.getNumber(), p0.getImageUrl(), p0.getAlias(), p0.getId(), p0.getInstLocalName(), p0.getPayMethod(), p0.getPayOption(), p0.getSenderName(), p0.getCardIndexNo(), p0.getNumber(), p0.getPrefix(), p0.getTransactionCount(), Long.valueOf(p0.getLastUpdated()), p1));
    }

    public final void getAuthRequestContext(RecentRecipient p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SaveRecentGroup saveRecentGroup = this.DatabaseTableConfigUtil;
        SaveRecentGroup.Params.Companion companion = SaveRecentGroup.Params.INSTANCE;
        String id2 = p0.getId();
        Intrinsics.checkNotNullExpressionValue(id2, "");
        String name = p0.getName();
        Intrinsics.checkNotNullExpressionValue(name, "");
        String imageUrl = p0.getImageUrl();
        Intrinsics.checkNotNullExpressionValue(imageUrl, "");
        int participantCount = p0.getParticipantCount();
        if (participantCount == null) {
            participantCount = 0;
        }
        saveRecentGroup.execute(companion.forUpdateRecentGroup(id2, name, imageUrl, participantCount.intValue(), GroupSendRecipientType.CONTACT, p0.isFavorite()), new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyRecentGroup$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel$modifyRecentGroup$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        this.DatabaseTableConfigUtil.dispose();
        this.lookAheadTest.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.PlaceComponentResult.dispose();
        this.GetContactSyncConfig.dispose();
        this.initRecordTimeStamp.dispose();
        this.getErrorConfigVersion.dispose();
        this.moveToNextValue.dispose();
    }
}
