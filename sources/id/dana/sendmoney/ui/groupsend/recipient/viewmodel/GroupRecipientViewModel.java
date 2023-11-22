package id.dana.sendmoney.ui.groupsend.recipient.viewmodel;

import androidx.paging.CachedPagingDataKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;
import androidx.view.ViewModel;
import androidx.view.ViewModelKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.sendmoney.domain.groupsend.GroupSendOperationType;
import id.dana.sendmoney.domain.groupsend.interactor.GetBottomSheetOnBoardingFlow;
import id.dana.sendmoney.domain.groupsend.interactor.GetContactInjectionConfig;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendMaxParticipant;
import id.dana.sendmoney.domain.groupsend.interactor.GetPhoneNumber;
import id.dana.sendmoney.domain.groupsend.interactor.GetUserInfo;
import id.dana.sendmoney.domain.groupsend.interactor.InitSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.interactor.InjectDanaContact;
import id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupParticipants;
import id.dana.sendmoney.domain.groupsend.interactor.SaveDisplayBottomSheetOnBoardingFlow;
import id.dana.sendmoney.ui.groupsend.recipient.mapper.UserContactMapper;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientUiState;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 J2\u00020\u0001:\u0001JBa\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001d\u0012\u0006\u0010>\u001a\u00020\u001b\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010@\u001a\u000207\u0012\u0006\u0010A\u001a\u00020\u0015\u0012\u0006\u0010B\u001a\u00020#\u0012\u0006\u0010C\u001a\u00020\u001f\u0012\u0006\u0010D\u001a\u00020\u0018\u0012\u0006\u0010E\u001a\u00020)\u0012\u0006\u0010F\u001a\u00020,\u0012\u0006\u0010G\u001a\u00020&¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\b\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0014\u0010\u000b\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u0014\u0010\b\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010'R\u0014\u0010 \u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0403X\u0086\"¢\u0006\u0006\n\u0004\b.\u00105R\u0014\u00100\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120:X\u0006¢\u0006\u0006\n\u0004\b6\u0010;R\u0014\u00108\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010="}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "()V", "", "Lid/dana/sync_engine/domain/model/UserContact;", "p0", "MyBillsEntityDataFactory", "(Ljava/util/Set;)V", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "Landroidx/paging/PagingSource;", "", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "(Landroidx/paging/PagingSource;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientUiState;", "getAuthRequestContext", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetBottomSheetOnBoardingFlow;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetBottomSheetOnBoardingFlow;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/groupsend/interactor/GetContactInjectionConfig;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetContactInjectionConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;", "Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendMaxParticipant;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendMaxParticipant;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetPhoneNumber;", "lookAheadTest", "Lid/dana/sendmoney/domain/groupsend/interactor/GetPhoneNumber;", "moveToNextValue", "Lid/dana/sendmoney/domain/groupsend/interactor/GetUserInfo;", "Lid/dana/sendmoney/domain/groupsend/interactor/GetUserInfo;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup;", "Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup;", "scheduleImpl", "Lid/dana/sendmoney/domain/groupsend/interactor/InjectDanaContact;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/sendmoney/domain/groupsend/interactor/InjectDanaContact;", "Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupParticipants;", "Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupParticipants;", "getErrorConfigVersion", "Landroidx/paging/PagingConfig;", "initRecordTimeStamp", "Landroidx/paging/PagingConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lkotlinx/coroutines/flow/Flow;", "GetContactSyncConfig", "Lid/dana/sendmoney/domain/groupsend/interactor/SaveDisplayBottomSheetOnBoardingFlow;", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/domain/groupsend/interactor/SaveDisplayBottomSheetOnBoardingFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "Lid/dana/sendmoney/ui/groupsend/recipient/mapper/UserContactMapper;", "Lid/dana/sendmoney/ui/groupsend/recipient/mapper/UserContactMapper;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendMaxParticipant;Lid/dana/sync_engine/domain/interactor/GetContactsUseCase;Lid/dana/sendmoney/ui/groupsend/recipient/mapper/UserContactMapper;Lid/dana/sendmoney/domain/groupsend/interactor/SaveDisplayBottomSheetOnBoardingFlow;Lid/dana/sendmoney/domain/groupsend/interactor/GetBottomSheetOnBoardingFlow;Lid/dana/sendmoney/domain/groupsend/interactor/GetUserInfo;Lid/dana/sendmoney/domain/groupsend/interactor/GetPhoneNumber;Lid/dana/sendmoney/domain/groupsend/interactor/GetContactInjectionConfig;Lid/dana/sendmoney/domain/groupsend/interactor/InjectDanaContact;Lid/dana/sendmoney/domain/groupsend/interactor/ModifyGroupParticipants;Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupRecipientViewModel extends ViewModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final GetContactInjectionConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final SaveDisplayBottomSheetOnBoardingFlow initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final StateFlow<GroupRecipientUiState> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final GetGroupSendMaxParticipant MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final GetBottomSheetOnBoardingFlow BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final InitSendMoneyGroup scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final InjectDanaContact lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final UserContactMapper DatabaseTableConfigUtil;
    public final GetContactsUseCase PlaceComponentResult;
    public final MutableStateFlow<GroupRecipientUiState> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public Flow<PagingData<RecipientViewModel>> GetContactSyncConfig;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final PagingConfig NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    final GetPhoneNumber moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final GetUserInfo NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final ModifyGroupParticipants getErrorConfigVersion;

    @Inject
    public GroupRecipientViewModel(GetGroupSendMaxParticipant getGroupSendMaxParticipant, GetContactsUseCase getContactsUseCase, UserContactMapper userContactMapper, SaveDisplayBottomSheetOnBoardingFlow saveDisplayBottomSheetOnBoardingFlow, GetBottomSheetOnBoardingFlow getBottomSheetOnBoardingFlow, GetUserInfo getUserInfo, GetPhoneNumber getPhoneNumber, GetContactInjectionConfig getContactInjectionConfig, InjectDanaContact injectDanaContact, ModifyGroupParticipants modifyGroupParticipants, InitSendMoneyGroup initSendMoneyGroup) {
        Intrinsics.checkNotNullParameter(getGroupSendMaxParticipant, "");
        Intrinsics.checkNotNullParameter(getContactsUseCase, "");
        Intrinsics.checkNotNullParameter(userContactMapper, "");
        Intrinsics.checkNotNullParameter(saveDisplayBottomSheetOnBoardingFlow, "");
        Intrinsics.checkNotNullParameter(getBottomSheetOnBoardingFlow, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        Intrinsics.checkNotNullParameter(getPhoneNumber, "");
        Intrinsics.checkNotNullParameter(getContactInjectionConfig, "");
        Intrinsics.checkNotNullParameter(injectDanaContact, "");
        Intrinsics.checkNotNullParameter(modifyGroupParticipants, "");
        Intrinsics.checkNotNullParameter(initSendMoneyGroup, "");
        this.MyBillsEntityDataFactory = getGroupSendMaxParticipant;
        this.PlaceComponentResult = getContactsUseCase;
        this.DatabaseTableConfigUtil = userContactMapper;
        this.initRecordTimeStamp = saveDisplayBottomSheetOnBoardingFlow;
        this.BuiltInFictitiousFunctionClassFactory = getBottomSheetOnBoardingFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getUserInfo;
        this.moveToNextValue = getPhoneNumber;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getContactInjectionConfig;
        this.lookAheadTest = injectDanaContact;
        this.getErrorConfigVersion = modifyGroupParticipants;
        this.scheduleImpl = initSendMoneyGroup;
        MutableStateFlow<GroupRecipientUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(GroupRecipientUiState.None.INSTANCE);
        this.getAuthRequestContext = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = FlowKt.asStateFlow(MutableStateFlow);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new PagingConfig(20, 10, false, 0, 0, 0, 56, null);
    }

    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseFlowUseCase.execute$default(this.initRecordTimeStamp, p0, null, null, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$saveDisplayedBottomSheetOnBoarding$1
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
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SAVE_ON_BOARDING_PREFIX);
                sb.append(GroupRecipientViewModel.this.getClass().getName());
                sb.append("on Error");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
                mutableStateFlow = GroupRecipientViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    GroupRecipientUiState groupRecipientUiState = (GroupRecipientUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.Error(0, th, GroupSendOperationType.GROUP_DISPLAY_BOTTOM_SHEET_ONBOARDING, 1, null)));
            }
        }, null, ViewModelKt.PlaceComponentResult(this), 22, null);
    }

    public final void MyBillsEntityDataFactory(Set<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList = new ArrayList();
        for (UserContact userContact : p0) {
            if (userContact.PlaceComponentResult()) {
                arrayList.add(userContact.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
        }
        if ((!arrayList.isEmpty()) == true) {
            MutableStateFlow<GroupRecipientUiState> mutableStateFlow = this.getAuthRequestContext;
            do {
            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), new GroupRecipientUiState.OnSuccessGetDanaUserContact(arrayList)));
        }
    }

    public final void MyBillsEntityDataFactory(final PagingSource<Integer, RecipientViewModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Flow<PagingData<RecipientViewModel>> authRequestContext = CachedPagingDataKt.getAuthRequestContext(new Pager(this.NetworkUserEntityData$$ExternalSyntheticLambda2, null, new Function0<PagingSource<Integer, RecipientViewModel>>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel$subscribeToPagedList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PagingSource<Integer, RecipientViewModel> invoke() {
                return p0;
            }
        }, 2, null).PlaceComponentResult, ViewModelKt.PlaceComponentResult(this));
        Intrinsics.checkNotNullParameter(authRequestContext, "");
        this.GetContactSyncConfig = authRequestContext;
    }

    @Override // androidx.view.ViewModel
    public final void onCleared() {
        super.onCleared();
        this.PlaceComponentResult.dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(GroupRecipientViewModel groupRecipientViewModel, Set set) {
        GroupRecipientUiState value;
        List<RecipientViewModel> apply;
        MutableStateFlow<GroupRecipientUiState> mutableStateFlow = groupRecipientViewModel.getAuthRequestContext;
        do {
            value = mutableStateFlow.getValue();
            apply = groupRecipientViewModel.DatabaseTableConfigUtil.apply(CollectionsKt.toMutableList((Collection) set));
            Intrinsics.checkNotNullExpressionValue(apply, "");
        } while (!mutableStateFlow.compareAndSet(value, new GroupRecipientUiState.OnSuccessGetRecipientSyncContacts(apply)));
    }
}
