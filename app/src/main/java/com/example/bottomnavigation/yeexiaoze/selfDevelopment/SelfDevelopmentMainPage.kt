package com.example.bottomnavigation.yeexiaoze.selfDevelopment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomnavigation.R
import com.example.bottomnavigation.yeexiaoze.general.Validation
import com.example.bottomnavigation.yeexiaoze.database.selfDevelopment.ChapterSQLiteHelper
import com.example.bottomnavigation.databinding.SelfDevelopmentMainPageBinding
import com.example.bottomnavigation.yeexiaoze.database.selfDevelopment.SubchapterSQLiteHelper
import com.example.bottomnavigation.yeexiaoze.general.SelfDevChapterAdapter

class SelfDevelopmentMainPage : AppCompatActivity() {
    //Set binding variables
    private lateinit var binding: SelfDevelopmentMainPageBinding

    //Use validation methods
    private lateinit var validation: Validation

    //Use SQL helper
    private lateinit var sqliteHelper: ChapterSQLiteHelper

    private lateinit var chapterAdapter: SelfDevChapterAdapter
    private lateinit var chapterList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Initialization
        binding = SelfDevelopmentMainPageBinding.inflate(layoutInflater)
        validation = Validation()
        setContentView(binding.root)

        sqliteHelper = ChapterSQLiteHelper(this)
        recyclerViewInit()
    }

    private fun recyclerViewInit() {
        binding.selfDevChapter.layoutManager = LinearLayoutManager(this)
        chapterList = sqliteHelper.getAttribute("title")

        chapterAdapter = SelfDevChapterAdapter(this, chapterList)
        binding.selfDevChapter.adapter = chapterAdapter
    }
}