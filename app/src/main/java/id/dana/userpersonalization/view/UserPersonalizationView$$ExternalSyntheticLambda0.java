package id.dana.userpersonalization.view;

import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public final /* synthetic */ class UserPersonalizationView$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Function1 KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ UserPersonalizationView getAuthRequestContext;

    public /* synthetic */ UserPersonalizationView$$ExternalSyntheticLambda0(UserPersonalizationView userPersonalizationView, Function1 function1) {
        this.getAuthRequestContext = userPersonalizationView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UserPersonalizationView.$r8$lambda$ig06l5pP40xKB0dA24vPBhVgYqo(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
