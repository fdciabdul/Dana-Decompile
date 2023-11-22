package id.dana.sendmoney.ui.common;

import android.app.Activity;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.sendmoney.ui.groupsend.recipient.view.SearchView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0012\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0012\u0010\r\u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e@CX\u0086\n¢\u0006\f\n\u0004\b\u000f\u0010\u0010\"\u0004\b\r\u0010\u0011R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\u0012X\u0007¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0012X\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\u0015X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016"}, d2 = {"Lid/dana/sendmoney/ui/common/DefaultSearchHelper;", "", "Lkotlinx/coroutines/CoroutineScope;", "p0", "", "PlaceComponentResult", "(Lkotlinx/coroutines/CoroutineScope;)V", "Landroid/app/Activity;", "getAuthRequestContext", "Landroid/app/Activity;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "", "lookAheadTest", "Z", "(Z)V", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/ui/groupsend/recipient/view/SearchView;", "Lid/dana/sendmoney/ui/groupsend/recipient/view/SearchView;", "scheduleImpl", "p1", "p2", "p3", "<init>", "(Landroid/app/Activity;Lid/dana/sendmoney/ui/groupsend/recipient/view/SearchView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultSearchHelper {
    public final Function1<String, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Function1<Boolean, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final SearchView scheduleImpl;
    public final Activity getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultSearchHelper(Activity activity, SearchView searchView, Function1<? super String, Unit> function1, Function1<? super Boolean, Unit> function12) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(searchView, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        this.getAuthRequestContext = activity;
        this.scheduleImpl = searchView;
        this.BuiltInFictitiousFunctionClassFactory = function1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function12;
        this.MyBillsEntityDataFactory = "";
    }

    public /* synthetic */ DefaultSearchHelper(Activity activity, SearchView searchView, Function1 function1, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, searchView, function1, (i & 8) != 0 ? new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.common.DefaultSearchHelper.1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        } : anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(boolean z) {
        while (this.PlaceComponentResult != z) {
            this.PlaceComponentResult = z;
            this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(Boolean.valueOf(z));
            if (this.PlaceComponentResult) {
                this.scheduleImpl.focusOnEditText();
                return;
            }
            SearchView searchView = this.scheduleImpl;
            searchView.clearEditText();
            searchView.clearEditTextFocus();
            KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
            z = false;
        }
    }

    public final void PlaceComponentResult(CoroutineScope p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SearchView searchView = this.scheduleImpl;
        searchView.setOnSearchListener(p0, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.common.DefaultSearchHelper$initSearchView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                DefaultSearchHelper.BuiltInFictitiousFunctionClassFactory(DefaultSearchHelper.this, str);
            }
        });
        searchView.setOnFocusSearchListener(p0, new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.common.DefaultSearchHelper$initSearchView$1$2
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
                DefaultSearchHelper.this.MyBillsEntityDataFactory(z);
            }
        });
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DefaultSearchHelper defaultSearchHelper, String str) {
        defaultSearchHelper.MyBillsEntityDataFactory = str;
        if (!defaultSearchHelper.PlaceComponentResult && (!StringsKt.isBlank(str)) != false) {
            defaultSearchHelper.MyBillsEntityDataFactory(true);
        }
        defaultSearchHelper.BuiltInFictitiousFunctionClassFactory.invoke(defaultSearchHelper.MyBillsEntityDataFactory);
    }
}
