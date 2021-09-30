package com.example.doom

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.createBitmap
import java.util.*

class FireView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var temp: List<IntArray>
    private  val paint = Paint()
    private lateinit var bitmap: Bitmap
    private val random = Random()
    private val scale = 10

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        val scaledW = w / scale
        val scaledH = h / scale

        temp = List(scaledH) {IntArray(scaledW)}

        for (x in 0 until scaledW){
            temp[scaledH-1][x] = firePlace.size - 1
        }
        bitmap = createBitmap(scaledW, scaledH,)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for(y in 0 until temp.size - 1) {
            for(x in 0 until temp[y].size){
                val dx1 = random.nextInt(4) - 1
                val dy1 = random.nextInt(3)
                val dt1 = random.nextInt(3)

                val x1 = Math.min(temp[y].size -1, Math.max(0, x + dx1))
                val y1 = Math.min(temp.size -1, y +dy1)
                val d1 = Math.max(0, temp[y1][x1] -dt1)

                temp[y][x] = d1

            }
        }



        for(y in 0 until temp.size) {
            for(x in 0 until temp[y].size){
                val color = firePlace[temp[y][x]]
                paint.color = color
                bitmap.setPixel(x,y, color)
            }
        }


        canvas?.scale(scale.toFloat(), scale.toFloat())
        canvas?.drawBitmap(bitmap, 0f,0f, paint)

  //      for(y in 0 until temp.size) {
   //         for(x in 0 until temp[y].size){
    //            val color = firePlace[temp[y][x]]
      //          paint.color = color
      //          canvas?.drawPoint(x.toFloat(),y.toFloat(), paint  )
        //    }
       // }

        invalidate()

 }
    private companion object{

        private  val firePlace = intArrayOf(
            -0xf8f8f9,
            -0xe0f9f9,
            -0xd0f0f9,
            -0xb8f0f9,
            -0xa8e8f9,
            -0x98e0f9,
            -0x88e0f9,
            -0x70d8f9,
            -0x60d0f9,
            -0x38b8f9,
            -0x20b0f9,
            -0x20a8f9,
            -0x20a8f9,
            -0x28a0f9,
            -0x28a0f9,
            -0x28a8f9,
            -0x3090f1,
            -0x3088f1,
            -0x3080f1,
            -0x3078e9,
            -0x3878e9,
            -0x3870e9,
            -0x3868e1,
            -0x4060e1,
            -0x4060e1,
            -0x4058d9,
            -0x4058d9,
            -0x4050d1,
            -0x4850d1,
            -0x4848d1,
            -0x4848c9,
            -0x303091,
            -0x202061,
            -0x101039,
            -0x1
        )

    }

}