package com.example.firstapp

import ContactListAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray

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

