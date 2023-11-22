package id.dana.core.ui.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/core/ui/glide/GlideUtil;", "", "<init>", "()V", "OnCompleted"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GlideUtil {
    public static final GlideUtil INSTANCE = new GlideUtil();

    private GlideUtil() {
    }

    public static /* synthetic */ void PlaceComponentResult(Context context, String str, final Function0 function0, final Function1 function1) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function1, "");
        GlideApp.getAuthRequestContext(context).PlaceComponentResult(str).KClassImpl$Data$declaredNonStaticMembers$2(false).BuiltInFictitiousFunctionClassFactory(new RequestListener<Drawable>() { // from class: id.dana.core.ui.glide.GlideUtil$loadImageWithListener$1
            @Override // com.bumptech.glide.request.RequestListener
            public final /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return MyBillsEntityDataFactory(drawable);
            }

            @Override // com.bumptech.glide.request.RequestListener
            public final boolean onLoadFailed(GlideException p0, Object p1, Target<Drawable> p2, boolean p3) {
                function0.invoke();
                return false;
            }

            private boolean MyBillsEntityDataFactory(Drawable drawable) {
                function1.invoke(drawable);
                return true;
            }
        }).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J;\u0010\u000b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJE\u0010\u000f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/core/ui/glide/GlideUtil$OnCompleted;", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "Lcom/bumptech/glide/load/engine/GlideException;", "p0", "", "p1", "Lcom/bumptech/glide/request/target/Target;", "p2", "", "p3", "onLoadFailed", "(Lcom/bumptech/glide/load/engine/GlideException;Ljava/lang/Object;Lcom/bumptech/glide/request/target/Target;Z)Z", "Lcom/bumptech/glide/load/DataSource;", "p4", "MyBillsEntityDataFactory", "()Z", "Lkotlin/Function0;", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class OnCompleted implements RequestListener<Drawable> {
        public static final OnCompleted INSTANCE = new OnCompleted();

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public static Function0<Unit> MyBillsEntityDataFactory;

        private OnCompleted() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
            return MyBillsEntityDataFactory();
        }

        private static boolean MyBillsEntityDataFactory() {
            Function0<Unit> function0 = MyBillsEntityDataFactory;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                function0 = null;
            }
            function0.invoke();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public final boolean onLoadFailed(GlideException p0, Object p1, Target<Drawable> p2, boolean p3) {
            Function0<Unit> function0 = MyBillsEntityDataFactory;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                function0 = null;
            }
            function0.invoke();
            return false;
        }
    }
}
