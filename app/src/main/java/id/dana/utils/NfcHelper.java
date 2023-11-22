package id.dana.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import id.dana.danah5.DanaH5;
import id.dana.electronicmoney.RxEmoneyBus;
import id.dana.util.MinApiUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017"}, d2 = {"Lid/dana/utils/NfcHelper;", "", "Landroid/app/Activity;", "p0", "Lio/reactivex/disposables/CompositeDisposable;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;Lio/reactivex/disposables/CompositeDisposable;)V", "", "Landroid/content/Intent;", "p2", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lio/reactivex/disposables/CompositeDisposable;Landroid/content/Intent;)V", "", "getAuthRequestContext", "Z", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Landroid/nfc/NfcAdapter;", "Landroid/nfc/NfcAdapter;", "Landroid/app/PendingIntent;", "Landroid/app/PendingIntent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NfcHelper {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    public NfcAdapter MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public PendingIntent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    public final void MyBillsEntityDataFactory(String p0, CompositeDisposable p1, Intent p2) {
        if (this.PlaceComponentResult) {
            if (Intrinsics.areEqual("android.nfc.action.TAG_DISCOVERED", p0) || Intrinsics.areEqual("android.nfc.action.TECH_DISCOVERED", p0) || Intrinsics.areEqual("android.nfc.action.NDEF_DISCOVERED", p0)) {
                if (p1 != null) {
                    p1.getAuthRequestContext(RxEmoneyBus.getAuthRequestContext().subscribe(new Consumer() { // from class: id.dana.utils.NfcHelper$$ExternalSyntheticLambda1
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            NfcHelper.MyBillsEntityDataFactory(NfcHelper.this, (String) obj);
                        }
                    }));
                }
                if (TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("url", this.KClassImpl$Data$declaredNonStaticMembers$2);
                bundle.putParcelable("android.nfc.extra.TAG", p2);
                DanaH5.startContainerActivity(bundle);
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Activity p0, CompositeDisposable p1) {
        Activity activity = p0;
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity);
        this.MyBillsEntityDataFactory = defaultAdapter;
        if (defaultAdapter != null) {
            this.BuiltInFictitiousFunctionClassFactory = PendingIntent.getActivity(activity, 0, new Intent(activity, getClass()).addFlags(536870912), MinApiUtils.PlaceComponentResult() ? 33554432 : 0);
            if (p1 != null) {
                p1.getAuthRequestContext(RxEmoneyBus.PlaceComponentResult().subscribe(new Consumer() { // from class: id.dana.utils.NfcHelper$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        NfcHelper.KClassImpl$Data$declaredNonStaticMembers$2(NfcHelper.this, ((Boolean) obj).booleanValue());
                    }
                }));
            }
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(NfcHelper nfcHelper, String str) {
        Intrinsics.checkNotNullParameter(nfcHelper, "");
        Intrinsics.checkNotNullParameter(str, "");
        nfcHelper.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NfcHelper nfcHelper, boolean z) {
        Intrinsics.checkNotNullParameter(nfcHelper, "");
        nfcHelper.PlaceComponentResult = z;
    }
}
