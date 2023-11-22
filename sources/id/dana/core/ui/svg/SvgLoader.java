package id.dana.core.ui.svg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class SvgLoader {
    private String BuiltInFictitiousFunctionClassFactory;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private ImageView MyBillsEntityDataFactory;
    private RequestOptions NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Context PlaceComponentResult;
    private int getAuthRequestContext;
    private Transformation<?> lookAheadTest;
    private List<RequestListener<PictureDrawable>> moveToNextValue;

    public /* synthetic */ SvgLoader(Builder builder, byte b) {
        this(builder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SvgLoader(Builder builder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.PlaceComponentResult = builder.lookAheadTest;
        this.BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory;
        this.getAuthRequestContext = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.MyBillsEntityDataFactory = builder.PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.moveToNextValue;
        this.lookAheadTest = builder.getErrorConfigVersion;
        this.moveToNextValue = builder.getAuthRequestContext;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.MyBillsEntityDataFactory;
        if (this.PlaceComponentResult == null || TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory) || this.MyBillsEntityDataFactory == null) {
            return;
        }
        GlideRequest MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(this.PlaceComponentResult).PlaceComponentResult(PictureDrawable.class).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((RequestListener) new SvgSoftwareLayerSetter(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 2 : 1)).MyBillsEntityDataFactory(Uri.parse(this.BuiltInFictitiousFunctionClassFactory));
        int i = this.getAuthRequestContext;
        if (i != 0) {
            MyBillsEntityDataFactory.MyBillsEntityDataFactory(i).BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
        }
        RequestOptions requestOptions = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (requestOptions != null) {
            MyBillsEntityDataFactory.MyBillsEntityDataFactory((BaseRequestOptions<?>) requestOptions);
        }
        Transformation<?> transformation = this.lookAheadTest;
        if (transformation != null) {
            MyBillsEntityDataFactory.MyBillsEntityDataFactory((Transformation<Bitmap>) transformation);
        }
        List<RequestListener<PictureDrawable>> list = this.moveToNextValue;
        if (list != null && !list.isEmpty()) {
            Iterator<RequestListener<PictureDrawable>> it = this.moveToNextValue.iterator();
            while (it.hasNext()) {
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(it.next());
            }
        }
        MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
    }

    public static boolean getAuthRequestContext(String str) {
        return str != null && str.contains(".svg");
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        return new Builder(context, (byte) 0);
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public String BuiltInFictitiousFunctionClassFactory;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public boolean MyBillsEntityDataFactory;
        public ImageView PlaceComponentResult;
        public List<RequestListener<PictureDrawable>> getAuthRequestContext;
        public Transformation<?> getErrorConfigVersion;
        private Context lookAheadTest;
        public RequestOptions moveToNextValue;

        /* synthetic */ Builder(Context context, byte b) {
            this(context);
        }

        private Builder(Context context) {
            this.MyBillsEntityDataFactory = false;
            this.lookAheadTest = context;
        }
    }
}
