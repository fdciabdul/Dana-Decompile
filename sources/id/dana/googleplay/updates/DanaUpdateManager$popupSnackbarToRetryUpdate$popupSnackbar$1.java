package id.dana.googleplay.updates;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.googleplay.updates.DanaUpdateManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaUpdateManager$popupSnackbarToRetryUpdate$popupSnackbar$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DanaUpdateManager.ManualCheckUpdateCallback $$callback;
    final /* synthetic */ DanaUpdateManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaUpdateManager$popupSnackbarToRetryUpdate$popupSnackbar$1(DanaUpdateManager danaUpdateManager, DanaUpdateManager.ManualCheckUpdateCallback manualCheckUpdateCallback) {
        super(0);
        this.this$0 = danaUpdateManager;
        this.$$callback = manualCheckUpdateCallback;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final DanaUpdateManager danaUpdateManager = this.this$0;
        final DanaUpdateManager.ManualCheckUpdateCallback manualCheckUpdateCallback = this.$$callback;
        danaUpdateManager.getAuthRequestContext(R.string.error_updating_app_snackbar, R.string.try_again, 0, new View.OnClickListener() { // from class: id.dana.googleplay.updates.DanaUpdateManager$popupSnackbarToRetryUpdate$popupSnackbar$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaUpdateManager$popupSnackbarToRetryUpdate$popupSnackbar$1.m2614invoke$lambda0(DanaUpdateManager.this, manualCheckUpdateCallback, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2614invoke$lambda0(DanaUpdateManager danaUpdateManager, DanaUpdateManager.ManualCheckUpdateCallback manualCheckUpdateCallback, View view) {
        Intrinsics.checkNotNullParameter(danaUpdateManager, "");
        Intrinsics.checkNotNullParameter(manualCheckUpdateCallback, "");
        danaUpdateManager.PlaceComponentResult(manualCheckUpdateCallback);
    }
}
