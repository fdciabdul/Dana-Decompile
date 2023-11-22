package id.dana.kyb.helper.service.strategy;

import android.content.Context;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.kyb.helper.service.listener.KybServiceListener;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.model.KybServiceRedirectValueModel;
import id.dana.utils.UrlUtil;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u000f"}, d2 = {"Lid/dana/kyb/helper/service/strategy/KybServiceAuthActionStrategy;", "Lid/dana/kyb/helper/service/strategy/KybServiceActionStrategy;", "Landroid/content/Context;", "p0", "Lid/dana/kyb/model/KybServiceModel;", "p1", "Lid/dana/kyb/helper/service/listener/KybServiceListener;", "p2", "", "PlaceComponentResult", "(Landroid/content/Context;Lid/dana/kyb/model/KybServiceModel;Lid/dana/kyb/helper/service/listener/KybServiceListener;)V", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/authcode/interactor/GetAuthCode;", "MyBillsEntityDataFactory", "Lid/dana/kyb/helper/service/listener/KybServiceListener;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/domain/authcode/interactor/GetAuthCode;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybServiceAuthActionStrategy implements KybServiceActionStrategy {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final GetAuthCode MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private KybServiceListener BuiltInFictitiousFunctionClassFactory;

    @Inject
    public KybServiceAuthActionStrategy(GetAuthCode getAuthCode) {
        Intrinsics.checkNotNullParameter(getAuthCode, "");
        this.MyBillsEntityDataFactory = getAuthCode;
    }

    @Override // id.dana.kyb.helper.service.strategy.KybServiceActionStrategy
    public final void PlaceComponentResult(Context p0, KybServiceModel p1, KybServiceListener p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.BuiltInFictitiousFunctionClassFactory = p2;
        final KybServiceRedirectValueModel kybServiceRedirectValueModel = p1.MyBillsEntityDataFactory;
        if (kybServiceRedirectValueModel != null) {
            GetAuthCode getAuthCode = this.MyBillsEntityDataFactory;
            GetAuthCode.Params.Companion companion = GetAuthCode.Params.INSTANCE;
            String str = kybServiceRedirectValueModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (str == null) {
                str = "";
            }
            String str2 = kybServiceRedirectValueModel.getErrorConfigVersion;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = kybServiceRedirectValueModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            getAuthCode.execute(companion.forGetAuthCode(str, str2, str3 != null ? str3 : "", StringsKt.equals$default(kybServiceRedirectValueModel.BuiltInFictitiousFunctionClassFactory, "1", false, 2, null)), new Function1<AuthCodeResult, Unit>() { // from class: id.dana.kyb.helper.service.strategy.KybServiceAuthActionStrategy$fetchAuthCode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(AuthCodeResult authCodeResult) {
                    invoke2(authCodeResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(AuthCodeResult authCodeResult) {
                    Intrinsics.checkNotNullParameter(authCodeResult, "");
                    KybServiceAuthActionStrategy kybServiceAuthActionStrategy = KybServiceAuthActionStrategy.this;
                    String str4 = kybServiceRedirectValueModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (str4 == null) {
                        str4 = "";
                    }
                    String authCode = authCodeResult.getAuthCode();
                    Intrinsics.checkNotNullExpressionValue(authCode, "");
                    List<String> list = kybServiceRedirectValueModel.PlaceComponentResult;
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                    KybServiceAuthActionStrategy.getAuthRequestContext(kybServiceAuthActionStrategy, str4, authCode, list);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.kyb.helper.service.strategy.KybServiceAuthActionStrategy$fetchAuthCode$2
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
                    KybServiceAuthActionStrategy.this.MyBillsEntityDataFactory.dispose();
                }
            }, new Function0<Unit>() { // from class: id.dana.kyb.helper.service.strategy.KybServiceAuthActionStrategy$fetchAuthCode$3
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
                    KybServiceAuthActionStrategy.this.MyBillsEntityDataFactory.dispose();
                }
            });
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(KybServiceAuthActionStrategy kybServiceAuthActionStrategy, String str, String str2, List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("authCode=");
        sb.append(str2);
        StringBuilder sb2 = new StringBuilder(UrlUtil.PlaceComponentResult(str, sb.toString()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Typography.amp);
            sb3.append(str3);
            sb2.append(sb3.toString());
        }
        String obj = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        KybServiceListener kybServiceListener = kybServiceAuthActionStrategy.BuiltInFictitiousFunctionClassFactory;
        if (kybServiceListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            kybServiceListener = null;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(obj);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        kybServiceListener.BuiltInFictitiousFunctionClassFactory(authRequestContext);
    }
}
