package com.example.firstapp

import ContactListAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.util.Locale

class ContactActivity : AppCompatActivity(), ContactListAdapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val backButton = findViewById<ImageButton>(R.id.icon_back)
        backButton.setOnClickListener {
            navigateToPage(MainActivity::class.java)
        }

        // JSON 파일 읽기
        val contactJson = assets.open("json/contact_data.json").reader().readText()

        // JSON Array 파싱
        val contactArrayJson = JSONArray(contactJson)

        val contactItemList = ArrayList<ContactItem>()

        for (index in 0 until contactArrayJson.length()) {
            val jsonObject = contactArrayJson.getJSONObject(index)

            contactItemList.add(ContactItem(jsonObject.getString("Email"), jsonObject.getString("Name"), jsonObject.getString("Organization") ,jsonObject.getString("Phone")))
        }

        val adapter = ContactListAdapter(
            contactItemList,
            LayoutInflater.from(this),
            this
        )

        adapter.onItemClickListener = this

        findViewById<RecyclerView>(R.id.ContactList).adapter = adapter

    // Search
        val searchView = findViewById<SearchView>(R.id.contact_search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText) {
                    // 이 부분에서 어댑터에게 데이터가 변경되었음을 알려줌
                    adapter.notifyDataSetChanged()
                }
                return true
            }
        })


    }

    private fun navigateToPage(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
        finish()
    }

    override fun onItemClick(contactItem: ContactItem) {
        // Handle item click, e.g., show contact details
        showContactDetails(contactItem)
    }

    private fun showContactDetails(contactItem: ContactItem) {
        val intent = Intent(this, CondetailActivity::class.java)
        intent.putExtra("name", contactItem.Name)
        intent.putExtra("organization", contactItem.Organization)
        intent.putExtra("phone", contactItem.Phone)
        intent.putExtra("email", contactItem.Email)
        startActivity(intent)
    }
}

