package com.rd.draw.drawer;

import android.graphics.Paint;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.type.BasicDrawer;
import com.rd.draw.drawer.type.ColorDrawer;
import com.rd.draw.drawer.type.DropDrawer;
import com.rd.draw.drawer.type.FillDrawer;
import com.rd.draw.drawer.type.ScaleDownDrawer;
import com.rd.draw.drawer.type.ScaleDrawer;
import com.rd.draw.drawer.type.SlideDrawer;
import com.rd.draw.drawer.type.SwapDrawer;
import com.rd.draw.drawer.type.ThinWormDrawer;
import com.rd.draw.drawer.type.WormDrawer;

/* loaded from: classes3.dex */
public class Drawer {
    public int BuiltInFictitiousFunctionClassFactory;
    public ThinWormDrawer GetContactSyncConfig;
    public ColorDrawer KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public SlideDrawer NetworkUserEntityData$$ExternalSyntheticLambda0;
    public WormDrawer NetworkUserEntityData$$ExternalSyntheticLambda1;
    public SwapDrawer NetworkUserEntityData$$ExternalSyntheticLambda2;
    public BasicDrawer PlaceComponentResult;
    public DropDrawer getAuthRequestContext;
    public int getErrorConfigVersion;
    public ScaleDownDrawer lookAheadTest;
    public ScaleDrawer moveToNextValue;
    public FillDrawer scheduleImpl;

    public Drawer(Indicator indicator) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.PlaceComponentResult = new BasicDrawer(paint, indicator);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ColorDrawer(paint, indicator);
        this.moveToNextValue = new ScaleDrawer(paint, indicator);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new WormDrawer(paint, indicator);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SlideDrawer(paint, indicator);
        this.scheduleImpl = new FillDrawer(paint, indicator);
        this.GetContactSyncConfig = new ThinWormDrawer(paint, indicator);
        this.getAuthRequestContext = new DropDrawer(paint, indicator);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new SwapDrawer(paint, indicator);
        this.lookAheadTest = new ScaleDownDrawer(paint, indicator);
    }
}
