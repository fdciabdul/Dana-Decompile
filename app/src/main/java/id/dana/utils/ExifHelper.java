package id.dana.utils;

import androidx.exifinterface.media.ExifInterface;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0006*\u00020\u00070\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/utils/ExifHelper;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "([B)I", "", "PlaceComponentResult", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ExifHelper {
    public static final ExifHelper INSTANCE = new ExifHelper();
    private static final String PlaceComponentResult = ExifHelper.class.getName();

    private ExifHelper() {
    }

    @JvmStatic
    public static final int BuiltInFictitiousFunctionClassFactory(byte[] p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(p0);
        try {
            int i = -1;
            try {
                switch (new ExifInterface(byteArrayInputStream).getAuthRequestContext("Orientation")) {
                    case 3:
                    case 4:
                        i = 180;
                        break;
                    case 5:
                    case 6:
                        i = 90;
                        break;
                    case 7:
                    case 8:
                        i = 270;
                        break;
                    default:
                        i = 0;
                        break;
                }
                String str = PlaceComponentResult;
                StringBuilder sb = new StringBuilder();
                sb.append("got orientation from EXIF. ");
                sb.append(i);
                DanaLog.getAuthRequestContext(str, sb.toString());
            } catch (IOException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, "could not get orientation from EXIF.", e);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(byteArrayInputStream, null);
            return i;
        } finally {
        }
    }
}
