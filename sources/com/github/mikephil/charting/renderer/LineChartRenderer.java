package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BaseEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class LineChartRenderer extends LineRadarRenderer {
    protected LineDataProvider BuiltInFictitiousFunctionClassFactory;
    protected WeakReference<Bitmap> DatabaseTableConfigUtil;
    protected Path GetContactSyncConfig;
    protected Bitmap.Config KClassImpl$Data$declaredNonStaticMembers$2;
    protected Path MyBillsEntityDataFactory;
    private float[] NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected Canvas PlaceComponentResult;
    protected Path getAuthRequestContext;
    protected Paint initRecordTimeStamp;
    private HashMap<IDataSet, DataSetImageCache> isLayoutRequested;
    private float[] newProxyInstance;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult() {
    }

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Bitmap.Config.ARGB_8888;
        this.MyBillsEntityDataFactory = new Path();
        this.getAuthRequestContext = new Path();
        this.newProxyInstance = new float[4];
        this.GetContactSyncConfig = new Path();
        this.isLayoutRequested = new HashMap<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new float[2];
        this.BuiltInFictitiousFunctionClassFactory = lineDataProvider;
        Paint paint = new Paint(1);
        this.initRecordTimeStamp = paint;
        paint.setStyle(Paint.Style.FILL);
        this.initRecordTimeStamp.setColor(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v9, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r1v33, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r26v6, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r2v20, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r2v24, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r2v45, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r2v54, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r2v72, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r3v13, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r9v21, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void BuiltInFictitiousFunctionClassFactory(Canvas canvas) {
        Bitmap bitmap;
        Iterator it;
        PathEffect pathEffect;
        int i;
        Canvas canvas2;
        Canvas canvas3;
        char c;
        int i2;
        int initRecordTimeStamp = (int) this.NetworkUserEntityData$$ExternalSyntheticLambda7.initRecordTimeStamp();
        int NetworkUserEntityData$$ExternalSyntheticLambda1 = (int) this.NetworkUserEntityData$$ExternalSyntheticLambda7.NetworkUserEntityData$$ExternalSyntheticLambda1();
        WeakReference<Bitmap> weakReference = this.DatabaseTableConfigUtil;
        Bitmap bitmap2 = weakReference == null ? null : weakReference.get();
        if (bitmap2 == null || bitmap2.getWidth() != initRecordTimeStamp || bitmap2.getHeight() != NetworkUserEntityData$$ExternalSyntheticLambda1) {
            if (initRecordTimeStamp <= 0 || NetworkUserEntityData$$ExternalSyntheticLambda1 <= 0) {
                return;
            }
            bitmap2 = Bitmap.createBitmap(initRecordTimeStamp, NetworkUserEntityData$$ExternalSyntheticLambda1, this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.DatabaseTableConfigUtil = new WeakReference<>(bitmap2);
            this.PlaceComponentResult = new Canvas(bitmap2);
        }
        Bitmap bitmap3 = bitmap2;
        bitmap3.eraseColor(0);
        Iterator it2 = this.BuiltInFictitiousFunctionClassFactory.getLineData().BuiltInFictitiousFunctionClassFactory().iterator();
        while (it2.hasNext()) {
            ILineDataSet iLineDataSet = (ILineDataSet) it2.next();
            if (iLineDataSet.whenAvailable() && iLineDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() > 0) {
                this.lookAheadTest.setStrokeWidth(iLineDataSet.F());
                this.lookAheadTest.setPathEffect(iLineDataSet.lookAheadTest());
                int i3 = AnonymousClass1.MyBillsEntityDataFactory[iLineDataSet.SubSequence().ordinal()];
                if (i3 == 3) {
                    bitmap = bitmap3;
                    it = it2;
                    float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
                    Transformer transformer = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iLineDataSet.scheduleImpl());
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, iLineDataSet);
                    float BuiltInFictitiousFunctionClassFactory = iLineDataSet.BuiltInFictitiousFunctionClassFactory();
                    this.MyBillsEntityDataFactory.reset();
                    if (this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
                        int i4 = this.getErrorConfigVersion.PlaceComponentResult + 1;
                        int i5 = this.getErrorConfigVersion.PlaceComponentResult;
                        int i6 = this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2;
                        ?? errorConfigVersion = iLineDataSet.getErrorConfigVersion(Math.max(i4 - 2, 0));
                        ?? errorConfigVersion2 = iLineDataSet.getErrorConfigVersion(Math.max(i4 - 1, 0));
                        int i7 = -1;
                        if (errorConfigVersion2 != 0) {
                            this.MyBillsEntityDataFactory.moveTo(errorConfigVersion2.MyBillsEntityDataFactory(), errorConfigVersion2.getAuthRequestContext() * MyBillsEntityDataFactory);
                            int i8 = this.getErrorConfigVersion.PlaceComponentResult + 1;
                            Entry entry = errorConfigVersion;
                            Entry entry2 = errorConfigVersion2;
                            Entry entry3 = errorConfigVersion2;
                            while (true) {
                                Entry entry4 = entry3;
                                if (i8 > this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 + this.getErrorConfigVersion.PlaceComponentResult) {
                                    break;
                                }
                                if (i7 != i8) {
                                    entry4 = iLineDataSet.getErrorConfigVersion(i8);
                                }
                                int i9 = i8 + 1;
                                if (i9 < iLineDataSet.BottomSheetCardBindingView$watcherCardNumberView$1()) {
                                    i8 = i9;
                                }
                                ?? errorConfigVersion3 = iLineDataSet.getErrorConfigVersion(i8);
                                this.MyBillsEntityDataFactory.cubicTo(entry2.MyBillsEntityDataFactory() + ((entry4.MyBillsEntityDataFactory() - entry.MyBillsEntityDataFactory()) * BuiltInFictitiousFunctionClassFactory), (entry2.getAuthRequestContext() + ((entry4.getAuthRequestContext() - entry.getAuthRequestContext()) * BuiltInFictitiousFunctionClassFactory)) * MyBillsEntityDataFactory, entry4.MyBillsEntityDataFactory() - ((errorConfigVersion3.MyBillsEntityDataFactory() - entry2.MyBillsEntityDataFactory()) * BuiltInFictitiousFunctionClassFactory), (entry4.getAuthRequestContext() - ((errorConfigVersion3.getAuthRequestContext() - entry2.getAuthRequestContext()) * BuiltInFictitiousFunctionClassFactory)) * MyBillsEntityDataFactory, entry4.MyBillsEntityDataFactory(), entry4.getAuthRequestContext() * MyBillsEntityDataFactory);
                                entry = entry2;
                                entry2 = entry4;
                                entry3 = errorConfigVersion3;
                                int i10 = i8;
                                i8 = i9;
                                i7 = i10;
                            }
                        } else {
                            pathEffect = null;
                        }
                    }
                    if (iLineDataSet.AppCompatEmojiTextHelper()) {
                        this.getAuthRequestContext.reset();
                        this.getAuthRequestContext.addPath(this.MyBillsEntityDataFactory);
                        getAuthRequestContext(this.PlaceComponentResult, iLineDataSet, this.getAuthRequestContext, transformer, this.getErrorConfigVersion);
                    }
                    this.lookAheadTest.setColor(iLineDataSet.moveToNextValue());
                    this.lookAheadTest.setStyle(Paint.Style.STROKE);
                    transformer.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
                    this.PlaceComponentResult.drawPath(this.MyBillsEntityDataFactory, this.lookAheadTest);
                    pathEffect = null;
                    this.lookAheadTest.setPathEffect(null);
                } else if (i3 != 4) {
                    int BottomSheetCardBindingView$watcherCardNumberView$1 = iLineDataSet.BottomSheetCardBindingView$watcherCardNumberView$1();
                    boolean z = iLineDataSet.SubSequence() == LineDataSet.Mode.STEPPED;
                    int i11 = z ? 4 : 2;
                    Transformer transformer2 = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iLineDataSet.scheduleImpl());
                    float MyBillsEntityDataFactory2 = this.scheduleImpl.MyBillsEntityDataFactory();
                    this.lookAheadTest.setStyle(Paint.Style.STROKE);
                    Canvas canvas4 = iLineDataSet.A() ? this.PlaceComponentResult : canvas;
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, iLineDataSet);
                    if (!iLineDataSet.AppCompatEmojiTextHelper() || BottomSheetCardBindingView$watcherCardNumberView$1 <= 0) {
                        i = BottomSheetCardBindingView$watcherCardNumberView$1;
                        canvas2 = canvas4;
                        bitmap = bitmap3;
                        it = it2;
                    } else {
                        BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.getErrorConfigVersion;
                        Path path = this.GetContactSyncConfig;
                        int i12 = xBounds.PlaceComponentResult;
                        int i13 = xBounds.KClassImpl$Data$declaredNonStaticMembers$2 + xBounds.PlaceComponentResult;
                        int i14 = 0;
                        while (true) {
                            int i15 = (i14 * 128) + i12;
                            int i16 = i12;
                            int i17 = i15 + 128;
                            if (i17 > i13) {
                                i17 = i13;
                            }
                            if (i15 <= i17) {
                                i2 = i13;
                                it = it2;
                                float PlaceComponentResult = iLineDataSet.getErrorConfigVersion().PlaceComponentResult(iLineDataSet, this.BuiltInFictitiousFunctionClassFactory);
                                float MyBillsEntityDataFactory3 = this.scheduleImpl.MyBillsEntityDataFactory();
                                bitmap = bitmap3;
                                i = BottomSheetCardBindingView$watcherCardNumberView$1;
                                boolean z2 = iLineDataSet.SubSequence() == LineDataSet.Mode.STEPPED;
                                path.reset();
                                ?? errorConfigVersion4 = iLineDataSet.getErrorConfigVersion(i15);
                                canvas2 = canvas4;
                                path.moveTo(errorConfigVersion4.MyBillsEntityDataFactory(), PlaceComponentResult);
                                path.lineTo(errorConfigVersion4.MyBillsEntityDataFactory(), errorConfigVersion4.getAuthRequestContext() * MyBillsEntityDataFactory3);
                                int i18 = i15 + 1;
                                BaseEntry baseEntry = errorConfigVersion4;
                                Entry entry5 = null;
                                while (i18 <= i17) {
                                    ?? errorConfigVersion5 = iLineDataSet.getErrorConfigVersion(i18);
                                    boolean z3 = z2;
                                    if (z2) {
                                        path.lineTo(errorConfigVersion5.MyBillsEntityDataFactory(), baseEntry.getAuthRequestContext() * MyBillsEntityDataFactory3);
                                    }
                                    path.lineTo(errorConfigVersion5.MyBillsEntityDataFactory(), errorConfigVersion5.getAuthRequestContext() * MyBillsEntityDataFactory3);
                                    i18++;
                                    baseEntry = errorConfigVersion5;
                                    z2 = z3;
                                    entry5 = errorConfigVersion5;
                                }
                                if (entry5 != null) {
                                    path.lineTo(entry5.MyBillsEntityDataFactory(), PlaceComponentResult);
                                }
                                path.close();
                                transformer2.KClassImpl$Data$declaredNonStaticMembers$2(path);
                                Drawable I = iLineDataSet.I();
                                if (I != null) {
                                    BuiltInFictitiousFunctionClassFactory(canvas, path, I);
                                } else {
                                    MyBillsEntityDataFactory(canvas, path, iLineDataSet.VerifyPinStateManager$executeRiskChallenge$2$2(), iLineDataSet.E());
                                }
                            } else {
                                i = BottomSheetCardBindingView$watcherCardNumberView$1;
                                canvas2 = canvas4;
                                bitmap = bitmap3;
                                i2 = i13;
                                it = it2;
                            }
                            i14++;
                            if (i15 > i17) {
                                break;
                            }
                            i12 = i16;
                            i13 = i2;
                            it2 = it;
                            bitmap3 = bitmap;
                            BottomSheetCardBindingView$watcherCardNumberView$1 = i;
                            canvas4 = canvas2;
                        }
                    }
                    if (iLineDataSet.NetworkUserEntityData$$ExternalSyntheticLambda2().size() > 1) {
                        int i19 = i11 * 2;
                        if (this.newProxyInstance.length <= i19) {
                            this.newProxyInstance = new float[i11 * 4];
                        }
                        int i20 = this.getErrorConfigVersion.PlaceComponentResult;
                        while (i20 <= this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 + this.getErrorConfigVersion.PlaceComponentResult) {
                            ?? errorConfigVersion6 = iLineDataSet.getErrorConfigVersion(i20);
                            if (errorConfigVersion6 != 0) {
                                this.newProxyInstance[0] = errorConfigVersion6.MyBillsEntityDataFactory();
                                this.newProxyInstance[1] = errorConfigVersion6.getAuthRequestContext() * MyBillsEntityDataFactory2;
                                if (i20 < this.getErrorConfigVersion.getAuthRequestContext) {
                                    ?? errorConfigVersion7 = iLineDataSet.getErrorConfigVersion(i20 + 1);
                                    if (errorConfigVersion7 == 0) {
                                        break;
                                    }
                                    if (z) {
                                        this.newProxyInstance[2] = errorConfigVersion7.MyBillsEntityDataFactory();
                                        float[] fArr = this.newProxyInstance;
                                        float f = fArr[1];
                                        fArr[3] = f;
                                        fArr[4] = fArr[2];
                                        fArr[5] = f;
                                        fArr[6] = errorConfigVersion7.MyBillsEntityDataFactory();
                                        this.newProxyInstance[7] = errorConfigVersion7.getAuthRequestContext() * MyBillsEntityDataFactory2;
                                    } else {
                                        this.newProxyInstance[2] = errorConfigVersion7.MyBillsEntityDataFactory();
                                        this.newProxyInstance[3] = errorConfigVersion7.getAuthRequestContext() * MyBillsEntityDataFactory2;
                                    }
                                    c = 0;
                                } else {
                                    float[] fArr2 = this.newProxyInstance;
                                    c = 0;
                                    fArr2[2] = fArr2[0];
                                    fArr2[3] = fArr2[1];
                                }
                                transformer2.PlaceComponentResult(this.newProxyInstance);
                                if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(this.newProxyInstance[c])) {
                                    break;
                                } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(this.newProxyInstance[2])) {
                                    if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(this.newProxyInstance[1]) && !this.NetworkUserEntityData$$ExternalSyntheticLambda7.BuiltInFictitiousFunctionClassFactory(this.newProxyInstance[3])) {
                                        canvas3 = canvas2;
                                        i20++;
                                        canvas2 = canvas3;
                                    }
                                    this.lookAheadTest.setColor(iLineDataSet.PlaceComponentResult(i20));
                                    canvas3 = canvas2;
                                    canvas3.drawLines(this.newProxyInstance, 0, i19, this.lookAheadTest);
                                    i20++;
                                    canvas2 = canvas3;
                                }
                            }
                            canvas3 = canvas2;
                            i20++;
                            canvas2 = canvas3;
                        }
                    } else {
                        Canvas canvas5 = canvas2;
                        int i21 = i * i11;
                        if (this.newProxyInstance.length < Math.max(i21, i11) * 2) {
                            this.newProxyInstance = new float[Math.max(i21, i11) * 4];
                        }
                        if (iLineDataSet.getErrorConfigVersion(this.getErrorConfigVersion.PlaceComponentResult) != null) {
                            int i22 = this.getErrorConfigVersion.PlaceComponentResult;
                            int i23 = 0;
                            while (i22 <= this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 + this.getErrorConfigVersion.PlaceComponentResult) {
                                ?? errorConfigVersion8 = iLineDataSet.getErrorConfigVersion(i22 == 0 ? 0 : i22 - 1);
                                ?? errorConfigVersion9 = iLineDataSet.getErrorConfigVersion(i22);
                                if (errorConfigVersion8 != 0 && errorConfigVersion9 != 0) {
                                    int i24 = i23 + 1;
                                    this.newProxyInstance[i23] = errorConfigVersion8.MyBillsEntityDataFactory();
                                    int i25 = i24 + 1;
                                    this.newProxyInstance[i24] = errorConfigVersion8.getAuthRequestContext() * MyBillsEntityDataFactory2;
                                    if (z) {
                                        int i26 = i25 + 1;
                                        this.newProxyInstance[i25] = errorConfigVersion9.MyBillsEntityDataFactory();
                                        int i27 = i26 + 1;
                                        this.newProxyInstance[i26] = errorConfigVersion8.getAuthRequestContext() * MyBillsEntityDataFactory2;
                                        int i28 = i27 + 1;
                                        this.newProxyInstance[i27] = errorConfigVersion9.MyBillsEntityDataFactory();
                                        i25 = i28 + 1;
                                        this.newProxyInstance[i28] = errorConfigVersion8.getAuthRequestContext() * MyBillsEntityDataFactory2;
                                    }
                                    int i29 = i25 + 1;
                                    this.newProxyInstance[i25] = errorConfigVersion9.MyBillsEntityDataFactory();
                                    this.newProxyInstance[i29] = errorConfigVersion9.getAuthRequestContext() * MyBillsEntityDataFactory2;
                                    i23 = i29 + 1;
                                }
                                i22++;
                            }
                            if (i23 > 0) {
                                transformer2.PlaceComponentResult(this.newProxyInstance);
                                int max = Math.max((this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 + 1) * i11, i11);
                                this.lookAheadTest.setColor(iLineDataSet.moveToNextValue());
                                canvas5.drawLines(this.newProxyInstance, 0, max * 2, this.lookAheadTest);
                            }
                        }
                    }
                    pathEffect = null;
                    this.lookAheadTest.setPathEffect(null);
                } else {
                    bitmap = bitmap3;
                    it = it2;
                    float MyBillsEntityDataFactory4 = this.scheduleImpl.MyBillsEntityDataFactory();
                    Transformer transformer3 = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iLineDataSet.scheduleImpl());
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, iLineDataSet);
                    this.MyBillsEntityDataFactory.reset();
                    if (this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
                        ?? errorConfigVersion10 = iLineDataSet.getErrorConfigVersion(this.getErrorConfigVersion.PlaceComponentResult);
                        this.MyBillsEntityDataFactory.moveTo(errorConfigVersion10.MyBillsEntityDataFactory(), errorConfigVersion10.getAuthRequestContext() * MyBillsEntityDataFactory4);
                        int i30 = this.getErrorConfigVersion.PlaceComponentResult + 1;
                        Entry entry6 = errorConfigVersion10;
                        while (i30 <= this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 + this.getErrorConfigVersion.PlaceComponentResult) {
                            ?? errorConfigVersion11 = iLineDataSet.getErrorConfigVersion(i30);
                            float MyBillsEntityDataFactory5 = entry6.MyBillsEntityDataFactory() + ((errorConfigVersion11.MyBillsEntityDataFactory() - entry6.MyBillsEntityDataFactory()) / 2.0f);
                            this.MyBillsEntityDataFactory.cubicTo(MyBillsEntityDataFactory5, entry6.getAuthRequestContext() * MyBillsEntityDataFactory4, MyBillsEntityDataFactory5, errorConfigVersion11.getAuthRequestContext() * MyBillsEntityDataFactory4, errorConfigVersion11.MyBillsEntityDataFactory(), errorConfigVersion11.getAuthRequestContext() * MyBillsEntityDataFactory4);
                            i30++;
                            entry6 = errorConfigVersion11;
                        }
                    }
                    if (iLineDataSet.AppCompatEmojiTextHelper()) {
                        this.getAuthRequestContext.reset();
                        this.getAuthRequestContext.addPath(this.MyBillsEntityDataFactory);
                        getAuthRequestContext(this.PlaceComponentResult, iLineDataSet, this.getAuthRequestContext, transformer3, this.getErrorConfigVersion);
                    }
                    this.lookAheadTest.setColor(iLineDataSet.moveToNextValue());
                    this.lookAheadTest.setStyle(Paint.Style.STROKE);
                    transformer3.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
                    this.PlaceComponentResult.drawPath(this.MyBillsEntityDataFactory, this.lookAheadTest);
                    pathEffect = null;
                    this.lookAheadTest.setPathEffect(null);
                }
                this.lookAheadTest.setPathEffect(pathEffect);
                it2 = it;
                bitmap3 = bitmap;
            }
        }
        canvas.drawBitmap(bitmap3, 0.0f, 0.0f, this.lookAheadTest);
    }

    /* renamed from: com.github.mikephil.charting.renderer.LineChartRenderer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[LineDataSet.Mode.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[LineDataSet.Mode.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[LineDataSet.Mode.STEPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[LineDataSet.Mode.CUBIC_BEZIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[LineDataSet.Mode.HORIZONTAL_BEZIER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.github.mikephil.charting.data.Entry] */
    private void getAuthRequestContext(Canvas canvas, ILineDataSet iLineDataSet, Path path, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        float PlaceComponentResult = iLineDataSet.getErrorConfigVersion().PlaceComponentResult(iLineDataSet, this.BuiltInFictitiousFunctionClassFactory);
        path.lineTo(iLineDataSet.getErrorConfigVersion(xBounds.PlaceComponentResult + xBounds.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(), PlaceComponentResult);
        path.lineTo(iLineDataSet.getErrorConfigVersion(xBounds.PlaceComponentResult).MyBillsEntityDataFactory(), PlaceComponentResult);
        path.close();
        transformer.KClassImpl$Data$declaredNonStaticMembers$2(path);
        Drawable I = iLineDataSet.I();
        if (I != null) {
            BuiltInFictitiousFunctionClassFactory(canvas, path, I);
        } else {
            MyBillsEntityDataFactory(canvas, path, iLineDataSet.VerifyPinStateManager$executeRiskChallenge$2$2(), iLineDataSet.E());
        }
    }

    /* JADX WARN: Type inference failed for: r13v3, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void PlaceComponentResult(Canvas canvas) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory)) {
            List<T> BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.getLineData().BuiltInFictitiousFunctionClassFactory();
            for (int i = 0; i < BuiltInFictitiousFunctionClassFactory.size(); i++) {
                ILineDataSet iLineDataSet = (ILineDataSet) BuiltInFictitiousFunctionClassFactory.get(i);
                if (BuiltInFictitiousFunctionClassFactory(iLineDataSet) && iLineDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() > 0) {
                    PlaceComponentResult(iLineDataSet);
                    Transformer transformer = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iLineDataSet.scheduleImpl());
                    int MyBillsEntityDataFactory = (int) (iLineDataSet.MyBillsEntityDataFactory() * 1.75f);
                    if (!iLineDataSet.getValueOfTouchPositionAbsolute()) {
                        MyBillsEntityDataFactory /= 2;
                    }
                    int i2 = MyBillsEntityDataFactory;
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, iLineDataSet);
                    float[] KClassImpl$Data$declaredNonStaticMembers$2 = transformer.KClassImpl$Data$declaredNonStaticMembers$2(iLineDataSet, this.scheduleImpl.PlaceComponentResult(), this.scheduleImpl.MyBillsEntityDataFactory(), this.getErrorConfigVersion.PlaceComponentResult, this.getErrorConfigVersion.getAuthRequestContext);
                    ValueFormatter NetworkUserEntityData$$ExternalSyntheticLambda7 = iLineDataSet.NetworkUserEntityData$$ExternalSyntheticLambda7();
                    MPPointF authRequestContext = MPPointF.getAuthRequestContext(iLineDataSet.PrepareContext());
                    authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = Utils.PlaceComponentResult(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
                    authRequestContext.PlaceComponentResult = Utils.PlaceComponentResult(authRequestContext.PlaceComponentResult);
                    for (int i3 = 0; i3 < KClassImpl$Data$declaredNonStaticMembers$2.length; i3 += 2) {
                        float f = KClassImpl$Data$declaredNonStaticMembers$2[i3];
                        float f2 = KClassImpl$Data$declaredNonStaticMembers$2[i3 + 1];
                        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(f)) {
                            break;
                        }
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(f) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion(f2)) {
                            int i4 = i3 / 2;
                            ?? errorConfigVersion = iLineDataSet.getErrorConfigVersion(this.getErrorConfigVersion.PlaceComponentResult + i4);
                            if (iLineDataSet.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                                this.NetworkUserEntityData$$ExternalSyntheticLambda2.setColor(iLineDataSet.getAuthRequestContext(i4));
                                canvas.drawText(NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(errorConfigVersion.getAuthRequestContext()), f, f2 - i2, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                            }
                            if (errorConfigVersion.lookAheadTest != null && iLineDataSet.FragmentBottomSheetPaymentSettingBinding()) {
                                Drawable drawable = errorConfigVersion.lookAheadTest;
                                Utils.BuiltInFictitiousFunctionClassFactory(canvas, drawable, (int) (f + authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2), (int) (f2 + authRequestContext.PlaceComponentResult), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                            }
                        }
                    }
                    MPPointF.BuiltInFictitiousFunctionClassFactory(authRequestContext);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void MyBillsEntityDataFactory(Canvas canvas, Highlight[] highlightArr) {
        LineData lineData = this.BuiltInFictitiousFunctionClassFactory.getLineData();
        for (Highlight highlight : highlightArr) {
            ILineDataSet iLineDataSet = (ILineDataSet) lineData.MyBillsEntityDataFactory(highlight.MyBillsEntityDataFactory);
            if (iLineDataSet != null && iLineDataSet.NetworkUserEntityData$$ExternalSyntheticLambda5()) {
                ?? authRequestContext = iLineDataSet.getAuthRequestContext(highlight.moveToNextValue, highlight.lookAheadTest);
                if (BuiltInFictitiousFunctionClassFactory(authRequestContext, iLineDataSet)) {
                    MPPointD BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iLineDataSet.scheduleImpl()).BuiltInFictitiousFunctionClassFactory(authRequestContext.MyBillsEntityDataFactory(), authRequestContext.getAuthRequestContext() * this.scheduleImpl.MyBillsEntityDataFactory());
                    float f = (float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    float f2 = (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                    highlight.PlaceComponentResult = f;
                    highlight.BuiltInFictitiousFunctionClassFactory = f2;
                    MyBillsEntityDataFactory(canvas, (float) BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (float) BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, iLineDataSet);
                }
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Canvas canvas = this.PlaceComponentResult;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.PlaceComponentResult = null;
        }
        WeakReference<Bitmap> weakReference = this.DatabaseTableConfigUtil;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.DatabaseTableConfigUtil.clear();
            this.DatabaseTableConfigUtil = null;
        }
    }

    /* loaded from: classes3.dex */
    class DataSetImageCache {
        private Path BuiltInFictitiousFunctionClassFactory;
        Bitmap[] MyBillsEntityDataFactory;

        private DataSetImageCache() {
            this.BuiltInFictitiousFunctionClassFactory = new Path();
        }

        /* synthetic */ DataSetImageCache(LineChartRenderer lineChartRenderer, byte b) {
            this();
        }

        protected final boolean KClassImpl$Data$declaredNonStaticMembers$2(ILineDataSet iLineDataSet) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = iLineDataSet.KClassImpl$Data$declaredNonStaticMembers$2();
            Bitmap[] bitmapArr = this.MyBillsEntityDataFactory;
            if (bitmapArr == null) {
                this.MyBillsEntityDataFactory = new Bitmap[KClassImpl$Data$declaredNonStaticMembers$2];
            } else if (bitmapArr.length == KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            } else {
                this.MyBillsEntityDataFactory = new Bitmap[KClassImpl$Data$declaredNonStaticMembers$2];
            }
            return true;
        }

        protected final void KClassImpl$Data$declaredNonStaticMembers$2(ILineDataSet iLineDataSet, boolean z, boolean z2) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = iLineDataSet.KClassImpl$Data$declaredNonStaticMembers$2();
            float MyBillsEntityDataFactory = iLineDataSet.MyBillsEntityDataFactory();
            float authRequestContext = iLineDataSet.getAuthRequestContext();
            for (int i = 0; i < KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                Bitmap.Config config = Bitmap.Config.ARGB_4444;
                double d = MyBillsEntityDataFactory;
                Double.isNaN(d);
                int i2 = (int) (d * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i2, i2, config);
                Canvas canvas = new Canvas(createBitmap);
                this.MyBillsEntityDataFactory[i] = createBitmap;
                LineChartRenderer.this.lookAheadTest.setColor(iLineDataSet.moveToNextValue(i));
                if (z2) {
                    this.BuiltInFictitiousFunctionClassFactory.reset();
                    this.BuiltInFictitiousFunctionClassFactory.addCircle(MyBillsEntityDataFactory, MyBillsEntityDataFactory, MyBillsEntityDataFactory, Path.Direction.CW);
                    this.BuiltInFictitiousFunctionClassFactory.addCircle(MyBillsEntityDataFactory, MyBillsEntityDataFactory, authRequestContext, Path.Direction.CCW);
                    canvas.drawPath(this.BuiltInFictitiousFunctionClassFactory, LineChartRenderer.this.lookAheadTest);
                } else {
                    canvas.drawCircle(MyBillsEntityDataFactory, MyBillsEntityDataFactory, MyBillsEntityDataFactory, LineChartRenderer.this.lookAheadTest);
                    if (z) {
                        canvas.drawCircle(MyBillsEntityDataFactory, MyBillsEntityDataFactory, authRequestContext, LineChartRenderer.this.initRecordTimeStamp);
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [com.github.mikephil.charting.data.Entry, com.github.mikephil.charting.data.BaseEntry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public final void getAuthRequestContext(Canvas canvas) {
        DataSetImageCache dataSetImageCache;
        ?? errorConfigVersion;
        this.lookAheadTest.setStyle(Paint.Style.FILL);
        float MyBillsEntityDataFactory = this.scheduleImpl.MyBillsEntityDataFactory();
        float[] fArr = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        float f = 0.0f;
        byte b = 0;
        fArr[0] = 0.0f;
        char c = 1;
        fArr[1] = 0.0f;
        List<T> BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.getLineData().BuiltInFictitiousFunctionClassFactory();
        int i = 0;
        while (i < BuiltInFictitiousFunctionClassFactory.size()) {
            ILineDataSet iLineDataSet = (ILineDataSet) BuiltInFictitiousFunctionClassFactory.get(i);
            if (iLineDataSet.whenAvailable() && iLineDataSet.getValueOfTouchPositionAbsolute() && iLineDataSet.BottomSheetCardBindingView$watcherCardNumberView$1() != 0) {
                this.initRecordTimeStamp.setColor(iLineDataSet.PlaceComponentResult());
                Transformer transformer = this.BuiltInFictitiousFunctionClassFactory.getTransformer(iLineDataSet.scheduleImpl());
                this.getErrorConfigVersion.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, iLineDataSet);
                float MyBillsEntityDataFactory2 = iLineDataSet.MyBillsEntityDataFactory();
                float authRequestContext = iLineDataSet.getAuthRequestContext();
                boolean z = iLineDataSet.B() && authRequestContext < MyBillsEntityDataFactory2 && authRequestContext > f;
                boolean z2 = z && iLineDataSet.PlaceComponentResult() == 1122867;
                if (this.isLayoutRequested.containsKey(iLineDataSet)) {
                    dataSetImageCache = this.isLayoutRequested.get(iLineDataSet);
                } else {
                    dataSetImageCache = new DataSetImageCache(this, b);
                    this.isLayoutRequested.put(iLineDataSet, dataSetImageCache);
                }
                if (dataSetImageCache.KClassImpl$Data$declaredNonStaticMembers$2(iLineDataSet)) {
                    dataSetImageCache.KClassImpl$Data$declaredNonStaticMembers$2(iLineDataSet, z, z2);
                }
                int i2 = this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2;
                int i3 = this.getErrorConfigVersion.PlaceComponentResult;
                int i4 = this.getErrorConfigVersion.PlaceComponentResult;
                while (i4 <= i2 + i3 && (errorConfigVersion = iLineDataSet.getErrorConfigVersion(i4)) != 0) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1[b] = errorConfigVersion.MyBillsEntityDataFactory();
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1[c] = errorConfigVersion.getAuthRequestContext() * MyBillsEntityDataFactory;
                    transformer.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1[b])) {
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1[b]) && this.NetworkUserEntityData$$ExternalSyntheticLambda7.getErrorConfigVersion(this.NetworkUserEntityData$$ExternalSyntheticLambda1[c])) {
                            Bitmap[] bitmapArr = dataSetImageCache.MyBillsEntityDataFactory;
                            Bitmap bitmap = bitmapArr[i4 % bitmapArr.length];
                            if (bitmap != null) {
                                float[] fArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                canvas.drawBitmap(bitmap, fArr2[b] - MyBillsEntityDataFactory2, fArr2[c] - MyBillsEntityDataFactory2, (Paint) null);
                                i4++;
                                b = 0;
                                c = 1;
                            }
                        }
                        i4++;
                        b = 0;
                        c = 1;
                    }
                }
            }
            i++;
            f = 0.0f;
            b = 0;
            c = 1;
        }
    }
}
