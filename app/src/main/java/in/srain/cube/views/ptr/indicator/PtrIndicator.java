package in.srain.cube.views.ptr.indicator;

import android.graphics.PointF;

/* loaded from: classes6.dex */
public class PtrIndicator {
    public static final int POS_START = 0;
    private int mHeaderHeight;
    private float mOffsetX;
    private float mOffsetY;
    protected int mOffsetToRefresh = 0;
    private PointF mPtLastMove = new PointF();
    private int mCurrentPos = 0;
    private int mLastPos = 0;
    private int mPressedPos = 0;
    private float mRatioOfHeaderHeightToRefresh = 1.2f;
    private float mResistance = 1.7f;
    private boolean mIsUnderTouch = false;
    private int mOffsetToKeepHeaderWhileLoading = -1;
    private int mRefreshCompleteY = 0;

    protected void onUpdatePos(int i, int i2) {
    }

    public boolean willOverTop(int i) {
        return i < 0;
    }

    public boolean isUnderTouch() {
        return this.mIsUnderTouch;
    }

    public float getResistance() {
        return this.mResistance;
    }

    public void setResistance(float f) {
        this.mResistance = f;
    }

    public void onRelease() {
        this.mIsUnderTouch = false;
    }

    public void onUIRefreshComplete() {
        this.mRefreshCompleteY = this.mCurrentPos;
    }

    public boolean goDownCrossFinishPosition() {
        return this.mCurrentPos >= this.mRefreshCompleteY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processOnMove(float f, float f2, float f3, float f4) {
        setOffset(f3, f4 / this.mResistance);
    }

    public void setRatioOfHeaderHeightToRefresh(float f) {
        this.mRatioOfHeaderHeightToRefresh = f;
        this.mOffsetToRefresh = (int) (this.mHeaderHeight * f);
    }

    public float getRatioOfHeaderToHeightRefresh() {
        return this.mRatioOfHeaderHeightToRefresh;
    }

    public int getOffsetToRefresh() {
        return this.mOffsetToRefresh;
    }

    public void setOffsetToRefresh(int i) {
        this.mRatioOfHeaderHeightToRefresh = (this.mHeaderHeight * 1.0f) / i;
        this.mOffsetToRefresh = i;
    }

    public void onPressDown(float f, float f2) {
        this.mIsUnderTouch = true;
        this.mPressedPos = this.mCurrentPos;
        this.mPtLastMove.set(f, f2);
    }

    public final void onMove(float f, float f2) {
        processOnMove(f, f2, f - this.mPtLastMove.x, f2 - this.mPtLastMove.y);
        this.mPtLastMove.set(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOffset(float f, float f2) {
        this.mOffsetX = f;
        this.mOffsetY = f2;
    }

    public float getOffsetX() {
        return this.mOffsetX;
    }

    public float getOffsetY() {
        return this.mOffsetY;
    }

    public int getLastPosY() {
        return this.mLastPos;
    }

    public int getCurrentPosY() {
        return this.mCurrentPos;
    }

    public final void setCurrentPos(int i) {
        int i2 = this.mCurrentPos;
        this.mLastPos = i2;
        this.mCurrentPos = i;
        onUpdatePos(i, i2);
    }

    public int getHeaderHeight() {
        return this.mHeaderHeight;
    }

    public void setHeaderHeight(int i) {
        this.mHeaderHeight = i;
        updateHeight();
    }

    protected void updateHeight() {
        this.mOffsetToRefresh = (int) (this.mRatioOfHeaderHeightToRefresh * this.mHeaderHeight);
    }

    public void convertFrom(PtrIndicator ptrIndicator) {
        this.mCurrentPos = ptrIndicator.mCurrentPos;
        this.mLastPos = ptrIndicator.mLastPos;
        this.mHeaderHeight = ptrIndicator.mHeaderHeight;
    }

    public boolean hasLeftStartPosition() {
        return this.mCurrentPos > 0;
    }

    public boolean hasJustLeftStartPosition() {
        return this.mLastPos == 0 && hasLeftStartPosition();
    }

    public boolean hasJustBackToStartPosition() {
        return this.mLastPos != 0 && isInStartPosition();
    }

    public boolean isOverOffsetToRefresh() {
        return this.mCurrentPos >= getOffsetToRefresh();
    }

    public boolean hasMovedAfterPressedDown() {
        return this.mCurrentPos != this.mPressedPos;
    }

    public boolean isInStartPosition() {
        return this.mCurrentPos == 0;
    }

    public boolean crossRefreshLineFromTopToBottom() {
        return this.mLastPos < getOffsetToRefresh() && this.mCurrentPos >= getOffsetToRefresh();
    }

    public boolean hasJustReachedHeaderHeightFromTopToBottom() {
        int i = this.mLastPos;
        int i2 = this.mHeaderHeight;
        return i < i2 && this.mCurrentPos >= i2;
    }

    public boolean isOverOffsetToKeepHeaderWhileLoading() {
        return this.mCurrentPos > getOffsetToKeepHeaderWhileLoading();
    }

    public void setOffsetToKeepHeaderWhileLoading(int i) {
        this.mOffsetToKeepHeaderWhileLoading = i;
    }

    public int getOffsetToKeepHeaderWhileLoading() {
        int i = this.mOffsetToKeepHeaderWhileLoading;
        return i < 0 ? this.mHeaderHeight : i;
    }

    public boolean isAlreadyHere(int i) {
        return this.mCurrentPos == i;
    }

    public float getLastPercent() {
        int i = this.mHeaderHeight;
        if (i == 0) {
            return 0.0f;
        }
        return (this.mLastPos * 1.0f) / i;
    }

    public float getCurrentPercent() {
        int i = this.mHeaderHeight;
        if (i == 0) {
            return 0.0f;
        }
        return (this.mCurrentPos * 1.0f) / i;
    }
}
