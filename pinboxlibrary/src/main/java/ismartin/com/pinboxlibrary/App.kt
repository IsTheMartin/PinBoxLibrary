package ismartin.com.pinboxlibrary

import android.app.Application

class App: Application() {
    companion object {
        var prefs: SharedPrefs? = null
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }
}