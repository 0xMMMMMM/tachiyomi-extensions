package eu.kanade.tachiyomi.extension.en.luminousscans

import eu.kanade.tachiyomi.multisrc.mangathemesia.MangaThemesia
import eu.kanade.tachiyomi.network.interceptor.rateLimit
import eu.kanade.tachiyomi.source.model.FilterList
import eu.kanade.tachiyomi.source.model.MangasPage
import okhttp3.OkHttpClient
import rx.Observable
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit

class LuminousScans : MangaThemesia(
    "Luminous Scans",
    "https://luminousscans.net",
    "en",
    mangaUrlDirectory = "/series",
    dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.US),
) {
    override val client: OkHttpClient = super.client.newBuilder()
        .rateLimit(2, 3, TimeUnit.SECONDS)
        .build()

    override val altNamePrefix = ""
}
