package com.android.todo.database

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.android.todo.R
import java.lang.StringBuilder
import java.text.SimpleDateFormat

fun convertNumericProrityToString(Priority: Int, resources: Resources): String{

    var PriorityString = "OK"

    when(Priority){
        -1 -> PriorityString = "Vary Low Prority"
        0 -> PriorityString = resources.getString(R.string.zero)
        1 -> PriorityString = resources.getString(R.string.one)
        2 -> PriorityString = resources.getString(R.string.two)
        3 -> PriorityString = resources.getString(R.string.three)
        4 -> PriorityString = resources.getString(R.string.four)
    }

    return PriorityString
}
@SuppressLint("SimpleDateFormat")
fun convertLongToDateString(systemTime: Long): String{
    return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
        .format(systemTime).toString()
}

fun formatDays(days: List<TodoList>, resources: Resources): Spanned{
    val sb = StringBuilder()

    sb.apply{
        append("<h3>HERE IS YOUR TODO DATA</h3>")
        days.forEach {
            append("<br>")
            append("<b>Start: </b>")
            append("\t${convertLongToDateString(it.startTime)}<br>")
            if (it.endTime != it.startTime){
                append("<b>Finish:</b>")
                append("\t${convertLongToDateString(it.endTime)}<br>")
                append(resources.getString(R.string.priority))
                append("\t${convertNumericProrityToString(it.priority, resources)}<br>")
                append(resources.getString(R.string.time_taken))
                // Hours
                append("\t ${it.startTime.minus(it.startTime) / 1000 / 60 / 60}:")
                // Minutes
                append("${it.endTime.minus(it.endTime) / 1000 / 60}:")
                // Seconds
                append("${it.endTime.minus(it.endTime) / 1000}<br><br>")
            }
        }
    }

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    }else{
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

}