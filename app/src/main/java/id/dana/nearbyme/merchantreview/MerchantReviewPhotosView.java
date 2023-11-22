package id.dana.nearbyme.merchantreview;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.extension.ContextExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantreview.adapter.MerchantReviewPhotosAdapter;
import id.dana.utils.OSUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u000234B!\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u0012\b\b\u0002\u00100\u001a\u00020\u000e¢\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\rJ\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\rJ\u0015\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\rJ\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\rR\u0016\u0010\u0017\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010(R\u0018\u0010$\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+"}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewPhotosView;", "Lid/dana/base/BaseRichView;", "Landroid/content/Intent;", "data", "", "activityForResult", "(Landroid/content/Intent;)V", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "images", "addItemFromMerchantReview", "(Ljava/util/List;)V", "checkForPermission", "()V", "", "getLayout", "()I", "", "getPhotos", "()Ljava/util/List;", "hideAddPhotos", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Intent;)Z", RequestPermission.REQUEST_CODE, "", RequestPermission.GRANT_RESULTS, "onRequestPermissionResult", "(I[I)V", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantreview/MerchantReviewPhotosView$PhotosViewInteraction;", "sentListener", "setListener", "(Lid/dana/nearbyme/merchantreview/MerchantReviewPhotosView$PhotosViewInteraction;)V", "setup", "PlaceComponentResult", "Lid/dana/nearbyme/merchantreview/adapter/MerchantReviewPhotosAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantreview/adapter/MerchantReviewPhotosAdapter;", "Lid/dana/nearbyme/merchantreview/MerchantReviewPhotosView$PhotosViewInteraction;", "Landroid/net/Uri;", "getAuthRequestContext", "Landroid/net/Uri;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "PhotosViewInteraction"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewPhotosView extends BaseRichView {
    public static final int MAX_PHOTO_COUNT = 10;
    public static final int PERMISSION_REQUEST = 1002;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private MerchantReviewPhotosAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private PhotosViewInteraction BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Uri PlaceComponentResult;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u0007\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewPhotosView$PhotosViewInteraction;", "", "", "getAuthRequestContext", "()V", "Landroid/content/Intent;", "p0", "PlaceComponentResult", "(Landroid/content/Intent;)V", "", "", "([Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface PhotosViewInteraction {
        void PlaceComponentResult(Intent p0);

        void PlaceComponentResult(String[] p0);

        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantReviewPhotosView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_merchant_review_photo;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantReviewPhotosView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantReviewPhotosView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final List<String> getPhotos() {
        MerchantReviewPhotosAdapter merchantReviewPhotosAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ArrayList arrayList = null;
        if (merchantReviewPhotosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewPhotosAdapter = null;
        }
        List<Uri> items = merchantReviewPhotosAdapter.getItems();
        if (items != null) {
            List<Uri> list = items;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Uri) it.next()).toString());
            }
            arrayList = arrayList2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    public final void setListener(PhotosViewInteraction sentListener) {
        Intrinsics.checkNotNullParameter(sentListener, "");
        this.BuiltInFictitiousFunctionClassFactory = sentListener;
    }

    public final void activityForResult(Intent data) {
        Uri data2;
        ClipData clipData;
        ArrayList arrayList = new ArrayList();
        if (KClassImpl$Data$declaredNonStaticMembers$2(data)) {
            Uri uri = this.PlaceComponentResult;
            if (uri != null) {
                arrayList.add(uri);
            }
        } else if (data != null && (clipData = data.getClipData()) != null) {
            arrayList.addAll(NearbyExtensionKt.KClassImpl$Data$declaredNonStaticMembers$2(clipData));
        } else if (data != null && (data2 = data.getData()) != null) {
            arrayList.add(data2);
        }
        MerchantReviewPhotosAdapter merchantReviewPhotosAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        MerchantReviewPhotosAdapter merchantReviewPhotosAdapter2 = null;
        if (merchantReviewPhotosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewPhotosAdapter = null;
        }
        int placeComponentResult = merchantReviewPhotosAdapter.getPlaceComponentResult();
        MerchantReviewPhotosAdapter merchantReviewPhotosAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantReviewPhotosAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantReviewPhotosAdapter2 = merchantReviewPhotosAdapter3;
        }
        merchantReviewPhotosAdapter2.appendItems(CollectionsKt.take(arrayList, 10 - placeComponentResult));
    }

    public final void onRequestPermissionResult(int r4, int[] r5) {
        Intrinsics.checkNotNullParameter(r5, "");
        if (r4 == 1002) {
            int length = r5.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                } else if (r5[i] != 0) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                MyBillsEntityDataFactory();
            }
        }
    }

    public final void addItemFromMerchantReview(List<MerchantImageModel> images) {
        Intrinsics.checkNotNullParameter(images, "");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = images.iterator();
        while (it.hasNext()) {
            Uri parse = Uri.parse(((MerchantImageModel) it.next()).BuiltInFictitiousFunctionClassFactory);
            Intrinsics.checkNotNullExpressionValue(parse, "");
            arrayList.add(parse);
        }
        MerchantReviewPhotosAdapter merchantReviewPhotosAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantReviewPhotosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewPhotosAdapter = null;
        }
        merchantReviewPhotosAdapter.appendItems(arrayList);
        if ((!arrayList.isEmpty()) == true) {
            PlaceComponentResult();
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Intent p0) {
        if (p0 == null) {
            return true;
        }
        if (p0.getAction() == null) {
            return false;
        }
        return Intrinsics.areEqual("android.media.action.IMAGE_CAPTURE", p0.getAction());
    }

    public final void checkForPermission() {
        ArrayList arrayList;
        ArrayList<String> arrayList2 = new ArrayList();
        arrayList2.add("android.permission.CAMERA");
        if (Build.VERSION.SDK_INT < 29) {
            arrayList2.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        Context context = getContext();
        PhotosViewInteraction photosViewInteraction = null;
        if (context != null) {
            arrayList = new ArrayList();
            for (String str : arrayList2) {
                if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, str) != 0) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        List list = arrayList;
        if ((!list.isEmpty()) != false && OSUtil.GetContactSyncConfig()) {
            PhotosViewInteraction photosViewInteraction2 = this.BuiltInFictitiousFunctionClassFactory;
            if (photosViewInteraction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                photosViewInteraction = photosViewInteraction2;
            }
            Object[] array = list.toArray(new String[0]);
            if (array != null) {
                photosViewInteraction.PlaceComponentResult((String[]) array);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        MyBillsEntityDataFactory();
    }

    private final void MyBillsEntityDataFactory() {
        PackageManager packageManager;
        Context context = getContext();
        PhotosViewInteraction photosViewInteraction = null;
        this.PlaceComponentResult = context != null ? ContextExtKt.MyBillsEntityDataFactory(context) : null;
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Context context2 = getContext();
        List<ResolveInfo> queryIntentActivities = (context2 == null || (packageManager = context2.getPackageManager()) == null) ? null : packageManager.queryIntentActivities(intent, 0);
        if (queryIntentActivities != null) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.packageName;
                Intent intent2 = new Intent(intent);
                intent2.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
                intent2.setPackage(str);
                intent2.putExtra(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, this.PlaceComponentResult);
                arrayList.add(intent2);
            }
        }
        Intent intent3 = new Intent();
        intent3.setType("image/*");
        intent3.setAction("android.intent.action.PICK");
        intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*"});
        intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        Intent createChooser = Intent.createChooser(intent3, getContext().getString(R.string.rating_submit_photos_intent_title));
        Object[] array = arrayList.toArray(new Intent[0]);
        if (array != null) {
            createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) array);
            PhotosViewInteraction photosViewInteraction2 = this.BuiltInFictitiousFunctionClassFactory;
            if (photosViewInteraction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                photosViewInteraction = photosViewInteraction2;
            }
            Intrinsics.checkNotNullExpressionValue(createChooser, "");
            photosViewInteraction.PlaceComponentResult(createChooser);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final void PlaceComponentResult() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0079_kclassimpl_data_declarednonstaticmembers_2)).setVisibility(8);
        ((HorizontalScrollView) _$_findCachedViewById(R.id.sv_photos)).setVisibility(0);
        CardView cardView = (CardView) _$_findCachedViewById(R.id.cv_add_photo);
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewPhotosView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantReviewPhotosView.$r8$lambda$BUpgT2OIr8MS8_e4cptT1w2C15E(MerchantReviewPhotosView.this, view);
                }
            });
        }
    }

    public final void hideAddPhotos() {
        MerchantReviewPhotosAdapter merchantReviewPhotosAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantReviewPhotosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewPhotosAdapter = null;
        }
        merchantReviewPhotosAdapter.PlaceComponentResult = true;
        CardView cardView = (CardView) _$_findCachedViewById(R.id.cv_add_photo);
        if (cardView != null) {
            cardView.setVisibility(8);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1178_platformimplementations_reflectthrowable);
        if (recyclerView != null) {
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(recyclerView, Float.valueOf(0.0f), null, null, null, 14);
        }
    }

    public static /* synthetic */ void $r8$lambda$BUpgT2OIr8MS8_e4cptT1w2C15E(MerchantReviewPhotosView merchantReviewPhotosView, View view) {
        Intrinsics.checkNotNullParameter(merchantReviewPhotosView, "");
        MerchantReviewPhotosAdapter merchantReviewPhotosAdapter = merchantReviewPhotosView.KClassImpl$Data$declaredNonStaticMembers$2;
        PhotosViewInteraction photosViewInteraction = null;
        if (merchantReviewPhotosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewPhotosAdapter = null;
        }
        if (merchantReviewPhotosAdapter.getPlaceComponentResult() < 10) {
            PhotosViewInteraction photosViewInteraction2 = merchantReviewPhotosView.BuiltInFictitiousFunctionClassFactory;
            if (photosViewInteraction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                photosViewInteraction = photosViewInteraction2;
            }
            photosViewInteraction.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void $r8$lambda$yllWn9SF37TzZh_d8vboNawoeHg(MerchantReviewPhotosView merchantReviewPhotosView, View view) {
        Intrinsics.checkNotNullParameter(merchantReviewPhotosView, "");
        MerchantReviewPhotosAdapter merchantReviewPhotosAdapter = merchantReviewPhotosView.KClassImpl$Data$declaredNonStaticMembers$2;
        PhotosViewInteraction photosViewInteraction = null;
        if (merchantReviewPhotosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewPhotosAdapter = null;
        }
        if (merchantReviewPhotosAdapter.getPlaceComponentResult() <= 0) {
            PhotosViewInteraction photosViewInteraction2 = merchantReviewPhotosView.BuiltInFictitiousFunctionClassFactory;
            if (photosViewInteraction2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                photosViewInteraction = photosViewInteraction2;
            }
            photosViewInteraction.getAuthRequestContext();
        }
        merchantReviewPhotosView.PlaceComponentResult();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        MerchantReviewPhotosAdapter merchantReviewPhotosAdapter = new MerchantReviewPhotosAdapter();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantReviewPhotosAdapter;
        merchantReviewPhotosAdapter.setItems(new ArrayList());
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1178_platformimplementations_reflectthrowable);
        if (recyclerView != null) {
            MerchantReviewPhotosAdapter merchantReviewPhotosAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (merchantReviewPhotosAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantReviewPhotosAdapter2 = null;
            }
            recyclerView.setAdapter(merchantReviewPhotosAdapter2);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        }
        ((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0079_kclassimpl_data_declarednonstaticmembers_2)).setVisibility(0);
        ((HorizontalScrollView) _$_findCachedViewById(R.id.sv_photos)).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0079_kclassimpl_data_declarednonstaticmembers_2)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewPhotosView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantReviewPhotosView.$r8$lambda$yllWn9SF37TzZh_d8vboNawoeHg(MerchantReviewPhotosView.this, view);
            }
        });
    }
}
