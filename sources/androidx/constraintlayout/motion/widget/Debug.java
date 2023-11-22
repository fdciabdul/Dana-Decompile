package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.view.View;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.domain.model.KycStatus;

/* loaded from: classes3.dex */
public class Debug {
    public static void PlaceComponentResult(String str, String str2) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(2, stackTrace.length - 1);
        String str3 = " ";
        for (int i = 1; i <= min; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            StringBuilder sb = new StringBuilder();
            sb.append(".(");
            sb.append(stackTrace[i].getFileName());
            sb.append(":");
            sb.append(stackTrace[i].getLineNumber());
            sb.append(") ");
            sb.append(stackTrace[i].getMethodName());
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(" ");
            str3 = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(str3);
            sb3.append(obj);
            sb3.append(str3);
            InstrumentInjector.log_v(str, sb3.toString());
        }
    }

    public static String MyBillsEntityDataFactory(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String MyBillsEntityDataFactory(Context context, int i) {
        if (i != -1) {
            try {
                return context.getResources().getResourceEntryName(i);
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("?");
                sb.append(i);
                return sb.toString();
            }
        }
        return "UNKNOWN";
    }

    public static String MyBillsEntityDataFactory() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sb = new StringBuilder();
        sb.append(".(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")");
        return sb.toString();
    }

    public static String PlaceComponentResult() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder sb = new StringBuilder();
        sb.append(".(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(") ");
        sb.append(stackTraceElement.getMethodName());
        sb.append("()");
        return sb.toString();
    }

    public static String PlaceComponentResult(MotionLayout motionLayout, int i) {
        return i == -1 ? KycStatus.UNDEFINED : motionLayout.getContext().getResources().getResourceEntryName(i);
    }
}
