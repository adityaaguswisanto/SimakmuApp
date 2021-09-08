package com.simakmu.simakmu.data.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri

fun Activity.spreadSheet(link: String) {
    val uri = Uri.parse(link)
    startActivity(Intent(Intent.ACTION_VIEW, uri))
}