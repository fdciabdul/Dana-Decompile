package id.dana.sendmoney.ui.groupsend.recipient.util;

import android.app.Activity;
import android.text.TextUtils;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.sendmoney.databinding.ActivityGroupRecipientBinding;
import id.dana.sendmoney.ui.groupsend.recipient.view.RecipientSourceType;
import id.dana.sendmoney.ui.groupsend.recipient.view.RecipientViewState;
import id.dana.sendmoney.ui.groupsend.recipient.view.SearchView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\u0006\u0010!\u001a\u00020\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u000bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u0005\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\"\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002@CX\u0086\n¢\u0006\f\n\u0004\b\u0011\u0010\u0012\"\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\n8\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8\u0007@CX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0011\u0010\u0016\"\u0004\b\t\u0010\u0018R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u001d8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0014\u0010\u0013\u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010 "}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/util/GroupRecipientSearchHelper;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "MyBillsEntityDataFactory", "", "(Ljava/lang/String;)Z", "Landroid/app/Activity;", "scheduleImpl", "Landroid/app/Activity;", "Lid/dana/sendmoney/databinding/ActivityGroupRecipientBinding;", "Lid/dana/sendmoney/databinding/ActivityGroupRecipientBinding;", "PlaceComponentResult", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "lookAheadTest", "(Z)V", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getErrorConfigVersion", "moveToNextValue", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientViewState;", "Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientViewState;", "p1", "p2", "<init>", "(Landroid/app/Activity;Lid/dana/sendmoney/databinding/ActivityGroupRecipientBinding;Lid/dana/sendmoney/ui/groupsend/recipient/view/RecipientViewState;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupRecipientSearchHelper {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Function0<Unit> getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Function1<? super Boolean, Unit> moveToNextValue;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ActivityGroupRecipientBinding PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean lookAheadTest;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final RecipientViewState NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Activity getAuthRequestContext;

    public GroupRecipientSearchHelper(Activity activity, ActivityGroupRecipientBinding activityGroupRecipientBinding, RecipientViewState recipientViewState) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(activityGroupRecipientBinding, "");
        Intrinsics.checkNotNullParameter(recipientViewState, "");
        this.getAuthRequestContext = activity;
        this.PlaceComponentResult = activityGroupRecipientBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recipientViewState;
        this.scheduleImpl = true;
        this.MyBillsEntityDataFactory = "";
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(boolean z) {
        if (this.BuiltInFictitiousFunctionClassFactory != z) {
            this.BuiltInFictitiousFunctionClassFactory = z;
            Function1<? super Boolean, Unit> function1 = this.moveToNextValue;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                function1 = null;
            }
            function1.invoke(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory));
            if (!this.BuiltInFictitiousFunctionClassFactory) {
                MyBillsEntityDataFactory();
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(String str) {
        this.MyBillsEntityDataFactory = str;
        if (!this.BuiltInFictitiousFunctionClassFactory && (!StringsKt.isBlank(str)) != false) {
            MyBillsEntityDataFactory(true);
        }
        if (this.BuiltInFictitiousFunctionClassFactory) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            this.lookAheadTest = false;
            if (Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2, RecipientSourceType.Contact.INSTANCE)) {
                MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
            }
        }
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private final void MyBillsEntityDataFactory(String p0) {
        String str = p0;
        if (!(str.length() > 0)) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (TextUtils.isDigitsOnly(str)) {
            getAuthRequestContext(p0);
        } else {
            Function0<Unit> function0 = null;
            if (StringsKt.startsWith$default(p0, "+", false, 2, (Object) null)) {
                getAuthRequestContext(p0);
                return;
            }
            this.scheduleImpl = false;
            Function0<Unit> function02 = this.getErrorConfigVersion;
            if (function02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                function0 = function02;
            }
            function0.invoke();
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.scheduleImpl) {
            return;
        }
        this.scheduleImpl = true;
        PlaceComponentResult("");
        Function0<Unit> function0 = this.getErrorConfigVersion;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            function0 = null;
        }
        function0.invoke();
    }

    private final void getAuthRequestContext(String p0) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(p0)) {
            this.scheduleImpl = false;
            Function0<Unit> function0 = this.getErrorConfigVersion;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                function0 = null;
            }
            function0.invoke();
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return p0.length() >= 3;
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GroupRecipientSearchHelper groupRecipientSearchHelper) {
        SearchView searchView = groupRecipientSearchHelper.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (groupRecipientSearchHelper.lookAheadTest) {
            searchView.setSearchViewInputType(3);
        } else {
            searchView.setSearchViewInputType(144);
        }
    }

    public final void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.lookAheadTest = false;
        SearchView searchView = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda2;
        searchView.clearEditText();
        searchView.clearEditTextFocus();
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
        KClassImpl$Data$declaredNonStaticMembers$2();
        MyBillsEntityDataFactory(false);
    }
}
