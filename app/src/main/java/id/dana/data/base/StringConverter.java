package id.dana.data.base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/base/StringConverter;", "", "", "", "list", "fromList", "(Ljava/util/List;)Ljava/lang/String;", "value", "fromString", "(Ljava/lang/String;)Ljava/util/List;", "Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "getGson", "()Lcom/google/gson/Gson;", "gson", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class StringConverter {

    /* renamed from: gson$delegate  reason: from kotlin metadata */
    private final Lazy gson = LazyKt.lazy(new Function0<Gson>() { // from class: id.dana.data.base.StringConverter$gson$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Gson invoke() {
            return new Gson();
        }
    });

    @JvmName(name = "getGson")
    private final Gson getGson() {
        return (Gson) this.gson.getValue();
    }

    public final List<String> fromString(String value) {
        Intrinsics.checkNotNullParameter(value, "");
        Object fromJson = getGson().fromJson(value, new TypeToken<List<? extends String>>() { // from class: id.dana.data.base.StringConverter$fromString$listType$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "");
        return (List) fromJson;
    }

    public final String fromList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String json = getGson().toJson(list);
        Intrinsics.checkNotNullExpressionValue(json, "");
        return json;
    }
}
