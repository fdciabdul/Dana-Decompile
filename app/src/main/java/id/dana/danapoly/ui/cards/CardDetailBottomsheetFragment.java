package id.dana.danapoly.ui.cards;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.BottomSheetCardDetailBinding;
import id.dana.danapoly.ui.enums.CardStatus;
import id.dana.danapoly.ui.enums.RewardTypeKt;
import id.dana.danapoly.ui.model.CardItemModel;
import id.dana.danapoly.ui.model.play.LocalizationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B*\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0019\u0010\u0015\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0012\u0004\u0012\u00020\t0\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR)\u0010\u0004\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0011¢\u0006\u0002\b\u0012\u0012\u0004\u0012\u00020\t0\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0013"}, d2 = {"Lid/dana/danapoly/ui/cards/CardDetailBottomsheetFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/danapoly/databinding/BottomSheetCardDetailBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "Lid/dana/danapoly/ui/model/CardItemModel;", "Lid/dana/danapoly/ui/model/CardItemModel;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function1;", "p0", "p1", "<init>", "(Lid/dana/danapoly/ui/model/CardItemModel;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardDetailBottomsheetFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetCardDetailBinding> {
    private final CardItemModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function1<? super String, Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetCardDetailBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetCardDetailBinding authRequestContext = BottomSheetCardDetailBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public CardDetailBottomsheetFragment(CardItemModel cardItemModel, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(cardItemModel, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cardItemModel;
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        Context context;
        super.getAuthRequestContext();
        Unit unit = null;
        if (Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2.getStatus(), CardStatus.EXPIRED.name())) {
            VB vb = this.MyBillsEntityDataFactory;
            if (vb != 0) {
                ((BottomSheetCardDetailBinding) vb).scheduleImpl.setText(getString(R.string.res_0x7f130755_networkuserentitydata_externalsyntheticlambda4));
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    ((BottomSheetCardDetailBinding) vb2).moveToNextValue.setText(getString(R.string.res_0x7f130754_networkuserentitydata_externalsyntheticlambda5));
                    VB vb3 = this.MyBillsEntityDataFactory;
                    if (vb3 != 0) {
                        DanaButtonPrimaryView danaButtonPrimaryView = ((BottomSheetCardDetailBinding) vb3).getAuthRequestContext;
                        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
                        danaButtonPrimaryView.setVisibility(0);
                        VB vb4 = this.MyBillsEntityDataFactory;
                        if (vb4 != 0) {
                            ((BottomSheetCardDetailBinding) vb4).getAuthRequestContext.setActiveButton(getString(R.string.res_0x7f130753_networkuserentitydata_externalsyntheticlambda3), null);
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            VB vb5 = this.MyBillsEntityDataFactory;
            if (vb5 != 0) {
                ((BottomSheetCardDetailBinding) vb5).scheduleImpl.setText(LocalizationModel.INSTANCE.localized(this.KClassImpl$Data$declaredNonStaticMembers$2.getTitle()));
                VB vb6 = this.MyBillsEntityDataFactory;
                if (vb6 != 0) {
                    ((BottomSheetCardDetailBinding) vb6).moveToNextValue.setText(LocalizationModel.INSTANCE.localized(this.KClassImpl$Data$declaredNonStaticMembers$2.getDescription()));
                    String localized = LocalizationModel.INSTANCE.localized(this.KClassImpl$Data$declaredNonStaticMembers$2.getActionTitle());
                    if (!(localized.length() > 0)) {
                        localized = null;
                    }
                    if (localized != null) {
                        VB vb7 = this.MyBillsEntityDataFactory;
                        if (vb7 != 0) {
                            DanaButtonPrimaryView danaButtonPrimaryView2 = ((BottomSheetCardDetailBinding) vb7).getAuthRequestContext;
                            Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView2, "");
                            danaButtonPrimaryView2.setVisibility(0);
                            VB vb8 = this.MyBillsEntityDataFactory;
                            if (vb8 != 0) {
                                ((BottomSheetCardDetailBinding) vb8).getAuthRequestContext.setActiveButton(localized, null);
                                unit = Unit.INSTANCE;
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                    if (unit == null) {
                        VB vb9 = this.MyBillsEntityDataFactory;
                        if (vb9 != 0) {
                            DanaButtonPrimaryView danaButtonPrimaryView3 = ((BottomSheetCardDetailBinding) vb9).getAuthRequestContext;
                            Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView3, "");
                            danaButtonPrimaryView3.setVisibility(8);
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.getCardType() != null && (context = getContext()) != null) {
            GlideRequest<Drawable> PlaceComponentResult = GlideApp.getAuthRequestContext(context).PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.getUrl()).getErrorConfigVersion(RewardTypeKt.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getCardType())).PlaceComponentResult(RewardTypeKt.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getCardType()));
            VB vb10 = this.MyBillsEntityDataFactory;
            if (vb10 != 0) {
                PlaceComponentResult.MyBillsEntityDataFactory((ImageView) ((BottomSheetCardDetailBinding) vb10).BuiltInFictitiousFunctionClassFactory);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        if (!Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2.getStatus(), CardStatus.PENDING.name())) {
            VB vb11 = this.MyBillsEntityDataFactory;
            if (vb11 != 0) {
                ShapeableImageView shapeableImageView = ((BottomSheetCardDetailBinding) vb11).BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
                ViewExtKt.MyBillsEntityDataFactory((ImageView) shapeableImageView, true);
                Context context2 = getContext();
                if (context2 != null) {
                    VB vb12 = this.MyBillsEntityDataFactory;
                    if (vb12 != 0) {
                        ((BottomSheetCardDetailBinding) vb12).BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(context2, R.color.moveToNextValue_res_0x7f0600c9));
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb13 = this.MyBillsEntityDataFactory;
        if (vb13 != 0) {
            ((BottomSheetCardDetailBinding) vb13).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.CardDetailBottomsheetFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CardDetailBottomsheetFragment.getAuthRequestContext(CardDetailBottomsheetFragment.this);
                }
            });
            VB vb14 = this.MyBillsEntityDataFactory;
            if (vb14 != 0) {
                ((BottomSheetCardDetailBinding) vb14).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.CardDetailBottomsheetFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CardDetailBottomsheetFragment.BuiltInFictitiousFunctionClassFactory(CardDetailBottomsheetFragment.this);
                    }
                });
                return;
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
            a_(PlaceComponentResult(dialog));
            BottomSheetBehavior<View> o_ = o_();
            if (o_ != null) {
                o_.setDraggable(false);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                getAuthRequestContext.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(getAuthRequestContext, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(CardDetailBottomsheetFragment cardDetailBottomsheetFragment) {
        Intrinsics.checkNotNullParameter(cardDetailBottomsheetFragment, "");
        if (!Intrinsics.areEqual(cardDetailBottomsheetFragment.KClassImpl$Data$declaredNonStaticMembers$2.getStatus(), CardStatus.EXPIRED.name())) {
            if (cardDetailBottomsheetFragment.KClassImpl$Data$declaredNonStaticMembers$2.getUrl().length() > 0) {
                cardDetailBottomsheetFragment.BuiltInFictitiousFunctionClassFactory.invoke(cardDetailBottomsheetFragment.KClassImpl$Data$declaredNonStaticMembers$2.getUrl());
            }
        }
        cardDetailBottomsheetFragment.dismiss();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CardDetailBottomsheetFragment cardDetailBottomsheetFragment) {
        Intrinsics.checkNotNullParameter(cardDetailBottomsheetFragment, "");
        cardDetailBottomsheetFragment.dismiss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetCardDetailBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
