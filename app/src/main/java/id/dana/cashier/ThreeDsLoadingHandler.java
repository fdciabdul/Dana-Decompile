package id.dana.cashier;

import android.os.CountDownTimer;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.cashier.ThreeDsLoadingHandler$countDownTimer$2;
import id.dana.richview.LogoProgressView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0006\u001a\u00020\tX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0003\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R$\u0010\n\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\"\u0004\b\u000e\u0010\u0015R$\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0014\"\u0004\b\b\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0011X\u0087\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0014"}, d2 = {"Lid/dana/cashier/ThreeDsLoadingHandler;", "", "", "PlaceComponentResult", "()V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getAuthRequestContext", "Landroidx/constraintlayout/widget/ConstraintLayout;", "MyBillsEntityDataFactory", "Landroid/os/CountDownTimer;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "Lid/dana/richview/LogoProgressView;", "Lid/dana/richview/LogoProgressView;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "", "p0", "scheduleImpl", "Z", "(Z)V", "getErrorConfigVersion", "p1", "p2", "<init>", "(Landroid/widget/FrameLayout;Lid/dana/richview/LogoProgressView;Landroidx/constraintlayout/widget/ConstraintLayout;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ThreeDsLoadingHandler {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Lazy getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final FrameLayout PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final LogoProgressView KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ConstraintLayout MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    public ThreeDsLoadingHandler(FrameLayout frameLayout, LogoProgressView logoProgressView, ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "");
        Intrinsics.checkNotNullParameter(logoProgressView, "");
        Intrinsics.checkNotNullParameter(constraintLayout, "");
        this.PlaceComponentResult = frameLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = logoProgressView;
        this.MyBillsEntityDataFactory = constraintLayout;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<ThreeDsLoadingHandler$countDownTimer$2.AnonymousClass1>() { // from class: id.dana.cashier.ThreeDsLoadingHandler$countDownTimer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.cashier.ThreeDsLoadingHandler$countDownTimer$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final ThreeDsLoadingHandler threeDsLoadingHandler = ThreeDsLoadingHandler.this;
                return new CountDownTimer() { // from class: id.dana.cashier.ThreeDsLoadingHandler$countDownTimer$2.1
                    @Override // android.os.CountDownTimer
                    public final void onTick(long p0) {
                    }

                    {
                        super(500L, 500L);
                    }

                    @Override // android.os.CountDownTimer
                    public final void onFinish() {
                        ThreeDsLoadingHandler threeDsLoadingHandler2 = ThreeDsLoadingHandler.this;
                        if (threeDsLoadingHandler2.getErrorConfigVersion) {
                            return;
                        }
                        threeDsLoadingHandler2.PlaceComponentResult.setVisibility(8);
                        threeDsLoadingHandler2.MyBillsEntityDataFactory(false);
                        threeDsLoadingHandler2.KClassImpl$Data$declaredNonStaticMembers$2(false);
                    }
                };
            }
        });
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(boolean z) {
        if (this.scheduleImpl == z) {
            return;
        }
        this.scheduleImpl = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(z ? 0 : 8);
        if (this.scheduleImpl) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.startRefresh();
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.stopRefresh();
        }
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        if (this.BuiltInFictitiousFunctionClassFactory == z) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = z;
        this.MyBillsEntityDataFactory.setVisibility(z ? 0 : 8);
    }

    public final void PlaceComponentResult() {
        if (this.getErrorConfigVersion) {
            return;
        }
        ((CountDownTimer) this.getAuthRequestContext.getValue()).cancel();
        ((CountDownTimer) this.getAuthRequestContext.getValue()).start();
    }
}
