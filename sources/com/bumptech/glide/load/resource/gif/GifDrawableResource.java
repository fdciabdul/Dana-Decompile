package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes3.dex */
public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<GifDrawable> KClassImpl$Data$declaredNonStaticMembers$2() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int MyBillsEntityDataFactory() {
        GifFrameLoader gifFrameLoader = ((GifDrawable) this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        return gifFrameLoader.moveToNextValue.MyBillsEntityDataFactory() + gifFrameLoader.MyBillsEntityDataFactory;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final void lookAheadTest() {
        ((GifDrawable) this.BuiltInFictitiousFunctionClassFactory).stop();
        GifDrawable gifDrawable = (GifDrawable) this.BuiltInFictitiousFunctionClassFactory;
        gifDrawable.MyBillsEntityDataFactory = true;
        GifFrameLoader gifFrameLoader = gifDrawable.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        gifFrameLoader.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        Bitmap bitmap = gifFrameLoader.PlaceComponentResult;
        if (bitmap != null) {
            gifFrameLoader.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(bitmap);
            gifFrameLoader.PlaceComponentResult = null;
        }
        gifFrameLoader.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        GifFrameLoader.DelayTarget delayTarget = gifFrameLoader.getAuthRequestContext;
        if (delayTarget != null) {
            gifFrameLoader.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext((Target<?>) delayTarget);
            gifFrameLoader.getAuthRequestContext = null;
        }
        GifFrameLoader.DelayTarget delayTarget2 = gifFrameLoader.lookAheadTest;
        if (delayTarget2 != null) {
            gifFrameLoader.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext((Target<?>) delayTarget2);
            gifFrameLoader.lookAheadTest = null;
        }
        GifFrameLoader.DelayTarget delayTarget3 = gifFrameLoader.initRecordTimeStamp;
        if (delayTarget3 != null) {
            gifFrameLoader.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext((Target<?>) delayTarget3);
            gifFrameLoader.initRecordTimeStamp = null;
        }
        gifFrameLoader.moveToNextValue.PlaceComponentResult();
        gifFrameLoader.getErrorConfigVersion = true;
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public final void BuiltInFictitiousFunctionClassFactory() {
        ((GifDrawable) this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.PlaceComponentResult.prepareToDraw();
    }
}
