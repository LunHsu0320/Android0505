package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

//Tab+ViewPager2 標籤加滑動
class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        init()
    }

    private fun init() {
        val tab_layout = findViewById<TabLayout>(R.id.tab_layout)
        val tab_pager = findViewById<ViewPager2>(R.id.tab_pager)

        //設定 ViewPager2 資料適配器
        tab_pager.adapter = MyPagerAdapter(this)
        //連結 tab_layout 與 tab_pager
        TabLayoutMediator(tab_layout, tab_pager) { tab, position ->
            val s = "第" + position + "頁"
            tab.text = s //設定 tab標題字串
        }.attach()
        //使用 attach() 方法將 TabLayoutMediator 與 TabLayout 和 ViewPager 進行關聯，
        // 從而完成整個設置過程。
    }

    //inner class(內部類別)能使用外部類別私有成員
    //資料適配器
    inner class MyPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        //有多少項資料
        override fun getItemCount(): Int {
            return 2 //有2頁
        }

        override fun createFragment(position: Int): Fragment {
            //建立片段
            lateinit var f: Fragment
            when (position) {
                0 -> {
                    f = TabFragment1()
                }

                1 -> {
                    f = TabFragment2()
                }
            }
            return f
        }
    }//MyPagerAdapter
}//Activity

class TabFragment1 : Fragment() {
    //建立片段畫面
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflater(畫面佈局 載入器)
        return inflater.inflate(R.layout.tab_fragment1_layout, container, false)

    }
}

class TabFragment2 : Fragment() {
    //建立片段畫面
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflater(畫面佈局 載入器)
        return inflater.inflate(R.layout.tab_fragment2_layout, container, false)
    }
}