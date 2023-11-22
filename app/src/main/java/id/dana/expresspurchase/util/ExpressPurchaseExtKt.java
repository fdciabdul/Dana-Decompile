package id.dana.expresspurchase.util;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import id.dana.core.ui.glide.ImageAttacherFactory;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.view.ExpressPurchaseActivity;
import id.dana.utils.ImageOss;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0004\u0010\f"}, d2 = {"Landroid/content/Intent;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/content/Intent;Lid/dana/expresspurchase/model/ExpressPurchaseModel;)V", "Landroid/widget/ImageView;", "Landroid/content/Context;", "", "p1", "", "p2", "(Landroid/widget/ImageView;Landroid/content/Context;Ljava/lang/String;I)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpressPurchaseExtKt {
    public static final void MyBillsEntityDataFactory(ImageView imageView, final Context context, String str, final int i) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        ImageOss.MyBillsEntityDataFactory(str, imageView, new ImageOss.EventListener() { // from class: id.dana.expresspurchase.util.ExpressPurchaseExtKt$$ExternalSyntheticLambda0
            @Override // id.dana.utils.ImageOss.EventListener
            public final void PlaceComponentResult(String str2, ImageView imageView2) {
                ExpressPurchaseExtKt.MyBillsEntityDataFactory(context, i, str2, imageView2);
            }
        });
    }

    public static final void MyBillsEntityDataFactory(Intent intent, ExpressPurchaseModel expressPurchaseModel) {
        Intrinsics.checkNotNullParameter(intent, "");
        Intrinsics.checkNotNullParameter(expressPurchaseModel, "");
        if (expressPurchaseModel instanceof ExpressPurchaseModel.Gold) {
            intent.putExtra(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD, expressPurchaseModel);
        } else if (expressPurchaseModel instanceof ExpressPurchaseModel.Insurance) {
            intent.putExtra(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD, expressPurchaseModel);
        } else if (expressPurchaseModel instanceof ExpressPurchaseModel.Paylater) {
            intent.putExtra(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD, expressPurchaseModel);
        } else if (!(expressPurchaseModel instanceof ExpressPurchaseModel.Deals)) {
            throw new NoWhenBranchMatchedException();
        } else {
            intent.putExtra(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD, expressPurchaseModel);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Context context, int i, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "");
        new ImageAttacherFactory().KClassImpl$Data$declaredNonStaticMembers$2(context, imageView, str, i);
    }
}
