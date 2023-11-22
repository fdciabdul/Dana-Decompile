package id.dana.cardbinding.helper;

import android.content.Context;
import id.dana.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B/\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0005R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007"}, d2 = {"Lid/dana/cardbinding/helper/CardBindingErrorHelper;", "", "", "", "MyBillsEntityDataFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "", "getAuthRequestContext", "I", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "BuiltInFictitiousFunctionClassFactory", "lookAheadTest", "Landroid/content/Context;", "p0", "p1", "p2", "", "p3", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardBindingErrorHelper {
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final List<String> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final List<String> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public int PlaceComponentResult;

    public CardBindingErrorHelper(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "");
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"AE13112168000955", "AE15012168003032", "AE11112060030101", "AE11112060030102", "AE11112060030113", "AE11112060030114", "AE11112060030117", "AE13112168000964", "AE11112060030123", "AE11112060030122"});
        this.KClassImpl$Data$declaredNonStaticMembers$2 = listOf;
        List<String> listOf2 = CollectionsKt.listOf((Object[]) new String[]{"AE11112060030105", "AE15101858018110", "AE15112168003100", "AE15112168003027"});
        this.getAuthRequestContext = listOf2;
        this.lookAheadTest = "VIEW_TYPE_DIALOG";
        if (CollectionsKt.contains(listOf, str)) {
            this.BuiltInFictitiousFunctionClassFactory = context.getString(R.string.card_binding_save_card_dialog_failed_title);
            this.MyBillsEntityDataFactory = context.getString(R.string.card_binding_save_card_dialog_desc);
            this.PlaceComponentResult = R.drawable.ic_save_card_failed;
        } else if (CollectionsKt.contains(listOf2, str)) {
            this.BuiltInFictitiousFunctionClassFactory = context.getString(R.string.card_binding_save_card_dialog_server_error_title);
            this.MyBillsEntityDataFactory = context.getString(R.string.card_binding_save_card_dialog_desc);
            this.PlaceComponentResult = R.drawable.ic_save_card_server_failed;
        } else {
            String str3 = str2;
            this.BuiltInFictitiousFunctionClassFactory = str3 == null || str3.length() == 0 ? context.getString(R.string.something_went_wrong_try_again) : str2;
            this.MyBillsEntityDataFactory = context.getString(R.string.card_binding_save_card_dialog_desc);
            this.PlaceComponentResult = R.drawable.ic_save_card_server_failed;
            this.lookAheadTest = "VIEW_TYPE_TOAST";
        }
    }
}
