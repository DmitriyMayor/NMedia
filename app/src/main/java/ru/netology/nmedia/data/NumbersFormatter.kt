package ru.netology.nmedia.data

import kotlin.math.ln
import kotlin.math.pow

class NumbersFormatter {

    fun getFormattedLikesNumber(likes: Long): String {
        if (likes < 1000) return "" + likes
        val exp = (ln(likes.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", likes / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }

    fun getFormattedSharesNumber(shares: Long): String {
        if (shares < 1000) return "" + shares
        val exp = (ln(shares.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", shares / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }

    fun getFormattedViewsNumber(views: Long): String {
        if (views < 1000) return "" + views
        val exp = (ln(views.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", views / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }

}
