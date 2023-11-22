package id.dana.explore.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.explore.model.ExploreProductWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/explore/adapter/viewholder/ExploreProductViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/explore/model/ExploreProductWrapper;", "p0", "", "PlaceComponentResult", "(Lid/dana/explore/model/ExploreProductWrapper;)V", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreProductViewHolder extends BaseRecyclerViewHolder<ExploreProductWrapper> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static boolean BuiltInFictitiousFunctionClassFactory = false;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static int MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult;
    private static boolean getAuthRequestContext;

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    static {
        getAuthRequestContext();
        ?? r1 = 0;
        INSTANCE = new Companion(r1);
        int i = MyBillsEntityDataFactory + 119;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        int length = r1.length;
    }

    private static void BuiltInFictitiousFunctionClassFactory(AppCompatImageView appCompatImageView) {
        int i = MyBillsEntityDataFactory + 49;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        if ((appCompatImageView instanceof ImageView ? (char) 24 : '-') != 24) {
            appCompatImageView.setImageResource(R.drawable.bg_circle_grey_30);
            return;
        }
        InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.bg_circle_grey_30);
        int i3 = MyBillsEntityDataFactory + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 28 : 'E') != 28) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    static void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{39851, 39865, 39850, 39846, 39861, 39867, 39871, 39857, 39855, 39866, 39856, 39860, 39869, 39863};
        getAuthRequestContext = true;
        BuiltInFictitiousFunctionClassFactory = true;
        PlaceComponentResult = 909155100;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ExploreProductWrapper exploreProductWrapper) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        PlaceComponentResult(exploreProductWrapper);
        int i3 = MyBillsEntityDataFactory + 29;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        int i4 = 96 / 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreProductViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_explore_product, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
    
        if (r3 != (-1872079272)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if ((r3 == -1872079272) != true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        if (r3 == 359536993) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0071, code lost:
    
        if (r3 != 930525159) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007b, code lost:
    
        if (r2.equals(id.dana.mybills.ui.constant.MyBillsServiceKey.ELECTRICITY) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
    
        r2 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        r2 = '%';
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0082, code lost:
    
        if (r2 == '%') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
    
        r2 = id.dana.explore.adapter.viewholder.ExploreProductViewHolder.MyBillsEntityDataFactory + 101;
        id.dana.explore.adapter.viewholder.ExploreProductViewHolder.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2 % 128;
        r2 = r2 % 2;
        r2 = r9.KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig;
        r3 = id.dana.explore.adapter.viewholder.ExploreProductViewHolder.MyBillsEntityDataFactory + 107;
        id.dana.explore.adapter.viewholder.ExploreProductViewHolder.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a3, code lost:
    
        if (r2.equals(id.dana.mybills.ui.constant.MyBillsServiceKey.BPJS) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ae, code lost:
    
        if (r2.equals("service_telkom") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b0, code lost:
    
        r2 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b3, code lost:
    
        r2 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b5, code lost:
    
        if (r2 == '0') goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b7, code lost:
    
        r2 = r0.getCustomerName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c3, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r2)) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c5, code lost:
    
        r2 = id.dana.explore.adapter.viewholder.ExploreProductViewHolder.MyBillsEntityDataFactory + 63;
        id.dana.explore.adapter.viewholder.ExploreProductViewHolder.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2 % 128;
        r2 = r2 % 2;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d0, code lost:
    
        if (r2 != null) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void PlaceComponentResult(id.dana.explore.model.ExploreProductWrapper r9) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.adapter.viewholder.ExploreProductViewHolder.PlaceComponentResult(id.dana.explore.model.ExploreProductWrapper):void");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        boolean z;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 9;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String str = p0;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            z = false;
        }
        if (!z) {
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(p0).getErrorConfigVersion((int) R.drawable.bg_circle_grey_30).PlaceComponentResult((int) R.drawable.bg_circle_grey_30).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.iv_product_thumbnail)));
            return;
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.iv_product_thumbnail);
        if (!(appCompatImageView == null)) {
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
            MyBillsEntityDataFactory = i5 % 128;
            if (!(i5 % 2 != 0)) {
                BuiltInFictitiousFunctionClassFactory(appCompatImageView);
                return;
            }
            BuiltInFictitiousFunctionClassFactory(appCompatImageView);
            int i6 = 49 / 0;
        }
    }

    private final void PlaceComponentResult(String p0) {
        try {
            try {
                AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.tv_product_detail);
                int i = 0;
                if (appCompatTextView == null) {
                    return;
                }
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
                MyBillsEntityDataFactory = i2 % 128;
                int i3 = i2 % 2;
                String str = p0;
                appCompatTextView.setText(str);
                AppCompatTextView appCompatTextView2 = appCompatTextView;
                if (((str == null || StringsKt.isBlank(str)) ^ true ? (char) 22 : ',') != 22) {
                    i = 8;
                    int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 29;
                    MyBillsEntityDataFactory = i4 % 128;
                    int i5 = i4 % 2;
                } else {
                    int i6 = MyBillsEntityDataFactory + 109;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
                    if (i6 % 2 == 0) {
                    }
                }
                appCompatTextView2.setVisibility(i);
                int i7 = MyBillsEntityDataFactory + 43;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i7 % 128;
                int i8 = i7 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0229, code lost:
    
        if (r9 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0236, code lost:
    
        if (r9 != null) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0238, code lost:
    
        r9.setContentDescription(r0.getContext().getString(id.dana.R.string.icon_water));
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0183, code lost:
    
        if (r9 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0190, code lost:
    
        if (r9 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0192, code lost:
    
        r9.setContentDescription(r0.getContext().getString(id.dana.R.string.icon_emas));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.adapter.viewholder.ExploreProductViewHolder.MyBillsEntityDataFactory(java.lang.String):void");
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        char[] cArr2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = KClassImpl$Data$declaredNonStaticMembers$2;
        if ((cArr3 != null ? '5' : '6') != '6') {
            int length = cArr3.length;
            char[] cArr4 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr4[i3] = (char) (cArr3[i3] ^ 4571606982258105150L);
            }
            cArr3 = cArr4;
        }
        int i4 = (int) (PlaceComponentResult ^ 4571606982258105150L);
        try {
            if (BuiltInFictitiousFunctionClassFactory) {
                int i5 = $11 + 83;
                $10 = i5 % 128;
                if ((i5 % 2 != 0 ? '\b' : (char) 7) != 7) {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                    cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                } else {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                    cArr2 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                }
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr2[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    int i6 = $10 + 113;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                }
                objArr[0] = new String(cArr2);
            } else if (getAuthRequestContext) {
                int i8 = $10 + 3;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
            } else {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i10 = $10 + 113;
                    $11 = i10 % 128;
                    if ((i10 % 2 == 0 ? (char) 27 : 'M') != 27) {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult << 0) + bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] >> i] + i4);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory * 0;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
                objArr[0] = new String(cArr6);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
