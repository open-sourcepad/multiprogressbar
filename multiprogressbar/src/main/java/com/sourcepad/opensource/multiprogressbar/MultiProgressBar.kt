package com.sourcepad.opensource.multiprogressbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.sourcepad.core.multiprogressbar.R
import kotlin.math.min

/**
 * Created by jecsan
 */
class MultiProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var progress1Max = 100f
    var progress2Max = 100f
    var progress3Max = 100f

    private var color1 = ContextCompat.getColor(context,
        R.color.progress_color_1
    )
    private var color2 = ContextCompat.getColor(context,
        R.color.progress_color_2
    )
    private var color3 = ContextCompat.getColor(context,
        R.color.progress_color_3
    )

    private val paint: Paint = Paint()

    private var progress1 = 0f
    private var progress2 = 0f
    private var progress3 = 0f

    private var centerY: Float = 0f
    private var centerX: Float = 0f

    private var radius: Float = 0f
    private val progressBgAlpha = 60

    private var startAngle = 270f

    private var barWidth: Float =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, resources.displayMetrics)
    private val rectF = RectF()


    init {

        context.theme.obtainStyledAttributes(attrs,
            R.styleable.MultiProgressBar, 0, 0).apply {
            try {
                color1 = ContextCompat.getColor(
                    context,
                    getResourceId(
                        R.styleable.MultiProgressBar_progress1Color,
                        R.color.progress_color_1
                    )
                )
                color2 = ContextCompat.getColor(
                    context,
                    getResourceId(
                        R.styleable.MultiProgressBar_progress2Color,
                        R.color.progress_color_2
                    )
                )
                color3 = ContextCompat.getColor(
                    context,
                    getResourceId(
                        R.styleable.MultiProgressBar_progress3Color,
                        R.color.progress_color_3
                    )
                )

                barWidth = getDimension(R.styleable.MultiProgressBar_progressWidth, barWidth)


            } finally {
                recycle()
            }
        }
    }


    private fun getColor(@ColorRes color: Int): Int {
        return ContextCompat.getColor(context, color)
    }

    fun setMaxProgress(
        maxProgress1: Float = 100f,
        maxProgress2: Float = 100f,
        maxProgress3: Float = 100f
    ) {
        this.progress1Max = maxProgress1
        this.progress2Max = maxProgress2
        this.progress3Max = maxProgress3
    }

    fun setProgressbarWidth(width: Float){
        this.barWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, resources.displayMetrics)
        invalidate()
    }

    fun setColor(@ColorRes color1: Int = R.color.progress_color_1, @ColorRes color2: Int = R.color.progress_color_2, @ColorRes color3: Int = R.color.progress_color_3) {
        this.color1 = getColor(color1)
        this.color2 = getColor(color2)
        this.color3 = getColor(color3)
        invalidate()

    }

    fun setProgress(progress1: Float = -1f, progress2: Float = -1f, progress3: Float = -1f) {
        if (progress1 > -1f) this.progress1 = progress1
        if (progress2 > -1f) this.progress2 = progress2
        if (progress3 > -1f) this.progress3 = progress3
        ensureProgressToMax()
        invalidate()
    }


    private fun ensureProgressToMax() {
        if (progress1 > progress1Max) progress1 = progress1Max
        if (progress2 > progress2Max) progress2 = progress2Max
        if (progress3 > progress3Max) progress3 = progress3Max
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        val viewHeight = MeasureSpec.getSize(heightMeasureSpec)

        radius = (min(viewWidth, viewHeight) - barWidth) / 2f

        centerX = viewWidth / 2f
        centerY = viewHeight / 2f

    }


    private fun reduceRect(r: Float) {

        rectF.set(
            centerX - r,
            centerY - r,
            centerX + r,
            centerY + r
        )

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = Color.DKGRAY
        paint.strokeWidth = barWidth
        paint.strokeCap = Paint.Cap.ROUND
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true

        val progress1Sweep = progress1 * 360 / progress1Max
        val progress2Sweep = progress2 * 360 / progress2Max
        val progress3Sweep = progress3 * 360 / progress3Max


        //Draw 1st ring
        var r = this.radius
        paint.color = color1
        reduceRect(r)
        canvas.drawArc(rectF, startAngle, progress1Sweep, false, paint)
        paint.alpha = progressBgAlpha
        reduceRect(r)
        canvas.drawArc(rectF, startAngle, 360f, false, paint)

        //Draw 2nd ring
        r -= barWidth
        paint.color = color2
        reduceRect(r)
        canvas.drawArc(rectF, startAngle, progress2Sweep, false, paint)
        paint.alpha = progressBgAlpha
        reduceRect(r)
        canvas.drawArc(rectF, startAngle, 360f, false, paint)

        //Draw 3rd ring
        r -= barWidth
        paint.color = color3
        reduceRect(r)
        canvas.drawArc(rectF, startAngle, progress3Sweep, false, paint)
        paint.alpha = progressBgAlpha
        reduceRect(r)
        canvas.drawArc(rectF, startAngle, 360f, false, paint)

    }

}