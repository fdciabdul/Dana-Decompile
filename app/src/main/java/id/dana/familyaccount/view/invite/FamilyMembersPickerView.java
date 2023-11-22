package id.dana.familyaccount.view.invite;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.extension.ContextExtKt;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ViewFamilyAccountMembersPickerSheetBinding;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.MemberInfoModel;
import id.dana.familyaccount.view.invite.FamilyMembersPickerView;
import id.dana.richview.contactselector.ContactSelectorView;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import id.dana.utils.KeyboardHelper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001IB/\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010E\u001a\u00020D\u0012\b\b\u0002\u0010F\u001a\u00020D¢\u0006\u0004\bG\u0010HJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010 H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020#H\u0002¢\u0006\u0004\b\u001b\u0010$J\r\u0010%\u001a\u00020\u0005¢\u0006\u0004\b%\u0010\tJ\u000f\u0010&\u001a\u00020\u0005H\u0014¢\u0006\u0004\b&\u0010\tJ\r\u0010'\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\tJ\u001b\u0010*\u001a\u00020\u00052\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050(¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010,¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\tJ\r\u00100\u001a\u00020\u0005¢\u0006\u0004\b0\u0010\tR\u001c\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00102R\u0018\u0010!\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00105R\u0011\u00106\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u00108R\u0018\u0010\u000f\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010:R\u0018\u0010\u001b\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010;R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010<8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u0010>"}, d2 = {"Lid/dana/familyaccount/view/invite/FamilyMembersPickerView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewFamilyAccountMembersPickerSheetBinding;", "Lio/reactivex/disposables/Disposable;", "disposable", "", "addDisposable", "(Lio/reactivex/disposables/Disposable;)V", "cancelPicker", "()V", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "p0", "Lid/dana/sendmoney/model/RecipientModel;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/familyaccount/model/FamilyMemberInfoModel;Lid/dana/sendmoney/model/RecipientModel;)Z", "Lid/dana/base/BaseActivity;", "baseActivity", "configPeekHeight", "(Lid/dana/base/BaseActivity;)V", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "dispose", "Lid/dana/familyaccount/view/invite/FamilyInviteMemberActivity;", "PlaceComponentResult", "()Lid/dana/familyaccount/view/invite/FamilyInviteMemberActivity;", "hide", "inflateViewBinding", "()Lid/dana/databinding/ViewFamilyAccountMembersPickerSheetBinding;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Z", "", "(Ljava/lang/String;)Z", "onCancel", "onDetachedFromWindow", "onFinished", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "openScanner", "(Lkotlin/jvm/functions/Function0;)V", "Lid/dana/familyaccount/view/invite/FamilyMembersPickerView$Listener;", "setListener", "(Lid/dana/familyaccount/view/invite/FamilyMembersPickerView$Listener;)V", "setup", ContainerUIProvider.KEY_SHOW, "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "MyBillsEntityDataFactory", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "isShow", "()Z", "Z", "getAuthRequestContext", "Lid/dana/familyaccount/view/invite/FamilyMembersPickerView$Listener;", "Ljava/lang/String;", "", "lookAheadTest", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyMembersPickerView extends BaseViewBindingRichView<ViewFamilyAccountMembersPickerSheetBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private BottomSheetBehavior<?> MyBillsEntityDataFactory;
    private Listener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private CompositeDisposable BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private List<String> NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/view/invite/FamilyMembersPickerView$Listener;", "", "onHide", "", "onShow", "onViewHidden", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Listener {

        /* renamed from: id.dana.familyaccount.view.invite.FamilyMembersPickerView$Listener$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void MyBillsEntityDataFactory() {
            }
        }

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FamilyMembersPickerView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FamilyMembersPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FamilyMembersPickerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilyMembersPickerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FamilyMembersPickerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewFamilyAccountMembersPickerSheetBinding inflateViewBinding() {
        ViewFamilyAccountMembersPickerSheetBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewFamilyAccountMembersPickerSheetBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        if (this.getAuthRequestContext && !getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.isClearImageViewRect((int) event.getRawX(), (int) event.getRawY())) {
            if (event.getAction() == 0) {
                View findFocus = findFocus();
                if (findFocus instanceof EditText) {
                    Rect rect = new Rect();
                    findFocus.getGlobalVisibleRect(rect);
                    if (rect.contains((int) event.getRawX(), (int) event.getRawY())) {
                        return false;
                    }
                    findFocus.clearFocus();
                    KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this);
                    return false;
                }
                return false;
            }
            return false;
        }
        return super.dispatchTouchEvent(event);
    }

    private final FamilyInviteMemberActivity PlaceComponentResult() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        Activity PlaceComponentResult = ContextExtKt.PlaceComponentResult(context);
        if (PlaceComponentResult != null) {
            return (FamilyInviteMemberActivity) PlaceComponentResult;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.familyaccount.view.invite.FamilyInviteMemberActivity");
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(List<FamilyMemberInfoModel> p0) {
        return p0 != null && p0.size() == 0;
    }

    private final boolean PlaceComponentResult(String p0) {
        Boolean bool;
        String str = this.PlaceComponentResult;
        if (str != null) {
            bool = Boolean.valueOf(str.length() > 0);
        } else {
            bool = null;
        }
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue() && Intrinsics.areEqual(NumberUtils.getIndoPhoneNumber(this.PlaceComponentResult), NumberUtils.getIndoPhoneNumber(p0));
    }

    public final void show() {
        BottomSheetBehavior<?> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    public final void hide() {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.clearKeyword();
        BottomSheetBehavior<?> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(5);
        }
        Listener listener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (listener != null) {
            listener.getAuthRequestContext();
        }
    }

    @JvmName(name = "isShow")
    public final boolean isShow() {
        BottomSheetBehavior<?> bottomSheetBehavior = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNull(bottomSheetBehavior);
        return 5 != bottomSheetBehavior.getState();
    }

    public final void configPeekHeight(final BaseActivity baseActivity) {
        Intrinsics.checkNotNullParameter(baseActivity, "");
        post(new Runnable() { // from class: id.dana.familyaccount.view.invite.FamilyMembersPickerView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FamilyMembersPickerView.$r8$lambda$iZ_Ptw6uudOGZ3F3S45v8G9RYsg(BaseActivity.this, this);
            }
        });
    }

    public final void setListener(Listener listener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = listener;
    }

    public final void onCancel() {
        hide();
    }

    public final void onFinished() {
        hide();
    }

    public final void addDisposable(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "");
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new CompositeDisposable();
        }
        Preconditions.getAuthRequestContext(disposable);
        Preconditions.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
        CompositeDisposable compositeDisposable = this.BuiltInFictitiousFunctionClassFactory;
        if (compositeDisposable != null) {
            compositeDisposable.getAuthRequestContext(disposable);
        }
    }

    public final void dispose() {
        CompositeDisposable compositeDisposable;
        CompositeDisposable compositeDisposable2 = this.BuiltInFictitiousFunctionClassFactory;
        if (compositeDisposable2 != null) {
            boolean z = false;
            if (compositeDisposable2 != null && !compositeDisposable2.isDisposed()) {
                z = true;
            }
            if (!z || (compositeDisposable = this.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            compositeDisposable.dispose();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dispose();
    }

    public final void cancelPicker() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.invite.FamilyMembersPickerView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyMembersPickerView.$r8$lambda$zAcfIjDhzDqeP4KJxgHSFis7bTs(FamilyMembersPickerView.this, view);
            }
        });
    }

    public final void openScanner(final Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.invite.FamilyMembersPickerView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FamilyMembersPickerView.$r8$lambda$n9R3FOOwc97MhVfzKRx3VpbREEw(Function0.this, view);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$iZ_Ptw6uudOGZ3F3S45v8G9RYsg(BaseActivity baseActivity, FamilyMembersPickerView familyMembersPickerView) {
        Intrinsics.checkNotNullParameter(baseActivity, "");
        Intrinsics.checkNotNullParameter(familyMembersPickerView, "");
        Display defaultDisplay = baseActivity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        BottomSheetBehavior<?> bottomSheetBehavior = familyMembersPickerView.MyBillsEntityDataFactory;
        if (bottomSheetBehavior == null || bottomSheetBehavior == null) {
            return;
        }
        bottomSheetBehavior.setPeekHeight(point.y);
    }

    public static /* synthetic */ void $r8$lambda$n9R3FOOwc97MhVfzKRx3VpbREEw(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    /* renamed from: $r8$lambda$rBTOQrI4HvuXnWgOPU1R-fYTUFQ  reason: not valid java name */
    public static /* synthetic */ void m2594$r8$lambda$rBTOQrI4HvuXnWgOPU1RfYTUFQ(FamilyMembersPickerView familyMembersPickerView, String str) {
        Intrinsics.checkNotNullParameter(familyMembersPickerView, "");
        familyMembersPickerView.getBinding().lookAheadTest.observeContactPagedList(str);
    }

    /* renamed from: $r8$lambda$rY2trPSYd2xxqhZPjH-jB0_GqsM  reason: not valid java name */
    public static /* synthetic */ void m2595$r8$lambda$rY2trPSYd2xxqhZPjHjB0_GqsM(FamilyMembersPickerView familyMembersPickerView, RecipientModel recipientModel) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(familyMembersPickerView, "");
        if (recipientModel != null) {
            String str = recipientModel.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(str, "");
            if (familyMembersPickerView.PlaceComponentResult(str)) {
                FamilyInviteMemberActivity PlaceComponentResult = familyMembersPickerView.PlaceComponentResult();
                if (PlaceComponentResult != null) {
                    PlaceComponentResult.showInvitationFailToast(familyMembersPickerView.getContext().getString(R.string.error_select_own_number));
                    return;
                }
                return;
            }
            FamilyInviteMemberActivity PlaceComponentResult2 = familyMembersPickerView.PlaceComponentResult();
            if (PlaceComponentResult2.getExistingMember() == null) {
                PlaceComponentResult2.initQuestionnaire(recipientModel);
                familyMembersPickerView.hide();
                return;
            }
            ArrayList<FamilyMemberInfoModel> existingMember = PlaceComponentResult2.getExistingMember();
            if (existingMember != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : existingMember) {
                    FamilyMemberInfoModel familyMemberInfoModel = (FamilyMemberInfoModel) obj;
                    Intrinsics.checkNotNullExpressionValue(familyMemberInfoModel, "");
                    if (KClassImpl$Data$declaredNonStaticMembers$2(familyMemberInfoModel, recipientModel)) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (!BuiltInFictitiousFunctionClassFactory(arrayList)) {
                PlaceComponentResult2.showInvitationFailToast(PlaceComponentResult2.getString(R.string.family_text_error_already_member));
                return;
            }
            PlaceComponentResult2.initQuestionnaire(recipientModel);
            familyMembersPickerView.hide();
        }
    }

    public static /* synthetic */ void $r8$lambda$zAcfIjDhzDqeP4KJxgHSFis7bTs(FamilyMembersPickerView familyMembersPickerView, View view) {
        Intrinsics.checkNotNullParameter(familyMembersPickerView, "");
        familyMembersPickerView.onCancel();
    }

    public static final /* synthetic */ void access$focusEtSearchContact(FamilyMembersPickerView familyMembersPickerView) {
        if (familyMembersPickerView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            familyMembersPickerView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.requestFocus();
            familyMembersPickerView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setFocusableInTouchMode(true);
            Context context = familyMembersPickerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(context);
            return;
        }
        familyMembersPickerView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.focusEtSearchContact();
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(FamilyMemberInfoModel p0, RecipientModel p1) {
        String str = p0.getAuthRequestContext.getErrorConfigVersion;
        String str2 = p1.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        return Intrinsics.areEqual(str, PhoneNumberUtilKt.replaceIndoPhonePrefixWithRegionDash(str2));
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        Disposable subscribe;
        FamilyMemberInfoModel familyMemberInfoModel;
        MemberInfoModel memberInfoModel;
        BottomSheetBehavior<?> from = BottomSheetBehavior.from(getBinding().MyBillsEntityDataFactory);
        from.setHideable(true);
        from.setState(5);
        from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.familyaccount.view.invite.FamilyMembersPickerView$initBottomSheet$1$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View p0, float p1) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View p0, int p1) {
                FamilyMembersPickerView.Listener listener;
                FamilyMembersPickerView.Listener listener2;
                FamilyMembersPickerView.Listener listener3;
                FamilyMembersPickerView.Listener listener4;
                Intrinsics.checkNotNullParameter(p0, "");
                listener = FamilyMembersPickerView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (listener != null) {
                    if (5 == p1) {
                        FamilyMembersPickerView.this.onFinished();
                        listener4 = FamilyMembersPickerView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (listener4 != null) {
                            listener4.MyBillsEntityDataFactory();
                        }
                    } else if (3 == p1) {
                        listener3 = FamilyMembersPickerView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (listener3 != null) {
                            listener3.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                    } else if (4 == p1) {
                        FamilyMembersPickerView.this.onFinished();
                        listener2 = FamilyMembersPickerView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (listener2 != null) {
                            listener2.getAuthRequestContext();
                        }
                    }
                }
            }
        });
        this.MyBillsEntityDataFactory = from;
        FamilyInviteMemberActivity PlaceComponentResult = PlaceComponentResult();
        if (PlaceComponentResult != null) {
            String organizerPhoneNumber = PlaceComponentResult.getOrganizerPhoneNumber();
            if (organizerPhoneNumber == null) {
                ArrayList<FamilyMemberInfoModel> existingMember = PlaceComponentResult.getExistingMember();
                organizerPhoneNumber = (existingMember == null || (familyMemberInfoModel = existingMember.get(0)) == null || (memberInfoModel = familyMemberInfoModel.getAuthRequestContext) == null) ? null : memberInfoModel.getErrorConfigVersion;
            }
            this.PlaceComponentResult = organizerPhoneNumber;
        }
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setSearchViewContentDescription(getContext().getString(R.string.txt_search_phone_number));
        ContactSelectorView contactSelectorView = getBinding().lookAheadTest;
        contactSelectorView.setContactHeaderColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(contactSelectorView.getContext(), R.color.f27072131100488));
        contactSelectorView.enableArrow();
        contactSelectorView.setListener(new ContactSelectorView.Listener() { // from class: id.dana.familyaccount.view.invite.FamilyMembersPickerView$initContactSelector$1$1
            @Override // id.dana.richview.contactselector.ContactSelectorView.Listener
            public final void PlaceComponentResult(boolean p0) {
            }

            @Override // id.dana.richview.contactselector.ContactSelectorView.Listener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                FamilyMembersPickerView.access$focusEtSearchContact(FamilyMembersPickerView.this);
            }
        });
        contactSelectorView.setRecipientListener(new BaseRecipientListener() { // from class: id.dana.familyaccount.view.invite.FamilyMembersPickerView$$ExternalSyntheticLambda4
            @Override // id.dana.sendmoney.view.BaseRecipientListener
            public final void onRecipientSelected(RecipientModel recipientModel) {
                FamilyMembersPickerView.m2595$r8$lambda$rY2trPSYd2xxqhZPjHjB0_GqsM(FamilyMembersPickerView.this, recipientModel);
            }
        });
        getBinding().lookAheadTest.initContactList();
        getBinding().lookAheadTest.checkPermission();
        KeyboardHelper.PlaceComponentResult(this, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.familyaccount.view.invite.FamilyMembersPickerView$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ViewFamilyAccountMembersPickerSheetBinding binding;
                ViewFamilyAccountMembersPickerSheetBinding binding2;
                FamilyMembersPickerView.this.getAuthRequestContext = true;
                binding = FamilyMembersPickerView.this.getBinding();
                binding.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                binding2 = FamilyMembersPickerView.this.getBinding();
                binding2.scheduleImpl.setVisibility(0);
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                ViewFamilyAccountMembersPickerSheetBinding binding;
                ViewFamilyAccountMembersPickerSheetBinding binding2;
                FamilyMembersPickerView.this.getAuthRequestContext = false;
                binding = FamilyMembersPickerView.this.getBinding();
                binding.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
                binding2 = FamilyMembersPickerView.this.getBinding();
                binding2.scheduleImpl.setVisibility(8);
            }
        });
        PublishSubject<String> keyword = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.getKeyword();
        if (keyword != null && (subscribe = keyword.subscribe(new Consumer() { // from class: id.dana.familyaccount.view.invite.FamilyMembersPickerView$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FamilyMembersPickerView.m2594$r8$lambda$rBTOQrI4HvuXnWgOPU1RfYTUFQ(FamilyMembersPickerView.this, (String) obj);
            }
        })) != null) {
            addDisposable(subscribe);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList();
    }
}
