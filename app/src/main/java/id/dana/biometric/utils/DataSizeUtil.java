package id.dana.biometric.utils;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/biometric/utils/DataSizeUtil;", "", "p0", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Object;)D", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DataSizeUtil {
    public static final DataSizeUtil INSTANCE = new DataSizeUtil();

    private DataSizeUtil() {
    }

    public static double BuiltInFictitiousFunctionClassFactory(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "");
        byte[] bytes = new Gson().toJson(obj).toString().getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        double length = bytes.length;
        Double.isNaN(length);
        double round = Math.round((length / 1024.0d) * 100.0d);
        Double.isNaN(round);
        return round / 100.0d;
    }
}
