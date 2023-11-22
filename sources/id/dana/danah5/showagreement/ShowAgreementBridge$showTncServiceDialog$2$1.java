package id.dana.danah5.showagreement;

import android.app.Application;
import android.content.Intent;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.miniprogram.tnc.TncServiceDialogActivity;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "contentAgreements", "", BridgeDSL.INVOKE, "(Ljava/util/ArrayList;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShowAgreementBridge$showTncServiceDialog$2$1 extends Lambda implements Function1<ArrayList<String>, Unit> {
    final /* synthetic */ Application $$context;
    final /* synthetic */ ShowAgreementBridge this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowAgreementBridge$showTncServiceDialog$2$1(ShowAgreementBridge showAgreementBridge, Application application) {
        super(1);
        this.this$0 = showAgreementBridge;
        this.$$context = application;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
        invoke2(arrayList);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ArrayList<String> arrayList) {
        Map map;
        Intrinsics.checkNotNullParameter(arrayList, "");
        ThirdPartyServiceResponse thirdPartyServiceResponse = this.this$0.service;
        ThirdPartyServiceResponse thirdPartyServiceResponse2 = null;
        if (thirdPartyServiceResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            thirdPartyServiceResponse = null;
        }
        String icon = thirdPartyServiceResponse.getIcon();
        String str = icon == null ? "" : icon;
        ThirdPartyServiceResponse thirdPartyServiceResponse3 = this.this$0.service;
        if (thirdPartyServiceResponse3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            thirdPartyServiceResponse3 = null;
        }
        String name = thirdPartyServiceResponse3.getName();
        String str2 = name == null ? "" : name;
        map = this.this$0.agreementMap;
        String joinToString$default = CollectionsKt.joinToString$default(map.values(), null, null, null, 0, null, null, 63, null);
        ThirdPartyServiceResponse thirdPartyServiceResponse4 = this.this$0.service;
        if (thirdPartyServiceResponse4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            thirdPartyServiceResponse2 = thirdPartyServiceResponse4;
        }
        Intent putExtra = new Intent(this.$$context, TncServiceDialogActivity.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).putExtra("startParams", new TncServiceDialogActivity.StartParams(str, str2, joinToString$default, arrayList, thirdPartyServiceResponse2.getAction()));
        Intrinsics.checkNotNullExpressionValue(putExtra, "");
        this.$$context.startActivity(putExtra);
    }
}
