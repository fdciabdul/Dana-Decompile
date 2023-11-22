package id.dana;

import android.content.Context;
import androidx.core.provider.FontRequest;
import androidx.emoji.text.EmojiCompat;
import androidx.emoji.text.FontRequestEmojiCompatConfig;
import androidx.startup.Initializer;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00010\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/EmojiSupportInitializer;", "Landroidx/startup/Initializer;", "Landroidx/emoji/text/EmojiCompat;", "", "Ljava/lang/Class;", "PlaceComponentResult", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EmojiSupportInitializer implements Initializer<EmojiCompat> {
    @Override // androidx.startup.Initializer
    public final /* synthetic */ EmojiCompat getAuthRequestContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        EmojiCompat MyBillsEntityDataFactory = EmojiCompat.MyBillsEntityDataFactory(new FontRequestEmojiCompatConfig(context, new FontRequest(context.getString(R.string.font_req_provider_authority), context.getString(R.string.font_req_provider_package), context.getString(R.string.font_req_query))).BuiltInFictitiousFunctionClassFactory(true).KClassImpl$Data$declaredNonStaticMembers$2(new EmojiCompat.InitCallback() { // from class: id.dana.EmojiSupportInitializer$create$emojiConfig$1
            @Override // androidx.emoji.text.EmojiCompat.InitCallback
            public final void MyBillsEntityDataFactory() {
                DanaLog.getAuthRequestContext("FontRequestEmojiCompatConfig", "onInitialized");
            }

            @Override // androidx.emoji.text.EmojiCompat.InitCallback
            public final void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
                DanaLog.BuiltInFictitiousFunctionClassFactory("FontRequestEmojiCompatConfig", "onFailed");
            }
        }));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> PlaceComponentResult() {
        return CollectionsKt.listOf(DanaLogInitializer.class);
    }
}
