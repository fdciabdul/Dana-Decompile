package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class BottomSheetAddAssetBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    private final FrameLayout DatabaseTableConfigUtil;
    public final AppCompatTextView GetContactSyncConfig;
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;
    public final RecyclerView MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final FrameLayout PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;
    public final RecyclerView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private BottomSheetAddAssetBinding(FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, RecyclerView recyclerView5, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5) {
        this.DatabaseTableConfigUtil = frameLayout;
        this.PlaceComponentResult = frameLayout2;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.MyBillsEntityDataFactory = recyclerView2;
        this.getAuthRequestContext = recyclerView3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView4;
        this.getErrorConfigVersion = recyclerView5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView;
        this.lookAheadTest = appCompatTextView;
        this.scheduleImpl = appCompatTextView2;
        this.moveToNextValue = appCompatTextView3;
        this.GetContactSyncConfig = appCompatTextView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = appCompatTextView5;
    }

    public static BottomSheetAddAssetBinding getAuthRequestContext(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.rv_add_fifth_section;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_add_fifth_section);
        if (recyclerView != null) {
            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_add_first_section);
            if (recyclerView2 != null) {
                RecyclerView recyclerView3 = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_add_fourth_section);
                if (recyclerView3 != null) {
                    RecyclerView recyclerView4 = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_add_second_section);
                    if (recyclerView4 != null) {
                        RecyclerView recyclerView5 = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_add_third_section);
                        if (recyclerView5 != null) {
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tab_icon);
                            if (appCompatImageView != null) {
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_fifth_section);
                                if (appCompatTextView != null) {
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_first_section);
                                    if (appCompatTextView2 != null) {
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_fourth_section);
                                        if (appCompatTextView3 != null) {
                                            AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_second_section);
                                            if (appCompatTextView4 != null) {
                                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_title_third_section);
                                                if (appCompatTextView5 != null) {
                                                    return new BottomSheetAddAssetBinding(frameLayout, frameLayout, recyclerView, recyclerView2, recyclerView3, recyclerView4, recyclerView5, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5);
                                                }
                                                i = R.id.tv_title_third_section;
                                            } else {
                                                i = R.id.tv_title_second_section;
                                            }
                                        } else {
                                            i = R.id.tv_title_fourth_section;
                                        }
                                    } else {
                                        i = R.id.tv_title_first_section;
                                    }
                                } else {
                                    i = R.id.tv_title_fifth_section;
                                }
                            } else {
                                i = R.id.tab_icon;
                            }
                        } else {
                            i = R.id.rv_add_third_section;
                        }
                    } else {
                        i = R.id.rv_add_second_section;
                    }
                } else {
                    i = R.id.rv_add_fourth_section;
                }
            } else {
                i = R.id.rv_add_first_section;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.DatabaseTableConfigUtil;
    }
}
