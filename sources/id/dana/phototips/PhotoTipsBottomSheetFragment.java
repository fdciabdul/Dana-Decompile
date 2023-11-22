package id.dana.phototips;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.WindowManagerUtil;
import id.dana.databinding.BottomSheetPhotoTipsBinding;
import id.dana.extension.view.ViewExtKt;
import id.dana.phototips.adapter.PhotoTipsDescriptionAdapter;
import id.dana.phototips.model.PhotoTipsModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000bR\u0014\u0010\n\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u000e\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/phototips/PhotoTipsBottomSheetFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/BottomSheetPhotoTipsBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "MyBillsEntityDataFactory", "", "Ljava/lang/String;", "Lid/dana/phototips/adapter/PhotoTipsDescriptionAdapter;", "PlaceComponentResult", "Lid/dana/phototips/adapter/PhotoTipsDescriptionAdapter;", "Lid/dana/phototips/model/PhotoTipsModel;", "initRecordTimeStamp", "Lid/dana/phototips/model/PhotoTipsModel;", "p0", "p1", "<init>", "(Lid/dana/phototips/model/PhotoTipsModel;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PhotoTipsBottomSheetFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetPhotoTipsBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;
    private PhotoTipsDescriptionAdapter PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final PhotoTipsModel MyBillsEntityDataFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.5f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    public PhotoTipsBottomSheetFragment(PhotoTipsModel photoTipsModel, String str) {
        Intrinsics.checkNotNullParameter(photoTipsModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.MyBillsEntityDataFactory = photoTipsModel;
        this.getAuthRequestContext = str;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetPhotoTipsBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetPhotoTipsBinding BuiltInFictitiousFunctionClassFactory = BottomSheetPhotoTipsBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            BottomSheetPhotoTipsBinding bottomSheetPhotoTipsBinding = (BottomSheetPhotoTipsBinding) vb;
            bottomSheetPhotoTipsBinding.DatabaseTableConfigUtil.setText(this.MyBillsEntityDataFactory.lookAheadTest);
            bottomSheetPhotoTipsBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setContentDescription(getString(R.string.image_capture_bottom_sheet_img_photo_tips, this.getAuthRequestContext));
            bottomSheetPhotoTipsBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setContentDescription(getString(R.string.image_capture_bottom_sheet_desc_photo_tips, this.getAuthRequestContext));
            Context context = getContext();
            if (context != null) {
                if (this.MyBillsEntityDataFactory.MyBillsEntityDataFactory.length() > 0) {
                    AppCompatImageView appCompatImageView = bottomSheetPhotoTipsBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    boolean z = this.MyBillsEntityDataFactory.PlaceComponentResult > 0 && this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory > 0;
                    boolean z2 = this.MyBillsEntityDataFactory.PlaceComponentResult == 0 && this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory > 0;
                    if (z) {
                        appCompatImageView.setVisibility(0);
                        appCompatImageView.getLayoutParams().width = ViewExtKt.PlaceComponentResult(this.MyBillsEntityDataFactory.PlaceComponentResult);
                        appCompatImageView.getLayoutParams().height = ViewExtKt.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
                    } else if (z2) {
                        appCompatImageView.setVisibility(0);
                        appCompatImageView.getLayoutParams().width = -1;
                        appCompatImageView.getLayoutParams().height = ViewExtKt.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
                    } else {
                        appCompatImageView.setVisibility(8);
                    }
                    GlideApp.getAuthRequestContext(context).PlaceComponentResult(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.bg_rectangle_grey_frame_4_dp).PlaceComponentResult((int) R.drawable.bg_rectangle_grey_frame_4_dp).MyBillsEntityDataFactory((ImageView) appCompatImageView);
                }
            }
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                BottomSheetPhotoTipsBinding bottomSheetPhotoTipsBinding2 = (BottomSheetPhotoTipsBinding) vb2;
                bottomSheetPhotoTipsBinding2.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.phototips.PhotoTipsBottomSheetFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PhotoTipsBottomSheetFragment.PlaceComponentResult(PhotoTipsBottomSheetFragment.this);
                    }
                });
                bottomSheetPhotoTipsBinding2.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.phototips.PhotoTipsBottomSheetFragment$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PhotoTipsBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(PhotoTipsBottomSheetFragment.this);
                    }
                });
                this.PlaceComponentResult = new PhotoTipsDescriptionAdapter(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    BottomSheetPhotoTipsBinding bottomSheetPhotoTipsBinding3 = (BottomSheetPhotoTipsBinding) vb3;
                    RecyclerView recyclerView = bottomSheetPhotoTipsBinding3.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    PhotoTipsDescriptionAdapter photoTipsDescriptionAdapter = this.PlaceComponentResult;
                    if (photoTipsDescriptionAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        photoTipsDescriptionAdapter = null;
                    }
                    recyclerView.setAdapter(photoTipsDescriptionAdapter);
                    bottomSheetPhotoTipsBinding3.NetworkUserEntityData$$ExternalSyntheticLambda2.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
                    VB vb4 = this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        final BottomSheetPhotoTipsBinding bottomSheetPhotoTipsBinding4 = (BottomSheetPhotoTipsBinding) vb4;
                        bottomSheetPhotoTipsBinding4.NetworkUserEntityData$$ExternalSyntheticLambda1.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: id.dana.phototips.PhotoTipsBottomSheetFragment$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnLayoutChangeListener
                            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                                PhotoTipsBottomSheetFragment.MyBillsEntityDataFactory(PhotoTipsBottomSheetFragment.this, bottomSheetPhotoTipsBinding4, view, i6, i8);
                            }
                        });
                        VB vb5 = this.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            ((BottomSheetPhotoTipsBinding) vb5).NetworkUserEntityData$$ExternalSyntheticLambda2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.phototips.PhotoTipsBottomSheetFragment$setupBottomSheetScrollBehavior$1
                                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                                    BottomSheetBehavior o_;
                                    Intrinsics.checkNotNullParameter(p0, "");
                                    super.onScrolled(p0, p1, p2);
                                    o_ = PhotoTipsBottomSheetFragment.this.o_();
                                    if (o_ != null) {
                                        if (o_.getState() == 3) {
                                            o_.setDraggable(false);
                                        }
                                        if (PhotoTipsBottomSheetFragment.PlaceComponentResult(p0.getLayoutManager()) == 0) {
                                            o_.setDraggable(true);
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            VB vb = this.MyBillsEntityDataFactory;
            if (vb != 0) {
                int measuredHeight = ((BottomSheetPhotoTipsBinding) vb).GetContactSyncConfig.getMeasuredHeight();
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    int height = measuredHeight - ((BottomSheetPhotoTipsBinding) vb2).scheduleImpl.getHeight();
                    VB vb3 = this.MyBillsEntityDataFactory;
                    if (vb3 != 0) {
                        int height2 = height - ((BottomSheetPhotoTipsBinding) vb3).getErrorConfigVersion.getHeight();
                        int i = this.MyBillsEntityDataFactory.getAuthRequestContext;
                        final int PlaceComponentResult = PlaceComponentResult(dialog);
                        if (height2 < PlaceComponentResult && i <= PlaceComponentResult) {
                            if (height2 >= i) {
                                VB vb4 = this.MyBillsEntityDataFactory;
                                if (vb4 != 0) {
                                    int height3 = ((BottomSheetPhotoTipsBinding) vb4).scheduleImpl.getHeight() + height2;
                                    VB vb5 = this.MyBillsEntityDataFactory;
                                    if (vb5 != 0) {
                                        PlaceComponentResult = height3 + ((BottomSheetPhotoTipsBinding) vb5).getErrorConfigVersion.getHeight();
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                VB vb6 = this.MyBillsEntityDataFactory;
                                if (vb6 != 0) {
                                    int height4 = ((BottomSheetPhotoTipsBinding) vb6).scheduleImpl.getHeight() + i;
                                    VB vb7 = this.MyBillsEntityDataFactory;
                                    if (vb7 != 0) {
                                        PlaceComponentResult = height4 + ((BottomSheetPhotoTipsBinding) vb7).getErrorConfigVersion.getHeight();
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            }
                        }
                        MyBillsEntityDataFactory(dialog);
                        BottomSheetBehavior<View> o_ = o_();
                        if (o_ != null) {
                            o_.setDraggable(false);
                        }
                        BottomSheetBehavior<View> o_2 = o_();
                        if (o_2 != null) {
                            o_2.setState(3);
                        }
                        BottomSheetBehavior<View> o_3 = o_();
                        if (o_3 != null) {
                            o_3.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.phototips.PhotoTipsBottomSheetFragment$initPhotoTipsBottomSheet$1
                                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                                public final void onSlide(View p0, float p1) {
                                    Intrinsics.checkNotNullParameter(p0, "");
                                }

                                /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
                                
                                    r2 = r1.MyBillsEntityDataFactory.o_();
                                 */
                                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                */
                                public final void onStateChanged(android.view.View r2, int r3) {
                                    /*
                                        r1 = this;
                                        java.lang.String r0 = ""
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                                        r2 = 3
                                        if (r3 != r2) goto L1a
                                        id.dana.phototips.PhotoTipsBottomSheetFragment r2 = id.dana.phototips.PhotoTipsBottomSheetFragment.this
                                        com.google.android.material.bottomsheet.BottomSheetBehavior r2 = id.dana.phototips.PhotoTipsBottomSheetFragment.MyBillsEntityDataFactory(r2)
                                        if (r2 == 0) goto L1a
                                        int r0 = r2
                                        float r0 = (float) r0
                                        int r0 = id.dana.extension.view.ViewExtKt.PlaceComponentResult(r0)
                                        r2.setPeekHeight(r0)
                                    L1a:
                                        r2 = 5
                                        if (r3 != r2) goto L22
                                        id.dana.phototips.PhotoTipsBottomSheetFragment r2 = id.dana.phototips.PhotoTipsBottomSheetFragment.this
                                        r2.dismiss()
                                    L22:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: id.dana.phototips.PhotoTipsBottomSheetFragment$initPhotoTipsBottomSheet$1.onStateChanged(android.view.View, int):void");
                                }
                            });
                        }
                        if (dialog != null) {
                            dialog.findViewById(R.id.design_bottom_sheet).getLayoutParams().height = PlaceComponentResult;
                        }
                        View getAuthRequestContext = getGetAuthRequestContext();
                        if (getAuthRequestContext != null) {
                            getAuthRequestContext.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(getAuthRequestContext, this));
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/phototips/PhotoTipsBottomSheetFragment$Companion;", "", "Lid/dana/phototips/model/PhotoTipsModel;", "p0", "", "p1", "Lid/dana/phototips/PhotoTipsBottomSheetFragment;", "getAuthRequestContext", "(Lid/dana/phototips/model/PhotoTipsModel;Ljava/lang/String;)Lid/dana/phototips/PhotoTipsBottomSheetFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static PhotoTipsBottomSheetFragment getAuthRequestContext(PhotoTipsModel p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new PhotoTipsBottomSheetFragment(p0, p1);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PhotoTipsBottomSheetFragment photoTipsBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(photoTipsBottomSheetFragment, "");
        photoTipsBottomSheetFragment.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PhotoTipsBottomSheetFragment photoTipsBottomSheetFragment, BottomSheetPhotoTipsBinding bottomSheetPhotoTipsBinding, View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(photoTipsBottomSheetFragment, "");
        Intrinsics.checkNotNullParameter(bottomSheetPhotoTipsBinding, "");
        int height = view.getHeight();
        WindowManagerUtil windowManagerUtil = WindowManagerUtil.INSTANCE;
        FragmentActivity requireActivity = photoTipsBottomSheetFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        int i3 = WindowManagerUtil.PlaceComponentResult(requireActivity).y;
        if (view.getHeight() != i2 - i) {
            if (height >= i3) {
                photoTipsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0();
                return;
            } else {
                photoTipsBottomSheetFragment.scheduleImpl();
                return;
            }
        }
        if (bottomSheetPhotoTipsBinding.initRecordTimeStamp.canScrollVertically(1) || bottomSheetPhotoTipsBinding.initRecordTimeStamp.canScrollVertically(-1)) {
            photoTipsBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda0();
        } else {
            photoTipsBottomSheetFragment.scheduleImpl();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(PhotoTipsBottomSheetFragment photoTipsBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(photoTipsBottomSheetFragment, "");
        photoTipsBottomSheetFragment.dismissAllowingStateLoss();
    }

    public static final /* synthetic */ int PlaceComponentResult(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        return 0;
    }

    private final void scheduleImpl() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            BottomSheetPhotoTipsBinding bottomSheetPhotoTipsBinding = (BottomSheetPhotoTipsBinding) vb;
            NestedScrollView nestedScrollView = bottomSheetPhotoTipsBinding.initRecordTimeStamp;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
            NestedScrollView nestedScrollView2 = nestedScrollView;
            ViewGroup.LayoutParams layoutParams = nestedScrollView2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            RelativeLayout.LayoutParams layoutParams3 = layoutParams2;
            layoutParams3.width = -1;
            layoutParams3.height = -2;
            layoutParams3.removeRule(2);
            nestedScrollView2.setLayoutParams(layoutParams2);
            LinearLayoutCompat linearLayoutCompat = bottomSheetPhotoTipsBinding.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "");
            LinearLayoutCompat linearLayoutCompat2 = linearLayoutCompat;
            ViewGroup.LayoutParams layoutParams4 = linearLayoutCompat2.getLayoutParams();
            if (layoutParams4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
            RelativeLayout.LayoutParams layoutParams6 = layoutParams5;
            layoutParams6.width = -1;
            layoutParams6.height = -2;
            layoutParams6.removeRule(12);
            layoutParams6.addRule(3, R.id.nsv_content_tips);
            linearLayoutCompat2.setLayoutParams(layoutParams5);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            BottomSheetPhotoTipsBinding bottomSheetPhotoTipsBinding = (BottomSheetPhotoTipsBinding) vb;
            NestedScrollView nestedScrollView = bottomSheetPhotoTipsBinding.initRecordTimeStamp;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
            NestedScrollView nestedScrollView2 = nestedScrollView;
            ViewGroup.LayoutParams layoutParams = nestedScrollView2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            RelativeLayout.LayoutParams layoutParams3 = layoutParams2;
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            layoutParams3.addRule(2, R.id.footer);
            nestedScrollView2.setLayoutParams(layoutParams2);
            LinearLayoutCompat linearLayoutCompat = bottomSheetPhotoTipsBinding.getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "");
            LinearLayoutCompat linearLayoutCompat2 = linearLayoutCompat;
            ViewGroup.LayoutParams layoutParams4 = linearLayoutCompat2.getLayoutParams();
            if (layoutParams4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            }
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) layoutParams4;
            RelativeLayout.LayoutParams layoutParams6 = layoutParams5;
            layoutParams6.width = -1;
            layoutParams6.height = -2;
            layoutParams6.removeRule(3);
            layoutParams6.addRule(12);
            linearLayoutCompat2.setLayoutParams(layoutParams5);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            RelativeLayout relativeLayout = ((BottomSheetPhotoTipsBinding) vb).GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
            return relativeLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
