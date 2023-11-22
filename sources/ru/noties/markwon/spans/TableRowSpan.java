package ru.noties.markwon.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class TableRowSpan extends ReplacementSpan {
    public Invalidator BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean MyBillsEntityDataFactory;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final List<Cell> PlaceComponentResult;
    private final List<StaticLayout> getAuthRequestContext;
    private final Paint getErrorConfigVersion;
    private int initRecordTimeStamp;
    private final SpannableTheme lookAheadTest;
    private final TextPaint moveToNextValue;
    private final Rect scheduleImpl;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Alignment {
    }

    /* loaded from: classes6.dex */
    public interface Invalidator {
        void getAuthRequestContext();
    }

    /* loaded from: classes6.dex */
    public static class Cell {
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        final CharSequence PlaceComponentResult;

        public Cell(int i, CharSequence charSequence) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.PlaceComponentResult = charSequence;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Cell{alignment=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", text=");
            sb.append((Object) this.PlaceComponentResult);
            sb.append('}');
            return sb.toString();
        }
    }

    public TableRowSpan(SpannableTheme spannableTheme, List<Cell> list, boolean z, boolean z2) {
        Rect rect;
        rect = ObjectsPool.PlaceComponentResult;
        this.scheduleImpl = rect;
        this.getErrorConfigVersion = ObjectsPool.getAuthRequestContext();
        this.lookAheadTest = spannableTheme;
        this.PlaceComponentResult = list;
        this.getAuthRequestContext = new ArrayList(list.size());
        this.moveToNextValue = new TextPaint();
        this.MyBillsEntityDataFactory = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z2;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.getAuthRequestContext.size() > 0 && fontMetricsInt != null) {
            Iterator<StaticLayout> it = this.getAuthRequestContext.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int height = it.next().getHeight();
                if (height > i3) {
                    i3 = height;
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
            fontMetricsInt.ascent = -(i3 + (this.lookAheadTest.getAuthRequestContext() * 2));
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.initRecordTimeStamp;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Invalidator invalidator;
        int save;
        Layout.Alignment alignment;
        int i6 = 1;
        if (KClassImpl$Data$declaredNonStaticMembers$2(canvas.getWidth())) {
            this.initRecordTimeStamp = canvas.getWidth();
            this.moveToNextValue.set(paint);
            this.moveToNextValue.setFakeBoldText(this.MyBillsEntityDataFactory);
            int size = this.PlaceComponentResult.size();
            int authRequestContext = this.lookAheadTest.getAuthRequestContext();
            int i7 = this.initRecordTimeStamp / size;
            this.getAuthRequestContext.clear();
            int size2 = this.PlaceComponentResult.size();
            int i8 = 0;
            while (i8 < size2) {
                Cell cell = this.PlaceComponentResult.get(i8);
                CharSequence charSequence2 = cell.PlaceComponentResult;
                TextPaint textPaint = this.moveToNextValue;
                int i9 = cell.KClassImpl$Data$declaredNonStaticMembers$2;
                int i10 = i7 - (authRequestContext * 2);
                if (i9 == i6) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else if (i9 == 2) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                } else {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                }
                this.getAuthRequestContext.add(new StaticLayout(charSequence2, textPaint, i10, alignment, 1.0f, 0.0f, false));
                i8++;
                i6 = 1;
            }
        }
        int authRequestContext2 = this.lookAheadTest.getAuthRequestContext();
        int size3 = this.getAuthRequestContext.size();
        int i11 = this.initRecordTimeStamp / size3;
        int i12 = i5 - i3;
        int i13 = (i12 - this.KClassImpl$Data$declaredNonStaticMembers$2) / 4;
        if (this.MyBillsEntityDataFactory) {
            this.lookAheadTest.scheduleImpl(this.getErrorConfigVersion);
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            this.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0(this.getErrorConfigVersion);
        } else {
            this.lookAheadTest.moveToNextValue(this.getErrorConfigVersion);
        }
        if (this.getErrorConfigVersion.getColor() != 0) {
            save = canvas.save();
            try {
                this.scheduleImpl.set(0, 0, this.initRecordTimeStamp, i12);
                canvas.translate(f, i3 - i13);
                canvas.drawRect(this.scheduleImpl, this.getErrorConfigVersion);
            } finally {
            }
        }
        this.getErrorConfigVersion.set(paint);
        this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion);
        boolean z = this.lookAheadTest.lookAheadTest(paint) > 0;
        if (z) {
            this.scheduleImpl.set(0, 0, i11, i12);
        }
        int i14 = 0;
        for (int i15 = 0; i15 < size3; i15++) {
            StaticLayout staticLayout = this.getAuthRequestContext.get(i15);
            save = canvas.save();
            try {
                canvas.translate((i15 * i11) + f, i3 - i13);
                if (z) {
                    canvas.drawRect(this.scheduleImpl, this.getErrorConfigVersion);
                }
                canvas.translate(authRequestContext2, authRequestContext2 + i13);
                staticLayout.draw(canvas);
                if (staticLayout.getHeight() > i14) {
                    i14 = staticLayout.getHeight();
                }
                canvas.restoreToCount(save);
            } finally {
            }
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == i14 || (invalidator = this.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        invalidator.getAuthRequestContext();
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return this.initRecordTimeStamp != i;
    }
}
