package id.dana.extension.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.LayerDrawable;
import android.widget.ProgressBar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import id.dana.utils.OSUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a!\u0010\u0002\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\b"}, d2 = {"Landroid/widget/ProgressBar;", "", "MyBillsEntityDataFactory", "(Landroid/widget/ProgressBar;)Z", "", "p0", "p1", "", "(Landroid/widget/ProgressBar;II)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProgressBarExtKt {
    public static final byte[] MyBillsEntityDataFactory = {Ascii.DC4, -68, -64, 70, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int PlaceComponentResult = 228;

    public static final void MyBillsEntityDataFactory(ProgressBar progressBar, int i, int i2) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$22;
        Intrinsics.checkNotNullParameter(progressBar, "");
        if (!OSUtil.scheduleImpl()) {
            LayerDrawable layerDrawable = (LayerDrawable) progressBar.getProgressDrawable().mutate();
            PlaceComponentResult(layerDrawable, 0).setColorFilter(BlendModeColorFilterCompat.MyBillsEntityDataFactory(i2, BlendModeCompat.SRC_IN));
            PlaceComponentResult(layerDrawable, 1).setColorFilter(BlendModeColorFilterCompat.MyBillsEntityDataFactory(i, BlendModeCompat.SRC_IN));
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r0.getResources(), i, progressBar.getContext().getTheme());
        progressBar.setProgressTintList(KClassImpl$Data$declaredNonStaticMembers$2);
        KClassImpl$Data$declaredNonStaticMembers$22 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r3.getResources(), i2, progressBar.getContext().getTheme());
        progressBar.setBackgroundTintList(KClassImpl$Data$declaredNonStaticMembers$22);
    }

    public static final boolean MyBillsEntityDataFactory(ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "");
        return progressBar.getProgress() == (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda1() ? progressBar.getMin() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0040 -> B:15:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.drawable.Drawable PlaceComponentResult(android.graphics.drawable.LayerDrawable r11, int r12) {
        /*
            byte[] r0 = id.dana.extension.view.ProgressBarExtKt.MyBillsEntityDataFactory
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 97
            r4 = 0
            r5 = 3
            if (r0 != 0) goto L14
            r5 = r2
            r6 = 3
            r7 = 3
            r8 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L47
        L14:
            r3 = r2
            r5 = 97
            r6 = 3
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1c:
            int r6 = r6 + 1
            int r8 = r7 + 1
            byte r9 = (byte) r5
            r3[r7] = r9
            if (r8 != r1) goto L40
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3b
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3b:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L40:
            r7 = r2[r6]
            r10 = r5
            r5 = r3
            r3 = r7
            r7 = r6
            r6 = r10
        L47:
            int r6 = r6 + r3
            int r3 = r6 + (-8)
            r6 = r7
            r7 = r8
            r10 = r5
            r5 = r3
            r3 = r10
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.extension.view.ProgressBarExtKt.PlaceComponentResult(android.graphics.drawable.LayerDrawable, int):android.graphics.drawable.Drawable");
    }
}
