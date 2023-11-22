package id.dana.contract.deeplink.path;

import android.app.Activity;
import id.dana.cardbinding.activity.CardBindingActivity;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.danah5.DanaH5;
import id.dana.domain.core.usecase.NoParams;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\b\u001a\u00020\u00072\r\u0010\u0004\u001a\t\u0018\u00010\u0002¢\u0006\u0002\b\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureCardBinding;", "", "Landroid/app/Activity;", "Lorg/jetbrains/annotations/NotNull;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;Ljava/lang/String;)V", "Lid/dana/cardbinding/domain/interactor/GetIsCardBindingV2Enabled;", "getAuthRequestContext", "Lid/dana/cardbinding/domain/interactor/GetIsCardBindingV2Enabled;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/cardbinding/domain/interactor/GetIsCardBindingV2Enabled;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeatureCardBinding {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final GetIsCardBindingV2Enabled MyBillsEntityDataFactory;

    @Inject
    public FeatureCardBinding(GetIsCardBindingV2Enabled getIsCardBindingV2Enabled) {
        Intrinsics.checkNotNullParameter(getIsCardBindingV2Enabled, "");
        this.MyBillsEntityDataFactory = getIsCardBindingV2Enabled;
    }

    public final void BuiltInFictitiousFunctionClassFactory(final Activity p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.contract.deeplink.path.FeatureCardBinding$openCardBinding$1
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
                if (z) {
                    FeatureCardBinding.getAuthRequestContext(p0, p1);
                } else {
                    DanaH5.startContainerFullUrl("https://m.dana.id/m/portal/bankcardadd?isClosable=true");
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.deeplink.path.FeatureCardBinding$openCardBinding$2
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
                Intrinsics.checkNotNullParameter(th, "");
                DanaH5.startContainerFullUrl("https://m.dana.id/m/portal/bankcardadd?isClosable=true");
            }
        });
    }

    public static final /* synthetic */ void getAuthRequestContext(Activity activity, String str) {
        CardBindingActivity.Companion companion = CardBindingActivity.INSTANCE;
        activity.startActivity(CardBindingActivity.Companion.MyBillsEntityDataFactory(activity, str));
    }
}
