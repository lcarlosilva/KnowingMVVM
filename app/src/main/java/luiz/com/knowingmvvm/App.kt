package luiz.com.knowingmvvm


import androidx.multidex.MultiDexApplication
import luiz.com.knowingmvvm.di.inject

class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        inject()
    }
}
